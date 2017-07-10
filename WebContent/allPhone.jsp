<%@page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta http-equiv="x-ua-compatible" content="IE-edge" />
<meta name='viewport' content="width=device-width,initial-scale=1" />
<!--上面3个标签必须有，必须放在最前面
        viewport用来适配移动端显示效果
    -->
<title>爬虫后台</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap-theme.min.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css" />
<script type="text/javascript" src="js/jquery-1.7.2.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<!--引入jQuery：Bootstrap的js文件依赖jQuery，所以必须优先引入jQuery-->
<!--引入Bootstrap的js文件-->
<script type="text/javascript">
     function changeT(type){
         if(type=="one"){
         	$("#show").text("5个线程爬取");
            $("#count").val(5);
         }
         else{
        	 $("#show").text("10个线程爬取");
             $("#count").val(10);
         }
	} 
     
     function start(){
    	 var count = $("#count").val();
    	 location.href = "http://localhost:8080/HadoopCra/getImg?count="+count+"";
	} 
</script>
<style type="text/css">
.pagination {
	display: inline-block;
	padding-left: 0;
	margin: 20px 0;
	border-radius: 4px;
}

.pagination ul {
	display: inline-block;
	margin-left: 0;
	margin-bottom: 0;
	-webkit-border-radius: 4px;
	-moz-border-radius: 4px;
	border-radius: 4px;
	-webkit-box-shadow: 0 1px 2px rgba(0, 0, 0, 0.05);
	-moz-box-shadow: 0 1px 2px rgba(0, 0, 0, 0.05);
	box-shadow: 0 1px 2px rgba(0, 0, 0, 0.05);
}

ul>li {
	display: inline;
}

li {
	line-height: 20px;
}

.pagination ul>li:first-child>a,.pagination ul>li:first-child>span {
	border-left-width: 1px;
	-webkit-border-top-left-radius: 4px;
	-moz-border-radius-topleft: 4px;
	border-top-left-radius: 4px;
	-webkit-border-bottom-left-radius: 4px;
	-moz-border-radius-bottomleft: 4px;
	border-bottom-left-radius: 4px;
}

.pagination ul>li>a:hover,.pagination ul>li>a:focus,.pagination ul>.active>a,.pagination ul>.active>span
	{
	background-color: #f5f5f5;
}

.pagination ul>li>a,.pagination ul>li>span {
	float: left;
	padding: 4px 12px;
	line-height: 20px;
	text-decoration: none;
	background-color: #ffffff;
	border: 1px solid #dddddd;
	border-left-width: 0;
}
</style>
</head>
<body style="background-image:url('./images/login_bg_0.jpg');">
	<div class="container-fluid" style="width: 100%;" >
		<!--标题-->
		<div class="row show-grid">
			<nav class="navbar navbar-inverse">
				<div class="container-fluid">
					<div class="navbar-header">
						<li style="cursor: pointer"><a class="navbar-brand">百知教育云平台运营系统</a></li>
					</div>
				</div>
			</nav>
		</div>
		<!--左侧菜单-->
		<div class="row show-grid">
		<%-- <a href="${pageContext.request.contextPath}/getImg"><button class="btn btn-lg btn-warning btn-block" type="button" onclick="test();">爬取所有链接内的信息</button></a>
		<a href="http://192.168.211.128:50070/explorer.html#/"><button class="btn btn-lg btn-warning btn-block" type="button">查看爬取结果</button></a> --%>
			<table style="text-align:left" id="userPager"
				class=" table-bordered table-responsive table table-hover table-condensed">
				<thead>
					<tr class="bg-primary h4">
						<td>序号</td>
						<td>电话</td>
						<td>姓名</td>
						<td>日期</td>
				</thead>
				<!--数据-->
				<tbody>

					<c:forEach items="${requestScope.list}" var="data" varStatus="c">
						<tr class="bg-danger">
							<td>${c.count}</td>
							<td>${data.phone}</td>
							<td>${data.name}</td>
							<td>${data.date}</td>
						</tr>
					</c:forEach>
			</table>
			<!--分页-->
			<input type="hidden" id="count" value="5">
			<div align="center">
				<div class="pagination">
					<ul>
							<li><a href="${pageContext.request.contextPath}/allUrl?page=${requestScope.page-1}">上一页</a></li>
							<li><a href="${pageContext.request.contextPath}/allUrl?page=${requestScope.page+1}">下一页</a></li>
					</ul>
				</div>
			</div>
		</div>
	</div>
</body>
</html>