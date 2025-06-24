package model;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private String nome;
    private String telefone;
    private String email;
    private String cpf;
    private List<Pet> pets; // Lista de pets do cliente

    public Cliente(String nome, String telefone, String email, String cpf) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.cpf = cpf;
        this.pets = new ArrayList<>(); // Inicializa a lista
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    // Métodos para manipular os pets
    public List<Pet> getPets() {
        return pets;
    }

    public void adicionarPet(Pet pet) {
        pets.add(pet);
    }

    @Override
    public String toString() {
        return nome + " - CPF: " + cpf;
    }
}
