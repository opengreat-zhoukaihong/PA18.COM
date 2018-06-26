package com.mcip.nia.orb;

/**
 * <ul>
 * <li> <b>IDL Source</b>    "D:/Kevin/MCIPDOC/MCIPTEST/MCIPTEST/src/IDL/policyInfoStruct.idl"
 * <li> <b>IDL Name</b>      ::com::mcip::nia::orb::NiaGridPack
 * <li> <b>Repository Id</b> IDL:com/mcip/nia/orb/NiaGridPack:1.0
 * </ul>
 * <b>IDL definition:</b>
 * <pre>
 * struct NiaGridPack {
  ...
};
 * </pre>
 */
public final class NiaGridPackHolder implements org.omg.CORBA.portable.Streamable {
  public com.mcip.nia.orb.NiaGridPack value;

  public NiaGridPackHolder () {
  }

  public NiaGridPackHolder (final com.mcip.nia.orb.NiaGridPack _vis_value) {
    this.value = _vis_value;
  }

  public void _read (final org.omg.CORBA.portable.InputStream input) {
    value = com.mcip.nia.orb.NiaGridPackHelper.read(input);
  }

  public void _write (final org.omg.CORBA.portable.OutputStream output) {
    com.mcip.nia.orb.NiaGridPackHelper.write(output, value);
  }

  public org.omg.CORBA.TypeCode _type () {
    return com.mcip.nia.orb.NiaGridPackHelper.type();
  }
}
