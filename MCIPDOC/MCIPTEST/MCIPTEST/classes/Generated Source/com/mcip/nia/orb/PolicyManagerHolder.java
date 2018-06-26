package com.mcip.nia.orb;

/**
 * <ul>
 * <li> <b>IDL Source</b>    "D:/Kevin/MCIPDOC/MCIPTEST/MCIPTEST/src/IDL/policyManage.idl"
 * <li> <b>IDL Name</b>      ::com::mcip::nia::orb::PolicyManager
 * <li> <b>Repository Id</b> IDL:com/mcip/nia/orb/PolicyManager:1.0
 * </ul>
 * <b>IDL definition:</b>
 * <pre>
 * interface PolicyManager {
  ...
};
 * </pre>
 */
public final class PolicyManagerHolder implements org.omg.CORBA.portable.Streamable {
  public com.mcip.nia.orb.PolicyManager value;

  public PolicyManagerHolder () {
  }

  public PolicyManagerHolder (final com.mcip.nia.orb.PolicyManager _vis_value) {
    this.value = _vis_value;
  }

  public void _read (final org.omg.CORBA.portable.InputStream input) {
    value = com.mcip.nia.orb.PolicyManagerHelper.read(input);
  }

  public void _write (final org.omg.CORBA.portable.OutputStream output) {
    com.mcip.nia.orb.PolicyManagerHelper.write(output, value);
  }

  public org.omg.CORBA.TypeCode _type () {
    return com.mcip.nia.orb.PolicyManagerHelper.type();
  }
}
