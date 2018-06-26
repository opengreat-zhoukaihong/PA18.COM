package com.mcip.orb;

/**
 * <ul>
 * <li> <b>IDL Source</b>    "D:/Kevin/MCIPDOC/MCIPTEST/MCIPTEST/src/IDL/CorbaDataType.idl"
 * <li> <b>IDL Name</b>      ::com::mcip::orb::Stringss
 * <li> <b>Repository Id</b> IDL:com/mcip/orb/Stringss:1.0
 * </ul>
 * <b>IDL definition:</b>
 * <pre>
 * typedef sequence&ltcom.mcip.orb.Strings&gt Stringss;
 * </pre>
 */
public final class StringssHolder implements org.omg.CORBA.portable.Streamable {
  public java.lang.String[][] value;

  public StringssHolder () {
  }

  public StringssHolder (final java.lang.String[][] _vis_value) {
    this.value = _vis_value;
  }

  public void _read (final org.omg.CORBA.portable.InputStream input) {
    value = com.mcip.orb.StringssHelper.read(input);
  }

  public void _write (final org.omg.CORBA.portable.OutputStream output) {
    com.mcip.orb.StringssHelper.write(output, value);
  }

  public org.omg.CORBA.TypeCode _type () {
    return com.mcip.orb.StringssHelper.type();
  }
}
