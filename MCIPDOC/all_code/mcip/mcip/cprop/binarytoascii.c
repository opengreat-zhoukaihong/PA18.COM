#include "g_globdef.h"

#include "typeconvt.h"
#include "printappbinary.h"

#include "cpkthead.h"
#include "cperclnt.h"
#include "corgclnt.h"
#include "cplybodyinfo.h"
#include "cplyapppolygrid.h"
#include "cplyproposal.h"
#include "cplycheckgrid.h"
#include "toasciiapp.h"
#include "cclmplcyno.h"
#include "cplyedrapp.h"
#include "cplyedrappcrgo.h"
#include "cplyedrapprdr.h"
#include "cplyedrapppay.h"
#include "cplyappnet.h"
#include "cplyedrgrid.h"
#include "cplyproposal.h"

#include "binarytoascii.h"


/*Func: convert binary string to ascii
*
* Input param: 
*			pBinBuff  --> binary string buff 
*			iPktID    --> this packet ID (used this param for Packet ID, Don't use
*								the packet ID in buff, it may be incorrect.)
*
* Output param:
*			ppStringReturn --> the converted ascii string header pointer, 
*							in this function, it's memory will be alloced.
*							Don't malloc memory for the param beyond the function again.
*			plenStr		--> the ascii string length
*
* Return:	
*			0	--> OK
*			<0	--> Failed
* 
*/
int BinaryToAscii(char* pBinBuff, int iPktID, char **ppStringReturn, int* plenStr)
{
	int rtnVal = 0;
	char *pOffsetString;
	int iMemSize = 0;
	PacketHead struPktHead;
	PktBodyInfoStru struPktBodyInfo;

	GetRcvHead(&pBinBuff, &struPktHead);
	if(struPktHead.iPacketID!=iPktID)
	{
		#ifdef _DEBUG
		printf("Warn: struPktHead.iPacketID=%d, it should be [%d]\n", 
					struPktHead.iPacketID, iPktID);
		#endif
	}

	if(struPktHead.cRetCode!=0) 
	{
		iMemSize = sizeof(PacketHead)+MAXLENLEN*MAXFIELDCOUNT+1024;
		pOffsetString = (char*)malloc(iMemSize);
		if(pOffsetString==NULL)
		{
			#ifdef _DEBUG
			printf("malloc memory failed: File:%s, Line:%d\n", __FILE__, __LINE__);
			#endif
			rtnVal = -1;
		}
		else
		{
			*ppStringReturn = pOffsetString;
			StruPKTHeadToStr(&struPktHead, &pOffsetString, plenStr);
			StrToStr(pBinBuff, &pOffsetString, plenStr);
		}
		return rtnVal;
	}




	switch(iPktID)
	{
	case 13003: 
	case 13004:
		iMemSize = sizeof(PacketHead)+sizeof(cltPerClntInfoStru)+MAXLENLEN*MAXFIELDCOUNT*2;
		pOffsetString = (char*)malloc(iMemSize);
		if(pOffsetString==NULL)
		{
			rtnVal = -1;
			break;
		}
		*ppStringReturn = pOffsetString;
		StruPKTHeadToStr(&struPktHead, &pOffsetString, plenStr);
		CltPerClntInfoReturnToStr(&pBinBuff, struPktHead.cRetCode, &pOffsetString, plenStr);
		break;
		
	case 13008:
	case 13009:
		iMemSize = sizeof(PacketHead)+sizeof(cltOrgClntInfoStru)+MAXLENLEN*MAXFIELDCOUNT*2;
		pOffsetString = (char*)malloc(iMemSize);
		if(pOffsetString==NULL)
		{
			rtnVal = -1;
			break;
		}
		*ppStringReturn = pOffsetString;
		StruPKTHeadToStr(&struPktHead, &pOffsetString, plenStr);
		CltOrgClntInfoReturnToStr(&pBinBuff, struPktHead.cRetCode, &pOffsetString, plenStr);
		break;
	
	case 22151:
		iMemSize = sizeof(PacketHead)+sizeof(PktBodyInfoStru)+sizeof(plyAppPolyGridStru)+sizeof(plyProposalStru)+
						MAXLENLEN*MAXFIELDCOUNT*4;
		pOffsetString = (char*)malloc(iMemSize);
		if(pOffsetString==NULL)
		{
			rtnVal = -1;
			break;
		}
		*ppStringReturn = pOffsetString;
		StruPKTHeadToStr(&struPktHead, &pOffsetString, plenStr);
		PlyCplyReturnToStr(&pBinBuff, struPktHead.cRetCode, &pOffsetString, plenStr);
		break;

	case 22114:
		iMemSize = sizeof(PacketHead)+sizeof(plyCheckGridStru)+MAXLENLEN*MAXFIELDCOUNT*2;
		pOffsetString = (char*)malloc(iMemSize);
		if(pOffsetString==NULL)
		{
			rtnVal = -1;
			break;
		}
		*ppStringReturn = pOffsetString;
		StruPKTHeadToStr(&struPktHead, &pOffsetString, plenStr);
		CheckGridReturnToStr(&pBinBuff, struPktHead.cRetCode, &pOffsetString, plenStr);
		break;

	case 22106:
	case 22105:
		iMemSize = sizeof(PacketHead)+MAXLENLEN*MAXFIELDCOUNT;
		pOffsetString = (char*)malloc(iMemSize);
		if(pOffsetString==NULL)
		{
			rtnVal = -1;
			break;
		}
		*ppStringReturn = pOffsetString;
		StruPKTHeadToStr(&struPktHead, &pOffsetString, plenStr);
		AppPolyReturnToStr(&pBinBuff, struPktHead.cRetCode, &pOffsetString, plenStr);

		break;
	case 22126:
		iMemSize = sizeof(PacketHead)+MAXLENLEN*MAXFIELDCOUNT;
		pOffsetString = (char*)malloc(iMemSize);
		if(pOffsetString==NULL)
		{
			rtnVal = -1;
			break;
		}
		*ppStringReturn = pOffsetString;
		StruPKTHeadToStr(&struPktHead, &pOffsetString, plenStr);
		Ply22126ReturnToStr(&pBinBuff, struPktHead.cRetCode, &pOffsetString, plenStr);

		break;
	case 2024:
		iMemSize = sizeof(PacketHead)+sizeof(clmInListChangeStru)+MAXLENLEN*MAXFIELDCOUNT*2;
		pOffsetString = (char*)malloc(iMemSize);
		if(pOffsetString==NULL)
		{
			rtnVal = -1;
			break;
		}
		*ppStringReturn = pOffsetString;
		StruPKTHeadToStr(&struPktHead, &pOffsetString, plenStr);
		ClmPlcyNoReturnToStr(&pBinBuff, struPktHead.cRetCode, &pOffsetString, plenStr);

		break;

	case 22120:
		iMemSize = sizeof(PacketHead)+sizeof(PktBodyInfoStru)
			+sizeof(plyEdrappStru)+sizeof(plyEdrappcrgoStru)
			+sizeof(plyEdrapprdrStru)+sizeof(plyEdrapppayStru)
			+sizeof(plyPlyappNetStru)
			+MAXLENLEN*MAXFIELDCOUNT*7;
		pOffsetString = (char*)malloc(iMemSize);
		if(pOffsetString==NULL)
		{
			rtnVal = -1;
			break;
		}
		*ppStringReturn = pOffsetString;
		StruPKTHeadToStr(&struPktHead, &pOffsetString, plenStr);
		Ply22120ReturnToStr(&pBinBuff, struPktHead.cRetCode, &pOffsetString, plenStr);
		break;
	
	case 22125:     
		memcpy(&struPktBodyInfo, pBinBuff, sizeof(PktBodyInfoStru));
		pBinBuff = pBinBuff + sizeof(PktBodyInfoStru);
	
		iMemSize = sizeof(PacketHead)
			+sizeof(PktBodyInfoStru)
			+sizeof(plyEdrGridStru)*struPktBodyInfo.nPktNum[0]
			+sizeof(plyProposalStru)*struPktBodyInfo.nPktNum[1]
			+MAXLENLEN*MAXFIELDCOUNT*(2+struPktBodyInfo.nPktNum[0]+struPktBodyInfo.nPktNum[1]);
		pOffsetString = (char*)malloc(iMemSize);
		if(pOffsetString==NULL)
		{
			rtnVal = -1;
			break;
		}
		*ppStringReturn = pOffsetString;
		StruPKTHeadToStr(&struPktHead, &pOffsetString, plenStr);
		StruPlyPktBodyInfoToStr(&struPktBodyInfo, &pOffsetString, plenStr);
		Ply22125ReturnToStr(&pBinBuff, struPktHead.cRetCode, &pOffsetString, plenStr, &struPktBodyInfo);
		break;

	case 22128:
		memcpy(&struPktBodyInfo, pBinBuff, sizeof(PktBodyInfoStru));
		pBinBuff = pBinBuff + sizeof(PktBodyInfoStru);
	
		iMemSize = sizeof(PacketHead)
			+sizeof(PktBodyInfoStru)
			+sizeof(plyEdrGridStru)*struPktBodyInfo.nPktNum[0]
			+MAXLENLEN*MAXFIELDCOUNT*(2+struPktBodyInfo.nPktNum[0]);
		pOffsetString = (char*)malloc(iMemSize);
		if(pOffsetString==NULL)
		{
			rtnVal = -1;
			break;
		}
		*ppStringReturn = pOffsetString;
		StruPKTHeadToStr(&struPktHead, &pOffsetString, plenStr);
		StruPlyPktBodyInfoToStr(&struPktBodyInfo, &pOffsetString, plenStr);
		Ply22128ReturnToStr(&pBinBuff, struPktHead.cRetCode, &pOffsetString, plenStr, &struPktBodyInfo);
		break;

	case 22123:
		memcpy(&struPktBodyInfo, pBinBuff, sizeof(PktBodyInfoStru));
		pBinBuff = pBinBuff + sizeof(PktBodyInfoStru);
	
		iMemSize = sizeof(PacketHead)+
					sizeof(PktBodyInfoStru)+
					sizeof(plyEdrGridStru)*struPktBodyInfo.nPktNum[0]+
					sizeof(plyEdrappStru)*struPktBodyInfo.nPktNum[1]+
					sizeof(plyEdrappcrgoStru)*struPktBodyInfo.nPktNum[2]+
					sizeof(plyEdrapprdrStru)*struPktBodyInfo.nPktNum[8]+
					sizeof(plyEdrapppayStru)*struPktBodyInfo.nPktNum[9]+
					sizeof(plyPlyappNetStru)*struPktBodyInfo.nPktNum[13]+
					+MAXLENLEN*MAXFIELDCOUNT*(2+struPktBodyInfo.nPktNum[0]
												+struPktBodyInfo.nPktNum[1]
												+struPktBodyInfo.nPktNum[2]
												+struPktBodyInfo.nPktNum[8]
												+struPktBodyInfo.nPktNum[9]
												+struPktBodyInfo.nPktNum[13]);
		printf("Start to resolve...\n");
		printf("total size of %d\n", iMemSize);
				
		pOffsetString = (char*)malloc(iMemSize);
		if(pOffsetString==NULL)
		{
			rtnVal = -1;
			break;
		}
		*ppStringReturn = pOffsetString;
		StruPKTHeadToStr(&struPktHead, &pOffsetString, plenStr);
		StruPlyPktBodyInfoToStr(&struPktBodyInfo, &pOffsetString, plenStr);

		printf("struPktBodyInfo.nPktNum[0]:%d\n",struPktBodyInfo.nPktNum[0]);
		printf("struPktBodyInfo.nPktNum[1]:%d\n",struPktBodyInfo.nPktNum[1]);
		printf("struPktBodyInfo.nPktNum[2]:%d\n",struPktBodyInfo.nPktNum[2]);
		printf("struPktBodyInfo.nPktNum[8]:%d\n",struPktBodyInfo.nPktNum[8]);
		printf("struPktBodyInfo.nPktNum[9]:%d\n",struPktBodyInfo.nPktNum[9]);
		printf("struPktBodyInfo.nPktNum[13]:%d\n",struPktBodyInfo.nPktNum[13]);

		Ply22123ReturnToStr(&pBinBuff, struPktHead.cRetCode, &pOffsetString, plenStr, &struPktBodyInfo);

		printf("END OF RESOLOVE 22123....................\n");
		break;

/* add by joe qiao 2001/11/23  begin  this case is specieal to other case. it just olay one string to be send and receive, so it process is different than others*/
	case 22660:
	case 22669:
		iMemSize = sizeof(PacketHead)+struPktHead.lPacketSize+MAXLENLEN*MAXFIELDCOUNT*2;
		pOffsetString = (char*)malloc(iMemSize);
		if(pOffsetString==NULL)
		{
			rtnVal = -1;
			break;
		}
		*ppStringReturn = pOffsetString;
		StruPKTHeadToStr(&struPktHead, &pOffsetString, plenStr);
		StrToStr(pBinBuff    , &pOffsetString,  plenStr);

		break;
		
/* add by joe qiao end */


	default:
		#ifdef _DEBUG
		printf("---->Unknow package: id=%d\n", struPktHead.iPacketID);
		#endif

		rtnVal = -2;
		break;
	}
	
	

	return rtnVal;
}




/*After receive from the server, byte order should be converted, 
* type with only one byte , such as 'char', is not need to convert.
*/
int AfterRcvOrderConvt(char* pBinBuff, int iPktID)
{
	int i;
	PacketHead struPktHead;
	PktBodyInfoStru		struPktBodyInfo;

	GetRcvHead(&pBinBuff, &struPktHead);
	if(struPktHead.cRetCode!=0) return 0;

/*	switch(struPktHead.iPacketID)*/
	switch(iPktID)
	{
	case 13003: 
	case 13004:
		struCltPerClntInfoOrderConvt(pBinBuff);
		break;
		
	case 13008:
	case 13009:
		struCltOrgClntInfoOrderConvt(pBinBuff);
		break;
	
	case 22151:
		struPktBodyInfoOrderConvt(pBinBuff); 
		memcpy(&struPktBodyInfo, pBinBuff, sizeof(PktBodyInfoStru));
		/*for(i=0; i<struPktBodyInfo.nPktNum[0]; i++)*/
		for(i=0; i<1; i++)
			struAppPolyGridOrderConvt(pBinBuff+sizeof(PktBodyInfoStru)+i*sizeof(plyAppPolyGridStru));
		/*for(i=0; i<struPktBodyInfo.nPktNum[1]; i++)*/
		for(i=0; i<1; i++)
			struProposalOrderConvt(pBinBuff+sizeof(PktBodyInfoStru)
								+struPktBodyInfo.nPktNum[0]*sizeof(plyAppPolyGridStru)
								+i*sizeof(plyProposalStru));
		break;

	case 22114:
		struPlyCheckGridOrderConvt(pBinBuff);
		break;

	case 22106:
	case 22105:
	case 22126:
		break;

	case 2024:
		struClmPlcyNoOrderConvt(pBinBuff);
		break;

	case 22120:
		struPktBodyInfoOrderConvt(pBinBuff); 
		memcpy(&struPktBodyInfo, pBinBuff, sizeof(PktBodyInfoStru));
		for(i=0; i<struPktBodyInfo.nPktNum[0]; i++)
			struPlyEdrappOrderConvt(pBinBuff+sizeof(PktBodyInfoStru)+i*sizeof(plyEdrappStru));

		for(i=0; i<struPktBodyInfo.nPktNum[1]; i++)
			struPlyEdrappcrgoOrderConvt(pBinBuff+sizeof(PktBodyInfoStru)
				+struPktBodyInfo.nPktNum[0]*sizeof(plyEdrappStru)
				+i*sizeof(plyEdrappcrgoStru));

		for(i=0; i<struPktBodyInfo.nPktNum[7]; i++)
			struPlyEdrapprdrOrderConvt(pBinBuff+sizeof(PktBodyInfoStru)
				+struPktBodyInfo.nPktNum[0]*sizeof(plyEdrappStru)
				+struPktBodyInfo.nPktNum[1]*sizeof(plyEdrappcrgoStru)
				+i*sizeof(plyEdrapprdrStru));

		for(i=0; i<struPktBodyInfo.nPktNum[8]; i++)
			struPlyEdrapppayOrderConvt(pBinBuff+sizeof(PktBodyInfoStru)
				+struPktBodyInfo.nPktNum[0]*sizeof(plyEdrappStru)
				+struPktBodyInfo.nPktNum[1]*sizeof(plyEdrappcrgoStru)
				+struPktBodyInfo.nPktNum[7]*sizeof(plyEdrapprdrStru)
				+i*sizeof(plyEdrapppayStru));

		for(i=0; i<struPktBodyInfo.nPktNum[12]; i++)
			struPlyappNetOrderConvt(pBinBuff+sizeof(PktBodyInfoStru)
				+struPktBodyInfo.nPktNum[0]*sizeof(plyEdrappStru)
				+struPktBodyInfo.nPktNum[1]*sizeof(plyEdrappcrgoStru)
				+struPktBodyInfo.nPktNum[7]*sizeof(plyEdrapprdrStru)
				+struPktBodyInfo.nPktNum[8]*sizeof(plyEdrapppayStru)
				+i*sizeof(plyPlyappNetStru));
		break;

	
	case 22125:     //PktBodyInfoStru+ plyEdrGridStru + plyProposalStru
		struPktBodyInfoOrderConvt(pBinBuff); 
		memcpy(&struPktBodyInfo, pBinBuff, sizeof(PktBodyInfoStru));
		printf("22125-------------struPktBodyInfo.nPktNum[0]=%d\n",struPktBodyInfo.nPktNum[0]);
		for(i=0; i<struPktBodyInfo.nPktNum[0]; i++)
			struPlyEdrGridOrderConvt(pBinBuff+sizeof(PktBodyInfoStru)
						+i*sizeof(plyEdrGridStru));
        printf("22125-------------struPktBodyInfo.nPktNum[1]=%d\n",struPktBodyInfo.nPktNum[1]);
		for(i=0; i<struPktBodyInfo.nPktNum[1]; i++)
			struProposalOrderConvt(pBinBuff+sizeof(PktBodyInfoStru)
					+struPktBodyInfo.nPktNum[0]*sizeof(plyEdrGridStru)
					+i*sizeof(plyProposalStru));
		break;


	case 22128:     //PktBodyInfoStru+ plyEdrGridStru
		struPktBodyInfoOrderConvt(pBinBuff); 
		memcpy(&struPktBodyInfo, pBinBuff, sizeof(PktBodyInfoStru));
		for(i=0; i<struPktBodyInfo.nPktNum[0]; i++)
			struPlyEdrGridOrderConvt(pBinBuff+sizeof(PktBodyInfoStru)
						+i*sizeof(plyEdrGridStru));
		break;

	case 22123:
		struPktBodyInfoOrderConvt(pBinBuff); 
		memcpy(&struPktBodyInfo, pBinBuff, sizeof(PktBodyInfoStru));
		for(i=0; i<struPktBodyInfo.nPktNum[0]; i++)
			struPlyEdrGridOrderConvt(pBinBuff+sizeof(PktBodyInfoStru)
							+i*sizeof(plyEdrGridStru));

		for(i=0; i<struPktBodyInfo.nPktNum[1]; i++)
			struPlyEdrappOrderConvt(pBinBuff+sizeof(PktBodyInfoStru)
							+struPktBodyInfo.nPktNum[0]*sizeof(plyEdrGridStru)
							+i*sizeof(plyEdrappStru));

		for(i=0; i<struPktBodyInfo.nPktNum[2]; i++)
			struPlyEdrappcrgoOrderConvt(pBinBuff+sizeof(PktBodyInfoStru)
							+struPktBodyInfo.nPktNum[0]*sizeof(plyEdrGridStru)
							+struPktBodyInfo.nPktNum[1]*sizeof(plyEdrappStru)
							+i*sizeof(plyEdrappcrgoStru));

		for(i=0; i<struPktBodyInfo.nPktNum[8]; i++)
			struPlyEdrapprdrOrderConvt(pBinBuff+sizeof(PktBodyInfoStru)
				+struPktBodyInfo.nPktNum[0]*sizeof(plyEdrappStru)
				+struPktBodyInfo.nPktNum[1]*sizeof(plyEdrappcrgoStru)
				+i*sizeof(plyEdrapprdrStru));

		for(i=0; i<struPktBodyInfo.nPktNum[9]; i++)
			struPlyEdrapppayOrderConvt(pBinBuff+sizeof(PktBodyInfoStru)
				+struPktBodyInfo.nPktNum[0]*sizeof(plyEdrGridStru)
				+struPktBodyInfo.nPktNum[1]*sizeof(plyEdrappStru)
				+struPktBodyInfo.nPktNum[2]*sizeof(plyEdrappcrgoStru)
				+struPktBodyInfo.nPktNum[8]*sizeof(plyEdrapprdrStru)
				+i*sizeof(plyEdrapppayStru));

		for(i=0; i<struPktBodyInfo.nPktNum[13]; i++)
			struPlyappNetOrderConvt(pBinBuff+sizeof(PktBodyInfoStru)
				+struPktBodyInfo.nPktNum[0]*sizeof(plyEdrGridStru)
				+struPktBodyInfo.nPktNum[1]*sizeof(plyEdrappStru)
				+struPktBodyInfo.nPktNum[2]*sizeof(plyEdrappcrgoStru)
				+struPktBodyInfo.nPktNum[8]*sizeof(plyEdrapprdrStru)
				+struPktBodyInfo.nPktNum[9]*sizeof(plyEdrapppayStru)
				+i*sizeof(plyPlyappNetStru));
		break;

	default:
		break;
	}

	return 0;
}



/* Print each structure content on screen.
* It is used only for debug 
*/
void PrintReplyBinPkt(char* pbuff, int iPktID)
{
	PacketHead	struPktHead;


	GetRcvHead(&pbuff, &struPktHead);
	printf("\n********************* struPktHead **********************\n");
	PrintStruPKTHead(&struPktHead);
	if(struPktHead.cRetCode!=0)
	{
		printf("Error Messag[%d]: %s\n", struPktHead.cRetCode, pbuff);
		return ;
	}


/*	switch(struPktHead.iPacketID)*/
	switch(iPktID)
	{
	case 13003: 
	case 13004:
		PrintBinPerCltBuff(pbuff);

		break;

	case 13008:
	case 13009:
		PrintBinOrgCltBuff(pbuff);

		break;

	case 22151:
		PrintBinAppPlyBuff(pbuff);
		break;

	case 22114:
		PrintBinCheckGrid(pbuff);
		break;

	case 22106:
	case 22105:
		/*PrintBinPolyGrid(pbuff);*/
		break;

	case 2024:
		PrintBinClmPlcyNo(pbuff);
		break;

	case 22120:
		PrintBin22120(pbuff);
		break;

	case 22125:     
		PrintBin22125(pbuff);
		break;

	case 22128:     
		PrintBin22128(pbuff);
		break;

	case 22123:     
		PrintBin22123(pbuff);
		break;

	default:
		break;
	}

	return ;
}









