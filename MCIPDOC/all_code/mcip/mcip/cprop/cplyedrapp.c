#include "typeconvt.h"
#include "AiConvert.h"
#include "cplyedrapp.h"




int StrToStruPlyEdrapp(char** ppstring, int *plenStr, plyEdrappStru *pstruPlyEdrapp)
{
	int i, j;
	if(*ppstring==NULL) return 1;

	i=j=0;
	do
	{
		j++; if(ToStringField(ppstring, plenStr, (pstruPlyEdrapp->sCrtCde      ), C_CRT_CDE_LEN            )==FALSE) break;    else i++;
		j++; if(ToStringField(ppstring, plenStr, (pstruPlyEdrapp->sCrtTm       ), TIME_LEN                 )==FALSE) break;    else i++;
		j++; if(ToStringField(ppstring, plenStr, (pstruPlyEdrapp->sUpdCde      ), C_UPD_CDE_LEN            )==FALSE) break;    else i++;
		j++; if(ToStringField(ppstring, plenStr, (pstruPlyEdrapp->sUpdTm       ), TIME_LEN                 )==FALSE) break;    else i++;
		j++; if(ToStringField(ppstring, plenStr, (pstruPlyEdrapp->sEdrAppNo    ), C_EDR_APP_NO_LEN         )==FALSE) break;    else i++;
		j++; if(ToStringField(ppstring, plenStr, (pstruPlyEdrapp->sEdrNo       ), C_EDR_NO_LEN             )==FALSE) break;    else i++;
		j++; if(ToStringField(ppstring, plenStr, (pstruPlyEdrapp->sCplyNo      ), C_PLY_NO_LEN             )==FALSE) break;    else i++;
		j++; if(ToStringField(ppstring, plenStr, (pstruPlyEdrapp->sEdrTyp      ), C_EDR_TYP_LEN            )==FALSE) break;    else i++;
		j++; if(ToStringField(ppstring, plenStr, (pstruPlyEdrapp->sAppPrsnCde  ), C_APP_PRSN_CDE_LEN       )==FALSE) break;    else i++; 
		j++; if(ToStringField(ppstring, plenStr, (pstruPlyEdrapp->sAppPrsnNme  ), C_APP_PRSN_NME_LEN       )==FALSE) break;    else i++;
		j++; if(ToStringField(ppstring, plenStr, (pstruPlyEdrapp->sAppPrsnAddr ), C_APP_PRSN_ADDR_LEN      )==FALSE) break;    else i++;  
		j++; if(ToStringField(ppstring, plenStr, (pstruPlyEdrapp->sAppPrsnTel  ), C_APP_PRSN_TEL_LEN       )==FALSE) break;    else i++;
		j++; if(ToStringField(ppstring, plenStr, (pstruPlyEdrapp->sEdrAppTm    ), DATE_LEN                 )==FALSE) break;    else i++;
		j++; if(ToStringField(ppstring, plenStr, (pstruPlyEdrapp->sEdrRsn      ), C_EDR_RSN_LEN            )==FALSE) break;    else i++;
		j++; if(ToStringField(ppstring, plenStr, (pstruPlyEdrapp->sEdrCtnt     ), C_EDR_CTNT_LEN           )==FALSE) break;    else i++;
		j++; if(ToDoubleField(ppstring, plenStr, &(pstruPlyEdrapp->fAmtVar      ))==FALSE) break;    else i++;
		j++; if(ToDoubleField(ppstring, plenStr, &(pstruPlyEdrapp->fPrmVar      ))==FALSE) break;    else i++;
		j++; if(ToDoubleField(ppstring, plenStr, &(pstruPlyEdrapp->fNclmAmt     ))==FALSE) break;    else i++;
		j++; if(ToDoubleField(ppstring, plenStr, &(pstruPlyEdrapp->fAppntAmt    ))==FALSE) break;    else i++;
		j++; if(ToDoubleField(ppstring, plenStr, &(pstruPlyEdrapp->fNdisAmt     ))==FALSE) break;    else i++;
		j++; if(ToDoubleField(ppstring, plenStr, &(pstruPlyEdrapp->fNnclmAmt    ))==FALSE) break;    else i++;
		j++; if(ToStringField(ppstring, plenStr, (pstruPlyEdrapp->sOrigCplyNo  ), C_ORIG_PLY_NO_LEN        )==FALSE) break;    else i++;
		j++; if(ToStringField(ppstring, plenStr, (pstruPlyEdrapp->sDptCde      ), C_DPT_CDE_LEN            )==FALSE) break;    else i++;
		j++; if(ToStringField(ppstring, plenStr, (pstruPlyEdrapp->sBsnsTyp     ), C_BSNS_TYP_LEN           )==FALSE) break;    else i++;
		j++; if(ToStringField(ppstring, plenStr, (pstruPlyEdrapp->sCmpnyAgtCde ), C_CMPNY_AGT_CDE_LEN      )==FALSE) break;    else i++;
		j++; if(ToIntField(ppstring, plenStr, &(pstruPlyEdrapp->nSubCoNo     ))==FALSE) break;    else i++;
		j++; if(ToStringField(ppstring, plenStr, (pstruPlyEdrapp->sAgtAgrNo    ), C_AGT_AGR_NO_LEN         )==FALSE) break;    else i++;
		j++; if(ToStringField(ppstring, plenStr, (pstruPlyEdrapp->sBrkrCde     ), C_BRKR_CDE_LEN           )==FALSE) break;    else i++;
		j++; if(ToStringField(ppstring, plenStr, (pstruPlyEdrapp->sSlsCde      ), C_SLS_CDE_LEN            )==FALSE) break;    else i++;
		j++; if(ToStringField(ppstring, plenStr, pstruPlyEdrapp->sInsrncCmpnyCde, C_INSRNC_CMPNY_CDE_LEN   )==FALSE) break;    else i++;
		j++; if(ToStringField(ppstring, plenStr, (pstruPlyEdrapp->sInsrntCde    ), C_INSRNT_CDE_LEN          )==FALSE) break;    else i++;
		j++; if(ToStringField(ppstring, plenStr, (pstruPlyEdrapp->sInsrntNme    ), C_INSRNT_NME_LEN          )==FALSE) break;    else i++;
		j++; if(ToStringField(ppstring, plenStr, (pstruPlyEdrapp->sInsrntAddr   ), C_INSRNT_ADDR_LEN         )==FALSE) break;    else i++;
		j++; if(ToStringField(ppstring, plenStr, (pstruPlyEdrapp->sBnfcCde      ), C_BNFC_CDE_LEN            )==FALSE) break;    else i++;
		j++; if(ToStringField(ppstring, plenStr, (pstruPlyEdrapp->sBnfcNme      ), C_BNFC_NME_LEN            )==FALSE) break;    else i++;
		j++; if(ToStringField(ppstring, plenStr, (pstruPlyEdrapp->sAppCde       ), C_APP_CDE_LEN             )==FALSE) break;    else i++;
		j++; if(ToStringField(ppstring, plenStr, (pstruPlyEdrapp->sAppNme       ), C_APP_NME_LEN             )==FALSE) break;    else i++;
		j++; if(ToStringField(ppstring, plenStr, (pstruPlyEdrapp->sAppAddr      ), C_APP_ADDR_LEN            )==FALSE) break;    else i++;
		j++; if(ToStringField(ppstring, plenStr, (pstruPlyEdrapp->sAppTel       ), C_APP_TEL_LEN             )==FALSE) break;    else i++;
		j++; if(ToStringField(ppstring, plenStr, (pstruPlyEdrapp->sInsrncCde    ), C_INSRNC_CDE_LEN          )==FALSE) break;    else i++;
		j++; if(ToStringField(ppstring, plenStr, (pstruPlyEdrapp->sClausCde     ), C_CLAUS_CDE_LEN           )==FALSE) break;    else i++;
		j++; if(ToStringField(ppstring, plenStr, (pstruPlyEdrapp->sAppTm        ), DATE_LEN                  )==FALSE) break;    else i++; 
		j++; if(ToStringField(ppstring, plenStr, (pstruPlyEdrapp->sInsrncBgnTm  ), TIME_LEN                  )==FALSE) break;    else i++;
		j++; if(ToStringField(ppstring, plenStr, (pstruPlyEdrapp->sInsrncEndTm  ), TIME_LEN                  )==FALSE) break;    else i++;  
		j++; if(ToStringField(ppstring, plenStr, (pstruPlyEdrapp->sSignTm       ), TIME_LEN                  )==FALSE) break;    else i++;
		j++; if(ToStringField(ppstring, plenStr, (pstruPlyEdrapp->sAmtCur       ), C_AMT_CUR_LEN             )==FALSE) break;    else i++;
		j++; if(ToDoubleField(ppstring, plenStr, &(pstruPlyEdrapp->fInsrncVlu     ))==FALSE) break;    else i++;
		j++; if(ToDoubleField(ppstring, plenStr, &(pstruPlyEdrapp->fAmt           ))==FALSE) break;    else i++;
		j++; if(ToDoubleField(ppstring, plenStr, &(pstruPlyEdrapp->fRate          ))==FALSE) break;    else i++;
		j++; if(ToDoubleField(ppstring, plenStr, &(pstruPlyEdrapp->fPrm           ))==FALSE) break;    else i++;
		j++; if(ToDoubleField(ppstring, plenStr, &(pstruPlyEdrapp->fRdrPrm        ))==FALSE) break;    else i++;
		j++; if(ToDoubleField(ppstring, plenStr, &(pstruPlyEdrapp->fSumPrm        ))==FALSE) break;    else i++;
		j++; if(ToStringField(ppstring, plenStr, (pstruPlyEdrapp->sPrmCur       ), C_PRM_CUR_LEN             )==FALSE) break;    else i++;
		j++; if(ToDoubleField(ppstring, plenStr, &(pstruPlyEdrapp->fNclmProp      ))==FALSE) break;    else i++;
		j++; if(ToDoubleField(ppstring, plenStr, &(pstruPlyEdrapp->fAppntProp     ))==FALSE) break;    else i++;
		j++; if(ToDoubleField(ppstring, plenStr, &(pstruPlyEdrapp->fCmmProp       ))==FALSE) break;    else i++;
		j++; if(ToDoubleField(ppstring, plenStr, &(pstruPlyEdrapp->fBrkProp       ))==FALSE) break;    else i++;
		j++; if(ToIntField(ppstring, plenStr, &(pstruPlyEdrapp->nPayTms        ))==FALSE) break;    else i++;
		j++; if(ToStringField(ppstring, plenStr, (pstruPlyEdrapp->sAppnt       ) , C_APPNT_LEN               )==FALSE) break;    else i++;
		j++; if(ToStringField(ppstring, plenStr, (pstruPlyEdrapp->sRemark      ) , C_REMARK_LEN              )==FALSE) break;    else i++;
		j++; if(ToStringField(ppstring, plenStr, (pstruPlyEdrapp->sCrtPrsn     ) , C_CRT_PRSN_LEN            )==FALSE) break;    else i++;
		j++; if(ToStringField(ppstring, plenStr, (pstruPlyEdrapp->sUndrPrsn    ) , C_UNDR_PRSN_LEN           )==FALSE) break;    else i++;
		j++; if(ToStringField(ppstring, plenStr, (pstruPlyEdrapp->sUndrTm      ) , TIME_LEN                  )==FALSE) break;    else i++;
		j++; if(ToStringField(ppstring, plenStr, (pstruPlyEdrapp->sRinsrncMrk  ) , C_RINSRNC_MRK_LEN         )==FALSE) break;    else i++;
		j++; if(ToStringField(ppstring, plenStr, (pstruPlyEdrapp->sCoinsrncMrk ) , C_COINSRNC_MRK_LEN        )==FALSE) break;    else i++;
		j++; if(ToStringField(ppstring, plenStr, (pstruPlyEdrapp->sInputTm     ) , DATE_LEN                  )==FALSE) break;    else i++;
		j++; if(ToStringField(ppstring, plenStr, (pstruPlyEdrapp->sUndrDpt     ) , C_UNDR_DPT_LEN            )==FALSE) break;    else i++;
		j++; if(ToStringField(ppstring, plenStr, (pstruPlyEdrapp->sOprTyp      ) , C_OPR_TYP_LEN             )==FALSE) break;    else i++;
		j++; if(ToIntField(ppstring, plenStr, &(pstruPlyEdrapp->nEdrPrjNo      ))==FALSE) break;    else i++;
		j++; if(ToStringField(ppstring, plenStr, (pstruPlyEdrapp->sNextEdrUndrTm), TIME_LEN                  )==FALSE) break;    else i++;
		j++; if(ToStringField(ppstring, plenStr, (pstruPlyEdrapp->sDptCnm      ) , C_DPT_CNM_LEN             )==FALSE) break;    else i++; 
		j++; if(ToStringField(ppstring, plenStr, (pstruPlyEdrapp->sInsrncCnm   ) , C_INSRNC_CNM_LEN          )==FALSE) break;    else i++;
		j++; if(ToStringField(ppstring, plenStr, (pstruPlyEdrapp->sUndrPrsnCnm ) , C_EMP_CNM_LEN             )==FALSE) break;    else i++;  
		j++; if(ToStringField(ppstring, plenStr, (pstruPlyEdrapp->sUndrDptCnm  ) , C_DPT_CNM_LEN             )==FALSE) break;    else i++;
		j++; if(ToStringField(ppstring, plenStr, (pstruPlyEdrapp->sCrtPrsnCnm  ) , C_EMP_CNM_LEN             )==FALSE) break;    else i++;
		j++; if(ToStringField(ppstring, plenStr, (pstruPlyEdrapp->sSlsCnm      ) , C_EMP_CNM_LEN             )==FALSE) break;    else i++;
		j++; if(ToStringField(ppstring, plenStr, (pstruPlyEdrapp->sAgtNme      ) , C_AGT_NME_LEN             )==FALSE) break;    else i++;
		j++; if(ToStringField(ppstring, plenStr, (pstruPlyEdrapp->sAmtCurCnm   ) , C_CUR_CNM_LEN             )==FALSE) break;    else i++;
		j++; if(ToStringField(ppstring, plenStr, (pstruPlyEdrapp->sAgeLongMrk  ) , C_AGELONG_MRK_LEN         )==FALSE) break;    else i++;
		j++; if(ToStringField(ppstring, plenStr, (pstruPlyEdrapp->sCeprnMrk    ) , C_CEPRN_MRK_LEN           )==FALSE) break;    else i++;
		j++; if(ToStringField(ppstring, plenStr, (pstruPlyEdrapp->sUdrMrk      ) , C_UDR_MRK_LEN             )==FALSE) break;    else i++;
		j++; if(ToStringField(ppstring, plenStr, (pstruPlyEdrapp->sSalegrpCde  ) , C_SALEGRP_CDE_LEN         )==FALSE) break;    else i++;
		j++; if(ToDoubleField(ppstring, plenStr, &(pstruPlyEdrapp->fGotPrm        ))==FALSE) break;    else i++;
		j++; if(ToDoubleField(ppstring, plenStr, &(pstruPlyEdrapp->fSumNclm       ))==FALSE) break;    else i++;
		j++; if(ToStringField(ppstring, plenStr, (pstruPlyEdrapp->sZipCde      ) , C_ZIP_CDE_LEN             )==FALSE) break;    else i++;
		j++; if(ToStringField(ppstring, plenStr, (pstruPlyEdrapp->sSttl        ) , C_STTL_LEN                )==FALSE) break;    else i++;
		j++; if(ToDoubleField(ppstring, plenStr, &(pstruPlyEdrapp->fRatio         ))==FALSE) break;    else i++;
		j++; if(ToStringField(ppstring, plenStr, (pstruPlyEdrapp->sCntctPrsnNme) , C_CNTCT_PRSN_NME_LEN      )==FALSE) break;    else i++;
		j++; if(ToStringField(ppstring, plenStr, (pstruPlyEdrapp->sAppTyp      ) , C_APP_TYP_LEN             )==FALSE) break;    else i++;
		j++; if(ToStringField(ppstring, plenStr, (pstruPlyEdrapp->sQueryMrk    ) , C_QUERY_MRK_LEN           )==FALSE) break;    else i++;
		j++; if(ToStringField(ppstring, plenStr, (pstruPlyEdrapp->sFstUndrPrsn ) ,  C_FST_UNDR_PRSN_LEN      )==FALSE) break;    else i++;
		j++; if(ToStringField(ppstring, plenStr, (pstruPlyEdrapp->sFstOpn      ) ,  C_FST_OPN_LEN            )==FALSE) break;    else i++;
		j++; if(ToStringField(ppstring, plenStr, (pstruPlyEdrapp->sChkPrsn     ) ,  C_CHK_PRSN_LEN           )==FALSE) break;    else i++;
		j++; if(ToStringField(ppstring, plenStr, (pstruPlyEdrapp->sChkRec      ) ,  C_CHK_REC_LEN            )==FALSE) break;    else i++;
		j++; if(ToStringField(ppstring, plenStr, (pstruPlyEdrapp->sChkTm       ) ,  TIME_LEN                 )==FALSE) break;    else i++;
		j++; if(ToStringField(ppstring, plenStr, (pstruPlyEdrapp->sFstUndrTm   ) ,  TIME_LEN                 )==FALSE) break;    else i++;
		j++; if(ToDoubleField(ppstring, plenStr, &(pstruPlyEdrapp->fSaveAmtVar    ))==FALSE) break;    else i++;
		j++; if(ToStringField(ppstring, plenStr, (pstruPlyEdrapp->sOpenCoverNo ) ,  C_OPEN_COVER_NO_LEN      )==FALSE) break;    else i++;
		j++; if(ToStringField(ppstring, plenStr, (pstruPlyEdrapp->sInternetTyp ) ,  C_INTERNET_TYP_LEN       )==FALSE) break;    else i++;
	}while(0);
	if(j!=i) 
	{	
		#ifdef _DEBUG
		printf("StrToStruPlyEdrapp failed: Field index = %d\n", j);
		#endif
		return 0-i;
	}
	return 0;
}

void StruPlyEdrappToStr(plyEdrappStru *pstruPlyEdrapp, char** ppstring, int *plenStr)
{
	StrToStr(pstruPlyEdrapp->sCrtCde      , ppstring,  plenStr); 
	StrToStr(pstruPlyEdrapp->sCrtTm       , ppstring,  plenStr); 
	StrToStr(pstruPlyEdrapp->sUpdCde      , ppstring,  plenStr); 
	StrToStr(pstruPlyEdrapp->sUpdTm       , ppstring,  plenStr); 
	StrToStr(pstruPlyEdrapp->sEdrAppNo    , ppstring,  plenStr); 
	StrToStr(pstruPlyEdrapp->sEdrNo       , ppstring,  plenStr); 
	StrToStr(pstruPlyEdrapp->sCplyNo      , ppstring,  plenStr); 
	StrToStr(pstruPlyEdrapp->sEdrTyp      , ppstring,  plenStr); 
	StrToStr(pstruPlyEdrapp->sAppPrsnCde  , ppstring,  plenStr);  
	StrToStr(pstruPlyEdrapp->sAppPrsnNme  , ppstring,  plenStr); 
	StrToStr(pstruPlyEdrapp->sAppPrsnAddr , ppstring,  plenStr);   
	StrToStr(pstruPlyEdrapp->sAppPrsnTel  , ppstring,  plenStr); 
	StrToStr(pstruPlyEdrapp->sEdrAppTm    , ppstring,  plenStr); 
	StrToStr(pstruPlyEdrapp->sEdrRsn      , ppstring,  plenStr); 
	StrToStr(pstruPlyEdrapp->sEdrCtnt     , ppstring,  plenStr); 
	DoubleToStr(pstruPlyEdrapp->fAmtVar      , ppstring,  plenStr); 
	DoubleToStr(pstruPlyEdrapp->fPrmVar      , ppstring,  plenStr); 
	DoubleToStr(pstruPlyEdrapp->fNclmAmt     , ppstring,  plenStr); 
	DoubleToStr(pstruPlyEdrapp->fAppntAmt    , ppstring,  plenStr); 
	DoubleToStr(pstruPlyEdrapp->fNdisAmt     , ppstring,  plenStr); 
	DoubleToStr(pstruPlyEdrapp->fNnclmAmt    , ppstring,  plenStr); 
	StrToStr(pstruPlyEdrapp->sOrigCplyNo  , ppstring,  plenStr); 
	StrToStr(pstruPlyEdrapp->sDptCde      , ppstring,  plenStr); 
	StrToStr(pstruPlyEdrapp->sBsnsTyp     , ppstring,  plenStr); 
	StrToStr(pstruPlyEdrapp->sCmpnyAgtCde , ppstring,  plenStr); 
	IntToStr(pstruPlyEdrapp->nSubCoNo     , ppstring,  plenStr); 
	StrToStr(pstruPlyEdrapp->sAgtAgrNo    , ppstring,  plenStr); 
	StrToStr(pstruPlyEdrapp->sBrkrCde     , ppstring,  plenStr); 
	StrToStr(pstruPlyEdrapp->sSlsCde      , ppstring,  plenStr); 
	StrToStr(pstruPlyEdrapp->sInsrncCmpnyCde, ppstring,  plenStr); 
	StrToStr(pstruPlyEdrapp->sInsrntCde     , ppstring,  plenStr); 
	StrToStr(pstruPlyEdrapp->sInsrntNme     , ppstring,  plenStr); 
	StrToStr(pstruPlyEdrapp->sInsrntAddr    , ppstring,  plenStr); 
	StrToStr(pstruPlyEdrapp->sBnfcCde       , ppstring,  plenStr); 
	StrToStr(pstruPlyEdrapp->sBnfcNme       , ppstring,  plenStr); 
	StrToStr(pstruPlyEdrapp->sAppCde        , ppstring,  plenStr); 
	StrToStr(pstruPlyEdrapp->sAppNme        , ppstring,  plenStr); 
	StrToStr(pstruPlyEdrapp->sAppAddr       , ppstring,  plenStr); 
	StrToStr(pstruPlyEdrapp->sAppTel        , ppstring,  plenStr); 
	StrToStr(pstruPlyEdrapp->sInsrncCde     , ppstring,  plenStr); 
	StrToStr(pstruPlyEdrapp->sClausCde      , ppstring,  plenStr);  
	StrToStr(pstruPlyEdrapp->sAppTm         , ppstring,  plenStr); 
	StrToStr(pstruPlyEdrapp->sInsrncBgnTm   , ppstring,  plenStr);   
	StrToStr(pstruPlyEdrapp->sInsrncEndTm   , ppstring,  plenStr); 
	StrToStr(pstruPlyEdrapp->sSignTm        , ppstring,  plenStr); 
	StrToStr(pstruPlyEdrapp->sAmtCur        , ppstring,  plenStr); 
	DoubleToStr(pstruPlyEdrapp->fInsrncVlu     , ppstring,  plenStr); 
	DoubleToStr(pstruPlyEdrapp->fAmt           , ppstring,  plenStr); 
	DoubleToStr(pstruPlyEdrapp->fRate          , ppstring,  plenStr); 
	DoubleToStr(pstruPlyEdrapp->fPrm           , ppstring,  plenStr); 
	DoubleToStr(pstruPlyEdrapp->fRdrPrm        , ppstring,  plenStr); 
	DoubleToStr(pstruPlyEdrapp->fSumPrm        , ppstring,  plenStr); 
	StrToStr(pstruPlyEdrapp->sPrmCur        , ppstring,  plenStr); 
	DoubleToStr(pstruPlyEdrapp->fNclmProp      , ppstring,  plenStr); 
	DoubleToStr(pstruPlyEdrapp->fAppntProp     , ppstring,  plenStr); 
	DoubleToStr(pstruPlyEdrapp->fCmmProp       , ppstring,  plenStr); 
	DoubleToStr(pstruPlyEdrapp->fBrkProp       , ppstring,  plenStr); 
	IntToStr(pstruPlyEdrapp->nPayTms        , ppstring,  plenStr); 
	StrToStr(pstruPlyEdrapp->sAppnt         , ppstring,  plenStr); 
	StrToStr(pstruPlyEdrapp->sRemark        , ppstring,  plenStr); 
	StrToStr(pstruPlyEdrapp->sCrtPrsn       , ppstring,  plenStr); 
	StrToStr(pstruPlyEdrapp->sUndrPrsn      , ppstring,  plenStr); 
	StrToStr(pstruPlyEdrapp->sUndrTm        , ppstring,  plenStr); 
	StrToStr(pstruPlyEdrapp->sRinsrncMrk    , ppstring,  plenStr); 
	StrToStr(pstruPlyEdrapp->sCoinsrncMrk   , ppstring,  plenStr); 
	StrToStr(pstruPlyEdrapp->sInputTm       , ppstring,  plenStr); 
	StrToStr(pstruPlyEdrapp->sUndrDpt       , ppstring,  plenStr); 
	StrToStr(pstruPlyEdrapp->sOprTyp        , ppstring,  plenStr); 
	IntToStr(pstruPlyEdrapp->nEdrPrjNo      , ppstring,  plenStr); 
	StrToStr(pstruPlyEdrapp->sNextEdrUndrTm , ppstring,  plenStr); 
	StrToStr(pstruPlyEdrapp->sDptCnm        , ppstring,  plenStr); 
	StrToStr(pstruPlyEdrapp->sInsrncCnm     , ppstring,  plenStr); 
	StrToStr(pstruPlyEdrapp->sUndrPrsnCnm   , ppstring,  plenStr);  
	StrToStr(pstruPlyEdrapp->sUndrDptCnm    , ppstring,  plenStr); 
	StrToStr(pstruPlyEdrapp->sCrtPrsnCnm    , ppstring,  plenStr);   
	StrToStr(pstruPlyEdrapp->sSlsCnm        , ppstring,  plenStr); 
	StrToStr(pstruPlyEdrapp->sAgtNme        , ppstring,  plenStr); 
	StrToStr(pstruPlyEdrapp->sAmtCurCnm     , ppstring,  plenStr); 
	StrToStr(pstruPlyEdrapp->sAgeLongMrk    , ppstring,  plenStr); 
	StrToStr(pstruPlyEdrapp->sCeprnMrk      , ppstring,  plenStr); 
	StrToStr(pstruPlyEdrapp->sUdrMrk        , ppstring,  plenStr); 
	StrToStr(pstruPlyEdrapp->sSalegrpCde    , ppstring,  plenStr); 
	DoubleToStr(pstruPlyEdrapp->fGotPrm        , ppstring,  plenStr); 
	DoubleToStr(pstruPlyEdrapp->fSumNclm       , ppstring,  plenStr); 
	StrToStr(pstruPlyEdrapp->sZipCde        , ppstring,  plenStr); 
	StrToStr(pstruPlyEdrapp->sSttl          , ppstring,  plenStr); 
	DoubleToStr(pstruPlyEdrapp->fRatio         , ppstring,  plenStr); 
	StrToStr(pstruPlyEdrapp->sCntctPrsnNme  , ppstring,  plenStr); 
	StrToStr(pstruPlyEdrapp->sAppTyp        , ppstring,  plenStr); 
	StrToStr(pstruPlyEdrapp->sQueryMrk      , ppstring,  plenStr); 
	StrToStr(pstruPlyEdrapp->sFstUndrPrsn   , ppstring,  plenStr); 
	StrToStr(pstruPlyEdrapp->sFstOpn        , ppstring,  plenStr); 
	StrToStr(pstruPlyEdrapp->sChkPrsn       , ppstring,  plenStr); 
	StrToStr(pstruPlyEdrapp->sChkRec        , ppstring,  plenStr); 
	StrToStr(pstruPlyEdrapp->sChkTm         , ppstring,  plenStr); 
	StrToStr(pstruPlyEdrapp->sFstUndrTm     , ppstring,  plenStr); 
	DoubleToStr(pstruPlyEdrapp->fSaveAmtVar    , ppstring,  plenStr); 
	StrToStr(pstruPlyEdrapp->sOpenCoverNo   , ppstring,  plenStr); 
	StrToStr(pstruPlyEdrapp->sInternetTyp   , ppstring,  plenStr); 
	return ;
}




void PrintStruPlyEdrapp(const plyEdrappStru *pstruPlyEdrapp)
{
	printf("pstruPlyEdrapp->sCrtCde      =[%s]\n", pstruPlyEdrapp->sCrtCde      );                                                                            
	printf("pstruPlyEdrapp->sCrtTm       =[%s]\n", pstruPlyEdrapp->sCrtTm       );                                                                            
	printf("pstruPlyEdrapp->sUpdCde      =[%s]\n", pstruPlyEdrapp->sUpdCde      );                                                                            
	printf("pstruPlyEdrapp->sUpdTm       =[%s]\n", pstruPlyEdrapp->sUpdTm       );                                                                            
	printf("pstruPlyEdrapp->sEdrAppNo    =[%s]\n", pstruPlyEdrapp->sEdrAppNo    );                                                                            
	printf("pstruPlyEdrapp->sEdrNo       =[%s]\n", pstruPlyEdrapp->sEdrNo       );                                                                            
	printf("pstruPlyEdrapp->sCplyNo      =[%s]\n", pstruPlyEdrapp->sCplyNo      );                                                                            
	printf("pstruPlyEdrapp->sEdrTyp      =[%s]\n", pstruPlyEdrapp->sEdrTyp      );                                                                            
	printf("pstruPlyEdrapp->sAppPrsnCde  =[%s]\n", pstruPlyEdrapp->sAppPrsnCde  );                                                                             
	printf("pstruPlyEdrapp->sAppPrsnNme  =[%s]\n", pstruPlyEdrapp->sAppPrsnNme  );                                                                            
	printf("pstruPlyEdrapp->sAppPrsnAddr =[%s]\n", pstruPlyEdrapp->sAppPrsnAddr );                                                                              
	printf("pstruPlyEdrapp->sAppPrsnTel  =[%s]\n", pstruPlyEdrapp->sAppPrsnTel  );                                                                            
	printf("pstruPlyEdrapp->sEdrAppTm    =[%s]\n", pstruPlyEdrapp->sEdrAppTm    );                                                                            
	printf("pstruPlyEdrapp->sEdrRsn      =[%s]\n", pstruPlyEdrapp->sEdrRsn      );                                                                            
	printf("pstruPlyEdrapp->sEdrCtnt     =[%s]\n", pstruPlyEdrapp->sEdrCtnt     );                                                                            
	printf("pstruPlyEdrapp->fAmtVar      =[%f]\n", pstruPlyEdrapp->fAmtVar      );                                                                            
	printf("pstruPlyEdrapp->fPrmVar      =[%f]\n", pstruPlyEdrapp->fPrmVar      );                                                                            
	printf("pstruPlyEdrapp->fNclmAmt     =[%f]\n", pstruPlyEdrapp->fNclmAmt     );                                                                            
	printf("pstruPlyEdrapp->fAppntAmt    =[%f]\n", pstruPlyEdrapp->fAppntAmt    );                                                                            
	printf("pstruPlyEdrapp->fNdisAmt     =[%f]\n", pstruPlyEdrapp->fNdisAmt     );                                                                            
	printf("pstruPlyEdrapp->fNnclmAmt    =[%f]\n", pstruPlyEdrapp->fNnclmAmt    );                                                                            
	printf("pstruPlyEdrapp->sOrigCplyNo  =[%s]\n", pstruPlyEdrapp->sOrigCplyNo  );                                                                            
	printf("pstruPlyEdrapp->sDptCde      =[%s]\n", pstruPlyEdrapp->sDptCde      );                                                                            
	printf("pstruPlyEdrapp->sBsnsTyp     =[%s]\n", pstruPlyEdrapp->sBsnsTyp     );                                                                            
	printf("pstruPlyEdrapp->sCmpnyAgtCde =[%s]\n", pstruPlyEdrapp->sCmpnyAgtCde );                                                                            
	printf("pstruPlyEdrapp->nSubCoNo     =[%d]\n", pstruPlyEdrapp->nSubCoNo     );                                                                            
	printf("pstruPlyEdrapp->sAgtAgrNo    =[%s]\n", pstruPlyEdrapp->sAgtAgrNo    );                                                                            
	printf("pstruPlyEdrapp->sBrkrCde     =[%s]\n", pstruPlyEdrapp->sBrkrCde     );                                                                            
	printf("pstruPlyEdrapp->sSlsCde      =[%s]\n", pstruPlyEdrapp->sSlsCde      );                                                                            
	printf("pstruPlyEdrapp->sInsrncCmpnyCde=[%s]\n", pstruPlyEdrapp->sInsrncCmpnyCde);                                                                            
	printf("pstruPlyEdrapp->sInsrntCde     =[%s]\n", pstruPlyEdrapp->sInsrntCde     );                                                                            
	printf("pstruPlyEdrapp->sInsrntNme     =[%s]\n", pstruPlyEdrapp->sInsrntNme     );                                                                            
	printf("pstruPlyEdrapp->sInsrntAddr    =[%s]\n", pstruPlyEdrapp->sInsrntAddr    );                                                                            
	printf("pstruPlyEdrapp->sBnfcCde       =[%s]\n", pstruPlyEdrapp->sBnfcCde       );                                                                            
	printf("pstruPlyEdrapp->sBnfcNme       =[%s]\n", pstruPlyEdrapp->sBnfcNme       );                                                                            
	printf("pstruPlyEdrapp->sAppCde        =[%s]\n", pstruPlyEdrapp->sAppCde        );                                                                             
	printf("pstruPlyEdrapp->sAppNme        =[%s]\n", pstruPlyEdrapp->sAppNme        );                                                                            
	printf("pstruPlyEdrapp->sAppAddr       =[%s]\n", pstruPlyEdrapp->sAppAddr       );                                                                              
	printf("pstruPlyEdrapp->sAppTel        =[%s]\n", pstruPlyEdrapp->sAppTel        );                                                                            
	printf("pstruPlyEdrapp->sInsrncCde     =[%s]\n", pstruPlyEdrapp->sInsrncCde     );                                                                            
	printf("pstruPlyEdrapp->sClausCde      =[%s]\n", pstruPlyEdrapp->sClausCde      );                                                                            
	printf("pstruPlyEdrapp->sAppTm         =[%s]\n", pstruPlyEdrapp->sAppTm         );                                                                            
	printf("pstruPlyEdrapp->sInsrncBgnTm   =[%s]\n", pstruPlyEdrapp->sInsrncBgnTm   );                                                                            
	printf("pstruPlyEdrapp->sInsrncEndTm   =[%s]\n", pstruPlyEdrapp->sInsrncEndTm   );                                                                            
	printf("pstruPlyEdrapp->sSignTm        =[%s]\n", pstruPlyEdrapp->sSignTm        );                                                                            
	printf("pstruPlyEdrapp->sAmtCur        =[%s]\n", pstruPlyEdrapp->sAmtCur        );                                                                            
	printf("pstruPlyEdrapp->fInsrncVlu     =[%f]\n", pstruPlyEdrapp->fInsrncVlu     );                                                                            
	printf("pstruPlyEdrapp->fAmt           =[%f]\n", pstruPlyEdrapp->fAmt           );                                                                            
	printf("pstruPlyEdrapp->fRate          =[%f]\n", pstruPlyEdrapp->fRate          );                                                                            
	printf("pstruPlyEdrapp->fPrm           =[%f]\n", pstruPlyEdrapp->fPrm           );                                                                            
	printf("pstruPlyEdrapp->fRdrPrm        =[%f]\n", pstruPlyEdrapp->fRdrPrm        );                                                                            
	printf("pstruPlyEdrapp->fSumPrm        =[%f]\n", pstruPlyEdrapp->fSumPrm        );                                                                            
	printf("pstruPlyEdrapp->sPrmCur        =[%s]\n", pstruPlyEdrapp->sPrmCur        );                                                                            
	printf("pstruPlyEdrapp->fNclmProp      =[%f]\n", pstruPlyEdrapp->fNclmProp      );                                                                            
	printf("pstruPlyEdrapp->fAppntProp     =[%f]\n", pstruPlyEdrapp->fAppntProp     );                                                                            
	printf("pstruPlyEdrapp->fCmmProp       =[%f]\n", pstruPlyEdrapp->fCmmProp       );                                                                            
	printf("pstruPlyEdrapp->fBrkProp       =[%f]\n", pstruPlyEdrapp->fBrkProp       );                                                                            
	printf("pstruPlyEdrapp->nPayTms        =[%d]\n", pstruPlyEdrapp->nPayTms        );                                                                            
	printf("pstruPlyEdrapp->sAppnt         =[%s]\n", pstruPlyEdrapp->sAppnt         );                                                                            
	printf("pstruPlyEdrapp->sRemark        =[%s]\n", pstruPlyEdrapp->sRemark        );                                                                            
	printf("pstruPlyEdrapp->sCrtPrsn       =[%s]\n", pstruPlyEdrapp->sCrtPrsn       );                                                                            
	printf("pstruPlyEdrapp->sUndrPrsn      =[%s]\n", pstruPlyEdrapp->sUndrPrsn      );                                                                            
	printf("pstruPlyEdrapp->sUndrTm        =[%s]\n", pstruPlyEdrapp->sUndrTm        );                                                                            
	printf("pstruPlyEdrapp->sRinsrncMrk    =[%s]\n", pstruPlyEdrapp->sRinsrncMrk    );                                                                             
	printf("pstruPlyEdrapp->sCoinsrncMrk   =[%s]\n", pstruPlyEdrapp->sCoinsrncMrk   );                                                                            
	printf("pstruPlyEdrapp->sInputTm       =[%s]\n", pstruPlyEdrapp->sInputTm       );                                                                              
	printf("pstruPlyEdrapp->sUndrDpt       =[%s]\n", pstruPlyEdrapp->sUndrDpt       );                                                                            
	printf("pstruPlyEdrapp->sOprTyp        =[%s]\n", pstruPlyEdrapp->sOprTyp        );                                                                            
	printf("pstruPlyEdrapp->nEdrPrjNo      =[%d]\n", pstruPlyEdrapp->nEdrPrjNo      );                                                                            
	printf("pstruPlyEdrapp->sNextEdrUndrTm =[%s]\n", pstruPlyEdrapp->sNextEdrUndrTm );                                                                            
	printf("pstruPlyEdrapp->sDptCnm        =[%s]\n", pstruPlyEdrapp->sDptCnm        );                                                                            
	printf("pstruPlyEdrapp->sInsrncCnm     =[%s]\n", pstruPlyEdrapp->sInsrncCnm     );                                                                            
	printf("pstruPlyEdrapp->sUndrPrsnCnm   =[%s]\n", pstruPlyEdrapp->sUndrPrsnCnm   );                                                                            
	printf("pstruPlyEdrapp->sUndrDptCnm    =[%s]\n", pstruPlyEdrapp->sUndrDptCnm    );                                                                            
	printf("pstruPlyEdrapp->sCrtPrsnCnm    =[%s]\n", pstruPlyEdrapp->sCrtPrsnCnm    );                                                                            
	printf("pstruPlyEdrapp->sSlsCnm        =[%s]\n", pstruPlyEdrapp->sSlsCnm        );                                                                            
	printf("pstruPlyEdrapp->sAgtNme        =[%s]\n", pstruPlyEdrapp->sAgtNme        );                                                                            
	printf("pstruPlyEdrapp->sAmtCurCnm     =[%s]\n", pstruPlyEdrapp->sAmtCurCnm     );                                                                            
	printf("pstruPlyEdrapp->sAgeLongMrk    =[%s]\n", pstruPlyEdrapp->sAgeLongMrk    );                                                                            
	printf("pstruPlyEdrapp->sCeprnMrk      =[%s]\n", pstruPlyEdrapp->sCeprnMrk      );                                                                            
	printf("pstruPlyEdrapp->sUdrMrk        =[%s]\n", pstruPlyEdrapp->sUdrMrk        );                                                                            
	printf("pstruPlyEdrapp->sSalegrpCde    =[%s]\n", pstruPlyEdrapp->sSalegrpCde    );                                                                            
	printf("pstruPlyEdrapp->fGotPrm        =[%f]\n", pstruPlyEdrapp->fGotPrm        );                                                                            
	printf("pstruPlyEdrapp->fSumNclm       =[%f]\n", pstruPlyEdrapp->fSumNclm       );                                                                            
	printf("pstruPlyEdrapp->sZipCde        =[%s]\n", pstruPlyEdrapp->sZipCde        );                                                                            
	printf("pstruPlyEdrapp->sSttl          =[%s]\n", pstruPlyEdrapp->sSttl          );                                                                            
	printf("pstruPlyEdrapp->fRatio         =[%f]\n", pstruPlyEdrapp->fRatio         );                                                                            
	printf("pstruPlyEdrapp->sCntctPrsnNme  =[%s]\n", pstruPlyEdrapp->sCntctPrsnNme  );                                                                            
	printf("pstruPlyEdrapp->sAppTyp        =[%s]\n", pstruPlyEdrapp->sAppTyp        );                                                                            
	printf("pstruPlyEdrapp->sQueryMrk      =[%s]\n", pstruPlyEdrapp->sQueryMrk      );                                                                            
	printf("pstruPlyEdrapp->sFstUndrPrsn   =[%s]\n", pstruPlyEdrapp->sFstUndrPrsn   );                                                                             
	printf("pstruPlyEdrapp->sFstOpn        =[%s]\n", pstruPlyEdrapp->sFstOpn        );                                                                            
	printf("pstruPlyEdrapp->sChkPrsn       =[%s]\n", pstruPlyEdrapp->sChkPrsn       );                                                                              
	printf("pstruPlyEdrapp->sChkRec        =[%s]\n", pstruPlyEdrapp->sChkRec        );                                                                            
	printf("pstruPlyEdrapp->sChkTm         =[%s]\n", pstruPlyEdrapp->sChkTm         );                                                                            
	printf("pstruPlyEdrapp->sFstUndrTm     =[%s]\n", pstruPlyEdrapp->sFstUndrTm     );                                                                            
	printf("pstruPlyEdrapp->fSaveAmtVar    =[%f]\n", pstruPlyEdrapp->fSaveAmtVar    );                                                                            
	printf("pstruPlyEdrapp->sOpenCoverNo   =[%s]\n", pstruPlyEdrapp->sOpenCoverNo   );                                                                            
	printf("pstruPlyEdrapp->sInternetTyp   =[%s]\n\n", pstruPlyEdrapp->sInternetTyp   );                                                                            
	return;
}


void struPlyEdrappOrderConvt(char *pBuff)
{
	plyEdrappStru struPlyEdrapp;
	memcpy(&struPlyEdrapp, pBuff, sizeof(plyEdrappStru));

	struPlyEdrapp.fAmtVar     = AIcom_ConvertDouble1(struPlyEdrapp.fAmtVar    );
	struPlyEdrapp.fPrmVar     = AIcom_ConvertDouble1(struPlyEdrapp.fPrmVar    );
	struPlyEdrapp.fNclmAmt    = AIcom_ConvertDouble1(struPlyEdrapp.fNclmAmt   );
	struPlyEdrapp.fAppntAmt   = AIcom_ConvertDouble1(struPlyEdrapp.fAppntAmt  );
	struPlyEdrapp.fNdisAmt    = AIcom_ConvertDouble1(struPlyEdrapp.fNdisAmt   );
	struPlyEdrapp.fNnclmAmt   = AIcom_ConvertDouble1(struPlyEdrapp.fNnclmAmt  );
	struPlyEdrapp.nSubCoNo	  = AIcom_ConvertInt1(struPlyEdrapp.nSubCoNo );
	struPlyEdrapp.fInsrncVlu  = AIcom_ConvertDouble1(struPlyEdrapp.fInsrncVlu );
	struPlyEdrapp.fAmt        = AIcom_ConvertDouble1(struPlyEdrapp.fAmt       );
	struPlyEdrapp.fRate       = AIcom_ConvertDouble1(struPlyEdrapp.fRate      );
	struPlyEdrapp.fPrm        = AIcom_ConvertDouble1(struPlyEdrapp.fPrm       );
	struPlyEdrapp.fRdrPrm     = AIcom_ConvertDouble1(struPlyEdrapp.fRdrPrm    );
	struPlyEdrapp.fSumPrm     = AIcom_ConvertDouble1(struPlyEdrapp.fSumPrm    );
	struPlyEdrapp.fNclmProp   = AIcom_ConvertDouble1(struPlyEdrapp.fNclmProp  );
	struPlyEdrapp.fAppntProp  = AIcom_ConvertDouble1(struPlyEdrapp.fAppntProp );
	struPlyEdrapp.fCmmProp    = AIcom_ConvertDouble1(struPlyEdrapp.fCmmProp   );
	struPlyEdrapp.fBrkProp    = AIcom_ConvertDouble1(struPlyEdrapp.fBrkProp   );
	struPlyEdrapp.nPayTms     = AIcom_ConvertInt1(struPlyEdrapp.nPayTms  );
	struPlyEdrapp.nEdrPrjNo   = AIcom_ConvertInt1(struPlyEdrapp.nEdrPrjNo);
	struPlyEdrapp.fGotPrm     = AIcom_ConvertDouble1(struPlyEdrapp.fGotPrm    );
	struPlyEdrapp.fSumNclm    = AIcom_ConvertDouble1(struPlyEdrapp.fSumNclm   );
	struPlyEdrapp.fRatio      = AIcom_ConvertDouble1(struPlyEdrapp.fRatio     );
	struPlyEdrapp.fSaveAmtVar = AIcom_ConvertDouble1(struPlyEdrapp.fSaveAmtVar);

	memcpy(pBuff, &struPlyEdrapp, sizeof(plyEdrappStru));
	return ;
}




