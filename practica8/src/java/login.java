/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Milton Hinojosa
 */
@WebServlet(urlPatterns = {"/login"})
public class login extends HttpServlet {

   

 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }

 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       String prueba[];
       PrintWriter out = response.getWriter();
       String usuario= request.getParameter("emaillogin");
       String contrasena= request.getParameter("passwordlogin");
       Conexion conexion= new Conexion(usuario, contrasena);
       prueba= conexion.TransporteALogin();
       if(usuario.equals(prueba[0])  &&  contrasena.equals(prueba[1])){
           out.println("<html>");
                 out.println("<head>");
                 out.println("<title>Registro</title>");
                 out.println("<meta charset='UTF-8'>");
                 out.println("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
                 out.println("<link href='css.css' rel='stylesheet' type='text/css'/>");
                 out.println("</head>");
                 out.println("<body>");
                 out.println("<div>");
                 out.println("<h1>Bienvenido</h1>");
                 out.println("</div>");
                 out.println("</body>");
                 out.println("</html>");
       }else{
       out.println("<html>");
                 out.println("<head>");
                 out.println("<title>Registro</title>");
                 out.println("<meta charset='UTF-8'>");
                 out.println("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
                 out.println("<link href='css.css' rel='stylesheet' type='text/css'/>");
                 out.println("</head>");
                 out.println("<body>");
                 out.println("<div>");
                 out.println(" <form action=\"login\" method=\"post\">\n" +
                  
"<p>Datos erroneos</p>               <label for=\"email\">Ingresa tu usuario:</label>\n" +
"                <input type=\"text\" placeholder=\"Ingresa tu usuario\" id=\"email\" name=\"emaillogin\"></br></br>\n" +
"                <label for=\"password\">Contrasena:</label>\n" +
"                <input type=\"password\" placeholder=\"Contrasena\" id=\"password\" name=\"passwordlogin\"></br> </br>\n" +
"                <input type=\"submit\" value=\"Enviar\">\n" +
"            </form>");
                 out.println("</div>");
                 out.println("</body>");
                 out.println("</html>");
       }
       
       
       
       
       
       
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
