<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 폼</title>

</head>
<body>
	<form action="el_5_login_menu.jsp" method = "get">
		<label for = "user_id">아이디</label>
		<input type = "text" name = "id" id = "user_id"/> <br><br>
		
		<label for = "user_pw">비밀번호</label>
		<input type = "password" name = "pw" id = "user_pw"/> <br><br>
		
		<input type = "submit" value = "로그인"> &nbsp;
		<input type = "reset" value = "다시작성">
	</form>
	
</body>
</html>