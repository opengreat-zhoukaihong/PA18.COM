#ifndef _CPLYBODYINFO_H__3F478BE4_8A2A_11D4_B846_0000F4C08A45__INCLUDED_
#define _CPLYBODYINFO_H__3F478BE4_8A2A_11D4_B846_0000F4C08A45__INCLUDED_

#include "g_globdef.h"

int StrToStruPlyPktBodyInfo(char** ppstring, int *plenStr, PktBodyInfoStru *pstruPktBodyInfo);
void StruPlyPktBodyInfoToStr(PktBodyInfoStru *pstruPktBodyInfo, char** ppstring, int* plenStr);
void PrintStruPlyPktBodyInfo(const PktBodyInfoStru *pstruPktBodyInfo);
void struPktBodyInfoOrderConvt(char *pBuff);


#endif

