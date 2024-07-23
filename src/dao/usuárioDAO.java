package dao;

import beans.usuário;
import conection.Conection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class usuárioDAO {
    
    private Conection conexao;
    private Connection conn;
    
    public usuárioDAO (){
        
        this.conexao = new Conection();
        this.conn = this.conexao.getConection();
        
    }
    
    public void cadastrarUsuário(usuário user) {
        
        String sql = "INSERT INTO usuário (nomeCompleto, matricula, email, cpf, celular, celularreserva, endereco, complemento, cep, senha, tipo) VALUES "
        + "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        try{
            
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, user.getNomeCompleto());
            stmt.setString(2, user.getMatrícula());
            stmt.setString(3, user.getEmail());
            stmt.setString(4, user.getCpf());
            stmt.setString(5, user.getCelular());
            stmt.setString(6, user.getCelularreserva());
            stmt.setString(7, user.getEndereco());
            stmt.setString(8, user.getComplemento());
            stmt.setString(9, user.getCep());
            stmt.setString(10, user.getSenha());
            stmt.setString(11, user.getTipo());
            
            stmt.execute();
            
        } catch (Exception e){
            
            System.out.println(e.getMessage());
            
        }
    }
    
    public usuário logar(String login, String senha) {
        
        String sql = "SELECT * FROM usuário WHERE matricula = ? AND senha = ?";
        usuário user = null;
        
        try (PreparedStatement stmt = this.conn.prepareStatement(sql)) {
            stmt.setString(1, login);
            stmt.setString(2, senha);
            try (ResultSet rs = stmt.executeQuery()) {
                
                if (rs.next()) {
                    user = new usuário();
                    user.setNomeCompleto(rs.getString("nomeCompleto"));
                    user.setMatrícula(rs.getString("matricula"));
                    user.setEmail(rs.getString("email"));
                    user.setCpf(rs.getString("cpf"));
                    user.setCelular(rs.getString("celular"));
                    user.setCelularreserva(rs.getString("celularreserva"));
                    user.setEndereco(rs.getString("endereco"));
                    user.setComplemento(rs.getString("complemento"));
                    user.setCep(rs.getString("cep"));
                    user.setSenha(rs.getString("senha"));
                    user.setTipo(rs.getString("tipo"));
                    
                }
                
            }
            
        } catch (SQLException e) {
            
            System.err.println("Erro ao tentar logar: " + e.getMessage());
            
            e.printStackTrace();
            
        }
        
        return user;
    }
    
    public boolean alterarSenha(String matricula, String email, String novaSenha) {
        String sql = "UPDATE usuário SET senha = ? WHERE matricula = ? AND email = ?";
        
        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, novaSenha);
            stmt.setString(2, matricula);
            stmt.setString(3, email); 
            int affectedRows = stmt.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("Senha atualizada com sucesso!");
                return true;
            } else {
                System.out.println("Não foi possível atualizar a senha. Matrícula ou e-mail incorretos.");
                return false;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar a senha: " + e.getMessage());
        }
        return false;
    }
    
    public boolean alterarPerfil(String matricula, String email, String celular, String celularReserva, String endereco, String complemento, String cep) {
    StringBuilder sql = new StringBuilder("UPDATE usuário SET ");
    List<String> fields = new ArrayList<>();
    List<Object> values = new ArrayList<>();

    if (email != null && !email.isEmpty()) {
        fields.add("email = ?");
        values.add(email);
    }
    if (celular != null && !celular.isEmpty()) {
        fields.add("celular = ?");
        values.add(celular);
    }
    if (celularReserva != null && !celularReserva.isEmpty()) {
        fields.add("celularreserva = ?");
        values.add(celularReserva);
    }
    if (endereco != null && !endereco.isEmpty()) {
        fields.add("endereco = ?");
        values.add(endereco);
    }
    if (complemento != null && !complemento.isEmpty()) {
        fields.add("complemento = ?");
        values.add(complemento);
    }
    if (cep != null && !cep.isEmpty()) {
        fields.add("cep = ?");
        values.add(cep);
    }

    if (fields.isEmpty()) {
        return false; 
    }

    sql.append(String.join(", ", fields));
    sql.append(" WHERE matricula = ?");
    values.add(matricula);

    try (PreparedStatement stmt = this.conn.prepareStatement(sql.toString())) {
        for (int i = 0; i < values.size(); i++) {
            stmt.setObject(i + 1, values.get(i));
        }

        int affectedRows = stmt.executeUpdate();
        return affectedRows > 0;
    } catch (Exception e) {
        System.out.println("Erro ao alterar perfil: " + e.getMessage());
        e.printStackTrace();  // Adiciona mais detalhes sobre a exceção
        return false;
    }
}

    
}
