#ifndef _CORGCLNT_H__3F478BE3_8A2A_11D4_B846_0000F4C08A45__INCLUDED_
#define _CORGCLNT_H__3F478BE3_8A2A_11D4_B846_0000F4C08A45__INCLUDED_


#include "g_globdef.h"



int StrToStruCltOrgClntInfo(char** ppstring, int *plenStr, cltOrgClntInfoStru *pstruCltOrgClntInfo);
void StruCltOrgClntInfoToStr(cltOrgClntInfoStru *pstruCltOrgClntInfo, char** ppstring, int *plenStr);

void PrintStruCltOrgClntInfo(const cltOrgClntInfoStru *pstruCltOrgClntInfo);

void struCltOrgClntInfoOrderConvt(char *pBuff);


#endif


