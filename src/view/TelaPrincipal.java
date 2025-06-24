package view;

import controller.ClienteController;
import controller.PetController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class TelaPrincipal extends JFrame {

    private ClienteController clienteController;
    private PetController petController;

    public TelaPrincipal(ClienteController clienteController, PetController petController) {
        super("Sistema Pet Shop");

        this.clienteController = clienteController;
        this.petController = petController;

        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel painel = new JPanel();
        painel.setLayout(new GridLayout(4, 1, 10, 10));
        painel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JButton btnCliente = new JButton("Cadastrar Cliente");
        JButton btnPet = new JButton("Cadastrar Pet");
        JButton btnListar = new JButton("Listar Clientes e Pets");
        JButton btnSair = new JButton("Sair");

        btnCliente.addActionListener((ActionEvent e) -> {
            new TelaCadastroCliente(clienteController);
        });

        btnPet.addActionListener((ActionEvent e) -> {
            new TelaCadastroPet(clienteController, petController);
        });

        btnListar.addActionListener((ActionEvent e) -> {
            new TelaListagem(clienteController, petController);
        });

        btnSair.addActionListener((ActionEvent e) -> {
            System.exit(0);
        });

        painel.add(btnCliente);
        painel.add(btnPet);
        painel.add(btnListar);
        painel.add(btnSair);

        add(painel);
        setVisible(true);
    }
}
