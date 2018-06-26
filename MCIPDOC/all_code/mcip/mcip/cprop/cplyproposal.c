#include "typeconvt.h"
#include "AiConvert.h"
#include "cplyproposal.h"


void StruPlyProposalToStr(plyProposalStru* pstruPlyProposal, char **ppstring, int *plenStr)
{
	StrToStr(pstruPlyProposal->sCrtCde, ppstring,  plenStr);  
	StrToStr(pstruPlyProposal->sCrtTm, ppstring,  plenStr);  
	StrToStr(pstruPlyProposal->sUpdCde, ppstring,  plenStr);  
	StrToStr(pstruPlyProposal->sUpdTm, ppstring,  plenStr);  
	StrToStr(pstruPlyProposal->sDocNo, ppstring,  plenStr);  
	DoubleToStr(pstruPlyProposal->fRate, ppstring,  plenStr);  
	StrToStr(pstruPlyProposal->sNclmDesc, ppstring,  plenStr);  
	StrToStr(pstruPlyProposal->sUndrCndtn, ppstring,  plenStr);  
	StrToStr(pstruPlyProposal->sSendTm, ppstring,  plenStr);  
	StrToStr(pstruPlyProposal->sSendDesc, ppstring,  plenStr);  
	StrToStr(pstruPlyProposal->sUndrPrsn, ppstring,  plenStr);  
	StrToStr(pstruPlyProposal->sSignTm, ppstring,  plenStr);  
	StrToStr(pstruPlyProposal->sUserId, ppstring,  plenStr);  
	StrToStr(pstruPlyProposal->sUserRemark, ppstring,  plenStr);  
	StrToStr(pstruPlyProposal->sRemark, ppstring,  plenStr);  
	DoubleToStr(pstruPlyProposal->fSumPrm, ppstring,  plenStr);
	StrToStr(pstruPlyProposal->sPrmCur, ppstring,  plenStr);
	
	DoubleToStr(pstruPlyProposal->fAmt     , ppstring,  plenStr);
	DoubleToStr(pstruPlyProposal->fAmtVar  , ppstring,  plenStr);
	DoubleToStr(pstruPlyProposal->fAmtOld  , ppstring,  plenStr);
	StrToStr(   pstruPlyProposal->sAmtCur  , ppstring,  plenStr);
	DoubleToStr(pstruPlyProposal->fPrm     , ppstring,  plenStr);
	DoubleToStr(pstruPlyProposal->fPrmVar  , ppstring,  plenStr);
	DoubleToStr(pstruPlyProposal->fPrmOld  , ppstring,  plenStr);
	DoubleToStr(pstruPlyProposal->fRateOld , ppstring,  plenStr);
	StrToStr(   pstruPlyProposal->sReadFlag, ppstring,  plenStr);
	StrToStr(   pstruPlyProposal->sPropType, ppstring,  plenStr);
	StrToStr(   pstruPlyProposal->sPropFlag, ppstring,  plenStr);
	return;
}



void PrintStruPlyProposal(const plyProposalStru* pstruPlyProposal)
{
	printf("pstruPlyProposal->sCrtCde     = [%s]\n", pstruPlyProposal->sCrtCde);             
	printf("pstruPlyProposal->sCrtTm      = [%s]\n", pstruPlyProposal->sCrtTm);             
	printf("pstruPlyProposal->sUpdCde     = [%s]\n", pstruPlyProposal->sUpdCde);             
	printf("pstruPlyProposal->sUpdTm      = [%s]\n", pstruPlyProposal->sUpdTm);             
	printf("pstruPlyProposal->sDocNo      = [%s]\n", pstruPlyProposal->sDocNo);             
	printf("pstruPlyProposal->fRate       = [%f]\n", pstruPlyProposal->fRate);             
	printf("pstruPlyProposal->sNclmDesc   = [%s]\n", pstruPlyProposal->sNclmDesc);             
	printf("pstruPlyProposal->sUndrCndtn  = [%s]\n", pstruPlyProposal->sUndrCndtn);             
	printf("pstruPlyProposal->sSendTm     = [%s]\n", pstruPlyProposal->sSendTm);             
	printf("pstruPlyProposal->sSendDesc   = [%s]\n", pstruPlyProposal->sSendDesc);             
	printf("pstruPlyProposal->sUndrPrsn   = [%s]\n", pstruPlyProposal->sUndrPrsn);             
	printf("pstruPlyProposal->sSignTm     = [%s]\n", pstruPlyProposal->sSignTm);             
	printf("pstruPlyProposal->sUserId     = [%s]\n", pstruPlyProposal->sUserId);             
	printf("pstruPlyProposal->sUserRemark = [%s]\n", pstruPlyProposal->sUserRemark);             
	printf("pstruPlyProposal->sRemark     = [%s]\n", pstruPlyProposal->sRemark);             
	printf("pstruPlyProposal->fSumPrm     = [%d]\n", pstruPlyProposal->fSumPrm);             
	printf("pstruPlyProposal->sPrmCur     = [%s]\n", pstruPlyProposal->sPrmCur);        
	
	printf("pstruPlyProposal->fAmt        = [%f]\n", pstruPlyProposal->fAmt       );             
	printf("pstruPlyProposal->fAmtVar     = [%f]\n", pstruPlyProposal->fAmtVar    );             
	printf("pstruPlyProposal->fAmtOld     = [%f]\n", pstruPlyProposal->fAmtOld    );             
	printf("pstruPlyProposal->sAmtCur     = [%s]\n", pstruPlyProposal->sAmtCur    );             
	printf("pstruPlyProposal->fPrm        = [%f]\n", pstruPlyProposal->fPrm       );             
	printf("pstruPlyProposal->fPrmVar     = [%f]\n", pstruPlyProposal->fPrmVar    );             
	printf("pstruPlyProposal->fPrmOld     = [%f]\n", pstruPlyProposal->fPrmOld    );             
	printf("pstruPlyProposal->fRateOld    = [%f]\n", pstruPlyProposal->fRateOld   );             
	printf("pstruPlyProposal->sReadFlag   = [%s]\n", pstruPlyProposal->sReadFlag  );             
	printf("pstruPlyProposal->sPropType   = [%s]\n", pstruPlyProposal->sPropType  );             
	printf("pstruPlyProposal->sPropFlag   = [%s]\n\n",pstruPlyProposal->sPropFlag  );        
	
	return;
}



void struProposalOrderConvt(char *pBuff)
{
	plyProposalStru struPlyProposal;
	memcpy(&struPlyProposal, pBuff, sizeof(plyProposalStru));

	struPlyProposal.fRate   = AIcom_ConvertDouble1(struPlyProposal.fRate);
	struPlyProposal.fSumPrm = AIcom_ConvertDouble1(struPlyProposal.fSumPrm);
	
	struPlyProposal.fAmt     = AIcom_ConvertDouble1(struPlyProposal.fAmt    );
	struPlyProposal.fAmtVar  = AIcom_ConvertDouble1(struPlyProposal.fAmtVar );
	struPlyProposal.fAmtOld  = AIcom_ConvertDouble1(struPlyProposal.fAmtOld );
	struPlyProposal.fPrm     = AIcom_ConvertDouble1(struPlyProposal.fPrm    );
	struPlyProposal.fPrmVar  = AIcom_ConvertDouble1(struPlyProposal.fPrmVar );
	struPlyProposal.fPrmOld  = AIcom_ConvertDouble1(struPlyProposal.fPrmOld );
	struPlyProposal.fRateOld = AIcom_ConvertDouble1(struPlyProposal.fRateOld);


	memcpy(pBuff, &struPlyProposal, sizeof(plyProposalStru));
	return;
}





