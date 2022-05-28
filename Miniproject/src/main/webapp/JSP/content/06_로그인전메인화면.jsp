<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>


<script type="text/javascript">
	function log_alert(){
		
		if( confirm("로그인 후 이용 가능합니다. 로그인 하시겠습니까?")==true){
			
			location.href="../login/login.jsp";
			
		}else
			return;
		
		
	}


</script>

<style type="text/css">

 .container{
	width: 100%;
	height: 100%;
} 

</style>

</head>
<body>

<div class="container" >
  <div id="myCarousel" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
      <li data-target="#myCarousel" data-slide-to="1"></li>
      <li data-target="#myCarousel" data-slide-to="2"></li>
    </ol>

    <!-- Wrapper for slides -->
    <div class="carousel-inner">
      <div class="item active">
        <img src="../img/test1.png" onclick="log_alert();" alt="Los Angeles" style="width:100%;">
      </div>

      <div class="item">
        <img src="../img/test2.png" onclick="log_alert();" alt="Chicago" style="width:100%;">
      </div>
    
      <div class="item">
        <img src="../img/test3.png" onclick="log_alert();" alt="New york" style="width:100%;">
      </div>
    </div>

    <!-- Left and right controls -->
    <a class="left carousel-control" style="opacity: 0;"  href="#myCarousel" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" style="opacity: 0;" href="#myCarousel" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right"></span>
      <span class="sr-only">Next</span>
    </a>
    </div>
  </div>




</body>
</html>
