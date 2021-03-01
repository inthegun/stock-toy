<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>Register</h1>
<form action="/member/register" method="post">
	<div> id <input type="text" name="ID" id="ID" /> </div> 
	<div> pw <input type="password" name="PASSWORD" id="PASSWORD" /> </div> 
	<div> name <input type="text" name="NAME" id="NAME"/> </div> 
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" /> 
	<div> <input type="submit" value="회원가입"/> </div> 
</form>

</body>
</html>