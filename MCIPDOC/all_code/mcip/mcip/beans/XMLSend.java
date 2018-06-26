////////////////////////////////////////////////////////
// Author£ºZhangJinQuan
// Function£ºxml send
// Create date£º2000/10/05
// Update date£º2000/10/08
////////////////////////////////////////////////////////


package beans;

import java.util.*;
import java.lang.*;
import java.io.*;
import exceptions.*;
import utility.*;
import constant.*;

public class XMLSend
{
    
    private String XmlData[][] = null;
    public String XmlDataBase[][] = null;
    private String XmlDoc = "";

	public XMLSend(String XmlDataPara[][]) throws  NormalException
	{
	    XmlDataBase = new String[2][3];
            String RemoteData[][] = XmlDataPara;    		
	    if(RemoteData == null || RemoteData.length < 2 || RemoteData[0].length < 3)
	    {
	        throw new NormalException("Parameter and value from remote request is error");
	    }
	
	    for(int i = 0; i < 2;i++)
	       for(int j = 0 ; j < 3 ; j++)
	       {
	          XmlDataBase[i][j] = RemoteData[i][j];
	       }   

	}
	public XMLSend(String XmlDataPara[][],String flag) 
	{
		XmlDataBase = XmlDataPara;
	}	
	public XMLSend() 
	{
		
	}	

	public int SendStatus(String PrpFlagPara,String PlyAppNoPara) throws NormalException
	{
            String XmlContent = Const.XMLCONTENT_STATUS_HR;
            String XmlMethod = Const.XMLMETHOD_STATUS_HR;
            String XmlKey = Const.XMLKEY_STATUS_HR;
            String XmlUrl = Const.XMLURL_HR;

            String PlyAppNo = PlyAppNoPara;
            String PrpFlag = PrpFlagPara;//"0" is not availble, "1" is avaiable             
            String PrpStatus = "";

            if(PrpFlag.equals("0"))
            {
                PrpStatus = "APPLICATION_SUBMITTED";
            }
            else if(PrpFlag.equals("1"))    
            {
                PrpStatus = "PROPOSAL_AVAILABLE";            	
            }

            String Sdate = ServTool.getSysDateTime(); 
            String XmlDataStatus[][] = {{"TRAN_TYPE","T_SEND_TM","TRAN_STATUS","C_PLY_APP_NO"},
            {Const.REMOTE_PLY_SEND,Sdate,PrpStatus,PlyAppNo}};
            
            XmlData = XmlDataStatus;
             int result = 0;
	     try
	     {
	        XmlDoc = XMLMake.Xml(XmlContent,XmlDataBase,XmlData);
	        RPCClient XmlClient= new RPCClient(XmlMethod,XmlDoc,XmlKey,XmlUrl);
	        result = XmlClient.SendData();
	     }    
	     catch(Exception e)
	     {
	         throw NormalExceptionHandler.Handle(e);
	     }
            return result;
	}

	
	public static void main(String[] args)
	{
          String err="System para error;Para is plyappno [cre_plyapp_no sendflag(0 or 1)];sendflag is 1 then send two kind of proposal status";
		if(args == null)
		{
			System.out.println(err);
			return;
		}   
		else if(args.length == 1)
		{
			System.out.println("Para is must to be plyappno");			
			XmlStatus(args[0]);
		}
		else if(args.length == 3)
		{
			System.out.println("Para is  must to be  plyappno and cre_plyapp_no and sendflag");
			XmlStatus(args[0],args[1],args[2]);		
		}
		else
		{
			System.out.println(err);			
		}
			
		return;

	}

	public static int XmlStatus(String PlyAppNo,String cre_no,String sendflag)
	{
		int result= 0;
System.out.println("Begin to send xml:");
             String XmlDataBase1[][] = new String[2][3];
             XmlDataBase1[0][0] = "C_NET_ID";
             XmlDataBase1[0][1] = "PA18_NET_ID";             
             XmlDataBase1[0][2] = "CRE_PLYAPP_NO";                          
             XmlDataBase1[1][0] = "CRE";
             XmlDataBase1[1][1] = "PA";             
             XmlDataBase1[1][2] = cre_no;                          

		try
		{
			XMLSend  xmlsend = new XMLSend(XmlDataBase1,"1");//"1" is no use
			if(sendflag.equals("1"))
			{
			    result = xmlsend.SendStatus("0",PlyAppNo);//"1" is proposal flag				
			}
			 result = xmlsend.SendStatus("1",PlyAppNo);//"1" is proposal flag
		}
		catch(NormalException e)
		{
			System.out.println("NormalException:"+e.getMessage());
			result = - 1;
		}
		catch(Exception e)
		{
			System.out.println("Exception:"+e.getMessage());
			result = - 1;			
		}
		
		return result;
	}



	public static int XmlStatus(String PlyAppNo)
	{
		int result= 0;
System.out.println("Begin to send xml:");
             String XmlDataBase1[][] = new String[2][2];
             XmlDataBase1[0][0] = "C_NET_ID";
             XmlDataBase1[0][1] = "PA18_NET_ID";             
             XmlDataBase1[1][0] = "CRE";
             XmlDataBase1[1][1] = "PA";             

		try
		{
			XMLSend  xmlsend = new XMLSend(XmlDataBase1,"1");
			 result = xmlsend.SendStatus("1",PlyAppNo);
		}
		catch(NormalException e)
		{
			System.out.println("NormalException:"+e.getMessage());
			result = - 1;
		}
		catch(Exception e)
		{
			System.out.println("Exception:"+e.getMessage());
			result = - 1;			
		}
		
		return result;
	}
}