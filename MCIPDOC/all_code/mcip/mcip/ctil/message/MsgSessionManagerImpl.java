package ctil.message;
import java.util.*;
public class MsgSessionManagerImpl implements MsgSessionManager{

  private MsgSessionFactory factory;
  private int sessionCount ;
  private Hashtable sessions;
  public MsgSessionManagerImpl(){
      sessionCount = 0;
      sessions = new Hashtable(50);
      factory = GetMsgSessionFactory();
  }
  public MsgSessionFactory GetMsgSessionFactory(){
      factory = new MsgSessionFactory();
      return  factory;
  }
  public MsgSession CreateMsgSession(Client client, Server server){
      MsgSession session = factory.CreateMsgSession(client,server);
      String sessionId = client.GetClientName()+"_"+ server.GetServerName(); 
      sessions.put(sessionId, session);
      sessionCount++;
      return session;
  }
  public void RegisterNewMsgSession(MsgSession session){
      sessions.put(session.GetSessionId(), session);
      sessionCount++ ;
  }
  public void RemoveMsgSession(MsgSession session){
      sessions.remove(session.GetSessionId());
      sessionCount--;
  }
  public void RemoveMsgSession(String sessionId){
      sessions.remove(sessionId);
      sessionCount--;
  }
  public int GetSessionCount(){
      return sessionCount;
  }
  public void PauseSession(String sessionId){
      MsgSession session = (MsgSession)sessions.get(sessionId);
      session.PauseSession();
  }
  public void ContinueSession(String sessionId){
      MsgSession session = (MsgSession)sessions.get(sessionId);
      session.ContinueSession();
  }
  public Vector GetMsgSessionsByClient(String clientName){
      
      Enumeration e = sessions.elements();
      Vector v = new Vector(40);
      MsgSession session;
      String name ;
      while(e.hasMoreElements()){
           session = (MsgSession)e.nextElement();
           name = session.GetClient().GetClientName();
           if(name.equalsIgnoreCase(clientName)){
              v.addElement(session);
           }
      }
      return  v;

  }
  public Vector GetMsgSessionsByServer(String serverName){

      Enumeration e = sessions.elements();
      Vector v = new Vector(40);
      MsgSession session;
      String name ;
      while(e.hasMoreElements()){
           session = (MsgSession)e.nextElement();
           name = session.GetServer().GetServerName();
           if(name.equalsIgnoreCase(serverName)){
              v.addElement(session);
           }
      }
      return  v;
  }
  public Hashtable GetAllSessions(){
      return sessions;
  }
  public MsgSession GetMsgSession(String sessionId){
      return (MsgSession)sessions.get(sessionId);
  }
  public void EndMsgSession(String sessionId){
      MsgSession session = (MsgSession)sessions.get(sessionId);
      session.EndSession();
  }
} 