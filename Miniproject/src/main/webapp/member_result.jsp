
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%
 	//Java Code -> _jspService(request,response)메소드내에 삽입
 	
 	//JSP내장객체 : pageContext,request,response,session,application
 	//  		    out
 	
	//0.수신인코딩 설정(받을 때 해당 인코딩으로 받겠다) <- html에서 보낼때 POST로 보내면 한글은 깨져서 오기 때문
	request.setCharacterEncoding("utf-8");
	
	
	String name = request.getParameter("name");
	String id = request.getParameter("id");
	String pwd = request.getParameter("pwd");
	String gender = request.getParameter("gender");
	String[] hobby_array = request.getParameterValues("hobby");    //파라미터 이름이 동일한 변수는 배열로 받는다.
	String[] friend_array = request.getParameterValues("friend");  //파라미터 이름이 동일한 변수는 배열로 받는다.
	String blood = request.getParameter("blood");
	String profile = request.getParameter("profile");
	
	//비밀번호 mask
	int len = pwd.length();
	StringBuilder sb_pwd = new StringBuilder();
	sb_pwd.append(pwd.substring(0,len/2));
	for(int i=0;i<(len-len/2);i++) {
		sb_pwd.append('*');
	}
	
	String pwd_mask = sb_pwd.toString();
	
	//취미처리
	String hobby_list = "취미없음";
	
	if(hobby_array!=null) {
		
		StringBuffer sb = new StringBuffer();
		//String [] hobby_array = {"운동","독서"}
		for(String hobby : hobby_array) {
			sb.append(hobby);//운동 독서
			sb.append(" ");
		}
		hobby_list = sb.toString();
	}
	
	//친구처리
	//String [] friend_array = {"","","",""};
	
	StringBuffer sb1 = new StringBuffer();
	for (String friend : friend_array) {
		sb1.append(friend);
		sb1.append(" ");
	}
	String friend_list;
	friend_list = sb1.toString().trim();
	if(friend_list.isEmpty()) {
		friend_list="친구없음";
	}
	
//---- ▲[  Business Logic ]----------------------------------------------------------------------	
 %> 
 <!--- ▼[Presentaion Logic]--------------------------------------------------------------- -->   
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<style type="text/css">
	#box{
		width:400px;
		margin: auto;
		margin-top: 30px;
		border: 1px solid blue;
		box-shadow: 1px 1px 1px black;
	}
	
	caption{
		text-align: center;
	}
</style>

</head>
<body>

<div id="box">
		<table class="table table-striped">
			<caption>::::회원정보 결과::::</caption>
			<tr>
				<th>이름</th>
				<td><%=name%></td>
			</tr>
			<tr>
				<th>아이디</th>
				<td><%=id%></td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><%=pwd_mask%></td>
			</tr>
			<tr>
				<th>성별</th>
				<td><%=gender%></td>
			</tr>
			<tr>
				<th>취미</th>
				<td><%=hobby_list%></td>
			</tr>
			<tr>
				<th>혈액형</th>
				<td><%=blood%></td>
			</tr>
			<tr>
				<th>친구</th>
				<td><%=friend_list%></td>
			</tr>
			<tr>
				<th>자기소개</th>
				<td><%=profile%></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><a href="member_input.html">다시하기</a>
				</td>
			</tr>

		</table>

	</div>
</body>
</html>














