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

<script type="text/javascript">
	
	

	function page_signup() {

		window.location.href = '../HTML/my_signup.html';

	}
	
	function login(f){
		
		var member_ID = f.member_ID.value.trim();
		var m_pwd = f.m_pwd.value.trim();
		
		if(member_ID==''){
			alert("ID를 입력하세요.");
			f.member_ID.value = '';
			f.member_ID.focus();
			return;
		}
		
		if(m_pwd==''){
			alert("비밀번호를 입력하세요.");
			f.m_pwd.value = '';
			f.m_pwd.focus();
			return;
		}
		
		f.method = "GET";
		
		f.action = "../login.do";
		
		f.submit();

	}

</script>

<style type="text/css">
#main_box {
	margin: auto;
	margin-top: 30px;
	width: 500px;
	min-height: 300px;
}

#id_table {
	margin-bottom: 10px;
	margin: auto;
	width: 60%;
}

#input_box {
	margin-bottom: 10px;
}
</style>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body>

	<div id="main_box">
		<div class="panel panel-success">
			<div class="panel-heading">
				<h3 style="text-align: center">로그인</h3>
			</div>
			<div class="panel-body">

				<form>
					<table id="id_table">
						<tr>
							<th><input type="text" class="form-control" name="member_ID"
								id="input_box"></th>
						</tr>
						<tr>
							<th><input type="text" class="form-control" name="m_pwd"
								id="input_box"></th>
						</tr>
						<tr>
							<th><button class="w3-button w3-blue"
									onclick="login(this.form);">로그인</button>
								<button class="w3-button w3-blue" onclick="page_signup();">회원가입</button></th>
						</tr>
					</table>
				</form>


			</div>


		</div>
	</div>

</body>
</html>