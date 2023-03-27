<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import ="java.util.*,boad.*"
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
			<td width="7%">username</td>
			<td width="7%">univ</td>
			<td width="7%">birth</td>
			<td width="7%">email</td>
		</tr>
		
		<c:choose>
		<c:when test="${membersList == null }">
			<tr>
				<td colspan=5>
					<b>학생이 없습니다.</b>
				</td>
			</tr>
		</c:when>
	<c:when test="${membersList != null }">
		<c:forEach var="mem" items="${membersList }">
			<tr align="center">
				<td>${mem.id }</td>
				<td>${mem.username }</td>
				<td>${mem.univ }</td>
				<td>${mem.birth }</td>
				<td>${mem.email }</td>
			</tr>
		</c:forEach>
	</c:when>
	</c:choose>
	</table>
	<a href="${contextPath}/stud/memberForm.do">
		<p class="cls2"> 등록하기</p>
	</a>
</body>
</html>