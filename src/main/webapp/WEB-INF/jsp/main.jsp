<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>BlogCrawlSystem</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/font-awesome.css">
<link rel="stylesheet" href="css/templatemo-style.css">
<link rel="stylesheet" href="jqPagination/css/jqpagination.css" />
<script src="js/vendor/jquery-1.10.2.min.js"></script>
<script src="jqPagination/js/jquery.jqpagination.js"></script>
<script src="jqPagination/js/scripts.js"></script>
<style type="text/css">
.table td, th {
	text-align: left;
}

.msg{
	color: red;
}
</style>
<script type="text/javascript">
	function del(id) {
		$.ajax({
			type : "POST",
			url : "deleteUrl.do",
			data : {
				"id" : id
			},
			dataType : "json",
			success : function(result) {
				alert(result.Msg);
				location.href = "listUrls.do";
			},
			error : function(result) {
				location.href = "listUrls.do";
			}
		});
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
				<a href="#" class="site-brand">Blog<span>Crawl</span>System
				</a>
			</div>
		</div>
	</div>
	</header>

	<div class="container" id="page-content">
		<div id="menu-container">
			<div id="menu-1" class="homepage home-section text-center">

				<span style="font-size: 18px;">当前数据库中的URL</span><br />
				<br /> 
				
				<table class="table" cols="3">
					<tr>
						<th>序号</th>
						<th>url</th>
						<!-- <th>作者</th> -->
						<th>添加时间</th>
						<th>操作</th>
					</tr>
					<c:if test="${Msg == 'error'} ">
						<tr class ="msg">
							<c:out value="请求错误 请刷新页面"></c:out>
						</tr>
					</c:if>
					<c:if test="${Msg=='ok'  && fn:length(urlList) == 0}">
						<tr class ="msg">
							<c:out value="暂时无数据！请先添加Url"></c:out>
						</tr>
					</c:if>
					<c:forEach items="${urlList}" var="urls" varStatus="status">
						<tr>
							<td>${status.count}</td>
							<td><a>${urls.url}</a></td>
						<%-- 	<td><a>
								<c:if test="${empty urls.author}">暂无数据</c:if>
								<c:if test="${!empty urls.author}">${urls.author}</c:if>
							</a></td> --%>
							<td><a>${urls.createDate}</a></td>
							<td>&nbsp;&nbsp;<a onclick="del('${urls.id}');">删除</a></td>
						</tr>
					</c:forEach>

				</table>
				<!-- <div class="gigantic pagination">
					<a href="#" class="first" data-action="first">&laquo;</a> <a
						href="#" class="previous" data-action="previous">&lsaquo;</a> <input
						type="text" readonly="readonly" /> <a href="#" class="next"
						data-action="next">&rsaquo;</a> <a href="#" class="last"
						data-action="last">&raquo;</a>
				</div> -->

				<fieldset class="button-holder">
					<a href="index.jsp"><input type="button" class="btn light" value="添&nbsp;&nbsp;加"/></a>
					<input type="button" class="btn light" value="内&nbsp;容&nbsp;展&nbsp;示"/>
					<!--<a href="#" class="btn default">直接进入查看</a>-->
				</fieldset>
			</div>
		</div>
	</div>
	<div class="footer">
		<div class="text-center">
			<p class="copyright-text">
				<a href="#" target="_blank" title="">BlogCrawlSystem</a> - created
				by <a href="#">Doubli Team</a>
			</p>
		</div>
	</div>

</body>
</html>