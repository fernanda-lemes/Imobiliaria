package dao;

import model.Contrato;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ContratoDAO {

    public void inserir(Contrato contrato) {
        String sql = "INSERT INTO Contrato (idCliente, idImovel, dataInicio, dataFim, valor) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, contrato.getIdCliente());
            stmt.setInt(2, contrato.getIdImovel());
            stmt.setDate(3, Date.valueOf(contrato.getDataInicio()));
            stmt.setDate(4, Date.valueOf(contrato.getDataFim()));
            stmt.setDouble(5, contrato.getValor());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Contrato> listarTodos() {
        List<Contrato> lista = new ArrayList<>();
        String sql = "SELECT * FROM Contrato";
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Contrato c = new Contrato(
                        rs.getInt("id"),
                        rs.getInt("idCliente"),
                        rs.getInt("idImovel"),
                        rs.getDate("dataInicio").toLocalDate(),
                        rs.getDate("dataFim").toLocalDate(),
                        rs.getDouble("valor")
                );
                lista.add(c);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public List<Contrato> listarAtivos() {
        List<Contrato> lista = new ArrayList<>();
        String sql = "SELECT * FROM Contrato WHERE dataFim >= CURDATE()";
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Contrato c = new Contrato(
                        rs.getInt("id"),
                        rs.getInt("idCliente"),
                        rs.getInt("idImovel"),
                        rs.getDate("dataInicio").toLocalDate(),
                        rs.getDate("dataFim").toLocalDate(),
                        rs.getDouble("valor")
                );
                lista.add(c);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public List<Contrato> contratosExpirandoProximos30Dias() {
        List<Contrato> lista = new ArrayList<>();
        String sql = "SELECT * FROM Contrato WHERE dataFim BETWEEN CURDATE() AND DATE_ADD(CURDATE(), INTERVAL 30 DAY)";
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Contrato c = new Contrato(
                        rs.getInt("id"),
                        rs.getInt("idCliente"),
                        rs.getInt("idImovel"),
                        rs.getDate("dataInicio").toLocalDate(),
                        rs.getDate("dataFim").toLocalDate(),
                        rs.getDouble("valor")
                );
                lista.add(c);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
}