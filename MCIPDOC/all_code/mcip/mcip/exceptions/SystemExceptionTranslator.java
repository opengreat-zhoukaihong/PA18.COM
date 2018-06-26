package exceptions;

import com.mcip.orb.*;

/**
 * Specific translator for the translation of SystemException and all
 * its subclasses.
 */
public class SystemExceptionTranslator extends AbstractExceptionTranslator {

  public SystemExceptionTranslator() {
    super();
  }

  /**
   * Sets the next translator to be used
   * @param translator com.esd.cus.exception.AbstractExceptionTranslator
   */
  public SystemExceptionTranslator(AbstractExceptionTranslator translator) {
    super(translator);
  }

  /**
   * translates the input exception.
   * @param ex java.lang.Throwable
   */
  public CoException translate(Throwable ex) {
    if (ex instanceof SystemException) {
      return translate((SystemException)ex);
    }
    return super.translate(ex);
  }

  private CoException translate(SystemException ex) {
    return new CoException(ex.getErrCode(),
                            systemExceptionDescription(ex),
                              ex.getErrFieldName(),"");

  }

  private String systemExceptionDescription(SystemException ex) {
    String result;
    result = "Description: " + ex.getErrDescription() + "\n" +
             "Source: " + ex.getErrClassName() + " >> " + ex.getErrMethodName() + "\n";
    return result;
  }
}