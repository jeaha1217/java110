<%@page import="bitcamp.java110.cms.domain.Teacher"%>
<%@page import="bitcamp.java110.cms.domain.Student"%>
<%@page import="java.util.List"%>
<%@page import="bitcamp.java110.cms.dao.StudentDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset='UTF-8'>
<title>-Teacher Management -</title>
<link rel='stylesheet' href='../css/common.css'>
<style>
table, th, td {
	border: 1px solid gray;
}
</style>
</head>
<body>
	<jsp:include page="../header.jsp" />
	<h1>강사 목록 (MVC)</h1>
	<p>
		<a href='add'>추가</a>
	</p>
	<table>
		<thead>
			<tr>
				<th>NO.</th>
				<th>Name</th>
				<th>Email</th>
				<th>Pay</th>
				<th>Subject</th>
			</tr>
		</thead>
		<tbody>
<%
List<Teacher> list = (List<Teacher>) request.getAttribute("list");
for (Teacher t : list ){
%>
			<tr>
				<td><%=t.getNo() %></td>
				<td><a href='detail?no=<%=t.getNo()%>'><%=t.getName()%></a></td>
				<td><%=t.getEmail()%></td>
				<td><%=t.getPay()%></td>
				<td><%=t.getSubjects() %></td>
			</tr>
<%}%>
		</tbody>
	</table>
	<jsp:include page="../footer.jsp" />
</body>
</html>
