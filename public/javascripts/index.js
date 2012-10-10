function onLoad() {

	$("#createProject").click(function() {
		$.ajax({
			url : "/project/create?projectName=" + $('#projectName').val() + "&emailId=" + $('#emailId').val()
		}).done(function (data) {
			console.log("Create Response", data);
			var Json = eval("(" + data + ")");
			window.location.href = "/dashboard?projectId=" + Json.id + "&emailId=" + Json.emailId;
		});
	});
}