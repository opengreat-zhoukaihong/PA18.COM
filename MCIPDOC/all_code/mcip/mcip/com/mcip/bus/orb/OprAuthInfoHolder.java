package com.mcip.bus.orb;
/**
<p>
<ul>
<li> <b>Java Class</b> com.mcip.bus.orb.OprAuthInfoHolder
<li> <b>Source File</b> com/mcip/bus/orb/OprAuthInfoHolder.java
<li> <b>IDL Source File</b> businessInfoStruct.idl
<li> <b>IDL Absolute Name</b> ::com::mcip::bus::orb::OprAuthInfo
<li> <b>Repository Identifier</b> IDL:com/mcip/bus/orb/OprAuthInfo:1.0
</ul>
<b>IDL definition:</b>
<pre>
    #pragma prefix "com/mcip/bus/orb"
    struct OprAuthInfo {
      string c_opr_cde;
      string c_func_cde;
    };
</pre>
</p>
*/
final public class OprAuthInfoHolder implements org.omg.CORBA.portable.Streamable {
  public com.mcip.bus.orb.OprAuthInfo value;
  public OprAuthInfoHolder() {
  }
  public OprAuthInfoHolder(com.mcip.bus.orb.OprAuthInfo value) {
    this.value = value;
  }
  public void _read(org.omg.CORBA.portable.InputStream input) {
    value = com.mcip.bus.orb.OprAuthInfoHelper.read(input);
  }
  public void _write(org.omg.CORBA.portable.OutputStream output) {
    com.mcip.bus.orb.OprAuthInfoHelper.write(output, value);
  }
  public org.omg.CORBA.TypeCode _type() {
    return com.mcip.bus.orb.OprAuthInfoHelper.type();
  }
}
