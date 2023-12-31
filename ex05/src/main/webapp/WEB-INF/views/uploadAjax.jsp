<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<style>
		.uploadResult {
			width: 100%;
			background-color: rgb(128, 128, 128);
		}

		.uploadResult ul {
			display: flex;
			flex-flow: row;
			justify-content: center;
			align-items: center;
		}

		.uploadResult ul li {
			list-style: none;
			padding: 10px;
			align-content: center;
			text-align: center;
		}

		.uploadResult ul li img {
			width: 100px;
		}
		.uploadResult ui li span{
			color:white;
		}
		.bigPictureWrapper {
			position: absolute;
			display: none;
			justify-content: center;
			align-items: center;
			top:0%;
			width:100%;
			height:100%;
			background-color: rgb(128, 128, 128);
			z-index: 100;
		}

		.bigPicture {
			position: relative;
			display:flex;
			justify-content: center;
			align-items: center;
		}
		.bigPicture img{
			width: 600px;
		}
	</style>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<h1>Upload with Ajax</h1>


	<div class='uploadDiv'>
		<input type='file' name='uploadFile' multiple>
	</div>

	<div class='uploadResult'>
		<ul>

		</ul>
	</div>
	<div class='bigPictureWrapper'>
		<div class='bigPicture'>

		</div>
	</div>

	<button id="uploadBtn">Upload</button>


	<script>


		$(document).ready(function (){	// 바로 실행하는 메서드
			var regex = new RegExp("(.*?)\.(exe|sh|zip|alz|txt)$");	// 파일 형식을 제한하는 인스턴스생성
			var maxSize = 5242880; //5MB 로 제한한다.

			function checkExtension(fileName, fileSize) {

				if (fileSize >= maxSize) {
					alert("파일 사이즈 초과");
					return false;
				}

				if (regex.test(fileName)) {
					alert("해당 종류의 파일은 업로드할 수 없습니다.");
					return false;
				}
				return true;
			}

			var cloneObj  = $(".uploadDiv").clone();

			$("#uploadBtn").on("click", function (e){ // id 동일한 태그의 click을 하면 실행하는 메서드
				let formData = new FormData();	// 인스턴스생성

				let inputFile = $("input[name='uploadFile']");	//변수 선언

				let files = inputFile[0].files;		// 변수 선언

				console.log(files);

				/* add fileData to formData */
				for(let i = 0; i< files.length; i++){
					if(!checkExtension(files[i].name, files[i].size)){
						return false;
					}

					formData.append("uploadFile", files[i]);
				}

				$.ajax({
					url: '/uploadAjaxAction',
					processData: false,
					contentType: false,
					data: formData,
					type: 'POST',
					dataType: 'json',
					success: function (result){
						alert("Uploaded");
						console.log(result);

						showUploadedFile(result);

						$(".uploadDiv").html(cloneObj.html());
					}
				}); //$.ajax

			});


			let uploadResult = $(".uploadResult ul");

			function showUploadedFile(uploadResultArr){

				let str = "";

				$(uploadResultArr).each(function(i, obj){

					if(!obj.image){
						let fileCallPath  = encodeURIComponent(obj.uploadPath + "/" + obj.uuid + "_" + obj.fileName);
						//str += "<li><img src='/resources/img/attach.png'>"+obj.fileName+"</li>";
						str += "<li><a href='/download?fileName="+fileCallPath+"'>"+"<img src='/resources/img/attach.png'>"+obj.fileName+"</a></li>"
					}else{

						let fileCallPath =  encodeURIComponent( obj.uploadPath+ "/s_"+obj.uuid+"_"+obj.fileName);
						str += "<li><img src='/display?fileName="+fileCallPath+"'><li>";
					}
				});
				uploadResult.append(str);
			}
		});
	</script>


</body>
</html>
