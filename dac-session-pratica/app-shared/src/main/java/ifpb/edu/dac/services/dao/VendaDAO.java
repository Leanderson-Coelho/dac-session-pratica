package ifpb.edu.dac.services.dao;

import java.sql.SQLException;
import java.util.List;

import ifpb.edu.dac.domain.Produto;
import ifpb.edu.dac.domain.Venda;

public interface VendaDAO {
	public void adicionar(Venda venda);
	public void remover(Venda venda);
	public List<Venda> listar();
	public Venda buscar(int id);
}
