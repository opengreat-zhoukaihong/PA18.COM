/*
==================================================================
=== 	 Author： 			zlx												===
===	 Function：			For policyManager interface				===
===	 Create date：		2000/09/10										===
==================================================================
*/

package beans;

import java.io.*;
import java.util.*;
import java.lang.*;
import java.beans.Beans;
import exceptions.*;
import com.mcip.nia.orb.*;
import com.mcip.orb.*;
import constant.*;
import utility.*;

public class ZPolicybean
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
    PolicyManager plymanager;    

    public ZPolicybean()  
    {
       	  // Initialize the ORB.
         try
         {    
	         orb = ORBManager.getORBForClient();
		 plymanager = PolicyManagerHelper.bind(orb, "plymanager");
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

      //for client CORBA invoke
      //is to analyst corba exception type
   	
         try{    
		  //call remote methods with in inout parameter
		switch(operType)
		{
			case ZConst.ACCEPT_CASERPT:
				retValueArra = plymanager.acceptCaseRpt(ZObjects.getCaserptinfo(formPara));	    		
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
