////////////////////////////////////////////////////////
// Author：ZhangJinQuan
// Function：For get colnum of a array by a fieldname
// Create date：2000/9/15
// Update date：2000/9/18
////////////////////////////////////////////////////////


package beans;

import java.util.*;
import java.lang.*;
import java.io.*;

public class ServTool
{
    private static String[] StrArraOne = null;
    private static String[][] StrArraTwo = null;
    private static Hashtable hash = new Hashtable();
    private final static String ONE_DIMEN = "0";
    private final static String TWO_DIMEN = "1";    
        
    public ServTool()
    {
    }

////////////////////////////////////////////////////////////////////
//The following is to get colNum from array according colName
///////////////////////////////////////////////////////////////////
    public  void setHash(Hashtable hashPara)
    {
    	this.hash = hashPara;
    } 
    
    public static void setArraOne(String[] Str)
    {
    	ServTool.StrArraOne = Str;
    	putToHash(ONE_DIMEN);
    }

    public static void setArraTwo(String[][] Str)
    {
    	ServTool.StrArraTwo = Str;
    	putToHash(TWO_DIMEN);    	
    }

    private static void  putToHash(String Flag)
    {
    	String s[] = null;

       if(Flag.equals(ONE_DIMEN))
       {
          s = ServTool.StrArraOne;
       }   
       else if(Flag.equals(TWO_DIMEN))
       {
          s = ServTool.StrArraTwo[0];       	
       }
       
       ServTool.hash.clear();	
       for(int i =0;i<s.length;i++)
       {
         if(!(s[i] == null))
         {
             ServTool.hash.put(s[i],String.valueOf(i));
         }
       }
       
       return;
    }
///////////////////////////////////////////////////
//get col number according to col name
///////////////////////////////////////////////////    
    public static int getColNum(String field)
    {
     	int i = 0;
    	String t = Objects.getHt(ServTool.hash,field);

        if(t.equals(""))
            return 0;
           
    	try
    	{
    		i = Integer.parseInt(t);
	}
	catch(Exception e)
	{
	}

    	return i;
    }
    
    public static int getColNum(String[] Str ,String field)
    {
    	ServTool.setArraOne(Str);
    	return getColNum(field);
    }	

    public static int getColNum(String[][] Str ,String field)
    {
    	ServTool.setArraTwo(Str);
    	return getColNum(field);
    }	
    
////////////////////////////////////////////////////////////
//Get system date and datetime
/////////////////////////////////////////////////////////////    
    public static String getSysDate(int DayDiff)
    {
    	  Calendar Cal = Calendar.getInstance();
//    	  if(DayDiff > 0)
//    	  {
	  	Cal.add(Cal.DAY_OF_YEAR , DayDiff);//DAY_OF_YEAR
//	  	Cal.roll(Cal.DATE , true);//DAY_OF_YEAR	  		  	
//	  	Cal.roll(Cal.DATE , DayDiff);//DAY_OF_YEAR	  	
//	  }
	  Date date = Cal.getTime();
	  java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
	  String Sdate = sdf.format(date);
	  
	  return Sdate;

    }
//hh:mm:ss 
    public static String getSysDateTime()
    {
    	  Calendar Cal = Calendar.getInstance();    	
	  Date date = Cal.getTime();
	  java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	  String Sdate = sdf.format(date);
	  
	  return Sdate;
    }
/////////////////////////////////
//end get datatime
///////////////////////////////////

    public static boolean IsInArray(String[] Str,String Svalue)
    {
     	if(Str == null || Svalue == null)
     	  return false;
     	int StrLen = Str.length;
     	for(int i =0 ; i < StrLen; i++)  
     	{
     		if(Svalue.equals(Str[i]))
     		     return true;
     	}
     	
     	return false;
     }

////////////////////////////////////////////////
//to make jscript:city according province
//////////////////////////////////////////////////
//var city = new Array(
//new Array("合肥-01","芜湖-02","蚌埠-03","巢湖-04","滁州-05","淮南-06","安庆-07","宣城-08","马鞍山-09","黄山-10","铜陵-11","宿州-12","淮北-13","阜阳-14","其它-99"),
//new Array("北京-00","其它-99"),
//new Array("台湾-00"),
//new Array("其他-00")
//);
///////////////////////////////////////////////////////
    public static String JSMake(String[][] City,String[][] Province,String DeptFlag)
    {
    	    int ProvinceLen = Servlets.getLen(Province);   
            int CityLen = Servlets.getLen(City);           
            if(ProvinceLen < 1 || CityLen< 1)
               return "";
            int c_city = Objects.getColNum("c_city",City);
            int c_city_cnm = Objects.getColNum("c_city_cnm",City);
            int c_province = Objects.getColNum("c_province",City);      
            int c_dpt_cde = 0;
            int c_province_prov = Objects.getColNum("c_city",Province);           
            
            if(DeptFlag.equals("0"))//not to add dept cde 
            {
                c_dpt_cde = -1;
            }
            else
            {
            	c_dpt_cde =  Objects.getColNum("c_dpt_cde",City);            
            }    
            
            String JS = "";
            for(int i =1; i < ProvinceLen; i++)      
            {
            	if(JS.length() > 0)
            	   JS = JS + ",";
            	
            	JS = JS + JSData(City,CityLen,c_city,c_city_cnm,c_dpt_cde,c_province,Province[i][c_province_prov]);   
            }
//            JS = "new Array(\"请选择-\"),"+JS;
            if(JS.length() > 0)
            {
            	JS = "var city = new Array("+JS+");"; 
            }
            return JS;   
    }
    private static String JSData(String[][] City,int CityLen,int c_city,int c_city_cnm,int c_dpt_cde,int c_province, String ProvinceCde)
    {
            String Ret = "";
            String Quto = "\"";
            String DeptCde = "";
            for(int i = 1; i< CityLen; i++)
            {
            	if(City[i][c_province].equals(ProvinceCde))
            	{
            		if(Ret.length() > 0)
            		    Ret = Ret + ",";
            		if(c_dpt_cde != -1)    
            		   DeptCde = "&" +  City[i][c_dpt_cde]; 
            		Ret = Ret+Quto+City[i][c_city_cnm]+"-"+City[i][c_city]+DeptCde+Quto;
            	}
            }
            if (Ret == null || Ret.trim().length() ==0){
				Ret = Quto+"请选择-"+Quto;
			}else{
				Ret = Quto+"请选择-"+Quto+","+Ret;
			}
            if(Ret.length() == 0)
            {
                Ret = Quto+"其他-00&00"+Quto;
            }

            Ret = "new Array("+Ret+")";

             return Ret;
 
    }
////////////////////////////////////////////////
//end make jscript:city according province
//////////////////////////////////////////////////

////////////////////////////////////////////////////////////////////////////////
//Begin : JSListMake()
//Parameter:String Data[][] is the data of list
//String Col[] is the colume to be in jscpit
//int BegRow,int EndRow is the range of data to be jscript
//for all list page javascipt make
////////////////////////////////////////////////////////////////////////////////
//var ListData = new Array("001","002");
//var ListData = new Array("001&102&201","002&105&208");
//////////////////////////////////////////////////////////////////////////////////////////

    public static String JSMakeOfList(String[][] Data,String[] Col,int BegRow,int EndRow)
    {
    	String JsReturn = "";
    	String JsTemp = "";
        String Quto = "\"";
                	
    	if(Data == null || Col == null)
    	   return JsReturn;
    	if(Data.length < 1 || Col.length < 1)
    	   return JsReturn;
    	
    	for(int i = BegRow ;i< EndRow;i++ ) 
    	{
    	      if(JsReturn.length() > 0)
            	   JsReturn = JsReturn + ",";
            
              JsTemp = "";	   
              for(int j = 0;j < Col.length; j++)
              {
                  if(JsTemp.length() > 0)
                      JsTemp = JsTemp + "&";
              	  JsTemp = JsTemp + Data[i][Objects.getColNum(Col[j],Data)];
              }
              JsTemp = Quto + JsTemp + Quto;
              
              JsReturn = JsReturn + JsTemp;
    	}   
    	
    	if(JsReturn.length() > 0)
    	   JsReturn = "var ListData = new Array(" + JsReturn + ");";
     	return JsReturn;   
    }

//////////////////////////////////////////////////////////////////
//end JSListMake()
//////////////////////////////////////////////////////////////////



////////////////////////////////
//calling function example
/////////////////////////////////    
 public static void main(String[] args)
 {
//test array
 	String ss[]={"a","b","c","d"};
 	String sss[][]={{"a","1"},{"b","2"}}; 	
 	setArraOne(ss);
 	for(int i =0;i<ss.length;i++)
 	{
 	}

 	setArraTwo(sss);
//test array end
        int Df = 0 - 30;
        String Sdate = ServTool.getSysDate(Df);
 }
 
}
    