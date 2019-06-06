/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifpb.edu.dac.controllers;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.inject.Named;

import ifpb.edu.dac.domain.Cliente;
import ifpb.edu.dac.domain.Produto;
import ifpb.edu.dac.services.dao.ClienteDAO;

/**
 *
 * @author ericl
 */
@Named
public class ClienteBean {
    private String cpf;
    private Cliente cliente;
    private List<Cliente> clientes = new ArrayList<>();
    @EJB
    private ClienteDAO service;

    public List<Cliente> listarClientes(){
        try {
			return service.listarTodos();
		} catch (SQLException e) {
			e.printStackTrace();
		}
        return null;
    }
    
    public String buscarPorCpf(String cpf){
        try {
			cliente = service.pesquisarPorCPF(cpf);
		} catch (SQLException e) {
			e.printStackTrace();
		}
        return "cliente/edit.xhtml";
    }
    
    public String novo() {
    	try {
			service.salvarCliente(cliente);
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	cliente = null;
    	return "cliente/list.xhtml";
    }
    
    public String remover() {
    	try {
			service.removerCliente(cliente);
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	return null;
    }
    
    public String atualizar() {
    	try {
			service.atualizarCliente(cliente);
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	return "cliente/list.xhtml";
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
