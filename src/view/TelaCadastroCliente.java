package view;

import controller.ClienteController;

import javax.swing.*;
import java.awt.*;

public class TelaCadastroCliente extends JFrame {

    private JTextField campoNome;
    private JTextField campoCpf;
    private JTextField campoTelefone;
    private JTextField campoEmail;
    private JTextArea areaMensagens;
    private ClienteController controller;

    public TelaCadastroCliente() {
        super("Cadastro de Cliente");
        controller = new ClienteController();

        setLayout(new BorderLayout());

        JPanel painelFormulario = new JPanel(new GridLayout(5, 2));

        painelFormulario.add(new JLabel("Nome:"));
        campoNome = new JTextField();
        painelFormulario.add(campoNome);

        painelFormulario.add(new JLabel("CPF:"));
        campoCpf = new JTextField();
        painelFormulario.add(campoCpf);

        painelFormulario.add(new JLabel("Telefone:"));
        campoTelefone = new JTextField();
        painelFormulario.add(campoTelefone);

        painelFormulario.add(new JLabel("Email:"));
        campoEmail = new JTextField();
        painelFormulario.add(campoEmail);

        JButton botaoCadastrar = new JButton("Cadastrar");
        botaoCadastrar.addActionListener(e -> cadastrarCliente());
        painelFormulario.add(botaoCadastrar);

        JButton botaoListar = new JButton("Listar Clientes");
        botaoListar.addActionListener(e -> listarClientes());
        painelFormulario.add(botaoListar);

        add(painelFormulario, BorderLayout.NORTH);

        areaMensagens = new JTextArea(10, 30);
        areaMensagens.setEditable(false);
        add(new JScrollPane(areaMensagens), BorderLayout.CENTER);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

    private void cadastrarCliente() {
        String nome = campoNome.getText();
        String cpf = campoCpf.getText();
        String telefone = campoTelefone.getText();
        String email = campoEmail.getText();

        String mensagem = controller.cadastrarCliente(nome, cpf, telefone, email);
        areaMensagens.append(mensagem + "\n");
    }

    private void listarClientes() {
        areaMensagens.append("--- Lista de Clientes ---\n");
        for (var cliente : controller.listarClientes()) {
            areaMensagens.append(cliente.toString() + "\n");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(TelaCadastroCliente::new);
    }
}
