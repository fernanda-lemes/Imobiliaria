package dao;

import model.Imovel;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ImovelDAO {

    public void inserir(Imovel imovel) {
        String sql = "INSERT INTO Imovel (endereco, tipo, valorAluguel, disponivel) VALUES (?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, imovel.getEndereco());
            stmt.setString(2, imovel.getTipo());
            stmt.setDouble(3, imovel.getValorAluguel());
            stmt.setBoolean(4, imovel.isDisponivel());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Imovel> listarDisponiveis() {
        List<Imovel> lista = new ArrayList<>();
        String sql = "SELECT * FROM Imovel WHERE disponivel = true";
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Imovel i = new Imovel(
                        rs.getInt("id"),
                        rs.getString("endereco"),
                        rs.getString("tipo"),
                        rs.getDouble("valorAluguel"),
                        rs.getBoolean("disponivel")
                );
                lista.add(i);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public Imovel buscarPorId(int id) {
        String sql = "SELECT * FROM Imovel WHERE id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Imovel(
                        rs.getInt("id"),
                        rs.getString("endereco"),
                        rs.getString("tipo"),
                        rs.getDouble("valorAluguel"),
                        rs.getBoolean("disponivel")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void atualizar(Imovel imovel) {
        String sql = "UPDATE Imovel SET endereco=?, tipo=?, valorAluguel=?, disponivel=? WHERE id=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, imovel.getEndereco());
            stmt.setString(2, imovel.getTipo());
            stmt.setDouble(3, imovel.getValorAluguel());
            stmt.setBoolean(4, imovel.isDisponivel());
            stmt.setInt(5, imovel.getId());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void remover(int id) {
        String sql = "DELETE FROM Imovel WHERE id=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}