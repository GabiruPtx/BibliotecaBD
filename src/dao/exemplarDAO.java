package dao;

import beans.exemplar;
import beans.material;
import conection.Conection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class exemplarDAO {
    
    private Conection conexao;
    private Connection conn;
    
    public exemplarDAO(){
    
        this.conexao = new Conection();
        this.conn = this.conexao.getConection();
        
    }
    
    public void cadastrarExemplar(exemplar e){
        
        String sql = "INSERT INTO exemplar (material_id, andar, corredor, estante, prateleira) VALUES "
        + "(?, ?, ?, ?, ?)";
        
        try{
            
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setInt(1, e.getMaterialId());
            stmt.setString(2, e.getAndar());
            stmt.setString(3, e.getCorredor());
            stmt.setString(4, e.getEstante());
            stmt.setString(5, e.getPrateleira());
            
            stmt.execute();
            
        } catch (Exception ex){
            
            System.out.println(ex.getMessage());
            
        }
    }
    
    public void cadastroExemplar(material material, int materialId) {
        
        String sql = "INSERT INTO exemplar(material_id) VALUES (?)";

        try {

            int count = material.getQntExemplares();
            
            while (count != 0) {
                PreparedStatement stmt2 = this.conn.prepareStatement(sql);
                stmt2.setInt(1, materialId);
                stmt2.executeUpdate();
                stmt2.close();
                count -= 1;
            }
            
        } catch (Exception e) {
            
            System.out.println("Erro ao cadastrar exemplar: " + e.getMessage());
            
        }
        
    }

    public exemplar buscarExemplarComCamposDefault() {
        
        String sql = "SELECT id, material_id FROM exemplar " +
                     "WHERE andar = '-' OR corredor = '-' OR estante = '-' OR prateleira = '-' " +
                     "LIMIT 1";

        try {
            
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
           
            if (rs.next()) {
                
            
                exemplar e = new exemplar();
                e.setId(rs.getInt("id"));
                e.setMaterialId(rs.getInt("material_id"));
                return e;
                
            } else {
              
                return null;
                
            }

        } catch (Exception e) {
            
            e.printStackTrace();
            
            return null;
            
        }
    }
    
    public String buscarTituloMaterial(int materialId) {
        
        String sql = "SELECT m.titulo " +
                     "FROM material m " +
                     "JOIN exemplar e ON m.id = e.material_id " +
                     "WHERE e.material_id = ?";

        try {
            
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setInt(1, materialId);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                
                return rs.getString("Titulo");
                
            } else {
                
                return null;
                
            }

        } catch (Exception e) {
            
            e.printStackTrace();
            
            return null;
        }
    }
    
    public boolean atualizarExemplar(exemplar ex) {
        
        String sql = "UPDATE exemplar SET andar = ?, corredor = ?, estante = ?, prateleira = ? WHERE id = ?";

        try (PreparedStatement stmt = this.conn.prepareStatement(sql)) {
            stmt.setString(1, ex.getAndar());
            stmt.setString(2, ex.getCorredor());
            stmt.setString(3, ex.getEstante());
            stmt.setString(4, ex.getPrateleira());
            stmt.setInt(5, ex.getId());

            int rowsUpdated = stmt.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            
            e.printStackTrace();
            
            return false;
        }
}

    
}
