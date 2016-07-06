
/**
 * 事件處理.menu異動.將網址keep 
 * **/
window.onhashchange = function(){
	
	if(location.hash=='') reloadPortal('/main');
	if(location.hash){
		var hash = location.hash.substring(1);
		goHistiry(hash);
	}
}

function reloadPortal(){
	location.reload();
}

/**
 * 處理圖片上傳
 * **/
function uploadImage(){
	var oMyForm = new FormData();
	oMyForm.append("file", empImg.files[0]);
	var csrf = $("input[name=_csrf]").val();
	console.log(csrf);
	$.ajax({
	  url: './imageUploadController',
	  data: oMyForm,
	  dataType: 'text',
	  processData: false,
	  contentType: false,
	  type: 'POST',
	  beforeSend: function(xhr) {
          xhr.setRequestHeader('X-CSRF-Token',csrf)
      },
	  success: function(data){
		  var res = $.parseHTML(data);
		  $('#previewImg').html(data);
		  $('#image\\.id').val(res[0].id);
	  }
	});
}


function upload(obj){
	var csrf = $("input[name=_csrf]").val();
	$(obj).click(function(e){
		var filename = $("input[type=file]").val();
		var oMyForm = new FormData();
		oMyForm.append("file", filename);
	    $.ajax({
	    	url: '/upload2',   
	        data: oMyForm,
	        dataType: 'text',
	        processData: false,
	        contentType: false,
	        type: "POST",
	        beforeSend: function(xhr) {
	            xhr.setRequestHeader('X-CSRF-Token',csrf)
	        },
	        success: function(data){
	          $('#result').html(data);
	        }
	    
	        
	    });
		e.preventDefault();
		e.unbind();
	});
	$(obj).submit();
	
}


function goHistiry(hash){
	var destUrl = "./"+hash+" #content-wrapper";
	$("#content").load(destUrl,function( response, status, xhr ) {
		reponseHandler(response,xhr,status);
	});
}

function reponseHandler(response,xhr,status){
	if ( status == "error" ) {
		if(xhr.status=='404'){load404Page();}
		if(xhr.status=='500'){load500Page(response,xhr);}
	}
}

function getMenuContent(obj){
	var parentLi = $(obj).closest('li');
	var targetUrl = parentLi.attr('contextUrl');
	var entityClass = parentLi.attr('entityClass');
	var destUrl = targetUrl+"?entityClass="+entityClass+" #content-wrapper";
	console.log(destUrl);
	console.log(entityClass);
	$("#content").load(destUrl,function( response, status, xhr ) {
		reponseHandler(response,xhr,status);
		window.location.hash = targetUrl;
		
	});
}


function load404Page(){
	var destUrl = "./pageNotFound #content-wrapper";
	$("#content").load(destUrl);
}

function load500Page(resonse,xhr){
	var destUrl = "./serverError #content-wrapper";
	$("#content").load(destUrl,function( response) {
		$("#content #errorMessage").text(xhr.responseText);
	});
	
	//$("#errorMessage").html(xhr)
}

function redirectContentWrapper(obj){
	var targetUrl = $(obj).attr('contextUrl');
	var destUrl = targetUrl+" #content-wrapper";
	console.log(destUrl);
	$("#content").load(destUrl,function( response, status, xhr ) {
		reponseHandler(response,xhr,status);
		window.location.hash = targetUrl;
	});
	console.log("sucess");

}


function editEntity(entity,id){
	alert('open edit page');
}

function sumbitPage(obj){
	var $form = $("form[action][id]");
	console.log($($form).parents("form"));
	console.log($form);
	$($form).submit(function(e){
		var postData = $(this).serializeArray();
		var formURL = $(this).attr("action");
		console.log(formURL);
		console.log(postData);
		$.ajax({
			url : formURL,
			type: "POST",
			data : postData,
		    success : function(result) {
		    	console.log(result)
		    	alert('Save Sucessful');
		    	back();
		    },
		    error : function(jqXHR, textStatus, errorThrown) {
		    	load500Page(jqXHR)
		        alert(jqXHR.status + " " + jqXHR.responseText);
		    }
		});
		e.preventDefault();
		e.unbind();
	});
	$($form).submit();
}

function back(){
	window.history.back();
}



	
	