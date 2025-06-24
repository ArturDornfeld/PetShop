package model;

public class Servico {
    private String nome;
    private String descricao;
    private double preco;
    private Cliente cliente;
    private Pet pet;

    public Servico(String nome, String descricao, double preco, Cliente cliente, Pet pet) {
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.cliente = cliente;
        this.pet = pet;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getPreco() {
        return preco;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Pet getPet() {
        return pet;
    }

    // Usado para salvar no arquivo
    public String toLinhaArquivo() {
        return nome + ";" + descricao + ";" + preco + ";" +
               cliente.getCpf() + ";" + pet.getNome();
    }

    // Usado para ler do arquivo
    public static Servico fromLinhaArquivo(String linha, java.util.List<Cliente> clientes, java.util.List<Pet> pets) {
        String[] partes = linha.split(";");
        if (partes.length < 5) return null;

        String nome = partes[0];
        String descricao = partes[1];
        double preco = Double.parseDouble(partes[2]);
        String cpfCliente = partes[3];
        String nomePet = partes[4];

        Cliente cliente = null;
        for (Cliente c : clientes) {
            if (c.getCpf().equals(cpfCliente)) {
                cliente = c;
                break;
            }
        }

        Pet pet = null;
        for (Pet p : pets) {
            if (p.getNome().equals(nomePet) && p.getDono().getCpf().equals(cpfCliente)) {
                pet = p;
                break;
            }
        }

        if (cliente == null || pet == null) return null;

        return new Servico(nome, descricao, preco, cliente, pet);
    }

    @Override
    public String toString() {
        return "Serviço: " + nome + " | Preço: R$ " + preco + "\n" +
               "Descrição: " + descricao + "\n" +
               "Cliente: " + cliente.getNome() + " | Pet: " + pet.getNome();
    }
}
