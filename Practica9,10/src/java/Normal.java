import java.sql.*;

public class Normal extends Usuario{
    
    String suscripcion;
    String domicilio;
    
    public Normal(){}
    
    public void setAttributes(String uno, String dos){
        
        this.suscripcion=uno;
        this.domicilio=dos;
    
    
    }
    
    public String insertarDatos(){
        String out = "";
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/usuarios","root", "");
            PreparedStatement prepared =connection.prepareStatement("INSERT INTO NORMAL VALUES('"+ iduser +"','"+ username+"','"+ tipo +"','" + domicilio + "')");
            prepared.executeUpdate();
        }catch(Exception e){
                        out = String.format("Error: %s", e.getMessage());
        }
        return out;
    }
    
    public String[] traerDatos(){
        
        String out[]=new String[4];
        try{
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/usuarios","root", "");
        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery("SELECT *  FROM NORMAL WHERE IDUSER='"+ iduser + "'");
        
        while(result.next()){
            
            out[0]= result.getString("iduser");
            out[1]= result.getString("username"); 
            out[2]= result.getString("tipo");
            out[3]= result.getString("domicilio"); 
            
        }
        }catch(Exception e){
            out[0] = String.format("Error: %s", e.getMessage());
        }
        return out;
    }
    @Override
    public String DatosPorUsuario() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    
}
