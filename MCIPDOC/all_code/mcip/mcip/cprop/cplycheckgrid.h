#ifndef _CPLYCHECKGRID_H__3F478BED_8A2A_11D4_B846_0000F4C08A45__INCLUDED_
#define _CPLYCHECKGRID_H__3F478BED_8A2A_11D4_B846_0000F4C08A45__INCLUDED_


#include "g_globdef.h"


int StrToStruPlyCheckGrid(char** ppstring, int *plenStr, plyCheckGridStru *pstruPlyCheckGrid);
void StruPlyCheckGridToStr(plyCheckGridStru *pstruPlyCheckGrid, char** ppstring, int *plenStr);
void PrintStruCheckGrid(const plyCheckGridStru *pstruPlyCheckGrid);
void struPlyCheckGridOrderConvt(char *pBuff);





#endif

