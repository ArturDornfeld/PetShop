package view;

import controller.ClienteController;
import controller.ServicoController;
import model.Cliente;
import model.Pet;
import model.Servico;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class TelaServico extends JFrame {

    private ClienteController clienteController;
    private ServicoController servicoController;

    public TelaServico(ClienteController clienteController, ServicoController servicoController) {
        this.clienteController = clienteController;
        this.servicoController = servicoController;

        setTitle("Contratar Serviço");
        setSize(400, 300);
        setLocationRelativeTo(null);

        JPanel painel = new JPanel(new GridLayout(5, 1, 10, 10));
        painel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JComboBox<String> cbClientes = new JComboBox<>();
        for (Cliente cliente : clienteController.listarClientes()) {
            cbClientes.addItem(cliente.getNome());
        }

        JComboBox<String> cbPets = new JComboBox<>();
        cbClientes.addActionListener(e -> {
            cbPets.removeAllItems();
            int index = cbClientes.getSelectedIndex();
            if (index >= 0) {
                Cliente cliente = clienteController.listarClientes().get(index);
                for (Pet pet : cliente.getPets()) {
                    cbPets.addItem(pet.getNome());
                }
            }
        });

        JComboBox<String> cbServicos = new JComboBox<>();
        for (Servico servico : servicoController.listarServicos()) {
            cbServicos.addItem(servico.toString());
        }

        JButton btnContratar = new JButton("Contratar");

        JLabel lblResultado = new JLabel("");

        btnContratar.addActionListener(e -> {
            int clienteIndex = cbClientes.getSelectedIndex();
            int petIndex = cbPets.getSelectedIndex();
            int servicoIndex = cbServicos.getSelectedIndex();

            if (clienteIndex >= 0 && petIndex >= 0 && servicoIndex >= 0) {
                Cliente cliente = clienteController.listarClientes().get(clienteIndex);
                Pet pet = cliente.getPets().get(petIndex);
                Servico servico = servicoController.listarServicos().get(servicoIndex);

                String msg = servicoController.contratarServico(pet, servico);
                lblResultado.setText(msg);
            }
        });

        painel.add(new JLabel("Cliente:"));
        painel.add(cbClientes);
        painel.add(new JLabel("Pet:"));
        painel.add(cbPets);
        painel.add(new JLabel("Serviço:"));
        painel.add(cbServicos);
        painel.add(btnContratar);
        painel.add(lblResultado);

        add(painel);
        setVisible(true);
    }
}
