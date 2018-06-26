package utility;



import java.util.*;

import javax.servlet.*;
import javax.servlet.http.*;

public class Browser extends HttpServlet
{
   protected HttpServletRequest request;
   protected HttpSession session;

   protected String userAgent;
   protected String company; // Firmenname des Herstellers
   protected String name; // Bezeichnung des Browsers
   protected String version; // Version
   protected String mainVersion; // Hauptversion
   protected String minorVersion; // Unterversion
   protected String os; // Betriebssystem
   protected String language = "de"; // Sprachcode Standard
   protected Locale locale; // Locale-Objekt mit den aktuellen
   // Spracheinstellungen

   private Hashtable supportedLanguages; // Untersttzte Sprachen

   public Browser(HttpServletRequest request, HttpSession session)
  {
    this.initialize();
    this.request = request;
    this.session = session;

    this.setUserAgent(this.request.getHeader("User-Agent"));
    this.setCompany();
    this.setName();
    this.setVersion();
    this.setMainVersion();
    this.setMinorVersion();
    this.setOs();
    this.setLanguage();
    this.setLocale();
  }

  public void initialize()
 {
    this.supportedLanguages = new Hashtable(2);

    this.supportedLanguages.put("en", "");
    this.supportedLanguages.put("de", "");
  }

  public void setUserAgent(String httpUserAgent)
  {
    this.userAgent = httpUserAgent.toLowerCase();
  }

  private void setCompany()
  {
    if (this.userAgent.indexOf("msie") > -1)
    {
      this.company = "Microsoft";
    }
    else if (this.userAgent.indexOf("opera") > -1)
    {
      this.company = "Opera Software";
    }
    else if (this.userAgent.indexOf("mozilla") > -1)
    {
      this.company = "Netscape Communications";
    }
    else
    {
        this.company = "unknown";
    }
  }

/**
* Liefert den Firmennamen des Herstellers des verwendeten Browsers.
*/
  public String getCompany()
 {
   return this.company;
 }

  private void setName()
 {
   if (this.company == "Microsoft")
   {
     this.name = "Microsoft Internet Explorer";
   }
   else if (this.company == "Netscape Communications")
  {
    this.name = "Netscape Navigator";
  }
   else if (this.company == "Operasoftware")
  {
     this.name = "Operasoftware Opera";
   }
   else
 {
    this.name = "unknown";
  }
}

/**
* Liefert den Namen des verwendeten Browsers.
*/
public String getName()
{
return this.name;
}

private void setVersion()
{
int tmpPos;
String tmpString;

if (this.company == "Microsoft")
{
String str = this.userAgent.substring(this.userAgent.indexOf("msie") + 5);
this.version = str.substring(0, str.indexOf(";"));
}
else
{
tmpString = (this.userAgent.substring(tmpPos = (this.userAgent.indexOf("/")) + 1, tmpPos + this.userAgent.indexOf(" "))).trim();
this.version = tmpString.substring(0, tmpString.indexOf(" "));
}
}

/**
* Liefert die Versionsnummer des verwendeten Browsers.
*/
public String getVersion()
{
return this.version;
}

private void setMainVersion()
{
this.mainVersion = this.version.substring(0, this.version.indexOf("."));
}

/**
* Liefert die Hauptversionsnummer des verwendeten Browsers.
*/
public String getMainVersion()
{
return this.mainVersion;
}

private void setMinorVersion()
{
this.minorVersion = this.version.substring(this.version.indexOf(".") + 1).trim();
}

/**
* Liefert die Unterversionsnummer des verwendeten Browsers.
*/
public String getMinorVersion()
{
return this.minorVersion;
}

private void setOs()
{
if (this.userAgent.indexOf("win") > -1)
{
if (this.userAgent.indexOf("windows 95") > -1 || this.userAgent.indexOf("win95") > -1)
{
this.os = "Windows 95";
}
if (this.userAgent.indexOf("windows 98") > -1 || this.userAgent.indexOf("win98") > -1)
{
this.os = "Windows 98";
}
if (this.userAgent.indexOf("windows nt") > -1 || this.userAgent.indexOf("winnt") > -1)
{
this.os = "Windows NT";
}
if (this.userAgent.indexOf("win16") > -1 || this.userAgent.indexOf("windows 3.") > -1)
{
this.os = "Windows 3.x";
}
}
}

/**
* Liefert den Namen des Betriebssystems.
*/
public String getOs()
{
return this.os;
}

private void setLanguage()
{
String prefLanguage = this.request.getHeader("Accept-Language");

if (prefLanguage != null)
{
String language = null;
StringTokenizer st = new StringTokenizer(prefLanguage, ",");

int elements = st.countTokens();

for (int idx = 0; idx< elements; idx++)
{
if (this.supportedLanguages.containsKey((language = st.nextToken())))
{
this.language = this.parseLocale(language);
}
}
}
}

/*
* Hilfsfunktion fr setLanguage().
*/
private String parseLocale(String language)
{
StringTokenizer st = new StringTokenizer(language, "-");

if (st.countTokens() == 2)
{
return st.nextToken();
}
else
{
return language;
}
}

/**
* Liefert das L?nderk¿ rzel der vom Benutzer
* bevorzugten Sprache.
*/
public String getLanguage()
{
return this.language;
}

private void setLocale()
{
this.locale = new Locale(this.language, "");
}

/**
* Liefert ein Locale-Objekt mit der Sprach-Prferenz des verwendeten Browsers
*/
public Locale getLocale()
{
return this.locale;
}
} 



