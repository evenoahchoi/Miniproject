<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<%
	List<String> seoul = new ArrayList<String>();
	seoul.add("강동");
	seoul.add("강남");
	seoul.add("강서");
	seoul.add("강북");
	List<String> busan = new ArrayList<String>();
	busan.add("해운대");
	busan.add("사하");
	busan.add("수영");
	busan.add("남구");
	List<String> daegu = new ArrayList<String>();
	daegu.add("수성");
	daegu.add("달서");
	daegu.add("북");
	daegu.add("중");
	
	
	Map<String, List<String>> sidoMap = new HashMap<String, List<String>>();
	
	sidoMap.put("seoul", seoul);
	sidoMap.put("busan", busan);
	sidoMap.put("daegu", daegu);
	
	pageContext.setAttribute("sidoMap", sidoMap);
	
/* 	pageContext.setAttribute("seoul", seoul);
	pageContext.setAttribute("busan", busan);
	pageContext.setAttribute("seoul", daegu); */
	
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">

<style type="text/css">

	div{
		margin: auto;
		margin-top: 30px;
		width: 400px;
	}

</style>


</head>
<body>

<div>
	<table border="1" class="w3-table-all w3-hoverable">
		<tr>
			<th>시도</th>
			<th>구</th>
		</tr>
		
		<c:forEach var="sido" items="${ sidoMap }">
		
		<tr>
			<td>${ sido.key }</td>	
			
			
			
			<td>
				<c:forEach var="value" items="${ sido.value }">
				<table border="1" class="w3-table-all w3-hoverable">
					<tr>
						<td>${ value }</td>
					</tr>
					
				</table>
				</c:forEach> <!-- second - end  -->
			</td>
			
		
		
		
		</tr>
		</c:forEach> <!-- first - end  -->
		
	</table>
</div>	

	
</body>
</html>