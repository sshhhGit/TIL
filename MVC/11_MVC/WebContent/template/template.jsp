<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/module/header.jsp" %>

<html>
  <body>
    <table border="1" height="90%" width="90%" bgcolor="ivory">
      <tr height="40">
        <td align="left"><%--top --%>
        <a href="${ctxpath }/member/main.do">
          <img alt="" src="../imgs/logo.jpg" width="100"></a>
        </td>
        <td align="right">
          <jsp:include page="/module/top.jsp" flush="false"></jsp:include>
        </td>
      </tr>
      
      <tr>
	    <td width="5%" valign="top" align="right"><%--left --%>
	      <jsp:include page="/module/left.jsp"></jsp:include>
	    </td>
	    <td width="90%" valign="top" height="90%"><%--content --%>
	      <jsp:include page="${view }" flush="false"></jsp:include>
	    </td>
      </tr>
      <tr>
        <td colspan="2" align="center"><%-- bottom.jsp --%>
          <jsp:include page="/module/bottom.jsp"></jsp:include>
        </td>
      </tr>
    </table>
  </body>
</html>