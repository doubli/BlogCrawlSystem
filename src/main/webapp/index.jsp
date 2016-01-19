<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%	
	String path=request.getContextPath();
	String basePath = request.getScheme() + "://" 
					  + request.getServerName() + ":"
					  + request.getServerPort() + path +"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>BlogCrawlSystem</title>
		<base href="<%=basePath%>">
		<link rel="stylesheet" href="css/bootstrap.min.css">
		<link rel="stylesheet" href="css/font-awesome.css">
		<link rel="stylesheet" href="css/templatemo-style.css">
		<script src="js/vendor/jquery-1.10.2.min.js"></script>
		<script type="text/javascript">
			var regexUrl = "(http|https):\\/\\/[\\w\\-_]+(\\.[\\w\\-_]+)+([\\w\\-\\.,@?^=%&amp;:/~\\+#]*[\\w\\-\\@?^=%&amp;/~\\+#])?";
			function verify(){
		        var url = $(".url").val().trim();
				if(url.match(regexUrl) != null || ""== url){
					$(".urlspan").text("");
					return true;
				}else{
					$(".urlspan").text("地址不正确，请重新输入！");
					$(".url").val("");
					return false;
				}
        	}
		</script>
	</head>

	<body>
		<div class="site-bg"></div>

		<!-- SITE-HEADER -->
		<header class="site-header">
			<div class="container">
				<div class="row">
					<div class="col-md-4 col-sm-4 hidden-xs">
						<span class="phone">欢迎使用</span>
					</div>
					<div class="col-md-4 col-sm-4 col-xs-6 logo-holder">
						<a href="#" class="site-brand">Blog<span>Crawl</span>System</a>
					</div>
				</div>
			</div>
		</header>

		<div class="container" id="page-content">
			<div id="menu-container">
				<div id="menu-1" class="homepage home-section text-center">
					<form action="addUrl.do" method="post" class="subscribe-form">
						<h3 style="font-family:'微软雅黑';">博客爬取分类系统</h3>
						<fieldset class="email-holder">
							<input type="url" class="url" name="url" placeholder="Enter Blog main site here... " onblur="verify();">

							<br />
							<span class="urlspan" style="color: red;" span>
							</fieldset>
							
							<fieldset class="regex">
								<input type="regex" class="regex" name="regex" placeholder="Enter Regex here... ">
							</fieldset>
							<fieldset class="button-holder">
								<input type="submit" class="btn light" value="开&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;始" onblur="verify();"/>
								<!--<a href="#" class="btn default">直接进入查看</a>-->
							</fieldset>
						</form>
					</div>
			</div>
		</div>
					<div class="footer">
					<div class="text-center">
						<p class="copyright-text"> <a href="#" target="_blank" title="">BlogCrawlSystem</a> - created by <a href="#">Doubli Team</a></p>
					</div>
				</div>
					
	</body>
</html>