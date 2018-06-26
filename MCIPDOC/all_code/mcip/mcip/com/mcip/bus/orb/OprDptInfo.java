package com.mcip.bus.orb;
/**
<p>
<ul>
<li> <b>Java Class</b> com.mcip.bus.orb.OprDptInfo
<li> <b>Source File</b> com/mcip/bus/orb/OprDptInfo.java
<li> <b>IDL Source File</b> businessInfoStruct.idl
<li> <b>IDL Absolute Name</b> ::com::mcip::bus::orb::OprDptInfo
<li> <b>Repository Identifier</b> IDL:com/mcip/bus/orb/OprDptInfo:1.0
</ul>
<b>IDL definition:</b>
<pre>
    #pragma prefix "com/mcip/bus/orb"
    struct OprDptInfo {
      string c_opr_cde;
      string c_dpt_cde;
    };
</pre>
</p>
*/
final public class OprDptInfo {
  public java.lang.String c_opr_cde;
  public java.lang.String c_dpt_cde;
  public OprDptInfo() {
  }
  public OprDptInfo(
    java.lang.String c_opr_cde,
    java.lang.String c_dpt_cde
  ) {
    this.c_opr_cde = c_opr_cde;
    this.c_dpt_cde = c_dpt_cde;
  }
  public java.lang.String toString() {
    org.omg.CORBA.Any any = org.omg.CORBA.ORB.init().create_any();
    com.mcip.bus.orb.OprDptInfoHelper.insert(any, this);
    return any.toString();
  }
}
