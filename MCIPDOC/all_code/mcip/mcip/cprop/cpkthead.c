#include "typeconvt.h"
#include "AiConvert.h"

#include "cpkthead.h"


int StrToStruPKTHead(char** ppstring, int *plenStr, PacketHead *pstruPktHead)
{
	int  i, j;
	int  iTemp;
	if(*ppstring==NULL) return 1;

	j=i=0;
	do 
	{
		j++;    if(ToUnshortField(ppstring, plenStr, &(pstruPktHead->iPacketID))==FALSE) break;    else i++; 
		j++;    if(ToUnshortField(ppstring, plenStr, &(pstruPktHead->iRetPktID))==FALSE) break;    else i++;
		j++;    if(ToIntField(ppstring, plenStr, &(pstruPktHead->lPacketSize))==FALSE) break;    else i++;
		j++;    if(ToShortField(ppstring, plenStr, &(pstruPktHead->iRecordNum))==FALSE) break;    else i++;
		j++;    if(ToShortField(ppstring, plenStr, &(pstruPktHead->iRecordSize))==FALSE) break;    else i++;
		j++;    if(ToShortField(ppstring, plenStr, &(pstruPktHead->iPriority))==FALSE) break;    else i++;
		j++;    if(ToShortField(ppstring, plenStr, &(pstruPktHead->iServiceNo))==FALSE) break;    else i++;
		j++;    if(ToIntField(ppstring, plenStr, &iTemp)==FALSE) break;    else i++;
		pstruPktHead->cRetCode = iTemp;
		j++;    if(ToIntField(ppstring, plenStr, &(pstruPktHead->iReserved))==FALSE) break;    else i++; 
	}while(0);
	if(j!=i) 
	{	
		#ifdef _DEBUG
		printf("StrToStruPKTHead failed, Field index = %d\n", j);
		#endif
		return 0-j;
	}
	return 0;
}


void StruPKTHeadToStr(PacketHead *pstruPktHead, char** ppstring, int *plenStr)
{

	printf("pstruPktHead->lPacketSize %d\n", pstruPktHead->lPacketSize); 
	printf("pstruPktHead->cRetCode %d\n",pstruPktHead->cRetCode);
	UnshortToStr(pstruPktHead->iPacketID, ppstring,  plenStr);
	UnshortToStr(pstruPktHead->iRetPktID, ppstring,  plenStr);
	IntToStr(pstruPktHead->lPacketSize, ppstring,  plenStr);
	ShortToStr(pstruPktHead->iRecordNum, ppstring,  plenStr);
	ShortToStr(pstruPktHead->iRecordSize, ppstring,  plenStr);
	ShortToStr(pstruPktHead->iPriority, ppstring,  plenStr);
	ShortToStr(pstruPktHead->iServiceNo, ppstring,  plenStr);
	IntToStr(pstruPktHead->cRetCode, ppstring,  plenStr);
	IntToStr(pstruPktHead->iReserved, ppstring,  plenStr);
	return;
}




/*Get received binary head, and move the pointer to next position
* Return:	
*			0	--> OK
*			<0	--> Failed
*/
int GetRcvHead(char** ppBinBuff, PacketHead *pstruPktHead)
{
	if(*ppBinBuff==NULL) return -1;
	memcpy(pstruPktHead, *ppBinBuff, sizeof(PacketHead));

	*ppBinBuff = *ppBinBuff + sizeof(PacketHead);
	return 0;
}





void PrintStruPKTHead(const PacketHead *pstruPktHead)
{
	printf("pstruPktHead->iPacketID   = [%d]\n", pstruPktHead->iPacketID); 
	printf("pstruPktHead->iRetPktID   = [%d]\n", pstruPktHead->iRetPktID);     
	printf("pstruPktHead->lPacketSize = [%d]\n", pstruPktHead->lPacketSize);   
	printf("pstruPktHead->iRecordNum  = [%d]\n", pstruPktHead->iRecordNum);    
	printf("pstruPktHead->iRecordSize = [%d]\n", pstruPktHead->iRecordSize);   
	printf("pstruPktHead->iPriority   = [%d]\n", pstruPktHead->iPriority);     
	printf("pstruPktHead->iServiceNo  = [%d]\n", pstruPktHead->iServiceNo);    
	printf("pstruPktHead->cRetCode    = [%d]\n", pstruPktHead->cRetCode);     
	printf("pstruPktHead->iReserved   = [%d]\n\n", pstruPktHead->iReserved);     
	return ;
}



