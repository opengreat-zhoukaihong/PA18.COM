package ctil.message;
import java.util.Date ;
public class Message {
  public String username;
  public Date date;
  public int msgType;
  public String msgId;
  public String subject;
  public String body;
  public Message(String msgId ,int msgType,  String subject ,String text) {
    //this.msgId = msgId;
    //this.msgType = msgType;
    //this.subject = subject;
    //this.body = body;
    this(msgId,"",(new Date()),msgType,subject,text);
  }
  public Message(String msgId ,String username, int msgType,  String subject,String text){
    //this.msgId = msgId;
    //this.username = username;
    //this.msgType = msgType;
    //this.subject = subject;
    //this.body = text;
    this(msgId,username,(new Date()),msgType,subject,text);
  }
  public Message(String msgId ,String username, Date date, int msgType,  String subject ,String text){
    this.msgId = msgId;
    this.username = username;
    this.date = date;
    this.msgType = msgType;
    this.subject = subject;
    this.body = text;
  }
  
} 