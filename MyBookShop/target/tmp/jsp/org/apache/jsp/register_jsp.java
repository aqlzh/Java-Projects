/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: jetty/9.4.8.v20171121
 * Generated at: 2020-05-20 22:27:06 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class register_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("jar:file:/E:/software/apache-maven-3.6.3/repository/javax/servlet/jstl/1.2/jstl-1.2.jar!/META-INF/c.tld", Long.valueOf(1153356282000L));
    _jspx_dependants.put("file:/E:/software/apache-maven-3.6.3/repository/javax/servlet/jstl/1.2/jstl-1.2.jar", Long.valueOf(1589063380110L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
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

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
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

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
      return;
    }

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

      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("<meta charset=\"utf-8\">\n");
      out.write("<title>注册会员 - 在线购书</title>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("\t<!-- header -->\n");
      out.write("\t");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "header.jsp", out, false);
      out.write("\n");
      out.write("\n");
      out.write("\t<!-- container -->\n");
      out.write("\t<div id=\"rgbar\">\n");
      out.write("\t\t<p>用户注册／<small>Register</small></p>\n");
      out.write("\t\t<form action=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctxPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/UserServlet?opt=register\" method=\"post\" onsubmit=\"return check_Rg_Submit()\">\n");
      out.write("\t\t<ul class=\"rgul\">\n");
      out.write("\t\t\t<div class=\"alert alert-warning\" role=\"alert\" id=\"msg\">\n");
      out.write("\t\t\t  ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${MSG_USER_REGISTER_RESULT}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t\t<li>\n");
      out.write("\t\t\t\t<span>用户名</span>\n");
      out.write("\t\t\t\t<input class=\"form-control\" type=\"text\" name=\"loginId\" placeholder=\"用户名*\" onblur=\"check_Rg_LoginId(this)\"/>\n");
      out.write("\t\t\t\t<small id=\"rg_LoginId_state\"></small>\n");
      out.write("\t\t\t</li>\n");
      out.write("\t\t\t<li class=\"tips collapse\" id=\"rg_LoginId_Tips\"><span></span><code>用户名由6-12位字母、数字、下划线组成</code></li>\n");
      out.write("\t\t\t<li>\n");
      out.write("\t\t\t\t<span>用户密码</span>\n");
      out.write("\t\t\t\t<input class=\"form-control\" type=\"password\" name=\"loginPwd\"  placeholder=\"用户密码*\" onblur=\"check_Rg_LoginPwd(this)\" />\n");
      out.write("\t\t\t\t<small id=\"rg_LoginPwd_state\"></small>\n");
      out.write("\t\t\t</li>\n");
      out.write("\t\t\t<li class=\"tips collapse\" id=\"rg_LoginPwd_Tips\"><span></span><code>密码由6-20位字母、数字、下划线组成</code></li>\n");
      out.write("\t\t\t<li>\n");
      out.write("\t\t\t\t<span>确认密码</span>\n");
      out.write("\t\t\t\t<input class=\"form-control\" type=\"password\" placeholder=\"确认密码*\" onblur=\"check_Rg_LoginPwd_Success(this)\"/>\n");
      out.write("\t\t\t\t<small  id=\"rg_LoginPwd2_state\"></small>\n");
      out.write("\t\t\t</li>\n");
      out.write("\t\t\t<li class=\"tips collapse\" id=\"rg_LoginPwd2_Tips\"><span></span><code>两次密码不一致</code></li>\n");
      out.write("\t\t\t<li><hr /></li>\n");
      out.write("\t\t\t<li>\n");
      out.write("\t\t\t\t<span>真实姓名</span>\n");
      out.write("\t\t\t\t<input class=\"form-control\" type=\"text\" name=\"name\" placeholder=\"姓名\" onblur=\"check_Rg_Name(this)\" />\n");
      out.write("\t\t\t\t<small id=\"rg_Name_state\"></small>\n");
      out.write("\t\t\t</li>\n");
      out.write("\t\t\t<li class=\"tips collapse\" id=\"rg_Name_Tips\"><span></span><code>请输入合法的中文姓名</code></li>\n");
      out.write("\t\t\t<li>\n");
      out.write("\t\t\t\t<span>电子邮箱</span>\n");
      out.write("\t\t\t\t<input class=\"form-control\" type=\"text\" name=\"mail\" placeholder=\"邮箱*\" onblur=\"check_Rg_Email(this)\" />\n");
      out.write("\t\t\t\t<small id=\"rg_Email_state\"></small>\n");
      out.write("\t\t\t</li>\n");
      out.write("\t\t\t<li class=\"tips collapse\" id=\"rg_Email_Tips\"><span></span><code>邮箱格式有误</code></li>\n");
      out.write("\t\t\t<li>\n");
      out.write("\t\t\t\t<span>手机号码</span>\n");
      out.write("\t\t\t\t<input class=\"form-control\" type=\"text\" name=\"phone\" placeholder=\"手机*\" onblur=\"check_Rg_Phone(this)\" />\n");
      out.write("\t\t\t\t<small id=\"rg_Phone_state\"></small>\n");
      out.write("\t\t\t</li>\n");
      out.write("\t\t\t<li class=\"tips collapse\" id=\"rg_Phone_Tips\"><span></span><code>手机号码有误</code></li>\n");
      out.write("\t\t\t<li>\n");
      out.write("\t\t\t\t<span>联系地址</span>\n");
      out.write("\t\t\t\t<input class=\"form-control\" type=\"text\" name=\"address\" placeholder=\"联系地址*\" onblur=\"check_Rg_Address(this)\" />\n");
      out.write("\t\t\t\t<small id=\"rg_Address_state\"></small>\n");
      out.write("\t\t\t</li>\n");
      out.write("\t\t\t<li class=\"tips collapse\" id=\"rg_Address_Tips\"><span></span><code>联系地址不能为空</code></li>\n");
      out.write("\t\t\t<li><span></span><label><input type=\"checkbox\"  onchange=\"check_Rg_Article(this)\"/>同意协议《<a\n");
      out.write("\t\t\t\t\thref=\"#\">阅读协议</a>》</label></li>\n");
      out.write("\t\t\t<li><span></span><button type=\"submit\" >立即注册</button></li>\n");
      out.write("\t\t</ul>\n");
      out.write("\t\t</form>\n");
      out.write("\t\t<div class=\"note\">\n");
      out.write("\t\t\t<ul>\n");
      out.write("\t\t\t\t<li>已有账号?<a href=\"login.jsp\">立即登录</a></li>\n");
      out.write("\t\t\t\t<li>用户名由6-12位字母、数字、下划线组成</li>\n");
      out.write("\t\t\t\t<li>密码由6-20位字母、数字、下划线组成</li>\n");
      out.write("\t\t\t</ul>\n");
      out.write("\t\t</div>\n");
      out.write("\t</div>\n");
      out.write("\n");
      out.write("\t<!--footer -->\n");
      out.write("\t");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "footer.jsp", out, false);
      out.write("\n");
      out.write("\t\n");
      out.write("\t<!-- script -->\n");
      out.write("\t<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctxPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/js/userckeck.js\"></script>\n");
      out.write("<script type=\"text/javascript\">\n");
      out.write("\t$(function(){\n");
      out.write("\t\t//处理提示消息\n");
      out.write("\t\tif('");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${MSG_USER_REGISTER_RESULT}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("'==''){\n");
      out.write("\t\t\t$('#msg').addClass('collapse');\n");
      out.write("\t\t\t");
 session.removeAttribute("MSG_USER_REGISTER_RESULT"); 
      out.write("\t\n");
      out.write("\t\t}else\n");
      out.write("\t\t\t$('#msg').removeClass('collapse');\n");
      out.write("\t});\n");
      out.write("\t\n");
      out.write("</script>\n");
      out.write("</body>\n");
      out.write("</html>\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
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
