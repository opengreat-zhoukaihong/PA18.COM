<%@ page  import="com.jspsmart.upload.*" contentType="text/html;charset=gb2312"%>
<jsp:useBean id="mySmartUpload" scope="page" class="com.jspsmart.upload.SmartUpload" />
<%
	// Variables
	int count=0;
	String fileName = "";
	String fileContent = "";
	// Initialization
	mySmartUpload.initialize(pageContext);

	// Upload
	mySmartUpload.upload();

	// Select each file
	for (int i=0;i<mySmartUpload.getFiles().getCount();i++){

		// Retreive the current file
		com.jspsmart.upload.File myFile = mySmartUpload.getFiles().getFile(i);

		// Save it only if this file exists
		if (!myFile.isMissing()) {

			// Save the files with its original names in a virtual path of the web server
			/**
			fileName =  new java.util.Date().getTime()+ myFile.getFileName();
			myFile.saveAs("/upload/"+ fileName);
			count ++;*/
			fileContent = myFile.getContentString();

		}

	}
	if (fileContent != null){
		request.setAttribute("fileContent",fileContent);
	}

%>
<<jsp:forward page="test.jsp" />
提交上传数据，请稍候...

<form action="test.jsp" name="nf" method="post">
	<input type="hidden" name="fileContent" value="<%=fileContent %>">
</form>
</BODY>
</HTML>