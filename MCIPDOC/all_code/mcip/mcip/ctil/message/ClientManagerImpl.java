package ctil.message;
import java.util.*;
public class ClientManagerImpl implements ClientManager{
  private int clientCount ;
  private Hashtable clients;
  public ClientManagerImpl(){
      clientCount = 0;
      clients = new Hashtable(50);
  }
  public boolean IsClientLogged(String clientName){
      return clients.containsKey(clientName);
  }
  synchronized public void AddClient(String clientName,
                        String orgName,
                        String insurance,
                        String subject){

      Client client = new Client(clientName, orgName,
                                 insurance, subject);
      clients.put(clientName, client);
      clientCount++;
      
  }
  synchronized public void RemoveClient(String clientName){
     if(clients.containsKey(clientName)){
      System.out.println("Yes start remove client in ClientManagerImpl:"+clientName);
      Object obj = clients.remove(clientName);
       if(obj!= null){
        clientCount--;
      }
      if(clients.containsKey(clientName)){
         System.out.println("remove client failed");
      }else{
       System.out.println("remove client succ");
      }

     }
  }
  
  public int GetClientCount(){
      return clientCount;
  }
  public Client GetClient(String clientName){
      return  (Client)clients.get(clientName);
  }
  public boolean IsClientConnected(String clientName){
      Client client = (Client)clients.get(clientName);
      if(client==null){
        return false;
      }
      return client.IsConnected();
  }
  public Vector GetClientsNotConnected(){
      Vector v= new Vector(20);
      Enumeration e ;// = clients.elements();
      Client client;
      for(e = clients.elements(); e.hasMoreElements();){
        client = (Client)e.nextElement();
        if(!client.IsConnected()){
          v.add(client);
        }
      }
      return v;
  }
} 