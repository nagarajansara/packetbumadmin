<%@ include file="lib/header.jsp"%>
<%@ include file="lib/leftsidebar.jsp"%>
<div id="page-wrapper">
	<div id="page-inner">
		<div class="row">
			<div class="col-md-12">
				<!-- <h2>Coming soon</h2>
				<h5>Welcome Jhon Deo , Love to see you back. </h5> -->
			</div>

		</div>
		<hr>
		<div class="row bmMailHeadersMsg" style="display: none;">
			<div class="col-md-12">
				<div class="alert alert-info bmMailHeadersInfo"></div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-12"></div>
		</div>
		<div class="row">
			<div class="col-md-12"></div>
		</div>
	</div>
</div>
<%@ include file="lib/footer.jsp"%>
<script src="${baseURL}/assets/js/pkpaketbum.js"></script>
<script
	src="${baseURL}/theme/admin/assets/js/dataTables/jquery.dataTables.js"></script>
<script
	src="${baseURL}/theme/admin/assets/js/dataTables/dataTables.bootstrap.js"></script>
<script>
    $('.bmTestInterFace li a').removeClass('active-menu');
    $('.bmTestInterFace a.bmMailHeadersMenu').addClass('active-menu');
    $(document).ready(function() {
	$('#dataTables-example').dataTable();
    });
</script>