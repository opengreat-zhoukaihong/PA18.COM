<%
        //////////////////////////////////////////////////////
        // For pageList£¬ TotalPages
        //include this page you must define:
        //**************************************
        //int Const.MAXROWNUM,-----max row number to display
        //int ArrayRowLen,----array len of data to display
        //String PageListUrl----own page url
        //String FormName------form name
        //String ListParas---own page hold paras//modify in 2000-11-03
        //****if ListParas is no value then setvalue:"?a=a"
        //bean is session scope
        //include tools.js
        //
        // and begini & endi is variable for looping 
        //change "select by click" function i
        //get page is mutilpage then not to call corba,only get from bean
        //
        //author:ZhangJinQuan
        //********************************************
        //////////////////////////////////////////////////////
        
        int TotalPages=0,CurrentPage=0,LastPage=0,NextPage=0,ShowPage=0;
        int MaxRowNum = Const.MAXROWNUM;
        int PageRowLen = ArrayRowLen - 1;//the first row is colname
        String PageUrl = PageListUrl;
        String PageFormName = FormName;
        String PageListParas = ListParas;
        if (PageRowLen > MaxRowNum)
        {
            if (PageRowLen % MaxRowNum != 0)//qu yu
            {
                TotalPages = PageRowLen/MaxRowNum;
System.out.println("TotalPages:"+TotalPages);
            }
            else
            {
                TotalPages = PageRowLen/MaxRowNum - 1;
System.out.println("TotalPages111:"+TotalPages);                
            }
            String PageNow = request.getParameter("PAGE");
            if (PageNow == null)
            {
                CurrentPage = 0;
            }
            else
            {
                CurrentPage = Integer.parseInt(PageNow);
            }
            LastPage = CurrentPage - 1;
            NextPage = CurrentPage + 1;
            ShowPage = CurrentPage + 1;
            if (LastPage < 0)
                LastPage = 0;
            if (NextPage > TotalPages)
                NextPage = TotalPages;
        }
        // For pageList
        //////////////////////////////////////////////////////
%>

<%

            //////////////////////////////////////////////////////
            // For pageList£¬ TotalPages
            int begini = MaxRowNum*CurrentPage + 1;
            int endi = MaxRowNum*(CurrentPage+1) + 1;
            if (endi > PageRowLen)
                endi = PageRowLen + 1;
            //////////////////////////////////////////////////////
%>

