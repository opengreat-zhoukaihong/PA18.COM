package exceptions;

import com.mcip.orb.*;
/** Abstract Exception Translator is used for the translation of all exceptions
 *  in a system.
 *  @author Ge-BE
 */
public abstract class AbstractExceptionTranslator {

  private AbstractExceptionTranslator translator;

  public AbstractExceptionTranslator() {
    super();
  }

  public AbstractExceptionTranslator(AbstractExceptionTranslator translator) {
    setTranslator(translator);
  }

  public AbstractExceptionTranslator getTranslator() {
    return translator;
  }

  protected void setTranslator(AbstractExceptionTranslator exceptionTranslator) {
    translator = exceptionTranslator;
  }

  public CoException translate(Throwable ex) {
    return getTranslator().translate(ex);
  }
}
