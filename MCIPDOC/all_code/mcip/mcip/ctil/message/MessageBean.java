package ctil.message;
import java.util.*;
import java.beans.*;
import javax.servlet.http.*;
public class MessageBean{
  private static MessageServer delegation;
  private static boolean Inited = false;
  public static MessageBean instance = new MessageBean();
  public MessageBean(){
    delegation = new MessageServer();
    Thread thread = new Thread(delegation);
    thread.start();
  }
  public static MessageServer GetMessageServer(){
      if(Inited){
       return delegation ;
      }else{
        delegation = new MessageServer();
        Thread thread = new Thread(delegation);
        thread.start();
        Inited = true;
        return delegation;
      }
  }
  // ---------debug---------------------------------
  public void SetRequest(int cm, HttpServletRequest request){
      delegation.SetRequest(cm , request);
  }
  public String GetResult(){
      return  delegation.GetCommand();
  }
  //------------------------------------------------
  
  public boolean IsClientLogged(String clientName){
     return delegation.IsClientLogged(clientName);
  }
  public boolean IsClientConnected(String clientName){
     return delegation.IsClientConnected(clientName);
  }
  public void  TransferServer(String sessionId, String newServerName)
  {
     delegation.TransferSession(sessionId, newServerName);
  }
  public Vector GetClientsNotConnected(){
         return delegation.GetClientsNotConnected(); 
  }
  public void  ClientLogin(String clientName, String orgName, String insurance,String subject){
      delegation.ClientLogin(clientName,orgName,insurance,subject);
  }
  public void AddClientPreMessage(String clientName,String mess){
      delegation.AddClientPreMessage(clientName,mess);
  }
  public void AddClientMessage(String sessionId, Message message){
      delegation.AddClientMessage(sessionId, message);
  }
  public LinkedList GetClientNewMsgs(String sessionId){
      return delegation.GetClientNewMsgs(sessionId);
  }
  public String GetSessionId(String clientName){
      return delegation.GetSessionId(clientName);
  }
  public LinkedList GetClientMessages(String sessionId){
      return delegation.GetClientMessages(sessionId);
  }
  public void ClientExit(String sessionId, String clientName){
      delegation.ClientExit(sessionId, clientName);
  }
  public int GetServerCount(){
     return  delegation.GetServerCount();
  }
  public Server GetServer(String serverName){
      return delegation.GetServer(serverName); 
  }
  public Vector GetAllServers(){
      return delegation.GetAllServers();
  }
  public Vector GetServersFree(){
     return   delegation.GetServersFree();
  }
  public void ServerLogin(String serverName, String[] authInsurances, String[] authOrgs){
      delegation.ServerLogin(serverName, authInsurances, authOrgs);
  }
  public void AddServerMessage(String sessionId, Message message){
      delegation.AddServerMessage(sessionId, message);
  }
  public LinkedList GetServerNewMsgs(String sessionId){
      return delegation.GetServerNewMsgs(sessionId);
  }
  public LinkedList GetServerMessages(String sessionId){
      return delegation.GetServerMessages(sessionId);
  }
  public void ServerExit(String sessionId, String serverName){
      delegation.ServerExit(sessionId, serverName);
  }
  public int GetMemberCount(){
    return delegation.GetMemberCount();
  }
  public boolean  SetConnection(String clientName, String serverName){
     return delegation.SetConnection(clientName, serverName);
  }
  public Hashtable GetAllSessions(){
      return delegation.GetAllSessions();
  }
} 