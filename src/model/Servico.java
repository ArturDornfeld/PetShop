package model;

public abstract class Servico {
    private String tipoServico;
    private double preco;

    public Servico(String tipoServico, double preco) {
        this.tipoServico = tipoServico;
        this.preco = preco;
    }

    /* gets */
    public String getTipoServico() {
        return tipoServico;
    }

    public double getPreco() {
        return preco;
    }

    /* sets */
    public void setTipoServico(String tipoServico) {
        this.tipoServico = tipoServico;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    /* métodos */
    public void exibirInformacoes() {
        System.out.println("Serviço: " + tipoServico);
        System.out.printf("Preço: R$%.2f%n", preco);
    }

    public String toString() {
        return String.format("Servico[tipo=%s, preco=%.2f]", tipoServico, preco);
    }
}
