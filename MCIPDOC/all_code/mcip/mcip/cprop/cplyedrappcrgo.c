#include "typeconvt.h"
#include "AiConvert.h"
#include "cplyedrappcrgo.h"





int StrToStruPlyEdrappcrgo(char** ppstring, int *plenStr, plyEdrappcrgoStru *pstruPlyEdrappcrgo)
{
	int i, j;
	if(*ppstring==NULL) return 1;

	i=j=0;
	do
	{
		j++; if(ToStringField(ppstring, plenStr, (pstruPlyEdrappcrgo->sCrtCde     ), C_CRT_CDE_LEN     )==FALSE) break;    else i++;
		j++; if(ToStringField(ppstring, plenStr, (pstruPlyEdrappcrgo->sCrtTm      ), TIME_LEN          )==FALSE) break;    else i++;
		j++; if(ToStringField(ppstring, plenStr, (pstruPlyEdrappcrgo->sUpdCde     ), C_UPD_CDE_LEN     )==FALSE) break;    else i++;
		j++; if(ToStringField(ppstring, plenStr, (pstruPlyEdrappcrgo->sUpdTm      ), TIME_LEN          )==FALSE) break;    else i++;
		j++; if(ToStringField(ppstring, plenStr, (pstruPlyEdrappcrgo->sEdrAppNo   ), C_EDR_APP_NO_LEN  )==FALSE) break;    else i++;
		j++; if(ToStringField(ppstring, plenStr, (pstruPlyEdrappcrgo->sCrgoCde    ), C_CRGO_CDE_LEN    )==FALSE) break;    else i++;
		j++; if(ToStringField(ppstring, plenStr, (pstruPlyEdrappcrgo->sCrgoCnm    ), C_CRGO_CNM_LEN    )==FALSE) break;    else i++;
		j++; if(ToStringField(ppstring, plenStr, (pstruPlyEdrappcrgo->sCrgoDesc   ), C_CRGO_DESC_LEN   )==FALSE) break;    else i++;
		j++; if(ToStringField(ppstring, plenStr, (pstruPlyEdrappcrgo->sInvcNo     ), C_INVC_NO_LEN     )==FALSE) break;    else i++; 
		j++; if(ToStringField(ppstring, plenStr, (pstruPlyEdrappcrgo->sSailNo     ), C_SAIL_NO_LEN     )==FALSE) break;    else i++;
		j++; if(ToStringField(ppstring, plenStr, (pstruPlyEdrappcrgo->sPrnFrm     ), C_PRN_FRM_LEN     )==FALSE) break;    else i++;  
		j++; if(ToStringField(ppstring, plenStr, (pstruPlyEdrappcrgo->sCarriageCde), C_CARRIAGE_CDE_LEN)==FALSE) break;    else i++;
		j++; if(ToStringField(ppstring, plenStr, (pstruPlyEdrappcrgo->sVslLvlCde  ), C_VSL_LVL_CDE_LEN )==FALSE) break;    else i++;
		j++; if(ToStringField(ppstring, plenStr, (pstruPlyEdrappcrgo->sFromPrt    ), C_FROM_PRT_LEN    )==FALSE) break;    else i++;
		j++; if(ToStringField(ppstring, plenStr, (pstruPlyEdrappcrgo->sToPrt      ), C_TO_PRT_LEN      )==FALSE) break;    else i++;
		j++; if(ToStringField(ppstring, plenStr, (pstruPlyEdrappcrgo->sFrmPrtAra  ), C_FRM_PRT_ARA_LEN )==FALSE) break;    else i++;
		j++; if(ToStringField(ppstring, plenStr, (pstruPlyEdrappcrgo->sToPrtAra   ), C_TO_PRT_ARA_LEN  )==FALSE) break;    else i++;
		j++; if(ToStringField(ppstring, plenStr, (pstruPlyEdrappcrgo->sPassPrt    ), C_PASS_PRT_LEN    )==FALSE) break;    else i++;
		j++; if(ToStringField(ppstring, plenStr, (pstruPlyEdrappcrgo->sSrvyCde    ), C_SRVY_CDE_LEN    )==FALSE) break;    else i++;
		j++; if(ToStringField(ppstring, plenStr, (pstruPlyEdrappcrgo->sSrvyCnm    ), C_SRVY_CNM_LEN    )==FALSE) break;    else i++;
		j++; if(ToStringField(ppstring, plenStr, (pstruPlyEdrappcrgo->sUndrCndtn  ), C_UNDR_CNDTN_LEN  )==FALSE) break;    else i++;
		j++; if(ToDoubleField(ppstring, plenStr, &(pstruPlyEdrappcrgo->fTgtAmt     ))==FALSE) break;    else i++;
		j++; if(ToDoubleField(ppstring, plenStr, &(pstruPlyEdrappcrgo->fRate       ))==FALSE) break;    else i++;
		j++; if(ToDoubleField(ppstring, plenStr, &(pstruPlyEdrappcrgo->fTgtPrm     ))==FALSE) break;    else i++;
		j++; if(ToStringField(ppstring, plenStr, (pstruPlyEdrappcrgo->sPayAddr    ), C_PAY_ADDR_LEN    )==FALSE) break;    else i++;
		j++; if(ToStringField(ppstring, plenStr, (pstruPlyEdrappcrgo->sRecNo      ), C_REC_NO_LEN      )==FALSE) break;    else i++;

		j++; if(ToStringField(ppstring, plenStr, (pstruPlyEdrappcrgo->sReceiptNo  ), C_RECEIPT_NO_LEN  )==FALSE) break;    else i++;
		j++; if(ToStringField(ppstring, plenStr, (pstruPlyEdrappcrgo->sCrgoCls    ), C_CRGO_CLS_LEN    )==FALSE) break;    else i++;
		j++; if(ToStringField(ppstring, plenStr, (pstruPlyEdrappcrgo->sCrgoName   ), C_CRGO_NAME_LEN   )==FALSE) break;    else i++;
		j++; if(ToStringField(ppstring, plenStr, (pstruPlyEdrappcrgo->samount     ), C_AMOUNT_LEN      )==FALSE) break;    else i++;
		j++; if(ToStringField(ppstring, plenStr, (pstruPlyEdrappcrgo->sPackCde    ), C_PACK_CDE_LEN    )==FALSE) break;    else i++;
		j++; if(ToStringField(ppstring, plenStr, (pstruPlyEdrappcrgo->sMark       ), C_MARK_LEN        )==FALSE) break;    else i++;
		j++; if(ToDoubleField(ppstring, plenStr,&(pstruPlyEdrappcrgo->fInvcAmt    ))==FALSE) break;    else i++;
		j++; if(ToStringField(ppstring, plenStr, (pstruPlyEdrappcrgo->sInvcAmtCur ), C_INVC_AMT_CUR_LEN)==FALSE) break;    else i++;
		j++; if(ToStringField(ppstring, plenStr, (pstruPlyEdrappcrgo->sNoRepay    ), C_NO_REPAY_LEN    )==FALSE) break;    else i++;
		j++; if(ToStringField(ppstring, plenStr, (pstruPlyEdrappcrgo->sCreditId   ), C_CREDIT_ID_LEN   )==FALSE) break;    else i++;
		j++; if(ToStringField(ppstring, plenStr, (pstruPlyEdrappcrgo->sLostDesc   ), C_LOST_DESC_LEN   )==FALSE) break;    else i++;
		j++; if(ToStringField(ppstring, plenStr, (pstruPlyEdrappcrgo->sContainer  ), C_CONTAINER_LEN   )==FALSE) break;    else i++;
		j++; if(ToStringField(ppstring, plenStr, (pstruPlyEdrappcrgo->sAddRisk    ), C_ADD_RISK_LEN    )==FALSE) break;    else i++;
		j++; if(ToStringField(ppstring, plenStr, (pstruPlyEdrappcrgo->sPackCnm    ), C_PACK_CNM_LEN    )==FALSE) break;    else i++;
		j++; if(ToStringField(ppstring, plenStr, (pstruPlyEdrappcrgo->sSrvyAddr   ), C_SRVY_ADDR_LEN   )==FALSE) break;    else i++;
		j++; if(ToStringField(ppstring, plenStr, (pstruPlyEdrappcrgo->sEdrInfo    ), C_EDR_INFO_LEN    )==FALSE) break;    else i++;
	
	}while(0);
	if(j!=i) 
	{	
		#ifdef _DEBUG
		printf("StrToStruPlyEdrappcrgo failed: Field index = %d\n", j);
		#endif
		return 0-i;
	}
	return 0;
}

void StruPlyEdrappcrgoToStr(plyEdrappcrgoStru *pstruPlyEdrappcrgo, char** ppstring, int *plenStr)
{
printf("pstruPlyEdrappcrgo->sAddRisk     =[%s]\n", pstruPlyEdrappcrgo->sAddRisk     );                                                                            
	StrToStr(pstruPlyEdrappcrgo->sCrtCde     , ppstring,  plenStr); 
	StrToStr(pstruPlyEdrappcrgo->sCrtTm      , ppstring,  plenStr); 
	StrToStr(pstruPlyEdrappcrgo->sUpdCde     , ppstring,  plenStr); 
	StrToStr(pstruPlyEdrappcrgo->sUpdTm      , ppstring,  plenStr); 
	StrToStr(pstruPlyEdrappcrgo->sEdrAppNo   , ppstring,  plenStr); 
	StrToStr(pstruPlyEdrappcrgo->sCrgoCde    , ppstring,  plenStr); 
	StrToStr(pstruPlyEdrappcrgo->sCrgoCnm    , ppstring,  plenStr); 
	StrToStr(pstruPlyEdrappcrgo->sCrgoDesc   , ppstring,  plenStr); 
	StrToStr(pstruPlyEdrappcrgo->sInvcNo     , ppstring,  plenStr);  
	StrToStr(pstruPlyEdrappcrgo->sSailNo     , ppstring,  plenStr); 
	StrToStr(pstruPlyEdrappcrgo->sPrnFrm     , ppstring,  plenStr);   
	StrToStr(pstruPlyEdrappcrgo->sCarriageCde, ppstring,  plenStr); 
	StrToStr(pstruPlyEdrappcrgo->sVslLvlCde  , ppstring,  plenStr); 
	StrToStr(pstruPlyEdrappcrgo->sFromPrt    , ppstring,  plenStr); 
	StrToStr(pstruPlyEdrappcrgo->sToPrt      , ppstring,  plenStr); 
	StrToStr(pstruPlyEdrappcrgo->sFrmPrtAra  , ppstring,  plenStr); 
	StrToStr(pstruPlyEdrappcrgo->sToPrtAra   , ppstring,  plenStr); 
	StrToStr(pstruPlyEdrappcrgo->sPassPrt    , ppstring,  plenStr); 
	StrToStr(pstruPlyEdrappcrgo->sSrvyCde    , ppstring,  plenStr); 
	StrToStr(pstruPlyEdrappcrgo->sSrvyCnm    , ppstring,  plenStr); 
	StrToStr(pstruPlyEdrappcrgo->sUndrCndtn  , ppstring,  plenStr); 
	DoubleToStr(pstruPlyEdrappcrgo->fTgtAmt     , ppstring,  plenStr); 
	DoubleToStr(pstruPlyEdrappcrgo->fRate       , ppstring,  plenStr); 
	DoubleToStr(pstruPlyEdrappcrgo->fTgtPrm     , ppstring,  plenStr); 
	StrToStr(pstruPlyEdrappcrgo->sPayAddr    , ppstring,  plenStr); 
	StrToStr(pstruPlyEdrappcrgo->sRecNo      , ppstring,  plenStr); 

	StrToStr(pstruPlyEdrappcrgo->sReceiptNo  , ppstring,  plenStr); 
	StrToStr(pstruPlyEdrappcrgo->sCrgoCls    , ppstring,  plenStr); 
	StrToStr(pstruPlyEdrappcrgo->sCrgoName   , ppstring,  plenStr); 
	StrToStr(pstruPlyEdrappcrgo->samount     , ppstring,  plenStr); 
	StrToStr(pstruPlyEdrappcrgo->sPackCde    , ppstring,  plenStr); 
	StrToStr(pstruPlyEdrappcrgo->sMark       , ppstring,  plenStr); 
	DoubleToStr(pstruPlyEdrappcrgo->fInvcAmt    , ppstring,  plenStr); 
	StrToStr(pstruPlyEdrappcrgo->sInvcAmtCur , ppstring,  plenStr); 
	StrToStr(pstruPlyEdrappcrgo->sNoRepay    , ppstring,  plenStr);  
	StrToStr(pstruPlyEdrappcrgo->sCreditId   , ppstring,  plenStr); 
	StrToStr(pstruPlyEdrappcrgo->sLostDesc   , ppstring,  plenStr);   
	StrToStr(pstruPlyEdrappcrgo->sContainer  , ppstring,  plenStr); 
	StrToStr(pstruPlyEdrappcrgo->sAddRisk    , ppstring,  plenStr); 
	StrToStr(pstruPlyEdrappcrgo->sPackCnm    , ppstring,  plenStr); 
	StrToStr(pstruPlyEdrappcrgo->sSrvyAddr   , ppstring,  plenStr); 
	StrToStr(pstruPlyEdrappcrgo->sEdrInfo    , ppstring,  plenStr); 

	return ;
}




void PrintStruPlyEdrappcrgo(const plyEdrappcrgoStru *pstruPlyEdrappcrgo)
{
	printf("pstruPlyEdrappcrgo->sCrtCde     =[%s]\n", pstruPlyEdrappcrgo->sCrtCde     );                                                                            
	printf("pstruPlyEdrappcrgo->sCrtTm      =[%s]\n", pstruPlyEdrappcrgo->sCrtTm      );                                                                            
	printf("pstruPlyEdrappcrgo->sUpdCde     =[%s]\n", pstruPlyEdrappcrgo->sUpdCde     );                                                                            
	printf("pstruPlyEdrappcrgo->sUpdTm      =[%s]\n", pstruPlyEdrappcrgo->sUpdTm      );                                                                            
	printf("pstruPlyEdrappcrgo->sEdrAppNo   =[%s]\n", pstruPlyEdrappcrgo->sEdrAppNo   );                                                                            
	printf("pstruPlyEdrappcrgo->sCrgoCde    =[%s]\n", pstruPlyEdrappcrgo->sCrgoCde    );                                                                            
	printf("pstruPlyEdrappcrgo->sCrgoCnm    =[%s]\n", pstruPlyEdrappcrgo->sCrgoCnm    );                                                                            
	printf("pstruPlyEdrappcrgo->sCrgoDesc   =[%s]\n", pstruPlyEdrappcrgo->sCrgoDesc   );                                                                            
	printf("pstruPlyEdrappcrgo->sInvcNo     =[%s]\n", pstruPlyEdrappcrgo->sInvcNo     );                                                                             
	printf("pstruPlyEdrappcrgo->sSailNo     =[%s]\n", pstruPlyEdrappcrgo->sSailNo     );                                                                            
	printf("pstruPlyEdrappcrgo->sPrnFrm     =[%s]\n", pstruPlyEdrappcrgo->sPrnFrm     );                                                                              
	printf("pstruPlyEdrappcrgo->sCarriageCde=[%s]\n", pstruPlyEdrappcrgo->sCarriageCde);                                                                            
	printf("pstruPlyEdrappcrgo->sVslLvlCde  =[%s]\n", pstruPlyEdrappcrgo->sVslLvlCde  );                                                                            
	printf("pstruPlyEdrappcrgo->sFromPrt    =[%s]\n", pstruPlyEdrappcrgo->sFromPrt    );                                                                            
	printf("pstruPlyEdrappcrgo->sToPrt      =[%s]\n", pstruPlyEdrappcrgo->sToPrt      );                                                                            
	printf("pstruPlyEdrappcrgo->sFrmPrtAra  =[%s]\n", pstruPlyEdrappcrgo->sFrmPrtAra  );                                                                            
	printf("pstruPlyEdrappcrgo->sToPrtAra   =[%s]\n", pstruPlyEdrappcrgo->sToPrtAra   );                                                                            
	printf("pstruPlyEdrappcrgo->sPassPrt    =[%s]\n", pstruPlyEdrappcrgo->sPassPrt    );                                                                            
	printf("pstruPlyEdrappcrgo->sSrvyCde    =[%s]\n", pstruPlyEdrappcrgo->sSrvyCde    );                                                                            
	printf("pstruPlyEdrappcrgo->sSrvyCnm    =[%s]\n", pstruPlyEdrappcrgo->sSrvyCnm    );                                                                            
	printf("pstruPlyEdrappcrgo->sUndrCndtn  =[%s]\n", pstruPlyEdrappcrgo->sUndrCndtn  );                                                                            
	printf("pstruPlyEdrappcrgo->fTgtAmt     =[%f]\n", pstruPlyEdrappcrgo->fTgtAmt     );                                                                            
	printf("pstruPlyEdrappcrgo->fRate       =[%f]\n", pstruPlyEdrappcrgo->fRate       );                                                                            
	printf("pstruPlyEdrappcrgo->fTgtPrm     =[%f]\n", pstruPlyEdrappcrgo->fTgtPrm     );                                                                            
	printf("pstruPlyEdrappcrgo->sPayAddr    =[%s]\n", pstruPlyEdrappcrgo->sPayAddr    );                                                                            
	printf("pstruPlyEdrappcrgo->sRecNo      =[%s]\n", pstruPlyEdrappcrgo->sRecNo      );                                                                            
	printf("pstruPlyEdrappcrgo->sReceiptNo  =[%s]\n", pstruPlyEdrappcrgo->sReceiptNo  );                                                                            
	printf("pstruPlyEdrappcrgo->sCrgoCls    =[%s]\n", pstruPlyEdrappcrgo->sCrgoCls    );                                                                            
	printf("pstruPlyEdrappcrgo->sCrgoName   =[%s]\n", pstruPlyEdrappcrgo->sCrgoName   );                                                                            
	printf("pstruPlyEdrappcrgo->samount     =[%s]\n", pstruPlyEdrappcrgo->samount     );                                                                            
	printf("pstruPlyEdrappcrgo->sPackCde    =[%s]\n", pstruPlyEdrappcrgo->sPackCde    );                                                                            
	printf("pstruPlyEdrappcrgo->sMark       =[%s]\n", pstruPlyEdrappcrgo->sMark       );                                                                            
	printf("pstruPlyEdrappcrgo->fInvcAmt    =[%f]\n", pstruPlyEdrappcrgo->fInvcAmt    );                                                                            
	printf("pstruPlyEdrappcrgo->sInvcAmtCur =[%s]\n", pstruPlyEdrappcrgo->sInvcAmtCur );                                                                            
	printf("pstruPlyEdrappcrgo->sNoRepay    =[%s]\n", pstruPlyEdrappcrgo->sNoRepay    );                                                                             
	printf("pstruPlyEdrappcrgo->sCreditId   =[%s]\n", pstruPlyEdrappcrgo->sCreditId   );                                                                            
	printf("pstruPlyEdrappcrgo->sLostDesc   =[%s]\n", pstruPlyEdrappcrgo->sLostDesc   );                                                                              
	printf("pstruPlyEdrappcrgo->sContainer  =[%s]\n", pstruPlyEdrappcrgo->sContainer  );                                                                            
	printf("pstruPlyEdrappcrgo->sAddRisk    =[%s]\n", pstruPlyEdrappcrgo->sAddRisk    );                                                                            
	printf("pstruPlyEdrappcrgo->sPackCnm    =[%s]\n", pstruPlyEdrappcrgo->sPackCnm    );                                                                            
	printf("pstruPlyEdrappcrgo->sSrvyAddr   =[%s]\n", pstruPlyEdrappcrgo->sSrvyAddr   );                                                                            
	printf("pstruPlyEdrappcrgo->sEdrInfo    =[%s]\n\n", pstruPlyEdrappcrgo->sEdrInfo  );                                                                            
        
	return;
}


void struPlyEdrappcrgoOrderConvt(char *pBuff)
{
	plyEdrappcrgoStru struPlyEdrappcrgo;
	memcpy(&struPlyEdrappcrgo, pBuff, sizeof(plyEdrappcrgoStru));

	struPlyEdrappcrgo.fTgtAmt = AIcom_ConvertDouble1(struPlyEdrappcrgo.fTgtAmt);
	struPlyEdrappcrgo.fRate   = AIcom_ConvertDouble1(struPlyEdrappcrgo.fRate  );
	struPlyEdrappcrgo.fTgtPrm = AIcom_ConvertDouble1(struPlyEdrappcrgo.fTgtPrm);
	struPlyEdrappcrgo.fInvcAmt = AIcom_ConvertDouble1(struPlyEdrappcrgo.fInvcAmt);

	memcpy(pBuff, &struPlyEdrappcrgo, sizeof(plyEdrappcrgoStru));
	return ;
}

