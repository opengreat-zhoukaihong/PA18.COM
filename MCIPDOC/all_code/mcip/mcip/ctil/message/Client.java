package ctil.message;
import java.beans.*;
import java.util.* ; 
public class Client implements SessionClientListener{
  private String clientName;
  private boolean connected ;
  private MsgSession session;
  private boolean isConnected;
  private String orgName, insurance, subject;
  private Date  loginDate;
  private Vector messages;
  private String sessionId = null;
  public Client(String clientName, String orgName,String insurance, String subject){
     this.clientName = clientName;
     this.insurance = insurance;
     this.orgName = orgName;
     this.subject = subject;
     connected = false ;
     loginDate = new Date();
     messages = new Vector(10);
  }
  public String GetClientName(){
     return clientName;
  }
  public String GetInsurance(){
      return insurance;
  }
  public String GetOrgName(){
      return orgName;
  }
  public String GetSubject(){
      return subject;
  }
  public String GetLoginDate(){
     return loginDate.toString();
  }
  public String GetSessionId(){
    return sessionId;
  }
  public void SetSessionId(String newSessionId){
    sessionId = newSessionId;
  }
  public void RequestMsgSession(){

  }
  public void  ExitMsgSession(){
     ;
  }
  public void  AddMessage(Message newMessage){
      session.AddClientMsg(newMessage);

  }
  public void AddPreMessage(String newMessage){
     System.out.println("yes client.java add premessage:");
     messages.addElement(newMessage);
     System.out.println("messages size:"+ messages.size());
  }
  public Vector GetPreMessages(){
      return messages;
  }
  public void RemovePreMessages(){
      messages.clear();
  }
  public boolean IsConnected(){
      return isConnected;
  }
  public void setConnected(boolean connected){
      isConnected = connected;
  }
  public void propertyChange(PropertyChangeEvent evt){
  }


} 