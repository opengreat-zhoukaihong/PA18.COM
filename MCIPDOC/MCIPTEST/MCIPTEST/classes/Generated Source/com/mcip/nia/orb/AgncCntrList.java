package com.mcip.nia.orb;

/**
 * <ul>
 * <li> <b>IDL Source</b>    "D:/Kevin/MCIPDOC/MCIPTEST/MCIPTEST/src/IDL/policyInfoStruct.idl"
 * <li> <b>IDL Name</b>      ::com::mcip::nia::orb::AgncCntrList
 * <li> <b>Repository Id</b> IDL:com/mcip/nia/orb/AgncCntrList:1.0
 * </ul>
 * <b>IDL definition:</b>
 * <pre>
 * struct AgncCntrList {
  ...
};
 * </pre>
 */
public final class AgncCntrList implements org.omg.CORBA.portable.IDLEntity {
  
  public java.lang.String c_agt_agr_no;
  
  public int n_sub_co_no;
  
  public java.lang.String c_insrnc_cde;
  
  public java.lang.String c_insrnc_cnm;
  
  public java.lang.String c_crgo_cde;
  
  public java.lang.String c_crgo_cnm;

  public AgncCntrList () {
  }

  public AgncCntrList (final java.lang.String c_agt_agr_no, 
                       final int n_sub_co_no, 
                       final java.lang.String c_insrnc_cde, 
                       final java.lang.String c_insrnc_cnm, 
                       final java.lang.String c_crgo_cde, 
                       final java.lang.String c_crgo_cnm) {
    this.c_agt_agr_no = c_agt_agr_no;
    this.n_sub_co_no = n_sub_co_no;
    this.c_insrnc_cde = c_insrnc_cde;
    this.c_insrnc_cnm = c_insrnc_cnm;
    this.c_crgo_cde = c_crgo_cde;
    this.c_crgo_cnm = c_crgo_cnm;
  }

  public java.lang.String toString() {
    final java.lang.StringBuffer _ret = new java.lang.StringBuffer("struct com.mcip.nia.orb.AgncCntrList {");
    _ret.append("\n");
    _ret.append("java.lang.String c_agt_agr_no=");
    _ret.append(c_agt_agr_no != null?'\"' + c_agt_agr_no + '\"':null);
    _ret.append(",\n");
    _ret.append("int n_sub_co_no=");
    _ret.append(n_sub_co_no);
    _ret.append(",\n");
    _ret.append("java.lang.String c_insrnc_cde=");
    _ret.append(c_insrnc_cde != null?'\"' + c_insrnc_cde + '\"':null);
    _ret.append(",\n");
    _ret.append("java.lang.String c_insrnc_cnm=");
    _ret.append(c_insrnc_cnm != null?'\"' + c_insrnc_cnm + '\"':null);
    _ret.append(",\n");
    _ret.append("java.lang.String c_crgo_cde=");
    _ret.append(c_crgo_cde != null?'\"' + c_crgo_cde + '\"':null);
    _ret.append(",\n");
    _ret.append("java.lang.String c_crgo_cnm=");
    _ret.append(c_crgo_cnm != null?'\"' + c_crgo_cnm + '\"':null);
    _ret.append("\n");
    _ret.append("}");
    return _ret.toString();
  }

  public boolean equals (java.lang.Object o) {
    if (this == o) return true;
    if (o == null) return false;

    if (o instanceof com.mcip.nia.orb.AgncCntrList) {
      final com.mcip.nia.orb.AgncCntrList obj = (com.mcip.nia.orb.AgncCntrList)o;
      boolean res = true;
      do {
        res = this.c_agt_agr_no == obj.c_agt_agr_no ||
         (this.c_agt_agr_no != null && obj.c_agt_agr_no != null && this.c_agt_agr_no.equals(obj.c_agt_agr_no));
        if (!res) break;
        res = this.n_sub_co_no == obj.n_sub_co_no;
        if (!res) break;
        res = this.c_insrnc_cde == obj.c_insrnc_cde ||
         (this.c_insrnc_cde != null && obj.c_insrnc_cde != null && this.c_insrnc_cde.equals(obj.c_insrnc_cde));
        if (!res) break;
        res = this.c_insrnc_cnm == obj.c_insrnc_cnm ||
         (this.c_insrnc_cnm != null && obj.c_insrnc_cnm != null && this.c_insrnc_cnm.equals(obj.c_insrnc_cnm));
        if (!res) break;
        res = this.c_crgo_cde == obj.c_crgo_cde ||
         (this.c_crgo_cde != null && obj.c_crgo_cde != null && this.c_crgo_cde.equals(obj.c_crgo_cde));
        if (!res) break;
        res = this.c_crgo_cnm == obj.c_crgo_cnm ||
         (this.c_crgo_cnm != null && obj.c_crgo_cnm != null && this.c_crgo_cnm.equals(obj.c_crgo_cnm));
      } while (false);
      return res;
    }
    else {
      return false;
    }
  }
}
