<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>4장 연습문제 6번</title>
<script type="text/javascript">
var call_func = function check_function() {
	alert("영화 추천 : " + document.movie_form.name.value + "\r\n" +
			 "평점 :  " + document.movie_form.choice.value		
	);	
};
</script>
</head>
<body>
	<form action="#" method = "get" name = "movie_form">
		<fieldset style = "width:300px">
			<legend>영화 평점</legend>
			재미있게 본 영화: <br>
			<input type = "text" name = "name"> <br><br>
			평점: <br>
			<hr> <br>
			<input type = "radio" name = "choice" value = "★★★★★"> ★★★★★ <br>
			<input type = "radio" name = "choice" value = "★★★★☆"> ★★★★☆ <br>
			<input type = "radio" name = "choice" value = "★★★☆☆"> ★★★☆☆ <br>
			<input type = "radio" name = "choice" value = "★★☆☆☆"> ★★☆☆☆ <br>
			<input type = "radio" name = "choice" value = "★☆☆☆☆"> ★☆☆☆☆ <br> <hr> <br>
			소감: <br>
			<textarea rows="5" cols="50">
			</textarea>
			<div align = "center">
				<input type = "submit" value = "제출하기" onclick = "call_func()"> &nbsp;
				<input type = "reset" value = "다시 작성">
			</div>
		</fieldset>
	</form>
</body>
</html>