<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script type="text/javascript">
	
	$(function() {
		
		/* $("#account_box1").hide(); */
		
	});

	
	<
	

</script>

<style type="text/css">
#account_box1, #account_box2, #account_box3 {
	margin: auto;
	width: 200px;
	height: 100px;
	border: 1px;
	margin-bottom: 5px;
}
	
	.img {
	cursor: pointer;
	border: 1px solid gray;
}

</style>


</head>
<body>
	<div style="margin-top: 100px;">
		<div id="account_box1">
			<!-- 여기서 이미지 태그를 누르면 통장개설되는 서블릿으로 이동 -->
			<img class="img" onclick="location.href='index.jsp'" src="../img/보통예금.png"><br>
		</div>
		<div id="account_box2">
			<img class="img" onclick="location.href='index.jsp'" src="../img/정기예금.png"><br>
		</div>
		<div id="account_box3">
			<img class="img" onclick="location.href='index.jsp'" src="../img/정기적금.png"><br>
		</div>
	</div>
</body>
</html>