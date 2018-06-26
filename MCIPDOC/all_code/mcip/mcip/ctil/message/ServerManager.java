package ctil.message;
import java.util.*;
public interface ServerManager{
  public void AddServer(String serverName, String[] authInsurances, String[] authOrgs);
  public void RemoveServer(String serverName);
  public int GetServerCount();
  public Server GetServer(String serverName);
  public boolean IsServerLogon(String serverName);
  public boolean IsServerBusy(String serverName);
  public Vector GetServersFree();
  public Vector GetAllServers();

} 