#include "g_globdef.h"

#include "printappascii.h"

#include "cpkthead.h"
#include "cperclnt.h"
#include "corgclnt.h"
#include "cplybodyinfo.h"
#include "cplyapppolygrid.h"
#include "cplyapppolicy.h"
#include "cplygotgt.h"
#include "cplyrdr.h"
#include "cplypay.h"
#include "cplyappnet.h"
#include "cplycheckgrid.h"
#include "cclminlistchange.h"
#include "tobinaryapp.h"
#include "cplygetdoc.h"
#include "cplyedrapp.h"
#include "cplyedrappcrgo.h"
#include "cplyedrapprdr.h"
#include "cplyedrapppay.h"
#include "cplyappnet.h"
#include "cplyedrgrid.h"
#include "asciitobinary.h"



/*Func: convert ascii string to binary
*
* Input param: 
*			inbuff  --> ascii string buff 
*			ilenStr --> ascii string length
*
* Output param:
*			ppBuffSend --> the converted binary header pointer, 
*							in this function, it's memory will be alloced.
*							Don't malloc memory for the param beyond the function again.
*			piPktID    --> this packet ID
*
* Return:	
*			0	--> OK
*			<0	--> Failed
* 
*/
int AsciiToBinary(char* inbuff, int ilenStr, char** ppBuffSend, int *piPktID)
{
	int rtnVal = 0;
	PacketHead struPktHead;
	cltPerClntInfoStru struCltPerClntInfo;
	cltOrgClntInfoStru struCltOrgClntInfo;
	PktBodyInfoStru struPktBodyInfo;
	clmInListChangeStru struClmInListChange;
	plyGetDocStru struPlyGetDoc;
	int iMemSize = 0;


    memset(&struPktHead, 0, sizeof(PacketHead));
	rtnVal = StrToStruPKTHead(&inbuff, &ilenStr, &struPktHead);
	if(rtnVal!=0)
	{
		#ifdef _DEBUG
		printf("StrToStruPKTHead return =%d\n", rtnVal);
		#endif
		return -1;
	}
	*piPktID = struPktHead.iPacketID;
	
	switch(struPktHead.iPacketID)
	{
	case 13003: 
	case 13004:
		memset(&struCltPerClntInfo, 0, sizeof(cltPerClntInfoStru));
		iMemSize = sizeof(PacketHead)+sizeof(cltPerClntInfoStru)*struPktHead.iRecordNum;
		*ppBuffSend = (char*)malloc(iMemSize);
		struPktHead.lPacketSize = sizeof(PacketHead)+sizeof(cltPerClntInfoStru)*struPktHead.iRecordNum;
		struPktHead.iRecordSize = sizeof(cltPerClntInfoStru);
	    rtnVal = StrToStruCltPerClntInfo(&inbuff, &ilenStr, &struCltPerClntInfo);
		if(rtnVal!=0)
		{	
			#ifdef _DEBUG
		    printf("StrToStruCltPerClntInfo return = %d\n", rtnVal);
			#endif
			rtnVal = -3;
			break;
		}
		if(*ppBuffSend==NULL)
		{	rtnVal = -4;
			break;
		}
		memcpy(*ppBuffSend, &struPktHead, sizeof(PacketHead));
		memcpy(*ppBuffSend + sizeof(PacketHead), &struCltPerClntInfo, sizeof(cltPerClntInfoStru));

		break;
	case 13008:
	case 13009:
		memset(&struCltOrgClntInfo, 0, sizeof(cltOrgClntInfoStru));
		iMemSize = sizeof(PacketHead)+sizeof(cltOrgClntInfoStru)*struPktHead.iRecordNum;
		*ppBuffSend = (char*)malloc(iMemSize);
		struPktHead.lPacketSize = sizeof(PacketHead)+sizeof(cltOrgClntInfoStru)*struPktHead.iRecordNum;
		struPktHead.iRecordSize = sizeof(cltOrgClntInfoStru);
	    rtnVal = StrToStruCltOrgClntInfo(&inbuff, &ilenStr, &struCltOrgClntInfo);
		if(rtnVal!=0)
		{	
			#ifdef _DEBUG
		    printf("StrToStruCltOrgClntInfo return = %d\n", rtnVal);
			#endif
			rtnVal = -3;
			break;
		}
		if(*ppBuffSend==NULL)
		{	rtnVal = -4;
			break;
		}
		memcpy(*ppBuffSend, &struPktHead, sizeof(PacketHead));
		memcpy(*ppBuffSend + sizeof(PacketHead), &struCltOrgClntInfo, sizeof(cltOrgClntInfoStru));
		break;

	case 22151:
		memset(&struPktBodyInfo, 0, sizeof(PktBodyInfoStru));
		rtnVal = StrToStruPlyPktBodyInfo(&inbuff, &ilenStr, &struPktBodyInfo);
		if(rtnVal!=0)
		{
			#ifdef _DEBUG
			printf("StrToStruPlyPktBodyInfo return = %d\n", rtnVal);
			#endif
			rtnVal = -5;
			break;
		}
		iMemSize = sizeof(PacketHead)+
					sizeof(PktBodyInfoStru)+
					sizeof(plyAppPolyGridStru)+
					sizeof(plyAppPolicyStru)+
					sizeof(plyGoTgtStru)+
					sizeof(plyRdrStru)*(struPktBodyInfo.nPktNum[8])+
					sizeof(plyPayStru)+
					sizeof(plyPlyappNetStru);
		*ppBuffSend = (char*)malloc(iMemSize);
		if((*ppBuffSend)==NULL)
		{
			#ifdef _DEBUG
			printf("malloc failed: File(%s), Line(%d)\n", __FILE__, __LINE__);
			#endif
			rtnVal = -6;
			break;
		}
		struPktHead.lPacketSize = iMemSize;
		struPktHead.iRecordSize = iMemSize - sizeof(PacketHead);

		memcpy(*ppBuffSend, &struPktHead, sizeof(PacketHead));
		memcpy(*ppBuffSend+sizeof(PacketHead), &struPktBodyInfo, sizeof(PktBodyInfoStru));
		rtnVal = StrToPlyApp(&inbuff, &ilenStr, *ppBuffSend+sizeof(PacketHead)+sizeof(PktBodyInfoStru), 
							&struPktBodyInfo);
		if(rtnVal!=0)
		{
			#ifdef _DEBUG
			printf("StrToPlyApp return = %d\n", rtnVal);
			#endif
			rtnVal = -7;
			break;
		}
		break;

	case 22114:
		iMemSize = sizeof(PacketHead)+
					sizeof(PktBodyInfoStru)+
					sizeof(plyCheckGridStru);
		*ppBuffSend = (char*)malloc(iMemSize);
		if((*ppBuffSend)==NULL)
		{
			#ifdef _DEBUG
			printf("malloc failed: File(%s), Line(%d)\n", __FILE__, __LINE__);
			#endif
			rtnVal = -8;
			break;
		}
		struPktHead.lPacketSize = iMemSize;
		struPktHead.iRecordSize = iMemSize - sizeof(PacketHead);

		memcpy(*ppBuffSend, &struPktHead, sizeof(PacketHead));
		rtnVal = StrToCheckApp(&inbuff, &ilenStr, *ppBuffSend+sizeof(PacketHead));
		if(rtnVal!=0)
		{
			#ifdef _DEBUG
			printf("StrToCheckApp return = %d\n", rtnVal);
			#endif
			rtnVal = -9;
			break;
		}
		break;

	case 22106:
	case 22105:
		iMemSize = sizeof(PacketHead)+
					sizeof(PktBodyInfoStru)+
					sizeof(plyAppPolyGridStru);
		*ppBuffSend = (char*)malloc(iMemSize);
		if((*ppBuffSend)==NULL)
		{
			#ifdef _DEBUG
			printf("malloc failed: File(%s), Line(%d)\n", __FILE__, __LINE__);
			#endif
			rtnVal = -9;
			break;
		}
		struPktHead.lPacketSize = iMemSize;
		struPktHead.iRecordSize = iMemSize - sizeof(PacketHead);

		memcpy(*ppBuffSend, &struPktHead, sizeof(PacketHead));
		rtnVal = StrToPolyGridApp(&inbuff, &ilenStr, *ppBuffSend+sizeof(PacketHead));
		if(rtnVal!=0)
		{
			#ifdef _DEBUG
			printf("StrToCheckApp return = %d\n", rtnVal);
			#endif
			rtnVal = -10;
			break;
		}
		break;

	case 2024:
		memset(&struClmInListChange, 0, sizeof(clmInListChangeStru));
		iMemSize = sizeof(PacketHead)+sizeof(clmInListChangeStru)*struPktHead.iRecordNum;
		*ppBuffSend = (char*)malloc(iMemSize);
		struPktHead.lPacketSize = sizeof(PacketHead)+sizeof(clmInListChangeStru)*struPktHead.iRecordNum;
		struPktHead.iRecordSize = sizeof(clmInListChangeStru);
	    rtnVal = StrToStruClmInListChange(&inbuff, &ilenStr, &struClmInListChange);
		if(rtnVal!=0)
		{	
			#ifdef _DEBUG
		    printf("StrToStruClmInListChange return = %d\n", rtnVal);
			#endif
			rtnVal = -3;
			break;
		}
		if(*ppBuffSend==NULL)
		{	rtnVal = -4;
			break;
		}
		memcpy(*ppBuffSend, &struPktHead, sizeof(PacketHead));
		memcpy(*ppBuffSend + sizeof(PacketHead), &struClmInListChange, sizeof(clmInListChangeStru));
		break;

	case 22120:
		memset(&struPlyGetDoc, 0, sizeof(plyGetDocStru));
		iMemSize = sizeof(PacketHead)+sizeof(plyGetDocStru)*struPktHead.iRecordNum;
		*ppBuffSend = (char*)malloc(iMemSize);
		struPktHead.lPacketSize = sizeof(PacketHead)+sizeof(plyGetDocStru)*struPktHead.iRecordNum;
		struPktHead.iRecordSize = sizeof(plyGetDocStru);
	    rtnVal = StrToStruPlyGetDoc(&inbuff, &ilenStr, &struPlyGetDoc);
		if(rtnVal!=0)
		{	
			#ifdef _DEBUG
		    printf("StrToStruPlyGetDoc return = %d\n", rtnVal);
			#endif
			rtnVal = -3;
			break;
		}
		if(*ppBuffSend==NULL)
		{	rtnVal = -4;
			break;
		}
		memcpy(*ppBuffSend, &struPktHead, sizeof(PacketHead));
		memcpy(*ppBuffSend + sizeof(PacketHead), &struPlyGetDoc, sizeof(plyGetDocStru));
		break;

	case 22125:
		memset(&struPktBodyInfo, 0, sizeof(PktBodyInfoStru));
		rtnVal = StrToStruPlyPktBodyInfo(&inbuff, &ilenStr, &struPktBodyInfo);
		if(rtnVal!=0)
		{
			#ifdef _DEBUG
			printf("StrToStruPlyPktBodyInfo return = %d\n", rtnVal);
			#endif
			rtnVal = -5;
			break;
		}
		iMemSize = sizeof(PacketHead)+
					sizeof(PktBodyInfoStru)+
					sizeof(plyEdrGridStru)*struPktBodyInfo.nPktNum[0]+
					sizeof(plyEdrappStru)*struPktBodyInfo.nPktNum[1]+
					sizeof(plyEdrappcrgoStru)*struPktBodyInfo.nPktNum[2]+
					sizeof(plyEdrapprdrStru)*struPktBodyInfo.nPktNum[8]+
					sizeof(plyEdrapppayStru)*struPktBodyInfo.nPktNum[9]+
					sizeof(plyPlyappNetStru)*struPktBodyInfo.nPktNum[13];
		*ppBuffSend = (char*)malloc(iMemSize);
		if((*ppBuffSend)==NULL)
		{
			#ifdef _DEBUG
			printf("malloc failed: File(%s), Line(%d)\n", __FILE__, __LINE__);
			#endif
			rtnVal = -6;
			break;
		}
		struPktHead.lPacketSize = iMemSize;
		struPktHead.iRecordSize = iMemSize - sizeof(PacketHead);

		memcpy(*ppBuffSend, &struPktHead, sizeof(PacketHead));
		memcpy(*ppBuffSend+sizeof(PacketHead), &struPktBodyInfo, sizeof(PktBodyInfoStru));
		rtnVal = StrToPly22125(&inbuff, &ilenStr, *ppBuffSend+sizeof(PacketHead)+sizeof(PktBodyInfoStru), 
							&struPktBodyInfo);
		if(rtnVal!=0)
		{
			#ifdef _DEBUG
			printf("StrToPly22125 return = %d\n", rtnVal);
			#endif
			rtnVal = -7;
			break;
		}
		break;


	case 22128:
	case 22123:
	case 22126:
		memset(&struPktBodyInfo, 0, sizeof(PktBodyInfoStru));
		rtnVal = StrToStruPlyPktBodyInfo(&inbuff, &ilenStr, &struPktBodyInfo);
		if(rtnVal!=0)
		{
			#ifdef _DEBUG
			printf("StrToStruPlyPktBodyInfo return = %d\n", rtnVal);
			#endif
			rtnVal = -5;
			break;
		}
		iMemSize = sizeof(PacketHead)+
					sizeof(PktBodyInfoStru)+
					sizeof(plyEdrGridStru)*struPktBodyInfo.nPktNum[0];
		*ppBuffSend = (char*)malloc(iMemSize);
		if((*ppBuffSend)==NULL)
		{
			#ifdef _DEBUG
			printf("malloc failed: File(%s), Line(%d)\n", __FILE__, __LINE__);
			#endif
			rtnVal = -6;
			break;
		}
		struPktHead.lPacketSize = iMemSize;
		struPktHead.iRecordSize = iMemSize - sizeof(PacketHead);

		memcpy(*ppBuffSend, &struPktHead, sizeof(PacketHead));
		memcpy(*ppBuffSend+sizeof(PacketHead), &struPktBodyInfo, sizeof(PktBodyInfoStru));
		rtnVal = StrToPly22128(&inbuff, &ilenStr, *ppBuffSend+sizeof(PacketHead)+sizeof(PktBodyInfoStru), 
							&struPktBodyInfo);
		if(rtnVal!=0)
		{
			#ifdef _DEBUG
			if(struPktHead.iPacketID==22128) printf("StrToPly22128 return = %d\n", rtnVal);
			else if(struPktHead.iPacketID==22123) printf("StrToPly22123 return = %d\n", rtnVal);
			else ;
			#endif
			rtnVal = -7;
			break;
		}
		break;

/* add by joe qiao 2001/11/23  begin  this case is specieal to other case. it just olay one string to be send and receive, so it process is different than others*/
	case 22660:
	case 22669:
		{
				char sTemp[MAXFIELDLEN+1];
				if(ToStringField(&inbuff, &ilenStr, &sTemp,MAXFIELDLEN+1)==FALSE) {
						#ifdef _DEBUG
						if(struPktHead.iPacketID==22660) printf("22660 return = %d\n", rtnVal);
						else if(struPktHead.iPacketID==22669) printf("22669 return = %d\n", rtnVal);
						else ;
						#endif
						rtnVal = -7;
						break;
				}
				iMemSize = sizeof(PacketHead)+strlen(sTemp);
				*ppBuffSend = (char*)malloc(iMemSize);

				struPktHead.lPacketSize = sizeof(PacketHead)+strlen(sTemp);
				struPktHead.iRecordSize = strlen(sTemp);
				
				memcpy(*ppBuffSend, &struPktHead, sizeof(PacketHead));
				memcpy(*ppBuffSend + sizeof(PacketHead), sTemp, strlen(sTemp));
		}
		break;
/* add by joe qiao  end */
	default:
		#ifdef _DEBUG
		printf("Unknow package: id=%d\n", struPktHead.iPacketID);
		#endif
		rtnVal = -2;
		break;
	}

	return rtnVal;
}


/*Before send to the server, byte order should be converted, 
* Type with one byte, such as 'char', is not need to convert.
*/
void BeforSendOrderConvt(char* pbuff)
{
	int i;
	PacketHead struPktHead;
	PktBodyInfoStru struPktBodyInfo;

	memcpy(&struPktHead, pbuff, sizeof(PacketHead));
	switch(struPktHead.iPacketID)
	{
	case 13003: 
	case 13004:
		struCltPerClntInfoOrderConvt(pbuff+sizeof(PacketHead));
		break;
	case 13008:
	case 13009:
		struCltOrgClntInfoOrderConvt(pbuff+sizeof(PacketHead));
		break;

	case 22151:
		memcpy(&struPktBodyInfo, pbuff+sizeof(PacketHead), sizeof(PktBodyInfoStru));
		struPktBodyInfoOrderConvt(pbuff+sizeof(PacketHead));
		
		struAppPolyGridOrderConvt(pbuff+sizeof(PacketHead)+sizeof(PktBodyInfoStru));
		struAppPolicyOrderConvt(pbuff+sizeof(PacketHead)+sizeof(PktBodyInfoStru)+sizeof(plyAppPolyGridStru));
		struGoTgtOrderConvt(pbuff+sizeof(PacketHead)+sizeof(PktBodyInfoStru)+
			sizeof(plyAppPolyGridStru)+sizeof(plyAppPolicyStru));

		for(i=0; i<struPktBodyInfo.nPktNum[8]; i++)
		{
			struRdrOrderConvt(pbuff+sizeof(PacketHead)+sizeof(PktBodyInfoStru)+
					sizeof(plyAppPolyGridStru)+sizeof(plyAppPolicyStru)+
					sizeof(plyGoTgtStru)+i*sizeof(plyRdrStru));
		}
		struPayOrderConvt(pbuff+sizeof(PacketHead)+sizeof(PktBodyInfoStru)+
					sizeof(plyAppPolyGridStru)+sizeof(plyAppPolicyStru)+
					sizeof(plyGoTgtStru)+
					struPktBodyInfo.nPktNum[8]*sizeof(plyRdrStru));
		struPlyappNetOrderConvt(pbuff+sizeof(PacketHead)+sizeof(PktBodyInfoStru)+
					sizeof(plyAppPolyGridStru)+sizeof(plyAppPolicyStru)+
					sizeof(plyGoTgtStru)+
					struPktBodyInfo.nPktNum[8]*sizeof(plyRdrStru)+
					sizeof(plyPayStru));
		break;

	case 22114:
		struPktBodyInfoOrderConvt(pbuff+sizeof(PacketHead));
		struPlyCheckGridOrderConvt(pbuff+sizeof(PacketHead)+sizeof(PktBodyInfoStru));
		break;

	case 22106:
	case 22105:
		struPktBodyInfoOrderConvt(pbuff+sizeof(PacketHead));
		struAppPolyGridOrderConvt(pbuff+sizeof(PacketHead)+sizeof(PktBodyInfoStru));
		break;

	case 2024:
		struClmInListChangeOrderConvt(pbuff+sizeof(PacketHead));
		break;

	case 22120:
		struPlyGetDocOrderConvt(pbuff+sizeof(PacketHead));
		break;
	
	case 22125:
		memcpy(&struPktBodyInfo, pbuff+sizeof(PacketHead), sizeof(PktBodyInfoStru));
		struPktBodyInfoOrderConvt(pbuff+sizeof(PacketHead)); 
		
		for(i=0; i<struPktBodyInfo.nPktNum[0]; i++)
			struPlyEdrGridOrderConvt(pbuff+sizeof(PacketHead)
									+sizeof(PktBodyInfoStru)
									+i*sizeof(plyEdrGridStru));

		for(i=0; i<struPktBodyInfo.nPktNum[1]; i++)
			struPlyEdrappOrderConvt(pbuff+sizeof(PacketHead)+sizeof(PktBodyInfoStru)
					+struPktBodyInfo.nPktNum[0]*sizeof(plyEdrGridStru)
					+i*sizeof(plyEdrappStru));

		for(i=0; i<struPktBodyInfo.nPktNum[2]; i++)
			struPlyEdrappcrgoOrderConvt(pbuff+sizeof(PacketHead)+sizeof(PktBodyInfoStru)
				+struPktBodyInfo.nPktNum[0]*sizeof(plyEdrGridStru)
				+struPktBodyInfo.nPktNum[1]*sizeof(plyEdrappStru)
				+i*sizeof(plyEdrappcrgoStru));

		for(i=0; i<struPktBodyInfo.nPktNum[8]; i++)
			struPlyEdrapprdrOrderConvt(pbuff+sizeof(PacketHead)+sizeof(PktBodyInfoStru)
				+struPktBodyInfo.nPktNum[0]*sizeof(plyEdrGridStru)
				+struPktBodyInfo.nPktNum[1]*sizeof(plyEdrappStru)
				+struPktBodyInfo.nPktNum[2]*sizeof(plyEdrappcrgoStru)
				+i*sizeof(plyEdrapprdrStru));

		for(i=0; i<struPktBodyInfo.nPktNum[9]; i++)
			struPlyEdrapppayOrderConvt(pbuff+sizeof(PacketHead)+sizeof(PktBodyInfoStru)
				+struPktBodyInfo.nPktNum[0]*sizeof(plyEdrGridStru)
				+struPktBodyInfo.nPktNum[1]*sizeof(plyEdrappStru)
				+struPktBodyInfo.nPktNum[2]*sizeof(plyEdrappcrgoStru)
				+struPktBodyInfo.nPktNum[8]*sizeof(plyEdrapprdrStru)
				+i*sizeof(plyEdrapppayStru));

		for(i=0; i<struPktBodyInfo.nPktNum[13]; i++)
			struPlyappNetOrderConvt(pbuff+sizeof(PacketHead)+sizeof(PktBodyInfoStru)
				+struPktBodyInfo.nPktNum[0]*sizeof(plyEdrGridStru)
				+struPktBodyInfo.nPktNum[1]*sizeof(plyEdrappStru)
				+struPktBodyInfo.nPktNum[2]*sizeof(plyEdrappcrgoStru)
				+struPktBodyInfo.nPktNum[8]*sizeof(plyEdrapprdrStru)
				+struPktBodyInfo.nPktNum[9]*sizeof(plyEdrapppayStru)
				+i*sizeof(plyPlyappNetStru));
		break;

	case 22128:
	case 22123:
	case 22126:
		memcpy(&struPktBodyInfo, pbuff+sizeof(PacketHead), sizeof(PktBodyInfoStru));
		struPktBodyInfoOrderConvt(pbuff+sizeof(PacketHead)); 

		for(i=0; i<struPktBodyInfo.nPktNum[0]; i++)
			struPlyEdrGridOrderConvt(pbuff
									+sizeof(PacketHead)
									+sizeof(PktBodyInfoStru)
									+sizeof(plyEdrGridStru)*i);
		break;



	default:
		break;
	}

	return ;
}




/* Print each structure content on screen.
* It is used only for debug 
*/
void PrintAscPkt(char* pbuff)
{
	PacketHead struPktHead;

	memcpy(&struPktHead, pbuff, sizeof(PacketHead));
	switch(struPktHead.iPacketID)
	{
	case 13003: 
	case 13004:
		PrintPerCltBuff(pbuff);
		break;

	case 13008:
	case 13009:
		PrintOrgCltBuff(pbuff);
		break;

	case 22151:
		PrintPlyAppBuff(pbuff);
		break;

	case 22114:
		PrintCheckGridBuff(pbuff);
		break;

	case 22106:
	case 22105:
		PrintPolyGridBuff(pbuff);
		break;
	case 2024:
		PrintClmInListChangeBuff(pbuff);
		break;

	case 22120:
		PrintPlyGetDocBuff(pbuff);
		break;

	case 22125:
		PrintAscii22125(pbuff);
		break;

	case 22128:
	case 22123:
	case 22126:
		PrintAscii22128(pbuff);
		break;

	default:
		break;
	}

	return ;
}

