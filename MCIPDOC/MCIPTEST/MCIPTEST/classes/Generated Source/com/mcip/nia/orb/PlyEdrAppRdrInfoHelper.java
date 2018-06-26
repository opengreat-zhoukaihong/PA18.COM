package com.mcip.nia.orb;

/**
 * <ul>
 * <li> <b>IDL Source</b>    "D:/Kevin/MCIPDOC/MCIPTEST/MCIPTEST/src/IDL/policyInfoStruct.idl"
 * <li> <b>IDL Name</b>      ::com::mcip::nia::orb::PlyEdrAppRdrInfo
 * <li> <b>Repository Id</b> IDL:com/mcip/nia/orb/PlyEdrAppRdrInfo:1.0
 * </ul>
 * <b>IDL definition:</b>
 * <pre>
 * struct PlyEdrAppRdrInfo {
  ...
};
 * </pre>
 */
public final class PlyEdrAppRdrInfoHelper {
  private static boolean _inited = false;
  private static boolean _initing = false;
  private static org.omg.CORBA.TypeCode _type;
  private static boolean _initializing;

  private static org.omg.CORBA.ORB _orb () {
    return org.omg.CORBA.ORB.init();
  }

  public static com.mcip.nia.orb.PlyEdrAppRdrInfo read (final org.omg.CORBA.portable.InputStream _input) {
    final com.mcip.nia.orb.PlyEdrAppRdrInfo _result = new com.mcip.nia.orb.PlyEdrAppRdrInfo();
    _result.edrapprdr = com.mcip.orb.StringssHelper.read(_input);
    return _result;
  }

  public static void write (final org.omg.CORBA.portable.OutputStream _output, final com.mcip.nia.orb.PlyEdrAppRdrInfo _vis_value) {
    com.mcip.orb.StringssHelper.write(_output, _vis_value.edrapprdr);
  }

  public static void insert (final org.omg.CORBA.Any any, final com.mcip.nia.orb.PlyEdrAppRdrInfo _vis_value) {
    any.insert_Streamable(new com.mcip.nia.orb.PlyEdrAppRdrInfoHolder(_vis_value));
  }

  public static com.mcip.nia.orb.PlyEdrAppRdrInfo extract (final org.omg.CORBA.Any any) {
    com.mcip.nia.orb.PlyEdrAppRdrInfo _vis_value;
    if (any instanceof com.inprise.vbroker.CORBA.Any) {
      com.mcip.nia.orb.PlyEdrAppRdrInfoHolder _vis_holder = new com.mcip.nia.orb.PlyEdrAppRdrInfoHolder();
      ((com.inprise.vbroker.CORBA.Any)any).extract_Streamable(_vis_holder);
      _vis_value = _vis_holder.value;
    }
    else {
      _vis_value = com.mcip.nia.orb.PlyEdrAppRdrInfoHelper.read(any.create_input_stream());
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
          final org.omg.CORBA.StructMember[] members = new org.omg.CORBA.StructMember[1];
          members[0] = new org.omg.CORBA.StructMember("edrapprdr", com.mcip.orb.StringssHelper.type(), null);
          _type = _orb().create_struct_tc(id(), "PlyEdrAppRdrInfo", members);
          _initializing = false;
        }
      }
    }
    return _type;
  }

  public static java.lang.String id () {
    return "IDL:com/mcip/nia/orb/PlyEdrAppRdrInfo:1.0";
  }
}
