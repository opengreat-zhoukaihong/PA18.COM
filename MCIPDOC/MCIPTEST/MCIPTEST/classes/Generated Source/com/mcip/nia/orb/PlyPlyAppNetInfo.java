package com.mcip.nia.orb;

/**
 * <ul>
 * <li> <b>IDL Source</b>    "D:/Kevin/MCIPDOC/MCIPTEST/MCIPTEST/src/IDL/policyInfoStruct.idl"
 * <li> <b>IDL Name</b>      ::com::mcip::nia::orb::PlyPlyAppNetInfo
 * <li> <b>Repository Id</b> IDL:com/mcip/nia/orb/PlyPlyAppNetInfo:1.0
 * </ul>
 * <b>IDL definition:</b>
 * <pre>
 * struct PlyPlyAppNetInfo {
  ...
};
 * </pre>
 */
public final class PlyPlyAppNetInfo implements org.omg.CORBA.portable.IDLEntity {
  
  public java.lang.String c_crt_cde;
  
  public java.lang.String c_crt_tm;
  
  public java.lang.String c_upd_cde;
  
  public java.lang.String c_upd_tm;
  
  public java.lang.String c_ply_app_no;
  
  public java.lang.String n_user_seq_no;
  
  public java.lang.String t_freeback_tm;
  
  public java.lang.String t_print_tm;
  
  public java.lang.String c_province;
  
  public java.lang.String c_city;
  
  public java.lang.String c_place;
  
  public java.lang.String c_contact_name;
  
  public java.lang.String c_contact_phone;
  
  public java.lang.String c_contact_fax;
  
  public java.lang.String c_contact_email;
  
  public java.lang.String c_site_cde;
  
  public java.lang.String c_rec_no;
  
  public java.lang.String c_send_flag;
  
  public java.lang.String c_send_emp_cde;
  
  public java.lang.String c_prt_emp_cde;
  
  public java.lang.String t_send_tm;
  
  public java.lang.String t_sended_tm;
  
  public java.lang.String c_zip_cde;
  
  public java.lang.String c_pay_flag;
  
  public java.lang.String c_session_id;
  
  public java.lang.String c_bank_cde;
  
  public java.lang.String c_bank_cnm;
  
  public java.lang.String c_bank_accnt;
  
  public java.lang.String n_got_prm;
  
  public java.lang.String c_cur_typ;
  
  public java.lang.String t_pay_tm;
  
  public java.lang.String c_pay_typ;
  
  public java.lang.String c_pay_cde;

  public PlyPlyAppNetInfo () {
  }

  public PlyPlyAppNetInfo (final java.lang.String c_crt_cde, 
                           final java.lang.String c_crt_tm, 
                           final java.lang.String c_upd_cde, 
                           final java.lang.String c_upd_tm, 
                           final java.lang.String c_ply_app_no, 
                           final java.lang.String n_user_seq_no, 
                           final java.lang.String t_freeback_tm, 
                           final java.lang.String t_print_tm, 
                           final java.lang.String c_province, 
                           final java.lang.String c_city, 
                           final java.lang.String c_place, 
                           final java.lang.String c_contact_name, 
                           final java.lang.String c_contact_phone, 
                           final java.lang.String c_contact_fax, 
                           final java.lang.String c_contact_email, 
                           final java.lang.String c_site_cde, 
                           final java.lang.String c_rec_no, 
                           final java.lang.String c_send_flag, 
                           final java.lang.String c_send_emp_cde, 
                           final java.lang.String c_prt_emp_cde, 
                           final java.lang.String t_send_tm, 
                           final java.lang.String t_sended_tm, 
                           final java.lang.String c_zip_cde, 
                           final java.lang.String c_pay_flag, 
                           final java.lang.String c_session_id, 
                           final java.lang.String c_bank_cde, 
                           final java.lang.String c_bank_cnm, 
                           final java.lang.String c_bank_accnt, 
                           final java.lang.String n_got_prm, 
                           final java.lang.String c_cur_typ, 
                           final java.lang.String t_pay_tm, 
                           final java.lang.String c_pay_typ, 
                           final java.lang.String c_pay_cde) {
    this.c_crt_cde = c_crt_cde;
    this.c_crt_tm = c_crt_tm;
    this.c_upd_cde = c_upd_cde;
    this.c_upd_tm = c_upd_tm;
    this.c_ply_app_no = c_ply_app_no;
    this.n_user_seq_no = n_user_seq_no;
    this.t_freeback_tm = t_freeback_tm;
    this.t_print_tm = t_print_tm;
    this.c_province = c_province;
    this.c_city = c_city;
    this.c_place = c_place;
    this.c_contact_name = c_contact_name;
    this.c_contact_phone = c_contact_phone;
    this.c_contact_fax = c_contact_fax;
    this.c_contact_email = c_contact_email;
    this.c_site_cde = c_site_cde;
    this.c_rec_no = c_rec_no;
    this.c_send_flag = c_send_flag;
    this.c_send_emp_cde = c_send_emp_cde;
    this.c_prt_emp_cde = c_prt_emp_cde;
    this.t_send_tm = t_send_tm;
    this.t_sended_tm = t_sended_tm;
    this.c_zip_cde = c_zip_cde;
    this.c_pay_flag = c_pay_flag;
    this.c_session_id = c_session_id;
    this.c_bank_cde = c_bank_cde;
    this.c_bank_cnm = c_bank_cnm;
    this.c_bank_accnt = c_bank_accnt;
    this.n_got_prm = n_got_prm;
    this.c_cur_typ = c_cur_typ;
    this.t_pay_tm = t_pay_tm;
    this.c_pay_typ = c_pay_typ;
    this.c_pay_cde = c_pay_cde;
  }

  public java.lang.String toString() {
    final java.lang.StringBuffer _ret = new java.lang.StringBuffer("struct com.mcip.nia.orb.PlyPlyAppNetInfo {");
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
    _ret.append("java.lang.String c_ply_app_no=");
    _ret.append(c_ply_app_no != null?'\"' + c_ply_app_no + '\"':null);
    _ret.append(",\n");
    _ret.append("java.lang.String n_user_seq_no=");
    _ret.append(n_user_seq_no != null?'\"' + n_user_seq_no + '\"':null);
    _ret.append(",\n");
    _ret.append("java.lang.String t_freeback_tm=");
    _ret.append(t_freeback_tm != null?'\"' + t_freeback_tm + '\"':null);
    _ret.append(",\n");
    _ret.append("java.lang.String t_print_tm=");
    _ret.append(t_print_tm != null?'\"' + t_print_tm + '\"':null);
    _ret.append(",\n");
    _ret.append("java.lang.String c_province=");
    _ret.append(c_province != null?'\"' + c_province + '\"':null);
    _ret.append(",\n");
    _ret.append("java.lang.String c_city=");
    _ret.append(c_city != null?'\"' + c_city + '\"':null);
    _ret.append(",\n");
    _ret.append("java.lang.String c_place=");
    _ret.append(c_place != null?'\"' + c_place + '\"':null);
    _ret.append(",\n");
    _ret.append("java.lang.String c_contact_name=");
    _ret.append(c_contact_name != null?'\"' + c_contact_name + '\"':null);
    _ret.append(",\n");
    _ret.append("java.lang.String c_contact_phone=");
    _ret.append(c_contact_phone != null?'\"' + c_contact_phone + '\"':null);
    _ret.append(",\n");
    _ret.append("java.lang.String c_contact_fax=");
    _ret.append(c_contact_fax != null?'\"' + c_contact_fax + '\"':null);
    _ret.append(",\n");
    _ret.append("java.lang.String c_contact_email=");
    _ret.append(c_contact_email != null?'\"' + c_contact_email + '\"':null);
    _ret.append(",\n");
    _ret.append("java.lang.String c_site_cde=");
    _ret.append(c_site_cde != null?'\"' + c_site_cde + '\"':null);
    _ret.append(",\n");
    _ret.append("java.lang.String c_rec_no=");
    _ret.append(c_rec_no != null?'\"' + c_rec_no + '\"':null);
    _ret.append(",\n");
    _ret.append("java.lang.String c_send_flag=");
    _ret.append(c_send_flag != null?'\"' + c_send_flag + '\"':null);
    _ret.append(",\n");
    _ret.append("java.lang.String c_send_emp_cde=");
    _ret.append(c_send_emp_cde != null?'\"' + c_send_emp_cde + '\"':null);
    _ret.append(",\n");
    _ret.append("java.lang.String c_prt_emp_cde=");
    _ret.append(c_prt_emp_cde != null?'\"' + c_prt_emp_cde + '\"':null);
    _ret.append(",\n");
    _ret.append("java.lang.String t_send_tm=");
    _ret.append(t_send_tm != null?'\"' + t_send_tm + '\"':null);
    _ret.append(",\n");
    _ret.append("java.lang.String t_sended_tm=");
    _ret.append(t_sended_tm != null?'\"' + t_sended_tm + '\"':null);
    _ret.append(",\n");
    _ret.append("java.lang.String c_zip_cde=");
    _ret.append(c_zip_cde != null?'\"' + c_zip_cde + '\"':null);
    _ret.append(",\n");
    _ret.append("java.lang.String c_pay_flag=");
    _ret.append(c_pay_flag != null?'\"' + c_pay_flag + '\"':null);
    _ret.append(",\n");
    _ret.append("java.lang.String c_session_id=");
    _ret.append(c_session_id != null?'\"' + c_session_id + '\"':null);
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
    _ret.append("java.lang.String n_got_prm=");
    _ret.append(n_got_prm != null?'\"' + n_got_prm + '\"':null);
    _ret.append(",\n");
    _ret.append("java.lang.String c_cur_typ=");
    _ret.append(c_cur_typ != null?'\"' + c_cur_typ + '\"':null);
    _ret.append(",\n");
    _ret.append("java.lang.String t_pay_tm=");
    _ret.append(t_pay_tm != null?'\"' + t_pay_tm + '\"':null);
    _ret.append(",\n");
    _ret.append("java.lang.String c_pay_typ=");
    _ret.append(c_pay_typ != null?'\"' + c_pay_typ + '\"':null);
    _ret.append(",\n");
    _ret.append("java.lang.String c_pay_cde=");
    _ret.append(c_pay_cde != null?'\"' + c_pay_cde + '\"':null);
    _ret.append("\n");
    _ret.append("}");
    return _ret.toString();
  }

  public boolean equals (java.lang.Object o) {
    if (this == o) return true;
    if (o == null) return false;

    if (o instanceof com.mcip.nia.orb.PlyPlyAppNetInfo) {
      final com.mcip.nia.orb.PlyPlyAppNetInfo obj = (com.mcip.nia.orb.PlyPlyAppNetInfo)o;
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
        res = this.c_ply_app_no == obj.c_ply_app_no ||
         (this.c_ply_app_no != null && obj.c_ply_app_no != null && this.c_ply_app_no.equals(obj.c_ply_app_no));
        if (!res) break;
        res = this.n_user_seq_no == obj.n_user_seq_no ||
         (this.n_user_seq_no != null && obj.n_user_seq_no != null && this.n_user_seq_no.equals(obj.n_user_seq_no));
        if (!res) break;
        res = this.t_freeback_tm == obj.t_freeback_tm ||
         (this.t_freeback_tm != null && obj.t_freeback_tm != null && this.t_freeback_tm.equals(obj.t_freeback_tm));
        if (!res) break;
        res = this.t_print_tm == obj.t_print_tm ||
         (this.t_print_tm != null && obj.t_print_tm != null && this.t_print_tm.equals(obj.t_print_tm));
        if (!res) break;
        res = this.c_province == obj.c_province ||
         (this.c_province != null && obj.c_province != null && this.c_province.equals(obj.c_province));
        if (!res) break;
        res = this.c_city == obj.c_city ||
         (this.c_city != null && obj.c_city != null && this.c_city.equals(obj.c_city));
        if (!res) break;
        res = this.c_place == obj.c_place ||
         (this.c_place != null && obj.c_place != null && this.c_place.equals(obj.c_place));
        if (!res) break;
        res = this.c_contact_name == obj.c_contact_name ||
         (this.c_contact_name != null && obj.c_contact_name != null && this.c_contact_name.equals(obj.c_contact_name));
        if (!res) break;
        res = this.c_contact_phone == obj.c_contact_phone ||
         (this.c_contact_phone != null && obj.c_contact_phone != null && this.c_contact_phone.equals(obj.c_contact_phone));
        if (!res) break;
        res = this.c_contact_fax == obj.c_contact_fax ||
         (this.c_contact_fax != null && obj.c_contact_fax != null && this.c_contact_fax.equals(obj.c_contact_fax));
        if (!res) break;
        res = this.c_contact_email == obj.c_contact_email ||
         (this.c_contact_email != null && obj.c_contact_email != null && this.c_contact_email.equals(obj.c_contact_email));
        if (!res) break;
        res = this.c_site_cde == obj.c_site_cde ||
         (this.c_site_cde != null && obj.c_site_cde != null && this.c_site_cde.equals(obj.c_site_cde));
        if (!res) break;
        res = this.c_rec_no == obj.c_rec_no ||
         (this.c_rec_no != null && obj.c_rec_no != null && this.c_rec_no.equals(obj.c_rec_no));
        if (!res) break;
        res = this.c_send_flag == obj.c_send_flag ||
         (this.c_send_flag != null && obj.c_send_flag != null && this.c_send_flag.equals(obj.c_send_flag));
        if (!res) break;
        res = this.c_send_emp_cde == obj.c_send_emp_cde ||
         (this.c_send_emp_cde != null && obj.c_send_emp_cde != null && this.c_send_emp_cde.equals(obj.c_send_emp_cde));
        if (!res) break;
        res = this.c_prt_emp_cde == obj.c_prt_emp_cde ||
         (this.c_prt_emp_cde != null && obj.c_prt_emp_cde != null && this.c_prt_emp_cde.equals(obj.c_prt_emp_cde));
        if (!res) break;
        res = this.t_send_tm == obj.t_send_tm ||
         (this.t_send_tm != null && obj.t_send_tm != null && this.t_send_tm.equals(obj.t_send_tm));
        if (!res) break;
        res = this.t_sended_tm == obj.t_sended_tm ||
         (this.t_sended_tm != null && obj.t_sended_tm != null && this.t_sended_tm.equals(obj.t_sended_tm));
        if (!res) break;
        res = this.c_zip_cde == obj.c_zip_cde ||
         (this.c_zip_cde != null && obj.c_zip_cde != null && this.c_zip_cde.equals(obj.c_zip_cde));
        if (!res) break;
        res = this.c_pay_flag == obj.c_pay_flag ||
         (this.c_pay_flag != null && obj.c_pay_flag != null && this.c_pay_flag.equals(obj.c_pay_flag));
        if (!res) break;
        res = this.c_session_id == obj.c_session_id ||
         (this.c_session_id != null && obj.c_session_id != null && this.c_session_id.equals(obj.c_session_id));
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
        res = this.n_got_prm == obj.n_got_prm ||
         (this.n_got_prm != null && obj.n_got_prm != null && this.n_got_prm.equals(obj.n_got_prm));
        if (!res) break;
        res = this.c_cur_typ == obj.c_cur_typ ||
         (this.c_cur_typ != null && obj.c_cur_typ != null && this.c_cur_typ.equals(obj.c_cur_typ));
        if (!res) break;
        res = this.t_pay_tm == obj.t_pay_tm ||
         (this.t_pay_tm != null && obj.t_pay_tm != null && this.t_pay_tm.equals(obj.t_pay_tm));
        if (!res) break;
        res = this.c_pay_typ == obj.c_pay_typ ||
         (this.c_pay_typ != null && obj.c_pay_typ != null && this.c_pay_typ.equals(obj.c_pay_typ));
        if (!res) break;
        res = this.c_pay_cde == obj.c_pay_cde ||
         (this.c_pay_cde != null && obj.c_pay_cde != null && this.c_pay_cde.equals(obj.c_pay_cde));
      } while (false);
      return res;
    }
    else {
      return false;
    }
  }
}
