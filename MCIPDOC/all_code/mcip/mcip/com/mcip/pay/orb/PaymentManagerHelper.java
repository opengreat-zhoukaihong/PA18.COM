package com.mcip.pay.orb;
/**
<p>
<ul>
<li> <b>Java Class</b> com.mcip.pay.orb.PaymentManagerHelper
<li> <b>Source File</b> com/mcip/pay/orb/PaymentManagerHelper.java
<li> <b>IDL Source File</b> paymentManage.idl
<li> <b>IDL Absolute Name</b> ::com::mcip::pay::orb::PaymentManager
<li> <b>Repository Identifier</b> IDL:com/mcip/pay/orb/PaymentManager:1.0
</ul>
<b>IDL definition:</b>
<pre>
    #pragma prefix "com/mcip/pay/orb"
    interface PaymentManager {
      ::com::mcip::orb::Stringss queryLastPayment(
        in string order_no,
        in string tran_type,
        in wstring user_id,
        in string pay_amt,
        in string order_tm
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss queryPaymentList(
        in string order_no,
        in string tran_type,
        in wstring user_id,
        in string pay_amt,
        in string order_tm
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss queryPaymentLog(
        in string in_p_id
      )
      raises(
        ::com::mcip::orb::CoException
      );
      boolean acceptPaymentLog(
        in ::com::mcip::pay::orb::PaymentLog paymentlogobj
      )
      raises(
        ::com::mcip::orb::CoException
      );
      boolean updatePayFlag(
        in string plcy_no,
        in string pay_flag,
        in string in_session_id,
        in wstring bank_cde,
        in wstring bank_nme,
        in wstring bank_accnt,
        in string in_got_prm,
        in string in_cur_typ,
        in string pay_tm,
        in string pay_type,
        in string pay_cde,
        in string app_typ
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss getPaymentLogList(
        in string frm_pay_tm,
        in string to_pay_tm,
        in ::com::mcip::orb::Strings owned_dpt,
        in wstring in_trans_id,
        in wstring in_order_no,
        in wstring in_payment_id,
        in wstring in_cur_typ,
        in wstring in_user_id
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss getBankPayList(
        in string frm_pay_tm,
        in string to_pay_tm,
        in ::com::mcip::orb::Strings owned_dpt,
        in string frm_insrnc_cde,
        in string to_insrnc_cde,
        in wstring in_bank_cde
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss getDptPayList(
        in string frm_undr_tm,
        in string to_undr_tm,
        in ::com::mcip::orb::Strings owned_dpt,
        in string frm_insrnc_cde,
        in string to_insrnc_cde,
        in wstring in_bank_cde
      )
      raises(
        ::com::mcip::orb::CoException
      );
      boolean updatePaymentLog(
        in ::com::mcip::pay::orb::PaymentLog paymentlogobj
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss getPayStatusList(
      )
      raises(
        ::com::mcip::orb::CoException
      );
      boolean setPayFlag(
        in ::com::mcip::orb::Stringss payinfo
      )
      raises(
        ::com::mcip::orb::CoException
      );
    };
</pre>
</p>
*/
abstract public class PaymentManagerHelper {
  public static com.mcip.pay.orb.PaymentManager narrow(org.omg.CORBA.Object object) {
    return narrow(object, false);
  }
  private static com.mcip.pay.orb.PaymentManager narrow(org.omg.CORBA.Object object, boolean is_a) {
    if(object == null) {
      return null;
    }
    if(object instanceof com.mcip.pay.orb.PaymentManager) {
      return (com.mcip.pay.orb.PaymentManager) object;
    }
    if(is_a || object._is_a(id())) {
      com.mcip.pay.orb._st_PaymentManager result = (com.mcip.pay.orb._st_PaymentManager)new com.mcip.pay.orb._st_PaymentManager();
      ((org.omg.CORBA.portable.ObjectImpl) result)._set_delegate
        (((org.omg.CORBA.portable.ObjectImpl) object)._get_delegate());
      ((org.omg.CORBA.portable.ObjectImpl) result._this())._set_delegate
        (((org.omg.CORBA.portable.ObjectImpl) object)._get_delegate());
      return (com.mcip.pay.orb.PaymentManager) result._this();
    }
    return null;
  }
  public static com.mcip.pay.orb.PaymentManager bind(org.omg.CORBA.ORB orb) {
    return bind(orb, null, null, null);
  }
  public static com.mcip.pay.orb.PaymentManager bind(org.omg.CORBA.ORB orb, java.lang.String name) {
    return bind(orb, name, null, null);
  }
  public static com.mcip.pay.orb.PaymentManager bind(org.omg.CORBA.ORB orb, java.lang.String name, java.lang.String host, org.omg.CORBA.BindOptions options) {
    if (orb instanceof com.visigenic.vbroker.orb.ORB) {
      return narrow(((com.visigenic.vbroker.orb.ORB)orb).bind(id(), name, host, options), true);
    }
    else {
      throw new org.omg.CORBA.BAD_PARAM();
    }
  }
  private static org.omg.CORBA.ORB _orb() {
    return org.omg.CORBA.ORB.init();
  }
  public static com.mcip.pay.orb.PaymentManager read(org.omg.CORBA.portable.InputStream _input) {
    return com.mcip.pay.orb.PaymentManagerHelper.narrow(_input.read_Object(), true);
  }
  public static void write(org.omg.CORBA.portable.OutputStream _output, com.mcip.pay.orb.PaymentManager value) {
    _output.write_Object(value);
  }
  public static void insert(org.omg.CORBA.Any any, com.mcip.pay.orb.PaymentManager value) {
    org.omg.CORBA.portable.OutputStream output = any.create_output_stream();
    write(output, value);
    any.read_value(output.create_input_stream(), type());
  }
  public static com.mcip.pay.orb.PaymentManager extract(org.omg.CORBA.Any any) {
    if(!any.type().equal(type())) {
      throw new org.omg.CORBA.BAD_TYPECODE();
    }
    return read(any.create_input_stream());
  }
  private static org.omg.CORBA.TypeCode _type;
  public static org.omg.CORBA.TypeCode type() {
    if(_type == null) {
      _type = _orb().create_interface_tc(id(), "PaymentManager");
    }
    return _type;
  }
  public static java.lang.String id() {
    return "IDL:com/mcip/pay/orb/PaymentManager:1.0";
  }
}
