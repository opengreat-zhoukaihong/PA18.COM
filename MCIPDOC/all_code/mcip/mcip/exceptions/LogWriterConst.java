////////////////////////////////////////////////////////
// Function:    constant for LogWriter
// Author:      ZhanYB
// Create Date: 2000/8/24
////////////////////////////////////////////////////////
// Change Log
//     Zhanyb:  11/09 Add Comment for java doc
////////////////////////////////////////////////////////

package exceptions;

import java.lang.*;
public class LogWriterConst
{
  /**
   * corresponding property file
   */
    public static final String PROPERTY_FILE="LogWriter.properties";
  /**
   * system current working dir
   */
    public static final String DEFAULT_FILE_PATH=System.getProperty("user.dir")+System.getProperty("file.separator");
  /**
   * Long Datetime Format in Chinese
   */
    public static final String CLONG_DATETIMEFORMAT="yyyy年MM月dd日HH时mm分ss秒SSS";
  /**
   * Long Datetime Format in English
   */
    public static final String ELONG_DATETIMEFORMAT="yyyy-MM-dd HH:mm:ss SSS";
  /**
   * Short Date Format in English
   */
    public static final String ESHORT_DATEFORMAT="yyyyMMdd";
  /**
   * Default File Filter
   */
    public static final String DEFAULT_FILE_FILTER=".txt";


  /**
   * severity constant
   */
    public static final String NORMAL_INFO= "Normal ";
  /**
   * severity constant
   */
    public static final String WARNING_INFO="Warning";
  /**
   * severity constant
   */
    public static final String ERROR_INFO=  "Error  ";
  /**
   * severity constant
   */
    public static final String DEBUG_INFO=  "Debug  ";

  /**
   * the parm for file size
   */
    public static final long LOG_KB_UNIT=1024;
  /**
   * the parm for file size
   */
    public static final long LOG_MB_UNIT=1048576;//1024*1024
  /**
   * the parm for file max size
   */
    public static final long LOG_FILE_MAXSIZE=4*LOG_MB_UNIT;

}
