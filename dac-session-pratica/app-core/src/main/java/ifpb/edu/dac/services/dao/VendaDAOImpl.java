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
import ifpb.edu.dac.domain.Venda;

@Stateless
@Remote(VendaDAO.class)
public class VendaDAOImpl implements VendaDAO{
	
	@Resource(name = "java:app/jdbc/dac-session")
	private DataSource dataSource;
	private Connection connection;
	public VendaDAOImpl() throws SQLException {
		
			this.connection = this.dataSource.getConnection();
		
	}
	
	@Override
	public void nova(Venda venda) throws SQLException {
		String sql1 = "insert into Venda(id_cliente) values (?)";
		String sql2 = "insert into ProdutoVenda(id_produto, id_venda) values (?, ?)";
		PreparedStatement ps = connection.prepareStatement(sql1);
		ps.setInt(1, venda.getCliente().getId());
		ps.executeUpdate();
		List<Produto> produtos = venda.getProdutos();
		int idVenda = venda.getId();
		for(Produto p:produtos) {
			ps = connection.prepareStatement(sql2);
			ps.setInt(1, p.getId());
			ps.setInt(2, idVenda);
			ps.executeUpdate();
		}

	}

	@Override
	public List<Produto> listarProdutos(Venda venda) throws SQLException {
		List<Produto> produtos = new ArrayList<>();
		String sql = "select p.id_produto, p.descricao, p.valor from ProdutoVenda pv, produto p where pv.id_venda=?";
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setInt(1, venda.getId());
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			produtos.add(new Produto(rs.getInt(1), rs.getString(2), rs.getBigDecimal(3)));
		}
		return produtos;
	}

    
	
}
