package com.mcip.pay.orb;
/**
<p>
<ul>
<li> <b>Java Class</b> com.mcip.pay.orb._st_PaymentManager
<li> <b>Source File</b> com/mcip/pay/orb/_st_PaymentManager.java
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
public class _st_PaymentManager extends com.inprise.vbroker.CORBA.portable.ObjectImpl implements com.mcip.pay.orb.PaymentManager {
  protected com.mcip.pay.orb.PaymentManager _wrapper = null;
  public com.mcip.pay.orb.PaymentManager _this() {
    return this;
  }
  public java.lang.String[] _ids() {
    return __ids;
  }
  private static java.lang.String[] __ids = {
    "IDL:com/mcip/pay/orb/PaymentManager:1.0"
  };
  /**
  <p>
  Operation: <b>::com::mcip::pay::orb::PaymentManager::queryLastPayment</b>.
  <pre>
    #pragma prefix "com/mcip/pay/orb/PaymentManager"
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
  </pre>
  </p>
  */
  public java.lang.String[][] queryLastPayment(
    java.lang.String order_no,
    java.lang.String tran_type,
    java.lang.String user_id,
    java.lang.String pay_amt,
    java.lang.String order_tm
  ) throws
    com.mcip.orb.CoException {
    org.omg.CORBA.portable.OutputStream _output;
    org.omg.CORBA.portable.InputStream _input;
    java.lang.String[][] _result;
    while(true) {
      _output = this._request("queryLastPayment", true);
      _output.write_string(order_no);
      _output.write_string(tran_type);
      _output.write_wstring(user_id);
      _output.write_string(pay_amt);
      _output.write_string(order_tm);
      org.omg.CORBA.StringHolder _exception_id = new org.omg.CORBA.StringHolder();
      try {
        _input = this._invoke(_output, _exception_id);
        if(_exception_id.value != null) {
          if(_exception_id.value.equals(com.mcip.orb.CoExceptionHelper.id())) {
            throw com.mcip.orb.CoExceptionHelper.read(_input);
          }
          throw new org.omg.CORBA.MARSHAL
            ("Unexpected User Exception: " + _exception_id.value);
        }
        _result = com.mcip.orb.StringssHelper.read(_input);
      }
      catch(org.omg.CORBA.TRANSIENT _exception) {
        continue;
      }
      break;
    }
    return _result;
  }
  /**
  <p>
  Operation: <b>::com::mcip::pay::orb::PaymentManager::queryPaymentList</b>.
  <pre>
    #pragma prefix "com/mcip/pay/orb/PaymentManager"
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
  </pre>
  </p>
  */
  public java.lang.String[][] queryPaymentList(
    java.lang.String order_no,
    java.lang.String tran_type,
    java.lang.String user_id,
    java.lang.String pay_amt,
    java.lang.String order_tm
  ) throws
    com.mcip.orb.CoException {
    org.omg.CORBA.portable.OutputStream _output;
    org.omg.CORBA.portable.InputStream _input;
    java.lang.String[][] _result;
    while(true) {
      _output = this._request("queryPaymentList", true);
      _output.write_string(order_no);
      _output.write_string(tran_type);
      _output.write_wstring(user_id);
      _output.write_string(pay_amt);
      _output.write_string(order_tm);
      org.omg.CORBA.StringHolder _exception_id = new org.omg.CORBA.StringHolder();
      try {
        _input = this._invoke(_output, _exception_id);
        if(_exception_id.value != null) {
          if(_exception_id.value.equals(com.mcip.orb.CoExceptionHelper.id())) {
            throw com.mcip.orb.CoExceptionHelper.read(_input);
          }
          throw new org.omg.CORBA.MARSHAL
            ("Unexpected User Exception: " + _exception_id.value);
        }
        _result = com.mcip.orb.StringssHelper.read(_input);
      }
      catch(org.omg.CORBA.TRANSIENT _exception) {
        continue;
      }
      break;
    }
    return _result;
  }
  /**
  <p>
  Operation: <b>::com::mcip::pay::orb::PaymentManager::queryPaymentLog</b>.
  <pre>
    #pragma prefix "com/mcip/pay/orb/PaymentManager"
    ::com::mcip::orb::Stringss queryPaymentLog(
      in string in_p_id
    )
    raises(
      ::com::mcip::orb::CoException
    );
  </pre>
  </p>
  */
  public java.lang.String[][] queryPaymentLog(
    java.lang.String in_p_id
  ) throws
    com.mcip.orb.CoException {
    org.omg.CORBA.portable.OutputStream _output;
    org.omg.CORBA.portable.InputStream _input;
    java.lang.String[][] _result;
    while(true) {
      _output = this._request("queryPaymentLog", true);
      _output.write_string(in_p_id);
      org.omg.CORBA.StringHolder _exception_id = new org.omg.CORBA.StringHolder();
      try {
        _input = this._invoke(_output, _exception_id);
        if(_exception_id.value != null) {
          if(_exception_id.value.equals(com.mcip.orb.CoExceptionHelper.id())) {
            throw com.mcip.orb.CoExceptionHelper.read(_input);
          }
          throw new org.omg.CORBA.MARSHAL
            ("Unexpected User Exception: " + _exception_id.value);
        }
        _result = com.mcip.orb.StringssHelper.read(_input);
      }
      catch(org.omg.CORBA.TRANSIENT _exception) {
        continue;
      }
      break;
    }
    return _result;
  }
  /**
  <p>
  Operation: <b>::com::mcip::pay::orb::PaymentManager::acceptPaymentLog</b>.
  <pre>
    #pragma prefix "com/mcip/pay/orb/PaymentManager"
    boolean acceptPaymentLog(
      in ::com::mcip::pay::orb::PaymentLog paymentlogobj
    )
    raises(
      ::com::mcip::orb::CoException
    );
  </pre>
  </p>
  */
  public boolean acceptPaymentLog(
    com.mcip.pay.orb.PaymentLog paymentlogobj
  ) throws
    com.mcip.orb.CoException {
    org.omg.CORBA.portable.OutputStream _output;
    org.omg.CORBA.portable.InputStream _input;
    boolean _result;
    while(true) {
      _output = this._request("acceptPaymentLog", true);
      com.mcip.pay.orb.PaymentLogHelper.write(_output, paymentlogobj);
      org.omg.CORBA.StringHolder _exception_id = new org.omg.CORBA.StringHolder();
      try {
        _input = this._invoke(_output, _exception_id);
        if(_exception_id.value != null) {
          if(_exception_id.value.equals(com.mcip.orb.CoExceptionHelper.id())) {
            throw com.mcip.orb.CoExceptionHelper.read(_input);
          }
          throw new org.omg.CORBA.MARSHAL
            ("Unexpected User Exception: " + _exception_id.value);
        }
        _result = _input.read_boolean();
      }
      catch(org.omg.CORBA.TRANSIENT _exception) {
        continue;
      }
      break;
    }
    return _result;
  }
  /**
  <p>
  Operation: <b>::com::mcip::pay::orb::PaymentManager::updatePayFlag</b>.
  <pre>
    #pragma prefix "com/mcip/pay/orb/PaymentManager"
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
  </pre>
  </p>
  */
  public boolean updatePayFlag(
    java.lang.String plcy_no,
    java.lang.String pay_flag,
    java.lang.String in_session_id,
    java.lang.String bank_cde,
    java.lang.String bank_nme,
    java.lang.String bank_accnt,
    java.lang.String in_got_prm,
    java.lang.String in_cur_typ,
    java.lang.String pay_tm,
    java.lang.String pay_type,
    java.lang.String pay_cde,
    java.lang.String app_typ
  ) throws
    com.mcip.orb.CoException {
    org.omg.CORBA.portable.OutputStream _output;
    org.omg.CORBA.portable.InputStream _input;
    boolean _result;
    while(true) {
      _output = this._request("updatePayFlag", true);
      _output.write_string(plcy_no);
      _output.write_string(pay_flag);
      _output.write_string(in_session_id);
      _output.write_wstring(bank_cde);
      _output.write_wstring(bank_nme);
      _output.write_wstring(bank_accnt);
      _output.write_string(in_got_prm);
      _output.write_string(in_cur_typ);
      _output.write_string(pay_tm);
      _output.write_string(pay_type);
      _output.write_string(pay_cde);
      _output.write_string(app_typ);
      org.omg.CORBA.StringHolder _exception_id = new org.omg.CORBA.StringHolder();
      try {
        _input = this._invoke(_output, _exception_id);
        if(_exception_id.value != null) {
          if(_exception_id.value.equals(com.mcip.orb.CoExceptionHelper.id())) {
            throw com.mcip.orb.CoExceptionHelper.read(_input);
          }
          throw new org.omg.CORBA.MARSHAL
            ("Unexpected User Exception: " + _exception_id.value);
        }
        _result = _input.read_boolean();
      }
      catch(org.omg.CORBA.TRANSIENT _exception) {
        continue;
      }
      break;
    }
    return _result;
  }
  /**
  <p>
  Operation: <b>::com::mcip::pay::orb::PaymentManager::getPaymentLogList</b>.
  <pre>
    #pragma prefix "com/mcip/pay/orb/PaymentManager"
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
  </pre>
  </p>
  */
  public java.lang.String[][] getPaymentLogList(
    java.lang.String frm_pay_tm,
    java.lang.String to_pay_tm,
    java.lang.String[] owned_dpt,
    java.lang.String in_trans_id,
    java.lang.String in_order_no,
    java.lang.String in_payment_id,
    java.lang.String in_cur_typ,
    java.lang.String in_user_id
  ) throws
    com.mcip.orb.CoException {
    org.omg.CORBA.portable.OutputStream _output;
    org.omg.CORBA.portable.InputStream _input;
    java.lang.String[][] _result;
    while(true) {
      _output = this._request("getPaymentLogList", true);
      _output.write_string(frm_pay_tm);
      _output.write_string(to_pay_tm);
      com.mcip.orb.StringsHelper.write(_output, owned_dpt);
      _output.write_wstring(in_trans_id);
      _output.write_wstring(in_order_no);
      _output.write_wstring(in_payment_id);
      _output.write_wstring(in_cur_typ);
      _output.write_wstring(in_user_id);
      org.omg.CORBA.StringHolder _exception_id = new org.omg.CORBA.StringHolder();
      try {
        _input = this._invoke(_output, _exception_id);
        if(_exception_id.value != null) {
          if(_exception_id.value.equals(com.mcip.orb.CoExceptionHelper.id())) {
            throw com.mcip.orb.CoExceptionHelper.read(_input);
          }
          throw new org.omg.CORBA.MARSHAL
            ("Unexpected User Exception: " + _exception_id.value);
        }
        _result = com.mcip.orb.StringssHelper.read(_input);
      }
      catch(org.omg.CORBA.TRANSIENT _exception) {
        continue;
      }
      break;
    }
    return _result;
  }
  /**
  <p>
  Operation: <b>::com::mcip::pay::orb::PaymentManager::getBankPayList</b>.
  <pre>
    #pragma prefix "com/mcip/pay/orb/PaymentManager"
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
  </pre>
  </p>
  */
  public java.lang.String[][] getBankPayList(
    java.lang.String frm_pay_tm,
    java.lang.String to_pay_tm,
    java.lang.String[] owned_dpt,
    java.lang.String frm_insrnc_cde,
    java.lang.String to_insrnc_cde,
    java.lang.String in_bank_cde
  ) throws
    com.mcip.orb.CoException {
    org.omg.CORBA.portable.OutputStream _output;
    org.omg.CORBA.portable.InputStream _input;
    java.lang.String[][] _result;
    while(true) {
      _output = this._request("getBankPayList", true);
      _output.write_string(frm_pay_tm);
      _output.write_string(to_pay_tm);
      com.mcip.orb.StringsHelper.write(_output, owned_dpt);
      _output.write_string(frm_insrnc_cde);
      _output.write_string(to_insrnc_cde);
      _output.write_wstring(in_bank_cde);
      org.omg.CORBA.StringHolder _exception_id = new org.omg.CORBA.StringHolder();
      try {
        _input = this._invoke(_output, _exception_id);
        if(_exception_id.value != null) {
          if(_exception_id.value.equals(com.mcip.orb.CoExceptionHelper.id())) {
            throw com.mcip.orb.CoExceptionHelper.read(_input);
          }
          throw new org.omg.CORBA.MARSHAL
            ("Unexpected User Exception: " + _exception_id.value);
        }
        _result = com.mcip.orb.StringssHelper.read(_input);
      }
      catch(org.omg.CORBA.TRANSIENT _exception) {
        continue;
      }
      break;
    }
    return _result;
  }
  /**
  <p>
  Operation: <b>::com::mcip::pay::orb::PaymentManager::getDptPayList</b>.
  <pre>
    #pragma prefix "com/mcip/pay/orb/PaymentManager"
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
  </pre>
  </p>
  */
  public java.lang.String[][] getDptPayList(
    java.lang.String frm_undr_tm,
    java.lang.String to_undr_tm,
    java.lang.String[] owned_dpt,
    java.lang.String frm_insrnc_cde,
    java.lang.String to_insrnc_cde,
    java.lang.String in_bank_cde
  ) throws
    com.mcip.orb.CoException {
    org.omg.CORBA.portable.OutputStream _output;
    org.omg.CORBA.portable.InputStream _input;
    java.lang.String[][] _result;
    while(true) {
      _output = this._request("getDptPayList", true);
      _output.write_string(frm_undr_tm);
      _output.write_string(to_undr_tm);
      com.mcip.orb.StringsHelper.write(_output, owned_dpt);
      _output.write_string(frm_insrnc_cde);
      _output.write_string(to_insrnc_cde);
      _output.write_wstring(in_bank_cde);
      org.omg.CORBA.StringHolder _exception_id = new org.omg.CORBA.StringHolder();
      try {
        _input = this._invoke(_output, _exception_id);
        if(_exception_id.value != null) {
          if(_exception_id.value.equals(com.mcip.orb.CoExceptionHelper.id())) {
            throw com.mcip.orb.CoExceptionHelper.read(_input);
          }
          throw new org.omg.CORBA.MARSHAL
            ("Unexpected User Exception: " + _exception_id.value);
        }
        _result = com.mcip.orb.StringssHelper.read(_input);
      }
      catch(org.omg.CORBA.TRANSIENT _exception) {
        continue;
      }
      break;
    }
    return _result;
  }
  /**
  <p>
  Operation: <b>::com::mcip::pay::orb::PaymentManager::updatePaymentLog</b>.
  <pre>
    #pragma prefix "com/mcip/pay/orb/PaymentManager"
    boolean updatePaymentLog(
      in ::com::mcip::pay::orb::PaymentLog paymentlogobj
    )
    raises(
      ::com::mcip::orb::CoException
    );
  </pre>
  </p>
  */
  public boolean updatePaymentLog(
    com.mcip.pay.orb.PaymentLog paymentlogobj
  ) throws
    com.mcip.orb.CoException {
    org.omg.CORBA.portable.OutputStream _output;
    org.omg.CORBA.portable.InputStream _input;
    boolean _result;
    while(true) {
      _output = this._request("updatePaymentLog", true);
      com.mcip.pay.orb.PaymentLogHelper.write(_output, paymentlogobj);
      org.omg.CORBA.StringHolder _exception_id = new org.omg.CORBA.StringHolder();
      try {
        _input = this._invoke(_output, _exception_id);
        if(_exception_id.value != null) {
          if(_exception_id.value.equals(com.mcip.orb.CoExceptionHelper.id())) {
            throw com.mcip.orb.CoExceptionHelper.read(_input);
          }
          throw new org.omg.CORBA.MARSHAL
            ("Unexpected User Exception: " + _exception_id.value);
        }
        _result = _input.read_boolean();
      }
      catch(org.omg.CORBA.TRANSIENT _exception) {
        continue;
      }
      break;
    }
    return _result;
  }
  /**
  <p>
  Operation: <b>::com::mcip::pay::orb::PaymentManager::getPayStatusList</b>.
  <pre>
    #pragma prefix "com/mcip/pay/orb/PaymentManager"
    ::com::mcip::orb::Stringss getPayStatusList(
    )
    raises(
      ::com::mcip::orb::CoException
    );
  </pre>
  </p>
  */
  public java.lang.String[][] getPayStatusList(
  ) throws
    com.mcip.orb.CoException {
    org.omg.CORBA.portable.OutputStream _output;
    org.omg.CORBA.portable.InputStream _input;
    java.lang.String[][] _result;
    while(true) {
      _output = this._request("getPayStatusList", true);
      org.omg.CORBA.StringHolder _exception_id = new org.omg.CORBA.StringHolder();
      try {
        _input = this._invoke(_output, _exception_id);
        if(_exception_id.value != null) {
          if(_exception_id.value.equals(com.mcip.orb.CoExceptionHelper.id())) {
            throw com.mcip.orb.CoExceptionHelper.read(_input);
          }
          throw new org.omg.CORBA.MARSHAL
            ("Unexpected User Exception: " + _exception_id.value);
        }
        _result = com.mcip.orb.StringssHelper.read(_input);
      }
      catch(org.omg.CORBA.TRANSIENT _exception) {
        continue;
      }
      break;
    }
    return _result;
  }
  /**
  <p>
  Operation: <b>::com::mcip::pay::orb::PaymentManager::setPayFlag</b>.
  <pre>
    #pragma prefix "com/mcip/pay/orb/PaymentManager"
    boolean setPayFlag(
      in ::com::mcip::orb::Stringss payinfo
    )
    raises(
      ::com::mcip::orb::CoException
    );
  </pre>
  </p>
  */
  public boolean setPayFlag(
    java.lang.String[][] payinfo
  ) throws
    com.mcip.orb.CoException {
    org.omg.CORBA.portable.OutputStream _output;
    org.omg.CORBA.portable.InputStream _input;
    boolean _result;
    while(true) {
      _output = this._request("setPayFlag", true);
      com.mcip.orb.StringssHelper.write(_output, payinfo);
      org.omg.CORBA.StringHolder _exception_id = new org.omg.CORBA.StringHolder();
      try {
        _input = this._invoke(_output, _exception_id);
        if(_exception_id.value != null) {
          if(_exception_id.value.equals(com.mcip.orb.CoExceptionHelper.id())) {
            throw com.mcip.orb.CoExceptionHelper.read(_input);
          }
          throw new org.omg.CORBA.MARSHAL
            ("Unexpected User Exception: " + _exception_id.value);
        }
        _result = _input.read_boolean();
      }
      catch(org.omg.CORBA.TRANSIENT _exception) {
        continue;
      }
      break;
    }
    return _result;
  }
}
