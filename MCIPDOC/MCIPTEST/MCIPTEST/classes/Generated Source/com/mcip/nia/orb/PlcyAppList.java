package com.mcip.nia.orb;

/**
 * <ul>
 * <li> <b>IDL Source</b>    "D:/Kevin/MCIPDOC/MCIPTEST/MCIPTEST/src/IDL/policyInfoStruct.idl"
 * <li> <b>IDL Name</b>      ::com::mcip::nia::orb::PlcyAppList
 * <li> <b>Repository Id</b> IDL:com/mcip/nia/orb/PlcyAppList:1.0
 * </ul>
 * <b>IDL definition:</b>
 * <pre>
 * struct PlcyAppList {
  ...
};
 * </pre>
 */
public final class PlcyAppList implements org.omg.CORBA.portable.IDLEntity {
  
  public java.lang.String c_ply_app_no;
  
  public java.lang.String c_ply_no;
  
  public java.lang.String c_insrnc_cde;
  
  public java.lang.String c_insrnc_cnm;
  
  public double n_amt;
  
  public java.lang.String c_amt_cur;
  
  public java.lang.String c_crgo_cde;
  
  public java.lang.String c_cdgo_desc;
  
  public java.lang.String c_frm_prt_ara;
  
  public java.lang.String c_frm_prt_ara_cnm;
  
  public java.lang.String c_from_prt;
  
  public java.lang.String c_to_prt_ara;
  
  public java.lang.String c_to_prt_ara_cnm;
  
  public java.lang.String c_to_prt;
  
  public java.lang.String c_carriage_cde;
  
  public java.lang.String c_carriage_cnm;

  public PlcyAppList () {
  }

  public PlcyAppList (final java.lang.String c_ply_app_no, 
                      final java.lang.String c_ply_no, 
                      final java.lang.String c_insrnc_cde, 
                      final java.lang.String c_insrnc_cnm, 
                      final double n_amt, 
                      final java.lang.String c_amt_cur, 
                      final java.lang.String c_crgo_cde, 
                      final java.lang.String c_cdgo_desc, 
                      final java.lang.String c_frm_prt_ara, 
                      final java.lang.String c_frm_prt_ara_cnm, 
                      final java.lang.String c_from_prt, 
                      final java.lang.String c_to_prt_ara, 
                      final java.lang.String c_to_prt_ara_cnm, 
                      final java.lang.String c_to_prt, 
                      final java.lang.String c_carriage_cde, 
                      final java.lang.String c_carriage_cnm) {
    this.c_ply_app_no = c_ply_app_no;
    this.c_ply_no = c_ply_no;
    this.c_insrnc_cde = c_insrnc_cde;
    this.c_insrnc_cnm = c_insrnc_cnm;
    this.n_amt = n_amt;
    this.c_amt_cur = c_amt_cur;
    this.c_crgo_cde = c_crgo_cde;
    this.c_cdgo_desc = c_cdgo_desc;
    this.c_frm_prt_ara = c_frm_prt_ara;
    this.c_frm_prt_ara_cnm = c_frm_prt_ara_cnm;
    this.c_from_prt = c_from_prt;
    this.c_to_prt_ara = c_to_prt_ara;
    this.c_to_prt_ara_cnm = c_to_prt_ara_cnm;
    this.c_to_prt = c_to_prt;
    this.c_carriage_cde = c_carriage_cde;
    this.c_carriage_cnm = c_carriage_cnm;
  }

  public java.lang.String toString() {
    final java.lang.StringBuffer _ret = new java.lang.StringBuffer("struct com.mcip.nia.orb.PlcyAppList {");
    _ret.append("\n");
    _ret.append("java.lang.String c_ply_app_no=");
    _ret.append(c_ply_app_no != null?'\"' + c_ply_app_no + '\"':null);
    _ret.append(",\n");
    _ret.append("java.lang.String c_ply_no=");
    _ret.append(c_ply_no != null?'\"' + c_ply_no + '\"':null);
    _ret.append(",\n");
    _ret.append("java.lang.String c_insrnc_cde=");
    _ret.append(c_insrnc_cde != null?'\"' + c_insrnc_cde + '\"':null);
    _ret.append(",\n");
    _ret.append("java.lang.String c_insrnc_cnm=");
    _ret.append(c_insrnc_cnm != null?'\"' + c_insrnc_cnm + '\"':null);
    _ret.append(",\n");
    _ret.append("double n_amt=");
    _ret.append(n_amt);
    _ret.append(",\n");
    _ret.append("java.lang.String c_amt_cur=");
    _ret.append(c_amt_cur != null?'\"' + c_amt_cur + '\"':null);
    _ret.append(",\n");
    _ret.append("java.lang.String c_crgo_cde=");
    _ret.append(c_crgo_cde != null?'\"' + c_crgo_cde + '\"':null);
    _ret.append(",\n");
    _ret.append("java.lang.String c_cdgo_desc=");
    _ret.append(c_cdgo_desc != null?'\"' + c_cdgo_desc + '\"':null);
    _ret.append(",\n");
    _ret.append("java.lang.String c_frm_prt_ara=");
    _ret.append(c_frm_prt_ara != null?'\"' + c_frm_prt_ara + '\"':null);
    _ret.append(",\n");
    _ret.append("java.lang.String c_frm_prt_ara_cnm=");
    _ret.append(c_frm_prt_ara_cnm != null?'\"' + c_frm_prt_ara_cnm + '\"':null);
    _ret.append(",\n");
    _ret.append("java.lang.String c_from_prt=");
    _ret.append(c_from_prt != null?'\"' + c_from_prt + '\"':null);
    _ret.append(",\n");
    _ret.append("java.lang.String c_to_prt_ara=");
    _ret.append(c_to_prt_ara != null?'\"' + c_to_prt_ara + '\"':null);
    _ret.append(",\n");
    _ret.append("java.lang.String c_to_prt_ara_cnm=");
    _ret.append(c_to_prt_ara_cnm != null?'\"' + c_to_prt_ara_cnm + '\"':null);
    _ret.append(",\n");
    _ret.append("java.lang.String c_to_prt=");
    _ret.append(c_to_prt != null?'\"' + c_to_prt + '\"':null);
    _ret.append(",\n");
    _ret.append("java.lang.String c_carriage_cde=");
    _ret.append(c_carriage_cde != null?'\"' + c_carriage_cde + '\"':null);
    _ret.append(",\n");
    _ret.append("java.lang.String c_carriage_cnm=");
    _ret.append(c_carriage_cnm != null?'\"' + c_carriage_cnm + '\"':null);
    _ret.append("\n");
    _ret.append("}");
    return _ret.toString();
  }

  public boolean equals (java.lang.Object o) {
    if (this == o) return true;
    if (o == null) return false;

    if (o instanceof com.mcip.nia.orb.PlcyAppList) {
      final com.mcip.nia.orb.PlcyAppList obj = (com.mcip.nia.orb.PlcyAppList)o;
      boolean res = true;
      do {
        res = this.c_ply_app_no == obj.c_ply_app_no ||
         (this.c_ply_app_no != null && obj.c_ply_app_no != null && this.c_ply_app_no.equals(obj.c_ply_app_no));
        if (!res) break;
        res = this.c_ply_no == obj.c_ply_no ||
         (this.c_ply_no != null && obj.c_ply_no != null && this.c_ply_no.equals(obj.c_ply_no));
        if (!res) break;
        res = this.c_insrnc_cde == obj.c_insrnc_cde ||
         (this.c_insrnc_cde != null && obj.c_insrnc_cde != null && this.c_insrnc_cde.equals(obj.c_insrnc_cde));
        if (!res) break;
        res = this.c_insrnc_cnm == obj.c_insrnc_cnm ||
         (this.c_insrnc_cnm != null && obj.c_insrnc_cnm != null && this.c_insrnc_cnm.equals(obj.c_insrnc_cnm));
        if (!res) break;
        res = this.n_amt == obj.n_amt;
        if (!res) break;
        res = this.c_amt_cur == obj.c_amt_cur ||
         (this.c_amt_cur != null && obj.c_amt_cur != null && this.c_amt_cur.equals(obj.c_amt_cur));
        if (!res) break;
        res = this.c_crgo_cde == obj.c_crgo_cde ||
         (this.c_crgo_cde != null && obj.c_crgo_cde != null && this.c_crgo_cde.equals(obj.c_crgo_cde));
        if (!res) break;
        res = this.c_cdgo_desc == obj.c_cdgo_desc ||
         (this.c_cdgo_desc != null && obj.c_cdgo_desc != null && this.c_cdgo_desc.equals(obj.c_cdgo_desc));
        if (!res) break;
        res = this.c_frm_prt_ara == obj.c_frm_prt_ara ||
         (this.c_frm_prt_ara != null && obj.c_frm_prt_ara != null && this.c_frm_prt_ara.equals(obj.c_frm_prt_ara));
        if (!res) break;
        res = this.c_frm_prt_ara_cnm == obj.c_frm_prt_ara_cnm ||
         (this.c_frm_prt_ara_cnm != null && obj.c_frm_prt_ara_cnm != null && this.c_frm_prt_ara_cnm.equals(obj.c_frm_prt_ara_cnm));
        if (!res) break;
        res = this.c_from_prt == obj.c_from_prt ||
         (this.c_from_prt != null && obj.c_from_prt != null && this.c_from_prt.equals(obj.c_from_prt));
        if (!res) break;
        res = this.c_to_prt_ara == obj.c_to_prt_ara ||
         (this.c_to_prt_ara != null && obj.c_to_prt_ara != null && this.c_to_prt_ara.equals(obj.c_to_prt_ara));
        if (!res) break;
        res = this.c_to_prt_ara_cnm == obj.c_to_prt_ara_cnm ||
         (this.c_to_prt_ara_cnm != null && obj.c_to_prt_ara_cnm != null && this.c_to_prt_ara_cnm.equals(obj.c_to_prt_ara_cnm));
        if (!res) break;
        res = this.c_to_prt == obj.c_to_prt ||
         (this.c_to_prt != null && obj.c_to_prt != null && this.c_to_prt.equals(obj.c_to_prt));
        if (!res) break;
        res = this.c_carriage_cde == obj.c_carriage_cde ||
         (this.c_carriage_cde != null && obj.c_carriage_cde != null && this.c_carriage_cde.equals(obj.c_carriage_cde));
        if (!res) break;
        res = this.c_carriage_cnm == obj.c_carriage_cnm ||
         (this.c_carriage_cnm != null && obj.c_carriage_cnm != null && this.c_carriage_cnm.equals(obj.c_carriage_cnm));
      } while (false);
      return res;
    }
    else {
      return false;
    }
  }
}
