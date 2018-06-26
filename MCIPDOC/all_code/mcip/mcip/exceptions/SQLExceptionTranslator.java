package exceptions;

import java.sql.*;
import com.mcip.orb.*;
/**
 * Specific translator for the translation of java.sql.SQLException
 * @author Ge-BE
 */
public class SQLExceptionTranslator extends AbstractExceptionTranslator {

  private int[] interestedSystemDefinedCode = {1};
  private String[] interestedSystemErrorCode = {ExceptionCode.DB_UNIQUE_KEY_ERROR};

  private int[] interestedUserDefinedCode = {20010, 20020, 20030, 20040, 20050};
/*  private String[] interestedUserErrorCode = {ExceptionCode.TMS_RECOVER_ROLLFORWARD_ERROR,
                                                ExceptionCode.TMS_RECOVER_ROLLBACK_ERROR,
                                                ExceptionCode.TMS_UNKNOWN_TXN_STATUS,
                                                ExceptionCode.TMS_DUPLICATE_BEGIN_OPERATION,
                                                ExceptionCode.TMS_NO_OPERATION_FOUND};

*/
  /**
   * SQLExceptionTranslator constructor.
   */
  public SQLExceptionTranslator() {
    super();
  }

  /**
   * Sets the next translator to be used
   * @param translator com.esd.cus.exception.AbstractExceptionTranslator
   */
  public SQLExceptionTranslator(AbstractExceptionTranslator translator) {
    super(translator);
  }

  /**
   * translates the input exception.
   * @param ex java.lang.Throwable
   */
  public CoException translate(Throwable ex) {
    if (ex instanceof SQLException) {
      return translate((SQLException)ex);
    }
    return super.translate(ex);
  }

  private CoException translate(SQLException ex) {
    int originalCode = ex.getErrorCode();
    String internalCode = convert(originalCode);
    String errDescription;

    if(isUserDefinedDbCode(originalCode)) {
      errDescription = ex.toString();
    } else {
      errDescription = String.valueOf(originalCode) + " " + ex.getMessage();
    }
    return new CoException(internalCode, errDescription, "","");
  }

  /**
   * Convert database error code to application error code.
   * @return long
   * @param dbCode long
   */
  private String convert(int dbCode) {
    if(isUserDefinedDbCode(dbCode)) {
      return convertUserDefinedDbCode(dbCode);
    } else if(isSystemDefinedDbCode(dbCode))
      return convertSystemErrorDbCode(dbCode);
    else
      return ExceptionCode.DB_UNKNOWN_ERROR;
  }

  private String convertSystemErrorDbCode(int dbCode) {
/*    for (int i = 0; i < interestedSystemDefinedCode.length; i++) {
      if (dbCode == interestedSystemDefinedCode[i])
        return interestedSystemErrorCode[i];
    }
*/
    return dbErrorCode();
  }

  private String convertUserDefinedDbCode(int dbCode) {
/*    for (int i = 0; i < interestedUserDefinedCode.length; i++) {
      if (dbCode == interestedUserDefinedCode[i])
        return interestedUserErrorCode[i];
    }
*/
    return dbUserDefinedErrorCode();
  }

  /**
   * Tests whether the code is a user defined db code.
   * @return boolean
   * @param code long
   */
  private static boolean isUserDefinedDbCode(long code) {
    if(code >= userDefinedStartCode() &&
      code <= userDefinedEndCode()) {
      return true;
    }
    return false;
  }

  /**
   * Tests whether the code is a system defined db code.
   * @return boolean
   * @param code long
   */
  private static boolean isSystemDefinedDbCode(long code) {
    if (code >= systemDefinedStartCode() &&
          code <= systemDefinedEndCode()) {
      return true;
    }
    return false;
  }

  /**
   * Returns the end code for user defined db code.
   * @return long
   */
  private static int userDefinedEndCode() {
    return 20999;
  }

  /**
   * Returns the start code for user defined db code.
   * @return long
   */
  private static int userDefinedStartCode() {
    return 20000;
  }

  /**
   * Returns the end code for system defined db code.
   * @return long
   */
  private static int systemDefinedEndCode() {
    return 0; // 30734
  }

  /**
   * Returns the start code for system defined db code.
   * @return long
   */
  private static int systemDefinedStartCode() {
    return -20000;
  }

  private final static String dbErrorCode() {
    return ExceptionCode.GENERAL_DB_ERROR;
  }

  private final static String dbUserDefinedErrorCode() {
    return ExceptionCode.DB_USER_DEFINED_ERROR;
  }
}