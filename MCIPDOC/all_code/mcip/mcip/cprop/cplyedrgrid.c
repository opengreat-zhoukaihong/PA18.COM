#include "typeconvt.h"
#include "AiConvert.h"
#include "cplyedrgrid.h"




int StrToStruPlyEdrGrid(char** ppstring, int *plenStr, plyEdrGridStru *pstruPlyEdrGrid)
{
	int i, j;
	int iTemp;
	if(*ppstring==NULL) return 1;

	i=j=0;
	do
	{
		j++; if(ToStringField(ppstring, plenStr, (pstruPlyEdrGrid->sCrtCde      ), C_CRT_CDE_LEN       )==FALSE) break;    else i++;
		j++; if(ToStringField(ppstring, plenStr, (pstruPlyEdrGrid->sCrtTm       ), TIME_LEN            )==FALSE) break;    else i++;
		j++; if(ToStringField(ppstring, plenStr, (pstruPlyEdrGrid->sUpdCde      ), C_UPD_CDE_LEN       )==FALSE) break;    else i++;
		j++; if(ToStringField(ppstring, plenStr, (pstruPlyEdrGrid->sUpdTm       ), TIME_LEN            )==FALSE) break;    else i++;
		j++; if(ToStringField(ppstring, plenStr, (pstruPlyEdrGrid->sDocNo       ), C_DOC_NO_LEN        )==FALSE) break;    else i++;
		j++; if(ToStringField(ppstring, plenStr, (pstruPlyEdrGrid->sSendTm      ), TIME_LEN            )==FALSE) break;    else i++;
		j++; if(ToStringField(ppstring, plenStr, (pstruPlyEdrGrid->sBlgDptCde   ), C_BLG_DPT_CDE_LEN   )==FALSE) break;    else i++;
		j++; if(ToStringField(ppstring, plenStr, (pstruPlyEdrGrid->sSource      ), C_SOURCE_LEN        )==FALSE) break;    else i++;
		j++; if(ToStringField(ppstring, plenStr, (pstruPlyEdrGrid->sSendDptCde  ), C_SEND_DPT_CDE_LEN  )==FALSE) break;    else i++; 
		j++; if(ToStringField(ppstring, plenStr, (pstruPlyEdrGrid->sSendCde     ), C_SEND_CDE_LEN      )==FALSE) break;    else i++;
		j++; if(ToStringField(ppstring, plenStr, (pstruPlyEdrGrid->sDesDptCde   ), C_DES_DPT_CDE_LEN   )==FALSE) break;    else i++;  
		j++; if(ToStringField(ppstring, plenStr, (pstruPlyEdrGrid->sEmergency   ), C_EMERGENCY_LEN     )==FALSE) break;    else i++;
		j++; if(ToStringField(ppstring, plenStr, (pstruPlyEdrGrid->sAuthPrnCde  ), C_AUTH_PRN_CDE_LEN  )==FALSE) break;    else i++;
		j++; if(ToStringField(ppstring, plenStr, (pstruPlyEdrGrid->sUdrMrk      ), C_UDR_MRK_LEN       )==FALSE) break;    else i++;
		j++; if(ToStringField(ppstring, plenStr, (pstruPlyEdrGrid->sSendMrk     ), C_SEND_MRK_LEN      )==FALSE) break;    else i++;
		j++; if(ToStringField(ppstring, plenStr, (pstruPlyEdrGrid->sUdrOpnMrk   ), C_UDR_OPN_MRK_LEN   )==FALSE) break;    else i++;
		j++; if(ToIntField(ppstring, plenStr, &(pstruPlyEdrGrid->nVrfyMrk     ))==FALSE) break;    else i++;
		j++; if(ToStringField(ppstring, plenStr, (pstruPlyEdrGrid->sMdfyTm      ), TIME_LEN            )==FALSE) break;    else i++;
		j++; if(ToStringField(ppstring, plenStr, (pstruPlyEdrGrid->sInsrncCde   ), C_INSRNC_CDE_LEN    )==FALSE) break;    else i++;
		j++; if(ToStringField(ppstring, plenStr, (pstruPlyEdrGrid->sUndrPrsn    ), C_UNDR_PRSN_LEN     )==FALSE) break;    else i++;
		j++; if(ToStringField(ppstring, plenStr, (pstruPlyEdrGrid->sUndrDpt     ), C_UNDR_DPT_LEN      )==FALSE) break;    else i++;
		j++; if(ToStringField(ppstring, plenStr, (pstruPlyEdrGrid->sPrnTyp      ), C_PRN_TYP_LEN       )==FALSE) break;    else i++;
		j++; if(ToStringField(ppstring, plenStr, (pstruPlyEdrGrid->sRinsrncMrk  ), C_RINSRNC_MRK_LEN   )==FALSE) break;    else i++;
		j++; if(ToStringField(ppstring, plenStr, (pstruPlyEdrGrid->sCoinsrncMrk ), C_COINSRNC_MRK_LEN  )==FALSE) break;    else i++;
		j++; if(ToStringField(ppstring, plenStr, (pstruPlyEdrGrid->sCplyNo      ), C_PLY_NO_LEN        )==FALSE) break;    else i++;
		j++; if(ToStringField(ppstring, plenStr, (pstruPlyEdrGrid->sEdrNo       ), C_EDR_NO_LEN        )==FALSE) break;    else i++;
		j++; if(ToStringField(ppstring, plenStr, (pstruPlyEdrGrid->sReadTime    ), TIME_LEN            )==FALSE) break;    else i++;
		j++; if(ToStringField(ppstring, plenStr, (pstruPlyEdrGrid->sRecNo       ), C_REC_NO_LEN        )==FALSE) break;    else i++;
		j++; if(ToIntField(ppstring, plenStr, &iTemp)==FALSE) break;    else i++;
		pstruPlyEdrGrid->cFlag = iTemp;
		j++; if(ToStringField(ppstring, plenStr, (pstruPlyEdrGrid->sInsrncDfnTyp), C_INSRNC_DFN_TYP_LEN)==FALSE) break;    else i++;
		j++; if(ToStringField(ppstring, plenStr, (pstruPlyEdrGrid->sInsrncCnm   ), C_INSRNC_CNM_LEN    )==FALSE) break;    else i++;
		j++; if(ToStringField(ppstring, plenStr, (pstruPlyEdrGrid->sEdrTyp      ), C_EDR_TYP_LEN       )==FALSE) break;    else i++;
		j++; if(ToStringField(ppstring, plenStr, (pstruPlyEdrGrid->sAppNme      ), C_APP_NME_LEN       )==FALSE) break;    else i++;
		j++; if(ToDoubleField(ppstring, plenStr, &(pstruPlyEdrGrid->fAmt         ))==FALSE) break;    else i++;
		j++; if(ToStringField(ppstring, plenStr, (pstruPlyEdrGrid->sSignTm      ), TIME_LEN            )==FALSE) break;    else i++;
		j++; if(ToStringField(ppstring, plenStr, (pstruPlyEdrGrid->sRptDesc     ), C_RPT_DESC_LEN      )==FALSE) break;    else i++;
		j++; if(ToStringField(ppstring, plenStr, (pstruPlyEdrGrid->sRiskLvlCde  ), C_RISK_LVL_CDE_LEN  )==FALSE) break;    else i++;
		j++; if(ToStringField(ppstring, plenStr, (pstruPlyEdrGrid->sLcnNo       ), C_LCN_NO_LEN        )==FALSE) break;    else i++;
		j++; if(ToStringField(ppstring, plenStr, (pstruPlyEdrGrid->sEngNo       ), C_ENG_NO_LEN        )==FALSE) break;    else i++;
		j++; if(ToStringField(ppstring, plenStr, (pstruPlyEdrGrid->sInsrncCls   ), C_INSRNC_CLS_LEN    )==FALSE) break;    else i++;
		j++; if(ToStringField(ppstring, plenStr, (pstruPlyEdrGrid->sUseAtr      ), C_USE_ATR_LEN       )==FALSE) break;    else i++;
		j++; if(ToStringField(ppstring, plenStr, (pstruPlyEdrGrid->sUndrOpn     ), C_UNDR_OPN_LEN      )==FALSE) break;    else i++;
		j++; if(ToStringField(ppstring, plenStr, (pstruPlyEdrGrid->sInternetTyp ), C_INTERNET_TYP_LEN  )==FALSE) break;    else i++;
	}while(0);
	if(j!=i) 
	{	
		#ifdef _DEBUG
		printf("StrToStruPlyEdrGrid failed: Field index = %d\n", j);
		#endif
		return 0-i;
	}
	return 0;
}

void StruPlyEdrGridToStr(plyEdrGridStru *pstruPlyEdrGrid, char** ppstring, int *plenStr)
{

	 printf("pstruPlyEdrGrid---------------before res\n");
	 PrintStruPlyEdrGrid(pstruPlyEdrGrid);
	//----------------------------------------------------------
	StrToStr(pstruPlyEdrGrid->sCrtCde      , ppstring,  plenStr); 
	StrToStr(pstruPlyEdrGrid->sCrtTm       , ppstring,  plenStr); 
	StrToStr(pstruPlyEdrGrid->sUpdCde      , ppstring,  plenStr);
	StrToStr(pstruPlyEdrGrid->sUpdTm       , ppstring,  plenStr);
	StrToStr(pstruPlyEdrGrid->sDocNo       , ppstring,  plenStr);
	StrToStr(pstruPlyEdrGrid->sSendTm      , ppstring,  plenStr);
	StrToStr(pstruPlyEdrGrid->sBlgDptCde   , ppstring,  plenStr);
	StrToStr(pstruPlyEdrGrid->sSource      , ppstring,  plenStr);
	StrToStr(pstruPlyEdrGrid->sSendDptCde  , ppstring,  plenStr);
	StrToStr(pstruPlyEdrGrid->sSendCde     , ppstring,  plenStr);
	StrToStr(pstruPlyEdrGrid->sDesDptCde   , ppstring,  plenStr);
	StrToStr(pstruPlyEdrGrid->sEmergency   , ppstring,  plenStr);
	StrToStr(pstruPlyEdrGrid->sAuthPrnCde  , ppstring,  plenStr);
	StrToStr(pstruPlyEdrGrid->sUdrMrk      , ppstring,  plenStr);
	StrToStr(pstruPlyEdrGrid->sSendMrk     , ppstring,  plenStr);
	StrToStr(pstruPlyEdrGrid->sUdrOpnMrk   , ppstring,  plenStr);
	IntToStr(pstruPlyEdrGrid->nVrfyMrk     , ppstring,  plenStr);
	StrToStr(pstruPlyEdrGrid->sMdfyTm      , ppstring,  plenStr);
	StrToStr(pstruPlyEdrGrid->sInsrncCde   , ppstring,  plenStr);
	StrToStr(pstruPlyEdrGrid->sUndrPrsn    , ppstring,  plenStr);
	StrToStr(pstruPlyEdrGrid->sUndrDpt     , ppstring,  plenStr);
	StrToStr(pstruPlyEdrGrid->sPrnTyp      , ppstring,  plenStr);
	StrToStr(pstruPlyEdrGrid->sRinsrncMrk  , ppstring,  plenStr);
	StrToStr(pstruPlyEdrGrid->sCoinsrncMrk , ppstring,  plenStr);
	StrToStr(pstruPlyEdrGrid->sCplyNo      , ppstring,  plenStr);
	StrToStr(pstruPlyEdrGrid->sEdrNo       , ppstring,  plenStr);
	StrToStr(pstruPlyEdrGrid->sReadTime    , ppstring,  plenStr);
	StrToStr(pstruPlyEdrGrid->sRecNo       , ppstring,  plenStr);
	IntToStr(pstruPlyEdrGrid->cFlag        , ppstring,  plenStr);
	StrToStr(pstruPlyEdrGrid->sInsrncDfnTyp, ppstring,  plenStr);
	StrToStr(pstruPlyEdrGrid->sInsrncCnm   , ppstring,  plenStr);
	StrToStr(pstruPlyEdrGrid->sEdrTyp      , ppstring,  plenStr);
	StrToStr(pstruPlyEdrGrid->sAppNme      , ppstring,  plenStr);
	printf(" before ------------------pstruPlyEdrGrid->fAmt \n");
	printf("pstruPlyEdrGrid->fAmt %f\n",pstruPlyEdrGrid->fAmt);
	DoubleToStr(pstruPlyEdrGrid->fAmt       , ppstring,  plenStr);
		printf(" after ------------------pstruPlyEdrGrid->fAmt \n");
	StrToStr(pstruPlyEdrGrid->sSignTm      , ppstring,  plenStr); 
	StrToStr(pstruPlyEdrGrid->sRptDesc     , ppstring,  plenStr); 
	StrToStr(pstruPlyEdrGrid->sRiskLvlCde  , ppstring,  plenStr); 
	StrToStr(pstruPlyEdrGrid->sLcnNo       , ppstring,  plenStr); 
	StrToStr(pstruPlyEdrGrid->sEngNo       , ppstring,  plenStr); 
	StrToStr(pstruPlyEdrGrid->sInsrncCls   , ppstring,  plenStr); 
	StrToStr(pstruPlyEdrGrid->sUseAtr      , ppstring,  plenStr); 
	StrToStr(pstruPlyEdrGrid->sUndrOpn     , ppstring,  plenStr); 
	StrToStr(pstruPlyEdrGrid->sInternetTyp , ppstring,  plenStr); 
	return ;
}




void PrintStruPlyEdrGrid(const plyEdrGridStru *pstruPlyEdrGrid)
{
	printf("pstruPlyEdrGrid->sCrtCde      =[%s]\n", pstruPlyEdrGrid->sCrtCde      );                                                                            
	printf("pstruPlyEdrGrid->sCrtTm       =[%s]\n", pstruPlyEdrGrid->sCrtTm       );                                                                            
	printf("pstruPlyEdrGrid->sUpdCde      =[%s]\n", pstruPlyEdrGrid->sUpdCde      );                                                                            
	printf("pstruPlyEdrGrid->sUpdTm       =[%s]\n", pstruPlyEdrGrid->sUpdTm       );                                                                            
	printf("pstruPlyEdrGrid->sDocNo       =[%s]\n", pstruPlyEdrGrid->sDocNo       );                                                                            
	printf("pstruPlyEdrGrid->sSendTm      =[%s]\n", pstruPlyEdrGrid->sSendTm      );                                                                            
	printf("pstruPlyEdrGrid->sBlgDptCde   =[%s]\n", pstruPlyEdrGrid->sBlgDptCde   );                                                                            
	printf("pstruPlyEdrGrid->sSource      =[%s]\n", pstruPlyEdrGrid->sSource      );                                                                            
	printf("pstruPlyEdrGrid->sSendDptCde  =[%s]\n", pstruPlyEdrGrid->sSendDptCde  );                                                                             
	printf("pstruPlyEdrGrid->sSendCde     =[%s]\n", pstruPlyEdrGrid->sSendCde     );                                                                            
	printf("pstruPlyEdrGrid->sDesDptCde   =[%s]\n", pstruPlyEdrGrid->sDesDptCde   );                                                                              
	printf("pstruPlyEdrGrid->sEmergency   =[%s]\n", pstruPlyEdrGrid->sEmergency   );                                                                            
	printf("pstruPlyEdrGrid->sAuthPrnCde  =[%s]\n", pstruPlyEdrGrid->sAuthPrnCde  );                                                                            
	printf("pstruPlyEdrGrid->sUdrMrk      =[%s]\n", pstruPlyEdrGrid->sUdrMrk      );                                                                            
	printf("pstruPlyEdrGrid->sSendMrk     =[%s]\n", pstruPlyEdrGrid->sSendMrk     );                                                                            
	printf("pstruPlyEdrGrid->sUdrOpnMrk   =[%s]\n", pstruPlyEdrGrid->sUdrOpnMrk   );                                                                            
	printf("pstruPlyEdrGrid->nVrfyMrk     =[%d]\n", pstruPlyEdrGrid->nVrfyMrk     );                                                                            
	printf("pstruPlyEdrGrid->sMdfyTm      =[%s]\n", pstruPlyEdrGrid->sMdfyTm      );                                                                            
	printf("pstruPlyEdrGrid->sInsrncCde   =[%s]\n", pstruPlyEdrGrid->sInsrncCde   );                                                                            
	printf("pstruPlyEdrGrid->sUndrPrsn    =[%s]\n", pstruPlyEdrGrid->sUndrPrsn    );                                                                            
	printf("pstruPlyEdrGrid->sUndrDpt     =[%s]\n", pstruPlyEdrGrid->sUndrDpt     );                                                                            
	printf("pstruPlyEdrGrid->sPrnTyp      =[%s]\n", pstruPlyEdrGrid->sPrnTyp      );                                                                            
	printf("pstruPlyEdrGrid->sRinsrncMrk  =[%s]\n", pstruPlyEdrGrid->sRinsrncMrk  );                                                                            
	printf("pstruPlyEdrGrid->sCoinsrncMrk =[%s]\n", pstruPlyEdrGrid->sCoinsrncMrk );                                                                            
	printf("pstruPlyEdrGrid->sCplyNo      =[%s]\n", pstruPlyEdrGrid->sCplyNo      );                                                                            
	printf("pstruPlyEdrGrid->sEdrNo       =[%s]\n", pstruPlyEdrGrid->sEdrNo       );                                                                            
	printf("pstruPlyEdrGrid->sReadTime    =[%s]\n", pstruPlyEdrGrid->sReadTime    );                                                                            
	printf("pstruPlyEdrGrid->sRecNo       =[%s]\n", pstruPlyEdrGrid->sRecNo       );                                                                            
	printf("pstruPlyEdrGrid->cFlag        =[%d]\n", pstruPlyEdrGrid->cFlag        );                                                                            
	printf("pstruPlyEdrGrid->sInsrncDfnTyp=[%s]\n", pstruPlyEdrGrid->sInsrncDfnTyp);                                                                            
	printf("pstruPlyEdrGrid->sInsrncCnm   =[%s]\n", pstruPlyEdrGrid->sInsrncCnm   );                                                                            
	printf("pstruPlyEdrGrid->sEdrTyp      =[%s]\n", pstruPlyEdrGrid->sEdrTyp      );                                                                            
	printf("pstruPlyEdrGrid->sAppNme      =[%s]\n", pstruPlyEdrGrid->sAppNme      );                                                                            
	printf("pstruPlyEdrGrid->fAmt         =[%f]\n", pstruPlyEdrGrid->fAmt         );                                                                            
	printf("pstruPlyEdrGrid->sSignTm      =[%s]\n", pstruPlyEdrGrid->sSignTm      );                                                                            
	printf("pstruPlyEdrGrid->sRptDesc     =[%s]\n", pstruPlyEdrGrid->sRptDesc     );                                                                             
	printf("pstruPlyEdrGrid->sRiskLvlCde  =[%s]\n", pstruPlyEdrGrid->sRiskLvlCde  );                                                                            
	printf("pstruPlyEdrGrid->sLcnNo       =[%s]\n", pstruPlyEdrGrid->sLcnNo       );                                                                              
	printf("pstruPlyEdrGrid->sEngNo       =[%s]\n", pstruPlyEdrGrid->sEngNo       );                                                                            
	printf("pstruPlyEdrGrid->sInsrncCls   =[%s]\n", pstruPlyEdrGrid->sInsrncCls   );                                                                            
	printf("pstruPlyEdrGrid->sUseAtr      =[%s]\n", pstruPlyEdrGrid->sUseAtr      );                                                                            
	printf("pstruPlyEdrGrid->sUndrOpn     =[%s]\n", pstruPlyEdrGrid->sUndrOpn     );                                                                            
	printf("pstruPlyEdrGrid->sInternetTyp =[%s]\n\n", pstruPlyEdrGrid->sInternetTyp );                                                                            
	return;
}


void struPlyEdrGridOrderConvt(char *pBuff)
{
	plyEdrGridStru struPlyEdrGrid;
	memcpy(&struPlyEdrGrid, pBuff, sizeof(plyEdrGridStru));

	struPlyEdrGrid.nVrfyMrk = AIcom_ConvertInt1(struPlyEdrGrid.nVrfyMrk);
	struPlyEdrGrid.fAmt = AIcom_ConvertDouble1(struPlyEdrGrid.fAmt);

	memcpy(pBuff, &struPlyEdrGrid, sizeof(plyEdrGridStru));
	return ;
}

