<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.*, sec01.ex02.*"
    isELIgnored="false"
    %>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<%
request.setCharacterEncoding("UTF-8");
List membersList = new ArrayList();
MemberBean m1 = new MemberBean("son", "1234", "손흥민", "son@test.com");
MemberBean m2 = new MemberBean("ki", "4321", "기성용", "ki@test.com");
MemberBean m3 = new MemberBean("park", "1212", "박지성", "park@test.com");
membersList.add(m1);
membersList.add(m2);
membersList.add(m3);
%>

	<c:set var="membersList" value="<%=membersList %>" />
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<table border="1" align="center">
		<c:redirect url="/test03/member0.jsp">
			<c:param name="id" value="${'hong' }" />
			<c:param name="pwd" value="${'1234' }" />
			<c:param name="name" value="${'홍길동' }" />
			<c:param name="email" value="${'hong@test.com' }" />
			
		</c:redirect>
	
	</table>
</body>
</html>