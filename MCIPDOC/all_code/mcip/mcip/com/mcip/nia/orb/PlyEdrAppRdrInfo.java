package com.mcip.nia.orb;
/**
<p>
<ul>
<li> <b>Java Class</b> com.mcip.nia.orb.PlyEdrAppRdrInfo
<li> <b>Source File</b> com/mcip/nia/orb/PlyEdrAppRdrInfo.java
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
final public class PlyEdrAppRdrInfo {
  public java.lang.String[][] edrapprdr;
  public PlyEdrAppRdrInfo() {
  }
  public PlyEdrAppRdrInfo(
    java.lang.String[][] edrapprdr
  ) {
    this.edrapprdr = edrapprdr;
  }
  public java.lang.String toString() {
    org.omg.CORBA.Any any = org.omg.CORBA.ORB.init().create_any();
    com.mcip.nia.orb.PlyEdrAppRdrInfoHelper.insert(any, this);
    return any.toString();
  }
}
