<%@include file="seguridad.jsp"%>
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
                        <h2>Panel de control de GameTeam </h2>
                        <p>
                         Bienvenido al panel de administración de GameTeam.
                         
                         Aquí podrás dar de alta nuevas publicaciones, Juegos y Consolas en la web.
                        </p>

                    </div>                    
                </section>                
            </div>
        </main>
          
    </body>
</html>
