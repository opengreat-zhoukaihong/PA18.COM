#include "typeconvt.h"
#include "AiConvert.h"

#include "cperclnt.h"


int StrToStruCltPerClntInfo(char** ppstring, int *plenStr, cltPerClntInfoStru *pstruCltPerClntInfo)
{
	int i, j;
	if(*ppstring==NULL) return 1;

	i=j=0;
	do
	{
		j++; if(ToStringField(ppstring, plenStr, pstruCltPerClntInfo->sClntCde     , C_CLNT_CDE_LEN     )==FALSE) break;    else i++;
		j++; if(ToStringField(ppstring, plenStr, pstruCltPerClntInfo->sDptCde      , C_DPT_CDE_LEN      )==FALSE) break;    else i++;
		j++; if(ToStringField(ppstring, plenStr, pstruCltPerClntInfo->sClntNme     , C_CLNT_NME_LEN     )==FALSE) break;    else i++;
		j++; if(ToStringField(ppstring, plenStr, pstruCltPerClntInfo->sChnAbr      , C_CHN_ABR_LEN      )==FALSE) break;    else i++;
		j++; if(ToStringField(ppstring, plenStr, pstruCltPerClntInfo->sAuthMrk     , C_AUTH_MRK_LEN     )==FALSE) break;    else i++;
		j++; if(ToStringField(ppstring, plenStr, pstruCltPerClntInfo->sBrdEnm      , C_BRD_ENM_LEN      )==FALSE) break;    else i++;
		j++; if(ToStringField(ppstring, plenStr, pstruCltPerClntInfo->sRgstNo      , C_RGST_NO_LEN      )==FALSE) break;    else i++;
		j++; if(ToStringField(ppstring, plenStr, pstruCltPerClntInfo->sSex         , C_SEX_LEN          )==FALSE) break;    else i++;
		j++; if(ToStringField(ppstring, plenStr, pstruCltPerClntInfo->sHmtwn       , C_HMTWN_LEN        )==FALSE) break;    else i++; 
		j++; if(ToStringField(ppstring, plenStr, pstruCltPerClntInfo->sNtnCde      , C_NTN_CDE_LEN      )==FALSE) break;    else i++;
		j++; if(ToStringField(ppstring, plenStr, pstruCltPerClntInfo->sBirthday    , DATE_LEN           )==FALSE) break;    else i++;  
		j++; if(ToStringField(ppstring, plenStr, pstruCltPerClntInfo->sMrgCde      , C_MRG_CDE_LEN      )==FALSE) break;    else i++;
		j++; if(ToStringField(ppstring, plenStr, pstruCltPerClntInfo->sGrdt        , C_GRDT_LEN         )==FALSE) break;    else i++;
		j++; if(ToStringField(ppstring, plenStr, pstruCltPerClntInfo->sEduCde      , C_EDU_CDE_LEN      )==FALSE) break;    else i++;
		j++; if(ToStringField(ppstring, plenStr, pstruCltPerClntInfo->sMajorCde    , C_MAJOR_CDE_LEN    )==FALSE) break;    else i++;
		j++; if(ToStringField(ppstring, plenStr, pstruCltPerClntInfo->sTitlCde     , C_TITLE_CDE_LEN    )==FALSE) break;    else i++;
		j++; if(ToStringField(ppstring, plenStr, pstruCltPerClntInfo->sDuty        , C_DUTY_LEN         )==FALSE) break;    else i++;
		j++; if(ToStringField(ppstring, plenStr, pstruCltPerClntInfo->sTel         , C_TEL_LEN          )==FALSE) break;    else i++;
		j++; if(ToStringField(ppstring, plenStr, pstruCltPerClntInfo->sFax         , C_FAX_LEN          )==FALSE) break;    else i++;
		j++; if(ToStringField(ppstring, plenStr, pstruCltPerClntInfo->sEmail       , C_EMAIL_LEN        )==FALSE) break;    else i++;
		j++; if(ToStringField(ppstring, plenStr, pstruCltPerClntInfo->sClntAddr    , C_CLNT_ADDR_LEN    )==FALSE) break;    else i++;
		j++; if(ToStringField(ppstring, plenStr, pstruCltPerClntInfo->sZipCde      , C_ZIP_CDE_LEN      )==FALSE) break;    else i++;
		j++; if(ToStringField(ppstring, plenStr, pstruCltPerClntInfo->sRemark      , C_REMARK_LEN       )==FALSE) break;    else i++;
		j++; if(ToStringField(ppstring, plenStr, pstruCltPerClntInfo->sClntMrk     , C_CLNT_MRK_LEN     )==FALSE) break;    else i++;
		j++; if(ToStringField(ppstring, plenStr, pstruCltPerClntInfo->sEmpCde      , C_EMP_CDE_LEN      )==FALSE) break;    else i++;
		j++; if(ToStringField(ppstring, plenStr, pstruCltPerClntInfo->sImptClntCde , C_IMPT_CLNT_CDE_LEN)==FALSE) break;    else i++;
		j++; if(ToStringField(ppstring, plenStr, pstruCltPerClntInfo->sUpdTm       , TIME_LEN           )==FALSE) break;    else i++;
		j++; if(ToStringField(ppstring, plenStr, pstruCltPerClntInfo->sProvince    , C_PROVINCE_LEN     )==FALSE) break;    else i++;
		j++; if(ToStringField(ppstring, plenStr, pstruCltPerClntInfo->sCity        , C_CITY_LEN         )==FALSE) break;    else i++;
		j++; if(ToStringField(ppstring, plenStr, pstruCltPerClntInfo->sPlace       , C_PLACE_LEN        )==FALSE) break;    else i++;
	}while(0);
	if(j!=i) 
	{	
		#ifdef _DEBUG
		printf("StrToStruCltPerClntInfo failed: Field index = %d\n", j);
		#endif
		return 0-j;
	}
	return 0;
}


void StruCltPerClntInfoToStr(cltPerClntInfoStru *pstruCltPerClntInfo, char** ppstring, int *plenStr)
{
	StrToStr(pstruCltPerClntInfo->sClntCde    , ppstring,  plenStr);
	StrToStr(pstruCltPerClntInfo->sDptCde     , ppstring,  plenStr);
	StrToStr(pstruCltPerClntInfo->sClntNme    , ppstring,  plenStr);
	StrToStr(pstruCltPerClntInfo->sChnAbr     , ppstring,  plenStr);
	StrToStr(pstruCltPerClntInfo->sAuthMrk    , ppstring,  plenStr);
	StrToStr(pstruCltPerClntInfo->sBrdEnm     , ppstring,  plenStr);
	StrToStr(pstruCltPerClntInfo->sRgstNo     , ppstring,  plenStr);
	StrToStr(pstruCltPerClntInfo->sSex        , ppstring,  plenStr);
	StrToStr(pstruCltPerClntInfo->sHmtwn      , ppstring,  plenStr);
	StrToStr(pstruCltPerClntInfo->sNtnCde     , ppstring,  plenStr);
	StrToStr(pstruCltPerClntInfo->sBirthday   , ppstring,  plenStr);
	StrToStr(pstruCltPerClntInfo->sMrgCde     , ppstring,  plenStr);
	StrToStr(pstruCltPerClntInfo->sGrdt       , ppstring,  plenStr);
	StrToStr(pstruCltPerClntInfo->sEduCde     , ppstring,  plenStr);                      
	StrToStr(pstruCltPerClntInfo->sMajorCde   , ppstring,  plenStr);                    
	StrToStr(pstruCltPerClntInfo->sTitlCde    , ppstring,  plenStr);                     
	StrToStr(pstruCltPerClntInfo->sDuty       , ppstring,  plenStr); 
	StrToStr(pstruCltPerClntInfo->sTel        , ppstring,  plenStr);  
	StrToStr(pstruCltPerClntInfo->sFax        , ppstring,  plenStr);  
	StrToStr(pstruCltPerClntInfo->sEmail      , ppstring,  plenStr);                       
	StrToStr(pstruCltPerClntInfo->sClntAddr   , ppstring,  plenStr); 
	StrToStr(pstruCltPerClntInfo->sZipCde     , ppstring,  plenStr);                      
	StrToStr(pstruCltPerClntInfo->sRemark     , ppstring,  plenStr);                      
	StrToStr(pstruCltPerClntInfo->sClntMrk    , ppstring,  plenStr);                     
	StrToStr(pstruCltPerClntInfo->sEmpCde     , ppstring,  plenStr);                      
	StrToStr(pstruCltPerClntInfo->sImptClntCde, ppstring,  plenStr); 
	StrToStr(pstruCltPerClntInfo->sUpdTm      , ppstring,  plenStr);    
	StrToStr(pstruCltPerClntInfo->sProvince   , ppstring,  plenStr); 
	StrToStr(pstruCltPerClntInfo->sCity       , ppstring,  plenStr); 
	StrToStr(pstruCltPerClntInfo->sPlace      , ppstring,  plenStr);    

	return ;
}





void PrintStruCltPerClntInfo(const cltPerClntInfoStru *pstruCltPerClntInfo)
{
	printf("pstruCltPerClntInfo->sClntCde    = [%s]\n", pstruCltPerClntInfo->sClntCde    );                                                                               
	printf("pstruCltPerClntInfo->sDptCde     = [%s]\n", pstruCltPerClntInfo->sDptCde     );                                                                               
	printf("pstruCltPerClntInfo->sClntNme    = [%s]\n", pstruCltPerClntInfo->sClntNme    );                                                                               
	printf("pstruCltPerClntInfo->sChnAbr     = [%s]\n", pstruCltPerClntInfo->sChnAbr     );                                                                               
	printf("pstruCltPerClntInfo->sAuthMrk    = [%s]\n", pstruCltPerClntInfo->sAuthMrk    );                                                                               
	printf("pstruCltPerClntInfo->sBrdEnm     = [%s]\n", pstruCltPerClntInfo->sBrdEnm     );                                                                               
	printf("pstruCltPerClntInfo->sRgstNo     = [%s]\n", pstruCltPerClntInfo->sRgstNo     );                                                                               
	printf("pstruCltPerClntInfo->sSex        = [%s]\n", pstruCltPerClntInfo->sSex        );                                                                               
	printf("pstruCltPerClntInfo->sHmtwn      = [%s]\n", pstruCltPerClntInfo->sHmtwn      );                                                                               
	printf("pstruCltPerClntInfo->sNtnCde     = [%s]\n", pstruCltPerClntInfo->sNtnCde     );                                                                               
	printf("pstruCltPerClntInfo->sBirthday   = [%s]\n", pstruCltPerClntInfo->sBirthday   );                                                                               
	printf("pstruCltPerClntInfo->sMrgCde     = [%s]\n", pstruCltPerClntInfo->sMrgCde     );                                                                               
	printf("pstruCltPerClntInfo->sGrdt       = [%s]\n", pstruCltPerClntInfo->sGrdt       );                                                                               
	printf("pstruCltPerClntInfo->sEduCde     = [%s]\n", pstruCltPerClntInfo->sEduCde     );                                                                                                     
	printf("pstruCltPerClntInfo->sMajorCde   = [%s]\n", pstruCltPerClntInfo->sMajorCde   );                                                                                                   
	printf("pstruCltPerClntInfo->sTitlCde    = [%s]\n", pstruCltPerClntInfo->sTitlCde    );                                                                                                    
	printf("pstruCltPerClntInfo->sDuty       = [%s]\n", pstruCltPerClntInfo->sDuty       );                                                                                
	printf("pstruCltPerClntInfo->sTel        = [%s]\n", pstruCltPerClntInfo->sTel        );                                                                                 
	printf("pstruCltPerClntInfo->sFax        = [%s]\n", pstruCltPerClntInfo->sFax        );                                                                                 
	printf("pstruCltPerClntInfo->sEmail      = [%s]\n", pstruCltPerClntInfo->sEmail      );                                                                                                      
	printf("pstruCltPerClntInfo->sClntAddr   = [%s]\n", pstruCltPerClntInfo->sClntAddr   );                                                                                
	printf("pstruCltPerClntInfo->sZipCde     = [%s]\n", pstruCltPerClntInfo->sZipCde     );                                                                                                     
	printf("pstruCltPerClntInfo->sRemark     = [%s]\n", pstruCltPerClntInfo->sRemark     );                                                                                                     
	printf("pstruCltPerClntInfo->sClntMrk    = [%s]\n", pstruCltPerClntInfo->sClntMrk    );                                                                                                    
	printf("pstruCltPerClntInfo->sEmpCde     = [%s]\n", pstruCltPerClntInfo->sEmpCde     );                                                                                                     
	printf("pstruCltPerClntInfo->sImptClntCde= [%s]\n", pstruCltPerClntInfo->sImptClntCde);                                                                               
	printf("pstruCltPerClntInfo->sUpdTm      = [%s]\n", pstruCltPerClntInfo->sUpdTm      );                                                                                   
	printf("pstruCltPerClntInfo->sProvince   = [%s]\n", pstruCltPerClntInfo->sProvince   );                                                                                
	printf("pstruCltPerClntInfo->sCity       = [%s]\n", pstruCltPerClntInfo->sCity       );                                                                                
	printf("pstruCltPerClntInfo->sPlace      = [%s]\n\n", pstruCltPerClntInfo->sPlace      );                                                                                   
}




void struCltPerClntInfoOrderConvt(char *pBuff)
{
/*	cltPerClntInfoStru struCltPerClntInfo;
	memcpy(&struCltPerClntInfo, pBuff, sizeof(cltPerClntInfoStru));


	memcpy(pBuff, &struCltPerClntInfo, sizeof(cltPerClntInfoStru));
*/
	return ;
}



