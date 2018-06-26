package com.mcip.pay.orb;

/**
 * <ul>
 * <li> <b>IDL Source</b>    "D:/Kevin/MCIPDOC/MCIPTEST/MCIPTEST/src/IDL/paymentInfoStruct.idl"
 * <li> <b>IDL Name</b>      ::com::mcip::pay::orb::PaymentLog
 * <li> <b>Repository Id</b> IDL:com/mcip/pay/orb/PaymentLog:1.0
 * </ul>
 * <b>IDL definition:</b>
 * <pre>
 * struct PaymentLog {
  ...
};
 * </pre>
 */
public final class PaymentLogHolder implements org.omg.CORBA.portable.Streamable {
  public com.mcip.pay.orb.PaymentLog value;

  public PaymentLogHolder () {
  }

  public PaymentLogHolder (final com.mcip.pay.orb.PaymentLog _vis_value) {
    this.value = _vis_value;
  }

  public void _read (final org.omg.CORBA.portable.InputStream input) {
    value = com.mcip.pay.orb.PaymentLogHelper.read(input);
  }

  public void _write (final org.omg.CORBA.portable.OutputStream output) {
    com.mcip.pay.orb.PaymentLogHelper.write(output, value);
  }

  public org.omg.CORBA.TypeCode _type () {
    return com.mcip.pay.orb.PaymentLogHelper.type();
  }
}
