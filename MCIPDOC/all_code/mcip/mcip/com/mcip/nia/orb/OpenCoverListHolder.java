package com.mcip.nia.orb;
/**
<p>
<ul>
<li> <b>Java Class</b> com.mcip.nia.orb.OpenCoverListHolder
<li> <b>Source File</b> com/mcip/nia/orb/OpenCoverListHolder.java
<li> <b>IDL Source File</b> policyInfoStruct.idl
<li> <b>IDL Absolute Name</b> ::com::mcip::nia::orb::OpenCoverList
<li> <b>Repository Identifier</b> IDL:com/mcip/nia/orb/OpenCoverList:1.0
</ul>
<b>IDL definition:</b>
<pre>
    #pragma prefix "com/mcip/nia/orb"
    struct OpenCoverList {
      string c_open_cover_no;
      wstring c_crgo_name;
      string c_insrnc_cde;
      wstring c_insrnc_cnm;
      string c_frm_prt_ara;
      wstring c_frm_prt_ara_cnm;
      string c_to_prt_ara;
      wstring c_to_prt_ara_cnm;
      wstring c_from_prt;
      wstring c_to_prt;
    };
</pre>
</p>
*/
final public class OpenCoverListHolder implements org.omg.CORBA.portable.Streamable {
  public com.mcip.nia.orb.OpenCoverList value;
  public OpenCoverListHolder() {
  }
  public OpenCoverListHolder(com.mcip.nia.orb.OpenCoverList value) {
    this.value = value;
  }
  public void _read(org.omg.CORBA.portable.InputStream input) {
    value = com.mcip.nia.orb.OpenCoverListHelper.read(input);
  }
  public void _write(org.omg.CORBA.portable.OutputStream output) {
    com.mcip.nia.orb.OpenCoverListHelper.write(output, value);
  }
  public org.omg.CORBA.TypeCode _type() {
    return com.mcip.nia.orb.OpenCoverListHelper.type();
  }
}
