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


    public List<Cliente> getTodosOsClientes() {
        return clienteDAO.listarTodos();
    }

    public String adicionar() {
        this.getTodosOsClientes().add(cliente);
        return null;
    }

    public String remover(Cliente cliente) {
        this.clienteDAO.remover(cliente);
        return null;
    }

    public String atualizar(Cliente cliente) {
        this.clienteDAO.atualizar(cliente);
        return "cliente/list.xhtml";
    }

    public String buscarCpf(String cpf) {
        this.clienteDAO.pesquisarCPF(cpf);
        return "cliente/edit.xhtml";
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}