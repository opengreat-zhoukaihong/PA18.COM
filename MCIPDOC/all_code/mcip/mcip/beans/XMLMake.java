////////////////////////////////////////////////////////
// Author£ºZhangJinQuan
// Function£ºxml make
// Create date£º2000/10/05
// Update date£º2000/10/08
////////////////////////////////////////////////////////


package beans;

import java.util.*;
import java.lang.*;
import java.io.*;

public class XMLMake
{
	
    private  static String xmlVersion = "?xml version = '1.0' encoding ='gb2312' ?";
    private  static  String xmlContent = "";
    private  static String xmlHeader = "HEADER";
    private  static String xmlRow = "ROW num=\"1\"";
    private  static String xmlRowFoot = "ROW";    
    private  static String xmlLeft = "<";
    private  static String xmlRight = ">";    
    private  static String xmlEnd = "/";
        
    public XMLMake()
    {
    }

    public static String Xml(String xmlCon,String[][] xmlData)
    {
    	 xmlContent =  xmlCon;
    	 String xmlDoc = xmlHead() + xmlDataAll(xmlData) + xmlFoot();
    	 
    	 return xmlDoc;
    }
    public static String Xml(String xmlCon,String[][] xmlData,String[][] xmlDataAdd)
    {
    	 xmlContent =  xmlCon;
    	 String xmlDoc = xmlHead() + xmlDataAll(xmlData) + xmlDataAll(xmlDataAdd)+ xmlFoot();
    	return xmlDoc;
    }
    public static String Xml(String xmlCon,String[][] xmlData,String[][] xmlDataAdd,String[][] xmlDataAdd1)
    {
    	 xmlContent =  xmlCon;
    	 String xmlDoc = xmlHead() + xmlDataAll(xmlData) + xmlDataAll(xmlDataAdd)+ xmlDataAll(xmlDataAdd1)+ xmlFoot();
    	return xmlDoc;
    }

    private static String xmlDataAll(String[][] xmlData)
    {
    	String xmlDataStr = "";
    	if(xmlData == null || xmlData.length < 2)
    	    return "";
    	   
    	for(int i = 0; i < xmlData[0].length; i++)
	{
    	    	xmlDataStr = xmlDataStr + xmlData(xmlData[0][i],xmlData[1][i]);
    	}
    	
    	return xmlDataStr;

    }
    private  static String xmlHead()
    {
    	String xmlHead = "";
    	xmlHead =  xmlHead + AddXmlRight(AddXmlLeft(xmlVersion));
    	xmlHead =  xmlHead + AddXmlRight(AddXmlLeft(xmlContent));
    	xmlHead =  xmlHead + AddXmlRight(AddXmlLeft(xmlHeader));
    	xmlHead =  xmlHead + AddXmlRight(AddXmlLeft(xmlRow));
    	
    	return xmlHead;
    	
    }
    private static  String xmlFoot()
    {
    	String xmlFoot = "";
    	xmlFoot =  xmlFoot + AddXmlRight(AddXmlEnd(AddXmlLeft("")) + xmlRowFoot);
    	xmlFoot =  xmlFoot + AddXmlRight(AddXmlEnd(AddXmlLeft("")) + xmlHeader);
    	xmlFoot =  xmlFoot + AddXmlRight(AddXmlEnd(AddXmlLeft("")) + xmlContent);

    	return xmlFoot;
    	
    }
    private  static String xmlData(String Para,String Value)
    {
    	String xmlData = "";
    	xmlData = xmlData + AddXmlRight(AddXmlLeft(Para));
    	xmlData = xmlData + Value;
    	xmlData = xmlData + AddXmlRight(AddXmlEnd(AddXmlLeft("")) + Para);;

    	return xmlData;
    	
    }

    private  static String AddXmlLeft(String xmlDoc)
    {
    	return (xmlLeft +  xmlDoc);
    }
    private static  String AddXmlRight(String xmlDoc)
    {
    	return (xmlDoc + xmlRight);
    }
    private static  String AddXmlEnd(String xmlDoc)
    {
    	return (xmlDoc + xmlEnd);
    }
/*
<?xml version = '1.0' encoding ='gb2312' ?>
<SEND_STATUS_INTERFACE>
 <HEADER>
   <ROW NUM="1">
        <CRE_CODE>CRE</CRE_CODE>
   	<INSURANCE_COMPANY_CODE>PA</INSURANCE_COMPANY_CODE>
   	<APPLICATION_NO>123</APPLICATION_NO>
   	<TRANSACTION_TYPE>02</TRANSACTION_TYPE>
   	<UPDATED_DATE>2000-09-28 15:36:36</UPDATED_DATE>
   	<STATUS>PROPOSAL_AVAILABLE</STATUS>
   	<INSURANCE_APP_NO>23456</INSURANCE_APP_NO>
   </ROW>
 </HEADER>
</SEND_STATUS_INTERFACE>

Remark:
  1. Encoding should be set for chinese version (gb2312 or big5).
  2. Date format should be "YYYY-MM-DD HH:MI:SS".
  3. There are 2 status code "APPLICATION_SUBMITTED" AND "PROPOSAL_AVAILABLE". 
*/  
}
    