package com.mcip.bus.orb;
/**
<p>
<ul>
<li> <b>Java Class</b> com.mcip.bus.orb.SysFuncInfo
<li> <b>Source File</b> com/mcip/bus/orb/SysFuncInfo.java
<li> <b>IDL Source File</b> businessInfoStruct.idl
<li> <b>IDL Absolute Name</b> ::com::mcip::bus::orb::SysFuncInfo
<li> <b>Repository Identifier</b> IDL:com/mcip/bus/orb/SysFuncInfo:1.0
</ul>
<b>IDL definition:</b>
<pre>
    #pragma prefix "com/mcip/bus/orb"
    struct SysFuncInfo {
      string c_func_cde;
      wstring c_func_cnm;
      wstring c_func_enm;
    };
</pre>
</p>
*/
final public class SysFuncInfo {
  public java.lang.String c_func_cde;
  public java.lang.String c_func_cnm;
  public java.lang.String c_func_enm;
  public SysFuncInfo() {
  }
  public SysFuncInfo(
    java.lang.String c_func_cde,
    java.lang.String c_func_cnm,
    java.lang.String c_func_enm
  ) {
    this.c_func_cde = c_func_cde;
    this.c_func_cnm = c_func_cnm;
    this.c_func_enm = c_func_enm;
  }
  public java.lang.String toString() {
    org.omg.CORBA.Any any = org.omg.CORBA.ORB.init().create_any();
    com.mcip.bus.orb.SysFuncInfoHelper.insert(any, this);
    return any.toString();
  }
}
