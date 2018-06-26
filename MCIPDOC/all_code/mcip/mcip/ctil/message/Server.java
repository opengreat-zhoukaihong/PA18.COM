package ctil.message;
import java.beans.*;
import java.util.Date;
public class Server implements SessionServerListener{
  private Queue clientQueue;
  private int waitCount ;
  private boolean busy = false;
  private String serverName ;
  private String[] authInsurances;
  private String[] authOrgs;
  public Date loginDate;

  public Server(String serverName,String[] authInsurances,String[] authOrgs){
      this.serverName = serverName;
      clientQueue = new Queue();
      waitCount = 0;
      busy = false;
      loginDate = new Date();
      SetServerAuth(authInsurances, authOrgs);
  }
  public void SetServerAuth(String[] authInsurCdes, String[] authOrgs){
      this.authInsurances = authInsurCdes;
      this.authOrgs = authOrgs;
  }

  /* Commented by Liuxy
  public boolean IsAuthOrg(String orgName){
      if(authOrgs==null)return false;
      int size = authOrgs.length;
      for(int i=0 ;i< size ;i++){
        if(authOrgs[i]!=null && orgName.equals(authOrgs[i])){
          return true;
        }
      }
      return false;
  }
  public boolean IsAuthInsurance(String insuranceCde){
      if(insuranceCde==null || authInsurances==null)return false;
      int size = authInsurances.length;
      for(int i=0 ;i<size; i++){
        if(authInsurances[i]!=null && insuranceCde.equals(authInsurances[i])){
          return true;
        }
      }
      return false;
  }

  */
/*
public boolean IsAuthOrg(String[] orgs,String clientOrg){
	boolean isSucc = false;
	for(int i = 0 ; i < orgs.length; i++){
		if(orgs[i] != null){
			String a = orgs[i];
			if( clientOrg.length() >= a.length() && clientOrg.substring(a.length()).equals(a) ){
				isSucc = true;		
				break;
			}
		}
	}
	return isSucc;
}

public boolean IsAuthInsurance(String[] insurances,String clientInsur){
	boolean isSucc = false;
	for(int i = 0; i<insurances.length; i++){
		if(insurances[i] != null){
			if(insurances[i].equals(clientInsur)){
				isSucc = true;
				break;
			}
		}
	}
	return isSucc;
}
*/
//
public boolean IsAuthOrg(String clientOrg){
	boolean isSucc = false;
	if(clientOrg == null)return true;
	if(authOrgs==null)return false;
	for(int i = 0 ; i < authOrgs.length; i++){
		if(authOrgs[i] != null){
			String a = authOrgs[i];
			System.out.println("authOrgs---a:"+a);
			if( clientOrg.length()>= a.length() && clientOrg.substring(0,a.length()).equals(a)){
				isSucc = true;		
				break;
			}
		}
	}
	return isSucc;
}

public boolean IsAuthInsurance(String clientInsur){
	boolean isSucc = false;
	if(clientInsur==null)return true;
	if(authInsurances==null)return false;
	for(int i = 0; i<authInsurances.length; i++){
		if(authInsurances[i] != null){
			if(authInsurances[i].equals(clientInsur)){
				isSucc = true;
				break;
			}
		}
	}
	return isSucc;
}


  public String GetServerName(){
      return serverName;
  }
  public String GetLoginDate(){
    return loginDate.toString();
  }
  public void AcceptClient(String clientName){
    busy = true;
  }
  synchronized public void AddClient(String clientName, Client client){
    clientQueue.AddMember(clientName, client);
    waitCount++;
  }
  synchronized public void RemoveClient(String clientName){
    clientQueue.RemoveMember(clientName);
    waitCount--;
  }
  synchronized public void RemoveFirst(){
    clientQueue.RemoveFirst();
    waitCount--;
  }
  synchronized public void RemoveAllClients(){
    while(clientQueue.GetMemberCount()>0){
      clientQueue.RemoveFirst();
      waitCount--;
    }  
  }
  public Queue GetClientQueue(){
     return clientQueue;
  }
  public void TransferUnderWriter(){
    waitCount--;
  }
  public int  IndexOfClient(String client){
     return  0;
  }
  public int GetQueueSize(){
     return waitCount;
  }
  public boolean IsBusy(){
      return busy;
  }
  public void SetBusy(boolean busy){
      this.busy = busy;
  }
  public void propertyChange(PropertyChangeEvent evt){
  }

}