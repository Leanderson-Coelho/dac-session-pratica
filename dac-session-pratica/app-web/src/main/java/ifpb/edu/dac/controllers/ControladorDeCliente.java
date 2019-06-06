/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifpb.edu.dac.controllers;

import ifpb.edu.dac.domain.Cliente;
import ifpb.edu.dac.services.dao.ClienteDAO;
import javax.ejb.EJB;
import javax.faces.bean.RequestScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;


/**
 *
 * @author Raul Coelho
 */


@RequestScoped
@Named
public class ControladorDeCliente implements Serializable {

    private Cliente cliente;

    @EJB
    private ClienteDAO clienteDAO;


    public List<Cliente> getTodosOsClientes() throws SQLException {
        return clienteDAO.listarTodos();
    }

    public String adicionar() throws SQLException {
        this.getTodosOsClientes().add(cliente);
        return null;
    }

    public String removerCliente (Cliente cliente) throws SQLException {
        this.clienteDAO.removerCliente(cliente);
        return null;
    }

    public String atualizarCliente(Cliente cliente) throws SQLException {
        this.clienteDAO.atualizarCliente(cliente);
        return "cliente/list.xhtml";
    }

    public String pesquisarPorCPF(String cpf) throws SQLException {
        this.clienteDAO.pesquisarPorCPF(cpf);
        return "cliente/edit.xhtml";
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}