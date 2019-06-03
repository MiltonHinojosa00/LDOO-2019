import java.sql.*;
public abstract class Usuario {
    
     int iduser;
    String username, password, tipo;
    
    public void setAttributesUser(int  iduser, String username, String password, String tipo){
        this.iduser=iduser;
        this.username=username;
        this.password=password;
        this.tipo=tipo;
    }
    
    public abstract void setAttributes(String uno, String dos);
    
    
    public String insertarDatos(){
        
        String out = "";
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/usuarios","root", "");
            PreparedStatement prepared =connection.prepareStatement("INSERT INTO USUARIOS VALUES('"+ iduser +"','"+ username+"','"+ password+"','" + tipo + "')");
            prepared.executeUpdate();
        }catch(Exception e){
                        out = String.format("Error Horrible: %s", e.getMessage());
        }
        return out;
    }
    
    public abstract String DatosPorUsuario();
    public abstract String[] traerDatos();
       
    public String[] buscarUsuario(String username){
        this.username=username;
     String out[] = new String [3];
         
         try{
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/usuarios","root", "");
        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery("SELECT IDUSER, PASSWORD, TIPO  FROM USUARIOS WHERE USUARIO='"+ username + "'");
        
        while(result.next()){
            
            out[0]= result.getString("PASSWORD");
            out[1]= result.getString("TIPO"); 
            out[2]=result.getString("IDUSER");
        }
        }catch(Exception e){
            out[0] = String.format("Error: %s", e.getMessage());
        }

         return out;
        
    }
}
