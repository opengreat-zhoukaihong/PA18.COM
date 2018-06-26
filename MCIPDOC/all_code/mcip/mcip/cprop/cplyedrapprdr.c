#include "typeconvt.h"
#include "AiConvert.h"
#include "cplyedrapprdr.h"




int StrToStruPlyEdrapprdr(char** ppstring, int *plenStr, plyEdrapprdrStru *pstruPlyEdrapprdr)
{
	int i, j;
	if(*ppstring==NULL) return 1;

	i=j=0;
	do
	{
		j++; if(ToStringField(ppstring, plenStr, (pstruPlyEdrapprdr->sCrtCde     ), C_CRT_CDE_LEN   )==FALSE) break;    else i++;
		j++; if(ToStringField(ppstring, plenStr, (pstruPlyEdrapprdr->sCrtTm      ), TIME_LEN        )==FALSE) break;    else i++;
		j++; if(ToStringField(ppstring, plenStr, (pstruPlyEdrapprdr->sUpdCde     ), C_UPD_CDE_LEN   )==FALSE) break;    else i++;
		j++; if(ToStringField(ppstring, plenStr, (pstruPlyEdrapprdr->sUpdTm      ), TIME_LEN        )==FALSE) break;    else i++;
		j++; if(ToStringField(ppstring, plenStr, (pstruPlyEdrapprdr->sEdrAppNo   ), C_EDR_APP_NO_LEN)==FALSE) break;    else i++;
		j++; if(ToStringField(ppstring, plenStr, (pstruPlyEdrapprdr->sRdrCde     ), C_RDR_CDE_LEN   )==FALSE) break;    else i++;
		j++; if(ToStringField(ppstring, plenStr, (pstruPlyEdrapprdr->sRdrNme     ), C_RDR_NME_LEN   )==FALSE) break;    else i++;
		j++; if(ToDoubleField(ppstring, plenStr, &(pstruPlyEdrapprdr->fRdrAmt	))==FALSE) break;    else i++;
		j++; if(ToDoubleField(ppstring, plenStr, &(pstruPlyEdrapprdr->fRdrPerAmt	))==FALSE) break;    else i++; 
		j++; if(ToDoubleField(ppstring, plenStr, &(pstruPlyEdrapprdr->fRate       ))==FALSE) break;    else i++;
		j++; if(ToDoubleField(ppstring, plenStr, &(pstruPlyEdrapprdr->fRdrPrm	))==FALSE) break;    else i++;  
		j++; if(ToStringField(ppstring, plenStr, (pstruPlyEdrapprdr->sDesc       ), C_DESC_LEN      )==FALSE) break;    else i++;
		j++; if(ToStringField(ppstring, plenStr, (pstruPlyEdrapprdr->sNclmDesc   ), C_NCLM_DESC_LEN )==FALSE) break;    else i++;
		j++; if(ToStringField(ppstring, plenStr, (pstruPlyEdrapprdr->sDelMrk     ), C_DEL_MRK_LEN   )==FALSE) break;    else i++;
		j++; if(ToStringField(ppstring, plenStr, (pstruPlyEdrapprdr->sRecNo      ), C_REC_NO_LEN    )==FALSE) break;    else i++;
		j++; if(ToStringField(ppstring, plenStr, (pstruPlyEdrapprdr->sObjNo      ), C_OBJ_NO_LEN    )==FALSE) break;    else i++;
		j++; if(ToDoubleField(ppstring, plenStr, &(pstruPlyEdrapprdr->fSeatdayNum ))==FALSE) break;    else i++;
		j++; if(ToDoubleField(ppstring, plenStr, &(pstruPlyEdrapprdr->fRdrPrmVar  ))==FALSE) break;    else i++;
		j++; if(ToDoubleField(ppstring, plenStr, &(pstruPlyEdrapprdr->fRdrDis     ))==FALSE) break;    else i++;
		j++; if(ToDoubleField(ppstring, plenStr, &(pstruPlyEdrapprdr->fRdrNclm    ))==FALSE) break;    else i++;
		j++; if(ToDoubleField(ppstring, plenStr, &(pstruPlyEdrapprdr->fRdrDisAmt  ))==FALSE) break;    else i++;
		j++; if(ToDoubleField(ppstring, plenStr, &(pstruPlyEdrapprdr->fRdrNclmAmt ))==FALSE) break;    else i++;
		j++; if(ToDoubleField(ppstring, plenStr, &(pstruPlyEdrapprdr->fRdrdisPrm	))==FALSE) break;    else i++;
		j++; if(ToDoubleField(ppstring, plenStr, &(pstruPlyEdrapprdr->fRdrnclmProp))==FALSE) break;    else i++;
	}while(0);
	if(j!=i) 
	{	
		#ifdef _DEBUG
		printf("StrToStruPlyEdrapprdr failed: Field index = %d\n", j);
		#endif
		return 0-i;
	}
	return 0;
}

void StruPlyEdrapprdrToStr(plyEdrapprdrStru *pstruPlyEdrapprdr, char** ppstring, int *plenStr)
{

	printf("before rdr-----\n");
	PrintStruPlyEdrapprdr(pstruPlyEdrapprdr);
	StrToStr(pstruPlyEdrapprdr->sCrtCde     , ppstring,  plenStr); 
	StrToStr(pstruPlyEdrapprdr->sCrtTm      , ppstring,  plenStr); 
	StrToStr(pstruPlyEdrapprdr->sUpdCde     , ppstring,  plenStr); 
	StrToStr(pstruPlyEdrapprdr->sUpdTm      , ppstring,  plenStr); 
	StrToStr(pstruPlyEdrapprdr->sEdrAppNo   , ppstring,  plenStr); 
	StrToStr(pstruPlyEdrapprdr->sRdrCde     , ppstring,  plenStr); 
	StrToStr(pstruPlyEdrapprdr->sRdrNme     , ppstring,  plenStr); 
	DoubleToStr(pstruPlyEdrapprdr->fRdrAmt	, ppstring,  plenStr); 
	DoubleToStr(pstruPlyEdrapprdr->fRdrPerAmt	, ppstring,  plenStr);  
	DoubleToStr(pstruPlyEdrapprdr->fRate       , ppstring,  plenStr); 
	DoubleToStr(pstruPlyEdrapprdr->fRdrPrm	, ppstring,  plenStr);   
	StrToStr(pstruPlyEdrapprdr->sDesc       , ppstring,  plenStr); 
	StrToStr(pstruPlyEdrapprdr->sNclmDesc   , ppstring,  plenStr); 
	StrToStr(pstruPlyEdrapprdr->sDelMrk     , ppstring,  plenStr); 
	StrToStr(pstruPlyEdrapprdr->sRecNo      , ppstring,  plenStr); 
	StrToStr(pstruPlyEdrapprdr->sObjNo      , ppstring,  plenStr); 
	DoubleToStr(pstruPlyEdrapprdr->fSeatdayNum , ppstring,  plenStr); 
	DoubleToStr(pstruPlyEdrapprdr->fRdrPrmVar  , ppstring,  plenStr); 
	DoubleToStr(pstruPlyEdrapprdr->fRdrDis     , ppstring,  plenStr); 
	DoubleToStr(pstruPlyEdrapprdr->fRdrNclm    , ppstring,  plenStr); 
	DoubleToStr(pstruPlyEdrapprdr->fRdrDisAmt  , ppstring,  plenStr); 
	DoubleToStr(pstruPlyEdrapprdr->fRdrNclmAmt , ppstring,  plenStr); 
	DoubleToStr(pstruPlyEdrapprdr->fRdrdisPrm	, ppstring,  plenStr); 
	DoubleToStr(pstruPlyEdrapprdr->fRdrnclmProp, ppstring,  plenStr); 
	return ;
}




void PrintStruPlyEdrapprdr(const plyEdrapprdrStru *pstruPlyEdrapprdr)
{
	printf("pstruPlyEdrapprdr->sCrtCde     =[%s]\n", pstruPlyEdrapprdr->sCrtCde     );                                                                            
	printf("pstruPlyEdrapprdr->sCrtTm      =[%s]\n", pstruPlyEdrapprdr->sCrtTm      );                                                                            
	printf("pstruPlyEdrapprdr->sUpdCde     =[%s]\n", pstruPlyEdrapprdr->sUpdCde     );                                                                            
	printf("pstruPlyEdrapprdr->sUpdTm      =[%s]\n", pstruPlyEdrapprdr->sUpdTm      );                                                                            
	printf("pstruPlyEdrapprdr->sEdrAppNo   =[%s]\n", pstruPlyEdrapprdr->sEdrAppNo   );                                                                            
	printf("pstruPlyEdrapprdr->sRdrCde     =[%s]\n", pstruPlyEdrapprdr->sRdrCde     );                                                                            
	printf("pstruPlyEdrapprdr->sRdrNme     =[%s]\n", pstruPlyEdrapprdr->sRdrNme     );                                                                            
	printf("pstruPlyEdrapprdr->fRdrAmt	   =[%f]\n", pstruPlyEdrapprdr->fRdrAmt	);                                                                            
	printf("pstruPlyEdrapprdr->fRdrPerAmt  =[%f]\n", pstruPlyEdrapprdr->fRdrPerAmt	);                                                                             
	printf("pstruPlyEdrapprdr->fRate       =[%f]\n", pstruPlyEdrapprdr->fRate       );                                                                            
	printf("pstruPlyEdrapprdr->fRdrPrm	   =[%f]\n", pstruPlyEdrapprdr->fRdrPrm	);                                                                              
	printf("pstruPlyEdrapprdr->sDesc       =[%s]\n", pstruPlyEdrapprdr->sDesc       );                                                                            
	printf("pstruPlyEdrapprdr->sNclmDesc   =[%s]\n", pstruPlyEdrapprdr->sNclmDesc   );                                                                            
	printf("pstruPlyEdrapprdr->sDelMrk     =[%s]\n", pstruPlyEdrapprdr->sDelMrk     );                                                                            
	printf("pstruPlyEdrapprdr->sRecNo      =[%s]\n", pstruPlyEdrapprdr->sRecNo      );                                                                            
	printf("pstruPlyEdrapprdr->sObjNo      =[%s]\n", pstruPlyEdrapprdr->sObjNo      );                                                                            
	printf("pstruPlyEdrapprdr->fSeatdayNum =[%f]\n", pstruPlyEdrapprdr->fSeatdayNum );                                                                            
	printf("pstruPlyEdrapprdr->fRdrPrmVar  =[%f]\n", pstruPlyEdrapprdr->fRdrPrmVar  );                                                                            
	printf("pstruPlyEdrapprdr->fRdrDis     =[%f]\n", pstruPlyEdrapprdr->fRdrDis     );                                                                            
	printf("pstruPlyEdrapprdr->fRdrNclm    =[%f]\n", pstruPlyEdrapprdr->fRdrNclm    );                                                                            
	printf("pstruPlyEdrapprdr->fRdrDisAmt  =[%f]\n", pstruPlyEdrapprdr->fRdrDisAmt  );                                                                            
	printf("pstruPlyEdrapprdr->fRdrNclmAmt =[%f]\n", pstruPlyEdrapprdr->fRdrNclmAmt );                                                                            
	printf("pstruPlyEdrapprdr->fRdrdisPrm  =[%f]\n", pstruPlyEdrapprdr->fRdrdisPrm	);                                                                            
	printf("pstruPlyEdrapprdr->fRdrnclmProp=[%f]\n\n", pstruPlyEdrapprdr->fRdrnclmProp);                                                                            
	return;
}


void struPlyEdrapprdrOrderConvt(char *pBuff)
{
	plyEdrapprdrStru struPlyEdrapprdr;
	memcpy(&struPlyEdrapprdr, pBuff, sizeof(plyEdrapprdrStru));

	struPlyEdrapprdr.fRdrAmt      = AIcom_ConvertDouble1(struPlyEdrapprdr.fRdrAmt     );
	struPlyEdrapprdr.fRdrPerAmt   = AIcom_ConvertDouble1(struPlyEdrapprdr.fRdrPerAmt  );
	struPlyEdrapprdr.fRate        = AIcom_ConvertDouble1(struPlyEdrapprdr.fRate       );
	struPlyEdrapprdr.fRdrPrm      = AIcom_ConvertDouble1(struPlyEdrapprdr.fRdrPrm     );
	struPlyEdrapprdr.fSeatdayNum  = AIcom_ConvertDouble1(struPlyEdrapprdr.fSeatdayNum );
	struPlyEdrapprdr.fRdrPrmVar   = AIcom_ConvertDouble1(struPlyEdrapprdr.fRdrPrmVar  );
	struPlyEdrapprdr.fRdrDis      = AIcom_ConvertDouble1(struPlyEdrapprdr.fRdrDis     );
	struPlyEdrapprdr.fRdrNclm     = AIcom_ConvertDouble1(struPlyEdrapprdr.fRdrNclm    );
	struPlyEdrapprdr.fRdrDisAmt   = AIcom_ConvertDouble1(struPlyEdrapprdr.fRdrDisAmt  );
	struPlyEdrapprdr.fRdrNclmAmt  = AIcom_ConvertDouble1(struPlyEdrapprdr.fRdrNclmAmt );
	struPlyEdrapprdr.fRdrdisPrm   = AIcom_ConvertDouble1(struPlyEdrapprdr.fRdrdisPrm  );
	struPlyEdrapprdr.fRdrnclmProp = AIcom_ConvertDouble1(struPlyEdrapprdr.fRdrnclmProp);

	memcpy(pBuff, &struPlyEdrapprdr, sizeof(plyEdrapprdrStru));
	return ;
}



  



       
     
 


