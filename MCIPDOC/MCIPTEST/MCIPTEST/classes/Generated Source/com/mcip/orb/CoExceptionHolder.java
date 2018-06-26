package com.mcip.orb;

/**
 * <ul>
 * <li> <b>IDL Source</b>    "D:/Kevin/MCIPDOC/MCIPTEST/MCIPTEST/src/IDL/exceptions.idl"
 * <li> <b>IDL Name</b>      ::com::mcip::orb::CoException
 * <li> <b>Repository Id</b> IDL:com/mcip/orb/CoException:1.0
 * </ul>
 * <b>IDL definition:</b>
 * <pre>
 * exception CoException {
  ...
};
 * </pre>
 */
public final class CoExceptionHolder implements org.omg.CORBA.portable.Streamable {
  public com.mcip.orb.CoException value;

  public CoExceptionHolder () {
  }

  public CoExceptionHolder (final com.mcip.orb.CoException _vis_value) {
    this.value = _vis_value;
  }

  public void _read (final org.omg.CORBA.portable.InputStream input) {
    value = com.mcip.orb.CoExceptionHelper.read(input);
  }

  public void _write (final org.omg.CORBA.portable.OutputStream output) {
    com.mcip.orb.CoExceptionHelper.write(output, value);
  }

  public org.omg.CORBA.TypeCode _type () {
    return com.mcip.orb.CoExceptionHelper.type();
  }
}
