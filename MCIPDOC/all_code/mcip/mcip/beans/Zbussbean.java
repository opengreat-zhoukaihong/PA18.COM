/*
==================================================================
=== 	 Author： 			zlx												===
===	 Function：			For BusinessManager interface				   ===
===	 Create date：		2000/09/20										===
==================================================================
*/

package beans;

import java.io.*;
import java.util.*;
import java.lang.*;
import java.beans.Beans;
import exceptions.*;
import com.mcip.bus.orb.*;
import com.mcip.orb.*;
import constant.*;
import utility.*;

public class Zbussbean
{

    //for set property using,object para is to be defined
    private int operType;
    private static String[] formParaPre;  //for the form with two table to be deliveried
    private static String[] formPara;
    
    //for get property using:
    private String retValue;
    private String[][] retValueArra;    
    private boolean retValueBool = false;
    
    //for orb initial using
    org.omg.CORBA.ORB orb  ;
    BusinessManager bussmanager;    

    public Zbussbean()  
    {
       	  // Initialize the ORB.
         try
         {    
	         orb = ORBManager.getORBForClient();
		 bussmanager = BusinessManagerHelper.bind(orb, "businessmanager");
         }	 
         catch (Exception e)
         {
 	         throw NormalExceptionHandler.Handle(e);
         }
    }

    public void setOperType(int operType)
    {
        this.operType = operType;
    }

    public void setFormParaPre(int operType,String[] paraPre)
    {
    	setOperType(operType);
        this.formParaPre = paraPre;
    }

    public void setFormPara(int operType,String[] para) throws NormalException
    {
    	setOperType(operType);    	
        this.formPara = para;
        this.ProcessLogic();
    }

    public String[] getFormParaPre()
    {
        return this.formParaPre;
    }
    public String getRetValue()
    {
        return this.retValue;
    }

    public String[][] getRetValueArra()
    {
        return this.retValueArra;
    }

    public boolean getRetValueBool()
    {
        return this.retValueBool;
    }

    
    //逻辑流程控制程序
    
    private void ProcessLogic()  throws NormalException
    {

		retValueArra = null; 	//To be sure retValueArra = null when null exception raises
      //for client CORBA invoke
      //is to analyst corba exception type
   	
         try{    
		  //call remote methods with in inout parameter
		switch(operType)
		{
			case ZConst.QUERY_PLYNETLIST:
				retValueArra = bussmanager.queryPlyNetList(formPara[0],formPara[1],formPara[2], formPara[3],formPara[4],formPara[5],formPara[6],formParaPre);	    		
		          	break;
			case ZConst.QUERY_PLYNETINFO:
				retValueArra = bussmanager.queryPlyNetInfo(formPara);	    		
		          	break;
			case ZConst.UPDATE_PRINTINFO:
				retValueBool = bussmanager.updatePrintInfo(formParaPre,formPara[0]);	    		
		          	break;

			//add on 2000/10/20 by zhulingxiang
			case ZConst.QUERY_GUIDELIST:
				retValueArra = bussmanager.queryGuideList(formPara[0],formPara[1]);	    		
		          	break;
			case ZConst.QUERY_GUIDEINFO:
				retValueArra = bussmanager.queryGuideInfo(formPara[0],formPara[1]);	    		
		          	break;
			case ZConst.QUERY_FAQLIST:
				retValueArra = bussmanager.queryFaqList(formPara[0],formPara[1]);	    		
		          	break;
			case ZConst.QUERY_FAQINFO:
				retValueArra = bussmanager.queryFaqInfo(formPara[0],formPara[1]);	    		
		          	break;
			case ZConst.ACCEPT_FAQINFO:
				retValueBool = bussmanager.acceptFaqInfo(ZObjects.getFaqInfo(formPara),formParaPre[0]);	    		
		          	break;
			case ZConst.QUERY_CONSULTLIST:
				retValueArra = bussmanager.queryConsultList(formPara[0],formPara[1]);	    		
		          	break;
			case ZConst.QUERY_CONSULTINFO:
				retValueArra = bussmanager.queryConsultInfo(formPara[0],formPara[1]);	    		
		          	break;
			//add by zlx 2001/1/3
			case ZConst.GET_CUSTPLYAPPLIST:
				retValueArra = bussmanager.getCustPlyAppList(formPara[0]);	    		
		          	break;

			 default:
            			throw NormalExceptionHandler.Handle(ExceptionCode.SYS_PARA_ERR);
		
		}

         }
         catch(CoException e)
         {
 	      throw  NormalExceptionHandler.Handle(e);//throw new NormalException("CORBAR Exception:" +e.errDescription);
         }
         catch (NormalException e)
         {
	      throw  NormalExceptionHandler.Handle(e);//throw new NormalException(e.getMessage());
         }
         catch (Exception e)
         {
	      throw  NormalExceptionHandler.Handle(e);// throw new NormalException(e.getMessage());
         }
         
         return;
    }

  
}
