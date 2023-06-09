<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"
    %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%
    	request.setCharacterEncoding("UTF-8");
    %>
    <c:set var="contextPath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글보기</title>
	<style>
		#tr_btn_modify{
			display: none;
		}
	</style>
	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
	<script type="text/javascript">
		function backToList(obj) {
			obj.action="$(contextPath)/board/listArticles.do";
			obj.submit();
		}
		
			function fn_enable(obj) {
				document.getElementByld("i_title").disabled=false;
				document.getElementByld("i_content").disabled=false;
				document.getElementByld("i_imageFileName").disabled=false;
				document.getElementByld("i_btn_modify").style.display="block";
				document.getElementByld("i_btn").style.display="none";
			}
			
			function fn_modify_article(obj) {
				obj.action="$(contextPath)/board/modArticle.do";
				obj.submit();
			}
			
			function fn_remove_article(url.articleNO) {
				var form = document.createElement("form");
				form.setAttribute("method", "post");
				form.setAttribute("action", "url");
				var articleNOInput = document.createElement("input");
				articleNOInput.setAttribute("type", "hidden");
				articleNOInput.setAttribute("name", "articleNO");
				articleNOInput.setAttribute("value", "articleNO");
				
				form.appendChild(articleNOInput);
				document.body.appendChild(form);
				form.submit();
			}
			
			function readURL(input) {
				if(input.files && input.files[0]) {
					var reader = new FileReader();
					reader.onload = function (e) {
						$('#preview').attr('src', e.target.result);
					}
					reader.readAsDataURL(input.file[0]);
				}
			}
	</script>
</head>
<body>
	<form name="frmArticle" method="post" action="${contextPath }" enctype="multipart/form-date">
	<table border="0" align="center">
	<tr>
		<td width="150" align="center" bgcolor="#FF9933">
		글번호
		</td>
		<td>
		<input type="text" value="${article.articleNO }" disabled />
		<input type="hidden" name="articleNO" value="${article.articleNO }" />
		</td>
		</tr>
		<tr>
		<td width="150" align="center" bgcolor="#FF9933">
			작성자 아이디
		</td>
		<td>
		<input type="text" value="${article.id}" name="writer" disabled />
		</td>
		</tr>
		<tr>
		<td width="150" align="center" bgcolor="#FF9933">
		제목
		</td>
		<td>
		<input type="text" value="${article.title}" name="title" id="i_title" disabled />
		</td>
		</tr>
		<tr>
		<td width="150" align="center" bgcolor="#FF9933">
		내용
		</td>
		<td>
		<textarea rows="20" cols="60" name="content" id="i_content" disabled /> ${article.content }</textarea>
		</td>
		</tr>
		
	
	</table>
	</form>

</body>
</html>