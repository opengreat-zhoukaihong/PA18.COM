#include "typeconvt.h"
#include "AiConvert.h"
#include "cclminlistchange.h"




int StrToStruClmInListChange(char** ppstring, int *plenStr, clmInListChangeStru *pstruClmInListChange)
{
	int i, j;
	if(*ppstring==NULL) return 1;

	i=j=0;
	do
	{
		j++;    if(ToStringField(ppstring,  plenStr, (pstruClmInListChange->sPlcyNo          ), C_PLY_NO_LEN          )==FALSE) break;    else i++;
		j++;    if(ToStringField(ppstring,  plenStr, (pstruClmInListChange->sRptNo           ), C_RPT_NO_LEN          )==FALSE) break;    else i++;
		j++;    if(ToStringField(ppstring,  plenStr, (pstruClmInListChange->sClmNo           ), C_CLM_NO_LEN          )==FALSE) break;    else i++;
		j++;    if(ToStringField(ppstring,  plenStr, (pstruClmInListChange->sInsrntName      ), C_INSRNT_NME_LEN      )==FALSE) break;    else i++;
		j++;    if(ToStringField(ppstring,  plenStr, (pstruClmInListChange->sInsrntCde       ), C_INSRNT_CDE_LEN      )==FALSE) break;    else i++;
		j++;    if(ToStringField(ppstring,  plenStr, (pstruClmInListChange->sInsrncTgt       ), C_INSRNC_TGT_LEN      )==FALSE) break;    else i++;
		j++;    if(ToStringField(ppstring,  plenStr, (pstruClmInListChange->sRptNme          ), C_RPT_NME_LEN         )==FALSE) break;    else i++;
		j++;    if(ToStringField(ppstring,  plenStr, (pstruClmInListChange->sBigClm          ), 2                     )==FALSE) break;    else i++;
		j++;    if(ToStringField(ppstring,  plenStr, (pstruClmInListChange->sRptAddrTel      ), C_RPT_ADDR_TEL_LEN    )==FALSE) break;    else i++;
		j++;    if(ToStringField(ppstring,  plenStr, (pstruClmInListChange->sRptTm           ), TIME_LEN              )==FALSE) break;    else i++;
		j++;    if(ToStringField(ppstring,  plenStr, (pstruClmInListChange->sAccdntTm        ), TIME_LEN              )==FALSE) break;    else i++;
		j++;    if(ToStringField(ppstring,  plenStr, (pstruClmInListChange->sAccdntSpot      ), C_ACCDNT_SPOT_LEN     )==FALSE) break;    else i++;
		j++;    if(ToStringField(ppstring,  plenStr, (pstruClmInListChange->sAccdntCaus      ), C_ACCDNT_CAUS_LEN     )==FALSE) break;    else i++;
		j++;    if(ToStringField(ppstring,  plenStr, (pstruClmInListChange->sLosDtl          ), C_LOS_DTL_LEN         )==FALSE) break;    else i++;
		j++;    if(ToStringField(ppstring,  plenStr, (pstruClmInListChange->sCurTyp          ), C_CUR_TYP_LEN         )==FALSE) break;    else i++;
		j++;    if(ToDoubleField(ppstring,  plenStr, &(pstruClmInListChange->dRptAmt         )                        )==FALSE) break;    else i++;
		j++;    if(ToStringField(ppstring,  plenStr, (pstruClmInListChange->sInsrncCde       ), C_INSRNC_CDE_LEN      )==FALSE) break;    else i++;
		j++;    if(ToStringField(ppstring,  plenStr, (pstruClmInListChange->sRcvrCde         ), C_RCVR_CDE_LEN        )==FALSE) break;    else i++;
		j++;    if(ToStringField(ppstring,  plenStr, (pstruClmInListChange->sOpinion         ), C_OPINION_LEN         )==FALSE) break;    else i++;
		j++;    if(ToStringField(ppstring,  plenStr, (pstruClmInListChange->sRemark          ), C_REMARK_LEN          )==FALSE) break;    else i++;
		j++;    if(ToStringField(ppstring,  plenStr, (pstruClmInListChange->sTgtLosDtl       ), C_TGT_LOS_DTL_LEN     )==FALSE) break;    else i++;
		j++;    if(ToStringField(ppstring,  plenStr, (pstruClmInListChange->sHlpLos          ), C_HLP_EXP_LEN         )==FALSE) break;    else i++;
		j++;    if(ToStringField(ppstring,  plenStr, (pstruClmInListChange->sThdLos          ), C_THD_LOS_LEN         )==FALSE) break;    else i++;
		j++;    if(ToStringField(ppstring,  plenStr, (pstruClmInListChange->sClmPrcsDtl      ), C_CLM_PRCS_DTL_LEN    )==FALSE) break;    else i++;
		j++;    if(ToStringField(ppstring,  plenStr, (pstruClmInListChange->sSrsCaseOpinion  ), C_SRS_CASE_OPINION_LEN)==FALSE) break;    else i++;
		j++;    if(ToStringField(ppstring,  plenStr, (pstruClmInListChange->sDptCde          ), C_DPT_CDE_LEN         )==FALSE) break;    else i++;
		j++;    if(ToStringField(ppstring,  plenStr, (pstruClmInListChange->sRptRgstMdfyTm   ), TIME_LEN              )==FALSE) break;    else i++;
		j++;    if(ToStringField(ppstring,  plenStr, (pstruClmInListChange->sPrcsDptCde      ), C_DPT_CDE_LEN         )==FALSE) break;    else i++;
		j++;    if(ToStringField(ppstring,  plenStr, (pstruClmInListChange->sRptRgstCde      ), C_RPT_RGST_CDE_LEN    )==FALSE) break;    else i++;
		j++;    if(ToStringField(ppstring,  plenStr, (pstruClmInListChange->sInsrncBgnTm     ), DATE_LEN              )==FALSE) break;    else i++;
		j++;    if(ToStringField(ppstring,  plenStr, (pstruClmInListChange->sInsrncEndTm     ), DATE_LEN              )==FALSE) break;    else i++;
		j++;    if(ToDoubleField(ppstring,  plenStr, &(pstruClmInListChange->dTgtAmt       	 )                        )==FALSE) break;    else i++;
		j++;    if(ToStringField(ppstring,  plenStr, (pstruClmInListChange->sInsCurTyp       ), C_CUR_TYP_LEN         )==FALSE) break;    else i++;
		j++;    if(ToStringField(ppstring,  plenStr, (pstruClmInListChange->sCarNo           ), C_CAR_NO_LEN          )==FALSE) break;    else i++;
		j++;    if(ToStringField(ppstring,  plenStr, (pstruClmInListChange->sLcnNo           ), C_LCN_NO_LEN          )==FALSE) break;    else i++;
		j++;    if(ToStringField(ppstring,  plenStr, (pstruClmInListChange->sBrndCde         ), C_BRND_CDE_LEN        )==FALSE) break;    else i++;
		j++;    if(ToStringField(ppstring,  plenStr, (pstruClmInListChange->sEngNo           ), C_ENG_NO_LEN          )==FALSE) break;    else i++;
		j++;    if(ToStringField(ppstring,  plenStr, (pstruClmInListChange->sAccdntDtl       ), C_ACCDNT_DTL_LEN      )==FALSE) break;    else i++;
		j++;    if(ToStringField(ppstring,  plenStr, (pstruClmInListChange->sRptPrcsMrk      ), 2                     )==FALSE) break;    else i++;
		j++;    if(ToStringField(ppstring,  plenStr, (pstruClmInListChange->sBrndCnm         ), C_BRND_CNM_LEN        )==FALSE) break;    else i++;
		j++;    if(ToStringField(ppstring,  plenStr, (pstruClmInListChange->sInternetTyp     ), 2                     )==FALSE) break;    else i++;

	}while(0);
	if(j!=i) 
	{	
		#ifdef _DEBUG
		printf("StrToStruClmInListChange failed: Field index = %d\n", j);
		#endif
		return 0-j;
	}
	return 0;
}



void PrintStruClmInListChange(const clmInListChangeStru *pstruClmInListChange)
{
	printf("pstruClmInListChange->sPlcyNo         = [%s]\n",  pstruClmInListChange->sPlcyNo        );
	printf("pstruClmInListChange->sRptNo          = [%s]\n",  pstruClmInListChange->sRptNo         );
	printf("pstruClmInListChange->sClmNo          = [%s]\n",  pstruClmInListChange->sClmNo         );
	printf("pstruClmInListChange->sInsrntName     = [%s]\n",  pstruClmInListChange->sInsrntName    );
	printf("pstruClmInListChange->sInsrntCde      = [%s]\n",  pstruClmInListChange->sInsrntCde     );
	printf("pstruClmInListChange->sInsrncTgt      = [%s]\n",  pstruClmInListChange->sInsrncTgt     );
	printf("pstruClmInListChange->sRptNme         = [%s]\n",  pstruClmInListChange->sRptNme        );
	printf("pstruClmInListChange->sBigClm         = [%s]\n",  pstruClmInListChange->sBigClm        );
	printf("pstruClmInListChange->sRptAddrTel     = [%s]\n",  pstruClmInListChange->sRptAddrTel    );
	printf("pstruClmInListChange->sRptTm          = [%s]\n",  pstruClmInListChange->sRptTm         );
	printf("pstruClmInListChange->sAccdntTm       = [%s]\n",  pstruClmInListChange->sAccdntTm      );
	printf("pstruClmInListChange->sAccdntSpot     = [%s]\n",  pstruClmInListChange->sAccdntSpot    );
	printf("pstruClmInListChange->sAccdntCaus     = [%s]\n",  pstruClmInListChange->sAccdntCaus    );
	printf("pstruClmInListChange->sLosDtl         = [%s]\n",  pstruClmInListChange->sLosDtl        );
	printf("pstruClmInListChange->sCurTyp         = [%s]\n",  pstruClmInListChange->sCurTyp        );
	printf("pstruClmInListChange->dRptAmt		  = [%f]\n",  pstruClmInListChange->dRptAmt        );
	printf("pstruClmInListChange->sInsrncCde      = [%s]\n",  pstruClmInListChange->sInsrncCde     );
	printf("pstruClmInListChange->sRcvrCde        = [%s]\n",  pstruClmInListChange->sRcvrCde       );
	printf("pstruClmInListChange->sOpinion        = [%s]\n",  pstruClmInListChange->sOpinion       );
	printf("pstruClmInListChange->sRemark         = [%s]\n",  pstruClmInListChange->sRemark        );
	printf("pstruClmInListChange->sTgtLosDtl      = [%s]\n",  pstruClmInListChange->sTgtLosDtl     );
	printf("pstruClmInListChange->sHlpLos         = [%s]\n",  pstruClmInListChange->sHlpLos        );
	printf("pstruClmInListChange->sThdLos         = [%s]\n",  pstruClmInListChange->sThdLos        );
	printf("pstruClmInListChange->sClmPrcsDtl     = [%s]\n",  pstruClmInListChange->sClmPrcsDtl    );
	printf("pstruClmInListChange->sSrsCaseOpinion = [%s]\n",  pstruClmInListChange->sSrsCaseOpinion);
	printf("pstruClmInListChange->sDptCde         = [%s]\n",  pstruClmInListChange->sDptCde        );
	printf("pstruClmInListChange->sRptRgstMdfyTm  = [%s]\n",  pstruClmInListChange->sRptRgstMdfyTm );
	printf("pstruClmInListChange->sPrcsDptCde     = [%s]\n",  pstruClmInListChange->sPrcsDptCde    );
	printf("pstruClmInListChange->sRptRgstCde     = [%s]\n",  pstruClmInListChange->sRptRgstCde    );
	printf("pstruClmInListChange->sInsrncBgnTm    = [%s]\n",  pstruClmInListChange->sInsrncBgnTm   );
	printf("pstruClmInListChange->sInsrncEndTm    = [%s]\n",  pstruClmInListChange->sInsrncEndTm   );
	printf("pstruClmInListChange->dTgtAmt         = [%f]\n",  pstruClmInListChange->dTgtAmt        );
	printf("pstruClmInListChange->sInsCurTyp      = [%s]\n",  pstruClmInListChange->sInsCurTyp     );
	printf("pstruClmInListChange->sCarNo          = [%s]\n",  pstruClmInListChange->sCarNo         );
	printf("pstruClmInListChange->sLcnNo          = [%s]\n",  pstruClmInListChange->sLcnNo         );
	printf("pstruClmInListChange->sBrndCde        = [%s]\n",  pstruClmInListChange->sBrndCde       );
	printf("pstruClmInListChange->sEngNo          = [%s]\n",  pstruClmInListChange->sEngNo         );
	printf("pstruClmInListChange->sAccdntDtl      = [%s]\n",  pstruClmInListChange->sAccdntDtl     );
	printf("pstruClmInListChange->sRptPrcsMrk     = [%s]\n",  pstruClmInListChange->sRptPrcsMrk    );
	printf("pstruClmInListChange->sBrndCnm        = [%s]\n",  pstruClmInListChange->sBrndCnm       );
	printf("pstruClmInListChange->sInternetTyp    = [%s]\n\n",  pstruClmInListChange->sInternetTyp   );

	return ;

}





void StruClmInListChangeToStr(clmInListChangeStru *pstruClmInListChange, char** ppstring, int *plenStr)
{
	StrToStr(pstruClmInListChange->sPlcyNo         , ppstring,  plenStr);
	StrToStr(pstruClmInListChange->sRptNo          , ppstring,  plenStr);
	StrToStr(pstruClmInListChange->sClmNo          , ppstring,  plenStr);
	StrToStr(pstruClmInListChange->sInsrntName     , ppstring,  plenStr);
	StrToStr(pstruClmInListChange->sInsrntCde      , ppstring,  plenStr);
	StrToStr(pstruClmInListChange->sInsrncTgt      , ppstring,  plenStr);
	StrToStr(pstruClmInListChange->sRptNme         , ppstring,  plenStr);
	StrToStr(pstruClmInListChange->sBigClm         , ppstring,  plenStr);
	StrToStr(pstruClmInListChange->sRptAddrTel     , ppstring,  plenStr);
	StrToStr(pstruClmInListChange->sRptTm          , ppstring,  plenStr);
	StrToStr(pstruClmInListChange->sAccdntTm       , ppstring,  plenStr);
	StrToStr(pstruClmInListChange->sAccdntSpot     , ppstring,  plenStr);
	StrToStr(pstruClmInListChange->sAccdntCaus     , ppstring,  plenStr);
	StrToStr(pstruClmInListChange->sLosDtl         , ppstring,  plenStr);
	StrToStr(pstruClmInListChange->sCurTyp         , ppstring,  plenStr);
	DoubleToStr(pstruClmInListChange->dRptAmt      , ppstring,  plenStr);
	StrToStr(pstruClmInListChange->sInsrncCde      , ppstring,  plenStr);
	StrToStr(pstruClmInListChange->sRcvrCde        , ppstring,  plenStr);
	StrToStr(pstruClmInListChange->sOpinion        , ppstring,  plenStr);
	StrToStr(pstruClmInListChange->sRemark         , ppstring,  plenStr);
	StrToStr(pstruClmInListChange->sTgtLosDtl      , ppstring,  plenStr);
	StrToStr(pstruClmInListChange->sHlpLos         , ppstring,  plenStr);
	StrToStr(pstruClmInListChange->sThdLos         , ppstring,  plenStr);
	StrToStr(pstruClmInListChange->sClmPrcsDtl     , ppstring,  plenStr);
	StrToStr(pstruClmInListChange->sSrsCaseOpinion , ppstring,  plenStr);
	StrToStr(pstruClmInListChange->sDptCde         , ppstring,  plenStr);
	StrToStr(pstruClmInListChange->sRptRgstMdfyTm  , ppstring,  plenStr);
	StrToStr(pstruClmInListChange->sPrcsDptCde     , ppstring,  plenStr);
	StrToStr(pstruClmInListChange->sRptRgstCde     , ppstring,  plenStr);
	StrToStr(pstruClmInListChange->sInsrncBgnTm    , ppstring,  plenStr);
	StrToStr(pstruClmInListChange->sInsrncEndTm    , ppstring,  plenStr);
	DoubleToStr(pstruClmInListChange->dTgtAmt      , ppstring,  plenStr);
	StrToStr(pstruClmInListChange->sInsCurTyp      , ppstring,  plenStr);
	StrToStr(pstruClmInListChange->sCarNo          , ppstring,  plenStr);
	StrToStr(pstruClmInListChange->sLcnNo          , ppstring,  plenStr);
	StrToStr(pstruClmInListChange->sBrndCde        , ppstring,  plenStr);
	StrToStr(pstruClmInListChange->sEngNo          , ppstring,  plenStr);
	StrToStr(pstruClmInListChange->sAccdntDtl      , ppstring,  plenStr);
	StrToStr(pstruClmInListChange->sRptPrcsMrk     , ppstring,  plenStr);
	StrToStr(pstruClmInListChange->sBrndCnm        , ppstring,  plenStr);
	StrToStr(pstruClmInListChange->sInternetTyp    , ppstring,  plenStr);

	return ;
}





void struClmInListChangeOrderConvt(char *pBuff)
{
	clmInListChangeStru struClmInListChange;
	memcpy(&struClmInListChange, pBuff, sizeof(clmInListChangeStru));
	struClmInListChange.dRptAmt = AIcom_ConvertDouble1(struClmInListChange.dRptAmt);
	struClmInListChange.dTgtAmt = AIcom_ConvertDouble1(struClmInListChange.dTgtAmt);
	memcpy(pBuff, &struClmInListChange, sizeof(clmInListChangeStru));
	return ;
}










