#ifndef _RETURNTOSTR_H_
#define _RETURNTOSTR_H_


void CltPerClntInfoReturnToStr(char** ppRcvStringOffset, char cRetCode, char** ppStringResult, int* plenStr);
void CltOrgClntInfoReturnToStr(char** ppRcvStringOffset, char cRetCode, char** ppStringResult, int* plenStr);

void PlyCplyReturnToStr(char** ppRcvStringOffset, char cRetCode, char** ppStringResult, int* plenStr);
void CheckGridReturnToStr(char** ppRcvStringOffset, char cRetCode, char** ppStringResult, int* plenStr);

void AppPolyReturnToStr(char** ppRcvStringOffset, char cRetCode, char** ppStringResult, int* plenStr);
void ClmPlcyNoReturnToStr(char** ppRcvStringOffset, char cRetCode, char** ppStringResult, int* plenStr);

void Ply22120ReturnToStr(char** ppRcvStringOffset, char cRetCode, char** ppStringResult, int* plenStr);
void Ply22125ReturnToStr(char** ppRcvStringOffset, char cRetCode, char** ppStringResult, int* plenStr, const PktBodyInfoStru* pstruPktBodyInfo);
void Ply22128ReturnToStr(char** ppRcvStringOffset, char cRetCode, char** ppStringResult, int* plenStr, const PktBodyInfoStru* pstruPktBodyInfo);
void Ply22123ReturnToStr(char** ppRcvStringOffset, char cRetCode, char** ppStringResult, int* plenStr, const PktBodyInfoStru* pstruPktBodyInfo);
void Ply22126ReturnToStr(char** ppRcvStringOffset, char cRetCode, char** ppStringResult, int* plenStr);

#endif