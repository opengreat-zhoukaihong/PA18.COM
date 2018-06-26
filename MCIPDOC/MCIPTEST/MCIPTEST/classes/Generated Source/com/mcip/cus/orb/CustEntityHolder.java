package com.mcip.cus.orb;

/**
 * <ul>
 * <li> <b>IDL Source</b>    "D:/Kevin/MCIPDOC/MCIPTEST/MCIPTEST/src/IDL/custInfoStruct.idl"
 * <li> <b>IDL Name</b>      ::com::mcip::cus::orb::CustEntity
 * <li> <b>Repository Id</b> IDL:com/mcip/cus/orb/CustEntity:1.0
 * </ul>
 * <b>IDL definition:</b>
 * <pre>
 * struct CustEntity {
  ...
};
 * </pre>
 */
public final class CustEntityHolder implements org.omg.CORBA.portable.Streamable {
  public com.mcip.cus.orb.CustEntity value;

  public CustEntityHolder () {
  }

  public CustEntityHolder (final com.mcip.cus.orb.CustEntity _vis_value) {
    this.value = _vis_value;
  }

  public void _read (final org.omg.CORBA.portable.InputStream input) {
    value = com.mcip.cus.orb.CustEntityHelper.read(input);
  }

  public void _write (final org.omg.CORBA.portable.OutputStream output) {
    com.mcip.cus.orb.CustEntityHelper.write(output, value);
  }

  public org.omg.CORBA.TypeCode _type () {
    return com.mcip.cus.orb.CustEntityHelper.type();
  }
}
