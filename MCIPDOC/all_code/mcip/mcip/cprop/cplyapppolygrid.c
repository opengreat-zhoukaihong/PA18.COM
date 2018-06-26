#include "typeconvt.h"
#include "AiConvert.h"
#include "cplyapppolygrid.h"




int StrToStruPolyGrid(char** ppstring, int *plenStr, plyAppPolyGridStru *pstruAppPolyGrid)
{
	int j, k;
	int iTemp;
	if(*ppstring==NULL) return 1;

	j=k=0;
	do
	{
		j++;    if(ToStringField(ppstring,  plenStr,  (pstruAppPolyGrid->sCrtCde        ), C_CRT_CDE_LEN     )==FALSE) break;    else k++;
		j++;    if(ToStringField(ppstring,  plenStr,  (pstruAppPolyGrid->sCrtTm         ), TIME_LEN          )==FALSE) break;    else k++;
		j++;    if(ToStringField(ppstring,  plenStr,  (pstruAppPolyGrid->sUpdCde        ), C_UPD_CDE_LEN     )==FALSE) break;    else k++;
		j++;    if(ToStringField(ppstring,  plenStr,  (pstruAppPolyGrid->sUpdTm         ), TIME_LEN          )==FALSE) break;    else k++;
		j++;    if(ToStringField(ppstring,  plenStr,  (pstruAppPolyGrid->sDocNo         ), C_DOC_NO_LEN      )==FALSE) break;    else k++;
		j++;    if(ToStringField(ppstring,  plenStr,  (pstruAppPolyGrid->sSendTm        ), TIME_LEN          )==FALSE) break;    else k++;
		j++;    if(ToStringField(ppstring,  plenStr,  (pstruAppPolyGrid->sBlgDptCde     ), C_BLG_DPT_CDE_LEN )==FALSE) break;    else k++;
		j++;    if(ToStringField(ppstring,  plenStr,  (pstruAppPolyGrid->sSource        ), C_SOURCE_LEN      )==FALSE) break;    else k++;
		j++;    if(ToStringField(ppstring,  plenStr,  (pstruAppPolyGrid->sSendDptCde    ), C_SEND_DPT_CDE_LEN)==FALSE) break;    else k++;
		j++;    if(ToStringField(ppstring,  plenStr,  (pstruAppPolyGrid->sSendCde       ), C_SEND_CDE_LEN    )==FALSE) break;    else k++;
		j++;    if(ToStringField(ppstring,  plenStr,  (pstruAppPolyGrid->sDesDptCde     ), C_DES_DPT_CDE_LEN )==FALSE) break;    else k++;
		j++;    if(ToStringField(ppstring,  plenStr,  (pstruAppPolyGrid->sEmergency     ), C_EMERGENCY_LEN   )==FALSE) break;    else k++;
		j++;    if(ToStringField(ppstring,  plenStr,  (pstruAppPolyGrid->sAuthPrnCde    ), C_AUTH_PRN_CDE_LEN)==FALSE) break;    else k++;
		j++;    if(ToStringField(ppstring,  plenStr,  (pstruAppPolyGrid->sUdrMrk        ), C_UDR_MRK_LEN     )==FALSE) break;    else k++;
		j++;    if(ToStringField(ppstring,  plenStr,  (pstruAppPolyGrid->sSendMrk       ), C_SEND_MRK_LEN    )==FALSE) break;    else k++;
		j++;    if(ToStringField(ppstring,  plenStr,  (pstruAppPolyGrid->sUdrOpnMrk     ), C_UDR_OPN_MRK_LEN )==FALSE) break;    else k++;
		j++;    if(ToIntField(ppstring,  plenStr,    &(pstruAppPolyGrid->nVrfyMrk       ))==FALSE) break;    else k++;
		j++;    if(ToStringField(ppstring,  plenStr,  (pstruAppPolyGrid->sMdfyTm        ), TIME_LEN          )==FALSE) break;    else k++;
		j++;    if(ToStringField(ppstring,  plenStr,  (pstruAppPolyGrid->sInsrncCde     ), C_INSRNC_CDE_LEN  )==FALSE) break;    else k++;
		j++;    if(ToStringField(ppstring,  plenStr,  (pstruAppPolyGrid->sUndrPrsn      ), C_UNDR_PRSN_LEN   )==FALSE) break;    else k++;
		j++;    if(ToStringField(ppstring,  plenStr,  (pstruAppPolyGrid->sUndrDpt       ), C_UNDR_DPT_LEN    )==FALSE) break;    else k++;
		j++;    if(ToStringField(ppstring,  plenStr,  (pstruAppPolyGrid->sPrnTyp        ), C_PRN_TYP_LEN     )==FALSE) break;    else k++;
		j++;    if(ToStringField(ppstring,  plenStr,  (pstruAppPolyGrid->sRinsrncMrk    ), C_RINSRNC_MRK_LEN )==FALSE) break;    else k++;
		j++;    if(ToStringField(ppstring,  plenStr,  (pstruAppPolyGrid->sCoinsrncMrk   ), C_COINSRNC_MRK_LEN)==FALSE) break;    else k++;
		j++;    if(ToStringField(ppstring,  plenStr,  (pstruAppPolyGrid->sCplyNo        ), C_PLY_NO_LEN      )==FALSE) break;    else k++;
		j++;    if(ToStringField(ppstring,  plenStr,  (pstruAppPolyGrid->sEdrNo         ), C_EDR_NO_LEN      )==FALSE) break;    else k++;
		j++;    if(ToStringField(ppstring,  plenStr,  (pstruAppPolyGrid->sReadTime      ), TIME_LEN          )==FALSE) break;    else k++;
		j++;    if(ToStringField(ppstring,  plenStr,  (pstruAppPolyGrid->sRecNo         ), C_REC_NO_LEN      )==FALSE) break;    else k++;
		j++;    if(ToIntField(ppstring,  plenStr,    &(iTemp                            ))==FALSE) break;    else k++;		pstruAppPolyGrid->cWorkMrk = iTemp;
		j++;    if(ToIntField(ppstring,  plenStr,    &(iTemp                            ))==FALSE) break;    else k++;		pstruAppPolyGrid->cFlag = iTemp;
		j++;    if(ToStringField(ppstring,  plenStr,  (pstruAppPolyGrid->sAppNme        ), C_APP_NME_LEN     )==FALSE) break;    else k++;
		j++;    if(ToStringField(ppstring,  plenStr,  (pstruAppPolyGrid->sApptTm        ), DATE_LEN          )==FALSE) break;    else k++;
		j++;    if(ToStringField(ppstring,  plenStr,  (pstruAppPolyGrid->sSignTm        ), TIME_LEN          )==FALSE) break;    else k++;
		j++;    if(ToStringField(ppstring,  plenStr,  (pstruAppPolyGrid->sInsrntNme     ), C_INSRNT_NME_LEN  )==FALSE) break;    else k++;
		j++;    if(ToStringField(ppstring,  plenStr,  (pstruAppPolyGrid->sRptDesc       ), C_RPT_DESC_LEN    )==FALSE) break;    else k++;
		j++;    if(ToStringField(ppstring,  plenStr,  (pstruAppPolyGrid->sEdrTyp        ), C_EDR_TYP_LEN     )==FALSE) break;    else k++;
		j++;    if(ToStringField(ppstring,  plenStr,  (pstruAppPolyGrid->sRiskLvlCde    ), C_RISK_LVL_CDE_LEN)==FALSE) break;    else k++;
		j++;    if(ToStringField(ppstring,  plenStr,  (pstruAppPolyGrid->sLcnNo         ), C_LCN_NO_LEN      )==FALSE) break;    else k++;
		j++;    if(ToStringField(ppstring,  plenStr,  (pstruAppPolyGrid->sEngNo         ), C_ENG_NO_LEN      )==FALSE) break;    else k++;
		j++;    if(ToStringField(ppstring,  plenStr,  (pstruAppPolyGrid->sInsrncCls     ), C_INSRNC_CLS_LEN  )==FALSE) break;    else k++;
		j++;    if(ToStringField(ppstring,  plenStr,  (pstruAppPolyGrid->sAppTyp        ), C_APP_TYP_LEN     )==FALSE) break;    else k++;
		j++;    if(ToStringField(ppstring,  plenStr,  (pstruAppPolyGrid->sUseAtr        ), C_USE_ATR_LEN     )==FALSE) break;    else k++;
		j++;    if(ToStringField(ppstring,  plenStr,  (pstruAppPolyGrid->sUndrOpn       ), C_UNDR_OPN_LEN    )==FALSE) break;    else k++;
		j++;    if(ToStringField(ppstring,  plenStr,  (pstruAppPolyGrid->sInternetTyp   ), C_INTERNET_TYP_LEN)==FALSE) break;    else k++;
	}while(0);
	if(j!=k) 
	{	
		#ifdef _DEBUG
		printf("StrToStruPolyGrid failed: Field index = %d\n", j);
		#endif
		return 0-j;
	}
	return 0;
}


void StruPlyAppPolyGridToStr(plyAppPolyGridStru *pstruAppPolyGrid, char** ppstring, int *plenStr)
{
	StrToStr(pstruAppPolyGrid->sCrtCde, ppstring,  plenStr);  
	StrToStr(pstruAppPolyGrid->sCrtTm, ppstring,  plenStr);  
	StrToStr(pstruAppPolyGrid->sUpdCde, ppstring,  plenStr);  
	StrToStr(pstruAppPolyGrid->sUpdTm, ppstring,  plenStr);  
	StrToStr(pstruAppPolyGrid->sDocNo, ppstring,  plenStr);  
	StrToStr(pstruAppPolyGrid->sSendTm, ppstring,  plenStr);  
	StrToStr(pstruAppPolyGrid->sBlgDptCde, ppstring,  plenStr);  
	StrToStr(pstruAppPolyGrid->sSource, ppstring,  plenStr);  
	StrToStr(pstruAppPolyGrid->sSendDptCde, ppstring,  plenStr);  
	StrToStr(pstruAppPolyGrid->sSendCde, ppstring,  plenStr);  
	StrToStr(pstruAppPolyGrid->sDesDptCde, ppstring,  plenStr);  
	StrToStr(pstruAppPolyGrid->sEmergency, ppstring,  plenStr);  
	StrToStr(pstruAppPolyGrid->sAuthPrnCde, ppstring,  plenStr);  
	StrToStr(pstruAppPolyGrid->sUdrMrk, ppstring,  plenStr);  
	StrToStr(pstruAppPolyGrid->sSendMrk, ppstring,  plenStr);  
	StrToStr(pstruAppPolyGrid->sUdrOpnMrk, ppstring,  plenStr);  
	IntToStr(pstruAppPolyGrid->nVrfyMrk, ppstring,  plenStr);  
	StrToStr(pstruAppPolyGrid->sMdfyTm, ppstring,  plenStr);  
	StrToStr(pstruAppPolyGrid->sInsrncCde, ppstring,  plenStr);  
	StrToStr(pstruAppPolyGrid->sUndrPrsn, ppstring,  plenStr);  
	StrToStr(pstruAppPolyGrid->sUndrDpt, ppstring,  plenStr);  
	StrToStr(pstruAppPolyGrid->sPrnTyp, ppstring,  plenStr);  
	StrToStr(pstruAppPolyGrid->sRinsrncMrk, ppstring,  plenStr);  
	StrToStr(pstruAppPolyGrid->sCoinsrncMrk, ppstring,  plenStr);  
	StrToStr(pstruAppPolyGrid->sCplyNo, ppstring,  plenStr);  
	StrToStr(pstruAppPolyGrid->sEdrNo, ppstring,  plenStr);  
	StrToStr(pstruAppPolyGrid->sReadTime, ppstring,  plenStr);  
	StrToStr(pstruAppPolyGrid->sRecNo, ppstring,  plenStr);  
	IntToStr(pstruAppPolyGrid->cWorkMrk, ppstring,  plenStr); 
	IntToStr(pstruAppPolyGrid->cFlag, ppstring,  plenStr);  
	StrToStr(pstruAppPolyGrid->sAppNme, ppstring,  plenStr);  
	StrToStr(pstruAppPolyGrid->sApptTm, ppstring,  plenStr);  
	StrToStr(pstruAppPolyGrid->sSignTm, ppstring,  plenStr);  
	StrToStr(pstruAppPolyGrid->sInsrntNme, ppstring,  plenStr);  
	StrToStr(pstruAppPolyGrid->sRptDesc, ppstring,  plenStr);  
	StrToStr(pstruAppPolyGrid->sEdrTyp, ppstring,  plenStr);  
	StrToStr(pstruAppPolyGrid->sRiskLvlCde, ppstring,  plenStr);  
	StrToStr(pstruAppPolyGrid->sLcnNo, ppstring,  plenStr);  
	StrToStr(pstruAppPolyGrid->sEngNo, ppstring,  plenStr);  
	StrToStr(pstruAppPolyGrid->sInsrncCls, ppstring,  plenStr);  
	StrToStr(pstruAppPolyGrid->sAppTyp, ppstring,  plenStr);  
	StrToStr(pstruAppPolyGrid->sUseAtr, ppstring,  plenStr);  
	StrToStr(pstruAppPolyGrid->sUndrOpn, ppstring,  plenStr);  
	StrToStr(pstruAppPolyGrid->sInternetTyp, ppstring,  plenStr);  
	return ;
}


void PrintStruAppPolyGrid(const plyAppPolyGridStru *pstruAppPolyGridTemp)
{
	printf("pstruAppPolyGridTemp->sCrtCde       = [%s]\n", pstruAppPolyGridTemp->sCrtCde);                  
	printf("pstruAppPolyGridTemp->sCrtTm        = [%s]\n", pstruAppPolyGridTemp->sCrtTm);          
	printf("pstruAppPolyGridTemp->sUpdCde       = [%s]\n", pstruAppPolyGridTemp->sUpdCde);               
	printf("pstruAppPolyGridTemp->sUpdTm        = [%s]\n", pstruAppPolyGridTemp->sUpdTm);              
	printf("pstruAppPolyGridTemp->sDocNo        = [%s]\n", pstruAppPolyGridTemp->sDocNo);              
	printf("pstruAppPolyGridTemp->sSendTm       = [%s]\n", pstruAppPolyGridTemp->sSendTm);               
	printf("pstruAppPolyGridTemp->sBlgDptCde    = [%s]\n", pstruAppPolyGridTemp->sBlgDptCde);                  
	printf("pstruAppPolyGridTemp->sSource       = [%s]\n", pstruAppPolyGridTemp->sSource);               
	printf("pstruAppPolyGridTemp->sSendDptCde   = [%s]\n", pstruAppPolyGridTemp->sSendDptCde);                   
	printf("pstruAppPolyGridTemp->sSendCde      = [%s]\n", pstruAppPolyGridTemp->sSendCde);                
	printf("pstruAppPolyGridTemp->sDesDptCde    = [%s]\n", pstruAppPolyGridTemp->sDesDptCde);                  
	printf("pstruAppPolyGridTemp->sEmergency    = [%s]\n", pstruAppPolyGridTemp->sEmergency);                  
	printf("pstruAppPolyGridTemp->sAuthPrnCde   = [%s]\n", pstruAppPolyGridTemp->sAuthPrnCde);                   
	printf("pstruAppPolyGridTemp->sUdrMrk       = [%s]\n", pstruAppPolyGridTemp->sUdrMrk);               
	printf("pstruAppPolyGridTemp->sSendMrk      = [%s]\n", pstruAppPolyGridTemp->sSendMrk);                
	printf("pstruAppPolyGridTemp->sUdrOpnMrk    = [%s]\n", pstruAppPolyGridTemp->sUdrOpnMrk);                  
	printf("pstruAppPolyGridTemp->nVrfyMrk      = [%d]\n", pstruAppPolyGridTemp->nVrfyMrk);                
	printf("pstruAppPolyGridTemp->sMdfyTm       = [%s]\n", pstruAppPolyGridTemp->sMdfyTm);               
	printf("pstruAppPolyGridTemp->sInsrncCde    = [%s]\n", pstruAppPolyGridTemp->sInsrncCde);                  
	printf("pstruAppPolyGridTemp->sUndrPrsn     = [%s]\n", pstruAppPolyGridTemp->sUndrPrsn);                 
	printf("pstruAppPolyGridTemp->sUndrDpt      = [%s]\n", pstruAppPolyGridTemp->sUndrDpt);                
	printf("pstruAppPolyGridTemp->sPrnTyp       = [%s]\n", pstruAppPolyGridTemp->sPrnTyp);               
	printf("pstruAppPolyGridTemp->sRinsrncMrk   = [%s]\n", pstruAppPolyGridTemp->sRinsrncMrk);                   
	printf("pstruAppPolyGridTemp->sCoinsrncMrk  = [%s]\n", pstruAppPolyGridTemp->sCoinsrncMrk);                    
	printf("pstruAppPolyGridTemp->sCplyNo       = [%s]\n", pstruAppPolyGridTemp->sCplyNo);               
	printf("pstruAppPolyGridTemp->sEdrNo        = [%s]\n", pstruAppPolyGridTemp->sEdrNo);              
	printf("pstruAppPolyGridTemp->sReadTime     = [%s]\n", pstruAppPolyGridTemp->sReadTime);                 
	printf("pstruAppPolyGridTemp->sRecNo        = [%s]\n", pstruAppPolyGridTemp->sRecNo);              
	printf("pstruAppPolyGridTemp->cWorkMrk      = [%d]\n", pstruAppPolyGridTemp->cWorkMrk);                
	printf("pstruAppPolyGridTemp->cFlag         = [%d]\n", pstruAppPolyGridTemp->cFlag);             
	printf("pstruAppPolyGridTemp->sAppNme       = [%s]\n", pstruAppPolyGridTemp->sAppNme);               
	printf("pstruAppPolyGridTemp->sApptTm       = [%s]\n", pstruAppPolyGridTemp->sApptTm);               
	printf("pstruAppPolyGridTemp->sSignTm       = [%s]\n", pstruAppPolyGridTemp->sSignTm);               
	printf("pstruAppPolyGridTemp->sInsrntNme    = [%s]\n", pstruAppPolyGridTemp->sInsrntNme);                  
	printf("pstruAppPolyGridTemp->sRptDesc      = [%s]\n", pstruAppPolyGridTemp->sRptDesc);                
	printf("pstruAppPolyGridTemp->sEdrTyp       = [%s]\n", pstruAppPolyGridTemp->sEdrTyp);               
	printf("pstruAppPolyGridTemp->sRiskLvlCde   = [%s]\n", pstruAppPolyGridTemp->sRiskLvlCde);                   
	printf("pstruAppPolyGridTemp->sLcnNo        = [%s]\n", pstruAppPolyGridTemp->sLcnNo);              
	printf("pstruAppPolyGridTemp->sEngNo        = [%s]\n", pstruAppPolyGridTemp->sEngNo);              
	printf("pstruAppPolyGridTemp->sInsrncCls    = [%s]\n", pstruAppPolyGridTemp->sInsrncCls);                  
	printf("pstruAppPolyGridTemp->sAppTyp       = [%s]\n", pstruAppPolyGridTemp->sAppTyp);               
	printf("pstruAppPolyGridTemp->sUseAtr       = [%s]\n", pstruAppPolyGridTemp->sUseAtr);               
	printf("pstruAppPolyGridTemp->sUndrOpn      = [%s]\n", pstruAppPolyGridTemp->sUndrOpn);                
	printf("pstruAppPolyGridTemp->sInternetTyp  = [%s]\n\n", pstruAppPolyGridTemp->sInternetTyp);                    
}


void struAppPolyGridOrderConvt(char *pBuff)
{
	plyAppPolyGridStru struAppPolyGrid;
	memcpy(&struAppPolyGrid, pBuff, sizeof(plyAppPolyGridStru));

	struAppPolyGrid.nVrfyMrk = AIcom_ConvertInt1(struAppPolyGrid.nVrfyMrk);

	memcpy(pBuff, &struAppPolyGrid, sizeof(plyAppPolyGridStru));
	return ;
}







