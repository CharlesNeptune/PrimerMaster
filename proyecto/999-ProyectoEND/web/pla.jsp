<%@page import="es.cice.models.Plataforma"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="es.cice.controller.BDManager"%>
<%@include file="seguridad.jsp"%>

<%
    BDManager bdManager = new BDManager();
    String sql = "SELECT * FROM consolasadm";
    ResultSet result = bdManager.execSelect(sql);
    ArrayList<Plataforma> listaPlataformas = new ArrayList<>();

    try{
        while(result.next()){
            String plataforma = result.getString("plataforma");
            int id_consola = result.getInt("id_consola");
            Plataforma pla = new Plataforma(id_consola, plataforma);
            listaPlataformas.add(pla);
            
        }
    }catch(Exception e){   
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
                        <h2>Plataformas</h2>
                        <div class="col col_70">
                            <!-- lista de Plataformas -->
                            <%for(Plataforma plataforma : listaPlataformas){%>
                            <article>
                                <h2><%=plataforma.getPlataforma()%></h2>
                                                               
                                <div class="col col_2">
                                    <a href="DeletePla?id_plataforma=<%=plataforma.getId_plataforma()%>" class="cancelar">eliminar</a>
                                </div>
                                 <div class="col col_2">
                                    <a href="editarpla.jsp?id_plataforma=<%=plataforma.getId_plataforma() %>" class="neutro">editar</a>
                                </div>
                            </article>
                            <%}%>
                            
                            
                        </div>
                        <div class="col col_30">
                            <!-- formulario para consolas -->
                            <h2>Nueva Consola</h2>
                            <form action="InsertarPla" method="POST">
                                <!-- Aqui metemos la nueva consola -->
                                <input type="text" name="txt_plataforma" placeholder="Consola">
                               
                    
                                <input type="submit" value="Registrar">
                            </form>
                            
                        </div>
                    </div>                    
                </section>                
            </div>
        </main>
          
    </body>
</html>
