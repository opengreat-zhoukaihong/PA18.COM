#include "typeconvt.h"
#include "AiConvert.h"
#include "cplybodyinfo.h"

int StrToStruPlyPktBodyInfo(char** ppstring, int *plenStr, PktBodyInfoStru *pstruPktBodyInfo)
{
	int i, j, k;
	if(*ppstring==NULL) return 1;

	for(i=j=k=0; i<C_APP_KINDS_LEN; i++)
	{
		j++;    if(ToIntField(ppstring,  plenStr,  &(pstruPktBodyInfo->nPktNum[i]))==FALSE) break;    else k++;
	}
	if(j!=k) 
	{
		#ifdef _DEBUG
		printf("StrToStruPlyPktBodyInfo failed: Field index = %d\n", j);
		#endif
		return 0-j;
	}
	return 0;
}


void StruPlyPktBodyInfoToStr(PktBodyInfoStru *pstruPktBodyInfo, char** ppstring, int* plenStr)
{
	int i;
	for(i=0; i<C_APP_KINDS_LEN; i++)
	{
		IntToStr(pstruPktBodyInfo->nPktNum[i], ppstring, plenStr);
	}
	return ;
}


void PrintStruPlyPktBodyInfo(const PktBodyInfoStru *pstruPktBodyInfo)
{
	int i;
	for(i=1; i<C_APP_KINDS_LEN+1; i++)
	{
		printf("pstruPktBodyInfo->nPktNum[%d]=[%d]\n", i-1, pstruPktBodyInfo->nPktNum[i-1]);
	}
	printf("\n");
	return ;
}



void struPktBodyInfoOrderConvt(char *pBuff)
{
	PktBodyInfoStru struPktBodyInfo;
	int i;
	memcpy(&struPktBodyInfo, pBuff, sizeof(PktBodyInfoStru));

	for(i=0; i<C_APP_KINDS_LEN; i++)
	{
		struPktBodyInfo.nPktNum[i] = AIcom_ConvertInt1(struPktBodyInfo.nPktNum[i]);
	}
	memcpy(pBuff, &struPktBodyInfo, sizeof(PktBodyInfoStru));
	return ;
}
