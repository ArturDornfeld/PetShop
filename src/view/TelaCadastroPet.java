package view;

import controller.ClienteController;
import controller.PetController;
import model.Cliente;
import model.Pet;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class TelaCadastroPet extends JFrame {

    public TelaCadastroPet(ClienteController clienteController, PetController petController) {
        super("Cadastro de Pet");

        setSize(400, 250);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel painel = new JPanel(new GridLayout(6, 2, 10, 10));
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
        JButton btnExcluir = new JButton("Excluir Pet");

        painel.add(btnCadastrar);
        painel.add(btnLimpar);
        painel.add(btnExcluir);

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

            Pet pet = new Pet(nomePet, especie, raca, dono);
            petController.cadastrarPet(dono.getCpf(), pet);

            JOptionPane.showMessageDialog(this, "Pet cadastrado com sucesso!");

            campoNomePet.setText("");
            campoEspecie.setText("");
            campoRaca.setText("");
        });

        btnLimpar.addActionListener(e -> {
            campoNomePet.setText("");
            campoEspecie.setText("");
            campoRaca.setText("");
        });

        btnExcluir.addActionListener(e -> {
            int index = comboClientes.getSelectedIndex();
            Cliente dono = clientes.get(index);
            String nomePet = campoNomePet.getText();

            if (petController.excluirPet(dono.getCpf(), nomePet)) {
                JOptionPane.showMessageDialog(this, "Pet excluído com sucesso!");
            } else {
                JOptionPane.showMessageDialog(this, "Pet não encontrado.");
            }
        });

        add(painel);
        setVisible(true);
    }
}
