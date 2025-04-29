package model;

import java.util.ArrayList;
import java.util.List;

/* Classe que representa um cliente do Pet Shop */
public class Cliente {
    private String nome;
    private String telefone;
    private String email;
    private List<Pet> pets;

    public Cliente(String nome, String telefone, String email) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.pets = new ArrayList<>();
    }

    /* gets */
    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEmail() {
        return email;
    }

    public List<Pet> getPets() {
        return pets;
    }

    /* sets */
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    /* métodos */
    public void adicionarPet(Pet pet) {
        pets.add(pet);
    }

    public boolean removerPet(Pet pet) {
        return pets.remove(pet);
    }

    public Pet buscarPetPorNome(String nomePet) {
        for (Pet p : pets) {
            if (p.getNome().equalsIgnoreCase(nomePet)) {
                return p;
            }
        }
        return null;
    }

    public void exibirInformacoes() {
        System.out.println("---- Cliente ----");
        System.out.println("Nome: " + nome);
        System.out.println("Telefone: " + telefone);
        System.out.println("E-mail: " + email);
        if (pets.isEmpty()) {
            System.out.println("Nenhum pet cadastrado.");
        } else {
            System.out.println("Pets cadastrados:");
            for (Pet p : pets) {
                System.out.print("  • ");
                p.exibirInformacoes();
            }
        }
    }

    public String toString() {
        return String.format("Cliente[nome=%s, telefone=%s, email=%s, qtdPets=%d]",
                             nome, telefone, email, pets.size());
    }
}
