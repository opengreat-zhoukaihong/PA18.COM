package ken;

import java.io.*;
import java.util.*;
import java.text.*;

public class LogOperator {
  private String fileName;
  private String logName1 = new String();//1类用户的日志
  private String logName2 = new String();//2类用户的日志
  private String logName3 = new String();//3类用户的日志

  private boolean hasBeenCalled = false;

  public boolean isHasBeenCalled(){
    return(hasBeenCalled);
  }
  public void Called(boolean flag){
    this.hasBeenCalled = flag;
  }

  public LogOperator() {
  }

  /**
  * 子构造：直接设置文件名。
  * param _fileName String 文件名
  */
  public LogOperator(String _fileName,
                     String _log1,
                     String _log2,
                     String _log3){
    this.fileName = new String();
    this.fileName = _fileName;
    this.logName1 = _log1;
    this.logName2 = _log2;
    this.logName3 = _log3;
  }

  /**
  * 设置文件名.
  * param _fileName String 文件名
  */
  public void setFileName(String _fileName){
    this.fileName = new String();
    this.fileName = _fileName;
  }

  /**
  * 设置日志文件的名称（应该是绝对路径）
  * param _log1 String
  * param _log2 String
  * param _log3 String
  */
  public void setLogName(String _log1,String _log2,String _log3){
    this.logName1 = _log1;
    this.logName2 = _log2;
    this.logName3 = _log3;
  }

  /**
  * 增加新的更新信息，哈希表里面有三种类型的信息，key是1、2、3;
  * param h Hashtable
  * param _addFlag1 boolean 是否增加在1类用户的日志
  * param _addFlag2 boolean 是否增加在2类用户的日志
  * param _addFlag3 boolean 是否增加在3类用户的日志
  * return boolean (更新成功/失败)
  */
  public boolean addNewLog(Hashtable h,
                           boolean _addFlag1,
                           boolean _addFlag2,
                           boolean _addFlag3){
    boolean tempF = true;
    Vector temV;
    String addedContent = new String();
    String logDate;
    SimpleDateFormat bartDateFormat =
      new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    Date date = new Date();
    logDate = bartDateFormat.format(date).toString();
    if(_addFlag1&&tempF){
      addedContent = logDate+" "+(String)h.get("1");
      temV = new Vector();
      temV = getLogContent(this.logName1);
      temV.addElement(addedContent);
      tempF = setLogContent(this.logName1,temV);
    }
    if(_addFlag2&&tempF){
      addedContent = logDate+" "+(String)h.get("2");
      temV = new Vector();
      temV = getLogContent(this.logName2);
      temV.addElement(addedContent);
      tempF = setLogContent(this.logName2,temV);
    }
    if(_addFlag3&&tempF){
      addedContent = logDate+" "+(String)h.get("3");
      temV = new Vector();
      temV = getLogContent(this.logName3);
      temV.addElement(addedContent);
      tempF = setLogContent(this.logName3,temV);
    }
    return(tempF);
  }

  /**
  * 根据取得新的日志记录
  * param _auth int 身份标志
  */
  public Hashtable getNewLog(int _auth){
    Hashtable tempH = new Hashtable();
    Vector temV = new Vector();
    String date = "";
    String content = "";
    if(_auth == 1){//如果是1类用户，则去取1类用户的日志文件
      temV = getLogContent(this.logName1);
    }
    if(_auth == 2){//如果是2类用户，则去取2类用户的日志文件
      temV = getLogContent(this.logName2);
    }
    if(_auth == 3){//如果是3类用户，则去取3类用户的日志文件
      temV = getLogContent(this.logName3);
    }
    if(temV.size()!=0){
      String logContent = (String)temV.elementAt(temV.size()-1);
      date = logContent.substring(0,19);
      content = logContent.substring(20).trim();
      tempH.put("LogDate",date);
      tempH.put("LogContent",content);
    }
    return(tempH);
  }

  /**
  * 读取日志文件内容
  * param _fileName String 文件的绝对路径和名称
  * return tempV 文件的内容
  */
  private Vector getLogContent(String _fileName){
    Vector tempV = new Vector();
    String record;
    try {
      FileReader fr = new FileReader(_fileName);
      BufferedReader br = new BufferedReader(fr);
      record = new String();
      while ((record = br.readLine()) != null) {
        System.out.println(record);
        tempV.addElement(record);
      }
      br.close();
      fr.close();
    } catch (IOException ex) {
      //如果没有这个文件则新增加一个。
      setLogContent(_fileName,tempV);
      System.out.println("Uh oh,the file doesnot exit,but I created one.");
      //ex.printStackTrace();
    }
    return(tempV);
  }

  /**
  * 写日志文件内容
  * param _fileName String 文件的绝对路径和名称
  * param tempV Vector 文件的内容
  */
  private boolean setLogContent(String _fileName,Vector tempV){
    boolean operaFlag = false;
    String tempStr = new String();
    try
		{
			PrintWriter pw = new PrintWriter(new FileOutputStream(_fileName));
      for(int i=0;i<tempV.size();i++){
        tempStr = tempV.elementAt(i).toString();
        pw.println(tempStr);
      }
			pw.close();
			operaFlag = true ;
		} catch(IOException e) {
			operaFlag = false;

		}
    return(operaFlag);
  }
} 