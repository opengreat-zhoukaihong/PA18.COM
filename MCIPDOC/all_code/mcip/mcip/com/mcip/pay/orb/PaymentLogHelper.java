package com.mcip.pay.orb;
/**
<p>
<ul>
<li> <b>Java Class</b> com.mcip.pay.orb.PaymentLogHelper
<li> <b>Source File</b> com/mcip/pay/orb/PaymentLogHelper.java
<li> <b>IDL Source File</b> paymentInfoStruct.idl
<li> <b>IDL Absolute Name</b> ::com::mcip::pay::orb::PaymentLog
<li> <b>Repository Identifier</b> IDL:com/mcip/pay/orb/PaymentLog:1.0
</ul>
<b>IDL definition:</b>
<pre>
    #pragma prefix "com/mcip/pay/orb"
    struct PaymentLog {
      string c_trans_id;
      string c_bank_cde;
      wstring c_bank_cnm;
      wstring c_bank_accnt;
      double n_got_prm;
      wstring c_cur_typ;
      wstring c_cur_sbl;
      wstring c_cur_cnm;
      string t_pay_tm;
      wstring c_pay_typ;
      wstring c_pay_cde;
      wstring c_order_no;
      string t_order_tm;
      wstring c_type_id;
      wstring c_payment_id;
      wstring c_pay_seq_no;
      wstring c_status_id;
      wstring c_user_id;
    };
</pre>
</p>
*/
abstract public class PaymentLogHelper {
  private static org.omg.CORBA.ORB _orb() {
    return org.omg.CORBA.ORB.init();
  }
  public static com.mcip.pay.orb.PaymentLog read(org.omg.CORBA.portable.InputStream _input) {
    com.mcip.pay.orb.PaymentLog result = new com.mcip.pay.orb.PaymentLog();
    result.c_trans_id = _input.read_string();
    result.c_bank_cde = _input.read_string();
    result.c_bank_cnm = _input.read_wstring();
    result.c_bank_accnt = _input.read_wstring();
    result.n_got_prm = _input.read_double();
    result.c_cur_typ = _input.read_wstring();
    result.c_cur_sbl = _input.read_wstring();
    result.c_cur_cnm = _input.read_wstring();
    result.t_pay_tm = _input.read_string();
    result.c_pay_typ = _input.read_wstring();
    result.c_pay_cde = _input.read_wstring();
    result.c_order_no = _input.read_wstring();
    result.t_order_tm = _input.read_string();
    result.c_type_id = _input.read_wstring();
    result.c_payment_id = _input.read_wstring();
    result.c_pay_seq_no = _input.read_wstring();
    result.c_status_id = _input.read_wstring();
    result.c_user_id = _input.read_wstring();
    return result;
  }
  public static void write(org.omg.CORBA.portable.OutputStream _output, com.mcip.pay.orb.PaymentLog value) {
    _output.write_string(value.c_trans_id);
    _output.write_string(value.c_bank_cde);
    _output.write_wstring(value.c_bank_cnm);
    _output.write_wstring(value.c_bank_accnt);
    _output.write_double(value.n_got_prm);
    _output.write_wstring(value.c_cur_typ);
    _output.write_wstring(value.c_cur_sbl);
    _output.write_wstring(value.c_cur_cnm);
    _output.write_string(value.t_pay_tm);
    _output.write_wstring(value.c_pay_typ);
    _output.write_wstring(value.c_pay_cde);
    _output.write_wstring(value.c_order_no);
    _output.write_string(value.t_order_tm);
    _output.write_wstring(value.c_type_id);
    _output.write_wstring(value.c_payment_id);
    _output.write_wstring(value.c_pay_seq_no);
    _output.write_wstring(value.c_status_id);
    _output.write_wstring(value.c_user_id);
  }
  public static void insert(org.omg.CORBA.Any any, com.mcip.pay.orb.PaymentLog value) {
    org.omg.CORBA.portable.OutputStream output = any.create_output_stream();
    write(output, value);
    any.read_value(output.create_input_stream(), type());
  }
  public static com.mcip.pay.orb.PaymentLog extract(org.omg.CORBA.Any any) {
    if(!any.type().equal(type())) {
      throw new org.omg.CORBA.BAD_TYPECODE();
    }
    return read(any.create_input_stream());
  }
  private static org.omg.CORBA.TypeCode _type;
  public static org.omg.CORBA.TypeCode type() {
    if(_type == null) {
      org.omg.CORBA.StructMember[] members = new org.omg.CORBA.StructMember[18];
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
      _type = (_orb()).create_struct_tc(id(), "PaymentLog", members);
    }
    return _type;
  }
  public static java.lang.String id() {
    return "IDL:com/mcip/pay/orb/PaymentLog:1.0";
  }
}
