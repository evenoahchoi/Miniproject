<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="../css/main.css">
<link rel="stylesheet" href="../css/menu.css">

</head>
<body>
	
	<div id="main_box">
		<div id="header_upper">
		<%@ include file="header/header_upper.jsp" %>
		</div>	
		<div id="header_lower">
		<%@ include file="header/header_lower.jsp" %>
		</div>	
		<div id="header_lower2">
		<%@ include file="header/header_lower2.jsp" %>
		</div>
		
		<div id="content">여기에 메인컨텐츠 출력</div>		
		<div id="footer">footer</div>		
	</div>

</body>
</html>