<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="es.cice.controller.BDManager"%>
<%@page import="es.cice.models.Plataforma"%>
<%@page import="es.cice.models.Noticia"%>
<%@page import="es.cice.controller.WordManager"%>
<%@include file="seguridad.jsp"%>

<%    WordManager wordManager = new WordManager();
//Obtenemos la id de la noticia de la URL (GET)
    
    String id_publicacion = request.getParameter("id_publicacion");
    Noticia noticia = wordManager.getNoticia(id_publicacion);
    
//obtenemos la lista de consolas
    ArrayList<Plataforma> listaPlataformas = wordManager.getPlataformas();

//Obtenemos la plataforma que pertenece a la noticia
    int id_pla = wordManager.getPlaFromNoticia(id_publicacion);
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
                    <h2>Editar Noticia</h2>
                    <form action="EditarNoticia" method="POST">
                        <input type="hidden" name="id_publicacion" value="<%=noticia.getId_publicacion()%>">
                        <input type="text" name="txt_titulo" placeholder="titulo publicacion" value="<%=noticia.getTitulo()%>">                               
                        <input type="text" name="txt_texto" placeholder="texto publicacion" value="<%=noticia.getTexto()%>">
                        <select name="plataforma">
                            <%for (Plataforma pla : listaPlataformas) {%>
                            <%
                                if (pla.getId_plataforma() == id_pla) {
                            %>
                            <option selected value="<%=pla.getId_plataforma()%>"><%=pla.getId_plataforma()%></option>
                            <%
                            } else {
                            %>
                            <option value="<%=pla.getId_plataforma()%>"><%=pla.getPlataforma()%></option>  
                                <%}%>
                            <%}%>   
                        </select>
                        <input type="submit" value="editar">
                    </form>                        
                </section>
            </div>
        </main>

    </body>
</html>
