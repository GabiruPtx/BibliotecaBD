package dao;

import beans.emprestimo;
import beans.pedido;
import java.sql.Connection;
import conection.Conection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class emprestimoDAO {
    
    private Conection conexao;
    private Connection conn;
    
    public emprestimoDAO(){
        
        this.conexao = new Conection();
        this.conn = this.conexao.getConection();
        
    }
    
    public emprestimo checarChances(int idEmprestimo) {
    
    String sql = "SELECT chancesRenovacao FROM emprestimo WHERE id = ?";
    emprestimo e = null;

    try {
        
        PreparedStatement stmt = this.conn.prepareStatement(sql);
        stmt.setInt(1, idEmprestimo);  // Define o parâmetro da consulta
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {  // Usa if em vez de while para garantir que apenas um resultado seja processado
            
            e = new emprestimo();
            e.setChancesDePrazo(rs.getInt("chancesRenovacao"));
            
        }
        
    } catch (Exception ex) {
        
        ex.printStackTrace();
        
    }

    return e;  // Retorna o objeto emprestimo, que pode ser null se não houver resultado
    
}

    public boolean autorizarEmprestimo(pedido pedido){
        
        String sqlInserirEmprestimo = "INSERT INTO emprestimo (id ,exemplar_id, tituloMaterial, UINome, UENome, dataEmprestimo, dataDevolucao, chancesRenovacao) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
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
            
            if( pedido.getTipoUsuario().equals("Aluno")){
                
                stmt.setInt(8, 2);
                
            }else{
                
                stmt.setInt(8, 4);
                
            }
            
            stmt.executeUpdate();
            
        }

        conn.commit();
        System.out.println("Empréstimo registrado com sucesso!");
        
        return true;
        
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
        return false;
    }
    
    public boolean estenderPrazo(pedido pedido){
        
        String sqlAtualizarData = "UPDATE emprestimo SET dataDevolucao = DATE_ADD(dataDevolucao, INTERVAL ? DAY), chancesRenovacao = chancesRenovacao - 1 WHERE id = ?";

    try {
        conn.setAutoCommit(false);

        try (PreparedStatement stmt = conn.prepareStatement(sqlAtualizarData)) {
            System.out.println(pedido.getExtensaoPrazo());
            System.out.println(pedido.getIdEmprestimo());
            stmt.setInt(1, pedido.getExtensaoPrazo());
            stmt.setInt(2, pedido.getIdEmprestimo());

            int linhasAfetadas = stmt.executeUpdate();

            if (linhasAfetadas > 0) {
                
                System.out.println("Data de devolução atualizada com sucesso!");
                return true;
                
            } else {
                
                System.out.println("Nenhum empréstimo encontrado com o ID fornecido.");
                
            }

            conn.commit();
            
        } catch (SQLException e) {
            
            conn.rollback();
            System.out.println("Erro ao atualizar a data de devolução: " + e.getMessage());
            
        }
        
    } catch (SQLException e) {
        
        System.out.println("Erro na conexão: " + e.getMessage());
        
    } finally {
        
        try {
            
            conn.setAutoCommit(true);
            
        } catch (SQLException e) {
            
            System.out.println("Erro ao definir auto-commit: " + e.getMessage());
        }
    }
        return false;
    }
    
    public List<emprestimo> preencherTabelaEmprestimo() {
    
        String sql = "SELECT * FROM emprestimo";

    try {
        
        PreparedStatement stmt = this.conn.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        List<emprestimo> listaEmprestimo = new ArrayList<>();
        while (rs.next()) {
            
            emprestimo e = new emprestimo();
            e.setId(rs.getInt("id"));
            e.setExemplarId(rs.getInt("exemplar_id"));
            e.setTitulo(rs.getString("tituloMaterial"));
            e.setUINome(rs.getString("UINome"));
            e.setUENome(rs.getString("UENome"));
            e.setDataEmprestimo(rs.getDate("dataEmprestimo"));
            e.setDataDevolucao(rs.getDate("dataDevolucao"));
            e.setChancesDePrazo(rs.getInt("chancesRenovacao"));
            
            // Obter as datas do ResultSet e converter para LocalDate
            LocalDate dataEmprestimo = rs.getDate("dataEmprestimo").toLocalDate();
            LocalDate dataDevolucao = rs.getDate("dataDevolucao").toLocalDate();
                
            // Calcular a diferença em dias
            long diferencaDias = ChronoUnit.DAYS.between(LocalDate.now(), dataDevolucao);
                
            // Atualizar o status com base na diferença de dias
            if (diferencaDias >= 0) {
                
                e.setStatus("ATIVO");
                
            } else {
                
                e.setStatus("EXPIRADO");
                
            }
            
            
            listaEmprestimo.add(e);
        }
        return listaEmprestimo;
        
    } catch (Exception ex) {
        
        ex.printStackTrace();
        return null;
        
    }
}
    
    public List<emprestimo> preencherTabelaEmprestimoUsuario(String usuario) {
    
        String sql = "SELECT * FROM emprestimo WHERE UENome = ?";

    try {
        
        PreparedStatement stmt = this.conn.prepareStatement(sql);
        stmt.setString(1, usuario);
        ResultSet rs = stmt.executeQuery();
        List<emprestimo> listaEmprestimo = new ArrayList<>();
        while (rs.next()) {
            
            emprestimo e = new emprestimo();
            e.setId(rs.getInt("id"));
            e.setExemplarId(rs.getInt("exemplar_id"));
            e.setTitulo(rs.getString("tituloMaterial"));
            e.setUINome(rs.getString("UINome"));
            e.setUENome(rs.getString("UENome"));
            e.setDataEmprestimo(rs.getDate("dataEmprestimo"));
            e.setDataDevolucao(rs.getDate("dataDevolucao"));
            e.setChancesDePrazo(rs.getInt("chancesRenovacao"));
            
            // Obter as datas do ResultSet e converter para LocalDate
            LocalDate dataEmprestimo = rs.getDate("dataEmprestimo").toLocalDate();
            LocalDate dataDevolucao = rs.getDate("dataDevolucao").toLocalDate();
                
            // Calcular a diferença em dias
            long diferencaDias = ChronoUnit.DAYS.between(LocalDate.now(), dataDevolucao);
                
            // Atualizar o status com base na diferença de dias
            if (diferencaDias >= 0) {
                
                e.setStatus("ATIVO");
                
            } else {
                
                e.setStatus("EXPIRADO");
                
            }
            
            
            listaEmprestimo.add(e);
        }
        return listaEmprestimo;
        
    } catch (Exception ex) {
        
        ex.printStackTrace();
        return null;
        
    }
}
    
}
