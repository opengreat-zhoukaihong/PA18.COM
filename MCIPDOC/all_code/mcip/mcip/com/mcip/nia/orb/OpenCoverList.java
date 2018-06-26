package com.mcip.nia.orb;
/**
<p>
<ul>
<li> <b>Java Class</b> com.mcip.nia.orb.OpenCoverList
<li> <b>Source File</b> com/mcip/nia/orb/OpenCoverList.java
<li> <b>IDL Source File</b> policyInfoStruct.idl
<li> <b>IDL Absolute Name</b> ::com::mcip::nia::orb::OpenCoverList
<li> <b>Repository Identifier</b> IDL:com/mcip/nia/orb/OpenCoverList:1.0
</ul>
<b>IDL definition:</b>
<pre>
    #pragma prefix "com/mcip/nia/orb"
    struct OpenCoverList {
      string c_open_cover_no;
      wstring c_crgo_name;
      string c_insrnc_cde;
      wstring c_insrnc_cnm;
      string c_frm_prt_ara;
      wstring c_frm_prt_ara_cnm;
      string c_to_prt_ara;
      wstring c_to_prt_ara_cnm;
      wstring c_from_prt;
      wstring c_to_prt;
    };
</pre>
</p>
*/
final public class OpenCoverList {
  public java.lang.String c_open_cover_no;
  public java.lang.String c_crgo_name;
  public java.lang.String c_insrnc_cde;
  public java.lang.String c_insrnc_cnm;
  public java.lang.String c_frm_prt_ara;
  public java.lang.String c_frm_prt_ara_cnm;
  public java.lang.String c_to_prt_ara;
  public java.lang.String c_to_prt_ara_cnm;
  public java.lang.String c_from_prt;
  public java.lang.String c_to_prt;
  public OpenCoverList() {
  }
  public OpenCoverList(
    java.lang.String c_open_cover_no,
    java.lang.String c_crgo_name,
    java.lang.String c_insrnc_cde,
    java.lang.String c_insrnc_cnm,
    java.lang.String c_frm_prt_ara,
    java.lang.String c_frm_prt_ara_cnm,
    java.lang.String c_to_prt_ara,
    java.lang.String c_to_prt_ara_cnm,
    java.lang.String c_from_prt,
    java.lang.String c_to_prt
  ) {
    this.c_open_cover_no = c_open_cover_no;
    this.c_crgo_name = c_crgo_name;
    this.c_insrnc_cde = c_insrnc_cde;
    this.c_insrnc_cnm = c_insrnc_cnm;
    this.c_frm_prt_ara = c_frm_prt_ara;
    this.c_frm_prt_ara_cnm = c_frm_prt_ara_cnm;
    this.c_to_prt_ara = c_to_prt_ara;
    this.c_to_prt_ara_cnm = c_to_prt_ara_cnm;
    this.c_from_prt = c_from_prt;
    this.c_to_prt = c_to_prt;
  }
  public java.lang.String toString() {
    org.omg.CORBA.Any any = org.omg.CORBA.ORB.init().create_any();
    com.mcip.nia.orb.OpenCoverListHelper.insert(any, this);
    return any.toString();
  }
}
