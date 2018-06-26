package utility;

import org.w3c.dom.*;
import java.util.*;
import java.io.*;
import java.net.*;
import oracle.xml.parser.v2.*;
import helma.xmlrpc.*;
import sun.misc.BASE64Encoder;
//import xmlrpc.*;

public class RPCClient{

// The attributes
  private String method;
  private String xml;
  private String url;
  //private byte[] signedDoc;
  private String XmlsignedDoc;
  private int rc;
  private String returnExe;
  private String key;

  public RPCClient(String iMethod, String iXml, String iKey,String iUrl)
  {
    method = iMethod;
    xml = iXml;
    url = iUrl;
    key = iKey;
  }
  
  private int Sign()
  {
	byte[] signedDoc=null;
	DSCreate dsCreate = new DSCreate(xml,key);//key is to be changed
	if (dsCreate.sign() == true) 
	{
		signedDoc = dsCreate.GetSignedDoc();
	}	
	else
	{
	   return  - 1;
	}	

	// encode signedDoc
	BASE64Encoder encoder = new BASE64Encoder();
	String encodeSignedDoc = encoder.encodeBuffer(signedDoc);
        XmlsignedDoc = encodeSignedDoc;
        return 0;
  	
  }
  public int SendData() {
    
    try 
    {
    	
    System.setProperty("java.protocol.handler.pkgs","com.sun.net.ssl.internal.www.protocol"); 
    java.security.Security.addProvider( new com.sun.net.ssl.internal.ssl.Provider() ); 	
    	
    //sign:
 	
      if(Sign() == -1)
         return -1;
   //end sign
            
      XmlRpc.setDriver("oracle2");
      XmlRpcClient xmlrpc = new XmlRpcClient(url);
      Vector params = new Vector();
      params.addElement(xml);
      params.addElement(XmlsignedDoc);
	//params.addElement(new String("<?xml version=\"1.0\" ?>\r\n<!DOCTYPE insuranceNegotiateList SYSTEM \"crc_com.dtd\">\r\n<insuranceNegotiateList>\r\n<insuranceNegotiate refNo=\"AIANEG001\" date=\"5 Sept, 2000\">\r\n<header>\r\n<from>\r\n<name>ABC Co., Ltd.</name>\r\n<address>123 Connaught Road, Central</address>\r\n</from>\r\n<to>\r\n<name>AIA Insurance Co., Ltd.</name>\r\n</to>\r\n</header>\r\n<insuranceNegotiateBody>\r\n<crossRefNo>AIAQUOTE208</crossRefNo>\r\n<assuredPerson>\r\n<name>Chan Tai Man</name>\r\n</assuredPerson>\r\n<commodityList>\r\n<commodity>\r\n<description>Wool Clothes</description>\r\n</commodity>\r\n</commodityList>\r\n<value currency=\"USD\">12000</value>\r\n<transportation>\r\n<loading>Hong Kong</loading>\r\n<discharging>San Francisco</discharging>\r\n<voyage>Some voyage</voyage>\r\n</transportation>\r\n<conditionList>\r\n<condition>Condition I</condition>\r\n</conditionList>\r\n<rate>15%</rate>\r\n</insuranceNegotiateBody>\r\n</insuranceNegotiate>\r\n</insuranceNegotiateList>"));
System.out.println("XmlsignedDoc:"+XmlsignedDoc);
System.out.println("method:"+method);
      try
       {
System.out.println("Begin to send xmlrpc.execute:");       	
          returnExe = (String)xmlrpc.execute(method, params);
System.out.println("Receive xmlrpc from hk:"+returnExe);          
          if(returnExe.equals("-1"))
              return -1;
       }
       catch (Exception e) 
       {
          System.out.println(e);
          return -1;
       }
    }
    catch (Exception e) 
    {
      System.out.println(e);
      return -1;
    }            
    
    return 0;
  }
}
