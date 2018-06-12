<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="es.cice.controller.BDManager"%>
<%@page import="es.cice.models.Plataforma"%>
<%@page import="es.cice.models.Noticia"%>
<%@page import="es.cice.controller.WordManager"%>
<%@include file="seguridad.jsp"%>

<%    WordManager wordManager = new WordManager();
//Obtenemos la id de la consola de la URL (GET)
    
    String id_plataforma = request.getParameter("id_plataforma");
    Plataforma plataforma = wordManager.getPlataforma(id_plataforma);
 
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>

        <link href="CSS/style.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>
    </head>
    <body>
        <header>
            <h1>Panel<span>de</span>control</h1>
            <a href="CerrarSession">
                <img src="img/logout23.png" alt=""/>
            </a>           
        </header>
        <nav>
            <div class="wrapper">
                <div class="menu">
                    <div class="submenu">
                        <a href="principal.jsp">Home</a>

                    </div>
                    <div class="submenu">
                        <a href="noticia.jsp">Noticias</a> 

                    </div>
                    <div class="submenu">
                        <a href="pla.jsp">Consolas</a>

                    </div>
                    <div class="submenu">
                        <a href="CerrarSession">Salir</a>

                    </div>

                </div>
            </div>
        </nav>
        <main>
            <div class="wrapper">
                <section class="col col_1">
                    <h2>Editar Consola</h2>
                    <form action="EditarPla" method="POST">
                        <input type="hidden" name="id_plataforma" value="<%=plataforma.getId_plataforma()%>">
                        <input type="text" name="txt_consola" placeholder="titulo publicacion" value="<%=plataforma.getPlataforma()%>">                                                   
                        <input type="submit" value="editar">
                    </form>                        
                </section>
            </div>
        </main>

    </body>
</html>
