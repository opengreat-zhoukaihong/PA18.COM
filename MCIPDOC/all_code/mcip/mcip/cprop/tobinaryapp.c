#include "g_globdef.h"

#include "cplybodyinfo.h"
#include "cplyapppolygrid.h"
#include "cplyapppolicy.h"
#include "cplygotgt.h"
#include "cplyrdr.h"
#include "cplypay.h"
#include "cplyappnet.h"
#include "cplycheckgrid.h"
#include "cplyedrapp.h"
#include "cplyedrappcrgo.h"
#include "cplyedrapprdr.h"
#include "cplyedrapppay.h"
#include "cplyappnet.h"
#include "cplyedrgrid.h"



#include "tobinaryapp.h"






int StrToPlyApp(char** ppstring, int *plenStr, char *pBuffPlyApp, const PktBodyInfoStru *pstruPktBodyInfo)
{
	int  i;
	int iSuccFlag = 0;
	plyAppPolyGridStru struAppPolyGridTemp;
	plyAppPolicyStru struAppPolicyTemp;
	plyGoTgtStru struGoTgtTemp;
	plyRdrStru struRdrTemp;
	plyPayStru struPayTemp;
	plyPlyappNetStru struPlyappNetTemp;



	for(i=0; i<pstruPktBodyInfo->nPktNum[0]; i++)
	{
		memset(&struAppPolyGridTemp, 0, sizeof(plyAppPolyGridStru));
		iSuccFlag = StrToStruPolyGrid(ppstring, plenStr, &struAppPolyGridTemp);
		if(iSuccFlag==0) 
		{
			memcpy(pBuffPlyApp, &struAppPolyGridTemp, sizeof(plyAppPolyGridStru));
			pBuffPlyApp = pBuffPlyApp+sizeof(plyAppPolyGridStru);
		}
		else break;
	}
	if(iSuccFlag==0)  
	{
		for(i=0; i<pstruPktBodyInfo->nPktNum[1]; i++)
		{
			memset(&struAppPolicyTemp, 0, sizeof(plyAppPolicyStru));
			iSuccFlag = StrToStruAppPolicy(ppstring, plenStr, &struAppPolicyTemp);
			if(iSuccFlag==0) 
			{
				memcpy(pBuffPlyApp, &struAppPolicyTemp, sizeof(plyAppPolicyStru));
				pBuffPlyApp = pBuffPlyApp+sizeof(plyAppPolicyStru);
			}
			else break;
		}/*endof for*/
	}
	if(iSuccFlag==0)  
	{
		for(i=0; i<pstruPktBodyInfo->nPktNum[2]; i++)
		{
			memset(&struGoTgtTemp, 0, sizeof(plyGoTgtStru));
			iSuccFlag = StrToStruGoTgt(ppstring, plenStr, &struGoTgtTemp);
			if(iSuccFlag==0) 
			{
				memcpy(pBuffPlyApp, &struGoTgtTemp, sizeof(plyGoTgtStru));
				pBuffPlyApp = pBuffPlyApp+sizeof(plyGoTgtStru);
			}
			else break;
		}/*endof for*/
	}
	if(iSuccFlag==0)  
	{
		for(i=0; i<pstruPktBodyInfo->nPktNum[8]; i++)
		{
			memset(&struRdrTemp, 0, sizeof(plyRdrStru));
			iSuccFlag =  StrToStruRdr(ppstring, plenStr, &struRdrTemp);
			if(iSuccFlag==0) 
			{
				memcpy(pBuffPlyApp, &struRdrTemp, sizeof(plyRdrStru));
				pBuffPlyApp = pBuffPlyApp+sizeof(plyRdrStru);
			}
			else break;
		}/*endof for*/
	}
	if(iSuccFlag==0)  
	{
		for(i=0; i<pstruPktBodyInfo->nPktNum[9]; i++)
		{
			memset(&struPayTemp, 0, sizeof(plyPayStru));
			iSuccFlag = StrToStruPay(ppstring, plenStr, &struPayTemp);
			if(iSuccFlag==0) 
			{
				memcpy(pBuffPlyApp, &struPayTemp, sizeof(plyPayStru));
				pBuffPlyApp = pBuffPlyApp+sizeof(plyPayStru);
			}
			else break;
		}/*endof for*/
	}

	if(iSuccFlag==0)  
	{
		for(i=0; i<pstruPktBodyInfo->nPktNum[13]; i++)
		{
			memset(&struPlyappNetTemp, 0, sizeof(plyPlyappNetStru));
			iSuccFlag = StrToStruPlyappNet(ppstring, plenStr, &struPlyappNetTemp);
			if(iSuccFlag==0) 
			{
				memcpy(pBuffPlyApp, &struPlyappNetTemp, sizeof(plyPlyappNetStru));
				pBuffPlyApp = pBuffPlyApp+sizeof(plyPlyappNetStru);
			}
			else break;
		}/*endof for*/
	}
	
	return iSuccFlag;
}





int StrToCheckApp(char** ppstring, int *plenStr, char *pBuffCheckApp)
{
	int rtnVal = 0;
	PktBodyInfoStru struPktBodyInfo;
	plyCheckGridStru struPlyCheckGrid;


	memset(&struPktBodyInfo, 0, sizeof(PktBodyInfoStru));
	rtnVal = StrToStruPlyPktBodyInfo(ppstring, plenStr, &struPktBodyInfo);
	if(rtnVal!=0)
	{
		#ifdef _DEBUG
		printf("StrToStruPlyPktBodyInfo return = %d\n", rtnVal);
		#endif
		rtnVal = -1;
	}
	if(rtnVal==0)
	{
		memset(&struPlyCheckGrid, 0, sizeof(plyCheckGridStru));
		rtnVal = StrToStruPlyCheckGrid(ppstring, plenStr, &struPlyCheckGrid);
		if(rtnVal!=0)
		{
			#ifdef _DEBUG
			printf("StrToStruPlyCheckGrid return = %d\n", rtnVal);
			#endif
			rtnVal = -2;
		}
	}

	if(rtnVal==0)
	{
		memcpy(pBuffCheckApp, &struPktBodyInfo, sizeof(PktBodyInfoStru));
		memcpy(pBuffCheckApp+sizeof(PktBodyInfoStru), &struPlyCheckGrid, sizeof(plyCheckGridStru));
	}
	return rtnVal;
}





int StrToPolyGridApp(char** ppstring, int *plenStr, char *pBuffPolyGridApp)
{
	int rtnVal = 0;
	PktBodyInfoStru struPktBodyInfo;
	plyAppPolyGridStru struPolyGrid;


    memset(&struPktBodyInfo, 0, sizeof(PktBodyInfoStru));
	rtnVal = StrToStruPlyPktBodyInfo(ppstring, plenStr, &struPktBodyInfo);
	if(rtnVal!=0)
	{
		#ifdef _DEBUG
		printf("StrToStruPlyPktBodyInfo return = %d\n", rtnVal);
		#endif
		rtnVal = -1;
	}
	if(rtnVal==0)
	{
		memset(&struPolyGrid, 0, sizeof(plyAppPolyGridStru));
		rtnVal = StrToStruPolyGrid(ppstring, plenStr, &struPolyGrid);
		if(rtnVal!=0)
		{
			#ifdef _DEBUG
			printf("StrToStruPolyGrid return = %d\n", rtnVal);
			#endif
			rtnVal = -2;
		}
	}

	if(rtnVal==0)
	{
		memcpy(pBuffPolyGridApp, &struPktBodyInfo, sizeof(PktBodyInfoStru));
		memcpy(pBuffPolyGridApp+sizeof(PktBodyInfoStru), &struPolyGrid, sizeof(plyAppPolyGridStru));
	}
	return rtnVal;
}


int StrToPly22125(char** ppstring, int *plenStr, char *pBuffPlyApp, const PktBodyInfoStru *pstruPktBodyInfo)
{
	int  i;
	int iSuccFlag = 0;
	plyEdrGridStru		struPlyEdrGrid;
	plyEdrappStru		struPlyEdrapp;
	plyEdrappcrgoStru	struPlyEdrappcrgo;
	plyEdrapprdrStru	struPlyEdrapprdr;
	plyEdrapppayStru	struPlyEdrapppay;
	plyPlyappNetStru	struPlyPlyappNet;

	for(i=0; i<pstruPktBodyInfo->nPktNum[0]; i++)
	{
		memset(&struPlyEdrGrid, 0, sizeof(plyEdrGridStru));
		iSuccFlag = StrToStruPlyEdrGrid(ppstring, plenStr, &struPlyEdrGrid);
		if(iSuccFlag==0) 
		{	memcpy(pBuffPlyApp, &struPlyEdrGrid, sizeof(plyEdrGridStru));
			pBuffPlyApp = pBuffPlyApp+sizeof(plyEdrGridStru);
		}
		else break;
	}

	if(iSuccFlag==0)
	{
		for(i=0; i<pstruPktBodyInfo->nPktNum[1]; i++)
		{
			memset(&struPlyEdrapp, 0, sizeof(plyEdrappStru));
			iSuccFlag = StrToStruPlyEdrapp(ppstring, plenStr, &struPlyEdrapp);
			if(iSuccFlag==0) 
			{	memcpy(pBuffPlyApp, &struPlyEdrapp, sizeof(plyEdrappStru));
				pBuffPlyApp = pBuffPlyApp+sizeof(plyEdrappStru);
			}
			else break;
		}
	}
	if(iSuccFlag==0)  
	{
		for(i=0; i<pstruPktBodyInfo->nPktNum[2]; i++)
		{
			memset(&struPlyEdrappcrgo, 0, sizeof(plyEdrappcrgoStru));
			iSuccFlag = StrToStruPlyEdrappcrgo(ppstring, plenStr, &struPlyEdrappcrgo);
			if(iSuccFlag==0) 
			{
				memcpy(pBuffPlyApp, &struPlyEdrappcrgo, sizeof(plyEdrappcrgoStru));
				pBuffPlyApp = pBuffPlyApp+sizeof(plyEdrappcrgoStru);
			}
			else break;
		}/*endof for*/
	}

	if(iSuccFlag==0)  
	{
		for(i=0; i<pstruPktBodyInfo->nPktNum[8]; i++)
		{
			memset(&struPlyEdrapprdr, 0, sizeof(plyEdrapprdrStru));
			iSuccFlag = StrToStruPlyEdrapprdr(ppstring, plenStr, &struPlyEdrapprdr);
			if(iSuccFlag==0) 
			{
				memcpy(pBuffPlyApp, &struPlyEdrapprdr, sizeof(plyEdrapprdrStru));
				pBuffPlyApp = pBuffPlyApp+sizeof(plyEdrapprdrStru);
			}
			else break;
		}/*endof for*/
	}

	if(iSuccFlag==0)  
	{
		for(i=0; i<pstruPktBodyInfo->nPktNum[9]; i++)
		{
			memset(&struPlyEdrapppay, 0, sizeof(plyEdrapppayStru));
			iSuccFlag =  StrToStruPlyEdrapppay(ppstring, plenStr, &struPlyEdrapppay);
			if(iSuccFlag==0) 
			{
				memcpy(pBuffPlyApp, &struPlyEdrapppay, sizeof(plyEdrapppayStru));
				pBuffPlyApp = pBuffPlyApp+sizeof(plyEdrapppayStru);
			}
			else break;
		}/*endof for*/
	}
	if(iSuccFlag==0)  
	{
		for(i=0; i<pstruPktBodyInfo->nPktNum[13]; i++)
		{
			memset(&struPlyPlyappNet, 0, sizeof(plyPlyappNetStru));
			iSuccFlag = StrToStruPlyappNet(ppstring, plenStr, &struPlyPlyappNet);
			if(iSuccFlag==0) 
			{
				memcpy(pBuffPlyApp, &struPlyPlyappNet, sizeof(plyPlyappNetStru));
				pBuffPlyApp = pBuffPlyApp+sizeof(plyPlyappNetStru);
			}
			else break;
		}/*endof for*/
	}

	
	return iSuccFlag;


}


int StrToPly22128(char** ppstring, int *plenStr, char *pBuffPlyApp, const PktBodyInfoStru *pstruPktBodyInfo)
{
	int  i;
	int iSuccFlag = 0;
	plyEdrGridStru		struPlyEdrGrid;


	for(i=0; i<pstruPktBodyInfo->nPktNum[0]; i++)
	{
		memset(&struPlyEdrGrid, 0, sizeof(plyEdrGridStru));
		iSuccFlag = StrToStruPlyEdrGrid(ppstring, plenStr, &struPlyEdrGrid);
		if(iSuccFlag==0) 
		{
			memcpy(pBuffPlyApp, &struPlyEdrGrid, sizeof(plyEdrGridStru));
			pBuffPlyApp = pBuffPlyApp+sizeof(plyEdrGridStru);
		}
		else break;
	}

	return iSuccFlag;
}

