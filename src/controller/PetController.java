package controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import model.Cliente;
import model.Pet;
import util.ArquivoUtil;

public class PetController {
    private ClienteController clienteController;

    public PetController(ClienteController clienteController) {
        this.clienteController = clienteController;
    }

    public void cadastrarPet(String cpfCliente, Pet pet) {
        Cliente cliente = clienteController.buscarClientePorCpf(cpfCliente);
        if (cliente != null) {
            cliente.getPets().add(pet);
            clienteController.salvarClientes();
        }
    }

    public List<Pet> listarPets(String cpfCliente) {
        Cliente cliente = clienteController.buscarClientePorCpf(cpfCliente);
        if (cliente != null) {
            return cliente.getPets();
        }
        return new ArrayList<>();
    }

    public boolean excluirPet(String cpfCliente, String nomePet) {
        Cliente cliente = clienteController.buscarClientePorCpf(cpfCliente);
        if (cliente != null) {
            Iterator<Pet> iterator = cliente.getPets().iterator();
            while (iterator.hasNext()) {
                Pet pet = iterator.next();
                if (pet.getNome().equalsIgnoreCase(nomePet)) {
                    iterator.remove();
                    clienteController.salvarClientes();
                    return true;
                }
            }
        }
        return false;
    }
}
