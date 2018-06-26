#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#include "g_globdef.h"
#include "typeconvt.h"


BOOL ToInt(char* pstring, int *iResult)
{
	char sTemp[MAXLENLEN+1];
	int i;

	memcpy(sTemp, pstring, MAXLENLEN);
	sTemp[MAXLENLEN] = '\0';
	for(i=0; i<MAXLENLEN; i++)
	{
		if(sTemp[i]<'0' || sTemp[i]>'9') break;
	}

	if(i!=MAXLENLEN)
	{
		#ifdef _DEBUG
		printf("String is not a length: %s\n", pstring);
		#endif
		return FALSE;
	}

	*iResult = atoi(sTemp);
	return TRUE;
}









BOOL ToIntField(char** ppstring, int* ilenStr, int *iResult)
{
	char sTemp[MAXFIELDLEN+1];
	int iFlag;
	int i, len;
	double fTemp;

	if(*ilenStr<MAXLENLEN)
	{
		#ifdef _DEBUG
		printf("Incorrect ending of the string: %s\n", *ppstring);
		printf("Error postion: %d\n", *ilenStr);
		#endif
		return FALSE;
	}
	if(ToInt(*ppstring, &len)==FALSE)
	{
		return FALSE;
	}

	if(len==0)
	{
		*iResult = 0;
	}
	else
	{
		if(*ilenStr<MAXLENLEN+len)
		{
			#ifdef _DEBUG
			printf("Incorrect ending of the string: %s\n", *ppstring);
			printf("Error postion: %d\n", *ilenStr);
			#endif
			return FALSE;
		}

		memcpy(sTemp, *ppstring+MAXLENLEN, len);
		sTemp[len] = '\0';
		for(iFlag=0, i=0; sTemp[i]!='\0'; i++)
		{
			if( ('0'<=sTemp[i]&&sTemp[i]<='9') || (sTemp[i]=='-') || (sTemp[i]=='+') ) 
				continue;
			else if( sTemp[i]=='.' )
			{
				if(iFlag==1) break; /*after 'E', '.' is not allow */
				else continue;
			}
			else if( (sTemp[i]=='E') || (sTemp[i]=='e') )
			{
				if(iFlag==1) break;  /*two 'E' is not allow*/
				else 
				{
					iFlag = 1;
					continue;
				}
			}
			else break;
		}

		if(i!=len)
		{
			#ifdef _DEBUG
			printf("String is not integer: %s\n", *ppstring);
			printf("Error postion: %d\n", *ilenStr);
			#endif
			return FALSE;
		}

		fTemp = atof(sTemp);
		*iResult = (int)(fTemp);
		if(fTemp!=(int)fTemp)
		{
			#ifdef _DEBUG
			printf("String may be a double(want a integer): %s\n", *ppstring);
			printf("Error position: %d\n", *ilenStr);
			#endif
			return FALSE;
		}
	}

	*ppstring = *ppstring+MAXLENLEN+len;
	*ilenStr = *ilenStr - MAXLENLEN-len;

	return TRUE;
}





BOOL ToDoubleField(char **ppstring, int* ilenStr, double *iResult)

{
	char sTemp[MAXFIELDLEN+1];
	int i, len;
	int iFlag = 0;

	if(*ilenStr<MAXLENLEN)
	{
		#ifdef _DEBUG
		printf("Incorrect ending of the string: %s\n", *ppstring);
		printf("Error postion: %d\n", *ilenStr);
		#endif
		return FALSE;
	}
	if(ToInt(*ppstring, &len)==FALSE) return FALSE;

	
	if(len==0)
	{
		*iResult = 0;
	}
	else
	{
		if(*ilenStr<MAXLENLEN+len)
		{
			#ifdef _DEBUG
			printf("Incorrect ending of the string: %s\n", *ppstring);
			printf("Error postion: %d\n", *ilenStr);
			#endif
			return FALSE;
		}
		memcpy(sTemp, *ppstring+MAXLENLEN, len);
		sTemp[len] = '\0';
		for(iFlag=0, i=0; sTemp[i]!='\0'; i++)
		{
			if( ('0'<=sTemp[i]&&sTemp[i]<='9') || (sTemp[i]=='-') || (sTemp[i]=='+') ) 
				continue;
			else if( sTemp[i]=='.' )
			{
				if(iFlag==1) break; /*after 'E', '.' is not allow */
				else continue;
			}
			else if( (sTemp[i]=='E') || (sTemp[i]=='e') )
			{
				if(iFlag==1) break;  /*two 'E' is not allow*/
				else 
				{
					iFlag = 1;
					continue;
				}
			}
			else break;
		}

		if(i!=len)
		{
			#ifdef _DEBUG
			printf("String is not double: %s\n", *ppstring);
			printf("Error postion: %d\n", *ilenStr);
			#endif
			return FALSE;
		}

		*iResult = atof(sTemp);
	}

	*ppstring = *ppstring+MAXLENLEN+len;
	*ilenStr = *ilenStr - MAXLENLEN-len;
	return TRUE;
}






BOOL ToUnshortField(char** ppstring, int* ilenStr, unsigned short *iResult)
{
	char sTemp[MAXFIELDLEN+1];
	int i, len;


	if(*ilenStr<MAXLENLEN)
	{
		#ifdef _DEBUG
		printf("Incorrect ending of the string: %s\n", *ppstring);
		printf("Error postion: %d\n", *ilenStr);
		#endif
		return FALSE;
	}
	if(ToInt(*ppstring, &len)==FALSE) return FALSE;


	if(len==0)
	{
		*iResult = 0;
	}
	else
	{
		if(*ilenStr<MAXLENLEN+len)
		{
			#ifdef _DEBUG
			printf("Incorrect ending of the string: %s\n", *ppstring);
			printf("Error postion: %d\n", *ilenStr);
			#endif
			return FALSE;
		}

		memcpy(sTemp, *ppstring+MAXLENLEN, len);
		sTemp[len] = '\0';

		for(i=0; sTemp[i]!='\0'; i++)
		{
			if( !('0'<=sTemp[i]&&sTemp[i]<='9') ) break;
		}
		if(i!=len)
		{
			#ifdef _DEBUG
			printf("String is not unsigned short: %s\n", *ppstring);
			printf("Error postion: %d\n", *ilenStr);
			#endif
			return FALSE;
		}
		*iResult = atoi(sTemp);
	}

	*ppstring = *ppstring+MAXLENLEN+len;
	*ilenStr = *ilenStr - MAXLENLEN-len;
	return TRUE;
}



BOOL ToCharField(char** ppstring, int* ilenStr, char *iResult)
{
	char sTemp[MAXFIELDLEN+1];
	int len;

	if(*ilenStr<MAXLENLEN)
	{
		#ifdef _DEBUG
		printf("Incorrect ending of the string: %s\n", *ppstring);
		printf("Error postion: %d\n", *ilenStr);
		#endif
		return FALSE;
	}

	if(ToInt(*ppstring, &len)==FALSE) return FALSE;
	if(len!=1 && len!=0)
	{
		#ifdef _DEBUG
		printf("char is incorrect length: %s\n", *ppstring);
		printf("Error postion: %d\n", *ilenStr);
		#endif
		return FALSE;
	}
	if(len==0)
	{
		iResult[0] = '\0';
	}
	else
	{
		if(*ilenStr<MAXLENLEN+len)
		{
			#ifdef _DEBUG
			printf("Incorrect ending of the string: %s\n", *ppstring);
			printf("Error postion: %d\n", *ilenStr);
			#endif
			return FALSE;
		}
		memcpy(sTemp, *ppstring+MAXLENLEN, len);
		sTemp[len] = '\0';
		*iResult = sTemp[0];
	}

	*ppstring = *ppstring+MAXLENLEN+len;
	*ilenStr = *ilenStr - MAXLENLEN-len;
	return TRUE;
}







BOOL ToStringField(char** ppstring, int* ilenStr, char *iResult, int ilenField)
{
	char sTemp[MAXFIELDLEN+1];
	int len;

	if(*ilenStr<MAXLENLEN)
	{
		#ifdef _DEBUG
		printf("Incorrect ending of the string: %s\n", *ppstring);
		printf("Error postion: %d\n", *ilenStr);
		#endif
		return FALSE;
	}

	if(ToInt(*ppstring, &len)==FALSE) return FALSE;
	if(len==0)
	{
		iResult[0] = '\0';
	}
	else
	{
		if(ilenField-1<len)
		{
			#ifdef _DEBUG
			printf("String length is too long: %d < %d\n",ilenField, len);
			printf("Error postion: [%s]\n", *ppstring);
			#endif
			return FALSE;
		}
		if(*ilenStr<MAXLENLEN+len)
		{
			#ifdef _DEBUG
			printf("Incorrect ending of the string: %s\n", *ppstring);
			printf("Error postion: %d\n", *ilenStr);
			#endif
			return FALSE;
		}
		memcpy(sTemp, *ppstring+MAXLENLEN, len);
		sTemp[len] = '\0';

		strcpy(iResult, sTemp);
	}

	*ppstring = *ppstring+MAXLENLEN+len;
	*ilenStr = *ilenStr - MAXLENLEN-len;
	return TRUE;
}



BOOL ToShortField(char** ppstring, int* ilenStr, short *iResult)
{
	char sTemp[MAXFIELDLEN+1];
	int i, len;


	if(*ilenStr<MAXLENLEN)
	{
		#ifdef _DEBUG
		printf("Incorrect ending of the string: %s\n", *ppstring);
		printf("Error postion: %d\n", *ilenStr);
		#endif
		return FALSE;
	}

	if(ToInt(*ppstring, &len)==FALSE) return FALSE;
	if(len==0)
	{
		*iResult = 0;
	}
	else
	{
		if(*ilenStr<MAXLENLEN+len)
		{
			#ifdef _DEBUG
			printf("Incorrect ending of the string: %s\n", *ppstring);
			printf("Error postion: %d\n", *ilenStr);
			#endif
			return FALSE;
		}
		memcpy(sTemp, *ppstring+MAXLENLEN, len);
		sTemp[len] = '\0';

		for(i=0; sTemp[i]!='\0'; i++)
		{
			if( !('0'<=sTemp[i]&&sTemp[i]<='9')) break;
		}
		if(i!=len)
		{
			#ifdef _DEBUG
			printf("String is not short: %s\n", *ppstring);
			printf("Error postion: %d\n", *ilenStr);
			#endif
			return FALSE;
		}

		*iResult = atoi(sTemp);
	}

	*ppstring = *ppstring+MAXLENLEN+len;
	*ilenStr = *ilenStr - MAXLENLEN-len;
	return TRUE;
}































void StrToStr(char* pInStr, char** ppOutPtr, int *ilenStr)
{
	int len;
	len = strlen(pInStr);
	if(pInStr!=NULL) sprintf(*ppOutPtr, "%04d%s", len, pInStr);
	*ppOutPtr = *ppOutPtr + MAXLENLEN + len;
	*ilenStr = *ilenStr + MAXLENLEN + len;

	return ;
}



void CharToStr(char pInChar, char** ppOutPtr, int *ilenStr)
{

/*	if(pInChar==0)

	{

		sprintf(*ppOutPtr, "0000");

		*ppOutPtr = *ppOutPtr + MAXLENLEN;

		*ilenStr = *ilenStr + MAXLENLEN;

	}

	else 

	{	

*/

		sprintf(*ppOutPtr, "0001%c", pInChar);
		*ppOutPtr = *ppOutPtr + MAXLENLEN + 1;
		*ilenStr = *ilenStr + MAXLENLEN + 1;

/*	}

*/	

	return ;

}





/*warn*/

void IntToStr(int pInInt, char** ppOutPtr, int *ilenStr)
{
	char sTemp[13];
	int len;


	if(pInInt==0)
	{
		sprintf(*ppOutPtr, "00010");
		*ppOutPtr = *ppOutPtr + MAXLENLEN+1;
		*ilenStr = *ilenStr + MAXLENLEN+1;
	}
	else
	{
		sprintf(sTemp, "%d", pInInt);
		len = strlen(sTemp);
		sprintf(*ppOutPtr, "%04d%s", len, sTemp);
		*ppOutPtr = *ppOutPtr + MAXLENLEN + len;
		*ilenStr = *ilenStr + MAXLENLEN + len;
	}


	return ;
}



void UnshortToStr(unsigned short pInUnshort, char** ppOutPtr, int *ilenStr)
{
	char sTemp[13];
	int len;

	if(pInUnshort==0)
	{
		sprintf(*ppOutPtr, "00010");
		*ppOutPtr = *ppOutPtr + MAXLENLEN+1;
		*ilenStr = *ilenStr + MAXLENLEN+1;
	}
	else
	{
		sprintf(sTemp, "%d", pInUnshort);
		len = strlen(sTemp);
		sprintf(*ppOutPtr, "%04d%s", len, sTemp);
		*ppOutPtr = *ppOutPtr + MAXLENLEN + len;
		*ilenStr = *ilenStr + MAXLENLEN + len;
	}

	return ;
}



void ShortToStr(short pInShort, char** ppOutPtr, int *ilenStr)
{
	char sTemp[13];
	int len;
	if(pInShort==0)
	{
		sprintf(*ppOutPtr, "00010");
		*ppOutPtr = *ppOutPtr + MAXLENLEN+1;
		*ilenStr = *ilenStr + MAXLENLEN+1;
	}
	else
	{
		sprintf(sTemp, "%d", pInShort);
		len = strlen(sTemp);
		sprintf(*ppOutPtr, "%04d%s", len, sTemp);
		*ppOutPtr = *ppOutPtr + MAXLENLEN + len;
		*ilenStr = *ilenStr + MAXLENLEN + len;
	}

	return ;
}









void DoubleToStr(double pInDouble, char** ppOutPtr, int *ilenStr)
{
	char sTemp[20];
	int len;
	if(pInDouble==0)
	{
		sprintf(*ppOutPtr, "00010");
		*ppOutPtr = *ppOutPtr + MAXLENLEN+1;
		*ilenStr = *ilenStr + MAXLENLEN+1;
	}
	else
	{
		sprintf(sTemp, "%f", pInDouble);
		len = strlen(sTemp);
		sprintf(*ppOutPtr, "%04d%s", len, sTemp);
		*ppOutPtr = *ppOutPtr + MAXLENLEN + len;
		*ilenStr = *ilenStr + MAXLENLEN + len;
	}
	return ;
}



