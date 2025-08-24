package model;

public class Imovel {
    private int id;
    private String endereco;
    private String tipo;
    private int quartos;
    private int banheiros;
    private double valor;
    private String status; // disponível / alugado

    public Imovel(String endereco, String tipo, int quartos, int banheiros, double valor, String status) {
        this.endereco = endereco;
        this.tipo = tipo;
        this.quartos = quartos;
        this.banheiros = banheiros;
        this.valor = valor;
        this.status = status;
    }

    public Imovel() {}

    // getters e setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getEndereco() { return endereco; }
    public void setEndereco(String endereco) { this.endereco = endereco; }
    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }
    public int getQuartos() { return quartos; }
    public void setQuartos(int quartos) { this.quartos = quartos; }
    public int getBanheiros() { return banheiros; }
    public void setBanheiros(int banheiros) { this.banheiros = banheiros; }
    public double getValor() { return valor; }
    public void setValor(double valor) { this.valor = valor; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
