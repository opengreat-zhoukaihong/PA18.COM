package ctil.message;

public class MsgSessionFactory{
  private MsgSession session;
  public static MsgSessionFactory instance = new  MsgSessionFactory();
  public MsgSession CreateMsgSession(Client client, Server server){
       session = new MsgSessionImpl(client, server);
       return session;
  }
} 