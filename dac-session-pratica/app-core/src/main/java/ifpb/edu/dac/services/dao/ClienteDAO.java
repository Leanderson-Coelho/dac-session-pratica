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
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.sql.DataSource;

@Stateless
public class ClienteDAO implements InterfaceDAO {

    @Resource(name = "java:app/jdbc/dac-session")
    private DataSource dataSource;
    private Connection connection;
    
    @PostConstruct
    public void init() {
        try {
            this.connection = this.dataSource.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
    
    /* Persiste o cliente no Banco */
    @Override
    public void salvarCliente(Cliente cliente) {
       String sql = "INSERT INTO Cliente (cpf, nome) VALUES(?,?) ";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,cliente.getCpf());
            statement.setString(2,cliente.getNome());
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE,null,ex);
        }
    }

    /* Listar todos os clientes do Banco */
    @Override
    public List<Cliente> listarTodos() {
        try {
            List<Cliente> lista = new ArrayList<>();
            ResultSet result = connection
                .prepareStatement("SELECT * FROM Cliente")
                .executeQuery();
            while (result.next()) {
                lista.add(criarCliente(result));
            }
            return lista;
        } catch (SQLException ex) {
            return Collections.EMPTY_LIST;
        }
    }

    /* Criar o objeto Cliente a partir de um Result Set */
    @Override
    public Cliente criarCliente(ResultSet result) {
        try {
            String nome = result.getString("nome");
            String cpf = result.getString("cpf");
            int id = result.getInt("id");
            return new Cliente(id,cpf,nome);
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
  
}
