package com.mcip.nia.orb;

/**
 * <ul>
 * <li> <b>IDL Source</b>    "D:/Kevin/MCIPDOC/MCIPTEST/MCIPTEST/src/IDL/policyInfoStruct.idl"
 * <li> <b>IDL Name</b>      ::com::mcip::nia::orb::AgncCntrInfo
 * <li> <b>Repository Id</b> IDL:com/mcip/nia/orb/AgncCntrInfo:1.0
 * </ul>
 * <b>IDL definition:</b>
 * <pre>
 * struct AgncCntrInfo {
  ...
};
 * </pre>
 */
public final class AgncCntrInfoHolder implements org.omg.CORBA.portable.Streamable {
  public com.mcip.nia.orb.AgncCntrInfo value;

  public AgncCntrInfoHolder () {
  }

  public AgncCntrInfoHolder (final com.mcip.nia.orb.AgncCntrInfo _vis_value) {
    this.value = _vis_value;
  }

  public void _read (final org.omg.CORBA.portable.InputStream input) {
    value = com.mcip.nia.orb.AgncCntrInfoHelper.read(input);
  }

  public void _write (final org.omg.CORBA.portable.OutputStream output) {
    com.mcip.nia.orb.AgncCntrInfoHelper.write(output, value);
  }

  public org.omg.CORBA.TypeCode _type () {
    return com.mcip.nia.orb.AgncCntrInfoHelper.type();
  }
}
