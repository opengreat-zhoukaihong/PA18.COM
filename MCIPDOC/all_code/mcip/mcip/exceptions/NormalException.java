package exceptions;

////////////////////////
// Function:for normal exception
// Create date:2000-08-1
// Author£ºZhangJinQuan
// Address:Shenzhen China
//////////////////////////
import java.lang.*;
import java.io.*;

public class NormalException extends RuntimeException
{
     public String errCode;
     public String errDesc;
     public String errModu;
     public String errLevl;

     public NormalException(String Msg)
     {
       super(Msg);
       this.errDesc = Msg;       
     }
     public NormalException()
     {
        super();
     }
     public NormalException(String Code ,String Msg)
     {
       super(Msg);
       this.errCode = Code;       
       this.errDesc = Msg;
     }

     public NormalException(String errCode,String errDesc,
                         String errModu,String errLevl)
     {
        super(errDesc);     	
	    this.errCode = errCode;
	    this.errDesc = errDesc;
	    this.errModu = errModu;
	    this.errLevl = errLevl;

	//	System.out.println("errCode:"+errCode+",errDesc:"+errDesc+",errModu:"+errModu+",errLevl:"+errLevl);
     }
     public String getErrCode()
     {
     	 return this.errCode;
     }
     public String getErrDesc()
     {
     	 return this.errDesc;
     }
     public String getErrModu()
     {
     	 return this.errModu;
     }
     public String getErrLevl()
     {
     	 return this.errLevl;
     }

}

