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
#include "cplygetdoc.h"
#include "cplyedrapp.h"
#include "cplyedrappcrgo.h"
#include "cplyedrapprdr.h"
#include "cplyedrapppay.h"
#include "cplyappnet.h"
#include "cplyedrgrid.h"

#include "printappascii.h"




void PrintPerCltBuff(char *pbuff)
{
	PacketHead struPktHead;
	cltPerClntInfoStru struCltPerClntInfo;

	memcpy(&struPktHead, pbuff, sizeof(PacketHead));
	memcpy(&struCltPerClntInfo, pbuff + sizeof(PacketHead), sizeof(cltPerClntInfoStru));

	printf("\n********************* struPktHead **********************\n");
	PrintStruPKTHead(&struPktHead);
	printf("\n *********** struct cltPerClntInfoStru *****************\n");
	PrintStruCltPerClntInfo(&struCltPerClntInfo);
}



void PrintOrgCltBuff(char *pbuff)
{
	PacketHead struPktHead;
	cltOrgClntInfoStru struCltOrgClntInfo;

	memcpy(&struPktHead, pbuff, sizeof(PacketHead));
	memcpy(&struCltOrgClntInfo, pbuff + sizeof(PacketHead), sizeof(cltOrgClntInfoStru));

	printf("\n********************* struPktHead **********************\n");
	PrintStruPKTHead(&struPktHead);
	printf("\n *********** struct cltOrgClntInfoStru *****************\n");
	PrintStruCltOrgClntInfo(&struCltOrgClntInfo);
}



void PrintPlyAppBuff(char *pbuff)
{
	int i;
	PacketHead struPktHead;
	PktBodyInfoStru  struBodyInfo;
	plyAppPolyGridStru  struPolyGrid;
	plyAppPolicyStru  struPolicy;
	plyGoTgtStru struGoTgt;
	plyRdrStru  struRdr;
	plyPayStru  struPay;
	plyPlyappNetStru struPlyappNet;



	memcpy(&struPktHead, pbuff, sizeof(PacketHead));
	printf("\n********************* struPktHead **********************\n");
	PrintStruPKTHead(&struPktHead);


	memcpy(&struBodyInfo, pbuff + sizeof(PacketHead), sizeof(PktBodyInfoStru));
	printf("\n********************* struct PktBodyInfoStru ***********\n");
	PrintStruPlyPktBodyInfo(&struBodyInfo);


	memcpy(&struPolyGrid, pbuff+sizeof(PacketHead)+sizeof(PktBodyInfoStru), sizeof(plyAppPolyGridStru));
	printf("\n********************* struct plyAppPolyGridStru ***********\n");
	PrintStruAppPolyGrid(&struPolyGrid);


	memcpy(&struPolicy, pbuff+sizeof(PacketHead)+sizeof(PktBodyInfoStru)+sizeof(plyAppPolyGridStru), sizeof(struPolicy));
	printf("\n********************* struct plyAppPolicyStru ***********\n");
	PrintStruAppPolicy(&struPolicy);


	memcpy(&struGoTgt, pbuff+sizeof(PacketHead)+sizeof(PktBodyInfoStru)+sizeof(plyAppPolyGridStru)+sizeof(struPolicy),
	sizeof(plyGoTgtStru));
	printf("\n********************* struct plyGoTgtStru ***********\n");
	PrintStruGoTgt(&struGoTgt);




	for(i=0; i<struBodyInfo.nPktNum[8]; i++)
	{
		memcpy(&struRdr, pbuff+sizeof(PacketHead)+sizeof(PktBodyInfoStru)+sizeof(plyAppPolyGridStru)+
		sizeof(struPolicy)+sizeof(plyGoTgtStru)+ i*sizeof(plyRdrStru), sizeof(plyRdrStru));

		printf("\n********************* struct plyRdrStru[%d] ********\n", i);
		PrintStruRdr(&struRdr);
	}

	memcpy(&struPay, pbuff+sizeof(PacketHead)+sizeof(PktBodyInfoStru)+sizeof(plyAppPolyGridStru)+
	sizeof(struPolicy)+sizeof(plyGoTgtStru)+struBodyInfo.nPktNum[8]*sizeof(plyRdrStru), sizeof(plyPayStru));
	printf("\n********************* struct plyPayStru  ********\n");
	PrintStruPay(&struPay);


	memcpy(&struPlyappNet, pbuff+sizeof(PacketHead)+sizeof(PktBodyInfoStru)+sizeof(plyAppPolyGridStru)+
	sizeof(struPolicy)+sizeof(plyGoTgtStru)+struBodyInfo.nPktNum[8]*sizeof(plyRdrStru)+sizeof(plyPayStru),
	sizeof(plyPlyappNetStru));
	printf("\n********************* struct plyPlyappNetStru  ********\n");
	PrintStruPlyappNet(&struPlyappNet);

	return ;
}


void PrintCheckGridBuff(char *pbuff)
{
	PacketHead struPktHead;
	PktBodyInfoStru  struBodyInfo;
	plyCheckGridStru struPlyCheckGrid;


	memcpy(&struPktHead, pbuff, sizeof(PacketHead));
	printf("\n********************* struPktHead **********************\n");
	PrintStruPKTHead(&struPktHead);


	memcpy(&struBodyInfo, pbuff + sizeof(PacketHead), sizeof(PktBodyInfoStru));
	printf("\n********************* struct PktBodyInfoStru ***********\n");
	PrintStruPlyPktBodyInfo(&struBodyInfo);


	memcpy(&struPlyCheckGrid, pbuff+sizeof(PacketHead)+sizeof(PktBodyInfoStru), sizeof(plyCheckGridStru));
	printf("\n********************* struct plyCheckGridStru ***********\n");
	PrintStruCheckGrid(&struPlyCheckGrid);

	return ;
}



void PrintPolyGridBuff(char* pbuff)
{
	PacketHead struPktHead;
	PktBodyInfoStru  struBodyInfo;
	plyAppPolyGridStru struAppPolyGrid;


	memcpy(&struPktHead, pbuff, sizeof(PacketHead));
	printf("\n********************* struPktHead **********************\n");
	PrintStruPKTHead(&struPktHead);


	memcpy(&struBodyInfo, pbuff + sizeof(PacketHead), sizeof(PktBodyInfoStru));
	printf("\n********************* struct PktBodyInfoStru ***********\n");
	PrintStruPlyPktBodyInfo(&struBodyInfo);


	memcpy(&struAppPolyGrid, pbuff+sizeof(PacketHead)+sizeof(PktBodyInfoStru), sizeof(plyAppPolyGridStru));
	printf("\n********************* struct plyAppPolyGridStru ***********\n");
	PrintStruAppPolyGrid(&struAppPolyGrid);

	return ;
}


void PrintClmInListChangeBuff(char *pbuff)
{
	PacketHead struPktHead;
	clmInListChangeStru struClmInListChange;

	memcpy(&struPktHead, pbuff, sizeof(PacketHead));
	memcpy(&struClmInListChange, pbuff + sizeof(PacketHead), sizeof(clmInListChangeStru));

	printf("\n********************* struPktHead **********************\n");
	PrintStruPKTHead(&struPktHead);
	printf("\n *********** struct clmInListChangeStru *****************\n");
	PrintStruClmInListChange(&struClmInListChange);
}


void PrintPlyGetDocBuff(char *pbuff)
{
	PacketHead struPktHead;
	plyGetDocStru struPlyGetDoc;

	memcpy(&struPktHead, pbuff, sizeof(PacketHead));
	memcpy(&struPlyGetDoc, pbuff + sizeof(PacketHead), sizeof(plyGetDocStru));

	printf("\n********************* struPktHead **********************\n");
	PrintStruPKTHead(&struPktHead);
	printf("\n *********** struct plyGetDocStru *****************\n");
	PrintStruPlyGetDoc(&struPlyGetDoc);
}




void PrintAscii22125(char *pbuff)
{
	int i;
	PacketHead struPktHead;
	PktBodyInfoStru  struPktBodyInfo;

	memcpy(&struPktHead, pbuff, sizeof(PacketHead));
	printf("\n********************* struPktHead **********************\n");
	PrintStruPKTHead(&struPktHead);


	memcpy(&struPktBodyInfo, pbuff + sizeof(PacketHead), sizeof(PktBodyInfoStru));
	printf("\n********************* struct PktBodyInfoStru ***********\n");
	PrintStruPlyPktBodyInfo(&struPktBodyInfo);

	for(i=0; i<struPktBodyInfo.nPktNum[0]; i++)
		PrintStruPlyEdrGrid((plyEdrGridStru*)(pbuff+sizeof(PacketHead)+sizeof(PktBodyInfoStru)
				+i*sizeof(plyEdrGridStru)));

	for(i=0; i<struPktBodyInfo.nPktNum[1]; i++)
		PrintStruPlyEdrapp((plyEdrappStru*)(pbuff+sizeof(PacketHead)+sizeof(PktBodyInfoStru)
				+struPktBodyInfo.nPktNum[0]*sizeof(plyEdrGridStru)
				+i*sizeof(plyEdrappStru)));

	for(i=0; i<struPktBodyInfo.nPktNum[2]; i++)
		PrintStruPlyEdrappcrgo((plyEdrappcrgoStru*)(pbuff+sizeof(PacketHead)+sizeof(PktBodyInfoStru)
			+struPktBodyInfo.nPktNum[0]*sizeof(plyEdrGridStru)
			+struPktBodyInfo.nPktNum[1]*sizeof(plyEdrappStru)
			+i*sizeof(plyEdrappcrgoStru)));

	for(i=0; i<struPktBodyInfo.nPktNum[8]; i++)
		PrintStruPlyEdrapprdr((plyEdrapprdrStru*)(pbuff+sizeof(PacketHead)+sizeof(PktBodyInfoStru)
			+struPktBodyInfo.nPktNum[0]*sizeof(plyEdrGridStru)
			+struPktBodyInfo.nPktNum[1]*sizeof(plyEdrappStru)
			+struPktBodyInfo.nPktNum[2]*sizeof(plyEdrappcrgoStru)
			+i*sizeof(plyEdrapprdrStru)));

	for(i=0; i<struPktBodyInfo.nPktNum[9]; i++)
		PrintStruPlyEdrapppay((plyEdrapppayStru*)(pbuff+sizeof(PacketHead)+sizeof(PktBodyInfoStru)
			+struPktBodyInfo.nPktNum[0]*sizeof(plyEdrGridStru)
			+struPktBodyInfo.nPktNum[1]*sizeof(plyEdrappStru)
			+struPktBodyInfo.nPktNum[2]*sizeof(plyEdrappcrgoStru)
			+struPktBodyInfo.nPktNum[8]*sizeof(plyEdrapprdrStru)
			+i*sizeof(plyEdrapppayStru)));

	for(i=0; i<struPktBodyInfo.nPktNum[13]; i++)
		PrintStruPlyappNet((plyPlyappNetStru*)(pbuff+sizeof(PacketHead)+sizeof(PktBodyInfoStru)
			+struPktBodyInfo.nPktNum[0]*sizeof(plyEdrGridStru)
			+struPktBodyInfo.nPktNum[1]*sizeof(plyEdrappStru)
			+struPktBodyInfo.nPktNum[2]*sizeof(plyEdrappcrgoStru)
			+struPktBodyInfo.nPktNum[8]*sizeof(plyEdrapprdrStru)
			+struPktBodyInfo.nPktNum[9]*sizeof(plyEdrapppayStru)
			+i*sizeof(plyPlyappNetStru)));

	return ;
}



void PrintAscii22128(char *pbuff)
{
	int i;
	PacketHead struPktHead;
	PktBodyInfoStru  struPktBodyInfo;

	memcpy(&struPktHead, pbuff, sizeof(PacketHead));
	printf("\n********************* struPktHead **********************\n");
	PrintStruPKTHead(&struPktHead);


	memcpy(&struPktBodyInfo, pbuff + sizeof(PacketHead), sizeof(PktBodyInfoStru));
	printf("\n********************* struct PktBodyInfoStru ***********\n");
	PrintStruPlyPktBodyInfo(&struPktBodyInfo);


	for(i=0; i<struPktBodyInfo.nPktNum[0]; i++)
	{
		printf("\n********************* struct plyEdrGridStru[%d] ***********\n", i);
		PrintStruPlyEdrGrid((plyEdrGridStru*)(pbuff+sizeof(PacketHead)+sizeof(PktBodyInfoStru)
				+sizeof(plyEdrGridStru)*i));
	}


	return ;
}
