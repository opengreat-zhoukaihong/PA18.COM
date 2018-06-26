////////////////////////////////////////////////////////
// Author£ºZhangJinQuan
// Function£ºFor jspOut data dispose
// Create date£º2000/8/23
// Update date£º2000/9/12
////////////////////////////////////////////////////////
package beans;

import javax.servlet.http.*;
import java.util.*;
import java.lang.*;
import java.beans.Beans;
import javax.servlet.*;
import exceptions.*;
import constant.*;
import utility.*;
import java.io.*;

public class Servlets
{
    private String[] delivery;
    private String[][] formData;

    private String RemoteOperType = "";
    private String[][] RemoteData = null;

    public Servlets()
    {
    	RemoteOperType = "";
    	RemoteData = null;
    }

    public Servlets(String RemoteOperTypePara,String[][] RemoteDataPara)
    {
    	RemoteOperType = RemoteOperTypePara;
    	RemoteData = RemoteDataPara;
    }

    public String[] getDelivery()
    {
    	return this.delivery;
    }
    public String[][] getFormData()
    {
    	return this.formData;
    }

//////////////////////////////////////////////////////////
//for Parameter get for all Servlets
/////////////////////////////////////////////////////////

    private void DataInit(HttpServletRequest request,String Para[],int ArraLen)
    {
	    String Sdate = "";
	    int i = 0;
	    int ParaLen = Para.length;
	    boolean IsRemoteGot = false;
	    String ParaValue = "";

    	delivery = new String[ArraLen];
	    formData = new String[2][ParaLen];

	    for(i = 0; i < ParaLen; i++)
	    {
	        formData[0][i] = Para[i];
/////////////////////////////////
//special fro remote data
////////////////////////////////
	        IsRemoteGot = false;
	        if(RemoteOperType.equals(Const.REMOTE_PRP) || RemoteOperType.equals(Const.REMOTE_PLY))
	        {
	        	int ColNum = Objects.getColNum(Para[i],RemoteData);
	        	String RemoteValue = RemoteData[1][ColNum];
	        	if(ColNum > 0 & !(RemoteValue == null || RemoteValue.equals("")))
	        	{
	        	     formData[1][i] = RemoteValue;
	        	     IsRemoteGot = true;
	        	}
		}
//////////////////////
//end special
//////////////////////
		if(!IsRemoteGot)
		{
			ParaValue = request.getParameter(Para[i]);
	        	formData[1][i] = ParaValue;
	        }

	        if(formData[1][i] == null)
	           formData[1][i] = "";

	    }

	    for(i = 0; i < ArraLen; i++)
	         delivery[i] = "";

    }

////////////////////////////////////////////////////////////////
//for policy input and notice get insuracecode
///////////////////////////////////////////////////////////////
    public static String  GetInsrnc(String TranType,String[] Transit)
    {
        String Insrnc = "";

        if(TranType == null)
           return Insrnc;

        if(TranType.equals(Const.C_HOME_CDE))
        {
        	if(Transit == null)
        	{
	           return Insrnc;
	        }
	        else
	        {
	        	for(int i = 0;i < Transit.length;i++)
	        	{
	        		if(!( Transit[i] == null || Transit[i].equals("")))
	        		{
					Insrnc = Transit[i];
					break;
				}
	        	}
        	}
        }
        else
        {
		Insrnc = TranType;
		//delivery[TabPly.C_INSRNC_CDE] = TranType;
        }

    	return Insrnc;
    }

//////////////////////////////////////////////////////////
//Servlets for get Notice pagecontent
/////////////////////////////////////////////////////////

    public void NoticeServlet(HttpServletRequest request)
    {
	    String Sdate = "";
	    int i = 0;
	    String Para[] = {"C_INSRNT_NME","C_PACK_CDE","C_PACK_CNM","C_AMOUNT","C_MARK","C_REMARK",
	"C_INVC_NO","C_RECEIPT_NO","C_CARRIAGE_CDE","C_SAIL_NO",
	"C_PRN_FRM_YEAR","C_PRN_FRM_MONTH","C_PRN_FRM_DATE",
	"C_FRM_PRT_ARA","C_FROM_PRT","C_PASS_PRT","C_TO_PRT_ARA",
	"C_TO_PRT","N_RATE","N_AMT","N_PRM","C_AMT_CUR","C_PRM_CUR","C_INSRNC_CDE",
	"C_CRGO_NAME","N_INVC_AMT","C_INVC_AMT_CUR","C_PRN_FRM","C_SRVY_ADDR","C_EDR_INFO","C_PAY_ADDR"};

        DataInit(request,Para,Const.POLICYINFO_LEN) ;



/////////////////////////////////////////////////////////////////////////////////////////
//Dimension of formData'i is also to be Objects.getColNum(fieldName,formData)
//for example:	delivery[TabPly.C_INSRNT_NME] =
//                    formData[1][Objects.getColNum("C_INSRNT_NME",formData)];
//
//another way:
//for example:	ServTool.setArraTwo(formData);
//              delivery[TabPly.C_INSRNT_NME] =
//                    formData[1][ServTool.getColNum("C_INSRNT_NME")];
//
/////////////////////////////////////////////////////////////////////////////////////////

	delivery[TabPly.C_INSRNT_NME] = formData[1][i];
	delivery[TabPly.C_PACK_CDE] = formData[1][++i];
	delivery[TabPly.C_PACK_CNM] = formData[1][++i];
	delivery[TabPly.C_AMOUNT] = formData[1][++i];
	delivery[TabPly.C_MARK] = formData[1][++i];
	delivery[TabPly.C_REMARK] = formData[1][++i];

	delivery[TabPly.C_INVC_NO] = formData[1][++i];
	delivery[TabPly.C_RECEIPT_NO] = formData[1][++i];
	delivery[TabPly.C_CARRIAGE_CDE] = formData[1][++i];
	delivery[TabPly.C_SAIL_NO] = formData[1][++i];

	i = i + 3;//for pass year,month,day
	Sdate = request.getParameter("tempdate");//Syear + "-"+Smonth +"-"+ Sday;//it to be check
	delivery[TabPly.T_INSRNC_BGN_TM] = Sdate;

	delivery[TabPly.C_FRM_PRT_ARA] = formData[1][++i];
	delivery[TabPly.C_FROM_PRT] = formData[1][++i];
	delivery[TabPly.C_PASS_PRT] = formData[1][++i];
	delivery[TabPly.C_TO_PRT_ARA] = formData[1][++i];

	delivery[TabPly.C_TO_PRT] = formData[1][++i];
	delivery[TabPly.N_RATE] = formData[1][++i];
	delivery[TabPly.N_AMT] = formData[1][++i];
	delivery[TabPly.N_PRM] = formData[1][++i];

	delivery[TabPly.C_AMT_CUR] = formData[1][++i];
	delivery[TabPly.C_PRM_CUR] = formData[1][++i];
	delivery[TabPly.C_INSRNC_CDE] = formData[1][++i];
	delivery[TabPly.C_CRGO_NAME] = formData[1][++i];
	delivery[TabPly.N_INVC_AMT] = formData[1][++i];
	delivery[TabPly.C_INVC_AMT_CUR] = formData[1][++i];


	delivery[TabPly.C_PRN_FRM] = formData[1][++i];
	delivery[TabPly.C_SRVY_ADDR] = formData[1][++i];
	delivery[TabPly.C_EDR_INFO] = formData[1][++i];
	delivery[TabPly.C_PAY_ADDR] = formData[1][++i];



//N_INVC_AMT  C_INVC_AMT_CUR
    }

//////////////////////////////////////////////////////////
//Servlets for get InputPolicy pagecontent
/////////////////////////////////////////////////////////

    public String[][] PolicyServlet(HttpServletRequest request,String TranType,String[] Transit,String[] TransitName)
    {
	    String Sdate = "";
	    int i = 0;
	    int j = 0;
	    String[][] Insurance = null;
	    String[][] InsuranceTemp = new String[22][2];
	    String Para[] = {"C_APP_NME","C_INSRNT_NME","C_PROVINCE","C_CITY","C_PLACE","C_CONTACT_NAME",
		"C_CONTACT_PHONE","C_CONTACT_FAX","C_CONTACT_EMAIL","C_CRGO_CLS","C_CRGO_CDE",
		"C_CRGO_DESC","C_PACK_CDE","C_PACK_CNM","C_AMOUNT","C_MARK","C_REMARK","N_INVC_AMT",
		"C_INVC_AMT_CUR","C_INVC_NO","C_RECEIPT_NO","C_SAIL_NO","C_CONTAINER","C_FRM_PRT_ARA",
		"C_FROM_PRT","C_TO_PRT_ARA","C_TO_PRT","C_PASS_PRT","birth_year","birth_month","birth_day",
		"N_AMT","C_AMT_CUR","N_PRM","C_PRM_CUR","C_NO_REPAY","N_RATE","C_MAIN_INSURANCE1",
		"C_MAIN_INSURANCE2","C_MAIN_INSURANCE3","C_MAIN_INSURANCE4","C_ADD_INSURANCE0","C_ADD_INSURANCE1","C_ADD_INSURANCE2",
		"C_ADD_INSURANCE3","C_ADD_INSURANCE4","C_ADD_INSURANCE5","C_ADD_INSURANCE6","C_ADD_INSURANCE7",
		"C_ADD_INSURANCE8","C_ADD_INSURANCE9","C_ADD_INSURANCE10","C_ADD_INSURANCE11","C_ADD_INSURANCE12",
		"C_ADD_RISK","C_UNDR_CNDTN","C_LOST_DESC","C_CRGO_NAME","C_INVC_AMT_CUR_TEMP",
		"C_AMT_CUR_CNM","C_PRM_CUR_CNM","C_PLY_APP_NO","C_ZIP_CDE","C_PRN_FRM","C_SRVY_ADDR","C_EDR_INFO","C_PAY_ADDR"};

        String[] City = new String[2];
        String CarriageCde = "01";
        String CarriageCdeConst[] = null;

//C_INSRNC_CDE//C_TO_PRT_ARA
        DataInit(request,Para,Const.POLICYINFO_LEN) ;

	delivery[TabPly.C_APP_NME] = formData[1][i];
	delivery[TabPly.C_INSRNT_NME] = formData[1][++i];

	delivery[TabPly.C_PROVINCE] = formData[1][++i];

	//special for city and dpt
	City = DivideStr(formData[1][++i],"&");
	delivery[TabPly.C_CITY] = City[0];
	City = DivideStr(City[1],"&");
	delivery[TabPly.C_DPT_CDE] = City[0];

	delivery[TabPly.C_PLACE] = formData[1][++i];
	delivery[TabPly.C_CONTACT_NAME] = formData[1][++i];
	delivery[TabPly.C_CONTACT_PHONE] = formData[1][++i];
	delivery[TabPly.C_CONTACT_FAX] = formData[1][++i];
	delivery[TabPly.C_CONTACT_EMAIL] = formData[1][++i];

	delivery[TabPly.C_CRGO_CLS] = formData[1][++i];
	delivery[TabPly.C_CRGO_CDE] = formData[1][++i];
	delivery[TabPly.C_CRGO_DESC] = formData[1][++i];
	delivery[TabPly.C_PACK_CDE] = formData[1][++i];
	delivery[TabPly.C_PACK_CNM] = formData[1][++i];
	delivery[TabPly.C_AMOUNT] = formData[1][++i];
	delivery[TabPly.C_MARK] = formData[1][++i];
	delivery[TabPly.C_REMARK] = formData[1][++i];
	delivery[TabPly.N_INVC_AMT] = formData[1][++i];
	delivery[TabPly.C_INVC_AMT_CUR] = formData[1][++i];
	delivery[TabPly.C_INVC_NO] = formData[1][++i];
	delivery[TabPly.C_RECEIPT_NO] = formData[1][++i];
	delivery[TabPly.C_SAIL_NO] = formData[1][++i];
	delivery[TabPly.C_CONTAINER] = formData[1][++i];
	delivery[TabPly.C_FRM_PRT_ARA] = formData[1][++i];
	delivery[TabPly.C_FROM_PRT] = formData[1][++i];
	delivery[TabPly.C_TO_PRT_ARA] = formData[1][++i];
	delivery[TabPly.C_TO_PRT] = formData[1][++i];
	delivery[TabPly.C_PASS_PRT] = formData[1][++i];

	i = i + 3;//for pass year,month,day
	Sdate = request.getParameter("tempdate");//Syear + "-"+Smonth +"-"+ Sday;//it to be check
	delivery[TabPly.T_INSRNC_BGN_TM] = Sdate;
	delivery[TabPly.N_AMT] = formData[1][++i];
	delivery[TabPly.C_AMT_CUR] = formData[1][++i];
	delivery[TabPly.N_PRM] = formData[1][++i];
	delivery[TabPly.C_PRM_CUR] = formData[1][++i];
	delivery[TabPly.C_NO_REPAY] = formData[1][++i];
	delivery[TabPly.N_RATE] = formData[1][++i];//
	j = i + 1;
	i  = i + 17;
		delivery[TabPly.C_ADD_RISK] = formData[1][++i];//
		delivery[TabPly.C_UNDR_CNDTN] = formData[1][++i];
		delivery[TabPly.C_LOST_DESC] = formData[1][++i];
		delivery[TabPly.C_CRGO_NAME] = formData[1][++i];
	i = i+4;
	delivery[TabPly.C_ZIP_CDE] = formData[1][++i];
    delivery[TabPly.C_PRN_FRM] = formData[1][++i];
	delivery[TabPly.C_SRVY_ADDR] = formData[1][++i];
	delivery[TabPly.C_EDR_INFO] = formData[1][++i];
	delivery[TabPly.C_PAY_ADDR] = formData[1][++i];
        //dispose for C_INSRNC_CDE
	delivery[TabPly.C_INSRNC_CDE] = GetInsrnc(TranType,Transit);

        if(TranType.equals(Const.C_HOME_CDE))
        {
        	CarriageCdeConst = Const.HOME_CARRIAGE_CDE;
	}
	else
	{
        	CarriageCdeConst = Const.PORT_CARRIAGE_CDE;
	}
	if(Transit != null)
	{
        	for(i = 0;i < Transit.length;i++)
        	{
        		if(!( Transit[i] == null || Transit[i].equals("")))
        		{
				CarriageCde = CarriageCdeConst[i];
				break;
			}
        	}
	}
	delivery[TabPly.C_CARRIAGE_CDE] = CarriageCde;

     //dispose transit message
        int row = 0;
	if(Transit == null)
        {
        	Insurance = null;
	}
        else
        {
                String ret[] = null;
        	//for(i = j; i < j + 18; i++)
			for(i = j; i < j + 17; i++)
        	{
        		if(!(formData[1][i] == null || formData[1][i].equals("")))
        		{
        			ret = DivideStr(formData[1][i],"&");
        			InsuranceTemp[row][0] = ret[0];
        			InsuranceTemp[row][1] = ret[1];
				++row;
        		}
        	}

        }
        Insurance = new String[row][2];
        for(i = 0; i < row; i++)
        {
        	Insurance[i][0] = InsuranceTemp[i][0];
        	Insurance[i][1] = InsuranceTemp[i][1];
        }
        return Insurance;
    }


//////////////////////////////////////////////////////////
//Servlets for get Entitycust pagecontent
/////////////////////////////////////////////////////////

    public void EntityServlet(HttpServletRequest request)
    {
	    String Para[] = {"C_USER_ID","C_User_pw","C_Pw_Question","C_Pw_Result"};
	    int i = 0;
	    int j = 0;
	    String CheckEntity[] = new String[3];

            DataInit(request,Para,Const.CUSTENTITY_LEN) ;

	    delivery[TabEty.C_USER_ID] =  formData[1][i];
	    delivery[TabEty.C_USER_PW] =  formData[1][++i];
	    delivery[TabEty.C_PW_QUESTION] = formData[1][++i];
	    delivery[TabEty.C_PW_RESULT] = formData[1][++i];

	    delivery[TabEty.C_USER_NAME] =  delivery[TabEty.C_USER_ID];

	    CheckEntity[j] = delivery[TabEty.C_USER_ID];
	    CheckEntity[++j] = delivery[TabEty.C_USER_PW];
	    CheckEntity[++j] =  request.getParameter("ConfirmPassword");


    }

//////////////////////////////////////////////////////////
//Servlets for get Prsncust pagecontent
/////////////////////////////////////////////////////////

    public void PrsnCustServlet(HttpServletRequest request)
    {
	    String Sdate = "";
	    int i = 0;
	    String Para[] = {"C_CLNT_NME","C_RGST_NO","C_SEX","C_NTN_CDE",
				"birth_year","birth_month","birth_day", "C_GRDT",
				"C_MAJOR_CDE","C_EDU_CDE","C_WORK_DPT","C_TITLE_CDE",
				"C_DUTY","C_TEL","C_FAX","C_EMAIL","C_ARA_CDE",
				"C_PROVINCE","C_CITY","C_PLACE","C_ZIP_CDE"};
            String Province[] = new String[2];
            int pointer = 0;

            DataInit(request,Para,Const.CUSTPRSN_LEN) ;

	    delivery[TabPrsn.C_CLNT_NME] = formData[1][i];
	    delivery[TabPrsn.C_RGST_NO] = formData[1][++i];
	    delivery[TabPrsn.C_SEX] = formData[1][++i];
	    delivery[TabPrsn.C_NTN_CDE] = formData[1][++i];

	    i = i + 3;//for pass year,month,day
	    Sdate = request.getParameter("tempdate");//Syear + "-"+Smonth +"-"+ Sday;//it to be check

	    delivery[TabPrsn.T_BIRTHDAY] = Sdate;

	    delivery[TabPrsn.C_GRDT] = formData[1][++i];
	    delivery[TabPrsn.C_MAJOR_CDE] = formData[1][++i];
	    delivery[TabPrsn.C_EDU_CDE] = formData[1][++i];
	    delivery[TabPrsn.C_WORK_DPT] = formData[1][++i];
	    delivery[TabPrsn.C_TITLE_CDE] = formData[1][++i];
	    delivery[TabPrsn.C_DUTY] = formData[1][++i];
	    delivery[TabPrsn.C_TEL] = formData[1][++i];
	    delivery[TabPrsn.C_FAX] = formData[1][++i];
	    delivery[TabPrsn.C_EMAIL] = formData[1][++i];
	    delivery[TabPrsn.C_ARA_CDE] = formData[1][++i];

//            Province = DivideStr(formData[1][++i],"&");
            delivery[TabPrsn.C_PROVINCE] = formData[1][++i];
//	    delivery[TabPrsn.C_DPT_CDE] = Province[1];

            Province = DivideStr(formData[1][++i],"&");
	    delivery[TabPrsn.C_CITY] = Province[0];
	    delivery[TabPrsn.C_DPT_CDE] = Province[1];

	    delivery[TabPrsn.C_PLACE] = formData[1][++i];
	    delivery[TabPrsn.C_ZIP_CDE] = formData[1][++i];
     }

//////////////////////////////////////////////////////////
//Servlets for get Orgncust pagecontent
/////////////////////////////////////////////////////////
     public void OrgnCustServlet(HttpServletRequest request)
     {
	    int i = 0;
	    String Para[] = {"C_CLNT_CDE","C_CHN_ABR","C_SCALE_CDE","C_CLNT_SCLE_CDE",
			    "C_ORGZ_TYP_CDE","C_BRD_ENM","C_ENG_ABR","C_OWNERSHIP_CDE","C_RGST_NO","N_RGST_MNY",
			    "C_CHIEF","N_EMLY_NUM", "C_TRD_CDE","C_CNTCT_PRSN_NME","C_TEL","C_FAX",
			    "C_EMAIL", "C_ARA_CDE","C_PROVINCE","C_CITY", "C_PLACE","C_ZIP_CDE","C_REMARK"};
            String Province[] = new String[2];
            int pointer = 0;

            DataInit(request,Para,Const.CUSTORGN_LEN) ;

	    delivery[TabOrgn.C_CLNT_NME] = formData[1][i];
	    delivery[TabOrgn.C_CHN_ABR] = formData[1][++i];
	    delivery[TabOrgn.C_SCALE_CDE] = formData[1][++i];
	    delivery[TabOrgn.C_CLNT_SCLE_CDE] = formData[1][++i];
	    delivery[TabOrgn.C_ORGZ_TYP_CDE] = formData[1][++i];
	    delivery[TabOrgn.C_BRD_ENM] = formData[1][++i];
	    delivery[TabOrgn.C_ENG_ABR] = formData[1][++i];
	    delivery[TabOrgn.C_OWNERSHIP_CDE] = formData[1][++i];
	    delivery[TabOrgn.C_RGST_NO] = formData[1][++i];
	    delivery[TabOrgn.N_RGST_MNY] = formData[1][++i];
	    delivery[TabOrgn.C_CHIEF] = formData[1][++i];
	    delivery[TabOrgn.N_EMLY_NUM] = formData[1][++i];
	    delivery[TabOrgn.C_TRD_CDE] = formData[1][++i];
	    delivery[TabOrgn.C_CNTCT_PRSN_NME] = formData[1][++i];
	    delivery[TabOrgn.C_TEL] = formData[1][++i];
	    delivery[TabOrgn.C_FAX] = formData[1][++i];
	    delivery[TabOrgn.C_EMAIL] = formData[1][++i];
	    delivery[TabOrgn.C_ARA_CDE] = formData[1][++i];

//            Province = DivideStr(formData[1][++i],"&");
            delivery[TabOrgn.C_PROVINCE] = formData[1][++i];
//	    delivery[TabPrsn.C_DPT_CDE] = Province[1];

            Province = DivideStr(formData[1][++i],"&");
	    delivery[TabOrgn.C_CITY] = Province[0];
	    delivery[TabOrgn.C_DPT_CDE] = Province[1];

	    delivery[TabOrgn.C_PLACE] = formData[1][++i];
	    delivery[TabOrgn.C_ZIP_CDE] = formData[1][++i];
      delivery[TabOrgn.C_REMARK] = formData[1][++i];

      }

//////////////////////////////////////////////////////
//get length of a array row
//////////////////////////////////////////////////////

      public static int getLen(String[][] Para)
      {
      	 int LenOfArra = 0;
      	 if(!(Para == null))
      	     LenOfArra = Para.length;

      	 return LenOfArra;
      }

//////////////////////////////////////////////////////
//divide Strings for two str connected with a flag
//////////////////////////////////////////////////////

      public static String[] DivideStr(String Str,String flag)
      {

        int i = 0;
        String[] ret= new String[2];
        if(Str == null || Str.equals(""))
           return ret;
      	i = Str.indexOf(flag);
      	if (i < 0)
      	    return ret;

        ret[1] = Str.substring(++i);
        ret[0] = Str.substring(0,--i);

        return ret;

	}
//////////////////////////////////////////////
// divide Strings for multi str by flag
/////////////////////////////////////////////

	public static String[] DivideMultiStr(String Str,String flag)
	{
	        int i = 0;
	        String[] ret= null;
	        if(Str == null || Str.equals(""))
	           return ret;

		String tmpStr = Str;
		tmpStr = tmpStr.trim();
		if (tmpStr.length() == 0)
		   return ret;

		StringTokenizer stFirst = new StringTokenizer(tmpStr,flag);
		ret = new String[stFirst.countTokens()];
		while (stFirst.hasMoreTokens())
		{
			try
			{
		 		ret[i] = stFirst.nextToken();
			}
			catch(NoSuchElementException e)
			{
				return null;
			}
			++i;
		}

		return ret;
	}

////////////////////////////////////////////////////////
//put chinese name to hashtable according to code
////////////////////////////////////////////////////////

      public static Hashtable PutCnm(Hashtable hashPara,String hashCde,String hashCnm,String[][] Result,String Cde,String Cnm)
      {
	      //if hashcde is "" then only to get arran len and colnum
	      Hashtable hashData = hashPara;
	      String DefaultValue = Objects.getHt(hashData,hashCde);

	      int Len = Servlets.getLen(Result);
	      int CdeCol = Objects.getColNum(Cde,Result);
	      int CnmCol = Objects.getColNum(Cnm,Result);
	      boolean IsFind = false;
	      //Vector VecResult = new Vector();

/////////////////////////////////////////////
//defaultvalue special for city,currency
///////////////////////////////////////////////
              if(hashCde.equals("C_CITY") || hashCde.equals("C_INVC_AMT_CUR_TEMP"))
              {
			String Code[] = Servlets.DivideStr(DefaultValue,"&");
			DefaultValue = Code[0];
			if(DefaultValue == null)
			     DefaultValue = "";
              }
/////////////////////////////////////////////////
/////////////////////////////////////////////////
	      if(!(hashCde.equals("")))
	      {
		      if(DefaultValue.equals(""))
		      {
		         hashData.put(hashCnm,Const.SELECT);
		      }
		      else  if(Len > 1)
		      {
		         for(int i = 1 ; i <Len; i++)
		         {
		             if(Result[i][CdeCol].equalsIgnoreCase(DefaultValue))
		             {
		                 hashData.put(hashCnm,Result[i][CnmCol]);
		                 IsFind = true;
		             }
		         }
		         if(!IsFind)
		         {
		                 hashData.put(hashCde,"");
		                 hashData.put(hashCnm,Const.SELECT);
		         }
		      }
              }

              //VecResult.addElement()
	      return hashData;
      }

//////////////////////////////////////////////////////////
//According to transit and rdrinfo to get insrncAdd info
//////////////////////////////////////////////////////////

   public static String[] GetInsrncAddtion(String[][] PlyAppRdrInfo,String[] PortTransitPara)
   {
	int c_rdr_cde =  Objects.getColNum("c_rdr_cde",PlyAppRdrInfo);
	int c_rdr_nme =  Objects.getColNum("c_rdr_nme",PlyAppRdrInfo);
	int RdrLen = Servlets.getLen(PlyAppRdrInfo);
        String[] PortTransit = PortTransitPara;

        if( RdrLen> 1)
        {
           for(int g=0;g<Const.PORT_TRANSIT_LEN;g++)
                PortTransit[g] = "";

           String TempRdrInfo = Const.PORT_INSRNC_CDE;
           int TempIndex = 0;
           for(int k = 1;k< RdrLen; k++)
           {
               TempIndex = TempRdrInfo.indexOf(PlyAppRdrInfo[k][c_rdr_cde]);

               if(TempIndex > 0 && TempIndex < 6*3)
               {
	               PortTransit[Const.N_SEA_CDE] = Const.C_LANDWAY_CDE;
               }
               else if(TempIndex > 6*3 && TempIndex < 8*3)
               {
	               PortTransit[Const.N_LANDWAY_CDE] = Const.C_LANDWAY_CDE;
               }
               else if(TempIndex > 8*3 && TempIndex < 10*3)
               {
	               PortTransit[Const.N_AVIATION_CDE] = Const.C_LANDWAY_CDE;
               }
           }//end for

        }//end rdrlen>1
        else
        {
        }

        return PortTransit;
   }


////////////////////////////////////////////////////////////
// get file content according to filename&path
///////////////////////////////////////////////////////////

  public static String GetFileContent(String FileName) throws NormalException
  {
	    File inputFile;
	    FileInputStream fis;
	    String FileContent = "";

  	 if (FileName == null || FileName.equals(""))
  	    return FileContent;

	  try
	  {
	    inputFile = new File(FileName);
	    if (!inputFile.exists())
	    {
	 	    throw NormalExceptionHandler.Handle("0001","File not found");
	    }

	    fis = new FileInputStream(FileName);
	    byte bt[] = new byte[(int)inputFile.length()];
	    fis.read(bt);
	    FileContent = new String(bt);
	  }
	  catch(NullPointerException e)
	  {
	 	    throw NormalExceptionHandler.Handle(e);
	  }
	  catch(FileNotFoundException e)
	  {
	 	    throw NormalExceptionHandler.Handle(e);
	  }
	  catch(IOException e)
	  {
	 	    throw NormalExceptionHandler.Handle(e);
	  }

	  return FileContent;

  }

}//END CLASS