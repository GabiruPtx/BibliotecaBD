package dao;

import conection.Conection;
import java.sql.Connection;

public class exemplarDAO {
    
    private Conection conexao;
    private Connection conn;
    
    public exemplarDAO(){
    
        this.conexao = new Conection();
        this.conn = this.conexao.getConection();
        
    }
    
    
    
}
