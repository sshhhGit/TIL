<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--test02_map.jsp --%>
<%--
Map, HashMap == DTO 같은 방법으로 사용한다
key, value		변수 = 값

 --%>

 <h2>Map사용 이전 방식</h2>
 <%
 Map<String, Object> map = new HashMap<String, Object>();
 map.put("name", "박문수");
 map.put("tel", "010-5757-7878");
 map.put("addr", "서울 구로구");
 %>
 <%-- 출력 --%>
 이름 : <%=map.get("name") %><br>
 전화 : <%=map.get("tel") %><br>
 주소 : <%=map.get("addr") %><br>
 
 <h2>Map EL, JSTL에서 사용하는 방식</h2>
 
 <c:set var="map2" value="<%=new HashMap() %>"></c:set>
 
 <c:set target="${map2 }" property="name" value="임영웅"></c:set>
 <c:set target="${map2 }" property="tel" value="010-3333-4444"></c:set>
 <c:set target="${map2 }" property="addr" value="서울 합정역 7번 출구"></c:set>
 
 <%-- 출력 --%>
 
 이름 : ${map2.name}<br>
 전화 : ${map2.tel}<br>
 주소 : ${map2.addr}