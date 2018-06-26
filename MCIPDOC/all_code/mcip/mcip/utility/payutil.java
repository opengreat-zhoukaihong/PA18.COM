/*
 * @(#)payutil.java
 *
 * History:
 *       02-16-2001        古立夫 - created
 *
 * Copyright (c) 2000-2001
 * PA Online.
 * All Rights Reserved.
 *
 * This is UNPUBLISHED PROPRIETARY SOURCE CODE of PA Online.
 * The contents of this file may not be disclosed to third 
 * parties, copied or duplicated in any form, in whole or in part, 
 * without the prior written permission of PA Online.
 */
package utility;
import java.math.BigInteger;
import java.security.*;
import java.security.interfaces.*;

/** 支付通讯加密和数据校验程序 
 * 
 * 提供有两个公用静态方法，分别提供以下功能
 * 1 用RSA(1024 BIT)加密支付请求数据，保证支付请求数据不被篡改
 * 2 校验RSA-MD5数字签名，校验支付响应消息不被篡改
 *
 * @author Gu Lifu
 * @version 1.00 2001-02-16
*/
public class payutil{
	private static BigInteger n= new BigInteger("00819A8BD6A8629370EF7E51B4036FF51EA06BA5960A6E4EEE4A66556380997583DF3C208010E2BC83B5C6BF584BA16EE2ABE3E701DAA2FB7D522058977CB43ECE7C2ED8B44E1B8524FC4AE660BA3F724015049AE16B45E7081A13A51F2B71DCE3E2F9EFBF968EAC4412411E59DD9CB658E7356592C08A9CD3281F60AF85A46919", 16);
	private static BigInteger e= new BigInteger("010001", 16);

	/* 用RSA1024加密支付请求数据
	 * 
	 * @param plainText 要加密的支付请求数据，他按规定格式组成，长度为40个ascii char
	 *
	 * @return 用RSA1024加密后的密文
	 */
	public static String buildCiphertext(String plainText) {
		if(plainText.getBytes().length!= 90) return null;
		byte[] b128= null;

		try {
			java.text.SimpleDateFormat sdf= new java.text.SimpleDateFormat("yyyyMMddHHmmss");
			String time= sdf.format( new java.util.Date());
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			byte[] bs= (time+plainText).getBytes();
			byte[] b112= new byte[112];

			java.util.Random rd= new java.util.Random();
			byte[] b8= new byte[8];
			rd.nextBytes( b8);
			b8[0]= 0x01;
			System.arraycopy(b8, 0, b112, 0, 8);
			System.arraycopy(bs, 0, b112, 8, 104);

			md5.update( b112 );
			byte[] hash= md5.digest();
		
			b128= new byte[128];
			System.arraycopy(b112, 0, b128, 0, 112);
			System.arraycopy(hash, 0, b128, 112, 16);
		}catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
		BigInteger src= new BigInteger( b128 );
		return src.modPow( e, n).toString(16);
	}
	
	/* 校验支付响应的数字签名
	 *
	 * @param src 数字签名的数据
	 * @param signareText 数字签名
	 *
	 * @return 校验结果，true为数字签名正确
	 */
	public static boolean verify(String src, String signareText) {
		try {
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			md5.update(src.getBytes());
			byte[] b16= md5.digest();
			
			BigInteger sign= new BigInteger(signareText, 16);
			BigInteger org_md5= sign.modPow( e, n);
			
			byte[] b128= org_md5.toByteArray();
			int offset= b128.length- b16.length;
			for(int i= 0; i< b16.length; i++) {
				if( b16[i]!= b128[offset+i]) return false;
			}
			return true;
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}
}
