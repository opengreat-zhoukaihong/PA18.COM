
<%
   System.out.println("1111111111111111111111111111111");

    String Area[][] = null;
    String Province[][] = null;
    String Pack[][] = null;
    String CargoType[][] = null;
    String CargoCls[][] = null;
    String Currency[][] = null;
    String City[][] = null;

   //for get bigCls add parameter :insrnc_code
    String ClsPara[] = new String[2];
    ClsPara[0] = "";
    ClsPara[1] = Servlets.GetInsrnc(TranType,HomeTransit);

    DefaultProvince = Objects.getHt(hashData,"C_PROVINCE");
    DefaultCls = Objects.getHt(hashData,"C_CRGO_CLS");
    System.out.println("222222222222222222222222222221111111111111111111111111111111");
    try
    {

        sb.setFieldValue(Const.GET_AREA,"");
        Area = sb.getRetValueArra();

        sb.setFieldValue(Const.GET_PROVINCE,"");
        Province = sb.getRetValueArra();

        sb.setFieldValue(Const.GET_PACK,"");
        Pack = sb.getRetValueArra();

        sb.setFormPara(Const.GET_BIGCARGOTYPE,ClsPara);
        CargoCls = sb.getRetValueArra();

        sb.setFieldValue(Const.GET_CURRENCY,"");
        Currency = sb.getRetValueArra();
    }
    catch(NormalException e)
    {
 	if(NormalExceptionHandler.IsSevere(e))
 	    throw NormalExceptionHandler.Handle(e);
 	else if(NormalExceptionHandler.IsWarning(e))
 	    WarnMsg = e.getErrDesc();

    }

	System.out.println("3333333333333333333333333333331111111111111111111111111111111");

	int AreaLen = Servlets.getLen(Area);
	int ProvinceLen = Servlets.getLen(Province);
	int PackLen = Servlets.getLen(Pack);
	int CargoClsLen = Servlets.getLen(CargoCls);
	int CurrencyLen = Servlets.getLen(Currency);

	int c_ara_cde = Objects.getColNum("c_ara_cde",Area);
	int c_ara_cnm = Objects.getColNum("c_ara_cnm",Area);
	int c_ara_enm = Objects.getColNum("c_ara_enm",Area);
	int c_city = Objects.getColNum("c_city",Province);
	int c_city_cnm = Objects.getColNum("c_city_cnm",Province);
	int c_cur_no = Objects.getColNum("c_cur_no",Currency);
	int c_cur_cnm = Objects.getColNum("c_cur_cnm",Currency);
	int n_chg_rte = Objects.getColNum("n_chg_rte",Currency);
	int c_crgo_cls = Objects.getColNum("c_crgo_cde",CargoCls);
	int c_crgo_cnm = Objects.getColNum("c_crgo_cnm",CargoCls);
    if(DefaultCls.equals("") & CargoClsLen > 1)
    {
       DefaultCls = CargoCls[1][c_crgo_cls];
    }
System.out.println("***********DefaultCls*************:"+DefaultCls);
    if(DefaultProvince.equals("") & ProvinceLen > 1)
    {
       DefaultProvince = Province[1][c_city];
    }

    try
    {
        sb.setFieldValue(Const.GET_SMALLCARGOTYPE,DefaultCls);
        CargoType = sb.getRetValueArra();
    }
    catch(NormalException e)
    {
 	if(NormalExceptionHandler.IsSevere(e))
 	    throw NormalExceptionHandler.Handle(e);
 	else if(NormalExceptionHandler.IsWarning(e))
 	    WarnMsg = e.getErrDesc();

    }


	try
    {
        sb.setFieldValue(Const.GET_CITY,DefaultProvince);
        City = sb.getRetValueArra();
    }
    catch(NormalException e)
    {
 	if(NormalExceptionHandler.IsSevere(e))
 	    throw NormalExceptionHandler.Handle(e);
 	else if(NormalExceptionHandler.IsWarning(e))
 	    WarnMsg = e.getErrDesc();

    }
	System.out.println("City:"+City);
        if(City == null)
        {
       		DefaultProvince = Province[1][c_city];
	    try
	    {
	        sb.setFieldValue(Const.GET_CITY,DefaultProvince);
	        City = sb.getRetValueArra();
	    }
	    catch(NormalException e)
	    {
	 	if(NormalExceptionHandler.IsSevere(e))
	 	    throw NormalExceptionHandler.Handle(e);
	 	else if(NormalExceptionHandler.IsWarning(e))
	 	    WarnMsg = e.getErrDesc();

	    }

        }

	int CargoTypeLen = Servlets.getLen(CargoType);
	int CityLen = Servlets.getLen(City);
   //modify in 2000-11-07 special for new ply currency

   if(IsNewPlyApp)
   {
      hashData.put("C_INVC_AMT_CUR",DefaultCur[0]);
      hashData.put("C_AMT_CUR",DefaultCur[0]);
      hashData.put("C_PRM_CUR",DefaultCur[0]);
   }

   if(step == Const.STEP_BEG || step == Const.STEP_REP)
   {
      //special for cur copy:
      hashData.put("C_INVC_AMT_CUR_TEMP",Objects.getHt(hashData,"C_INVC_AMT_CUR"));
      hashData = Servlets.PutCnm(hashData,"C_AMT_CUR","C_AMT_CUR_CNM",Currency,"c_cur_no","c_cur_cnm");
      hashData = Servlets.PutCnm(hashData,"C_PRM_CUR","C_PRM_CUR_CNM",Currency,"c_cur_no","c_cur_cnm");
    }
System.out.println("*****************************C_PRM_CUR***"+Objects.getHt(hashData,"C_PRM_CUR"));
   String Sdate = ServTool.getSysDate(2);



System.out.println("44444444444444444444444444444444441111111111111111111111111111111");




%>