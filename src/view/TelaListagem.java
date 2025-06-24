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

        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JTextArea areaTexto = new JTextArea();
        areaTexto.setEditable(false);
        JScrollPane scroll = new JScrollPane(areaTexto);
        add(scroll);

        StringBuilder sb = new StringBuilder();

        List<Cliente> clientes = clienteController.listarClientes();

        sb.append("📋 CLIENTES:\n");
        for (Cliente c : clientes) {
            sb.append("- ").append(c.getNome()).append(" (CPF: ").append(c.getCpf()).append(")\n");

            List<Pet> pets = petController.listarPets(c.getCpf());
            for (Pet p : pets) {
                sb.append("  🐾 Pet: ").append(p.getNome()).append(" - ").append(p.getEspecie()).append("\n");
            }

            List<Servico> servicos = servicoController.listarServicos();
            for (Servico s : servicos) {
                if (s.getCliente().getCpf().equals(c.getCpf())) {
                    sb.append("  💼 Serviço: ").append(s.getNome()).append(" para ").append(s.getPet().getNome()).append("\n");
                }
            }
        }

        areaTexto.setText(sb.toString());
        setVisible(true);
    }
}
