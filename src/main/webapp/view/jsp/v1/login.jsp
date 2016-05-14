<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html lang="en">
<head>
<c:set var="baseURL" value="${pageContext.request.contextPath}" />

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description"
	content="Bootbusiness | Short description about company">
<meta name="author" content="Your name">
<title>Testing tool</title>
<!-- Bootstrap -->
<link href="${baseURL}/theme/plugin/css/bootstrap.min.css"
	rel="stylesheet">
<!-- Bootstrap responsive -->
<link href="${baseURL}/theme/plugin/css/boot-business.css"
	rel="stylesheet">
<!-- Font awesome - iconic font with IE7 support -->
<link href="${baseURL}/theme/plugin/css/font-awesome.css"
	rel="stylesheet">
<link href="${baseURL}/theme/plugin/css/font-awesome-ie7.css"
	rel="stylesheet">
<!-- Bootbusiness theme -->
<link href="${baseURL}/theme/plugin/css/boot-business.css"
	rel="stylesheet">

<style>
.widget-header {
	background-color: #d00355 !important;
	color: #ffffff !important;
	font-family: verdana;
	font-size: 12px !important;
}

.content {
	background: none !important;
}

.widget-body {
	border: 4px solid #ddd !important;
}

.bmLoginWarMsg {
	display: none;
}
</style>

</head>
<body>
	<!-- Start: HEADER -->
	<header>
		<!-- Start: Navigation wrapper -->
		<div class="navbar navbar-fixed-top"></div>
		<!-- End: Navigation wrapper -->
	</header>
	<!-- End: HEADER -->
	<!-- Start: MAIN CONTENT -->
	<div class="content">
		<div class="container">
			<div class="row bmLoginWarMsg">
				<div class="span6 offset3">
					<span style="color: red; font-family: verdana">Username and
						Password missed</span>
				</div>
				<div class="clearfix"></div>
			</div>
			<c:if test="${sessionScope.userId != null}">
				<c:redirect url="/view/jsp/v1/home.jsp" />
			</c:if>
			<c:if test="${not empty model.responseStatus}">
				<div class="row">
					<div class="span6 offset3">
						<c:if test="${model.responseStatus ne 200}">
							<span style="color: red; font-family: verdana"><c:out
									value="${model.responseMsg}" /></span>
						</c:if>
						<c:if test="${model.responseStatus eq 200}">
							<c:redirect url="/view/jsp/v1/home.jsp" />
						</c:if>
					</div>
					<div class="clearfix"></div>
				</div>
			</c:if>
			<div class="row">
				<div class="span6 offset3">
					<h4 class="widget-header">
						<i class="icon-lock"></i> Signin to Paketbum Admin
					</h4>
					<div class="widget-body">
						<div class="center-align">
							<form action="${baseURL}/api/admin/validate" method="POST"
								class="form-horizontal form-signin-signup "
								onsubmit="return bmLoginSubmit()">
								<input type="text" name="email" placeholder="Email"
									class="bmLoginEmailTxt"> <input type="password"
									name="password" placeholder="Password" class="bmLoginPassTxt">
								<div class="clearfix"></div>
								<input type="submit" value="Signin"
									class="btn  btn-success btn-sm">
							</form>

						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- End: MAIN CONTENT -->
	<!-- Start: FOOTER -->

	<!-- End: FOOTER -->
	<script type="text/javascript"
		src="${baseURL}/theme/plugin/js/jquery.min.js"></script>
	<script type="text/javascript"
		src="${baseURL}/theme/plugin/js/bootstrap.min.js"></script>
	<script type="text/javascript"
		src="${baseURL}/theme/plugin/js/boot-business.js"></script>
	<script type="text/javascript">
	function bmLoginSubmit() {
	    var email = $('.bmLoginEmailTxt').val();
	    var password = $('.bmLoginPassTxt').val();
	    if (email && password && password.length > 0 && email.length > 0) {
		return true;
	    } else {
		$('.bmLoginWarMsg').show();

		return false;
	    }
	}
    </script>
</body>

</html>