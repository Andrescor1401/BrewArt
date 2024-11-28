import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import brew_art.model.service.AdminService;
import brew_art.model.service.ClientService;
import brew_art.model.service.SaleService;
import brew_art.dao.ClientDAO;
import brew_art.model.bean.Client;
import brew_art.model.bean.Sale;

import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
public class AdminServiceTest {

    @Test
    public void createClientTest(){
        ClientDAO mockDAO = Mockito.mock(ClientDAO.class);
        Mockito.when(mockDAO.registerClient(Mockito.any(Client.class))).thenReturn(true);
        AdminService admin = new AdminService(mockDAO);
        final Client client = admin.createClient(1, "Kenier Andrés Corcho Galvan", "keniercorcho13@gmail.com", 25, 0);
        assertNotNull(client,"The client cant be null");
        assertEquals(1, client.getIdClient());
        assertEquals("Kenier Andrés Corcho Galvan", client.getName());
        assertEquals("keniercorcho13@gmail.com", client.getMail());
        assertEquals(25, client.getAge());
        assertEquals(0, client.getTotalPoints());
    }

    @Test
    public void updatePointsTest(){
        ClientDAO mockDao = Mockito.mock(ClientDAO.class);
        Client clientTest = new Client();
        clientTest.setIdClient(1);
        clientTest.setTotalPoints(50);
        Mockito.when(mockDao.getClient(Mockito.any(Client.class))).thenAnswer(invocation -> {
            Client clientArg = invocation.getArgument(0);
            clientArg.setIdClient(clientTest.getIdClient());
            clientArg.setTotalPoints(clientTest.getTotalPoints());
            return true;
        });
        Mockito.when(mockDao.updatePoints(Mockito.any(Client.class))).thenReturn(true);
        final ClientService client = new ClientService(mockDao);
        boolean resultTest = client.updatePointsClient(1, 20);
        assertTrue(resultTest);
        ArgumentCaptor<Client> clientCaptor = ArgumentCaptor.forClass(Client.class);
        verify(mockDao).updatePoints(clientCaptor.capture());

        // Obtener el cliente capturado
        Client capturedClient = clientCaptor.getValue();
        assertEquals(70, capturedClient.getTotalPoints());
        
       
    }

    
}
