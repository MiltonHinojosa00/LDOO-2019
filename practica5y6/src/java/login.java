/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Milton Hinojosa
 */
@WebServlet(urlPatterns = {"/login"})
public class login extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
   

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }
@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       HttpSession session = request.getSession(true);
       PrintWriter out=response.getWriter();
       Cookie cookie[];
       if(request.getCookies()!=null){
       cookie=request.getCookies();
       }else {
       cookie=null;
       }
       Usuario user= (Usuario)session.getAttribute("User");
       String email= request.getParameter("emaillogin");
       String contraseña= request.getParameter("passwordlogin");
       String sessionid=session.getId();
       String sessionidcookie="sessionidcookie";
       if(cookie!=null){
       sessionidcookie=cookie[0].getValue();
       response.addCookie(cookie[0]);
       }
       
       
       
       
       if(cookie != null){
       if(email.equals(user.getEmail())){
           if(contraseña.equals(user.getPassword())){
               if(sessionid.equals(sessionidcookie)){
                 out.println("<html>");
                 out.println("<head>");
                 out.println("<title>PRACTICA 5 DE LDOO</title>");
                 out.println("<meta charset='UTF-8'>");
                 out.println("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
                 out.println("<link href='css.css' rel='stylesheet' type='text/css'/>");
                 out.println("</head>");
                 out.println("<body>");
                 out.println("<div>");
                 out.println("<h1>Bienvenido</h1>");
                 out.println(" <form action=\"Bienvenido\" method=\"post\">\n" +
"                <input type=\"submit\" value=\"Expirar Cookie\"/>\n" +
"                \n" +
"            </form>");
                 out.println("</div>");
                 out.println("</body>");
                 out.println("</html>");
               }
              
           }
           else{
                out.println("<html>");
                 out.println("<head>");
                 out.println("<title>PRACTICA 5 DE LDOO</title>");
                 out.println("<meta charset='UTF-8'>");
                 out.println("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
                 out.println("<link href='css.css' rel='stylesheet' type='text/css'/>");
                 out.println("</head>");
                 out.println("<body>");
                 out.println("<div>");
                 out.println(" <form action=\"login\" method=\"post\">\n" +
                  
"<p>Datos incorrectos</p>               <label for=\"email\">Ingresa tu correo:</label>\n" +
"                <input type=\"email\" placeholder=\"Ingresa tu correo\" id=\"email\" name=\"emaillogin\"></br></br>\n" +
"                <label for=\"password\">Contrasena:</label>\n" +
"                <input type=\"password\" placeholder=\"Contrasena\" id=\"password\" name=\"passwordlogin\"></br> </br>\n" +
"                <input type=\"submit\" value=\"Enviar\">\n" +
"            </form>");
                 out.println("</div>");
                 out.println("</body>");
                 out.println("</html>");
  
           }
       }
       
       
      
    }else if (cookie== null){
           out.println("<html>\n" +
"    <head>\n" +
"        <title>PRACTICA 5 DE LDOO</title>\n" +
"        <meta charset=\"UTF-8\">\n" +
"        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
"        <link href=\"css.css\" rel=\"stylesheet\" type=\"text/css\"/>\n" +
"    </head>\n" +
"    <body>\n" +
"        <div>\n" +
"            <form action=\"Registro\" method=\"post\">\n" +
"                <label for=\"email\">Ingresa tu correo:</label>\n" +
"                <input type=\"email\" placeholder=\"Ingresa tu correo\" id=\"email\" name=\"email\"></br></br>\n" +
"                <label for=\"password\">Contraseña:</label>\n" +
"                <input type=\"password\" placeholder=\"Contraseña\" id=\"password\" name=\"password\"></br> </br>\n" +
"                <label for=\"name\">Nombre:</label>\n" +
"                <input type=\"text\" placeholder=\"Nombre\" id=\"name\" name=\"name\"></br> </br>\n" +
"                <label for=\"date\">Nacimiento:</label>\n" +
"                <input type=\"date\" id=\"date\" name=\"date\"></br> </br>\n" +
"                <input type=\"submit\" value=\"Enviar\">\n" +
"\n" +
"            </form>\n" +
"         </div>\n" +
"    </body>\n" +
"</html>");
       }
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
