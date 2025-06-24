package controller;

import model.Cliente;
import model.Pet;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PetController {

    private final String caminho = "dados/pets.txt";

    public String cadastrarPet(String nome, String especie, String raca, Cliente dono) {
        Pet pet = new Pet(nome, especie, raca, dono);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(caminho, true))) {
            writer.write(pet.toLinhaArquivo());
            writer.newLine();
            return "Pet cadastrado com sucesso!";
        } catch (IOException e) {
            return "Erro ao salvar pet.";
        }
    }

    public List<Pet> listarPets(List<Cliente> clientes) {
        List<Pet> pets = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(caminho))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                Pet pet = Pet.fromLinhaArquivo(linha, clientes);
                if (pet != null) pets.add(pet);
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo de pets.");
        }

        return pets;
    }

    public List<Pet> listarPetsPorDono(Cliente dono, List<Cliente> clientes) {
        List<Pet> resultado = new ArrayList<>();
        for (Pet p : listarPets(clientes)) {
            if (p != null && p.getDono() != null && p.getDono().getCpf().equals(dono.getCpf())) {
                resultado.add(p);
            }
        }
        return resultado;
    }
}
