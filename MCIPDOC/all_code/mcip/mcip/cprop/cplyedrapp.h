#ifndef _CPLYEDRAPP_H__AAADC3AD_8FC9_11D4_B846_0000F4C08A45__INCLUDED_
#define _CPLYEDRAPP_H__AAADC3AD_8FC9_11D4_B846_0000F4C08A45__INCLUDED_

#include "g_globdef.h"



int StrToStruPlyEdrapp(char** ppstring, int *plenStr, plyEdrappStru *pstruPlyEdrapp);
void StruPlyEdrappToStr(plyEdrappStru *pstruPlyEdrapp, char** ppstring, int *plenStr);

void PrintStruPlyEdrapp(const plyEdrappStru *pstruPlyEdrapp);
void struPlyEdrappOrderConvt(char *pBuff);






#endif

