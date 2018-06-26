import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.Vector;
import org.apache.jasper.runtime.*;
import java.beans.*;
import org.apache.jasper.JasperException;


public class _0002fJsp_00031_0002ejspJsp1_jsp_0 extends HttpJspBase {

    // begin [file="D:\\Kevin\\MCIPDOC\\MCIPTEST\\MCIPTEST\\defaultroot\\Jsp1.jsp";from=(7,0);to=(7,73)]
    // end

    static {
    }
    public _0002fJsp_00031_0002ejspJsp1_jsp_0( ) {
    }

    private static boolean _jspx_inited = false;

    public final void _jspx_init() throws JasperException {
    }

    public void _jspService(HttpServletRequest request, HttpServletResponse  response)
        throws IOException, ServletException {

        JspFactory _jspxFactory = null;
        PageContext pageContext = null;
        HttpSession session = null;
        ServletContext application = null;
        ServletConfig config = null;
        JspWriter out = null;
        Object page = this;
        String  _value = null;
        try {

            if (_jspx_inited == false) {
                _jspx_init();
                _jspx_inited = true;
            }
            _jspxFactory = JspFactory.getDefaultFactory();
            response.setContentType("text/html; charset=GBK");
            pageContext = _jspxFactory.getPageContext(this, request, response,
			"", true, 8192, true);

            application = pageContext.getServletContext();
            config = pageContext.getServletConfig();
            session = pageContext.getSession();
            out = pageContext.getOut();

            // HTML // begin [file="D:\\Kevin\\MCIPDOC\\MCIPTEST\\MCIPTEST\\defaultroot\\Jsp1.jsp";from=(0,48);to=(7,0)]
                out.write("\r\n<html>\r\n<head>\r\n<title>\r\nJsp1\r\n</title>\r\n</head>\r\n");
            // end
            // begin [file="D:\\Kevin\\MCIPDOC\\MCIPTEST\\MCIPTEST\\defaultroot\\Jsp1.jsp";from=(7,0);to=(7,73)]
                mciptest.Jsp1Bean Jsp1BeanId = null;
                boolean _jspx_specialJsp1BeanId  = false;
                 synchronized (session) {
                    Jsp1BeanId= (mciptest.Jsp1Bean)
                    pageContext.getAttribute("Jsp1BeanId",PageContext.SESSION_SCOPE);
                    if ( Jsp1BeanId == null ) {
                        _jspx_specialJsp1BeanId = true;
                        try {
                            Jsp1BeanId = (mciptest.Jsp1Bean) Beans.instantiate(this.getClass().getClassLoader(), "mciptest.Jsp1Bean");
                        } catch (Exception exc) {
                             throw new ServletException (" Cannot create bean of class "+"mciptest.Jsp1Bean");
                        }
                        pageContext.setAttribute("Jsp1BeanId", Jsp1BeanId, PageContext.SESSION_SCOPE);
                    }
                 } 
                if(_jspx_specialJsp1BeanId == true) {
            // end
            // begin [file="D:\\Kevin\\MCIPDOC\\MCIPTEST\\MCIPTEST\\defaultroot\\Jsp1.jsp";from=(7,0);to=(7,73)]
                }
            // end
            // HTML // begin [file="D:\\Kevin\\MCIPDOC\\MCIPTEST\\MCIPTEST\\defaultroot\\Jsp1.jsp";from=(7,73);to=(8,0)]
                out.write("\r\n");
            // end
            // begin [file="D:\\Kevin\\MCIPDOC\\MCIPTEST\\MCIPTEST\\defaultroot\\Jsp1.jsp";from=(8,0);to=(8,50)]
                JspRuntimeLibrary.introspect(pageContext.findAttribute("Jsp1BeanId"), request);
            // end
            // HTML // begin [file="D:\\Kevin\\MCIPDOC\\MCIPTEST\\MCIPTEST\\defaultroot\\Jsp1.jsp";from=(8,50);to=(19,27)]
                out.write("\r\n<body>\r\n<h1>\r\nJBuilder Generated JSP\r\n</h1>\r\n<form method=\"post\">\r\n<br>Enter new value   :  <input name=\"sample\"><br>\r\n<br><br>\r\n<input type=\"submit\" name=\"Submit\" value=\"Submit\">\r\n<input type=\"reset\" value=\"Reset\">\r\n<br>\r\nValue of Bean property is :");
            // end
            // begin [file="D:\\Kevin\\MCIPDOC\\MCIPTEST\\MCIPTEST\\defaultroot\\Jsp1.jsp";from=(19,27);to=(19,82)]
                out.print(JspRuntimeLibrary.toString((((mciptest.Jsp1Bean)pageContext.findAttribute("Jsp1BeanId")).getSample())));
            // end
            // HTML // begin [file="D:\\Kevin\\MCIPDOC\\MCIPTEST\\MCIPTEST\\defaultroot\\Jsp1.jsp";from=(19,82);to=(23,0)]
                out.write("\r\n</form>\r\n</body>\r\n</html>\r\n");
            // end

        } catch (Exception ex) {
            if (out.getBufferSize() != 0)
                out.clearBuffer();
            pageContext.handlePageException(ex);
        } finally {
            out.flush();
            _jspxFactory.releasePageContext(pageContext);
        }
    }
}
