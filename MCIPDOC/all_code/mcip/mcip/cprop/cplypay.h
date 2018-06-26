#ifndef _CPLYPAY_H__3F478BE9_8A2A_11D4_B846_0000F4C08A45__INCLUDED_
#define _CPLYPAY_H__3F478BE9_8A2A_11D4_B846_0000F4C08A45__INCLUDED_



#include "g_globdef.h"


int StrToStruPay(char** ppstring, int *plenStr, plyPayStru *pstruPay);
void PrintStruPay(const plyPayStru *pstruPayTemp);
void struPayOrderConvt(char *pBuff);





#endif

