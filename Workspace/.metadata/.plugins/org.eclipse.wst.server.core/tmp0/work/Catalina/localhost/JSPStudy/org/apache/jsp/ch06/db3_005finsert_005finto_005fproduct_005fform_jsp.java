/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/10.1.43
 * Generated at: 2025-07-14 06:47:16 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.ch06;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.jsp.*;
import java.sql.*;

public final class db3_005finsert_005finto_005fproduct_005fform_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports,
                 org.apache.jasper.runtime.JspSourceDirectives {


	Connection connection = null;
	PreparedStatement preparedStatement = null;

	final String URL = "jdbc:oracle:thin:@192.168.0.2:1521:XE";
	final String ID = "c##park";
	final String PASSWORD = "park";

	final String INSERT_SQL = 
		    "INSERT INTO PRODUCT(productId, productName, manufacturer, expirationDate, isAdultOnly, price, quantity) " +
		    "VALUES (?, ?, ?, TO_DATE(?, 'YYYY-MM-DD'), ?, ?, ?)";


  private static final jakarta.servlet.jsp.JspFactory _jspxFactory =
          jakarta.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.LinkedHashSet<>(6);
    _jspx_imports_packages.add("java.sql");
    _jspx_imports_packages.add("jakarta.servlet");
    _jspx_imports_packages.add("jakarta.servlet.http");
    _jspx_imports_packages.add("jakarta.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile jakarta.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public boolean getErrorOnELNotFound() {
    return false;
  }

  public jakarta.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final jakarta.servlet.http.HttpServletRequest request, final jakarta.servlet.http.HttpServletResponse response)
      throws java.io.IOException, jakarta.servlet.ServletException {

    if (!jakarta.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
        return;
      }
    }

    final jakarta.servlet.jsp.PageContext pageContext;
    jakarta.servlet.http.HttpSession session = null;
    final jakarta.servlet.ServletContext application;
    final jakarta.servlet.ServletConfig config;
    jakarta.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    jakarta.servlet.jsp.JspWriter _jspx_out = null;
    jakarta.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>PRODUCT 테이블 데이터 입력</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");

	request.setCharacterEncoding("UTF-8");

	// 폼에서 넘어온 값 받기
	final int PRODUCT_ID = Integer.parseInt(request.getParameter("product_id"));
	final String PRODUCT_NAME = request.getParameter("product_name");
	final String MANUFACTURER = request.getParameter("manufacturer");
	final String EXPIRATION_DATE = request.getParameter("expiration_date"); 
	final String IS_ADULT_ONLY = request.getParameter("is_adult_only");     // 'Y' or 'N'
	final int PRICE = Integer.parseInt(request.getParameter("price"));
	final int QUANTITY = Integer.parseInt(request.getParameter("quantity"));

	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		connection = DriverManager.getConnection(URL, ID, PASSWORD);

		preparedStatement = connection.prepareStatement(INSERT_SQL);
		preparedStatement.setInt(1, PRODUCT_ID);
		preparedStatement.setString(2, PRODUCT_NAME);
		preparedStatement.setString(3, MANUFACTURER);
		preparedStatement.setString(4, EXPIRATION_DATE);
		preparedStatement.setString(5, IS_ADULT_ONLY);
		preparedStatement.setInt(6, PRICE);
		preparedStatement.setInt(7, QUANTITY);

		preparedStatement.executeUpdate();

      out.write("\r\n");
      out.write("	<h2> PRODUCT 테이블에 데이터 입력 성공</h2>\r\n");
      out.write("	<a href=\"db1_select_product.jsp\"> product 테이블 보기</a>\r\n");

	} catch (Exception e) {
		out.println("<p style='color:red;'> DB 오류: " + e.getMessage() + "</p>");
		e.printStackTrace();
	} finally {
		try {
			if (preparedStatement != null) preparedStatement.close();
			if (connection != null) connection.close();
		} catch (Exception e) {
			out.println("<p> DB 연결 해제 중 오류 발생</p>");
		}
	}

      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof jakarta.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
