<%@page import="es.cice.controller.Manager"%>
<%@page import="es.cice.models.Plataforma"%>
<%@page import="es.cice.models.Noticia"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="es.cice.controller.BDManager"%>

<%
 BDManager bdManager = new BDManager();
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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href='http://fonts.googleapis.com/css?family=Bangers' rel='stylesheet' type='text/css'>
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        
    </head>
    <body>
         <nav>
                <ul>
                    <li>
                       Bienvenido a GameTeam
                    
                    </li>
                   
                    <li>
                        <a href="index.html">Iniciar Sesión</a>
                    </li>
                    <li>
                        <a href="register.html">Registrarse</a>
                    </li>
                    <li>
                        <a href="CerrarSession">
                         <img src="img/logout23.png" alt=""/>
                        </a>  
                    </li>
                </ul>
            </nav>
        <div class="wrapper">
            <header>
                <img src="img/logogato2.png" alt=""/>
            </header>
            <nav>
                <ul>
                    <li>
                        <a href="principal.jsp">Inicio</a>
                    </li>
                    <li>
                        <a href="seguidos.jsp">Seguidos</a>
                    </li>
                    <li>
                        <a href="amigos.jsp">Seguidores</a>
                    </li>
                    <li>
                        <a href="destacados.jsp">Destacados</a>
                    </li>
                    <li>
                        <a href="ventas.jsp">Mis ventas</a>
                    </li>
                    <li>
                        <a href="perfil.jsp">Mi Perfil</a>
                    </li>
                </ul>
            </nav>
            <main class="blanco">
                <section>
                     <div class="col col_70">
                        
                            <li class="header_li">Noticias</li>
                           <%for (Noticia noticia : listaNoticias) {%>
                            <article>
                                <h2><%=noticia.getTitulo()%></h2>
                                <h3><%=noticia.getFecha()%></h3>
                                <h1><%=noticia.getTexto()%></h1>
                            </article>
                         <%}%>
                        
                    </div>
                    <div class="col col_30">
                        <h3>Mi perfil</h3>
                        
                        <div class="col col_35">
                        Mis Consolas
                        
                        </div>    
                   
                   
                    </div>
                   
                </section>
            </main>
            
            <footer>
                <h3>by Charles</h3>
            </footer>
        </div>
    </body>
</html>
