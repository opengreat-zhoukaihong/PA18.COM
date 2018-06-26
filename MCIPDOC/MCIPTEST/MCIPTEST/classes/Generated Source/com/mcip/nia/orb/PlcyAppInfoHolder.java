package com.mcip.nia.orb;

/**
 * <ul>
 * <li> <b>IDL Source</b>    "D:/Kevin/MCIPDOC/MCIPTEST/MCIPTEST/src/IDL/policyInfoStruct.idl"
 * <li> <b>IDL Name</b>      ::com::mcip::nia::orb::PlcyAppInfo
 * <li> <b>Repository Id</b> IDL:com/mcip/nia/orb/PlcyAppInfo:1.0
 * </ul>
 * <b>IDL definition:</b>
 * <pre>
 * struct PlcyAppInfo {
  ...
};
 * </pre>
 */
public final class PlcyAppInfoHolder implements org.omg.CORBA.portable.Streamable {
  public com.mcip.nia.orb.PlcyAppInfo value;

  public PlcyAppInfoHolder () {
  }

  public PlcyAppInfoHolder (final com.mcip.nia.orb.PlcyAppInfo _vis_value) {
    this.value = _vis_value;
  }

  public void _read (final org.omg.CORBA.portable.InputStream input) {
    value = com.mcip.nia.orb.PlcyAppInfoHelper.read(input);
  }

  public void _write (final org.omg.CORBA.portable.OutputStream output) {
    com.mcip.nia.orb.PlcyAppInfoHelper.write(output, value);
  }

  public org.omg.CORBA.TypeCode _type () {
    return com.mcip.nia.orb.PlcyAppInfoHelper.type();
  }
}
