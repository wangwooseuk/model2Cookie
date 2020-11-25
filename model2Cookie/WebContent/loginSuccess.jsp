<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="vo.Member"%>
<%
	Member loginMember = (Member)request.getAttribute("loginMember");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>로그인에 성공한 사용자 정보</h1>
	이름 : <%=loginMember.getName() %><br>
	주소 : <%=loginMember.getAddr() %><br>
	이메일 : <%=loginMember.getEmail() %><br>
	나이 : <%=loginMember.getAge() %><br>
</body>
</html>