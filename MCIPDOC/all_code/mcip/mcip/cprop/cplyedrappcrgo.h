#ifndef _CPLYEDRAPPCRGO_H__BF176645_9067_11D4_B846_0000F4C08A45__INCLUDED_
#define _CPLYEDRAPPCRGO_H__BF176645_9067_11D4_B846_0000F4C08A45__INCLUDED_

#include "g_globdef.h"



int StrToStruPlyEdrappcrgo(char** ppstring, int *plenStr, plyEdrappcrgoStru *pstruPlyEdrappcrgo);
void StruPlyEdrappcrgoToStr(plyEdrappcrgoStru *pstruPlyEdrappcrgo, char** ppstring, int *plenStr);

void PrintStruPlyEdrappcrgo(const plyEdrappcrgoStru *pstruPlyEdrappcrgo);
void struPlyEdrappcrgoOrderConvt(char *pBuff);



#endif

