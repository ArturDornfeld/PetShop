package controller;

import model.Cliente;
import java.util.ArrayList;
import java.util.List;

public class ClienteController {

    private List<Cliente> listaClientes = new ArrayList<>();

    // Valida e cadastra um cliente
    public String cadastrarCliente(String nome, String telefone, String email, String cpf) {
        if (nome == null || nome.isBlank()) {
            return "Nome não pode estar vazio.";
        }

        telefone = telefone.replaceAll("\\D", ""); // Remove caracteres não numéricos
        cpf = cpf.replaceAll("\\D", ""); // Remove pontos e traços

        if (!telefone.matches("\\d{10,11}")) {
            return "Telefone inválido. Use apenas números (10 ou 11 dígitos).";
        }

        if (!cpf.matches("\\d{11}")) {
            return "CPF inválido. Deve conter exatamente 11 dígitos numéricos.";
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
