package com.mcip.orb;

/**
 * <ul>
 * <li> <b>IDL Source</b>    "D:/Kevin/MCIPDOC/MCIPTEST/MCIPTEST/src/IDL/CorbaDataType.idl"
 * <li> <b>IDL Name</b>      ::com::mcip::orb::Strings
 * <li> <b>Repository Id</b> IDL:com/mcip/orb/Strings:1.0
 * </ul>
 * <b>IDL definition:</b>
 * <pre>
 * typedef sequence&ltwstring&gt Strings;
 * </pre>
 */
public final class StringsHolder implements org.omg.CORBA.portable.Streamable {
  public java.lang.String[] value;

  public StringsHolder () {
  }

  public StringsHolder (final java.lang.String[] _vis_value) {
    this.value = _vis_value;
  }

  public void _read (final org.omg.CORBA.portable.InputStream input) {
    value = com.mcip.orb.StringsHelper.read(input);
  }

  public void _write (final org.omg.CORBA.portable.OutputStream output) {
    com.mcip.orb.StringsHelper.write(output, value);
  }

  public org.omg.CORBA.TypeCode _type () {
    return com.mcip.orb.StringsHelper.type();
  }
}
