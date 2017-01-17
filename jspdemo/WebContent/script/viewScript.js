$(document).ready(function () {

});

function addUser() {
	$("#userTable").append('<form method="post" action="addUser.jsp">' + 
						   '<input type="text" name="username" />' +
						   '<input type="text" name="password" />' +
						   '<input type="submit" value="Add" /></form>');
}