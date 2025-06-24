package view;

import controller.ClienteController;
import controller.PetController;
import controller.ServicoController;
import model.Cliente;
import model.Pet;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class TelaCadastroServico extends JFrame {

    public TelaCadastroServico(ClienteController clienteController, PetController petController, ServicoController servicoController) {
        super("Contratação de Serviço");

        setSize(500, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel painel = new JPanel(new GridLayout(5, 2, 10, 10));
        painel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // ComboBox para selecionar cliente
        JComboBox<String> comboClientes = new JComboBox<>();
        List<Cliente> clientes = clienteController.listarClientes();
        for (Cliente c : clientes) {
            comboClientes.addItem(c.getCpf() + " - " + c.getNome());
        }

        // ComboBox para selecionar pet (será atualizado ao trocar cliente)
        JComboBox<String> comboPets = new JComboBox<>();

        // ComboBox com serviços fixos
        String[] opcoesServicos = {
            "Banho - Banho completo com shampoo especial - 49.90",
            "Tosa - Tosa higiênica e penteado - 59.90",
            "Consulta - Avaliação clínica com veterinário - 99.90"
        };
        JComboBox<String> comboServicos = new JComboBox<>(opcoesServicos);

        // Atualiza pets quando cliente for selecionado
        comboClientes.addActionListener(e -> {
            comboPets.removeAllItems();
            int index = comboClientes.getSelectedIndex();
            if (index >= 0) {
                Cliente cliente = clientes.get(index);
                List<Pet> petsDoCliente = petController.listarPetsPorDono(cliente, clientes);
                for (Pet p : petsDoCliente) {
                    comboPets.addItem(p.getNome());
                }
            }
        });

        // Inicializa comboPets com os primeiros pets
        if (!clientes.isEmpty()) {
            Cliente clienteInicial = clientes.get(0);
            List<Pet> petsIniciais = petController.listarPetsPorDono(clienteInicial, clientes);
            for (Pet p : petsIniciais) {
                comboPets.addItem(p.getNome());
            }
        }

        JButton btnContratar = new JButton("Contratar Serviço");

        btnContratar.addActionListener(e -> {
            int clienteIndex = comboClientes.getSelectedIndex();
            int petIndex = comboPets.getSelectedIndex();
            int servicoIndex = comboServicos.getSelectedIndex();

            if (clienteIndex == -1 || petIndex == -1 || servicoIndex == -1) {
                JOptionPane.showMessageDialog(this, "Preencha todos os campos.");
                return;
            }

            Cliente clienteSelecionado = clientes.get(clienteIndex);
            Pet petSelecionado = petController.listarPetsPorDono(clienteSelecionado, clientes).get(petIndex);

            String[] dadosServico = opcoesServicos[servicoIndex].split(" - ");
            String nome = dadosServico[0];
            String descricao = dadosServico[1];
            double preco = Double.parseDouble(dadosServico[2]);

            String resultado = servicoController.cadastrarServico(nome, descricao, preco, clienteSelecionado, petSelecionado);
            JOptionPane.showMessageDialog(this, resultado);
        });

        painel.add(new JLabel("Cliente:"));
        painel.add(comboClientes);
        painel.add(new JLabel("Pet:"));
        painel.add(comboPets);
        painel.add(new JLabel("Serviço:"));
        painel.add(comboServicos);
        painel.add(new JLabel(""));
        painel.add(btnContratar);

        add(painel);
        setVisible(true);
    }
}
