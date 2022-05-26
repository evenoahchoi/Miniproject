<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<!-- Bootstrap 3.x 사용설정 : CDN(Content Delivery Network) -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<script src="https://code.jquery.com/jquery-3.6.0.js"></script>

<script type="text/javascript">
	
</script>

<!-- w3.css 사용설정 -->
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">


<script type="text/javascript">
	function send(f) {

		//필수 입력 항목
		var member_ID = f.member_ID.value.trim();
		var m_name = f.m_name.value.trim();
		var m_pwd = f.m_pwd.value.trim();
		var pwd_check = f.pwd_check.value.trim();
		var email1 = f.email1.value.trim();
		var email2 = f.email2.value.trim();
		var tel1 = f.tel1.value.trim();
		var tel2 = f.tel2.value.trim();
		var tel3 = f.tel3.value.trim();
		
		//아이디 체크
		if (member_ID == '') {
			alert('ID를 입력하세요.');
			f.member_ID.value = '';
			f.member_ID.focus();
			return;
		}
		//아이디 유효성 검사
		 var idRegCheck = /^[a-zA-Z0-9]{1,10}$/; 

		if(!idRegCheck.test(member_ID)){
			alert('ID는 영문자와 숫자 1~10자리로 입력하실 수 있습니다.');
			f.member_ID.value = '';
			f.member_ID.focus();
			return;
		}
		 

		//비밀번호 체크
		if (m_pwd == '') {
			alert('비밀번호를 입력하세요.');
			f.m_pwd.value = '';
			f.m_pwd.focus();
			return;
		}
		if (pwd_check == '') {
			alert('비밀번호를 "재확인"하세요.');
			f.pwd_check.value = '';
			f.pwd_check.focus();
			return;
		}
		

		//비밀번호확인 체크
		if (m_pwd != pwd_check) {
			alert('두 비밀번호가 일치하지 않습니다.');
			f.pwd_check.value = '';
			f.pwd_check.focus();
			return;
		}
		
		var korRegCheck = /[ㄱ-ㅎㅏ-ㅣ가-힣]/;
		
		//이름 체크
		if (m_name == '') {
			alert('이름을 입력하세요.');
			f.m_name.value = '';
			f.m_name.focus();
			return;
		}
		
		if(!korRegCheck.test(m_name)){
			alert('이름은 한글만 입력가능합니다.');
			f.m_name.value = '';
			f.m_name.focus();
			return;
		}
		
		
	
		if(email1 == ''){
			alert('메일를 주소를 입력하세요.');
			f.email1.value = '';
			f.email1.focus();
			return;
		}
		
		var mailRegCheck = /^[a-zA-Z0-9]{1,}$/; 
		
		
		if(!mailRegCheck.test(email1)){
			alert('메일은 영문자와 숫자로만 입력 가능합니다.');
			f.email1.value = '';
			f.email1.focus();
			return;
		}
		
		
		
		if(email2 == ''){
			alert('메일를 주소를 끝까지 입력하세요.');
			f.email2.value = '';
			f.email2.focus();
			return;
		}
		
		
		if(!mailRegCheck.test(email2)){
			alert('메일은 영문자와 숫자로만 입력 가능합니다.');
			f.email2.value = '';
			f.email2.focus();
			return;
		}

 		var telRegCheck = /^[0-9]{3}$/;
		var telRegCheck2 = /^[0-9]{4}$/;
		
		//전화번호 입력 체크
		if (tel1 == '') {
			alert('첫번째 전화번호를 입력하세요.');
			f.tel1.value = '';
			f.tel1.focus();
			return;

			
		}
		
		if (!telRegCheck.test(tel1)) {
			alert('3자리 숫자만 입력하세요');
			f.tel1.value = '';
			f.tel1.focus();
			return;
		}
		
		// 2번째
		if (tel2 == '') {
			alert('두번째 전화번호를 입력하세요.');
			f.tel2.value = '';
			f.tel2.focus();
			return;

			
		}
		
		if (!telRegCheck2.test(tel2)) {
			alert('4자리 숫자만 입력하세요');
			f.tel2.value = '';
			f.tel2.focus();
			return;
		}

		// 3번째
		if (tel3 == '') {
			alert('세번째 전화번호를 입력하세요.');
			f.tel3.value = '';
			f.tel3.focus();
			return;

			
		}
		
		if (!telRegCheck2.test(tel3)) {
			alert('4자리 숫자만 입력하세요');
			f.tel3.value = '';
			f.tel3.focus();
			return;
		}
		
		// ===================================================
		//전송방식
		
		
		f.action = "sign_up.do";
		
		//전송
		f.submit();

	}

	$(function() {
		$("#cancle").click(function() {
			if (confirm("회원등록을 취소 하시겠습니까?") == true) {
				window.location.href='index.jsp';
			} else {
				return;
			}
		})
	});
	
</script>

<style type="text/css">
	#box {
		width: 400px;
		min-height: 300px;
		/* border : 1px solid blue; */
		margin: auto;
		margin-top: 30px;
	}
	#email {
		display: inline; 
		width: 45%; 
		margin-bottom: 10px;
	}

	#tel {
		display:inline-block; 
		margin-bottom: 10px; 
		width: 29%; 
		text-align: center;
	}
	



</style>

</head>
<body>

	<div id="box">
		<div class="panel panel-success">
			<div class="panel-heading">
				<h3 style="text-align: center">회원가입</h3>
			</div>
			<div class="panel-body">
				<!-- table -->

				<form action="">


					<table style="margin: auto;">
						<!-- 아이디 -->
						<tr>
							<th><label for="member_ID">I D :</label></th>
						</tr>
						<tr>
							<th><input type="text" class="form-control" name="member_ID"
								style="margin-bottom: 10px;"></th>

							<!-- 중복확인 함수 만들기 -->
							<td><button type="button" class="btn btn-default"
									style="margin-bottom: 10px; margin-left: 10px;">중복확인</button></td>
						</tr>


						<!-- 비번 -->
						<tr>
							<th><label for="m_pwd">비밀번호 :</label></th>
						</tr>

						<tr>
						<!-- 최종적으로 type을 password로 바꿀예정 지금은 개발중이라 text -->
							<th><input type="text" class="form-control" name="m_pwd"
								style="margin-bottom: 10px;"></th>
						</tr>
						
						<!-- 비번check -->
						<tr>
							<th><label>비밀번호 확인 :</label></th>
						</tr>

						<tr>
							<th><input type="text" class="form-control" name="pwd_check"
								style="margin-bottom: 10px;"></th>
						</tr>

						<!-- 이름 -->
						<tr>
							<th><label for="m_name">이름 :</label></th>
						</tr>

						<tr>
							<th><input type="text" class="form-control" name="m_name"
								style="margin-bottom: 10px;"></th>
						</tr>

						<!-- 이메일 -->
						<tr>
							<th><label for="email">e-mail :</label></th>
						</tr>
						<tr>
							<th>
								<input type="text" class="form-control" name="email1" id="email">
								@ 
								<input type="text" class="form-control" name="email2" id="email">
							</th>

							<td>
								<!-- jQuery써서 funtion만들기 -->
								<button type="button" class="btn btn-default"
									style="margin-bottom: 10px; margin-left: 10px;">중복확인</button>

							</td>
						</tr>

						<!-- 전화번호 -->
						<tr>
							<th><label>전화번호 :</label></th>
						</tr>
						<tr>
							<th>
							<input maxlength="3" type="text" class="form-control" name="tel1" id="tel">
							-
							<input maxlength="4" type="text" class="form-control" name="tel2" id="tel">
							-
							<input maxlength="4" type="text" class="form-control" name="tel3" id="tel">
							</th>
						</tr>
						<tr>
						<td><br><td>
						</tr>
						
						<!-- 가입 / 취소 -->
						<tr >
							<td colspan="2" style="text-align: center">
								<button type="button" class="btn btn-default"
									onclick="send(this.form);">가입</button>
								<button type="button" class="btn btn-default" id="cancle">취소</button>
							</td>
						</tr>


					</table>
				</form>


			</div>
		</div>
	</div>

</body>
</html>


