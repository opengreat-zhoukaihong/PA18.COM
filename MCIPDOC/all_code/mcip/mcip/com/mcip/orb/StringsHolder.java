package com.mcip.orb;
/**
<p>
<ul>
<li> <b>Java Class</b> com.mcip.orb.StringsHolder
<li> <b>Source File</b> com/mcip/orb/StringsHolder.java
<li> <b>IDL Source File</b> CorbaDataType.idl
<li> <b>IDL Absolute Name</b> ::com::mcip::orb::Strings
<li> <b>Repository Identifier</b> IDL:com/mcip/orb/Strings:1.0
</ul>
<b>IDL definition:</b>
<pre>
    #pragma prefix "com/mcip/orb"
    typedef sequence&ltwstring&gt Strings;
</pre>
</p>
*/
final public class StringsHolder implements org.omg.CORBA.portable.Streamable {
  public java.lang.String[] value;
  public StringsHolder() {
  }
  public StringsHolder(java.lang.String[] value) {
    this.value = value;
  }
  public void _read(org.omg.CORBA.portable.InputStream input) {
    value = com.mcip.orb.StringsHelper.read(input);
  }
  public void _write(org.omg.CORBA.portable.OutputStream output) {
    com.mcip.orb.StringsHelper.write(output, value);
  }
  public org.omg.CORBA.TypeCode _type() {
    return com.mcip.orb.StringsHelper.type();
  }
}
