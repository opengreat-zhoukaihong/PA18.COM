package com.mcip.bus.orb;
/**
<p>
<ul>
<li> <b>Java Class</b> com.mcip.bus.orb.CustFaqInfoHolder
<li> <b>Source File</b> com/mcip/bus/orb/CustFaqInfoHolder.java
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
final public class CustFaqInfoHolder implements org.omg.CORBA.portable.Streamable {
  public com.mcip.bus.orb.CustFaqInfo value;
  public CustFaqInfoHolder() {
  }
  public CustFaqInfoHolder(com.mcip.bus.orb.CustFaqInfo value) {
    this.value = value;
  }
  public void _read(org.omg.CORBA.portable.InputStream input) {
    value = com.mcip.bus.orb.CustFaqInfoHelper.read(input);
  }
  public void _write(org.omg.CORBA.portable.OutputStream output) {
    com.mcip.bus.orb.CustFaqInfoHelper.write(output, value);
  }
  public org.omg.CORBA.TypeCode _type() {
    return com.mcip.bus.orb.CustFaqInfoHelper.type();
  }
}
