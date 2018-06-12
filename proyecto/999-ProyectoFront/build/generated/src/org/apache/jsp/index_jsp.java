package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import es.cice.controller.Manager;
import es.cice.models.Plataforma;
import es.cice.models.Noticia;
import java.util.ArrayList;
import java.sql.ResultSet;
import es.cice.controller.BDManager;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");

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
    


      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("        <link href='http://fonts.googleapis.com/css?family=Bangers' rel='stylesheet' type='text/css'>\n");
      out.write("        <link href=\"css/style.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        \n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("         <nav>\n");
      out.write("                <ul>\n");
      out.write("                    <li>\n");
      out.write("                       Bienvenido a GameTeam\n");
      out.write("                    \n");
      out.write("                    </li>\n");
      out.write("                   \n");
      out.write("                    <li>\n");
      out.write("                        <a href=\"login.html\">Iniciar Sesión</a>\n");
      out.write("                    </li>\n");
      out.write("                    <li>\n");
      out.write("                        <a href=\"CerrarSession\">\n");
      out.write("                         <img src=\"img/logout23.png\" alt=\"\"/>\n");
      out.write("                        </a>  \n");
      out.write("                    </li>\n");
      out.write("                </ul>\n");
      out.write("            </nav>\n");
      out.write("        <div class=\"wrapper\">\n");
      out.write("            <header>\n");
      out.write("                <img src=\"img/logogato2.png\" alt=\"\"/>\n");
      out.write("            </header>\n");
      out.write("            <nav>\n");
      out.write("                <ul>\n");
      out.write("                    <li>\n");
      out.write("                        <a href=\"index.jsp\">Inicio</a>\n");
      out.write("                    </li>\n");
      out.write("                    <li>\n");
      out.write("                        <a href=\"seguidos.jsp\">Seguidos</a>\n");
      out.write("                    </li>\n");
      out.write("                    <li>\n");
      out.write("                        <a href=\"amigos.jsp\">Amigos</a>\n");
      out.write("                    </li>\n");
      out.write("                    <li>\n");
      out.write("                        <a href=\"destacados.jsp\">Destacados</a>\n");
      out.write("                    </li>\n");
      out.write("                    <li>\n");
      out.write("                        <a href=\"ventas.jsp\">Mis ventas</a>\n");
      out.write("                    </li>\n");
      out.write("                    <li>\n");
      out.write("                        <a href=\"perfil.jsp\">Mi Perfil</a>\n");
      out.write("                    </li>\n");
      out.write("                </ul>\n");
      out.write("            </nav>\n");
      out.write("            <main class=\"blanco\">\n");
      out.write("                <section>\n");
      out.write("                     <div class=\"col col_70\">\n");
      out.write("                        \n");
      out.write("                            <li class=\"header_li\">Noticias</li>\n");
      out.write("                           ");
for (Noticia noticia : listaNoticias) {
      out.write("\n");
      out.write("                            <article>\n");
      out.write("                                <h2>");
      out.print(noticia.getTitulo());
      out.write("</h2>\n");
      out.write("                                <h3>");
      out.print(noticia.getFecha());
      out.write("</h3>\n");
      out.write("                                <h1>");
      out.print(noticia.getTexto());
      out.write("</h1>\n");
      out.write("                            </article>\n");
      out.write("                         ");
}
      out.write("\n");
      out.write("                        \n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col col_30\">\n");
      out.write("                        <h3>Mi perfil</h3>\n");
      out.write("                        \n");
      out.write("                        <div class=\"col col_35\">\n");
      out.write("                        Mis Consolas\n");
      out.write("                        \n");
      out.write("                        </div>    \n");
      out.write("                   \n");
      out.write("                   \n");
      out.write("                    </div>\n");
      out.write("                   \n");
      out.write("                </section>\n");
      out.write("            </main>\n");
      out.write("            \n");
      out.write("            <footer>\n");
      out.write("                <h3>by Charles</h3>\n");
      out.write("            </footer>\n");
      out.write("        </div>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
