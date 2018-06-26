/*
==================================================================
=== 	 Author： 				zlx												===
===	 Function：				For userManager interface				   ===
===	 Create date：			2000/09/20										===
===	 Last update date：	2000/11/13										===
==================================================================
*/

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

public class Zuserbean
{

    //for set property using,object para is to be defined
    private int operType;
    private static String[] formParaPre;  //for the form with two table to be deliveried
    private static String[] formPara;
    
    //for get property using:
    private String retValue;
    private String[][] retValueArra;    
//    private String[][] retValueArra2=new String[2][12];    
    private boolean retValueBool = false;
    
    //for orb initial using
    org.omg.CORBA.ORB orb  ;
    UserManager usermanager;    

    public Zuserbean()  
    {
       	  // Initialize the ORB.
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

		retValueArra = null; 	//To be sure retValueArra = null when null exception raises
      //for client CORBA invoke
      //is to analyst corba exception type
   	
         try{    
		  //call remote methods with in inout parameter
		switch(operType)
		{
			case ZConst.QUERY_SYSFUNCLIST:
				retValueArra = usermanager.querySysFuncList(formPara[0]);	    		
		          	break;
			case ZConst.UPDATE_SYSFUNC:
				retValueBool = usermanager.updateSysFunc(ZObjects.getSysFuncInfo(formPara));	    		
		          	break;
			case ZConst.ACCEPT_SYSFUNC:
				retValueBool = usermanager.acceptSysFunc(ZObjects.getSysFuncInfo(formPara));	    		
		          	break;
			case ZConst.QUERY_PAGESLIST:
				retValueArra = usermanager.queryPagesList(formPara[0]);	    		
		          	break;
			case ZConst.UPDATE_PAGESINFO:
				retValueBool = usermanager.updatePagesInfo(ZObjects.getPagesInfo(formPara));	    		
		          	break;
			case ZConst.ACCEPT_PAGESINFO:
				retValueBool = usermanager.acceptPagesInfo(ZObjects.getPagesInfo(formPara));	    		
		          	break;
			case ZConst.QUERY_OPTRDPTLIST:
				retValueArra = usermanager.queryOptrDptList(formPara[0]);	    		
		          	break;
			case ZConst.CHECK_OPTRAUTH:
				retValueBool = usermanager.checkOptrAuth(formPara[0],formPara[1]);	    		
		          	break;
			case ZConst.QUERY_CUSTENTTLIST:
				if(formPara[7].equals(""))formPara[7]="0";
				if(formPara[8].equals(""))formPara[8]="0";
				retValueArra = usermanager.queryCustEnttList(formPara[0],formPara[1],formParaPre,formPara[3]
						,formPara[4],formPara[5],formPara[6],Integer.parseInt(formPara[7]),Integer.parseInt(formPara[8]),formPara[9]);	    		
		          	break;
			case ZConst.QUERY_SAMECUSTLIST:
				retValueArra = usermanager.querySameCustList(formPara[0]);	    		
		          	break;
			case ZConst.ACCEPT_USERVERIFY:	//modify 2000/11/13,add optr_cde
				retValueBool = usermanager.acceptUserVerify(formPara[0],formPara[1],formPara[2],formPara[3],formPara[4],formPara[5]);	    		
		          	break;
			case ZConst.DELETE_PAGESINFO:
				retValueBool = usermanager.deletePagesInfo(formPara[0]);	    		
		          	break;
			case ZConst.DELETE_SYSFUNC:
				retValueBool = usermanager.deleteSysFunc(formPara[0]);	    		
		          	break;

			//add by zlx 2000/10/30
			case ZConst.QUERY_CLNTMAPLIST:
				retValueArra = usermanager.queryClntMapList(formPara[0],formPara[1]);	    		
		          	break;
			case ZConst.ACCEPT_CLNTMAPINFO:
				retValueBool = usermanager.acceptClntMapInfo(formPara[0],formPara[1],formPara[2],formPara[3],formPara[4]);	    		
		          	break;
			case ZConst.DELETE_CLNTMAPINFO:
				retValueBool = usermanager.deleteClntMapInfo(formPara[0],formPara[1],formPara[2],formPara[3]);	    		
		          	break;
			//add by zlx 2000/12/27
			case ZConst.QUERY_SUPPEMAILLIST:
				retValueArra = usermanager.querySuppEmailList(formPara[0],formParaPre,formPara[1]);	    		
		          	break;
			case ZConst.ACCEPT_SUPPEMAIL:
				retValueBool = usermanager.acceptSuppEmail(formPara[0],formPara[1],formPara[2],formPara[3],formPara[4]);	    		
		          	break;
			case ZConst.UPDATE_SUPPEMAIL:
				retValueBool = usermanager.updateSuppEmail(formPara[0],formPara[1],formPara[2],formPara[3],formPara[4],formPara[5]);	    		
		          	break;
			case ZConst.DELETE_SUPPEMAIL:
				retValueBool = usermanager.deleteSuppEmail(formPara[0]);	    		
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
    
    //Main method
  public static void main(String[] args) {
    int i = 0;

	 String formpara[]=new String[10];
	 String formparaPre[]=new String[1];
    String info[][]=null;
    boolean IsAccept=false;

//begin userbean
	Zuserbean obj_user=new Zuserbean();
	for(i=0;i<10;i++)
		formpara[i]="";
	formpara[0]="test1111";
	formpara[1]="0";
	formpara[9]="11111aa";
	formparaPre[0]="201";
	obj_user.setFormParaPre(ZConst.QUERY_CUSTENTTLIST,formparaPre);
	obj_user.setFormPara(ZConst.QUERY_CUSTENTTLIST,formpara);
	info=obj_user.getRetValueArra();
  } //for main

}
