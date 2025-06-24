package model;

public class Pet {
    private String nome;
    private String especie;
    private String raca;
    private Cliente dono;

    public Pet(String nome, String especie, String raca, Cliente dono) {
        this.nome = nome;
        this.especie = especie;
        this.raca = raca;
        this.dono = dono;
    }

    public String getNome() {
        return nome;
    }

    public String getEspecie() {
        return especie;
    }

    public String getRaca() {
        return raca;
    }

    public Cliente getDono() {
        return dono;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public void setDono(Cliente dono) {
        this.dono = dono;
    }

    // Usado para salvar o pet em arquivo
    public String toLinhaArquivo() {
        return nome + ";" + especie + ";" + raca + ";" + dono.getCpf();
    }

    // Usado para ler o pet do arquivo
    public static Pet fromLinhaArquivo(String linha, java.util.List<Cliente> clientes) {
        String[] partes = linha.split(";");
        if (partes.length < 4) return null;

        String nome = partes[0];
        String especie = partes[1];
        String raca = partes[2];
        String cpfDono = partes[3];

        Cliente dono = null;
        for (Cliente c : clientes) {
            if (c.getCpf().equals(cpfDono)) {
                dono = c;
                break;
            }
        }

        if (dono == null) return null;

        return new Pet(nome, especie, raca, dono);
    }

    @Override
    public String toString() {
        return "Pet: " + nome + " | Espécie: " + especie + " | Raça: " + raca +
               " | Dono: " + dono.getNome() + " (" + dono.getCpf() + ")";
    }
}
