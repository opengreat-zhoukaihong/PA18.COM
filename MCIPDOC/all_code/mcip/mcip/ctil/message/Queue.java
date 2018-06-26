package ctil.message;
import java.util.*;
public class Queue{
  private Vector team;
  private Vector clientNames;
  public Queue(){
       team = new Vector(20);
       clientNames = new Vector(20);
  }
  public void AddMember(String clientName, Client member){
       clientNames.add(clientName);
       team.add(member);
  }
  public void InsertMember(int index, Client member){
     ;
  }
  public void RemoveMember(String clientName){
      if(!team.isEmpty() && team.indexOf(clientName)>0){
         team.remove(clientName);
         clientNames.remove(clientName);
      }  
  }
  public Client RemoveFirst(){

      if(clientNames.size()>0){
         Client client = (Client)(team.firstElement());
         team.remove(0);
         clientNames.remove(0);
         return client;
      }else{
        return null;
      }
  }
  public int getIndex(String clientName){
      return clientNames.indexOf(clientName);
  }
  public int GetMemberCount(){
      return team.size() ;
  }
  public Vector GetMembers(){
      return team;
  } 
}