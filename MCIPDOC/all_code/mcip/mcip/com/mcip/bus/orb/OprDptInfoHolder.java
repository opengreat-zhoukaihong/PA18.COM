package com.mcip.bus.orb;
/**
<p>
<ul>
<li> <b>Java Class</b> com.mcip.bus.orb.OprDptInfoHolder
<li> <b>Source File</b> com/mcip/bus/orb/OprDptInfoHolder.java
<li> <b>IDL Source File</b> businessInfoStruct.idl
<li> <b>IDL Absolute Name</b> ::com::mcip::bus::orb::OprDptInfo
<li> <b>Repository Identifier</b> IDL:com/mcip/bus/orb/OprDptInfo:1.0
</ul>
<b>IDL definition:</b>
<pre>
    #pragma prefix "com/mcip/bus/orb"
    struct OprDptInfo {
      string c_opr_cde;
      string c_dpt_cde;
    };
</pre>
</p>
*/
final public class OprDptInfoHolder implements org.omg.CORBA.portable.Streamable {
  public com.mcip.bus.orb.OprDptInfo value;
  public OprDptInfoHolder() {
  }
  public OprDptInfoHolder(com.mcip.bus.orb.OprDptInfo value) {
    this.value = value;
  }
  public void _read(org.omg.CORBA.portable.InputStream input) {
    value = com.mcip.bus.orb.OprDptInfoHelper.read(input);
  }
  public void _write(org.omg.CORBA.portable.OutputStream output) {
    com.mcip.bus.orb.OprDptInfoHelper.write(output, value);
  }
  public org.omg.CORBA.TypeCode _type() {
    return com.mcip.bus.orb.OprDptInfoHelper.type();
  }
}
