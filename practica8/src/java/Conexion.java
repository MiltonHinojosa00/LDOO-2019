

import java.sql.*;

public class Conexion {
    
    String correo, contrasena;
    
    
    public Conexion(String correo, String contrasena){
        this.correo=correo;
        this.contrasena=contrasena;
    }

    
    public String insertarDatos() {
        String out = "";
        try{
            Class.forName("com.mysql.jdbc.Driver");
        //Crear conexion 
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/usuarios","root", "");
        //Crear objeto statement 
            Statement statement = connection.createStatement();
            PreparedStatement prepared =connection.prepareStatement("INSERT INTO USUARIOS VALUES('"+ correo +"','"+contrasena +"')");
            prepared.executeUpdate();

      
        }catch(Exception e){
            
                        out = String.format("Error: %s", e.getMessage());
            
        }
        
        return out;
    }
    
    public String  EnseñarDatos(){
        
        String out = "";
        try{
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/usuarios","root", "");
        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery("SELECT * FROM USUARIOS");
        while(result.next()){
            out += result.getString("Usuario") + result.getString("Contraseña");
        }
        }catch(Exception e){
        
            out = String.format("Error: %s", e.getMessage());
        }
        
        return out;
        
    
    }
    
    
    
     public String[] TransporteALogin(){
         String out[] = new String [2];
         
         try{
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/usuarios","root", "");
        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery("SELECT * FROM USUARIOS WHERE USUARIO='"+ correo + "'");
        
        while(result.next()){
            
            out[0]= result.getString("Usuario");
            out[1]= result.getString("Contraseña"); 
            
        }
        }catch(Exception e){
            out[0] = String.format("Error: %s", e.getMessage());
        }

         return out;
         
     
     }
     
     
     
     
    
    
    
    public String getContrasena(){
        return contrasena;
    }
    
    
}
