////////////////////////////////////////////////////////
// Function:    constant for LogWriter
// Change by:   ZhanYB
// Create Date: 2000/8/24
////////////////////////////////////////////////////////


package exceptions;
import com.mcip.orb.*;
import constant.*;


public class CoExceptionHandler extends ExceptionHandler {

  public CoExceptionHandler() {
    super();
  }

  public CoExceptionHandler(String errFilePath) {
    super();
  }

  protected void createExceptionLog() {;}

  public static void WriteLog(String severity,String content) {
       exceptions.LogWriter lw=new LogWriter(severity);
       lw.Writelog(content);
  }

  protected void createExceptionLog(CoException e) {
       String content="Code:"+e.errCode+"; "+
                      "Desc:"+e.errDescription+"; "+
                      "Field:"+e.errFieldName+"; "+
                      "Sevirity:"+e.severity;
       String severity=LogWriterConst.ERROR_INFO;
       if (e.severity.equalsIgnoreCase(Constant.WARNING)){
           severity=LogWriterConst.WARNING_INFO;
       }
       LogWriter lw=new LogWriter(severity);
       lw.Writelog(content);
  }


  protected AbstractExceptionTranslator getTranslator() {
    return new SystemExceptionTranslator (
            new SQLExceptionTranslator(
              new GenericExceptionTranslator()));
  }

  public void raiseCoException(String errorCode) throws CoException {
      CoException e = new CoException(errorCode,MessageReader.getMessage(errorCode), "", Constant.ERROR);
      createExceptionLog(e);
      throw e;
  }

  public void raiseCoException(String errorCode,String errorDesc) throws CoException {
/* Modified by YiJF on Nov 09,2000
      String temp=MessageReader.getMessage(errorCode);
      if (errorDesc!=null)
          temp+=":"+errorDesc;
      CoException e = new CoException(errorCode,temp, "", Constant.ERROR);
*/
      String temp=MessageReader.getMessage(errorCode);
      if ((errorDesc!=null) && (errorDesc.length() > 0))
          temp+="\n"+errorDesc;
      CoException e = new CoException(errorCode,temp, "", Constant.ERROR);
      createExceptionLog(e);
      throw e;
  }

  public void raiseCoException(String errorCode,String errorDesc,String errorFieldName) throws CoException {
/* Modified by YiJF on Nov 09,2000
      String temp=MessageReader.getMessage(errorCode);
      if (errorDesc!=null)
          temp+=":"+errorDesc;
      CoException e = new CoException(errorCode,MessageReader.getMessage(errorCode)+":"+errorDesc, errorFieldName, Constant.ERROR);
*/
      String temp=MessageReader.getMessage(errorCode);
      if ((errorDesc!=null) && (errorDesc.length() > 0))
          temp+="\n"+errorDesc;
      CoException e = new CoException(errorCode,temp, errorFieldName, Constant.ERROR);
      createExceptionLog(e);
      throw e;
  }

  public void raiseCoException(String errorCode,String errorDesc,String errorFieldName,String errorSeverity) throws CoException {
/* Modified by YiJF on Nov 09,2000
      String temp=MessageReader.getMessage(errorCode);
      if (errorDesc!=null)
          temp+=":"+errorDesc;
      CoException e = new CoException(errorCode,MessageReader.getMessage(errorCode)+":"+errorDesc, errorFieldName, errorSeverity);
*/
      String temp=MessageReader.getMessage(errorCode);
      if ((errorDesc!=null) && (errorDesc.length() > 0))
          temp+="\n"+errorDesc;
      CoException e = new CoException(errorCode,temp, errorFieldName, errorSeverity);
      createExceptionLog(e);
      throw e;

  }

}
