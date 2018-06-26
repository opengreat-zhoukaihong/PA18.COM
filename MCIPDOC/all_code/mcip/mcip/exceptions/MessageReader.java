package exceptions;

import java.lang.String;
import java.util.Hashtable;
import java.io.BufferedReader;
import java.io.FileReader;

import java.util.Properties;
import java.io.FileInputStream;

public class MessageReader {

  private final static String DELIMITER = ";";
  private Hashtable messageHolder = null;
  private static MessageReader instance = null;

  /*
  create the MessageReader instance
  */
  private static synchronized void createInstance(String filename) {
    if (instance == null) {
      instance = new MessageReader(filename);
    }
  }

  /*
  Return the MessageReader instance.
  If the MessageReader doesn't exist, create one.
  */
  public static MessageReader getInstance() {

    try {
      if (instance == null) {
        Properties info = new Properties();
        FileInputStream in = new FileInputStream("msg.properties");
        info.load(in);
        String filename = info.getProperty("errormsg");
        createInstance(filename);
      }
    }
    catch(Exception ex) {
      System.out.println(ex.getMessage());
    }

    return instance;
  }

  /*
  Default Constructor
  */
  protected MessageReader(){
  }

  /*
  Constructor which accept the filename (string) as parameter
  */
  protected MessageReader(String filename) {
    readFile(filename);
  }

  /*
  Read error code and description from file and
  store them into the HashTable
  HashTable key = error code
  HashTable value = error description
  */
  private void readFile(String filename){
    String tmpLine;
    int index = 0;
    int len = 0;
    try {
      BufferedReader srcFile = new BufferedReader( new FileReader(filename) );
      messageHolder = new Hashtable();
      while( (tmpLine=srcFile.readLine()) != null )
      {
        index = tmpLine.indexOf(DELIMITER);
        len = tmpLine.length();
        if (index > 0 && len > 0) {
          //System.out.println(tmpLine);
          //System.out.println(tmpLine.substring(0,index));
          //System.out.println(tmpLine.substring(index+1,len));
          messageHolder.put(tmpLine.substring(0,index), tmpLine.substring(index+1,len));

//          messageHolder.put(tmpLine.substring(0,index), utility.Tools.ConvertCN("中国"+tmpLine.substring(index+1,len)));
        }
      }
    }
    catch (Exception e) {
      e.printStackTrace (System.out);
    }
  }

  /*
  Return the error description based on the error code passed in.
  Return hard-coded message if the error code doesn't exist.
  */
  private String basicGetMessage(String errorcode) {
    String message = null;

    if (messageHolder != null) {
      message = (String) messageHolder.get(errorcode);
//      message="打发十分"+utility.Tools.ConvertCN(message);
//      message="打"+message;
    } else {
      message = "Error file initialization error";
    }
    if (message == null) {
      message = "Undefined Error Message for " + errorcode;
    }
    return message;
  }

  public static String getMessage(String errorcode) {

//    return "中"+MessageReader.getInstance().basicGetMessage(errorcode);
      return MessageReader.getInstance().basicGetMessage(errorcode);
  }

}