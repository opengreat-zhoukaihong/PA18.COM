////////////////////////////////////////////////////////
// Author:     ZhanYB
// Function:   Common Routine
// Used Class:
// Update Date:2000/7/20
////////////////////////////////////////////////////////

package utility;


import exceptions.*;
import constant.*;
import java.text.*;
import java.lang.reflect.*;
import java.util.*;

public class DataUtility {

    private static DataUtility instance = null;
    private CoExceptionHandler exHandler;

    private static synchronized void createInstance() {
        if (instance == null) {
            instance = new DataUtility();
        }
    }

    public static DataUtility instance() {
        if (instance == null) {
            createInstance();
        }
        return instance;
    }

    private DataUtility() {
      exHandler = new CoExceptionHandler();
    }

////////////////////////////////////////////////////////
// Connect sql "and" parm after "where"               //
////////////////////////////////////////////////////////
    public static String SqlContact(String[][] SqlParameters){
        if ((SqlParameters==null) || (SqlParameters.length==0)){
            return "";
        }
        if ((SqlParameters[0][0]==null) || (SqlParameters[0][1]==null)){
            return "";
        }

        String temp=" WHERE ";
        for (int i=0;i<SqlParameters.length;i++){
           if (i!=0) temp+=" AND ";
           temp+=SqlParameters[i][0]+"='"+SqlParameters[i][1]+"'";
        }
        return temp;
    }

/////////////////////////////////////////////////////////
//  Convert String to javadate                         //
/////////////////////////////////////////////////////////
    public java.util.Date stringToDate(String strValue, String dateFormat)
           throws com.mcip.orb.CoException{
        if ((strValue == null) || (strValue.equals(""))) {
            return null;
        }

        java.util.Date theDate = null;

        if ((!dateFormat.equalsIgnoreCase(Constant.LONG_DATE_FORMAT)) &
           (!dateFormat.equalsIgnoreCase(Constant.SHORT_DATE_FORMAT))){
           this.exHandler.raiseCoException(ExceptionCode.DU_INVALIDDATEFMT);
        }

        try{
System.out.println("Debug:strValue:"+strValue);
System.out.println("Debug:dateFormat:"+dateFormat);
            SimpleDateFormat formatter = new SimpleDateFormat(dateFormat);
System.out.println("format completed:");
            theDate = formatter.parse(strValue);
System.out.println("date completed:");
            formatter = null;
        }catch(Exception e) {
            exHandler.handle(e, this.getClass().getName(), "stringToDate");
        }

        return theDate;

    }
////////////////////////////////////////////////////////
//  Convert String to sqldate
////////////////////////////////////////////////////////
    public java.sql.Date stringToSQLDate( String strValue, String dateFormat )
           throws com.mcip.orb.CoException{
        if ((strValue == null) || (strValue.equals(""))) {
            return null;
        }

        java.util.Date tempDate = stringToDate(strValue, dateFormat);
        return new java.sql.Date(tempDate.getTime());
    }

    public java.sql.Time stringToSQLTime( String strValue, String dateFormat )
           throws com.mcip.orb.CoException{
        if ((strValue == null) || (strValue.equals(""))) {
            return null;
        }

        java.util.Date tempDate = stringToDate(strValue, dateFormat);
        return new java.sql.Time(tempDate.getTime());
    }

    public java.sql.Timestamp stringToSQLTimestamp( String strValue, String dateFormat )
           throws com.mcip.orb.CoException{
        if ((strValue == null) || (strValue.equals(""))) {
            return null;
        }

        java.util.Date tempDate = stringToDate(strValue, dateFormat);
        return new java.sql.Timestamp(tempDate.getTime());
    }

////////////////////////////////////////////////////////
//  Convert String to bigdecimal
////////////////////////////////////////////////////////
    public java.math.BigDecimal stringToBigDecimal( String strValue ){
    	if ((strValue == null) || (strValue.equals(""))) {
            return null;
        }

        return new java.math.BigDecimal(Double.valueOf(strValue).doubleValue());

    }

////////////////////////////////////////////////////////
//  Convert String to bigdecimal
////////////////////////////////////////////////////////
    public static java.util.Date GetCurrentTS(){
        return java.util.Calendar.getInstance().getTime();
    }

    public static String GetCurrentTS(String dateFormat){
        SimpleDateFormat df = new SimpleDateFormat(dateFormat);
        return df.format(java.util.Calendar.getInstance().getTime());
    }

////////////////////////////////////////////////////////
//  Object to String Array
////////////////////////////////////////////////////////
    public static String[][] ObjToStringArray ( Object tempobj ) throws Exception{
        String fieldName=null;
        String fieldValue=null;
        Class tempClass=tempobj.getClass();
        Field[] tempfield=tempClass.getFields();
        int templen=tempfield.length;
        String[][] result= new String[2][templen];
        try{
            for (int i=0;i<templen;i++){
                fieldName = tempfield[i].getName();
                fieldValue=(tempClass.getField(fieldName).get(tempobj)).toString();
                result[0][i]=fieldName;
                result[1][i]=fieldValue;
            }
        }catch (Exception e){
            throw e;
        }
        return result;
    }


////////////////////////////////////////////////////////
//  Display Array
////////////////////////////////////////////////////////

   public static void dispArray (String[][] array){
  	     String[][] a=array;
  	     int tbr=a.length;

 	     System.out.println("The Return table have: "+tbr+" Rows!");
	      for (int j=0;j <tbr;j++){
	          String[] tablecolumn = a[j];
	          int tbc=tablecolumn.length;
	          for (int i=0;i<tbc;i++){
		             String str=tablecolumn[i];
        		     System.out.print(str+"\t");
	         }
	         System.out.print("\n");
	     }

   }

   public static void dispArray (Object[] array){
  	     Object[] a=array;
  	     int tbr=a.length;

 	     System.out.println("The Return table have: "+tbr+" Rows!");
	      for (int j=0;j <tbr;j++){
           System.out.println (""+j+":"+a[j].toString ());
	     }

   }

   public static void dispVector (Vector v){
     for (Enumeration e = v.elements() ; e.hasMoreElements() ;) {
         System.out.println(e.nextElement());
     }
   }

   public static void DisplayFields(Object obj){

        Class c =obj.getClass();
        Field[] publicFields =c.getFields();
        String fieldName =null;

        System.out.println("---Class Name:"+c.toString ());
        for (int i = 0; i < publicFields.length; i++) {
            try{
                fieldName = publicFields[i].getName();
                String fieldValue=(c.getField(fieldName).get(obj)).toString();
                System.out.print(i+":"+fieldName+":\t"+fieldValue+"\n");
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }


   public static void dispVectorDtl (Vector v){
     for (int i=0;i<v.size ();i++){
         System.out.print("---Element :"+i);
         DisplayFields(v.elementAt (i));
     };


   }

////////////////////////////////////////////////////////
// compare two object
////////////////////////////////////////////////////////

    private static boolean searchfield(String s, Object obj){
        boolean result=false;
        Object temp=obj;
        Class cl=temp.getClass();
        Field[] tmpfld=cl.getFields();
        int templen=tmpfld.length;
        for (int i=0;i<templen;i++){
            try{
                String fieldname = tmpfld[i].getName();
                if (fieldname.equals(s))
                    result=true;
            }catch(Exception e){
                 System.out.println ("Exception in:"+"findfield"+e.toString ());
            }
        }
        return result;
    }



    public static void compareobj (Object obj1, Object obj2){
        Vector  vctr1=null;
        Vector  vctr2=null;
        Class cl=obj1.getClass();
        Field[] tmpfld1=cl.getFields();
        int templen1=tmpfld1.length;

        for (int i=0;i<templen1;i++){
            String fieldname = tmpfld1[i].getName();
            if (searchfield(fieldname, obj2))
               vctr1.addElement(fieldname);
            else
               vctr2.addElement(fieldname);
        }
        System.out.println("-----------find field-------------");
        dispVector (vctr1);
        System.out.println("-----------unfind field-------------");
        dispVector (vctr2);

   }


////////////////////////////////////////////////////////
// Debug Code
////////////////////////////////////////////////////////

////////////////////////////////////////////////////////
// Debug Code
////////////////////////////////////////////////////////

    public static void main(String[] args){
        try{
//           compareobj(new com.mcip.nia.orb.PlcyEdrInfo(),new jtoc.plyEdrappcrgoStru());
        }catch(Exception e){
            e.printStackTrace();
        }
   }


/*
   public static void main (String [] args){
    try{
       System.out.println("wrong");
       Date a=DataUtility.instance().stringToDate("1999-01-01",Constant.SHORT_DATE_FORMAT);
       java.sql.Date c=DataUtility.instance().stringToSQLDate("1999-01-01",Constant.SHORT_DATE_FORMAT);
       String b=a.toString ();
       System.out.println("right");
    }catch(Exception e){
       e.printStackTrace ();
    }
   }
*/
}
