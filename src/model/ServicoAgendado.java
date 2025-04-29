package model;

import java.time.LocalDate;

public class ServicoAgendado {
    private Servico servico;
    private LocalDate dataAgendada;

    public ServicoAgendado(Servico servico, LocalDate dataAgendada) {
        this.servico = servico;
        this.dataAgendada = dataAgendada;
    }

    public Servico getServico() {
        return servico;
    }

    public LocalDate getDataAgendada() {
        return dataAgendada;
    }

    public void exibirInformacoes() {
        servico.exibirInformacoes();
        System.out.println("Data agendada: " + dataAgendada);
    }
}
