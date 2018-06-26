#ifndef _CPLYEDRAPPRDR_H__BF176641_9067_11D4_B846_0000F4C08A45__INCLUDED_
#define _CPLYEDRAPPRDR_H__BF176641_9067_11D4_B846_0000F4C08A45__INCLUDED_


#include "g_globdef.h"



int StrToStruPlyEdrapprdr(char** ppstring, int *plenStr, plyEdrapprdrStru *pstruPlyEdrapprdr);
void StruPlyEdrapprdrToStr(plyEdrapprdrStru *pstruPlyEdrapprdr, char** ppstring, int *plenStr);

void PrintStruPlyEdrapprdr(const plyEdrapprdrStru *pstruPlyEdrapprdr);
void struPlyEdrapprdrOrderConvt(char *pBuff);


#endif

