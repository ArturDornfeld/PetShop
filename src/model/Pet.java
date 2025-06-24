package model;

public class Pet {
    // Atributos
    private String nome;
    private String especie;
    private String raca;
    private Cliente dono;

    // Construtor
    public Pet(String nome, String especie, String raca, Cliente dono) {
        this.nome = nome;
        this.especie = especie;
        this.raca = raca;
        this.dono = dono;
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public Cliente getDono() {
        return dono;
    }

    public void setDono(Cliente dono) {
        this.dono = dono;
    }

    // Representação do objeto como string
    @Override
    public String toString() {
        return "Pet{" +
               "nome='" + nome + '\'' +
               ", especie='" + especie + '\'' +
               ", raca='" + raca + '\'' +
               ", dono='" + dono.getNome() + '\'' +
               '}';
    }
}
