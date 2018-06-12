
package es.cice.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;



public class BDManager {
   private String direc,usuario,password,driver;
   private Connection connection;
    
   //CONSTRUCTORES
   public BDManager() {
        this.usuario="root";
        this.password="root";
        this.driver="com.mysql.jdbc.Driver";
        this.direc="jdbc:mysql://localhost:3307/miproyecto";
        //conectamos con la base de datos
        connectToDB();
    }
   public BDManager(String driver) {
        this.driver = driver;
    }
   public BDManager(String direc, String usuario, String password, String driver) {
        this.direc = direc;
        this.usuario = usuario;
        this.password = password;
        this.driver = driver;
        connectToDB();
    }
   //FUNCIONES PARA CONECTAR
   public Boolean conectar(String direc, String usuario, String password){
       try{
           //Class.forName(driver);
           connection = DriverManager.getConnection(direc,usuario,password);
           return true;
       }catch(Exception e){
           return false;
       }
   }
   private void connectToDB(){
        try{
            //1Âº Cargar el driver
            Class.forName(driver);
            //2Âº Conectamos con la base de datos
            connection = DriverManager.getConnection(direc,usuario,password);
        }catch (SQLException e){
            
        } catch (ClassNotFoundException ex) {
           Logger.getLogger(BDManager.class.getName()).log(Level.SEVERE, null, ex);
       }
        
        
    }
   //FunciÃ³n para ejecutar sentencias INSERT/DELETE/UPDATE
   public Boolean execute(String sql){
       try{
           //1Âº Creamos la sentencia
           Statement st = connection.createStatement();
           //2Âº Ejecutamos sentencia
           return st.execute(sql);
       }catch(SQLException e){
           System.out.println("Error en la sentencia SQL SELEC");
           e.printStackTrace();
           return true;
       }
   }
   //FunciÃ³n para ejecutar una sentencia de SELECT
   public ResultSet execSelect(String sql){
       try{
           //1º Realizar sentencia
           Statement st = connection.createStatement();
           //executeQuery obtiene el resultSet del SELECT
           return st.executeQuery(sql);
           
       }catch(SQLException e){
           System.out.println("Error en la sentencia SQL EXEC");
           e.printStackTrace();
           return null;
       }
   }
}
