
public class Singleton {
    
    private static Usuario usuario;
    
    private Singleton(){      
    }
    
    public static Usuario getInstance(){
        return usuario;
    }

}
