package com.mcip.nia.orb;
/**
<p>
<ul>
<li> <b>Java Class</b> com.mcip.nia.orb.PlyGetDocInfoHolder
<li> <b>Source File</b> com/mcip/nia/orb/PlyGetDocInfoHolder.java
<li> <b>IDL Source File</b> policyInfoStruct.idl
<li> <b>IDL Absolute Name</b> ::com::mcip::nia::orb::PlyGetDocInfo
<li> <b>Repository Identifier</b> IDL:com/mcip/nia/orb/PlyGetDocInfo:1.0
</ul>
<b>IDL definition:</b>
<pre>
    #pragma prefix "com/mcip/nia/orb"
    struct PlyGetDocInfo {
      wstring c_doc_no;
      string c_insrnc_cde;
      string c_prn_typ;
      wstring t_undr_tm;
    };
</pre>
</p>
*/
final public class PlyGetDocInfoHolder implements org.omg.CORBA.portable.Streamable {
  public com.mcip.nia.orb.PlyGetDocInfo value;
  public PlyGetDocInfoHolder() {
  }
  public PlyGetDocInfoHolder(com.mcip.nia.orb.PlyGetDocInfo value) {
    this.value = value;
  }
  public void _read(org.omg.CORBA.portable.InputStream input) {
    value = com.mcip.nia.orb.PlyGetDocInfoHelper.read(input);
  }
  public void _write(org.omg.CORBA.portable.OutputStream output) {
    com.mcip.nia.orb.PlyGetDocInfoHelper.write(output, value);
  }
  public org.omg.CORBA.TypeCode _type() {
    return com.mcip.nia.orb.PlyGetDocInfoHelper.type();
  }
}
