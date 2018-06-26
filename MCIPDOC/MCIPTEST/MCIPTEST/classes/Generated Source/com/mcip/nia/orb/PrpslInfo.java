package com.mcip.nia.orb;

/**
 * <ul>
 * <li> <b>IDL Source</b>    "D:/Kevin/MCIPDOC/MCIPTEST/MCIPTEST/src/IDL/policyInfoStruct.idl"
 * <li> <b>IDL Name</b>      ::com::mcip::nia::orb::PrpslInfo
 * <li> <b>Repository Id</b> IDL:com/mcip/nia/orb/PrpslInfo:1.0
 * </ul>
 * <b>IDL definition:</b>
 * <pre>
 * struct PrpslInfo {
  ...
};
 * </pre>
 */
public final class PrpslInfo implements org.omg.CORBA.portable.IDLEntity {
  
  public java.lang.String c_doc_no;
  
  public double n_rate;
  
  public java.lang.String c_no_repay;
  
  public java.lang.String c_undr_cndtn;
  
  public java.lang.String t_send_tm;
  
  public java.lang.String c_send_desc;
  
  public java.lang.String c_undr_prsn;
  
  public java.lang.String t_sign_tm;
  
  public java.lang.String c_user_id;
  
  public java.lang.String c_remark;
  
  public java.lang.String c_user_remark;

  public PrpslInfo () {
  }

  public PrpslInfo (final java.lang.String c_doc_no, 
                    final double n_rate, 
                    final java.lang.String c_no_repay, 
                    final java.lang.String c_undr_cndtn, 
                    final java.lang.String t_send_tm, 
                    final java.lang.String c_send_desc, 
                    final java.lang.String c_undr_prsn, 
                    final java.lang.String t_sign_tm, 
                    final java.lang.String c_user_id, 
                    final java.lang.String c_remark, 
                    final java.lang.String c_user_remark) {
    this.c_doc_no = c_doc_no;
    this.n_rate = n_rate;
    this.c_no_repay = c_no_repay;
    this.c_undr_cndtn = c_undr_cndtn;
    this.t_send_tm = t_send_tm;
    this.c_send_desc = c_send_desc;
    this.c_undr_prsn = c_undr_prsn;
    this.t_sign_tm = t_sign_tm;
    this.c_user_id = c_user_id;
    this.c_remark = c_remark;
    this.c_user_remark = c_user_remark;
  }

  public java.lang.String toString() {
    final java.lang.StringBuffer _ret = new java.lang.StringBuffer("struct com.mcip.nia.orb.PrpslInfo {");
    _ret.append("\n");
    _ret.append("java.lang.String c_doc_no=");
    _ret.append(c_doc_no != null?'\"' + c_doc_no + '\"':null);
    _ret.append(",\n");
    _ret.append("double n_rate=");
    _ret.append(n_rate);
    _ret.append(",\n");
    _ret.append("java.lang.String c_no_repay=");
    _ret.append(c_no_repay != null?'\"' + c_no_repay + '\"':null);
    _ret.append(",\n");
    _ret.append("java.lang.String c_undr_cndtn=");
    _ret.append(c_undr_cndtn != null?'\"' + c_undr_cndtn + '\"':null);
    _ret.append(",\n");
    _ret.append("java.lang.String t_send_tm=");
    _ret.append(t_send_tm != null?'\"' + t_send_tm + '\"':null);
    _ret.append(",\n");
    _ret.append("java.lang.String c_send_desc=");
    _ret.append(c_send_desc != null?'\"' + c_send_desc + '\"':null);
    _ret.append(",\n");
    _ret.append("java.lang.String c_undr_prsn=");
    _ret.append(c_undr_prsn != null?'\"' + c_undr_prsn + '\"':null);
    _ret.append(",\n");
    _ret.append("java.lang.String t_sign_tm=");
    _ret.append(t_sign_tm != null?'\"' + t_sign_tm + '\"':null);
    _ret.append(",\n");
    _ret.append("java.lang.String c_user_id=");
    _ret.append(c_user_id != null?'\"' + c_user_id + '\"':null);
    _ret.append(",\n");
    _ret.append("java.lang.String c_remark=");
    _ret.append(c_remark != null?'\"' + c_remark + '\"':null);
    _ret.append(",\n");
    _ret.append("java.lang.String c_user_remark=");
    _ret.append(c_user_remark != null?'\"' + c_user_remark + '\"':null);
    _ret.append("\n");
    _ret.append("}");
    return _ret.toString();
  }

  public boolean equals (java.lang.Object o) {
    if (this == o) return true;
    if (o == null) return false;

    if (o instanceof com.mcip.nia.orb.PrpslInfo) {
      final com.mcip.nia.orb.PrpslInfo obj = (com.mcip.nia.orb.PrpslInfo)o;
      boolean res = true;
      do {
        res = this.c_doc_no == obj.c_doc_no ||
         (this.c_doc_no != null && obj.c_doc_no != null && this.c_doc_no.equals(obj.c_doc_no));
        if (!res) break;
        res = this.n_rate == obj.n_rate;
        if (!res) break;
        res = this.c_no_repay == obj.c_no_repay ||
         (this.c_no_repay != null && obj.c_no_repay != null && this.c_no_repay.equals(obj.c_no_repay));
        if (!res) break;
        res = this.c_undr_cndtn == obj.c_undr_cndtn ||
         (this.c_undr_cndtn != null && obj.c_undr_cndtn != null && this.c_undr_cndtn.equals(obj.c_undr_cndtn));
        if (!res) break;
        res = this.t_send_tm == obj.t_send_tm ||
         (this.t_send_tm != null && obj.t_send_tm != null && this.t_send_tm.equals(obj.t_send_tm));
        if (!res) break;
        res = this.c_send_desc == obj.c_send_desc ||
         (this.c_send_desc != null && obj.c_send_desc != null && this.c_send_desc.equals(obj.c_send_desc));
        if (!res) break;
        res = this.c_undr_prsn == obj.c_undr_prsn ||
         (this.c_undr_prsn != null && obj.c_undr_prsn != null && this.c_undr_prsn.equals(obj.c_undr_prsn));
        if (!res) break;
        res = this.t_sign_tm == obj.t_sign_tm ||
         (this.t_sign_tm != null && obj.t_sign_tm != null && this.t_sign_tm.equals(obj.t_sign_tm));
        if (!res) break;
        res = this.c_user_id == obj.c_user_id ||
         (this.c_user_id != null && obj.c_user_id != null && this.c_user_id.equals(obj.c_user_id));
        if (!res) break;
        res = this.c_remark == obj.c_remark ||
         (this.c_remark != null && obj.c_remark != null && this.c_remark.equals(obj.c_remark));
        if (!res) break;
        res = this.c_user_remark == obj.c_user_remark ||
         (this.c_user_remark != null && obj.c_user_remark != null && this.c_user_remark.equals(obj.c_user_remark));
      } while (false);
      return res;
    }
    else {
      return false;
    }
  }
}
