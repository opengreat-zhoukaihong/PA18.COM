<%
        //////////////////////////////////////////////////////
        // For pageList， TotalPages
        if (TotalPages > 0)
        {//forward(Form,field) 
%>
                <input type=hidden name="PAGE" value=0>

                <input type=hidden name="TempForFunc" value="">                
                [<%if(begini != 1){%><a href="<%=PageUrl+PageListParas%>&PAGE=0" onclick="setField(PAGE,'0');ChgAction(<%=PageFormName%>,'<%=PageUrl%>');forward(<%=PageFormName%>,TempForFunc);return true;"><%}%>首  页<%if(begini != 1){%></a><%}%>]
                [<%if(begini != 1){%><a href="<%=PageUrl+PageListParas%>&PAGE=<%=LastPage%>" onclick="setField(PAGE,'<%=LastPage%>');ChgAction(<%=PageFormName%>,'<%=PageUrl%>');forward(<%=PageFormName%>,TempForFunc);return true;"><%}%>上一页<%if(begini != 1){%></a><%}%>]
                &nbsp;&nbsp;显示<%=ShowPage%>/<%=TotalPages+1%>&nbsp;&nbsp;
                [<%if(endi != ArrayRowLen){%><a href="<%=PageUrl+PageListParas%>&PAGE=<%=NextPage%>" onclick="setField(PAGE,'<%=NextPage%>');ChgAction(<%=PageFormName%>,'<%=PageUrl%>');forward(<%=PageFormName%>,TempForFunc);return true;"><%}%>下一页<%if(endi != ArrayRowLen){%></a><%}%>]
                [<%if(endi != ArrayRowLen){%><a href="<%=PageUrl+PageListParas%>&PAGE=<%=TotalPages%>" onclick="setField(PAGE,'<%=TotalPages%>');ChgAction(<%=PageFormName%>,'<%=PageUrl%>');forward(<%=PageFormName%>,TempForFunc);return true;"><%}%>尾  页<%if(endi != ArrayRowLen){%></a><%}%>]                                


<%
        }
        // For pageList
        //////////////////////////////////////////////////////
%>
