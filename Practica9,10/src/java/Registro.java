
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/Registro"})
public class Registro extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        PrintWriter out= response.getWriter();
        
        Usuario usuario= Singleton.getInstance();
        if(request.getParameter("tipo").equals("Admin")){
            usuario= new Admin();
        }
        if(request.getParameter("tipo").equals("Normal")){
            usuario= new Normal();
        }
        if(request.getParameter("tipo").equals("Invitado")){
            usuario= new Invitado();
        }
        usuario.setAttributesUser((int)(Math.random()), request.getParameter("email"), request.getParameter("password"), request.getParameter("tipo"));
        usuario.setAttributes(request.getParameter("uno"), request.getParameter("dos"));
        usuario.insertarDatos();
        usuario.insertarDatos();
        
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Registro</title>");
        out.println("<meta charset='UTF-8'>");
        out.println("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
        out.println("<link href='css.css' rel='stylesheet' type='text/css'/>");
        out.println("</head>");
        out.println("<body>");
        out.println("<div>");
        out.println("<a href='login.html'>Ir a login</a>");
        out.println("</div>");
        out.println("</body>");
        out.println("</html>");
        
        
        
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
