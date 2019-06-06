/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifpb.edu.dac.services.dao;

import ifpb.edu.dac.domain.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.sql.DataSource;

@Stateless
@Remote(value = ClienteDAO.class)
public class ClienteDAOImpl implements ClienteDAO {

	@Resource(name = "java:app/jdbc/dac-session")
	private DataSource dataSource;
	private Connection connection;

	@PostConstruct
	public void init() {
		try {
			this.connection = this.dataSource.getConnection();
		} catch (SQLException ex) {
			Logger.getLogger(ClienteDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	/* Persiste o cliente no Banco */
	@Override
	public void salvarCliente(Cliente cliente) throws SQLException {
		String sql = "INSERT INTO Cliente (cpf, nome) VALUES(?,?) ";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, cliente.getCpf());
		statement.setString(2, cliente.getNome());
		statement.executeUpdate();
	}

	/* Listar todos os clientes do Banco */
	@Override
	public List<Cliente> listarTodos() throws SQLException {
		List<Cliente> lista = new ArrayList<>();
		ResultSet result = connection.prepareStatement("SELECT * FROM Cliente").executeQuery();
		while (result.next()) {
			lista.add(criarCliente(result));
		}
		return lista;
	}

	/* Pesquisar cliente por CPF no Banco */
	@Override
	public Cliente pesquisarPorCPF(String cpf) throws SQLException {
		String sql = "SELECT * FROM Cliente WHERE cpf = " + cpf;
		ResultSet result = connection.prepareStatement(sql).executeQuery();
		return criarCliente(result);
	}

	/* Criar o objeto Cliente a partir de um Result Set */
	@Override
	public Cliente criarCliente(ResultSet result) throws SQLException {
		String nome = result.getString("nome");
		String cpf = result.getString("cpf");
		int id = result.getInt("id");
		return new Cliente(id, cpf, nome);
	}

	@Override
	public void removerCliente(Cliente cliente) throws SQLException {
		String sql = "delete from cliente where cpf=?";
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setString(1, cliente.getCpf());
		ps.executeUpdate();
	}

	@Override
	public void atualizarCliente(Cliente cliente) throws SQLException {
		String sql = "update cliente set nome=?, cpf=? where id=?";
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setString(1, cliente.getNome());
		ps.setString(2, cliente.getCpf());
		ps.setInt(3, cliente.getId());
		ps.executeUpdate();
	}
	
	
}
