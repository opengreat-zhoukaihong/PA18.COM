package com.mcip.nia.orb;

/**
 * <ul>
 * <li> <b>IDL Source</b>    "D:/Kevin/MCIPDOC/MCIPTEST/MCIPTEST/src/IDL/policyInfoStruct.idl"
 * <li> <b>IDL Name</b>      ::com::mcip::nia::orb::QuotaCndtn
 * <li> <b>Repository Id</b> IDL:com/mcip/nia/orb/QuotaCndtn:1.0
 * </ul>
 * <b>IDL definition:</b>
 * <pre>
 * struct QuotaCndtn {
  ...
};
 * </pre>
 */
public final class QuotaCndtnHolder implements org.omg.CORBA.portable.Streamable {
  public com.mcip.nia.orb.QuotaCndtn value;

  public QuotaCndtnHolder () {
  }

  public QuotaCndtnHolder (final com.mcip.nia.orb.QuotaCndtn _vis_value) {
    this.value = _vis_value;
  }

  public void _read (final org.omg.CORBA.portable.InputStream input) {
    value = com.mcip.nia.orb.QuotaCndtnHelper.read(input);
  }

  public void _write (final org.omg.CORBA.portable.OutputStream output) {
    com.mcip.nia.orb.QuotaCndtnHelper.write(output, value);
  }

  public org.omg.CORBA.TypeCode _type () {
    return com.mcip.nia.orb.QuotaCndtnHelper.type();
  }
}
