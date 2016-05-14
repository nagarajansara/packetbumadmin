<%@ include file="lib/header.jsp"%>
<%@ include file="lib/leftsidebar.jsp"%>
<link rel="stylesheet" type="text/css"
	href="${baseURL }/assets/plugin/cfdatatable.css">
<div id="page-wrapper">
	<div id="page-inner">
		<div class="row">
			<div class="col-md-12">
				<h2>Vehicle Owner</h2>
				<!--<h5>Welcome Jhon Deo , Love to see you back. </h5>-->
			</div>

		</div>
		<hr>
		<div class="row">
			<div class="col-md-12">
				<div class="panel panel-default">
					<div class="panel-heading">User Lists</div>
					<div class="panel-body">
						<table width="100%">
							<tr>
								<td>
									<table id="example"
										class="display pkDataTableEx pkDataCommonTable"
										cellspacing="0" width="100%">
										<thead>
											<tr>
												<th>User Name</th>
												<th>Email</th>
												<th>Status</th>
												<th>Manage</th>
											</tr>
										</thead>
									</table>
								</td>
							</tr>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<%@ include file="lib/footer.jsp"%>
<script src="${baseURL}/assets/js/pkpaketbum.js"></script>
<script src="${baseURL }/assets/plugin/cfdatatable.js"></script>
<script>
    $('.pkAdminMenu li a').removeClass('active-menu');
    $('.pkAdminMenu a.pkVechicleUserMenu').addClass('active-menu');
    $(".pkUserMenu").addClass("active");

    //Plug-in to fetch page data 
    jQuery.fn.dataTableExt.oApi.fnPagingInfo = function(oSettings) {
	return {
	    "iStart" : oSettings._iDisplayStart,
	    "iEnd" : oSettings.fnDisplayEnd(),
	    "iLength" : oSettings._iDisplayLength,
	    "iTotal" : oSettings.fnRecordsTotal(),
	    "iFilteredTotal" : oSettings.fnRecordsDisplay(),
	    "iPage" : oSettings._iDisplayLength === -1 ? 0 : Math
		    .ceil(oSettings._iDisplayStart / oSettings._iDisplayLength),
	    "iTotalPages" : oSettings._iDisplayLength === -1 ? 0 : Math
		    .ceil(oSettings.fnRecordsDisplay()
			    / oSettings._iDisplayLength)
	};
    };

    $(document)
	    .ready(
		    function() {

			$("#example")
				.dataTable(
					{
					    "bProcessing" : true,
					    "bServerSide" : true,
					    "sort" : "position",
					    //bStateSave variable you can use to save state on client cookies: set value "true" 
					    "bStateSave" : false,
					    //Default: Page display length
					    "iDisplayLength" : 10,
					    //We will use below variable to track page number on server side(For more information visit: http://legacy.datatables.net/usage/options#iDisplayStart)
					    "iDisplayStart" : 0,
					    "fnDrawCallback" : function() {
						//Get page numer on client. Please note: number start from 0 So
						//for the first page you will see 0 second page 1 third page 2...
						//Un-comment below alert to see page number
						//alert("Current page number: "+this.fnPagingInfo().iPage);    
					    },
					    "sAjaxSource" : "http://"
						    + location.host
						    + "/paketbumadmin/api/admin/getUsers/vclOwner",
					    "aoColumns" : [ {
						"mData" : "shortname",
						'bSortable' : false
					    }, {
						"mData" : "email",
						'bSortable' : false
					    }, {
						"mData" : "status",
						'bSortable' : false
					    }, {
						"mData" : "manage",
						'bSortable' : false
					    }, ]
					});

		    });

    $(document)
	    .ready(
		    function() {
			$(document)
				.on(
					'click',
					".pkUserInfo",
					function(event) {
					    var id = $(this).attr("pk_id");
					    window
						    .open(
							    "http://"
								    + location.host
								    + "/paketbumadmin/api/admin/getUsersBasedId/"
								    + id
								    + "/"
								    + pkUtil.USER_TYPE_TRANSPORTER,
							    "_blank",
							    "width=800,height=500,left=200,top=100,scrollbars=1");
					});
		    });
</script>