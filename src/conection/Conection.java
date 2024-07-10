/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conection;

import java.sql.Connection;
import java.sql.DriverManager;
/**
 *
 * @author usuario
 */
public class Conection {
    
    public Connection getConection()
    {
       try {
           //tentar estabelecer a conexão
           Class.forName("com.mysql.cj.jdbc.Driver");
           Connection conn = DriverManager.getConnection(
                   "jdbc:mysql://localhost:3306/projetojavabiblioteca?serverTimezone=UTC", //linha de conexão
                   "root", //usuario do mysql
                   ""  //senha do mysql
           );
           return conn;
       } catch (Exception e) {
           //se der erro na conexão
           System.out.println("Erro ao conectar: " + e.getMessage());
           return null;
       }
    }
    
}
