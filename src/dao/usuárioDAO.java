package dao;

import beans.usuário;
import conection.Conection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
}
