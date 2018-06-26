package com.mcip.nia.orb;
/**
<p>
<ul>
<li> <b>Java Class</b> com.mcip.nia.orb.PlyGetDocInfo
<li> <b>Source File</b> com/mcip/nia/orb/PlyGetDocInfo.java
<li> <b>IDL Source File</b> policyInfoStruct.idl
<li> <b>IDL Absolute Name</b> ::com::mcip::nia::orb::PlyGetDocInfo
<li> <b>Repository Identifier</b> IDL:com/mcip/nia/orb/PlyGetDocInfo:1.0
</ul>
<b>IDL definition:</b>
<pre>
    #pragma prefix "com/mcip/nia/orb"
    struct PlyGetDocInfo {
      wstring c_doc_no;
      string c_insrnc_cde;
      string c_prn_typ;
      wstring t_undr_tm;
    };
</pre>
</p>
*/
final public class PlyGetDocInfo {
  public java.lang.String c_doc_no;
  public java.lang.String c_insrnc_cde;
  public java.lang.String c_prn_typ;
  public java.lang.String t_undr_tm;
  public PlyGetDocInfo() {
  }
  public PlyGetDocInfo(
    java.lang.String c_doc_no,
    java.lang.String c_insrnc_cde,
    java.lang.String c_prn_typ,
    java.lang.String t_undr_tm
  ) {
    this.c_doc_no = c_doc_no;
    this.c_insrnc_cde = c_insrnc_cde;
    this.c_prn_typ = c_prn_typ;
    this.t_undr_tm = t_undr_tm;
  }
  public java.lang.String toString() {
    org.omg.CORBA.Any any = org.omg.CORBA.ORB.init().create_any();
    com.mcip.nia.orb.PlyGetDocInfoHelper.insert(any, this);
    return any.toString();
  }
}
