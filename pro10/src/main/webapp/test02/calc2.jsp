 <%@ page language="java" contentType="text/html; charset=UTF-8"  
  	pageEncoding="UTF-8" isELIgnored="false"
    import="java.util.*,sec02.ex01.*" 
   	 %> 
   	 
   	 <% 
    	request.setCharacterEncoding("UTF-8");
     %> 
   	
   	 <jsp:useBean id="val" class="sec02.ex01.CalcBean"/>
   	 <jsp:setProperty name="val" property="n1" />
   	 <jsp:setProperty name="val" property="nn" />
   	 <jsp:setProperty name="val" property="n2" />
   	 <jsp:setProperty name="val" property="result" />
   	 
    	 <% 
    	
     	CalcDAO2 calcDAO2 = new CalcDAO2();
     	calcDAO2.addMember(val);
     	List membersList = calcDAO2.listMembers();
    
     %> 
   	 
 <!DOCTYPE html> 
 <html> 
 <head> 
 <meta charset="UTF-8">
 <title>계산기22</title> 
 </head> 

 <body> 
	
	<table align="center" width="100%">
		<tr align="center" bgcolor="#99ccff">
			<td width="7%">숫자</td>
			<td width="7%">${nn }</td>
			<td width="5%">숫자</td>
			<td width="11%">결과</td>
			</tr>
		<%
			if(membersList.size()==0) {
		%>
			<tr>
				<td colspan="5">
					<p align="center"><b><span style="font-size:9pt;">
						등록된 회원이 없습니다.</span></b></p>
				</td>
			</tr>
		<%
			} else{
				for(int i=0; i<membersList.size(); i++) {
					CalcBean bean = (CalcBean) membersList.get(i);	
		%>
		<tr align="center">
			<td><%= bean.getN1() %></td> 
			<td><%= bean.getNn() %></td>
			<td><%= bean.getN2() %></td>
			<td><%= bean.getResult() %></td>
		</tr>
		<%
				}	//end for
			}	//end if
		%>
			<tr height="1" bgcolor="#99ccff">
				<td colspan="5"></td>
			</tr>
	</table>	
 
	
 </body> 
  </html> 