<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Query String 사용하기</title>
</head>
<body>
 	코드 1 : <%= request.getParameter("id")  %> <br>
 	<br>
 	<br>
 	코드 2 : ${param.id } <br>
</body>
</html>