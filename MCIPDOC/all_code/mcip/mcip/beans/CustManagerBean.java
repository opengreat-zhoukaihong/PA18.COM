////////////////////////////////////////////////////////
// Author：ZhangJinQuan
// Function：For dataStream depose from jsp2jsp,For custManager interface
// Create date：2000/7/31
// Update date：2000/8/04
////////////////////////////////////////////////////////

package beans;

import java.io.*;
import java.util.*;
import java.lang.*;
import java.beans.Beans;
import javax.servlet.*;
import javax.servlet.http.*;
import exceptions.*;
import com.mcip.cus.orb.*;
import com.mcip.orb.*;
import constant.*;
import utility.*;

public class CustManagerBean
{

		//for set property using,object para is to be defined
		private int operType;
		private String[] formParaPre;  //for the form with two table to be deliveried
		private String[] formPara;
		private Object[] objectFormPara;

		//for get property using:
		private String retValue;
		private String[][] retValueArra;
		private boolean retValueBool = false;
		private String registerType = "0";

		//for orb initial using
		org.omg.CORBA.ORB orb  ;
		CustManager cmanager;

		public CustManagerBean()
		{
					// Initialize the ORB.
				 try
				 {
					 orb = ORBManager.getORBForClient();
		 cmanager = CustManagerHelper.bind(orb, "cmanager");
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

		public void setObjectFormPara(int operType,Object[] para)
		{
			setOperType(operType);
				this.objectFormPara = para;
				this.ProcessLogic();

		}

		public void setRegisterType(String s){
			 registerType = s ;
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
			case Const.CUSTOMER_LOGIN:
				retValueArra = cmanager.customerLogin(formPara[0],formPara[1]);
/*			 	if ((retValueArra == null) || (retValueArra[0][0].trim().equalsIgnoreCase("")))
				{
								throw new NormalException("登录错误：非法用户名或id");
								}
*/
								break;
						 case Const.ACCEPT_ORGACUST:
							 System.out.println("registerType:"+ registerType);
				retValueBool = cmanager.acceptOrgaCust(registerType,Objects.getCustOrgn(formPara),Objects.getCustEntity(formParaPre));
								break;
			 case Const.ACCEPT_PRSNCUST:
				retValueBool = cmanager.acceptPrsnCust(registerType,Objects.getCustPrsn(formPara),Objects.getCustEntity(formParaPre));
								break;
			 case Const.ACCEPT_AGNTCUST:
				retValueBool = cmanager.acceptAgntCust(Objects.getCustEntity(formPara));
								break;

				 case Const.UPDATE_ORGACUST:
				retValueBool = cmanager.updateOrgaCust(Objects.getCustOrgn(formPara),formParaPre[0]);
								break;
			 case Const.UPDATE_PRSNCUST:
				retValueBool = cmanager.updatePrsnCust(Objects.getCustPrsn(formPara),formParaPre[0]);
								break;
			 case Const.UPDATE_ENTTCUST:
				retValueBool = cmanager.updateEnttCust(Objects.getCustEntity(formPara));
								break;
			 case Const.QUERY_CUSTENTT:
				retValueArra = cmanager.queryCustEntt(formPara[0]);
								break;
			 case Const.QUERY_CUSTORGN:
				retValueArra = cmanager.queryCustOrgn(formPara[0]);
								break;
			 case Const.QUERY_CUSTPRSN:
				retValueArra = cmanager.queryCustPrsn(formPara[0]);
								break;
			 case Const.QUERY_CUSTAGNT:
				retValueArra = cmanager.queryCustAgnt(formPara[0]);
								break;

			 case Const.REQUIRECUST:
				retValueArra = cmanager.requireCust(formPara[0],formPara[1],formPara[2]);
								break;
          //Author 康进
          //Purpose:删除用户功能
          //Date:2001-09-14
          //ID:2001091401
          /*begin of add 2001091401*/
              case Const.DELETE_ILLEGAL_USER:
                retValueBool = cmanager.deleteIllegalUser(formPara[0]);
                  break;
          /*end of add 2001091401*/
			 //Add by ClarkRao
			 case  Const.CHECK_PROPOSAL:
				//public boolean checkProposal(String in_user_id, String in_cust_typ)
				System.out.println(formPara[0]+","+formPara[1]);
				 retValueBool = cmanager.checkProposal(formPara[0],formPara[1]);
				 break;
				case Const.QUERY_AGENCY_INFO:
					retValueArra = cmanager.queryAgencyInfo(formPara[0]);
					break;
				case Const.QUERY_OC_CUST_INFO:
					retValueArra = cmanager.queryOCcustInfo(formPara[0]);
					break;
				case Const.ACCEPT_OC_CUST:
					retValueBool = cmanager.acceptOCCust(
								(String) objectFormPara[0],
								(com.mcip.cus.orb.CustOrgn) objectFormPara[1],
								(com.mcip.cus.orb.CustEntity) objectFormPara[2]);
					break;
				case Const.ACCEPT_AG_CUST:
					//test code
					System.out.println("in accept agency");
					retValueBool = cmanager.acceptAGCust(
									(String) objectFormPara[0],
									(com.mcip.cus.orb.CustOrgn) objectFormPara[1],
									(com.mcip.cus.orb.CustEntity) objectFormPara[2]);
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

		public String ProcessLogin(String[][] Result,String UserId,String SessionId) throws NormalException
		{

			SessionBuffer sessionbuffer = SessionBuffer.getSessionBuffer();
			String sessionId = SessionId;//new String(sessionbuffer.getNewSessionId());
			int Locate ;
						sessionbuffer.ProcessSession(Const.SESSDEL,sessionId);
			Locate = sessionbuffer.ProcessSession(Const.SESSNEW,sessionId);
			if (Locate < 0)
			{

							throw NormalExceptionHandler.Handle(ExceptionCode.SYS_SESSION_INIT_FAILURE);
			}

			int ResultLen = Servlets.getLen(Result);
			if(ResultLen < 2)
			{
							throw NormalExceptionHandler.Handle(ExceptionCode.NO_CLIENT_INFO);
			}
			int c_clnt_cde = Objects.getColNum("C_CLNT_CDE",Result);
			int c_clnt_nme = Objects.getColNum("C_CLNT_NME",Result);
			int c_verify   = Objects.getColNum("C_VERIFY",Result);
			int c_clnt_mrk = Objects.getColNum("C_CLNT_MRK",Result);
			int c_cmpny_agt_cde = Objects.getColNum("c_cmpny_agt_cde",Result);
			int c_cust_typ =  Objects.getColNum("c_cust_typ",Result);
			int c_agt_nme =  Objects.getColNum("c_agt_nme",Result);
			int c_agt_cde =  Objects.getColNum("c_agt_cde",Result);

			String CustType = Result[1][c_cust_typ];
			if(CustType.equals(Const.CUST_CM) || CustType.equals(Const.CUST_OC))//common
			{
				sessionbuffer.setClientId(Locate,Result[1][c_clnt_cde]);
					sessionbuffer.setClientName(Locate,Result[1][c_clnt_nme]);
			}
			else if(CustType.equals(Const.CUST_AG))//agent
			{
					sessionbuffer.setCompanyId(Locate,Result[1][c_cmpny_agt_cde]);
					sessionbuffer.setClientId(Locate,Result[1][c_cmpny_agt_cde]);
					sessionbuffer.setClientName(Locate,Result[1][c_agt_nme]);
					sessionbuffer.setClientFlag(Locate,Result[1][c_agt_cde]);
			}

			sessionbuffer.setUserId(Locate,UserId);
			sessionbuffer.setClientFlag(Locate,Result[1][c_clnt_mrk]);
			sessionbuffer.setClientVerifyFlag(Locate,Result[1][c_verify]);
			sessionbuffer.setClientType(Locate,CustType);

			int c_dpt_caddr = Objects.getColNum("C_DPT_CADDR",Result);
			int c_dpt_cde = Objects.getColNum("C_DPT_CDE",Result);
			int c_ctct_cde = Objects.getColNum("C_CTCT_CDE",Result);
			int c_tel = Objects.getColNum("C_TEL",Result);
			int c_fax = Objects.getColNum("C_FAX",Result);
			int c_dpt_cnm =  Objects.getColNum("C_DPT_CNM",Result);
			String ClientAddInfo[] = new String[Const.CLIENT_ADD_LEN];
			ClientAddInfo[0] = Result[1][c_dpt_caddr];
			ClientAddInfo[1] = Result[1][c_ctct_cde];
			ClientAddInfo[2] = Result[1][c_tel];
			ClientAddInfo[3] = Result[1][c_fax];
			ClientAddInfo[4] = Result[1][c_dpt_cde];
			ClientAddInfo[5] = Result[1][c_clnt_cde];
			// Added by Clarkrao-------12/19/2000
			ClientAddInfo[6] = Result[1][c_dpt_cnm];
			//end added
			sessionbuffer.setClientAddInfo(Locate,ClientAddInfo);

			return sessionId;
		}

		public String[][] ProcessRemotePara(HttpServletRequest request,String[] Para) throws NormalException
		{
						int i = 0;
			int ParaLen = Para.length;
			String[][] Return = new String[2][ParaLen];

			for(i = 0; i < ParaLen; i++)
			{
					Return[0][i] = Para[i];
					Return[1][i] = request.getParameter(Para[i]);
					if(Return[1][i] == null)
						 Return[1][i] = "";

System.out.println(Return[0][i]+"  :::  "+Return[1][i]);
			 }

			 return Return;

		}
}
