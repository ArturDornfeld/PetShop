package model;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private String nome;
    private String telefone;
    private String email;
    private String cpf;
    private List<Pet> pets;

    public Cliente(String nome, String telefone, String email, String cpf) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.cpf = cpf;
        this.pets = new ArrayList<>();
    }

    public Cliente() {
        this.pets = new ArrayList<>();
    }

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

    // ➕ NOVO: para salvar no arquivo
    public String toLinhaArquivo() {
        return nome + ";" + cpf + ";" + telefone + ";" + email;
    }

    // ➕ NOVO: para carregar do arquivo
    public static Cliente fromLinhaArquivo(String linha) {
        String[] partes = linha.split(";");
        if (partes.length >= 4) {
            Cliente cliente = new Cliente();
            cliente.setNome(partes[0]);
            cliente.setCpf(partes[1]);
            cliente.setTelefone(partes[2]);
            cliente.setEmail(partes[3]);
            return cliente;
        }
        return null;
    }
}
