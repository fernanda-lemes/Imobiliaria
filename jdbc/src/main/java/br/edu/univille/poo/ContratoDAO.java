package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Contrato;
import util.Database;

public class ContratoDAO {
    public void criarTabela() {
        String sql = """
            CREATE TABLE IF NOT EXISTS contratos (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                id_imovel INTEGER,
                id_cliente INTEGER,
                valor REAL,
                data_inicio TEXT,
                data_fim TEXT,
                ativo INTEGER,
                FOREIGN KEY(id_imovel) REFERENCES imoveis(id),
                FOREIGN KEY(id_cliente) REFERENCES clientes(id)
            );
        """;
        try (Connection conn = Database.connect(); Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) { e.printStackTrace(); }
    }

    public void inserir(Contrato c) {
        String sql = "INSERT INTO contratos (id_imovel, id_cliente, valor, data_inicio, data_fim, ativo) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = Database.connect(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, c.getIdImovel());
            ps.setInt(2, c.getIdCliente());
            ps.setDouble(3, c.getValor());
            ps.setString(4, c.getDataInicio());
            ps.setString(5, c.getDataFim());
            ps.setInt(6, c.isAtivo() ? 1 : 0);
            ps.executeUpdate();
        } catch (SQLException e) { e.printStackTrace(); }
    }

    public List<Contrato> listarAtivos() {
        List<Contrato> lista = new ArrayList<>();
        String sql = "SELECT * FROM contratos WHERE ativo = 1";
        try (Connection conn = Database.connect(); Statement st = conn.createStatement(); ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                Contrato c = new Contrato();
                c.setId(rs.getInt("id"));
                c.setIdImovel(rs.getInt("id_imovel"));
                c.setIdCliente(rs.getInt("id_cliente"));
                c.setValor(rs.getDouble("valor"));
                c.setDataInicio(rs.getString("data_inicio"));
                c.setDataFim(rs.getString("data_fim"));
                c.setAtivo(rs.getInt("ativo") == 1);
                lista.add(c);
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return lista;
    }
}
