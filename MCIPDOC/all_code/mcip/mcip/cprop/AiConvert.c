#include <stdio.h>

#ifdef WIN32
#include <winsock2.h>
#else
#include <netinet/in.h>
#endif

#include "AiConvert.h"
/********************************************************************
 * NAME         : AIcom_ConvertInt
 * FUNCTION     : convert a integer into PC byte order 
 * PROCESS      : convert a integer into PC byte order 
 * INPUT        : n: integer want to convert 
 * OUTPUT       :
 * UPDATE       :
 * RETURN       : void
 * PROGRAMMED   : aisoft
 * DATE(ORG)    : 95/10/30
 * CALL         :
 ********************************************************************/
unsigned int AIcom_ConvertInt1(unsigned int n)
{
    unsigned int n2;

    n2 = htonl(n);
    if(n!=n2)  {
        return n;
    };

    return ((n&0xFF)<<24)|((n&0xFF00)<<8)|((n&0xFF0000)>>8)|((n&0xFF000000)>>24);
}


/********************************************************************
 * NAME         : AIcom_ConvertShort
 * FUNCTION     : convert a short into PC byte order 
 * PROCESS      : convert a short into PC byte order 
 * INPUT        : n: short want to convert 
 * OUTPUT       :
 * UPDATE       :
 * RETURN       : void
 * PROGRAMMED   : aisoft
 * DATE(ORG)    : 95/10/30
 * CALL         :
 ********************************************************************/
unsigned short AIcom_ConvertShort1(unsigned short n)
{
    unsigned short n2;

    n2 = htons(n);
    if(n!=n2) {
        return n;
    };

    return ((n&0xFF)<<8)|((n&0xFF00)>>8);
}

/********************************************************************
 * NAME         : AIcom_ConvertFloat
 * FUNCTION     : 转换float
 * PARAMETER    : f(需要转换的float)
 * RETURN       : 转换后的float
 * PROGRAMMER   : Jeffrey Du
 * DATE(ORG)    : 98/06/27
 * UPDATE       :
 ********************************************************************/
float AIcom_ConvertFloat1(float f)
{
    union {
        float         f;
        unsigned int  l;
    } ftoa;

    ftoa.f=f;
    ftoa.l = AIcom_ConvertInt1(ftoa.l);

    return(ftoa.f);
}

double AIcom_ConvertDouble1(d)
double d;
{
	union {
		double	d;
		char	c[8];
	}	dtoa;
	char		cTemp;

	dtoa.d=d;
	
	if(ntohs(1)!=1)
	{
		return(d);
	}
	else
	{
		cTemp=dtoa.c[0];
		dtoa.c[0]=dtoa.c[7];
		dtoa.c[7]=cTemp;
		cTemp=dtoa.c[1];
		dtoa.c[1]=dtoa.c[6];
		dtoa.c[6]=cTemp;
		cTemp=dtoa.c[2];
		dtoa.c[2]=dtoa.c[5];
		dtoa.c[5]=cTemp;
		cTemp=dtoa.c[3];
		dtoa.c[3]=dtoa.c[4];
		dtoa.c[4]=cTemp;
		
		return(dtoa.d);
	}
}


