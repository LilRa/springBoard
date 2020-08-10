/**
 * 
 */

 $(function(){
	$("#searchBtn").click(function(){
		var searchWord	 = $("#searchWord").val();
		var searchKey	 = $("#searchKey").val();
		var outContent 	 = $("#outContent");
		var link 		 = $("link");
		var list = new Array();
		console.log("ddddddddddddddddddddddddd")
		$.ajax({
			type : "GET",
			url : "/search/blogList/"+searchKey+"/"+searchWord,
			contentType : "application/x-www-form-urlencoded; charset=UTF-8",
			success : function(data){
				$('#resultSet').empty();
				for(var i = 0; i < data.length; i++){
					outContent.val(data[i].title);
					link.val(data[i].link);
					$('#resultSet').append('<tr><td><a href="'+data[i].link+'" title="'+data[i].description+'"target =_blank">"'+data[i].title +'</a></td><tr><br>');
				}
			},
			error : function(){
				alert("통신실패");
			}
		});
	})
})

function enterKey(){
	if(window.event.keyCode == 13){
		$('#searchBtn').trigger('click');
	}
}