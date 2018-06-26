package com.mcip.orb;
/**
<p>
<ul>
<li> <b>Java Class</b> com.mcip.orb.CoExceptionHolder
<li> <b>Source File</b> com/mcip/orb/CoExceptionHolder.java
<li> <b>IDL Source File</b> exceptions.idl
<li> <b>IDL Absolute Name</b> ::com::mcip::orb::CoException
<li> <b>Repository Identifier</b> IDL:com/mcip/orb/CoException:1.0
</ul>
<b>IDL definition:</b>
<pre>
    #pragma prefix "com/mcip/orb"
    exception CoException {
      string errCode;
      wstring errDescription;
      string errFieldName;
      string severity;
    };
</pre>
</p>
*/
final public class CoExceptionHolder implements org.omg.CORBA.portable.Streamable {
  public com.mcip.orb.CoException value;
  public CoExceptionHolder() {
  }
  public CoExceptionHolder(com.mcip.orb.CoException value) {
    this.value = value;
  }
  public void _read(org.omg.CORBA.portable.InputStream input) {
    value = com.mcip.orb.CoExceptionHelper.read(input);
  }
  public void _write(org.omg.CORBA.portable.OutputStream output) {
    com.mcip.orb.CoExceptionHelper.write(output, value);
  }
  public org.omg.CORBA.TypeCode _type() {
    return com.mcip.orb.CoExceptionHelper.type();
  }
}
