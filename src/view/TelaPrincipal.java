package view;

import controller.ClienteController;
import controller.PetController;
import controller.ServicoController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class TelaPrincipal extends JFrame {

    private ClienteController clienteController;
    private PetController petController;
    private ServicoController servicoController;

    public TelaPrincipal() {
        super("Sistema Pet Shop");

        // Inicializa os controladores
        clienteController = new ClienteController();
        petController = new PetController();
        servicoController = new ServicoController();

        setSize(400, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel painel = new JPanel();
        painel.setLayout(new GridLayout(5, 1, 10, 10));
        painel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JButton btnCliente = new JButton("Cadastrar Cliente");
        JButton btnPet = new JButton("Cadastrar Pet");
        JButton btnServico = new JButton("Contratar Serviço");
        JButton btnListar = new JButton("Listar Clientes e Pets");
        JButton btnSair = new JButton("Sair");

        // Ações dos botões
        btnCliente.addActionListener((ActionEvent e) -> {
            new TelaCadastroCliente(clienteController);
        });

        btnPet.addActionListener((ActionEvent e) -> {
            new TelaCadastroPet(clienteController, petController);
        });

        btnServico.addActionListener((ActionEvent e) -> {
            new TelaServico(clienteController, servicoController);
        });

        btnListar.addActionListener((ActionEvent e) -> {
            new TelaListagem(clienteController, petController);
        });

        btnSair.addActionListener((ActionEvent e) -> {
            System.exit(0);
        });

        painel.add(btnCliente);
        painel.add(btnPet);
        painel.add(btnServico);
        painel.add(btnListar);
        painel.add(btnSair);

        add(painel);
        setVisible(true);
    }

    public static void main(String[] args) {
        new TelaPrincipal();
    }
}
