import java.sql.*;
public class Invitado extends Usuario {
    
    String fechar;
    
    public Invitado(){}
    
    public void setAttributes(String uno, String dos){
    
      this.fechar=uno;
    
    }
    
    public String DatosPorUsuario(){
        String out = "";
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/usuarios","root", "");
            PreparedStatement prepared =connection.prepareStatement("INSERT INTO INVITADO VALUES('"+ iduser +"','"+ username+"','"+ fechar +"')");
            prepared.executeUpdate();
        }catch(Exception e){
                        out = String.format("Error Horrible: %s", e.getMessage());
        }
        return out;
    }
    public String[] traerDatos(){
        
        String out[]=new String[3];
        try{
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/usuarios","root", "");
        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery("SELECT *  FROM INVITADO WHERE IDUSER='"+ iduser + "'");
        
        while(result.next()){
            
            out[0]= result.getString("iduser");
            out[1]= result.getString("username"); 
            out[2]= result.getString("fechar"); 
            
            
        }
        }catch(Exception e){
            out[0] = String.format("Error: %s", e.getMessage());
        }
        return out;
    }

}
