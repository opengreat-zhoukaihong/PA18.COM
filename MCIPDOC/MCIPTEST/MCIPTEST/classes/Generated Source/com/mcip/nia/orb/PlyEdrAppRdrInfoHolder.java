package com.mcip.nia.orb;

/**
 * <ul>
 * <li> <b>IDL Source</b>    "D:/Kevin/MCIPDOC/MCIPTEST/MCIPTEST/src/IDL/policyInfoStruct.idl"
 * <li> <b>IDL Name</b>      ::com::mcip::nia::orb::PlyEdrAppRdrInfo
 * <li> <b>Repository Id</b> IDL:com/mcip/nia/orb/PlyEdrAppRdrInfo:1.0
 * </ul>
 * <b>IDL definition:</b>
 * <pre>
 * struct PlyEdrAppRdrInfo {
  ...
};
 * </pre>
 */
public final class PlyEdrAppRdrInfoHolder implements org.omg.CORBA.portable.Streamable {
  public com.mcip.nia.orb.PlyEdrAppRdrInfo value;

  public PlyEdrAppRdrInfoHolder () {
  }

  public PlyEdrAppRdrInfoHolder (final com.mcip.nia.orb.PlyEdrAppRdrInfo _vis_value) {
    this.value = _vis_value;
  }

  public void _read (final org.omg.CORBA.portable.InputStream input) {
    value = com.mcip.nia.orb.PlyEdrAppRdrInfoHelper.read(input);
  }

  public void _write (final org.omg.CORBA.portable.OutputStream output) {
    com.mcip.nia.orb.PlyEdrAppRdrInfoHelper.write(output, value);
  }

  public org.omg.CORBA.TypeCode _type () {
    return com.mcip.nia.orb.PlyEdrAppRdrInfoHelper.type();
  }
}
