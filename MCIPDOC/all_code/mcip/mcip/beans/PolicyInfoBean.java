
////////////////////////////////////////////////////////
// Author：ZhangJinQuan
// Function：For dataStream depose from jsp2jsp,For policyinfoManager interface
// Create date：2000/08/12
// Update date：2000/08/12
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


public class PolicyInfoBean
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

    public PolicyInfoBean()
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
			case (Const.GET_OCLIST):
			    retValueArra  = PolicyInfo.getOCList(formPara[0],formPara[1]);
			    break;
			case (Const.GET_OCINFO):
			    retValueArra  = PolicyInfo.getOCInfo(formPara[0],formPara[1],formPara[2]);
			    break;
			case (Const.GET_AGENCYLIST):
			    retValueArra  = PolicyInfo.getAgencyList(formPara[0],formPara[1]);
			    break;
			case (Const.GET_AGENCYINFO):
			    retValueArra  = PolicyInfo.getAgencyInfo(formPara[0],formPara[1],formPara[2],formPara[3]);
			    break;
			case (Const.GET_AGENCYPLCYLIST):
			    retValueArra  = PolicyInfo.getAgencyPlcyList(formPara[0],formPara[1],formPara[2]);
			    break;
			case (Const.GET_CUSTPLCYLIST):
			    retValueArra  = PolicyInfo.getCustPlcyList(formPara[0],formPara[1],formPara[2]);
			    break;
			case (Const.GET_POLICYAPPLIST):
			    retValueArra  = PolicyInfo.getPolicyAppList(formPara[0],formPara[1],formPara[2],formPara[3],formPara[4]);
			    break;
			case (Const.GET_POLICYAPPINFO):
			    retValueArra  = PolicyInfo.getPolicyAppInfo(fieldValue);
			    break;

			case (Const.GET_POLICYLIST):
			    retValueArra  = PolicyInfo.getPolicyList(formPara[0],formPara[1],formPara[2],formPara[3],formPara[4]);
			    break;
			case (Const.GET_POLICYINFO):
			    retValueArra  = PolicyInfo.getPolicyInfo(fieldValue);
			    break;
			case (Const.GET_POLICYINFO_LATEST):
				retValueArra = PolicyInfo.getPolicyInfoLatest(fieldValue);
				break;
			case (Const.GET_PROPOSALINFO):
			    retValueArra  = PolicyInfo.getProposalInfo(fieldValue);
			    break;
			case (Const.GET_PROPOSALLIST):
			    retValueArra  = PolicyInfo.getProposalList(formPara[0],formPara[1],formPara[2],formPara[3],formPara[4]);
			    break;

			case (Const.GET_ENDORSEPROPOSALINFO):
			    retValueArra  = PolicyInfo.getEndorseProposalInfo(fieldValue);
			    break;
			case (Const.GET_PLYAPPRDRINFO):
			    retValueArra  = PolicyInfo.getPlyAppRdrInfo(fieldValue);
			    break;
		/**kangjin*/
			case (Const.GET_PLYRDRINFO):
			    retValueArra  = PolicyInfo.getPlyRdrInfo(fieldValue);
			    break;
		/**kangjin*/
			case (Const.GET_PLYAPPNETADDRESS):
			    retValueArra  = PolicyInfo.getPlyAppNetAddress(formPara[0],formPara[1]);
			    break;

			case (Const.GET_CASERPTINFO):
			    retValueArra  = PolicyInfo.getCaseRptInfo(fieldValue);
			    break;
		  case (Const.GET_EDRAPPLIST):
		            retValueArra =  PolicyInfo.getEdrAppList(formPara[0],formPara[1],formPara[2],formPara[3],formPara[4],formPara[5]);
		       break;
      case (Const.GET_EDRSMTLIST):
                retValueArra =  PolicyInfo.getEdrsmtList(formPara[0],formPara[1],formPara[2],formPara[3],formPara[4],formPara[5]);
            break;
      case (Const.GET_EDRSMTINFO):
                retValueArra =  PolicyInfo.getEdrsmtInfo(fieldValue);
            break;
      case (Const.GET_PREEDRINFO):
                retValueArra =  PolicyInfo.getPreEdrInfo(fieldValue);
                break;
      case (Const.CHECK_EDRAPP):
	            retValueBool=  PolicyInfo.checkEdrApp(fieldValue);
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
