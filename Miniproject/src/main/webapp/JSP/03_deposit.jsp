<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>

<link rel="stylesheet" href="../css/main.css">
<link rel="stylesheet" href="../css/menu.css">
<link rel="stylesheet" href="../css/content.css">

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
		<div id="content">
		<hr>
			<div id="content1"></div>
			<div id="main">
				<%@ include file="content/03_입금.jsp" %> 
			</div>
			<div id="main2">
			
			</div>
			
		</div>		
		<div id="footer">footer</div>		
	</div>

</body>
</html>