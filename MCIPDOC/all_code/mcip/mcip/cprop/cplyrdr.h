#ifndef _CPLYRDR_H__3F478BE8_8A2A_11D4_B846_0000F4C08A45__INCLUDED_
#define _CPLYRDR_H__3F478BE8_8A2A_11D4_B846_0000F4C08A45__INCLUDED_


#include "g_globdef.h"


int StrToStruRdr(char** ppstring, int *plenStr, plyRdrStru *pstruRdr);
void PrintStruRdr(const plyRdrStru *pstruRdrTemp);
void struRdrOrderConvt(char *pBuff);





#endif

