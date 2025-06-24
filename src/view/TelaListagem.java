package view;

import controller.ClienteController;
import controller.PetController;
import model.Cliente;
import model.Pet;

import javax.swing.*;
import java.awt.*;

public class TelaListagem extends JFrame {

    public TelaListagem(ClienteController clienteController, PetController petController) {
        super("Listagem de Clientes e Pets");
        setSize(500, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JTextArea areaTexto = new JTextArea();
        areaTexto.setEditable(false);

        StringBuilder sb = new StringBuilder("Clientes Cadastrados:\n");
        for (Cliente c : clienteController.listarClientes()) {
            sb.append(c).append("\n");
        }

        sb.append("\nPets Cadastrados:\n");
        for (Pet p : petController.listarPets()) {
            sb.append(p).append("\n");
        }

        areaTexto.setText(sb.toString());
        add(new JScrollPane(areaTexto));

        setVisible(true);
    }
}
