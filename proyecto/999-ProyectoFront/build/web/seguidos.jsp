<%@page import="es.cice.models.Usuario"%>
<%@page import="es.cice.controller.WordManager"%>
<%@page import="es.cice.models.Amigo"%>
<%@page import="es.cice.models.Noticia"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="es.cice.controller.BDManager"%>
<%@page import="es.cice.login.Login"%>
<%@page import="es.cice.login.Register"%>

<%    BDManager bdManager = new BDManager();
    
    String id_publicador = request.getParameter("id_publicador");
    System.out.println(id_publicador);
    
    String sql = "SELECT nick, nombre, apellidos FROM usuarios WHERE id =(SELECT id_publicador FROM amigos WHERE id_seguidor='"+id_publicador+"'); ";
    ResultSet result = bdManager.execSelect(sql);
    ArrayList<Amigo> listaAmigos = new ArrayList<Amigo>();

    try {
        while (result.next()) {
            String nick = result.getString("nick");
            String nombre = result.getString("nombre");
            String apellido = result.getString("apellido");
			
            Amigo ami = new Amigo(nick, nombre, apellido);
            listaAmigos.add(ami);
        }
    } catch (Exception e) {
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
    <body><nav>
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
                    <%for (Amigo amigo : listaAmigos) {%>
                            <article>
                                <h2><%=amigo.getNick()%></h2>
                                <h3><%=amigo.getNombre()%></h3>
                                <h2><%=amigo.getApellidos()%></h2>
                                
                                <div class="col col_2">
                                    <a href="DeleteAmi?nick=<%=amigo.getNick()%>" class="cancelar">No seguir</a>
                                </div>
                            </article>
                            <%}%>
                </section>
            </main>
            
            <footer>
                <h3>by Charles</h3>
            </footer>
        </div>
    </body>
</html>
