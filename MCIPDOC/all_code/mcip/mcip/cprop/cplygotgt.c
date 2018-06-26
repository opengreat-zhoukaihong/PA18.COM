#include "typeconvt.h"
#include "AiConvert.h"
#include "cplygotgt.h"





int StrToStruGoTgt(char** ppstring, int *plenStr, plyGoTgtStru *pstruGoTgt)
{
	int j, k;
	if(*ppstring==NULL) return 1;

	j=k=0;
	do
	{
		j++;    if(ToStringField(ppstring,  plenStr,  (pstruGoTgt->sCrtCde)     , C_CRT_CDE_LEN     )==FALSE) break;    else k++;
		j++;    if(ToStringField(ppstring,  plenStr,  (pstruGoTgt->sCrtTm)      , TIME_LEN          )==FALSE) break;    else k++;
		j++;    if(ToStringField(ppstring,  plenStr,  (pstruGoTgt->sUpdCde)     , C_UPD_CDE_LEN     )==FALSE) break;    else k++;
		j++;    if(ToStringField(ppstring,  plenStr,  (pstruGoTgt->sUpdTm)      , TIME_LEN          )==FALSE) break;    else k++;
		j++;    if(ToStringField(ppstring,  plenStr,  (pstruGoTgt->sCplyAppNo)  , C_PLY_APP_NO_LEN  )==FALSE) break;    else k++;
		j++;    if(ToStringField(ppstring,  plenStr,  (pstruGoTgt->sCrgoCde)    , C_CRGO_CDE_LEN    )==FALSE) break;    else k++;
		j++;    if(ToStringField(ppstring,  plenStr,  (pstruGoTgt->sCrgoCnm)    , C_CRGO_CNM_LEN    )==FALSE) break;    else k++;
		j++;    if(ToStringField(ppstring,  plenStr,  (pstruGoTgt->sCrgoDesc)   , C_CRGO_DESC_LEN   )==FALSE) break;    else k++;
		j++;    if(ToStringField(ppstring,  plenStr,  (pstruGoTgt->sInvcNo)     , C_INVC_NO_LEN     )==FALSE) break;    else k++;
		j++;    if(ToStringField(ppstring,  plenStr,  (pstruGoTgt->sSailNo)     , C_SAIL_NO_LEN     )==FALSE) break;    else k++;
		j++;    if(ToStringField(ppstring,  plenStr,  (pstruGoTgt->sPrnFrm)     , C_PRN_FRM_LEN     )==FALSE) break;    else k++;
		j++;    if(ToStringField(ppstring,  plenStr,  (pstruGoTgt->sCarriageCde), C_CARRIAGE_CDE_LEN)==FALSE) break;    else k++;
		j++;    if(ToStringField(ppstring,  plenStr,  (pstruGoTgt->sVslLvlCde)  , C_VSL_LVL_CDE_LEN )==FALSE) break;    else k++;
		j++;    if(ToStringField(ppstring,  plenStr,  (pstruGoTgt->sFromPrt)    , C_FROM_PRT_LEN    )==FALSE) break;    else k++;
		j++;    if(ToStringField(ppstring,  plenStr,  (pstruGoTgt->sToPrt)      , C_TO_PRT_LEN      )==FALSE) break;    else k++;
		j++;    if(ToStringField(ppstring,  plenStr,  (pstruGoTgt->sFrmPrtAra)  , C_FRM_PRT_ARA_LEN )==FALSE) break;    else k++;
		j++;    if(ToStringField(ppstring,  plenStr,  (pstruGoTgt->sToPrtAra)   , C_TO_PRT_ARA_LEN  )==FALSE) break;    else k++;
		j++;    if(ToStringField(ppstring,  plenStr,  (pstruGoTgt->sPassPrt)    , C_PASS_PRT_LEN    )==FALSE) break;    else k++;
		j++;    if(ToStringField(ppstring,  plenStr,  (pstruGoTgt->sSrvyCde)    , C_SRVY_CDE_LEN    )==FALSE) break;    else k++;
		j++;    if(ToStringField(ppstring,  plenStr,  (pstruGoTgt->sSrvyCnm)    , C_SRVY_CNM_LEN    )==FALSE) break;    else k++;
		j++;    if(ToStringField(ppstring,  plenStr,  (pstruGoTgt->sUndrCndtn)  , C_UNDR_CNDTN_LEN  )==FALSE) break;    else k++;
		j++;    if(ToDoubleField(ppstring,  plenStr, &(pstruGoTgt->fTgtAmt)     )==FALSE) break;    else k++;
		j++;    if(ToDoubleField(ppstring,  plenStr, &(pstruGoTgt->fRate)       )==FALSE) break;    else k++;
		j++;    if(ToDoubleField(ppstring,  plenStr, &(pstruGoTgt->fTgtPrm)     )==FALSE) break;    else k++;
		j++;    if(ToStringField(ppstring,  plenStr,  (pstruGoTgt->sPayAddr)    , C_PAY_ADDR_LEN    )==FALSE) break;    else k++;
		j++;    if(ToStringField(ppstring,  plenStr,  (pstruGoTgt->sRecNo)      , C_REC_NO_LEN      )==FALSE) break;    else k++;
		j++;    if(ToStringField(ppstring,  plenStr,  (pstruGoTgt->sReceiptNo)  , C_RECEIPT_NO_LEN  )==FALSE) break;    else k++;
		j++;    if(ToStringField(ppstring,  plenStr,  (pstruGoTgt->sCrgoCls)    , C_CRGO_CLS_LEN    )==FALSE) break;    else k++;
		j++;    if(ToStringField(ppstring,  plenStr,  (pstruGoTgt->sCrgoName)   , C_CRGO_NAME_LEN   )==FALSE) break;    else k++;
		j++;    if(ToStringField(ppstring,  plenStr,  (pstruGoTgt->samount)     , C_AMOUNT_LEN      )==FALSE) break;    else k++;
		j++;    if(ToStringField(ppstring,  plenStr,  (pstruGoTgt->sPackCde)    , C_PACK_CDE_LEN    )==FALSE) break;    else k++;
		j++;    if(ToStringField(ppstring,  plenStr,  (pstruGoTgt->sMark)       , C_MARK_LEN        )==FALSE) break;    else k++;
		j++;    if(ToDoubleField(ppstring,  plenStr, &(pstruGoTgt->fInvcAmt)    )==FALSE) break;    else k++;
		j++;    if(ToStringField(ppstring,  plenStr,  (pstruGoTgt->sInvcAmtCur) , C_INVC_AMT_CUR_LEN)==FALSE) break;    else k++;
		j++;    if(ToStringField(ppstring,  plenStr,  (pstruGoTgt->sNoRepay)    , C_NO_REPAY_LEN    )==FALSE) break;    else k++;
		j++;    if(ToStringField(ppstring,  plenStr,  (pstruGoTgt->sCreditId)   , C_CREDIT_ID_LEN   )==FALSE) break;    else k++;
		j++;    if(ToStringField(ppstring,  plenStr,  (pstruGoTgt->sLostDesc)   , C_LOST_DESC_LEN   )==FALSE) break;    else k++;
		j++;    if(ToStringField(ppstring,  plenStr,  (pstruGoTgt->sContainer)  , C_CONTAINER_LEN   )==FALSE) break;    else k++;
		j++;    if(ToStringField(ppstring,  plenStr,  (pstruGoTgt->sAddRisk)    , C_ADD_RISK_LEN    )==FALSE) break;    else k++;
		j++;    if(ToStringField(ppstring,  plenStr,  (pstruGoTgt->sPackCnm)    , C_PACK_CNM_LEN    )==FALSE) break;    else k++;
		j++;    if(ToStringField(ppstring,  plenStr,  (pstruGoTgt->sSrvyAddr)   , C_SRVY_ADDR_LEN   )==FALSE) break;    else k++;
		j++;    if(ToStringField(ppstring,  plenStr,  (pstruGoTgt->sEdrInfo)    , C_EDR_INFO_LEN    )==FALSE) break;    else k++;
	}while(0);
	if(j!=k) 
	{	
		#ifdef _DEBUG
		printf("StrToStruGoTgt failed: Field index = %d\n", j);
		#endif
		return 0-j;
	}
	return 0;
}



void PrintStruGoTgt(const plyGoTgtStru *pstruGoTgtTemp)
{
	printf("pstruGoTgtTemp->sCrtCde      = [%s]\n", pstruGoTgtTemp->sCrtCde);                      
	printf("pstruGoTgtTemp->sCrtTm       = [%s]\n", pstruGoTgtTemp->sCrtTm);                      
	printf("pstruGoTgtTemp->sUpdCde      = [%s]\n", pstruGoTgtTemp->sUpdCde);                      
	printf("pstruGoTgtTemp->sUpdTm       = [%s]\n", pstruGoTgtTemp->sUpdTm);                      
	printf("pstruGoTgtTemp->sCplyAppNo   = [%s]\n", pstruGoTgtTemp->sCplyAppNo);                      
	printf("pstruGoTgtTemp->sCrgoCde     = [%s]\n", pstruGoTgtTemp->sCrgoCde);                      
	printf("pstruGoTgtTemp->sCrgoCnm     = [%s]\n", pstruGoTgtTemp->sCrgoCnm);                      
	printf("pstruGoTgtTemp->sCrgoDesc    = [%s]\n", pstruGoTgtTemp->sCrgoDesc);                      
	printf("pstruGoTgtTemp->sInvcNo      = [%s]\n", pstruGoTgtTemp->sInvcNo);                      
	printf("pstruGoTgtTemp->sSailNo      = [%s]\n", pstruGoTgtTemp->sSailNo);                      
	printf("pstruGoTgtTemp->sPrnFrm      = [%s]\n", pstruGoTgtTemp->sPrnFrm);                      
	printf("pstruGoTgtTemp->sCarriageCde = [%s]\n", pstruGoTgtTemp->sCarriageCde);                      
	printf("pstruGoTgtTemp->sVslLvlCde   = [%s]\n", pstruGoTgtTemp->sVslLvlCde);                      
	printf("pstruGoTgtTemp->sFromPrt     = [%s]\n", pstruGoTgtTemp->sFromPrt);                      
	printf("pstruGoTgtTemp->sToPrt       = [%s]\n", pstruGoTgtTemp->sToPrt);                      
	printf("pstruGoTgtTemp->sFrmPrtAra   = [%s]\n", pstruGoTgtTemp->sFrmPrtAra);                      
	printf("pstruGoTgtTemp->sToPrtAra    = [%s]\n", pstruGoTgtTemp->sToPrtAra);                      
	printf("pstruGoTgtTemp->sPassPrt     = [%s]\n", pstruGoTgtTemp->sPassPrt);                      
	printf("pstruGoTgtTemp->sSrvyCde     = [%s]\n", pstruGoTgtTemp->sSrvyCde);                      
	printf("pstruGoTgtTemp->sSrvyCnm     = [%s]\n", pstruGoTgtTemp->sSrvyCnm);                      
	printf("pstruGoTgtTemp->sUndrCndtn   = [%s]\n", pstruGoTgtTemp->sUndrCndtn);                      
	printf("pstruGoTgtTemp->fTgtAmt      = [%f]\n", pstruGoTgtTemp->fTgtAmt);                      
	printf("pstruGoTgtTemp->fRate        = [%f]\n", pstruGoTgtTemp->fRate);                      
	printf("pstruGoTgtTemp->fTgtPrm      = [%f]\n", pstruGoTgtTemp->fTgtPrm);                      
	printf("pstruGoTgtTemp->sPayAddr     = [%s]\n", pstruGoTgtTemp->sPayAddr);                      
	printf("pstruGoTgtTemp->sRecNo       = [%s]\n", pstruGoTgtTemp->sRecNo);                      
	printf("pstruGoTgtTemp->sReceiptNo   = [%s]\n", pstruGoTgtTemp->sReceiptNo);                      
	printf("pstruGoTgtTemp->sCrgoCls     = [%s]\n", pstruGoTgtTemp->sCrgoCls);                      
	printf("pstruGoTgtTemp->sCrgoName    = [%s]\n", pstruGoTgtTemp->sCrgoName);                      
	printf("pstruGoTgtTemp->samount      = [%s]\n", pstruGoTgtTemp->samount);                      
	printf("pstruGoTgtTemp->sPackCde     = [%s]\n", pstruGoTgtTemp->sPackCde);                      
	printf("pstruGoTgtTemp->sMark        = [%s]\n", pstruGoTgtTemp->sMark);                      
	printf("pstruGoTgtTemp->fInvcAmt     = [%f]\n", pstruGoTgtTemp->fInvcAmt);                      
	printf("pstruGoTgtTemp->sInvcAmtCur  = [%s]\n", pstruGoTgtTemp->sInvcAmtCur);                      
	printf("pstruGoTgtTemp->sNoRepay     = [%s]\n", pstruGoTgtTemp->sNoRepay);                      
	printf("pstruGoTgtTemp->sCreditId    = [%s]\n", pstruGoTgtTemp->sCreditId);                      
	printf("pstruGoTgtTemp->sLostDesc    = [%s]\n", pstruGoTgtTemp->sLostDesc);                      
	printf("pstruGoTgtTemp->sContainer   = [%s]\n", pstruGoTgtTemp->sContainer);                      
	printf("pstruGoTgtTemp->sAddRisk     = [%s]\n", pstruGoTgtTemp->sAddRisk);  
	printf("pstruGoTgtTemp->sPackCnm     = [%s]\n", pstruGoTgtTemp->sPackCnm);  
	printf("pstruGoTgtTemp->sSrvyAddr    = [%s]\n", pstruGoTgtTemp->sSrvyAddr);  
	printf("pstruGoTgtTemp->sEdrInfo     = [%s]\n\n", pstruGoTgtTemp->sEdrInfo);  
}




void struGoTgtOrderConvt(char *pBuff)
{
	plyGoTgtStru struGoTgt;
	memcpy(&struGoTgt, pBuff, sizeof(plyGoTgtStru));

	struGoTgt.fTgtAmt  = AIcom_ConvertDouble1(struGoTgt.fTgtAmt); 
	struGoTgt.fRate    = AIcom_ConvertDouble1(struGoTgt.fRate);   
	struGoTgt.fTgtPrm  = AIcom_ConvertDouble1(struGoTgt.fTgtPrm); 
	struGoTgt.fInvcAmt = AIcom_ConvertDouble1(struGoTgt.fInvcAmt);

	memcpy(pBuff, &struGoTgt, sizeof(plyGoTgtStru));
	return ;
}






