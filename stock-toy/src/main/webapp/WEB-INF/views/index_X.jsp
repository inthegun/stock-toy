<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%-- 스프링 시큐리티 자체적으로 제공하는 방법시 import 해야하는것 --%>
<%@ page import="org.springframework.security.core.context.SecurityContextHolder" %>
<%@ page import="org.springframework.security.core.Authentication" %>

<%
 Authentication auth = SecurityContextHolder.getContext().getAuthentication();
Object principal = auth.getPrincipal(); // 인증하지 않을경우 anonymousUser란 문자열이 담긴 String 객체 리턴함
 										// 인증했을경우 로그인한 사용자의 정보가 담긴 Object 객체 리턴

String name= "";
if(principal != null){ // 사용자 정보가 담긴 principal 이 null인지 아닌지 판단후 필요한 정보를 가져옴.
	name = auth.getName(); // 이름이 필요하기 때문에 name만 가져옴
}
%>

<%-- spring security 기능 jsp 페이지 에서 사용해야 될때 사용하는 tag --%>
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
<a href='<c:url value="/userpage"/>' role="button" >USER</a> 
<a href='<c:url value="/adminpage"/>' role="button" >ADMIN</a> 

<sec:authorize access="isAnonymous()"> <%-- 인증하지않은 이용자에게만 보이는 권한 --%>
	<h5><a href='<c:url value="/login"/>'>LOGIN</a> 로그인 해주세요.</h5> <%-- 새로운 로그인 화면 주소 --%>
</sec:authorize>

<sec:authorize access="isAuthenticated()"> <%-- 인증된 사용자일때 로그아웃을 보여줌 --%>
	<h5><%=name %>님, 환영합니다. </h5> <%-- name 변수를 로그인했을때만 띄어줌  --%>
	<p><sec:authentication property="principal.username"/>님 , 환영합니다 </p><%-- security 태그를 이용한 방법 --%>
	<form action="/logout" method="POST"> <%-- security-context에서 설정한 logout-url을 from 태그의 action 속성에 설정  --%> 
		<input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }"/>
		<button type="submit">LOGOUT</button>
	</form>
	<%-- 
	a 태그를 사용해야 할경우 , a 태그 클릭시 form 태그의 submit을 해주는 방법
	<a href="#" onclick="document.getElementById('logout-form').submit();">Sign out</a>
	<form id="logout-form" action='<c:url value='/accounts/logout'/>' method="POST">
  	 <input name="${_csrf.parameterName}" type="hidden" value="${_csrf.token}"/>
	</form>
출처: https://to-dy.tistory.com/82?category=720806 [todyDev]
	 --%>
</sec:authorize>

</p>
<c:if test="">
<p align="center"><a href="/register.do">회원가입</a></p>
<p align="center"><a href="/login.do">로그인</a><p>
</c:if>
<br>
<hr>
</body>
</html>
