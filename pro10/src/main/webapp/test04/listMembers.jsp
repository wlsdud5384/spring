<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import ="java.util.*,sec02.ex01.*"
    isELIgnored="false"
    
    %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <c:set var="contextPath" value="${pageContext.request.contextPath }" />
    
    <%
    	request.setCharacterEncoding("UTF-8");
    %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 출력창</title>
	<style>
		.cls1 {
			font-size: 40px;
			text-align: center;
		}
	</style>
</head>
<body>
	<table>
		<tr align="center" bgcolor="lightgreen">
			<td width="7%">ID</td>
			<td width="7%">PWD</td>
			<td width="7%">NAME</td>
			<td width="7%">EMAIL</td>
			<td width="7%">JOINDATE</td>
		</tr>
		
		<c:choose>
		<c:when test="${membersList==null }">
			<tr>
				<td colspan=5>
					<b>등록된 회원이 없습니다.</b>
				</td>
			</tr>
		</c:when>
	<c:when test="${membersList != null }">
		<c:forEach var="mem" items="${membersList }">
			<tr align="center">
				<td>${mem.id }</td>
				<td>${mem.pwd }</td>
				<td>${mem.name }</td>
				<td>${mem.email }</td>
				<td>${mem.joinDate }</td>
			</tr>
		</c:forEach>
	</c:when>
	</c:choose>
	</table>
	<a href="${contextPath}/member151/memberForm.do">
		<p class="cls2"> 회원 가입하기</p>
	</a>
</body>
</html>