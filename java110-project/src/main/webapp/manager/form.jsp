<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>매니저 관리</title>
<link rel='stylesheet' href='../css/common.css'>
<style>
th {
	text-align: right;
}
</style>
</head>
<body>

<jsp:include page="../header.jsp"></jsp:include>

	<h1>매니저 등록(MVC)</h1>

	<form action='add' method='post' enctype='multipart/form-data'>
<!--       url encoding 하는 이유, 일부 네트워크 장비는 아직도 7bit 장치를 쓰기 때문에
	       URL이 깨질 수 있음,
	       고로, 코드값을 7bit인 아스키코드로 인코딩해서 보냄.
	       (UTF 코드값을 ASCII문자화 해서 보낸다)
-->
		<table>
			<tbody>
				<tr>
					<th>이름</th>
					<td><input type='text' name='name'></td>
				</tr>
				<tr>
					<th>이메일</th>
					<td><input type='email' name='email'></td>
				</tr>
				<tr>
					<th>암호</th>
					<td><input type='password' name='password'></td>
				</tr>
				<tr>
					<th>전화</th>
					<td><input type="tel" name='tel'></td>
				</tr>
				<tr>
					<th>직위</th>
					<td><input type='text' name='position'></td>
				</tr>
				<tr>
					<th>사진</th>
					<td><input type='file' name='file1'></td>
				</tr>
				<tr>
					<th></th>
					<td><button>등록</button></td>
				</tr>
			</tbody>
		</table>
	</form>

<jsp:include page="../footer.jsp" />

</body>
</html>
