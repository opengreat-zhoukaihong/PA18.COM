package com.mcip.cus.orb;
/**
<p>
<ul>
<li> <b>Java Class</b> com.mcip.cus.orb.CustEntity
<li> <b>Source File</b> com/mcip/cus/orb/CustEntity.java
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
final public class CustEntity {
  public java.lang.String c_user_id;
  public java.lang.String c_user_name;
  public java.lang.String c_user_pw;
  public java.lang.String c_pw_question;
  public java.lang.String c_pw_result;
  public java.lang.String c_clnt_cde;
  public int n_user_seq_no;
  public char c_verify;
  public java.lang.String c_cmpny_agt_cde;
  public java.lang.String c_net_id;
  public CustEntity() {
  }
  public CustEntity(
    java.lang.String c_user_id,
    java.lang.String c_user_name,
    java.lang.String c_user_pw,
    java.lang.String c_pw_question,
    java.lang.String c_pw_result,
    java.lang.String c_clnt_cde,
    int n_user_seq_no,
    char c_verify,
    java.lang.String c_cmpny_agt_cde,
    java.lang.String c_net_id
  ) {
    this.c_user_id = c_user_id;
    this.c_user_name = c_user_name;
    this.c_user_pw = c_user_pw;
    this.c_pw_question = c_pw_question;
    this.c_pw_result = c_pw_result;
    this.c_clnt_cde = c_clnt_cde;
    this.n_user_seq_no = n_user_seq_no;
    this.c_verify = c_verify;
    this.c_cmpny_agt_cde = c_cmpny_agt_cde;
    this.c_net_id = c_net_id;
  }
  public java.lang.String toString() {
    org.omg.CORBA.Any any = org.omg.CORBA.ORB.init().create_any();
    com.mcip.cus.orb.CustEntityHelper.insert(any, this);
    return any.toString();
  }
}
