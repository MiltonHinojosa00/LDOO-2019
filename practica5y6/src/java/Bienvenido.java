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
@WebServlet(urlPatterns = {"/Bienvenido"})
public class Bienvenido extends HttpServlet {

   
 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       Cookie cookie[]= request.getCookies();
       HttpSession session= request.getSession();
       cookie[0].setMaxAge(0);
       PrintWriter out=response.getWriter();
       response.addCookie(cookie[0]);
       out.println("<html>\n" +
"    <head>\n" +
"        <title>Registro</title>\n" +
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

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
