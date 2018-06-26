////////////////////////////////////////////////////////
// Author：ZhangJinQuan
// function：check valid of field value
// Create date：2000/08/07
// Update date：2000/08/07
////////////////////////////////////////////////////////


package utility;

import java.lang.*;
import java.lang.Integer;
import java.util.*;
import java.text.*;
import exceptions.*;

public class FieldCheck
{

     static final String NOTNULLERR = "带*号的域不能为空!";
     static final String NUMOUTRANGEERR = "数字数据超出范围!";
     static final String NUMFORMATERR = "数字数据格式错误!";
     static final String STRLENERR = "字符串长度不合规定!";
     static final String MUSTNUMSTRERR = "输入域必须是数字字符串!";
     static final String NUMSTRZEROERR = "不可输入0!";
     static final String PSWDNOTSAMEERR = "两次输入的密码必须相同";
     static final String EMAILERR = "E_mail地址输入错误";
            
    public FieldCheck()
    {
    	super();
    }
    
    //check is null
    public static void CheckNull(String SValue[]) throws NormalException
    {
//        if ((SValue == null) || (SValue.trim().length() == 0))
          if (SValue == null)
             throw new NormalException(NOTNULLERR);
             
          for(int i = 0; i < SValue.length; i++)   
          {
          	if ((SValue[i] == null) || (SValue[i].trim().length() == 0))
          	{
                     throw new NormalException(NOTNULLERR);          		
          	}    
          }
 
        return;
        
    }    
    
    public static void CheckPswdSame(String Pswd1,String Pswd2) throws NormalException
    {
    	if ((Pswd1 == null) || (Pswd2 == null))
    	    return;
    	    
    	if (!(Pswd1.equals(Pswd2)))
             throw new NormalException(PSWDNOTSAMEERR);    	       

        return;     
    }
    
    //check is number format string
    public static void CheckIsNumStr(String SValue) throws NormalException
    {
        if ((SValue == null) || (SValue.trim().length() == 0))
             return;
  
        NumberFormat nf = NumberFormat.getNumberInstance();

        try
        {
            nf.parse(SValue);
        }
        catch(ParseException e)
        {
             throw new NormalException(MUSTNUMSTRERR);    	       
        }

        return;
    }

    //check email address valid
    public static void CheckEmail(String SValue) throws NormalException
    {
        if ((SValue == null) || (SValue.trim().length() == 0))
             return;
        String Temp = SValue.trim();     
    	if ((Temp.indexOf("@") < 1) || (Temp.indexOf(".") < 1))
             throw new NormalException(EMAILERR);    	       

        return;    	   
    }
    
}

