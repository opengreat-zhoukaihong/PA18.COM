package com.mcip.bus.orb;
/**
<p>
<ul>
<li> <b>Java Class</b> com.mcip.bus.orb.PagesInfoHolder
<li> <b>Source File</b> com/mcip/bus/orb/PagesInfoHolder.java
<li> <b>IDL Source File</b> businessInfoStruct.idl
<li> <b>IDL Absolute Name</b> ::com::mcip::bus::orb::PagesInfo
<li> <b>Repository Identifier</b> IDL:com/mcip/bus/orb/PagesInfo:1.0
</ul>
<b>IDL definition:</b>
<pre>
    #pragma prefix "com/mcip/bus/orb"
    struct PagesInfo {
      string c_page_no;
      wstring c_page_title;
      wstring c_file_enm;
      string c_func_cde;
      string t_edit_tm;
    };
</pre>
</p>
*/
final public class PagesInfoHolder implements org.omg.CORBA.portable.Streamable {
  public com.mcip.bus.orb.PagesInfo value;
  public PagesInfoHolder() {
  }
  public PagesInfoHolder(com.mcip.bus.orb.PagesInfo value) {
    this.value = value;
  }
  public void _read(org.omg.CORBA.portable.InputStream input) {
    value = com.mcip.bus.orb.PagesInfoHelper.read(input);
  }
  public void _write(org.omg.CORBA.portable.OutputStream output) {
    com.mcip.bus.orb.PagesInfoHelper.write(output, value);
  }
  public org.omg.CORBA.TypeCode _type() {
    return com.mcip.bus.orb.PagesInfoHelper.type();
  }
}
