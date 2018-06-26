package exceptions;

public class SQLExceptionHandler extends ExceptionHandler {

  public SQLExceptionHandler() {
    super();
  }

  protected void createExceptionLog() {;}

  protected AbstractExceptionTranslator getTranslator() {
    return new SQLExceptionTranslator(
              new GenericExceptionTranslator());
  }

}
