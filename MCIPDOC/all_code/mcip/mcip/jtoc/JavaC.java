////////////////////////////////////////////////////////
// Function:    The interface of java and c module
// Author:      ZhanYB
// Create Date: 2000/8/24
// Called by:   Implement part of Corba Server
// Call:        OCI Pro* C in DB server through C interface
////////////////////////////////////////////////////////
// Change Log
//     By who: Date       Content
//     Zhanyb: 2000/08/29 Add Interface 3
//     Zhanyb: 2000/08/30 Add confirm apppoly processing
//     Zhanyb: 2000/09/01 Chg ireserveid =1 in confirm poly app
//     Zhanyb: 2000/09/05 Chg c_udr_mrk="7"
//     Zhanyb: 2000/09/07 Add rdr input="" processing for accept policy
//     Zhanyb: 2000/09/07 Add upd_tm processing for update prsn and orgn cust
//     Zhanyb: 2000/09/08 Change getrefobj for withdraw policy processing
//     Zhanyb: 2000/09/12 Add accept case report processing
//     Zhanyb: 2000/09/30 Chg c_udr_mrk="1"  in confirm processing
//     Zhanyb: 2000/10/09 Chg c_udr_mrk="7"  in confirm processing
//     Zhanyb: 2000/10/25 Add new user case 22125;22120
//     Zhanyb: 2000/10/26 Update user case 22125;22120
//     Zhanyb: 2000/11/02 Add debug flag
//     Zhanyb: 2000/11/03 Change the interface of policy and endorcement related user case
//     Zhanyb: 2000/11/06 Add comment for javadoc
//     Zhanyb: 2000/11/07 chg array index in init method
//     Zhanyb: 2000/11/15 Add new user case 22128
//     Zhanyb: 2000/11/16 Add new user case confirm edr sub flow for 22120
//     Zhanyb: 2000/11/16 Add new user case 22123
//     Zhanyb: 2000/11/17 Add null rdr processing for get endorsement usercase
//     YiJF:   2000/12/27 Add new user case 22105
////////////////////////////////////////////////////////
// Change for Debug in local side
//     1.Add return code processing
//     2.outbytes=inbytes
//     3.Add comment on LoadLibrary statement
////////////////////////////////////////////////////////
// JNI Brief
//     1.Create Java code with native methods (see Listing 1).
//         public static native int setuid(int uid);
//         static {
//             System.loadLibrary("uid");
//         }
//     2.Compile Java code with javac (i.e., javac UID.Java).
//     3.Generate header file with javah (i.e., javah-jni micah.util.UID; see Listing 2).
//         javah -jni micah.util.UID
//     4.Create native C module to implement the methods declared in the Java code (see Listings 3, 4).
//         #include <jni.h>
//         #include "micah_util_UID.h"
//     5.Compile the native code.
//       under UNIX (Linux, in this case):
//         gcc \
//         -I/usr/local/java/include \
//         -I/usr/local/java/include/genunix \
//         -shared unix_uid.c -o libuid.so
//       under Windows NT:
//         cl -Ie:\jdk1.1.8\include -Ie:\jdk1.1.8\include\win32
//         -LD win_uid.c -Feuid.dll
//     6.Create a test Java app.
////////////////////////////////////////////////////////
// Here is the Description of how to use this class:
//
// if only one input obj and one output obj<br>
//       JavaC jc=new JavaC(ph,inputobj);
//       jc.init();
//       jc.JavaCMain();
//       jc.DisplayFields(jc.returnobj);
//
// if more than one input obj<br>
//       jc.JavaCMain(jc.GetInvctor());
//
// if input object include pkBodyInfoObj<br>
//       jc.init("0");
//
// if more than one output obj<br>
//       for(int i=0;i<GetReturnvctor().size ();i++){
//          System.out.println("Object:"+i+"  "+this.GetObjClass(GetReturnvctor().elementAt(i)).toString ());
//          DisplayFields(GetReturnvctor().elementAt(i));
//       }
//
// if accept or update policy user case<br>
//       String[][] rdr = {{"",""}};
//       PacketHead ph = new PacketHead(JCConstant.ACCEPTPOLICYAPP_PACKET_ID);
//       JavaC jc=new JavaC(ph,JavaC.initobj_nia(),rdr);
//       jc.init(rdr.length);
//       jc.JavaCMain(jc.GetInvctor());
// if confirm edr
//       call SetConfirmEdr();
////////////////////////////////////////////////////////
package jtoc;

import utility.*;
import java.util.Vector;
import java.lang.reflect.*;
import exceptions.*;
import constant.*;


/**
 * JavaC is the the interface between java and c module
 * which allow an java application call native c program
 * it included following common routine
 * <ul>
 * <li>   public static native byte[] packetchanege(byte[] instr,int strlen);
 * <li>   private void ErrorHandling(String ExceptionCode)
 * <li>   private void ErrorHandling(String ExceptionCode,String ExceptionDesc)
 * <li>   public Class GetReturnClass()throws com.mcip.orb.CoException
 * <li>   public Object GetReturnObj()throws com.mcip.orb.CoException
 * <li>   public Vector GetReturnvctor()throws com.mcip.orb.CoException
 * <li>   public Vector GetInvctor()throws com.mcip.orb.CoException
 * <li>   public Class GetObjClass(Object obj)throws com.mcip.orb.CoException
 * <li>   public Field[] GetObjProperties(Object obj)throws com.mcip.orb.CoException   {
 * <li>   public int GetObjLen(Object obj)throws com.mcip.orb.CoException
 * </ul>
 * <p>
 * <HR>
 * Some important thing must be mentioned,if you want to add a new user case for this.
 * How to add a new case<br>
 *     1.Add package header constant in JCConstant.java<br>
 *     2.Add package header constructor in PacketHead.java<br>
 *     3.Add object  processing in method "SetRefobj_Mapto_inobj"<br>
 *     4.Add object  processing in method "CreateReferOject"<br>
 *     5.Add object  processing in method "CreateReturnOject" if return single obj<br>
 *     6.Add processing in JavaCMain if return multi obj<br>
 * <p>
 * <HR>
 * <p>
 * <HR>
 * @author 	  Jeb Zhan
 * @version 	%I%, %G%
 * @since     JDK1.3
 * <HR>
 */

public class JavaC {

////////////////////////////////////////////////////////
// Packet Header
////////////////////////////////////////////////////////

    private PacketHead inpkthead=null;  //packet head object
    private PacketHead outpkthead=null; //packet head object
    private Class pkclass=null;         //class name of input object
    private Field[] pkfield=null;       //all properties name of input object
    private int pklen=0;                //the length of input object

////////////////////////////////////////////////////////
// Input Sturcture
////////////////////////////////////////////////////////

    private Object  inobj=null;         //input object
    private Class   inclass=null;       //class name of input object
    private Field[] infield=null;       //all properties name of input object
    private int     inobjlen=0;         //the length of input object

////////////////////////////////////////////////////////
// Refer Sturcture
////////////////////////////////////////////////////////

    private Object  referobj=null;      //reference object of input object (part of input object)
    private Class   referclass=null;    //class name of refer object

////////////////////////////////////////////////////////
// Output Sturcture
////////////////////////////////////////////////////////

    private Vector  returnvctor=null;   //return object of calling result

    private Object  returnobj=null;     //return object of calling result
    private Class   returnclass=null;   //class name of return object
    private Field[] returnfield=null;   //all properties name of return object
    private int     returnobjlen=0;     //the length of return object

    private String[][]  returnrdr=null; //Only used for get endorsement docu user case

////////////////////////////////////////////////////////
// Common properties
////////////////////////////////////////////////////////

    private CoExceptionHandler exHandler;
    private com.mcip.nia.orb.PlcyAppInfo inplcyAppInfoobj=new com.mcip.nia.orb.PlcyAppInfo();
    private String[][] inrdr;             //policy Rdr additional risk list
    private String in_packetid="";        //the unique identifier of case in java call c interface
    private Vector in_vctor=null;         //return object of calling result
    private boolean netobjexist=true;         //return object of calling result
    private boolean confirmedr=false;         //return object of calling result
////////////////////////////////////////////////////////
// JNI Declare
////////////////////////////////////////////////////////

    static {
        System.loadLibrary("JavaC");
    }

    public static native byte[] packetchanege(byte[] instr,int strlen);

////////////////////////////////////////////////////////
// Error Handling for CORBA server side exception
////////////////////////////////////////////////////////

  /**
   * Error Handling for CORBA server side exception
   * @param  String ExceptionCode(the code of exception)
   * @return                 void
   * @exception              com.mcip.orb.CoException
   */

   private void ErrorHandling(String ExceptionCode)
           throws com.mcip.orb.CoException   {
        this.exHandler.raiseCoException(ExceptionCode,null,"JavaC");
   }

  /**
   * Error Handling for CORBA server side exception
   * @param  String ExceptionCode(the code of exception)
   * @param  String ExceptionDesc(the additional description of exception)
   * @return                 void
   * @exception              com.mcip.orb.CoException
   */

   private void ErrorHandling(String ExceptionCode,String ExceptionDesc)
           throws com.mcip.orb.CoException   {
        this.exHandler.raiseCoException(ExceptionCode,ExceptionDesc,"JavaC");
   }

////////////////////////////////////////////////////////
// Get Method
////////////////////////////////////////////////////////
  /**
   * Get the class name of return object
   * @return                 Class
   * @exception              com.mcip.orb.CoException
   */
   public Class GetReturnClass()throws com.mcip.orb.CoException   {
        return returnclass;
   }

  /**
   * Get the return object
   * @return                 Object
   * @exception              com.mcip.orb.CoException
   */

   public Object GetReturnObj()throws com.mcip.orb.CoException   {
        return returnobj;
   }

  /**
   * Get the return vector
   * @return                 Vector
   * @exception              com.mcip.orb.CoException
   */
   public Vector GetReturnvctor()throws com.mcip.orb.CoException   {
        return returnvctor;
   }

  /**
   * Get the return rdr for get endorsement user cese
   * @return                 String[][]
   * @exception              com.mcip.orb.CoException
   */
   public String[][] GetReturnRdr()throws com.mcip.orb.CoException   {
        return returnrdr;
   }

  /**
   * Get the input vector
   * @return                 Vector
   * @exception              com.mcip.orb.CoException
   */
   public Vector GetInvctor()throws com.mcip.orb.CoException   {
        return in_vctor;
   }

  /**
   * Get the class of input object
   * @param                  obj
   * @return                 Class
   * @exception              com.mcip.orb.CoException
   */
   public Class GetObjClass(Object obj)throws com.mcip.orb.CoException   {
        return obj.getClass ();
   }

  /**
   * Get the attributes of input object
   * @param                  obj
   * @return                 Field[]
   * @exception              com.mcip.orb.CoException
   */
   public Field[] GetObjProperties(Object obj)throws com.mcip.orb.CoException   {
        return obj.getClass ().getFields();
   }

  /**
   * Get the count of attributes of input object
   * @param                  obj
   * @return                 int
   * @exception              com.mcip.orb.CoException
   */
   public int GetObjLen(Object obj)throws com.mcip.orb.CoException   {
        return obj.getClass ().getFields().length;
   }


  /**
   * Get the flag of netobj used in add endorsement docu user case
   * @return                 boolean
   * @exception              com.mcip.orb.CoException
   */
   public boolean GetNetObjFlag()throws com.mcip.orb.CoException   {
        return netobjexist;
   }


  /**
   * Set the confirm flag true in confirm endorsement user case
   * @return                 void
   * @exception              com.mcip.orb.CoException
   */
   public void SetConfirmEdr() throws com.mcip.orb.CoException   {
        confirmedr=true;
   }



////////////////////////////////////////////////////////
// Constructor added here
////////////////////////////////////////////////////////
  /**
   * Constructor
   */
    public JavaC(){
        exHandler = new CoExceptionHandler();
    }


////////////////////////////////////////////////////////
// Constructor for common user case
////////////////////////////////////////////////////////
  /**
   * Constructor
   * @param                  ph   input packet header
   * @param                  obj  input object
   * @exception              com.mcip.orb.CoException
   */
    public JavaC(PacketHead ph,Object obj) throws com.mcip.orb.CoException {
        if ((obj==null) || (ph==null)){
           ErrorHandling(ExceptionCode.JC_ERROR_INPUT,"Head--"+ph.toString()+";Structure--"+obj.toString());
        }
        exHandler = new CoExceptionHandler();

//Added for debug
if (JCConstant.JTOC_DEBUGINFO){
    System.out.println("_____________Input Header____________________");
    this.DisplayFields (ph);
    System.out.println("_____________Input Object____________________");
    System.out.println(GetObjClass(obj).toString()+":"+GetObjLen(obj));
    //this.DisplayFields (obj);
    System.out.println("_____End of JavaC ___________________________________________");
}
//End debug

        try{
           inpkthead=ph;
           inobj=obj;
           in_packetid=inpkthead.iPacketID;
        }catch(Exception e){
           System.out.println ("Exception in:"+"JavaC(PacketHead ph,Object obj)");
           ErrorHandling(ExceptionCode.JC_COMMON_ERROR,e.toString ());
        }

    }

////////////////////////////////////////////////////////
// Constructor for Accept or update plcyappinfo
////////////////////////////////////////////////////////

  /**
   * Constructor
   * @param                  ph   input packet header
   * @param                  obj  input object for policy user case
   * @param                  String[][] rdr  input array for policy user case
   * @exception              com.mcip.orb.CoException
   */

    public JavaC(PacketHead ph,com.mcip.nia.orb.PlcyAppInfo obj,String[][] rdr) throws com.mcip.orb.CoException {
        this(ph,obj);
        try{
           inrdr=rdr;
           inplcyAppInfoobj=obj;
        }catch(Exception e){
           System.out.println ("Exception in:"+"JavaC(PacketHead ph,com.mcip.nia.orb.PlcyAppInfo obj,String[][] rdr)");
           ErrorHandling(ExceptionCode.JC_COMMON_ERROR,e.toString ());
        }
    }


////////////////////////////////////////////////////////
// Constructor for Add endorsement policy
////////////////////////////////////////////////////////

  /**
   * Constructor
   * @param  ph   input packet header
   * @param  PlyEdrAppInfoobj  input PlyEdrAppInfo object for add endoresment policy user case
   * @param  PlyEdrAppCrgoInfoobj  input PlyEdrAppCrgoInfo object for add endoresment policy user case
   * @param  rdr  input PlyEdrApprdrInfo array for add endoresment policy user case
   * @param  PlyEdrAppPayInfo  input PlyEdrAppPayInfo object for add endoresment policy user case
   * @param  PlyPlyAppNetInfo  input PlyPlyAppNetInfo object for add endoresment policy user case
   * @exception  com.mcip.orb.CoException
   */
    public JavaC(PacketHead ph,
            com.mcip.nia.orb.PlyEdrAppInfo PlyEdrAppInfoobj,
            com.mcip.nia.orb.PlyEdrAppCrgoInfo PlyEdrAppCrgoInfoobj,
            String[][] rdr,
            com.mcip.nia.orb.PlyEdrAppPayInfo PlyEdrAppPayInfoobj,
            com.mcip.nia.orb.PlyPlyAppNetInfo PlyPlyAppNetInfoobj)
            throws com.mcip.orb.CoException {
        if ((ph==null)||(PlyEdrAppInfoobj==null)||
            (PlyEdrAppCrgoInfoobj==null)||
            (PlyEdrAppPayInfoobj==null)||
            (PlyPlyAppNetInfoobj==null))
           ErrorHandling(ExceptionCode.JC_ERROR_INPUT,"Head--"+ph.toString()+
             ";PlyEdrAppInfoobj--"+PlyEdrAppInfoobj.toString()+
             ";PlyEdrAppCrgoInfoobj--"+PlyEdrAppCrgoInfoobj.toString()+
             ";PlyEdrAppPayInfoobj--"+PlyEdrAppPayInfoobj.toString()+
             ";PlyPlyAppNetInfoobj--"+PlyPlyAppNetInfoobj.toString());

        exHandler = new CoExceptionHandler();

//Added for debug
if (JCConstant.JTOC_DEBUGINFO){
    System.out.println("_____________Input Header____________________");
    this.DisplayFields (ph);
    System.out.println("_____________Input PlyEdrAppInfo Object____________________");
    System.out.println(GetObjClass(PlyEdrAppInfoobj).toString()+":"+GetObjLen(PlyEdrAppInfoobj));
    this.DisplayFields (PlyEdrAppInfoobj);
    System.out.println("_____________Input PlyEdrAppCrgoInfo Object____________________");
    System.out.println(GetObjClass(PlyEdrAppCrgoInfoobj).toString()+":"+GetObjLen(PlyEdrAppCrgoInfoobj));
    this.DisplayFields (PlyEdrAppCrgoInfoobj);

    System.out.println("_____________Input RdR____________________");
    System.out.println("RdrRdr:"+rdr.length);
    DataUtility.dispArray (rdr);

    System.out.println("_____________Input PlyEdrAppPayInfo Object____________________");
    System.out.println(GetObjClass(PlyEdrAppPayInfoobj).toString()+":"+GetObjLen(PlyEdrAppPayInfoobj));
    this.DisplayFields (PlyEdrAppPayInfoobj);
    System.out.println("_____________Input PlyPlyAppNetInfo Object____________________");
    System.out.println(GetObjClass(PlyPlyAppNetInfoobj).toString()+":"+GetObjLen(PlyPlyAppNetInfoobj));
    this.DisplayFields (PlyPlyAppNetInfoobj);
    System.out.println("________________________________________________");
}
//End debug

        try{
           inpkthead=ph;
           inrdr=rdr;
           in_packetid=inpkthead.iPacketID;
           inobj=PlyEdrAppInfoobj;
           referobj=new plyEdrGridStru("0");
           referclass =referobj.getClass();

           in_vctor=new Vector();
           in_vctor.addElement(PlyEdrAppInfoobj);
           in_vctor.addElement(PlyEdrAppCrgoInfoobj);
           in_vctor.addElement(PlyEdrAppPayInfoobj);
           in_vctor.addElement(PlyPlyAppNetInfoobj);

        }catch(Exception e){
           System.out.println ("Exception in:"+"JavaC method for Add endorsement policy user case");
        }

    }

////////////////////////////////////////////////////////
// init method for common user case
////////////////////////////////////////////////////////

  /**
   * Initialization method for common user case
   * @return                 void
   * @exception              com.mcip.orb.CoException
   * @exception              Exception
   */
    public void init() throws com.mcip.orb.CoException,Exception {
//Init package header parm
        pkclass=inpkthead.getClass();
        pkfield=pkclass.getFields();
        pklen=pkfield.length;
//Init input object parm
        inclass =inobj.getClass();
        infield =inclass.getFields();
        inobjlen=infield.length;
//Init refer object parm
        referobj=CreateReferOject();
        referclass =referobj.getClass();
//Assign coresponding value to referobj by inputobj

        SetRefobj_Mapto_inobj(in_packetid);
//Init return object parm

        returnobj= CreateReturnObj();

        returnclass =returnobj.getClass();
        returnfield =returnclass.getFields();
        returnobjlen=returnfield.length;
        ResetReturnObj();

        java.util.Vector vctor=new Vector(2);
        vctor.addElement(referobj);
        in_vctor=vctor;

    }



////////////////////////////////////////////////////////
// init method for user case which needed pkbodyinfostru
////////////////////////////////////////////////////////

  /**
   * Initialization method for user case which needed pkbodyinfostru
   * @param  str   no valuable mean,just for overload usage
   * @return                 void
   * @exception              com.mcip.orb.CoException
   * @exception              Exception
   */

    public void init(String str) throws com.mcip.orb.CoException,Exception {
        this.init();

        java.util.Vector vctor=new Vector(2);
//Add PktBodyInfoStru
        Object pkBodyInfoObj= new pkBodyInfoStru(0,"1");
        vctor.addElement(pkBodyInfoObj);
//Add input object
        vctor.addElement(referobj);
        in_vctor=vctor;
    }


////////////////////////////////////////////////////////
// init method for Accept or update plcyappinfo
////////////////////////////////////////////////////////

  /**
   * Initialization method for Accept or update plcyappinfo
   * @param  ArrayLength   no valuable mean,just for overload usage
   * @return                 void
   * @exception              com.mcip.orb.CoException
   * @exception              Exception
   */

    public void init(int ArrayLength) throws com.mcip.orb.CoException,Exception {

//Init package header parm
        pkclass=inpkthead.getClass();
        pkfield=pkclass.getFields();
        pklen=pkfield.length;

        int Length=ArrayLength;

//in input array equals to "",no need to create stru object
        if ((ArrayLength==1) && (inrdr[0][0].equals(""))){
            Length=0;
        }

        java.util.Vector vctor=new Vector(6+Length);

//Add PktBodyInfoStru
//the length of input plyRdrStru must be recorded in pkBodyInfoStru
        Object pkBodyInfoObj= new pkBodyInfoStru(String.valueOf(Length));
        vctor.addElement(pkBodyInfoObj);

//Add plyAppPolyGridStru
        Object plyAppPolyGridObj= new plyAppPolyGridStru();
        SetplyAppPolyGridObj_Mapto_inobj(plyAppPolyGridObj);
        vctor.addElement(plyAppPolyGridObj);

//Add plyAppPolicyStru
        Object plyAppPolicyObj= new plyAppPolicyStru();
        SetplyAppPolicyObj_Mapto_inobj(plyAppPolicyObj);
        vctor.addElement(plyAppPolicyObj);

//Add plyGoTgtStru
        Object plyGoTgtObj= new plyGoTgtStru();
        SetplyGoTgObj_Mapto_inobj(plyGoTgtObj);
        vctor.addElement(plyGoTgtObj);

//Add plyRdrStru in a Loop
        for (int i=0;i<Length;i++){
            Object plyRdrObj= new plyRdrStru();
            SetplyRdrObj_Mapto_inobj(plyRdrObj,i);
            vctor.addElement(plyRdrObj);
        }

//Add plyPayStru
        Object plyPayObj= new plyPayStru();
        SetplyPayObj_Mapto_inobj(plyPayObj);
        vctor.addElement(plyPayObj);

//Add plyPlyappNetStru
        Object plyPlyappNetObj= new plyPlyappNetStru();
        SetplyPlyappNetObj_Mapto_inobj(plyPlyappNetObj);
        vctor.addElement(plyPlyappNetObj);

        in_vctor=vctor;
    }

////////////////////////////////////////////////////////
// init method for add endorsement policy
////////////////////////////////////////////////////////

  /**
   * Initialization method for add endorsement policy
   * @param  ArrayLength   no valuable mean,just for overload usage
   * @param  ArrayLength2   no valuable mean,just for overload usage
   * @return                 void
   * @exception              com.mcip.orb.CoException
   * @exception              Exception
   */

    public void init(int ArrayLength,int ArrayLength2) throws com.mcip.orb.CoException,Exception {

//Init package header parm
        pkclass=inpkthead.getClass();
        pkfield=pkclass.getFields();
        pklen=pkfield.length;

//in input array equals to "",no need to create stru object
//the first row of array is attribute name and must the same sequence of object
        int Length;
        if (ArrayLength<2){
            Length=0;
        }else{
            Length=ArrayLength-1;
        }

        java.util.Vector vctor=new Vector(6+Length);

//Add PktBodyInfoStru
//the length of input plyRdrStru must be recorded in pkBodyInfoStru
        Object pkBodyInfoObj= new pkBodyInfoStru(String.valueOf(Length));
        vctor.addElement(pkBodyInfoObj);

//Add plyEdrPolyGridStru
        SetRefobj_Mapto_inobj(JCConstant.ADDPOLICYEDR_PACKET_ID);
        vctor.addElement(referobj);

//Add PlyEdrAppInfo
        Object PlyEdrAppInfoobj= in_vctor.elementAt (0);
        vctor.addElement(PlyEdrAppInfoobj);

//Add PlyEdrAppCrgoInfo
        Object PlyEdrAppCrgoInfoobj= in_vctor.elementAt (1);
        vctor.addElement(PlyEdrAppCrgoInfoobj);

//Add plyEdrAppRdrStru in a Loop
        if (Length>0){
            Vector tempvctor=StrArrToObjVctor(inrdr);
            for(int i=0;i<tempvctor.size();i++){
               vctor.addElement (tempvctor.elementAt (i));
            }
        }

//Add PlyEdrAppPayInfo
        Object PlyEdrAppPayInfoobj= in_vctor.elementAt (2);
        vctor.addElement(PlyEdrAppPayInfoobj);

//Add PlyPlyAppNetInfoobj
        Object PlyPlyAppNetInfoobj= in_vctor.elementAt (3);
        vctor.addElement(PlyPlyAppNetInfoobj);

        in_vctor=vctor;
//Added for debug
if (JCConstant.JTOC_DEBUGINFO){
    System.out.println ("_________Input Vector_________");
    DataUtility.dispVectorDtl(in_vctor);
}
//End debug
    }


////////////////////////////////////////////////////////
// Set Referobj Mapping to Inputobj for common user case
////////////////////////////////////////////////////////

  /**
   * Assign value from originalobj to targetobj
   * @param  OriginalObj  input CORBA object
   * @param  TargetObj    output object coresponding with c struct
   * @return                 void
   * @exception              Exception
   */

    public void SetRefobj_Mapto_inobj(Object OriginalObj,Object TargetObj)throws Exception{
        String fieldLen=null;
        String nfieldValue=null;
        String nfieldName=null;


        Class OriginalClass=OriginalObj.getClass();
        Field[] Originalfield=OriginalClass.getFields();
        int Originallen=Originalfield.length;

        Class TargetClass=TargetObj.getClass();
        Field[] Targetfield=TargetClass.getFields();
        int Targetlen=Targetfield.length;

        int outlen=Targetlen;

        try{
            for (int i=0;i<Targetlen;i++){
                nfieldName = Targetfield[i].getName();
                if (findfield(nfieldName,OriginalObj)){
                   nfieldValue=(OriginalClass.getField(nfieldName).get(OriginalObj)).toString();
                }else{
                   nfieldValue="";
                }
                TargetClass.getField(nfieldName).set(TargetObj,nfieldValue);
            }
        }catch (com.mcip.orb.CoException e) {
                throw e;
        }catch (Exception e){
            System.out.println ("Exception in:"+"SetRefobj_Mapto_inobj");
            ErrorHandling(ExceptionCode.JC_ERROR_MAPPING,e.toString());
        }
    }


////////////////////////////////////////////////////////
// Update special field in back-end platform
// and some code pending for changing after user confirm
////////////////////////////////////////////////////////

  /**
   * Assign value from originalobj to targetobj according with input packet id
   * @param  in_packetid  input packet id
   * @return                 void
   * @exception              Exception
   */

    private void SetRefobj_Mapto_inobj(String in_packetid)throws Exception{
        SetRefobj_Mapto_inobj(inobj,referobj);

        if ((in_packetid.equals(JCConstant.ACCEPTPRSNCUST_PACKET_ID)) ||
            (in_packetid.equals(JCConstant.ACCEPTORGACUST_PACKET_ID))){
           referclass.getField("t_upd_tm").set(referobj,ConnectDB.GetCurrentTS(1));
        }else if (in_packetid.equals(JCConstant.CONFIRMPOLICYAPP_PACKET_ID)){
           referclass.getField("c_send_tm").set(referobj,ConnectDB.GetCurrentTS(1));
           referclass.getField("c_source").set(referobj,"0");
//Waiting for change
           referclass.getField("c_send_dpt_cde").set(referobj,"215");
//Waiting for change
           String nfieldValue=(inclass.getField("c_dpt_cde").get(inobj)).toString();
           referclass.getField("c_des_dpt_cde").set(referobj,nfieldValue);

           referclass.getField("c_udr_mrk").set(referobj,"7");
// change on 09th 10
//         referclass.getField("c_udr_mrk").set(referobj,"1");
           referclass.getField("c_send_mrk").set(referobj,"0");
           if (confirmedr){
               referclass.getField("c_prn_typ").set(referobj,"7");
           }else{
               referclass.getField("c_prn_typ").set(referobj,"5");
           }
           referclass.getField("c_flag").set(referobj,"7");
           referclass.getField("c_internet_typ").set(referobj,"2");
        }else if (in_packetid.equals(JCConstant.WITHDRAWALPOLICYAPP_PACKET_ID)){
           referclass.getField("c_send_tm").set(referobj,ConnectDB.GetCurrentTS(1));
           referclass.getField("c_source").set(referobj,"0");
//Waiting for change
           referclass.getField("c_send_dpt_cde").set(referobj,"215");
//Waiting for change
           String nfieldValue=(inclass.getField("c_dpt_cde").get(inobj)).toString();
           referclass.getField("c_des_dpt_cde").set(referobj,nfieldValue);
           referclass.getField("c_prn_typ").set(referobj,"5");
           referclass.getField("c_flag").set(referobj,"3");
           referclass.getField("c_internet_typ").set(referobj,"1");
        }else if (in_packetid.equals(JCConstant.DELETEPOLICYAPP_PACKET_ID)){
           referclass.getField("c_send_tm").set(referobj,ConnectDB.GetCurrentTS(1));
           referclass.getField("c_source").set(referobj,"0");
//Waiting for change
           referclass.getField("c_send_dpt_cde").set(referobj,"215");
//Waiting for change
           String nfieldValue=(inclass.getField("c_dpt_cde").get(inobj)).toString();
           referclass.getField("c_des_dpt_cde").set(referobj,nfieldValue);
           referclass.getField("c_prn_typ").set(referobj,"5");
           referclass.getField("c_flag").set(referobj,"5");
           referclass.getField("c_internet_typ").set(referobj,"1");
        }else if (in_packetid.equals(JCConstant.ADDPOLICYEDR_PACKET_ID)){
           referclass.getField("c_send_tm").set(referobj,ConnectDB.GetCurrentTS(1));
           referclass.getField("c_source").set(referobj,"0");
           referclass.getField("c_prn_typ").set(referobj,"5");
           referclass.getField("c_flag").set(referobj,"2");
           referclass.getField("c_internet_typ").set(referobj,"1");
           referclass.getField("c_send_dpt_cde").set(referobj,"001");

        }else if (in_packetid.equals(JCConstant.GETPOLICYFOREDR_PACKET_ID)){
           referclass.getField("c_prn_typ").set(referobj,"1");
        }else if (in_packetid.equals(JCConstant.WITHDRAWALPLYFOREDR_PACKET_ID )){
           referclass.getField("c_flag").set(referobj,"3");
           referclass.getField("c_internet_typ").set(referobj,"1");
        }else if (in_packetid.equals(JCConstant.GETEDRAPPINFO_PACKET_ID)){
           referclass.getField("c_source").set(referobj,"0");
           referclass.getField("c_flag").set(referobj,"4");
           referclass.getField("c_internet_typ").set(referobj,"1");
        }else if (in_packetid.equals(JCConstant.DELETEPLYFOREDR_PACKET_ID )){
           referclass.getField("c_flag").set(referobj,"5");
           referclass.getField("c_internet_typ").set(referobj,"1");
        }


    }

////////////////////////////////////////////////////////
// Set Referobj Mapping to Inputobj for accept/update policy user case
// it will not use referobj
////////////////////////////////////////////////////////
  /**
   * Assign value from originalobj to targetobj for accept/update policy user case
   * @param  plyAppPolyGridObj  input java object
   * @return                 void
   * @exception              Exception
   */

    private void SetplyAppPolyGridObj_Mapto_inobj(Object plyAppPolyGridObj) throws Exception{
        Class plyAppPolyGridStru =plyAppPolyGridObj.getClass();
        SetRefobj_Mapto_inobj(inplcyAppInfoobj,plyAppPolyGridObj);
        plyAppPolyGridStru.getField("c_crt_cde").set(plyAppPolyGridObj,inplcyAppInfoobj.c_app_cde);
        plyAppPolyGridStru.getField("c_crt_tm").set(plyAppPolyGridObj,ConnectDB.GetCurrentTS(1));
        plyAppPolyGridStru.getField("c_upd_cde").set(plyAppPolyGridObj,inplcyAppInfoobj.c_app_cde);
        plyAppPolyGridStru.getField("c_upd_tm").set(plyAppPolyGridObj,ConnectDB.GetCurrentTS(1));
        plyAppPolyGridStru.getField("c_send_tm").set(plyAppPolyGridObj,ConnectDB.GetCurrentTS(1));
        plyAppPolyGridStru.getField("c_source").set(plyAppPolyGridObj,"0");
        plyAppPolyGridStru.getField("c_udr_mrk").set(plyAppPolyGridObj,inplcyAppInfoobj.c_udr_mrk);//added by rao
		plyAppPolyGridStru.getField("c_mdfy_tm").set(plyAppPolyGridObj,inplcyAppInfoobj.c_mdfy_tm);//added by kangjin
//Waiting for change
//      plyAppPolyGridStru.getField("c_send_dpt_cde").set(plyAppPolyGridObj,JCConstant.C_SEND_DPT_CDE);
        plyAppPolyGridStru.getField("c_send_dpt_cde").set(plyAppPolyGridObj,"215");


//Waiting for change
        String nfieldValue=(plyAppPolyGridStru.getField("c_dpt_cde").get(plyAppPolyGridObj)).toString();
        plyAppPolyGridStru.getField("c_des_dpt_cde").set(plyAppPolyGridObj,nfieldValue);

        //by kangjin plyAppPolyGridStru.getField("c_mdfy_tm").set(plyAppPolyGridObj,ConnectDB.GetCurrentTS(1));
        plyAppPolyGridStru.getField("c_prn_typ").set(plyAppPolyGridObj,"5");
        plyAppPolyGridStru.getField("c_flag").set(plyAppPolyGridObj,"2");
        plyAppPolyGridStru.getField("c_internet_typ").set(plyAppPolyGridObj,"1");
    }

  /**
   * Assign value from originalobj to targetobj for accept/update policy user case
   * @param  plyAppPolicyObj  input java object
   * @return                 void
   * @exception              Exception
   */

    private void SetplyAppPolicyObj_Mapto_inobj(Object plyAppPolicyObj) throws Exception{
        Class plyAppPolicyStru =plyAppPolicyObj.getClass();
        SetRefobj_Mapto_inobj(inplcyAppInfoobj,plyAppPolicyObj);
        plyAppPolicyStru.getField("c_crt_cde").set(plyAppPolicyObj,inplcyAppInfoobj.c_app_cde);
        plyAppPolicyStru.getField("c_crt_tm").set(plyAppPolicyObj,ConnectDB.GetCurrentTS(1));
        plyAppPolicyStru.getField("c_upd_cde").set(plyAppPolicyObj,inplcyAppInfoobj.c_app_cde);
        plyAppPolicyStru.getField("c_upd_tm").set(plyAppPolicyObj,ConnectDB.GetCurrentTS(1));
        plyAppPolicyStru.getField("c_internet_typ").set(plyAppPolicyObj,"1");
    }

  /**
   * Assign value from originalobj to targetobj for accept/update policy user case
   * @param  plyGoTgObj  input java object
   * @return                 void
   * @exception              Exception
   */

    private void SetplyGoTgObj_Mapto_inobj(Object plyGoTgObj) throws Exception{
        Class plyGoTgStru =plyGoTgObj.getClass();
        SetRefobj_Mapto_inobj(inplcyAppInfoobj,plyGoTgObj);
        plyGoTgStru.getField("c_crt_cde").set(plyGoTgObj,inplcyAppInfoobj.c_app_cde);
        plyGoTgStru.getField("c_crt_tm").set(plyGoTgObj,ConnectDB.GetCurrentTS(1));
        plyGoTgStru.getField("c_upd_cde").set(plyGoTgObj,inplcyAppInfoobj.c_app_cde);
        plyGoTgStru.getField("c_upd_tm").set(plyGoTgObj,ConnectDB.GetCurrentTS(1));
    }

  /**
   * Assign value from originalobj to targetobj for accept/update policy user case
   * @param  plyRdrObj  input java object
   * @param  counter    the counter of input java object
   * @return                 void
   * @exception              Exception
   */

    private void SetplyRdrObj_Mapto_inobj(Object plyRdrObj,int counter) throws Exception{
        Class plyRdrStru =plyRdrObj.getClass();
        SetRefobj_Mapto_inobj(inplcyAppInfoobj,plyRdrObj);
        plyRdrStru.getField("c_crt_cde").set(plyRdrObj,inplcyAppInfoobj.c_app_cde);
        plyRdrStru.getField("c_crt_tm").set(plyRdrObj,ConnectDB.GetCurrentTS(1));
        plyRdrStru.getField("c_upd_cde").set(plyRdrObj,inplcyAppInfoobj.c_app_cde);
        plyRdrStru.getField("c_upd_tm").set(plyRdrObj,ConnectDB.GetCurrentTS(1));
        plyRdrStru.getField("c_rdr_cde").set(plyRdrObj,inrdr[counter][0]);
        plyRdrStru.getField("c_rdr_nme").set(plyRdrObj,inrdr[counter][1]);
//Waiting for change
        plyRdrStru.getField("c_obj_no").set(plyRdrObj,"1");

    }

  /**
   * Assign value from originalobj to targetobj for accept/update policy user case
   * @param  plyPayObj  input java object
   * @return                 void
   * @exception              Exception
   */

    private void SetplyPayObj_Mapto_inobj(Object plyPayObj) throws Exception{
        Class plyPayStru =plyPayObj.getClass();
        SetRefobj_Mapto_inobj(inplcyAppInfoobj,plyPayObj);
        plyPayStru.getField("c_crt_cde").set(plyPayObj,inplcyAppInfoobj.c_app_cde);
        plyPayStru.getField("c_crt_tm").set(plyPayObj,ConnectDB.GetCurrentTS(1));
        plyPayStru.getField("c_upd_cde").set(plyPayObj,inplcyAppInfoobj.c_app_cde);
        plyPayStru.getField("c_upd_tm").set(plyPayObj,ConnectDB.GetCurrentTS(1));
    }

  /**
   * Assign value from originalobj to targetobj for accept/update policy user case
   * @param  plyPlyappNetObj  input java object
   * @return                 void
   * @exception              Exception
   */
    private void SetplyPlyappNetObj_Mapto_inobj(Object plyPlyappNetObj) throws Exception{
        Class plyPlyappNetStru =plyPlyappNetObj.getClass();
        SetRefobj_Mapto_inobj(inplcyAppInfoobj,plyPlyappNetObj);
        plyPlyappNetStru.getField("c_crt_cde").set(plyPlyappNetObj,inplcyAppInfoobj.c_app_cde);
        plyPlyappNetStru.getField("c_crt_tm").set(plyPlyappNetObj,ConnectDB.GetCurrentTS(1));
        plyPlyappNetStru.getField("c_upd_cde").set(plyPlyappNetObj,inplcyAppInfoobj.c_app_cde);
        plyPlyappNetStru.getField("c_upd_tm").set(plyPlyappNetObj,ConnectDB.GetCurrentTS(1));
    }


////////////////////////////////////////////////////////
// Get ReferObject for common user case
// if input obj=output obj no need to call this
// if for accept/update policy no need to call this
////////////////////////////////////////////////////////

  /**
   * create Reference Object which needed in c moudle for common user case
   * @return                 Object
   * @exception              Exception
   */

    private Object CreateReferOject() throws Exception{

        String s=inclass.getName();

        if(s.equals("java.lang.String")){
            String st=new String();
            return st;
        }

        if (in_packetid.equals(JCConstant.ACCEPTPRSNCUST_PACKET_ID)){
            cltPerClntInfoStru object=new cltPerClntInfoStru();
            return object;
        }

        if (in_packetid.equals(JCConstant.ACCEPTORGACUST_PACKET_ID)){
            cltOrgClntInfoStru object=new cltOrgClntInfoStru();
            return object;
        }

        if (in_packetid.equals(JCConstant.UPDATEPRSNCUST_PACKET_ID)){
            cltPerClntInfoStru object=new cltPerClntInfoStru();
            return object;
        }

        if (in_packetid.equals(JCConstant.UPDATEORGACUST_PACKET_ID)){
            cltOrgClntInfoStru object=new cltOrgClntInfoStru();
            return object;
        }

        if (in_packetid.equals(JCConstant.CONFIRMPOLICYAPP_PACKET_ID)){
            plyCheckGridStru object=new plyCheckGridStru();
            return object;
        }

        if (in_packetid.equals(JCConstant.WITHDRAWALPOLICYAPP_PACKET_ID)){
            plyAppPolyGridStru object=new plyAppPolyGridStru();
            return object;
        }

        if (in_packetid.equals(JCConstant.DELETEPOLICYAPP_PACKET_ID)){
            plyAppPolyGridStru object=new plyAppPolyGridStru();
            return object;
        }

        if (in_packetid.equals(JCConstant.ACCEPTCASEREPORT_PACKET_ID)){
            clmInListChangeStru object=new clmInListChangeStru();
            return object;
        }

        if (in_packetid.equals(JCConstant.GETPOLICYFOREDR_PACKET_ID)){
            com.mcip.nia.orb.PlyGetDocInfo object=new com.mcip.nia.orb.PlyGetDocInfo();
            return object;
        }

        if (in_packetid.equals(JCConstant.ADDPOLICYEDR_PACKET_ID)){
            plyEdrGridStru object=new plyEdrGridStru();
            return object;
        }

        if (in_packetid.equals(JCConstant.WITHDRAWALPLYFOREDR_PACKET_ID)){
            plyEdrGridStru object=new plyEdrGridStru();
            return object;
        }

        if (in_packetid.equals(JCConstant.GETEDRAPPINFO_PACKET_ID)){
            plyEdrGridStru object=new plyEdrGridStru();
            return object;
        }

        if (in_packetid.equals(JCConstant.DELETEPLYFOREDR_PACKET_ID)){
            plyEdrGridStru object=new plyEdrGridStru();
            return object;
        }

        if (in_packetid.equals(JCConstant.GETPRINTINFO_PACKET_ID)){
            PrintObj object=new PrintObj();
            return object;
        }

        if (in_packetid.equals(JCConstant.GETPRINTFMT_PACKET_ID)){
            PrintObj object=new PrintObj();
            return object;
        }
//Depending for change here....
        ErrorHandling(ExceptionCode.JC_ERROR_CASENO,"Input packetid:"+in_packetid+"in CreateReferOject()");
        return null;
    }


////////////////////////////////////////////////////////
// Reset return object
////////////////////////////////////////////////////////

  /**
   * Reset the value of Return Object
   * @return                 void
   * @exception              Exception
   */

    private void ResetReturnObj() throws Exception{
        int  outlen=returnobjlen;
        String nfieldName =null;
        for (int i=0;i<outlen;i++){
             nfieldName = returnfield[i].getName();
             returnclass.getField(nfieldName).set(returnobj,"");
        }

    }

  /**
   * Reset the value of input Object
   * @param                  Obj
   * @return                 Object
   * @exception              Exception
   */

    private Object ResetReturnObj(Object obj) throws Exception{
        int  outlen=GetObjLen(obj);
        Field[] objfield=GetObjProperties(obj);
        Class objclass=GetObjClass(obj);
        String nfieldName =null;
        for (int i=0;i<outlen;i++){
             nfieldName = objfield[i].getName();
             objclass.getField(nfieldName).set(obj,"");
        }
        return obj;
    }

////////////////////////////////////////////////////////
// Get return obj for common user case
// no need for return vector
////////////////////////////////////////////////////////

  /**
   * Create the return Object according with input packet id
   * @return                 Object
   * @exception              com.mcip.orb.CoException,Exception
   */
    private Object CreateReturnObj() throws com.mcip.orb.CoException,Exception {
        if ((in_packetid.equals(JCConstant.ACCEPTPRSNCUST_PACKET_ID)) ||
            (in_packetid.equals(JCConstant.ACCEPTORGACUST_PACKET_ID)) ||
            (in_packetid.equals(JCConstant.UPDATEPRSNCUST_PACKET_ID)) ||
            (in_packetid.equals(JCConstant.UPDATEORGACUST_PACKET_ID)) ||
			(in_packetid.equals(JCConstant.GETPRINTINFO_PACKET_ID)) ||
			(in_packetid.equals(JCConstant.GETPRINTFMT_PACKET_ID))){
            return referobj.getClass().newInstance ();
        }

        if (in_packetid.equals(JCConstant.CONFIRMPOLICYAPP_PACKET_ID)){
            plyCheckGridStru object=new plyCheckGridStru();
            return object;
        }

        if (in_packetid.equals(JCConstant.WITHDRAWALPOLICYAPP_PACKET_ID)){
            plyAppPolyGridStru object=new plyAppPolyGridStru();
            return object;
        }

        if (in_packetid.equals(JCConstant.DELETEPOLICYAPP_PACKET_ID)){
            plyAppPolyGridStru object=new plyAppPolyGridStru();
            return object;
        }

        if (in_packetid.equals(JCConstant.ACCEPTCASEREPORT_PACKET_ID)){
            clmPlcyNoStru object=new clmPlcyNoStru();
            return object;
        }

        if (in_packetid.equals(JCConstant.WITHDRAWALPLYFOREDR_PACKET_ID )){
            plyEdrGridStru object=new plyEdrGridStru("0");
            return object;
        }

        if (in_packetid.equals(JCConstant.DELETEPLYFOREDR_PACKET_ID )){
            plyEdrGridStru object=new plyEdrGridStru("0");
            return object;
        }

        return new Object();

    }


////////////////////////////////////////////////////////
// Check if input string is property of input class
////////////////////////////////////////////////////////

  /**
   * Check if input string is property of input class
   * @param  s   the target attribute name
   * @param  obj the target  object
   * @return                 boolean
   * @exception              com.mcip.orb.CoException
   */

    private boolean findfield(String s, Object obj) throws com.mcip.orb.CoException{
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
                 System.out.println ("Exception in:"+"findfield");
                 ErrorHandling(ExceptionCode.JC_FINDFIELD_FAIL,e.toString());
            }
        }
        return result;
    }


  /**
   * Check if input string is property of refer class
   * @param  s   the target attribute name
   * @return                 boolean
   * @exception              com.mcip.orb.CoException
   */

    private boolean findfield(String s) throws com.mcip.orb.CoException{
        return findfield(s,referobj);
    }



////////////////////////////////////////////////////////
// Left pad for input string
////////////////////////////////////////////////////////

  /**
   * lpad the string which needed by c in fix length
   * @param  str1   the original string
   * @param  str_len the leng need to pad
   * @param  str3   the string pad on the left of original string
   * @return                 String
   * @exception              Exception
   */

    private String strlpad(String str1,int str_len,String str3) throws Exception{
        int i=0;
        int j=0;
        String str2=new String(str3);
        j=str1.length();
        if (j>=str_len)
            return str1;
        else{
            for (i=0;i<(str_len-j-1);i++){
                str2=str2.concat(str3);
            }
            str2=str2.concat(str1);
            return str2;
        }
    }


////////////////////////////////////////////////////////
// Build java object to c style string
//     string=s1+s2+s3+s4
//     s1= s1.length+s1.content
////////////////////////////////////////////////////////

  /**
   * Build java object to c style string
   * @param  obj   the object which is the same with c input struct
   * @return                 String
   * @exception              com.mcip.orb.CoException
   */

    private String setCstring(Object obj) throws com.mcip.orb.CoException{

        Object tempobj=obj;
        Class tempclass=obj.getClass();
        Field[] tempfield=tempclass.getFields();
        int outlen=tempfield.length;

        String temp="";
        String fieldName=null;
        String fieldValue=null;
        byte[] retbyte=null;

        for (int i=0;i<outlen;i++){
            try{
                fieldName = tempfield[i].getName();
                fieldValue=(tempclass.getField(fieldName).get(tempobj)).toString();

                retbyte=fieldValue.getBytes("GB2312");
                int bytelen=retbyte.length;

                if (fieldValue.equals(null) && bytelen==4)
                    temp=temp.concat("0000");
                else{
                    temp=temp.concat(strlpad(String.valueOf(bytelen),4,"0"));
                    temp=temp.concat(fieldValue);
                }
           }catch (com.mcip.orb.CoException e) {
                throw e;
           }catch(Exception e){
                 System.out.println ("Exception in:"+"setCstring");
                 ErrorHandling(ExceptionCode.JC_SETCSTRING_FAIL,e.toString());
                 return null;
            }
        }
        return temp;

    }


////////////////////////////////////////////////////////
// Get Packet Header String
////////////////////////////////////////////////////////

  /**
   * Build Packed header to c style string
   * @return                 String
   * @exception              com.mcip.orb.CoException
   */


    private String getPacketHeadStr() throws com.mcip.orb.CoException{
        return setCstring(inpkthead);
    }


////////////////////////////////////////////////////////
// Get Packet Body String and add Header before
////////////////////////////////////////////////////////

  /**
   * Build Packet Body String and add Header before
   * @param  sPkHead  the packed haead string
   * @param  obj      the packed body
   * @return                 String
   * @exception              com.mcip.orb.CoException
   */

    private String getInputString(String sPkHead,Object obj) throws com.mcip.orb.CoException{
        String temp=setCstring(obj);
        temp= sPkHead.concat(temp);
        return temp;
    }

  /**
   * Build Input String
   * @return                 String
   * @exception              com.mcip.orb.CoException
   */

    private String getInputString() throws com.mcip.orb.CoException{
        String pkHead=getPacketHeadStr();
        return getInputString(pkHead,referobj);
    }


  /**
   * Convert all obj in vector into string
   * @param  vctor  the input vector which stored input object
   * @return                 String
   * @exception              com.mcip.orb.CoException
   */

    private String getInputString(java.util.Vector vctor) throws com.mcip.orb.CoException{
        String pkHead=getPacketHeadStr();
        String result=pkHead;
        for (int i=0;i<vctor.size();i++){
           result=getInputString(result,vctor.elementAt (i));
//Add for Debug
if (JCConstant.JTOC_DEBUGINFO){
    System.out.println("__________Object to String Begin__________");
    System.out.println(this.GetObjClass(vctor.elementAt (i)).toString ());
    DisplayFields (vctor.elementAt (i));
    System.out.println("__________Object to String End__________");
}
//End Debug
        }
        return result;
    }

////////////////////////////////////////////////////////
// Conver refer object to byte array used for c program
////////////////////////////////////////////////////////

  /**
   * Conver refer object to byte array used for c program
   * @param  str  the input C_style (include length delimiter) String
   * @return                 byte[]
   * @exception              com.mcip.orb.CoException
   */

    private byte[] SetInputByteArray(String str) throws com.mcip.orb.CoException{

        byte[] retbyte=null;
        try{
            retbyte=str.getBytes("GB2312");
        }catch (Exception e){
            System.out.println ("Exception in:"+"SetInputByteArray");
            ErrorHandling(ExceptionCode.JC_SETINPUTBYTEARRAY_FAIL,e.toString());
            return null;
        }
        return retbyte;
    }

////////////////////////////////////////////////////////
// Set output Object, convert byte array to string, then to object
////////////////////////////////////////////////////////

  /**
   * Set output object according with c output struct
   * @param  obj  the object which needed fill in value
   * @param  OutputString  the object's attribute in 2-dime array
   * @param  beginidx  the object's attribute's begin index
   * @return                 Object
   * @exception              com.mcip.orb.CoException
   */

    private Object SetOutputObject(Object obj,String OutputString[],int beginidx) throws com.mcip.orb.CoException{

        String fieldName=null;
        String fieldValue=null;

        Class tempclass =obj.getClass ();
        Field[] tempfield=tempclass.getFields();
        int outlen=tempfield.length;
        int k=beginidx;

        try{
            for (int i=0;i<outlen;i++){
                fieldName = tempfield[i].getName();
                fieldValue=OutputString[k++];
                tempclass.getField(fieldName).set(obj,fieldValue);
//Add for debug
if (JCConstant.JTOC_DEBUGINFO){
    //after resolve it
    System.out.println("SetOutputobject:"+i+'\n'+
                       "fieldName:"+fieldName+'\n'+
                       "fieldValue:"+fieldValue+'\n');
}
//End debug
            }
        }catch (Exception e){
             System.out.println ("Exception in:"+"SetOutputObject");
             ErrorHandling(ExceptionCode.JC_GETPKHEADSTRARRAY_FAIL,e.toString());
        }
        return obj;

    }

////////////////////////////////////////////////////////
// Set output Object, convert byte array to string, begin index is zero, then to object
////////////////////////////////////////////////////////
  /**
   * Set output Object, convert byte array to string, begin index is zero, then to object
   * @param  obj  the object which needed fill in value
   * @param  OutputString  the object's attribute in 2-dime array
   * @return                 Object
   * @exception              com.mcip.orb.CoException
   */

    private Object SetOutputObject(Object obj,String OutputString[]) throws com.mcip.orb.CoException{
        return SetOutputObject(obj,OutputString,0);
    }

////////////////////////////////////////////////////////
// Set output packetheader to object
////////////////////////////////////////////////////////
  /**
   * Set output packet header, convert byte array to string, begin index is zero, then to object
   * @param  String[] OutputString  the packet header's attribute in 2-dime array
   * @return                 Object
   * @exception              com.mcip.orb.CoException
   */

    private Object SetOutpkthead(String OurStrArray[]) throws com.mcip.orb.CoException{
        outpkthead=new PacketHead();
        try{
            Object result=SetOutputObject(outpkthead,OurStrArray);
            Class tempclass=result.getClass ();
            Field[] tempfield=tempclass.getFields();
            int outlen=tempfield.length;

            if (tempclass.getField("cRetCode").get(result).toString()==null){
                ErrorHandling(ExceptionCode.JC_CNULLRETURN,"cRetCode");
            }

//Decide the return value
            String cRetCode=tempclass.getField("cRetCode").get(result).toString();

//if the return code from c not zero ,error
            if (Integer.parseInt (cRetCode)!=0){
                String errormsg=OurStrArray[outlen];
                System.out.println("C Return Error Message:"+errormsg);
                ErrorHandling(ExceptionCode.JC_CERRORRETURN,errormsg);
            }
            return result;
        }catch (com.mcip.orb.CoException e) {
                throw e;
        }catch (Exception e){
             System.out.println ("Exception in:"+"SetOutpkthead");
             ErrorHandling(ExceptionCode.JC_GETPKHEADSTRARRAY_FAIL,e.toString());
             return null;
        }
    }


////////////////////////////////////////////////////////
// Set c program output to object vector
////////////////////////////////////////////////////////

  /**
   * Set c program output to object vector
   * @param  OutputString  the output header's attribute in 2-dime array
   * @return                 Vector
   * @exception              com.mcip.orb.CoException
   */
    private Vector SetOutput(String[] OutputString) throws com.mcip.orb.CoException{
        Vector returnVctor= new Vector();
        try{
            Object outputpkthead=SetOutpkthead(OutputString);
            returnVctor.addElement (outputpkthead);
            int beginidx=GetObjLen(outputpkthead);
            Object outputobject=SetOutputObject(returnobj,OutputString,beginidx);

            returnVctor.addElement (outputobject);

            return returnVctor;
        }catch (com.mcip.orb.CoException e) {
                throw e;
        }catch (Exception e){
             System.out.println ("Exception in:"+"SetOutputObj(String OutputString)");
             ErrorHandling(ExceptionCode.JC_GETSTRARRAY_FAIL,e.toString());
             return null;
        }

    }


////////////////////////////////////////////////////////
// Set c program output to object vector
// For common use case
////////////////////////////////////////////////////////
  /**
   * Set c program output to object vector for common use case
   * @param  OutputString   the output header's attribute in 2-dime array
   * @param  pkBodyInfoObj  only need for user case which use pkBodyInfoObj for output
   * @return                 Vector
   * @exception              com.mcip.orb.CoException
   */

    private Vector SetOutput(String[] OutputString,pkBodyInfoStru pkBodyInfoObj) throws com.mcip.orb.CoException{

        Vector returnVctor= new Vector();

        try{

            Object outputpkthead=SetOutpkthead(OutputString);
            returnVctor.addElement (outputpkthead);
            int beginidx=GetObjLen(outputpkthead);

//Create return pkBodyInfoObj
            Object outpkBodyInfoObj=SetOutputObject(pkBodyInfoObj,OutputString,beginidx);
            returnVctor.addElement (outpkBodyInfoObj);
            beginidx+=GetObjLen(outpkBodyInfoObj);

//Create return object

            if (in_packetid.equals(JCConstant.ADDPOLICYEDR_PACKET_ID)){

                plyEdrGridStru plyEdrGridobject=new plyEdrGridStru();
                Object outplyEdrGridobject=SetOutputObject(plyEdrGridobject,OutputString,beginidx);
                beginidx+=GetObjLen(outplyEdrGridobject);
                returnVctor.addElement (outplyEdrGridobject);


                if (outpkBodyInfoObj.getClass ().getField ("NPktNum1").get(outpkBodyInfoObj).toString ().equalsIgnoreCase("0")){
                }else{
                   Object outputobject=SetOutputObject(new plyProposalStru(),OutputString,beginidx);
                   returnVctor.addElement (outputobject);

                }
            }else{
                Object outputobject=SetOutputObject(returnobj,OutputString,beginidx);
                returnVctor.addElement (outputobject);
            }


        }catch (com.mcip.orb.CoException e) {
                throw e;
        }catch (Exception e){
             System.out.println ("Exception in:"+"(String OutputString,plyAppPolyGridStru plyAppPolyGridObj,plyProposalStru plyProposalObj)");
             ErrorHandling(ExceptionCode.JC_GETSTRARRAY_FAIL,e.toString());
             return null;
        }
//Added for debug
if (JCConstant.JTOC_DEBUGINFO){
    System.out.println ("_________Output Vector_________");
    DataUtility.dispVectorDtl(returnVctor);
}
//End debug
        return returnVctor;


    }


////////////////////////////////////////////////////////
// Set c program output to object vector
// For accept or update policy use case
////////////////////////////////////////////////////////

  /**
   * Set c program output to object vector for accept or update policy use case
   * @param  OutputString      the output header's attribute in 2-dime array
   * @param  plyAppPolyGridObj the output object which should be known before calling
   * @param  plyProposalObj    the output object which should be known before calling
   * @return                 Vector
   * @exception              com.mcip.orb.CoException
   */

    private Vector SetOutput(String[] OutputString,plyAppPolyGridStru plyAppPolyGridObj,plyProposalStru plyProposalObj) throws com.mcip.orb.CoException{

        Vector returnVctor= new Vector();

        try{

            Object outputpkthead=SetOutpkthead(OutputString);
            returnVctor.addElement (outputpkthead);
            int beginidx=GetObjLen(outputpkthead);

//Create return pkBodyInfoObj
            Object pkBodyInfoObj= new pkBodyInfoStru();
            Object outpkBodyInfoObj=SetOutputObject(pkBodyInfoObj,OutputString,beginidx);
            returnVctor.addElement (outpkBodyInfoObj);
            beginidx+=GetObjLen(outpkBodyInfoObj);

//Create return plyAppPolyGridObj
            Object outplyAppPolyGridObj=SetOutputObject(plyAppPolyGridObj,OutputString,beginidx);
            returnVctor.addElement (outplyAppPolyGridObj);
            beginidx+=GetObjLen(outplyAppPolyGridObj);

//Create return plyProposalObj
            Object outplyProposalObj=SetOutputObject(plyProposalObj,OutputString,beginidx);
            returnVctor.addElement (plyProposalObj);

        }catch (com.mcip.orb.CoException e) {
                throw e;
        }catch (Exception e){
             System.out.println ("Exception in:"+"SetOutput(String[] OutputString,plyAppPolyGridStru plyAppPolyGridObj,plyProposalStru plyProposalObj)");
             ErrorHandling(ExceptionCode.JC_GETSTRARRAY_FAIL,e.toString());
             return null;
        }
//Added for debug
if (JCConstant.JTOC_DEBUGINFO){
    System.out.println ("_________Output Vector_________");
    DataUtility.dispVectorDtl(returnVctor);
}
//End debug
        return returnVctor;
    }

////////////////////////////////////////////////////////
// Set c program output to object vector
// For get endorsement docu use case
// For get edrappinfo for update endorsement
////////////////////////////////////////////////////////

  /**
   * Set c program output to object vector for common use case
   * @param  OutputString         the output header's attribute in 2-dime array
   * @param  PlyEdrAppInfoObj     the output object which should be known before calling
   * @param  PlyEdrAppCrgoInfoObj the output object which should be known before calling
   * @param  plyEdrapprdrObj      the output object which should be known before calling
   * @param  PlyEdrAppPayInfoObj  the output object which should be known before calling
   * @param  PlyPlyAppNetInfoObj  the output object which should be known before calling
   * @return                 Vector
   * @exception              com.mcip.orb.CoException
   */
    private Vector SetOutput(String[] OutputString,
        com.mcip.nia.orb.PlyEdrAppInfo PlyEdrAppInfoObj,
        com.mcip.nia.orb.PlyEdrAppCrgoInfo PlyEdrAppCrgoInfoObj,
        plyEdrapprdrStru plyEdrapprdrObj,
        com.mcip.nia.orb.PlyEdrAppPayInfo PlyEdrAppPayInfoObj,
        com.mcip.nia.orb.PlyPlyAppNetInfo PlyPlyAppNetInfoObj)
        throws com.mcip.orb.CoException{

        Vector returnVctor= new Vector();

        try{

System.out.println("__________Object pkthead__________");
            Object outputpkthead=SetOutpkthead(OutputString);
            returnVctor.addElement (outputpkthead);
            int beginidx=GetObjLen(outputpkthead);


//Create return pkBodyInfoObj
System.out.println("__________Object pkBodyInfo__________");
            Object pkBodyInfoObj= new pkBodyInfoStru();
            Object outpkBodyInfoObj=SetOutputObject(pkBodyInfoObj,OutputString,beginidx);
            returnVctor.addElement (outpkBodyInfoObj);
            beginidx+=GetObjLen(outpkBodyInfoObj);

//Create return plyEdrGridObj
            if (in_packetid.equalsIgnoreCase(JCConstant.GETEDRAPPINFO_PACKET_ID )){
System.out.println("__________Object plyEdrGridObj__________");
                Object plyEdrGridObj= new plyEdrGridStru("0");
                Object outplyEdrGridObj=SetOutputObject(plyEdrGridObj,OutputString,beginidx);
                returnVctor.addElement (outplyEdrGridObj);
                beginidx+=GetObjLen(outplyEdrGridObj);
            }


//Get output rdr length
//Get output PlyPlyAppNetInfoObj flag
            Class tempclass =pkBodyInfoObj.getClass ();
            Field[] tempfield=tempclass.getFields();
            int rdrlength=0;
            int netflag=0;

// For get endorsement docu use case
            if (in_packetid.equalsIgnoreCase(JCConstant.GETPOLICYFOREDR_PACKET_ID)){
                String nfieldName7="NPktNum7";
                String nfieldValue7=(tempclass.getField(nfieldName7).get(pkBodyInfoObj)).toString();
                rdrlength=Integer.parseInt (nfieldValue7);

                String nfieldName12="NPktNum12";
                String nfieldValue12=(tempclass.getField(nfieldName12).get(pkBodyInfoObj)).toString();
                netflag=Integer.parseInt (nfieldValue12);
            }

// For get edrappinfo for update endorsement
            if (in_packetid.equalsIgnoreCase(JCConstant.GETEDRAPPINFO_PACKET_ID)){
                String nfieldName8="NPktNum8";
                String nfieldValue8=(tempclass.getField(nfieldName8).get(pkBodyInfoObj)).toString();
                rdrlength=Integer.parseInt (nfieldValue8);

                String nfieldName13="NPktNum13";
                String nfieldValue13=(tempclass.getField(nfieldName13).get(pkBodyInfoObj)).toString();
                netflag=Integer.parseInt (nfieldValue13);
            }


//Create return PlyEdrAppInfoObj
System.out.println("__________Object PlyEdrAppInfo__________");
            Object outPlyEdrAppInfoObj=SetOutputObject(PlyEdrAppInfoObj,OutputString,beginidx);
            returnVctor.addElement (outPlyEdrAppInfoObj);
            beginidx+=GetObjLen(outPlyEdrAppInfoObj);

//Create return PlyEdrAppCrgoInfoObj
System.out.println("__________Object PlyEdrAppCrgoInfo__________");
            Object outPlyEdrAppCrgoInfoObj=SetOutputObject(PlyEdrAppCrgoInfoObj,OutputString,beginidx);
            returnVctor.addElement (outPlyEdrAppCrgoInfoObj);
            beginidx+=GetObjLen(outPlyEdrAppCrgoInfoObj);

//Create return plyRdrObj


            Object outplyEdrapprdrObj=null;
            int objlen=GetObjLen(plyEdrapprdrObj);
            String[][] singlerdr=new String[2][objlen];
            String[][] wholerdr=new String[rdrlength+1][objlen];

            for (int i=0;i<rdrlength;i++){

                outplyEdrapprdrObj=SetOutputObject(plyEdrapprdrObj,OutputString,beginidx);
                beginidx+=GetObjLen(outplyEdrapprdrObj);
                singlerdr=DataUtility.ObjToStringArray(outplyEdrapprdrObj);
//Added for debug
if (JCConstant.JTOC_DEBUGINFO){
    System.out.println("__________Object plyEdrapprdr__________"+i+"/"+rdrlength);
    DataUtility.dispArray (singlerdr);
}
//End dubug
                if (i==0){
                   wholerdr[i]=singlerdr[0];
                   wholerdr[i+1]=singlerdr[1];
                }else{
                   wholerdr[i+1]=singlerdr[1];
                }
            }

//If no rdr return,assign a[0][0] to request object;
//If rdr return,assign field name to a[0]; assign value to a[1];
            if (rdrlength==0){
               String[][] nullrdr=new String[1][1];
               nullrdr[0][0]="";
               returnrdr=nullrdr;
            }else{
               returnrdr=wholerdr;
            }

//Create return PlyEdrAppPayInfoObj
System.out.println("__________Object PlyEdrAppPayInfo__________");
            Object outPlyEdrAppPayInfoObj=SetOutputObject(PlyEdrAppPayInfoObj,OutputString,beginidx);
            returnVctor.addElement (outPlyEdrAppPayInfoObj);
            beginidx+=GetObjLen(outPlyEdrAppPayInfoObj);

//Create return PlyPlyAppNetInfoObj
            if (netflag==1){
System.out.println("__________Object PlyPlyAppNetInfo__________");
                Object outPlyPlyAppNetInfoObj=SetOutputObject(PlyPlyAppNetInfoObj,OutputString,beginidx);
                returnVctor.addElement (outPlyPlyAppNetInfoObj);
            }else{
                netobjexist=false;
            }

        }catch (com.mcip.orb.CoException e) {
             throw e;
        }catch (Exception e){
             System.out.println ("Exception in:"+"Vector SetOutput(String[] OutputString,com.mcip.nia.orb.PlyEdrAppInfo PlyEdrAppInfoObj,"+
                     "com.mcip.nia.orb.PlyEdrAppCrgoInfo PlyEdrAppCrgoInfoObj,"+
                     "plyRdrStru plyRdrObj,"+
                     "com.mcip.nia.orb.PlyEdrAppPayInfo PlyEdrAppPayInfoObj,"+
                     "com.mcip.nia.orb.PlyPlyAppNetInfo PlyPlyAppNetInfoObj)");
             ErrorHandling(ExceptionCode.JC_GETSTRARRAY_FAIL,e.toString());
             return null;
        }
//Added for debug
if (JCConstant.JTOC_DEBUGINFO){
    System.out.println ("_________Output Vector_________");
    DataUtility.dispVectorDtl(returnVctor);
}
//End debug
        return returnVctor;
    }


////////////////////////////////////////////////////////
//  Convert byte array to string array
////////////////////////////////////////////////////////
//Call by JavaCallC

  /**
   * Convert byte array to string array which called by JavaCallC method
   * @param  byte[] ibyte   the output byte array of c program
   * @return                 String[]
   * @exception              com.mcip.orb.CoException
   */

    private  String[] BytestoStrArray(byte[] ibyte) throws com.mcip.orb.CoException{
        Vector outvctor=new Vector();
        int blength=ibyte.length;
        int i=0;
        try{
            while(i<blength){
//get length from byte array
                byte[] lengthbyte = new byte[4];
                for (int j=0;j<4;j++){
                           lengthbyte[j]=ibyte[i++];
                }
                String sublen= new String(lengthbyte);
                int ilen=Integer.parseInt(sublen);
//Generate object and set attribute according to above length
                byte[] strbyte = new byte[ilen];
                String substr="";
                for (int j=0;j<ilen;j++){
                     strbyte[j]=ibyte[i++];
                     substr= new String(strbyte);
                }
                outvctor.addElement (substr);
            }

//Generate return string array
            int resultlen=outvctor.size();
            String[] result=new String[resultlen];
            for (int k=0;k<resultlen;k++){
                result[k]=outvctor.elementAt (k).toString ();
            }
            return result;
        }catch (Exception e){
            System.out.println ("Exception in:"+"BytestoStr");
            ErrorHandling(ExceptionCode.JC_BYTETOSTR_ERROR,e.toString());
            return null;
        }
    }


////////////////////////////////////////////////////////
//  Convert String array to object vector
//  string arr[][]      :arr[0][0] fieldname_1 ...arr[0][n] fidlename_n
//                      :arr[1][0] fieldval_1  ...arr[1][n] fidleval_n
//                      :arr[m][0] fieldval_1  ...arr[m][n] fidleval_n
//  object vector       obj1...objm
////////////////////////////////////////////////////////
  /**
   * Convert String array to object vector
   * @param  arr   the input string array just like a relational table
   * @return                 Vector
   * @exception              com.mcip.orb.CoException
   */

    public Vector StrArrToObjVctor(String[][] instrarr) throws com.mcip.orb.CoException{
        Vector outvctor=new Vector();

        String fieldName=null;
        String fieldValue=null;

        Object obj = new plyEdrapprdrStru("0");
        Class tempclass =obj.getClass ();
        Field[] tempfield=tempclass.getFields();
        int fieldlen=tempfield.length;
        int vctorlen=instrarr.length;

//Added for debug
if (JCConstant.JTOC_DEBUGINFO){
    System.out.println("********************");
    DataUtility.dispArray (instrarr);
}
//End dubug
        try{
            for (int i=1;i<vctorlen;i++){
                Object tempobj = new plyEdrapprdrStru("0");
                for (int j=0;j<fieldlen;j++){
                    fieldName = instrarr[0][j];
                    fieldValue= instrarr[i][j];
                    tempclass.getField(fieldName).set(tempobj,fieldValue);
                }
                outvctor.addElement(tempobj);
             }
//Added for debug
if (JCConstant.JTOC_DEBUGINFO){
    System.out.println("********************");
    DataUtility.dispVectorDtl(outvctor);
}
//End dubug



        }catch (Exception e){
             System.out.println ("Exception in:"+"SetOutputVctor");
             ErrorHandling(ExceptionCode.JC_GETPKHEADSTRARRAY_FAIL,e.toString());
        }

        return outvctor;



    }

////////////////////////////////////////////////////////
// String and Bytes Conversation
////////////////////////////////////////////////////////
  /**
   * Java Call C Kernal part goes here
   * @param  instr   the input c style string
   * @return                 String[]
   * @exception              com.mcip.orb.CoException
   */

    public String[] JavaCallC(String instr) throws com.mcip.orb.CoException{
        try{
            byte[] inbytes=SetInputByteArray(instr);
            int instrlen=inbytes.length;
//Added for debug
if (JCConstant.JTOC_DEBUGINFO){
   System.out.println("________________Java Send to C__________________");
   System.out.println("Before calling C Input String:"+instr);
   System.out.println("Before calling C Input Byte:"+inbytes);
   System.out.println("Before calling C Input Byte Length:"+instrlen);
   System.out.println("________________________________________________");
}
//End debug

//***********************************
//Java Call C Kernal part goes here *
//***********************************
            byte[] outbytes=(byte [])packetchanege(inbytes,instrlen);

            String[] outarray= BytestoStrArray(outbytes);
				for (int i=0;i<outarray.length ;i++ )
				{
					System.out.println("2001-10-30outarray["+i+"]:"+outarray[i]);
					System.out.println("JavaC:"+outarray[i].length());
				}
			System.out.println();


//Add for debug
if (JCConstant.JTOC_DEBUGINFO){
    System.out.println("________________Java Receive from C__________________");
    System.out.println("After calling C:");
    DataUtility.dispArray(outarray);
    System.out.println("_______________JtoC Output Completed_________");
}
//End debug
            return outarray;
       }catch (com.mcip.orb.CoException e) {
                throw e;
       }catch (Exception e){
             System.out.println ("Exception in:"+"JavaCallC");
             ErrorHandling(ExceptionCode.JC_JAVACALLC_ERROR,e.toString());
             return null;
       }
    }

////////////////////////////////////////////////////////
// Main Processing method use for common case
////////////////////////////////////////////////////////

  /**
   * Main Processing method use for common case
   * @return                 void
   * @exception              com.mcip.orb.CoException
   */

    public void JavaCMain() throws com.mcip.orb.CoException{
            String instr=getInputString();
            String[] outstr=JavaCallC(instr);
			System.out.println("outstr:["+outstr+"]");
            returnvctor=SetOutput(outstr);
            returnobj=returnvctor.elementAt(1);
    }


////////////////////////////////////////////////////////
// Main Processing method use for multi object output
////////////////////////////////////////////////////////

  /**
   * Main Processing method use for multi object output
   * @param  vctor   the input vector which stored input object
   * @return                 void
   * @exception              com.mcip.orb.CoException
   */

    public void JavaCMain(java.util.Vector vctor) throws com.mcip.orb.CoException{
            String instr=getInputString(vctor);
            String outstr[]=JavaCallC(instr);
		System.out.println("outstr value is>>>>>>>>>>>>>>>>>>>");
			for (int i=0; i<outstr.length;i++ )
			{
				System.out.println(outstr[i]);
			}
			System.out.println("instr value:"+instr);
			System.out.println("outstr value is<<<<<<<<<<<<<<<<<");
//for Accept policy
            if (in_packetid.equalsIgnoreCase(JCConstant.ACCEPTPOLICYAPP_PACKET_ID)){
               returnvctor=SetOutput(outstr,new plyAppPolyGridStru(),new plyProposalStru());
//for Update policy
            }else if (in_packetid.equalsIgnoreCase(JCConstant.UPDATEPOLICYAPP_PACKET_ID)){
               returnvctor=SetOutput(outstr,new plyAppPolyGridStru(),new plyProposalStru());
//for Confirm policy
            }else if (in_packetid.equalsIgnoreCase(JCConstant.CONFIRMPOLICYAPP_PACKET_ID)){
               returnvctor=SetOutput(outstr);
//for Withdrawal policy
            }else if (in_packetid.equalsIgnoreCase(JCConstant.WITHDRAWALPOLICYAPP_PACKET_ID)){
               returnvctor=SetOutput(outstr,new pkBodyInfoStru());
//for delete policy
            }else if (in_packetid.equalsIgnoreCase(JCConstant.DELETEPOLICYAPP_PACKET_ID)){
               returnvctor=SetOutput(outstr,new pkBodyInfoStru());
//for Get endorcement docu
            }else if (in_packetid.equalsIgnoreCase(JCConstant.GETPOLICYFOREDR_PACKET_ID)){
               returnvctor=SetOutput(outstr,
                  new com.mcip.nia.orb.PlyEdrAppInfo(),
                  new com.mcip.nia.orb.PlyEdrAppCrgoInfo(),
                  new plyEdrapprdrStru(),
                  new com.mcip.nia.orb.PlyEdrAppPayInfo(),
                  new com.mcip.nia.orb.PlyPlyAppNetInfo());
//For get edrappinfo for update endorsement
            }else if (in_packetid.equalsIgnoreCase(JCConstant.GETEDRAPPINFO_PACKET_ID )){
               returnvctor=SetOutput(outstr,
                  new com.mcip.nia.orb.PlyEdrAppInfo(),
                  new com.mcip.nia.orb.PlyEdrAppCrgoInfo(),
                  new plyEdrapprdrStru(),
                  new com.mcip.nia.orb.PlyEdrAppPayInfo(),
                  new com.mcip.nia.orb.PlyPlyAppNetInfo());
//for Add endorcement application
            }else if (in_packetid.equalsIgnoreCase(JCConstant.ADDPOLICYEDR_PACKET_ID)){
               returnvctor=SetOutput(outstr,new pkBodyInfoStru());
//for Withdrawal endorcement application
            }else if (in_packetid.equalsIgnoreCase(JCConstant.WITHDRAWALPLYFOREDR_PACKET_ID )){
               returnvctor=SetOutput(outstr,new pkBodyInfoStru());
//for Cancel or Delete endorcement application
            }else if (in_packetid.equalsIgnoreCase(JCConstant.DELETEPLYFOREDR_PACKET_ID )){
               returnvctor=SetOutput(outstr);
            }else {
               ErrorHandling(ExceptionCode.JC_ERROR_CASENO,"Input packetid:"+in_packetid+"in JavaCMain()");
            }
    }

////////////////////////////////////////////////////////
// Debug Code
////////////////////////////////////////////////////////

  /**
   * Debug Code:Display all public attributes of the obj
   * @param                  obj
   * @return                 void
   */

    public static void DisplayFields(Object obj){

        Class c =obj.getClass();
        Field[] publicFields =c.getFields();
        String fieldName =null;

            for (int i = 0; i < publicFields.length; i++) {
                try{
                    fieldName = publicFields[i].getName();
                    String fieldValue=(c.getField(fieldName).get(obj)).toString();
                    System.out.print(i+":"+fieldName+":\t"+fieldValue+"\n");
                }
                catch(Exception e){
                    e.printStackTrace();
                }
            }
    }


////////////////////////////////////////////////////////
// Debug Code
////////////////////////////////////////////////////////

  /**
   * Debug Code:Test the module
   * @param                  String[] args
   * @return                 void
   */

    public static void main(String[] args){
        try{

            PacketHead ph = new PacketHead(JCConstant.WITHDRAWALPLYFOREDR_PACKET_ID);
            plyEdrGridStru plyEdrGridObj=new plyEdrGridStru("0");

            JavaC jc=new JavaC(ph,plyEdrGridObj);
            jc.init("0");

            jc.JavaCMain(jc.GetInvctor());

            String[][]outrdr=jc.GetReturnRdr();

            jc.DisplayFields(jc.GetReturnvctor().elementAt(1));
        }catch(Exception e){
            e.printStackTrace();
        }
   }

}
