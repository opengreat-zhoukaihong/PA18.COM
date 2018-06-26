package ctil.message;
import java.util.*;
public class MessageQueue {
  private Vector team; 
  public MessageQueue(){
       team = new Vector(20);
  }
  public void AddMessage(Message msg){
       team.add(msg);
  }
  public void InsertMessage(int index, Message  msg){
     ;
  }
  public void RemoveMessage(Message msg){
      if(!team.isEmpty() && team.indexOf(msg)>0){
        team.remove(msg);
      }
  }
  public void RemoveFirst(){
      if(team.size()>0){
        team.remove(0);
      }
  }
  public Message GetFirst(){
       if(GetMessageCount() >0){
        return null;
       }else{
        return (Message)team.get(0);
       }
  }
  public int getIndex(Message msg){
      if(team.size()>0){
        return team.indexOf(msg);
      }else{
        return -1;
      }
  }
  public int GetMessageCount(){
      return team.size() ;
  }
}
