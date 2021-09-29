<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/jsp-header.jsp" %>    
<!-- login.jsp -->
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
  <div align="center" class="body">
    <h2>로그인 화면</h2>
    
    <!-- user모델빈이름, 컨트롤러의 toLoginForm()메서드에 대응된다 -->
    <form:form modelAttribute="user" method="post" action="login.html">
      
      <!-- 전체 에러 메시지 출력 -->
      <spring:hasBindErrors name="user">
        <font color="red">
          <c:forEach var="error" items="${errors.globalErrors}">
            <spring:message code="${error.code}"/>
          </c:forEach>
        </font>
      </spring:hasBindErrors>
    
    
     <tr height="40px">
       <td>USRE-ID</td>
       <td>
         <!-- path="user_id"는 user모델 변수이다 -->
         <form:input path="user_id" cssClass="user_id"/>
         
         <!-- 에러메시지 출력 -->
         <font color="red">
           <form:errors path="user_id"/>
         </font>
       </td>
     </tr>
     
     <tr height="40px">
       <td>PASSWORD</td>
       <td>
         <!-- path="password"는 user모델 변수이다 -->
         <form:input path="password" cssClass="password"/>
         
         <!-- 에러메시지 출력 -->
         <font color="red">
           <form:errors path="password"/>
         </font>
       </td>
     </tr>
     
     <tr>
       <td colspan="2" align="center">
         <input type="submit" value="로그인">
         <input type="reset">
       </td>
     </tr>
   
   </form:form>
  </div>
</body>
</html>