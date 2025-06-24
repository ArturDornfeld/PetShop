package controller;

import model.Cliente;
import model.Pet;
import model.Servico;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ServicoController {

    private static final String ARQUIVO_SERVICOS = "dados/servicos.txt";
    private List<Servico> listaServicos = new ArrayList<>();

    public String cadastrarServico(String nome, String descricao, double preco, Cliente cliente, Pet pet) {
        Servico servico = new Servico(nome, descricao, preco, cliente, pet);
        listaServicos.add(servico);
        salvarEmArquivo(servico);
        return "Serviço cadastrado com sucesso.";
    }

    public List<Servico> listarServicos(List<Cliente> clientes, List<Pet> pets) {
        List<Servico> servicos = new ArrayList<>();
        File arquivo = new File(ARQUIVO_SERVICOS);
        if (!arquivo.exists()) return servicos;

        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                Servico servico = Servico.fromLinhaArquivo(linha, clientes, pets);
                if (servico != null) {
                    servicos.add(servico);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return servicos;
    }

    private void salvarEmArquivo(Servico servico) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ARQUIVO_SERVICOS, true))) {
            bw.write(servico.toLinhaArquivo());
            bw.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
