function onLoad() {

	$("#signup").click(function() {
		$.ajax({
			url : "/user/create?email=" + $('#email').val() + "&username=" + $('#username').val() + "&password=" + $('#password').val()
		}).done(function (data) {
			console.log("Create Response", data);
			var Json = eval("(" + data + ")");
			setCookie("cloapp-sessionId", Json.sessionId, 14);
			//window.location.href = "/dashboard";
		});
	});
}


function setCookie(c_name,value,exdays)
{
	var exdate=new Date();
	exdate.setDate(exdate.getDate() + exdays);
	var c_value=escape(value) + ((exdays==null) ? "" : "; expires="+exdate.toUTCString());
	document.cookie=c_name + "=" + c_value;
}