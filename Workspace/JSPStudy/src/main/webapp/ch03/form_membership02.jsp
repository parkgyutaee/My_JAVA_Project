<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>입력한 정보 받아오기</title>
</head>
<body>
	Home > Personal Information Inquiry
	<hr>
	<%
		request.setCharacterEncoding("UTF-8");
	
		String id = request.getParameter("id");
		String pw = request.getParameter("password");
		String name = request.getParameter("name");
		
		String choice = request.getParameter("choice");
		String ph1 = request.getParameter("p1");
		String ph2 = request.getParameter("p2");
		String ph3 = request.getParameter("p3");
		
		String sex = request.getParameter("gender");
		String [] hob = request.getParameterValues("hobby");
		String intro = request.getParameter("introduce_area");
	%>
	 <p>아이디 : <%=id  %>
	 <p>비밀번호 : <%=pw  %>
	 <p>이름 : <%= name %>
	 <p>연락처 : <%= choice %> <%= ph1 %> <%= ph2%><%= ph3 %>
	 <p>성별 : <%= sex %>
	 <p>취미 : <%
	 					if (hob != null)
	 					{for (int count = 0; count <hob.length; count ++) {
	 						out.println(" " + hob [count]);
	 							}
	 					}
	 				 %>
	 <p> 본인소개 : <%=intro %>
	
</body>
</html>