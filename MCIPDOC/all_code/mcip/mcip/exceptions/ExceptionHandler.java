package exceptions;

import com.mcip.orb.*;
/**
 *  This abstract class provides some default method implementations for
 *  all the exception handlers in the System. It takes care of the
 *  translation of exceptions and the exception logging.
 *  @author Ge-BE
 */
public abstract class ExceptionHandler {

  protected AbstractExceptionTranslator exceptionTranslator;

  public ExceptionHandler() {
    exceptionTranslator = getTranslator();
  }

  protected abstract AbstractExceptionTranslator getTranslator();

  public void handle(Throwable ex, String errClassName, String errMethodName) throws CoException {

    CoException resultEx;
    if (ex instanceof CoException) {
      resultEx = (CoException) ex;
    } else {
      resultEx = exceptionTranslator.translate(ex);
    }
    systemOutPrintln(resultEx, errClassName, errMethodName);
    throw resultEx;
  }

  private void systemOutPrintln(CoException ce, String errClassName, String errMethodName) {
    String result;
    result = "CoException: \n" +
             "  Code        : " + ce.errCode + "\n" +
             "  Description : " + ce.errDescription + "\n" +
             "  Field Name  : " + ce.errFieldName + "\n" +
             "caught in " + errClassName + " >> " + errMethodName;
    System.out.println(result);
  }

  private class PostProcessThread extends Thread {
    public void run() {
      createExceptionLog();
    }
  }

  private void postProcess() throws CoException {
    PostProcessThread aPostProcess = new PostProcessThread();
    aPostProcess.start();
  }

  protected abstract void createExceptionLog();

}

