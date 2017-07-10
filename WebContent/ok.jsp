<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>百知教育登录界面</title>

<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/signin.css" rel="stylesheet">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.7.2.js"></script>
<script type="text/javascript">
/*     function test(){
         var url = $("#url").val();
         if(url == null){
           alert("请先输入地址：");
         }else{
            $.ajax({
               url : "${pageContext.request.contextPath}/main/getDivFromUrl.do",
               data : "url="+url,
               dataType : "text",
               success : function(result){
                 $("#url").css("display", true);
                 
               }
            });
         }
	} */
	function test(){
	   location.href = "http://localhost:8080/HadoopCra/allUrl";
	}
</script>

</head>

<body>

	<div class="signin">
		<div class="signin-head">
			<img src="${pageContext.request.contextPath}/images/test/12.jpg" width="130px" alt="" class="img-circle">
		</div>
		     <br/>
		     
			<button class="btn btn-lg btn-warning btn-block" type="button" onclick="test();">点击查看所有爬取的数据</button>
	</div>

	<div
		style="text-align:center;margin:50px 0; font:normal 14px/24px 'MicroSoft YaHei';">
	</div>
</body>
</html>
