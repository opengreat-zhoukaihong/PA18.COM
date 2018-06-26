////////////////////////////////////////////////////////
// Author:Kang Jin
// Function：For dataStream depose from jsp2jsp,For businessManager interface
// Create date：2001-4-23
// Update date：
////////////////////////////////////////////////////////
package	beans;

import java.io.*;
import java.util.*;
import java.lang.*;
import java.beans.Beans;
import exceptions.*;
import org.omg.CORBA.*;
import com.mcip.pay.orb.*;
import com.mcip.orb.*;
import constant.*;
import utility.*;

public class PaymentManagerBean{

	//for set property using,object para is to be defined
	private int operType;
	private static String[] formParaPre;  //for the form with two table to be deliveried
	private static String[] formPara;
	private static String[][] formTable;
	private static java.lang.Object[] formParaObj;

	//for get property using:
	private String retValue;
	private String[][] retValueArra;
	private boolean retValueBool = false;

	//for orb initial using
	org.omg.CORBA.ORB orb ;
	PaymentManager paymanager;

	public PaymentManagerBean(){
		// Initialize the ORB.
		try{
          orb = ORBManager.getORBForClient();
       	  paymanager =
	               PaymentManagerHelper.bind(orb, "paymanager");
		}catch (Exception e){
			throw NormalExceptionHandler.Handle(e);
		}
	}

	public void setOperType(int operType){
		this.operType = operType;
	}

	public void setFormParaPre(int operType,String[] paraPre){
		setOperType(operType);
		this.formParaPre = paraPre;
	}

	public void setFormParaObj(int operType,java.lang.Object[] paraObject){
		setOperType(operType);
		this.formParaObj = paraObject;
		this.ProcessLogic();
	}

	public void setFormPara(int operType,String[] para) throws NormalException{
		setOperType(operType);
		this.formPara = para;
		this.ProcessLogic();
	}

	public void setFormTable(int operType,String[][] para) throws NormalException{
		setOperType(operType);
		this.formTable = para;
		this.ProcessLogic();
	}

	public String getRetValue(){
		return this.retValue;
	}

	public String[][] getRetValueArra(){
		return this.retValueArra;
	}

	public boolean getRetValueBool(){
		return this.retValueBool;
	}


	//逻辑流程控制程序

	private void ProcessLogic()  throws NormalException{

	//for client CORBA invoke
	//is to analyst corba exception type

		 try{
			switch(operType){
				case PConst.ACCEPT_PAYMENT_LOG:
					retValueBool = paymanager.acceptPaymentLog((com.mcip.pay.orb.PaymentLog)formParaObj[0]);
					break;
				case PConst.GET_PAYMENT_LOG_LIST:
					retValueArra = paymanager.getPaymentLogList(
								(String) formParaObj[0], (String) formParaObj[1], (String[]) formParaObj[2],
								(String) formParaObj[3], (String) formParaObj[4], (String) formParaObj[5],
								(String) formParaObj[6], (String) formParaObj[7]);
				
					break;
					case PConst.QUERY_LAST_PAYMENT:
						retValueArra = paymanager.queryLastPayment(
								(String) formParaObj[0], (String) formParaObj[1], (String) formParaObj[2], 
								(String) formParaObj[3], (String) formParaObj[4]);
						break;
					case PConst.QUERY_PAYMENT_LIST:
						retValueArra = paymanager.queryPaymentList(
								(String) formParaObj[0], (String) formParaObj[1], (String) formParaObj[2], 
								(String) formParaObj[3], (String) formParaObj[4]);
						break;
					case PConst.UPDATE_PAY_FLAG:
						retValueBool = paymanager.updatePayFlag( formPara[0],  formPara[1],  formPara[2],  formPara[3],  formPara[4],  formPara[5],  formPara[6],  formPara[7],  formPara[8],  formPara[9],  formPara[10],  formPara[11]);
						break;
					case PConst.UPDATE_PAY_LOG:
						retValueBool = paymanager.updatePaymentLog((com.mcip.pay.orb.PaymentLog)formParaObj[0]);
						break;
					/*case PConst.QUERY_PAYMENT_LOG:
						retValueArra = paymanager.queryPaymentLog((String) formParaObj[0]);
						break;*/
					case PConst.GET_DPT_PAY_LIST:
						retValueArra = paymanager.getDptPayList((String)formParaObj[0], (String)formParaObj[1], (String[])formParaObj[2],(String)formParaObj[3],(String)formParaObj[4],(String)formParaObj[5]);
						break;
					case PConst.GET_BANK_PAY_LIST:
						retValueArra = paymanager.getBankPayList((String)formParaObj[0], (String)formParaObj[1], (String[])formParaObj[2],(String)formParaObj[3], (String)formParaObj[4], (String)formParaObj[5]);
						break;
				default:
					throw NormalExceptionHandler.Handle(ExceptionCode.SYS_PARA_ERR);
			}
		}/*
		catch(CoException e){
			throw  NormalExceptionHandler.Handle(e);//throw new NormalException("CORBAR Exception:" +e.errDescription);
		}
		catch (NormalException e){
			throw  NormalExceptionHandler.Handle(e);//throw new NormalException(e.getMessage());
		}*/
		catch (Exception e){
			throw  NormalExceptionHandler.Handle(e);// throw new NormalException(e.getMessage());
		}
		return;
	}
	public static void main(String args[]){
		beans.PaymentManagerBean pb = new beans.PaymentManagerBean();
	}
}
