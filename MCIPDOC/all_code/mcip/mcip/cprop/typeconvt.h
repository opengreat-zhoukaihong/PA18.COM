#ifndef _TYPECONVT_H_
#define _TYPECONVT_H_

#include "g_globdef.h"



BOOL ToIntField(char** ppstring, int* ilenStr, int *iResult);
BOOL ToDoubleField(char* *ppstring, int* ilenStr, double *iResult);
BOOL ToUnshortField(char** ppstring, int* ilenStr, unsigned short *iResult);
BOOL ToCharField(char** ppstring, int* ilenStr, char *iResult);
BOOL ToStringField(char** ppstring, int* ilenStr, char *iResult, int ilenField);
BOOL ToShortField(char** ppstring, int* ilenStr, short *iResult);



void StrToStr(char* pInStr, char** ppOutPtr, int *ilenStr);
void CharToStr(char pInChar, char** ppOutPtr, int *ilenStr);
void IntToStr(int pInInt, char** ppOutPtr, int *ilenStr);
void UnshortToStr(unsigned short pInUnshort, char** ppOutPtr, int *ilenStr);
void ShortToStr(short pInShort, char** ppOutPtr, int *ilenStr);
void DoubleToStr(double pInDouble, char** ppOutPtr, int *ilenStr);




#endif
