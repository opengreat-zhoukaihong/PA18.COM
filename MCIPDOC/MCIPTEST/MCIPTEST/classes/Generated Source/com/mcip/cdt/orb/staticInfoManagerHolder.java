package com.mcip.cdt.orb;

/**
 * <ul>
 * <li> <b>IDL Source</b>    "D:/Kevin/MCIPDOC/MCIPTEST/MCIPTEST/src/IDL/getStaticInfo.idl"
 * <li> <b>IDL Name</b>      ::com::mcip::cdt::orb::staticInfoManager
 * <li> <b>Repository Id</b> IDL:com/mcip/cdt/orb/staticInfoManager:1.0
 * </ul>
 * <b>IDL definition:</b>
 * <pre>
 * interface staticInfoManager {
  ...
};
 * </pre>
 */
public final class staticInfoManagerHolder implements org.omg.CORBA.portable.Streamable {
  public com.mcip.cdt.orb.staticInfoManager value;

  public staticInfoManagerHolder () {
  }

  public staticInfoManagerHolder (final com.mcip.cdt.orb.staticInfoManager _vis_value) {
    this.value = _vis_value;
  }

  public void _read (final org.omg.CORBA.portable.InputStream input) {
    value = com.mcip.cdt.orb.staticInfoManagerHelper.read(input);
  }

  public void _write (final org.omg.CORBA.portable.OutputStream output) {
    com.mcip.cdt.orb.staticInfoManagerHelper.write(output, value);
  }

  public org.omg.CORBA.TypeCode _type () {
    return com.mcip.cdt.orb.staticInfoManagerHelper.type();
  }
}
