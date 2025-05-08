	
function postJson() {
	var article1 = {id: 1, content: "Article #1", creationTime: new Date()}, 
		article2 = {id: 2, content: "Article #2", creationTime: new Date()};
	var articles = [article1, article2];
		
	alert("Request Body: " + JSON.stringify(articles));
	
	/*
 	$.ajax({			// Ajax 호출을 위해  JQuery 이용
		type: "POST",
		url: "/articles",
		contentType: "application/json",
		data: JSON.stringify(articles)
	}).done(function(responseObj) {	// responseObj: JS object parsed from JSON text
		...	
	}).fail(function(jqXHR) {
		alert("ERROR: "+ JSON.stringify(jqXHR));
	});	
	*/				
	
	// Ajax 호출을 위해 Axios library 이용
	axios.post("/articles", articles)
		.then(response => response.data)
		.then(responseObj => {	// JS object parsed from JSON text in response body		
			
			$("#result").html("Response Body: <div><div>");
			$("#result > div").text(JSON.stringify(responseObj));
			
	        // 응답 데이터 사용
		   	var content = `
		   			<br>응답 데이터 이용:<br>
		   			<table>
		   			<tr><th>ID</th><th>내용</th><th>생성시각</th></tr>`;
		   	$(responseObj).each(function(){				
		   		content += `
					<tr>
						<td>${this.id}</td>
						<td>${this.content}</td>  
						<td>${new Date(this.creationTime)}</td>
					</tr>`;
            });
		   	content += "</table><br>";
			$("#result").append(content);		
	   	})
		.catch(error => { 
				alert("ERROR", error); console.error(error);
		});	
}

function postXml() {
	var today = new Date().toISOString();
	var xmlData = `<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
		<message-list>
			<message>
				<id>1</id>
				<content>메시지 #1</content>
				<crTime>${today}</crTime>
			</message>
			<message>
				<id>2</id>
				<content>메시지 #2</content>
				<crTime>${today}</crTime>
			</message>
		</message-list>`;
		
	alert("Request Body: " + xmlData);

	/*
	$.ajax({		// Ajax 호출을 위해 JQuery 이용 
		type: "POST",
		url: "/messages",
		contentType: "text/xml",
		data: xmlData,
		dataType: "xml"
	}).done(function(responseXml){ 	// XML Document node
		...	
	}).fail(function(jqXHR) {
		alert("ERROR: "+ JSON.stringify(jqXHR));
	});	
	*/
		
	// Ajax 호출을 위해 Axios library 이용 
	axios.post("messages",
			xmlData,
			{ headers: {'Content-Type': 'text/xml', 'Accept': 'application/xml'},
			  responseType: "document" })	// XML document				
		.then(response => response.data)
		.then(xmlDoc => {					// XML Document node
			
			var str = (new XMLSerializer()).serializeToString(xmlDoc);
			$("#result").html("Response Body:<div><div>");		
			$("#result > div").text(str);			
			
		   	// XML 데이터 사용
		   	var content = `
		   			<br>응답 데이터 이용:<br>
		   			<table border='1'>
		   			<tr><th>ID</th><th>내용</th><th>생성시각</th></tr>`;
		   	var messageList = $(xmlDoc).find("message"); 	// find a list of <message> elements
		   	$(messageList).each(function(){
		   		content += `
					<tr>
						<td>${$(this).find("id").text()}</td>
						<td>${$(this).find("content").text()}</td>  
						<td>${new Date($(this).find("crTime").text())}</td>
					</tr>`;
            });
		   	content += "</table><br>";
		   	$("#result").append(content);
		})
		.catch(error => { 
			alert("ERROR", error); console.error(error);
		});
}

