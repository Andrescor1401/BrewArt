package brew_art.model.bean;

public class Client {

    private long idClient;
    private String name;
    private String mail;
    private int age;
    private int totalPoints;

    public Client(long idClient, String name, String mail, int age, int totalPoints){
        this.idClient = idClient;
        this.name = name;
        this.mail = mail;
        this.age = age;
        this.totalPoints = totalPoints;
    }
    public Client(){}

    public long getIdClient() {
        return idClient;
    }

    public void setIdClient(long idClient) {
        this.idClient = idClient;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getTotalPoints() {
        return totalPoints;
    }

    public void setTotalPoints(int totalPoints) {
        this.totalPoints = totalPoints;
    }

    @Override
    public String toString() {
        return "Client [idClient=" + idClient + ", name=" + name + ", mail=" + mail + ", age=" + age + ", totalPoints="
                + totalPoints + "]";
    }
    
    
}
