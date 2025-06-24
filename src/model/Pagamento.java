package model;

public class Pagamento {
    // Atributos
    private double valor;
    private String formaPagamento; // Ex: Dinheiro, Cartão, Pix
    private boolean pago;

    // Construtor
    public Pagamento(double valor, String formaPagamento, boolean pago) {
        this.valor = valor;
        this.formaPagamento = formaPagamento;
        this.pago = pago;
    }

    // Getters e Setters
    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public boolean isPago() {
        return pago;
    }

    public void setPago(boolean pago) {
        this.pago = pago;
    }

    // toString
    @Override
    public String toString() {
        return "Pagamento{" +
               "valor=" + valor +
               ", formaPagamento='" + formaPagamento + '\'' +
               ", pago=" + (pago ? "Sim" : "Não") +
               '}';
    }
}
