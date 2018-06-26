#if !defined(AFX_CCLMPLCYNO_H__3F478BEE_8A2A_11D4_B846_0000F4C08A45__INCLUDED_)
#define AFX_CCLMPLCYNO_H__3F478BEE_8A2A_11D4_B846_0000F4C08A45__INCLUDED_



#include "g_globdef.h"






int StrToStruClmPlcyNo(char** ppstring, int *plenStr, clmPlcyNoStru *pstruClmPlcyNo);
void PrintStruClmPlcyNo(const clmPlcyNoStru *pstruClmPlcyNo);
void StruClmPlcyNoToStr(clmPlcyNoStru *pstruClmPlcyNo, char** ppstring, int *plenStr);
void struClmPlcyNoOrderConvt(char *pBuff);




#endif

