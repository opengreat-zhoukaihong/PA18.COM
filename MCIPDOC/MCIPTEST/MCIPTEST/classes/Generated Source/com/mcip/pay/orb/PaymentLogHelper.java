package com.mcip.pay.orb;

/**
 * <ul>
 * <li> <b>IDL Source</b>    "D:/Kevin/MCIPDOC/MCIPTEST/MCIPTEST/src/IDL/paymentInfoStruct.idl"
 * <li> <b>IDL Name</b>      ::com::mcip::pay::orb::PaymentLog
 * <li> <b>Repository Id</b> IDL:com/mcip/pay/orb/PaymentLog:1.0
 * </ul>
 * <b>IDL definition:</b>
 * <pre>
 * struct PaymentLog {
  ...
};
 * </pre>
 */
public final class PaymentLogHelper {
  private static boolean _inited = false;
  private static boolean _initing = false;
  private static org.omg.CORBA.TypeCode _type;
  private static boolean _initializing;

  private static org.omg.CORBA.ORB _orb () {
    return org.omg.CORBA.ORB.init();
  }

  public static com.mcip.pay.orb.PaymentLog read (final org.omg.CORBA.portable.InputStream _input) {
    final com.mcip.pay.orb.PaymentLog _result = new com.mcip.pay.orb.PaymentLog();
    _result.c_trans_id = _input.read_string();
    _result.c_bank_cde = _input.read_string();
    _result.c_bank_cnm = _input.read_wstring();
    _result.c_bank_accnt = _input.read_wstring();
    _result.n_got_prm = _input.read_double();
    _result.c_cur_typ = _input.read_wstring();
    _result.c_cur_sbl = _input.read_wstring();
    _result.c_cur_cnm = _input.read_wstring();
    _result.t_pay_tm = _input.read_string();
    _result.c_pay_typ = _input.read_wstring();
    _result.c_pay_cde = _input.read_wstring();
    _result.c_order_no = _input.read_wstring();
    _result.t_order_tm = _input.read_string();
    _result.c_type_id = _input.read_wstring();
    _result.c_payment_id = _input.read_wstring();
    _result.c_pay_seq_no = _input.read_wstring();
    _result.c_status_id = _input.read_wstring();
    _result.c_user_id = _input.read_wstring();
    return _result;
  }

  public static void write (final org.omg.CORBA.portable.OutputStream _output, final com.mcip.pay.orb.PaymentLog _vis_value) {
    _output.write_string((java.lang.String)_vis_value.c_trans_id);
    _output.write_string((java.lang.String)_vis_value.c_bank_cde);
    _output.write_wstring((java.lang.String)_vis_value.c_bank_cnm);
    _output.write_wstring((java.lang.String)_vis_value.c_bank_accnt);
    _output.write_double((double)_vis_value.n_got_prm);
    _output.write_wstring((java.lang.String)_vis_value.c_cur_typ);
    _output.write_wstring((java.lang.String)_vis_value.c_cur_sbl);
    _output.write_wstring((java.lang.String)_vis_value.c_cur_cnm);
    _output.write_string((java.lang.String)_vis_value.t_pay_tm);
    _output.write_wstring((java.lang.String)_vis_value.c_pay_typ);
    _output.write_wstring((java.lang.String)_vis_value.c_pay_cde);
    _output.write_wstring((java.lang.String)_vis_value.c_order_no);
    _output.write_string((java.lang.String)_vis_value.t_order_tm);
    _output.write_wstring((java.lang.String)_vis_value.c_type_id);
    _output.write_wstring((java.lang.String)_vis_value.c_payment_id);
    _output.write_wstring((java.lang.String)_vis_value.c_pay_seq_no);
    _output.write_wstring((java.lang.String)_vis_value.c_status_id);
    _output.write_wstring((java.lang.String)_vis_value.c_user_id);
  }

  public static void insert (final org.omg.CORBA.Any any, final com.mcip.pay.orb.PaymentLog _vis_value) {
    any.insert_Streamable(new com.mcip.pay.orb.PaymentLogHolder(_vis_value));
  }

  public static com.mcip.pay.orb.PaymentLog extract (final org.omg.CORBA.Any any) {
    com.mcip.pay.orb.PaymentLog _vis_value;
    if (any instanceof com.inprise.vbroker.CORBA.Any) {
      com.mcip.pay.orb.PaymentLogHolder _vis_holder = new com.mcip.pay.orb.PaymentLogHolder();
      ((com.inprise.vbroker.CORBA.Any)any).extract_Streamable(_vis_holder);
      _vis_value = _vis_holder.value;
    }
    else {
      _vis_value = com.mcip.pay.orb.PaymentLogHelper.read(any.create_input_stream());
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
          final org.omg.CORBA.StructMember[] members = new org.omg.CORBA.StructMember[18];
          members[0] = new org.omg.CORBA.StructMember("c_trans_id", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
          members[1] = new org.omg.CORBA.StructMember("c_bank_cde", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
          members[2] = new org.omg.CORBA.StructMember("c_bank_cnm", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
          members[3] = new org.omg.CORBA.StructMember("c_bank_accnt", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
          members[4] = new org.omg.CORBA.StructMember("n_got_prm", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_double), null);
          members[5] = new org.omg.CORBA.StructMember("c_cur_typ", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
          members[6] = new org.omg.CORBA.StructMember("c_cur_sbl", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
          members[7] = new org.omg.CORBA.StructMember("c_cur_cnm", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
          members[8] = new org.omg.CORBA.StructMember("t_pay_tm", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
          members[9] = new org.omg.CORBA.StructMember("c_pay_typ", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
          members[10] = new org.omg.CORBA.StructMember("c_pay_cde", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
          members[11] = new org.omg.CORBA.StructMember("c_order_no", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
          members[12] = new org.omg.CORBA.StructMember("t_order_tm", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
          members[13] = new org.omg.CORBA.StructMember("c_type_id", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
          members[14] = new org.omg.CORBA.StructMember("c_payment_id", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
          members[15] = new org.omg.CORBA.StructMember("c_pay_seq_no", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
          members[16] = new org.omg.CORBA.StructMember("c_status_id", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
          members[17] = new org.omg.CORBA.StructMember("c_user_id", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
          _type = _orb().create_struct_tc(id(), "PaymentLog", members);
          _initializing = false;
        }
      }
    }
    return _type;
  }

  public static java.lang.String id () {
    return "IDL:com/mcip/pay/orb/PaymentLog:1.0";
  }
}
