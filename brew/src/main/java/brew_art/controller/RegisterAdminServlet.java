package brew_art.controller;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import brew_art.dao.AdminDAO;
import brew_art.model.bean.Admin;
import brew_art.model.service.AdminService;


public class RegisterAdminServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException{
        String idAdminParam = request.getParameter("idAdmin"); 
        String nameAdminParam = request.getParameter("nameAdmin"); 
        String ageAdminParam = request.getParameter("age");
        String passwordAdminParam = request.getParameter("password");
        if (idAdminParam == null || nameAdminParam == null || ageAdminParam == null || passwordAdminParam == null) { 
            response.getWriter().println("Datos faltantes"); 
            return;
        }
        try {
        int idAdmin = Integer.parseInt(idAdminParam);
        int age = Integer.parseInt(ageAdminParam);
        int password = Integer.parseInt(passwordAdminParam);
        AdminDAO adminDAO = new AdminDAO();
        AdminService adminService = new AdminService(adminDAO);
        Admin newAdmin = adminService.createAdmin(idAdmin,nameAdminParam,age,password);
        if(newAdmin!= null){
            response.getWriter().println("Admin registered");
        }else{
            response.getWriter().println("Datos invalidos o el usuario ya existe");
        }
            
        } catch (NumberFormatException e) {
            // TODO: handle exception
         response.getWriter().println("Formato de datos inválido"); 
        }

    }  
    
}
