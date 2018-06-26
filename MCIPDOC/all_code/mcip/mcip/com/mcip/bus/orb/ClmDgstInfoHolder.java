package com.mcip.bus.orb;
/**
<p>
<ul>
<li> <b>Java Class</b> com.mcip.bus.orb.ClmDgstInfoHolder
<li> <b>Source File</b> com/mcip/bus/orb/ClmDgstInfoHolder.java
<li> <b>IDL Source File</b> businessInfoStruct.idl
<li> <b>IDL Absolute Name</b> ::com::mcip::bus::orb::ClmDgstInfo
<li> <b>Repository Identifier</b> IDL:com/mcip/bus/orb/ClmDgstInfo:1.0
</ul>
<b>IDL definition:</b>
<pre>
    #pragma prefix "com/mcip/bus/orb"
    struct ClmDgstInfo {
      wstring c_ply_no;
      wstring c_rpt_no;
      wstring c_info_no;
      wstring c_digest;
      wstring c_content;
      string t_input_tm;
    };
</pre>
</p>
*/
final public class ClmDgstInfoHolder implements org.omg.CORBA.portable.Streamable {
  public com.mcip.bus.orb.ClmDgstInfo value;
  public ClmDgstInfoHolder() {
  }
  public ClmDgstInfoHolder(com.mcip.bus.orb.ClmDgstInfo value) {
    this.value = value;
  }
  public void _read(org.omg.CORBA.portable.InputStream input) {
    value = com.mcip.bus.orb.ClmDgstInfoHelper.read(input);
  }
  public void _write(org.omg.CORBA.portable.OutputStream output) {
    com.mcip.bus.orb.ClmDgstInfoHelper.write(output, value);
  }
  public org.omg.CORBA.TypeCode _type() {
    return com.mcip.bus.orb.ClmDgstInfoHelper.type();
  }
}
