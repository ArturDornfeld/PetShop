package controller;

import model.Pet;
import model.Cliente;

import java.util.ArrayList;
import java.util.List;

public class PetController {
    private List<Pet> listaPets = new ArrayList<>();

    public String cadastrarPet(String nome, String especie, String raca, Cliente dono) {
        if (nome == null || nome.isBlank()) {
            return "Nome do pet não pode estar vazio.";
        }
        if (especie == null || especie.isBlank()) {
            return "Espécie não pode estar vazia.";
        }
        if (raca == null || raca.isBlank()) {
            return "Raça não pode estar vazia.";
        }
        if (dono == null) {
            return "Pet precisa ter um dono.";
        }

        Pet novoPet = new Pet(nome, especie, raca, dono);
        listaPets.add(novoPet);
        return "Pet cadastrado com sucesso.";
    }

    public List<Pet> listarPets() {
        return listaPets;
    }
}
