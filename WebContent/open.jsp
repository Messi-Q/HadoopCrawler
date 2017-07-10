<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>百知教育登录界面</title>

<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/signin.css" rel="stylesheet">
<script type="text/javascript" src="js/jquery-1.7.2.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript">
     function changeT(type){
         $("#type").val(type);
         if(type=="one"){
         	$("#show").text("赶集网");
         }
         else{
        	 $("#show").text("房天下");
         }
	} 
</script>

</head>

<body>

	<div class="signin">
		<div class="signin-head">
			<img src="images/test/12.jpg" width="130px" alt="" class="img-circle">
		</div>
		<form id="urlForm" class="form-signin" role="form"
			action="${pageContext.request.contextPath}/main" method="post">
			<input id="url" name="url" type="url" class="form-control"
				placeholder="网站入口" required autofocus /> <br />
			<input type="hidden" id="type" name="type" value="one" >
			<button class="btn btn-lg btn-warning btn-block" type="submit">开始初始化</button>
		</form>
		<center><div class="btn-group">
				<button type="button" class="btn btn-primary">爬取网站</button>
				<button type="button" class="btn btn-primary dropdown-toggle"
					data-toggle="dropdown">
					<span class="caret"></span> <span class="sr-only">切换下拉菜单</span>
				</button>
				<ul class="dropdown-menu" role="menu">
					<li><a onclick="changeT('one');">赶集网</a></li>
					<li class="divider"></li>
					<li><a onclick="changeT('two');">房天下</a></li>
				</ul>
			</div><span id="show">赶集网</span></center>
	</div>
		
	<div
		style="text-align: center; margin: 50px 0; font: normal 14px/24px 'MicroSoft YaHei';">
	</div>
</body>
</html>
