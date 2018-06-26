#include "typeconvt.h"
#include "AiConvert.h"
#include "cplyapppolicy.h"



int StrToStruAppPolicy(char** ppstring, int *plenStr, plyAppPolicyStru *pstruAppPolicy)
{
	int j, k;
	if(*ppstring==NULL) return 1;

	j=k=0;
	do
	{
		j++;    if(ToStringField(ppstring,  plenStr,  (pstruAppPolicy->sCrtCde         ), C_CRT_CDE_LEN          )==FALSE) break;    else k++;
		j++;    if(ToStringField(ppstring,  plenStr,  (pstruAppPolicy->sCrtTm          ), TIME_LEN               )==FALSE) break;    else k++;
		j++;    if(ToStringField(ppstring,  plenStr,  (pstruAppPolicy->sUpdCde         ), C_UPD_CDE_LEN          )==FALSE) break;    else k++;
		j++;    if(ToStringField(ppstring,  plenStr,  (pstruAppPolicy->sUpdTm          ), TIME_LEN               )==FALSE) break;    else k++;
		j++;    if(ToStringField(ppstring,  plenStr,  (pstruAppPolicy->sCplyAppNo      ), C_PLY_APP_NO_LEN       )==FALSE) break;    else k++;
		j++;    if(ToStringField(ppstring,  plenStr,  (pstruAppPolicy->sCplyNo         ), C_PLY_NO_LEN           )==FALSE) break;    else k++;
		j++;    if(ToStringField(ppstring,  plenStr,  (pstruAppPolicy->sOrigCplyNo     ), C_ORIG_PLY_NO_LEN      )==FALSE) break;    else k++;
		j++;    if(ToStringField(ppstring,  plenStr,  (pstruAppPolicy->sDptCde         ), C_DPT_CDE_LEN          )==FALSE) break;    else k++;
		j++;    if(ToStringField(ppstring,  plenStr,  (pstruAppPolicy->sBsnsTyp        ), C_BSNS_TYP_LEN         )==FALSE) break;    else k++;
		j++;    if(ToStringField(ppstring,  plenStr,  (pstruAppPolicy->sCmpnyAgtCde    ), C_CMPNY_AGT_CDE_LEN    )==FALSE) break;    else k++;
		j++;    if(ToStringField(ppstring,  plenStr,  (pstruAppPolicy->sAgtAbr         ), C_AGT_ABR_LEN          )==FALSE) break;    else k++;
		j++;    if(ToStringField(ppstring,  plenStr,  (pstruAppPolicy->sAgtAgrNo       ), C_AGT_AGR_NO_LEN       )==FALSE) break;    else k++;
		j++;    if(ToIntField(ppstring,  plenStr,    &(pstruAppPolicy->nSubCoNo        ))==FALSE) break;    else k++;
		j++;    if(ToStringField(ppstring,  plenStr,  (pstruAppPolicy->sBrkrCde        ), C_BRKR_CDE_LEN         )==FALSE) break;    else k++;
		j++;    if(ToStringField(ppstring,  plenStr,  (pstruAppPolicy->sBrkrCnm        ), C_BRKR_CNM_LEN         )==FALSE) break;    else k++;
		j++;    if(ToStringField(ppstring,  plenStr,  (pstruAppPolicy->sSlsCde         ), C_SLS_CDE_LEN          )==FALSE) break;    else k++;
		j++;    if(ToStringField(ppstring,  plenStr,  (pstruAppPolicy->sSlsNme         ), C_EMP_CNM_LEN          )==FALSE) break;    else k++;
		j++;    if(ToStringField(ppstring,  plenStr,  (pstruAppPolicy->sInsrncCmpnyCde ), C_INSRNC_CMPNY_CDE_LEN )==FALSE) break;    else k++;
		j++;    if(ToStringField(ppstring,  plenStr,  (pstruAppPolicy->sInsrncCmpnyCnm ), C_BRKR_CNM_LEN         )==FALSE) break;    else k++;
		j++;    if(ToStringField(ppstring,  plenStr,  (pstruAppPolicy->sInsrntCde      ), C_INSRNT_CDE_LEN       )==FALSE) break;    else k++;
		j++;    if(ToStringField(ppstring,  plenStr,  (pstruAppPolicy->sInsrntNme      ), C_INSRNT_NME_LEN       )==FALSE) break;    else k++;
		j++;    if(ToStringField(ppstring,  plenStr,  (pstruAppPolicy->sInsrntAddr     ), C_INSRNT_ADDR_LEN      )==FALSE) break;    else k++;
		j++;    if(ToStringField(ppstring,  plenStr,  (pstruAppPolicy->sBnfcCde        ), C_BNFC_CDE_LEN         )==FALSE) break;    else k++;
		j++;    if(ToStringField(ppstring,  plenStr,  (pstruAppPolicy->sBnfcNme        ), C_BNFC_NME_LEN         )==FALSE) break;    else k++;
		j++;    if(ToStringField(ppstring,  plenStr,  (pstruAppPolicy->sAppCde         ), C_APP_CDE_LEN          )==FALSE) break;    else k++;
		j++;    if(ToStringField(ppstring,  plenStr,  (pstruAppPolicy->sAppNme         ), C_APP_NME_LEN          )==FALSE) break;    else k++;
		j++;    if(ToStringField(ppstring,  plenStr,  (pstruAppPolicy->sAppAddr        ), C_APP_ADDR_LEN         )==FALSE) break;    else k++;
		j++;    if(ToStringField(ppstring,  plenStr,  (pstruAppPolicy->sAppTel         ), C_APP_TEL_LEN          )==FALSE) break;    else k++;
		j++;    if(ToStringField(ppstring,  plenStr,  (pstruAppPolicy->sInsrncCde      ), C_INSRNC_CDE_LEN       )==FALSE) break;    else k++;
		j++;    if(ToStringField(ppstring,  plenStr,  (pstruAppPolicy->sClausCde       ), C_CLAUS_CDE_LEN        )==FALSE) break;    else k++;
		j++;    if(ToStringField(ppstring,  plenStr,  (pstruAppPolicy->sAppTm          ), DATE_LEN               )==FALSE) break;    else k++;
		j++;    if(ToStringField(ppstring,  plenStr,  (pstruAppPolicy->sInsrncBgnTm    ), TIME_LEN               )==FALSE) break;    else k++;
		j++;    if(ToStringField(ppstring,  plenStr,  (pstruAppPolicy->sInsrncEndTm    ), TIME_LEN               )==FALSE) break;    else k++;
		j++;    if(ToStringField(ppstring,  plenStr,  (pstruAppPolicy->sSignTm         ), TIME_LEN               )==FALSE) break;    else k++;
		j++;    if(ToStringField(ppstring,  plenStr,  (pstruAppPolicy->sAmtCur         ), C_AMT_CUR_LEN          )==FALSE) break;    else k++;
		j++;    if(ToDoubleField(ppstring,  plenStr, &(pstruAppPolicy->fInsrncVlu      ))==FALSE) break;    else k++;
		j++;    if(ToDoubleField(ppstring,  plenStr, &(pstruAppPolicy->fAmt            ))==FALSE) break;    else k++;
		j++;    if(ToDoubleField(ppstring,  plenStr, &(pstruAppPolicy->fRate           ))==FALSE) break;    else k++;
		j++;    if(ToDoubleField(ppstring,  plenStr, &(pstruAppPolicy->fPrm            ))==FALSE) break;    else k++;
		j++;    if(ToDoubleField(ppstring,  plenStr, &(pstruAppPolicy->fRdrPrm         ))==FALSE) break;    else k++;
		j++;    if(ToDoubleField(ppstring,  plenStr, &(pstruAppPolicy->fSumPrm         ))==FALSE) break;    else k++;
		j++;    if(ToStringField(ppstring,  plenStr,  (pstruAppPolicy->sPrmCur         ), C_PRM_CUR_LEN          )==FALSE) break;    else k++;
		j++;    if(ToDoubleField(ppstring,  plenStr, &(pstruAppPolicy->fNclmProp       ))==FALSE) break;    else k++;
		j++;    if(ToDoubleField(ppstring,  plenStr, &(pstruAppPolicy->fAppntProp      ))==FALSE) break;    else k++;
		j++;    if(ToDoubleField(ppstring,  plenStr, &(pstruAppPolicy->fCmmProp        ))==FALSE) break;    else k++;
		j++;    if(ToDoubleField(ppstring,  plenStr, &(pstruAppPolicy->fBrkProp        ))==FALSE) break;    else k++;
		j++;    if(ToIntField(ppstring,  plenStr,    &(pstruAppPolicy->nPayTms         ))==FALSE) break;    else k++;
		j++;    if(ToStringField(ppstring,  plenStr,  (pstruAppPolicy->sAppnt          ), C_APPNT_LEN            )==FALSE) break;    else k++;
		j++;    if(ToStringField(ppstring,  plenStr,  (pstruAppPolicy->sRemark         ), C_REMARK_LEN           )==FALSE) break;    else k++;
		j++;    if(ToStringField(ppstring,  plenStr,  (pstruAppPolicy->sCrtPrsn        ), C_CRT_PRSN_LEN         )==FALSE) break;    else k++;
		j++;    if(ToStringField(ppstring,  plenStr,  (pstruAppPolicy->sUndrPrsn       ), C_UNDR_PRSN_LEN        )==FALSE) break;    else k++;
		j++;    if(ToStringField(ppstring,  plenStr,  (pstruAppPolicy->sUndrTm         ), TIME_LEN               )==FALSE) break;    else k++;
		j++;    if(ToStringField(ppstring,  plenStr,  (pstruAppPolicy->sRinsrncMrk     ), C_RINSRNC_MRK_LEN      )==FALSE) break;    else k++;
		j++;    if(ToStringField(ppstring,  plenStr,  (pstruAppPolicy->sCoinsrncMrk    ), C_COINSRNC_MRK_LEN     )==FALSE) break;    else k++;
		j++;    if(ToStringField(ppstring,  plenStr,  (pstruAppPolicy->sInputTm        ), DATE_LEN               )==FALSE) break;    else k++;
		j++;    if(ToStringField(ppstring,  plenStr,  (pstruAppPolicy->sUndrDpt        ), C_UNDR_DPT_LEN         )==FALSE) break;    else k++;
		j++;    if(ToStringField(ppstring,  plenStr,  (pstruAppPolicy->sOprTyp         ), C_OPR_TYP_LEN          )==FALSE) break;    else k++;
		j++;    if(ToIntField(ppstring,  plenStr,    &(pstruAppPolicy->nEdrPrjNo       ))==FALSE) break;    else k++;
		j++;    if(ToStringField(ppstring,  plenStr,  (pstruAppPolicy->sNextEdrUndrTm  ), TIME_LEN               )==FALSE) break;    else k++;
		j++;    if(ToStringField(ppstring,  plenStr,  (pstruAppPolicy->sUdrMrk         ), C_UDR_MRK_LEN          )==FALSE) break;    else k++;
		j++;    if(ToStringField(ppstring,  plenStr,  (pstruAppPolicy->sRecNo          ), C_REC_NO_LEN           )==FALSE) break;    else k++;
		j++;    if(ToStringField(ppstring,  plenStr,  (pstruAppPolicy->sDptCnm         ), C_DPT_CNM_LEN          )==FALSE) break;    else k++;
		j++;    if(ToStringField(ppstring,  plenStr,  (pstruAppPolicy->sInsrncCnm      ), C_INSRNC_CNM_LEN       )==FALSE) break;    else k++;
		j++;    if(ToStringField(ppstring,  plenStr,  (pstruAppPolicy->sUndrPrsnCnm    ), C_EMP_CNM_LEN          )==FALSE) break;    else k++;
		j++;    if(ToStringField(ppstring,  plenStr,  (pstruAppPolicy->sUndrDptCnm     ), C_DPT_CNM_LEN          )==FALSE) break;    else k++;
		j++;    if(ToStringField(ppstring,  plenStr,  (pstruAppPolicy->sCrtPrsnCnm     ), C_EMP_CNM_LEN          )==FALSE) break;    else k++;
		j++;    if(ToStringField(ppstring,  plenStr,  (pstruAppPolicy->sAmtCurCnm      ), C_CUR_CNM_LEN          )==FALSE) break;    else k++;
		j++;    if(ToStringField(ppstring,  plenStr,  (pstruAppPolicy->sAgeLongMrk     ), C_AGELONG_MRK_LEN      )==FALSE) break;    else k++;
		j++;    if(ToStringField(ppstring,  plenStr,  (pstruAppPolicy->sCeprnMrk       ), C_CEPRN_MRK_LEN        )==FALSE) break;    else k++;
		j++;    if(ToStringField(ppstring,  plenStr,  (pstruAppPolicy->sSalegrpCde     ), C_SALEGRP_CDE_LEN      )==FALSE) break;    else k++;
		j++;    if(ToDoubleField(ppstring,  plenStr, &(pstruAppPolicy->fSumNclm        ))==FALSE) break;    else k++;
		j++;    if(ToStringField(ppstring,  plenStr,  (pstruAppPolicy->sZipCde         ), C_ZIP_CDE_LEN          )==FALSE) break;    else k++;
		j++;    if(ToStringField(ppstring,  plenStr,  (pstruAppPolicy->sSttl           ), C_STTL_LEN             )==FALSE) break;    else k++;
		j++;    if(ToDoubleField(ppstring,  plenStr, &(pstruAppPolicy->fRatio          ))==FALSE) break;    else k++;
		j++;    if(ToStringField(ppstring,  plenStr,  (pstruAppPolicy->sCntctPrsnNme   ), C_CNTCT_PRSN_NME_LEN   )==FALSE) break;    else k++;
		j++;    if(ToStringField(ppstring,  plenStr,  (pstruAppPolicy->sAppTyp         ), C_APP_TYP_LEN          )==FALSE) break;    else k++;
		j++;    if(ToStringField(ppstring,  plenStr,  (pstruAppPolicy->sQueryMrk       ), C_QUERY_MRK_LEN        )==FALSE) break;    else k++;
		j++;    if(ToStringField(ppstring,  plenStr,  (pstruAppPolicy->sFstUndrPrsn    ), C_FST_UNDR_PRSN_LEN    )==FALSE) break;    else k++;
		j++;    if(ToStringField(ppstring,  plenStr,  (pstruAppPolicy->sFstOpn         ), C_FST_OPN_LEN          )==FALSE) break;    else k++;
		j++;    if(ToStringField(ppstring,  plenStr,  (pstruAppPolicy->sChkPrsn        ), C_CHK_PRSN_LEN         )==FALSE) break;    else k++;
		j++;    if(ToStringField(ppstring,  plenStr,  (pstruAppPolicy->sChkRec         ), C_CHK_REC_LEN          )==FALSE) break;    else k++;
		j++;    if(ToStringField(ppstring,  plenStr,  (pstruAppPolicy->sChkTm          ), TIME_LEN               )==FALSE) break;    else k++;
		j++;    if(ToStringField(ppstring,  plenStr,  (pstruAppPolicy->sFstUndrTm      ), TIME_LEN               )==FALSE) break;    else k++;
		j++;    if(ToStringField(ppstring,  plenStr,  (pstruAppPolicy->sOpenCoverNo    ), C_OPEN_COVER_NO_LEN    )==FALSE) break;    else k++;
		j++;    if(ToStringField(ppstring,  plenStr,  (pstruAppPolicy->sInternetTyp    ), C_INTERNET_TYP_LEN     )==FALSE) break;    else k++;
	}while(0);
	if(j!=k) 
	{	
		#ifdef _DEBUG
		printf("StrToStruAppPolicy failed: Field index = %d\n", j);
		#endif
		return 0-j;
	}
	return 0;

}

void StruPlyAppPolicyToStr(plyAppPolicyStru* pstruAppPolicy, char** ppstring, int* plenStr)
{
	StrToStr(pstruAppPolicy->sCrtCde, ppstring,  plenStr);  
	StrToStr(pstruAppPolicy->sCrtTm, ppstring,  plenStr);  
	StrToStr(pstruAppPolicy->sUpdCde, ppstring,  plenStr);  
	StrToStr(pstruAppPolicy->sUpdTm, ppstring,  plenStr);  
	StrToStr(pstruAppPolicy->sCplyAppNo, ppstring,  plenStr);  
	StrToStr(pstruAppPolicy->sCplyNo, ppstring,  plenStr);  
	StrToStr(pstruAppPolicy->sOrigCplyNo, ppstring,  plenStr);  
	StrToStr(pstruAppPolicy->sDptCde, ppstring,  plenStr);  
	StrToStr(pstruAppPolicy->sBsnsTyp, ppstring,  plenStr);  
	StrToStr(pstruAppPolicy->sCmpnyAgtCde, ppstring,  plenStr);  
	StrToStr(pstruAppPolicy->sAgtAbr, ppstring,  plenStr);  
	StrToStr(pstruAppPolicy->sAgtAgrNo, ppstring,  plenStr);  
	IntToStr(pstruAppPolicy->nSubCoNo, ppstring,  plenStr);  
	StrToStr(pstruAppPolicy->sBrkrCde, ppstring,  plenStr);  
	StrToStr(pstruAppPolicy->sBrkrCnm, ppstring,  plenStr);  
	StrToStr(pstruAppPolicy->sSlsCde, ppstring,  plenStr);  
	StrToStr(pstruAppPolicy->sSlsNme, ppstring,  plenStr);  
	StrToStr(pstruAppPolicy->sInsrncCmpnyCde, ppstring,  plenStr);  
	StrToStr(pstruAppPolicy->sInsrncCmpnyCnm, ppstring,  plenStr);  
	StrToStr(pstruAppPolicy->sInsrntCde, ppstring,  plenStr);  
	StrToStr(pstruAppPolicy->sInsrntNme, ppstring,  plenStr);  
	StrToStr(pstruAppPolicy->sInsrntAddr, ppstring,  plenStr);  
	StrToStr(pstruAppPolicy->sBnfcCde, ppstring,  plenStr);  
	StrToStr(pstruAppPolicy->sBnfcNme, ppstring,  plenStr);  
	StrToStr(pstruAppPolicy->sAppCde, ppstring,  plenStr);  
	StrToStr(pstruAppPolicy->sAppNme, ppstring,  plenStr);  
	StrToStr(pstruAppPolicy->sAppAddr, ppstring,  plenStr);  
	StrToStr(pstruAppPolicy->sAppTel, ppstring,  plenStr);  
	StrToStr(pstruAppPolicy->sInsrncCde, ppstring,  plenStr);  
	StrToStr(pstruAppPolicy->sClausCde, ppstring,  plenStr);  
	StrToStr(pstruAppPolicy->sAppTm, ppstring,  plenStr);  
	StrToStr(pstruAppPolicy->sInsrncBgnTm, ppstring,  plenStr);  
	StrToStr(pstruAppPolicy->sInsrncEndTm, ppstring,  plenStr);  
	StrToStr(pstruAppPolicy->sSignTm, ppstring,  plenStr);  
	StrToStr(pstruAppPolicy->sAmtCur, ppstring,  plenStr);  
	DoubleToStr(pstruAppPolicy->fInsrncVlu, ppstring,  plenStr);  
	DoubleToStr(pstruAppPolicy->fAmt, ppstring,  plenStr);  
	DoubleToStr(pstruAppPolicy->fRate, ppstring,  plenStr);  
	DoubleToStr(pstruAppPolicy->fPrm, ppstring,  plenStr);  
	DoubleToStr(pstruAppPolicy->fRdrPrm, ppstring,  plenStr);  
	DoubleToStr(pstruAppPolicy->fSumPrm, ppstring,  plenStr);  
	StrToStr(pstruAppPolicy->sPrmCur, ppstring,  plenStr);  
	DoubleToStr(pstruAppPolicy->fNclmProp, ppstring,  plenStr);  
	DoubleToStr(pstruAppPolicy->fAppntProp, ppstring,  plenStr);  
	DoubleToStr(pstruAppPolicy->fCmmProp, ppstring,  plenStr);  
	DoubleToStr(pstruAppPolicy->fBrkProp, ppstring,  plenStr);  
	IntToStr(pstruAppPolicy->nPayTms, ppstring,  plenStr);  
	StrToStr(pstruAppPolicy->sAppnt, ppstring,  plenStr);  
	StrToStr(pstruAppPolicy->sRemark, ppstring,  plenStr);  
	StrToStr(pstruAppPolicy->sCrtPrsn, ppstring,  plenStr);  
	StrToStr(pstruAppPolicy->sUndrPrsn, ppstring,  plenStr);  
	StrToStr(pstruAppPolicy->sUndrTm, ppstring,  plenStr);  
	StrToStr(pstruAppPolicy->sRinsrncMrk, ppstring,  plenStr);  
	StrToStr(pstruAppPolicy->sCoinsrncMrk, ppstring,  plenStr);  
	StrToStr(pstruAppPolicy->sInputTm, ppstring,  plenStr);  
	StrToStr(pstruAppPolicy->sUndrDpt, ppstring,  plenStr);  
	StrToStr(pstruAppPolicy->sOprTyp, ppstring,  plenStr);  
	IntToStr(pstruAppPolicy->nEdrPrjNo, ppstring,  plenStr);  
	StrToStr(pstruAppPolicy->sNextEdrUndrTm, ppstring,  plenStr);  
	StrToStr(pstruAppPolicy->sUdrMrk, ppstring,  plenStr);  
	StrToStr(pstruAppPolicy->sRecNo, ppstring,  plenStr);  
	StrToStr(pstruAppPolicy->sDptCnm , ppstring,  plenStr);  
	StrToStr(pstruAppPolicy->sInsrncCnm, ppstring,  plenStr);  
	StrToStr(pstruAppPolicy->sUndrPrsnCnm, ppstring,  plenStr);  
	StrToStr(pstruAppPolicy->sUndrDptCnm, ppstring,  plenStr);  
	StrToStr(pstruAppPolicy->sCrtPrsnCnm, ppstring,  plenStr);  
	StrToStr(pstruAppPolicy->sAmtCurCnm, ppstring,  plenStr);  
	StrToStr(pstruAppPolicy->sAgeLongMrk, ppstring,  plenStr);  
	StrToStr(pstruAppPolicy->sCeprnMrk, ppstring,  plenStr);  
	StrToStr(pstruAppPolicy->sSalegrpCde, ppstring,  plenStr);  
	DoubleToStr(pstruAppPolicy->fSumNclm, ppstring,  plenStr);  
	StrToStr(pstruAppPolicy->sZipCde, ppstring,  plenStr);  
	StrToStr(pstruAppPolicy->sSttl, ppstring,  plenStr);  
	DoubleToStr(pstruAppPolicy->fRatio, ppstring,  plenStr);  
	StrToStr(pstruAppPolicy->sCntctPrsnNme, ppstring,  plenStr);  
	StrToStr(pstruAppPolicy->sAppTyp, ppstring,  plenStr);  
	StrToStr(pstruAppPolicy->sQueryMrk, ppstring,  plenStr);  
	StrToStr(pstruAppPolicy->sFstUndrPrsn, ppstring,  plenStr);  
	StrToStr(pstruAppPolicy->sFstOpn, ppstring,  plenStr);  
	StrToStr(pstruAppPolicy->sChkPrsn, ppstring,  plenStr);  
	StrToStr(pstruAppPolicy->sChkRec, ppstring,  plenStr);  
	StrToStr(pstruAppPolicy->sChkTm, ppstring,  plenStr);  
	StrToStr(pstruAppPolicy->sFstUndrTm, ppstring,  plenStr);  
	StrToStr(pstruAppPolicy->sOpenCoverNo, ppstring,  plenStr);  
	StrToStr(pstruAppPolicy->sInternetTyp, ppstring,  plenStr);  
	return ;
}


void PrintStruAppPolicy(const plyAppPolicyStru *pstruAppPolicyTemp)
{
	printf("pstruAppPolicyTemp->sCrtCde         = [%s]\n", pstruAppPolicyTemp->sCrtCde);                      
	printf("pstruAppPolicyTemp->sCrtTm          = [%s]\n", pstruAppPolicyTemp->sCrtTm);                      
	printf("pstruAppPolicyTemp->sUpdCde         = [%s]\n", pstruAppPolicyTemp->sUpdCde);                      
	printf("pstruAppPolicyTemp->sUpdTm          = [%s]\n", pstruAppPolicyTemp->sUpdTm);                      
	printf("pstruAppPolicyTemp->sCplyAppNo      = [%s]\n", pstruAppPolicyTemp->sCplyAppNo);                      
	printf("pstruAppPolicyTemp->sCplyNo         = [%s]\n", pstruAppPolicyTemp->sCplyNo);                      
	printf("pstruAppPolicyTemp->sOrigCplyNo     = [%s]\n", pstruAppPolicyTemp->sOrigCplyNo);                      
	printf("pstruAppPolicyTemp->sDptCde         = [%s]\n", pstruAppPolicyTemp->sDptCde);                      
	printf("pstruAppPolicyTemp->sBsnsTyp        = [%s]\n", pstruAppPolicyTemp->sBsnsTyp);                      
	printf("pstruAppPolicyTemp->sCmpnyAgtCde    = [%s]\n", pstruAppPolicyTemp->sCmpnyAgtCde);                      
	printf("pstruAppPolicyTemp->sAgtAbr         = [%s]\n", pstruAppPolicyTemp->sAgtAbr);                      
	printf("pstruAppPolicyTemp->sAgtAgrNo       = [%s]\n", pstruAppPolicyTemp->sAgtAgrNo);                      
	printf("pstruAppPolicyTemp->nSubCoNo        = [%d]\n", pstruAppPolicyTemp->nSubCoNo);                      
	printf("pstruAppPolicyTemp->sBrkrCde        = [%s]\n", pstruAppPolicyTemp->sBrkrCde);                      
	printf("pstruAppPolicyTemp->sBrkrCnm        = [%s]\n", pstruAppPolicyTemp->sBrkrCnm);                      
	printf("pstruAppPolicyTemp->sSlsCde         = [%s]\n", pstruAppPolicyTemp->sSlsCde);                      
	printf("pstruAppPolicyTemp->sSlsNme         = [%s]\n", pstruAppPolicyTemp->sSlsNme);                      
	printf("pstruAppPolicyTemp->sInsrncCmpnyCde = [%s]\n", pstruAppPolicyTemp->sInsrncCmpnyCde);                      
	printf("pstruAppPolicyTemp->sInsrncCmpnyCnm = [%s]\n", pstruAppPolicyTemp->sInsrncCmpnyCnm);                      
	printf("pstruAppPolicyTemp->sInsrntCde      = [%s]\n", pstruAppPolicyTemp->sInsrntCde);                      
	printf("pstruAppPolicyTemp->sInsrntNme      = [%s]\n", pstruAppPolicyTemp->sInsrntNme);                      
	printf("pstruAppPolicyTemp->sInsrntAddr     = [%s]\n", pstruAppPolicyTemp->sInsrntAddr);                      
	printf("pstruAppPolicyTemp->sBnfcCde        = [%s]\n", pstruAppPolicyTemp->sBnfcCde);                      
	printf("pstruAppPolicyTemp->sBnfcNme        = [%s]\n", pstruAppPolicyTemp->sBnfcNme);                      
	printf("pstruAppPolicyTemp->sAppCde         = [%s]\n", pstruAppPolicyTemp->sAppCde);                      
	printf("pstruAppPolicyTemp->sAppNme         = [%s]\n", pstruAppPolicyTemp->sAppNme);                      
	printf("pstruAppPolicyTemp->sAppAddr        = [%s]\n", pstruAppPolicyTemp->sAppAddr);                      
	printf("pstruAppPolicyTemp->sAppTel         = [%s]\n", pstruAppPolicyTemp->sAppTel);                      
	printf("pstruAppPolicyTemp->sInsrncCde      = [%s]\n", pstruAppPolicyTemp->sInsrncCde);                      
	printf("pstruAppPolicyTemp->sClausCde       = [%s]\n", pstruAppPolicyTemp->sClausCde);                      
	printf("pstruAppPolicyTemp->sAppTm          = [%s]\n", pstruAppPolicyTemp->sAppTm);                      
	printf("pstruAppPolicyTemp->sInsrncBgnTm    = [%s]\n", pstruAppPolicyTemp->sInsrncBgnTm);                      
	printf("pstruAppPolicyTemp->sInsrncEndTm    = [%s]\n", pstruAppPolicyTemp->sInsrncEndTm);                      
	printf("pstruAppPolicyTemp->sSignTm         = [%s]\n", pstruAppPolicyTemp->sSignTm);                      
	printf("pstruAppPolicyTemp->sAmtCur         = [%s]\n", pstruAppPolicyTemp->sAmtCur);                      
	printf("pstruAppPolicyTemp->fInsrncVlu      = [%f]\n", pstruAppPolicyTemp->fInsrncVlu);                      
	printf("pstruAppPolicyTemp->fAmt            = [%f]\n", pstruAppPolicyTemp->fAmt);                      
	printf("pstruAppPolicyTemp->fRate           = [%f]\n", pstruAppPolicyTemp->fRate);                      
	printf("pstruAppPolicyTemp->fPrm            = [%f]\n", pstruAppPolicyTemp->fPrm);                      
	printf("pstruAppPolicyTemp->fRdrPrm         = [%f]\n", pstruAppPolicyTemp->fRdrPrm);                      
	printf("pstruAppPolicyTemp->fSumPrm         = [%f]\n", pstruAppPolicyTemp->fSumPrm);                      
	printf("pstruAppPolicyTemp->sPrmCur         = [%s]\n", pstruAppPolicyTemp->sPrmCur);                      
	printf("pstruAppPolicyTemp->fNclmProp       = [%f]\n", pstruAppPolicyTemp->fNclmProp);                      
	printf("pstruAppPolicyTemp->fAppntProp      = [%f]\n", pstruAppPolicyTemp->fAppntProp);                      
	printf("pstruAppPolicyTemp->fCmmProp        = [%f]\n", pstruAppPolicyTemp->fCmmProp);                      
	printf("pstruAppPolicyTemp->fBrkProp        = [%f]\n", pstruAppPolicyTemp->fBrkProp);                      
	printf("pstruAppPolicyTemp->nPayTms         = [%d]\n", pstruAppPolicyTemp->nPayTms);                      
	printf("pstruAppPolicyTemp->sAppnt          = [%s]\n", pstruAppPolicyTemp->sAppnt);                      
	printf("pstruAppPolicyTemp->sRemark         = [%s]\n", pstruAppPolicyTemp->sRemark);                      
	printf("pstruAppPolicyTemp->sCrtPrsn        = [%s]\n", pstruAppPolicyTemp->sCrtPrsn);                      
	printf("pstruAppPolicyTemp->sUndrPrsn       = [%s]\n", pstruAppPolicyTemp->sUndrPrsn);                      
	printf("pstruAppPolicyTemp->sUndrTm         = [%s]\n", pstruAppPolicyTemp->sUndrTm);                      
	printf("pstruAppPolicyTemp->sRinsrncMrk     = [%s]\n", pstruAppPolicyTemp->sRinsrncMrk);                      
	printf("pstruAppPolicyTemp->sCoinsrncMrk    = [%s]\n", pstruAppPolicyTemp->sCoinsrncMrk);                      
	printf("pstruAppPolicyTemp->sInputTm        = [%s]\n", pstruAppPolicyTemp->sInputTm);                      
	printf("pstruAppPolicyTemp->sUndrDpt        = [%s]\n", pstruAppPolicyTemp->sUndrDpt);                      
	printf("pstruAppPolicyTemp->sOprTyp         = [%s]\n", pstruAppPolicyTemp->sOprTyp);                      
	printf("pstruAppPolicyTemp->nEdrPrjNo       = [%d]\n", pstruAppPolicyTemp->nEdrPrjNo);                      
	printf("pstruAppPolicyTemp->sNextEdrUndrTm  = [%s]\n", pstruAppPolicyTemp->sNextEdrUndrTm);                      
	printf("pstruAppPolicyTemp->sUdrMrk         = [%s]\n", pstruAppPolicyTemp->sUdrMrk);                      
	printf("pstruAppPolicyTemp->sRecNo          = [%s]\n", pstruAppPolicyTemp->sRecNo);                      
	printf("pstruAppPolicyTemp->sDptCnm         = [%s]\n", pstruAppPolicyTemp->sDptCnm );                      
	printf("pstruAppPolicyTemp->sInsrncCnm      = [%s]\n", pstruAppPolicyTemp->sInsrncCnm);                      
	printf("pstruAppPolicyTemp->sUndrPrsnCnm    = [%s]\n", pstruAppPolicyTemp->sUndrPrsnCnm);                      
	printf("pstruAppPolicyTemp->sUndrDptCnm     = [%s]\n", pstruAppPolicyTemp->sUndrDptCnm);                      
	printf("pstruAppPolicyTemp->sCrtPrsnCnm     = [%s]\n", pstruAppPolicyTemp->sCrtPrsnCnm);                      
	printf("pstruAppPolicyTemp->sAmtCurCnm      = [%s]\n", pstruAppPolicyTemp->sAmtCurCnm);                      
	printf("pstruAppPolicyTemp->sAgeLongMrk     = [%s]\n", pstruAppPolicyTemp->sAgeLongMrk);                      
	printf("pstruAppPolicyTemp->sCeprnMrk       = [%s]\n", pstruAppPolicyTemp->sCeprnMrk);                      
	printf("pstruAppPolicyTemp->sSalegrpCde     = [%s]\n", pstruAppPolicyTemp->sSalegrpCde);                      
	printf("pstruAppPolicyTemp->fSumNclm        = [%f]\n", pstruAppPolicyTemp->fSumNclm);                      
	printf("pstruAppPolicyTemp->sZipCde         = [%s]\n", pstruAppPolicyTemp->sZipCde);                      
	printf("pstruAppPolicyTemp->sSttl           = [%s]\n", pstruAppPolicyTemp->sSttl);                      
	printf("pstruAppPolicyTemp->fRatio          = [%f]\n", pstruAppPolicyTemp->fRatio);                      
	printf("pstruAppPolicyTemp->sCntctPrsnNme   = [%s]\n", pstruAppPolicyTemp->sCntctPrsnNme);                      
	printf("pstruAppPolicyTemp->sAppTyp         = [%s]\n", pstruAppPolicyTemp->sAppTyp);                      
	printf("pstruAppPolicyTemp->sQueryMrk       = [%s]\n", pstruAppPolicyTemp->sQueryMrk);                      
	printf("pstruAppPolicyTemp->sFstUndrPrsn    = [%s]\n", pstruAppPolicyTemp->sFstUndrPrsn);                      
	printf("pstruAppPolicyTemp->sFstOpn         = [%s]\n", pstruAppPolicyTemp->sFstOpn);                      
	printf("pstruAppPolicyTemp->sChkPrsn        = [%s]\n", pstruAppPolicyTemp->sChkPrsn);                      
	printf("pstruAppPolicyTemp->sChkRec         = [%s]\n", pstruAppPolicyTemp->sChkRec);                      
	printf("pstruAppPolicyTemp->sChkTm          = [%s]\n", pstruAppPolicyTemp->sChkTm);                      
	printf("pstruAppPolicyTemp->sFstUndrTm      = [%s]\n", pstruAppPolicyTemp->sFstUndrTm);                      
	printf("pstruAppPolicyTemp->sOpenCoverNo    = [%s]\n", pstruAppPolicyTemp->sOpenCoverNo);                      
	printf("pstruAppPolicyTemp->sInternetTyp    = [%s]\n\n", pstruAppPolicyTemp->sInternetTyp);                      
}




void struAppPolicyOrderConvt(char *pBuff)
{
	plyAppPolicyStru struAppPolicy;
	memcpy(&struAppPolicy, pBuff, sizeof(plyAppPolicyStru));

	struAppPolicy.nSubCoNo   = AIcom_ConvertInt1(struAppPolicy.nSubCoNo);
	struAppPolicy.fInsrncVlu = AIcom_ConvertDouble1(struAppPolicy.fInsrncVlu);    
	struAppPolicy.fAmt       = AIcom_ConvertDouble1(struAppPolicy.fAmt);        
	struAppPolicy.fRate      = AIcom_ConvertDouble1(struAppPolicy.fRate);            
	struAppPolicy.fPrm       = AIcom_ConvertDouble1(struAppPolicy.fPrm);  
	struAppPolicy.fRdrPrm    = AIcom_ConvertDouble1(struAppPolicy.fRdrPrm);      
	struAppPolicy.fSumPrm    = AIcom_ConvertDouble1(struAppPolicy.fSumPrm);      
	struAppPolicy.fNclmProp  = AIcom_ConvertDouble1(struAppPolicy.fNclmProp);      
	struAppPolicy.fAppntProp = AIcom_ConvertDouble1(struAppPolicy.fAppntProp);      
	struAppPolicy.fCmmProp   = AIcom_ConvertDouble1(struAppPolicy.fCmmProp);      
	struAppPolicy.fBrkProp   = AIcom_ConvertDouble1(struAppPolicy.fBrkProp);      
	struAppPolicy.nPayTms    = AIcom_ConvertInt1(struAppPolicy.nPayTms);      
	struAppPolicy.nEdrPrjNo  = AIcom_ConvertInt1(struAppPolicy.nEdrPrjNo);      
	struAppPolicy.fSumNclm   = AIcom_ConvertDouble1(struAppPolicy.fSumNclm);      
	struAppPolicy.fRatio     = AIcom_ConvertDouble1(struAppPolicy.fRatio); 
	
	memcpy(pBuff, &struAppPolicy, sizeof(plyAppPolicyStru));
	return ;
}

