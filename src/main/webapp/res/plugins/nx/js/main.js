

function getMenuContent(obj){
	var parentLi = $(obj).closest('li');
	var destUrl = parentLi.attr('contextUrl');
	var entityClass = parentLi.attr('entityClass');
	destUrl = destUrl+"?entityClass="+entityClass+" #content-wrapper";
	console.log(destUrl);
	console.log(entityClass);
	$(".content-wrapper").load(destUrl,function(){
		alert();
	});
	
}


function editEntity(entity,id){
	alert('open edit page');
}



function deleteEntity(entity,id){
	alert('disabled edit page');
}