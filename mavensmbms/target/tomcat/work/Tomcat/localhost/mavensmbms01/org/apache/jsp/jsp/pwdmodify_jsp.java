/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2020-08-27 07:56:34 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class pwdmodify_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/jsp/common/foot.jsp", Long.valueOf(1597568094118L));
    _jspx_dependants.put("/jsp/common/head.jsp", Long.valueOf(1461211469089L));
  }

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


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

      out.write('\r');
      out.write('\n');
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head lang=\"en\">\r\n");
      out.write("    <meta charset=\"UTF-8\">\r\n");
      out.write("    <title>超市订单管理系统</title>\r\n");
      out.write("    <link type=\"text/css\" rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/css/style.css\" />\r\n");
      out.write("    <link type=\"text/css\" rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/css/public.css\" />\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<!--头部-->\r\n");
      out.write("    <header class=\"publicHeader\">\r\n");
      out.write("        <h1>超市订单管理系统</h1>\r\n");
      out.write("        <div class=\"publicHeaderR\">\r\n");
      out.write("            <p><span>下午好！</span><span style=\"color: #fff21b\"> ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${userSession.userName }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</span> , 欢迎你！</p>\r\n");
      out.write("            <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/jsp/logout.do\">退出</a>\r\n");
      out.write("        </div>\r\n");
      out.write("    </header>\r\n");
      out.write("<!--时间-->\r\n");
      out.write("    <section class=\"publicTime\">\r\n");
      out.write("        <span id=\"time\">2015年1月1日 11:11  星期一</span>\r\n");
      out.write("        <a href=\"#\">温馨提示：为了能正常浏览，请使用高版本浏览器！（IE10+）</a>\r\n");
      out.write("    </section>\r\n");
      out.write(" <!--主体内容-->\r\n");
      out.write(" <section class=\"publicMian \">\r\n");
      out.write("     <div class=\"left\">\r\n");
      out.write("         <h2 class=\"leftH2\"><span class=\"span1\"></span>功能列表 <span></span></h2>\r\n");
      out.write("         <nav>\r\n");
      out.write("             <ul class=\"list\">\r\n");
      out.write("                 <li ><a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/jsp/bill.do?method=query\">订单管理</a></li>\r\n");
      out.write("              <li><a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/jsp/provider.do?method=query\">供应商管理</a></li>\r\n");
      out.write("              <li><a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/jsp/user.do?method=query\">用户管理</a></li>\r\n");
      out.write("              <li><a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/jsp/pwdmodify.jsp\">密码修改</a></li>\r\n");
      out.write("              <li><a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/jsp/logout.do\">退出系统</a></li>\r\n");
      out.write("             </ul>\r\n");
      out.write("         </nav>\r\n");
      out.write("     </div>\r\n");
      out.write("     <input type=\"hidden\" id=\"path\" name=\"path\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"/>\r\n");
      out.write("     <input type=\"hidden\" id=\"referer\" name=\"referer\" value=\"");
      out.print(request.getHeader("Referer"));
      out.write('"');
      out.write('/');
      out.write('>');
      out.write("\r\n");
      out.write("<div class=\"right\">\r\n");
      out.write("            <div class=\"location\">\r\n");
      out.write("                <strong>你现在所在的位置是:</strong>\r\n");
      out.write("                <span>密码修改页面</span>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"providerAdd\">\r\n");
      out.write("                <form id=\"userForm\" name=\"userForm\" method=\"post\" action=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/jsp/user.do\">\r\n");
      out.write("                    <input type=\"hidden\" name=\"method\" value=\"savepwd\">\r\n");
      out.write("                    <!--div的class 为error是验证错误，ok是验证成功-->\r\n");
      out.write("                    <div class=\"info\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${message}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</div>\r\n");
      out.write("                    <div class=\"\">\r\n");
      out.write("                        <label for=\"oldPassword\">旧密码：</label>\r\n");
      out.write("                        <input type=\"password\" name=\"oldpassword\" id=\"oldpassword\" value=\"\"> \r\n");
      out.write("\t\t\t\t\t\t<font color=\"red\"></font>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div>\r\n");
      out.write("                        <label for=\"newPassword\">新密码：</label>\r\n");
      out.write("                        <input type=\"password\" name=\"newpassword\" id=\"newpassword\" value=\"\"> \r\n");
      out.write("\t\t\t\t\t\t<font color=\"red\"></font>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div>\r\n");
      out.write("                        <label for=\"reNewPassword\">确认新密码：</label>\r\n");
      out.write("                        <input type=\"password\" name=\"rnewpassword\" id=\"rnewpassword\" value=\"\"> \r\n");
      out.write("\t\t\t\t\t\t<font color=\"red\"></font>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"providerAddBtn\">\r\n");
      out.write("                        <!--<a href=\"#\">保存</a>-->\r\n");
      out.write("                        <input type=\"button\" name=\"save\" id=\"save\" value=\"保存\" class=\"input-button\">\r\n");
      out.write("                    </div>\r\n");
      out.write("                </form>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </section>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<footer class=\"footer\">\r\n");
      out.write("    版权归啥都有无名小超市\r\n");
      out.write("</footer>\r\n");
      out.write("<script type=\"text/javascript\" charset=\"UTF-8\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/time.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/jquery-1.8.3.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/common.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/calendar/WdatePicker.js\"></script>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/pwdmodify.js\"></script>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}