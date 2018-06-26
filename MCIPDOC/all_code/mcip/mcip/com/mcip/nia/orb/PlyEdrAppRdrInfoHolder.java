package com.mcip.nia.orb;
/**
<p>
<ul>
<li> <b>Java Class</b> com.mcip.nia.orb.PlyEdrAppRdrInfoHolder
<li> <b>Source File</b> com/mcip/nia/orb/PlyEdrAppRdrInfoHolder.java
<li> <b>IDL Source File</b> policyInfoStruct.idl
<li> <b>IDL Absolute Name</b> ::com::mcip::nia::orb::PlyEdrAppRdrInfo
<li> <b>Repository Identifier</b> IDL:com/mcip/nia/orb/PlyEdrAppRdrInfo:1.0
</ul>
<b>IDL definition:</b>
<pre>
    #pragma prefix "com/mcip/nia/orb"
    struct PlyEdrAppRdrInfo {
      ::com::mcip::orb::Stringss edrapprdr;
    };
</pre>
</p>
*/
final public class PlyEdrAppRdrInfoHolder implements org.omg.CORBA.portable.Streamable {
  public com.mcip.nia.orb.PlyEdrAppRdrInfo value;
  public PlyEdrAppRdrInfoHolder() {
  }
  public PlyEdrAppRdrInfoHolder(com.mcip.nia.orb.PlyEdrAppRdrInfo value) {
    this.value = value;
  }
  public void _read(org.omg.CORBA.portable.InputStream input) {
    value = com.mcip.nia.orb.PlyEdrAppRdrInfoHelper.read(input);
  }
  public void _write(org.omg.CORBA.portable.OutputStream output) {
    com.mcip.nia.orb.PlyEdrAppRdrInfoHelper.write(output, value);
  }
  public org.omg.CORBA.TypeCode _type() {
    return com.mcip.nia.orb.PlyEdrAppRdrInfoHelper.type();
  }
}
