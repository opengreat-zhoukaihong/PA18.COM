package com.mcip.cus.orb;

/**
 * <ul>
 * <li> <b>IDL Source</b>    "D:/Kevin/MCIPDOC/MCIPTEST/MCIPTEST/src/IDL/custManage.idl"
 * <li> <b>IDL Name</b>      ::com::mcip::cus::orb::CustManager
 * <li> <b>Repository Id</b> IDL:com/mcip/cus/orb/CustManager:1.0
 * </ul>
 * <b>IDL definition:</b>
 * <pre>
 * interface CustManager {
  ...
};
 * </pre>
 */
public final class CustManagerHolder implements org.omg.CORBA.portable.Streamable {
  public com.mcip.cus.orb.CustManager value;

  public CustManagerHolder () {
  }

  public CustManagerHolder (final com.mcip.cus.orb.CustManager _vis_value) {
    this.value = _vis_value;
  }

  public void _read (final org.omg.CORBA.portable.InputStream input) {
    value = com.mcip.cus.orb.CustManagerHelper.read(input);
  }

  public void _write (final org.omg.CORBA.portable.OutputStream output) {
    com.mcip.cus.orb.CustManagerHelper.write(output, value);
  }

  public org.omg.CORBA.TypeCode _type () {
    return com.mcip.cus.orb.CustManagerHelper.type();
  }
}
