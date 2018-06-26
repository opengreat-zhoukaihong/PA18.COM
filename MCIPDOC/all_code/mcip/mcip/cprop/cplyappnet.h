#ifndef _CPLYAPPNET_H__3F478BEA_8A2A_11D4_B846_0000F4C08A45__INCLUDED_
#define _CPLYAPPNET_H__3F478BEA_8A2A_11D4_B846_0000F4C08A45__INCLUDED_



#include "g_globdef.h"


int StrToStruPlyappNet(char** ppstring, int *plenStr, plyPlyappNetStru *pstruPlyappNet);
void StruPlyappNetToStr(plyPlyappNetStru *pstruPlyappNet, char** ppstring, int *plenStr);
void PrintStruPlyappNet(const plyPlyappNetStru *pstruPlyappNetTemp);
void struPlyappNetOrderConvt(char *pBuff);




#endif

