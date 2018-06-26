package com.mcip.bus.orb;
/**
<p>
<ul>
<li> <b>Java Class</b> com.mcip.bus.orb.PagesInfo
<li> <b>Source File</b> com/mcip/bus/orb/PagesInfo.java
<li> <b>IDL Source File</b> businessInfoStruct.idl
<li> <b>IDL Absolute Name</b> ::com::mcip::bus::orb::PagesInfo
<li> <b>Repository Identifier</b> IDL:com/mcip/bus/orb/PagesInfo:1.0
</ul>
<b>IDL definition:</b>
<pre>
    #pragma prefix "com/mcip/bus/orb"
    struct PagesInfo {
      string c_page_no;
      wstring c_page_title;
      wstring c_file_enm;
      string c_func_cde;
      string t_edit_tm;
    };
</pre>
</p>
*/
final public class PagesInfo {
  public java.lang.String c_page_no;
  public java.lang.String c_page_title;
  public java.lang.String c_file_enm;
  public java.lang.String c_func_cde;
  public java.lang.String t_edit_tm;
  public PagesInfo() {
  }
  public PagesInfo(
    java.lang.String c_page_no,
    java.lang.String c_page_title,
    java.lang.String c_file_enm,
    java.lang.String c_func_cde,
    java.lang.String t_edit_tm
  ) {
    this.c_page_no = c_page_no;
    this.c_page_title = c_page_title;
    this.c_file_enm = c_file_enm;
    this.c_func_cde = c_func_cde;
    this.t_edit_tm = t_edit_tm;
  }
  public java.lang.String toString() {
    org.omg.CORBA.Any any = org.omg.CORBA.ORB.init().create_any();
    com.mcip.bus.orb.PagesInfoHelper.insert(any, this);
    return any.toString();
  }
}
