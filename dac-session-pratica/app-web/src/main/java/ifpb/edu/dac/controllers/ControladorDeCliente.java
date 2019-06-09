/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifpb.edu.dac.controllers;

import ifpb.edu.dac.domain.Cliente;
import ifpb.edu.dac.services.dao.ClienteDAO;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Raul Coelho
 */


@RequestScoped
@Named
public class ControladorDeCliente implements Serializable {

	private String cpf;
    private Cliente cliente;
    private List<Cliente> clientes = new ArrayList<>();
    @EJB
    private ClienteDAO clienteDAO;


    public List<Cliente> getTodosOsClientes(){
    	try {
			clientes = clienteDAO.listarTodos();
		} catch (SQLException e) {
			e.printStackTrace();
		}
        return clientes;
    }

    public String adicionar(){
    	try {
			clienteDAO.salvarCliente(cliente);
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	cliente = new Cliente();
        return null;
    }

    public String removerCliente (Cliente cliente){
    	try {
			clienteDAO.removerCliente(cliente);
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	return null;
    }

    public String atualizarCliente(Cliente cliente){
    	try {
			clienteDAO.atualizarCliente(cliente);
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	return "cliente/list.xhtml";
    }

    public String pesquisarPorCPF(String cpf){
    	try {
			cliente = clienteDAO.pesquisarPorCPF(cpf);
		} catch (SQLException e) {
			e.printStackTrace();
		}
        return "cliente/edit.xhtml";
    }
    
    public String atribuir(Cliente cliente) {
    	this.cliente = cliente;
    	return null;
    }


	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}
}