package ctil.message;
import java.util.*;
public class MsgSessionImpl implements MsgSession{
  private Client client;
  private Server server;
  private String sessionId;
  private String clientName, serverName;
  private GregorianCalendar createdDate, exitDate;
  private String subject;
  private LinkedList clientMessages,clientNewMessages, serverMessages, serverNewMessages;
  private boolean clientLocked, serverLocked;
  public MsgSessionImpl(Client client, Server server){
      this.client = client;
      this.server = server;
      sessionId = client.GetClientName() + "-" + server.GetServerName();
      createdDate = new  GregorianCalendar();
      clientMessages = new LinkedList();
      serverMessages = new LinkedList();
      clientNewMessages = new  LinkedList();
      serverNewMessages = new  LinkedList();
      clientLocked = false;
      serverLocked = false;
  }
  public void run(){

  }
  public Client  GetClient(){
      return client;
  }
  public void SetClient(Client newClient){
      client = newClient;
  }
  public Server  GetServer(){
      return server;
  }
  public void SetServer(Server newServer){
      server = newServer;
  }
  public String  GetSessionId(){
      return sessionId;
  }
  public void SetSessionId(String sessionId){
      this.sessionId = sessionId ;
  }
  public String  GetSubject(){
      return  subject;
  }
  public void  SetSubject(String subject){
      this.subject = subject;
  }
  public GregorianCalendar GetSessionCreatedDate(){
      return createdDate;
  }
  public void  ContinueSession(){
      ;
  }
  public void  PauseSession(){
      ;
  }
  synchronized public void  AddClientMsg(Message newMessage){
      clientMessages.add(newMessage);
      clientNewMessages.add(newMessage);
  }
  synchronized public void  AddServerMsg(Message newMessage){
      serverMessages.add(newMessage);
      serverNewMessages.add(newMessage);
  }
  synchronized public LinkedList GetClientNewMsgs(){
      LinkedList v = new LinkedList();
      while(clientNewMessages.size()>0){
         Object obj = clientNewMessages.removeFirst();
         v.add(obj);
      }
      return v;//clientNewMessages;
  }
  synchronized public LinkedList GetServerNewMsgs(){
      LinkedList v =  new LinkedList();
      System.out.println("rhm1:"+v.size());
      System.out.println("rhm2:"+serverNewMessages.size());
      while(serverNewMessages.size()>0){
          Object obj = serverNewMessages.removeFirst();
          v.add(obj);
      }
      System.out.println("rhm3:"+v.size());
      System.out.println("rhm4:"+serverNewMessages.size());
      return v;//serverNewMessages;
  }
  synchronized public LinkedList  GetClientMsgs(){
      return clientMessages;
  }
  synchronized public LinkedList  GetServerMsgs(){
      return serverMessages;
  }
  public String[][]  GetSessionHistoryBySubject(){
      return null;
  }
  public String[][] GetSessionHistoryByDate(){
      return null;
  }
  public void EndSession(){
      ;
  }
  public void AddSessionClientListener(SessionClientListener listener){
  }
  public void RemoveSessionClientListener(SessionClientListener listener){
  }
  public void AddSessionServerListener(SessionServerListener listener){
  }
  public void RemoveSessionServerListener(SessionServerListener listener){
  } 

}