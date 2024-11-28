package brew_art.model.service;
import brew_art.model.bean.Client;
import brew_art.dao.ClientDAO;
public class ClientService {
    private ClientDAO clientDAO;

    public ClientService(ClientDAO clientDAO){
      this.clientDAO = clientDAO;  
    }

    public Client getClientById(int idClient){
        Client clientToSearch = new Client();
        clientToSearch.setIdClient(idClient);
        if(clientDAO.getClient(clientToSearch)){
            return clientToSearch;
        }
        return null;
    }

    public boolean updatePointsClient(int idClient, int pointsEarned){
        ClientService clientService = new ClientService(clientDAO);
        Client clientToUpdatePoints = clientService.getClientById(idClient); 
        if(clientToUpdatePoints!= null){
            int currentPoints = clientToUpdatePoints.getTotalPoints();
            clientToUpdatePoints.setTotalPoints(currentPoints + pointsEarned);

            return clientDAO.updatePoints(clientToUpdatePoints);
        }   

        return false;

    }

    
}
