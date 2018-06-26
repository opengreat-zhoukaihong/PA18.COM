#include "typeconvt.h"
#include "AiConvert.h"
#include "cclmplcyno.h"




int StrToStruClmPlcyNo(char** ppstring, int *plenStr, clmPlcyNoStru *pstruClmPlcyNo)
{
	int i, j;
	if(*ppstring==NULL) return 1;

	i=j=0;
	do
	{
		j++;    if(ToStringField(ppstring,  plenStr, (pstruClmPlcyNo->sRptNo         ), C_RPT_NO_LEN    )==FALSE) break;    else i++;
		j++;    if(ToStringField(ppstring,  plenStr, (pstruClmPlcyNo->sPlcyNo        ), C_PLY_NO_LEN    )==FALSE) break;    else i++;
		j++;    if(ToStringField(ppstring,  plenStr, (pstruClmPlcyNo->sDptCde        ), C_DPT_CDE_LEN   )==FALSE) break;    else i++;
		j++;    if(ToStringField(ppstring,  plenStr, (pstruClmPlcyNo->sAccdntTime    ), TIME_LEN        )==FALSE) break;    else i++;
		j++;    if(ToStringField(ppstring,  plenStr, (pstruClmPlcyNo->sLcnNo         ), C_LCN_NO_LEN    )==FALSE) break;    else i++;
		j++;    if(ToStringField(ppstring,  plenStr, (pstruClmPlcyNo->sEgnNo         ), C_ENG_NO_LEN    )==FALSE) break;    else i++;
		j++;    if(ToStringField(ppstring,  plenStr, (pstruClmPlcyNo->sInsrntName    ), C_INSRNT_NME_LEN)==FALSE) break;    else i++;
		j++;    if(ToStringField(ppstring,  plenStr, (pstruClmPlcyNo->sCarNo         ), C_CAR_NO_LEN    )==FALSE) break;    else i++;
		j++;    if(ToStringField(ppstring,  plenStr, (pstruClmPlcyNo->sRptRgstMdfyTm ), TIME_LEN        )==FALSE) break;    else i++;
		j++;    if(ToCharField(ppstring,	plenStr, &(pstruClmPlcyNo->cDelorClr     )                  )==FALSE) break;    else i++;
	}while(0);
	if(j!=i) 
	{	
		#ifdef _DEBUG
		printf("StrToStruClmPlcyNo failed: Field index = %d\n", j);
		#endif
		return 0-j;
	}
	return 0;
}


void PrintStruClmPlcyNo(const clmPlcyNoStru *pstruClmPlcyNo)
{
	printf("pstruClmPlcyNo->sRptNo        = [%s]\n",  pstruClmPlcyNo->sRptNo         );
	printf("pstruClmPlcyNo->sPlcyNo       = [%s]\n",  pstruClmPlcyNo->sPlcyNo        );
	printf("pstruClmPlcyNo->sDptCde       = [%s]\n",  pstruClmPlcyNo->sDptCde        );
	printf("pstruClmPlcyNo->sAccdntTime   = [%s]\n",  pstruClmPlcyNo->sAccdntTime    );
	printf("pstruClmPlcyNo->sLcnNo        = [%s]\n",  pstruClmPlcyNo->sLcnNo         );
	printf("pstruClmPlcyNo->sEgnNo        = [%s]\n",  pstruClmPlcyNo->sEgnNo         );
	printf("pstruClmPlcyNo->sInsrntName   = [%s]\n",  pstruClmPlcyNo->sInsrntName    );
	printf("pstruClmPlcyNo->sCarNo        = [%s]\n",  pstruClmPlcyNo->sCarNo         );
	printf("pstruClmPlcyNo->sRptRgstMdfyTm= [%s]\n",  pstruClmPlcyNo->sRptRgstMdfyTm );
	printf("pstruClmPlcyNo->cDelorClr     = [%c]\n\n",  pstruClmPlcyNo->cDelorClr     );

	return ;
}




void StruClmPlcyNoToStr(clmPlcyNoStru *pstruClmPlcyNo, char** ppstring, int *plenStr)
{
	StrToStr(pstruClmPlcyNo->sRptNo        , ppstring,  plenStr);
	StrToStr(pstruClmPlcyNo->sPlcyNo       , ppstring,  plenStr);
	StrToStr(pstruClmPlcyNo->sDptCde       , ppstring,  plenStr);
	StrToStr(pstruClmPlcyNo->sAccdntTime   , ppstring,  plenStr);
	StrToStr(pstruClmPlcyNo->sLcnNo        , ppstring,  plenStr);
	StrToStr(pstruClmPlcyNo->sEgnNo        , ppstring,  plenStr);
	StrToStr(pstruClmPlcyNo->sInsrntName   , ppstring,  plenStr);
	StrToStr(pstruClmPlcyNo->sCarNo        , ppstring,  plenStr);
	StrToStr(pstruClmPlcyNo->sRptRgstMdfyTm, ppstring,  plenStr);
	CharToStr(pstruClmPlcyNo->cDelorClr    , ppstring,  plenStr);

	return ;
}



void struClmPlcyNoOrderConvt(char *pBuff)
{
	return ;
}




