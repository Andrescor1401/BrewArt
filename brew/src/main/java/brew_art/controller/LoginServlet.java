package brew_art.controller;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import brew_art.dao.AdminDAO;
import brew_art.model.service.AdminService;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException{
        String usernameParam = request.getParameter("username"); 
        String passwordParam = request.getParameter("password"); 
        if (usernameParam == null || passwordParam == null) { 
            response.getWriter().println("Datos faltantes"); 
            return;
        }
        try {
        int username = Integer.parseInt(usernameParam);
        int password = Integer.parseInt(passwordParam);
        AdminDAO adminDAO = new AdminDAO();
        AdminService adminService = new AdminService(adminDAO);
        if(adminService.loginAdmin(username, password)!= null){
            //response.getWriter().println("Welcome admin");
            response.sendRedirect("public_html/menu.html");
        }else{
            response.getWriter().println("Datos invalidos");
        }
            
        } catch (NumberFormatException e) {
            // TODO: handle exception
         response.getWriter().println("Formato de datos inválido"); 
        }

    }  
}
