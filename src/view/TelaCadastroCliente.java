package view;

import controller.ClienteController;
import model.Cliente;

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

        JPanel painel = new JPanel(new GridLayout(6, 2, 10, 10));
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
        JButton btnLimpar = new JButton("Limpar");
        JButton btnExcluir = new JButton("Excluir Cliente");

        painel.add(btnCadastrar);
        painel.add(btnLimpar);
        painel.add(btnExcluir);

        btnCadastrar.addActionListener(e -> {
            String nome = campoNome.getText().trim();
            String cpf = campoCpf.getText().trim();
            String telefone = campoTelefone.getText().trim();
            String email = campoEmail.getText().trim();

            if (nome.isEmpty() || cpf.isEmpty() || telefone.isEmpty() || email.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Todos os campos são obrigatórios.");
                return;
            }

            if (!cpf.matches("\\d{11}")) {
                JOptionPane.showMessageDialog(this, "CPF deve conter exatamente 11 dígitos numéricos.");
                return;
            }

            if (!email.contains("@") || !email.contains(".")) {
                JOptionPane.showMessageDialog(this, "Email inválido.");
                return;
            }

            if (!telefone.matches("\\d{8,14}")) {
                JOptionPane.showMessageDialog(this, "Telefone deve conter apenas números e ter entre 8 a 14 dígitos.");
                return;
            }

            Cliente cliente = new Cliente(nome, telefone, email, cpf);
            clienteController.cadastrarCliente(cliente);

            JOptionPane.showMessageDialog(this, "Cliente cadastrado com sucesso!");

            campoNome.setText("");
            campoCpf.setText("");
            campoTelefone.setText("");
            campoEmail.setText("");
        });

        btnLimpar.addActionListener(e -> {
            campoNome.setText("");
            campoCpf.setText("");
            campoTelefone.setText("");
            campoEmail.setText("");
        });

        btnExcluir.addActionListener(e -> {
            String cpf = campoCpf.getText();
            if (clienteController.excluirClientePorCpf(cpf)) {
                JOptionPane.showMessageDialog(this, "Cliente excluído com sucesso!");
            } else {
                JOptionPane.showMessageDialog(this, "Cliente não encontrado.");
            }
        });

        add(painel);
        setVisible(true);
    }
}
