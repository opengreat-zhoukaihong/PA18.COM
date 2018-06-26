package exceptions;
import com.mcip.orb.*;
/**
 *  Generic exception translator for all exceptions. The input exceptions
 *  are intrepreted as system error and are translated to one system error code
 *  with description equals the error messages of the exceptions.
 *  @author Ge-BE
 */
public class GenericExceptionTranslator extends AbstractExceptionTranslator {

  /**
   * GenericExceptionTranslator constructor.
   */
  public GenericExceptionTranslator() {
    super();
  }

  /**
   * translates the input exception.
   * @param ex java.lang.Throwable
   */
  public CoException translate(Throwable ex) {
    return new CoException(systemErrorCode(),ex.toString(),"","");
  }

  private final static String systemErrorCode() {
    return ExceptionCode.GENERAL_SYS_ERROR;
  }

}
