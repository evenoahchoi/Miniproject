<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id="box">
	
	여기서 통장을 선택할 수있게 구현.
	물론 통장도 반복문 받아서 파라미터값으로 출력 하기
	
	
	
	<c:if test="">
	값이 없으면 출력하지 않기
	</c:if>
	
	
		<h4 style="text-align: center">계좌번호</h4>

		<table >
			<tr>
				<th>입금 내역</th>
				<th>출금 내역</th>
				<th>날짜</th>
				<th>잔액</th>
			</tr>
			<tr>

				<td>여긴 반복문 사용</td>
				<td>if문써서 없으면 값이 null 이면 출력안하기</td>
				<td>날짜 EL식써서 받아오기</td>
			</tr>

		</table>
	</div>
	<input type="button" value="입금" onclick="modify(this.form);">
	<input type="button" value="출금" onclick="modify(this.form);">
	<input type="button" value="돌아가기" onclick="location.href='index.do'">


</body>
</html>