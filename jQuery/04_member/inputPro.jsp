<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="member.*"
    %>
<%--inputPro.jsp --%>
 <%
 request.setCharacterEncoding("UTF-8");
  
 String id=request.getParameter("id");
 %>
 
 <jsp:useBean id="dto" class="member.MemberDTO">
   <jsp:setProperty name="dto" property="*"/>
 </jsp:useBean>
 
 <%
   MemberDAO dao=new MemberDAO();//객체생성
   int x=dao.confirmID(id);//id 중복 체크
   //x=1//사용중인 id
   //x=-1//사용가능한 id
   
   if(x==1){
	   %>
	   <script>
	     alert("사용중인 id 입니다");
	     history.back();
	   </script>
	   <%
   }else if(x==-1){//사용 가는한 id
	   dao.insertMember(dto);//회원 가입
	   out.println("회원 가입 완료");
   }
 %>