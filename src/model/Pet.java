package model;

import java.util.ArrayList;
import java.util.List;

public class Pet {
    private String nome;
    private String especie;
    private String raca;
    private int idade;
    private double peso;
    private List<Servico> servicos;
    private List<ServicoAgendado> servicosAgendados;

    public Pet(String nome, String especie, String raca, int idade, double peso) {
        this.nome = nome;
        this.especie = especie;
        this.raca = raca;
        this.idade = idade;
        this.peso = peso;
        this.servicos = new ArrayList<>();
        this.servicosAgendados = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public String getEspecie() {
        return especie;
    }

    public String getRaca() {
        return raca;
    }

    public int getIdade() {
        return idade;
    }

    public double getPeso() {
        return peso;
    }

    public List<Servico> getServicos() {
        return servicos;
    }

    public List<ServicoAgendado> getServicosAgendados() {
        return servicosAgendados;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public void adicionarServico(Servico servico) {
        servicos.add(servico);
    }

    public boolean removerServico(Servico servico) {
        return servicos.remove(servico);
    }

    public void adicionarServicoAgendado(ServicoAgendado servicoAgendado) {
        servicosAgendados.add(servicoAgendado);
    }

    public boolean removerServicoAgendado(ServicoAgendado servicoAgendado) {
        return servicosAgendados.remove(servicoAgendado);
    }

    public Servico buscarServicoPorTipo(String tipoServico) {
        for (Servico s : servicos) {
            if (s.getTipoServico().equalsIgnoreCase(tipoServico)) {
                return s;
            }
        }
        return null;
    }

    public ServicoAgendado buscarServicoAgendadoPorTipo(String tipo) {
        for (ServicoAgendado sa : servicosAgendados) {
            if (sa.getServico().getTipoServico().equalsIgnoreCase(tipo)) {
                return sa;
            }
        }
        return null;
    }

    public void listarServicosAgendados() {
        if (servicosAgendados.isEmpty()) {
            System.out.println("Nenhum serviço agendado.");
        } else {
            for (ServicoAgendado sa : servicosAgendados) {
                System.out.print("  • ");
                sa.exibirInformacoes();
            }
        }
    }

    public void exibirInformacoes() {
        System.out.println("---- Pet ----");
        System.out.println("Nome: " + nome);
        System.out.println("Espécie: " + especie + " | Raça: " + raca);
        System.out.println("Idade: " + idade + " anos | Peso: " + peso + " kg");

        if (servicos.isEmpty()) {
            System.out.println("Nenhum serviço contratado.");
        } else {
            System.out.println("Serviços contratados:");
            for (Servico s : servicos) {
                System.out.print("  • ");
                s.exibirInformacoes();
            }
        }

        if (servicosAgendados.isEmpty()) {
            System.out.println("Nenhum serviço agendado.");
        } else {
            System.out.println("Serviços agendados:");
            for (ServicoAgendado sa : servicosAgendados) {
                System.out.print("  • ");
                sa.exibirInformacoes();
            }
        }
    }

    public String toString() {
        return String.format("Pet[nome=%s, especie=%s, raca=%s, idade=%d, peso=%.1f, qtdServicos=%d]",
                nome, especie, raca, idade, peso, servicos.size());
    }
}
