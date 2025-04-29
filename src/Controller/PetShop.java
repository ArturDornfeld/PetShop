package controller;

import model.Cliente;
import java.util.ArrayList;
import java.util.List;

public class PetShop {
    private List<Cliente> clientes;

    public PetShop() {
        clientes = new ArrayList<>();
    }

    public void adicionarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public Cliente buscarClientePorNome(String nome) {
        for (Cliente c : clientes) {
            if (c.getNome().equalsIgnoreCase(nome)) {
                return c;
            }
        }
        return null;
    }

    public boolean removerCliente(String nome) {
        Cliente c = buscarClientePorNome(nome);
        if (c != null) {
            return clientes.remove(c);
        }
        return false;
    }

    public void listarClientes() {
        if (clientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado.");
        } else {
            for (Cliente c : clientes) {
                c.exibirInformacoes();
                System.out.println();
            }
        }
    }
}
