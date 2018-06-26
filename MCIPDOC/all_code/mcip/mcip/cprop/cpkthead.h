#ifndef _CPKTHEAD_H__3F478BE1_8A2A_11D4_B846_0000F4C08A45__INCLUDED_
#define _CPKTHEAD_H__3F478BE1_8A2A_11D4_B846_0000F4C08A45__INCLUDED_

#include "g_globdef.h"


int StrToStruPKTHead(char** ppstring, int *plenStr, PacketHead *pstruPktHead);
void StruPKTHeadToStr(PacketHead *pstruPktHead, char** ppstring, int *plenStr);;




/*Get received binary head, and move the pointer to next position
* Return:	
*			0	--> OK
*			<0	--> Failed
*/
int GetRcvHead(char** ppBinBuff, PacketHead *pstruPktHead);



void PrintStruPKTHead(const PacketHead *pstruPktHead);




#endif

