<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="mysqlboard.*"%>
    
<%-- writePro.jsp --%>

<%
request.setCharacterEncoding("UTF-8");
%>
<jsp:useBean id="dto" class="mysqlboard.BoardDTO">
  <jsp:setProperty name="dto" property="*"/>
</jsp:useBean>

<%
dto.setIp(request.getRemoteAddr()); //ip구해서 setter 작업

BoardDAO dao = BoardDAO.getInstance();
dao.insertBoard(dto);

response.sendRedirect("list.jsp");
%>
