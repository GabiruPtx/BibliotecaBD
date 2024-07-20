package dao;

import beans.pedido;
import java.sql.Connection;
import conection.Conection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class pedidoDAO {
    
    private Conection conexao;
    private Connection conn;
    
    public pedidoDAO(){
        
        this.conexao = new Conection();
        this.conn = this.conexao.getConection();
        
    }
    
    public void solicitarEmprestimo(String tituloMaterial, String userName) {
        
        String sqlBuscaMaterial = "SELECT id FROM material WHERE Titulo = ?";
        String sqlBuscaExemplar = "SELECT id FROM exemplar WHERE material_id = ? AND status = 'DISPONIVEL' LIMIT 1";
        String sqlInserirPedido = "INSERT INTO pedido (tituloMaterial, usuario_Nome, exemplar_id, tipoPedido) VALUES (?, ?, ?, ?)";
        String titulo = tituloMaterial;
    try {
        conn.setAutoCommit(false);

        // Busca o ID do material pelo título
        int materialId = -1;
        try (PreparedStatement stmtMaterial = conn.prepareStatement(sqlBuscaMaterial)) {
            
            stmtMaterial.setString(1, tituloMaterial);
            try (ResultSet rsMaterial = stmtMaterial.executeQuery()) {
                
                if (rsMaterial.next()) {
                    
                    materialId = rsMaterial.getInt("id");
                    
                } else {
                    
                    throw new SQLException("Material não encontrado.");
                    
                }
            }
        }

        // Busca o exemplar disponível
        int exemplarId = -1;
        try (PreparedStatement stmtExemplar = conn.prepareStatement(sqlBuscaExemplar)) {
            
            stmtExemplar.setInt(1, materialId);
            try (ResultSet rsExemplar = stmtExemplar.executeQuery()) {
                
                if (rsExemplar.next()) {
                    
                    exemplarId = rsExemplar.getInt("id");
                    
                } else {
                    
                    throw new SQLException("Nenhum exemplar disponível encontrado.");
                    
                }
            }
        }

        // Insere um novo pedido
        try (PreparedStatement stmtPedido = conn.prepareStatement(sqlInserirPedido)) {
            
            stmtPedido.setString(1, titulo);
            stmtPedido.setString(2, userName);
            stmtPedido.setInt(3, exemplarId);
            stmtPedido.setString(4, "EMPRESTIMO");
            stmtPedido.executeUpdate();
        }

        conn.commit();
        System.out.println("Pedido registrado com sucesso!");

    } catch (SQLException e) {
        
        try {
            
            conn.rollback();
            
        } catch (SQLException ex) {
            
            ex.printStackTrace();
        }
        
        System.out.println("Erro ao requisitar pedido: " + e.getMessage());
        
    } finally {
        
        try {
            
            conn.setAutoCommit(true);
            
        } catch (SQLException e) {
            
            e.printStackTrace();
            
        }
    }
}

    public boolean checarPedidosPendentes() {
        String sqlBuscaPedidoPendente = "SELECT 1 FROM pedido WHERE status = 'PENDENTE' LIMIT 1";
        
        try (PreparedStatement stmt = conn.prepareStatement(sqlBuscaPedidoPendente);
             ResultSet rs = stmt.executeQuery()) {
             
            if (rs.next()) {
                return true; // Encontrou um pedido pendente
            }
        } catch (SQLException e) {
            System.out.println("Erro ao checar pedidos pendentes: " + e.getMessage());
        }
        
        return false; // Não encontrou nenhum pedido pendente
    }
    
    public pedido resgatarPedido(){
        
        String sql = "SELECT * FROM pedido WHERE status = 'PENDENTE' LIMIT 1";
        pedido pedido = null;
        
        try (PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
             
            if (rs.next()) {
                
                pedido = new pedido();
                pedido.setId(rs.getInt("id"));
                pedido.setTitulo(rs.getString("tituloMaterial"));
                pedido.setUserName(rs.getString("usuario_Nome"));
                pedido.setExemplarId(rs.getInt("exemplar_id"));
                pedido.setStatus(rs.getString("status"));
                pedido.setTipoPedido(rs.getString("tipoPedido"));
                
            }
        } catch (SQLException e) {
            
            System.out.println("Erro ao resgatar o pedido pendente: " + e.getMessage());
            
        }
        
        return pedido;
    }
    
}
