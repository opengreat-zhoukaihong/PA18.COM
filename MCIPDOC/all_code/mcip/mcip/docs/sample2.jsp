<%@ page language="java" import="com.jspsmart.upload.*"%>
<jsp:useBean id="mySmartUpload" scope="page" class="com.jspsmart.upload.SmartUpload" />

<HTML>
<BODY BGCOLOR="white">

<H1>jspSmartUpload : Sample 2</H1>
<HR>

<%
	
	// Variables
	int count=0;        

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
			//myFile.saveAs("/data1/pa18/nul/mcip/upload/" +new java.util.Date().getTime());
			out.println("STRING:<pre>"+myFile.getContentString()+"</pre><br>");
			// myFile.saveAs("/upload/" + myFile.getFileName(), mySmartUpload.SAVE_VIRTUAL);

			// sample with a physical path
			// myFile.saveAs("c:\\temp\\" + myFile.getFileName(), mySmartUpload.SAVE_PHYSICAL);

			//  Display the properties of the current file
			out.println("FieldName = " + myFile.getFieldName() + "<BR>");
			out.println("Size = " + myFile.getSize() + "<BR>");
			out.println("FileName = " + myFile.getFileName() + "<BR>");
			out.println("FileExt = " + myFile.getFileExt() + "<BR>");
			out.println("FilePathName = " + myFile.getFilePathName() + "<BR>");
			out.println("ContentType = " + myFile.getContentType() + "<BR>");
			out.println("ContentDisp = " + myFile.getContentDisp() + "<BR>");
			out.println("TypeMIME = " + myFile.getTypeMIME() + "<BR>");
			out.println("SubTypeMIME = " + myFile.getSubTypeMIME() + "<BR>");

			count ++;

		}

	}

	// Display the number of files which could be uploaded 
	out.println("<BR>" + mySmartUpload.getFiles().getCount() + " files could be uploaded.<BR>");

	// Display the number of files uploaded 
	out.println(count + " file(s) uploaded.");


%>
</BODY>
</HTML>
