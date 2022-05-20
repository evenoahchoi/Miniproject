<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//수행영역 : _jspService()
	//각 영역에 데이터를 넣는다.   (key, value)	
	pageContext.setAttribute("msg", "안녕 pageScope에 있어?");
	request.setAttribute("msg", "아니? requsetScope에 있는데??");
	session.setAttribute("msg", "그럼우리 sessionScope에서 만나자");
	application.setAttribute("msg", "싫어. application로 갈거야");


%>   
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- 변수를 사용했을때 형식 : ${ 영역.객체(변수)명 } --%>
pageScope내의 msg : ${ pageScope.msg }<br>
requestScope내의 msg : ${ requestScope.msg }<br>
sesstionScope내의 msg : ${ sessionScope.msg }<br>
applicationScope내의 msg : ${ applicationScope.msg }<br>

<!-- 영역이 생략되면 참조되는 순서
	pageScope -> requestScope -> sessionScope -> applicationScope

 -->
나는 어느영역에 msg일까? : ${ msg }<br>

</body>
</html>