////////////////////////////////////////////////////////
// Change by:  ZhanYB
// Function:   Common data function
// Used Class:
// Update Date:2000/7/20
////////////////////////////////////////////////////////

package utility;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Date;

public class LogWriter
{

    public LogWriter(String s, int i)
    {
        this(s, i, null);
    }

    public LogWriter(String s, int i, PrintWriter printwriter)
    {
        pw = printwriter;
        owner = s;
        logLevel = i;
    }

    public int getLogLevel()
    {
        return logLevel;
    }

    public PrintWriter getPrintWriter()
    {
        return pw;
    }

    private String getSeverityString(int i)
    {
        switch(i)
        {
        case 1: // '\001'
            return "error";

        case 2: // '\002'
            return "info";

        case 3: // '\003'
            return "debug";

        }
        return "Unknown";
    }

    public void log(String s, int i)
    {
        if(pw != null && i <= logLevel)
            pw.println("[" + new Date() + "]  " + getSeverityString(i) + ": " + owner + ": " + s);
    }

    public void log(Throwable throwable, String s, int i)
    {
        log(s + " : " + toTrace(throwable), i);
    }

    public void setLogLevel(int i)
    {
        logLevel = i;
    }

    public void setPrintWriter(PrintWriter printwriter)
    {
        pw = printwriter;
    }

    private String toTrace(Throwable throwable)
    {
        StringWriter stringwriter = new StringWriter();
        PrintWriter printwriter = new PrintWriter(stringwriter);
        throwable.printStackTrace(printwriter);
        printwriter.flush();
        return stringwriter.toString();
    }

    public static final int NONE = 0;
    public static final int ERROR = 1;
    public static final int INFO = 2;
    public static final int DEBUG = 3;
    private static final String ERROR_TEXT = "error";
    private static final String INFO_TEXT = "info";
    private static final String DEBUG_TEXT = "debug";
    private PrintWriter pw;
    private String owner;
    private int logLevel;
}
