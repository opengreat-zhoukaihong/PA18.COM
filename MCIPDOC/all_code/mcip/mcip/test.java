import java.io.*;
import beans.*;
import constant.*;
public class test {
  public static void main(String args[]) throws Exception{
		CustManagerBean cb = new CustManagerBean();
		String FormPara[] = new String[2];
		String Result[][] = null;
		FormPara[0] = args[0];
		FormPara[1] = args[1];
		try
        {
       System.out.println("Start Login YYYYYYY");
        cb.setFormPara(Const.CUSTOMER_LOGIN,FormPara);
        Result = cb.getRetValueArra();
        if(Result==null)
			System.out.println("Login failed");
		else
            System.out.println("CORBA LOGIN OK:"+Result);
    }
    catch(Exception e)
    {
         System.out.println(e);
    }catch(Throwable eb){
      eb.printStackTrace();
    }
  }
}