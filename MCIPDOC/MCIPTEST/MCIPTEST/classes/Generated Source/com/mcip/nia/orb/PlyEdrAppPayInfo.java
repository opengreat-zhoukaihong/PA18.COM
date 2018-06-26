package com.mcip.nia.orb;

/**
 * <ul>
 * <li> <b>IDL Source</b>    "D:/Kevin/MCIPDOC/MCIPTEST/MCIPTEST/src/IDL/policyInfoStruct.idl"
 * <li> <b>IDL Name</b>      ::com::mcip::nia::orb::PlyEdrAppPayInfo
 * <li> <b>Repository Id</b> IDL:com/mcip/nia/orb/PlyEdrAppPayInfo:1.0
 * </ul>
 * <b>IDL definition:</b>
 * <pre>
 * struct PlyEdrAppPayInfo {
  ...
};
 * </pre>
 */
public final class PlyEdrAppPayInfo implements org.omg.CORBA.portable.IDLEntity {
  
  public java.lang.String c_crt_cde;
  
  public java.lang.String c_crt_tm;
  
  public java.lang.String c_upd_cde;
  
  public java.lang.String c_upd_tm;
  
  public java.lang.String c_edr_app_no;
  
  public java.lang.String n_tms;
  
  public java.lang.String c_rcpt_no;
  
  public java.lang.String c_pay_prsn_cde;
  
  public java.lang.String c_pay_prsn_nme;
  
  public java.lang.String n_get_prm;
  
  public java.lang.String c_pay_mde_cde;
  
  public java.lang.String c_accnt_no;
  
  public java.lang.String t_pay_lmt_tm;
  
  public java.lang.String n_got_prm;
  
  public java.lang.String t_pay_strt_tm;
  
  public java.lang.String t_pay_tm;
  
  public java.lang.String c_insrnc_cde;
  
  public java.lang.String c_cur_typ;
  
  public java.lang.String c_rec_no;
  
  public java.lang.String c_prn_typ;

  public PlyEdrAppPayInfo () {
  }

  public PlyEdrAppPayInfo (final java.lang.String c_crt_cde, 
                           final java.lang.String c_crt_tm, 
                           final java.lang.String c_upd_cde, 
                           final java.lang.String c_upd_tm, 
                           final java.lang.String c_edr_app_no, 
                           final java.lang.String n_tms, 
                           final java.lang.String c_rcpt_no, 
                           final java.lang.String c_pay_prsn_cde, 
                           final java.lang.String c_pay_prsn_nme, 
                           final java.lang.String n_get_prm, 
                           final java.lang.String c_pay_mde_cde, 
                           final java.lang.String c_accnt_no, 
                           final java.lang.String t_pay_lmt_tm, 
                           final java.lang.String n_got_prm, 
                           final java.lang.String t_pay_strt_tm, 
                           final java.lang.String t_pay_tm, 
                           final java.lang.String c_insrnc_cde, 
                           final java.lang.String c_cur_typ, 
                           final java.lang.String c_rec_no, 
                           final java.lang.String c_prn_typ) {
    this.c_crt_cde = c_crt_cde;
    this.c_crt_tm = c_crt_tm;
    this.c_upd_cde = c_upd_cde;
    this.c_upd_tm = c_upd_tm;
    this.c_edr_app_no = c_edr_app_no;
    this.n_tms = n_tms;
    this.c_rcpt_no = c_rcpt_no;
    this.c_pay_prsn_cde = c_pay_prsn_cde;
    this.c_pay_prsn_nme = c_pay_prsn_nme;
    this.n_get_prm = n_get_prm;
    this.c_pay_mde_cde = c_pay_mde_cde;
    this.c_accnt_no = c_accnt_no;
    this.t_pay_lmt_tm = t_pay_lmt_tm;
    this.n_got_prm = n_got_prm;
    this.t_pay_strt_tm = t_pay_strt_tm;
    this.t_pay_tm = t_pay_tm;
    this.c_insrnc_cde = c_insrnc_cde;
    this.c_cur_typ = c_cur_typ;
    this.c_rec_no = c_rec_no;
    this.c_prn_typ = c_prn_typ;
  }

  public java.lang.String toString() {
    final java.lang.StringBuffer _ret = new java.lang.StringBuffer("struct com.mcip.nia.orb.PlyEdrAppPayInfo {");
    _ret.append("\n");
    _ret.append("java.lang.String c_crt_cde=");
    _ret.append(c_crt_cde != null?'\"' + c_crt_cde + '\"':null);
    _ret.append(",\n");
    _ret.append("java.lang.String c_crt_tm=");
    _ret.append(c_crt_tm != null?'\"' + c_crt_tm + '\"':null);
    _ret.append(",\n");
    _ret.append("java.lang.String c_upd_cde=");
    _ret.append(c_upd_cde != null?'\"' + c_upd_cde + '\"':null);
    _ret.append(",\n");
    _ret.append("java.lang.String c_upd_tm=");
    _ret.append(c_upd_tm != null?'\"' + c_upd_tm + '\"':null);
    _ret.append(",\n");
    _ret.append("java.lang.String c_edr_app_no=");
    _ret.append(c_edr_app_no != null?'\"' + c_edr_app_no + '\"':null);
    _ret.append(",\n");
    _ret.append("java.lang.String n_tms=");
    _ret.append(n_tms != null?'\"' + n_tms + '\"':null);
    _ret.append(",\n");
    _ret.append("java.lang.String c_rcpt_no=");
    _ret.append(c_rcpt_no != null?'\"' + c_rcpt_no + '\"':null);
    _ret.append(",\n");
    _ret.append("java.lang.String c_pay_prsn_cde=");
    _ret.append(c_pay_prsn_cde != null?'\"' + c_pay_prsn_cde + '\"':null);
    _ret.append(",\n");
    _ret.append("java.lang.String c_pay_prsn_nme=");
    _ret.append(c_pay_prsn_nme != null?'\"' + c_pay_prsn_nme + '\"':null);
    _ret.append(",\n");
    _ret.append("java.lang.String n_get_prm=");
    _ret.append(n_get_prm != null?'\"' + n_get_prm + '\"':null);
    _ret.append(",\n");
    _ret.append("java.lang.String c_pay_mde_cde=");
    _ret.append(c_pay_mde_cde != null?'\"' + c_pay_mde_cde + '\"':null);
    _ret.append(",\n");
    _ret.append("java.lang.String c_accnt_no=");
    _ret.append(c_accnt_no != null?'\"' + c_accnt_no + '\"':null);
    _ret.append(",\n");
    _ret.append("java.lang.String t_pay_lmt_tm=");
    _ret.append(t_pay_lmt_tm != null?'\"' + t_pay_lmt_tm + '\"':null);
    _ret.append(",\n");
    _ret.append("java.lang.String n_got_prm=");
    _ret.append(n_got_prm != null?'\"' + n_got_prm + '\"':null);
    _ret.append(",\n");
    _ret.append("java.lang.String t_pay_strt_tm=");
    _ret.append(t_pay_strt_tm != null?'\"' + t_pay_strt_tm + '\"':null);
    _ret.append(",\n");
    _ret.append("java.lang.String t_pay_tm=");
    _ret.append(t_pay_tm != null?'\"' + t_pay_tm + '\"':null);
    _ret.append(",\n");
    _ret.append("java.lang.String c_insrnc_cde=");
    _ret.append(c_insrnc_cde != null?'\"' + c_insrnc_cde + '\"':null);
    _ret.append(",\n");
    _ret.append("java.lang.String c_cur_typ=");
    _ret.append(c_cur_typ != null?'\"' + c_cur_typ + '\"':null);
    _ret.append(",\n");
    _ret.append("java.lang.String c_rec_no=");
    _ret.append(c_rec_no != null?'\"' + c_rec_no + '\"':null);
    _ret.append(",\n");
    _ret.append("java.lang.String c_prn_typ=");
    _ret.append(c_prn_typ != null?'\"' + c_prn_typ + '\"':null);
    _ret.append("\n");
    _ret.append("}");
    return _ret.toString();
  }

  public boolean equals (java.lang.Object o) {
    if (this == o) return true;
    if (o == null) return false;

    if (o instanceof com.mcip.nia.orb.PlyEdrAppPayInfo) {
      final com.mcip.nia.orb.PlyEdrAppPayInfo obj = (com.mcip.nia.orb.PlyEdrAppPayInfo)o;
      boolean res = true;
      do {
        res = this.c_crt_cde == obj.c_crt_cde ||
         (this.c_crt_cde != null && obj.c_crt_cde != null && this.c_crt_cde.equals(obj.c_crt_cde));
        if (!res) break;
        res = this.c_crt_tm == obj.c_crt_tm ||
         (this.c_crt_tm != null && obj.c_crt_tm != null && this.c_crt_tm.equals(obj.c_crt_tm));
        if (!res) break;
        res = this.c_upd_cde == obj.c_upd_cde ||
         (this.c_upd_cde != null && obj.c_upd_cde != null && this.c_upd_cde.equals(obj.c_upd_cde));
        if (!res) break;
        res = this.c_upd_tm == obj.c_upd_tm ||
         (this.c_upd_tm != null && obj.c_upd_tm != null && this.c_upd_tm.equals(obj.c_upd_tm));
        if (!res) break;
        res = this.c_edr_app_no == obj.c_edr_app_no ||
         (this.c_edr_app_no != null && obj.c_edr_app_no != null && this.c_edr_app_no.equals(obj.c_edr_app_no));
        if (!res) break;
        res = this.n_tms == obj.n_tms ||
         (this.n_tms != null && obj.n_tms != null && this.n_tms.equals(obj.n_tms));
        if (!res) break;
        res = this.c_rcpt_no == obj.c_rcpt_no ||
         (this.c_rcpt_no != null && obj.c_rcpt_no != null && this.c_rcpt_no.equals(obj.c_rcpt_no));
        if (!res) break;
        res = this.c_pay_prsn_cde == obj.c_pay_prsn_cde ||
         (this.c_pay_prsn_cde != null && obj.c_pay_prsn_cde != null && this.c_pay_prsn_cde.equals(obj.c_pay_prsn_cde));
        if (!res) break;
        res = this.c_pay_prsn_nme == obj.c_pay_prsn_nme ||
         (this.c_pay_prsn_nme != null && obj.c_pay_prsn_nme != null && this.c_pay_prsn_nme.equals(obj.c_pay_prsn_nme));
        if (!res) break;
        res = this.n_get_prm == obj.n_get_prm ||
         (this.n_get_prm != null && obj.n_get_prm != null && this.n_get_prm.equals(obj.n_get_prm));
        if (!res) break;
        res = this.c_pay_mde_cde == obj.c_pay_mde_cde ||
         (this.c_pay_mde_cde != null && obj.c_pay_mde_cde != null && this.c_pay_mde_cde.equals(obj.c_pay_mde_cde));
        if (!res) break;
        res = this.c_accnt_no == obj.c_accnt_no ||
         (this.c_accnt_no != null && obj.c_accnt_no != null && this.c_accnt_no.equals(obj.c_accnt_no));
        if (!res) break;
        res = this.t_pay_lmt_tm == obj.t_pay_lmt_tm ||
         (this.t_pay_lmt_tm != null && obj.t_pay_lmt_tm != null && this.t_pay_lmt_tm.equals(obj.t_pay_lmt_tm));
        if (!res) break;
        res = this.n_got_prm == obj.n_got_prm ||
         (this.n_got_prm != null && obj.n_got_prm != null && this.n_got_prm.equals(obj.n_got_prm));
        if (!res) break;
        res = this.t_pay_strt_tm == obj.t_pay_strt_tm ||
         (this.t_pay_strt_tm != null && obj.t_pay_strt_tm != null && this.t_pay_strt_tm.equals(obj.t_pay_strt_tm));
        if (!res) break;
        res = this.t_pay_tm == obj.t_pay_tm ||
         (this.t_pay_tm != null && obj.t_pay_tm != null && this.t_pay_tm.equals(obj.t_pay_tm));
        if (!res) break;
        res = this.c_insrnc_cde == obj.c_insrnc_cde ||
         (this.c_insrnc_cde != null && obj.c_insrnc_cde != null && this.c_insrnc_cde.equals(obj.c_insrnc_cde));
        if (!res) break;
        res = this.c_cur_typ == obj.c_cur_typ ||
         (this.c_cur_typ != null && obj.c_cur_typ != null && this.c_cur_typ.equals(obj.c_cur_typ));
        if (!res) break;
        res = this.c_rec_no == obj.c_rec_no ||
         (this.c_rec_no != null && obj.c_rec_no != null && this.c_rec_no.equals(obj.c_rec_no));
        if (!res) break;
        res = this.c_prn_typ == obj.c_prn_typ ||
         (this.c_prn_typ != null && obj.c_prn_typ != null && this.c_prn_typ.equals(obj.c_prn_typ));
      } while (false);
      return res;
    }
    else {
      return false;
    }
  }
}
