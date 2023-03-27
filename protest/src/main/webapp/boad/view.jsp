<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"
    %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <c:set var="contextPath" value="${pageContext.request.contextPath }" />
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 등록창</title>
</head>
<body>
							<!--    1차매핑  		2차매핑 -->
	<form action="${contextPath }/stud/addMember.do" method="post" >
		<h1 style="text-align:center">학생 추가</h1>
		<table align="center">
			<tr>
				<td width="200"><p align="right">이름</p></td>
				<td width="400"><input type="text" name="id"></td>
			</tr>
			<tr>
				<td width="200"><p align="right">대학</p></td>
				<td width="400"><input type="text" name="pwd"></td>
			</tr>
			<tr>
				<td width="200"><p align="right">생일</p></td>
				<td width="400"><input type="text" name="name"></td>
			</tr>
			<tr>
				<td width="200"><p align="right">이메일</p></td>
				<td width="400"><input type="text" name="email"></td>
			</tr>
			<tr>
				<td width="200"><p>&nbsp;</p></td>
				<td width="400">
			<input type="submit" value="등록">
			<input type="reset" value="다시입력">
			</td>
			</tr>
		</table>
	</form>
	
</body>
</html>