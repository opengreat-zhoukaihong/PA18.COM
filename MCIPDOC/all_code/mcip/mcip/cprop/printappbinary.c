#include "g_globdef.h"

#include "cpkthead.h"
#include "cperclnt.h"
#include "corgclnt.h"
#include "cplybodyinfo.h"
#include "cplyapppolygrid.h"
#include "cplyproposal.h"
#include "cplycheckgrid.h"
#include "cplyapppolicy.h"
#include "cplygotgt.h"
#include "cplyrdr.h"
#include "cplypay.h"
#include "cplyappnet.h"
#include "cplycheckgrid.h"
#include "cclminlistchange.h"
#include "cclmplcyno.h"
#include "cplyedrgrid.h"

#include "printappbinary.h"




void PrintBinPerCltBuff(char* pbuff)
{
	cltPerClntInfoStru	struCltPerClntInfo;
	if(pbuff==NULL) return ;

	memcpy(&struCltPerClntInfo, pbuff, sizeof(cltPerClntInfoStru));
	printf("\n************ struct cltPerClntInfoStru *****************\n");
	PrintStruCltPerClntInfo(&struCltPerClntInfo);
	return ;
}

void PrintBinOrgCltBuff(char* pbuff)
{
	cltOrgClntInfoStru	struCltOrgClntInfo;
	if(pbuff==NULL) return ;

	memcpy(&struCltOrgClntInfo, pbuff, sizeof(cltOrgClntInfoStru));
	printf("\n************ struct cltOrgClntInfoStru *****************\n");
	PrintStruCltOrgClntInfo(&struCltOrgClntInfo);
	return ;
}





void PrintBinAppPlyBuff(char* pbuff)
{
	int i;
	PktBodyInfoStru		struPktBodyInfo;
	plyAppPolyGridStru	struPolyGrid;
	plyProposalStru		struProposal;




	memcpy(&struPktBodyInfo, pbuff, sizeof(PktBodyInfoStru));
	printf("\n********** struct PktBodyInfoStru *********************\n");
	PrintStruPlyPktBodyInfo(&struPktBodyInfo);

/*	for(i=0; i<struPktBodyInfo.nPktNum[0]; i++)*/
	for(i=0; i<1; i++)
	{
		printf("\n *********** struct plyAppPolyGridStru[%d] *****************\n", i);
		memcpy(&struPolyGrid, 
			pbuff+sizeof(PktBodyInfoStru)+i*sizeof(plyAppPolyGridStru), 
			sizeof(plyAppPolyGridStru));
		PrintStruAppPolyGrid(&struPolyGrid);
	}

/*	for(i=0; i<struPktBodyInfo.nPktNum[1]; i++)*/
	for(i=0; i<1; i++)
	{
		printf("\n *********** struct plyProposalStru *****************\n");
		memcpy(&struProposal, 
			pbuff+sizeof(PktBodyInfoStru)
			+struPktBodyInfo.nPktNum[0]*sizeof(plyAppPolyGridStru)
			+i*sizeof(plyProposalStru), 
			sizeof(plyProposalStru));
		PrintStruPlyProposal(&struProposal);
	}
	return;
}



void PrintBinCheckGrid(char* pbuff)
{
	plyCheckGridStru	struPlyCheckGrid;

	memcpy(&struPlyCheckGrid, pbuff, sizeof(plyCheckGridStru));

	printf("\n *********** struct plyCheckGridStru *****************\n");
	PrintStruCheckGrid(&struPlyCheckGrid);
	return ;
}



void PrintBinPolyGrid(char* pbuff)
{
	PktBodyInfoStru		struPktBodyInfo;
	plyAppPolyGridStru	struAppPolyGrid;

	memcpy(&struPktBodyInfo, pbuff, sizeof(PktBodyInfoStru));
	memcpy(&struAppPolyGrid, pbuff+sizeof(PktBodyInfoStru), sizeof(plyAppPolyGridStru));

	printf("\n *********** struct PktBodyInfoStru *****************\n");
	PrintStruPlyPktBodyInfo(&struPktBodyInfo);
	printf("\n *********** struct plyAppPolyGridStru *****************\n");
	PrintStruAppPolyGrid(&struAppPolyGrid);
	return ;
}





void PrintBinClmPlcyNo(char *pbuff)
{
	clmPlcyNoStru struClmPlcyNo;
	if(pbuff==NULL) return ;

	memcpy(&struClmPlcyNo, pbuff, sizeof(clmPlcyNoStru));
	printf("\n************ struct clmPlcyNoStru *****************\n");
	PrintStruClmPlcyNo(&struClmPlcyNo);
	return ;

}



#include "cplyedrapp.h"
#include "cplyedrappcrgo.h"
#include "cplyedrapprdr.h"
#include "cplyedrapppay.h"
#include "cplyappnet.h"


void PrintBin22120(char* pbuff)
{
	int i;
	PktBodyInfoStru		struPktBodyInfo;

	memcpy(&struPktBodyInfo, pbuff, sizeof(PktBodyInfoStru));
	printf("\n************ struct pktBodyInfoStru *****************\n");
	PrintStruPlyPktBodyInfo(&struPktBodyInfo);
	for(i=0; i<struPktBodyInfo.nPktNum[0]; i++)
	{	printf("\n************ struct plyEdrappStru[%d] *****************\n", i);
		PrintStruPlyEdrapp((plyEdrappStru*)(pbuff+sizeof(PktBodyInfoStru)+i*sizeof(plyEdrappStru)));
	}

	for(i=0; i<struPktBodyInfo.nPktNum[1]; i++)
	{	printf("\n************ struct plyEdrappcrgoStru[%d] *****************\n", i);
		PrintStruPlyEdrappcrgo((plyEdrappcrgoStru*)(pbuff+sizeof(PktBodyInfoStru)
			+struPktBodyInfo.nPktNum[0]*sizeof(plyEdrappStru)
			+i*sizeof(plyEdrappcrgoStru)));
	}

	for(i=0; i<struPktBodyInfo.nPktNum[7]; i++)
	{	printf("\n************ struct plyEdrapprdrStru[%d] *****************\n", i);
		PrintStruPlyEdrapprdr((plyEdrapprdrStru*)(pbuff+sizeof(PktBodyInfoStru)
			+struPktBodyInfo.nPktNum[0]*sizeof(plyEdrappStru)
			+struPktBodyInfo.nPktNum[1]*sizeof(plyEdrappcrgoStru)
			+i*sizeof(plyEdrapprdrStru)));
	}

	for(i=0; i<struPktBodyInfo.nPktNum[8]; i++)
	{	printf("\n************ struct plyEdrapppayStru[%d] *****************\n", i);
		PrintStruPlyEdrapppay((plyEdrapppayStru*)(pbuff+sizeof(PktBodyInfoStru)
			+struPktBodyInfo.nPktNum[0]*sizeof(plyEdrappStru)
			+struPktBodyInfo.nPktNum[1]*sizeof(plyEdrappcrgoStru)
			+struPktBodyInfo.nPktNum[7]*sizeof(plyEdrapprdrStru)
			+i*sizeof(plyEdrapppayStru)));
	}

	for(i=0; i<struPktBodyInfo.nPktNum[12]; i++)
	{	printf("\n************ struct plyPlyappNetStru[%d] *****************\n", i);
		PrintStruPlyappNet((plyPlyappNetStru*)(pbuff+sizeof(PktBodyInfoStru)
			+struPktBodyInfo.nPktNum[0]*sizeof(plyEdrappStru)
			+struPktBodyInfo.nPktNum[1]*sizeof(plyEdrappcrgoStru)
			+struPktBodyInfo.nPktNum[7]*sizeof(plyEdrapprdrStru)
			+struPktBodyInfo.nPktNum[8]*sizeof(plyEdrapppayStru)
			+i*sizeof(plyPlyappNetStru)));
	}

	return ;
}





void PrintBin22125(char* pbuff)
{
	int i;
	PktBodyInfoStru		struPktBodyInfo;

	memcpy(&struPktBodyInfo, pbuff, sizeof(PktBodyInfoStru));
	printf("\n************ struct pktBodyInfoStru *****************\n");
	PrintStruPlyPktBodyInfo(&struPktBodyInfo);
	
	for(i=0; i<struPktBodyInfo.nPktNum[0]; i++)
	{	printf("\n************ struct plyEdrGridStru[%d] *****************\n", i);
		PrintStruPlyEdrGrid((plyEdrGridStru*)(pbuff+sizeof(PktBodyInfoStru)
				+i*sizeof(plyEdrGridStru)));
	}

	for(i=0; i<struPktBodyInfo.nPktNum[1]; i++)
	{	printf("\n************ struct plyProposalStru[%d] *****************\n", i);
		PrintStruPlyProposal((plyProposalStru*)(pbuff+sizeof(PktBodyInfoStru)
			+struPktBodyInfo.nPktNum[0]*sizeof(plyEdrGridStru)
			+i*sizeof(plyProposalStru)));
	}
	return ;


}



void PrintBin22128(char* pbuff)
{
	int i;
	PktBodyInfoStru		struPktBodyInfo;

	memcpy(&struPktBodyInfo, pbuff, sizeof(PktBodyInfoStru));
	printf("\n************ struct pktBodyInfoStru *****************\n");
	PrintStruPlyPktBodyInfo(&struPktBodyInfo);
	
	for(i=0; i<struPktBodyInfo.nPktNum[0]; i++)
	{	printf("\n************ struct plyEdrGridStru[%d] *****************\n", i);
		PrintStruPlyEdrGrid((plyEdrGridStru*)(pbuff+sizeof(PktBodyInfoStru)
				+i*sizeof(plyEdrGridStru)));
	}

	return ;
}



void PrintBin22123(char* pbuff)
{
	int i;
	PktBodyInfoStru		struPktBodyInfo;

	memcpy(&struPktBodyInfo, pbuff, sizeof(PktBodyInfoStru));
	printf("\n************ struct pktBodyInfoStru *****************\n");
	PrintStruPlyPktBodyInfo(&struPktBodyInfo);

	for(i=0; i<struPktBodyInfo.nPktNum[0]; i++)
	{	printf("\n************ struct plyEdrGridStru[%d] *****************\n", i);
		PrintStruPlyEdrGrid((plyEdrGridStru*)(pbuff+sizeof(PktBodyInfoStru)+i*sizeof(plyEdrGridStru)));
	}
	
	for(i=0; i<struPktBodyInfo.nPktNum[1]; i++)
	{	printf("\n************ struct plyEdrappStru[%d] *****************\n", i);
		PrintStruPlyEdrapp((plyEdrappStru*)(pbuff+sizeof(PktBodyInfoStru)
			+struPktBodyInfo.nPktNum[0]*sizeof(plyEdrGridStru)
			+i*sizeof(plyEdrappStru)));
	}

	for(i=0; i<struPktBodyInfo.nPktNum[2]; i++)
	{	printf("\n************ struct plyEdrappcrgoStru[%d] *****************\n", i);
		PrintStruPlyEdrappcrgo((plyEdrappcrgoStru*)(pbuff+sizeof(PktBodyInfoStru)
			+struPktBodyInfo.nPktNum[0]*sizeof(plyEdrGridStru)
			+struPktBodyInfo.nPktNum[1]*sizeof(plyEdrappStru)
			+i*sizeof(plyEdrappcrgoStru)));
	}

	for(i=0; i<struPktBodyInfo.nPktNum[8]; i++)
	{	printf("\n************ struct plyEdrapprdrStru[%d] *****************\n", i);
		PrintStruPlyEdrapprdr((plyEdrapprdrStru*)(pbuff+sizeof(PktBodyInfoStru)
			+struPktBodyInfo.nPktNum[0]*sizeof(plyEdrGridStru)
			+struPktBodyInfo.nPktNum[1]*sizeof(plyEdrappStru)
			+struPktBodyInfo.nPktNum[2]*sizeof(plyEdrappcrgoStru)
			+i*sizeof(plyEdrapprdrStru)));
	}

	for(i=0; i<struPktBodyInfo.nPktNum[9]; i++)
	{	printf("\n************ struct plyEdrapppayStru[%d] *****************\n", i);
		PrintStruPlyEdrapppay((plyEdrapppayStru*)(pbuff+sizeof(PktBodyInfoStru)
			+struPktBodyInfo.nPktNum[0]*sizeof(plyEdrGridStru)
			+struPktBodyInfo.nPktNum[1]*sizeof(plyEdrappStru)
			+struPktBodyInfo.nPktNum[2]*sizeof(plyEdrappcrgoStru)
			+struPktBodyInfo.nPktNum[8]*sizeof(plyEdrapprdrStru)
			+i*sizeof(plyEdrapppayStru)));
	}

	for(i=0; i<struPktBodyInfo.nPktNum[13]; i++)
	{	printf("\n************ struct plyPlyappNetStru[%d] *****************\n", i);
		PrintStruPlyappNet((plyPlyappNetStru*)(pbuff+sizeof(PktBodyInfoStru)
			+struPktBodyInfo.nPktNum[0]*sizeof(plyEdrGridStru)
			+struPktBodyInfo.nPktNum[1]*sizeof(plyEdrappStru)
			+struPktBodyInfo.nPktNum[2]*sizeof(plyEdrappcrgoStru)
			+struPktBodyInfo.nPktNum[8]*sizeof(plyEdrapprdrStru)
			+struPktBodyInfo.nPktNum[9]*sizeof(plyEdrapppayStru)
			+i*sizeof(plyPlyappNetStru)));
	}

	return ;
}
