<%@page import="es.cice.models.Plataforma"%>
<%@page import="es.cice.models.Noticia"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="es.cice.controller.BDManager"%>
<%@include file="seguridad.jsp"%>

<%    BDManager bdManager = new BDManager();
    String sql = "SELECT * FROM consolasadm";
    ResultSet result = bdManager.execSelect(sql);
    ArrayList<Plataforma> listaPlataformas = new ArrayList<Plataforma>();

    try {
        while (result.next()) {
            String plataforma = result.getString("plataforma");
            int id_consola = result.getInt("id_consola");
			
            Plataforma pla = new Plataforma(id_consola, plataforma);
            listaPlataformas.add(pla);
        }
    } catch (Exception e) {
        e.printStackTrace();

    }

    //Obtener todas las entradas de la BBDD
    sql = "SELECT * FROM noticias ORDER BY id_publicacion DESC";
    result = bdManager.execSelect(sql);
    ArrayList<Noticia> listaNoticias = new ArrayList<Noticia>();
    try {
        while (result.next()) {
            String id_publicacion = result.getString("id_publicacion");
            String titulo = result.getString("titulo");
            String texto = result.getString("texto");
            String consola = result.getString("consola");
            String fecha = result.getString("fecha");
            Noticia pub = new Noticia(id_publicacion, titulo, texto, consola,fecha);
            listaNoticias.add(pub);

        }
    } catch (Exception e) {
        System.out.println("error al select de publicaciones");
        e.printStackTrace();
    }

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
                <section>
                    <div class="col col_1">
                        <h2>Publicaciones</h2>
                        <div class="col col_70">
                            <!-- lista de publicacion -->
                            <%for (Noticia noticia : listaNoticias) {%>
                            <article>
                                <h2><%=noticia.getTitulo()%></h2>
                                <h3><%=noticia.getFecha()%></h3>
                                <h2><%=noticia.getTexto()%></h2>
                                
                                <div class="col col_2">
                                    <a href="DeleteNoticia?id_publicacion=<%=noticia.getId_publicacion()%>" class="cancelar">eliminar</a>
                                </div>
                                <div class="col col_2">
                                    <a href="editar.jsp?id_publicacion=<%=noticia.getId_publicacion() %>" class="neutro">editar</a>
                                </div>
                            </article>
                            <%}%>


                        </div>
                        <div class="col col_30">
                            <!-- formulario para publicacion -->
                            <h2>Nueva Publicacion</h2>
                            <form action="InsertarNoticia" method="POST">
                                <input type="text" name="txt_titulo" placeholder="titulo">
                                <textarea name="txt_publicacion" placeholder="publicacion"></textarea>
                                <select name="plataforma">
                                    <%for (Plataforma pla : listaPlataformas) {%>
                                    <option value="<%=pla.getPlataforma()%>"><%=pla.getPlataforma()%></option>  
                                    <%}%>
                                </select>
                                <input type="submit" value="Registrar">
                            </form>

                        </div>
                    </div>                    
                </section>                
            </div>
        </main>

    </body>
</html>
