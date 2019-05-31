package ifpb.edu.dac.services.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.sql.DataSource;

import ifpb.edu.dac.domain.Produto;

@Stateless
@Remote(value = ProdutoDAO.class)
public class ProdutoDAOImpl implements ProdutoDAO{
	
	@Resource(name = "java:app/jdbc/dac-session")
	private DataSource dataSource;
	private Connection connection;
	
	public ProdutoDAOImpl() {
		try {
			this.connection = this.dataSource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void novo(Produto produto) throws SQLException {
		String sql = "insert into produto (descricao, valor) values (?,?)";
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setString(1, produto.getDescricao());
		ps.setBigDecimal(2, produto.getValor());
		ps.executeUpdate();
	}

	@Override
	public List<Produto> listar() throws SQLException {
		List<Produto> produtos = new ArrayList<>();
		String sql = "select * from produto";
		PreparedStatement ps = connection.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			produtos.add(new Produto(rs.getInt(1), rs.getString(2), rs.getBigDecimal(3)));
		}
		return produtos;
	}

	@Override
	public void atualizar(Produto produto) throws SQLException {
		String sql = "update produto set descricao=?, valor=? where=?";
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setString(1, produto.getDescricao());
		ps.setBigDecimal(2, produto.getValor());
		ps.setInt(3, produto.getId());
		ps.executeUpdate();
	}

	@Override
	public void remover(Produto produto) throws SQLException {
		String sql = "delete from produto where id = ?";
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setInt(1, produto.getId());
		ps.executeUpdate();
	}

	@Override
	public List<Produto> buscarPorDescricao(String descricao) throws SQLException {
		List<Produto> produtos = new ArrayList<>();
		String sql = "select * from produto where descricao ilike ?%";
		PreparedStatement ps = connection.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			produtos.add(new Produto(rs.getInt(1), rs.getString(2), rs.getBigDecimal(3)));
		}
		return produtos;
	}

}
