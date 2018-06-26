package ctil.message;
import java.io.*;
import java.util.*;
import javax.servlet.http.*;
public class MessageServer implements Runnable{
  private MsgSessionManager msgSessionManager;
  private ClientManager clientManager;
  private ServerManager serverManager;
  private String[][] params[];
  private boolean  hasRequest;
  private HttpServletRequest request;
  private int command = 0;
  private boolean retBoolean =false;
  private Vector  retVector = null;
  private LinkedList retLinkedList=null;
  private String message= "" ;

  public MessageServer(){
      msgSessionManager = new MsgSessionManagerImpl();
      clientManager = new ClientManagerImpl();
      serverManager = new ServerManagerImpl();
      request = null ;
      hasRequest = false ;
  }
  public String GetCommand(){
      return "Yes:"+command+ message;
  }
  public boolean IsClientLogged(String clientName){
      return  clientManager.IsClientLogged(clientName);
  }
  public boolean IsClientConnected(String clientName){
      return clientManager.IsClientConnected(clientName);
  }
  public Vector GetClientsNotConnected(){
         return clientManager.GetClientsNotConnected();
  }
  public void  ClientLogin(String clientName, String orgName, String insurance,String subject){
      clientManager.AddClient(clientName,orgName,insurance,subject);
  }
  public void   AddClientPreMessage(String clientName,String mess){
     Client client = clientManager.GetClient(clientName);
     client.AddPreMessage(mess);
  }
  public void AddClientMessage(String sessionId, Message message){
      MsgSession session = msgSessionManager.GetMsgSession(sessionId);
      session.AddClientMsg(message);
  }
  public LinkedList GetClientNewMsgs(String sessionId){
      MsgSession session = msgSessionManager.GetMsgSession(sessionId);
      if(session==null)return null;
      return session.GetClientNewMsgs();
  }
  public LinkedList GetClientMessages(String sessionId){
      MsgSession session = msgSessionManager.GetMsgSession(sessionId);
      if(session==null)return null;
      return session.GetClientMsgs();
  }
  public void ClientExit(String sessionId, String clientName){
     // msgSessionManager.EndMsgSession(sessionId);
     System.out.println("ClientExit:"+sessionId +","+ clientName);
     if(clientManager!=null){
      if(clientName!=null)
       clientManager.RemoveClient(clientName);
       if(sessionId!=null){
         msgSessionManager.RemoveMsgSession(sessionId);
       }
     }
  }
  public Server GetServer(String serverName){
     return serverManager.GetServer(serverName);
  }
  public int GetServerCount(){
     return  serverManager.GetServerCount();
  }
  public Vector GetAllServers(){
      return serverManager.GetAllServers();
  }
  public Vector GetServersFree(){
     return   serverManager.GetServersFree();
  }
  public void ServerLogin(String serverName, String[] authInsurances, String[] authOrgs){
     if(!serverManager.IsServerLogon(serverName)){
       serverManager.AddServer(serverName, authInsurances, authOrgs);
     }
  }
  public void AddServerMessage(String sessionId, Message message){
     try{
       MsgSession session = msgSessionManager.GetMsgSession(sessionId);
       if(session==null){
         System.out.println(sessionId);
         System.out.println("Can't get session");
       }
       session.AddServerMsg(message);
     }catch(Exception e){e.printStackTrace();}
  }
  public LinkedList GetServerNewMsgs(String sessionId){
      MsgSession session = msgSessionManager.GetMsgSession(sessionId);
      if(session==null)return null;
      return session.GetServerNewMsgs();
  }
  public LinkedList GetServerMessages(String sessionId){
      MsgSession session = msgSessionManager.GetMsgSession(sessionId);
      return session.GetServerMsgs();
  }
  public void ServerExit(String sessionId,String serverName){   

      //Added on 02/16/2001
      Vector sessions= msgSessionManager.GetMsgSessionsByServer(serverName);
      int size = sessions.size();
      MsgSession session ;
      String clientName;
      for(int i=0 ;i <size; i++){
        session = (MsgSession)sessions.elementAt(i);
        clientName = session.GetClient().GetClientName();
        ClientExit(session.GetSessionId(), clientName);
      }
      serverManager.RemoveServer(serverName);
      
  }
  public void SetRequest(int cm, HttpServletRequest request){
      command = cm;
      this.request  = request;
      hasRequest = true ;
      message = message+ "\n"+ request.getParameter("message");
  }
  public boolean  SetConnection(String clientName, String serverName){
      Client client = clientManager.GetClient(clientName);
      Server server = serverManager.GetServer(serverName);
      if(client==null||server==null){
        if(client==null)
        System.out.println("set connection in MessageSever:client is null");
        if(server==null)
        System.out.println("set connection in MessageSever:client is null");
        return false;
      }
      MsgSession session = msgSessionManager.CreateMsgSession(client, server);
      if(session==null){
        System.out.println("session is null in set connection");
        return false;
      }else{
        System.out.println("set connection:"+ clientName+"_"+serverName);
        client.setConnected(true);
        String sessionId = clientName+"_"+serverName;
        client.SetSessionId(sessionId);
        server.SetBusy(true);
        Vector v= client.GetPreMessages();
        System.out.println("client premessage v.size:"+v.size());
        for(int i= 0 ; i< v.size(); i++){
          System.out.println("Pre message add ----MessageServer.java "+i);
          String mess = (String)v.elementAt(i);
          System.out.println("Pre message i:"+i+","+mess);
          Message message = new Message("",1,"subject",mess);
          //AddClientMessage(sessionId, message);
          session.AddClientMsg(message);
        }
        client.RemovePreMessages();
        return true;
      }
  }
  public void TransferSession(String sessionId, String serverName){
      MsgSession session = msgSessionManager.GetMsgSession(sessionId);
      msgSessionManager.RemoveMsgSession(sessionId);
      Client client = session.GetClient();
      Server oldServer = session.GetServer();
      Server newServer = serverManager.GetServer(serverName);
      newServer.SetBusy(true);
      newServer.AddClient(client.GetClientName(), client);
      session.SetServer(newServer);
      client.SetSessionId(client.GetClientName()+"_"+serverName);
      session.SetSessionId(client.GetClientName()+"_"+serverName);
      msgSessionManager.RegisterNewMsgSession(session);
      
  }
  public boolean ClearConnection(String sessionId){
      MsgSession session = msgSessionManager.GetMsgSession(sessionId);
      if(session==null){
        msgSessionManager.RemoveMsgSession(sessionId);
      }
      return true;
  }
  public String GetSessionId(String clientName){
      if(clientName==null){
        return null;
      }
      Client client = clientManager.GetClient(clientName);
      if(client==null){
         return null;
      }
      return client.GetSessionId();
  }
  public void DoRequest(HttpServletRequest request){
     //It's will be updated in here---Clarkrao
       System.out.println("Do request in server :");
       switch(command){
        case MsgConst.Client_Login:
         break;
        case MsgConst.Client_Exit:
         break;
        case MsgConst.Send_Client_Msg :
         break;
        case MsgConst.Get_Client_New_Msg: 
          break;
        case MsgConst.Server_Login :
          break;
        case MsgConst.Server_Exit:
          break;
        case MsgConst.Send_Server_Msg:
         break;
        case MsgConst.Get_Server_New_Msg:
         break;
       }
  }

  public void run(){
    while(true){
       if(hasRequest){
         DoRequest(request);
         hasRequest = false;
       }
       try
         {
            Thread.sleep(5);
         }
         catch(InterruptedException ex)
         {
            ;
         }
     }
  }
  public int GetMemberCount(){
      return clientManager.GetClientCount(); 
  }
  public Hashtable GetAllSessions(){
      return msgSessionManager.GetAllSessions();
  }
  
  //private boolean retBoolean =false;
  //private Vector  retVector = null;
  //private LinkedList retLinkedList=null;
  public static void main(String args[]){
     MessageServer ms = new MessageServer();
     Thread thread = new Thread(ms);
     thread.start();
  }
}