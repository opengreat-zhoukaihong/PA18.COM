package com.mcip.bus.orb;

/**
 * <ul>
 * <li> <b>IDL Source</b>    "D:/Kevin/MCIPDOC/MCIPTEST/MCIPTEST/src/IDL/businessInfoStruct.idl"
 * <li> <b>IDL Name</b>      ::com::mcip::bus::orb::InsrncGuideInfo
 * <li> <b>Repository Id</b> IDL:com/mcip/bus/orb/InsrncGuideInfo:1.0
 * </ul>
 * <b>IDL definition:</b>
 * <pre>
 * struct InsrncGuideInfo {
  ...
};
 * </pre>
 */
public final class InsrncGuideInfoHolder implements org.omg.CORBA.portable.Streamable {
  public com.mcip.bus.orb.InsrncGuideInfo value;

  public InsrncGuideInfoHolder () {
  }

  public InsrncGuideInfoHolder (final com.mcip.bus.orb.InsrncGuideInfo _vis_value) {
    this.value = _vis_value;
  }

  public void _read (final org.omg.CORBA.portable.InputStream input) {
    value = com.mcip.bus.orb.InsrncGuideInfoHelper.read(input);
  }

  public void _write (final org.omg.CORBA.portable.OutputStream output) {
    com.mcip.bus.orb.InsrncGuideInfoHelper.write(output, value);
  }

  public org.omg.CORBA.TypeCode _type () {
    return com.mcip.bus.orb.InsrncGuideInfoHelper.type();
  }
}
