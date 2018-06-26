package ctil.message;
import java.util.* ;
public interface MsgSession {
      
  public Client  GetClient();
  public void    SetClient(Client newClient);
  public Server  GetServer();
  public void    SetServer(Server newServer);
  public String  GetSessionId();
  public void SetSessionId(String sessionId);
  public void    AddClientMsg(Message newMessage);
  public void    AddServerMsg(Message newMessage);
  public LinkedList GetClientNewMsgs();
  public LinkedList GetServerNewMsgs();
  public GregorianCalendar GetSessionCreatedDate();
  public String  GetSubject();
  public void    ContinueSession();
  public void    PauseSession();
  public void  SetSubject(String subject);
  public  LinkedList  GetClientMsgs();
  public  LinkedList  GetServerMsgs();
  public String[][]  GetSessionHistoryBySubject();
  public String[][]  GetSessionHistoryByDate();
  public void EndSession();  

} 