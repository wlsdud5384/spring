<%@ page language="java" contentType="text/html; charset=UTF-8"
    	pageEncoding="UTF-8"%> 
    	
     <jsp:useBean id="test_" class="ch07.Test_example"/> 
     <jsp:setProperty name="test_" property="*"/> 
	 <!DOCTYPE html> 
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>3항 결과</h2>
	<hr>
	결과 : <%=test_.clac() %>
</body>
</html>