<%-- 
    Document   : login
    Created on : 28-jun-2015, 18:03:47
    Author     : usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href='http://fonts.googleapis.com/css?family=Bangers' rel='stylesheet' type='text/css'>
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <link href="css/login.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        
        <div class="viewport">
            <div class="content">
                <h2>Admin<span>GameTeam</span></h2>
                <form action="Login" method="POST">
                    <input type="text" name="txtCorreo" placeholder="email">
                    <input type="password" name="txtPassword" placeholder="password">
                    <input type="submit" value="entrar">
                    <input type="reset">
                </form>
            </div>  
        </div>
        <!-- aquí dejo el tema de la siguiente jsp
        <jsp:useBean id="sesionActual" class="usuario.sesion" scope="sesion"/>
        <jsp:setProperty name="sesionActual" property="usuario" value="<%=UsuarioIn%>"/>
        <jsp:setProperty name="sesionActual" property="usuario" value="<%=UsuarioIn%>"/>
        <jsp:setProperty name="sesionActual" property="usuario" value="<%=UsuarioIn%>"/>
        <jsp:setProperty name="sesionActual" property="usuario" value="<%=UsuarioIn%>"/>
        
        
        -->
        
       
        
        
    </body>
</html>
