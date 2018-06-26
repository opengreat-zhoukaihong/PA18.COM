package com.mcip.nia.orb;
/**
<p>
<ul>
<li> <b>Java Class</b> com.mcip.nia.orb.PlcyAppList
<li> <b>Source File</b> com/mcip/nia/orb/PlcyAppList.java
<li> <b>IDL Source File</b> policyInfoStruct.idl
<li> <b>IDL Absolute Name</b> ::com::mcip::nia::orb::PlcyAppList
<li> <b>Repository Identifier</b> IDL:com/mcip/nia/orb/PlcyAppList:1.0
</ul>
<b>IDL definition:</b>
<pre>
    #pragma prefix "com/mcip/nia/orb"
    struct PlcyAppList {
      string c_ply_app_no;
      string c_ply_no;
      string c_insrnc_cde;
      wstring c_insrnc_cnm;
      double n_amt;
      string c_amt_cur;
      string c_crgo_cde;
      wstring c_cdgo_desc;
      string c_frm_prt_ara;
      wstring c_frm_prt_ara_cnm;
      wstring c_from_prt;
      string c_to_prt_ara;
      wstring c_to_prt_ara_cnm;
      wstring c_to_prt;
      string c_carriage_cde;
      wstring c_carriage_cnm;
    };
</pre>
</p>
*/
final public class PlcyAppList {
  public java.lang.String c_ply_app_no;
  public java.lang.String c_ply_no;
  public java.lang.String c_insrnc_cde;
  public java.lang.String c_insrnc_cnm;
  public double n_amt;
  public java.lang.String c_amt_cur;
  public java.lang.String c_crgo_cde;
  public java.lang.String c_cdgo_desc;
  public java.lang.String c_frm_prt_ara;
  public java.lang.String c_frm_prt_ara_cnm;
  public java.lang.String c_from_prt;
  public java.lang.String c_to_prt_ara;
  public java.lang.String c_to_prt_ara_cnm;
  public java.lang.String c_to_prt;
  public java.lang.String c_carriage_cde;
  public java.lang.String c_carriage_cnm;
  public PlcyAppList() {
  }
  public PlcyAppList(
    java.lang.String c_ply_app_no,
    java.lang.String c_ply_no,
    java.lang.String c_insrnc_cde,
    java.lang.String c_insrnc_cnm,
    double n_amt,
    java.lang.String c_amt_cur,
    java.lang.String c_crgo_cde,
    java.lang.String c_cdgo_desc,
    java.lang.String c_frm_prt_ara,
    java.lang.String c_frm_prt_ara_cnm,
    java.lang.String c_from_prt,
    java.lang.String c_to_prt_ara,
    java.lang.String c_to_prt_ara_cnm,
    java.lang.String c_to_prt,
    java.lang.String c_carriage_cde,
    java.lang.String c_carriage_cnm
  ) {
    this.c_ply_app_no = c_ply_app_no;
    this.c_ply_no = c_ply_no;
    this.c_insrnc_cde = c_insrnc_cde;
    this.c_insrnc_cnm = c_insrnc_cnm;
    this.n_amt = n_amt;
    this.c_amt_cur = c_amt_cur;
    this.c_crgo_cde = c_crgo_cde;
    this.c_cdgo_desc = c_cdgo_desc;
    this.c_frm_prt_ara = c_frm_prt_ara;
    this.c_frm_prt_ara_cnm = c_frm_prt_ara_cnm;
    this.c_from_prt = c_from_prt;
    this.c_to_prt_ara = c_to_prt_ara;
    this.c_to_prt_ara_cnm = c_to_prt_ara_cnm;
    this.c_to_prt = c_to_prt;
    this.c_carriage_cde = c_carriage_cde;
    this.c_carriage_cnm = c_carriage_cnm;
  }
  public java.lang.String toString() {
    org.omg.CORBA.Any any = org.omg.CORBA.ORB.init().create_any();
    com.mcip.nia.orb.PlcyAppListHelper.insert(any, this);
    return any.toString();
  }
}
