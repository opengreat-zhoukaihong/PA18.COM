/* rdbuffdll.cpp : Defines the entry point for the DLL application.*/

#include "g_globdef.h"
#include "jtoc_JavaC.h"
#include "typeconvt.h"
#include "asciitobinary.h"
#include "binarytoascii.h"
#include "cpkthead.h"




extern int AIEU_TCPEstablishConnection(char* strHostname, char* strService, int timeout);
extern int AISendPacket(int sockid, char *pBuffSend);
extern char* AIRecvPacket(int sockid, int timeout, int* errflag);
extern int AIEU_TCPClose(int sockid);



JNIEXPORT jbyteArray JNICALL Java_jtoc_JavaC_packetchanege
    (JNIEnv * env, jobject jo,jbyteArray jba, jint lenstr) 
{ 
	int i=0; 
	char *inbuff=NULL;
	jsize insize, outsize; 
	jbyte *inbyte;
	jbyteArray	outbyteArray; 

	int sd=0,nRet,errflag;
	char *pPacket = NULL;
	char *pBuffSend = NULL;
	int rtnVal = 0;
	char *pRtnBuffString = NULL, *pRtnBuffPtr = NULL;
	int  iRntStrLen = 0;
	char strErrorMsg[256];
	int  iPktID;
	PacketHead struPktHead;

	

    #ifdef _DEBUG
	printf("\n\n");
    printf("\n---------------------------------C Begin-------------------------------------\n");
    #endif

    outsize=0;
    

	/*Get the input java buff*/
	insize =  (*env)->GetArrayLength(env, jba); 
	inbyte = (*env)->GetByteArrayElements(env, jba, 0);
	inbuff=(char*)malloc(insize+1);
	if(inbuff==NULL)
	{
        #ifdef _DEBUG
		printf("malloc failed\n");
        #endif		
		sprintf(strErrorMsg, "系统繁忙（内存分配故障）: File:%s, Line:%d", __FILE__, __LINE__);
		rtnVal = -1;
	}

	/*Convert Java String buff to C string buff*/
	if(rtnVal==0)
	{
    	for (i=0;i<lenstr;i++)	inbuff[i]=inbyte[i];
    	inbuff[lenstr]='\0';

        #ifdef _DEBUG
		printf("insize=%d\t lenstr=%d\n", insize, lenstr);
        printf("Current Printable String[%d]:{%s}\n\n\n", strlen(inbuff), inbuff);
        #endif
        
	}

	/*Resolve the ascii string and convert to binary */
	if(rtnVal==0)
	{
		rtnVal = AsciiToBinary(inbuff, lenstr, &pBuffSend, &iPktID);
    	if(rtnVal!=0)
    	{
            #ifdef _DEBUG
    	    printf("Resolve ASCII string failed, return = %d\n", rtnVal);
            #endif    	    
			sprintf(strErrorMsg, "系统繁忙（解析字串出错）, value=%d", rtnVal);
    	    rtnVal = -2;
    	}
    	else
    	{
            #ifdef _DEBUG
    	    printf("*********** Resolve ASCII string successful ************\n\n");   
 			printf("Print the sending string on screen ... ... \n");
			PrintAscPkt(pBuffSend);
			printf("\n************* Finished print the sending string ***************\n");
           #endif    	    
    	}
    }


	/*Stablish connection*/
	if(rtnVal==0)
	{
        #ifdef _DEBUG
	    printf("Connecting ... ...\n");    
        #endif    	    
    	sd = AIEU_TCPEstablishConnection("PA1024","PA18test",10);
    	//sd = AIEU_TCPEstablishConnection("PA1022","PA18",10);
    	if(sd <0) 
    	{
            #ifdef _DEBUG
    		printf("Connect fail!\n");
            #endif    		
			sprintf(strErrorMsg, "系统繁忙（后台业务系统繁忙，请与后台管理人员联系！）");
    		rtnVal = -3;
    	}
    	else
    	{
            #ifdef _DEBUG    	    
        	printf("Connect successful\n");
            #endif        	
    	}
    }

	/*Convert the byte order, and send it to the other end*/
	if(rtnVal==0)
	{
		if(pBuffSend!=NULL)
		{
			#ifdef _DEBUG
			printf("Byte order convert ... ... \n");
			#endif
			BeforSendOrderConvt(pBuffSend);

	        #ifdef _DEBUG    
	    	printf("Sending ... ...\n");
	        #endif    	
			nRet =  AISendPacket(sd, pBuffSend);
    		if(nRet <0) 
    		{
                #ifdef _DEBUG    	
    			printf("Send fail!\n");
                #endif    			
				sprintf(strErrorMsg, "系统繁忙（缓冲区发送错误）");
    			rtnVal = -4;
    		}
    		else
    		{
                #ifdef _DEBUG    		
        		printf("Send succussful !\n");
                #endif    	
            }	
    	}
		else 
		{	
            #ifdef _DEBUG		    
		    printf("Want to send empty buff\n");
            #endif		    
		    rtnVal = -5;
		}
    }


	/*Receive the buff returned*/
	if(rtnVal==0)
	{
        #ifdef _DEBUG
		printf("\n\n***************Wait receive ... ... \n");
        #endif		
		
		pPacket = NULL;
		pPacket = (char *)AIRecvPacket(sd,10,&errflag);
		if(errflag == 1) 
		{
            #ifdef _DEBUG
			printf("Disconnected!\n");
            #endif			
			sprintf(strErrorMsg, "系统繁忙（接收缓冲出错）");
			rtnVal = -6;
		}
		else
		{
            #ifdef _DEBUG
    		printf("Receive sucessful !\n");
            #endif
        }
        
		if(pPacket == NULL) 
		{
            #ifdef _DEBUG
			printf("receive empty!\n");
            #endif
			sprintf(strErrorMsg, "系统繁忙（接收到一个全空的缓冲）");
			rtnVal = -7;
		}
	}

	/*Convert the byte order, and convert binary to ascii string*/
	if(rtnVal==0)
	{
		iRntStrLen = 0;

		#ifdef _DEBUG
		printf("Byte order convert ... ... \n");
		#endif

		AfterRcvOrderConvt(pPacket, iPktID);
		
		#ifdef _DEBUG
		printf("\nBegin BinaryToAscii ... ...\n");
		#endif
		
		rtnVal = BinaryToAscii(pPacket, iPktID, &pRtnBuffString, &iRntStrLen);
		printf("rtnVal %d.................\n",rtnVal);
		if(rtnVal!=0)
		{
		    #ifdef _DEBUG
			printf("Resolve binary packet to ASCII string failed: return=%d\n", rtnVal);
			#endif
			sprintf(strErrorMsg, "系统繁忙（解析二进制包出错）, value=%d", rtnVal);
			rtnVal = -8;
		}
		else
		{
		    #ifdef _DEBUG
			printf("******* Resolve binary packet to ASCII string sucessful ************\n");
			printf("Return string[%d]:{%s}\n", iRntStrLen, pRtnBuffString);

			printf("*************Print the received buff on screen ... ... \n");
 			PrintReplyBinPkt(pPacket, iPktID);
			printf("\n*********** Finished Print the received buff ***************\n");
			#endif

			/*return the ascii buff to java program*/
			outsize = iRntStrLen;
			outbyteArray = (*env)->NewByteArray(env, outsize);
			(*env)->SetByteArrayRegion(env, outbyteArray, 0, outsize, (jbyte*)pRtnBuffString);
		}		

	}
	/*release the socket connect if it has been connected*/
	if(rtnVal != -3) AIEU_TCPClose(sd);

	/*release all resource*/
	free(inbuff);
	free(pPacket);
	free(pBuffSend);
	free(pRtnBuffString);

	inbuff = NULL;
	pPacket = NULL;
	pBuffSend = NULL;
	pRtnBuffString = NULL;


	if(rtnVal==0)
	{
        #ifdef _DEBUG
        printf("\n********** C OK ************\n");
		#endif
	}
	else
    {	/*If it has failed somewhere, return the error message, 
		* Don't return empty buff to java, else java will core dump
		*/
		memset(&struPktHead, 0, sizeof(PacketHead));
		struPktHead.cRetCode = rtnVal;
		struPktHead.lPacketSize = sizeof(PacketHead) + strlen(strErrorMsg);
		pRtnBuffString = malloc(struPktHead.lPacketSize+MAXLENLEN*MAXFIELDCOUNT
								+sizeof(strErrorMsg));
		pRtnBuffPtr = pRtnBuffString;
		if(pRtnBuffPtr==NULL)
		{
			#ifdef _DEBUG
			printf("$$$$$$ Fatatal error, reboot the machine, File:%s, Line%d $$$$$$$$$", __FILE__, __LINE__);
			#endif

			outbyteArray = (*env)->NewByteArray(env, 0);
			(*env)->SetByteArrayRegion(env, outbyteArray, 0, 0, (jbyte*)NULL);
		}
		else
		{
			iRntStrLen = 0;
			StruPKTHeadToStr(&struPktHead, &pRtnBuffPtr, &iRntStrLen);
			StrToStr(strErrorMsg, &pRtnBuffPtr, &iRntStrLen);

			outsize = iRntStrLen;
			outbyteArray = (*env)->NewByteArray(env, outsize);
			(*env)->SetByteArrayRegion(env, outbyteArray, 0, outsize, (jbyte*)pRtnBuffString);
		}

		#ifdef _DEBUG
		printf("\n****** C Failed **********\n");
		#endif

		free(inbuff);
		free(pPacket);
		free(pBuffSend);
		free(pRtnBuffString);
    }


    #ifdef _DEBUG
	printf("--------------------------------- C program end -----------------------------\n\n\n\n");
	#endif
	return outbyteArray;
} 
