package view;

import controller.PetController;
import model.Cliente;

import javax.swing.*;
import java.awt.*;

public class TelaCadastroPet extends JFrame {
    private JTextField campoNome, campoEspecie, campoRaca;
    private JTextField campoDono; // Nome do dono (simulação)
    private JTextArea resultado;
    private PetController petController;

    public TelaCadastroPet() {
        super("Cadastro de Pet");

        petController = new PetController();

        setLayout(new BorderLayout());

        // Painel de formulário
        JPanel formulario = new JPanel(new GridLayout(5, 2));

        formulario.add(new JLabel("Nome:"));
        campoNome = new JTextField();
        formulario.add(campoNome);

        formulario.add(new JLabel("Espécie:"));
        campoEspecie = new JTextField();
        formulario.add(campoEspecie);

        formulario.add(new JLabel("Raça:"));
        campoRaca = new JTextField();
        formulario.add(campoRaca);

        formulario.add(new JLabel("Nome do Dono:"));
        campoDono = new JTextField();
        formulario.add(campoDono);

        // Botão Cadastrar
        JButton botaoCadastrar = new JButton("Cadastrar");
        botaoCadastrar.addActionListener(e -> cadastrarPet());
        formulario.add(botaoCadastrar);

        // Botão Limpar
        JButton botaoLimpar = new JButton("Limpar");
        botaoLimpar.addActionListener(e -> limparCampos());
        formulario.add(botaoLimpar);

        add(formulario, BorderLayout.NORTH);

        resultado = new JTextArea(10, 30);
        resultado.setEditable(false);
        add(new JScrollPane(resultado), BorderLayout.CENTER);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        pack();
        setVisible(true);
    }

    private void cadastrarPet() {
        String nome = campoNome.getText();
        String especie = campoEspecie.getText();
        String raca = campoRaca.getText();
        String nomeDono = campoDono.getText();

        // Cliente fictício (simulação)
        Cliente clienteFicticio = new Cliente(nomeDono, "00000000000", nomeDono + "@email.com", "11999999999");

        String msg = petController.cadastrarPet(nome, especie, raca, clienteFicticio);
        resultado.setText(msg + "\n");

        if (msg.equals("Pet cadastrado com sucesso.")) {
            for (var pet : petController.listarPets()) {
                resultado.append(pet.toString() + "\n");
            }
        }
    }

    private void limparCampos() {
        campoNome.setText("");
        campoEspecie.setText("");
        campoRaca.setText("");
        campoDono.setText("");
        resultado.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(TelaCadastroPet::new);
    }
}
