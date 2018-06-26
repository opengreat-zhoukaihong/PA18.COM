#ifndef _CPLYAPPPOLICY_H__3F478BE6_8A2A_11D4_B846_0000F4C08A45__INCLUDED_
#define _CPLYAPPPOLICY_H__3F478BE6_8A2A_11D4_B846_0000F4C08A45__INCLUDED_

#include "g_globdef.h"



int StrToStruAppPolicy(char** ppstring, int *plenStr, plyAppPolicyStru *pstruAppPolicy);
void StruPlyAppPolicyToStr(plyAppPolicyStru* pstruAppPolicy, char** ppstring, int* plenStr);
void PrintStruAppPolicy(const plyAppPolicyStru *pstruAppPolicyTemp);
void struAppPolicyOrderConvt(char *pBuff);





#endif

