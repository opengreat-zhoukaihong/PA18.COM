package com.mcip.nia.orb;
/**
<p>
<ul>
<li> <b>Java Class</b> com.mcip.nia.orb.NiaGridPackHelper
<li> <b>Source File</b> com/mcip/nia/orb/NiaGridPackHelper.java
<li> <b>IDL Source File</b> policyInfoStruct.idl
<li> <b>IDL Absolute Name</b> ::com::mcip::nia::orb::NiaGridPack
<li> <b>Repository Identifier</b> IDL:com/mcip/nia/orb/NiaGridPack:1.0
</ul>
<b>IDL definition:</b>
<pre>
    #pragma prefix "com/mcip/nia/orb"
    struct NiaGridPack {
      string c_docno;
      string t_sendtm;
      string c_blgdptcde;
      string c_source;
      string c_senddptcde;
      string c_sendcde;
      string c_desdptcde;
      string c_emergency;
      string c_authprncde;
      string c_udrmrk;
      string c_sendmrk;
      string c_udropnmrk;
      long n_vrfymrk;
      string t_mdfytm;
      string c_Insrnccde;
      wstring c_undrprsn;
      wstring c_undrdpt;
      string c_prntyp;
      string c_rinsrncmrk;
      string c_coinsrncmrk;
      string c_plyno;
      string c_edrno;
      string c_read;
      string c_flag;
      wstring c_insrntnme;
      wstring c_insrnccnm;
      wstring c_blgdptcnm;
      wstring c_senddptcnm;
      wstring c_desdptcnm;
      wstring c_undrdptcnm;
      string t_signtm;
      wstring c_rptdesc;
      string c_edrtyp;
      string c_risklvlcde;
      string c_lcnno;
      string c_engno;
      string c_insrnccls;
      string c_useatr;
      string c_apptyp;
      string t_apptm;
      string t_inputtm;
      wstring c_appnme;
      wstring c_undropn;
      string c_edrapptm;
      string c_internet_typ;
    };
</pre>
</p>
*/
abstract public class NiaGridPackHelper {
  private static org.omg.CORBA.ORB _orb() {
    return org.omg.CORBA.ORB.init();
  }
  public static com.mcip.nia.orb.NiaGridPack read(org.omg.CORBA.portable.InputStream _input) {
    com.mcip.nia.orb.NiaGridPack result = new com.mcip.nia.orb.NiaGridPack();
    result.c_docno = _input.read_string();
    result.t_sendtm = _input.read_string();
    result.c_blgdptcde = _input.read_string();
    result.c_source = _input.read_string();
    result.c_senddptcde = _input.read_string();
    result.c_sendcde = _input.read_string();
    result.c_desdptcde = _input.read_string();
    result.c_emergency = _input.read_string();
    result.c_authprncde = _input.read_string();
    result.c_udrmrk = _input.read_string();
    result.c_sendmrk = _input.read_string();
    result.c_udropnmrk = _input.read_string();
    result.n_vrfymrk = _input.read_long();
    result.t_mdfytm = _input.read_string();
    result.c_Insrnccde = _input.read_string();
    result.c_undrprsn = _input.read_wstring();
    result.c_undrdpt = _input.read_wstring();
    result.c_prntyp = _input.read_string();
    result.c_rinsrncmrk = _input.read_string();
    result.c_coinsrncmrk = _input.read_string();
    result.c_plyno = _input.read_string();
    result.c_edrno = _input.read_string();
    result.c_read = _input.read_string();
    result.c_flag = _input.read_string();
    result.c_insrntnme = _input.read_wstring();
    result.c_insrnccnm = _input.read_wstring();
    result.c_blgdptcnm = _input.read_wstring();
    result.c_senddptcnm = _input.read_wstring();
    result.c_desdptcnm = _input.read_wstring();
    result.c_undrdptcnm = _input.read_wstring();
    result.t_signtm = _input.read_string();
    result.c_rptdesc = _input.read_wstring();
    result.c_edrtyp = _input.read_string();
    result.c_risklvlcde = _input.read_string();
    result.c_lcnno = _input.read_string();
    result.c_engno = _input.read_string();
    result.c_insrnccls = _input.read_string();
    result.c_useatr = _input.read_string();
    result.c_apptyp = _input.read_string();
    result.t_apptm = _input.read_string();
    result.t_inputtm = _input.read_string();
    result.c_appnme = _input.read_wstring();
    result.c_undropn = _input.read_wstring();
    result.c_edrapptm = _input.read_string();
    result.c_internet_typ = _input.read_string();
    return result;
  }
  public static void write(org.omg.CORBA.portable.OutputStream _output, com.mcip.nia.orb.NiaGridPack value) {
    _output.write_string(value.c_docno);
    _output.write_string(value.t_sendtm);
    _output.write_string(value.c_blgdptcde);
    _output.write_string(value.c_source);
    _output.write_string(value.c_senddptcde);
    _output.write_string(value.c_sendcde);
    _output.write_string(value.c_desdptcde);
    _output.write_string(value.c_emergency);
    _output.write_string(value.c_authprncde);
    _output.write_string(value.c_udrmrk);
    _output.write_string(value.c_sendmrk);
    _output.write_string(value.c_udropnmrk);
    _output.write_long(value.n_vrfymrk);
    _output.write_string(value.t_mdfytm);
    _output.write_string(value.c_Insrnccde);
    _output.write_wstring(value.c_undrprsn);
    _output.write_wstring(value.c_undrdpt);
    _output.write_string(value.c_prntyp);
    _output.write_string(value.c_rinsrncmrk);
    _output.write_string(value.c_coinsrncmrk);
    _output.write_string(value.c_plyno);
    _output.write_string(value.c_edrno);
    _output.write_string(value.c_read);
    _output.write_string(value.c_flag);
    _output.write_wstring(value.c_insrntnme);
    _output.write_wstring(value.c_insrnccnm);
    _output.write_wstring(value.c_blgdptcnm);
    _output.write_wstring(value.c_senddptcnm);
    _output.write_wstring(value.c_desdptcnm);
    _output.write_wstring(value.c_undrdptcnm);
    _output.write_string(value.t_signtm);
    _output.write_wstring(value.c_rptdesc);
    _output.write_string(value.c_edrtyp);
    _output.write_string(value.c_risklvlcde);
    _output.write_string(value.c_lcnno);
    _output.write_string(value.c_engno);
    _output.write_string(value.c_insrnccls);
    _output.write_string(value.c_useatr);
    _output.write_string(value.c_apptyp);
    _output.write_string(value.t_apptm);
    _output.write_string(value.t_inputtm);
    _output.write_wstring(value.c_appnme);
    _output.write_wstring(value.c_undropn);
    _output.write_string(value.c_edrapptm);
    _output.write_string(value.c_internet_typ);
  }
  public static void insert(org.omg.CORBA.Any any, com.mcip.nia.orb.NiaGridPack value) {
    org.omg.CORBA.portable.OutputStream output = any.create_output_stream();
    write(output, value);
    any.read_value(output.create_input_stream(), type());
  }
  public static com.mcip.nia.orb.NiaGridPack extract(org.omg.CORBA.Any any) {
    if(!any.type().equal(type())) {
      throw new org.omg.CORBA.BAD_TYPECODE();
    }
    return read(any.create_input_stream());
  }
  private static org.omg.CORBA.TypeCode _type;
  public static org.omg.CORBA.TypeCode type() {
    if(_type == null) {
      org.omg.CORBA.StructMember[] members = new org.omg.CORBA.StructMember[45];
      members[0] = new org.omg.CORBA.StructMember("c_docno", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
      members[1] = new org.omg.CORBA.StructMember("t_sendtm", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
      members[2] = new org.omg.CORBA.StructMember("c_blgdptcde", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
      members[3] = new org.omg.CORBA.StructMember("c_source", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
      members[4] = new org.omg.CORBA.StructMember("c_senddptcde", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
      members[5] = new org.omg.CORBA.StructMember("c_sendcde", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
      members[6] = new org.omg.CORBA.StructMember("c_desdptcde", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
      members[7] = new org.omg.CORBA.StructMember("c_emergency", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
      members[8] = new org.omg.CORBA.StructMember("c_authprncde", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
      members[9] = new org.omg.CORBA.StructMember("c_udrmrk", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
      members[10] = new org.omg.CORBA.StructMember("c_sendmrk", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
      members[11] = new org.omg.CORBA.StructMember("c_udropnmrk", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
      members[12] = new org.omg.CORBA.StructMember("n_vrfymrk", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_long), null);
      members[13] = new org.omg.CORBA.StructMember("t_mdfytm", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
      members[14] = new org.omg.CORBA.StructMember("c_Insrnccde", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
      members[15] = new org.omg.CORBA.StructMember("c_undrprsn", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[16] = new org.omg.CORBA.StructMember("c_undrdpt", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[17] = new org.omg.CORBA.StructMember("c_prntyp", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
      members[18] = new org.omg.CORBA.StructMember("c_rinsrncmrk", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
      members[19] = new org.omg.CORBA.StructMember("c_coinsrncmrk", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
      members[20] = new org.omg.CORBA.StructMember("c_plyno", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
      members[21] = new org.omg.CORBA.StructMember("c_edrno", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
      members[22] = new org.omg.CORBA.StructMember("c_read", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
      members[23] = new org.omg.CORBA.StructMember("c_flag", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
      members[24] = new org.omg.CORBA.StructMember("c_insrntnme", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[25] = new org.omg.CORBA.StructMember("c_insrnccnm", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[26] = new org.omg.CORBA.StructMember("c_blgdptcnm", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[27] = new org.omg.CORBA.StructMember("c_senddptcnm", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[28] = new org.omg.CORBA.StructMember("c_desdptcnm", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[29] = new org.omg.CORBA.StructMember("c_undrdptcnm", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[30] = new org.omg.CORBA.StructMember("t_signtm", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
      members[31] = new org.omg.CORBA.StructMember("c_rptdesc", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[32] = new org.omg.CORBA.StructMember("c_edrtyp", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
      members[33] = new org.omg.CORBA.StructMember("c_risklvlcde", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
      members[34] = new org.omg.CORBA.StructMember("c_lcnno", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
      members[35] = new org.omg.CORBA.StructMember("c_engno", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
      members[36] = new org.omg.CORBA.StructMember("c_insrnccls", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
      members[37] = new org.omg.CORBA.StructMember("c_useatr", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
      members[38] = new org.omg.CORBA.StructMember("c_apptyp", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
      members[39] = new org.omg.CORBA.StructMember("t_apptm", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
      members[40] = new org.omg.CORBA.StructMember("t_inputtm", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
      members[41] = new org.omg.CORBA.StructMember("c_appnme", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[42] = new org.omg.CORBA.StructMember("c_undropn", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[43] = new org.omg.CORBA.StructMember("c_edrapptm", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
      members[44] = new org.omg.CORBA.StructMember("c_internet_typ", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
      _type = (_orb()).create_struct_tc(id(), "NiaGridPack", members);
    }
    return _type;
  }
  public static java.lang.String id() {
    return "IDL:com/mcip/nia/orb/NiaGridPack:1.0";
  }
}
