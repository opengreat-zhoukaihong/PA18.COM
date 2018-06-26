package ctil.message;
import java.util.*;
public interface ClientManager{
  public void AddClient(String clientName,String orgName,String insurance,String subject);
  public void RemoveClient(String clientName);
  public int GetClientCount();
  public Client GetClient(String clientName);
  public boolean IsClientConnected(String clientName);
  public boolean IsClientLogged(String clientName);
  public Vector GetClientsNotConnected(); 

}