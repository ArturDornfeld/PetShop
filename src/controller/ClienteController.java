package controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import model.Cliente;
import util.ArquivoUtil;

public class ClienteController {
    private List<Cliente> listaClientes;
    private final String CAMINHO_ARQUIVO = "dados/clientes.txt";

    public ClienteController() {
        listaClientes = new ArrayList<>();
        carregarClientes();
    }

    public void cadastrarCliente(Cliente cliente) {
        listaClientes.add(cliente);
        salvarClientes();
    }

    public List<Cliente> listarClientes() {
        return listaClientes;
    }

    public Cliente buscarClientePorCpf(String cpf) {
        for (Cliente cliente : listaClientes) {
            if (cliente.getCpf().equalsIgnoreCase(cpf)) {
                return cliente;
            }
        }
        return null;
    }

    public boolean excluirClientePorCpf(String cpf) {
        Iterator<Cliente> iterator = listaClientes.iterator();
        boolean removido = false;

        while (iterator.hasNext()) {
            Cliente cliente = iterator.next();
            if (cliente.getCpf().equalsIgnoreCase(cpf)) {
                iterator.remove();
                removido = true;
                break;
            }
        }

        if (removido) {
            salvarClientes();
        }

        return removido;
    }

    public void salvarClientes() {
        List<String> linhas = new ArrayList<>();
        for (Cliente cliente : listaClientes) {
            linhas.add(cliente.toLinhaArquivo());
        }
        ArquivoUtil.escreverLinhas(CAMINHO_ARQUIVO, linhas);
    }

    public void carregarClientes() {
        listaClientes.clear();
        List<String> linhas = ArquivoUtil.lerLinhas(CAMINHO_ARQUIVO);
        for (String linha : linhas) {
            Cliente cliente = Cliente.fromLinhaArquivo(linha);
            if (cliente != null) {
                listaClientes.add(cliente);
            }
        }
    }
}
