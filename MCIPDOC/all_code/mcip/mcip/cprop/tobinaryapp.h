#ifndef _TOBINARYAPP_H__3F478BF6_8A2A_11D4_B846_0000F4C08A45__INCLUDED_
#define _TOBINARYAPP_H__3F478BF6_8A2A_11D4_B846_0000F4C08A45__INCLUDED_

#include "g_globdef.h"




int StrToPlyApp(char** ppstring, int *plenStr, char *pBuffPlyApp, const PktBodyInfoStru *pstruPktBodyInfo);
int StrToCheckApp(char** ppstring, int *plenStr, char *pBuffCheckApp);
int StrToPolyGridApp(char** ppstring, int *plenStr, char *pBuffPolyGridApp);

int StrToPly22125(char** ppstring, int *plenStr, char *pBuffPlyApp, const PktBodyInfoStru *pstruPktBodyInfo);
int StrToPly22128(char** ppstring, int *plenStr, char *pBuffPlyApp, const PktBodyInfoStru *pstruPktBodyInfo);










#endif

