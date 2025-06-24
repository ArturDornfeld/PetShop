package controller;

import model.Pet;
import model.Servico;

import java.util.ArrayList;
import java.util.List;

public class ServicoController {

    private List<Servico> servicosDisponiveis = new ArrayList<>();
    private List<String> historicoContratacoes = new ArrayList<>();

    public ServicoController() {
        // Exemplos de serviços
        servicosDisponiveis.add(new Servico("Banho", "Banho com shampoo especial", 49.90));
        servicosDisponiveis.add(new Servico("Tosa", "Tosa higiênica completa", 59.90));
        servicosDisponiveis.add(new Servico("Consulta Veterinária", "Consulta com profissional", 89.90));
    }

    public List<Servico> listarServicos() {
        return servicosDisponiveis;
    }

    public String contratarServico(Pet pet, Servico servico) {
        historicoContratacoes.add("Pet: " + pet.getNome() + " contratou: " + servico.getNome());
        return "Serviço contratado com sucesso para " + pet.getNome() + "!";
    }

    public List<String> listarHistorico() {
        return historicoContratacoes;
    }
}
