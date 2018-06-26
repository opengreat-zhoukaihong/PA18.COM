////////////////////////////////////////////////////////
// Author：ZhangJinQuan
// Function：For dataStream depose from jsp2jsp,For policyAppManager interface
// Create date：2000/08/12
// Update date：2000/08/24
////////////////////////////////////////////////////////

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

public class PolicyAppBean
{

    //for set property using,object para is to be defined
    private static String[] formPara;
    private static String[][] formParaPre;
    private int operType;
    private String fieldValue;

    //for get property using:
    private String[][] retValueArra;
    private boolean retValueBool = false;

    //for orb initial using
    org.omg.CORBA.ORB orb  ;
    PolicyAppManager PolicyApp;    //to be

    public PolicyAppBean()
    {
       	  // Initialize the ORB.

          try
          {
	         orb = ORBManager.getORBForClient();
		 PolicyApp = PolicyAppManagerHelper.bind(orb, "amanager");//to be
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

    public void setFormPara(int operType,String[] para) throws NormalException
    {
    	setOperType(operType);
        this.formPara = para;
        this.ProcessLogic();
    }

    public void setFormParaPre(int operType,String[][] para) throws NormalException
    {
    	setOperType(operType);
        this.formParaPre = para;
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
			case (Const.ACCEPT_POLICYAPP):
				try{
			        retValueArra  = PolicyApp.acceptPolicyApp(Objects.getPlcyAppInfo(formPara),formParaPre);
				}catch(Exception e){
					e.printStackTrace();
				}
			    break;
			case (Const.WITHDRAWAL_POLICYAPP):
			    retValueBool  = PolicyApp.withdrawalPolicyApp(fieldValue);
			    break;
			case (Const.UPDATE_POLICYAPP):
			    retValueArra  = PolicyApp.updatePolicyApp(Objects.getPlcyAppInfo(formPara),formParaPre);
			    break;
			case (Const.CONFIRM_POLICYAPPPROPOSAL):
			    retValueArra  = PolicyApp.confirmPolicyAppProposal(formPara[0],formPara[1],formPara[2],formPara[3]);
			    break;
     //Added by Clarkrao
      case (Const.ACCEPT_USERREMARK):
          retValueBool = PolicyApp.acceptUserRemark(formPara[0],formPara[1],formPara[2],formPara[3]);
          //PolicyApp.acceptUserRemark(String policyapp_no, String app_cde, String user_remark)
          break;
      case (Const.DELETE_POLICYAPP):
         retValueBool = PolicyApp.deletePolicyApp(fieldValue);
         break;
     //Added end
			default:
            			throw NormalExceptionHandler.Handle(ExceptionCode.SYS_PARA_ERR);
		}
            }
            catch(CoException e)
            {
	         throw  NormalExceptionHandler.Handle(e);
             }
            catch (NormalException e)
            {
        	 throw  NormalExceptionHandler.Handle(e);
            }
            catch (Exception e)
            {
        	 throw  NormalExceptionHandler.Handle(e);
            }

         return;
    }
}
