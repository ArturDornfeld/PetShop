package model;

import java.util.ArrayList;
import java.util.List;

public class PacoteServicos {
    private List<Servico> servicos;
    private double desconto; // ex: 0.10 para 10%

    public PacoteServicos(double desconto) {
        this.servicos = new ArrayList<>();
        this.desconto = desconto;
    }

    public void adicionarServico(Servico servico) {
        servicos.add(servico);
    }

    public boolean removerServico(Servico servico) {
        return servicos.remove(servico);
    }

    public double calcularTotalComDesconto() {
        double total = 0;
        for (Servico s : servicos) {
            total += s.getPreco();
        }
        return total * (1 - desconto);
    }

    public void exibirPacote() {
        System.out.println("Pacote de serviços:");
        for (Servico s : servicos) {
            s.exibirInformacoes();
        }
        System.out.printf("Total com desconto: R$%.2f%n", calcularTotalComDesconto());
    }
}
