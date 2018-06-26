package com.mcip.bus.orb;
/**
<p>
<ul>
<li> <b>Java Class</b> com.mcip.bus.orb.InsrncFaqInfoHolder
<li> <b>Source File</b> com/mcip/bus/orb/InsrncFaqInfoHolder.java
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
final public class InsrncFaqInfoHolder implements org.omg.CORBA.portable.Streamable {
  public com.mcip.bus.orb.InsrncFaqInfo value;
  public InsrncFaqInfoHolder() {
  }
  public InsrncFaqInfoHolder(com.mcip.bus.orb.InsrncFaqInfo value) {
    this.value = value;
  }
  public void _read(org.omg.CORBA.portable.InputStream input) {
    value = com.mcip.bus.orb.InsrncFaqInfoHelper.read(input);
  }
  public void _write(org.omg.CORBA.portable.OutputStream output) {
    com.mcip.bus.orb.InsrncFaqInfoHelper.write(output, value);
  }
  public org.omg.CORBA.TypeCode _type() {
    return com.mcip.bus.orb.InsrncFaqInfoHelper.type();
  }
}
