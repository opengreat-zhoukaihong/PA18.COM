package com.mcip.cus.orb;

/**
 * <ul>
 * <li> <b>IDL Source</b>    "D:/Kevin/MCIPDOC/MCIPTEST/MCIPTEST/src/IDL/custInfoStruct.idl"
 * <li> <b>IDL Name</b>      ::com::mcip::cus::orb::CustPrsn
 * <li> <b>Repository Id</b> IDL:com/mcip/cus/orb/CustPrsn:1.0
 * </ul>
 * <b>IDL definition:</b>
 * <pre>
 * struct CustPrsn {
  ...
};
 * </pre>
 */
public final class CustPrsn implements org.omg.CORBA.portable.IDLEntity {
  
  public java.lang.String c_clnt_cde;
  
  public java.lang.String c_dpt_cde;
  
  public int n_clnt_grp_cde;
  
  public java.lang.String c_clnt_mrk;
  
  public java.lang.String c_clnt_nme;
  
  public java.lang.String c_chn_abr;
  
  public java.lang.String c_auth_mrk;
  
  public java.lang.String c_brd_enm;
  
  public java.lang.String c_eng_abr;
  
  public java.lang.String c_rgst_no;
  
  public java.lang.String c_sex;
  
  public java.lang.String c_hmtwn;
  
  public java.lang.String c_ntn_cde;
  
  public java.lang.String t_birthday;
  
  public java.lang.String c_mrg_cde;
  
  public java.lang.String c_grdt;
  
  public java.lang.String c_major_cde;
  
  public java.lang.String c_edu_cde;
  
  public java.lang.String c_work_dpt;
  
  public java.lang.String c_title_cde;
  
  public java.lang.String c_duty;
  
  public java.lang.String c_tel;
  
  public java.lang.String c_fax;
  
  public java.lang.String c_email;
  
  public java.lang.String c_clnt_addr;
  
  public java.lang.String c_ara_cde;
  
  public java.lang.String c_province;
  
  public java.lang.String c_city;
  
  public java.lang.String c_place;
  
  public java.lang.String c_zip_cde;
  
  public java.lang.String c_bank;
  
  public java.lang.String c_accnt_no;
  
  public java.lang.String c_remark;
  
  public java.lang.String c_impt_clnt_cde;
  
  public java.lang.String t_upd_tm;

  public CustPrsn () {
  }

  public CustPrsn (final java.lang.String c_clnt_cde, 
                   final java.lang.String c_dpt_cde, 
                   final int n_clnt_grp_cde, 
                   final java.lang.String c_clnt_mrk, 
                   final java.lang.String c_clnt_nme, 
                   final java.lang.String c_chn_abr, 
                   final java.lang.String c_auth_mrk, 
                   final java.lang.String c_brd_enm, 
                   final java.lang.String c_eng_abr, 
                   final java.lang.String c_rgst_no, 
                   final java.lang.String c_sex, 
                   final java.lang.String c_hmtwn, 
                   final java.lang.String c_ntn_cde, 
                   final java.lang.String t_birthday, 
                   final java.lang.String c_mrg_cde, 
                   final java.lang.String c_grdt, 
                   final java.lang.String c_major_cde, 
                   final java.lang.String c_edu_cde, 
                   final java.lang.String c_work_dpt, 
                   final java.lang.String c_title_cde, 
                   final java.lang.String c_duty, 
                   final java.lang.String c_tel, 
                   final java.lang.String c_fax, 
                   final java.lang.String c_email, 
                   final java.lang.String c_clnt_addr, 
                   final java.lang.String c_ara_cde, 
                   final java.lang.String c_province, 
                   final java.lang.String c_city, 
                   final java.lang.String c_place, 
                   final java.lang.String c_zip_cde, 
                   final java.lang.String c_bank, 
                   final java.lang.String c_accnt_no, 
                   final java.lang.String c_remark, 
                   final java.lang.String c_impt_clnt_cde, 
                   final java.lang.String t_upd_tm) {
    this.c_clnt_cde = c_clnt_cde;
    this.c_dpt_cde = c_dpt_cde;
    this.n_clnt_grp_cde = n_clnt_grp_cde;
    this.c_clnt_mrk = c_clnt_mrk;
    this.c_clnt_nme = c_clnt_nme;
    this.c_chn_abr = c_chn_abr;
    this.c_auth_mrk = c_auth_mrk;
    this.c_brd_enm = c_brd_enm;
    this.c_eng_abr = c_eng_abr;
    this.c_rgst_no = c_rgst_no;
    this.c_sex = c_sex;
    this.c_hmtwn = c_hmtwn;
    this.c_ntn_cde = c_ntn_cde;
    this.t_birthday = t_birthday;
    this.c_mrg_cde = c_mrg_cde;
    this.c_grdt = c_grdt;
    this.c_major_cde = c_major_cde;
    this.c_edu_cde = c_edu_cde;
    this.c_work_dpt = c_work_dpt;
    this.c_title_cde = c_title_cde;
    this.c_duty = c_duty;
    this.c_tel = c_tel;
    this.c_fax = c_fax;
    this.c_email = c_email;
    this.c_clnt_addr = c_clnt_addr;
    this.c_ara_cde = c_ara_cde;
    this.c_province = c_province;
    this.c_city = c_city;
    this.c_place = c_place;
    this.c_zip_cde = c_zip_cde;
    this.c_bank = c_bank;
    this.c_accnt_no = c_accnt_no;
    this.c_remark = c_remark;
    this.c_impt_clnt_cde = c_impt_clnt_cde;
    this.t_upd_tm = t_upd_tm;
  }

  public java.lang.String toString() {
    final java.lang.StringBuffer _ret = new java.lang.StringBuffer("struct com.mcip.cus.orb.CustPrsn {");
    _ret.append("\n");
    _ret.append("java.lang.String c_clnt_cde=");
    _ret.append(c_clnt_cde != null?'\"' + c_clnt_cde + '\"':null);
    _ret.append(",\n");
    _ret.append("java.lang.String c_dpt_cde=");
    _ret.append(c_dpt_cde != null?'\"' + c_dpt_cde + '\"':null);
    _ret.append(",\n");
    _ret.append("int n_clnt_grp_cde=");
    _ret.append(n_clnt_grp_cde);
    _ret.append(",\n");
    _ret.append("java.lang.String c_clnt_mrk=");
    _ret.append(c_clnt_mrk != null?'\"' + c_clnt_mrk + '\"':null);
    _ret.append(",\n");
    _ret.append("java.lang.String c_clnt_nme=");
    _ret.append(c_clnt_nme != null?'\"' + c_clnt_nme + '\"':null);
    _ret.append(",\n");
    _ret.append("java.lang.String c_chn_abr=");
    _ret.append(c_chn_abr != null?'\"' + c_chn_abr + '\"':null);
    _ret.append(",\n");
    _ret.append("java.lang.String c_auth_mrk=");
    _ret.append(c_auth_mrk != null?'\"' + c_auth_mrk + '\"':null);
    _ret.append(",\n");
    _ret.append("java.lang.String c_brd_enm=");
    _ret.append(c_brd_enm != null?'\"' + c_brd_enm + '\"':null);
    _ret.append(",\n");
    _ret.append("java.lang.String c_eng_abr=");
    _ret.append(c_eng_abr != null?'\"' + c_eng_abr + '\"':null);
    _ret.append(",\n");
    _ret.append("java.lang.String c_rgst_no=");
    _ret.append(c_rgst_no != null?'\"' + c_rgst_no + '\"':null);
    _ret.append(",\n");
    _ret.append("java.lang.String c_sex=");
    _ret.append(c_sex != null?'\"' + c_sex + '\"':null);
    _ret.append(",\n");
    _ret.append("java.lang.String c_hmtwn=");
    _ret.append(c_hmtwn != null?'\"' + c_hmtwn + '\"':null);
    _ret.append(",\n");
    _ret.append("java.lang.String c_ntn_cde=");
    _ret.append(c_ntn_cde != null?'\"' + c_ntn_cde + '\"':null);
    _ret.append(",\n");
    _ret.append("java.lang.String t_birthday=");
    _ret.append(t_birthday != null?'\"' + t_birthday + '\"':null);
    _ret.append(",\n");
    _ret.append("java.lang.String c_mrg_cde=");
    _ret.append(c_mrg_cde != null?'\"' + c_mrg_cde + '\"':null);
    _ret.append(",\n");
    _ret.append("java.lang.String c_grdt=");
    _ret.append(c_grdt != null?'\"' + c_grdt + '\"':null);
    _ret.append(",\n");
    _ret.append("java.lang.String c_major_cde=");
    _ret.append(c_major_cde != null?'\"' + c_major_cde + '\"':null);
    _ret.append(",\n");
    _ret.append("java.lang.String c_edu_cde=");
    _ret.append(c_edu_cde != null?'\"' + c_edu_cde + '\"':null);
    _ret.append(",\n");
    _ret.append("java.lang.String c_work_dpt=");
    _ret.append(c_work_dpt != null?'\"' + c_work_dpt + '\"':null);
    _ret.append(",\n");
    _ret.append("java.lang.String c_title_cde=");
    _ret.append(c_title_cde != null?'\"' + c_title_cde + '\"':null);
    _ret.append(",\n");
    _ret.append("java.lang.String c_duty=");
    _ret.append(c_duty != null?'\"' + c_duty + '\"':null);
    _ret.append(",\n");
    _ret.append("java.lang.String c_tel=");
    _ret.append(c_tel != null?'\"' + c_tel + '\"':null);
    _ret.append(",\n");
    _ret.append("java.lang.String c_fax=");
    _ret.append(c_fax != null?'\"' + c_fax + '\"':null);
    _ret.append(",\n");
    _ret.append("java.lang.String c_email=");
    _ret.append(c_email != null?'\"' + c_email + '\"':null);
    _ret.append(",\n");
    _ret.append("java.lang.String c_clnt_addr=");
    _ret.append(c_clnt_addr != null?'\"' + c_clnt_addr + '\"':null);
    _ret.append(",\n");
    _ret.append("java.lang.String c_ara_cde=");
    _ret.append(c_ara_cde != null?'\"' + c_ara_cde + '\"':null);
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
    _ret.append("java.lang.String c_zip_cde=");
    _ret.append(c_zip_cde != null?'\"' + c_zip_cde + '\"':null);
    _ret.append(",\n");
    _ret.append("java.lang.String c_bank=");
    _ret.append(c_bank != null?'\"' + c_bank + '\"':null);
    _ret.append(",\n");
    _ret.append("java.lang.String c_accnt_no=");
    _ret.append(c_accnt_no != null?'\"' + c_accnt_no + '\"':null);
    _ret.append(",\n");
    _ret.append("java.lang.String c_remark=");
    _ret.append(c_remark != null?'\"' + c_remark + '\"':null);
    _ret.append(",\n");
    _ret.append("java.lang.String c_impt_clnt_cde=");
    _ret.append(c_impt_clnt_cde != null?'\"' + c_impt_clnt_cde + '\"':null);
    _ret.append(",\n");
    _ret.append("java.lang.String t_upd_tm=");
    _ret.append(t_upd_tm != null?'\"' + t_upd_tm + '\"':null);
    _ret.append("\n");
    _ret.append("}");
    return _ret.toString();
  }

  public boolean equals (java.lang.Object o) {
    if (this == o) return true;
    if (o == null) return false;

    if (o instanceof com.mcip.cus.orb.CustPrsn) {
      final com.mcip.cus.orb.CustPrsn obj = (com.mcip.cus.orb.CustPrsn)o;
      boolean res = true;
      do {
        res = this.c_clnt_cde == obj.c_clnt_cde ||
         (this.c_clnt_cde != null && obj.c_clnt_cde != null && this.c_clnt_cde.equals(obj.c_clnt_cde));
        if (!res) break;
        res = this.c_dpt_cde == obj.c_dpt_cde ||
         (this.c_dpt_cde != null && obj.c_dpt_cde != null && this.c_dpt_cde.equals(obj.c_dpt_cde));
        if (!res) break;
        res = this.n_clnt_grp_cde == obj.n_clnt_grp_cde;
        if (!res) break;
        res = this.c_clnt_mrk == obj.c_clnt_mrk ||
         (this.c_clnt_mrk != null && obj.c_clnt_mrk != null && this.c_clnt_mrk.equals(obj.c_clnt_mrk));
        if (!res) break;
        res = this.c_clnt_nme == obj.c_clnt_nme ||
         (this.c_clnt_nme != null && obj.c_clnt_nme != null && this.c_clnt_nme.equals(obj.c_clnt_nme));
        if (!res) break;
        res = this.c_chn_abr == obj.c_chn_abr ||
         (this.c_chn_abr != null && obj.c_chn_abr != null && this.c_chn_abr.equals(obj.c_chn_abr));
        if (!res) break;
        res = this.c_auth_mrk == obj.c_auth_mrk ||
         (this.c_auth_mrk != null && obj.c_auth_mrk != null && this.c_auth_mrk.equals(obj.c_auth_mrk));
        if (!res) break;
        res = this.c_brd_enm == obj.c_brd_enm ||
         (this.c_brd_enm != null && obj.c_brd_enm != null && this.c_brd_enm.equals(obj.c_brd_enm));
        if (!res) break;
        res = this.c_eng_abr == obj.c_eng_abr ||
         (this.c_eng_abr != null && obj.c_eng_abr != null && this.c_eng_abr.equals(obj.c_eng_abr));
        if (!res) break;
        res = this.c_rgst_no == obj.c_rgst_no ||
         (this.c_rgst_no != null && obj.c_rgst_no != null && this.c_rgst_no.equals(obj.c_rgst_no));
        if (!res) break;
        res = this.c_sex == obj.c_sex ||
         (this.c_sex != null && obj.c_sex != null && this.c_sex.equals(obj.c_sex));
        if (!res) break;
        res = this.c_hmtwn == obj.c_hmtwn ||
         (this.c_hmtwn != null && obj.c_hmtwn != null && this.c_hmtwn.equals(obj.c_hmtwn));
        if (!res) break;
        res = this.c_ntn_cde == obj.c_ntn_cde ||
         (this.c_ntn_cde != null && obj.c_ntn_cde != null && this.c_ntn_cde.equals(obj.c_ntn_cde));
        if (!res) break;
        res = this.t_birthday == obj.t_birthday ||
         (this.t_birthday != null && obj.t_birthday != null && this.t_birthday.equals(obj.t_birthday));
        if (!res) break;
        res = this.c_mrg_cde == obj.c_mrg_cde ||
         (this.c_mrg_cde != null && obj.c_mrg_cde != null && this.c_mrg_cde.equals(obj.c_mrg_cde));
        if (!res) break;
        res = this.c_grdt == obj.c_grdt ||
         (this.c_grdt != null && obj.c_grdt != null && this.c_grdt.equals(obj.c_grdt));
        if (!res) break;
        res = this.c_major_cde == obj.c_major_cde ||
         (this.c_major_cde != null && obj.c_major_cde != null && this.c_major_cde.equals(obj.c_major_cde));
        if (!res) break;
        res = this.c_edu_cde == obj.c_edu_cde ||
         (this.c_edu_cde != null && obj.c_edu_cde != null && this.c_edu_cde.equals(obj.c_edu_cde));
        if (!res) break;
        res = this.c_work_dpt == obj.c_work_dpt ||
         (this.c_work_dpt != null && obj.c_work_dpt != null && this.c_work_dpt.equals(obj.c_work_dpt));
        if (!res) break;
        res = this.c_title_cde == obj.c_title_cde ||
         (this.c_title_cde != null && obj.c_title_cde != null && this.c_title_cde.equals(obj.c_title_cde));
        if (!res) break;
        res = this.c_duty == obj.c_duty ||
         (this.c_duty != null && obj.c_duty != null && this.c_duty.equals(obj.c_duty));
        if (!res) break;
        res = this.c_tel == obj.c_tel ||
         (this.c_tel != null && obj.c_tel != null && this.c_tel.equals(obj.c_tel));
        if (!res) break;
        res = this.c_fax == obj.c_fax ||
         (this.c_fax != null && obj.c_fax != null && this.c_fax.equals(obj.c_fax));
        if (!res) break;
        res = this.c_email == obj.c_email ||
         (this.c_email != null && obj.c_email != null && this.c_email.equals(obj.c_email));
        if (!res) break;
        res = this.c_clnt_addr == obj.c_clnt_addr ||
         (this.c_clnt_addr != null && obj.c_clnt_addr != null && this.c_clnt_addr.equals(obj.c_clnt_addr));
        if (!res) break;
        res = this.c_ara_cde == obj.c_ara_cde ||
         (this.c_ara_cde != null && obj.c_ara_cde != null && this.c_ara_cde.equals(obj.c_ara_cde));
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
        res = this.c_zip_cde == obj.c_zip_cde ||
         (this.c_zip_cde != null && obj.c_zip_cde != null && this.c_zip_cde.equals(obj.c_zip_cde));
        if (!res) break;
        res = this.c_bank == obj.c_bank ||
         (this.c_bank != null && obj.c_bank != null && this.c_bank.equals(obj.c_bank));
        if (!res) break;
        res = this.c_accnt_no == obj.c_accnt_no ||
         (this.c_accnt_no != null && obj.c_accnt_no != null && this.c_accnt_no.equals(obj.c_accnt_no));
        if (!res) break;
        res = this.c_remark == obj.c_remark ||
         (this.c_remark != null && obj.c_remark != null && this.c_remark.equals(obj.c_remark));
        if (!res) break;
        res = this.c_impt_clnt_cde == obj.c_impt_clnt_cde ||
         (this.c_impt_clnt_cde != null && obj.c_impt_clnt_cde != null && this.c_impt_clnt_cde.equals(obj.c_impt_clnt_cde));
        if (!res) break;
        res = this.t_upd_tm == obj.t_upd_tm ||
         (this.t_upd_tm != null && obj.t_upd_tm != null && this.t_upd_tm.equals(obj.t_upd_tm));
      } while (false);
      return res;
    }
    else {
      return false;
    }
  }
}
