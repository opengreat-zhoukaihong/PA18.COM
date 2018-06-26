package com.mcip.cus.orb;
/**
<p>
<ul>
<li> <b>Java Class</b> com.mcip.cus.orb.CustPrsnHelper
<li> <b>Source File</b> com/mcip/cus/orb/CustPrsnHelper.java
<li> <b>IDL Source File</b> custInfoStruct.idl
<li> <b>IDL Absolute Name</b> ::com::mcip::cus::orb::CustPrsn
<li> <b>Repository Identifier</b> IDL:com/mcip/cus/orb/CustPrsn:1.0
</ul>
<b>IDL definition:</b>
<pre>
    #pragma prefix "com/mcip/cus/orb"
    struct CustPrsn {
      string c_clnt_cde;
      string c_dpt_cde;
      long n_clnt_grp_cde;
      string c_clnt_mrk;
      wstring c_clnt_nme;
      wstring c_chn_abr;
      string c_auth_mrk;
      wstring c_brd_enm;
      wstring c_eng_abr;
      string c_rgst_no;
      string c_sex;
      wstring c_hmtwn;
      string c_ntn_cde;
      string t_birthday;
      string c_mrg_cde;
      wstring c_grdt;
      string c_major_cde;
      string c_edu_cde;
      wstring c_work_dpt;
      string c_title_cde;
      string c_duty;
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
      string c_impt_clnt_cde;
      string t_upd_tm;
    };
</pre>
</p>
*/
abstract public class CustPrsnHelper {
  private static org.omg.CORBA.ORB _orb() {
    return org.omg.CORBA.ORB.init();
  }
  public static com.mcip.cus.orb.CustPrsn read(org.omg.CORBA.portable.InputStream _input) {
    com.mcip.cus.orb.CustPrsn result = new com.mcip.cus.orb.CustPrsn();
    result.c_clnt_cde = _input.read_string();
    result.c_dpt_cde = _input.read_string();
    result.n_clnt_grp_cde = _input.read_long();
    result.c_clnt_mrk = _input.read_string();
    result.c_clnt_nme = _input.read_wstring();
    result.c_chn_abr = _input.read_wstring();
    result.c_auth_mrk = _input.read_string();
    result.c_brd_enm = _input.read_wstring();
    result.c_eng_abr = _input.read_wstring();
    result.c_rgst_no = _input.read_string();
    result.c_sex = _input.read_string();
    result.c_hmtwn = _input.read_wstring();
    result.c_ntn_cde = _input.read_string();
    result.t_birthday = _input.read_string();
    result.c_mrg_cde = _input.read_string();
    result.c_grdt = _input.read_wstring();
    result.c_major_cde = _input.read_string();
    result.c_edu_cde = _input.read_string();
    result.c_work_dpt = _input.read_wstring();
    result.c_title_cde = _input.read_string();
    result.c_duty = _input.read_string();
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
    result.c_impt_clnt_cde = _input.read_string();
    result.t_upd_tm = _input.read_string();
    return result;
  }
  public static void write(org.omg.CORBA.portable.OutputStream _output, com.mcip.cus.orb.CustPrsn value) {
    _output.write_string(value.c_clnt_cde);
    _output.write_string(value.c_dpt_cde);
    _output.write_long(value.n_clnt_grp_cde);
    _output.write_string(value.c_clnt_mrk);
    _output.write_wstring(value.c_clnt_nme);
    _output.write_wstring(value.c_chn_abr);
    _output.write_string(value.c_auth_mrk);
    _output.write_wstring(value.c_brd_enm);
    _output.write_wstring(value.c_eng_abr);
    _output.write_string(value.c_rgst_no);
    _output.write_string(value.c_sex);
    _output.write_wstring(value.c_hmtwn);
    _output.write_string(value.c_ntn_cde);
    _output.write_string(value.t_birthday);
    _output.write_string(value.c_mrg_cde);
    _output.write_wstring(value.c_grdt);
    _output.write_string(value.c_major_cde);
    _output.write_string(value.c_edu_cde);
    _output.write_wstring(value.c_work_dpt);
    _output.write_string(value.c_title_cde);
    _output.write_string(value.c_duty);
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
    _output.write_string(value.c_impt_clnt_cde);
    _output.write_string(value.t_upd_tm);
  }
  public static void insert(org.omg.CORBA.Any any, com.mcip.cus.orb.CustPrsn value) {
    org.omg.CORBA.portable.OutputStream output = any.create_output_stream();
    write(output, value);
    any.read_value(output.create_input_stream(), type());
  }
  public static com.mcip.cus.orb.CustPrsn extract(org.omg.CORBA.Any any) {
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
      members[7] = new org.omg.CORBA.StructMember("c_brd_enm", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[8] = new org.omg.CORBA.StructMember("c_eng_abr", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[9] = new org.omg.CORBA.StructMember("c_rgst_no", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
      members[10] = new org.omg.CORBA.StructMember("c_sex", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
      members[11] = new org.omg.CORBA.StructMember("c_hmtwn", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[12] = new org.omg.CORBA.StructMember("c_ntn_cde", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
      members[13] = new org.omg.CORBA.StructMember("t_birthday", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
      members[14] = new org.omg.CORBA.StructMember("c_mrg_cde", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
      members[15] = new org.omg.CORBA.StructMember("c_grdt", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[16] = new org.omg.CORBA.StructMember("c_major_cde", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
      members[17] = new org.omg.CORBA.StructMember("c_edu_cde", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
      members[18] = new org.omg.CORBA.StructMember("c_work_dpt", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[19] = new org.omg.CORBA.StructMember("c_title_cde", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
      members[20] = new org.omg.CORBA.StructMember("c_duty", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
      members[21] = new org.omg.CORBA.StructMember("c_tel", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
      members[22] = new org.omg.CORBA.StructMember("c_fax", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
      members[23] = new org.omg.CORBA.StructMember("c_email", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[24] = new org.omg.CORBA.StructMember("c_clnt_addr", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[25] = new org.omg.CORBA.StructMember("c_ara_cde", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
      members[26] = new org.omg.CORBA.StructMember("c_province", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[27] = new org.omg.CORBA.StructMember("c_city", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[28] = new org.omg.CORBA.StructMember("c_place", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[29] = new org.omg.CORBA.StructMember("c_zip_cde", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
      members[30] = new org.omg.CORBA.StructMember("c_bank", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[31] = new org.omg.CORBA.StructMember("c_accnt_no", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
      members[32] = new org.omg.CORBA.StructMember("c_remark", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[33] = new org.omg.CORBA.StructMember("c_impt_clnt_cde", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
      members[34] = new org.omg.CORBA.StructMember("t_upd_tm", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
      _type = (_orb()).create_struct_tc(id(), "CustPrsn", members);
    }
    return _type;
  }
  public static java.lang.String id() {
    return "IDL:com/mcip/cus/orb/CustPrsn:1.0";
  }
}
