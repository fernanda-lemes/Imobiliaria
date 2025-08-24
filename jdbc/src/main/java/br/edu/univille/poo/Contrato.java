package model;

public class Contrato {
    private int id;
    private int idImovel;
    private int idCliente;
    private double valor;
    private String dataInicio;
    private String dataFim;
    private boolean ativo;

    public Contrato(int idImovel, int idCliente, double valor, String dataInicio, String dataFim, boolean ativo) {
        this.idImovel = idImovel;
        this.idCliente = idCliente;
        this.valor = valor;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.ativo = ativo;
    }

    public Contrato() {}

    // getters e setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public int getIdImovel() { return idImovel; }
    public void setIdImovel(int idImovel) { this.idImovel = idImovel; }
    public int getIdCliente() { return idCliente; }
    public void setIdCliente(int idCliente) { this.idCliente = idCliente; }
    public double getValor() { return valor; }
    public void setValor(double valor) { this.valor = valor; }
    public String getDataInicio() { return dataInicio; }
    public void setDataInicio(String dataInicio) { this.dataInicio = dataInicio; }
    public String getDataFim() { return dataFim; }
    public void setDataFim(String dataFim) { this.dataFim = dataFim; }
    public boolean isAtivo() { return ativo; }
    public void setAtivo(boolean ativo) { this.ativo = ativo; }
}
