package ifpb.edu.dac.services.dao;

import java.sql.SQLException;
import java.util.List;

import ifpb.edu.dac.domain.Produto;

public interface ProdutoDAO {
	void novo(Produto produto) throws SQLException;
	List<Produto> listar() throws SQLException;
	List<Produto> buscarPorDescricao(String descricao) throws SQLException;
	void atualizar(Produto produto) throws SQLException;
	void remover(Produto produto) throws SQLException;
}
