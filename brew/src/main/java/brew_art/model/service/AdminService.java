package brew_art.model.service;
import brew_art.model.bean.Admin;
import brew_art.model.bean.Client;
import brew_art.dao.AdminDAO;
import brew_art.dao.ClientDAO;

public class AdminService {
    private ClientDAO clientDAO;
    private AdminDAO adminDAO;
    public AdminService(ClientDAO clientDAO){
        this.clientDAO = clientDAO;
    }
    public AdminService(AdminDAO adminDAO){
        this.adminDAO = adminDAO;
    }

    public Client createClient(long idClient,String name, String mail,int age, int totalPoints){
        Client newClient = new Client(idClient, name, mail, age, totalPoints);

        if(clientDAO.registerClient(newClient)){
            return newClient;     
        }
        return null;
    }
    public Admin createAdmin(int idAdmin, String name, int age, int password){
        Admin newAdmin = new Admin(idAdmin,name,age,password);
        if(adminDAO.registerAdmin(newAdmin)){
            return newAdmin;
        }
        return null;
    } 

    public Admin loginAdmin(int idAdmin, int password){
        Admin adminToValidate = new Admin();
        adminToValidate.setIdAdmin(idAdmin);
        adminToValidate.setPassword(password);
        if(adminDAO.getAdmin(adminToValidate)){
            return adminToValidate;
        }
        return null;
    }

    public static void main(String[] args) {
        AdminDAO adminDAO = new AdminDAO();
        AdminService admin = new AdminService(adminDAO);
        //admin.createAdmin(1, "Andres lopez", 20, 1401);

        Admin admin2 = admin.loginAdmin(1, 1407);
        if(admin2!= null){
            System.out.println("Acceso permitido");
        }else{
            System.out.println("Datos invalidos");
        }
        
    }
    
}
