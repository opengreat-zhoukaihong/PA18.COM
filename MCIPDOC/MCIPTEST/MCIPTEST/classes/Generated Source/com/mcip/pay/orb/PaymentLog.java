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
public final class PaymentLog implements org.omg.CORBA.portable.IDLEntity {
  
  public java.lang.String c_trans_id;
  
  public java.lang.String c_bank_cde;
  
  public java.lang.String c_bank_cnm;
  
  public java.lang.String c_bank_accnt;
  
  public double n_got_prm;
  
  public java.lang.String c_cur_typ;
  
  public java.lang.String c_cur_sbl;
  
  public java.lang.String c_cur_cnm;
  
  public java.lang.String t_pay_tm;
  
  public java.lang.String c_pay_typ;
  
  public java.lang.String c_pay_cde;
  
  public java.lang.String c_order_no;
  
  public java.lang.String t_order_tm;
  
  public java.lang.String c_type_id;
  
  public java.lang.String c_payment_id;
  
  public java.lang.String c_pay_seq_no;
  
  public java.lang.String c_status_id;
  
  public java.lang.String c_user_id;

  public PaymentLog () {
  }

  public PaymentLog (final java.lang.String c_trans_id, 
                     final java.lang.String c_bank_cde, 
                     final java.lang.String c_bank_cnm, 
                     final java.lang.String c_bank_accnt, 
                     final double n_got_prm, 
                     final java.lang.String c_cur_typ, 
                     final java.lang.String c_cur_sbl, 
                     final java.lang.String c_cur_cnm, 
                     final java.lang.String t_pay_tm, 
                     final java.lang.String c_pay_typ, 
                     final java.lang.String c_pay_cde, 
                     final java.lang.String c_order_no, 
                     final java.lang.String t_order_tm, 
                     final java.lang.String c_type_id, 
                     final java.lang.String c_payment_id, 
                     final java.lang.String c_pay_seq_no, 
                     final java.lang.String c_status_id, 
                     final java.lang.String c_user_id) {
    this.c_trans_id = c_trans_id;
    this.c_bank_cde = c_bank_cde;
    this.c_bank_cnm = c_bank_cnm;
    this.c_bank_accnt = c_bank_accnt;
    this.n_got_prm = n_got_prm;
    this.c_cur_typ = c_cur_typ;
    this.c_cur_sbl = c_cur_sbl;
    this.c_cur_cnm = c_cur_cnm;
    this.t_pay_tm = t_pay_tm;
    this.c_pay_typ = c_pay_typ;
    this.c_pay_cde = c_pay_cde;
    this.c_order_no = c_order_no;
    this.t_order_tm = t_order_tm;
    this.c_type_id = c_type_id;
    this.c_payment_id = c_payment_id;
    this.c_pay_seq_no = c_pay_seq_no;
    this.c_status_id = c_status_id;
    this.c_user_id = c_user_id;
  }

  public java.lang.String toString() {
    final java.lang.StringBuffer _ret = new java.lang.StringBuffer("struct com.mcip.pay.orb.PaymentLog {");
    _ret.append("\n");
    _ret.append("java.lang.String c_trans_id=");
    _ret.append(c_trans_id != null?'\"' + c_trans_id + '\"':null);
    _ret.append(",\n");
    _ret.append("java.lang.String c_bank_cde=");
    _ret.append(c_bank_cde != null?'\"' + c_bank_cde + '\"':null);
    _ret.append(",\n");
    _ret.append("java.lang.String c_bank_cnm=");
    _ret.append(c_bank_cnm != null?'\"' + c_bank_cnm + '\"':null);
    _ret.append(",\n");
    _ret.append("java.lang.String c_bank_accnt=");
    _ret.append(c_bank_accnt != null?'\"' + c_bank_accnt + '\"':null);
    _ret.append(",\n");
    _ret.append("double n_got_prm=");
    _ret.append(n_got_prm);
    _ret.append(",\n");
    _ret.append("java.lang.String c_cur_typ=");
    _ret.append(c_cur_typ != null?'\"' + c_cur_typ + '\"':null);
    _ret.append(",\n");
    _ret.append("java.lang.String c_cur_sbl=");
    _ret.append(c_cur_sbl != null?'\"' + c_cur_sbl + '\"':null);
    _ret.append(",\n");
    _ret.append("java.lang.String c_cur_cnm=");
    _ret.append(c_cur_cnm != null?'\"' + c_cur_cnm + '\"':null);
    _ret.append(",\n");
    _ret.append("java.lang.String t_pay_tm=");
    _ret.append(t_pay_tm != null?'\"' + t_pay_tm + '\"':null);
    _ret.append(",\n");
    _ret.append("java.lang.String c_pay_typ=");
    _ret.append(c_pay_typ != null?'\"' + c_pay_typ + '\"':null);
    _ret.append(",\n");
    _ret.append("java.lang.String c_pay_cde=");
    _ret.append(c_pay_cde != null?'\"' + c_pay_cde + '\"':null);
    _ret.append(",\n");
    _ret.append("java.lang.String c_order_no=");
    _ret.append(c_order_no != null?'\"' + c_order_no + '\"':null);
    _ret.append(",\n");
    _ret.append("java.lang.String t_order_tm=");
    _ret.append(t_order_tm != null?'\"' + t_order_tm + '\"':null);
    _ret.append(",\n");
    _ret.append("java.lang.String c_type_id=");
    _ret.append(c_type_id != null?'\"' + c_type_id + '\"':null);
    _ret.append(",\n");
    _ret.append("java.lang.String c_payment_id=");
    _ret.append(c_payment_id != null?'\"' + c_payment_id + '\"':null);
    _ret.append(",\n");
    _ret.append("java.lang.String c_pay_seq_no=");
    _ret.append(c_pay_seq_no != null?'\"' + c_pay_seq_no + '\"':null);
    _ret.append(",\n");
    _ret.append("java.lang.String c_status_id=");
    _ret.append(c_status_id != null?'\"' + c_status_id + '\"':null);
    _ret.append(",\n");
    _ret.append("java.lang.String c_user_id=");
    _ret.append(c_user_id != null?'\"' + c_user_id + '\"':null);
    _ret.append("\n");
    _ret.append("}");
    return _ret.toString();
  }

  public boolean equals (java.lang.Object o) {
    if (this == o) return true;
    if (o == null) return false;

    if (o instanceof com.mcip.pay.orb.PaymentLog) {
      final com.mcip.pay.orb.PaymentLog obj = (com.mcip.pay.orb.PaymentLog)o;
      boolean res = true;
      do {
        res = this.c_trans_id == obj.c_trans_id ||
         (this.c_trans_id != null && obj.c_trans_id != null && this.c_trans_id.equals(obj.c_trans_id));
        if (!res) break;
        res = this.c_bank_cde == obj.c_bank_cde ||
         (this.c_bank_cde != null && obj.c_bank_cde != null && this.c_bank_cde.equals(obj.c_bank_cde));
        if (!res) break;
        res = this.c_bank_cnm == obj.c_bank_cnm ||
         (this.c_bank_cnm != null && obj.c_bank_cnm != null && this.c_bank_cnm.equals(obj.c_bank_cnm));
        if (!res) break;
        res = this.c_bank_accnt == obj.c_bank_accnt ||
         (this.c_bank_accnt != null && obj.c_bank_accnt != null && this.c_bank_accnt.equals(obj.c_bank_accnt));
        if (!res) break;
        res = this.n_got_prm == obj.n_got_prm;
        if (!res) break;
        res = this.c_cur_typ == obj.c_cur_typ ||
         (this.c_cur_typ != null && obj.c_cur_typ != null && this.c_cur_typ.equals(obj.c_cur_typ));
        if (!res) break;
        res = this.c_cur_sbl == obj.c_cur_sbl ||
         (this.c_cur_sbl != null && obj.c_cur_sbl != null && this.c_cur_sbl.equals(obj.c_cur_sbl));
        if (!res) break;
        res = this.c_cur_cnm == obj.c_cur_cnm ||
         (this.c_cur_cnm != null && obj.c_cur_cnm != null && this.c_cur_cnm.equals(obj.c_cur_cnm));
        if (!res) break;
        res = this.t_pay_tm == obj.t_pay_tm ||
         (this.t_pay_tm != null && obj.t_pay_tm != null && this.t_pay_tm.equals(obj.t_pay_tm));
        if (!res) break;
        res = this.c_pay_typ == obj.c_pay_typ ||
         (this.c_pay_typ != null && obj.c_pay_typ != null && this.c_pay_typ.equals(obj.c_pay_typ));
        if (!res) break;
        res = this.c_pay_cde == obj.c_pay_cde ||
         (this.c_pay_cde != null && obj.c_pay_cde != null && this.c_pay_cde.equals(obj.c_pay_cde));
        if (!res) break;
        res = this.c_order_no == obj.c_order_no ||
         (this.c_order_no != null && obj.c_order_no != null && this.c_order_no.equals(obj.c_order_no));
        if (!res) break;
        res = this.t_order_tm == obj.t_order_tm ||
         (this.t_order_tm != null && obj.t_order_tm != null && this.t_order_tm.equals(obj.t_order_tm));
        if (!res) break;
        res = this.c_type_id == obj.c_type_id ||
         (this.c_type_id != null && obj.c_type_id != null && this.c_type_id.equals(obj.c_type_id));
        if (!res) break;
        res = this.c_payment_id == obj.c_payment_id ||
         (this.c_payment_id != null && obj.c_payment_id != null && this.c_payment_id.equals(obj.c_payment_id));
        if (!res) break;
        res = this.c_pay_seq_no == obj.c_pay_seq_no ||
         (this.c_pay_seq_no != null && obj.c_pay_seq_no != null && this.c_pay_seq_no.equals(obj.c_pay_seq_no));
        if (!res) break;
        res = this.c_status_id == obj.c_status_id ||
         (this.c_status_id != null && obj.c_status_id != null && this.c_status_id.equals(obj.c_status_id));
        if (!res) break;
        res = this.c_user_id == obj.c_user_id ||
         (this.c_user_id != null && obj.c_user_id != null && this.c_user_id.equals(obj.c_user_id));
      } while (false);
      return res;
    }
    else {
      return false;
    }
  }
}
