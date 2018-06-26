package exceptions;

import com.mcip.orb.*;

public class JSPExceptionHandler {

  public JSPExceptionHandler() {
  }

  public static void raiseExceptionFrom(CoException coEx) throws Exception {
    throw new Exception(coEx.errCode + " " + coEx.errDescription);
  }
}
