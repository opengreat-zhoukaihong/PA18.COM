#ifndef _ASCIITOBINARY_H_
#define _ASCIITOBINARY_H_

/*Func: convert ascii string to binary
*
* Input param: 
*			inbuff  --> ascii string buff 
*			ilenStr --> ascii string length
*
* Output param:
*			ppBuffSend --> the converted binary header pointer, 
*							in this function, it's memory will be alloced.
*							Don't malloc memory for the param beyond the function again.
*			piPktID    --> this packet ID
*
* Return:	
*			0	--> OK
*			<0	--> Failed
* 
*/
int AsciiToBinary(char* inbuff, int ilenStr, char** ppBuffSend, int *piPktID);





/*Before send to the server, byte order should be converted, 
* Type with one byte, such as 'char', is not need to convert.
*/
void BeforSendOrderConvt(char* pbuff);





/* Print each structure content on screen.
* It is used only for debug 
*/
void PrintAscPkt(char* pbuff);



#endif
