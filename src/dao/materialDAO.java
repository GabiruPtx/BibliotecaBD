package dao;

import beans.material;
import conection.Conection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class materialDAO {
    
    private Conection conexao;
    private Connection conn;
    
    public materialDAO(){
    
        this.conexao = new Conection();
        this.conn = this.conexao.getConection();
        
    }
    
    public void cadastrarLivro(material material) {
    String sql = "INSERT INTO material (Titulo, Ano_publicacao, Resumo, Qnt_exemplares, Autor, Tipo)" +
                 " VALUES (?, ?, ?, ?, ?, ?)";
    String sql3 = "INSERT INTO livro (id, editora, genero)" +
                  " VALUES (?, ?, ?)";

    try {
        conn.setAutoCommit(false); // Inicia a transação

        // Insere o material e obtém o ID gerado
        PreparedStatement stmt = this.conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        stmt.setString(1, material.getTítulo());
        stmt.setString(2, material.getAnoPublicacao());
        stmt.setString(3, material.getResumo());
        stmt.setInt(4, material.getQntExemplares());
        stmt.setString(5, material.getAutor());
        stmt.setString(6, material.getTipo());
        stmt.executeUpdate();

        ResultSet rs = stmt.getGeneratedKeys();
        int materialId = 0;
        if (rs.next()) {
            materialId = rs.getInt(1);
        }
        rs.close();
        stmt.close();

        // Insere na tabela livro
        PreparedStatement stmt3 = this.conn.prepareStatement(sql3);
        stmt3.setInt(1, materialId);
        stmt3.setString(2, material.getEditora());
        stmt3.setString(3, material.getGenero());
        stmt3.executeUpdate();
        stmt3.close();

        conn.commit(); // Finaliza a transação
    } catch (Exception e) {
        try {
            conn.rollback(); // Desfaz a transação em caso de erro
        } catch (SQLException ex) {
            System.out.println("Erro ao fazer rollback: " + ex.getMessage());
        }
        System.out.println("Erro ao inserir livro: " + e.getMessage());
    } finally {
        try {
            conn.setAutoCommit(true); // Restaura o modo padrão de commit automático
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

    
    public void cadastrarArtigo(material material) {
    String sql = "INSERT INTO material (Titulo, Ano_publicacao, Resumo, Qnt_exemplares, Autor, Tipo)" +
                 " VALUES (?, ?, ?, ?, ?, ?)";
    String sql2 = "INSERT INTO artigo (id, revista, volume)" +
                  " VALUES (?, ?, ?)";

    try {
        conn.setAutoCommit(false); // Inicia a transação

        // Insere o material e obtém o ID gerado
        PreparedStatement stmt = this.conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        stmt.setString(1, material.getTítulo());
        stmt.setString(2, material.getAnoPublicacao());
        stmt.setString(3, material.getResumo());
        stmt.setInt(4, material.getQntExemplares());
        stmt.setString(5, material.getAutor());
        stmt.setString(6, material.getTipo());
        stmt.executeUpdate();

        ResultSet rs = stmt.getGeneratedKeys();
        int materialId = 0;
        if (rs.next()) {
            materialId = rs.getInt(1);
        }
        rs.close();
        stmt.close();

        // Insere na tabela artigo
        PreparedStatement stmt2 = this.conn.prepareStatement(sql2);
        stmt2.setInt(1, materialId);
        stmt2.setString(2, material.getRevista());
        stmt2.setInt(3, material.getVolume());
        stmt2.executeUpdate();
        stmt2.close();

        conn.commit(); // Finaliza a transação
    } catch (Exception e) {
        try {
            conn.rollback(); // Desfaz a transação em caso de erro
        } catch (SQLException ex) {
            System.out.println("Erro ao fazer rollback: " + ex.getMessage());
        }
        System.out.println("Erro ao inserir artigo: " + e.getMessage());
    } finally {
        try {
            conn.setAutoCommit(true); // Restaura o modo padrão de commit automático
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

    
}
