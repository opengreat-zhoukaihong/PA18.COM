#ifndef _CPLYEDRGRID_H__BF17664C_9067_11D4_B846_0000F4C08A45__INCLUDED_
#define _CPLYEDRGRID_H__BF17664C_9067_11D4_B846_0000F4C08A45__INCLUDED_

#include "g_globdef.h"



int StrToStruPlyEdrGrid(char** ppstring, int *plenStr, plyEdrGridStru *pstruPlyEdrGrid);
void StruPlyEdrGridToStr(plyEdrGridStru *pstruPlyEdrGrid, char** ppstring, int *plenStr);

void PrintStruPlyEdrGrid(const plyEdrGridStru *pstruPlyEdrGrid);
void struPlyEdrGridOrderConvt(char *pBuff);



#endif

