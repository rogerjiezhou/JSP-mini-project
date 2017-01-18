$(document).ready(function () {

});

function addUser() {
	$('tr').last().prev().after('<tr class="success"><td contenteditable="true"></td><td contenteditable="true"></td>' +
								 '<td><img style="display:none" src="images/edit.png" class="editButton" />' + 
								 '<img src="images/save.png" class="addNewButton" /></td></tr>');
}

$(document).on('click', 'img[class="editButton"]', function() {

	$(this).parent().prev().attr("contenteditable", "true");
	$(this).parent().prev().prev().attr("contenteditable", "true");
	$(this).toggle();
	$(this).next().toggle();
	$(this).parent().parent().toggleClass("success");
	
});

$(document).on('click', 'img[class="saveButton"]', function() {

	var name = $(this).parent().prev().prev().text();
	var pwd = $(this).parent().prev().text();
	var id = $(this).attr("id");
	
	$(this).parent().prev().attr("contenteditable", "false");
	$(this).parent().prev().prev().attr("contenteditable", "false");
	$(this).toggle();
	$(this).prev().toggle();
	$(this).parent().parent().toggleClass("success");
	
	var jspPage = 'updateUser.jsp?username=' + name + '&password=' + pwd + '&id=' + id;
	
	window.location.href = jspPage;
	
});

$(document).on('click', 'img[class="addNewButton"]', function() {

	var name = $(this).parent().prev().prev().text();
	var pwd = $(this).parent().prev().text();
	
	$(this).parent().prev().attr("contenteditable", "false");
	$(this).parent().prev().prev().attr("contenteditable", "false");
	$(this).attr("class", "saveButton");
	$(this).toggle();
	$(this).prev().toggle();
	$(this).parent().parent().toggleClass("success");
	
	var jspPage = 'addUser.jsp?username=' + name + '&password=' + pwd;
	
	window.location.href = jspPage;
	
});