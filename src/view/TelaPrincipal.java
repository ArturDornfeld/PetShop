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

    public TelaPrincipal(ClienteController clienteController, PetController petController, ServicoController servicoController) {
        super("Sistema Pet Shop");

        this.clienteController = clienteController;
        this.petController = petController;
        this.servicoController = servicoController;

        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel painel = new JPanel();
        painel.setLayout(new GridLayout(5, 1, 10, 10));
        painel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Botões
        JButton btnCliente = new JButton("Cadastrar Cliente");
        JButton btnPet = new JButton("Cadastrar Pet");
        JButton btnServico = new JButton("Cadastrar Serviço");
        JButton btnListar = new JButton("Listar Tudo");
        JButton btnSair = new JButton("Sair");

        // Ações
        btnCliente.addActionListener((ActionEvent e) -> new TelaCadastroCliente(clienteController));
        btnPet.addActionListener((ActionEvent e) -> new TelaCadastroPet(clienteController, petController));
        btnServico.addActionListener((ActionEvent e) -> new TelaCadastroServico(clienteController, petController, servicoController));
        btnListar.addActionListener((ActionEvent e) -> new TelaListagem(clienteController, petController, servicoController));
        btnSair.addActionListener((ActionEvent e) -> System.exit(0));

        painel.add(btnCliente);
        painel.add(btnPet);
        painel.add(btnServico);
        painel.add(btnListar);
        painel.add(btnSair);

        add(painel);
        setVisible(true);
    }
}
