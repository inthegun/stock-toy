<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>

<h3 align="center"> 메인 페이지 테스트 </h3>

<hr>
<h2 align="center">스프링 시큐리티 로그인 </h2>
<p align='center'>
<a href='<c:url value="/page"/>' role="button" >GUEST</a> 
<a href='<c:url value="/userpage"/>' role="button" >USER</a> 
<a href='<c:url value="/adminpage"/>' role="button" >ADMIN</a> 

</p>
<c:if test="">
<p align="center"><a href="/register.do">회원가입</a></p>
<p align="center"><a href="/login.do">로그인</a><p>
</c:if>
<br>
<hr>
</body>
</html>
