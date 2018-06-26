#ifndef _CPLYAPPPOLYGRID_H__3F478BE5_8A2A_11D4_B846_0000F4C08A45__INCLUDED_
#define _CPLYAPPPOLYGRID_H__3F478BE5_8A2A_11D4_B846_0000F4C08A45__INCLUDED_


#include "g_globdef.h"


int StrToStruPolyGrid(char** ppstring, int *plenStr, plyAppPolyGridStru *pstruAppPolyGrid);
void StruPlyAppPolyGridToStr(plyAppPolyGridStru *pstruAppPolyGrid, char** ppstring, int *plenStr);
void PrintStruAppPolyGrid(const plyAppPolyGridStru *pstruAppPolyGridTemp);
void struAppPolyGridOrderConvt(char *pBuff);




#endif

