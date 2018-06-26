#include "typeconvt.h"
#include "AiConvert.h"
#include "cplyrdr.h"







int StrToStruRdr(char** ppstring, int *plenStr, plyRdrStru *pstruRdr)
{
	int j, k;
	if(*ppstring==NULL) return 1;

	j=k=0;
	do
	{
		j++;    if(ToStringField(ppstring,  plenStr,  (pstruRdr->sCrtCde)     , C_CRT_CDE_LEN   )==FALSE) break;    else k++;
		j++;    if(ToStringField(ppstring,  plenStr,  (pstruRdr->sCrtTm)      , TIME_LEN        )==FALSE) break;    else k++;
		j++;    if(ToStringField(ppstring,  plenStr,  (pstruRdr->sUpdCde)     , C_UPD_CDE_LEN   )==FALSE) break;    else k++;
		j++;    if(ToStringField(ppstring,  plenStr,  (pstruRdr->sUpdTm)      , TIME_LEN        )==FALSE) break;    else k++;
		j++;    if(ToStringField(ppstring,  plenStr,  (pstruRdr->sCplyAppNo)  , C_PLY_APP_NO_LEN)==FALSE) break;    else k++;
		j++;    if(ToStringField(ppstring,  plenStr,  (pstruRdr->sRdrCde)     , C_RDR_CDE_LEN   )==FALSE) break;    else k++;
		j++;    if(ToStringField(ppstring,  plenStr,  (pstruRdr->sRdrNme)     , C_RDR_NME_LEN   )==FALSE) break;    else k++;
		j++;    if(ToDoubleField(ppstring,  plenStr, &(pstruRdr->fRdrAmt)     )==FALSE) break;    else k++;
		j++;    if(ToDoubleField(ppstring,  plenStr, &(pstruRdr->fRdrPerAmt)  )==FALSE) break;    else k++;
		j++;    if(ToDoubleField(ppstring,  plenStr, &(pstruRdr->fRate)       )==FALSE) break;    else k++;
		j++;    if(ToDoubleField(ppstring,  plenStr, &(pstruRdr->fRdrPrm)     )==FALSE) break;    else k++;
		j++;    if(ToStringField(ppstring,  plenStr,  (pstruRdr->sDesc)       , C_DESC_LEN      )==FALSE) break;    else k++;
		j++;    if(ToStringField(ppstring,  plenStr,  (pstruRdr->sNclmDesc)   , C_NCLM_DESC_LEN )==FALSE) break;    else k++;
		j++;    if(ToStringField(ppstring,  plenStr,  (pstruRdr->sDelMrk)     , C_DEL_MRK_LEN   )==FALSE) break;    else k++;
		j++;    if(ToStringField(ppstring,  plenStr,  (pstruRdr->sRecNo)      , C_REC_NO_LEN    )==FALSE) break;    else k++;
		j++;    if(ToStringField(ppstring,  plenStr,  (pstruRdr->sObjNo)      , C_OBJ_NO_LEN    )==FALSE) break;    else k++;
		j++;    if(ToDoubleField(ppstring,  plenStr, &(pstruRdr->fSeatdayNum) )==FALSE) break;    else k++;
		j++;    if(ToDoubleField(ppstring,  plenStr, &(pstruRdr->fRdrPrmVar)  )==FALSE) break;    else k++;
		j++;    if(ToDoubleField(ppstring,  plenStr, &(pstruRdr->fRdrDis)     )==FALSE) break;    else k++;
		j++;    if(ToDoubleField(ppstring,  plenStr, &(pstruRdr->fRdrNclm)    )==FALSE) break;    else k++;
		j++;    if(ToDoubleField(ppstring,  plenStr, &(pstruRdr->fRdrDisAmt)  )==FALSE) break;    else k++;
		j++;    if(ToDoubleField(ppstring,  plenStr, &(pstruRdr->fRdrNclmAmt) )==FALSE) break;    else k++;
		j++;    if(ToDoubleField(ppstring,  plenStr, &(pstruRdr->fRdrdisPrm)  )==FALSE) break;    else k++;
		j++;    if(ToDoubleField(ppstring,  plenStr, &(pstruRdr->fRdrnclmProp))==FALSE) break;    else k++;

	}while(0);
	if(j!=k) 
	{	
		#ifdef _DEBUG
		printf("StrToStruRdr failed: Field index = %d\n", j);
		#endif
		return 0-j;
	}
	return 0;
}











void PrintStruRdr(const plyRdrStru *pstruRdrTemp)
{
	printf("pstruRdrTemp->sCrtCde     = [%s]\n", pstruRdrTemp->sCrtCde);                      
	printf("pstruRdrTemp->sCrtTm      = [%s]\n", pstruRdrTemp->sCrtTm);                      
	printf("pstruRdrTemp->sUpdCde     = [%s]\n", pstruRdrTemp->sUpdCde);                      
	printf("pstruRdrTemp->sUpdTm      = [%s]\n", pstruRdrTemp->sUpdTm);                      
	printf("pstruRdrTemp->sCplyAppNo  = [%s]\n", pstruRdrTemp->sCplyAppNo);                      
	printf("pstruRdrTemp->sRdrCde     = [%s]\n", pstruRdrTemp->sRdrCde);                      
	printf("pstruRdrTemp->sRdrNme     = [%s]\n", pstruRdrTemp->sRdrNme);                      
	printf("pstruRdrTemp->fRdrAmt     = [%f]\n", pstruRdrTemp->fRdrAmt);                      
	printf("pstruRdrTemp->fRdrPerAmt  = [%f]\n", pstruRdrTemp->fRdrPerAmt);                      
	printf("pstruRdrTemp->fRate       = [%f]\n", pstruRdrTemp->fRate);                      
	printf("pstruRdrTemp->fRdrPrm     = [%f]\n", pstruRdrTemp->fRdrPrm);                      
	printf("pstruRdrTemp->sDesc       = [%s]\n", pstruRdrTemp->sDesc);                      
	printf("pstruRdrTemp->sNclmDesc   = [%s]\n", pstruRdrTemp->sNclmDesc);                      
	printf("pstruRdrTemp->sDelMrk     = [%s]\n", pstruRdrTemp->sDelMrk);                      
	printf("pstruRdrTemp->sRecNo      = [%s]\n", pstruRdrTemp->sRecNo);                      
	printf("pstruRdrTemp->sObjNo      = [%s]\n", pstruRdrTemp->sObjNo);                      
	printf("pstruRdrTemp->fSeatdayNum = [%f]\n", pstruRdrTemp->fSeatdayNum);                      
	printf("pstruRdrTemp->fRdrPrmVar  = [%f]\n", pstruRdrTemp->fRdrPrmVar);                      
	printf("pstruRdrTemp->fRdrDis     = [%f]\n", pstruRdrTemp->fRdrDis);                      
	printf("pstruRdrTemp->fRdrNclm    = [%f]\n", pstruRdrTemp->fRdrNclm);                      
	printf("pstruRdrTemp->fRdrDisAmt  = [%f]\n", pstruRdrTemp->fRdrDisAmt);                      
	printf("pstruRdrTemp->fRdrNclmAmt = [%f]\n", pstruRdrTemp->fRdrNclmAmt);                      
	printf("pstruRdrTemp->fRdrdisPrm  = [%f]\n", pstruRdrTemp->fRdrdisPrm);                      
	printf("pstruRdrTemp->fRdrnclmProp= [%f]\n\n", pstruRdrTemp->fRdrnclmProp);      
} 
 
 







void struRdrOrderConvt(char *pBuff)
{
	plyRdrStru struRdr;
	memcpy(&struRdr, pBuff, sizeof(plyRdrStru));

	struRdr.fRdrAmt        = AIcom_ConvertDouble1(struRdr.fRdrAmt);     
	struRdr.fRdrPerAmt     = AIcom_ConvertDouble1(struRdr.fRdrPerAmt);  
	struRdr.fRate          = AIcom_ConvertDouble1(struRdr.fRate);       
	struRdr.fRdrPrm        = AIcom_ConvertDouble1(struRdr.fRdrPrm);     
	struRdr.fSeatdayNum    = AIcom_ConvertDouble1(struRdr.fSeatdayNum); 
	struRdr.fRdrPrmVar     = AIcom_ConvertDouble1(struRdr.fRdrPrmVar);  
	struRdr.fRdrDis        = AIcom_ConvertDouble1(struRdr.fRdrDis);     
	struRdr.fRdrNclm       = AIcom_ConvertDouble1(struRdr.fRdrNclm);    
	struRdr.fRdrDisAmt     = AIcom_ConvertDouble1(struRdr.fRdrDisAmt);  
	struRdr.fRdrNclmAmt    = AIcom_ConvertDouble1(struRdr.fRdrNclmAmt); 
	struRdr.fRdrdisPrm     = AIcom_ConvertDouble1(struRdr.fRdrdisPrm);  
	struRdr.fRdrnclmProp   = AIcom_ConvertDouble1(struRdr.fRdrnclmProp);
	memcpy(pBuff, &struRdr, sizeof(plyRdrStru));
	return ;
}





