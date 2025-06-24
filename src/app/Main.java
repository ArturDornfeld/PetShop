package app;

import controller.ClienteController;
import controller.PetController;
import view.TelaPrincipal;

public class Main {
    public static void main(String[] args) {
        ClienteController clienteController = new ClienteController();
        PetController petController = new PetController();

        new TelaPrincipal(clienteController, petController);
    }
}
