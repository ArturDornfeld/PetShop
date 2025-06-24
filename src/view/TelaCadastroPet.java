package view;

import controller.ClienteController;
import controller.PetController;
import model.Cliente;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class TelaCadastroPet extends JFrame {
    private ClienteController clienteController;
    private PetController petController;

    public TelaCadastroPet(ClienteController clienteController, PetController petController) {
        super("Cadastro de Pet");
        this.clienteController = clienteController;
        this.petController = petController;

        setSize(350, 250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel painel = new JPanel(new GridLayout(4, 2, 10, 10));
        painel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JTextField txtNome = new JTextField();
        JTextField txtEspecie = new JTextField();
        JTextField txtRaca = new JTextField();
        JComboBox<String> cbClientes = new JComboBox<>();

        List<Cliente> clientes = clienteController.listarClientes();
        for (Cliente c : clientes) {
            cbClientes.addItem(c.getCpf() + " - " + c.getNome());
        }

        painel.add(new JLabel("Nome do Pet:"));
        painel.add(txtNome);
        painel.add(new JLabel("Espécie:"));
        painel.add(txtEspecie);
        painel.add(new JLabel("Raça:"));
        painel.add(txtRaca);
        painel.add(new JLabel("Dono:"));
        painel.add(cbClientes);

        JButton btnSalvar = new JButton("Cadastrar");
        btnSalvar.addActionListener(e -> {
            int selectedIndex = cbClientes.getSelectedIndex();
            if (selectedIndex >= 0) {
                Cliente dono = clientes.get(selectedIndex);
                String msg = petController.cadastrarPet(txtNome.getText(), txtEspecie.getText(), txtRaca.getText(), dono);
                JOptionPane.showMessageDialog(this, msg);
            } else {
                JOptionPane.showMessageDialog(this, "Selecione um dono para o pet.");
            }
        });

        add(painel, BorderLayout.CENTER);
        add(btnSalvar, BorderLayout.SOUTH);
        setVisible(true);
    }
}
