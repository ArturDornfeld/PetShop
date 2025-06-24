package controller;

import model.Cliente;
import model.Pet;

import java.util.ArrayList;
import java.util.List;

public class PetController {

    private List<Pet> listaPets = new ArrayList<>();

    public String cadastrarPet(String nome, String especie, String raca, Cliente dono) {
        if (nome == null || nome.isBlank()) {
            return "Nome do pet não pode estar vazio.";
        }
        if (especie == null || especie.isBlank()) {
            return "Espécie do pet não pode estar vazia.";
        }
        if (raca == null || raca.isBlank()) {
            return "Raça do pet não pode estar vazia.";
        }

        Pet novoPet = new Pet(nome, especie, raca, dono);
        listaPets.add(novoPet);
        dono.adicionarPet(novoPet); // Aqui adicionamos o pet ao cliente

        return "Pet cadastrado com sucesso.";
    }

    public List<Pet> listarPets() {
        return listaPets;
    }
}
