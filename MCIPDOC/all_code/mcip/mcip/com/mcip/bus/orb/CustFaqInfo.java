package com.mcip.bus.orb;
/**
<p>
<ul>
<li> <b>Java Class</b> com.mcip.bus.orb.CustFaqInfo
<li> <b>Source File</b> com/mcip/bus/orb/CustFaqInfo.java
<li> <b>IDL Source File</b> businessInfoStruct.idl
<li> <b>IDL Absolute Name</b> ::com::mcip::bus::orb::CustFaqInfo
<li> <b>Repository Identifier</b> IDL:com/mcip/bus/orb/CustFaqInfo:1.0
</ul>
<b>IDL definition:</b>
<pre>
    #pragma prefix "com/mcip/bus/orb"
    struct CustFaqInfo {
      wstring c_faq_no;
      wstring c_faq_psn;
      wstring c_faq_email;
      wstring c_faq_title;
      wstring c_faq_content;
      string t_faq_tm;
      wstring c_reply_cont;
      wstring c_reply_emp;
      string t_reply_tm;
    };
</pre>
</p>
*/
final public class CustFaqInfo {
  public java.lang.String c_faq_no;
  public java.lang.String c_faq_psn;
  public java.lang.String c_faq_email;
  public java.lang.String c_faq_title;
  public java.lang.String c_faq_content;
  public java.lang.String t_faq_tm;
  public java.lang.String c_reply_cont;
  public java.lang.String c_reply_emp;
  public java.lang.String t_reply_tm;
  public CustFaqInfo() {
  }
  public CustFaqInfo(
    java.lang.String c_faq_no,
    java.lang.String c_faq_psn,
    java.lang.String c_faq_email,
    java.lang.String c_faq_title,
    java.lang.String c_faq_content,
    java.lang.String t_faq_tm,
    java.lang.String c_reply_cont,
    java.lang.String c_reply_emp,
    java.lang.String t_reply_tm
  ) {
    this.c_faq_no = c_faq_no;
    this.c_faq_psn = c_faq_psn;
    this.c_faq_email = c_faq_email;
    this.c_faq_title = c_faq_title;
    this.c_faq_content = c_faq_content;
    this.t_faq_tm = t_faq_tm;
    this.c_reply_cont = c_reply_cont;
    this.c_reply_emp = c_reply_emp;
    this.t_reply_tm = t_reply_tm;
  }
  public java.lang.String toString() {
    org.omg.CORBA.Any any = org.omg.CORBA.ORB.init().create_any();
    com.mcip.bus.orb.CustFaqInfoHelper.insert(any, this);
    return any.toString();
  }
}
