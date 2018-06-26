#include "typeconvt.h"
#include "AiConvert.h"
#include "cplygetdoc.h"



int StrToStruPlyGetDoc(char** ppstring, int *plenStr, plyGetDocStru *pstruPlyGetDoc)
{
	int i, j;
	if(*ppstring==NULL) return 1;

	i=j=0;
	do
	{
		j++; if(ToStringField(ppstring, plenStr, (pstruPlyGetDoc->sDocNo    ), C_DOC_NO_LEN     )==FALSE) break;    else i++;
		j++; if(ToStringField(ppstring, plenStr, (pstruPlyGetDoc->sInsrncCde), C_INSRNC_CDE_LEN )==FALSE) break;    else i++;
		j++; if(ToStringField(ppstring, plenStr, (pstruPlyGetDoc->sPrnTyp   ), C_PRN_TYP_LEN    )==FALSE) break;    else i++;
		j++; if(ToStringField(ppstring, plenStr, (pstruPlyGetDoc->sUndrTm   ), TIME_LEN         )==FALSE) break;    else i++;
	}while(0);
	if(j!=i) 
	{	
		#ifdef _DEBUG
		printf("StrToStruPlyGetDoc failed: Field index = %d\n", j);
		#endif
		return 0-i;
	}
	return 0;
}

void StruPlyGetDocToStr(plyGetDocStru *pstruPlyGetDoc, char** ppstring, int *plenStr)
{
	StrToStr(pstruPlyGetDoc->sDocNo    , ppstring,  plenStr); 
	StrToStr(pstruPlyGetDoc->sInsrncCde, ppstring,  plenStr); 
	StrToStr(pstruPlyGetDoc->sPrnTyp   , ppstring,  plenStr); 
	StrToStr(pstruPlyGetDoc->sUndrTm   , ppstring,  plenStr); 
	return ;
}




void PrintStruPlyGetDoc(const plyGetDocStru *pstruPlyGetDoc)
{
	printf("pstruPlyGetDoc->sDocNo    =[%s]\n", pstruPlyGetDoc->sDocNo    );                                                                            
	printf("pstruPlyGetDoc->sInsrncCde=[%s]\n", pstruPlyGetDoc->sInsrncCde);                                                                            
	printf("pstruPlyGetDoc->sPrnTyp   =[%s]\n", pstruPlyGetDoc->sPrnTyp   );                                                                            
	printf("pstruPlyGetDoc->sUndrTm   =[%s]\n\n", pstruPlyGetDoc->sUndrTm   );                                                                            
	return;
}


void struPlyGetDocOrderConvt(char *pBuff)
{
/*	plyGetDocStru struPlyGetDoc;
	memcpy(&struPlyGetDoc, pBuff, sizeof(plyGetDocStru));


	memcpy(pBuff, &struPlyGetDoc, sizeof(plyGetDocStru));
*/	return ;
}

