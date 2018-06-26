package com.mcip.nia.orb;
/**
<p>
<ul>
<li> <b>Java Class</b> com.mcip.nia.orb.QuotaCndtn
<li> <b>Source File</b> com/mcip/nia/orb/QuotaCndtn.java
<li> <b>IDL Source File</b> policyInfoStruct.idl
<li> <b>IDL Absolute Name</b> ::com::mcip::nia::orb::QuotaCndtn
<li> <b>Repository Identifier</b> IDL:com/mcip/nia/orb/QuotaCndtn:1.0
</ul>
<b>IDL definition:</b>
<pre>
    #pragma prefix "com/mcip/nia/orb"
    struct QuotaCndtn {
      string c_dpt_cde;
      string c_insrnc_cde;
      string c_rdr_cde;
      string c_crgo_cls;
      string c_crgo_cde;
      string c_pack_cde;
      string c_carriage_cde;
      string c_frm_prt_ara;
      string c_to_prt_ara;
      string n_rate;
      wstring c_nclm_desc;
    };
</pre>
</p>
*/
final public class QuotaCndtn {
  public java.lang.String c_dpt_cde;
  public java.lang.String c_insrnc_cde;
  public java.lang.String c_rdr_cde;
  public java.lang.String c_crgo_cls;
  public java.lang.String c_crgo_cde;
  public java.lang.String c_pack_cde;
  public java.lang.String c_carriage_cde;
  public java.lang.String c_frm_prt_ara;
  public java.lang.String c_to_prt_ara;
  public java.lang.String n_rate;
  public java.lang.String c_nclm_desc;
  public QuotaCndtn() {
  }
  public QuotaCndtn(
    java.lang.String c_dpt_cde,
    java.lang.String c_insrnc_cde,
    java.lang.String c_rdr_cde,
    java.lang.String c_crgo_cls,
    java.lang.String c_crgo_cde,
    java.lang.String c_pack_cde,
    java.lang.String c_carriage_cde,
    java.lang.String c_frm_prt_ara,
    java.lang.String c_to_prt_ara,
    java.lang.String n_rate,
    java.lang.String c_nclm_desc
  ) {
    this.c_dpt_cde = c_dpt_cde;
    this.c_insrnc_cde = c_insrnc_cde;
    this.c_rdr_cde = c_rdr_cde;
    this.c_crgo_cls = c_crgo_cls;
    this.c_crgo_cde = c_crgo_cde;
    this.c_pack_cde = c_pack_cde;
    this.c_carriage_cde = c_carriage_cde;
    this.c_frm_prt_ara = c_frm_prt_ara;
    this.c_to_prt_ara = c_to_prt_ara;
    this.n_rate = n_rate;
    this.c_nclm_desc = c_nclm_desc;
  }
  public java.lang.String toString() {
    org.omg.CORBA.Any any = org.omg.CORBA.ORB.init().create_any();
    com.mcip.nia.orb.QuotaCndtnHelper.insert(any, this);
    return any.toString();
  }
}
