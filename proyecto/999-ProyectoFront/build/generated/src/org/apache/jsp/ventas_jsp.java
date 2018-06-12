package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import es.cice.models.Publicacion;
import es.cice.models.Plataforma;
import java.util.ArrayList;
import java.sql.ResultSet;
import es.cice.controller.BDManager;

public final class ventas_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
    BDManager bdManager = new BDManager();
    String sql = "SELECT * FROM categorias";
    ResultSet result = bdManager.execSelect(sql);
    ArrayList<Plataforma> listaPlataformas = new ArrayList<Plataforma>();

    try {
        while (result.next()) {
            String nombre = result.getString("nombre");
            int id_categoria = result.getInt("id_categoria");
            Plataforma pla = new Plataforma(id_categoria, nombre);
            listaPlataformas.add(pla);

        }
    } catch (Exception e) {

    }

    //Obtener todas las entradas de la BBDD
    sql = "SELECT * FROM entradas ORDER BY id DESC";
    result = bdManager.execSelect(sql);
    ArrayList<Publicacion> listaPublicaciones = new ArrayList<Publicacion>();
    try {
        while (result.next()) {
            String id_publicacion = result.getString("id_publicacion");
            String nombre = result.getString("nombre");
            String precio = result.getString("precio");
            String fecha = result.getString("fecha");
            Publicacion pub = new Publicacion(id_publicacion, nombre, precio, fecha);
            listaPublicaciones.add(pub);

        }
    } catch (Exception e) {
        System.out.println("error al select de entradas");
    }


      out.write("\n");
      out.write("\n");
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
      out.write("                        <a href=\"bakery.jsp\">Bakery</a>\n");
      out.write("                    </li>\n");
      out.write("                    <li>\n");
      out.write("                        <a href=\"productos.jsp\">Productos</a>\n");
      out.write("                    </li>\n");
      out.write("                    <li>\n");
      out.write("                        <a href=\"eventos.jsp\">Eventos</a>\n");
      out.write("                    </li>\n");
      out.write("                    <li>\n");
      out.write("                        <a href=\"localizacion.jsp\">Localización</a>\n");
      out.write("                    </li>\n");
      out.write("                    <li>\n");
      out.write("                        <a href=\"contacto.jsp\">Contacto</a>\n");
      out.write("                    </li>\n");
      out.write("                </ul>\n");
      out.write("            </nav>\n");
      out.write("            <div class=\"col col_70\">\n");
      out.write("                Poner en Venta:\n");
      out.write("             \n");
      out.write(" \n");
      out.write("                            <!-- lista de entradas -->\n");
      out.write("                            ");
for (Publicacion publicacion : listaPublicaciones) {
      out.write("\n");
      out.write("                            <article>\n");
      out.write("                                <h2>");
      out.print(publicacion.getNombre());
      out.write("</h2>\n");
      out.write("                                <h3>");
      out.print(publicacion.getFecha());
      out.write("</h3>\n");
      out.write("                                <p>\n");
      out.write("                                    ");
      out.print(publicacion.getPrecio());
      out.write("\n");
      out.write("                                </p>\n");
      out.write("                                <div class=\"col col_2\">\n");
      out.write("                                    <a href=\"Deletepublicacion?id_publicacion=");
      out.print(publicacion.getId());
      out.write("\" class=\"cancelar\">eliminar</a>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"col col_2\">\n");
      out.write("                                    <a href=\"editar.jsp?id_publicacion=");
      out.print(publicacion.getId() );
      out.write("\" class=\"neutro\">editar</a>\n");
      out.write("                                </div>\n");
      out.write("                            </article>\n");
      out.write("                            ");
}
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"col col_30\">\n");
      out.write("                            <!-- formulario para entrada -->\n");
      out.write("                            <h2>Nueva Entrada</h2>\n");
      out.write("                            <form action=\"InsertarPublicacion\" method=\"POST\">\n");
      out.write("                                <input type=\"text\" name=\"txt_nombre\" placeholder=\"nombre\">\n");
      out.write("                                <textarea name=\"txt_publicacion\" placeholder=\"publicacion\"></textarea>\n");
      out.write("                                <select name=\"plataforma\">\n");
      out.write("                                    ");
for (Plataforma pla : listaPlataformas) {
      out.write("\n");
      out.write("                                    <option value=\"");
      out.print(pla.getId_plataforma());
      out.write('"');
      out.write('>');
      out.print(pla.getNombre());
      out.write("</option>  \n");
      out.write("                                    ");
}
      out.write("\n");
      out.write("                                </select>\n");
      out.write("                                <input type=\"submit\" value=\"Vender\">\n");
      out.write("                            </form>\n");
      out.write("\n");
      out.write("             \n");
      out.write("                \n");
      out.write("               \n");
      out.write("            </div>\n");
      out.write("            <main class=\"blanco\">\n");
      out.write("                <section>\n");
      out.write("                    \n");
      out.write("                    <article class=\"col col_1\">\n");
      out.write("                        <h2>Productos</h2>\n");
      out.write("                        \n");
      out.write("                        <div class=\"col col_2\">\n");
      out.write("                            <a href=\"CookiesManager?pro=bebidas\">\n");
      out.write("                                <img src=\"img/productos/fo1.png\" alt=\"\"/>\n");
      out.write("                            </a>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"col col_2\">\n");
      out.write("                            <a href=\"CookiesManager?pro=tartas\">\n");
      out.write("                                <img src=\"img/productos/fo2.png\" alt=\"\"/>\n");
      out.write("                            </a>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"col col_2\">\n");
      out.write("                            <a href=\"CookiesManager?pro=galletas\">\n");
      out.write("                                <img src=\"img/productos/fo3.png\" alt=\"\"/>\n");
      out.write("                            </a>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"col col_2\">\n");
      out.write("                            <a href=\"CookiesManager?pro=cupcakes\">\n");
      out.write("                                <img src=\"img/productos/fo4.png\" alt=\"\"/>\n");
      out.write("                            </a>\n");
      out.write("                        </div>\n");
      out.write("                        \n");
      out.write("                    </article>\n");
      out.write("                    \n");
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
