<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    

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
		<%@ include file="header/header_upper.jsp" %><hr>
		</div>	
		<div id="header_lower">
		<%@ include file="header/header_lower.jsp" %>
		</div>	
		<div id="header_lower2">
		<%@ include file="header/header_lower2.jsp" %>
		</div>
		<hr>
		<div id="content">
			<div id="content1"></div>
			<div>
				<%@ include file="content/01_통장조회.jsp" %> 
			</div>
			
		</div>		
		<div id="footer">footer</div>		
	</div>

</body>
</html>