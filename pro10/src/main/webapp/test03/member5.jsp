<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"
    %>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%
    	request.setCharacterEncoding("UTF-8");
    %>
    
	<c:choose>
<%--     <c:when test="${name==null}"> --%>
    <c:when test='${empty name}'/>
    	<tr align="center">
    		<td colspan=5>이름을 입력하세요!!</td>
    	</tr>
    <c:otherwise>
    	<tr align="center">
    		<td>${id }</td>
    		<td>${pwd }</td>
    		<td>${name }</td>
    		<td>${age}</td>
    		<td>${height }</td>
    		</tr>
    		</c:otherwise>
    	
    	<c:set var="id" value="hong" scope="page" />
    	<c:set var="pwd" value="1234" scope="page" />
<%--     	<c:set var="name" value="${'홍길동 }" scope="page" /> --%>
    	<c:set var="age" value="${22 }" scope="page" />
    	<c:set var="height" value="${177 }" scope="page" />
    	</c:choose>
    	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>



</body>
</html>