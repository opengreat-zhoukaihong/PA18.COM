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
public final class PlyEdrAppRdrInfo implements org.omg.CORBA.portable.IDLEntity {
  
  public java.lang.String[][] edrapprdr;

  public PlyEdrAppRdrInfo () {
  }

  public PlyEdrAppRdrInfo (final java.lang.String[][] edrapprdr) {
    this.edrapprdr = edrapprdr;
  }

  private transient java.util.Hashtable _printMap = null;
  public java.lang.String toString() {
    final java.lang.StringBuffer _ret = new java.lang.StringBuffer("struct com.mcip.nia.orb.PlyEdrAppRdrInfo {");
    final java.lang.Thread _currentThread = java.lang.Thread.currentThread();
    boolean justCreated = false;
    if (_printMap == null) {
      synchronized (this) {
        if (_printMap == null) {
          justCreated = true;
          _printMap = new java.util.Hashtable();
        }
      }
    }
    if (!justCreated) {
      if (_printMap.get(_currentThread) != null) {
        _ret.append("...}");
        return _ret.toString();
      }
    }
    _printMap.put(_currentThread, this);
    _ret.append("\n");
    _ret.append("java.lang.String[][] edrapprdr=");
    _ret.append("{");
    if (edrapprdr == null) {
      _ret.append(edrapprdr);
    } else {
      for (int $counter0 = 0; $counter0 < edrapprdr.length; $counter0++) {
        _ret.append("{");
        if (edrapprdr[$counter0] == null) {
          _ret.append(edrapprdr[$counter0]);
        } else {
          for (int $counter1 = 0; $counter1 < edrapprdr[$counter0].length; $counter1++) {
            _ret.append(edrapprdr[$counter0][$counter1] != null?'\"' + edrapprdr[$counter0][$counter1] + '\"':null);
            if ($counter1 < edrapprdr[$counter0].length - 1) {
              _ret.append(",");
            }
          }
        }
        _ret.append("}");
        if ($counter0 < edrapprdr.length - 1) {
          _ret.append(",");
        }
      }
    }
    _ret.append("}");
    _ret.append("\n");
    _printMap.remove(_currentThread);
    _ret.append("}");
    return _ret.toString();
  }

  private transient java.util.Hashtable _cmpMap = null;
  public boolean equals (java.lang.Object o) {
    if (this == o) return true;
    if (o == null) return false;

    final java.lang.Thread _currentThread = java.lang.Thread.currentThread();
    boolean justCreated = false;
    if (_cmpMap == null) {
      synchronized (this) {
        if (_cmpMap == null) {
          justCreated = true;
          _cmpMap = new java.util.Hashtable();
        }
      }
    }
    if (!justCreated) {
      final java.lang.Object _cmpObj;
      _cmpObj= _cmpMap.get(_currentThread);
      if (_cmpObj != null) return o == _cmpObj;
    }
    if (o instanceof com.mcip.nia.orb.PlyEdrAppRdrInfo) {
      _cmpMap.put(_currentThread, o);
      final com.mcip.nia.orb.PlyEdrAppRdrInfo obj = (com.mcip.nia.orb.PlyEdrAppRdrInfo)o;
      boolean res = true;
      do {
          if (res = (this.edrapprdr.length == obj.edrapprdr.length)) {
            for (int $counter2 = 0; res && $counter2 < this.edrapprdr.length; $counter2++) {
                if (res = (this.edrapprdr[$counter2].length == obj.edrapprdr[$counter2].length)) {
                  for (int $counter3 = 0; res && $counter3 < this.edrapprdr[$counter2].length; $counter3++) {
                    res = this.edrapprdr[$counter2][$counter3] == obj.edrapprdr[$counter2][$counter3] ||
                     (this.edrapprdr[$counter2][$counter3] != null && obj.edrapprdr[$counter2][$counter3] != null && this.edrapprdr[$counter2][$counter3].equals(obj.edrapprdr[$counter2][$counter3]));
                  }
                }
            }
          }
      } while (false);
      _cmpMap.remove(_currentThread);
      return res;
    }
    else {
      return false;
    }
  }
}
