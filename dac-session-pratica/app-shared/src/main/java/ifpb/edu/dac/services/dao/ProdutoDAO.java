package ifpb.edu.dac.services.dao;

import java.sql.SQLException;
import java.util.List;

import ifpb.edu.dac.domain.Produto;

public interface ProdutoDAO {
	public void novo(Produto produto) throws SQLException;
	public List<Produto> listar() throws SQLException;
	public List<Produto> buscarPorDescricao(String descricao) throws SQLException;
	public void atualizar(Produto produto) throws SQLException;
	public void remover(Produto produto) throws SQLException;
}
