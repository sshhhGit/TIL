<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>layout.jsp</title>
<style type="text/css">
body {
	margin: 0px;
}
table {
	border-spacing: 0px;
}
</style>
</head>
<body>
  <table border="0" height="100%" width="100%">
    <tr>
      <td>
        <tiles:insertAttribute name="top"/>
      </td>
    </tr>
    <tr align="center">
      <td>
        <tiles:insertAttribute name="content"/>
      </td>
    </tr>
    <tr>
      <td>
        <tiles:insertAttribute name="footer"/>
      </td>
    </tr>
  </table>
</body>
</html>