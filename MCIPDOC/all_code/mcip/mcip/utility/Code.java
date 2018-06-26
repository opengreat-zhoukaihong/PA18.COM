////////////////////////////////////////////////////////
// Updateú¦ZhangJinQuan
// Funciton: for encrypt and decrypt
// Create dateú¦2000/08/10
// UPdate dateú¦2000/08/10
////////////////////////////////////////////////////////
package utility;

public class Code
{
    private static char base_64[] = 
    {
        'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P',
        'Q','R','S','T','U','V','W','X','Y','Z','a','b','c','d','e','f',
        'g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v',
        'w','x','y','z','0','1','2','3','4','5','6','7','8','9','+','-'
    };

    static int base_64_reverse[]=
    {
        -1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,
        -1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,
        -1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,62,-1,63,-1,-1,
        52,53,54,55,56,57,58,59,60,61,-1,-1,-1,-1,-1,-1,
        -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9,10,11,12,13,14,
        15,16,17,18,19,20,21,22,23,24,25,-1,-1,-1,-1,-1,
        -1,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,
        41,42,43,44,45,46,47,48,49,50,51,-1,-1,-1,-1,-1,
        -1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,
        -1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,
        -1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,
        -1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,
        -1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,
        -1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,
        -1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,
        -1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1
    };


    private static String Encode_8b_6b(char inbuf[])
    {
        int length = inbuf.length;
        
        if (length<1)
            return("");

        char outbuf[] = new char[( (int)((length+2)/3) )*4 ];
        int unit,i;
        String result;
        unit=length/3;    // 3
        
        for(i=0;i<unit;i++)
        {
                int b1,b2,b3,b4;

                b1=inbuf[i*3]>>2;
                b2=((inbuf[i*3]&3)<<4)|(inbuf[i*3+1]>>4);
                b3=((inbuf[i*3+1]&0x0f)<<2)|(inbuf[i*3+2]>>6);
                b4=inbuf[i*3+2]&0x3f;
                outbuf[i*4+0]=base_64[b1];
                outbuf[i*4+1]=base_64[b2];
                outbuf[i*4+2]=base_64[b3];
                outbuf[i*4+3]=base_64[b4];
        }

        /* ´˜×„®‹©¦ş…Ì°™©×Ì3´ıØ“×²˜µ×˜µÕ×úÔ€×²¾œ´ı³ªÁ */
        if(unit*3<length)
        {
                int b1,b2,b3,b4,a1,a2;

                b4=b3=b2=b1=0; a2=a1=0;
                if((length-unit*3)>1) a2=inbuf[unit*3+1];
                if((length-unit*3)>0) a1=inbuf[unit*3];

                b3=(a2&0x0f)<<2;
                b2=((a1&3)<<4)|(a2>>4);
                b1=a1>>2;

                outbuf[unit*4+0]=base_64[b1];
                outbuf[unit*4+1]=base_64[b2];
                outbuf[unit*4+2]=base_64[b3];
                outbuf[unit*4+3]=base_64[b4];
        }

        result= new String(outbuf);
        return(result);
    }
    
    
    private static String Decode_6b_8b(char inbuf[])
    {
        int inlen = inbuf.length;
        int outlen = ((inlen/4) * 3 - 2) + 4;
        
        
        int unit,i,uselen;
        boolean ret;
        char outbuf[] = new char[outlen];

        ret = true;             /* ­Œ™‰×„®‹×²¾œ×Ì¸±¦Î¸¿ */

        /* ¹·¾œ×„®‹¦Í×„ş÷©¦ş…Ì°´ı³Ïí¾÷µ¿ÒíÔÈıı¹÷şñµ® */
        if(outlen*4>inlen*3)
        {
                unit=inlen/4;
                uselen=0;             /* ÒíÔÈ×„®‹©¦ş…Ì°´ışñµ® */
        }
        else
        {
                unit=outlen/3;
                uselen=1;             /* ÒíÔÈ×„®‹©¦ş…Ì°´ışñµ® */
        }

        if( (unit<1) && ((inlen<1)||(outlen<1)) )
                return("");

        for(i=0;i<unit;i++)
        {
                int a1,a2,a3;
                int b1,b2,b3,b4;

                b1=base_64_reverse[inbuf[i*4+0]];
                b2=base_64_reverse[inbuf[i*4+1]];
                b3=base_64_reverse[inbuf[i*4+2]];
                b4=base_64_reverse[inbuf[i*4+3]];

                if( (b1<0) || (b2<0) || (b3<0) || (b4<0) )
                {
                        if(b1<0) b1=0;
                        if(b2<0) b2=0;
                        if(b3<0) b3=0;
                        if(b4<0) b4=0;
                        ret=false;
                }

                a1=(b1<<2)|(b2>>4);
                a2=((b2&0x0f)<<4)|(b3>>2);
                a3=((b3&0x3)<<6)|b4;
                outbuf[i*3+0]=(char) a1;
                outbuf[i*3+1]=(char) a2;
                outbuf[i*3+2]=(char) a3;
        }

        /* ´˜×„®‹©¦ş…Ì°™©×Ì4´ıØ“×²˜µ×˜µÕ×úÔ€×²¾œ´ı³ªÁ */
        /* ©ø×„ş÷©¦ş…Ì°™©×Ì3´ıØ“×²˜µ×˜µÕ×úÔ€×²¾œ´ı³ªÁ */
        if( (uselen==0)&&(unit*4<inlen) ||
                (uselen==1)&&(unit*3<outlen) )
        {
                int a1,a2,a3;
                int b1,b2,b3,b4;

                b1=b2=b3=b4=0; a1=a2=a3=0;

                if((inlen-unit*4)>2) b3=base_64_reverse[inbuf[unit*4+2]];
                if((inlen-unit*4)>1) b2=base_64_reverse[inbuf[unit*4+1]];
                if((inlen-unit*4)>0) b1=base_64_reverse[inbuf[unit*4+0]];

                if( (b1<0) || (b2<0) || (b3<0) )
                {
                        if(b1<0) b1=0;
                        if(b2<0) b2=0;
                        if(b3<0) b3=0;
                        ret=false;
                }

                a1=(b1<<2)|(b2>>4);
                a2=((b2&0x0f)<<4)|(b3>>2);
                a3=((b3&0x3)<<6)|b4;
                if((outlen-unit*3)>0) outbuf[unit*3+0]=(char) a1;
                if((outlen-unit*3)>1) outbuf[unit*3+1]=(char) a2;
                if((outlen-unit*3)>2) outbuf[unit*3+2]=(char) a3;
        }

        String stemp = new String(outbuf);
        return(stemp.trim());
    }


    public static String Encrypt(String inStr)
    {
         if (inStr == null)
             return "";
             
         int l = inStr.length();
         char c[] = new char[l];
         for (int i=0;i<l;i++)
         {
                c[i] = (char) (inStr.charAt(i) ^ 0xff);
         }
         String enc = Encode_8b_6b(c);
    
         return enc;
    }


    public static String Decrypt(String inStr)
    {
         //System.out.println(inStr);
         if (inStr == null)
             return "";
         
         int l = inStr.length();
         char c[] = new char[l];
         for (int i=0;i<l;i++)
         {
                c[i] = inStr.charAt(i);
                if (((int) c[i]) == 32) c[i] = '+';
         }
        
         String dec = Decode_6b_8b(c);
         //System.out.println(dec);
             
         l = dec.length();
         char cc[] = new char[l];
         for (int i=0;i<l;i++)
             cc[i] = (char) (dec.charAt(i) ^ 0xff);
             
             
         //System.out.println(new String(cc));
         return (new String(cc));
    }


    public static byte[] encode_8b_6b(byte temp[])
    {
        int length = temp.length;
        //System.out.println(length);

        if (length<1)
            return null;

        int inbuf[] = new int[length];

        for (int ii=0;ii<length;ii++)
        {
                inbuf[ii] = (int)temp[ii];
                inbuf[ii] = inbuf[ii] & 0x00ff;
        }        

        byte outbuf[] = new byte[( (int)((length+2)/3) )*4 +4];
        //System.out.println(outbuf.length);

        //System.out.println("function begin");
        int unit,i;
        unit=length/3;    // 3

        //System.out.println(unit);
        for(i=0;i<unit;i++)
        {
            int b1,b2,b3,b4;

            try
            {
                b1=(inbuf[i*3]>>2) & 0x00ff;
                b2=(((inbuf[i*3]&3)<<4)|(inbuf[i*3+1]>>4)) & 0x00ff;
                b3=(((inbuf[i*3+1]&0x0f)<<2)|(inbuf[i*3+2]>>6)) & 0x00ff;
                b4=(inbuf[i*3+2]&0x3f) & 0x00ff;

                outbuf[i*4+0]=(byte) base_64[b1];
                outbuf[i*4+1]=(byte) base_64[b2];
                outbuf[i*4+2]=(byte) base_64[b3];
                outbuf[i*4+3]=(byte) base_64[b4];
            }
            catch (Exception e){break;}
        }

        //System.out.println("function middle");
        /* ´˜×„®‹©¦ş…Ì°™©×Ì3´ıØ“×²˜µ×˜µÕ×úÔ€×²¾œ´ı³ªÁ */
        if(unit*3<length)
        {
                int b1,b2,b3,b4,a1,a2;

                b4=b3=b2=b1=0; a2=a1=0;
                if((length-unit*3)>1) a2=inbuf[unit*3+1];
                if((length-unit*3)>0) a1=inbuf[unit*3];

                b3=((a2&0x0f)<<2) & 0x00ff;
                b2=(((a1&3)<<4)|(a2>>4)) & 0x00ff;
                b1=(a1>>2) & 0x00ff;

                outbuf[unit*4+0]=(byte) base_64[b1];
                outbuf[unit*4+1]=(byte) base_64[b2];
                outbuf[unit*4+2]=(byte) base_64[b3];
                outbuf[unit*4+3]=(byte) base_64[b4];
        }
        //System.out.println("function end");
        return(outbuf);
    }


    private static byte[] decode_6b_8b(byte temp[])
    {
        int length = temp.length;
        if (length<1)
            return null;
        int inbuf[] = new int[length];
        for (int ii=0;ii<length;ii++)
        {
                inbuf[ii] = (int)temp[ii];
                inbuf[ii] = inbuf[ii] & 0x00ff;
        }


        int inlen = inbuf.length + 1;
        int outlen = ((inlen/4) * 3 - 2 +3);
        
        
        int unit,i,uselen;
        boolean ret;
        byte outbuf[] = new byte[outlen];

        ret = true;             /* ­Œ™‰×„®‹×²¾œ×Ì¸±¦Î¸¿ */

        /* ¹·¾œ×„®‹¦Í×„ş÷©¦ş…Ì°´ı³Ïí¾÷µ¿ÒíÔÈıı¹÷şñµ® */
        if(outlen*4>inlen*3)
        {
                unit=inlen/4;
                uselen=0;             /* ÒíÔÈ×„®‹©¦ş…Ì°´ışñµ® */
        }
        else
        {
                unit=outlen/3;
                uselen=1;             /* ÒíÔÈ×„®‹©¦ş…Ì°´ışñµ® */
        }

        if( (unit<1) && ((inlen<1)||(outlen<1)) )
                return null;

        for(i=0;i<unit;i++)
        {
            try
            {
                int a1,a2,a3;
                int b1,b2,b3,b4;

                b1=base_64_reverse[inbuf[i*4+0]];
                b2=base_64_reverse[inbuf[i*4+1]];
                b3=base_64_reverse[inbuf[i*4+2]];
                b4=base_64_reverse[inbuf[i*4+3]];

                if( (b1<0) || (b2<0) || (b3<0) || (b4<0) )
                {
                        if(b1<0) b1=0;
                        if(b2<0) b2=0;
                        if(b3<0) b3=0;
                        if(b4<0) b4=0;
                        ret=false;
                }

                a1=((b1<<2)|(b2>>4)) & 0x00ff;
                a2=(((b2&0x0f)<<4)|(b3>>2)) & 0x00ff;
                a3=(((b3&0x3)<<6)|b4) & 0x00ff;
                outbuf[i*3+0]=(byte) a1;
                outbuf[i*3+1]=(byte) a2;
                outbuf[i*3+2]=(byte) a3;
            }
            catch (Exception e) {break;}
        }
        //System.out.println("function middle");

        /* ´˜×„®‹©¦ş…Ì°™©×Ì4´ıØ“×²˜µ×˜µÕ×úÔ€×²¾œ´ı³ªÁ */
        /* ©ø×„ş÷©¦ş…Ì°™©×Ì3´ıØ“×²˜µ×˜µÕ×úÔ€×²¾œ´ı³ªÁ */
        if( (uselen==0)&&(unit*4<inlen) ||
                (uselen==1)&&(unit*3<outlen) )
        {
            try
            {
                int a1,a2,a3;
                int b1,b2,b3,b4;

                b1=b2=b3=b4=0; a1=a2=a3=0;

                if((inlen-unit*4)>2) b3=base_64_reverse[inbuf[unit*4+2]];
                if((inlen-unit*4)>1) b2=base_64_reverse[inbuf[unit*4+1]];
                if((inlen-unit*4)>0) b1=base_64_reverse[inbuf[unit*4+0]];

                if( (b1<0) || (b2<0) || (b3<0) )
                {
                        if(b1<0) b1=0;
                        if(b2<0) b2=0;
                        if(b3<0) b3=0;
                        ret=false;
                }

                a1=((b1<<2)|(b2>>4)) & 0x00ff;;
                a2=(((b2&0x0f)<<4)|(b3>>2)) & 0x00ff;;
                a3=(((b3&0x3)<<6)|b4) & 0x00ff;;
                if((outlen-unit*3)>0) outbuf[unit*3+0]=(byte) a1;
                if((outlen-unit*3)>1) outbuf[unit*3+1]=(byte) a2;
                if((outlen-unit*3)>2) outbuf[unit*3+2]=(byte) a3;
            }
            catch (Exception e) {}
        }

     return outbuf;
    }

}
    