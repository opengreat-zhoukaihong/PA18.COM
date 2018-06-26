#include "typeconvt.h"
#include "AiConvert.h"

#include "corgclnt.h"



int StrToStruCltOrgClntInfo(char** ppstring, int *plenStr, cltOrgClntInfoStru *pstruCltOrgClntInfo)
{
	int i, j;
	if(*ppstring==NULL) return 1;

	i=j=0;
	do
	{
		j++; if(ToStringField(ppstring, plenStr, (pstruCltOrgClntInfo->sClntCde     ), C_CLNT_CDE_LEN      )==FALSE) break;    else i++;
		j++; if(ToStringField(ppstring, plenStr, (pstruCltOrgClntInfo->sDptCde      ), C_DPT_CDE_LEN       )==FALSE) break;    else i++;
		j++; if(ToStringField(ppstring, plenStr, (pstruCltOrgClntInfo->sClntNme     ), C_CLNT_NME_LEN      )==FALSE) break;    else i++;
		j++; if(ToStringField(ppstring, plenStr, (pstruCltOrgClntInfo->sChnAbr      ), C_CHN_ABR_LEN       )==FALSE) break;    else i++;
		j++; if(ToStringField(ppstring, plenStr, (pstruCltOrgClntInfo->sAuthMrk     ), C_AUTH_MRK_LEN      )==FALSE) break;    else i++;
		j++; if(ToStringField(ppstring, plenStr, (pstruCltOrgClntInfo->sBrdEnm      ), C_BRD_ENM_LEN       )==FALSE) break;    else i++;
		j++; if(ToStringField(ppstring, plenStr, (pstruCltOrgClntInfo->sRgstNo      ), C_RGST_NO_LEN       )==FALSE) break;    else i++;
		j++; if(ToStringField(ppstring, plenStr, (pstruCltOrgClntInfo->sTaxNo       ), C_TAX_NO_LEN        )==FALSE) break;    else i++;
		j++; if(ToDoubleField(ppstring, plenStr, &(pstruCltOrgClntInfo->fRgstMny    )                      )==FALSE) break;    else i++; 
		j++; if(ToStringField(ppstring, plenStr, (pstruCltOrgClntInfo->sChief       ), C_CHIEF_LEN         )==FALSE) break;    else i++;
		j++; if(ToDoubleField(ppstring, plenStr, &(pstruCltOrgClntInfo->fEmlyNum    )                      )==FALSE) break;    else i++;  
		j++; if(ToStringField(ppstring, plenStr, (pstruCltOrgClntInfo->sOwnershipCde), C_OWNERSHIP_CDE_LEN )==FALSE) break;    else i++;
		j++; if(ToStringField(ppstring, plenStr, (pstruCltOrgClntInfo->sOrgzTypCde  ), C_ORGZ_TYP_CDE_LEN  )==FALSE) break;    else i++;
		j++; if(ToStringField(ppstring, plenStr, (pstruCltOrgClntInfo->sTrdCde      ), C_TRD_CDE_LEN       )==FALSE) break;    else i++;
		j++; if(ToStringField(ppstring, plenStr, (pstruCltOrgClntInfo->sAraCde      ), C_ARA_CDE_LEN       )==FALSE) break;    else i++;
		j++; if(ToStringField(ppstring, plenStr, (pstruCltOrgClntInfo->sClntScleCde ), C_CLNT_SCLE_CDE_LEN )==FALSE) break;    else i++;
		j++; if(ToStringField(ppstring, plenStr, (pstruCltOrgClntInfo->sScaleCde    ), C_SCALE_CDE_LEN     )==FALSE) break;    else i++;
		j++; if(ToStringField(ppstring, plenStr, (pstruCltOrgClntInfo->sUprDptCde   ), C_UPR_DPT_CDE_LEN   )==FALSE) break;    else i++;
		j++; if(ToStringField(ppstring, plenStr, (pstruCltOrgClntInfo->sImptClntCde ), C_IMPT_CLNT_CDE_LEN )==FALSE) break;    else i++;
		j++; if(ToStringField(ppstring, plenStr, (pstruCltOrgClntInfo->sCntctPrsnNme), C_CNTCT_PRSN_NME_LEN)==FALSE) break;    else i++;
		j++; if(ToStringField(ppstring, plenStr, (pstruCltOrgClntInfo->sTel         ), C_TEL_LEN           )==FALSE) break;    else i++;
		j++; if(ToStringField(ppstring, plenStr, (pstruCltOrgClntInfo->sFax         ), C_FAX_LEN           )==FALSE) break;    else i++;
		j++; if(ToStringField(ppstring, plenStr, (pstruCltOrgClntInfo->sEmail       ), C_EMAIL_LEN         )==FALSE) break;    else i++;
		j++; if(ToStringField(ppstring, plenStr, (pstruCltOrgClntInfo->sClntAddr    ), C_CLNT_ADDR_LEN     )==FALSE) break;    else i++;
		j++; if(ToStringField(ppstring, plenStr, (pstruCltOrgClntInfo->sZipCde      ), C_ZIP_CDE_LEN       )==FALSE) break;    else i++;
		j++; if(ToStringField(ppstring, plenStr, (pstruCltOrgClntInfo->sRemark      ), C_REMARK_LEN        )==FALSE) break;    else i++;
		j++; if(ToStringField(ppstring, plenStr, (pstruCltOrgClntInfo->sClntMrk     ), C_CLNT_MRK_LEN      )==FALSE) break;    else i++;
		j++; if(ToStringField(ppstring, plenStr, (pstruCltOrgClntInfo->sEmpCde      ), C_EMP_CDE_LEN       )==FALSE) break;    else i++;
		j++; if(ToStringField(ppstring, plenStr, (pstruCltOrgClntInfo->sUpdTm       ), TIME_LEN            )==FALSE) break;    else i++;
		j++; if(ToStringField(ppstring, plenStr, (pstruCltOrgClntInfo->sBank        ), C_BANK_LEN          )==FALSE) break;    else i++;
		j++; if(ToStringField(ppstring, plenStr, (pstruCltOrgClntInfo->sAccntNo     ), C_ACCNT_NO_LEN      )==FALSE) break;    else i++;
		j++; if(ToStringField(ppstring, plenStr, (pstruCltOrgClntInfo->sEngAbr      ), C_ENG_ABR_LEN       )==FALSE) break;    else i++;
		j++; if(ToStringField(ppstring, plenStr, (pstruCltOrgClntInfo->sProvince    ), C_PROVINCE_LEN      )==FALSE) break;    else i++;
		j++; if(ToStringField(ppstring, plenStr, (pstruCltOrgClntInfo->sCity        ), C_CITY_LEN          )==FALSE) break;    else i++;
		j++; if(ToStringField(ppstring, plenStr, (pstruCltOrgClntInfo->sPlace       ), C_PLACE_LEN         )==FALSE) break;    else i++;
	}while(0);
	if(j!=i) 
	{	
		#ifdef _DEBUG
		printf("StrToCltOrgClntInfo failed: Field index = %d\n", j);
		#endif
		return 0-j;
	}
	return 0;
}

void StruCltOrgClntInfoToStr(cltOrgClntInfoStru *pstruCltOrgClntInfo, char** ppstring, int *plenStr)
{
	StrToStr(pstruCltOrgClntInfo->sClntCde     , ppstring,  plenStr); 
	StrToStr(pstruCltOrgClntInfo->sDptCde      , ppstring,  plenStr); 
	StrToStr(pstruCltOrgClntInfo->sClntNme     , ppstring,  plenStr); 
	StrToStr(pstruCltOrgClntInfo->sChnAbr      , ppstring,  plenStr); 
	StrToStr(pstruCltOrgClntInfo->sAuthMrk     , ppstring,  plenStr); 
	StrToStr(pstruCltOrgClntInfo->sBrdEnm      , ppstring,  plenStr); 
	StrToStr(pstruCltOrgClntInfo->sRgstNo      , ppstring,  plenStr); 
	StrToStr(pstruCltOrgClntInfo->sTaxNo       , ppstring,  plenStr); 
	DoubleToStr(pstruCltOrgClntInfo->fRgstMny     , ppstring,  plenStr);  
	StrToStr(pstruCltOrgClntInfo->sChief       , ppstring,  plenStr); 
	DoubleToStr(pstruCltOrgClntInfo->fEmlyNum     , ppstring,  plenStr);   
	StrToStr(pstruCltOrgClntInfo->sOwnershipCde, ppstring,  plenStr); 
	StrToStr(pstruCltOrgClntInfo->sOrgzTypCde  , ppstring,  plenStr); 
	StrToStr(pstruCltOrgClntInfo->sTrdCde      , ppstring,  plenStr); 
	StrToStr(pstruCltOrgClntInfo->sAraCde      , ppstring,  plenStr); 
	StrToStr(pstruCltOrgClntInfo->sClntScleCde , ppstring,  plenStr); 
	StrToStr(pstruCltOrgClntInfo->sScaleCde    , ppstring,  plenStr); 
	StrToStr(pstruCltOrgClntInfo->sUprDptCde   , ppstring,  plenStr); 
	StrToStr(pstruCltOrgClntInfo->sImptClntCde , ppstring,  plenStr); 
	StrToStr(pstruCltOrgClntInfo->sCntctPrsnNme, ppstring,  plenStr); 
	StrToStr(pstruCltOrgClntInfo->sTel         , ppstring,  plenStr); 
	StrToStr(pstruCltOrgClntInfo->sFax         , ppstring,  plenStr); 
	StrToStr(pstruCltOrgClntInfo->sEmail       , ppstring,  plenStr); 
	StrToStr(pstruCltOrgClntInfo->sClntAddr    , ppstring,  plenStr); 
	StrToStr(pstruCltOrgClntInfo->sZipCde      , ppstring,  plenStr); 
	StrToStr(pstruCltOrgClntInfo->sRemark      , ppstring,  plenStr); 
	StrToStr(pstruCltOrgClntInfo->sClntMrk     , ppstring,  plenStr); 
	StrToStr(pstruCltOrgClntInfo->sEmpCde      , ppstring,  plenStr); 
	StrToStr(pstruCltOrgClntInfo->sUpdTm       , ppstring,  plenStr); 
	StrToStr(pstruCltOrgClntInfo->sBank        , ppstring,  plenStr); 
	StrToStr(pstruCltOrgClntInfo->sAccntNo     , ppstring,  plenStr); 
	StrToStr(pstruCltOrgClntInfo->sEngAbr      , ppstring,  plenStr); 
	StrToStr(pstruCltOrgClntInfo->sProvince    , ppstring,  plenStr); 
	StrToStr(pstruCltOrgClntInfo->sCity        , ppstring,  plenStr); 
	StrToStr(pstruCltOrgClntInfo->sPlace       , ppstring,  plenStr); 
	return ;
}




void PrintStruCltOrgClntInfo(const cltOrgClntInfoStru *pstruCltOrgClntInfo)
{
	printf("pstruCltOrgClntInfo->sClntCde     = [%s]\n", pstruCltOrgClntInfo->sClntCde     );                                                                            
	printf("pstruCltOrgClntInfo->sDptCde      = [%s]\n", pstruCltOrgClntInfo->sDptCde      );                                                                            
	printf("pstruCltOrgClntInfo->sClntNme     = [%s]\n", pstruCltOrgClntInfo->sClntNme     );                                                                            
	printf("pstruCltOrgClntInfo->sChnAbr      = [%s]\n", pstruCltOrgClntInfo->sChnAbr      );                                                                            
	printf("pstruCltOrgClntInfo->sAuthMrk     = [%s]\n", pstruCltOrgClntInfo->sAuthMrk     );                                                                            
	printf("pstruCltOrgClntInfo->sBrdEnm      = [%s]\n", pstruCltOrgClntInfo->sBrdEnm      );                                                                            
	printf("pstruCltOrgClntInfo->sRgstNo      = [%s]\n", pstruCltOrgClntInfo->sRgstNo      );                                                                            
	printf("pstruCltOrgClntInfo->sTaxNo       = [%s]\n", pstruCltOrgClntInfo->sTaxNo       );                                                                            
	printf("pstruCltOrgClntInfo->fRgstMny     = [%f]\n", pstruCltOrgClntInfo->fRgstMny     );                                                                             
	printf("pstruCltOrgClntInfo->sChief       = [%s]\n", pstruCltOrgClntInfo->sChief       );                                                                            
	printf("pstruCltOrgClntInfo->fEmlyNum     = [%f]\n", pstruCltOrgClntInfo->fEmlyNum     );                                                                              
	printf("pstruCltOrgClntInfo->sOwnershipCde= [%s]\n", pstruCltOrgClntInfo->sOwnershipCde);                                                                            
	printf("pstruCltOrgClntInfo->sOrgzTypCde  = [%s]\n", pstruCltOrgClntInfo->sOrgzTypCde  );                                                                            
	printf("pstruCltOrgClntInfo->sTrdCde      = [%s]\n", pstruCltOrgClntInfo->sTrdCde      );                                                                            
	printf("pstruCltOrgClntInfo->sAraCde      = [%s]\n", pstruCltOrgClntInfo->sAraCde      );                                                                            
	printf("pstruCltOrgClntInfo->sClntScleCde = [%s]\n", pstruCltOrgClntInfo->sClntScleCde );                                                                            
	printf("pstruCltOrgClntInfo->sScaleCde    = [%s]\n", pstruCltOrgClntInfo->sScaleCde    );                                                                            
	printf("pstruCltOrgClntInfo->sUprDptCde   = [%s]\n", pstruCltOrgClntInfo->sUprDptCde   );                                                                            
	printf("pstruCltOrgClntInfo->sImptClntCde = [%s]\n", pstruCltOrgClntInfo->sImptClntCde );                                                                            
	printf("pstruCltOrgClntInfo->sCntctPrsnNme= [%s]\n", pstruCltOrgClntInfo->sCntctPrsnNme);                                                                            
	printf("pstruCltOrgClntInfo->sTel         = [%s]\n", pstruCltOrgClntInfo->sTel         );                                                                            
	printf("pstruCltOrgClntInfo->sFax         = [%s]\n", pstruCltOrgClntInfo->sFax         );                                                                            
	printf("pstruCltOrgClntInfo->sEmail       = [%s]\n", pstruCltOrgClntInfo->sEmail       );                                                                            
	printf("pstruCltOrgClntInfo->sClntAddr    = [%s]\n", pstruCltOrgClntInfo->sClntAddr    );                                                                            
	printf("pstruCltOrgClntInfo->sZipCde      = [%s]\n", pstruCltOrgClntInfo->sZipCde      );                                                                            
	printf("pstruCltOrgClntInfo->sRemark      = [%s]\n", pstruCltOrgClntInfo->sRemark      );                                                                            
	printf("pstruCltOrgClntInfo->sClntMrk     = [%s]\n", pstruCltOrgClntInfo->sClntMrk     );                                                                            
	printf("pstruCltOrgClntInfo->sEmpCde      = [%s]\n", pstruCltOrgClntInfo->sEmpCde      );                                                                            
	printf("pstruCltOrgClntInfo->sUpdTm       = [%s]\n", pstruCltOrgClntInfo->sUpdTm       );                                                                            
	printf("pstruCltOrgClntInfo->sBank        = [%s]\n", pstruCltOrgClntInfo->sBank        );                                                                            
	printf("pstruCltOrgClntInfo->sAccntNo     = [%s]\n", pstruCltOrgClntInfo->sAccntNo     );                                                                            
	printf("pstruCltOrgClntInfo->sEngAbr      = [%s]\n", pstruCltOrgClntInfo->sEngAbr      );                                                                            
	printf("pstruCltOrgClntInfo->sProvince    = [%s]\n", pstruCltOrgClntInfo->sProvince    );                                                                            
	printf("pstruCltOrgClntInfo->sCity        = [%s]\n", pstruCltOrgClntInfo->sCity        );                                                                            
	printf("pstruCltOrgClntInfo->sPlace       = [%s]\n\n", pstruCltOrgClntInfo->sPlace       );                                                                            
	return;
}


void struCltOrgClntInfoOrderConvt(char *pBuff)
{
	cltOrgClntInfoStru struCltOrgClntInfo;
	memcpy(&struCltOrgClntInfo, pBuff, sizeof(cltOrgClntInfoStru));

	struCltOrgClntInfo.fRgstMny = AIcom_ConvertDouble1(struCltOrgClntInfo.fRgstMny);
	struCltOrgClntInfo.fEmlyNum = AIcom_ConvertDouble1(struCltOrgClntInfo.fEmlyNum);

	memcpy(pBuff, &struCltOrgClntInfo, sizeof(cltOrgClntInfoStru));
	return ;
}

