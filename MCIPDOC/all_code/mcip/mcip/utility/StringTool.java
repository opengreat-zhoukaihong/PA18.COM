package utility;
import java.math.*;
import java.text.*;
import java.util.*;
/**
*@author Lawrence
*@version 1.0
*/
public class  StringTool
{
	/**
	*将null字符串转换成空串.
	*如果该字符串不为null则返回该字符串的值
	*/
	public static String null2Blank(String para)
	{
		if (para == null)
			para = "";
		return para;
	}
	public static String getDateString(String dateStringSource,String type){
		if (dateStringSource == null || type == null)
			return "";
		if (type.equals("ENG")){
			try{
				SimpleDateFormat formatter = new SimpleDateFormat ("yyyy-MM-dd",Locale.US);
				Date sourceDate = formatter.parse(dateStringSource,new ParsePosition(0));
				formatter.applyPattern("MMM. dd,yyyy");
				return formatter.format(sourceDate,new StringBuffer(),new FieldPosition(0)).toString();
			}catch(Exception e){
				return "";
			}
		}else{
			try{
				SimpleDateFormat formatter = new SimpleDateFormat ("yyyy-MM-dd");
				Date sourceDate = formatter.parse(dateStringSource,new ParsePosition(0));
				formatter.applyPattern("yyyy年M月dd日");
				return formatter.format(sourceDate,new StringBuffer(),new FieldPosition(0)).toString();
			}catch(Exception e){
				return "";
			}
		}
	}

		public static String getDateString(Date dateStringSource,String type){
		if (dateStringSource == null || type == null)
			return "";
		if (type.equals("ENG")){
			try{
				SimpleDateFormat formatter = new SimpleDateFormat ("yyyy-MM-dd",Locale.US);
				Date sourceDate = dateStringSource;
				formatter.applyPattern("MMM. dd,yyyy");
				return formatter.format(sourceDate,new StringBuffer(),new FieldPosition(0)).toString();
			}catch(Exception e){
				return "";
			}
		}else{
			try{
				SimpleDateFormat formatter = new SimpleDateFormat ("yyyy-MM-dd");
				Date sourceDate = dateStringSource;
				formatter.applyPattern("yyyy年M月dd日");
				return formatter.format(sourceDate,new StringBuffer(),new FieldPosition(0)).toString();
			}catch(Exception e){
				return "";
			}
		}
	}

	private static String replace(String srcStr ,String str1,String str2)
	{
		StringBuffer srcBuff = new StringBuffer(srcStr);
		int index =0;
		String
			tempStr = "";
		index = srcStr.indexOf(str1,index);
		while (index != -1)
		{
			tempStr = tempStr+srcStr.substring(0,index)+str2;
			srcStr = srcStr.substring(index+str1.length());
			index = srcStr.indexOf(str1);
		}
		tempStr += srcStr;
		return tempStr;
	}
	/**
	*将para字符串中的特殊字符转换成html编码.
	* & to &amp;
	* " to &quot;
	* < to &lt;
	* > to &gt;
	*/
	public static String htmlEncode(String para) throws NullPointerException
	{
		if ( para == null)
			throw new NullPointerException();
		else
		{
			para = replace(para,"&","&amp;");
			para = replace(para,"\"","&quot;");
			para = replace(para,"<","&lt;");
			para = replace(para,">","&gt;");
			}
		return para;
	}


	/**
	*将para字符串中的html编码转换成特殊字符
	* &amp; to &
	* &quot; to "
	* &lt; to <
	* &gt; to >
	*/
	public static String htmlDecode(String para) throws NullPointerException
	{
		if ( para == null)
			throw new NullPointerException();
		else
		{
			para = replace(para,"&amp;","&");
			para = replace(para,"&quot;","\"");
			para = replace(para,"&lt;","<");
			para = replace(para,"&gt;",">");
			}
		return para;
	}

	/**
	*将para字符串中的特殊字符转换成mailto参数编码.
	* & to and;
	* " to &quot;
	* < to &lt;
	* > to &gt;
	*/
	public static String mailtoEncode(String para) throws NullPointerException
	{
		if ( para == null)
			throw new NullPointerException();
		else
		{
			para = replace(para,"&"," and ");
			para = replace(para,"\"","&quot;");
			para = replace(para,"<","&lt;");
			para = replace(para,">","&gt;");
			}
		return para;
	}
	/**
	*chang the float into fixed decimal
	*/
	public static String fix(float i)
	{
		try{
			Float numFloat = new Float(i);
			BigDecimal decimal =  new BigDecimal(numFloat.toString());
			return decimal.setScale(2,decimal.ROUND_HALF_UP).toString();
		}catch (Exception e){
			return "";
		}
	}

	public static String fix(String string)
	{
		try{
			double doubleValue = Double.parseDouble(string);
			BigDecimal decimal =  new BigDecimal(doubleValue);
			return decimal.setScale(2,decimal.ROUND_HALF_UP).toString();
		}catch(Exception e){
			return "";
		}
	}

	public static String fixedComma(String string){
		try{
			String numString = fix(string);
			StringBuffer strBuf = new StringBuffer();
			java.text.FieldPosition fp = new java.text.FieldPosition(0);
			java.text.DecimalFormat thisFormat = new java.text.DecimalFormat("###,###,###,###,###,###,###,###,###,###.00");
			return thisFormat.format(Double.parseDouble(numString),strBuf,fp).toString();
		}catch(Exception e){
			return "";
		}
	}

	/** map currency code to symble,name in Chinese
	 *  CAUTION:Just can be used in USD,HKD&RMD.If applied this method on other currency Code
	 *          blank infomation will be returned.*/
	public static String[] getCurrInfo(String code){
		String [] currInfo = new String[2];
		// handle RMB
		if (code.equals("01")){
			currInfo[0] = "RMB";
			currInfo[1] = "人民币";
		}
		//handle HKD
		if (code.equals("02")){
			currInfo[0] = "HKD";
			currInfo[1] = "港币";
		}
		//handle USD
		if (code.equals("03")){
			currInfo[0] = "USD";
			currInfo[1] = "美元";
		}
		return currInfo;
	}
	/** Change the new line symble in a string to the "<br>" so that can display in the html*/
	public static String nl2br(String source){
		String destString = replace(source,"\r","<br>");
		return destString;
	}

	/**@author :Lawrence
	*   Create Date :2001-10-31
	*  the static method getDateStampStr provide the string contains the running time infomation
	* this method is usually used in debug output.
	*/
	public static String getDateStampStr(){
		Date thisDate = new Date();
		return thisDate.toString()+"["+thisDate.getTime()+"]";
	}

	/**@author :Lawrence
	*	Create Date:2001-10-31
	*  this static method errorDetail print the exception detailed info to the standard output device
	*  this method is usually used to output the error for debuging
	*/
	public static void errorDetail(Exception e){
		Date tempDate = new Date();
		if (e == null)
			return;
		System.out.println("*************************错误详细信息*************************");
		System.out.println(">时间:"+tempDate.toString()+"["+tempDate.getTime()+"]");
		System.out.println(">错误信息:"+e.toString());
		System.out.println(">路径:");
		e.printStackTrace();
	}
	public static void main(String[] args)
	{
		System.out.println(fixedComma(args[0]));
}
}
