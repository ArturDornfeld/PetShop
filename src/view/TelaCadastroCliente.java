package view;

import controller.ClienteController;
import javax.swing.*;
import java.awt.*;

public class TelaCadastroCliente extends JFrame {
    private ClienteController clienteController;

    public TelaCadastroCliente(ClienteController clienteController) {
        super("Cadastro de Cliente");
        this.clienteController = clienteController;

        setSize(350, 250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel painel = new JPanel(new GridLayout(5, 2, 10, 10));
        painel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JTextField txtNome = new JTextField();
        JTextField txtCPF = new JTextField();
        JTextField txtTelefone = new JTextField();
        JTextField txtEmail = new JTextField();

        painel.add(new JLabel("Nome:"));
        painel.add(txtNome);
        painel.add(new JLabel("CPF:"));
        painel.add(txtCPF);
        painel.add(new JLabel("Telefone:"));
        painel.add(txtTelefone);
        painel.add(new JLabel("Email:"));
        painel.add(txtEmail);

        JButton btnSalvar = new JButton("Cadastrar");
        btnSalvar.addActionListener(e -> {
            String msg = clienteController.cadastrarCliente(
                txtNome.getText(), txtTelefone.getText(), txtEmail.getText(), txtCPF.getText()
            );
            JOptionPane.showMessageDialog(this, msg);
        });

        painel.add(btnSalvar);
        add(painel);
        setVisible(true);
    }
}
