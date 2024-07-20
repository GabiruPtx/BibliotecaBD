package dao;

import java.sql.Connection;
import conection.Conection;

public class emprestimoDAO {
    
    private Conection conexao;
    private Connection conn;
    
    public emprestimoDAO(){
        
        this.conexao = new Conection();
        this.conn = this.conexao.getConection();
        
    }
    
    
    
}
