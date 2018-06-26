package ctil.message;
import java.util.*;
public class ServerManagerImpl  implements ServerManager{
  private int serverCount ;
  private Hashtable servers ;
  public ServerManagerImpl(){
      serverCount = 0;
      servers = new Hashtable(50);
  }
  public void AddServer(String serverName, String[] authInsurances, String[] authOrgs){
      Server server = new Server(serverName,authInsurances,authOrgs);
      servers.put(serverName, server);
      serverCount++ ;
  }

  public void RemoveServer(String serverName){
      Object obj = servers.remove(serverName);
      if(obj!= null){
        serverCount--; 
      }
  }
  public int GetServerCount(){
      System.out.println("ServerManager serverCount:"+ serverCount);
      return serverCount;
  }
  public Server GetServer(String serverName){
      return (Server)servers.get(serverName);
  }
  public boolean IsServerLogon(String serverName){
      return servers.containsKey(serverName);
  }
  public boolean IsServerBusy(String serverName){
      Server server = (Server)servers.get(serverName);
      return server.IsBusy();
  }
  public Vector GetServersFree(){
      Vector v= new Vector(20);
      Enumeration e ;// = clients.elements();
      Server server;
      for(e = servers.elements(); e.hasMoreElements();){
        server = (Server)e.nextElement();
        if(!server.IsBusy()){
          v.add(server);
        }
      }
      return v;
  }
  public Vector GetAllServers(){
      Vector v= new Vector(20);
      Enumeration e ;// = clients.elements();
      Server server;
      for(e = servers.elements(); e.hasMoreElements();){
        server = (Server)e.nextElement();
        v.add(server); 
      }
      return v;
  }
} 