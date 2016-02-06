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
<style type="text/css">
.table td, th {
	text-align: left;
}

.msg{
	color:red;
}
</style>
	<script type="text/javascript">

		function formateDate(date){
			console.log(date);
			var year = date.getFullYear();
			var month = date.getMonth() + 1;
			var day = date.getDay();
			var hour = date.getHours();
			var minute = date.getMinutes();
			var second = date.getSeconds();
			console.log(year);
			return year+"-"+month+"-"+day+"  "+hour+":"+minute+":"+second;
		}

		function  addData(result){
			var tab = $(".table");
			$.each(result.dataList.list,function(i,url){
				var str = "<tr><td>"+(i+1)+"</td><td><a>"+url['url']+"</a></td><td>"+formateDate(new Date(url['createDate']))+"</td><td><a onclick=\"del("+url['id']+");\">"+"删除</a>"+"</td></tr>";
				console.log(str);
				tab.append(str);
			});
			tab.append("<tr><td>bbbb</td><td>bbbb</td><td>bbbb</td><td>bbbb</td></tr>");
		}

		function forData(){
			$.ajax({
				type : "POST",
				url : "listUrls.do",
				async: true,
				dataType : "json",
				success : function(result) {
					var pageNum = result.dataList.pageNum;
					var maxPage = result.dataList.pages;
					$('.pagination').jqPagination({
						max_page: maxPage,
						current_page : pageNum,
						page_string:'Page {current_page} of {max_page}',
					});
					addData(result);
				}
			});
		}

		$(function(){
			forData();

			$('.pagination').jqPagination({
				max_page: '{max_page}',
				current_page : '{current_page}',
				page_string:'Page {current_page} of {max_page}',
				//回调函数
				paged: function(page){
					alert("回调了");
				}
			});

			/*$('.pagination').jqPagination({
				max_page: "33",
				current_page : "$('dataList.pageNum')",
				page_string:'Page {current_page} of {max_page}',
				paged: function (page) {
					location.href = 'listUrls.do?currentPage='+page;
				}
			});*/
		});

	</script>
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
					<%--<c:if test="${Msg == 'error'} ">
						<tr class ="msg">
							<c:out value="请求错误 请刷新页面"></c:out>
						</tr>
					</c:if>
					<c:if test="${Msg=='ok'  && fn:length(dataList.list) == 0}">
						<tr class ="msg">
							<c:out value="暂时无数据！请先添加Url"></c:out>
						</tr>
					</c:if>
					<c:forEach items="${dataList.list}" var="urls" varStatus="status">
						<tr>
							<td>${status.count}</td>
							<td><a>${urls.url}</a></td>
						&lt;%&ndash; 	<td><a>
								<c:if test="${empty urls.author}">暂无数据</c:if>
								<c:if test="${!empty urls.author}">${urls.author}</c:if>
							</a></td> &ndash;%&gt;
							<td><a>${urls.createDate}</a></td>
							<td>&nbsp;&nbsp;<a onclick="del('${urls.id}');">删除</a></td>
						</tr>
					</c:forEach>--%>

				</table>
				<div class="gigantic pagination">
					<a href="#" class="first" data-action="first">&laquo;</a> <a
						href="#" class="previous" data-action="previous">&lsaquo;</a> <input
						type="text" readonly="readonly" /> <a href="#" class="next"
						data-action="next">&rsaquo;</a> <a href="#" class="last"
						data-action="last">&raquo;</a>
				</div>

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