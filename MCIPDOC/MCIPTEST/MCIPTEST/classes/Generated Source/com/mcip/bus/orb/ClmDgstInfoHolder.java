package com.mcip.bus.orb;

/**
 * <ul>
 * <li> <b>IDL Source</b>    "D:/Kevin/MCIPDOC/MCIPTEST/MCIPTEST/src/IDL/businessInfoStruct.idl"
 * <li> <b>IDL Name</b>      ::com::mcip::bus::orb::ClmDgstInfo
 * <li> <b>Repository Id</b> IDL:com/mcip/bus/orb/ClmDgstInfo:1.0
 * </ul>
 * <b>IDL definition:</b>
 * <pre>
 * struct ClmDgstInfo {
  ...
};
 * </pre>
 */
public final class ClmDgstInfoHolder implements org.omg.CORBA.portable.Streamable {
  public com.mcip.bus.orb.ClmDgstInfo value;

  public ClmDgstInfoHolder () {
  }

  public ClmDgstInfoHolder (final com.mcip.bus.orb.ClmDgstInfo _vis_value) {
    this.value = _vis_value;
  }

  public void _read (final org.omg.CORBA.portable.InputStream input) {
    value = com.mcip.bus.orb.ClmDgstInfoHelper.read(input);
  }

  public void _write (final org.omg.CORBA.portable.OutputStream output) {
    com.mcip.bus.orb.ClmDgstInfoHelper.write(output, value);
  }

  public org.omg.CORBA.TypeCode _type () {
    return com.mcip.bus.orb.ClmDgstInfoHelper.type();
  }
}
