package view;

import controller.ClienteController;
import controller.PetController;
import controller.ServicoController;
import model.Cliente;
import model.Pet;
import model.Servico;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class TelaCadastroServico extends JFrame {

    public TelaCadastroServico(ClienteController clienteController, PetController petController, ServicoController servicoController) {
        super("Contratação de Serviço");

        setSize(500, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel painel = new JPanel(new GridLayout(6, 2, 10, 10));
        painel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JComboBox<String> comboClientes = new JComboBox<>();
        List<Cliente> clientes = clienteController.listarClientes();
        for (Cliente c : clientes) {
            comboClientes.addItem(c.getCpf() + " - " + c.getNome());
        }

        JComboBox<String> comboPets = new JComboBox<>();
        JComboBox<String> comboServicos = new JComboBox<>(new String[]{
            "Banho - Banho completo com shampoo especial - 49.90",
            "Tosa - Tosa higiênica e penteado - 59.90",
            "Consulta - Avaliação clínica com veterinário - 99.90"
        });

        comboClientes.addActionListener(e -> {
            comboPets.removeAllItems();
            int index = comboClientes.getSelectedIndex();
            if (index >= 0) {
                Cliente cliente = clientes.get(index);
                List<Pet> petsDoCliente = petController.listarPets(cliente.getCpf());
                for (Pet p : petsDoCliente) {
                    comboPets.addItem(p.getNome());
                }
            }
        });

        if (!clientes.isEmpty()) {
            Cliente clienteInicial = clientes.get(0);
            List<Pet> petsIniciais = petController.listarPets(clienteInicial.getCpf());
            for (Pet p : petsIniciais) {
                comboPets.addItem(p.getNome());
            }
        }

        JButton btnContratar = new JButton("Contratar Serviço");
        JButton btnCancelar = new JButton("Cancelar Serviço");

        btnContratar.addActionListener(e -> {
            int clienteIndex = comboClientes.getSelectedIndex();
            int petIndex = comboPets.getSelectedIndex();
            int servicoIndex = comboServicos.getSelectedIndex();

            if (clienteIndex == -1 || petIndex == -1 || servicoIndex == -1) {
                JOptionPane.showMessageDialog(this, "Preencha todos os campos.");
                return;
            }

            Cliente cliente = clientes.get(clienteIndex);
            Pet pet = petController.listarPets(cliente.getCpf()).get(petIndex);

            String[] dados = comboServicos.getItemAt(servicoIndex).split(" - ");
            String nome = dados[0];
            String descricao = dados[1];
            double preco = Double.parseDouble(dados[2]);

            Servico servico = new Servico(nome, descricao, preco, cliente, pet);
            servicoController.contratarServico(servico);

            JOptionPane.showMessageDialog(this, "Serviço contratado com sucesso!");
        });

        btnCancelar.addActionListener(e -> {
            int clienteIndex = comboClientes.getSelectedIndex();
            int petIndex = comboPets.getSelectedIndex();
            int servicoIndex = comboServicos.getSelectedIndex();

            if (clienteIndex == -1 || petIndex == -1 || servicoIndex == -1) {
                JOptionPane.showMessageDialog(this, "Preencha todos os campos.");
                return;
            }

            Cliente cliente = clientes.get(clienteIndex);
            Pet pet = petController.listarPets(cliente.getCpf()).get(petIndex);
            String nomeServico = comboServicos.getItemAt(servicoIndex).split(" - ")[0];

            if (servicoController.cancelarServico(cliente.getCpf(), pet.getNome(), nomeServico)) {
                JOptionPane.showMessageDialog(this, "Serviço cancelado com sucesso!");
            } else {
                JOptionPane.showMessageDialog(this, "Serviço não encontrado.");
            }
        });

        painel.add(new JLabel("Cliente:"));
        painel.add(comboClientes);
        painel.add(new JLabel("Pet:"));
        painel.add(comboPets);
        painel.add(new JLabel("Serviço:"));
        painel.add(comboServicos);
        painel.add(btnContratar);
        painel.add(btnCancelar);

        add(painel);
        setVisible(true);
    }
}
