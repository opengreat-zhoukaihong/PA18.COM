<%@ include file="public/up.jsp" %>
<%@ include file="public/left.jsp" %>

<jsp:useBean id="obj_data"  scope="session" class="beans.Zdatabean"/>
<!-- obj_data (.data used for next page) -->
<% 
	int i=0;
	String formpara[] = new String[4];
	String Para[]={"opr_cde","userid","clntcde","clnt_agt_flg"};

	//begin process
	for(i=0;i<Para.length;i++)
	{
		formpara[i]=request.getParameter(Para[i]);
	}
	obj_data.setdata(formpara);
%>	

<form method="POST" name="form55" action="Zsubm_del_relation.jsp">

        <p>客户帐号: <%=formpara[1]%>
        </p>
        <p align="left"> 客户编码: <%=formpara[2]%>
        </p>
        <div align="center"> 
          <input type="submit" value="删除" name="submitname">
        </div>

</form>

<%@ include file="public/bottom.jsp" %>
