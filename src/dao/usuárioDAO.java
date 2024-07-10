/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import beans.usuário;
import java.sql.Connection;
import conection.Conection;
import java.sql.PreparedStatement;

/**
 *
 * @author usuario
 */
public class usuárioDAO {
    
    private Conection conexao;
    private Connection conn;
    
    //Construtor da classe. É executado automaticamente
    
    public usuárioDAO(){
        this.conexao = new Conection();
        this.conn = this.conexao.getConection();
    }
    
    public void inserir(usuário user){
        
        String sql = "INSERT INTO usuário(tipo, nome_completo, email, cpf, celular, celular_reserva, endereco, complemento, cep, senha) VALUES "
                + "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try{
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.set
        }
        catch(Exception e){
            
        }
    }
}
