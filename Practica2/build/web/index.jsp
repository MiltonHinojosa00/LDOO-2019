<%-- 
    Document   : index
    Created on : 2/03/2019, 02:15:02 PM
    Author     : Milton 
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registro</title>
    </head>
    <body>
        <p>Ingrese Datos</p>
        <form action="Controlador" method="POST">
            <table>
                <tr>
                    <td>Nombre</td><td> <input type="text" placeholder="Nombre" name="usuario"/></td>
                </tr>
                <tr>
                    <td>Email</td><td> <input type="email" placeholder="Email" name="email"/></td>
                </tr>
                <tr>
                    <td>Contrasena</td><td> <input type="password" placeholder="Email" name="contrasena"/></td>
                </tr>
                <tr>
                    <td>Fecha de Nacimiento</td><td> <input type="date" placeholder="Fecha de Nacimiento" name="fecha"/></td>
                </tr>
                <tr>
                    <td><button type="submit">Registrarse</button>
                </tr>
            </table>
        </form>
    </body>
</html>
