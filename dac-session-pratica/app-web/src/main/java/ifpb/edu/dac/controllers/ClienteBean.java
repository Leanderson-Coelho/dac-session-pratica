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

    public void listarClientes(){
        try {
			clientes = service.listarTodos();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
    
    public void buscarPorCpf(String cpf){
        try {
			cliente = service.pesquisarPorCPF(cpf);
		} catch (SQLException e) {
			e.printStackTrace();
		}
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
