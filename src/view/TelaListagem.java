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

public class TelaListagem extends JFrame {

    public TelaListagem(ClienteController clienteController, PetController petController, ServicoController servicoController) {
        super("Listagem Geral");

        setSize(500, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JTextArea areaTexto = new JTextArea();
        areaTexto.setEditable(false);
        areaTexto.setFont(new Font("Monospaced", Font.PLAIN, 12));

        StringBuilder sb = new StringBuilder();

        // Listar Clientes
        sb.append("=== CLIENTES ===\n");
        List<Cliente> clientes = clienteController.listarClientes();
        if (clientes.isEmpty()) {
            sb.append("Nenhum cliente cadastrado.\n");
        } else {
            for (Cliente c : clientes) {
                sb.append(c).append("\n");
            }
        }

        // Listar Pets (usando os clientes!)
        sb.append("\n=== PETS ===\n");
        List<Pet> pets = petController.listarPets(clientes);
        if (pets.isEmpty()) {
            sb.append("Nenhum pet cadastrado.\n");
        } else {
            for (Pet p : pets) {
                sb.append(p).append("\n");
            }
        }

        // Listar Serviços
        sb.append("\n=== SERVIÇOS ===\n");
        List<Servico> servicos = servicoController.listarServicos(clientes, pets);
        if (servicos.isEmpty()) {
            sb.append("Nenhum serviço contratado.\n");
        } else {
            for (Servico s : servicos) {
                sb.append(s).append("\n");
            }
        }

        areaTexto.setText(sb.toString());
        JScrollPane scrollPane = new JScrollPane(areaTexto);
        add(scrollPane);

        setVisible(true);
    }
}
