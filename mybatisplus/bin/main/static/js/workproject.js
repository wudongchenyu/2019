$(document).ready(function(){
	var timestamp = new Date().getTime();
	$.ajax({
		url : "/work/project/page",
		contentType : "application/json",
		data : JSON.stringify({
			timestamp : timestamp,
			pageNumber : 1,
			pageSize : 10
		}),
		dataType : "JSON",
		type : "post",
		success : function(data) {
			if (data.records) {
				console.log(data.records);
			}
		}
	});
});