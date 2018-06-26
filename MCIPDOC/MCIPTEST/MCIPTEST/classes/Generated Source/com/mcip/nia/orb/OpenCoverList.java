package com.mcip.nia.orb;

/**
 * <ul>
 * <li> <b>IDL Source</b>    "D:/Kevin/MCIPDOC/MCIPTEST/MCIPTEST/src/IDL/policyInfoStruct.idl"
 * <li> <b>IDL Name</b>      ::com::mcip::nia::orb::OpenCoverList
 * <li> <b>Repository Id</b> IDL:com/mcip/nia/orb/OpenCoverList:1.0
 * </ul>
 * <b>IDL definition:</b>
 * <pre>
 * struct OpenCoverList {
  ...
};
 * </pre>
 */
public final class OpenCoverList implements org.omg.CORBA.portable.IDLEntity {
  
  public java.lang.String c_open_cover_no;
  
  public java.lang.String c_crgo_name;
  
  public java.lang.String c_insrnc_cde;
  
  public java.lang.String c_insrnc_cnm;
  
  public java.lang.String c_frm_prt_ara;
  
  public java.lang.String c_frm_prt_ara_cnm;
  
  public java.lang.String c_to_prt_ara;
  
  public java.lang.String c_to_prt_ara_cnm;
  
  public java.lang.String c_from_prt;
  
  public java.lang.String c_to_prt;

  public OpenCoverList () {
  }

  public OpenCoverList (final java.lang.String c_open_cover_no, 
                        final java.lang.String c_crgo_name, 
                        final java.lang.String c_insrnc_cde, 
                        final java.lang.String c_insrnc_cnm, 
                        final java.lang.String c_frm_prt_ara, 
                        final java.lang.String c_frm_prt_ara_cnm, 
                        final java.lang.String c_to_prt_ara, 
                        final java.lang.String c_to_prt_ara_cnm, 
                        final java.lang.String c_from_prt, 
                        final java.lang.String c_to_prt) {
    this.c_open_cover_no = c_open_cover_no;
    this.c_crgo_name = c_crgo_name;
    this.c_insrnc_cde = c_insrnc_cde;
    this.c_insrnc_cnm = c_insrnc_cnm;
    this.c_frm_prt_ara = c_frm_prt_ara;
    this.c_frm_prt_ara_cnm = c_frm_prt_ara_cnm;
    this.c_to_prt_ara = c_to_prt_ara;
    this.c_to_prt_ara_cnm = c_to_prt_ara_cnm;
    this.c_from_prt = c_from_prt;
    this.c_to_prt = c_to_prt;
  }

  public java.lang.String toString() {
    final java.lang.StringBuffer _ret = new java.lang.StringBuffer("struct com.mcip.nia.orb.OpenCoverList {");
    _ret.append("\n");
    _ret.append("java.lang.String c_open_cover_no=");
    _ret.append(c_open_cover_no != null?'\"' + c_open_cover_no + '\"':null);
    _ret.append(",\n");
    _ret.append("java.lang.String c_crgo_name=");
    _ret.append(c_crgo_name != null?'\"' + c_crgo_name + '\"':null);
    _ret.append(",\n");
    _ret.append("java.lang.String c_insrnc_cde=");
    _ret.append(c_insrnc_cde != null?'\"' + c_insrnc_cde + '\"':null);
    _ret.append(",\n");
    _ret.append("java.lang.String c_insrnc_cnm=");
    _ret.append(c_insrnc_cnm != null?'\"' + c_insrnc_cnm + '\"':null);
    _ret.append(",\n");
    _ret.append("java.lang.String c_frm_prt_ara=");
    _ret.append(c_frm_prt_ara != null?'\"' + c_frm_prt_ara + '\"':null);
    _ret.append(",\n");
    _ret.append("java.lang.String c_frm_prt_ara_cnm=");
    _ret.append(c_frm_prt_ara_cnm != null?'\"' + c_frm_prt_ara_cnm + '\"':null);
    _ret.append(",\n");
    _ret.append("java.lang.String c_to_prt_ara=");
    _ret.append(c_to_prt_ara != null?'\"' + c_to_prt_ara + '\"':null);
    _ret.append(",\n");
    _ret.append("java.lang.String c_to_prt_ara_cnm=");
    _ret.append(c_to_prt_ara_cnm != null?'\"' + c_to_prt_ara_cnm + '\"':null);
    _ret.append(",\n");
    _ret.append("java.lang.String c_from_prt=");
    _ret.append(c_from_prt != null?'\"' + c_from_prt + '\"':null);
    _ret.append(",\n");
    _ret.append("java.lang.String c_to_prt=");
    _ret.append(c_to_prt != null?'\"' + c_to_prt + '\"':null);
    _ret.append("\n");
    _ret.append("}");
    return _ret.toString();
  }

  public boolean equals (java.lang.Object o) {
    if (this == o) return true;
    if (o == null) return false;

    if (o instanceof com.mcip.nia.orb.OpenCoverList) {
      final com.mcip.nia.orb.OpenCoverList obj = (com.mcip.nia.orb.OpenCoverList)o;
      boolean res = true;
      do {
        res = this.c_open_cover_no == obj.c_open_cover_no ||
         (this.c_open_cover_no != null && obj.c_open_cover_no != null && this.c_open_cover_no.equals(obj.c_open_cover_no));
        if (!res) break;
        res = this.c_crgo_name == obj.c_crgo_name ||
         (this.c_crgo_name != null && obj.c_crgo_name != null && this.c_crgo_name.equals(obj.c_crgo_name));
        if (!res) break;
        res = this.c_insrnc_cde == obj.c_insrnc_cde ||
         (this.c_insrnc_cde != null && obj.c_insrnc_cde != null && this.c_insrnc_cde.equals(obj.c_insrnc_cde));
        if (!res) break;
        res = this.c_insrnc_cnm == obj.c_insrnc_cnm ||
         (this.c_insrnc_cnm != null && obj.c_insrnc_cnm != null && this.c_insrnc_cnm.equals(obj.c_insrnc_cnm));
        if (!res) break;
        res = this.c_frm_prt_ara == obj.c_frm_prt_ara ||
         (this.c_frm_prt_ara != null && obj.c_frm_prt_ara != null && this.c_frm_prt_ara.equals(obj.c_frm_prt_ara));
        if (!res) break;
        res = this.c_frm_prt_ara_cnm == obj.c_frm_prt_ara_cnm ||
         (this.c_frm_prt_ara_cnm != null && obj.c_frm_prt_ara_cnm != null && this.c_frm_prt_ara_cnm.equals(obj.c_frm_prt_ara_cnm));
        if (!res) break;
        res = this.c_to_prt_ara == obj.c_to_prt_ara ||
         (this.c_to_prt_ara != null && obj.c_to_prt_ara != null && this.c_to_prt_ara.equals(obj.c_to_prt_ara));
        if (!res) break;
        res = this.c_to_prt_ara_cnm == obj.c_to_prt_ara_cnm ||
         (this.c_to_prt_ara_cnm != null && obj.c_to_prt_ara_cnm != null && this.c_to_prt_ara_cnm.equals(obj.c_to_prt_ara_cnm));
        if (!res) break;
        res = this.c_from_prt == obj.c_from_prt ||
         (this.c_from_prt != null && obj.c_from_prt != null && this.c_from_prt.equals(obj.c_from_prt));
        if (!res) break;
        res = this.c_to_prt == obj.c_to_prt ||
         (this.c_to_prt != null && obj.c_to_prt != null && this.c_to_prt.equals(obj.c_to_prt));
      } while (false);
      return res;
    }
    else {
      return false;
    }
  }
}
