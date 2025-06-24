package view;

import controller.ClienteController;
import controller.PetController;
import model.Cliente;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class TelaCadastroPet extends JFrame {

    public TelaCadastroPet(ClienteController clienteController, PetController petController) {
        super("Cadastro de Pet");

        setSize(400, 250);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel painel = new JPanel(new GridLayout(5, 2, 10, 10));
        painel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JTextField campoNomePet = new JTextField();
        JTextField campoEspecie = new JTextField();
        JTextField campoRaca = new JTextField();

        List<Cliente> clientes = clienteController.listarClientes();
        JComboBox<String> comboClientes = new JComboBox<>();
        for (Cliente c : clientes) {
            comboClientes.addItem(c.getCpf() + " - " + c.getNome());
        }

        painel.add(new JLabel("Nome do Pet:"));
        painel.add(campoNomePet);
        painel.add(new JLabel("Espécie:"));
        painel.add(campoEspecie);
        painel.add(new JLabel("Raça:"));
        painel.add(campoRaca);
        painel.add(new JLabel("Dono (CPF - Nome):"));
        painel.add(comboClientes);

        JButton btnCadastrar = new JButton("Cadastrar");
        JButton btnLimpar = new JButton("Limpar");
        painel.add(btnCadastrar);
        painel.add(btnLimpar);

        btnCadastrar.addActionListener(e -> {
            if (clientes.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Nenhum cliente cadastrado.");
                return;
            }

            String nomePet = campoNomePet.getText();
            String especie = campoEspecie.getText();
            String raca = campoRaca.getText();
            int index = comboClientes.getSelectedIndex();
            Cliente dono = clientes.get(index);

            String resultado = petController.cadastrarPet(nomePet, especie, raca, dono);
            JOptionPane.showMessageDialog(this, resultado);

            if (resultado.equals("Pet cadastrado com sucesso.")) {
                campoNomePet.setText("");
                campoEspecie.setText("");
                campoRaca.setText("");
            }
        });

        btnLimpar.addActionListener(e -> {
            campoNomePet.setText("");
            campoEspecie.setText("");
            campoRaca.setText("");
        });

        add(painel);
        setVisible(true);
    }
}
