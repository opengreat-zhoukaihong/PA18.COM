package com.mcip.nia.orb;
/**
<p>
<ul>
<li> <b>Java Class</b> com.mcip.nia.orb.AgncCntrList
<li> <b>Source File</b> com/mcip/nia/orb/AgncCntrList.java
<li> <b>IDL Source File</b> policyInfoStruct.idl
<li> <b>IDL Absolute Name</b> ::com::mcip::nia::orb::AgncCntrList
<li> <b>Repository Identifier</b> IDL:com/mcip/nia/orb/AgncCntrList:1.0
</ul>
<b>IDL definition:</b>
<pre>
    #pragma prefix "com/mcip/nia/orb"
    struct AgncCntrList {
      string c_agt_agr_no;
      long n_sub_co_no;
      string c_insrnc_cde;
      wstring c_insrnc_cnm;
      string c_crgo_cde;
      wstring c_crgo_cnm;
    };
</pre>
</p>
*/
final public class AgncCntrList {
  public java.lang.String c_agt_agr_no;
  public int n_sub_co_no;
  public java.lang.String c_insrnc_cde;
  public java.lang.String c_insrnc_cnm;
  public java.lang.String c_crgo_cde;
  public java.lang.String c_crgo_cnm;
  public AgncCntrList() {
  }
  public AgncCntrList(
    java.lang.String c_agt_agr_no,
    int n_sub_co_no,
    java.lang.String c_insrnc_cde,
    java.lang.String c_insrnc_cnm,
    java.lang.String c_crgo_cde,
    java.lang.String c_crgo_cnm
  ) {
    this.c_agt_agr_no = c_agt_agr_no;
    this.n_sub_co_no = n_sub_co_no;
    this.c_insrnc_cde = c_insrnc_cde;
    this.c_insrnc_cnm = c_insrnc_cnm;
    this.c_crgo_cde = c_crgo_cde;
    this.c_crgo_cnm = c_crgo_cnm;
  }
  public java.lang.String toString() {
    org.omg.CORBA.Any any = org.omg.CORBA.ORB.init().create_any();
    com.mcip.nia.orb.AgncCntrListHelper.insert(any, this);
    return any.toString();
  }
}
