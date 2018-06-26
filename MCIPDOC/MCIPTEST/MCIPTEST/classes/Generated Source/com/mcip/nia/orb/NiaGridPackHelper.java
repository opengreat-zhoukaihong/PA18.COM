package com.mcip.nia.orb;

/**
 * <ul>
 * <li> <b>IDL Source</b>    "D:/Kevin/MCIPDOC/MCIPTEST/MCIPTEST/src/IDL/policyInfoStruct.idl"
 * <li> <b>IDL Name</b>      ::com::mcip::nia::orb::NiaGridPack
 * <li> <b>Repository Id</b> IDL:com/mcip/nia/orb/NiaGridPack:1.0
 * </ul>
 * <b>IDL definition:</b>
 * <pre>
 * struct NiaGridPack {
  ...
};
 * </pre>
 */
public final class NiaGridPackHelper {
  private static boolean _inited = false;
  private static boolean _initing = false;
  private static org.omg.CORBA.TypeCode _type;
  private static boolean _initializing;

  private static org.omg.CORBA.ORB _orb () {
    return org.omg.CORBA.ORB.init();
  }

  public static com.mcip.nia.orb.NiaGridPack read (final org.omg.CORBA.portable.InputStream _input) {
    final com.mcip.nia.orb.NiaGridPack _result = new com.mcip.nia.orb.NiaGridPack();
    _result.c_docno = _input.read_string();
    _result.t_sendtm = _input.read_string();
    _result.c_blgdptcde = _input.read_string();
    _result.c_source = _input.read_string();
    _result.c_senddptcde = _input.read_string();
    _result.c_sendcde = _input.read_string();
    _result.c_desdptcde = _input.read_string();
    _result.c_emergency = _input.read_string();
    _result.c_authprncde = _input.read_string();
    _result.c_udrmrk = _input.read_string();
    _result.c_sendmrk = _input.read_string();
    _result.c_udropnmrk = _input.read_string();
    _result.n_vrfymrk = _input.read_long();
    _result.t_mdfytm = _input.read_string();
    _result.c_Insrnccde = _input.read_string();
    _result.c_undrprsn = _input.read_wstring();
    _result.c_undrdpt = _input.read_wstring();
    _result.c_prntyp = _input.read_string();
    _result.c_rinsrncmrk = _input.read_string();
    _result.c_coinsrncmrk = _input.read_string();
    _result.c_plyno = _input.read_string();
    _result.c_edrno = _input.read_string();
    _result.c_read = _input.read_string();
    _result.c_flag = _input.read_string();
    _result.c_insrntnme = _input.read_wstring();
    _result.c_insrnccnm = _input.read_wstring();
    _result.c_blgdptcnm = _input.read_wstring();
    _result.c_senddptcnm = _input.read_wstring();
    _result.c_desdptcnm = _input.read_wstring();
    _result.c_undrdptcnm = _input.read_wstring();
    _result.t_signtm = _input.read_string();
    _result.c_rptdesc = _input.read_wstring();
    _result.c_edrtyp = _input.read_string();
    _result.c_risklvlcde = _input.read_string();
    _result.c_lcnno = _input.read_string();
    _result.c_engno = _input.read_string();
    _result.c_insrnccls = _input.read_string();
    _result.c_useatr = _input.read_string();
    _result.c_apptyp = _input.read_string();
    _result.t_apptm = _input.read_string();
    _result.t_inputtm = _input.read_string();
    _result.c_appnme = _input.read_wstring();
    _result.c_undropn = _input.read_wstring();
    _result.c_edrapptm = _input.read_string();
    _result.c_internet_typ = _input.read_string();
    return _result;
  }

  public static void write (final org.omg.CORBA.portable.OutputStream _output, final com.mcip.nia.orb.NiaGridPack _vis_value) {
    _output.write_string((java.lang.String)_vis_value.c_docno);
    _output.write_string((java.lang.String)_vis_value.t_sendtm);
    _output.write_string((java.lang.String)_vis_value.c_blgdptcde);
    _output.write_string((java.lang.String)_vis_value.c_source);
    _output.write_string((java.lang.String)_vis_value.c_senddptcde);
    _output.write_string((java.lang.String)_vis_value.c_sendcde);
    _output.write_string((java.lang.String)_vis_value.c_desdptcde);
    _output.write_string((java.lang.String)_vis_value.c_emergency);
    _output.write_string((java.lang.String)_vis_value.c_authprncde);
    _output.write_string((java.lang.String)_vis_value.c_udrmrk);
    _output.write_string((java.lang.String)_vis_value.c_sendmrk);
    _output.write_string((java.lang.String)_vis_value.c_udropnmrk);
    _output.write_long((int)_vis_value.n_vrfymrk);
    _output.write_string((java.lang.String)_vis_value.t_mdfytm);
    _output.write_string((java.lang.String)_vis_value.c_Insrnccde);
    _output.write_wstring((java.lang.String)_vis_value.c_undrprsn);
    _output.write_wstring((java.lang.String)_vis_value.c_undrdpt);
    _output.write_string((java.lang.String)_vis_value.c_prntyp);
    _output.write_string((java.lang.String)_vis_value.c_rinsrncmrk);
    _output.write_string((java.lang.String)_vis_value.c_coinsrncmrk);
    _output.write_string((java.lang.String)_vis_value.c_plyno);
    _output.write_string((java.lang.String)_vis_value.c_edrno);
    _output.write_string((java.lang.String)_vis_value.c_read);
    _output.write_string((java.lang.String)_vis_value.c_flag);
    _output.write_wstring((java.lang.String)_vis_value.c_insrntnme);
    _output.write_wstring((java.lang.String)_vis_value.c_insrnccnm);
    _output.write_wstring((java.lang.String)_vis_value.c_blgdptcnm);
    _output.write_wstring((java.lang.String)_vis_value.c_senddptcnm);
    _output.write_wstring((java.lang.String)_vis_value.c_desdptcnm);
    _output.write_wstring((java.lang.String)_vis_value.c_undrdptcnm);
    _output.write_string((java.lang.String)_vis_value.t_signtm);
    _output.write_wstring((java.lang.String)_vis_value.c_rptdesc);
    _output.write_string((java.lang.String)_vis_value.c_edrtyp);
    _output.write_string((java.lang.String)_vis_value.c_risklvlcde);
    _output.write_string((java.lang.String)_vis_value.c_lcnno);
    _output.write_string((java.lang.String)_vis_value.c_engno);
    _output.write_string((java.lang.String)_vis_value.c_insrnccls);
    _output.write_string((java.lang.String)_vis_value.c_useatr);
    _output.write_string((java.lang.String)_vis_value.c_apptyp);
    _output.write_string((java.lang.String)_vis_value.t_apptm);
    _output.write_string((java.lang.String)_vis_value.t_inputtm);
    _output.write_wstring((java.lang.String)_vis_value.c_appnme);
    _output.write_wstring((java.lang.String)_vis_value.c_undropn);
    _output.write_string((java.lang.String)_vis_value.c_edrapptm);
    _output.write_string((java.lang.String)_vis_value.c_internet_typ);
  }

  public static void insert (final org.omg.CORBA.Any any, final com.mcip.nia.orb.NiaGridPack _vis_value) {
    any.insert_Streamable(new com.mcip.nia.orb.NiaGridPackHolder(_vis_value));
  }

  public static com.mcip.nia.orb.NiaGridPack extract (final org.omg.CORBA.Any any) {
    com.mcip.nia.orb.NiaGridPack _vis_value;
    if (any instanceof com.inprise.vbroker.CORBA.Any) {
      com.mcip.nia.orb.NiaGridPackHolder _vis_holder = new com.mcip.nia.orb.NiaGridPackHolder();
      ((com.inprise.vbroker.CORBA.Any)any).extract_Streamable(_vis_holder);
      _vis_value = _vis_holder.value;
    }
    else {
      _vis_value = com.mcip.nia.orb.NiaGridPackHelper.read(any.create_input_stream());
    }
    return _vis_value;
  }

  public static org.omg.CORBA.TypeCode type () {
    if (_type == null) {
      synchronized (org.omg.CORBA.TypeCode.class) {
        if (_type == null) {
          if (_initializing) {
            return _orb().create_recursive_tc(id());
          }
          _initializing = true;
          final org.omg.CORBA.StructMember[] members = new org.omg.CORBA.StructMember[45];
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
          _type = _orb().create_struct_tc(id(), "NiaGridPack", members);
          _initializing = false;
        }
      }
    }
    return _type;
  }

  public static java.lang.String id () {
    return "IDL:com/mcip/nia/orb/NiaGridPack:1.0";
  }
}
