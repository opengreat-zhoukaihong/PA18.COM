package exceptions;
/////////////////////////////////////////////
// Function:for normal exceptionhandler
// Create date:2000-08-18
// Author£ºZhangJinQuan
// Address:Shenzhen China
/////////////////////////////////////////////
import com.mcip.orb.*;
import java.lang.*;
import java.io.*;

public  class NormalExceptionHandler 
{

	  public static NormalException Handle(Throwable ex) 
	  {
             NormalException NorEx;	
	    CoException CoEx;
	    Exception Exc;
	    NumberFormatException NumEx;
	    NullPointerException  NPEx;
	    FileNotFoundException FNFEx;
	    IOException IOEx;
	    IndexOutOfBoundsException IndexEx;
	    if (ex instanceof NormalException)
	     {
	       NorEx = (NormalException) ex;
	     }
	    else if (ex instanceof CoException)
	    {
	       CoEx = (CoException) ex;
	       NorEx = new NormalException(CoEx.errCode,CoEx.errDescription,CoEx.errFieldName,
	         CoEx.severity);
	    }
	    else if (ex instanceof NumberFormatException)
	    {
	       NumEx = (NumberFormatException) ex;
	       NorEx = new NormalException("","Dataformat err:"+NumEx.getMessage(),"","");    }
	    else if (ex instanceof NullPointerException)
	    {
	       NPEx = (NullPointerException) ex;
	       NorEx = new NormalException("",NPEx.getMessage(),"","");    }
	    else if (ex instanceof FileNotFoundException)
	    {
	       FNFEx = (FileNotFoundException) ex;
	       NorEx = new NormalException("",FNFEx.getMessage(),"","");    }
	    else if (ex instanceof IOException)
	    {
	       IOEx = (IOException) ex;
	       NorEx = new NormalException("",IOEx.getMessage(),"","");    }
	    else if (ex instanceof IndexOutOfBoundsException)
	    {
	       IndexEx = (IndexOutOfBoundsException) ex;
	       NorEx = new NormalException("",IndexEx.getMessage(),"","");    }
	    else 
	    {
	    	Exc = (Exception) ex;
	       NorEx = new NormalException("",Exc.getMessage(),"","");
	    }
	
	    return NorEx;
	  }
	  
	  public static NormalException Handle(String Code) 
	  {
	      NormalException NorEx;
	      NorEx = new NormalException(Code,MessageReader.getMessage(Code),"","99");
	      return NorEx;
	  }  
	  public static NormalException Handle(String Code,String Msg) 
	  {
              NormalException NorEx;	  	
	      NorEx = new NormalException(Code,Msg);
	      return NorEx;
	  }  

	  public static NormalException Handle(String Code,String Msg,String Modu,String Levl) 
	  {
              NormalException NorEx;	  	
	      NorEx = new NormalException(Code,Msg,Modu,Levl);
	      return NorEx;
	  }  
	  
	  public static boolean IsSevere(NormalException e)
	  {
	  	return ExceptionLvl(e,"9");   	  
	  }

	  public static boolean IsWarning(NormalException e)
	  {
	  	return ExceptionLvl(e,"3");   
	  }
	  
	  private static boolean ExceptionLvl(NormalException e,String Lvl)
	  {
	  	String Temp = e.getErrLevl();
	  	if(Temp == null)
	  	   return false;
	  	if(Temp.indexOf(Lvl) == 0)
	  	    return true;
	  	 return false;   
	  	
	  }
}

