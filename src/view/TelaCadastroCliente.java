package view;

import controller.ClienteController;

import javax.swing.*;
import java.awt.*;

public class TelaCadastroCliente extends JFrame {

    private ClienteController clienteController;

    public TelaCadastroCliente(ClienteController controller) {
        super("Cadastro de Cliente");
        this.clienteController = controller;

        setSize(400, 250);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel painel = new JPanel(new GridLayout(5, 2, 10, 10));
        painel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JTextField campoNome = new JTextField();
        JTextField campoCpf = new JTextField();
        JTextField campoTelefone = new JTextField();
        JTextField campoEmail = new JTextField();

        painel.add(new JLabel("Nome:"));
        painel.add(campoNome);
        painel.add(new JLabel("CPF:"));
        painel.add(campoCpf);
        painel.add(new JLabel("Telefone:"));
        painel.add(campoTelefone);
        painel.add(new JLabel("Email:"));
        painel.add(campoEmail);

        JButton btnCadastrar = new JButton("Cadastrar");
        painel.add(btnCadastrar);

        JButton btnLimpar = new JButton("Limpar");
        painel.add(btnLimpar);

        btnCadastrar.addActionListener(e -> {
            String nome = campoNome.getText();
            String cpf = campoCpf.getText();
            String telefone = campoTelefone.getText();
            String email = campoEmail.getText();

            String resultado = clienteController.cadastrarCliente(nome, telefone, email, cpf);
            JOptionPane.showMessageDialog(this, resultado);

            if (resultado.equals("Cliente cadastrado com sucesso.")) {
                campoNome.setText("");
                campoCpf.setText("");
                campoTelefone.setText("");
                campoEmail.setText("");
            }
        });

        btnLimpar.addActionListener(e -> {
            campoNome.setText("");
            campoCpf.setText("");
            campoTelefone.setText("");
            campoEmail.setText("");
        });

        add(painel);
        setVisible(true);
    }
}
