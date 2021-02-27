<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
      <br><br>
      <div class="container text-center">
          <h1>Security Prj</h1><br>
      </div>
      <div class="container col-md-4">
	      <form class="px-4 py-3" action="/login" method="post">
	          <div class="form-group">
	              <label for="exampleDropdownFormEmail1">ID</label>
	              <input type="text" class="form-control" name="loginId" placeholder="example">
	          </div>
	          <div class="form-group">
	              <label for="exampleDropdownFormPassword1">Password</label>
	              <input type="password" class="form-control" name="loginPwd" placeholder="Password">
	          </div>
	          
	          <%-- 예외발생(실패시) 예외객체 생성후 세션에 저장 key의 이름은 SPRING_SECURITY_LAST_EXCEPTION
	          세션에 에러메시지 출력은 좋지않음 추후에 변경함. 
	          키가 비어있지않으면(인증 실패) 세션을 통해 에러메시지 출력--%>
	          <c:if test="${not empty SPRING_SECURITY_LAST_EXCEPTION}">
					<font color="red">
				  		<p>Your login attempt was not successful due to <br/>
				  		${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}</p>
						<c:remove var="SPRING_SECURITY_LAST_EXCEPTION" scope="session"/>
					</font>
				</c:if>
	          
	          <div class="form-check">
	              <label class="form-check-label">
	              <input type="checkbox" class="form-check-input">
	              Remember me
	              </label>
	          </div>
	          <input name="${_csrf.parameterName}" type="hidden" value="${_csrf.token}"/>
	          <button type="submit" class="btn btn-primary">Sign in</button>
	      </form>
	      <div class="dropdown-divider"></div>
	      <a class="dropdown-item" href="#">New around here? Sign up</a>
	      <a class="dropdown-item" href="#">Forgot password?</a>
	  </div>

</body>
</html>