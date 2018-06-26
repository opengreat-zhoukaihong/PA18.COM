package com.mcip.bus.orb;

/**
 * <ul>
 * <li> <b>IDL Source</b>    "D:/Kevin/MCIPDOC/MCIPTEST/MCIPTEST/src/IDL/businessManage.idl"
 * <li> <b>IDL Name</b>      ::com::mcip::bus::orb::BusinessManager
 * <li> <b>Repository Id</b> IDL:com/mcip/bus/orb/BusinessManager:1.0
 * </ul>
 * <b>IDL definition:</b>
 * <pre>
 * interface BusinessManager {
  ...
};
 * </pre>
 */
public final class BusinessManagerHolder implements org.omg.CORBA.portable.Streamable {
  public com.mcip.bus.orb.BusinessManager value;

  public BusinessManagerHolder () {
  }

  public BusinessManagerHolder (final com.mcip.bus.orb.BusinessManager _vis_value) {
    this.value = _vis_value;
  }

  public void _read (final org.omg.CORBA.portable.InputStream input) {
    value = com.mcip.bus.orb.BusinessManagerHelper.read(input);
  }

  public void _write (final org.omg.CORBA.portable.OutputStream output) {
    com.mcip.bus.orb.BusinessManagerHelper.write(output, value);
  }

  public org.omg.CORBA.TypeCode _type () {
    return com.mcip.bus.orb.BusinessManagerHelper.type();
  }
}
