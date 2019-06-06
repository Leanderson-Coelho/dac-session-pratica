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
    public void adicionar(Venda venda) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void remover(Venda venda) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Venda> listar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Venda buscar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
	
}
