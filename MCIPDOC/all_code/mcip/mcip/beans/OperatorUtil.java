package beans;

import java.io.*;
import constant.*;
import com.mcip.bus.orb.*;
public class OperatorUtil {

  //public static
  public static OperatorInfo getOperatorInfoInstance(String infoStrings[]){
       OperatorInfo   info =  new OperatorInfo(
                       infoStrings[TabOperatorInfo.c_opr_cde],
                       infoStrings[TabOperatorInfo.c_opr_pw],
                       infoStrings[TabOperatorInfo.c_emp_cde],
                       infoStrings[TabOperatorInfo.c_dpt_cde],
                       infoStrings[TabOperatorInfo.c_acredt_cde],
                       infoStrings[TabOperatorInfo.c_sysadm_mrk]);
       return info;

  }

  public static OprAuthInfo getOprAuthInfoInstance(String c_opr_cde, String c_func_cde){
       return new OprAuthInfo(c_opr_cde, c_func_cde);
  }

  public static OprDptInfo getOprDptInfoInstance(String c_opr_cde, String c_dpt_cde){
    return new OprDptInfo(c_opr_cde, c_dpt_cde);
  }

}