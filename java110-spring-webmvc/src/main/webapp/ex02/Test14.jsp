<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <h1>Test14 페이지 컨트롤러</h1>
    <pre>
    [CAR]
    model : ${car.model}<br>
    maker : ${car.maker}<br>
    auto : ${car.auto}<br>
    
    [Engine]
    name : ${car.engine.name}
    cc : ${car.engine.cc}
    valve : ${car.engine.valve}
    </pre>
</body>
</html>