package com.mcip.cus.orb;
/**
<p>
<ul>
<li> <b>Java Class</b> com.mcip.cus.orb.CustEntityHolder
<li> <b>Source File</b> com/mcip/cus/orb/CustEntityHolder.java
<li> <b>IDL Source File</b> custInfoStruct.idl
<li> <b>IDL Absolute Name</b> ::com::mcip::cus::orb::CustEntity
<li> <b>Repository Identifier</b> IDL:com/mcip/cus/orb/CustEntity:1.0
</ul>
<b>IDL definition:</b>
<pre>
    #pragma prefix "com/mcip/cus/orb"
    struct CustEntity {
      wstring c_user_id;
      wstring c_user_name;
      string c_user_pw;
      wstring c_pw_question;
      wstring c_pw_result;
      string c_clnt_cde;
      long n_user_seq_no;
      char c_verify;
      string c_cmpny_agt_cde;
      string c_net_id;
    };
</pre>
</p>
*/
final public class CustEntityHolder implements org.omg.CORBA.portable.Streamable {
  public com.mcip.cus.orb.CustEntity value;
  public CustEntityHolder() {
  }
  public CustEntityHolder(com.mcip.cus.orb.CustEntity value) {
    this.value = value;
  }
  public void _read(org.omg.CORBA.portable.InputStream input) {
    value = com.mcip.cus.orb.CustEntityHelper.read(input);
  }
  public void _write(org.omg.CORBA.portable.OutputStream output) {
    com.mcip.cus.orb.CustEntityHelper.write(output, value);
  }
  public org.omg.CORBA.TypeCode _type() {
    return com.mcip.cus.orb.CustEntityHelper.type();
  }
}
