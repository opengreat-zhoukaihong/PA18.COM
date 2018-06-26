#include "typeconvt.h"
#include "AiConvert.h"
#include "cplycheckgrid.h"








int StrToStruPlyCheckGrid(char** ppstring, int *plenStr, plyCheckGridStru *pstruPlyCheckGrid)
{
	int i, j;
	int iTemp;
	if(*ppstring==NULL) return 1;

	i=j=0;
	do
	{
		j++;    if(ToStringField(ppstring,  plenStr, pstruPlyCheckGrid->sCrtCde      , C_CRT_CDE_LEN     )==FALSE) break;    else i++;         
		j++;    if(ToStringField(ppstring,  plenStr, pstruPlyCheckGrid->sCrtTm       , TIME_LEN          )==FALSE) break;    else i++;         
		j++;    if(ToStringField(ppstring,  plenStr, pstruPlyCheckGrid->sUpdCde      , C_UPD_CDE_LEN     )==FALSE) break;    else i++;         
		j++;    if(ToStringField(ppstring,  plenStr, pstruPlyCheckGrid->sUpdTm       , TIME_LEN          )==FALSE) break;    else i++;         
		j++;    if(ToStringField(ppstring,  plenStr, pstruPlyCheckGrid->sDocNo       , C_DOC_NO_LEN      )==FALSE) break;    else i++;         
		j++;    if(ToStringField(ppstring,  plenStr, pstruPlyCheckGrid->sSendTm      , TIME_LEN          )==FALSE) break;    else i++;         
		j++;    if(ToStringField(ppstring,  plenStr, pstruPlyCheckGrid->sBlgDptCde   , C_BLG_DPT_CDE_LEN )==FALSE) break;    else i++;         
		j++;    if(ToStringField(ppstring,  plenStr, pstruPlyCheckGrid->sSource      , C_SOURCE_LEN      )==FALSE) break;    else i++;         
		j++;    if(ToStringField(ppstring,  plenStr, pstruPlyCheckGrid->sSendDptCde  , C_SEND_DPT_CDE_LEN)==FALSE) break;    else i++;         
		j++;    if(ToStringField(ppstring,  plenStr, pstruPlyCheckGrid->sSendCde     , C_SEND_CDE_LEN    )==FALSE) break;    else i++;         
		j++;    if(ToStringField(ppstring,  plenStr, pstruPlyCheckGrid->sDesDptCde   , C_DES_DPT_CDE_LEN )==FALSE) break;    else i++;         
		j++;    if(ToStringField(ppstring,  plenStr, pstruPlyCheckGrid->sEmergency   , C_EMERGENCY_LEN   )==FALSE) break;    else i++;         
		j++;    if(ToStringField(ppstring,  plenStr, pstruPlyCheckGrid->sAuthPrnCde  , C_AUTH_PRN_CDE_LEN)==FALSE) break;    else i++;         
		j++;    if(ToStringField(ppstring,  plenStr, pstruPlyCheckGrid->sUdrMrk      , C_UDR_MRK_LEN     )==FALSE) break;    else i++;         
		j++;    if(ToStringField(ppstring,  plenStr, pstruPlyCheckGrid->sSendMrk     , C_SEND_MRK_LEN    )==FALSE) break;    else i++;         
		j++;    if(ToStringField(ppstring,  plenStr, pstruPlyCheckGrid->sUdrOpnMrk   , C_UDR_OPN_MRK_LEN )==FALSE) break;    else i++;         
		j++;    if(ToIntField(ppstring,  plenStr,  &(pstruPlyCheckGrid->nVrfyMrk)    )==FALSE) break;    else i++;         
		j++;    if(ToStringField(ppstring,  plenStr, pstruPlyCheckGrid->sMdfyTm      , TIME_LEN          )==FALSE) break;    else i++;         
		j++;    if(ToStringField(ppstring,  plenStr, pstruPlyCheckGrid->sInsrncCde   , C_INSRNC_CDE_LEN  )==FALSE) break;    else i++;         
		j++;    if(ToStringField(ppstring,  plenStr, pstruPlyCheckGrid->sUndrPrsn    , C_UNDR_PRSN_LEN   )==FALSE) break;    else i++;         
		j++;    if(ToStringField(ppstring,  plenStr, pstruPlyCheckGrid->sUndrDpt     , C_UNDR_DPT_LEN    )==FALSE) break;    else i++;         
		j++;    if(ToStringField(ppstring,  plenStr, pstruPlyCheckGrid->sPrnTyp      , C_PRN_TYP_LEN     )==FALSE) break;    else i++;         
		j++;    if(ToStringField(ppstring,  plenStr, pstruPlyCheckGrid->sRinsrncMrk  , C_RINSRNC_MRK_LEN )==FALSE) break;    else i++;         
		j++;    if(ToStringField(ppstring,  plenStr, pstruPlyCheckGrid->sCoinsrncMrk , C_COINSRNC_MRK_LEN)==FALSE) break;    else i++;         
		j++;    if(ToStringField(ppstring,  plenStr, pstruPlyCheckGrid->sCplyNo      , C_PLY_NO_LEN      )==FALSE) break;    else i++;         
		j++;    if(ToStringField(ppstring,  plenStr, pstruPlyCheckGrid->sEdrNo       , C_EDR_NO_LEN      )==FALSE) break;    else i++;         
		j++;    if(ToIntField(ppstring,  plenStr,   &iTemp                           )==FALSE) break;    else i++;  		pstruPlyCheckGrid->cRead = iTemp; 
		j++;    if(ToIntField(ppstring,  plenStr,   &iTemp                           )==FALSE) break;    else i++;  		pstruPlyCheckGrid->cFlag = iTemp; 
		j++;    if(ToStringField(ppstring,  plenStr, pstruPlyCheckGrid->sInsrntNme   , C_INSRNT_NME_LEN  )==FALSE) break;    else i++;         
		j++;    if(ToStringField(ppstring,  plenStr, pstruPlyCheckGrid->sInsrncCnm   , C_INSRNC_CNM_LEN  )==FALSE) break;    else i++;         
		j++;    if(ToStringField(ppstring,  plenStr, pstruPlyCheckGrid->sBlgDptCnm   , C_DPT_CNM_LEN     )==FALSE) break;    else i++;         
		j++;    if(ToStringField(ppstring,  plenStr, pstruPlyCheckGrid->sSendDptCnm  , C_DPT_CNM_LEN     )==FALSE) break;    else i++;         
		j++;    if(ToStringField(ppstring,  plenStr, pstruPlyCheckGrid->sDesDptCnm   , C_DPT_CNM_LEN     )==FALSE) break;    else i++;         
		j++;    if(ToStringField(ppstring,  plenStr, pstruPlyCheckGrid->sUndrDptCnm  , C_DPT_CNM_LEN     )==FALSE) break;    else i++;         
		j++;    if(ToStringField(ppstring,  plenStr, pstruPlyCheckGrid->sSignTm      , TIME_LEN          )==FALSE) break;    else i++;         
		j++;    if(ToStringField(ppstring,  plenStr, pstruPlyCheckGrid->sRptDesc     , C_RPT_DESC_LEN    )==FALSE) break;    else i++;         
		j++;    if(ToStringField(ppstring,  plenStr, pstruPlyCheckGrid->sEdrTyp      , C_EDR_TYP_LEN     )==FALSE) break;    else i++;         
		j++;    if(ToStringField(ppstring,  plenStr, pstruPlyCheckGrid->sRiskLvlCde  , C_RISK_LVL_CDE_LEN)==FALSE) break;    else i++;         
		j++;    if(ToStringField(ppstring,  plenStr, pstruPlyCheckGrid->sLcnNo       , C_LCN_NO_LEN      )==FALSE) break;    else i++;         
		j++;    if(ToStringField(ppstring,  plenStr, pstruPlyCheckGrid->sEngNo       , C_ENG_NO_LEN      )==FALSE) break;    else i++;         
		j++;    if(ToStringField(ppstring,  plenStr, pstruPlyCheckGrid->sInsrncCls   , C_INSRNC_CLS_LEN  )==FALSE) break;    else i++;         
		j++;    if(ToStringField(ppstring,  plenStr, pstruPlyCheckGrid->sUseAtr      , C_USE_ATR_LEN     )==FALSE) break;    else i++;         
		j++;    if(ToStringField(ppstring,  plenStr, pstruPlyCheckGrid->sAppTyp      , C_APP_TYP_LEN     )==FALSE) break;    else i++;         
		j++;    if(ToStringField(ppstring,  plenStr, pstruPlyCheckGrid->sAppTm       , DATE_LEN          )==FALSE) break;    else i++;         
		j++;    if(ToStringField(ppstring,  plenStr, pstruPlyCheckGrid->sInputTm     , DATE_LEN          )==FALSE) break;    else i++;         
		j++;    if(ToStringField(ppstring,  plenStr, pstruPlyCheckGrid->sAppNme      , C_APP_NME_LEN     )==FALSE) break;    else i++;         
		j++;    if(ToStringField(ppstring,  plenStr, pstruPlyCheckGrid->sUndrOpn     , C_UNDR_OPN_LEN    )==FALSE) break;    else i++;         
		j++;    if(ToStringField(ppstring,  plenStr, pstruPlyCheckGrid->sEdrAppTm    , DATE_LEN          )==FALSE) break;    else i++;         
		j++;    if(ToStringField(ppstring,  plenStr, pstruPlyCheckGrid->sInternetTyp , C_INTERNET_TYP_LEN)==FALSE) break;    else i++;         
	}while(0);
	if(j!=i) 
	{	
		#ifdef _DEBUG
		printf("StrToStruPlyCheckGrid failed: Field index = %d\n", j);
		#endif
		return 0-j;
	}
	return 0;
}



void StruPlyCheckGridToStr(plyCheckGridStru *pstruPlyCheckGrid, char** ppstring, int *plenStr)
{
	StrToStr(pstruPlyCheckGrid->sCrtCde, ppstring,  plenStr);  
	StrToStr(pstruPlyCheckGrid->sCrtTm, ppstring,  plenStr);  
	StrToStr(pstruPlyCheckGrid->sUpdCde, ppstring,  plenStr);  
	StrToStr(pstruPlyCheckGrid->sUpdTm, ppstring,  plenStr);  
	StrToStr(pstruPlyCheckGrid->sDocNo, ppstring,  plenStr);  
	StrToStr(pstruPlyCheckGrid->sSendTm, ppstring,  plenStr);  
	StrToStr(pstruPlyCheckGrid->sBlgDptCde, ppstring,  plenStr);  
	StrToStr(pstruPlyCheckGrid->sSource, ppstring,  plenStr);  
	StrToStr(pstruPlyCheckGrid->sSendDptCde, ppstring,  plenStr);  
	StrToStr(pstruPlyCheckGrid->sSendCde, ppstring,  plenStr);  
	StrToStr(pstruPlyCheckGrid->sDesDptCde, ppstring,  plenStr);  
	StrToStr(pstruPlyCheckGrid->sEmergency, ppstring,  plenStr);  
	StrToStr(pstruPlyCheckGrid->sAuthPrnCde, ppstring,  plenStr);  
	StrToStr(pstruPlyCheckGrid->sUdrMrk, ppstring,  plenStr);  
	StrToStr(pstruPlyCheckGrid->sSendMrk, ppstring,  plenStr);  
	StrToStr(pstruPlyCheckGrid->sUdrOpnMrk, ppstring,  plenStr);  
	IntToStr(pstruPlyCheckGrid->nVrfyMrk, ppstring,  plenStr);  
	StrToStr(pstruPlyCheckGrid->sMdfyTm, ppstring,  plenStr);  
	StrToStr(pstruPlyCheckGrid->sInsrncCde, ppstring,  plenStr);  
	StrToStr(pstruPlyCheckGrid->sUndrPrsn, ppstring,  plenStr);  
	StrToStr(pstruPlyCheckGrid->sUndrDpt, ppstring,  plenStr);  
	StrToStr(pstruPlyCheckGrid->sPrnTyp, ppstring,  plenStr);  
	StrToStr(pstruPlyCheckGrid->sRinsrncMrk, ppstring,  plenStr);  
	StrToStr(pstruPlyCheckGrid->sCoinsrncMrk, ppstring,  plenStr);  
	StrToStr(pstruPlyCheckGrid->sCplyNo, ppstring,  plenStr);  
	StrToStr(pstruPlyCheckGrid->sEdrNo, ppstring,  plenStr);  
	IntToStr(pstruPlyCheckGrid->cRead, ppstring,  plenStr);  
	IntToStr(pstruPlyCheckGrid->cFlag, ppstring,  plenStr);  
	StrToStr(pstruPlyCheckGrid->sInsrntNme, ppstring,  plenStr);  
	StrToStr(pstruPlyCheckGrid->sInsrncCnm, ppstring,  plenStr);  
	StrToStr(pstruPlyCheckGrid->sBlgDptCnm, ppstring,  plenStr);  
	StrToStr(pstruPlyCheckGrid->sSendDptCnm, ppstring,  plenStr);  
	StrToStr(pstruPlyCheckGrid->sDesDptCnm, ppstring,  plenStr);  
	StrToStr(pstruPlyCheckGrid->sUndrDptCnm, ppstring,  plenStr);  
	StrToStr(pstruPlyCheckGrid->sSignTm, ppstring,  plenStr);  
	StrToStr(pstruPlyCheckGrid->sRptDesc, ppstring,  plenStr);  
	StrToStr(pstruPlyCheckGrid->sEdrTyp, ppstring,  plenStr);  
	StrToStr(pstruPlyCheckGrid->sRiskLvlCde, ppstring,  plenStr);  
	StrToStr(pstruPlyCheckGrid->sLcnNo, ppstring,  plenStr);  
	StrToStr(pstruPlyCheckGrid->sEngNo, ppstring,  plenStr);  
	StrToStr(pstruPlyCheckGrid->sInsrncCls, ppstring,  plenStr);  
	StrToStr(pstruPlyCheckGrid->sUseAtr, ppstring,  plenStr);  
	StrToStr(pstruPlyCheckGrid->sAppTyp, ppstring,  plenStr);  
	StrToStr(pstruPlyCheckGrid->sAppTm, ppstring,  plenStr);  
	StrToStr(pstruPlyCheckGrid->sInputTm , ppstring,  plenStr);  
	StrToStr(pstruPlyCheckGrid->sAppNme, ppstring,  plenStr);  
	StrToStr(pstruPlyCheckGrid->sUndrOpn, ppstring,  plenStr);  
	StrToStr(pstruPlyCheckGrid->sEdrAppTm, ppstring,  plenStr);  
	StrToStr(pstruPlyCheckGrid->sInternetTyp, ppstring,  plenStr);  
	return ;
}






void PrintStruCheckGrid(const plyCheckGridStru *pstruPlyCheckGrid)
{
	printf("pstruPlyCheckGrid->sCrtCde       = [%s]\n", pstruPlyCheckGrid->sCrtCde);             
	printf("pstruPlyCheckGrid->sCrtTm        = [%s]\n", pstruPlyCheckGrid->sCrtTm);             
	printf("pstruPlyCheckGrid->sUpdCde       = [%s]\n", pstruPlyCheckGrid->sUpdCde);             
	printf("pstruPlyCheckGrid->sUpdTm        = [%s]\n", pstruPlyCheckGrid->sUpdTm);             
	printf("pstruPlyCheckGrid->sDocNo        = [%s]\n", pstruPlyCheckGrid->sDocNo);             
	printf("pstruPlyCheckGrid->sSendTm       = [%s]\n", pstruPlyCheckGrid->sSendTm);             
	printf("pstruPlyCheckGrid->sBlgDptCde    = [%s]\n", pstruPlyCheckGrid->sBlgDptCde);             
	printf("pstruPlyCheckGrid->sSource       = [%s]\n", pstruPlyCheckGrid->sSource);             
	printf("pstruPlyCheckGrid->sSendDptCde   = [%s]\n", pstruPlyCheckGrid->sSendDptCde);             
	printf("pstruPlyCheckGrid->sSendCde      = [%s]\n", pstruPlyCheckGrid->sSendCde);             
	printf("pstruPlyCheckGrid->sDesDptCde    = [%s]\n", pstruPlyCheckGrid->sDesDptCde);             
	printf("pstruPlyCheckGrid->sEmergency    = [%s]\n", pstruPlyCheckGrid->sEmergency);             
	printf("pstruPlyCheckGrid->sAuthPrnCde   = [%s]\n", pstruPlyCheckGrid->sAuthPrnCde);             
	printf("pstruPlyCheckGrid->sUdrMrk       = [%s]\n", pstruPlyCheckGrid->sUdrMrk);             
	printf("pstruPlyCheckGrid->sSendMrk      = [%s]\n", pstruPlyCheckGrid->sSendMrk);             
	printf("pstruPlyCheckGrid->sUdrOpnMrk    = [%s]\n", pstruPlyCheckGrid->sUdrOpnMrk);             
	printf("pstruPlyCheckGrid->nVrfyMrk      = [%d]\n", pstruPlyCheckGrid->nVrfyMrk);             
	printf("pstruPlyCheckGrid->sMdfyTm       = [%s]\n", pstruPlyCheckGrid->sMdfyTm);             
	printf("pstruPlyCheckGrid->sInsrncCde    = [%s]\n", pstruPlyCheckGrid->sInsrncCde);             
	printf("pstruPlyCheckGrid->sUndrPrsn     = [%s]\n", pstruPlyCheckGrid->sUndrPrsn);             
	printf("pstruPlyCheckGrid->sUndrDpt      = [%s]\n", pstruPlyCheckGrid->sUndrDpt);             
	printf("pstruPlyCheckGrid->sPrnTyp       = [%s]\n", pstruPlyCheckGrid->sPrnTyp);             
	printf("pstruPlyCheckGrid->sRinsrncMrk   = [%s]\n", pstruPlyCheckGrid->sRinsrncMrk);             
	printf("pstruPlyCheckGrid->sCoinsrncMrk  = [%s]\n", pstruPlyCheckGrid->sCoinsrncMrk);             
	printf("pstruPlyCheckGrid->sCplyNo       = [%s]\n", pstruPlyCheckGrid->sCplyNo);             
	printf("pstruPlyCheckGrid->sEdrNo        = [%s]\n", pstruPlyCheckGrid->sEdrNo);             
	printf("pstruPlyCheckGrid->cRead         = [%d]\n", pstruPlyCheckGrid->cRead);             
	printf("pstruPlyCheckGrid->cFlag         = [%d]\n", pstruPlyCheckGrid->cFlag);             
	printf("pstruPlyCheckGrid->sInsrntNme    = [%s]\n", pstruPlyCheckGrid->sInsrntNme);             
	printf("pstruPlyCheckGrid->sInsrncCnm    = [%s]\n", pstruPlyCheckGrid->sInsrncCnm);             
	printf("pstruPlyCheckGrid->sBlgDptCnm    = [%s]\n", pstruPlyCheckGrid->sBlgDptCnm);             
	printf("pstruPlyCheckGrid->sSendDptCnm   = [%s]\n", pstruPlyCheckGrid->sSendDptCnm);             
	printf("pstruPlyCheckGrid->sDesDptCnm    = [%s]\n", pstruPlyCheckGrid->sDesDptCnm);             
	printf("pstruPlyCheckGrid->sUndrDptCnm   = [%s]\n", pstruPlyCheckGrid->sUndrDptCnm);             
	printf("pstruPlyCheckGrid->sSignTm       = [%s]\n", pstruPlyCheckGrid->sSignTm);             
	printf("pstruPlyCheckGrid->sRptDesc      = [%s]\n", pstruPlyCheckGrid->sRptDesc);             
	printf("pstruPlyCheckGrid->sEdrTyp       = [%s]\n", pstruPlyCheckGrid->sEdrTyp);             
	printf("pstruPlyCheckGrid->sRiskLvlCde   = [%s]\n", pstruPlyCheckGrid->sRiskLvlCde);             
	printf("pstruPlyCheckGrid->sLcnNo        = [%s]\n", pstruPlyCheckGrid->sLcnNo);             
	printf("pstruPlyCheckGrid->sEngNo        = [%s]\n", pstruPlyCheckGrid->sEngNo);             
	printf("pstruPlyCheckGrid->sInsrncCls    = [%s]\n", pstruPlyCheckGrid->sInsrncCls);             
	printf("pstruPlyCheckGrid->sUseAtr       = [%s]\n", pstruPlyCheckGrid->sUseAtr);             
	printf("pstruPlyCheckGrid->sAppTyp       = [%s]\n", pstruPlyCheckGrid->sAppTyp);             
	printf("pstruPlyCheckGrid->sAppTm        = [%s]\n", pstruPlyCheckGrid->sAppTm);             
	printf("pstruPlyCheckGrid->sInputTm      = [%s]\n", pstruPlyCheckGrid->sInputTm );             
	printf("pstruPlyCheckGrid->sAppNme       = [%s]\n", pstruPlyCheckGrid->sAppNme);             
	printf("pstruPlyCheckGrid->sUndrOpn      = [%s]\n", pstruPlyCheckGrid->sUndrOpn);             
	printf("pstruPlyCheckGrid->sEdrAppTm     = [%s]\n", pstruPlyCheckGrid->sEdrAppTm);             
	printf("pstruPlyCheckGrid->sInternetTyp  = [%s]\n\n", pstruPlyCheckGrid->sInternetTyp);             
	return ;
}









void struPlyCheckGridOrderConvt(char *pBuff)
{
	plyCheckGridStru struPlyCheckGrid;
	memcpy(&struPlyCheckGrid, pBuff, sizeof(plyCheckGridStru));
	struPlyCheckGrid.nVrfyMrk = AIcom_ConvertInt1(struPlyCheckGrid.nVrfyMrk);
	memcpy(pBuff, &struPlyCheckGrid, sizeof(plyCheckGridStru));
	return ;
}

