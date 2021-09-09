<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- test_oper.jsp --%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>연산자</h2>
<h3>\${7+3 }=${7+3 }</h3>
<h3>\${7-3 }=${7-3 }</h3>
<h3>\${7*3 }=${7*3 }</h3>

<h3>\${7/3 }=${7/3 }</h3>    		<%-- 나누기, 몫이 아니다 --%>
<h3>\${7 div 3 }=${7 div 3 }</h3>   <%-- 나누기, 몫이 아니다 --%>

<h3>\${7%3 }=${7%3 }</h3>			<%-- 나머지 --%>
<h3>\${7 mod 3 }=${7 mod 3 }</h3>   <%-- 나머지 --%>
<br>

<h3>\${7 eq 3 }=${7 eq 3 }</h3>
<h3>\${7 eq 3 and 7 eq 7}=${7 eq 3 and 7 eq 7}</h3>
<h3>\${7 eq 3 or 7 eq 7}=${7 eq 3 or 7 eq 7}</h3>

<br>
<h2>관계연산자</h2>
<h3>\${7==3 }=${7==3 }</h3>
<h3>\${7!=3 }=${7!=3 }</h3>
<h3>\${7<3 }=${7<3 }</h3>
<h3>\${7>3 }=${7>3 }</h3>
<h3>\${7>=3 }=${7>=3 }</h3>
<h3>\${7<=3 }=${7<=3 }</h3>

<br>

<h2>조건연산자</h2>
  <h3>${(5+3)==8?8:10 }</h3>
  <h3>${(5+3)!=8?8:10 }</h3>
</body>
</html>