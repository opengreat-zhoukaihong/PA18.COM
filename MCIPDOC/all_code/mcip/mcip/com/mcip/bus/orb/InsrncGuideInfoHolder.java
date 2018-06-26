package com.mcip.bus.orb;
/**
<p>
<ul>
<li> <b>Java Class</b> com.mcip.bus.orb.InsrncGuideInfoHolder
<li> <b>Source File</b> com/mcip/bus/orb/InsrncGuideInfoHolder.java
<li> <b>IDL Source File</b> businessInfoStruct.idl
<li> <b>IDL Absolute Name</b> ::com::mcip::bus::orb::InsrncGuideInfo
<li> <b>Repository Identifier</b> IDL:com/mcip/bus/orb/InsrncGuideInfo:1.0
</ul>
<b>IDL definition:</b>
<pre>
    #pragma prefix "com/mcip/bus/orb"
    struct InsrncGuideInfo {
      wstring c_info_no;
      wstring c_title_no;
      wstring c_title_cnm;
      wstring c_title_enm;
      wstring c_content_cnm;
      wstring c_content_enm;
      string t_crt_tm;
    };
</pre>
</p>
*/
final public class InsrncGuideInfoHolder implements org.omg.CORBA.portable.Streamable {
  public com.mcip.bus.orb.InsrncGuideInfo value;
  public InsrncGuideInfoHolder() {
  }
  public InsrncGuideInfoHolder(com.mcip.bus.orb.InsrncGuideInfo value) {
    this.value = value;
  }
  public void _read(org.omg.CORBA.portable.InputStream input) {
    value = com.mcip.bus.orb.InsrncGuideInfoHelper.read(input);
  }
  public void _write(org.omg.CORBA.portable.OutputStream output) {
    com.mcip.bus.orb.InsrncGuideInfoHelper.write(output, value);
  }
  public org.omg.CORBA.TypeCode _type() {
    return com.mcip.bus.orb.InsrncGuideInfoHelper.type();
  }
}
