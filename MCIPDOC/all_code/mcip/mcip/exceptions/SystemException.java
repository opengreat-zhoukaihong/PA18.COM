package exceptions;

/**
  * General System Exception
  */
public class SystemException extends Exception {

  private String errCode;
  private String errClassName;
  private String errMethodName;
  private String errDescription;
  private String errFieldName;

  public SystemException() {
    setErrCode(ExceptionCode.GENERAL_SYSTEM_EXCEPTION);
    setErrClassName("");
    setErrMethodName("");
    setErrDescription("");
    setErrFieldName("");
  }

  public SystemException(String errCode, String errClassName, String errMethodName) {
    setErrCode(errCode);
    setErrClassName(errClassName);
    setErrMethodName(errMethodName);
    setErrDescription("");
    setErrFieldName("");
  }

  public SystemException(String errCode, String errClassName, String errMethodName, String errDescription) {
    setErrCode(errCode);
    setErrClassName(errClassName);
    setErrMethodName(errMethodName);
    setErrDescription(errDescription);
    setErrFieldName("");
  }

  public SystemException(String errCode, String errClassName, String errMethodName, String errDescription, String errFieldName) {
    setErrCode(errCode);
    setErrClassName(errClassName);
    setErrMethodName(errMethodName);
    setErrDescription(errDescription);
    setErrFieldName(errFieldName);
  }

  /**
   * sets the error code of the ESDUserException.
   * @param errCode
   */
  public void setErrCode(String errCode) {
    this.errCode = errCode;
  }

  /**
   * returns the error code of the ESDUserException.
   * @return
   */
  public String getErrCode() {
    return errCode;
  }

  /**
   * sets the class name where the exception occurs.
   * @param errClassName
   */
  public void setErrClassName(String errClassName) {
    this.errClassName = errClassName;
  }

  /**
   * returns the class name where the exception occurs.
   * @return
   */
  public String getErrClassName() {
    return errClassName;
  }

  /**
   * sets the method name where the exception occurs.
   * @param errMethodName
   */
  public void setErrMethodName(String errMethodName) {
    this.errMethodName = errMethodName;
  }

  /**
   * returns the method name where the exception occurs.
   * @return
   */
  public String getErrMethodName() {
    return errMethodName;
  }

  /**
   * sets the error description of the ESDUserException.
   * @param errDescription
   */
  public void setErrDescription(String errDescription) {
    this.errDescription = errDescription;
  }

  /**
   * returns the error description of the ESDUserException.
   * @return
   */
  public String getErrDescription() {
    return errDescription;
  }

  /**
   * sets the error description of the ESDUserException.
   * @param errDescription
   */
  public void setErrFieldName(String errFieldName) {
    this.errFieldName = errFieldName;
  }

  /**
   * returns the error description of the ESDUserException.
   * @return
   */
  public String getErrFieldName() {
    return errFieldName;
  }


}
