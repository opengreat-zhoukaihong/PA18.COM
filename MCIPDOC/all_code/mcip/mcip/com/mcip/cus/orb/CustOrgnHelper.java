package com.mcip.cus.orb;
/**
<p>
<ul>
<li> <b>Java Class</b> com.mcip.cus.orb.CustOrgnHelper
<li> <b>Source File</b> com/mcip/cus/orb/CustOrgnHelper.java
<li> <b>IDL Source File</b> custInfoStruct.idl
<li> <b>IDL Absolute Name</b> ::com::mcip::cus::orb::CustOrgn
<li> <b>Repository Identifier</b> IDL:com/mcip/cus/orb/CustOrgn:1.0
</ul>
<b>IDL definition:</b>
<pre>
    #pragma prefix "com/mcip/cus/orb"
    struct CustOrgn {
      string c_clnt_cde;
      string c_dpt_cde;
      long n_clnt_grp_cde;
      string c_clnt_mrk;
      wstring c_clnt_nme;
      wstring c_chn_abr;
      string c_auth_mrk;
      string c_scale_cde;
      string c_clnt_scle_cde;
      string c_orgz_typ_cde;
      wstring c_brd_enm;
      wstring c_eng_abr;
      string c_ownership_cde;
      string c_rgst_no;
      string c_tax_no;
      double n_rgst_mny;
      wstring c_chief;
      long n_emly_num;
      string c_trd_cde;
      string c_upr_dpt_cde;
      string c_impt_clnt_cde;
      wstring c_cntct_prsn_nme;
      string c_tel;
      string c_fax;
      wstring c_email;
      wstring c_clnt_addr;
      string c_ara_cde;
      wstring c_province;
      wstring c_city;
      wstring c_place;
      string c_zip_cde;
      wstring c_bank;
      string c_accnt_no;
      wstring c_remark;
      string t_upd_tm;
    };
</pre>
</p>
*/
abstract public class CustOrgnHelper {
  private static org.omg.CORBA.ORB _orb() {
    return org.omg.CORBA.ORB.init();
  }
  public static com.mcip.cus.orb.CustOrgn read(org.omg.CORBA.portable.InputStream _input) {
    com.mcip.cus.orb.CustOrgn result = new com.mcip.cus.orb.CustOrgn();
    result.c_clnt_cde = _input.read_string();
    result.c_dpt_cde = _input.read_string();
    result.n_clnt_grp_cde = _input.read_long();
    result.c_clnt_mrk = _input.read_string();
    result.c_clnt_nme = _input.read_wstring();
    result.c_chn_abr = _input.read_wstring();
    result.c_auth_mrk = _input.read_string();
    result.c_scale_cde = _input.read_string();
    result.c_clnt_scle_cde = _input.read_string();
    result.c_orgz_typ_cde = _input.read_string();
    result.c_brd_enm = _input.read_wstring();
    result.c_eng_abr = _input.read_wstring();
    result.c_ownership_cde = _input.read_string();
    result.c_rgst_no = _input.read_string();
    result.c_tax_no = _input.read_string();
    result.n_rgst_mny = _input.read_double();
    result.c_chief = _input.read_wstring();
    result.n_emly_num = _input.read_long();
    result.c_trd_cde = _input.read_string();
    result.c_upr_dpt_cde = _input.read_string();
    result.c_impt_clnt_cde = _input.read_string();
    result.c_cntct_prsn_nme = _input.read_wstring();
    result.c_tel = _input.read_string();
    result.c_fax = _input.read_string();
    result.c_email = _input.read_wstring();
    result.c_clnt_addr = _input.read_wstring();
    result.c_ara_cde = _input.read_string();
    result.c_province = _input.read_wstring();
    result.c_city = _input.read_wstring();
    result.c_place = _input.read_wstring();
    result.c_zip_cde = _input.read_string();
    result.c_bank = _input.read_wstring();
    result.c_accnt_no = _input.read_string();
    result.c_remark = _input.read_wstring();
    result.t_upd_tm = _input.read_string();
    return result;
  }
  public static void write(org.omg.CORBA.portable.OutputStream _output, com.mcip.cus.orb.CustOrgn value) {
    _output.write_string(value.c_clnt_cde);
    _output.write_string(value.c_dpt_cde);
    _output.write_long(value.n_clnt_grp_cde);
    _output.write_string(value.c_clnt_mrk);
    _output.write_wstring(value.c_clnt_nme);
    _output.write_wstring(value.c_chn_abr);
    _output.write_string(value.c_auth_mrk);
    _output.write_string(value.c_scale_cde);
    _output.write_string(value.c_clnt_scle_cde);
    _output.write_string(value.c_orgz_typ_cde);
    _output.write_wstring(value.c_brd_enm);
    _output.write_wstring(value.c_eng_abr);
    _output.write_string(value.c_ownership_cde);
    _output.write_string(value.c_rgst_no);
    _output.write_string(value.c_tax_no);
    _output.write_double(value.n_rgst_mny);
    _output.write_wstring(value.c_chief);
    _output.write_long(value.n_emly_num);
    _output.write_string(value.c_trd_cde);
    _output.write_string(value.c_upr_dpt_cde);
    _output.write_string(value.c_impt_clnt_cde);
    _output.write_wstring(value.c_cntct_prsn_nme);
    _output.write_string(value.c_tel);
    _output.write_string(value.c_fax);
    _output.write_wstring(value.c_email);
    _output.write_wstring(value.c_clnt_addr);
    _output.write_string(value.c_ara_cde);
    _output.write_wstring(value.c_province);
    _output.write_wstring(value.c_city);
    _output.write_wstring(value.c_place);
    _output.write_string(value.c_zip_cde);
    _output.write_wstring(value.c_bank);
    _output.write_string(value.c_accnt_no);
    _output.write_wstring(value.c_remark);
    _output.write_string(value.t_upd_tm);
  }
  public static void insert(org.omg.CORBA.Any any, com.mcip.cus.orb.CustOrgn value) {
    org.omg.CORBA.portable.OutputStream output = any.create_output_stream();
    write(output, value);
    any.read_value(output.create_input_stream(), type());
  }
  public static com.mcip.cus.orb.CustOrgn extract(org.omg.CORBA.Any any) {
    if(!any.type().equal(type())) {
      throw new org.omg.CORBA.BAD_TYPECODE();
    }
    return read(any.create_input_stream());
  }
  private static org.omg.CORBA.TypeCode _type;
  public static org.omg.CORBA.TypeCode type() {
    if(_type == null) {
      org.omg.CORBA.StructMember[] members = new org.omg.CORBA.StructMember[35];
      members[0] = new org.omg.CORBA.StructMember("c_clnt_cde", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
      members[1] = new org.omg.CORBA.StructMember("c_dpt_cde", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
      members[2] = new org.omg.CORBA.StructMember("n_clnt_grp_cde", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_long), null);
      members[3] = new org.omg.CORBA.StructMember("c_clnt_mrk", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
      members[4] = new org.omg.CORBA.StructMember("c_clnt_nme", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[5] = new org.omg.CORBA.StructMember("c_chn_abr", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[6] = new org.omg.CORBA.StructMember("c_auth_mrk", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
      members[7] = new org.omg.CORBA.StructMember("c_scale_cde", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
      members[8] = new org.omg.CORBA.StructMember("c_clnt_scle_cde", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
      members[9] = new org.omg.CORBA.StructMember("c_orgz_typ_cde", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
      members[10] = new org.omg.CORBA.StructMember("c_brd_enm", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[11] = new org.omg.CORBA.StructMember("c_eng_abr", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[12] = new org.omg.CORBA.StructMember("c_ownership_cde", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
      members[13] = new org.omg.CORBA.StructMember("c_rgst_no", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
      members[14] = new org.omg.CORBA.StructMember("c_tax_no", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
      members[15] = new org.omg.CORBA.StructMember("n_rgst_mny", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_double), null);
      members[16] = new org.omg.CORBA.StructMember("c_chief", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[17] = new org.omg.CORBA.StructMember("n_emly_num", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_long), null);
      members[18] = new org.omg.CORBA.StructMember("c_trd_cde", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
      members[19] = new org.omg.CORBA.StructMember("c_upr_dpt_cde", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
      members[20] = new org.omg.CORBA.StructMember("c_impt_clnt_cde", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
      members[21] = new org.omg.CORBA.StructMember("c_cntct_prsn_nme", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[22] = new org.omg.CORBA.StructMember("c_tel", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
      members[23] = new org.omg.CORBA.StructMember("c_fax", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
      members[24] = new org.omg.CORBA.StructMember("c_email", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[25] = new org.omg.CORBA.StructMember("c_clnt_addr", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[26] = new org.omg.CORBA.StructMember("c_ara_cde", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
      members[27] = new org.omg.CORBA.StructMember("c_province", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[28] = new org.omg.CORBA.StructMember("c_city", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[29] = new org.omg.CORBA.StructMember("c_place", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[30] = new org.omg.CORBA.StructMember("c_zip_cde", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
      members[31] = new org.omg.CORBA.StructMember("c_bank", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[32] = new org.omg.CORBA.StructMember("c_accnt_no", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
      members[33] = new org.omg.CORBA.StructMember("c_remark", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[34] = new org.omg.CORBA.StructMember("t_upd_tm", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
      _type = (_orb()).create_struct_tc(id(), "CustOrgn", members);
    }
    return _type;
  }
  public static java.lang.String id() {
    return "IDL:com/mcip/cus/orb/CustOrgn:1.0";
  }
}
