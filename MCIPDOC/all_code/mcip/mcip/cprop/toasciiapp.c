#include "g_globdef.h"
#include "typeconvt.h"

#include "cpkthead.h"
#include "cperclnt.h"
#include "corgclnt.h"
#include "cplybodyinfo.h"
#include "cplyapppolygrid.h"
#include "cplyproposal.h"
#include "cplycheckgrid.h"
#include "cclmplcyno.h"
#include "cplyedrapp.h"
#include "cplyedrappcrgo.h"
#include "cplyedrapprdr.h"
#include "cplyedrapppay.h"
#include "cplyappnet.h"
#include "cplyedrgrid.h"

#include "toasciiapp.h"



void CltPerClntInfoReturnToStr(char** ppRcvStringOffset, char cRetCode, char** ppStringResult, int* plenStr)
{
	cltPerClntInfoStru struCltPerClntInfo;

	memcpy(&struCltPerClntInfo, *ppRcvStringOffset, sizeof(cltPerClntInfoStru));
	StruCltPerClntInfoToStr(&struCltPerClntInfo, ppStringResult, plenStr);

	return ;
}








void CltOrgClntInfoReturnToStr(char** ppRcvStringOffset, char cRetCode, char** ppStringResult, int* plenStr)
{
	cltOrgClntInfoStru struCltOrgClntInfo;

	memcpy(&struCltOrgClntInfo, *ppRcvStringOffset, sizeof(cltOrgClntInfoStru));
	StruCltOrgClntInfoToStr(&struCltOrgClntInfo, ppStringResult, plenStr);
	return ;
}


void PlyCplyReturnToStr(char** ppRcvStringOffset, char cRetCode, char** ppStringResult, int* plenStr)
{
	int i;
	PktBodyInfoStru		struPktBodyInfo;
	plyAppPolyGridStru	struAppPolyGrid;
	plyProposalStru		struPlyProposal;


	memcpy(&struPktBodyInfo, *ppRcvStringOffset, sizeof(PktBodyInfoStru));
	StruPlyPktBodyInfoToStr(&struPktBodyInfo, ppStringResult, plenStr); 
/*	for(i=0; i<struPktBodyInfo.nPktNum[0]; i++)*/
	for(i=0; i<1; i++)
	{
		memcpy(&struAppPolyGrid, 
			*ppRcvStringOffset+sizeof(PktBodyInfoStru)+i*sizeof(plyAppPolyGridStru), 
			sizeof(plyAppPolyGridStru));
		StruPlyAppPolyGridToStr(&struAppPolyGrid, ppStringResult, plenStr);
	}
/*	for(i=0; i<struPktBodyInfo.nPktNum[1]; i++)*/
	for(i=0; i<1; i++)
	{
		memcpy(&struPlyProposal, 
			*ppRcvStringOffset+sizeof(PktBodyInfoStru)
			+struPktBodyInfo.nPktNum[0]*sizeof(plyAppPolyGridStru)
			+i*sizeof(plyProposalStru), 
			sizeof(plyProposalStru));
		StruPlyProposalToStr(&struPlyProposal, ppStringResult, plenStr);
	}

	return ;
}

void CheckGridReturnToStr(char** ppRcvStringOffset, char cRetCode, char** ppStringResult, int* plenStr)
{
	plyCheckGridStru pstruPlyCheckGrid;

	memcpy(&pstruPlyCheckGrid, *ppRcvStringOffset, sizeof(plyCheckGridStru));
	StruPlyCheckGridToStr(&pstruPlyCheckGrid, ppStringResult, plenStr);

	return ;
}



void AppPolyReturnToStr(char** ppRcvStringOffset, char cRetCode, char** ppStringResult, int* plenStr)
{
	PktBodyInfoStru		struPktBodyInfo;
	plyAppPolyGridStru struAppPolyGrid;

	/*temp*/
	memset(&struPktBodyInfo, 0, sizeof(PktBodyInfoStru));
	memset(&struAppPolyGrid, 0, sizeof(plyAppPolyGridStru));
	StruPlyPktBodyInfoToStr(&struPktBodyInfo, ppStringResult, plenStr); 
	StruPlyAppPolyGridToStr(&struAppPolyGrid, ppStringResult, plenStr);

	return ;
}



void ClmPlcyNoReturnToStr(char** ppRcvStringOffset, char cRetCode, char** ppStringResult, int* plenStr)
{
	clmPlcyNoStru struClmPlcyNo;

	memcpy(&struClmPlcyNo, *ppRcvStringOffset, sizeof(clmPlcyNoStru));
	StruClmPlcyNoToStr(&struClmPlcyNo, ppStringResult, plenStr);

	return ;
}


void Ply22120ReturnToStr(char** ppRcvStringOffset, char cRetCode, char** ppStringResult, int* plenStr)
{
	int i;
	PktBodyInfoStru		struPktBodyInfo;
	plyEdrappStru		struPlyEdrapp;
	plyEdrappcrgoStru	struPlyEdrappcrgo;
	plyEdrapprdrStru    struPlyEdrapprdr;
	plyEdrapppayStru	struPlyEdrapppay;
	plyPlyappNetStru	struPlyPlyappNet;

	memcpy(&struPktBodyInfo, *ppRcvStringOffset, sizeof(PktBodyInfoStru));
	StruPlyPktBodyInfoToStr(&struPktBodyInfo, ppStringResult, plenStr); 
	for(i=0; i<struPktBodyInfo.nPktNum[0]; i++)
	{
		memcpy(&struPlyEdrapp, 
			*ppRcvStringOffset+sizeof(PktBodyInfoStru)
			+i*sizeof(plyEdrappStru),
			sizeof(plyEdrappStru));
		StruPlyEdrappToStr(&struPlyEdrapp, ppStringResult, plenStr);
	}
	for(i=0; i<struPktBodyInfo.nPktNum[1]; i++)
	{
		memcpy(&struPlyEdrappcrgo, 
			*ppRcvStringOffset+sizeof(PktBodyInfoStru)
			+struPktBodyInfo.nPktNum[0]*sizeof(plyEdrappStru)
			+i*sizeof(plyEdrappcrgoStru),
			sizeof(plyEdrappcrgoStru));
		StruPlyEdrappcrgoToStr(&struPlyEdrappcrgo, ppStringResult, plenStr);
	}
	for(i=0; i<struPktBodyInfo.nPktNum[7]; i++)
	{
		memcpy(&struPlyEdrapprdr, 
			*ppRcvStringOffset+sizeof(PktBodyInfoStru)
			+struPktBodyInfo.nPktNum[0]*sizeof(plyEdrappStru)
			+struPktBodyInfo.nPktNum[1]*sizeof(plyEdrappcrgoStru)
			+i*sizeof(plyEdrapprdrStru),
			sizeof(plyEdrapprdrStru));
		StruPlyEdrapprdrToStr(&struPlyEdrapprdr, ppStringResult, plenStr);
	}
	for(i=0; i<struPktBodyInfo.nPktNum[8]; i++)
	{
		memcpy(&struPlyEdrapppay, 
			*ppRcvStringOffset+sizeof(PktBodyInfoStru)
			+struPktBodyInfo.nPktNum[0]*sizeof(plyEdrappStru)
			+struPktBodyInfo.nPktNum[1]*sizeof(plyEdrappcrgoStru)
			+struPktBodyInfo.nPktNum[7]*sizeof(plyEdrapprdrStru)
			+i*sizeof(plyEdrapppayStru),
			sizeof(plyEdrapppayStru));
		StruPlyEdrapppayToStr(&struPlyEdrapppay, ppStringResult, plenStr);
	}
	for(i=0; i<struPktBodyInfo.nPktNum[12]; i++)
	{
		memcpy(&struPlyPlyappNet, 
			*ppRcvStringOffset+sizeof(PktBodyInfoStru)
			+struPktBodyInfo.nPktNum[0]*sizeof(plyEdrappStru)
			+struPktBodyInfo.nPktNum[1]*sizeof(plyEdrappcrgoStru)
			+struPktBodyInfo.nPktNum[7]*sizeof(plyEdrapprdrStru)
			+struPktBodyInfo.nPktNum[8]*sizeof(plyEdrapppayStru)
			+i*sizeof(plyPlyappNetStru),
			sizeof(plyPlyappNetStru));
		StruPlyappNetToStr(&struPlyPlyappNet, ppStringResult, plenStr);
	}

	return ;
}





void Ply22125ReturnToStr(char** ppRcvStringOffset, char cRetCode, char** ppStringResult, int* plenStr, const PktBodyInfoStru* pstruPktBodyInfo)
{
	int i;
	plyEdrGridStru struPlyEdrGrid;
	plyProposalStru struPlyProposal;

	for(i=0; i<pstruPktBodyInfo->nPktNum[0]; i++)
	{
		memcpy(&struPlyEdrGrid, *ppRcvStringOffset, sizeof(plyEdrGridStru));
		StruPlyEdrGridToStr(&struPlyEdrGrid, ppStringResult, plenStr);
		*ppRcvStringOffset = *ppRcvStringOffset + sizeof(plyEdrGridStru);
	}

	for(i=0; i<pstruPktBodyInfo->nPktNum[1]; i++)
	{
		memcpy(&struPlyProposal, *ppRcvStringOffset, sizeof(plyProposalStru));
		StruPlyProposalToStr(&struPlyProposal, ppStringResult, plenStr);
		*ppRcvStringOffset = *ppRcvStringOffset + sizeof(plyProposalStru);
	}

	return ;
}



void Ply22128ReturnToStr(char** ppRcvStringOffset, char cRetCode, char** ppStringResult, int* plenStr, const PktBodyInfoStru* pstruPktBodyInfo)
{
	int i;
	plyEdrGridStru struPlyEdrGrid;

	for(i=0; i<pstruPktBodyInfo->nPktNum[0]; i++)
	{
		memcpy(&struPlyEdrGrid, *ppRcvStringOffset, sizeof(plyEdrGridStru));
		StruPlyEdrGridToStr(&struPlyEdrGrid, ppStringResult, plenStr);
		*ppRcvStringOffset = *ppRcvStringOffset + sizeof(plyEdrGridStru);
	}

	return ;
}





void Ply22123ReturnToStr(char** ppRcvStringOffset, char cRetCode, char** ppStringResult, int* plenStr, const PktBodyInfoStru* pstruPktBodyInfo)
{
	int i;
	plyEdrGridStru		struPlyEdrGrid;
	plyEdrappStru		struPlyEdrapp;
	plyEdrappcrgoStru	struPlyEdrappcrgo;
	plyEdrapprdrStru    struPlyEdrapprdr;
	plyEdrapppayStru	struPlyEdrapppay;
	plyPlyappNetStru	struPlyPlyappNet;

	printf("debug 1------------------------------\n");

	for(i=0; i<pstruPktBodyInfo->nPktNum[0]; i++)
	{
		printf("....................................111\n");
		memcpy(&struPlyEdrGrid, *ppRcvStringOffset, sizeof(plyEdrGridStru));
		printf("....................................122\n");
		StruPlyEdrGridToStr(&struPlyEdrGrid, ppStringResult, plenStr);
		printf("....................................133\n");
		*ppRcvStringOffset = *ppRcvStringOffset + sizeof(plyEdrGridStru);
	}

	printf("debug 2------------------------------\n");
	for(i=0; i<pstruPktBodyInfo->nPktNum[1]; i++)
	{
		memcpy(&struPlyEdrapp, *ppRcvStringOffset, sizeof(plyEdrappStru));
		StruPlyEdrappToStr(&struPlyEdrapp, ppStringResult, plenStr);
		*ppRcvStringOffset = *ppRcvStringOffset + sizeof(plyEdrappStru);
	}

	printf("debug 3------------------------------\n");
	for(i=0; i<pstruPktBodyInfo->nPktNum[2]; i++)
	{
		memcpy(&struPlyEdrappcrgo, *ppRcvStringOffset, sizeof(plyEdrappcrgoStru));
		StruPlyEdrappcrgoToStr(&struPlyEdrappcrgo, ppStringResult, plenStr);
		*ppRcvStringOffset = *ppRcvStringOffset + sizeof(plyEdrappcrgoStru);
	}

	printf("debug 4------------------------------\n");
	for(i=0; i<pstruPktBodyInfo->nPktNum[8]; i++)
	{
		memcpy(&struPlyEdrapprdr, *ppRcvStringOffset, sizeof(plyEdrapprdrStru));
		StruPlyEdrapprdrToStr(&struPlyEdrapprdr, ppStringResult, plenStr);
		*ppRcvStringOffset = *ppRcvStringOffset + sizeof(plyEdrapprdrStru);
	}

	printf("debug 5------------------------------\n");
	for(i=0; i<pstruPktBodyInfo->nPktNum[9]; i++)
	{
		memcpy(&struPlyEdrapppay, *ppRcvStringOffset, sizeof(plyEdrapppayStru));
		StruPlyEdrapppayToStr(&struPlyEdrapppay, ppStringResult, plenStr);
		*ppRcvStringOffset = *ppRcvStringOffset + sizeof(plyEdrapppayStru);
	}
	printf("debug 6------------------------------\n");
	for(i=0; i<pstruPktBodyInfo->nPktNum[13]; i++)
	{
		memcpy(&struPlyPlyappNet, *ppRcvStringOffset, sizeof(plyPlyappNetStru));
		StruPlyappNetToStr(&struPlyPlyappNet, ppStringResult, plenStr);
		*ppRcvStringOffset = *ppRcvStringOffset + sizeof(plyPlyappNetStru);
	}

	return ;
}




void Ply22126ReturnToStr(char** ppRcvStringOffset, char cRetCode, char** ppStringResult, int* plenStr)
{
	plyEdrGridStru struPlyEdrGrid;

	/*temp*/
	memset(&struPlyEdrGrid, 0, sizeof(plyEdrGridStru));
	StruPlyEdrGridToStr(&struPlyEdrGrid, ppStringResult, plenStr);

	return ;
}





