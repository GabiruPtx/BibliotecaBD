package dao;

import beans.pedido;
import java.sql.Connection;
import conection.Conection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class emprestimoDAO {
    
    private Conection conexao;
    private Connection conn;
    
    public emprestimoDAO(){
        
        this.conexao = new Conection();
        this.conn = this.conexao.getConection();
        
    }
    
    public void autorizarEmprestimo(pedido pedido){
        
        String sqlInserirEmprestimo = "INSERT INTO emprestimo (id ,exemplar_id, tituloMaterial, UINome, UENome, dataEmprestimo, dataDevolucao) VALUES (?, ?, ?, ?, ?, ?, ?)";
        LocalDate dataEmprestimo = LocalDate.now();
        LocalDate dataDevolucao = dataEmprestimo.plus(7, ChronoUnit.DAYS);
        
        
        try {
        conn.setAutoCommit(false);

        try (PreparedStatement stmt = conn.prepareStatement(sqlInserirEmprestimo)) {
            
            stmt.setInt(1, pedido.getId());
            stmt.setInt(2, pedido.getExemplarId());
            stmt.setString(3, pedido.getTitulo());
            stmt.setString(4, System.getProperty("nomeCompleto"));
            stmt.setString(5, pedido.getUserName());
            stmt.setDate(6, java.sql.Date.valueOf(dataEmprestimo));
            stmt.setDate(7, java.sql.Date.valueOf(dataDevolucao));
            stmt.executeUpdate();
            
        }

        conn.commit();
        System.out.println("Empréstimo registrado com sucesso!");

    } catch (SQLException e) {
        
        try {
            
            conn.rollback();
            
        } catch (SQLException ex) {
            
            ex.printStackTrace();
        }
        
        System.out.println("Erro ao registrar empréstimo: " + e.getMessage());
        
    } finally {
        
        try {
            
            conn.setAutoCommit(true);
            
        } catch (SQLException e) {
            
            e.printStackTrace();
            
        }
    }
        
    }
    
}
