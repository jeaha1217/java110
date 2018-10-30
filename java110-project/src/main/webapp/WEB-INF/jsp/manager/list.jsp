<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset='UTF-8'>
<title>매니저 관리</title>
<link rel='stylesheet' href='/css/common.css'>
<%-- 브라우져 입장에서의 경로가 바뀌었다. --%>
<style>
    table, th, td {
        border: 1px solid gray;
    }
</style>
</head>
<body>

    <jsp:include page="../header.jsp"/>
    <%-- 얘는 상관 없다?
         왜?
         얘는 JSP 기준이기 때문임.
         
         js도 헷깔릴수 있음 js도 웹 브라우져의 기준에서 경로임.
         헷갈리지 말아라앙 으르르르르르를!
    --%>
    <h1>매니저 목록(MVC)</h1>
    <p>
        <a href='form'>추가</a>
    </p>
    <table>
        <thead>
            <tr>
                <th>번호</th><th>이름</th><th>이메일</th><th>직위</th>
            </tr>
        </thead>
        <tbody>
            
            <c:forEach items="${list}" var="m">
                <tr>
                    <td>${m.no}</td>
                    <td><a href='detail?no=${m.no}'>${m.name}</a></td>
                    <%-- 같은 방에 있는 주소 ㅇㅇ --%>
                    <td>${m.email}</td>
                    <td>${m.position}</td>
                </tr>
            </c:forEach>
            
        </tbody>
    </table>

    <jsp:include page="../footer.jsp"/>

</body>
</html>