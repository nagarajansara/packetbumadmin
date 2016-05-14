<%@ include file="lib/header.jsp"%>
<link rel="stylesheet" type="text/css"
	href="${baseURL }/assets/plugin/cfdatatable.css">
<style>
.navbar-cls-top {
	display: none;
}

#page-wrapper {
	margin-left: 0px;
}
</style>
<div id="page-wrapper">
	<div id="page-inner">
		<div class="row">
			<div class="col-md-12">
				<h2>Users</h2>
				<!--<h5>Welcome Jhon Deo , Love to see you back. </h5>-->
			</div>

		</div>
		<hr>
		<div class="row">
			<div class="col-md-12">
				<div class="panel panel-default">
					<div class="panel-heading">User Lists</div>
					<div class="panel-body">
						<c:if
							test="${(not empty model.responseData.userList) && (model.responseData.role eq 'vclOwner')}">
							<c:forEach var="element" items="${model.responseData.userList}">
								<form class="form-horizontal pkVclOwnerForm" role="form">
									<input type="hidden" class="pkVclOwneruserId"
										value="${element.userid }">
									<div class="form-group">
										<label class="control-label col-sm-2" for="email">UserName
										</label>
										<div class="col-sm-10">
											<input required type="text"
												class="form-control pkVclOwnUserName" id="email"
												placeholder="Enter userName" value="${element.username }">
										</div>
									</div>
									<div class="form-group">
										<label class="control-label col-sm-2" for="email">Email
										</label>
										<div class="col-sm-10">
											<input required type="text"
												class="form-control pkVclOwnEmail" placeholder="Enter email"
												value="${element.email }">
										</div>
									</div>
									<div class="form-group">
										<label class="control-label col-sm-2" for="email">mobile
										</label>
										<div class="col-sm-10">
											<input required type="text"
												class="form-control pkVclOwnerMobile"
												placeholder="Enter email" value="${element.mobile }">
										</div>
									</div>
									<div class="form-group">
										<label class="control-label col-sm-2" for="status">Status
										</label>
										<div class="col-sm-10">
											<div class="radio">
												<c:if test="${element.isactive eq 1}">
													<label><input type="radio" value="1" name="status"
														checked>Active</label>
												</c:if>
												<c:if test="${element.isactive eq 0}">
													<label><input type="radio" value="1" name="status">Active</label>
												</c:if>
											</div>
											<div class="radio">
												<c:if test="${element.isactive eq 0}">
													<label><input type="radio" value="0" name="status"
														checked>Deactive</label>
												</c:if>
												<c:if test="${element.isactive eq 1}">
													<label><input type="radio" value="0" name="status">Deactive</label>
												</c:if>
											</div>
										</div>
									</div>
									<div class="form-group">
										<div class="col-sm-offset-2 col-sm-10">
											<button type="button"
												class="btn btn-default pkUpdateVclOwnerUserDetails">Update</button>
											<img class="pkDisplayHide pkWarningMsg"
												src="data:image/gif;base64,R0lGODlhEAAQAPIAAP///wAAAMLCwkJCQgAAAGJiYoKCgpKSkiH/C05FVFNDQVBFMi4wAwEAAAAh/hpDcmVhdGVkIHdpdGggYWpheGxvYWQuaW5mbwAh+QQJCgAAACwAAAAAEAAQAAADMwi63P4wyklrE2MIOggZnAdOmGYJRbExwroUmcG2LmDEwnHQLVsYOd2mBzkYDAdKa+dIAAAh+QQJCgAAACwAAAAAEAAQAAADNAi63P5OjCEgG4QMu7DmikRxQlFUYDEZIGBMRVsaqHwctXXf7WEYB4Ag1xjihkMZsiUkKhIAIfkECQoAAAAsAAAAABAAEAAAAzYIujIjK8pByJDMlFYvBoVjHA70GU7xSUJhmKtwHPAKzLO9HMaoKwJZ7Rf8AYPDDzKpZBqfvwQAIfkECQoAAAAsAAAAABAAEAAAAzMIumIlK8oyhpHsnFZfhYumCYUhDAQxRIdhHBGqRoKw0R8DYlJd8z0fMDgsGo/IpHI5TAAAIfkECQoAAAAsAAAAABAAEAAAAzIIunInK0rnZBTwGPNMgQwmdsNgXGJUlIWEuR5oWUIpz8pAEAMe6TwfwyYsGo/IpFKSAAAh+QQJCgAAACwAAAAAEAAQAAADMwi6IMKQORfjdOe82p4wGccc4CEuQradylesojEMBgsUc2G7sDX3lQGBMLAJibufbSlKAAAh+QQJCgAAACwAAAAAEAAQAAADMgi63P7wCRHZnFVdmgHu2nFwlWCI3WGc3TSWhUFGxTAUkGCbtgENBMJAEJsxgMLWzpEAACH5BAkKAAAALAAAAAAQABAAAAMyCLrc/jDKSatlQtScKdceCAjDII7HcQ4EMTCpyrCuUBjCYRgHVtqlAiB1YhiCnlsRkAAAOwAAAAAAAAAAAA==" />
										</div>
									</div>
								</form>
							</c:forEach>
						</c:if>
						<c:if
							test="${(not empty model.responseData.userList) && (model.responseData.role eq 'proOwner')}">
							<c:forEach var="element" items="${model.responseData.userList}">
								<form class="form-horizontal pkProOwnerForm" role="form">
									<input type="hidden" class="pkProOwneruserId"
										value="${element.userid }">
									<div class="form-group">
										<label class="control-label col-sm-2" for="email">UserName
										</label>
										<div class="col-sm-10">
											<input required type="text"
												class="form-control pkProOwnUserName" id="email"
												placeholder="Enter userName" value="${element.username }">
										</div>
									</div>
									<div class="form-group">
										<label class="control-label col-sm-2" for="email">Email
										</label>
										<div class="col-sm-10">
											<input required type="email"
												class="form-control pkProOwnEmail" placeholder="Enter email"
												value="${element.email }">
										</div>
									</div>
									<div class="form-group">
										<label class="control-label col-sm-2" for="email">First
											Name </label>
										<div class="col-sm-10">
											<input required type="text"
												class="form-control pkProOwnfname" placeholder="Enter email"
												value="${element.firstname }">
										</div>
									</div>
									<div class="form-group">
										<label class="control-label col-sm-2" for="email">Last
											Name </label>
										<div class="col-sm-10">
											<input required type="text"
												class="form-control pkProOwnlName"
												placeholder="Enter Last Name" value="${element.lastname }">
										</div>
									</div>
									<div class="form-group">
										<label class="control-label col-sm-2" for="email">Company
											Name </label>
										<div class="col-sm-10">
											<input required type="text"
												class="form-control pkProOwnCompanyName"
												placeholder="Enter Company Name"
												value="${element.companyname }">
										</div>
									</div>
									<div class="form-group">
										<label class="control-label col-sm-2" for="email">Tax
											Number </label>
										<div class="col-sm-10">
											<input required type="text"
												class="form-control pkProOwnTaxNo"
												placeholder="Enter Tax Number" value="${element.taxnumber }">
										</div>
									</div>
									<div class="form-group">
										<label class="control-label col-sm-2" for="email">Phone
										</label>
										<div class="col-sm-10">
											<input required type="text" class="form-control pkProPhoneno"
												placeholder="Enter Phone No" value="${element.telephone }">
										</div>
									</div>
									<div class="form-group">
										<label class="control-label col-sm-2" for="email">City
										</label>
										<div class="col-sm-10">
											<input required type="text" class="form-control pkProCity"
												placeholder="Enter City Name" value="${element.city }">
										</div>
									</div>
									<div class="form-group">
										<label class="control-label col-sm-2" for="email">Company
											Address </label>
										<div class="col-sm-10">
											<textarea required class="form-control pkProOwnaddress1"
												rows="5">${element.address1 }</textarea>
										</div>
									</div>
									<div class="form-group">
										<label class="control-label col-sm-2" for="email">Private
											Address </label>
										<div class="col-sm-10">
											<textarea required class="form-control pkProOwnaddress2"
												rows="5">${element.address2 }</textarea>
										</div>
									</div>
									<div class="form-group">
										<label class="control-label col-sm-2" for="email">Post
											Code </label>
										<div class="col-sm-10">
											<input required type="text"
												class="form-control pkProOwnerPostCode"
												placeholder="Post Code" value="${element.postcode }">
										</div>
									</div>

									<div class="form-group">
										<label class="control-label col-sm-2" for="email">mobile
										</label>
										<div class="col-sm-10">
											<input required type="text"
												class="form-control pkProOwnerMobile"
												placeholder="Mobile No" value="${element.mobile }">
										</div>
									</div>
									<div class="form-group">
										<label class="control-label col-sm-2" for="email">Vehicle
											Nmber </label>
										<div class="col-sm-10">
											<input required type="text"
												class="form-control pkProOwnerVehiclenumber"
												placeholder="Vehicle No" value="${element.vehiclenumber }">
										</div>
									</div>
									<div class="form-group">
										<label class="control-label col-sm-2" for="status">Status
										</label>
										<div class="col-sm-10">
											<div class="radio">
												<c:if test="${element.isactive eq 1}">
													<label><input type="radio" value="1" name="status"
														checked>Active</label>
												</c:if>
												<c:if test="${element.isactive eq 0}">
													<label><input type="radio" value="1" name="status">Active</label>
												</c:if>
											</div>
											<div class="radio">
												<c:if test="${element.isactive eq 0}">
													<label><input type="radio" value="0" name="status"
														checked>Deactive</label>
												</c:if>
												<c:if test="${element.isactive eq 1}">
													<label><input type="radio" value="0" name="status">Deactive</label>
												</c:if>
											</div>
										</div>
									</div>
									<div class="form-group">
										<div class="col-sm-offset-2 col-sm-10">
											<button type="button"
												class="btn btn-default pkUpdateProOwnerUserDetails">Update</button>
											<img class="pkDisplayHide pkWarningMsg"
												src="data:image/gif;base64,R0lGODlhEAAQAPIAAP///wAAAMLCwkJCQgAAAGJiYoKCgpKSkiH/C05FVFNDQVBFMi4wAwEAAAAh/hpDcmVhdGVkIHdpdGggYWpheGxvYWQuaW5mbwAh+QQJCgAAACwAAAAAEAAQAAADMwi63P4wyklrE2MIOggZnAdOmGYJRbExwroUmcG2LmDEwnHQLVsYOd2mBzkYDAdKa+dIAAAh+QQJCgAAACwAAAAAEAAQAAADNAi63P5OjCEgG4QMu7DmikRxQlFUYDEZIGBMRVsaqHwctXXf7WEYB4Ag1xjihkMZsiUkKhIAIfkECQoAAAAsAAAAABAAEAAAAzYIujIjK8pByJDMlFYvBoVjHA70GU7xSUJhmKtwHPAKzLO9HMaoKwJZ7Rf8AYPDDzKpZBqfvwQAIfkECQoAAAAsAAAAABAAEAAAAzMIumIlK8oyhpHsnFZfhYumCYUhDAQxRIdhHBGqRoKw0R8DYlJd8z0fMDgsGo/IpHI5TAAAIfkECQoAAAAsAAAAABAAEAAAAzIIunInK0rnZBTwGPNMgQwmdsNgXGJUlIWEuR5oWUIpz8pAEAMe6TwfwyYsGo/IpFKSAAAh+QQJCgAAACwAAAAAEAAQAAADMwi6IMKQORfjdOe82p4wGccc4CEuQradylesojEMBgsUc2G7sDX3lQGBMLAJibufbSlKAAAh+QQJCgAAACwAAAAAEAAQAAADMgi63P7wCRHZnFVdmgHu2nFwlWCI3WGc3TSWhUFGxTAUkGCbtgENBMJAEJsxgMLWzpEAACH5BAkKAAAALAAAAAAQABAAAAMyCLrc/jDKSatlQtScKdceCAjDII7HcQ4EMTCpyrCuUBjCYRgHVtqlAiB1YhiCnlsRkAAAOwAAAAAAAAAAAA==" />
										</div>
									</div>
								</form>
							</c:forEach>
						</c:if>
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
    $(document).ready(function() {
	$(".pkUpdateVclOwnerUserDetails").click(function() {
	    if ($('.pkVclOwnerForm').parsley().validate()) {
		var isactive = $('input[name=status]:checked').val();
		var param = {
		    "email" : $(".pkVclOwnEmail").val(),
		    "username" : $(".pkVclOwnUserName").val(),
		    "isactive" : (isactive == 1 ? true : false),
		    "mobile" : $(".pkVclOwnerMobile").val(),
		    "userid" : $(".pkVclOwneruserId").val()
		};
		$(".pkWarningMsg").show();
		pkDao.updateVclOwnerDetails(param, function(data) {
		    $(".pkWarningMsg").hide();
		    if (data && data.responseStatus == pkUtil.RESPONSE_STATUS) {
			alert("Successfully updated");
		    } else {
			alert(data.responseData);
		    }
		});
	    } else {
		alert(pkUtil.FILL_ALL_DATAS);
		$(".pkWarningMsg").hide();
	    }

	});

	$(".pkUpdateProOwnerUserDetails").click(function() {
	    if ($('.pkProOwnerForm').parsley().validate()) {
		var isactive = $('input[name=status]:checked').val();
		var param = {
		    "username" : $(".pkProOwnUserName").val(),
		    "fName" : $(".pkProOwnfname").val(),
		    "lName" : $(".pkProOwnlName").val(),
		    "email" : $(".pkProOwnEmail").val(),
		    "companyName" : $(".pkProOwnCompanyName").val(),
		    "telephoneNo" : $(".pkProPhoneno").val(),
		    "taxNo" : $(".pkProOwnTaxNo").val(),
		    "city" : $(".pkProCity").val(),
		    "address1" : $(".pkProOwnaddress1").val(),
		    "address2" : $(".pkProOwnaddress2").val(),
		    "postCode" : $(".pkProOwnerPostCode").val(),
		    "isactive" : (isactive == 1 ? true : false),
		    "mobile" : $(".pkProOwnerMobile").val(),
		    "userid" : $(".pkProOwneruserId").val(),
		    "vehiclenumber" : $(".pkProOwnerVehiclenumber").val()
		}
		$(".pkWarningMsg").show();
		pkDao.updateProOwnerDetails(param, function(data) {
		    $(".pkWarningMsg").hide();
		    if (data && data.responseStatus == pkUtil.RESPONSE_STATUS) {
			alert("Successfully updated");
		    } else {
			alert(data.responseData);
		    }
		});

	    } else {
		alert(pkUtil.FILL_ALL_DATAS);
		$(".pkWarningMsg").hide();
	    }

	})
    });
</script>