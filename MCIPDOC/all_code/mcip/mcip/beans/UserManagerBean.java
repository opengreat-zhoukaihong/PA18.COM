////////////////////////////////////////////////////////
// Author：Clark_Rao
// Function：For dataStream depose from jsp2jsp,For UserManager interface
// Create date：2000/09/25

////////////////////////////////////////////////////////


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


//Please tell me when MODIFIED, REPLACED, DELETE!!!!
// CLARK_RAO

public class UserManagerBean
{

    //for set property using,object para is to be defined
    private int operateType;
    private static String[][] formParaPre;  //for the form with two table to be deliveried
    private static String[] formPara;


    private String retValue;
    private String[][] retValueArra;
    private boolean retValueBool = false;


    org.omg.CORBA.ORB orb  ;
    UserManager usermanager;

    public UserManagerBean()
    {
         try
         {
	         orb = ORBManager.getORBForClient();
    		   usermanager = UserManagerHelper.bind(orb, "usermanager");
         }
         catch (Exception e)
         {
 	         throw NormalExceptionHandler.Handle(e);
         }
    }
    //added by Clark_rao 2000.10.30
    Hashtable LoggerDptList = null;
    Hashtable OprDptList = null;
    Vector  LoggerDpt_CDE_List = null ;
    public void setLoggerDpt_CDE_List(Vector v){
       LoggerDpt_CDE_List = v;
    }
    public Vector getLoggerDpt_CDE_List(){
       return  LoggerDpt_CDE_List;
    }
    public void setLoggerDptList(Hashtable v){
       LoggerDptList = v;
    }
    public void setOprDptList(Hashtable v){
       OprDptList = v;
    }
    
    public Hashtable getLoggerDptList(){
       return  LoggerDptList;
    }
    public Hashtable getOprDptList(){
       return OprDptList;
    }
    //end added
    public void setOperType(int operType)
    {
        this.operateType = operType;
    }

    public void setFormParaPre(int operType,String[][] paraPre)
    {
    	  setOperType(operType);
        this.formParaPre = paraPre;
    }

    public void setFormPara(int operType,String[] para) throws NormalException
    {
    	  setOperType(operType);
        this.formPara = para;
        ProcessLogic();
    }
    String act_typ, auth_opr_cde, in_opr_cde;
    String[][] optrauthinfo, optrdptinfo;
    public void ExecuteAuth(int operType, String act_type, String auth_opr_cde,
                             String in_opr_cde,
                            java.lang.String[][] optrauthinfo,
                            java.lang.String[][] optrdptinfo)
    throws NormalException
    {
    	  setOperType(operType);
        this.act_typ = act_type ;
        this.auth_opr_cde = auth_opr_cde;
        this.in_opr_cde = in_opr_cde;
        this.optrauthinfo = optrauthinfo;
        this.optrdptinfo = optrdptinfo;
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


    //逻辑流程控制程序
   //Please tell me when MODIFIED, REPLACED, DELETE!!!!
   //CLARK_RAO

    private void ProcessLogic()throws NormalException
    {
      try{

		   switch(operateType)
		  {
			   case ZConst.OPERATOR_LOGIN://Const.USER_LOGIN:
				   retValueArra = usermanager.operatorLogin(formPara[0],formPara[1]);
		       break;

		     case ZConst.ACCEPT_OPERATOR :
               OperatorInfo operatorInfo = new OperatorInfo(formPara[0],
                                        formPara[1],formPara[2],
                                        formPara[3], formPara[4],
                                        formPara[5]
                                        );
				       retValueBool = usermanager.acceptOperator( operatorInfo);
		          	break;
         case ZConst.UPDATE_OPERATOR :
               OperatorInfo operatorObj = new OperatorInfo(formPara[0],
                                        formPara[1],formPara[2],
                                        formPara[3],formPara[4],
                                        formPara[5]
                                        );
				       retValueBool = usermanager.updateOperator(operatorObj);
		          	break;

        case ZConst.DELETE_OPERATOR :
             retValueBool = usermanager.deleteOperator (formPara[0],formPara[1],formPara[2],formPara[3]);
             break;
        case ZConst.QUERY_OPTRINFO:
		      retValueArra = usermanager.queryOptrInfo(formPara[0]);
			  break;
        case ZConst.QUERY_OPTRLIST :
             retValueArra = usermanager.queryOptrList(formPara[0],
                                     formPara[1], formPara[2],
                                     formPara[3]);
             break;
         case ZConst.QUERY_AUTHLIST :
               retValueArra = usermanager.queryAuthList(formPara[0],
                                     formPara[1], formPara[2],
                                     formPara[3]);
              break;
         case ZConst.QUERY_PAGESLIST:
              retValueArra = usermanager.queryPagesList(formPara[0]);
            break;
		    case ZConst.QUERY_OPTRDPTLIST:
			      retValueArra = usermanager.queryOptrDptList(formPara[0]);
			  break;

        case ZConst.QUERY_ABLEDPTLIST :
             retValueArra = usermanager.queryAbleDptList(formPara[0], formPara[1]);
             break;
        case ZConst.EXECUTE_OPTRAUTH:
             retValueBool = usermanager.executeOptrAuth(act_typ, auth_opr_cde,
                            in_opr_cde, optrauthinfo, optrdptinfo);
             break;

       case ZConst.QUERY_SUBDPTLIST :

            retValueArra = usermanager.querySubDptList(formPara[0]);  

            break;
       case ZConst.REPPLACEAUTHOPTR :
            retValueBool = usermanager.replaceAuthOptr(formPara[0], formPara[1]);
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
class DptInfo{

     public String c_dpt_cde, c_snr_dpt,c_dpt_cnm, c_dpt_enm, c_snr_cnm, c_snr_enm;

     public DptInfo(String c_dpt_cde,String c_snr_dpt,String c_dpt_cnm,
                    String c_dpt_enm,  String c_snr_cnm,
                    String c_snr_enm){
                    this.c_dpt_cde = c_dpt_cde;
                    this.c_snr_dpt = c_snr_dpt;
                    this.c_dpt_cnm = c_dpt_cnm;
                    this.c_dpt_enm = c_dpt_enm;
                    this.c_snr_cnm = c_snr_cnm;
                    this.c_snr_enm = c_snr_enm;
                    }

}
