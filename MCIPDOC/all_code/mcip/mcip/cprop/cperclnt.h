#ifndef _CPERCLNT_H__3F478BE2_8A2A_11D4_B846_0000F4C08A45__INCLUDED_
#define _CPERCLNT_H__3F478BE2_8A2A_11D4_B846_0000F4C08A45__INCLUDED_


#include "g_globdef.h"




int StrToStruCltPerClntInfo(char** ppstring, int *plenStr, cltPerClntInfoStru *pstruCltPerClntInfo);
void StruCltPerClntInfoToStr(cltPerClntInfoStru *pstruCltPerClntInfo, char** ppstring, int *plenStr);
void PrintStruCltPerClntInfo(const cltPerClntInfoStru *pstruCltPerClntInfo);
void struCltPerClntInfoOrderConvt(char *pBuff);

#endif

