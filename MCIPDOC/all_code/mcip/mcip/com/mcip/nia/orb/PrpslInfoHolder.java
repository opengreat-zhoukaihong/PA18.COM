package com.mcip.nia.orb;
/**
<p>
<ul>
<li> <b>Java Class</b> com.mcip.nia.orb.PrpslInfoHolder
<li> <b>Source File</b> com/mcip/nia/orb/PrpslInfoHolder.java
<li> <b>IDL Source File</b> policyInfoStruct.idl
<li> <b>IDL Absolute Name</b> ::com::mcip::nia::orb::PrpslInfo
<li> <b>Repository Identifier</b> IDL:com/mcip/nia/orb/PrpslInfo:1.0
</ul>
<b>IDL definition:</b>
<pre>
    #pragma prefix "com/mcip/nia/orb"
    struct PrpslInfo {
      string c_doc_no;
      double n_rate;
      wstring c_no_repay;
      wstring c_undr_cndtn;
      string t_send_tm;
      wstring c_send_desc;
      wstring c_undr_prsn;
      string t_sign_tm;
      string c_user_id;
      wstring c_remark;
      wstring c_user_remark;
    };
</pre>
</p>
*/
final public class PrpslInfoHolder implements org.omg.CORBA.portable.Streamable {
  public com.mcip.nia.orb.PrpslInfo value;
  public PrpslInfoHolder() {
  }
  public PrpslInfoHolder(com.mcip.nia.orb.PrpslInfo value) {
    this.value = value;
  }
  public void _read(org.omg.CORBA.portable.InputStream input) {
    value = com.mcip.nia.orb.PrpslInfoHelper.read(input);
  }
  public void _write(org.omg.CORBA.portable.OutputStream output) {
    com.mcip.nia.orb.PrpslInfoHelper.write(output, value);
  }
  public org.omg.CORBA.TypeCode _type() {
    return com.mcip.nia.orb.PrpslInfoHelper.type();
  }
}
