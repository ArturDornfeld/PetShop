package controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import model.Cliente;
import model.Pet;
import model.Servico;
import util.ArquivoUtil;

public class ServicoController {
    private List<Servico> listaServicos;
    private final String CAMINHO_ARQUIVO = "dados/servicos.txt";

    private ClienteController clienteController;
    private PetController petController;

    public ServicoController(ClienteController clienteController, PetController petController) {
        this.clienteController = clienteController;
        this.petController = petController;
        listaServicos = new ArrayList<>();
        carregarServicos();
    }

    public void contratarServico(Servico servico) {
        listaServicos.add(servico);
        salvarServicos();
    }

    public List<Servico> listarServicos() {
        return listaServicos;
    }

    public boolean cancelarServico(String cpfCliente, String nomePet, String nomeServico) {
        Iterator<Servico> iterator = listaServicos.iterator();
        while (iterator.hasNext()) {
            Servico servico = iterator.next();
            if (servico.getCliente().getCpf().equalsIgnoreCase(cpfCliente) &&
                servico.getPet().getNome().equalsIgnoreCase(nomePet) &&
                servico.getNome().equalsIgnoreCase(nomeServico)) {
                iterator.remove();
                salvarServicos();
                return true;
            }
        }
        return false;
    }

    public void salvarServicos() {
        List<String> linhas = new ArrayList<>();
        for (Servico servico : listaServicos) {
            linhas.add(servico.toLinhaArquivo());
        }
        ArquivoUtil.escreverLinhas(CAMINHO_ARQUIVO, linhas);
    }

    public void carregarServicos() {
        listaServicos.clear();
        List<String> linhas = ArquivoUtil.lerLinhas(CAMINHO_ARQUIVO);

        List<Cliente> clientes = clienteController.listarClientes();
        List<Pet> pets = new ArrayList<>();
        for (Cliente c : clientes) {
            pets.addAll(c.getPets());
        }

        for (String linha : linhas) {
            Servico servico = Servico.fromLinhaArquivo(linha, clientes, pets);
            if (servico != null) {
                listaServicos.add(servico);
            }
        }
    }
}
