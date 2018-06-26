package com.mcip.bus.orb;
/**
<p>
<ul>
<li> <b>Java Class</b> com.mcip.bus.orb.OprAuthInfo
<li> <b>Source File</b> com/mcip/bus/orb/OprAuthInfo.java
<li> <b>IDL Source File</b> businessInfoStruct.idl
<li> <b>IDL Absolute Name</b> ::com::mcip::bus::orb::OprAuthInfo
<li> <b>Repository Identifier</b> IDL:com/mcip/bus/orb/OprAuthInfo:1.0
</ul>
<b>IDL definition:</b>
<pre>
    #pragma prefix "com/mcip/bus/orb"
    struct OprAuthInfo {
      string c_opr_cde;
      string c_func_cde;
    };
</pre>
</p>
*/
final public class OprAuthInfo {
  public java.lang.String c_opr_cde;
  public java.lang.String c_func_cde;
  public OprAuthInfo() {
  }
  public OprAuthInfo(
    java.lang.String c_opr_cde,
    java.lang.String c_func_cde
  ) {
    this.c_opr_cde = c_opr_cde;
    this.c_func_cde = c_func_cde;
  }
  public java.lang.String toString() {
    org.omg.CORBA.Any any = org.omg.CORBA.ORB.init().create_any();
    com.mcip.bus.orb.OprAuthInfoHelper.insert(any, this);
    return any.toString();
  }
}
