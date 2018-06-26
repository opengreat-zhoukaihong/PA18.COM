<%@ include file="public/Public.jsp" %>

<jsp:useBean id="ob"  scope="session" class="beans.OperationBean"/> 
<jsp:setProperty name="ob" property="*"/>
<% 
      session.setMaxInactiveInterval(Const.TIMEOUT/1000);
%>
<%  //for get  para and to bean
      String OperationType = null;
      String TranType = null;
      String[] HomeTransit = new String[Const.HOME_TRANSIT_LEN];    
      String[] PortTransit = new String[Const.PORT_TRANSIT_LEN];
      String[] HomeTransitName = new String[Const.HOME_TRANSIT_LEN];    
      String[] PortTransitName = new String[Const.PORT_TRANSIT_LEN];
      String Temp = "";
      int i = 0;
      String Credit ="";
      String Other_Type = "";
      String[] ParaValue = null;
      int TransitLocate = 0;
      
      for(i = 0 ; i < Const.HOME_TRANSIT_LEN ; i++)
      {
          HomeTransit[i] = "";
          HomeTransitName[i] = "";
      }    
      for(i = 0 ; i < Const.PORT_TRANSIT_LEN ; i++)
      {
          PortTransit[i] = "";
          PortTransitName[i] = "";
       }   
          
      Other_Type = request.getParameter("OTHER_TYPE");
      OperationType = request.getParameter("OperationType");
      TranType =  request.getParameter("TranType");
      ob.setTranType(TranType);
 
 System.out.println("Enter mid.jsp:TranType:"+TranType);                    
      if(TranType.equals(Const.C_EXPORT_CDE))//outport
      {
          Credit = request.getParameter("Credit");
      }
      if(TranType.equals(Const.C_HOME_CDE))//home
      {
          Temp = request.getParameter("HOME_TRANSIT");
          ParaValue = Servlets.DivideStr(Temp,"&");
          TransitLocate = Integer.parseInt(ParaValue[1]);
          HomeTransit[TransitLocate] = ParaValue[0];

     }
     else
     {
          Temp = request.getParameter("PORT_TRANSIT");
          ParaValue = Servlets.DivideStr(Temp,"&");
          TransitLocate = Integer.parseInt(ParaValue[1]);
          PortTransit[TransitLocate] = ParaValue[0];

     }
 System.out.println("Enter operationselectmid.jsp:Temp:"+Temp);                         
     ob.setCredit(Credit);                
     ob.setHomeTransit(HomeTransit);    
     ob.setHomeTransitName(HomeTransitName);    
     ob.setPortTransit(PortTransit);     
     ob.setPortTransitName(PortTransitName);     
     ob.setStep(Const.STEP_BEG);    

    request.setAttribute("sessionid",Code.Encrypt(sessionId));
    
%>

<% if(OperationType.equals(Const.AGENT))
   {
%>
     <jsp:forward page="AgentList.jsp"/>
<%   
   }
   else    if(OperationType.equals(Const.OTHER))
   {
       request.setAttribute("OTHER_TYPE",Other_Type);
%>
     <jsp:forward page="ViewClause.jsp"/>
<%
   }
%>
