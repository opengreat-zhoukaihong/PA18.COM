package com.mcip.bus.orb;
/**
<p>
<ul>
<li> <b>Java Class</b> com.mcip.bus.orb.InsrncGuideInfo
<li> <b>Source File</b> com/mcip/bus/orb/InsrncGuideInfo.java
<li> <b>IDL Source File</b> businessInfoStruct.idl
<li> <b>IDL Absolute Name</b> ::com::mcip::bus::orb::InsrncGuideInfo
<li> <b>Repository Identifier</b> IDL:com/mcip/bus/orb/InsrncGuideInfo:1.0
</ul>
<b>IDL definition:</b>
<pre>
    #pragma prefix "com/mcip/bus/orb"
    struct InsrncGuideInfo {
      wstring c_info_no;
      wstring c_title_no;
      wstring c_title_cnm;
      wstring c_title_enm;
      wstring c_content_cnm;
      wstring c_content_enm;
      string t_crt_tm;
    };
</pre>
</p>
*/
final public class InsrncGuideInfo {
  public java.lang.String c_info_no;
  public java.lang.String c_title_no;
  public java.lang.String c_title_cnm;
  public java.lang.String c_title_enm;
  public java.lang.String c_content_cnm;
  public java.lang.String c_content_enm;
  public java.lang.String t_crt_tm;
  public InsrncGuideInfo() {
  }
  public InsrncGuideInfo(
    java.lang.String c_info_no,
    java.lang.String c_title_no,
    java.lang.String c_title_cnm,
    java.lang.String c_title_enm,
    java.lang.String c_content_cnm,
    java.lang.String c_content_enm,
    java.lang.String t_crt_tm
  ) {
    this.c_info_no = c_info_no;
    this.c_title_no = c_title_no;
    this.c_title_cnm = c_title_cnm;
    this.c_title_enm = c_title_enm;
    this.c_content_cnm = c_content_cnm;
    this.c_content_enm = c_content_enm;
    this.t_crt_tm = t_crt_tm;
  }
  public java.lang.String toString() {
    org.omg.CORBA.Any any = org.omg.CORBA.ORB.init().create_any();
    com.mcip.bus.orb.InsrncGuideInfoHelper.insert(any, this);
    return any.toString();
  }
}
