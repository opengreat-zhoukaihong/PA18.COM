package com.mcip.cus.orb;

/**
 * <ul>
 * <li> <b>IDL Source</b>    "D:/Kevin/MCIPDOC/MCIPTEST/MCIPTEST/src/IDL/custInfoStruct.idl"
 * <li> <b>IDL Name</b>      ::com::mcip::cus::orb::CustPrsn
 * <li> <b>Repository Id</b> IDL:com/mcip/cus/orb/CustPrsn:1.0
 * </ul>
 * <b>IDL definition:</b>
 * <pre>
 * struct CustPrsn {
  ...
};
 * </pre>
 */
public final class CustPrsnHolder implements org.omg.CORBA.portable.Streamable {
  public com.mcip.cus.orb.CustPrsn value;

  public CustPrsnHolder () {
  }

  public CustPrsnHolder (final com.mcip.cus.orb.CustPrsn _vis_value) {
    this.value = _vis_value;
  }

  public void _read (final org.omg.CORBA.portable.InputStream input) {
    value = com.mcip.cus.orb.CustPrsnHelper.read(input);
  }

  public void _write (final org.omg.CORBA.portable.OutputStream output) {
    com.mcip.cus.orb.CustPrsnHelper.write(output, value);
  }

  public org.omg.CORBA.TypeCode _type () {
    return com.mcip.cus.orb.CustPrsnHelper.type();
  }
}
