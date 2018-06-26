package beans;

import java.io.*;
import java.util.*;
import java.lang.*;
import java.beans.Beans;
import exceptions.*;
import org.omg.CORBA.*;
import com.mcip.bus.orb.*;  
import com.mcip.nia.orb.*; 
import com.mcip.orb.*;
import constant.*;
import utility.*;


public class PolicyManagerBean{
    private int operateType;
    private static String[][] formParaPre;  //for the form with two table to be deliveried
    private static String[] formPara;
    private static String fieldValue ;


    private String retValue;
    private String[][] retValueArra;
    private boolean retValueBool = false;

    org.omg.CORBA.ORB orb  ;

    PolicyManager plymanager;
    PlyGetDocInfo  plyGetDocInfo;
  
    public PlyEdrAppInfo plyEdrAppInfo=null;
    public PlyEdrAppCrgoInfo plyEdrAppCrgoInfo=null;
    public PlyEdrAppRdrInfo plyEdrAppRdrInfo=null;
    public PlyEdrAppPayInfo  plyEdrAppPayInfo=null;
    public PlyPlyAppNetInfo  plyPlyAppNetInfo=null ;
    String[][] in_rdrinfo =null;

    AnyHolder plyedrappHolder;
    AnyHolder plyedrappcrgoHolder;
    AnyHolder plyedrapprdrHolder;
    AnyHolder plyedrapppayHolder;
    AnyHolder plyplyappnetHolder;


    public PolicyManagerBean()
    {
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
        this.operateType = operType;
    }

    public void setFormParaPre(int operType,String[][] paraPre)
    {
    	  setOperType(operType);
        this.formParaPre = paraPre;
    }
    public void setFieldValue(int  operType, String newValue){
        setOperType(operType);
        this.fieldValue = newValue;
        ProcessLogic();
    } 

    public void setFormPara(int operType,String[] para) throws NormalException
    {
    	  setOperType(operType);
        this.formPara = para;
        ProcessLogic();
    }
    


    public String[] getFormPara(){
        return formPara;
    }

    public String getRetValue()
    {
        return this.retValue;
    }

    public String[][] getRetValueArra()
    {
        return retValueArra;
    }

    public boolean getRetValueBool()
    {
        return retValueBool;
    }

    public void setplyEdrAppInfo(PlyEdrAppInfo  info){
       plyEdrAppInfo = info;
    }
    public void setplyEdrAppCrgoInfo(PlyEdrAppCrgoInfo info){
       plyEdrAppCrgoInfo = info;
    }
    public void setin_rdrinfo(String[][] info){
       in_rdrinfo = info;
    }
    public void setplyEdrAppPayInfo(PlyEdrAppPayInfo info){
       plyEdrAppPayInfo  = info;
    }
    public void setplyPlyAppNetInfo(PlyPlyAppNetInfo info){
       plyPlyAppNetInfo = info;
    }

    private void ProcessLogic()throws NormalException
    {
       //From
       
      try{

		   switch(operateType)
		  {
         case 0:
              plyGetDocInfo = new  PlyGetDocInfo(formPara[0],"","1","");
              plyedrappHolder =    new AnyHolder();
              plyedrappcrgoHolder =  new AnyHolder();
              plyedrapprdrHolder =    new AnyHolder();
              plyedrapppayHolder =   new AnyHolder();
              plyplyappnetHolder =   new AnyHolder();
              plymanager.getPolicyEdr(plyGetDocInfo,
                                      plyedrappHolder,
                                      plyedrappcrgoHolder,
                                      plyedrapprdrHolder,
                                      plyedrapppayHolder,
                                      plyplyappnetHolder);

              plyEdrAppInfo  = PlyEdrAppInfoHelper.extract(plyedrappHolder.value);
              plyEdrAppCrgoInfo = PlyEdrAppCrgoInfoHelper.extract(plyedrappcrgoHolder.value);
              plyEdrAppRdrInfo  = PlyEdrAppRdrInfoHelper.extract(plyedrapprdrHolder.value);
              plyEdrAppPayInfo = PlyEdrAppPayInfoHelper.extract(plyedrapppayHolder.value);
              plyPlyAppNetInfo = PlyPlyAppNetInfoHelper.extract(plyplyappnetHolder.value);
              in_rdrinfo = plyEdrAppRdrInfo.edrapprdr;
               break;
         case 1 :
            
             //note : java.lang.String[][] in_rdrinfo,

			 in_rdrinfo = plyEdrAppRdrInfo.edrapprdr;
             retValueArra = plymanager.acceptPolicyEdr(plyEdrAppInfo,
                                                   plyEdrAppCrgoInfo,
                                                   in_rdrinfo,
                                                   plyEdrAppPayInfo,
                                                   plyPlyAppNetInfo);
                     

            break;

           // public java.lang.String[][] confirmEdrAppProposal(String edrapp_no, String dpt_cde, String insrnc_cde)

          case 2 :
             retValueArra = plymanager.confirmEdrAppProposal(formPara[0],formPara[1],formPara[2]);
             break;
          case 3:
              retValueBool =  plymanager.withdrawalEdrApp(fieldValue) ;
              break;
          case 4:
              plyedrappHolder =    new AnyHolder();
              plyedrappcrgoHolder =  new AnyHolder();
              plyedrapprdrHolder =    new AnyHolder();
              plyedrapppayHolder =   new AnyHolder();
              plyplyappnetHolder =   new AnyHolder();
              PlyEdrGridInfo plyEdrGridInfo = new PlyEdrGridInfo(
                 "",//java.lang.String c_crt_cde,
                 "",//java.lang.String c_crt_tm,
                 "",//java.lang.String c_upd_cde,
                 "",//java.lang.String c_upd_tm,
                 formPara[0],//java.lang.String c_edr_app_no,
                 "",//java.lang.String c_send_tm,
                 formPara[1],//java.lang.String c_dpt_cde,
                 "",//java.lang.String c_source,
                 "",//java.lang.String c_send_dpt_cde,
                 "",//java.lang.String c_send_cde,
                 "",//java.lang.String c_des_dpt_cde,
                 "",//java.lang.String c_emergency,
                 "",//java.lang.String c_authprn_cde,
                 "",//java.lang.String c_udr_mrk,
                 "",//java.lang.String c_send_mrk,
                 "",//java.lang.String c_udr_opn_mrk,
                 "",//java.lang.String c_vrfy_mrk,
                 "",//java.lang.String c_mdfy_tm,
                 formPara[2],//java.lang.String c_insrnc_cde,
                 "",//java.lang.String c_undr_prsn,
                 "",//java.lang.String c_undr_dpt,
                 "",//java.lang.String c_prn_typ,
                 "",//java.lang.String c_rinsrnc_mrk,
                 "",//java.lang.String c_coinsrnc_mrk,
                 "",//java.lang.String c_ply_no,
                 "",//java.lang.String c_edr_no,
                 "",//java.lang.String c_read_tm,
                 "",//java.lang.String c_rec_no,
                 "",//java.lang.String c_flag,
                 "",//java.lang.String c_insrnc_dfn_typ,
                 "",//java.lang.String c_insrnc_cnm,
                 "",//java.lang.String c_edr_typ,
                 "",//java.lang.String c_app_nme,
                 "",//java.lang.String n_amt,
                 "",//java.lang.String t_sign_tm,
                 "",//java.lang.String c_rpt_desc,
                 "",//java.lang.String c_risk_lvl_cde,
                 "",//java.lang.String c_lcn_no,
                 "",//java.lang.String c_eng_no,
                 "",//java.lang.String c_insrnc_cls,
                 "",//java.lang.String c_use_atr,
				 "",//java.lang.String c_undr_opn,
                 ""//java.lang.String c_internet_typ
          );
          
              plymanager.getEdrAppInfo(plyEdrGridInfo,
                                      plyedrappHolder,
                                      plyedrappcrgoHolder,
                                      plyedrapprdrHolder,
                                      plyedrapppayHolder,
                                      plyplyappnetHolder);

              plyEdrAppInfo  = PlyEdrAppInfoHelper.extract(plyedrappHolder.value);
              plyEdrAppCrgoInfo = PlyEdrAppCrgoInfoHelper.extract(plyedrappcrgoHolder.value);
              plyEdrAppRdrInfo  = PlyEdrAppRdrInfoHelper.extract(plyedrapprdrHolder.value);
              plyEdrAppPayInfo = PlyEdrAppPayInfoHelper.extract(plyedrapppayHolder.value);
              plyPlyAppNetInfo = PlyPlyAppNetInfoHelper.extract(plyplyappnetHolder.value);
              in_rdrinfo = plyEdrAppRdrInfo.edrapprdr;


             break;
			 case 5:
			  retValueBool =  plymanager.deleteEdrApp(fieldValue);
			  break;
          /* --------------------------added on 11.15 .2000 -------------
          //get Edrsmt App List
          case 2:
             retValueArra = plymanager.getEdrsmtAppList();
             break;
          // get EdrsmtApp Info
          case 3:
             retValueArra = plymanager.getEdrsmtAppInfo(fieldValue);
             break;
          //  get Proposal of Edrsmt App
          case 4:
             retValueArra = plymanager.getEdrsmtAppProposal(fieldValue);
             break;
          // confirm the proposal
          case 5:
             retValueArra = plymanager.confirmEdrsmtProposal(fieldValue);
             break;
          --------------------------------------------------------*/
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

    }


}
