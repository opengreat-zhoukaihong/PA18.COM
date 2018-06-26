<%@ include file="public/up.jsp" %>
<%@ include file="public/left.jsp"%>   
<SCRIPT LANGUAGE="JavaScript" SRC="check.js"></SCRIPT>
<%

    SessionUser mySession = sessionuser;
    String in_opr_cde = request.getParameter("opr_cde");
%>
<form name="form1"  action="updateAuthAction.jsp" onSubmit="return checkForm(this)">

  <input type=hidden name=opr_cde value="<%=in_opr_cde%>">
  
    <div align="center">               
                <table width="96%" border="1" cellspacing="0" cellpadding="0" align="center" class="td" bordercolor="#009999" bordercolorlight="#E6E6E6">
                  <tr>
                    <td bgcolor="#9DEEDE"  valign="top" width="22%">
                        操作权限：
                    </td>
                    <td   width="78%">
                    <div><table width=100% border="1" cellspacing="0" cellpadding="0" align="center" class="td" bordercolor="#009999" bordercolorlight="#E6E6E6">

             <%
             int i =0 ;
             String result[]= mySession.getfuncCode(Locate);
             String funcCodes[] =new String[result.length];
             for(i=0 ;i <result.length;i++)
             funcCodes[i]= result[i];
             String funcNames[]= mySession.getfuncName(Locate);
             String hasAuthCodes[] = request.getParameterValues("hasAuthCodes");
             for(i=0 ;i <funcCodes.length;i++){
              if(funcCodes[i]==null){ break;}
              boolean checked = false;
               if(hasAuthCodes!=null && hasAuthCodes.length>0){
                for(int j=0; j< hasAuthCodes.length; j++){
                 if(funcCodes[i].equalsIgnoreCase(hasAuthCodes[j])){
                    checked = true;
                    break;
                    }
                  }
                }
                if(i%3 ==0){%>
                   <tr width=100%>
               <%}  
                if(checked){
             %>

                      <td bgcolor="#DFF9F3" height="2"  valign="top"><input type="checkbox" name="funcCodes" checked value="<%=funcCodes[i]%>">
                      <%=funcNames[i]%> </div>
              
             <%}else{ %>
                     <td bgcolor="#DFF9F3" height="2"  valign="top"><input type="checkbox" name="funcCodes" value="<%=funcCodes[i]%>">
                      <%=funcNames[i]%>
              <% }

             }
             if(i%3!=0){
                for(;;i++){ if(i%3==0)break; %><td bgcolor="#DFF9F3" height="2"  valign="top">&nbsp;&nbsp;
             <%     }}
              i= 0;
             %>

              <tr><td colspan=3 class="td"><a href="javascript:SetChecked('funcCodes',1)">全选</a>&nbsp;&nbsp;
                      <a href="javascript:SetChecked('funcCodes',0)">清空</a>
             </table>
             </div></td></tr>

                  

             <tr>
                    <td bgcolor="#9DEEDE" valign="top" width=22%>
                        可授权管辖机构：
                    </td>
            <td width="78%">
             <table width=100% border="1" cellspacing="0" cellpadding="0" align="center" class="td" bordercolor="#009999" bordercolorlight="#E6E6E6">
               
                  <%
				  String oprCde=sessionuser.getuserId(Locate); 
				  String departList[][] = null ;
				  String myDptList[][] = null; 
				  Vector myVector = new Vector(50);
				  //GET DEPARTMENT LIST FOR CURRENT USER
				  try
				 {
					
                    
					String formPara[] = {in_opr_cde,oprCde};  
					ub.setFormPara(ZConst.QUERY_OPTRDPTLIST,formPara);
					myDptList = ub.getRetValueArra();
				 }
				 catch(NormalException e)
				 {
					if(NormalExceptionHandler.IsSevere(e))
						throw NormalExceptionHandler.Handle(e);
				 }

				 try
				 {
					                    
					String formPara[] = {oprCde};
					ub.setFormPara(ZConst.QUERY_OPTRDPTLIST ,formPara);
					departList = ub.getRetValueArra();
				 }
				 catch(NormalException e)
				 {
					if(NormalExceptionHandler.IsSevere(e))
						throw NormalExceptionHandler.Handle(e);
				 }

                 if(myDptList!=null && myDptList.length>0){ 
				      int index_dpt_cde = Objects.getColNum("C_DPT_CDE",departList);
					  for(int kk= 1 ;  kk< myDptList.length; kk++)
				       myVector.add(myDptList[kk][index_dpt_cde]);
                 } 
				 
                    
               
				 if (departList!=null && departList.length>1)
				  {

					int index_opr_cde=Objects.getColNum("C_OPR_CDE",departList);
					int index_dpt_cde=Objects.getColNum("C_DPT_CDE",departList);
					int index_dpt_cnm=Objects.getColNum("C_DPT_CNM",departList);
					int index_dpt_enm=Objects.getColNum("C_DPT_ENM",departList);
					int C_SNR_DPT = Objects.getColNum("C_SNR_DPT",departList);
					int j ;
					for (i=1,j=0;i<departList.length;i++,j++)
					{
					  String value= departList[i][index_dpt_cde]+","+ departList[i][C_SNR_DPT];
					 %>
					<tr> 
					    <td width="4%" bgcolor="#DFF9F3"><input type="checkbox" <% if(myVector.contains(departList[i][index_dpt_cde])){%> checked <%}%> name="AuthDptList" value="<%=value%>"></td>
          				<td width="96%" bgcolor="#DFF9F3"><%=departList[i][index_dpt_cnm]%></td>
					</tr>
				  <%}%>
				    <tr><td width="4%">&nbsp;</td><td width="96%">
		            <a href="javascript:SetChecked('AuthDptList',1)">全选</a> &nbsp;&nbsp;<a href="javascript:SetChecked('AuthDptList',0)">清空</a>
	  </td>
				<%}else
				  {
				  %>
				  <tr><td><font color="#FF0066">没有找到相应的机构！</font></td></tr>
				  <%
				  }
				  %>
           
             
               </tr>
               </table></div>
                </td>
               </tr>
                </table>
 </div>

  <p align="center">
    <input type="submit" value="确定" name="SubmitLog">
    <a href="authList.jsp">返回</a><br>
  </p>
</form>

<%@ include file="public/bottom.jsp"%>
<script language=JavaScript>
function checkForm(theForm){
   var i,j;
   i=0;
   var  fChecked,dChecked;
   fChecked =0;
   dChecked =0;

   if(!(theForm.AuthDptList) || !(theForm.funcCodes))return true;

   if(theForm.AuthDptList){
    
    len = theForm.elements.length;

     //for(j=0 ; j< theForm.AuthDptList.length;j++)
	 //  if(theForm.AuthDptList[j].checked)dChecked++;
	 for( i=0 ; i<len ; i++) {
      if (theForm.elements[i].name=="AuthDptList") {
	    if(theForm.elements[i].checked)dChecked++;
       }
     } 
   }
   if(theForm.funcCodes){
      //for(j=0;j< theForm.funcCodes.length;j++)
	  //   if(theForm.funcCodes[j].checked)fChecked++;

	  len = theForm.elements.length;      
	  for( i=0 ; i<len ; i++) {
      if (theForm.elements[i].name=="funcCodes") {
	    if(theForm.elements[i].checked)fChecked++;
       }
      } 
   }
   
   if(fChecked>0 && dChecked<=0){
      alert("请选择管辖机构!");
	  return false;
   }
   if(fChecked<=0 && dChecked>0){
      alert("请选择操作权限!");
	  return false;
   }
   
   return true;

  

}
 function SetChecked(name ,val) {
    dml=document.form1;
    len = dml.elements.length;
    var i=0;
    for( i=0 ; i<len ; i++) {
      if (dml.elements[i].name==name) {
        dml.elements[i].checked=val;
       }
    } 
}

</script>