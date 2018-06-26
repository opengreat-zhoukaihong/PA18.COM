package com.mcip.nia.orb;

/**
 * <ul>
 * <li> <b>IDL Source</b>    "D:/Kevin/MCIPDOC/MCIPTEST/MCIPTEST/src/IDL/policyInfoManage.idl"
 * <li> <b>IDL Name</b>      ::com::mcip::nia::orb::PolicyInfoManager
 * <li> <b>Repository Id</b> IDL:com/mcip/nia/orb/PolicyInfoManager:1.0
 * </ul>
 * <b>IDL definition:</b>
 * <pre>
 * interface PolicyInfoManager {
  ...
};
 * </pre>
 */
public final class PolicyInfoManagerHolder implements org.omg.CORBA.portable.Streamable {
  public com.mcip.nia.orb.PolicyInfoManager value;

  public PolicyInfoManagerHolder () {
  }

  public PolicyInfoManagerHolder (final com.mcip.nia.orb.PolicyInfoManager _vis_value) {
    this.value = _vis_value;
  }

  public void _read (final org.omg.CORBA.portable.InputStream input) {
    value = com.mcip.nia.orb.PolicyInfoManagerHelper.read(input);
  }

  public void _write (final org.omg.CORBA.portable.OutputStream output) {
    com.mcip.nia.orb.PolicyInfoManagerHelper.write(output, value);
  }

  public org.omg.CORBA.TypeCode _type () {
    return com.mcip.nia.orb.PolicyInfoManagerHelper.type();
  }
}
