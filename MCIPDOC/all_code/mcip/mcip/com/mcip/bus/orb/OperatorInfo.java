package com.mcip.bus.orb;
/**
<p>
<ul>
<li> <b>Java Class</b> com.mcip.bus.orb.OperatorInfo
<li> <b>Source File</b> com/mcip/bus/orb/OperatorInfo.java
<li> <b>IDL Source File</b> businessInfoStruct.idl
<li> <b>IDL Absolute Name</b> ::com::mcip::bus::orb::OperatorInfo
<li> <b>Repository Identifier</b> IDL:com/mcip/bus/orb/OperatorInfo:1.0
</ul>
<b>IDL definition:</b>
<pre>
    #pragma prefix "com/mcip/bus/orb"
    struct OperatorInfo {
      wstring c_opr_cde;
      string c_opr_pw;
      string c_emp_cde;
      string c_dpt_cde;
      wstring c_acredt_cde;
      string c_sys_admin;
    };
</pre>
</p>
*/
final public class OperatorInfo {
  public java.lang.String c_opr_cde;
  public java.lang.String c_opr_pw;
  public java.lang.String c_emp_cde;
  public java.lang.String c_dpt_cde;
  public java.lang.String c_acredt_cde;
  public java.lang.String c_sys_admin;
  public OperatorInfo() {
  }
  public OperatorInfo(
    java.lang.String c_opr_cde,
    java.lang.String c_opr_pw,
    java.lang.String c_emp_cde,
    java.lang.String c_dpt_cde,
    java.lang.String c_acredt_cde,
    java.lang.String c_sys_admin
  ) {
    this.c_opr_cde = c_opr_cde;
    this.c_opr_pw = c_opr_pw;
    this.c_emp_cde = c_emp_cde;
    this.c_dpt_cde = c_dpt_cde;
    this.c_acredt_cde = c_acredt_cde;
    this.c_sys_admin = c_sys_admin;
  }
  public java.lang.String toString() {
    org.omg.CORBA.Any any = org.omg.CORBA.ORB.init().create_any();
    com.mcip.bus.orb.OperatorInfoHelper.insert(any, this);
    return any.toString();
  }
}
