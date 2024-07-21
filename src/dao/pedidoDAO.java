package dao;

import beans.emprestimo;
import beans.pedido;
import java.sql.Connection;
import conection.Conection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

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
        String sql = "SELECT tipo FROM usuário WHERE nomeCompleto = ?";
        String sqlInserirPedido = "INSERT INTO pedido (tituloMaterial, usuario_Nome, exemplar_id, tipoPedido, tipoUsuario) VALUES (?, ?, ?, ?, ?)";
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
        
        //Busca tipo do usuário.
        String userTipo  = null;
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, userName);
            
            try (ResultSet rs = stmt.executeQuery()) {
                
                if (rs.next()) {
                    
                    userTipo = rs.getString("tipo");
                    
                } else {
                    
                    throw new SQLException("Tipo não encontrado.");
                    
                }
            }
        }

        // Insere um novo pedido
        try (PreparedStatement stmtPedido = conn.prepareStatement(sqlInserirPedido)) {
            
            stmtPedido.setString(1, titulo);
            stmtPedido.setString(2, userName);
            stmtPedido.setInt(3, exemplarId);
            stmtPedido.setString(4, "EMPRESTIMO");
            stmtPedido.setString(5, userTipo);
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
                pedido.setExtensaoPrazo(rs.getInt("extensaoPrazo"));
                pedido.setIdEmprestimo(rs.getInt("idEmprestimo"));
                pedido.setTipoUsuario(rs.getString("tipoUsuario"));
                
            }
        } catch (SQLException e) {
            
            System.out.println("Erro ao resgatar o pedido pendente: " + e.getMessage());
            
        }
        
        return pedido;
    }
    
    public void autorizarPedido(pedido pedido){
        
        String sql = "UPDATE pedido SET status = 'AUTORIZADO' WHERE id = ?";
        
        try {
        conn.setAutoCommit(false);

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, pedido.getId());
            stmt.executeUpdate();
            
        }

        conn.commit();
        System.out.println("Status de pedido atualizado!");

    } catch (SQLException e) {
        
        try {
            
            conn.rollback();
            
        } catch (SQLException ex) {
            
            ex.printStackTrace();
        }
        
        System.out.println("Erro ao atualizar status: " + e.getMessage());
        
    } finally {
        
        try {
            
            conn.setAutoCommit(true);
            
        } catch (SQLException e) {
            
            e.printStackTrace();
            
        }
    }
        
    }
    
    public void solicitarExtensão(int id, String DiasPrazo){
        
        String sqlBuscaEmprestimo = "SELECT * FROM emprestimo WHERE id = ?";
        String sqlInserirPedido = "INSERT INTO pedido (tituloMaterial, usuario_Nome, exemplar_id, tipoPedido, idEmprestimo, extensaoPrazo, tipoUsuario) VALUES (?, ?, ?, ?, ?, ?, ?)";
        String sql = "SELECT tipo FROM usuário WHERE nomeCompleto = ?";
        
        try {
        conn.setAutoCommit(false);

        emprestimo emprestimo = null;
        
        //Buscar o empréstimo solicitado
        try (PreparedStatement stmt = conn.prepareStatement(sqlBuscaEmprestimo)) {
            
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                
                if (rs.next()) {
                    
                    emprestimo = new emprestimo();
                    emprestimo.setId(rs.getInt("id"));
                    emprestimo.setExemplarId(rs.getInt("exemplar_id"));
                    emprestimo.setTitulo(rs.getString("tituloMaterial"));
                    emprestimo.setUINome(rs.getString("UINome"));
                    emprestimo.setUENome(rs.getString("UENome"));
                    emprestimo.setDataEmprestimo(rs.getDate("dataEmprestimo"));
                    emprestimo.setDataDevolucao(rs.getDate("dataDevolucao"));
                    
                    
                } else {
                    
                    JOptionPane.showMessageDialog(null, "Id do empréstimo não é válido.", "Erro", JOptionPane.ERROR_MESSAGE);
                    
                }
            }
        }
        
        String userTipo  = null;
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, emprestimo.getUENome());
            
            try (ResultSet rs = stmt.executeQuery()) {
                
                if (rs.next()) {
                    
                    userTipo = rs.getString("tipo");
                    
                } else {
                    
                    throw new SQLException("Tipo não encontrado.");
                    
                }
            }
        }
        
        // Insere um novo pedido
        try (PreparedStatement stmtPedido = conn.prepareStatement(sqlInserirPedido)) {
            
            stmtPedido.setString(1, emprestimo.getTitulo());
            stmtPedido.setString(2, emprestimo.getUENome());
            stmtPedido.setInt(3, emprestimo.getExemplarId());
            stmtPedido.setString(4, "PRAZO");
            stmtPedido.setInt(5, emprestimo.getId());
            stmtPedido.setInt(6, Integer.parseInt(DiasPrazo));
            stmtPedido.setString(7, userTipo);
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
    
    public boolean rejeitarPedido(pedido pedido){
        
        String sql = "UPDATE pedido SET status = 'REJEITADO' WHERE id = ?";
        
        try {
        conn.setAutoCommit(false);

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, pedido.getId());
            stmt.executeUpdate();
            
        }

        conn.commit();
        System.out.println("Status de pedido atualizado!");
        return true;
        
    } catch (SQLException e) {
        
        try {
            
            conn.rollback();
            
        } catch (SQLException ex) {
            
            ex.printStackTrace();
        }
        
        System.out.println("Erro ao atualizar status: " + e.getMessage());
        
    } finally {
        
        try {
            
            conn.setAutoCommit(true);
            
        } catch (SQLException e) {
            
            e.printStackTrace();
            
        }
    }
        return false;
    }
    
    public List<pedido> preencherTabelaPedido() {
    
        String sql = "SELECT * FROM pedido";

    try {
        
        PreparedStatement stmt = this.conn.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        List<pedido> listaPedido = new ArrayList<>();
        while (rs.next()) {
            
            pedido p = new pedido();
            p.setId(rs.getInt("id"));
            p.setUserName(rs.getString("usuario_Nome"));
            p.setIdEmprestimo(rs.getInt("idEmprestimo"));
            p.setTitulo(rs.getString("tituloMaterial"));
            p.setExemplarId(rs.getInt("exemplar_id"));
            p.setTipoPedido(rs.getString("tipoPedido"));
            p.setStatus(rs.getString("status"));
            p.setExtensaoPrazo(rs.getInt("extensaoPrazo"));
            
            listaPedido.add(p);
        }
        return listaPedido;
        
    } catch (Exception e) {
        
        e.printStackTrace();
        return null;
        
    }
}
    
    public List<pedido> preencherTabelaPedidoUsuario(String usuario) {
    
        String sql = "SELECT * FROM pedido WHERE usuario_Nome = ?";

    try {
        
        PreparedStatement stmt = this.conn.prepareStatement(sql);
        stmt.setString(1, usuario);
        ResultSet rs = stmt.executeQuery();
        List<pedido> listaPedido = new ArrayList<>();
        while (rs.next()) {
            
            pedido p = new pedido();
            p.setId(rs.getInt("id"));
            p.setUserName(rs.getString("usuario_Nome"));
            p.setIdEmprestimo(rs.getInt("idEmprestimo"));
            p.setTitulo(rs.getString("tituloMaterial"));
            p.setExemplarId(rs.getInt("exemplar_id"));
            p.setTipoPedido(rs.getString("tipoPedido"));
            p.setStatus(rs.getString("status"));
            p.setExtensaoPrazo(rs.getInt("extensaoPrazo"));
            
            listaPedido.add(p);
        }
        return listaPedido;
        
    } catch (Exception e) {
        
        e.printStackTrace();
        return null;
        
    }
}
    
}
