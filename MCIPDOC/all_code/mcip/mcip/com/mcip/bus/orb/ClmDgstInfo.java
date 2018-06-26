package com.mcip.bus.orb;
/**
<p>
<ul>
<li> <b>Java Class</b> com.mcip.bus.orb.ClmDgstInfo
<li> <b>Source File</b> com/mcip/bus/orb/ClmDgstInfo.java
<li> <b>IDL Source File</b> businessInfoStruct.idl
<li> <b>IDL Absolute Name</b> ::com::mcip::bus::orb::ClmDgstInfo
<li> <b>Repository Identifier</b> IDL:com/mcip/bus/orb/ClmDgstInfo:1.0
</ul>
<b>IDL definition:</b>
<pre>
    #pragma prefix "com/mcip/bus/orb"
    struct ClmDgstInfo {
      wstring c_ply_no;
      wstring c_rpt_no;
      wstring c_info_no;
      wstring c_digest;
      wstring c_content;
      string t_input_tm;
    };
</pre>
</p>
*/
final public class ClmDgstInfo {
  public java.lang.String c_ply_no;
  public java.lang.String c_rpt_no;
  public java.lang.String c_info_no;
  public java.lang.String c_digest;
  public java.lang.String c_content;
  public java.lang.String t_input_tm;
  public ClmDgstInfo() {
  }
  public ClmDgstInfo(
    java.lang.String c_ply_no,
    java.lang.String c_rpt_no,
    java.lang.String c_info_no,
    java.lang.String c_digest,
    java.lang.String c_content,
    java.lang.String t_input_tm
  ) {
    this.c_ply_no = c_ply_no;
    this.c_rpt_no = c_rpt_no;
    this.c_info_no = c_info_no;
    this.c_digest = c_digest;
    this.c_content = c_content;
    this.t_input_tm = t_input_tm;
  }
  public java.lang.String toString() {
    org.omg.CORBA.Any any = org.omg.CORBA.ORB.init().create_any();
    com.mcip.bus.orb.ClmDgstInfoHelper.insert(any, this);
    return any.toString();
  }
}
