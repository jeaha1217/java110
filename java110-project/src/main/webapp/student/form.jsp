<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>- Manager Management -</title>
<style>
th {
    text-align: right;
}
</style>
</head>
<body>
    <h1>학생 등록(MVC)</h1>
    <form action='add' method='post'>
        <table>
            <tbody>
                <tr>
                    <th>이름</th>
                    <td><input type='text' name='name'></td>
                </tr>
                <tr>
                    <th>이메일</th>
                    <td><input type='text' name='email'></td>
                </tr>
                <tr>
                    <th>암호</th>
                    <td><input type='password' name='password'></td>
                </tr>
                <tr>
                    <th>전화</th>
                    <td><input type='tel' name='tel'></td>
                </tr>
                <tr>
                    <th>최종학력</th>
                    <td><input type='text' name='school'></td>
                </tr>

                <tr>
                    <th>재직여부</th>
                    <td><input type='radio' name='working' value='true'>true</td>
                    <td><input type='radio' name='working' value='false'>false</td>
                </tr>

                <tr>
                    <th></th>
                    <td><button>등록</button></td>
                </tr>
            </tbody>
        </table>
    </form>
</body>
</html>