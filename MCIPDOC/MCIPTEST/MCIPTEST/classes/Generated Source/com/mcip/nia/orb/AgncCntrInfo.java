package com.mcip.nia.orb;

/**
 * <ul>
 * <li> <b>IDL Source</b>    "D:/Kevin/MCIPDOC/MCIPTEST/MCIPTEST/src/IDL/policyInfoStruct.idl"
 * <li> <b>IDL Name</b>      ::com::mcip::nia::orb::AgncCntrInfo
 * <li> <b>Repository Id</b> IDL:com/mcip/nia/orb/AgncCntrInfo:1.0
 * </ul>
 * <b>IDL definition:</b>
 * <pre>
 * struct AgncCntrInfo {
  ...
};
 * </pre>
 */
public final class AgncCntrInfo implements org.omg.CORBA.portable.IDLEntity {
  
  public java.lang.String c_agt_agr_no;
  
  public int n_sub_co_no;
  
  public java.lang.String c_auth_mrk;
  
  public java.lang.String c_co_mrk;
  
  public java.lang.String c_per_org_mrk;
  
  public java.lang.String c_udr_mrk;
  
  public java.lang.String c_clnt_cde;
  
  public java.lang.String c_clnt_nme;
  
  public java.lang.String c_dpt_cde;
  
  public java.lang.String t_effc_tm;
  
  public java.lang.String t_co_strt_tm;
  
  public java.lang.String t_co_end_tm;
  
  public java.lang.String c_sls_cde;
  
  public java.lang.String c_co_cnt;
  
  public java.lang.String c_undr_prsn;
  
  public java.lang.String c_insrnc_cde;
  
  public java.lang.String c_crgo_cde;
  
  public double n_rate;
  
  public double n_nclm_prop;
  
  public double n_appnt_prop;
  
  public double n_cmm_prop;
  
  public double n_min_prm_prop;
  
  public double n_max_amt_prop;

  public AgncCntrInfo () {
  }

  public AgncCntrInfo (final java.lang.String c_agt_agr_no, 
                       final int n_sub_co_no, 
                       final java.lang.String c_auth_mrk, 
                       final java.lang.String c_co_mrk, 
                       final java.lang.String c_per_org_mrk, 
                       final java.lang.String c_udr_mrk, 
                       final java.lang.String c_clnt_cde, 
                       final java.lang.String c_clnt_nme, 
                       final java.lang.String c_dpt_cde, 
                       final java.lang.String t_effc_tm, 
                       final java.lang.String t_co_strt_tm, 
                       final java.lang.String t_co_end_tm, 
                       final java.lang.String c_sls_cde, 
                       final java.lang.String c_co_cnt, 
                       final java.lang.String c_undr_prsn, 
                       final java.lang.String c_insrnc_cde, 
                       final java.lang.String c_crgo_cde, 
                       final double n_rate, 
                       final double n_nclm_prop, 
                       final double n_appnt_prop, 
                       final double n_cmm_prop, 
                       final double n_min_prm_prop, 
                       final double n_max_amt_prop) {
    this.c_agt_agr_no = c_agt_agr_no;
    this.n_sub_co_no = n_sub_co_no;
    this.c_auth_mrk = c_auth_mrk;
    this.c_co_mrk = c_co_mrk;
    this.c_per_org_mrk = c_per_org_mrk;
    this.c_udr_mrk = c_udr_mrk;
    this.c_clnt_cde = c_clnt_cde;
    this.c_clnt_nme = c_clnt_nme;
    this.c_dpt_cde = c_dpt_cde;
    this.t_effc_tm = t_effc_tm;
    this.t_co_strt_tm = t_co_strt_tm;
    this.t_co_end_tm = t_co_end_tm;
    this.c_sls_cde = c_sls_cde;
    this.c_co_cnt = c_co_cnt;
    this.c_undr_prsn = c_undr_prsn;
    this.c_insrnc_cde = c_insrnc_cde;
    this.c_crgo_cde = c_crgo_cde;
    this.n_rate = n_rate;
    this.n_nclm_prop = n_nclm_prop;
    this.n_appnt_prop = n_appnt_prop;
    this.n_cmm_prop = n_cmm_prop;
    this.n_min_prm_prop = n_min_prm_prop;
    this.n_max_amt_prop = n_max_amt_prop;
  }

  public java.lang.String toString() {
    final java.lang.StringBuffer _ret = new java.lang.StringBuffer("struct com.mcip.nia.orb.AgncCntrInfo {");
    _ret.append("\n");
    _ret.append("java.lang.String c_agt_agr_no=");
    _ret.append(c_agt_agr_no != null?'\"' + c_agt_agr_no + '\"':null);
    _ret.append(",\n");
    _ret.append("int n_sub_co_no=");
    _ret.append(n_sub_co_no);
    _ret.append(",\n");
    _ret.append("java.lang.String c_auth_mrk=");
    _ret.append(c_auth_mrk != null?'\"' + c_auth_mrk + '\"':null);
    _ret.append(",\n");
    _ret.append("java.lang.String c_co_mrk=");
    _ret.append(c_co_mrk != null?'\"' + c_co_mrk + '\"':null);
    _ret.append(",\n");
    _ret.append("java.lang.String c_per_org_mrk=");
    _ret.append(c_per_org_mrk != null?'\"' + c_per_org_mrk + '\"':null);
    _ret.append(",\n");
    _ret.append("java.lang.String c_udr_mrk=");
    _ret.append(c_udr_mrk != null?'\"' + c_udr_mrk + '\"':null);
    _ret.append(",\n");
    _ret.append("java.lang.String c_clnt_cde=");
    _ret.append(c_clnt_cde != null?'\"' + c_clnt_cde + '\"':null);
    _ret.append(",\n");
    _ret.append("java.lang.String c_clnt_nme=");
    _ret.append(c_clnt_nme != null?'\"' + c_clnt_nme + '\"':null);
    _ret.append(",\n");
    _ret.append("java.lang.String c_dpt_cde=");
    _ret.append(c_dpt_cde != null?'\"' + c_dpt_cde + '\"':null);
    _ret.append(",\n");
    _ret.append("java.lang.String t_effc_tm=");
    _ret.append(t_effc_tm != null?'\"' + t_effc_tm + '\"':null);
    _ret.append(",\n");
    _ret.append("java.lang.String t_co_strt_tm=");
    _ret.append(t_co_strt_tm != null?'\"' + t_co_strt_tm + '\"':null);
    _ret.append(",\n");
    _ret.append("java.lang.String t_co_end_tm=");
    _ret.append(t_co_end_tm != null?'\"' + t_co_end_tm + '\"':null);
    _ret.append(",\n");
    _ret.append("java.lang.String c_sls_cde=");
    _ret.append(c_sls_cde != null?'\"' + c_sls_cde + '\"':null);
    _ret.append(",\n");
    _ret.append("java.lang.String c_co_cnt=");
    _ret.append(c_co_cnt != null?'\"' + c_co_cnt + '\"':null);
    _ret.append(",\n");
    _ret.append("java.lang.String c_undr_prsn=");
    _ret.append(c_undr_prsn != null?'\"' + c_undr_prsn + '\"':null);
    _ret.append(",\n");
    _ret.append("java.lang.String c_insrnc_cde=");
    _ret.append(c_insrnc_cde != null?'\"' + c_insrnc_cde + '\"':null);
    _ret.append(",\n");
    _ret.append("java.lang.String c_crgo_cde=");
    _ret.append(c_crgo_cde != null?'\"' + c_crgo_cde + '\"':null);
    _ret.append(",\n");
    _ret.append("double n_rate=");
    _ret.append(n_rate);
    _ret.append(",\n");
    _ret.append("double n_nclm_prop=");
    _ret.append(n_nclm_prop);
    _ret.append(",\n");
    _ret.append("double n_appnt_prop=");
    _ret.append(n_appnt_prop);
    _ret.append(",\n");
    _ret.append("double n_cmm_prop=");
    _ret.append(n_cmm_prop);
    _ret.append(",\n");
    _ret.append("double n_min_prm_prop=");
    _ret.append(n_min_prm_prop);
    _ret.append(",\n");
    _ret.append("double n_max_amt_prop=");
    _ret.append(n_max_amt_prop);
    _ret.append("\n");
    _ret.append("}");
    return _ret.toString();
  }

  public boolean equals (java.lang.Object o) {
    if (this == o) return true;
    if (o == null) return false;

    if (o instanceof com.mcip.nia.orb.AgncCntrInfo) {
      final com.mcip.nia.orb.AgncCntrInfo obj = (com.mcip.nia.orb.AgncCntrInfo)o;
      boolean res = true;
      do {
        res = this.c_agt_agr_no == obj.c_agt_agr_no ||
         (this.c_agt_agr_no != null && obj.c_agt_agr_no != null && this.c_agt_agr_no.equals(obj.c_agt_agr_no));
        if (!res) break;
        res = this.n_sub_co_no == obj.n_sub_co_no;
        if (!res) break;
        res = this.c_auth_mrk == obj.c_auth_mrk ||
         (this.c_auth_mrk != null && obj.c_auth_mrk != null && this.c_auth_mrk.equals(obj.c_auth_mrk));
        if (!res) break;
        res = this.c_co_mrk == obj.c_co_mrk ||
         (this.c_co_mrk != null && obj.c_co_mrk != null && this.c_co_mrk.equals(obj.c_co_mrk));
        if (!res) break;
        res = this.c_per_org_mrk == obj.c_per_org_mrk ||
         (this.c_per_org_mrk != null && obj.c_per_org_mrk != null && this.c_per_org_mrk.equals(obj.c_per_org_mrk));
        if (!res) break;
        res = this.c_udr_mrk == obj.c_udr_mrk ||
         (this.c_udr_mrk != null && obj.c_udr_mrk != null && this.c_udr_mrk.equals(obj.c_udr_mrk));
        if (!res) break;
        res = this.c_clnt_cde == obj.c_clnt_cde ||
         (this.c_clnt_cde != null && obj.c_clnt_cde != null && this.c_clnt_cde.equals(obj.c_clnt_cde));
        if (!res) break;
        res = this.c_clnt_nme == obj.c_clnt_nme ||
         (this.c_clnt_nme != null && obj.c_clnt_nme != null && this.c_clnt_nme.equals(obj.c_clnt_nme));
        if (!res) break;
        res = this.c_dpt_cde == obj.c_dpt_cde ||
         (this.c_dpt_cde != null && obj.c_dpt_cde != null && this.c_dpt_cde.equals(obj.c_dpt_cde));
        if (!res) break;
        res = this.t_effc_tm == obj.t_effc_tm ||
         (this.t_effc_tm != null && obj.t_effc_tm != null && this.t_effc_tm.equals(obj.t_effc_tm));
        if (!res) break;
        res = this.t_co_strt_tm == obj.t_co_strt_tm ||
         (this.t_co_strt_tm != null && obj.t_co_strt_tm != null && this.t_co_strt_tm.equals(obj.t_co_strt_tm));
        if (!res) break;
        res = this.t_co_end_tm == obj.t_co_end_tm ||
         (this.t_co_end_tm != null && obj.t_co_end_tm != null && this.t_co_end_tm.equals(obj.t_co_end_tm));
        if (!res) break;
        res = this.c_sls_cde == obj.c_sls_cde ||
         (this.c_sls_cde != null && obj.c_sls_cde != null && this.c_sls_cde.equals(obj.c_sls_cde));
        if (!res) break;
        res = this.c_co_cnt == obj.c_co_cnt ||
         (this.c_co_cnt != null && obj.c_co_cnt != null && this.c_co_cnt.equals(obj.c_co_cnt));
        if (!res) break;
        res = this.c_undr_prsn == obj.c_undr_prsn ||
         (this.c_undr_prsn != null && obj.c_undr_prsn != null && this.c_undr_prsn.equals(obj.c_undr_prsn));
        if (!res) break;
        res = this.c_insrnc_cde == obj.c_insrnc_cde ||
         (this.c_insrnc_cde != null && obj.c_insrnc_cde != null && this.c_insrnc_cde.equals(obj.c_insrnc_cde));
        if (!res) break;
        res = this.c_crgo_cde == obj.c_crgo_cde ||
         (this.c_crgo_cde != null && obj.c_crgo_cde != null && this.c_crgo_cde.equals(obj.c_crgo_cde));
        if (!res) break;
        res = this.n_rate == obj.n_rate;
        if (!res) break;
        res = this.n_nclm_prop == obj.n_nclm_prop;
        if (!res) break;
        res = this.n_appnt_prop == obj.n_appnt_prop;
        if (!res) break;
        res = this.n_cmm_prop == obj.n_cmm_prop;
        if (!res) break;
        res = this.n_min_prm_prop == obj.n_min_prm_prop;
        if (!res) break;
        res = this.n_max_amt_prop == obj.n_max_amt_prop;
      } while (false);
      return res;
    }
    else {
      return false;
    }
  }
}
