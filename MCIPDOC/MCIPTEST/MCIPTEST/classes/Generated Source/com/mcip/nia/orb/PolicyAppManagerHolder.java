package com.mcip.nia.orb;

/**
 * <ul>
 * <li> <b>IDL Source</b>    "D:/Kevin/MCIPDOC/MCIPTEST/MCIPTEST/src/IDL/policyAppManage.idl"
 * <li> <b>IDL Name</b>      ::com::mcip::nia::orb::PolicyAppManager
 * <li> <b>Repository Id</b> IDL:com/mcip/nia/orb/PolicyAppManager:1.0
 * </ul>
 * <b>IDL definition:</b>
 * <pre>
 * interface PolicyAppManager {
  ...
};
 * </pre>
 */
public final class PolicyAppManagerHolder implements org.omg.CORBA.portable.Streamable {
  public com.mcip.nia.orb.PolicyAppManager value;

  public PolicyAppManagerHolder () {
  }

  public PolicyAppManagerHolder (final com.mcip.nia.orb.PolicyAppManager _vis_value) {
    this.value = _vis_value;
  }

  public void _read (final org.omg.CORBA.portable.InputStream input) {
    value = com.mcip.nia.orb.PolicyAppManagerHelper.read(input);
  }

  public void _write (final org.omg.CORBA.portable.OutputStream output) {
    com.mcip.nia.orb.PolicyAppManagerHelper.write(output, value);
  }

  public org.omg.CORBA.TypeCode _type () {
    return com.mcip.nia.orb.PolicyAppManagerHelper.type();
  }
}
