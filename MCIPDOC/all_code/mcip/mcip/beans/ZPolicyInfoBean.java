/*
==================================================================
=== 	 Author： 			zlx												===
===	 Function：			For policyinfoManager interface			===
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


public class ZPolicyInfoBean
{

    //for set property using,object para is to be defined
    private static String[] formPara;
    private int operType;
    private String fieldValue;    
    
    //for get property using:
    private String[][] retValueArra;    
    private boolean retValueBool = false;
        
    //for orb initial using
    org.omg.CORBA.ORB orb  ;
    PolicyInfoManager PolicyInfo;    //to be

    public ZPolicyInfoBean()
    {
       	  // Initialize the ORB.

          try
          {    
	         orb = ORBManager.getORBForClient();
		 PolicyInfo = PolicyInfoManagerHelper.bind(orb, "pmanager");//to be
	  }	 
          catch (Exception e)
          {
 	        throw  NormalExceptionHandler.Handle(e);
          }
      
    }

    public void setOperType(int operType)
    {
        this.operType = operType;
    }

    public void setFormPara(int operType,String[] para) throws NormalException
    {
    	setOperType(operType);    	
        this.formPara = para;
        this.ProcessLogic();
    }

    public void setFieldValue(int operType,String para) throws NormalException
    {
    	setOperType(operType);    	
        this.fieldValue = para;
        this.ProcessLogic();
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
   	
         try{    
		  //call remote methods with in inout parameter
		switch(operType)
		{

			case (Const.GET_POLICYINFO):
			    retValueArra  = PolicyInfo.getPolicyInfo(fieldValue);
			    break;	    
			case (Const.GET_PROPOSALINFO):
			    retValueArra  = PolicyInfo.getProposalInfo(fieldValue);
			    break;	    
			case (Const.GET_ENDORSEPROPOSALINFO):
			    retValueArra  = PolicyInfo.getEndorseProposalInfo(fieldValue);
			    break;	    
			case (Const.GET_PLYAPPRDRINFO):
			    retValueArra  = PolicyInfo.getPlyAppRdrInfo(fieldValue);
			    break;	    
			case (ZConst.GET_CASERPTLIST):
			    retValueArra  = PolicyInfo.getCaseRptList(formPara[0],formPara[1],formPara[2],formPara[3],formPara[4]);
			    break;	    
			case (ZConst.GET_CASECLMLIST):
			    retValueArra  = PolicyInfo.getCaseClmList(formPara[0],formPara[1]);
			    break;	    
			case (ZConst.GET_CLAIMLIST):
			    retValueArra  = PolicyInfo.getClaimList(formPara[0],formPara[1],formPara[2],formPara[3],formPara[4],formPara[5]);
			    break;	    
			case (ZConst.GET_CLMDGSTLIST):
			    retValueArra  = PolicyInfo.getClmDgstList(formPara[0],formPara[1]);
			    break;	    

			case ZConst.GET_CLAUSELIST:
			    retValueArra  = PolicyInfo.getClauseList(formPara[0],formPara[1],formPara[2]);
			    break;	    
			//add by zlx 2000/11/9
			case (ZConst.GET_CASERPTINFO):
			    retValueArra  = PolicyInfo.getCaseRptInfo(formPara[0]);
			    break;	    

			default:    
            			throw NormalExceptionHandler.Handle(ExceptionCode.SYS_PARA_ERR);
		}
            }
            catch(CoException e)
            {
	         throw NormalExceptionHandler.Handle(e);
             }
            catch (Exception e)
            {
        	 throw  NormalExceptionHandler.Handle(e);
            }
     
         return;
    }
 
}
