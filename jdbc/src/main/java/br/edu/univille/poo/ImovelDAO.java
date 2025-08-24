package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Imovel;
import util.Database;

public class ImovelDAO {
    public void criarTabela() {
        String sql = """
            CREATE TABLE IF NOT EXISTS imoveis (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                endereco TEXT,
                tipo TEXT,
                quartos INTEGER,
                banheiros INTEGER,
                valor REAL,
                status TEXT
            );
        """;
        try (Connection conn = Database.connect(); Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) { e.printStackTrace(); }
    }

    public void inserir(Imovel imovel) {
        String sql = "INSERT INTO imoveis (endereco, tipo, quartos, banheiros, valor, status) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = Database.connect(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, imovel.getEndereco());
            ps.setString(2, imovel.getTipo());
            ps.setInt(3, imovel.getQuartos());
            ps.setInt(4, imovel.getBanheiros());
            ps.setDouble(5, imovel.getValor());
            ps.setString(6, imovel.getStatus());
            ps.executeUpdate();
        } catch (SQLException e) { e.printStackTrace(); }
    }

    public void atualizarStatus(int id, String status) {
        String sql = "UPDATE imoveis SET status = ? WHERE id = ?";
        try (Connection conn = Database.connect(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, status);
            ps.setInt(2, id);
            ps.executeUpdate();
        } catch (SQLException e) { e.printStackTrace(); }
    }

    public List<Imovel> listarDisponiveis() {
        List<Imovel> lista = new ArrayList<>();
        String sql = "SELECT * FROM imoveis WHERE status = 'disponível'";
        try (Connection conn = Database.connect(); Statement st = conn.createStatement(); ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                Imovel i = new Imovel();
                i.setId(rs.getInt("id"));
                i.setEndereco(rs.getString("endereco"));
                i.setTipo(rs.getString("tipo"));
                i.setQuartos(rs.getInt("quartos"));
                i.setBanheiros(rs.getInt("banheiros"));
                i.setValor(rs.getDouble("valor"));
                i.setStatus(rs.getString("status"));
                lista.add(i);
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return lista;
    }
}
