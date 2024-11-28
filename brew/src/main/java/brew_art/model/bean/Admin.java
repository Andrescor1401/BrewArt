package brew_art.model.bean;

public class Admin {

    private long idAdmin;
    private String name;
    private int age;
    private int password;

    public Admin(long idAdmin, String name, int age, int password){
        this.idAdmin = idAdmin;
        this.name = name;
        this.age = age;
        this.password = password;
    }
    public Admin(){}

    public long getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(long idAdmin) {
        this.idAdmin = idAdmin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Admin [idAdmin=" + idAdmin + ", name=" + name + ", age=" + age + ", password=" + password + "]";
    }
    
    
}
