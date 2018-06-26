package com.mcip.pay.orb;
/**
<p>
<ul>
<li> <b>Java Class</b> com.mcip.pay.orb._PaymentManagerImplBase
<li> <b>Source File</b> com/mcip/pay/orb/_PaymentManagerImplBase.java
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
abstract public class _PaymentManagerImplBase extends com.inprise.vbroker.CORBA.portable.Skeleton implements com.mcip.pay.orb.PaymentManager {
  protected com.mcip.pay.orb.PaymentManager _wrapper = null;
  public com.mcip.pay.orb.PaymentManager _this() {
    return this;
  }
  protected _PaymentManagerImplBase(java.lang.String name) {
    super(name);
  }
  public _PaymentManagerImplBase() {
  }
  public java.lang.String toString() {
    try {
      return super.toString();
    } catch (org.omg.CORBA.SystemException ex) { // delegate may not be set yet
      return "Unbound instance of com.mcip.pay.orb.PaymentManager";
    }
  }
  public java.lang.String[] _ids() {
    return __ids;
  }
  private static java.lang.String[] __ids = {
    "IDL:com/mcip/pay/orb/PaymentManager:1.0"
  };
  public org.omg.CORBA.portable.MethodPointer[] _methods() {
    org.omg.CORBA.portable.MethodPointer[] methods = {
      new org.omg.CORBA.portable.MethodPointer("queryLastPayment", 0, 0),
      new org.omg.CORBA.portable.MethodPointer("queryPaymentList", 0, 1),
      new org.omg.CORBA.portable.MethodPointer("queryPaymentLog", 0, 2),
      new org.omg.CORBA.portable.MethodPointer("acceptPaymentLog", 0, 3),
      new org.omg.CORBA.portable.MethodPointer("updatePayFlag", 0, 4),
      new org.omg.CORBA.portable.MethodPointer("getPaymentLogList", 0, 5),
      new org.omg.CORBA.portable.MethodPointer("getBankPayList", 0, 6),
      new org.omg.CORBA.portable.MethodPointer("getDptPayList", 0, 7),
      new org.omg.CORBA.portable.MethodPointer("updatePaymentLog", 0, 8),
      new org.omg.CORBA.portable.MethodPointer("getPayStatusList", 0, 9),
      new org.omg.CORBA.portable.MethodPointer("setPayFlag", 0, 10),
    };
    return methods;
  }
  public boolean _execute(org.omg.CORBA.portable.MethodPointer method, org.omg.CORBA.portable.InputStream input, org.omg.CORBA.portable.OutputStream output) {
    switch(method.interface_id) {
    case 0: {
      return com.mcip.pay.orb._PaymentManagerImplBase._execute(_this(), method.method_id, input, output); 
    }
    }
    throw new org.omg.CORBA.MARSHAL();
  }
  public static boolean _execute(com.mcip.pay.orb.PaymentManager _self, int _method_id, org.omg.CORBA.portable.InputStream _input, org.omg.CORBA.portable.OutputStream _output) {
    switch(_method_id) {
    case 0: {
      try {
        java.lang.String order_no;
        order_no = _input.read_string();
        java.lang.String tran_type;
        tran_type = _input.read_string();
        java.lang.String user_id;
        user_id = _input.read_wstring();
        java.lang.String pay_amt;
        pay_amt = _input.read_string();
        java.lang.String order_tm;
        order_tm = _input.read_string();
        java.lang.String[][] _result = _self.queryLastPayment(order_no,tran_type,user_id,pay_amt,order_tm);
        com.mcip.orb.StringssHelper.write(_output, _result);
      }
      catch(com.mcip.orb.CoException _exception) {
        com.mcip.orb.CoExceptionHelper.write(_output, _exception);
        return true;
      }
      return false;
    }
    case 1: {
      try {
        java.lang.String order_no;
        order_no = _input.read_string();
        java.lang.String tran_type;
        tran_type = _input.read_string();
        java.lang.String user_id;
        user_id = _input.read_wstring();
        java.lang.String pay_amt;
        pay_amt = _input.read_string();
        java.lang.String order_tm;
        order_tm = _input.read_string();
        java.lang.String[][] _result = _self.queryPaymentList(order_no,tran_type,user_id,pay_amt,order_tm);
        com.mcip.orb.StringssHelper.write(_output, _result);
      }
      catch(com.mcip.orb.CoException _exception) {
        com.mcip.orb.CoExceptionHelper.write(_output, _exception);
        return true;
      }
      return false;
    }
    case 2: {
      try {
        java.lang.String in_p_id;
        in_p_id = _input.read_string();
        java.lang.String[][] _result = _self.queryPaymentLog(in_p_id);
        com.mcip.orb.StringssHelper.write(_output, _result);
      }
      catch(com.mcip.orb.CoException _exception) {
        com.mcip.orb.CoExceptionHelper.write(_output, _exception);
        return true;
      }
      return false;
    }
    case 3: {
      try {
        com.mcip.pay.orb.PaymentLog paymentlogobj;
        paymentlogobj = com.mcip.pay.orb.PaymentLogHelper.read(_input);
        boolean _result = _self.acceptPaymentLog(paymentlogobj);
        _output.write_boolean(_result);
      }
      catch(com.mcip.orb.CoException _exception) {
        com.mcip.orb.CoExceptionHelper.write(_output, _exception);
        return true;
      }
      return false;
    }
    case 4: {
      try {
        java.lang.String plcy_no;
        plcy_no = _input.read_string();
        java.lang.String pay_flag;
        pay_flag = _input.read_string();
        java.lang.String in_session_id;
        in_session_id = _input.read_string();
        java.lang.String bank_cde;
        bank_cde = _input.read_wstring();
        java.lang.String bank_nme;
        bank_nme = _input.read_wstring();
        java.lang.String bank_accnt;
        bank_accnt = _input.read_wstring();
        java.lang.String in_got_prm;
        in_got_prm = _input.read_string();
        java.lang.String in_cur_typ;
        in_cur_typ = _input.read_string();
        java.lang.String pay_tm;
        pay_tm = _input.read_string();
        java.lang.String pay_type;
        pay_type = _input.read_string();
        java.lang.String pay_cde;
        pay_cde = _input.read_string();
        java.lang.String app_typ;
        app_typ = _input.read_string();
        boolean _result = _self.updatePayFlag(plcy_no,pay_flag,in_session_id,bank_cde,bank_nme,bank_accnt,in_got_prm,in_cur_typ,pay_tm,pay_type,pay_cde,app_typ);
        _output.write_boolean(_result);
      }
      catch(com.mcip.orb.CoException _exception) {
        com.mcip.orb.CoExceptionHelper.write(_output, _exception);
        return true;
      }
      return false;
    }
    case 5: {
      try {
        java.lang.String frm_pay_tm;
        frm_pay_tm = _input.read_string();
        java.lang.String to_pay_tm;
        to_pay_tm = _input.read_string();
        java.lang.String[] owned_dpt;
        owned_dpt = com.mcip.orb.StringsHelper.read(_input);
        java.lang.String in_trans_id;
        in_trans_id = _input.read_wstring();
        java.lang.String in_order_no;
        in_order_no = _input.read_wstring();
        java.lang.String in_payment_id;
        in_payment_id = _input.read_wstring();
        java.lang.String in_cur_typ;
        in_cur_typ = _input.read_wstring();
        java.lang.String in_user_id;
        in_user_id = _input.read_wstring();
        java.lang.String[][] _result = _self.getPaymentLogList(frm_pay_tm,to_pay_tm,owned_dpt,in_trans_id,in_order_no,in_payment_id,in_cur_typ,in_user_id);
        com.mcip.orb.StringssHelper.write(_output, _result);
      }
      catch(com.mcip.orb.CoException _exception) {
        com.mcip.orb.CoExceptionHelper.write(_output, _exception);
        return true;
      }
      return false;
    }
    case 6: {
      try {
        java.lang.String frm_pay_tm;
        frm_pay_tm = _input.read_string();
        java.lang.String to_pay_tm;
        to_pay_tm = _input.read_string();
        java.lang.String[] owned_dpt;
        owned_dpt = com.mcip.orb.StringsHelper.read(_input);
        java.lang.String frm_insrnc_cde;
        frm_insrnc_cde = _input.read_string();
        java.lang.String to_insrnc_cde;
        to_insrnc_cde = _input.read_string();
        java.lang.String in_bank_cde;
        in_bank_cde = _input.read_wstring();
        java.lang.String[][] _result = _self.getBankPayList(frm_pay_tm,to_pay_tm,owned_dpt,frm_insrnc_cde,to_insrnc_cde,in_bank_cde);
        com.mcip.orb.StringssHelper.write(_output, _result);
      }
      catch(com.mcip.orb.CoException _exception) {
        com.mcip.orb.CoExceptionHelper.write(_output, _exception);
        return true;
      }
      return false;
    }
    case 7: {
      try {
        java.lang.String frm_undr_tm;
        frm_undr_tm = _input.read_string();
        java.lang.String to_undr_tm;
        to_undr_tm = _input.read_string();
        java.lang.String[] owned_dpt;
        owned_dpt = com.mcip.orb.StringsHelper.read(_input);
        java.lang.String frm_insrnc_cde;
        frm_insrnc_cde = _input.read_string();
        java.lang.String to_insrnc_cde;
        to_insrnc_cde = _input.read_string();
        java.lang.String in_bank_cde;
        in_bank_cde = _input.read_wstring();
        java.lang.String[][] _result = _self.getDptPayList(frm_undr_tm,to_undr_tm,owned_dpt,frm_insrnc_cde,to_insrnc_cde,in_bank_cde);
        com.mcip.orb.StringssHelper.write(_output, _result);
      }
      catch(com.mcip.orb.CoException _exception) {
        com.mcip.orb.CoExceptionHelper.write(_output, _exception);
        return true;
      }
      return false;
    }
    case 8: {
      try {
        com.mcip.pay.orb.PaymentLog paymentlogobj;
        paymentlogobj = com.mcip.pay.orb.PaymentLogHelper.read(_input);
        boolean _result = _self.updatePaymentLog(paymentlogobj);
        _output.write_boolean(_result);
      }
      catch(com.mcip.orb.CoException _exception) {
        com.mcip.orb.CoExceptionHelper.write(_output, _exception);
        return true;
      }
      return false;
    }
    case 9: {
      try {
        java.lang.String[][] _result = _self.getPayStatusList();
        com.mcip.orb.StringssHelper.write(_output, _result);
      }
      catch(com.mcip.orb.CoException _exception) {
        com.mcip.orb.CoExceptionHelper.write(_output, _exception);
        return true;
      }
      return false;
    }
    case 10: {
      try {
        java.lang.String[][] payinfo;
        payinfo = com.mcip.orb.StringssHelper.read(_input);
        boolean _result = _self.setPayFlag(payinfo);
        _output.write_boolean(_result);
      }
      catch(com.mcip.orb.CoException _exception) {
        com.mcip.orb.CoExceptionHelper.write(_output, _exception);
        return true;
      }
      return false;
    }
    }
    throw new org.omg.CORBA.MARSHAL();
  }
}
