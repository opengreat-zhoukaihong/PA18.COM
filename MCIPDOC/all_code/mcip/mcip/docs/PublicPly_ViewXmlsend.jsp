<%      
    String Area[][] = null;
    String Province[][] = null;
    String Pack[][] = null;
    String CargoType[][] = null;
    String Currency[][] = null;
    String City[][] = null;    
    String CargoCls[][] = null;
    String Insrnc[][] = null;
    
    String InsrncCde = Objects.getHt(hashData,"C_INSRNC_CDE"); 
    
    String ClsPara[] = new String[2];
    ClsPara[0] = "";
    ClsPara[1] = InsrncCde;

    try
    {

        sb.setFieldValue(Const.GET_AREA,"");
        Area = sb.getRetValueArra();

        sb.setFieldValue(Const.GET_PROVINCE,"");
        Province = sb.getRetValueArra();

        sb.setFieldValue(Const.GET_PACK,"");
        Pack = sb.getRetValueArra();

        sb.setFieldValue(Const.GET_CURRENCY,"");
        Currency = sb.getRetValueArra();

        sb.setFormPara(Const.GET_BIGCARGOTYPE,ClsPara);
        CargoCls = sb.getRetValueArra();

        sb.setFieldValue(Const.GET_SMALLCARGOTYPE,Objects.getHt(hashData,"C_CRGO_CLS"));
        CargoType = sb.getRetValueArra();
        
        sb.setFieldValue(Const.GET_CITY,Objects.getHt(hashData,"C_PROVINCE"));
        City = sb.getRetValueArra();

//        sb.setFieldValue(Const.GET_INSURANCEDEFINE,"");
        Insrnc = sb.getRetValueArra();

    }
    catch(NormalException e)
    {
 	if(NormalExceptionHandler.IsSevere(e))
 	    throw NormalExceptionHandler.Handle(e);
 	else if(NormalExceptionHandler.IsWarning(e))    
 	    WarnMsg = e.getErrDesc(); 
 	    
    }
%>
<%
	String CargoClsName = Objects.getValueCnm(CargoCls,"c_crgo_cde","c_crgo_cnm",Objects.getHt(hashData,"C_CRGO_CLS"));
	String CargoTypeName = Objects.getValueCnm(CargoType,"c_crgo_cde","c_crgo_cnm",Objects.getHt(hashData,"C_CRGO_CDE"));
	String ProvinceName = Objects.getValueCnm(Province,"c_city","c_city_cnm",Objects.getHt(hashData,"C_PROVINCE"));    
	String CityName = Objects.getValueCnm(City,"c_city","c_city_cnm",Objects.getHt(hashData,"C_CITY"));    
	String PackName = Objects.getValueCnm(Pack,"c_pack_cde","c_pack_cnm",Objects.getHt(hashData,"C_PACK_CDE"));    
	String AmtCurName = Objects.getValueCnm(Currency,"c_cur_no","c_cur_sbl",Objects.getHt(hashData,"C_AMT_CUR"));    
	String PrmCurName = Objects.getValueCnm(Currency,"c_cur_no","c_cur_sbl",Objects.getHt(hashData,"C_PRM_CUR"));    
	String InvcCurName = Objects.getValueCnm(Currency,"c_cur_no","c_cur_sbl",Objects.getHt(hashData,"C_INVC_AMT_CUR"));    
	String FrmPrtName = Objects.getValueCnm(Area,"c_ara_cde","c_ara_cnm",Objects.getHt(hashData,"C_FRM_PRT_ARA"));    
	String ToPrtName = Objects.getValueCnm(Area,"c_ara_cde","c_ara_cnm",Objects.getHt(hashData,"C_TO_PRT_ARA"));    
	String InsrncMainName = Objects.getValueCnm(Insrnc,"c_insrnc_cde","c_insrnc_cnm",InsrncCde);    
%>

