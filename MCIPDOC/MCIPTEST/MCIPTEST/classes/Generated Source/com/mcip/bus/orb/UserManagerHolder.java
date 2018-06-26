package com.mcip.bus.orb;

/**
 * <ul>
 * <li> <b>IDL Source</b>    "D:/Kevin/MCIPDOC/MCIPTEST/MCIPTEST/src/IDL/userManage.idl"
 * <li> <b>IDL Name</b>      ::com::mcip::bus::orb::UserManager
 * <li> <b>Repository Id</b> IDL:com/mcip/bus/orb/UserManager:1.0
 * </ul>
 * <b>IDL definition:</b>
 * <pre>
 * interface UserManager {
  ...
};
 * </pre>
 */
public final class UserManagerHolder implements org.omg.CORBA.portable.Streamable {
  public com.mcip.bus.orb.UserManager value;

  public UserManagerHolder () {
  }

  public UserManagerHolder (final com.mcip.bus.orb.UserManager _vis_value) {
    this.value = _vis_value;
  }

  public void _read (final org.omg.CORBA.portable.InputStream input) {
    value = com.mcip.bus.orb.UserManagerHelper.read(input);
  }

  public void _write (final org.omg.CORBA.portable.OutputStream output) {
    com.mcip.bus.orb.UserManagerHelper.write(output, value);
  }

  public org.omg.CORBA.TypeCode _type () {
    return com.mcip.bus.orb.UserManagerHelper.type();
  }
}
