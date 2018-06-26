package com.mcip.bus.orb;
/**
<p>
<ul>
<li> <b>Java Class</b> com.mcip.bus.orb.SysFuncInfoHolder
<li> <b>Source File</b> com/mcip/bus/orb/SysFuncInfoHolder.java
<li> <b>IDL Source File</b> businessInfoStruct.idl
<li> <b>IDL Absolute Name</b> ::com::mcip::bus::orb::SysFuncInfo
<li> <b>Repository Identifier</b> IDL:com/mcip/bus/orb/SysFuncInfo:1.0
</ul>
<b>IDL definition:</b>
<pre>
    #pragma prefix "com/mcip/bus/orb"
    struct SysFuncInfo {
      string c_func_cde;
      wstring c_func_cnm;
      wstring c_func_enm;
    };
</pre>
</p>
*/
final public class SysFuncInfoHolder implements org.omg.CORBA.portable.Streamable {
  public com.mcip.bus.orb.SysFuncInfo value;
  public SysFuncInfoHolder() {
  }
  public SysFuncInfoHolder(com.mcip.bus.orb.SysFuncInfo value) {
    this.value = value;
  }
  public void _read(org.omg.CORBA.portable.InputStream input) {
    value = com.mcip.bus.orb.SysFuncInfoHelper.read(input);
  }
  public void _write(org.omg.CORBA.portable.OutputStream output) {
    com.mcip.bus.orb.SysFuncInfoHelper.write(output, value);
  }
  public org.omg.CORBA.TypeCode _type() {
    return com.mcip.bus.orb.SysFuncInfoHelper.type();
  }
}
