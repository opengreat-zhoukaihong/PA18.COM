#ifndef _CPLYEDRAPPPAY_H__BF176644_9067_11D4_B846_0000F4C08A45__INCLUDED_
#define _CPLYEDRAPPPAY_H__BF176644_9067_11D4_B846_0000F4C08A45__INCLUDED_


#include "g_globdef.h"



int StrToStruPlyEdrapppay(char** ppstring, int *plenStr, plyEdrapppayStru *pstruPlyEdrapppay);
void StruPlyEdrapppayToStr(plyEdrapppayStru *pstruPlyEdrapppay, char** ppstring, int *plenStr);

void PrintStruPlyEdrapppay(const plyEdrapppayStru *pstruPlyEdrapppay);
void struPlyEdrapppayOrderConvt(char *pBuff);



#endif

