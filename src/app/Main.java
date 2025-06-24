package app;

import controller.ClienteController;
import controller.PetController;
import controller.ServicoController;
import view.TelaPrincipal;

public class Main {
    public static void main(String[] args) {
        ClienteController clienteController = new ClienteController();
        PetController petController = new PetController(clienteController);
        ServicoController servicoController = new ServicoController(clienteController, petController);

        new TelaPrincipal(clienteController, petController, servicoController);
    }
}
