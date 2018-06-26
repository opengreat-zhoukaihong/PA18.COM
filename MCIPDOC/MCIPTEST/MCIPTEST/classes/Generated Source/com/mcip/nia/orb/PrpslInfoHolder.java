package com.mcip.nia.orb;

/**
 * <ul>
 * <li> <b>IDL Source</b>    "D:/Kevin/MCIPDOC/MCIPTEST/MCIPTEST/src/IDL/policyInfoStruct.idl"
 * <li> <b>IDL Name</b>      ::com::mcip::nia::orb::PrpslInfo
 * <li> <b>Repository Id</b> IDL:com/mcip/nia/orb/PrpslInfo:1.0
 * </ul>
 * <b>IDL definition:</b>
 * <pre>
 * struct PrpslInfo {
  ...
};
 * </pre>
 */
public final class PrpslInfoHolder implements org.omg.CORBA.portable.Streamable {
  public com.mcip.nia.orb.PrpslInfo value;

  public PrpslInfoHolder () {
  }

  public PrpslInfoHolder (final com.mcip.nia.orb.PrpslInfo _vis_value) {
    this.value = _vis_value;
  }

  public void _read (final org.omg.CORBA.portable.InputStream input) {
    value = com.mcip.nia.orb.PrpslInfoHelper.read(input);
  }

  public void _write (final org.omg.CORBA.portable.OutputStream output) {
    com.mcip.nia.orb.PrpslInfoHelper.write(output, value);
  }

  public org.omg.CORBA.TypeCode _type () {
    return com.mcip.nia.orb.PrpslInfoHelper.type();
  }
}
