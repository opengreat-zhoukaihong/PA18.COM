////////////////////////////////////////////////////////
// Author：ZhangJinQuan
// Function：For getobject in beans
// Create date：2000/8/12
// Update date：2000/8/12
////////////////////////////////////////////////////////

package beans;

import java.io.*;
import java.util.*;
import java.lang.*;
import java.lang.reflect.*;
import exceptions.*;
import com.mcip.cus.orb.*;
import com.mcip.nia.orb.*;
import com.mcip.orb.*;
import constant.*;
import utility.*;

public class Objects
{

    public Objects()
    {
    	super();
    }

//////////////////////////////////////////////////////////
//for translate String to Int
/////////////////////////////////////////////////////////
    public static int  ToInt(String sValue) throws NormalException
    {
    	int retInt = 0;

    	if(!(sValue == null || sValue.equals("")))
    	{
	        try
	        {
	        	retInt = Integer.parseInt(sValue);

	        }
	    	catch(NumberFormatException e)
	    	{
	    		throw NormalExceptionHandler.Handle(e);
	    	}

        }

    	return retInt;
    }

//////////////////////////////////////////////////////////
//for translate String to double
/////////////////////////////////////////////////////////

    public static double  ToDouble(String sValue) throws NormalException
    {
    	double retDouble = 0;
    	sValue = sValue.trim();

    	if(!(sValue == null || sValue.equals("")))
    	{
    	System.out.println("enter double svalue:"+sValue);
	        try
	        {
	        	retDouble = Double.parseDouble(sValue);

	        }
	    	catch(NumberFormatException e)
	    	{
	    		throw NormalExceptionHandler.Handle(e);
	    	}

    	System.out.println("over double:svalue:"+sValue);
       }

    	return retDouble;
    }

//////////////////////////////////////////////////////////
//for translate String to char
/////////////////////////////////////////////////////////

    private static char  ToChar(String sValue) throws NormalException
    {
    	char retChar = 'a';

    	if(!(sValue == null || sValue.equals("")))
    	{

	    	String TempValue = sValue.trim();
	    	try
	    	{
	    		retChar = TempValue.charAt(0);
	    	}
	        catch(IndexOutOfBoundsException e)
	        {
		    	throw NormalExceptionHandler.Handle(e);
	        }
	}
    	return retChar;
    }

//////////////////////////////////////////////////////////
//for get object cusrOrgn according to array
/////////////////////////////////////////////////////////

    public  static CustOrgn getCustOrgn(String[] st) throws NormalException
    {
    	    	System.out.println("Enter custorgn");
    	//st is the value of CustOrgn structure
    	CustOrgn co;

    	try
    	{
    		co = new CustOrgn(st[TabOrgn.C_CLNT_CDE] ,
				    st[TabOrgn.C_DPT_CDE] ,
				    ToInt(st[TabOrgn.N_CLNT_GRP_CDE]) ,
				    st[TabOrgn.C_CLNT_MRK] ,
				    st[TabOrgn.C_CLNT_NME] ,
				    st[TabOrgn.C_CHN_ABR] ,
				    st[TabOrgn.C_AUTH_MRK] ,
				    st[TabOrgn.C_SCALE_CDE] ,
				    st[TabOrgn.C_CLNT_SCLE_CDE] ,
				    st[TabOrgn.C_ORGZ_TYP_CDE] ,
				    st[TabOrgn.C_BRD_ENM] ,
				    st[TabOrgn.C_ENG_ABR] ,
				    st[TabOrgn.C_OWNERSHIP_CDE] ,
				    st[TabOrgn.C_RGST_NO] ,
				    st[TabOrgn.C_TAX_NO] ,
				    ToDouble(st[TabOrgn. N_RGST_MNY]) ,
				    st[TabOrgn.C_CHIEF] ,
				    ToInt(st[TabOrgn.N_EMLY_NUM]) ,
				    st[TabOrgn.C_TRD_CDE] ,
				    st[TabOrgn.C_UPR_DPT_CDE] ,
				    st[TabOrgn.C_IMPT_CLNT_CDE] ,
				    st[TabOrgn.C_CNTCT_PRSN_NME] ,
				    st[TabOrgn.C_TEL] ,
				    st[TabOrgn.C_FAX] ,
				    st[TabOrgn.C_EMAIL] ,
				    st[TabOrgn.C_CLNT_ADDR] ,
				    st[TabOrgn.C_ARA_CDE] ,
				    st[TabOrgn.C_PROVINCE] ,
				    st[TabOrgn.C_CITY] ,
				    st[TabOrgn.C_PLACE] ,
				    st[TabOrgn.C_ZIP_CDE] ,
				    st[TabOrgn.C_BANK] ,
				    st[TabOrgn.C_ACCNT_NO] ,
				    st[TabOrgn.C_REMARK],
				    st[TabOrgn.T_UPD_TM]
				    );

    	}
    	catch(NumberFormatException e)
    	{
    		throw NormalExceptionHandler.Handle(e);
    	}
    	catch(Exception e)
    	{
    		throw NormalExceptionHandler.Handle(e);
    	}

    	return co;
    }

//////////////////////////////////////////////////////////
//for get object cusrPrsn according to array
/////////////////////////////////////////////////////////

    public static CustPrsn getCustPrsn(String[] st) throws NormalException
    {
    	    	System.out.println("Enter custprsn");
    	//st is the value of CustPrsn structure
    	CustPrsn cp;


    	try
    	{
                cp = new CustPrsn(st[TabPrsn.C_CLNT_CDE] ,
				    st[TabPrsn.C_DPT_CDE] ,
				    ToInt(st[TabPrsn.N_CLNT_GRP_CDE]) ,
				    st[TabPrsn.C_CLNT_MRK] ,
				    st[TabPrsn.C_CLNT_NME] ,
				    st[TabPrsn.C_CHN_ABR] ,
				    st[TabPrsn.C_AUTH_MRK] ,
				    st[TabPrsn.C_BRD_ENM] ,
				    st[TabPrsn.C_ENG_ABR] ,
				    st[TabPrsn.C_RGST_NO] ,
				    st[TabPrsn.C_SEX] ,
				    st[TabPrsn.C_HMTWN] ,
				    st[TabPrsn.C_NTN_CDE] ,
				    st[TabPrsn.T_BIRTHDAY] ,
				    st[TabPrsn.C_MRG_CDE] ,
				    st[TabPrsn.C_GRDT] ,
				    st[TabPrsn.C_MAJOR_CDE] ,
				    st[TabPrsn.C_EDU_CDE] ,
				    st[TabPrsn.C_WORK_DPT] ,
				    st[TabPrsn.C_TITLE_CDE] ,
				    st[TabPrsn.C_DUTY] ,
				    st[TabPrsn.C_TEL] ,
				    st[TabPrsn.C_FAX] ,
				    st[TabPrsn.C_EMAIL] ,
				    st[TabPrsn.C_CLNT_ADDR] ,
				    st[TabPrsn.C_ARA_CDE] ,
				    st[TabPrsn.C_PROVINCE] ,
				    st[TabPrsn.C_CITY] ,
				    st[TabPrsn.C_PLACE] ,
				    st[TabPrsn.C_ZIP_CDE] ,
				    st[TabPrsn.C_BANK] ,
				    st[TabPrsn.C_ACCNT_NO] ,
				    st[TabPrsn.C_REMARK],
				    st[TabPrsn.C_IMPT_CLNT_CDE],
				    st[TabPrsn.T_UPD_TM]
				    );

  	}
    	catch(Exception e)
    	{
    		throw NormalExceptionHandler.Handle(e);
    	}


    	return cp;
    }

//////////////////////////////////////////////////////////
//for get object cusrEntity according to array
/////////////////////////////////////////////////////////

    public  static CustEntity getCustEntity(String[] st) throws NormalException
    {
    	System.out.println("Enter custentity");
    	//st is the value of CustEntity structure
    	CustEntity ce;

    	try
    	{
             ce = new CustEntity(st[TabEty.C_USER_ID] ,
				    st[TabEty.C_USER_NAME] ,
				    st[TabEty.C_USER_PW] ,
				    st[TabEty.C_PW_QUESTION] ,
				    st[TabEty.C_PW_RESULT] ,
				    st[TabEty.C_CLNT_CDE],
				    ToInt(st[TabEty.N_USER_SEQ_NO]) ,
				    ToChar(st[TabEty.C_VERIFY]),
				    st[TabEty.C_CMPNY_AGT_CDE],
				    st[TabEty.C_NET_ID]);

   	}
    	catch(Exception e)
    	{
    		throw NormalExceptionHandler.Handle(e);
    	}

    	return ce;
    }


//////////////////////////////////////////////////////////
//for get object Policy according to array
/////////////////////////////////////////////////////////

     public  static PlcyAppInfo getPlcyAppInfo(String[] st) throws NormalException
    {
    	//st is the value of PlcyAppInfo structure
    	PlcyAppInfo pa;

/*    	if(!(st.length == Const.CUSTORGN_LEN))//34
    	{
    	    throw new NormalException("系统内部参数传递错误(数组长度)");
    	}*/

    	try
    	{

    	        pa = new PlcyAppInfo(st[TabPly.C_PLY_APP_NO],
				    st[TabPly.C_PLY_NO],
				    st[TabPly.C_ORIG_PLY_NO],
				    st[TabPly.C_DPT_CDE],
				    st[TabPly.C_BSNS_TYP] ,
				    st[TabPly.C_CMPNY_AGT_CDE],
				    st[TabPly.C_CMPNY_AGT_NME] ,
				    st[TabPly.C_AGT_AGR_NO],
				    ToInt(st[TabPly.N_SUB_CO_NO]) ,
				    st[TabPly.C_BRKR_CDE],
				    st[TabPly.C_BRKR_NME] ,
				    st[TabPly.C_SLS_CDE],
				    st[TabPly.C_SLS_NME] ,
				    st[TabPly.C_INSRNC_CMPNY_CDE] ,
				    st[TabPly.C_INSRNC_CMPNY_NME] ,
				    st[TabPly.C_INSRNT_CDE],
				    st[TabPly.C_INSRNT_NME] ,
				    st[TabPly.C_INSRNT_ADDR],
				    st[TabPly.C_BNFC_CDE] ,
				    st[TabPly.C_BNFC_NME] ,
				    st[TabPly.C_APP_CDE] ,
				    st[TabPly.C_APP_NME] ,
				    st[TabPly.C_APP_ADDR],
				    st[TabPly.C_APP_TEL] ,
				    st[TabPly.C_INSRNC_CDE],
				    st[TabPly.C_CLAUS_CDE] ,
				    st[TabPly.T_APP_TM] ,
				    st[TabPly.T_INSRNC_BGN_TM],
				    st[TabPly.T_INSRNC_END_TM] ,
				    st[TabPly.T_SIGN_TM] ,
				    st[TabPly.C_AMT_CUR] ,
				    ToDouble(st[TabPly.N_INSRNC_VLU]),
				    ToDouble(st[TabPly.N_AMT]) ,
				    ToDouble(st[TabPly.N_RATE])*0.01 ,
				    ToDouble(st[TabPly.N_PRM]) ,
				    ToDouble(st[TabPly.N_RDR_PRM]) ,
				    ToDouble(st[TabPly.N_SUM_PRM]),
				    st[TabPly.C_PRM_CUR] ,
				    ToDouble(st[TabPly.N_NCLM_PROP]) ,
				    ToDouble(st[TabPly.N_APPNT_PROP]) ,
				    ToDouble(st[TabPly.N_CMM_PROP]) ,
				    ToDouble(st[TabPly.N_BRK_PROP]),
				    ToInt(st[TabPly.N_PAY_TMS]),
				    st[TabPly.C_APPNT] ,
				    st[TabPly.C_REMARK] ,
				    st[TabPly.C_CRT_PRSN] ,
				    st[TabPly.C_UNDR_PRSN] ,
				    st[TabPly.T_UNDR_TM] ,
				    st[TabPly.C_RINSRNC_MRK] ,
				    st[TabPly.C_COINSRNC_MRK] ,
				    st[TabPly.T_INPUT_TM] ,
				    st[TabPly.C_UNDR_DPT],
				    st[TabPly.C_OPR_TYP] ,
				    st[TabPly.C_EDR_PRJ_NO] ,
				    st[TabPly.T_NEXT_EDR_UNDR_TM] ,
				    st[TabPly.C_UDR_MRK] ,
				    st[TabPly.C_AGELONG_MRK] ,
				    st[TabPly.C_CEPRN_MRK] ,
				    st[TabPly.C_SALEGRP_CDE] ,
				    st[TabPly.C_OPEN_COVER_NO] ,
				    st[TabPly.C_INTERNET_TYP] ,
				    st[TabPly.C_CRGO_CDE] ,
				    st[TabPly.C_CRGO_DESC] ,
				    st[TabPly.C_INVC_NO] ,
				    st[TabPly.C_SAIL_NO] ,
				    st[TabPly.C_PRN_FRM] ,
				    st[TabPly.C_CARRIAGE_CDE] ,
				    st[TabPly.C_VSL_LVL_CDE] ,
				    st[TabPly.C_FROM_PRT] ,
				    st[TabPly.C_TO_PRT] ,
				    st[TabPly.C_FRM_PRT_ARA] ,
				    st[TabPly.C_TO_PRT_ARA] ,
				    st[TabPly.C_PASS_PRT] ,
				    st[TabPly.C_SRVY_CDE] ,
				    st[TabPly.C_SRVY_CNM] ,
				    st[TabPly.C_UNDR_CNDTN] ,
				    st[TabPly.C_PAY_ADDR],
				    st[TabPly.C_RECEIPT_NO] ,
				    st[TabPly.C_CRGO_CLS] ,
				    st[TabPly.C_CRGO_NAME] ,
				    st[TabPly.C_AMOUNT] ,
				    st[TabPly.C_PACK_CDE] ,
				    st[TabPly.C_PACK_CNM] ,
				    st[TabPly.C_MARK] ,
				    ToDouble(st[TabPly.N_INVC_AMT]) ,
				    st[TabPly.C_INVC_AMT_CUR] ,
				    st[TabPly.C_NO_REPAY] ,
				    st[TabPly.C_CREDIT_ID] ,
				    st[TabPly.C_LOST_DESC] ,
				    st[TabPly.C_CONTAINER] ,
				    st[TabPly.C_ADD_RISK] ,
				    st[TabPly.C_MAIN_INSURANCE] ,
				    st[TabPly.C_ADD_INSURANCE] ,
				    st[TabPly.C_RDR_CDE] ,
				    st[TabPly.C_RDR_NME] ,
				    st[TabPly.C_RMK_DESC],
				    st[TabPly.C_PROVINCE],
				    st[TabPly.C_CITY],
				    st[TabPly.C_PLACE],
				    st[TabPly.C_CONTACT_NAME],
				    st[TabPly.C_CONTACT_PHONE],
				    st[TabPly.C_CONTACT_FAX],
				    st[TabPly.C_CONTACT_EMAIL],
				    st[TabPly.C_PAY_MDE_CDE],
				    st[TabPly.C_SITE_CDE],
					st[TabPly.C_ZIP_CDE],
					st[TabPly.C_SRVY_ADDR],
					st[TabPly.C_EDR_INFO],
					st[TabPly.C_MDFY_TM]
);
    	}
    	catch(NumberFormatException e)
    	{
			System.out.println(e);
    		throw NormalExceptionHandler.Handle(e);
    	}
    	catch(NormalException e)
    	{
			System.out.println(e);
    		throw NormalExceptionHandler.Handle(e);
    	}

    	catch(Exception e)
    	{
			System.out.println(e);
    		throw NormalExceptionHandler.Handle(e);
    	}


		//ADDD____________________BY RAO
		  Object obj = (Object)pa;
          Class c = obj.getClass();
		  Field[] fields =c.getFields();
		  String fieldName ="";
		  String fieldValue="";
		  System.out.println("pmb.plyEdrAppInfo fields:");
		  for (int  i = 0; i < fields.length; i++) {
			try{
				fieldName = fields[i].getName();
				fieldValue=(c.getField(fieldName).get(obj)).toString();
				System.out.print(i+":"+fieldName+":"+fieldValue+"\n");

			  }catch(Exception e){
				  throw NormalExceptionHandler.Handle(e);
			 }
		  }
		//END

    	return pa;
    }

//////////////////////////////////////////////////////////
//for get value of a array by col
/////////////////////////////////////////////////////////

   public static String getValue (int row, String fieldname, String[][] Para)
   {
   	for (int j=0;j<(Para[0].length);j++)
   	{
   	    if (fieldname.trim().equalsIgnoreCase(Para[0][j].trim()))
   	       return Para[row][j];
   	}
   	return "";
   }

//////////////////////////////////////////////////////////
//for get Column number of a array by colname
/////////////////////////////////////////////////////////

   public static int getColNum (String fieldname, String[][] Para)
   {
        if(Para == null)
           return 0;
   	for (int j=0;j<(Para[0].length);j++)
   	{
   	    if (fieldname.trim().equalsIgnoreCase(Para[0][j].trim()))
   	       return j;
   	}
   	return 0;
   }

//////////////////////////////////////////////////////////
//for get chinese name by code of a array
/////////////////////////////////////////////////////////

   public static String getColName (String[][] Result,String Cde)
   {

      String Cnm = "";
      if(Result == null)
           return Cnm;
      if(Cde == null)
          Cde = "";

      int Len = Servlets.getLen(Result);
      int CdeCol = getColNum(Cde,Result);

	if(Len > 1)
        {
	         for(int i = 1 ; i <Len; i++)
	         {
	             if(Result[i][CdeCol].equalsIgnoreCase(Cde))
	             {
      			 int CnmCol = getColNum(Cnm,Result);
	                 Cnm = Result[i][CnmCol];
	             }   break;
	         }
	 }

       return Cnm;
   }

//////////////////////////////////////////////////////////
//for get Value :chinese name by code of a array
/////////////////////////////////////////////////////////

   public static String getValueCnm (String[][] ResultPara,String ColCde,String ColCnm,String ValueCde)
   {


      String ValueCnm = "";
      String[][] Result = ResultPara;
      if(Result == null)
           return ValueCnm;

      if(ValueCde == null)
          ValueCde = "";

      int Len = Servlets.getLen(Result);
      int ColCdeNum = getColNum(ColCde,Result);
      int ColCnmNum = getColNum(ColCnm,Result);
	if(Len > 1)
        {
	         for(int i = 1 ; i <Len; i++)
	         {
	             if(Result[i][ColCdeNum].equals(ValueCde))
	             {
	                 ValueCnm = Result[i][ColCnmNum];
	                    break;
	             }
	         }
	 }

       return ValueCnm;
   }

//////////////////////////////////////////////////////////
//for get value of a hash by key
/////////////////////////////////////////////////////////

  public static String getHt(Hashtable ht,String KeyStr)
  {
  	if(ht == null || KeyStr == null || KeyStr.equals(""))
  	   return "";
  	if(!ht.containsKey(KeyStr))
  	  	KeyStr = KeyStr.toUpperCase();
  	if(!ht.containsKey(KeyStr))
  	   return "";

  	if(ht.get(KeyStr) == null)
  	   return "";

  	return ht.get(KeyStr).toString();

  }
  public static String getScaleNumber(String arg, int scale){
     char c;
     if(arg==null)return "";
	 arg= arg.trim();
	 if(arg.length()==0 || arg.equals(""))return "";
     int point = arg.indexOf(".");
	 if(point<=0) {
	   System.out.println("case in Objects");
	   for(int i=0 ;i< arg.length(); i++){
	    c= arg.charAt(i);
		if(Character.digit(c,10)>=0)continue;
        if(c=='.'){ System.out.println("case 1 in objects"+i); continue;}
		else{ System.out.println("case 2 in objects"+i);  return arg; }
	   }
	   //arg = arg+".";
	   //for(int i=0 ;i<scale ;i++)arg = arg+"0";
	   return arg;
	 }

	 if(arg.length()<= (point+scale+1)){
	   System.out.println("case 0 in objects");
	   for(int i=0 ;i< arg.length(); i++){
	    c= arg.charAt(i);
		if(Character.digit(c,10)>=0)continue;
        if(c=='.'){ System.out.println("case 1 in objects"+i); continue;}
		else{ System.out.println("case 2 in objects"+i);  return arg; }
	   }
       //for(int i= arg.length();i<point+scale+1 ;i++) arg= arg+"0";
	   return arg;
     }

	 for(int i=0 ;i< arg.length(); i++){
	    c= arg.charAt(i);
		if(Character.digit(c,10)>=0)continue;
        if(c=='.'){ System.out.println("case 1 in objects"+i); continue;}
		else{ System.out.println("case 2 in objects"+i);  return arg; }
	 }
	 arg = arg.substring(0,point+scale+1);
	 return arg;

  }

  public static String getScaleNumberZero(String arg, int scale){
     char c;
     if(arg==null)return "";
	 arg= arg.trim();
	 if(arg.length()==0 || arg.equals(""))return "";
     int point = arg.indexOf(".");
	 if(point<=0) {
	   System.out.println("case in Objects");
	   for(int i=0 ;i< arg.length(); i++){
	    c= arg.charAt(i);
		if(Character.digit(c,10)>=0)continue;
        if(c=='.'){ System.out.println("case 1 in objects"+i); continue;}
		else{ System.out.println("case 2 in objects"+i);  return arg; }
	   }
	   arg = arg+".";
	   for(int i=0 ;i<scale ;i++)arg = arg+"0";
	   return arg;
	 }

	 if(arg.length()<= (point+scale+1)){
	   System.out.println("case 0 in objects");
	   for(int i=0 ;i< arg.length(); i++){
	    c= arg.charAt(i);
		if(Character.digit(c,10)>=0)continue;
        if(c=='.'){ System.out.println("case 1 in objects"+i); continue;}
		else{ System.out.println("case 2 in objects"+i);  return arg; }
	   }
       for(int i= arg.length();i<point+scale+1 ;i++) arg= arg+"0";
	   return arg;
     }

	 for(int i=0 ;i< arg.length(); i++){
	    c= arg.charAt(i);
		if(Character.digit(c,10)>=0)continue;
        if(c=='.'){ System.out.println("case 1 in objects"+i); continue;}
		else{ System.out.println("case 2 in objects"+i);  return arg; }
	 }
	 arg = arg.substring(0,point+scale+1);
	 return arg;

  }
  public static String getTrimZero(String arg){
     if(arg==null || arg.equals(""))return "";
	 int point = arg.indexOf(".");
	 if(point<0){return arg;}
	 int Len = arg.length();
	 if(arg.substring(Len-1).equals("0")){
	    arg = arg.substring(0,(Len-1));
		arg = getTrimZero(arg);
		return arg;
	 }else{
	    if(arg.substring(Len-1).equals("."))arg = arg.substring(0,(Len-1));
	    return arg;
	 }

  }
  public static void main(String args[]){
     System.out.println("test:"+ Objects.getTrimZero(args[0]));
  }
}
