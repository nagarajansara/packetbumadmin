var pkDao = new PkDAO();

function PkDAO() {
    this.CONTEXT_NAME = "paketbumadmin";
    this.DOMAIN_NAME = window.location.host;
    this.HTTP_URL_PREFIX = "http://" + window.location.host + "/"
	    + this.CONTEXT_NAME + "/";
    this.HTTPS_URL_PREFIX = "https://" + window.location.host + "/"
	    + this.CONTEXT_NAME + "/";
    this.API_PREFIX = this.HTTP_URL_PREFIX + "api";

    this.RESPONSE_CACHE = {};

    this.UPDATE_VCLOWNER_DETAILS = this.API_PREFIX
	    + "/admin/updateVclOwnerDetails.json";
    this.UPDATE_PRO_OWNER_DETAILS = this.API_PREFIX
	    + "/admin/updateProOwnerDetails.json";

    this.TOTAL_RECORDS_PER_PAGE = 5;
    this.INITIAL_USER_CREDITS = 0;

    this.CACHE_MAP = {};

};
PkDAO.prototype.updateVclOwnerDetails = function(param, cbk) {
    var tObj = this;
    tObj.getData(tObj.UPDATE_VCLOWNER_DETAILS, param, cbk);
};
PkDAO.prototype.updateProOwnerDetails = function(param, cbk) {
    var tObj = this;
    tObj.getData(tObj.UPDATE_PRO_OWNER_DETAILS, param, cbk);
};
PkDAO.prototype.getData = function(url, postParams, callback, isCacheMap,
	isParse) {
    var tObj = this, cbk = function(data, isCacheMap) {
	if (data && data.model) {
	    if (!isParse) {

	    }
	    console.log("isCacheMap :" + isCacheMap);
	    if (isCacheMap) {
		tObj.CACHE_MAP[url] = data;
		console.log(tObj.CACHE_MAP[url]);
	    }
	    data = data.model;
	}
	callback(data);
    }, ajaxConfig = {
	"type" : (postParams ? "POST" : "GET"),
	"url" : url,
	"dataType" : "json",
	"data" : postParams,
	error : function(err) {

	},
	success : function(data) {
	    cbk(data, isCacheMap);
	},
	statusCode : {
	    404 : function() {
		alert("Check your internet connection");
	    }
	}

    };
    if (!tObj.CACHE_MAP[url]) {
	jQuery.ajax(ajaxConfig);
    } else {
	cbk(tObj.CACHE_MAP[url], isCacheMap);
    }

};
PkDAO.prototype.parseJSON = function(jsonData) {
    try {
	jsonData = JSON.parse(jsonData);
    } catch (ex) {
	console.log(ex);
    }
    return jsonData;
};
