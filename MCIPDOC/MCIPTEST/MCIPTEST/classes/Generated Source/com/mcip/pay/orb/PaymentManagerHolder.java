package com.mcip.pay.orb;

/**
 * <ul>
 * <li> <b>IDL Source</b>    "D:/Kevin/MCIPDOC/MCIPTEST/MCIPTEST/src/IDL/paymentManage.idl"
 * <li> <b>IDL Name</b>      ::com::mcip::pay::orb::PaymentManager
 * <li> <b>Repository Id</b> IDL:com/mcip/pay/orb/PaymentManager:1.0
 * </ul>
 * <b>IDL definition:</b>
 * <pre>
 * interface PaymentManager {
  ...
};
 * </pre>
 */
public final class PaymentManagerHolder implements org.omg.CORBA.portable.Streamable {
  public com.mcip.pay.orb.PaymentManager value;

  public PaymentManagerHolder () {
  }

  public PaymentManagerHolder (final com.mcip.pay.orb.PaymentManager _vis_value) {
    this.value = _vis_value;
  }

  public void _read (final org.omg.CORBA.portable.InputStream input) {
    value = com.mcip.pay.orb.PaymentManagerHelper.read(input);
  }

  public void _write (final org.omg.CORBA.portable.OutputStream output) {
    com.mcip.pay.orb.PaymentManagerHelper.write(output, value);
  }

  public org.omg.CORBA.TypeCode _type () {
    return com.mcip.pay.orb.PaymentManagerHelper.type();
  }
}
