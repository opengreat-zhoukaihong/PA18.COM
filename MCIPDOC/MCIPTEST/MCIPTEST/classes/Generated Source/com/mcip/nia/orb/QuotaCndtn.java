package com.mcip.nia.orb;

/**
 * <ul>
 * <li> <b>IDL Source</b>    "D:/Kevin/MCIPDOC/MCIPTEST/MCIPTEST/src/IDL/policyInfoStruct.idl"
 * <li> <b>IDL Name</b>      ::com::mcip::nia::orb::QuotaCndtn
 * <li> <b>Repository Id</b> IDL:com/mcip/nia/orb/QuotaCndtn:1.0
 * </ul>
 * <b>IDL definition:</b>
 * <pre>
 * struct QuotaCndtn {
  ...
};
 * </pre>
 */
public final class QuotaCndtn implements org.omg.CORBA.portable.IDLEntity {
  
  public java.lang.String c_dpt_cde;
  
  public java.lang.String c_insrnc_cde;
  
  public java.lang.String c_rdr_cde;
  
  public java.lang.String c_crgo_cls;
  
  public java.lang.String c_crgo_cde;
  
  public java.lang.String c_pack_cde;
  
  public java.lang.String c_carriage_cde;
  
  public java.lang.String c_frm_prt_ara;
  
  public java.lang.String c_to_prt_ara;
  
  public java.lang.String n_rate;
  
  public java.lang.String c_nclm_desc;

  public QuotaCndtn () {
  }

  public QuotaCndtn (final java.lang.String c_dpt_cde, 
                     final java.lang.String c_insrnc_cde, 
                     final java.lang.String c_rdr_cde, 
                     final java.lang.String c_crgo_cls, 
                     final java.lang.String c_crgo_cde, 
                     final java.lang.String c_pack_cde, 
                     final java.lang.String c_carriage_cde, 
                     final java.lang.String c_frm_prt_ara, 
                     final java.lang.String c_to_prt_ara, 
                     final java.lang.String n_rate, 
                     final java.lang.String c_nclm_desc) {
    this.c_dpt_cde = c_dpt_cde;
    this.c_insrnc_cde = c_insrnc_cde;
    this.c_rdr_cde = c_rdr_cde;
    this.c_crgo_cls = c_crgo_cls;
    this.c_crgo_cde = c_crgo_cde;
    this.c_pack_cde = c_pack_cde;
    this.c_carriage_cde = c_carriage_cde;
    this.c_frm_prt_ara = c_frm_prt_ara;
    this.c_to_prt_ara = c_to_prt_ara;
    this.n_rate = n_rate;
    this.c_nclm_desc = c_nclm_desc;
  }

  public java.lang.String toString() {
    final java.lang.StringBuffer _ret = new java.lang.StringBuffer("struct com.mcip.nia.orb.QuotaCndtn {");
    _ret.append("\n");
    _ret.append("java.lang.String c_dpt_cde=");
    _ret.append(c_dpt_cde != null?'\"' + c_dpt_cde + '\"':null);
    _ret.append(",\n");
    _ret.append("java.lang.String c_insrnc_cde=");
    _ret.append(c_insrnc_cde != null?'\"' + c_insrnc_cde + '\"':null);
    _ret.append(",\n");
    _ret.append("java.lang.String c_rdr_cde=");
    _ret.append(c_rdr_cde != null?'\"' + c_rdr_cde + '\"':null);
    _ret.append(",\n");
    _ret.append("java.lang.String c_crgo_cls=");
    _ret.append(c_crgo_cls != null?'\"' + c_crgo_cls + '\"':null);
    _ret.append(",\n");
    _ret.append("java.lang.String c_crgo_cde=");
    _ret.append(c_crgo_cde != null?'\"' + c_crgo_cde + '\"':null);
    _ret.append(",\n");
    _ret.append("java.lang.String c_pack_cde=");
    _ret.append(c_pack_cde != null?'\"' + c_pack_cde + '\"':null);
    _ret.append(",\n");
    _ret.append("java.lang.String c_carriage_cde=");
    _ret.append(c_carriage_cde != null?'\"' + c_carriage_cde + '\"':null);
    _ret.append(",\n");
    _ret.append("java.lang.String c_frm_prt_ara=");
    _ret.append(c_frm_prt_ara != null?'\"' + c_frm_prt_ara + '\"':null);
    _ret.append(",\n");
    _ret.append("java.lang.String c_to_prt_ara=");
    _ret.append(c_to_prt_ara != null?'\"' + c_to_prt_ara + '\"':null);
    _ret.append(",\n");
    _ret.append("java.lang.String n_rate=");
    _ret.append(n_rate != null?'\"' + n_rate + '\"':null);
    _ret.append(",\n");
    _ret.append("java.lang.String c_nclm_desc=");
    _ret.append(c_nclm_desc != null?'\"' + c_nclm_desc + '\"':null);
    _ret.append("\n");
    _ret.append("}");
    return _ret.toString();
  }

  public boolean equals (java.lang.Object o) {
    if (this == o) return true;
    if (o == null) return false;

    if (o instanceof com.mcip.nia.orb.QuotaCndtn) {
      final com.mcip.nia.orb.QuotaCndtn obj = (com.mcip.nia.orb.QuotaCndtn)o;
      boolean res = true;
      do {
        res = this.c_dpt_cde == obj.c_dpt_cde ||
         (this.c_dpt_cde != null && obj.c_dpt_cde != null && this.c_dpt_cde.equals(obj.c_dpt_cde));
        if (!res) break;
        res = this.c_insrnc_cde == obj.c_insrnc_cde ||
         (this.c_insrnc_cde != null && obj.c_insrnc_cde != null && this.c_insrnc_cde.equals(obj.c_insrnc_cde));
        if (!res) break;
        res = this.c_rdr_cde == obj.c_rdr_cde ||
         (this.c_rdr_cde != null && obj.c_rdr_cde != null && this.c_rdr_cde.equals(obj.c_rdr_cde));
        if (!res) break;
        res = this.c_crgo_cls == obj.c_crgo_cls ||
         (this.c_crgo_cls != null && obj.c_crgo_cls != null && this.c_crgo_cls.equals(obj.c_crgo_cls));
        if (!res) break;
        res = this.c_crgo_cde == obj.c_crgo_cde ||
         (this.c_crgo_cde != null && obj.c_crgo_cde != null && this.c_crgo_cde.equals(obj.c_crgo_cde));
        if (!res) break;
        res = this.c_pack_cde == obj.c_pack_cde ||
         (this.c_pack_cde != null && obj.c_pack_cde != null && this.c_pack_cde.equals(obj.c_pack_cde));
        if (!res) break;
        res = this.c_carriage_cde == obj.c_carriage_cde ||
         (this.c_carriage_cde != null && obj.c_carriage_cde != null && this.c_carriage_cde.equals(obj.c_carriage_cde));
        if (!res) break;
        res = this.c_frm_prt_ara == obj.c_frm_prt_ara ||
         (this.c_frm_prt_ara != null && obj.c_frm_prt_ara != null && this.c_frm_prt_ara.equals(obj.c_frm_prt_ara));
        if (!res) break;
        res = this.c_to_prt_ara == obj.c_to_prt_ara ||
         (this.c_to_prt_ara != null && obj.c_to_prt_ara != null && this.c_to_prt_ara.equals(obj.c_to_prt_ara));
        if (!res) break;
        res = this.n_rate == obj.n_rate ||
         (this.n_rate != null && obj.n_rate != null && this.n_rate.equals(obj.n_rate));
        if (!res) break;
        res = this.c_nclm_desc == obj.c_nclm_desc ||
         (this.c_nclm_desc != null && obj.c_nclm_desc != null && this.c_nclm_desc.equals(obj.c_nclm_desc));
      } while (false);
      return res;
    }
    else {
      return false;
    }
  }
}
