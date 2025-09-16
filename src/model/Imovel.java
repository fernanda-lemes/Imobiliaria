package model;

public class Imovel {
    private int id;
    private String endereco;
    private String tipo;
    private double valorAluguel;
    private boolean disponivel;

    public Imovel() {}

    public Imovel(int id, String endereco, String tipo, double valorAluguel, boolean disponivel) {
        this.id = id;
        this.endereco = endereco;
        this.tipo = tipo;
        this.valorAluguel = valorAluguel;
        this.disponivel = disponivel;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getEndereco() { return endereco; }
    public void setEndereco(String endereco) { this.endereco = endereco; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public double getValorAluguel() { return valorAluguel; }
    public void setValorAluguel(double valorAluguel) { this.valorAluguel = valorAluguel; }

    public boolean isDisponivel() { return disponivel; }
    public void setDisponivel(boolean disponivel) { this.disponivel = disponivel; }

    @Override
    public String toString() {
        return "Imovel [id=" + id + ", endereco=" + endereco + ", tipo=" + tipo + ", valorAluguel=" + valorAluguel
                + ", disponivel=" + disponivel + "]";
    }
}