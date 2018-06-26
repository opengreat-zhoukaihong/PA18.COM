<%    

      String C_APP_NME = ""; //投保人
      String C_INSRNT_NME = "";//被保人姓名
      String C_PLACE = "";//送达祥细地址
      String C_CONTACT_NAME= "";//联系人
      String C_CONTACT_PHONE = "";//联系电话
      String C_CONTACT_FAX = "";//联系传真
      String C_CONTACT_EMAIL= "";//
	  String C_ZIP_CDE ="";
	  String C_CREDIT_ID = "";//信用证标识 
	  String C_CRGO_CLS = ""; //货物大类
	  String C_CRGO_CDE = "";//货物编码
      String C_CRGO_NAME = "";//货物名称
      String C_CRGO_DESC= "";//品名描述
      String C_PACK_CNM= "";//包装描述
      String C_AMOUNT= "";//数量及单位
      String C_MARK= "";//唛头
      String N_INVC_AMT = "";//发票金额
      String C_INVC_AMT_CUR  = "";//发票币种
	  String C_AMT_CUR_CNM = "";//保额币种名
	  String C_AMT_CUR = "";//保额币种
	  String C_PRM_CUR =  "";//保费币种
	  String N_RATE = "";//费率
	  String N_AMT = "";//保险金额
	  String N_PRM = "";//保费
      String C_INVC_NO ="";//发票号码
      String C_RECEIPT_NO ="";//提单号
      String C_FRM_PRT_ARA ="";//起运国
      String C_FROM_PRT=  "";  //起运港
      String C_PASS_PRT = "";//途经港
      String C_TO_PRT_ARA = "";//到达国
      String C_TO_PRT = "";//到达港
      String C_SAIL_NO = "";//航次
      String C_CONTAINER = "";//集装箱方氏
      String t_insrnc_bgn_tm = "";//起运日期
	  String C_NO_REPAY = "";//免赔
	  String C_REMARK ="";//备注      
      String birth_year="";  //plyEdrAppCrgoInfo.c_prn_frm开航年
      String birth_month=""; //开航月
      String birth_day=""; //开航年日 
	  String C_INSRNC_CDE = "";//险种
      String C_UNDR_CNDTN = "";//承保条件
	  String C_LOST_DESC = "";//赔付记录
	  String C_OPEN_COVER_NO  = "";//Open Cover 协议号
	  String C_ADD_RISK = "";//其他附加险
	  String OLD_PRM_CUR =""; //旧保费币种


	  String N_PRM1 ="";//原保费
	  String N_PRM_VAR ="";//保费变化
	  String N_PRM_CHANGE= "";//保费变化百分比

	  String C_EDR_CTNT = "";//批改原因

	  String C_PROVINCE ="";
	  String C_CITY ="";
	  String Currency_NAME = "";

	  String C_CTNT ="";

	  String tempstr1 = "";
	  String tempstr2 = "";

      String paraNames[]= { "C_APP_NME" ,          "C_INSRNT_NME",      "C_PLACE",
                            "C_CONTACT_NAME",      "C_CONTACT_PHONE",   "C_CONTACT_FAX",
                            "C_CONTACT_EMAIL" ,    "C_CREDIT_ID",       "C_CRGO_CLS",
	                        "C_CRGO_CDE",          "C_CRGO_NAME",       "C_CRGO_DESC",
                            "C_PACK_CNM",          "C_AMOUNT",          "C_MARK",
                            "N_INVC_AMT",          "C_INVC_AMT_CUR",    "C_AMT_CUR_CNM",
	                        "C_AMT_CUR",           "C_PRM_CUR",         "N_RATE",
	                        "N_AMT",               "N_PRM",             "C_INVC_NO",
                            "C_RECEIPT_NO",        "C_FRM_PRT_ARA",     "C_FROM_PRT",
                            "C_PASS_PRT",          "C_TO_PRT_ARA",      "C_TO_PRT",
                            "C_SAIL_NO",           "C_CONTAINER",       "t_insrnc_bgn_tm",
	                        "C_NO_REPAY",          "C_REMARK",          "C_INSRNC_CDE",
                            "C_UNDR_CNDTN",        "C_LOST_DESC",       "C_ADD_RISK",
                            "C_OPEN_COVER_NO",     "C_MAIN_INSURANCE1", "C_MAIN_INSURANCE2",
                            "C_MAIN_INSURANCE3",   "C_MAIN_INSURANCE4", "C_ADD_INSURANCE0",
							"C_ADD_INSURANCE1" ,   "C_ADD_INSURANCE2" , "C_ADD_INSURANCE3",	
							"C_ADD_INSURANCE4",    "C_ADD_INSURANCE5",  "C_ADD_INSURANCE6",  
							"C_ADD_INSURANCE7",    "C_ADD_INSURANCE8",  "C_ADD_INSURANCE9",  
							"C_ADD_INSURANCE10",   "C_ADD_INSURANCE11", "C_ADD_INSURANCE12", 
                            /*"C_ADD_INSURANCE13", */
							"OLD_PRM_CUR",       "N_PRM1",             	"N_PRM_VAR" ,
							"N_PRM_CHANGE",      "C_EDR_CTNT"    ,    	"C_ZIP_CDE",           
							"C_PRN_FRM",         "C_PAY_ADDR",          "C_SRVY_ADDR" 
						   };
	                        
      
	  String result[][] = null;
	  String paras[][] = null ;


	  String CODES[] = {           "01",    "02",    "03",   
	                               "04",    "06",    "05",
								   "02",    "07",    "08",
								   "09",    "36",    "37",
								   "39",    "40",    "42",
								   "18",    "20",   /* "22",*/
								   "23",    "24",    "25",    
								   "27",    "28",    "29",    
								   "30",    "31",    "32",    
								   "33",    "34"
	                          };

      String NAMES[] = {          "基本险",             "综合险",      "航空运输险",  
	                              "航空运输一切险",     "平安险",      "水渍险",
								  "一切险",             "I.C.C.(A)",   "I.C.C.(B)",
								  "I.C.C.(C)",          "陆运险",      "陆运一切险",
								  "航空险",             "航空一切险",   "邮包险",
								  "罢工险",             "战争险",      /* "仓-仓条款",*/
								  "偷窃、提货不着险",   "碰损、破碎险", "渗漏险",       
								  "短量险",             "包装破裂险",   "淡水、雨淋险", 
								  "混杂、沾污险",       "串味险",       "受潮受热险",   
								  "钩损险",             "锈损险"             
                              };
      String MAINCODES = "01&02&03&04&06&05&07&08&09&36&37&39&40&42";

	 
	  
	    System.out.println("GET REQUEST NOT STEP =BEG Yes, I am there EdrapPre.jsp");
	     String temp="";
		 paras = new String[2][66];//[paraNames.length];
         for(i= 0 ;i< paraNames.length ;i++){
            paras[0][i] = paraNames[i];
			//System.out.println(i +" "+ paraNames[i]);
		    temp = request.getParameter(paraNames[i]);
		    if(temp==null)temp="";
		       paras[1][i] = temp.trim();
         }
		System.out.println("continue doing in EdrApppre.jsp ");
		birth_year = request.getParameter("birth_year");
		birth_month = request.getParameter("birth_month");
		birth_day = request.getParameter("birth_day");
		t_insrnc_bgn_tm = birth_year + "-" + birth_month + "-" + birth_day;
		paras[1][32] = t_insrnc_bgn_tm;
		double n_rate = Objects.ToDouble(paras[1][20]);
        n_rate = n_rate/100 ;
		paras[1][20] = n_rate +"";
		System.out.println("In edrapp get request n_rate:"+n_rate);
		
        

		paras[0][7]= "C_CREDIT_ID";
		paras[1][7]= pmb.plyEdrAppCrgoInfo.c_credit_id;

	 

    try{
      System.out.println("try to set pmb data in edrappPre.jsp");
      ob.setFormData(paras);
	  hashData = ob.getHashData();
    }catch(NormalException e){
	 	    if(NormalExceptionHandler.IsSevere(e))
	 	     throw NormalExceptionHandler.Handle(e);
	 	      else if(NormalExceptionHandler.IsWarning(e))
	 	      WarnMsg = e.getErrDesc();
	 }
	  
	  C_APP_NME = Objects.getHt(hashData,"C_APP_NME"); //投保人
      C_INSRNT_NME = Objects.getHt(hashData,"C_INSRNT_NME");//被保人姓名
      C_PLACE = Objects.getHt(hashData,"C_PLACE");//送达祥细地址
      C_CONTACT_NAME= Objects.getHt(hashData,"C_CONTACT_NAME");//联系人
      C_CONTACT_PHONE = Objects.getHt(hashData,"C_CONTACT_PHONE").trim();//联系电话


      C_CONTACT_FAX = Objects.getHt(hashData,"C_CONTACT_FAX").trim();//联系传真
      C_CONTACT_EMAIL= Objects.getHt(hashData,"C_CONTACT_EMAIL").trim();//
	  C_CREDIT_ID = Objects.getHt(hashData,"C_CREDIT_ID");//信用证标识 
	  C_CRGO_CLS = Objects.getHt(hashData,"C_CRGO_CLS"); //货物大类
	  C_CRGO_CDE = Objects.getHt(hashData,"C_CRGO_CDE");//货物编码
      C_CRGO_NAME = Objects.getHt(hashData,"C_CRGO_NAME");//货物名称
      C_CRGO_DESC= Objects.getHt(hashData,"C_CRGO_DESC");//品名描述
      C_PACK_CNM= Objects.getHt(hashData,"C_PACK_CNM");//包装描述
      C_AMOUNT= Objects.getHt(hashData,"C_AMOUNT");//数量及单位
      C_MARK= Objects.getHt(hashData,"C_MARK");//唛头
      N_INVC_AMT = Objects.getHt(hashData,"N_INVC_AMT");//发票金额
      C_INVC_AMT_CUR  = Objects.getHt(hashData,"C_INVC_AMT_CUR");//发票币种

	  C_AMT_CUR_CNM = Objects.getHt(hashData,"C_AMT_CUR_CNM");//保额币种名


	  C_AMT_CUR = Objects.getHt(hashData,"C_AMT_CUR");//保额币种
	  C_PRM_CUR =  Objects.getHt(hashData,"C_PRM_CUR");//保费币种
	  OLD_PRM_CUR = Objects.getHt(hashData,"OLD_PRM_CUR");//旧保费币种

	  N_RATE = Objects.getHt(hashData,"N_RATE");//费率


	  N_AMT = Objects.getHt(hashData,"N_AMT");//保险金额
	  N_PRM = Objects.getHt(hashData,"N_PRM");//保费
      C_INVC_NO = Objects.getHt(hashData,"C_INVC_NO");//发票号码
      C_RECEIPT_NO = Objects.getHt(hashData,"C_RECEIPT_NO");//提单号
      C_FRM_PRT_ARA = Objects.getHt(hashData,"C_FRM_PRT_ARA");//起运国
      C_FROM_PRT=  Objects.getHt(hashData,"C_FROM_PRT");  //起运港
      C_PASS_PRT = Objects.getHt(hashData,"C_PASS_PRT");//途经港
      C_TO_PRT_ARA = Objects.getHt(hashData,"C_TO_PRT_ARA");//到达国
      C_TO_PRT = Objects.getHt(hashData,"C_TO_PRT");//到达港
      C_SAIL_NO = Objects.getHt(hashData,"C_SAIL_NO");//航次
      C_CONTAINER = Objects.getHt(hashData,"C_CONTAINER");//集装箱方氏
      t_insrnc_bgn_tm = Objects.getHt(hashData,"t_insrnc_bgn_tm");//起运日期
	  C_NO_REPAY = Objects.getHt(hashData,"C_NO_REPAY");//免赔
	  C_REMARK =Objects.getHt(hashData,"C_REMARK");//备注      
	  C_INSRNC_CDE = Objects.getHt(hashData,"C_INSRNC_CDE");//险种
      C_UNDR_CNDTN = Objects.getHt(hashData,"C_UNDR_CNDTN");//承保条件
	  C_LOST_DESC = Objects.getHt(hashData,"C_LOST_DESC");//赔付记录
	  C_OPEN_COVER_NO  = Objects.getHt(hashData,"C_OPEN_COVER_NO");//Open Cover 协议号
	  C_ADD_RISK = Objects.getHt(hashData,"C_ADD_RISK");//其他附加险
	  C_PROVINCE = pmb.plyPlyAppNetInfo.c_province;
	  C_CITY = pmb.plyPlyAppNetInfo.c_city;
	  N_PRM1 = Objects.getHt(hashData,"N_PRM1");
	  N_PRM_VAR = Objects.getHt(hashData,"N_PRM_VAR");
	  N_PRM_CHANGE = Objects.getHt(hashData, "N_PRM_CHANGE");
	  C_EDR_CTNT = Objects.getHt(hashData,"C_EDR_CTNT");

	  System.out.println("C_EDR_CTNT edrappPre.jsp :"+C_EDR_CTNT);
	  System.out.println("N_RATE.......EdrAppPre.jsp "+N_RATE);
  %>    
 