package com.mcip.bus.orb;
/**
<p>
<ul>
<li> <b>Java Class</b> com.mcip.bus.orb.OperatorInfoHolder
<li> <b>Source File</b> com/mcip/bus/orb/OperatorInfoHolder.java
<li> <b>IDL Source File</b> businessInfoStruct.idl
<li> <b>IDL Absolute Name</b> ::com::mcip::bus::orb::OperatorInfo
<li> <b>Repository Identifier</b> IDL:com/mcip/bus/orb/OperatorInfo:1.0
</ul>
<b>IDL definition:</b>
<pre>
    #pragma prefix "com/mcip/bus/orb"
    struct OperatorInfo {
      wstring c_opr_cde;
      string c_opr_pw;
      string c_emp_cde;
      string c_dpt_cde;
      wstring c_acredt_cde;
      string c_sys_admin;
    };
</pre>
</p>
*/
final public class OperatorInfoHolder implements org.omg.CORBA.portable.Streamable {
  public com.mcip.bus.orb.OperatorInfo value;
  public OperatorInfoHolder() {
  }
  public OperatorInfoHolder(com.mcip.bus.orb.OperatorInfo value) {
    this.value = value;
  }
  public void _read(org.omg.CORBA.portable.InputStream input) {
    value = com.mcip.bus.orb.OperatorInfoHelper.read(input);
  }
  public void _write(org.omg.CORBA.portable.OutputStream output) {
    com.mcip.bus.orb.OperatorInfoHelper.write(output, value);
  }
  public org.omg.CORBA.TypeCode _type() {
    return com.mcip.bus.orb.OperatorInfoHelper.type();
  }
}
