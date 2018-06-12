package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class principal_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(1);
    _jspx_dependants.add("/seguridad.jsp");
  }

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


    //Codigo de seguridad
    //--------------------
    //sino tenemos id_usuario en la session, acceso ilegal!!
    Integer id_usuario = (Integer)session.getAttribute("id_usuario");
    if(id_usuario==null){
        response.sendRedirect("index.html");
    }
    //----------------------
    //Fin codigo de seguridad
    
      out.write('\n');
      out.write('\n');
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("   \n");
      out.write("        <link href=\"CSS/style.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <header>\n");
      out.write("            <h1>Panel<span>de</span>control</h1>\n");
      out.write("            <a href=\"CerrarSession\">\n");
      out.write("            <img src=\"img/logout23.png\" alt=\"\"/>\n");
      out.write("            </a>           \n");
      out.write("        </header>\n");
      out.write("        <nav>\n");
      out.write("               <div class=\"wrapper\">\n");
      out.write("                <div class=\"menu\">\n");
      out.write("                    <div class=\"submenu\">\n");
      out.write("                        <a href=\"principal.jsp\">home</a>\n");
      out.write("\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"submenu\">\n");
      out.write("                        <a href=\"publicaciones.jsp\">Publicaciones</a> \n");
      out.write("\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"submenu\">\n");
      out.write("                        <a href=\"pla.jsp\">Consolas</a>\n");
      out.write("\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"submenu\">\n");
      out.write("                        <a href=\"cuenta.jsp\">cuenta</a>\n");
      out.write("\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </nav>\n");
      out.write("        <main>\n");
      out.write("            <div class=\"wrapper\">\n");
      out.write("                <section>\n");
      out.write("                    <div class=\"col col_1\">\n");
      out.write("                        <h2>Panel de control de GameTeam </h2>\n");
      out.write("                        <p>\n");
      out.write("                         Bienvenido al panel de administración de GameTeam.\n");
      out.write("                         \n");
      out.write("                         Aquí podrás dar de alta nuevas publicaciones, Juegos y Consolas en la web.\n");
      out.write("                        </p>\n");
      out.write("\n");
      out.write("                    </div>                    \n");
      out.write("                </section>                \n");
      out.write("            </div>\n");
      out.write("        </main>\n");
      out.write("          \n");
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
