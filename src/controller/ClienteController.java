package controller;

import model.Cliente;
import java.util.ArrayList;
import java.util.List;

public class ClienteController {

    private List<Cliente> listaClientes = new ArrayList<>();

    // Valida e cadastra um cliente
    public String cadastrarCliente(String nome, String cpf, String telefone, String email) {
        if (nome == null || nome.isBlank()) {
            return "Nome não pode estar vazio.";
        }
        if (!cpf.matches("\\d{11}")) {
            return "CPF inválido. Use apenas 11 dígitos numéricos.";
        }
        if (!telefone.matches("\\d{10,11}")) {
            return "Telefone inválido. Use apenas números (10 ou 11 dígitos).";
        }
        if (!email.matches("^[\\w\\.-]+@[\\w\\.-]+\\.\\w{2,}$")) {
            return "Email inválido.";
        }

        Cliente novoCliente = new Cliente(nome, cpf, email, telefone);
        listaClientes.add(novoCliente);
        return "Cliente cadastrado com sucesso.";
    }

    // Lista todos os clientes cadastrados
    public List<Cliente> listarClientes() {
        return listaClientes;
    }
}
