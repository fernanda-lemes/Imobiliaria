package br.edu.univille.poo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Hello world!
 *
 */
public class Main {

    public static void main( String[] args ) {
        String url = "jdbc:mysql://localhost:3306/poo_2_b";
        String user = "root";
        String password = "univille";
        try {
            Connection con = DriverManager.getConnection(url,user,password);
            System.out.println("Conectou!");
            Statement st = con.createStatement();
            String sql = "insert into pessoa(nome,cpf) values('Senna','123456789');";
            st.execute(sql);
        } catch (SQLException e) {
            System.out.println("Deu erro!");
            e.printStackTrace();
        }
    }

}
