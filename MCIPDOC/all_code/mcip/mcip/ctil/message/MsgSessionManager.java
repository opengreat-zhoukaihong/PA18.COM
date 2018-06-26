package ctil.message;
import java.util.*;
public interface MsgSessionManager{
  public MsgSession CreateMsgSession(Client client, Server server);
  public void RegisterNewMsgSession(MsgSession session);
  public void RemoveMsgSession(MsgSession session);
  public void RemoveMsgSession(String sessionId);
  public int GetSessionCount();
  public Hashtable GetAllSessions();
  public void PauseSession(String sessionId);
  public void ContinueSession(String sessionId);
  public Vector GetMsgSessionsByClient(String clientName);
  public Vector GetMsgSessionsByServer(String serverName);
  public MsgSession GetMsgSession(String sessionId);
  public void EndMsgSession(String sessionID);
}