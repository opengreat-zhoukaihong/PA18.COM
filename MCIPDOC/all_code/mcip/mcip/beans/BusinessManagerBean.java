////////////////////////////////////////////////////////
// Author:Kang Jin
// Function：For dataStream depose from jsp2jsp,For businessManager interface
// Create date：2000/10/6
// Update date：
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

public class BusinessManagerBean
{

    //for set property using,object para is to be defined
    private int operType;
    private static String[] formParaPre;  //for the form with two table to be deliveried
    private static String[] formPara;
	private static String[][] formTable;

    //for get property using:
    private String retValue;
    private String[][] retValueArra;    
    private boolean retValueBool = false;
    
    //for orb initial using
    org.omg.CORBA.ORB orb  ;
    BusinessManager bmanager;    

    public BusinessManagerBean()  
    {
       	  // Initialize the ORB.
         try
         {    
	     orb = ORBManager.getORBForClient();
		 bmanager = BusinessManagerHelper.bind(orb, "businessmanager");
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

    public void setFormTable(int operType,String[][] para) throws NormalException
    {
    	setOperType(operType);    	
        this.formTable = para;
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
			switch(operType)
			{
				case BConst.QUERY_PLYDEALLIST:
					retValueArra = bmanager.queryPlyDealList(formTable[0][0],formTable[1][0],
									formTable[2][0],formTable[3][0],formTable[4][0],formTable[5][0],
									formTable[6][0],formTable[7],formTable[8][0]);	    
		          	break;
				case BConst.QUERY_SEND_EMP_LIST:
					retValueArra = bmanager.queryPlyNetAbleEmp(formPara[0],formPara[1]);
					break;
				case BConst.ACCEPT_PLY_ASSIGN:
					retValueBool = bmanager.acceptPlyAssign(formPara[0],formPara[1],formPara[2],formPara[3],formPara[4]);
					break;
				case BConst.ACCEPT_PLY_SENDED:
					retValueBool = bmanager.acceptPlySended(formPara[0],formPara[1]);
					break;
				case BConst.ACCEPT_PLY_FEEDBACK:
					retValueBool = bmanager.acceptPlyFreebk(formPara[0],formPara[1]);
					break;
				case BConst.QUERY_RPT_FLWUPLIST:
					retValueArra = bmanager.queryRptFlwUpList(formTable[0][0],formTable[1][0],
									formTable[2][0],formTable[3][0],formTable[4][0],formTable[5][0],
									formTable[6][0],formTable[7][0],formTable[8],formTable[9][0]);	    
					break;
				case BConst.ACCEPT_RPT_FLWUPEMP:
					retValueBool = bmanager.acceptRptFlwUpEmp(formPara[0],formPara[1],formPara[2]);	    
					break;
       case BConst.QUERY_EVENT_TYPELIST :
           System.out.println("BConst QUERY_TYPELIST IN BusinessManager");
           retValueArra = bmanager.queryEventTypeList(formPara[0]);  
           break;
       case BConst.QUERY_EVENT_COUNTLIST :
           retValueArra = bmanager.queryEventCountList(formPara[0],
             formPara[1], formPara[2], formPara[3], formPara[4]);
           break;      
		case BConst.QUERY_GUIDE_LIST:
			retValueArra = bmanager.queryGuideList(formPara[0],formPara[1]);
			break;
		case BConst.QUERY_GUIDE_INFO:
			retValueArra = bmanager.queryGuideInfo(formPara[0],formPara[1]);
			break;
		case BConst.UPDATE_GUIDE_INFO:
			retValueBool = bmanager.updateGuideInfo(
										new InsrncGuideInfo(formPara[0],formPara[1],formPara[2],formPara[3],formPara[4],formPara[5],formPara[6]),
										formPara[7]);
			break;
		case BConst.ACCEPT_GUIDE_INFO:
			retValueBool = bmanager.acceptGuideInfo(
										new InsrncGuideInfo(formPara[0],formPara[1],formPara[2],formPara[3],formPara[4],formPara[5],formPara[6]),
										formPara[7]);
			break;
		case BConst.DELETE_GUIDE_INFO:
			retValueBool = bmanager.deleteGuideInfo(formPara[0],formPara[1]);
			break;
		case BConst.QUERY_CONSULT_LIST:
			retValueArra = bmanager.queryConsultList(formPara[0],formPara[1]);
			break;
		case BConst.QUERY_CONSULT_INFO:
			retValueArra = bmanager.queryConsultInfo(formPara[0],formPara[1]);
			break;
		case BConst.ACCEPT_CONSULT_INFO:
			retValueBool = bmanager.acceptConsultInfo( 
				new InsrncFaqInfo(formPara[0],formPara[1],formPara[2],formPara[3],formPara[4],formPara[5]),
				formPara[6]);
			break;
		case BConst.UPDATE_CONSULT_INFO:
			retValueBool = bmanager.updateConsultInfo( 
				new InsrncFaqInfo(formPara[0],formPara[1],formPara[2],formPara[3],formPara[4],formPara[5]),
				formPara[6]);
			break;
		case BConst.DELETE_CONSULT_INFO:
			retValueBool = bmanager.deleteConsultInfo(formPara[0],formPara[1]);
			break;
		case BConst.QUERY_FAQ_LIST:
			retValueArra = bmanager.queryFaqList(formPara[0],formPara[1]);
			break;
		case BConst.QUERY_FAQ_INFO:
			retValueArra = bmanager.queryFaqInfo(formPara[0],formPara[1]);
			break;
		case BConst.REPLY_FAQ:
			retValueBool = bmanager.updateFaqInfo(
							new CustFaqInfo(formPara[0],formPara[1],formPara[2],formPara[3],formPara[4],formPara[5],formPara[6],formPara[7],formPara[8]),
							formPara[9]);
			break;
		case BConst.DELETE_FAQ:
			retValueBool = bmanager.deleteFaqInfo(formPara[0],formPara[1]);
			break;
		case BConst.GET_PROPOSAL_STATICS:
		retValueArra = bmanager.getProposalStatictics(formTable[0][0],formTable[1][0],formTable[2],formTable[3][0],
											formTable[4][0],formTable[5][0],formTable[6][0],formTable[7][0],formTable[8][0],formTable[9][0]);

      break;
case BConst.GET_POLICY_STATICS:
			retValueArra = bmanager.getPolicyStatictics(formTable[0][0],formTable[1][0],formTable[2],formTable[3][0],
											formTable[4][0],formTable[5][0],formTable[6][0],formTable[7][0],formTable[8][0],formTable[9][0]);
			break;
case BConst.GET_CASE_RPT_STATICS:
			retValueArra = bmanager.getCaseRptStatictics(formTable[0][0],formTable[1][0],formTable[2],formTable[3][0],
											formTable[4][0],formTable[5][0],formTable[6][0],formTable[7][0],formTable[8][0],formTable[9][0]);
			break;
case BConst.GET_CUST_STATICS:
			retValueArra = bmanager.getCustStatictics(formTable[0][0],formTable[1][0],formTable[2],formTable[3][0],
											formTable[4][0],formTable[5][0]);
			break;
case BConst.GET_PLYAPP_STATICS:
			retValueArra = bmanager.getPlyAppStatictics(formTable[0][0],formTable[1][0],formTable[2],formTable[3][0],
											formTable[4][0],formTable[5][0],formTable[6][0],formTable[7][0],formTable[8][0],formTable[9][0],formTable[10][0]);
			break;
case BConst.GET_EDR_PLCY_STATICTICS:
			retValueArra = bmanager.getEdrPlcyStatictics(formTable[0][0],formTable[1][0],formTable[2],formTable[3][0],
											formTable[4][0],formTable[5][0],formTable[6][0],formTable[7][0],formTable[8][0],formTable[9][0]);
			break;
case BConst.ACCEPT_CLMDGST:
				retValueBool = bmanager.acceptClmDgst(new ClmDgstInfo(formPara[0],formPara[1],formPara[2],formPara[3],formPara[4],formPara[5]),formPara[6]);	    
				break;
case BConst.UPDATE_CLMDGST:
				retValueBool = bmanager.updateClmDgst(new ClmDgstInfo(formPara[0],formPara[1],formPara[2],formPara[3],formPara[4],formPara[5]),formPara[6]);	    
				break;
case BConst.DELETE_CLMDGST:
				retValueBool = bmanager.deleteClmDgst(formPara[0],formPara[1],formPara[2],formPara[3]);	    
				break;
case BConst.ACCEPT_CHAT_RECORD :
        System.out.println("Accept Chat Record in BB");        
        retValueBool = bmanager.acceptChatCntnt(formPara[0], formPara[1], formPara[2], formParaPre, formPara[3], formPara[4]);
        break;
case BConst.QUERY_CHAT_RECORD :
        System.out.println("Inquiry Chat Record in BB");
        retValueArra = bmanager.queryChatCntnt(formPara[0], formPara[1]);
       break;        
case BConst.GET_CUST_PLY_SUM :
        retValueArra = bmanager.getCustPlySum(formTable[0][0], formTable[1],formTable[2][0]);
       break; 
	   case BConst.GET_CHATRIGHT:
	    retValueArra = bmanager.getChatRight(formPara[0]);       
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
