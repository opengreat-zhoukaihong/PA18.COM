#include "typeconvt.h"
#include "AiConvert.h"
#include "cplyedrapppay.h"




int StrToStruPlyEdrapppay(char** ppstring, int *plenStr, plyEdrapppayStru *pstruPlyEdrapppay)
{
	int i, j;
	if(*ppstring==NULL) return 1;

	i=j=0;
	do
	{
		j++; if(ToStringField(ppstring, plenStr, (pstruPlyEdrapppay->sCrtCde    ), C_CRT_CDE_LEN     )==FALSE) break;    else i++;
		j++; if(ToStringField(ppstring, plenStr, (pstruPlyEdrapppay->sCrtTm     ), TIME_LEN          )==FALSE) break;    else i++;
		j++; if(ToStringField(ppstring, plenStr, (pstruPlyEdrapppay->sUpdCde    ), C_UPD_CDE_LEN     )==FALSE) break;    else i++;
		j++; if(ToStringField(ppstring, plenStr, (pstruPlyEdrapppay->sUpdTm     ), TIME_LEN          )==FALSE) break;    else i++;
		j++; if(ToStringField(ppstring, plenStr, (pstruPlyEdrapppay->sEdrAppNo  ), C_EDR_APP_NO_LEN  )==FALSE) break;    else i++;
		j++; if(ToIntField(ppstring, plenStr, &(pstruPlyEdrapppay->nTms       ))==FALSE) break;    else i++;
		j++; if(ToStringField(ppstring, plenStr, (pstruPlyEdrapppay->sRcptNo    ), C_RCPT_NO_LEN     )==FALSE) break;    else i++;
		j++; if(ToStringField(ppstring, plenStr, (pstruPlyEdrapppay->sPayPrsnCde), C_PAY_PRSN_CDE_LEN)==FALSE) break;    else i++;
		j++; if(ToStringField(ppstring, plenStr, (pstruPlyEdrapppay->sPayPrsnNme), C_PAY_PRSN_NME_LEN)==FALSE) break;    else i++; 
		j++; if(ToDoubleField(ppstring, plenStr, &(pstruPlyEdrapppay->fGetPrm    ))==FALSE) break;    else i++;
		j++; if(ToStringField(ppstring, plenStr, (pstruPlyEdrapppay->sPayMdeCde ), C_PAY_MDE_CDE_LEN )==FALSE) break;    else i++;  
		j++; if(ToStringField(ppstring, plenStr, (pstruPlyEdrapppay->sAccntNo   ), C_ACCNT_NO_LEN    )==FALSE) break;    else i++;
		j++; if(ToStringField(ppstring, plenStr, (pstruPlyEdrapppay->sPayLmtTm  ), DATE_LEN          )==FALSE) break;    else i++;
		j++; if(ToDoubleField(ppstring, plenStr, &(pstruPlyEdrapppay->fGotPrm    ))==FALSE) break;    else i++;
		j++; if(ToStringField(ppstring, plenStr, (pstruPlyEdrapppay->sPayStrtTm ), DATE_LEN          )==FALSE) break;    else i++;
		j++; if(ToStringField(ppstring, plenStr, (pstruPlyEdrapppay->sPayTm     ), DATE_LEN          )==FALSE) break;    else i++;
		j++; if(ToStringField(ppstring, plenStr, (pstruPlyEdrapppay->sInsrncCde ), C_INSRNC_CDE_LEN  )==FALSE) break;    else i++;
		j++; if(ToStringField(ppstring, plenStr, (pstruPlyEdrapppay->sCurTyp    ), C_CUR_TYP_LEN     )==FALSE) break;    else i++;
		j++; if(ToStringField(ppstring, plenStr, (pstruPlyEdrapppay->sRecNo     ), C_REC_NO_LEN      )==FALSE) break;    else i++;
		j++; if(ToStringField(ppstring, plenStr, (pstruPlyEdrapppay->sPrnTyp    ), C_PRN_TYP_LEN     )==FALSE) break;    else i++;
	}while(0);
	if(j!=i) 
	{	
		#ifdef _DEBUG
		printf("StrToStruPlyEdrapppay failed: Field index = %d\n", j);
		#endif
		return 0-i;
	}
	return 0;
}

void StruPlyEdrapppayToStr(plyEdrapppayStru *pstruPlyEdrapppay, char** ppstring, int *plenStr)
{
	StrToStr(pstruPlyEdrapppay->sCrtCde    , ppstring,  plenStr); 
	StrToStr(pstruPlyEdrapppay->sCrtTm     , ppstring,  plenStr); 
	StrToStr(pstruPlyEdrapppay->sUpdCde    , ppstring,  plenStr); 
	StrToStr(pstruPlyEdrapppay->sUpdTm     , ppstring,  plenStr); 
	StrToStr(pstruPlyEdrapppay->sEdrAppNo  , ppstring,  plenStr); 
	IntToStr(pstruPlyEdrapppay->nTms       , ppstring,  plenStr); 
	StrToStr(pstruPlyEdrapppay->sRcptNo    , ppstring,  plenStr); 
	StrToStr(pstruPlyEdrapppay->sPayPrsnCde, ppstring,  plenStr); 
	StrToStr(pstruPlyEdrapppay->sPayPrsnNme, ppstring,  plenStr);  
	DoubleToStr(pstruPlyEdrapppay->fGetPrm    , ppstring,  plenStr); 
	StrToStr(pstruPlyEdrapppay->sPayMdeCde , ppstring,  plenStr);   
	StrToStr(pstruPlyEdrapppay->sAccntNo   , ppstring,  plenStr); 
	StrToStr(pstruPlyEdrapppay->sPayLmtTm  , ppstring,  plenStr); 
	DoubleToStr(pstruPlyEdrapppay->fGotPrm    , ppstring,  plenStr); 
	StrToStr(pstruPlyEdrapppay->sPayStrtTm , ppstring,  plenStr); 
	StrToStr(pstruPlyEdrapppay->sPayTm     , ppstring,  plenStr); 
	StrToStr(pstruPlyEdrapppay->sInsrncCde , ppstring,  plenStr); 
	StrToStr(pstruPlyEdrapppay->sCurTyp    , ppstring,  plenStr); 
	StrToStr(pstruPlyEdrapppay->sRecNo     , ppstring,  plenStr); 
	StrToStr(pstruPlyEdrapppay->sPrnTyp    , ppstring,  plenStr); 
	return ;
}




void PrintStruPlyEdrapppay(const plyEdrapppayStru *pstruPlyEdrapppay)
{
	printf("pstruPlyEdrapppay->sCrtCde    =[%s]\n", pstruPlyEdrapppay->sCrtCde    );                                                                            
	printf("pstruPlyEdrapppay->sCrtTm     =[%s]\n", pstruPlyEdrapppay->sCrtTm     );                                                                            
	printf("pstruPlyEdrapppay->sUpdCde    =[%s]\n", pstruPlyEdrapppay->sUpdCde    );                                                                            
	printf("pstruPlyEdrapppay->sUpdTm     =[%s]\n", pstruPlyEdrapppay->sUpdTm     );                                                                            
	printf("pstruPlyEdrapppay->sEdrAppNo  =[%s]\n", pstruPlyEdrapppay->sEdrAppNo  );                                                                            
	printf("pstruPlyEdrapppay->nTms       =[%d]\n", pstruPlyEdrapppay->nTms       );                                                                            
	printf("pstruPlyEdrapppay->sRcptNo    =[%s]\n", pstruPlyEdrapppay->sRcptNo    );                                                                            
	printf("pstruPlyEdrapppay->sPayPrsnCde=[%s]\n", pstruPlyEdrapppay->sPayPrsnCde);                                                                            
	printf("pstruPlyEdrapppay->sPayPrsnNme=[%s]\n", pstruPlyEdrapppay->sPayPrsnNme);                                                                             
	printf("pstruPlyEdrapppay->fGetPrm    =[%f]\n", pstruPlyEdrapppay->fGetPrm    );                                                                            
	printf("pstruPlyEdrapppay->sPayMdeCde =[%s]\n", pstruPlyEdrapppay->sPayMdeCde );                                                                              
	printf("pstruPlyEdrapppay->sAccntNo   =[%s]\n", pstruPlyEdrapppay->sAccntNo   );                                                                            
	printf("pstruPlyEdrapppay->sPayLmtTm  =[%s]\n", pstruPlyEdrapppay->sPayLmtTm  );                                                                            
	printf("pstruPlyEdrapppay->fGotPrm    =[%f]\n", pstruPlyEdrapppay->fGotPrm    );                                                                            
	printf("pstruPlyEdrapppay->sPayStrtTm =[%s]\n", pstruPlyEdrapppay->sPayStrtTm );                                                                            
	printf("pstruPlyEdrapppay->sPayTm     =[%s]\n", pstruPlyEdrapppay->sPayTm     );                                                                            
	printf("pstruPlyEdrapppay->sInsrncCde =[%s]\n", pstruPlyEdrapppay->sInsrncCde );                                                                            
	printf("pstruPlyEdrapppay->sCurTyp    =[%s]\n", pstruPlyEdrapppay->sCurTyp    );                                                                            
	printf("pstruPlyEdrapppay->sRecNo     =[%s]\n", pstruPlyEdrapppay->sRecNo     );                                                                            
	printf("pstruPlyEdrapppay->sPrnTyp    =[%s]\n\n", pstruPlyEdrapppay->sPrnTyp    );                                                                            
	return;
}


void struPlyEdrapppayOrderConvt(char *pBuff)
{
	plyEdrapppayStru struPlyEdrapppay;
	memcpy(&struPlyEdrapppay, pBuff, sizeof(plyEdrapppayStru));

	struPlyEdrapppay.nTms = AIcom_ConvertInt1(struPlyEdrapppay.nTms);
	struPlyEdrapppay.fGetPrm = AIcom_ConvertDouble1(struPlyEdrapppay.fGetPrm);
	struPlyEdrapppay.fGotPrm = AIcom_ConvertDouble1(struPlyEdrapppay.fGotPrm);

	memcpy(pBuff, &struPlyEdrapppay, sizeof(plyEdrapppayStru));
	return ;
}

