package com.mcip.orb;
/**
<p>
<ul>
<li> <b>Java Class</b> com.mcip.orb.StringssHolder
<li> <b>Source File</b> com/mcip/orb/StringssHolder.java
<li> <b>IDL Source File</b> CorbaDataType.idl
<li> <b>IDL Absolute Name</b> ::com::mcip::orb::Stringss
<li> <b>Repository Identifier</b> IDL:com/mcip/orb/Stringss:1.0
</ul>
<b>IDL definition:</b>
<pre>
    #pragma prefix "com/mcip/orb"
    typedef sequence&lt::com::mcip::orb::Strings&gt Stringss;
</pre>
</p>
*/
final public class StringssHolder implements org.omg.CORBA.portable.Streamable {
  public java.lang.String[][] value;
  public StringssHolder() {
  }
  public StringssHolder(java.lang.String[][] value) {
    this.value = value;
  }
  public void _read(org.omg.CORBA.portable.InputStream input) {
    value = com.mcip.orb.StringssHelper.read(input);
  }
  public void _write(org.omg.CORBA.portable.OutputStream output) {
    com.mcip.orb.StringssHelper.write(output, value);
  }
  public org.omg.CORBA.TypeCode _type() {
    return com.mcip.orb.StringssHelper.type();
  }
}
