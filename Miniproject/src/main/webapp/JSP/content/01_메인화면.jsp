<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta charset="UTF-8">
<title>통장조회</title>

<script type="text/javascript">

	function ipp() {
		location.href="03_deposit.jsp";
	}
	function chul() {
		location.href="04_withdraw.jsp";
	}


</script>

<style type="text/css">
	#table_box{
		margin-top: 80px;
		margin-left: 60px;
		height: 80%;

	}
	th, td{
		text-align: center;
	}
	
</style>
</head>
<body>
	<div id="table_box">

			<table  width="100%">
				<tr>
					<th width="20%">계좌번호</th>
					<th width="10%">통장종류</th>
					<th width="15%">개설일</th>
					<th width="15%">만기일</th>
					<th width="10%">잔액</th>
				</tr>
				
				<c:if test="${ empty list }">
					<tr>
						<td colspan="5" align="center">
							<span style="color: red;">데이터가 존재하지 않습니다.</span>
						</td>
					</tr>
				</c:if> 
				
				<c:forEach var="vo" items="${ list }">
				<tr>
					<td>${vo.a_acc_no}</td>	
					<td>${vo.type}</td>	
					<td>${vo.acc_s}</td>	
					<td>${vo.acc_e}</td>	
					<td>${vo.list_jan}</td>	

					<td>
						<input class="btn btn-info" type="button" value="입금" 
						onclick="ipp();">
						<input class="btn btn-danger" type="button" value="출금" 
						onclick="chul();">
					</td>
				</tr>
				
				
				</c:forEach>
				
			</table>

	</div>

</body>
</html>