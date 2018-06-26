////////////////////////////////////////////////////////
// Function:    Write operation log into log file
// Author:      ZhanYB
// Create Date: 2000/8/24
////////////////////////////////////////////////////////
// Change Log
//     Zhanyb:  11/09 Add Comment for java doc
////////////////////////////////////////////////////////

package exceptions;

import java.io.*;
import java.util.*;
import java.text.*;
import java.lang.*;

/**
 * This class is used to write exception log
 * in exceptions package and write email log
 * in mail package.
 *
 * The class with the same name in utility package
 * is not the same with this
 * <p>
 * <HR>
 * <p>
 * How to maintain the LogWriter.properties Configuration
 * <ul>
 * <li> current_subseq       (the sequence of log,no use in this module)
 * <li> log_filepath=.//     (the path where to located log file)
 * <li> log_filename=Exception    (the name of the log file)
 * <li> log_filefilter=.log   (the filter of the log file)
 * </ul>
 * <p>
 * <HR>
 *
 *
 * @author 	  Jeb Zhan
 * @version 	%I%, %G%
 * @since     JDK1.3
 */


public class LogWriter {

   private String LW_Path;
   private String LW_FileName;
   private String LW_FileFilter;
   private String LW_Severity;
   private String LW_Module;
////////////////////////////////////////////////////////
// Constructor
// Update: 2000/08/01
////////////////////////////////////////////////////////

   public LogWriter() {
       super();
       init();
   }

   public LogWriter(String Severity) {
       this();
       LW_Severity=Severity;
   }


   public LogWriter(String Path,String FileName,
       String FileFilter,String Severity) {
       String usrdir = System.getProperty("user.dir");
       LW_Path = usrdir+Path;
       LW_FileName = FileName;
       LW_FileFilter = FileFilter;
       LW_Severity=Severity;
   }

////////////////////////////////////////////////////////
// Used for return result Handling
// Update: 2000/08/01
////////////////////////////////////////////////////////

  /**
   * Error Handling in LogWriter class
   * @param                  Exception e
   * @return                 void
   */

   private void ErrorHandling(Exception e){
        e.printStackTrace ();
//      System.exit (1);
   }

////////////////////////////////////////////////////////
// Get parm from property file
// Update: 2000/08/01
////////////////////////////////////////////////////////

  /**
   * Get parm from property file
   * @return       void
   */

   public void init() {
       java.io.InputStream inputstream = getClass().getResourceAsStream(LogWriterConst.PROPERTY_FILE);
       java.util.Properties properties = new java.util.Properties();
       try{
           properties.load(inputstream);
       }catch(Exception e){
           System.out.println("Can not read from file:"+e.toString ());
           ErrorHandling(e);
       }
       String usrdir = System.getProperty("user.dir");
       LW_Path = usrdir+properties.getProperty("log_filepath");
       LW_FileName = properties.getProperty("log_filename");
       LW_FileFilter = properties.getProperty("log_filefilter");

       LW_Severity=LogWriterConst.NORMAL_INFO;
   }

////////////////////////////////////////////////////////
// Set parm to property file
// Update: 2000/08/01
////////////////////////////////////////////////////////

  /**
   * Set parm to property file
   * @param        String inKey
   * @param        String inValue
   * @return       void
   */

  synchronized private void setProperty(String inKey,String inValue) {
       java.io.InputStream inputstream = getClass().getResourceAsStream(LogWriterConst.PROPERTY_FILE);
       java.util.Properties properties = new java.util.Properties();
//       java.io.OutputStream outputstream = java.io.OutputStream.;
       try{
           properties.load(inputstream);
           properties.setProperty (inKey,inValue);
//         properties.save (outputstream);
       }catch(Exception e){
           System.out.println("Can not write property file:"+e.toString ());
           ErrorHandling(e);
       }

   }

////////////////////////////////////////////////////////
// Get Log Path
// Update: 2000/08/01
////////////////////////////////////////////////////////

  /**
   * Get Log Path
   * @return       String
   */

   private String getLWPath() {
       String LogPath="";
       if ((LW_Path==null)||(LW_Path.trim().length()==0))
           LogPath=LogWriterConst.DEFAULT_FILE_PATH;
       else
           LogPath=LW_Path;

       if (LogPath.lastIndexOf(System.getProperty("file.separator"))!=(LogPath.length()-1))
           LogPath=LogPath+System.getProperty("file.separator");

       return LogPath;
   }

////////////////////////////////////////////////////////
// Get Log File Name
// Update: 2000/08/01
////////////////////////////////////////////////////////

  /**
   * Get Log File Name
   * @return       String
   */

   private String getLWFileName() {
       String LogFileName="";

       SimpleDateFormat dF = new SimpleDateFormat(LogWriterConst.ESHORT_DATEFORMAT);
       Date dToday = new Date();
       String sTF = dF.format(dToday);

       if ((LW_FileName==null)||(LW_FileName.trim().length()==0)){
           LogFileName=sTF;
       }else{
           LogFileName=LW_FileName+"_"+sTF;
       }
       return LogFileName;
   }

////////////////////////////////////////////////////////
// Get Log File Filter
// Update: 2000/08/01
////////////////////////////////////////////////////////

  /**
   * Get Log File Filter
   * @return       String
   */

   private String getLWFileFilter() {
       String LogFileFilter="";
       if ((LW_FileFilter==null)||(LW_FileFilter.trim().length()==0)){
           LogFileFilter=LogWriterConst.DEFAULT_FILE_FILTER;
       }else{
           LogFileFilter=LW_FileFilter;
       }
       if (LogFileFilter.indexOf('.')!=0)
           LogFileFilter="."+LW_FileFilter;
       return LogFileFilter;
   }

////////////////////////////////////////////////////////
// check Log File Size
// Update: 2000/08/01
////////////////////////////////////////////////////////

  /**
   * check Log File Size
   * @parm         File Logfile
   * @return       boolean
   */

   private boolean chkLWFileSize(File logfile) {
       boolean result=true;
       long lFilesize=logfile.length();
       if (lFilesize>=LogWriterConst.LOG_FILE_MAXSIZE){
           result=false;
       }
       return result;
   }

//  File fRenametofile = new File(sRenametofile);
//  outputFile.renameTo(fRenametofile);

////////////////////////////////////////////////////////
// check Log File
// Update: 2000/08/01
////////////////////////////////////////////////////////

  /**
   * check if Log File is valid
   * @parm         File Logfile
   * @return       boolean
   */

   private boolean chkLWFile(File logfile) {
       boolean result=true;
       if (logfile.exists()){
          if (!logfile.isFile()) result=false;
          if (!logfile.canRead()) result=false;
          if (!logfile.canWrite()) result=false;
       }
       return result;
   }


////////////////////////////////////////////////////////
// Write Log Operation
// Update: 2000/08/01
////////////////////////////////////////////////////////

  /**
   * Write Log Operation
   * @parm         String content
   * @return       void
   */

  synchronized public void Writelog(String content) {

       try {
          SimpleDateFormat dF = new SimpleDateFormat(LogWriterConst.CLONG_DATETIMEFORMAT,new Locale("zh","CN"));
          Date dToday = new Date();
          String sTF = dF.format(dToday);

          String LogPath=getLWPath();
          String LogName=getLWFileName();
          String LogFilter=getLWFileFilter();

          String LOG_FULL_NAME=LogPath+LogName+LogFilter;

          File outputFile = new File(LOG_FULL_NAME);

          if (!chkLWFile(outputFile)) throw new Exception("Check File error");

          FileWriter out = new FileWriter(LOG_FULL_NAME,true);
          out.write(sTF+":   "+LW_Severity+"    "+content+'\n');
          out.close();
       }
       catch(Exception e){
          System.out.println("Can not write to file:"+e.toString ());
          ErrorHandling(e);
       }
   }

////////////////////////////////////////////////////////
// Debug Code
// Update: 2000/08/01
////////////////////////////////////////////////////////

  /**
   * Main method for debug use
   * @parm         String args[]
   * @return       void
   */

   public static void main (String args[]) {
       LogWriter lw=new LogWriter(LogWriterConst.WARNING_INFO );
       lw.Writelog("dfs");
   }
}
