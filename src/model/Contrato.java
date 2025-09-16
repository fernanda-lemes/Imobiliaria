package model;

import java.time.LocalDate;

public class Contrato {
    private int id;
    private int idCliente;
    private int idImovel;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private double valor;

    public Contrato() {}

    public Contrato(int id, int idCliente, int idImovel, LocalDate dataInicio, LocalDate dataFim, double valor) {
        this.id = id;
        this.idCliente = idCliente;
        this.idImovel = idImovel;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.valor = valor;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getIdCliente() { return idCliente; }
    public void setIdCliente(int idCliente) { this.idCliente = idCliente; }

    public int getIdImovel() { return idImovel; }
    public void setIdImovel(int idImovel) { this.idImovel = idImovel; }

    public LocalDate getDataInicio() { return dataInicio; }
    public void setDataInicio(LocalDate dataInicio) { this.dataInicio = dataInicio; }

    public LocalDate getDataFim() { return dataFim; }
    public void setDataFim(LocalDate dataFim) { this.dataFim = dataFim; }

    public double getValor() { return valor; }
    public void setValor(double valor) { this.valor = valor; }

    @Override
    public String toString() {
        return "Contrato [id=" + id + ", idCliente=" + idCliente + ", idImovel=" + idImovel
                + ", dataInicio=" + dataInicio + ", dataFim=" + dataFim + ", valor=" + valor + "]";
    }
}