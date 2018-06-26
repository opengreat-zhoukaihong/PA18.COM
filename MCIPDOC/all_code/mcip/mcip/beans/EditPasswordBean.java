package beans;

import java.io.*;
import java.util.*;
import java.lang.*;
import java.beans.Beans;
import exceptions.*;
import com.mcip.cus.orb.*;
import com.mcip.orb.*;
import constant.*;
import utility.*;

public class EditPasswordBean
{
 // ---- InPara ----
 private String userMark;
 private String cUserIdIn;
 private String cRgstNo;
 private CustEntity custEntity;

 // ---- OutPara ----
 private String[][] retValueArra;
 private boolean retValue = false;

 private String cUserIdOut;
 private String cUserName;
 private String cPwQuestion;
 private String cPwResult;

 // ---- ORB environment ----
 org.omg.CORBA.ORB orb;
 CustManager custManager;

 public EditPasswordBean()
 {
  try
  {
   orb = ORBManager.getORBForClient();
		 custManager = CustManagerHelper.bind(orb,"cmanager");
	 }
  catch (Exception e)
  {
 	 throw  NormalExceptionHandler.Handle(e);
  }
 }

 // ---- 验证用户 ----
 public void setFormPara(String s1,String s2,String s3) throws NormalException
 {
  this.userMark = s1;
  this.cUserIdIn = s2;
  this.cRgstNo = s3;
  this.ProcessLogic();
 }

 /*
 // ---- 修改用户口令，s1为新口令 ----
 public void setFormPara(String s1) throws NormalException
 {
  custEntity = new CustEntity();
  custEntity.c_user_id = retValueArra[1][0];
  custEntity.c_user_name = retValueArra[1][1];
  custEntity.c_user_pw = s1;
  custEntity.c_pw_question = retValueArra[1][2];
  custEntity.c_pw_result = retValueArra[1][3];
  custEntity.n_user_seq_no = 0;

  this.ProcessLogic(custEntity);
 } */

 public void setFormPara(String s1,String s2,String s3,String s4,String s5) throws NormalException
 {
   custEntity = new CustEntity();
   custEntity.c_user_id = s1;
   custEntity.c_user_name = s2;
   custEntity.c_user_pw = s3;
   custEntity.c_pw_question = s4;
   custEntity.c_pw_result = s5;

   custEntity.n_user_seq_no = 0;
   custEntity.c_clnt_cde = s1;
   custEntity.c_cmpny_agt_cde = s1;
   custEntity.c_net_id = s1;
   
   this.ProcessLogic(custEntity);
 }

 public String[][] getRetValueArra()
 {
  return this.retValueArra;
 }

 public boolean getRetValue()
 {
  return this.retValue;
 }

 private void ProcessLogic() throws NormalException
 {
  try
  {
   retValueArra = custManager.requireCust(userMark,cUserIdIn,cRgstNo);
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

 private void ProcessLogic(CustEntity ce) throws NormalException
 {
  try
  {
    retValue = custManager.updateEnttCust(ce);
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

 /*
 public boolean compareAnswer(String answer)
 {
  return retValueArra[1][3].equals(answer);
 } */
}
