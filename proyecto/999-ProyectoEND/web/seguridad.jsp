<%
    //Codigo de seguridad
    //--------------------
    //sino tenemos id_usuario en la session, acceso ilegal!!
    Integer id_usuario = (Integer)session.getAttribute("id_usuario");
    if(id_usuario==null){
        response.sendRedirect("index.html");
    }
    //----------------------
    //Fin codigo de seguridad
    %>

