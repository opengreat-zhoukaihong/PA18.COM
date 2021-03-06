package com.mcip.pay.orb;
/**
<p>
<ul>
<li> <b>Java Class</b> com.mcip.pay.orb._example_PaymentManager
<li> <b>Source File</b> com/mcip/pay/orb/_example_PaymentManager.java
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
public class _example_PaymentManager extends com.mcip.pay.orb._PaymentManagerImplBase {
  /** Construct a persistently named object. */
  public _example_PaymentManager(java.lang.String name) {
    super(name);
  }
  /** Construct a transient object. */
  public _example_PaymentManager() {
    super();
  }
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
    // IMPLEMENT: Operation
    return null;
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
    // IMPLEMENT: Operation
    return null;
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
    // IMPLEMENT: Operation
    return null;
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
    // IMPLEMENT: Operation
    return false;
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
    // IMPLEMENT: Operation
    return false;
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
    // IMPLEMENT: Operation
    return null;
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
    // IMPLEMENT: Operation
    return null;
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
    // IMPLEMENT: Operation
    return null;
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
    // IMPLEMENT: Operation
    return false;
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
    // IMPLEMENT: Operation
    return null;
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
    // IMPLEMENT: Operation
    return false;
  }
}
