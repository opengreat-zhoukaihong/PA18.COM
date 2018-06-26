package com.mcip.bus.orb;

/**
 * <ul>
 * <li> <b>IDL Source</b>    "D:/Kevin/MCIPDOC/MCIPTEST/MCIPTEST/src/IDL/businessInfoStruct.idl"
 * <li> <b>IDL Name</b>      ::com::mcip::bus::orb::SysFuncInfo
 * <li> <b>Repository Id</b> IDL:com/mcip/bus/orb/SysFuncInfo:1.0
 * </ul>
 * <b>IDL definition:</b>
 * <pre>
 * struct SysFuncInfo {
  ...
};
 * </pre>
 */
public final class SysFuncInfoHolder implements org.omg.CORBA.portable.Streamable {
  public com.mcip.bus.orb.SysFuncInfo value;

  public SysFuncInfoHolder () {
  }

  public SysFuncInfoHolder (final com.mcip.bus.orb.SysFuncInfo _vis_value) {
    this.value = _vis_value;
  }

  public void _read (final org.omg.CORBA.portable.InputStream input) {
    value = com.mcip.bus.orb.SysFuncInfoHelper.read(input);
  }

  public void _write (final org.omg.CORBA.portable.OutputStream output) {
    com.mcip.bus.orb.SysFuncInfoHelper.write(output, value);
  }

  public org.omg.CORBA.TypeCode _type () {
    return com.mcip.bus.orb.SysFuncInfoHelper.type();
  }
}
