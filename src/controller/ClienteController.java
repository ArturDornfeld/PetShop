package controller;

import model.Cliente;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteController {

    private List<Cliente> listaClientes = new ArrayList<>();
    private static final String ARQUIVO_CLIENTES = "dados/clientes.txt";

    public ClienteController() {
        carregarClientes();
    }

    public String cadastrarCliente(String nome, String telefone, String email, String cpf) {
        if (nome == null || nome.isBlank()) return "Nome não pode estar vazio.";
        if (!telefone.matches("\\d{10,11}")) return "Telefone inválido.";
        if (!email.matches("^[\\w\\.-]+@[\\w\\.-]+\\.\\w{2,}$")) return "Email inválido.";
        if (!cpf.matches("\\d{11}")) return "CPF inválido. Deve conter 11 dígitos.";

        Cliente novo = new Cliente(nome, cpf, email, telefone);
        listaClientes.add(novo);
        salvarClientes();
        return "Cliente cadastrado com sucesso.";
    }

    public List<Cliente> listarClientes() {
        return listaClientes;
    }

    public void salvarClientes() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ARQUIVO_CLIENTES))) {
            for (Cliente cliente : listaClientes) {
                String linha = String.format("%s;%s;%s;%s", 
                    cliente.getNome(), cliente.getCpf(), cliente.getEmail(), cliente.getTelefone());
                writer.write(linha);
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Erro ao salvar clientes: " + e.getMessage());
        }
    }

    public void carregarClientes() {
        File arquivo = new File(ARQUIVO_CLIENTES);
        if (!arquivo.exists()) return;

        try (BufferedReader reader = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] partes = linha.split(";");
                if (partes.length == 4) {
                    String nome = partes[0];
                    String cpf = partes[1];
                    String email = partes[2];
                    String telefone = partes[3];

                    Cliente cliente = new Cliente(nome, cpf, email, telefone);
                    listaClientes.add(cliente);
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao carregar clientes: " + e.getMessage());
        }
    }

    public Cliente buscarClientePorCpf(String cpf) {
        for (Cliente c : listaClientes) {
            if (c.getCpf().equals(cpf)) {
                return c;
            }
        }
        return null;
    }
}
