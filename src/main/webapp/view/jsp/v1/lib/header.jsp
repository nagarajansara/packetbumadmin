<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<c:set var="baseURL" value="${pageContext.request.contextPath}" />

<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Test Sending Tool</title>
<!-- BOOTSTRAP STYLES-->
<link href="${baseURL}/theme/admin/assets/css/bootstrap.css"
	rel="stylesheet" />
<!-- FONTAWESOME STYLES-->
<link href="${baseURL}/theme/admin/assets/css/font-awesome.css"
	rel="stylesheet" />
<!-- CUSTOM STYLES-->
<link href="${baseURL}/theme/admin/assets/css/custom.css"
	rel="stylesheet" />
<!-- GOOGLE FONTS-->
<link href='http://fonts.googleapis.com/css?family=Open+Sans'
	rel='stylesheet' type='text/css' />


<link
	href="${baseURL}/theme/admin/assets/js/dataTables/dataTables.bootstrap.css"
	rel="stylesheet" />

<link href="${baseURL}/assets/css/pkpaketbum.css" rel="stylesheet" />

<style>
body {
	font-family: verdana;
}

.Pknavbar-default {
	background-color: #d00355;
}

.bmNavBar-Brand {
	font-size: 20px !important;
}
</style>

</head>
<body>
	<div id="wrapper">
		<nav class="navbar navbar-default Pknavbar-default navbar-cls-top "
			role="navigation" style="margin-bottom: 0">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".sidebar-collapse">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand bmNavBar-Brand" href="index.html">Paketbum
					Admin</a>
			</div>
			<div
				style="color: white; padding: 15px 50px 5px 50px; float: right; font-size: 16px;">
				<a href="${baseURL}/api/admin/logout" class="btn square-btn-adjust"
					style="background-color: #000000; color: #fff;">Logout</a>
			</div>
		</nav>