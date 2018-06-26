////////////////////////////////////////////////////////
// Author：ZhangJinQuan
// Function：For dataStream depose from jsp2jsp,For staticinfoManager interface
// Create date：2000/08/07
// Update date：2000/08/08
////////////////////////////////////////////////////////

package beans;

import java.io.*;
import java.util.*;
import java.lang.*;
import java.beans.Beans;
import exceptions.*;
import com.mcip.cdt.orb.*;
import com.mcip.orb.*;
import constant.*;
import utility.*;


public class StaticInfoBean
{

    //for set property using,object para is to be defined
    private String[] formPara;
    private int operType;
    private String fieldValue;    
    
    //for get property using:
    private String[][] retValueArra;    
    
    //For using in this class
    private String[][] respValueStr;
    
    //for orb initial using
    org.omg.CORBA.ORB orb  ;
    staticInfoManager StaticInfo;    //to be

    public StaticInfoBean()
    {
       	  // Initialize the ORB.

          try
          {    
	         orb = ORBManager.getORBForClient();
		 StaticInfo = staticInfoManagerHelper.bind(orb, "smanager");//to be
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

    public void setFieldValue(int operType,String para) throws NormalException
    {
    	setOperType(operType);    	
        this.fieldValue = para;
        this.ProcessLogic();
    }

    public void setRetValueArra(String[][] newValue)
    {
        this.retValueArra = newValue;
    }

    public String[][] getRetValueArra()
    {
        return this.retValueArra;
    }


    
    //逻辑流程控制程序
    
    private void ProcessLogic()  throws NormalException
    {

      //for client CORBA invoke
   	
         try{    
		  //call remote methods with in inout parameter
		switch(operType)
		{
			case (Const.GET_NATIONAL):
			    respValueStr = StaticInfo.getNationalList(fieldValue);
			    break;	    
			case (Const.GET_AREA):
			    respValueStr = StaticInfo.getAreaList(fieldValue);	    		
			    break;	    			
			case(Const.GET_PROVINCE):
			    respValueStr = StaticInfo.getProvinceList(fieldValue);	    		
			    break;	    
			case(Const.GET_EDU):
    			    respValueStr = StaticInfo.getEduList(fieldValue);	    		
			    break;	    
			case(Const.GET_TITILE):
			    respValueStr = StaticInfo.getTitleList(fieldValue);	    		
			    break;	    
			case(Const.GET_DUTY):
			    respValueStr = StaticInfo.getDutyList(fieldValue);	    		
			    break;	    
			case(Const.GET_TRADETYPE):
			    respValueStr = StaticInfo.getTradeTypeList(fieldValue);	    		
			    break;	    
			case(Const.GET_ORGTYPE):
			    respValueStr = StaticInfo.getOrgTypeList(fieldValue);	    		
			    break;	    
			case(Const.GET_OWNERSHIP):
			    respValueStr = StaticInfo.getOwnershipList(fieldValue);	    		
			    break;	    
			case(Const.GET_SCALE):
			    respValueStr = StaticInfo.getScaleList(fieldValue);	    		
			    break;	    
			case(Const.GET_PREMIUMSCALE):
			    respValueStr = StaticInfo.getPremiumScaleList(fieldValue);	    		
			    break;	    
			case(Const.GET_CURRENCY)://is special invok
			    respValueStr = StaticInfo.getCurrencyList(fieldValue);	    		
			    break;	
			    
			/*kangjin*/
			case(Const.GET_CURRENCY_INFO)://is special invok
			    respValueStr = StaticInfo.getCurrencyInfo(formPara[0]);	    		
			    break;	
			/*kangjin*/
			case(Const.GET_BIGCARGOTYPE):
			    respValueStr = StaticInfo.getCargoClsList(formPara[0],formPara[1]);	    		
			    break;	    
			case(Const.GET_SMALLCARGOTYPE):
			    respValueStr = StaticInfo.getCargoTypeList(fieldValue);	    		
			    break;	    
			case(Const.GET_PACK):
			    respValueStr = StaticInfo.getPackList(fieldValue);	    		
			    break;	    
			case(Const.GET_EXCHANGERATE):
			    respValueStr = StaticInfo.getExchangeRateList(formPara[0],formPara[1]);	    		
			    break;	    
			case(Const.GET_PAYMODE):
			    respValueStr = StaticInfo.getPayModeList(fieldValue);	    		
			    break;	    
			case(Const.GET_INSURANCECLASS):
			    respValueStr = StaticInfo.getInsuranceClassList(fieldValue);	    		
			    break;	    
			case(Const.GET_INSURANCEDEFINE):
			    respValueStr = StaticInfo.getInsuranceDefineList(fieldValue);	    		
			    break;	    
			case(Const.GET_INSURANCETYPE):
			    respValueStr = StaticInfo.getInsuranceTypeList(fieldValue);	    		
			    break;	    
			case(Const.GET_CLAUSE):
			    respValueStr = StaticInfo.getClauseList(formPara[0],formPara[1],formPara[2]);	    		
			    break;	    
			case(Const.GET_ENDORSEREASON):
			    respValueStr = StaticInfo.getEndorseReasonList(fieldValue);	    		
			    break;	    
			case(Const.GET_DEPARTMENT):
			    respValueStr = StaticInfo.getDepartmentList(fieldValue);	    		
			    break;	    

			case(Const.GET_AGENTCHARACTER):
			    respValueStr = StaticInfo.getAgentCharacterList(fieldValue);	    		
			    break;	    
			case(Const.GET_SURVEYAGENT):
			    respValueStr = StaticInfo.getSurveyAgentList(fieldValue);	    		
			    break;	    
			case(Const.GET_CARRIAGE):
			    respValueStr = StaticInfo.getCarriageList(fieldValue);	    		
			    break;	    
			case(Const.GET_VSLLEVEL):
			    respValueStr = StaticInfo.getVslLevelList(fieldValue);	    		
			    break;	    
			case(Const.GET_CERTIFICATE):
			    respValueStr = StaticInfo.getCertificateList(fieldValue);	    		
			    break;	    
			case(Const.GET_MAJOR):
			    respValueStr = StaticInfo.getMajorList(fieldValue);	    		
			    break;	    
			case(Const.GET_MARRIAGE):
			    respValueStr = StaticInfo.getMarriageList(fieldValue);	    		
			    break;	    
			case(Const.GET_SEX):
			    respValueStr = StaticInfo.getSexList(fieldValue);	    		
			    break;	    
			case(Const.GET_EMPLOYEECODE):
			    respValueStr = StaticInfo.getEmployeeCodeList(fieldValue);	    		
			    break;	    
			case(Const.GET_CITY):
			    respValueStr = StaticInfo.getCityList(fieldValue);	    		
			    break;	    

			case(Const.GET_NETCODELIST):
			    respValueStr = StaticInfo.getNetCodeList(fieldValue);	    		
			    break;
			// Added by rao 4/3	
			case(Const.GET_RPTTELNUM): 
			   respValueStr = StaticInfo.getRptTelNum(fieldValue);		    
			   break;
            // Added by rao 4/3	
			        
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
		throw NormalExceptionHandler.Handle(e);
        }
     
        

         setRetValueArra(respValueStr);

         return;
    }
    
 
}
