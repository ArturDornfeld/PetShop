package model;

import java.time.LocalDateTime;

public class Agendamento {
    // Atributos
    private Pet pet;
    private Servico servico;
    private LocalDateTime dataHora;

    // Construtor
    public Agendamento(Pet pet, Servico servico, LocalDateTime dataHora) {
        this.pet = pet;
        this.servico = servico;
        this.dataHora = dataHora;
    }

    // Getters e Setters
    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public Servico getServico() {
        return servico;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    // toString para representação do agendamento
    @Override
    public String toString() {
        return "Agendamento{" +
               "pet=" + pet.getNome() +
               ", servico=" + servico.getNome() +
               ", dataHora=" + dataHora +
               '}';
    }
}
