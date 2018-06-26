package com.mcip.bus.orb;
/**
<p>
<ul>
<li> <b>Java Class</b> com.mcip.bus.orb.InsrncFaqInfo
<li> <b>Source File</b> com/mcip/bus/orb/InsrncFaqInfo.java
<li> <b>IDL Source File</b> businessInfoStruct.idl
<li> <b>IDL Absolute Name</b> ::com::mcip::bus::orb::InsrncFaqInfo
<li> <b>Repository Identifier</b> IDL:com/mcip/bus/orb/InsrncFaqInfo:1.0
</ul>
<b>IDL definition:</b>
<pre>
    #pragma prefix "com/mcip/bus/orb"
    struct InsrncFaqInfo {
      wstring c_faq_no;
      wstring c_faq_emp;
      wstring c_faq_title;
      wstring c_faq_content;
      string t_faq_tm;
      wstring c_topic_no;
    };
</pre>
</p>
*/
final public class InsrncFaqInfo {
  public java.lang.String c_faq_no;
  public java.lang.String c_faq_emp;
  public java.lang.String c_faq_title;
  public java.lang.String c_faq_content;
  public java.lang.String t_faq_tm;
  public java.lang.String c_topic_no;
  public InsrncFaqInfo() {
  }
  public InsrncFaqInfo(
    java.lang.String c_faq_no,
    java.lang.String c_faq_emp,
    java.lang.String c_faq_title,
    java.lang.String c_faq_content,
    java.lang.String t_faq_tm,
    java.lang.String c_topic_no
  ) {
    this.c_faq_no = c_faq_no;
    this.c_faq_emp = c_faq_emp;
    this.c_faq_title = c_faq_title;
    this.c_faq_content = c_faq_content;
    this.t_faq_tm = t_faq_tm;
    this.c_topic_no = c_topic_no;
  }
  public java.lang.String toString() {
    org.omg.CORBA.Any any = org.omg.CORBA.ORB.init().create_any();
    com.mcip.bus.orb.InsrncFaqInfoHelper.insert(any, this);
    return any.toString();
  }
}
