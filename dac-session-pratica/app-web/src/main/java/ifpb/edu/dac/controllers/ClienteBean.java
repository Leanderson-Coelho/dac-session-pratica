/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifpb.edu.dac.controllers;

import javax.inject.Named;

/**
 *
 * @author ericl
 */
@Named
public class ClienteBean {
    
    private Integer id;
    private String nome;
    private String Cpf
    private Cliente cliente;
    
    private List<Cliente> clientes;

    public ClienteBean() {
        
    }
    
    
    public void listarClientes(){
        clientes = ClienteDao.listar();
    }
    
    public Cliente buscarPorCpf(String cpf){
        ClienteDao.pesquisarCPF(cpf);
    }
    public void editarCliente(Cliente clinte){
        ClienteDao.editar(cliente);
    }
   
    
    
    
    
}
