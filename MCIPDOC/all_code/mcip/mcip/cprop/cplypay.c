#include "typeconvt.h"
#include "AiConvert.h"
#include "cplypay.h"




int StrToStruPay(char** ppstring, int *plenStr, plyPayStru *pstruPay)
{
	int j, k;
	if(*ppstring==NULL) return 1;

	j=k=0;
	do
	{
		j++;    if(ToStringField(ppstring,  plenStr,  (pstruPay->sCrtCde)    , C_CRT_CDE_LEN      )==FALSE) break;    else k++;
		j++;    if(ToStringField(ppstring,  plenStr,  (pstruPay->sCrtTm)     , TIME_LEN           )==FALSE) break;    else k++;
		j++;    if(ToStringField(ppstring,  plenStr,  (pstruPay->sUpdCde)    , C_UPD_CDE_LEN      )==FALSE) break;    else k++;
		j++;    if(ToStringField(ppstring,  plenStr,  (pstruPay->sUpdTm)     , TIME_LEN           )==FALSE) break;    else k++;
		j++;    if(ToStringField(ppstring,  plenStr,  (pstruPay->sCplyAppNo) , C_PLY_APP_NO_LEN   )==FALSE) break;    else k++;
		j++;    if(ToIntField(ppstring,  plenStr,    &(pstruPay->nTms)        )==FALSE) break;    else k++;
		j++;    if(ToStringField(ppstring,  plenStr,  (pstruPay->sRcptNo)    , C_RCPT_NO_LEN      )==FALSE) break;    else k++;
		j++;    if(ToStringField(ppstring,  plenStr,  (pstruPay->sPayPrsnCde), C_PAY_PRSN_CDE_LEN )==FALSE) break;    else k++;
		j++;    if(ToStringField(ppstring,  plenStr,  (pstruPay->sPayPrsnNme), C_PAY_PRSN_NME_LEN )==FALSE) break;    else k++;
		j++;    if(ToDoubleField(ppstring,  plenStr, &(pstruPay->fGetPrm)     )==FALSE) break;    else k++;
		j++;    if(ToStringField(ppstring,  plenStr,  (pstruPay->sPayMdeCde) , C_PAY_MDE_CDE_LEN  )==FALSE) break;    else k++;
		j++;    if(ToStringField(ppstring,  plenStr,  (pstruPay->sAccntNo)   , C_ACCNT_NO_LEN     )==FALSE) break;    else k++;
		j++;    if(ToStringField(ppstring,  plenStr,  (pstruPay->sPayLmtTm)  , DATE_LEN           )==FALSE) break;    else k++;
		j++;    if(ToDoubleField(ppstring,  plenStr, &(pstruPay->fGotPrm)     )==FALSE) break;    else k++;
		j++;    if(ToStringField(ppstring,  plenStr,  (pstruPay->sPayStrtTm) , DATE_LEN           )==FALSE) break;    else k++;
		j++;    if(ToStringField(ppstring,  plenStr,  (pstruPay->sPayTm)     , DATE_LEN           )==FALSE) break;    else k++;
		j++;    if(ToStringField(ppstring,  plenStr,  (pstruPay->sInsrncCde) , C_INSRNC_CDE_LEN   )==FALSE) break;    else k++;
		j++;    if(ToStringField(ppstring,  plenStr,  (pstruPay->sCurTyp)    , C_CUR_TYP_LEN      )==FALSE) break;    else k++;
		j++;    if(ToStringField(ppstring,  plenStr,  (pstruPay->sRecNo)     , C_REC_NO_LEN       )==FALSE) break;    else k++;
		j++;    if(ToStringField(ppstring,  plenStr,  (pstruPay->sPrnTyp)    , C_PRN_TYP_LEN      )==FALSE) break;    else k++;
	}while(0);
	if(j!=k) 
	{	
		#ifdef _DEBUG
		printf("StrToStruPay failed: Field index = %d\n", j);
		#endif
		return 0-j;
	}
	return 0;
}



void PrintStruPay(const plyPayStru *pstruPayTemp)
{
	printf("pstruPayTemp->sCrtCde    = [%s]\n", pstruPayTemp->sCrtCde);                     
	printf("pstruPayTemp->sCrtTm     = [%s]\n", pstruPayTemp->sCrtTm);                     
	printf("pstruPayTemp->sUpdCde    = [%s]\n", pstruPayTemp->sUpdCde);                     
	printf("pstruPayTemp->sUpdTm     = [%s]\n", pstruPayTemp->sUpdTm);                     
	printf("pstruPayTemp->sCplyAppNo = [%s]\n", pstruPayTemp->sCplyAppNo);                     
	printf("pstruPayTemp->nTms       = [%d]\n", pstruPayTemp->nTms);                     
	printf("pstruPayTemp->sRcptNo    = [%s]\n", pstruPayTemp->sRcptNo);                     
	printf("pstruPayTemp->sPayPrsnCde= [%s]\n", pstruPayTemp->sPayPrsnCde);                     
	printf("pstruPayTemp->sPayPrsnNme= [%s]\n", pstruPayTemp->sPayPrsnNme);                     
	printf("pstruPayTemp->fGetPrm    = [%f]\n", pstruPayTemp->fGetPrm);                     
	printf("pstruPayTemp->sPayMdeCde = [%s]\n", pstruPayTemp->sPayMdeCde);                     
	printf("pstruPayTemp->sAccntNo   = [%s]\n", pstruPayTemp->sAccntNo);                     
	printf("pstruPayTemp->sPayLmtTm  = [%s]\n", pstruPayTemp->sPayLmtTm);                     
	printf("pstruPayTemp->fGotPrm    = [%f]\n", pstruPayTemp->fGotPrm);                     
	printf("pstruPayTemp->sPayStrtTm = [%s]\n", pstruPayTemp->sPayStrtTm);                     
	printf("pstruPayTemp->sPayTm     = [%s]\n", pstruPayTemp->sPayTm);                     
	printf("pstruPayTemp->sInsrncCde = [%s]\n", pstruPayTemp->sInsrncCde);                     
	printf("pstruPayTemp->sCurTyp    = [%s]\n", pstruPayTemp->sCurTyp);                     
	printf("pstruPayTemp->sRecNo     = [%s]\n", pstruPayTemp->sRecNo);                     
	printf("pstruPayTemp->sPrnTyp    = [%s]\n\n", pstruPayTemp->sPrnTyp);                     
}






void struPayOrderConvt(char *pBuff)
{
	plyPayStru struPay;
	memcpy(&struPay, pBuff, sizeof(plyPayStru));
	struPay.nTms      = AIcom_ConvertInt1(struPay.nTms);   
	struPay.fGetPrm   = AIcom_ConvertDouble1(struPay.fGetPrm);
	struPay.fGotPrm   = AIcom_ConvertDouble1(struPay.fGotPrm);
	memcpy(pBuff, &struPay, sizeof(plyPayStru));
	return ;
}




