package dao;

import beans.material;
import conection.Conection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
        stmt2.setString(3, material.getVolume());
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
   
    public void excluirMaterial(int materialId, String tipo) {
        
        String sqlVerificaTipo = "SELECT Tipo FROM material WHERE id = ?";
        String sqlDeleteExemplares = "DELETE FROM exemplar WHERE material_id = ?";
        String sqlDeleteMaterial = "DELETE FROM material WHERE id = ?";
        String sqlDeleteEspecifico;

        if (tipo.equalsIgnoreCase("LIVRO")) {

            sqlDeleteEspecifico = "DELETE FROM livro WHERE id = ?";

        } else if (tipo.equalsIgnoreCase("ARTIGO")) {

            sqlDeleteEspecifico = "DELETE FROM artigo WHERE id = ?";

        } else {

            throw new IllegalArgumentException("Tipo de material desconhecido: " + tipo);

        }

        try {
            
            conn.setAutoCommit(false); // Inicia a transação

            // Verifica o tipo do material no banco de dados
            PreparedStatement stmtVerifica = this.conn.prepareStatement(sqlVerificaTipo);
            stmtVerifica.setInt(1, materialId);
            ResultSet rs = stmtVerifica.executeQuery();
            String tipoBanco = null;
            if (rs.next()) {
                
                tipoBanco = rs.getString("Tipo");
                
            }
            rs.close();
            stmtVerifica.close();

            // Verifica se o tipo no banco corresponde ao tipo fornecido pelo usuário
            if (tipoBanco == null) {
                
                throw new IllegalArgumentException("Material com ID " + materialId + " não encontrado.");
                
            }
            if (!tipoBanco.equalsIgnoreCase(tipo)) {
                
                throw new IllegalArgumentException("O tipo do material não corresponde ao tipo fornecido pelo usuário.");
                
            }

            // Exclui os exemplares relacionados ao material
            PreparedStatement stmtDeleteExemplares = this.conn.prepareStatement(sqlDeleteExemplares);
            stmtDeleteExemplares.setInt(1, materialId);
            stmtDeleteExemplares.executeUpdate();
            stmtDeleteExemplares.close();

            // Exclui da tabela específica (livro ou artigo)
            PreparedStatement stmtDeleteEspecifico = this.conn.prepareStatement(sqlDeleteEspecifico);
            stmtDeleteEspecifico.setInt(1, materialId);
            stmtDeleteEspecifico.executeUpdate();
            stmtDeleteEspecifico.close();

            // Exclui da tabela material
            PreparedStatement stmtDeleteMaterial = this.conn.prepareStatement(sqlDeleteMaterial);
            stmtDeleteMaterial.setInt(1, materialId);
            stmtDeleteMaterial.executeUpdate();
            stmtDeleteMaterial.close();

            conn.commit(); // Finaliza a transação
            
        } catch (Exception e) {
            
            try {
                
                conn.rollback(); // Desfaz a transação em caso de erro
                
            } catch (SQLException ex) {
                
                System.out.println("Erro ao fazer rollback: " + ex.getMessage());
                
            }
            
            System.out.println("Erro ao excluir material: " + e.getMessage());
            
        } finally {
            
            try {
                
                conn.setAutoCommit(true); // Restaura o modo padrão de commit automático
                
            } catch (SQLException e) {
                
                e.printStackTrace();
                
            }
        }
}
    
    public List<material> preencherTabelaMaterial() {
    String sql = "SELECT " +
                 "    m.id, " +
                 "    m.titulo, " +
                 "    m.autor, " +
                 "    m.Ano_publicacao, " +
                 "    m.resumo, " +
                 "    m.tipo, " +
                 "    l.editora, " +
                 "    l.genero, " +
                 "    a.revista, " +
                 "    a.volume " +
                 "FROM " +
                 "    material m " +
                 "LEFT JOIN " +
                 "    livro l ON m.id = l.id " +
                 "LEFT JOIN " +
                 "    artigo a ON m.id = a.id";

    try {
        PreparedStatement stmt = this.conn.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        List<material> listaMaterial = new ArrayList<>();
        while (rs.next()) {
            material m = new material();
            m.setId(rs.getInt("id"));
            m.setTítulo(rs.getString("Titulo"));
            m.setAutor(rs.getString("Autor"));
            m.setAnoPublicacao(rs.getString("Ano_publicacao"));
            m.setResumo(rs.getString("Resumo"));
            m.setTipo(rs.getString("Tipo"));
            
            if ("LIVRO".equalsIgnoreCase(m.getTipo())) {
                
                m.setEditora(rs.getString("editora"));
                m.setGenero(rs.getString("genero"));
                m.setVolume("");
                m.setRevista("");
                
            } else if ("ARTIGO".equalsIgnoreCase(m.getTipo())) {
                
                m.setRevista(rs.getString("revista"));
                m.setVolume(rs.getString("volume"));
                m.setEditora("");
                m.setGenero("");
                
            }
            
            listaMaterial.add(m);
        }
        return listaMaterial;
        
    } catch (Exception e) {
        
        e.printStackTrace();
        return null;
        
    }
}
    
    public List<Integer> buscarIdsMateriais(String busca) {
    String sql = "SELECT m.id " +
                 "FROM material m " +
                 "LEFT JOIN livro l ON m.id = l.id " +
                 "LEFT JOIN artigo a ON m.id = a.id " +
                 "WHERE m.Titulo LIKE ? OR m.Autor LIKE ? OR m.Ano_publicacao LIKE ? OR m.Tipo LIKE ? " +
                 "OR l.editora LIKE ? OR l.genero LIKE ? OR a.revista LIKE ? OR a.volume LIKE ?";

    try {
        PreparedStatement stmt = this.conn.prepareStatement(sql);
        String buscaPattern = "%" + busca + "%";
        stmt.setString(1, buscaPattern);
        stmt.setString(2, buscaPattern);
        stmt.setString(3, buscaPattern);
        stmt.setString(4, buscaPattern);
        stmt.setString(5, buscaPattern);
        stmt.setString(6, buscaPattern);
        stmt.setString(7, buscaPattern);
        stmt.setString(8, buscaPattern);

        ResultSet rs = stmt.executeQuery();
        List<Integer> listaIds = new ArrayList<>();

        while (rs.next()) {
            listaIds.add(rs.getInt("id"));
        }
        return listaIds;

    } catch (Exception e) {
        e.printStackTrace();
        return null;
    }
}

    public List<material> buscarMaterial(List<Integer> ids){
        
        if (ids == null || ids.isEmpty()) {
        return new ArrayList<>();
        }
        
        System.out.println("Comando executado");
        
        String sql = "SELECT m.id, m.Titulo, m.Autor, m.Ano_publicacao, m.Resumo, m.Tipo, " +
                 "CASE WHEN m.Tipo = 'livro' THEN l.editora ELSE a.revista END AS especifico1, " +
                 "CASE WHEN m.Tipo = 'livro' THEN l.genero ELSE a.volume END AS especifico2 " +
                 "FROM material m " +
                 "LEFT JOIN livro l ON m.id = l.id " +
                 "LEFT JOIN artigo a ON m.id = a.id " +
                 "WHERE m.id IN (" + ids.stream().map(String::valueOf).collect(Collectors.joining(",")) + ")";

    try {
        
        PreparedStatement stmt = this.conn.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        List<material> listaMaterial = new ArrayList<>();
        System.out.println("try executado");
        while (rs.next()) {
            
            material m = new material();
            m.setId(rs.getInt("id"));
            m.setTítulo(rs.getString("Titulo"));
            m.setAutor(rs.getString("Autor"));
            m.setAnoPublicacao(rs.getString("Ano_publicacao"));
            m.setResumo(rs.getString("Resumo"));
            m.setTipo(rs.getString("Tipo"));
            
             // Set additional fields based on type
            if ("livro".equalsIgnoreCase(m.getTipo())) {
                
                m.setEditora(rs.getString("especifico1"));
                m.setGenero(rs.getString("especifico2"));
                m.setRevista("");
                m.setVolume("");
                
            } else if ("artigo".equalsIgnoreCase(m.getTipo())) {
                
                m.setRevista(rs.getString("especifico1"));
                m.setVolume(rs.getString("especifico2"));
                m.setEditora("");
                m.setGenero("");
                
            }

            
            listaMaterial.add(m);
        }
        return listaMaterial;
        
    } catch (Exception e) {
        
        e.printStackTrace();
        return null;
        
    }
    
    }
    
}
