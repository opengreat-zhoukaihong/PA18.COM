#include "typeconvt.h"
#include "AiConvert.h"
#include "cplyappnet.h"


//char sSendFlag[C_SEND_FLAG_LEN];


int StrToStruPlyappNet(char** ppstring, int *plenStr, plyPlyappNetStru *pstruPlyappNet)
{
	int j, k;
	if(*ppstring==NULL) return 1;

	j=k=0;
	do
	{
		j++;    if(ToStringField(ppstring,  plenStr,  (pstruPlyappNet->sCrtCde       ), C_CRT_CDE_LEN      )==FALSE) break;    else k++;
		j++;    if(ToStringField(ppstring,  plenStr,  (pstruPlyappNet->sCrtTm        ), TIME_LEN           )==FALSE) break;    else k++;
		j++;    if(ToStringField(ppstring,  plenStr,  (pstruPlyappNet->sUpdCde       ), C_UPD_CDE_LEN      )==FALSE) break;    else k++;
		j++;    if(ToStringField(ppstring,  plenStr,  (pstruPlyappNet->sUpdTm        ), TIME_LEN           )==FALSE) break;    else k++;
		j++;    if(ToStringField(ppstring,  plenStr,  (pstruPlyappNet->sPlyAppNo     ), C_PLY_APP_NO_LEN   )==FALSE) break;    else k++;
		j++;    if(ToDoubleField(ppstring,  plenStr,  &(pstruPlyappNet->fUserSeqNo   )                     )==FALSE) break;    else k++;
		j++;    if(ToStringField(ppstring,  plenStr,  (pstruPlyappNet->sFeedbackTm   ), DATE_LEN           )==FALSE) break;    else k++;
		j++;    if(ToStringField(ppstring,  plenStr,  (pstruPlyappNet->sPrintTm      ), DATE_LEN           )==FALSE) break;    else k++;
		j++;    if(ToStringField(ppstring,  plenStr,  (pstruPlyappNet->sProvince     ), C_PROVINCE_LEN     )==FALSE) break;    else k++;
		j++;    if(ToStringField(ppstring,  plenStr,  (pstruPlyappNet->sCity         ), C_CITY_LEN         )==FALSE) break;    else k++;
		j++;    if(ToStringField(ppstring,  plenStr,  (pstruPlyappNet->sPlace        ), C_PLACE_LEN        )==FALSE) break;    else k++;
		j++;    if(ToStringField(ppstring,  plenStr,  (pstruPlyappNet->sContactName  ), C_CONTACT_NAME_LEN )==FALSE) break;    else k++;
		j++;    if(ToStringField(ppstring,  plenStr,  (pstruPlyappNet->sContactPhone ), C_CONTACT_PHONE_LEN)==FALSE) break;    else k++;
		j++;    if(ToStringField(ppstring,  plenStr,  (pstruPlyappNet->sContactFax   ), C_CONTACT_FAX_LEN  )==FALSE) break;    else k++;
		j++;    if(ToStringField(ppstring,  plenStr,  (pstruPlyappNet->sContactEmail ), C_CONTACT_EMAIL_LEN)==FALSE) break;    else k++;
		j++;    if(ToStringField(ppstring,  plenStr,  (pstruPlyappNet->sSiteCde      ), C_SITE_CDE_LEN     )==FALSE) break;    else k++;
		j++;    if(ToStringField(ppstring,  plenStr,  (pstruPlyappNet->sRecNo        ), C_REC_NO_LEN       )==FALSE) break;    else k++;
		j++;    if(ToStringField(ppstring,  plenStr,  (pstruPlyappNet->sSendFlag     ), C_REC_NO_LEN       )==FALSE) break;    else k++;
		
		j++;    if(ToStringField(ppstring,  plenStr,  (pstruPlyappNet->sSendEmpCde   ), C_SEND_EMP_CDE_LEN )==FALSE) break;    else k++; 		  
		j++;    if(ToStringField(ppstring,  plenStr,  (pstruPlyappNet->sPrtEmpCde    ), C_PRT_EMP_CDE_LEN  )==FALSE) break;    else k++; 		
		j++;    if(ToStringField(ppstring,  plenStr,  (pstruPlyappNet->sSendTm	     ), TIME_LEN           )==FALSE) break;    else k++;  			  
		j++;    if(ToStringField(ppstring,  plenStr,  (pstruPlyappNet->sSendedTm     ),	TIME_LEN           )==FALSE) break;    else k++;    			  
		j++;    if(ToStringField(ppstring,  plenStr,  (pstruPlyappNet->sZipCde	     ),	C_ZIP_CDE_LEN      )==FALSE) break;    else k++;       
		j++;    if(ToStringField(ppstring,  plenStr,  (pstruPlyappNet->cPayFlag	     ),	C_PAY_FLAG_LEN     )==FALSE) break;    else k++;     	
		j++;    if(ToStringField(ppstring,  plenStr,  (pstruPlyappNet->sSessionId    ),	C_SESSION_ID_LEN   )==FALSE) break;    else k++;  	
		j++;    if(ToStringField(ppstring,  plenStr,  (pstruPlyappNet->sBankCde	     ), C_BANK_CDE_LEN     )==FALSE) break;    else k++;  		
		j++;    if(ToStringField(ppstring,  plenStr,  (pstruPlyappNet->sBankCnm	     ), C_BANK_CNM_LEN     )==FALSE) break;    else k++;     	
		j++;    if(ToStringField(ppstring,  plenStr,  (pstruPlyappNet->sBankAccnt    ),	C_BANK_ACCNT_LEN   )==FALSE) break;    else k++;      		
		j++;    if(ToDoubleField(ppstring,  plenStr, &(pstruPlyappNet->fGotPrm	     )                     )==FALSE) break;    else k++;  
		j++;    if(ToStringField(ppstring,  plenStr,  (pstruPlyappNet->sCurTyp       ),	C_CUR_TYP_LEN      )==FALSE) break;    else k++;  
		j++;    if(ToStringField(ppstring,  plenStr,  (pstruPlyappNet->sPayTm	     ),	TIME_LEN           )==FALSE) break;    else k++;        		  
		j++;    if(ToStringField(ppstring,  plenStr,  (pstruPlyappNet->sPayTyp	     ),	C_PAY_TYP_LEN      )==FALSE) break;    else k++;   	  
		j++;    if(ToStringField(ppstring,  plenStr,  (pstruPlyappNet->sPayCde	     ),	C_PAY_CDE_LEN      )==FALSE) break;    else k++;   	             	  
		
		
	}while(0);
	if(j!=k) 
	{	
		#ifdef _DEBUG
		printf("StrToStruPlyappNet failed: Field index = %d\n", j);
		#endif
		return 0-j;
	}
	return 0;
}

void StruPlyappNetToStr(plyPlyappNetStru *pstruPlyappNet, char** ppstring, int *plenStr)
{
	StrToStr(pstruPlyappNet->sCrtCde      , ppstring,  plenStr); 
	StrToStr(pstruPlyappNet->sCrtTm       , ppstring,  plenStr); 
	StrToStr(pstruPlyappNet->sUpdCde      , ppstring,  plenStr); 
	StrToStr(pstruPlyappNet->sUpdTm       , ppstring,  plenStr); 
	StrToStr(pstruPlyappNet->sPlyAppNo    , ppstring,  plenStr); 
	DoubleToStr(pstruPlyappNet->fUserSeqNo  , ppstring,  plenStr); 
	StrToStr(pstruPlyappNet->sFeedbackTm  , ppstring,  plenStr); 
	StrToStr(pstruPlyappNet->sPrintTm     , ppstring,  plenStr); 
	StrToStr(pstruPlyappNet->sProvince    , ppstring,  plenStr);  
	StrToStr(pstruPlyappNet->sCity        , ppstring,  plenStr); 
	StrToStr(pstruPlyappNet->sPlace       , ppstring,  plenStr);   
	StrToStr(pstruPlyappNet->sContactName , ppstring,  plenStr); 
	StrToStr(pstruPlyappNet->sContactPhone, ppstring,  plenStr); 
	StrToStr(pstruPlyappNet->sContactFax  , ppstring,  plenStr); 
	StrToStr(pstruPlyappNet->sContactEmail, ppstring,  plenStr); 
	StrToStr(pstruPlyappNet->sSiteCde     , ppstring,  plenStr); 
	StrToStr(pstruPlyappNet->sRecNo       , ppstring,  plenStr); 
	StrToStr(pstruPlyappNet->sSendFlag    , ppstring,  plenStr); 


	StrToStr(pstruPlyappNet->sSendEmpCde   , ppstring,  plenStr); 
	StrToStr(pstruPlyappNet->sPrtEmpCde    , ppstring,  plenStr);   
	StrToStr(pstruPlyappNet->sSendTm       , ppstring,  plenStr); 
	StrToStr(pstruPlyappNet->sSendedTm     , ppstring,  plenStr); 
	StrToStr(pstruPlyappNet->sZipCde       , ppstring,  plenStr); 
	StrToStr(pstruPlyappNet->cPayFlag      , ppstring,  plenStr); 
	StrToStr(pstruPlyappNet->sSessionId    , ppstring,  plenStr); 
	StrToStr(pstruPlyappNet->sBankCde      , ppstring,  plenStr); 
	StrToStr(pstruPlyappNet->sBankCnm      , ppstring,  plenStr); 
	StrToStr(pstruPlyappNet->sBankAccnt    , ppstring,  plenStr); 
	DoubleToStr(pstruPlyappNet->fGotPrm    , ppstring,  plenStr);   
	StrToStr(pstruPlyappNet->sCurTyp       , ppstring,  plenStr); 
	StrToStr(pstruPlyappNet->sPayTm	       , ppstring,  plenStr); 
	StrToStr(pstruPlyappNet->sPayTyp       , ppstring,  plenStr); 
	StrToStr(pstruPlyappNet->sPayCde       , ppstring,  plenStr); 

	return ;
}












void PrintStruPlyappNet(const plyPlyappNetStru *pstruPlyappNetTemp)
{
	printf("pstruPlyappNetTemp->sCrtCde        = [%s]\n",  pstruPlyappNetTemp->sCrtCde      );              
	printf("pstruPlyappNetTemp->sCrtTm         = [%s]\n",  pstruPlyappNetTemp->sCrtTm       );             
	printf("pstruPlyappNetTemp->sUpdCde        = [%s]\n",  pstruPlyappNetTemp->sUpdCde      );              
	printf("pstruPlyappNetTemp->sUpdTm         = [%s]\n",  pstruPlyappNetTemp->sUpdTm       );             
	printf("pstruPlyappNetTemp->sPlyAppNo      = [%s]\n",  pstruPlyappNetTemp->sPlyAppNo    );                
	printf("pstruPlyappNetTemp->fUserSeqNo     = [%f]\n",  pstruPlyappNetTemp->fUserSeqNo   );                 
	printf("pstruPlyappNetTemp->sFeedbackTm    = [%s]\n",  pstruPlyappNetTemp->sFeedbackTm  );                  
	printf("pstruPlyappNetTemp->sPrintTm       = [%s]\n",  pstruPlyappNetTemp->sPrintTm     );               
	printf("pstruPlyappNetTemp->sProvince      = [%s]\n",  pstruPlyappNetTemp->sProvince    );                
	printf("pstruPlyappNetTemp->sCity          = [%s]\n",  pstruPlyappNetTemp->sCity        );            
	printf("pstruPlyappNetTemp->sPlace         = [%s]\n",  pstruPlyappNetTemp->sPlace       );             
	printf("pstruPlyappNetTemp->sContactName   = [%s]\n",  pstruPlyappNetTemp->sContactName );                   
	printf("pstruPlyappNetTemp->sContactPhone  = [%s]\n",  pstruPlyappNetTemp->sContactPhone);                    
	printf("pstruPlyappNetTemp->sContactFax    = [%s]\n",  pstruPlyappNetTemp->sContactFax  );                  
	printf("pstruPlyappNetTemp->sContactEmail  = [%s]\n",  pstruPlyappNetTemp->sContactEmail);                    
	printf("pstruPlyappNetTemp->sSiteCde       = [%s]\n",  pstruPlyappNetTemp->sSiteCde     );               
	printf("pstruPlyappNetTemp->sRecNo         = [%s]\n",  pstruPlyappNetTemp->sRecNo       );             
	printf("pstruPlyappNetTemp->sSendFlag      = [%s]\n",  pstruPlyappNetTemp->sSendFlag  );             


	printf("pstruPlyappNetTemp->sSendEmpCde   = [%s]\n",  pstruPlyappNetTemp->sSendEmpCde   );              
	printf("pstruPlyappNetTemp->sPrtEmpCde    = [%s]\n",  pstruPlyappNetTemp->sPrtEmpCde    );             
	printf("pstruPlyappNetTemp->sSendTm       = [%s]\n",  pstruPlyappNetTemp->sSendTm       );              
	printf("pstruPlyappNetTemp->sSendedTm     = [%s]\n",  pstruPlyappNetTemp->sSendedTm     );             
	printf("pstruPlyappNetTemp->sZipCde       = [%s]\n",  pstruPlyappNetTemp->sZipCde       );                
	printf("pstruPlyappNetTemp->cPayFlag      = [%s]\n",  pstruPlyappNetTemp->cPayFlag      );                 
	printf("pstruPlyappNetTemp->sSessionId    = [%s]\n",  pstruPlyappNetTemp->sSessionId    );                  
	printf("pstruPlyappNetTemp->sBankCde      = [%s]\n",  pstruPlyappNetTemp->sBankCde      );               
	printf("pstruPlyappNetTemp->sBankCnm      = [%s]\n",  pstruPlyappNetTemp->sBankCnm      );                
	printf("pstruPlyappNetTemp->sBankAccnt    = [%s]\n",  pstruPlyappNetTemp->sBankAccnt    );            
	printf("pstruPlyappNetTemp->fGotPrm       = [%f]\n",  pstruPlyappNetTemp->fGotPrm       );             
	printf("pstruPlyappNetTemp->sCurTyp       = [%s]\n",  pstruPlyappNetTemp->sCurTyp       );                   
	printf("pstruPlyappNetTemp->sPayTm	  = [%s]\n",  pstruPlyappNetTemp->sPayTm        );                    
	printf("pstruPlyappNetTemp->sPayTyp       = [%s]\n",  pstruPlyappNetTemp->sPayTyp       );                  
	printf("pstruPlyappNetTemp->sPayCde       = [%s]\n\n",  pstruPlyappNetTemp->sPayCde       );                    


}









void struPlyappNetOrderConvt(char *pBuff)
{
	plyPlyappNetStru struPlyappNet;
	memcpy(&struPlyappNet, pBuff, sizeof(plyPlyappNetStru));
	struPlyappNet.fUserSeqNo  = AIcom_ConvertDouble1(struPlyappNet.fUserSeqNo);                          
	struPlyappNet.fGotPrm     = AIcom_ConvertDouble1(struPlyappNet.fGotPrm);                          
	memcpy(pBuff, &struPlyappNet, sizeof(plyPlyappNetStru));
	return ;
}
