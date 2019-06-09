package ifpb.edu.dac.services.dao;

import java.sql.SQLException;
import java.util.List;

import ifpb.edu.dac.domain.Produto;
import ifpb.edu.dac.domain.Venda;

public interface VendaDAO {
	public void nova(Venda venda) throws SQLException;
	public List<Produto> listarProdutos(Venda venda) throws SQLException;
}
