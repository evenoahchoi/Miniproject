<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
	<!-- update -->


	<form>
		<div id="box"></div>
		<table class="table table-striped">

			<tr>
				<th>현재 잔액</th>
				<td><input style="text-align: right;" type="text"
					name="list_jan" value="0" readonly="readonly"></td>
			</tr>
			<tr>
				<th>입금하실 금액</th>
				<td><input type="text" name="list_in" ></td>
			</tr>


			<tr>

				<td colspan="2" align="center"><input type="button" value="입금"
					onclick="modify(this.form);"> <input type="button"
					value="취소" onclick="location.href='index.do'"></td>
			</tr>
		</table>


	</form>
</body>
</html>