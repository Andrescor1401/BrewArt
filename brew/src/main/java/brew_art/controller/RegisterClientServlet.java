package brew_art.controller;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import brew_art.dao.ClientDAO;
import brew_art.model.bean.Client;
import brew_art.model.service.AdminService;
public class RegisterClientServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException{
        String idClientParam = request.getParameter("idClient"); 
        String nameClientParam = request.getParameter("nameClient"); 
        String ageClientParam = request.getParameter("age");
        String mailClientParam = request.getParameter("mail");
        String totalPointsParam = request.getParameter("totalPoints");
        if (idClientParam == null || nameClientParam == null || ageClientParam == null || mailClientParam == null ||totalPointsParam == null) { 
            response.getWriter().println("Datos faltantes"); 
            return;
        }
        try {
        int idClient = Integer.parseInt(idClientParam);
        int age = Integer.parseInt(ageClientParam);
        int totalPoints = Integer.parseInt(totalPointsParam);
        ClientDAO clientDAO = new ClientDAO();
        AdminService adminService = new AdminService(clientDAO);
        Client newClient = adminService.createClient(idClient,nameClientParam,mailClientParam,age,totalPoints);
        if(newClient!= null){
            response.getWriter().println("Client registered");
        }else{
            response.getWriter().println("Datos invalidos o el usuario ya existe");
        }
            
        } catch (NumberFormatException e) {
            // TODO: handle exception
         response.getWriter().println("Formato de datos inválido"); 
        }

    }  
}
