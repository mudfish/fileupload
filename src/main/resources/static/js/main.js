$(function(){
	//表单提交事件
	$('#multipleUploadForm').submit(function(event) {
		
	    var formElement = this;
	    var formData = new FormData(formElement);
	    
	    $.ajax({
	        type: "POST",
	        enctype: 'multipart/form-data',
	        url: "/uploadMultipleFiles",
	        data: formData,
	        processData: false,
	        contentType: false,
	        success: function (data) {
	        	$('#multipleFileUploadError').hide();
	            /*var content = "<p>All Files Uploaded Successfully</p>";
	            for(var i = 0; i < data.length; i++) {
	                content += "<p>DownloadUrl : <a href='" + data[i].fileDownloadUri + "' target='_blank'>" + data[i].fileDownloadUri + "</a></p>";
	            }
	            $("#multipleFileUploadSuccess").html(content);*/
	        	alert("文件上传成功！");
	            window.location.reload();
	        },
	        error: function (error) {
	            console.log(error);
	            $("#multipleFileUploadSuccess").hide();
	            $("#multipleFileUploadError").html((error && error.message) || "Some Error Occurred");
	            
	            alert("文件上传失败！");
	        }
	    });

	    event.preventDefault();
	});
	
	//查看文件列表
	$("#viewList").click(function(){
		window.open("/listPage.html");
	});
});


