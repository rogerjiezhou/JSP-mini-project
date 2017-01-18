$(document).ready(function () {

});

function addUser() {
	$("#userTable").append('<form method="post" action="addUser.jsp">' + 
						   '<input type="text" name="username" />' +
						   '<input type="text" name="password" />' +
						   '<input type="submit" value="Add" /></form>');
}

$(document).on('click', 'img[class="editButton"]', function() {

	$(this).parent().prev().attr("contenteditable", "true");
	$(this).parent().prev().prev().attr("contenteditable", "true");
	$(this).toggle();
	$(this).next().toggle();
	
});

$(document).on('click', 'img[class="saveButton"]', function() {

	var name = $(this).parent().prev().prev().text();
	var pwd = $(this).parent().prev().text();
	var id = $(this).attr("id");
	
	console.log(name + pwd);
	$(this).parent().prev().attr("contenteditable", "false");
	$(this).parent().prev().prev().attr("contenteditable", "false");
	$(this).toggle();
	$(this).prev().toggle();
	
	var jspPage = 'updateUser.jsp?username=' + name + '&password=' + pwd + '&id=' + id;
	
	window.location.href = jspPage;
	
});