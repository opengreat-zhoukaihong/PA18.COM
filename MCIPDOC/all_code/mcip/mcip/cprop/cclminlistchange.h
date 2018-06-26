#if !defined(AFX_STRTOSTRUCLM_H__787F6AA1_84CF_11D4_B846_0000F4C08A45__INCLUDED_)
#define AFX_STRTOSTRUCLM_H__787F6AA1_84CF_11D4_B846_0000F4C08A45__INCLUDED_

#include "g_globdef.h"

int StrToStruClmInListChange(char** ppstring, int *plenStr, clmInListChangeStru *pstruClmInListChange);
void PrintStruClmInListChange(const clmInListChangeStru *pstruClmInListChange);
void StruClmInListChangeToStr(clmInListChangeStru *pstruClmInListChange, char** ppstring, int *plenStr);
void struClmInListChangeOrderConvt(char *pBuff);









#endif
