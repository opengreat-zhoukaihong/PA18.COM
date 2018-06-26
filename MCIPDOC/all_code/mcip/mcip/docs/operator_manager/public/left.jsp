<SCRIPT LANGUAGE="JavaScript" SRC="../../art_open.js"></SCRIPT>
<%
String fCode = request.getParameter("fCode");
if (fCode != null && fCode.length() > 0){
	request.getSession(true).putValue("fCode",fCode);//save the function code
}else{
	fCode = (String)request.getSession(false).getValue("fCode");//retrieve the function code
}
%>
<table width="776" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td height="157" width="14%" valign="top" background="images/di_r05_c1.jpg"><img src="images/di_r04_c1.jpg" width="137" height="43"><br>
      <table width="100%" border="0" cellspacing="0" cellpadding="0" class="td">
        <tr> 
          <td height="6"></td>
        </tr>
		<%
		//String Result[][] = null;
		/*
				try
				{
				FormPara[0]=fCode;
					ub.setFormPara(ZConst.QUERY_PAGESLIST,FormPara);
					Result = ub.getRetValueArra();
				}
				catch(Exception e)
				{
				//     throw NormalExceptionHandler.Handle(e);
				Result = null;
				}
				*/
				Result = (String[][])request.getSession().getValue(fCode);
				
				String url = "";
				if (Result!=null && Result.length>1)
				{
					//获得所需字段的所在列的索引
					index_page_no = Objects.getColNum("C_PAGE_NO",Result);   //页面编码
					index_page_title = Objects.getColNum("C_PAGE_TITLE",Result);   //页面中文名称
					index_file_enm   = Objects.getColNum("C_FILE_ENM",Result);  //页面文件名
					index_func_cde = Objects.getColNum("C_FUNC_CDE",Result);//功能编码
					index_edit_tm = Objects.getColNum("C_EDIT_TM",Result);//最后修改时间
					for (int i = 1;i < Result.length; i++){
	  %>
        <tr > 
          <td height="21"  background="images/di_r06_c1.jpg"> 
            <div align="center"> <a href="<%=Result[i][index_file_enm]%>">&nbsp;<%=Result[i][index_page_title]%></a> </div>
          </td>
        </tr>
	  <%			}
		}%>
    
		<tr>
			<td height="21"  background="images/di_r06_c1.jpg">
				<div align="center"> <a href="index.jsp?logout=1">&nbsp;返回首页</a> </div>
			</td>
		</tr>
        <tr > 
          <td height="22"> 
            <div align="center"></div>
          </td>
        </tr>
        <tr> 
          <td height="22">&nbsp;</td>
        </tr>
      </table>
    </td>
    <td height="157" width="86%" valign="top"> <br>