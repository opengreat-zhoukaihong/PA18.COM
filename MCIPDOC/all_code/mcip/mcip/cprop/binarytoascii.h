#ifndef _BINARYTOASCII_H_
#define _BINARYTOASCII_H_



/*Func: convert binary string to ascii
*
* Input param: 
*			pBinBuff  --> binary string buff 
*			iPktID    --> this packet ID (used this param for Packet ID, Don't use
*								the packet ID in buff, it may be incorrect.)
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
int BinaryToAscii(char* pBinBuff, int iPktID, char **ppStringReturn, int* plenStr);



/*After receive from the server, byte order should be converted, 
* type with only one byte , such as 'char', is not need to convert.
*/
int AfterRcvOrderConvt(char* pBinBuff, int iPktID);



/* Print each structure content on screen.
* It is used only for debug 
*/
void PrintReplyBinPkt(char* pbuff, int iPktID);

#endif
