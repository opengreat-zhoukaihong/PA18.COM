#ifndef _CPLYGETDOC_H__BF176653_9067_11D4_B846_0000F4C08A45__INCLUDED_
#define _CPLYGETDOC_H__BF176653_9067_11D4_B846_0000F4C08A45__INCLUDED_

#include "g_globdef.h"



int StrToStruPlyGetDoc(char** ppstring, int *plenStr, plyGetDocStru *pstruPlyGetDoc);
void StruPlyGetDocToStr(plyGetDocStru *pstruPlyGetDoc, char** ppstring, int *plenStr);

void PrintStruPlyGetDoc(const plyGetDocStru *pstruPlyGetDoc);
void struPlyGetDocOrderConvt(char *pBuff);





#endif

