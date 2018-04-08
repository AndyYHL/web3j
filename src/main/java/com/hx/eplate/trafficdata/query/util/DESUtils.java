
package com.hx.eplate.trafficdata.query.util;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/**
 * DES加解密工具
 * Version: 1.0<br>
 * Date: 2017年8月30日
 */
public class DESUtils {
	
	/**
	 * 解密数据
	 * Date: 2017年8月30日<br>
	 * @return String
	 */
	public static String decrypt(String message, String key, String specIv) throws Exception {
		byte[] bytesrc = convertHexString(message);
		Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
		DESKeySpec desKeySpec = new DESKeySpec(key.substring(0, 8).getBytes("UTF-8"));
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
		SecretKey secretKey = keyFactory.generateSecret(desKeySpec);
		IvParameterSpec iv = new IvParameterSpec(specIv.substring(0, 8).getBytes("UTF-8"));
		cipher.init(Cipher.DECRYPT_MODE, secretKey, iv);
		byte[] retByte = cipher.doFinal(bytesrc);
		return new String(retByte);
	}
	 
	/**
	 * 加密数据
	 * Date: 2017年8月30日<br>
	 * @return String
	 */
	public static String encrypt(String message, String key, String specIv) throws Exception {
		Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
		DESKeySpec desKeySpec = new DESKeySpec(key.substring(0, 8).getBytes("UTF-8"));
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
		SecretKey secretKey = keyFactory.generateSecret(desKeySpec);
		IvParameterSpec iv = new IvParameterSpec(specIv.substring(0, 8).getBytes("UTF-8"));
		cipher.init(Cipher.ENCRYPT_MODE, secretKey, iv);
		byte[] b = cipher.doFinal(message.getBytes("UTF-8"));
		return toHexString(b);
	}
	
	/**
	 * 解密数据
	 * Date: 2017年8月31日<br>
	 * @return String
	 */
	public static String decryptDES(String message, String key, String specIv) throws Exception {
		byte[] byteMi = Base64.decode(message);
		IvParameterSpec zeroIv = new IvParameterSpec(specIv.getBytes());
		SecretKeySpec skey = new SecretKeySpec(key.getBytes(), "DES");
		Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
		cipher.init(Cipher.DECRYPT_MODE, skey, zeroIv);
		byte decryptedData[] = cipher.doFinal(byteMi);
		return new String(decryptedData);
	}
	
	/**
	 * 加密数据
	 * Date: 2017年8月31日<br>
	 * @return String
	 */
	public static String encryptDES(String message, String key, String specIv) throws Exception {
		IvParameterSpec zeroIv = new IvParameterSpec(specIv.getBytes());
		SecretKeySpec skey = new SecretKeySpec(key.getBytes(), "DES");
		Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
		cipher.init(Cipher.ENCRYPT_MODE, skey, zeroIv);
		byte[] encryptedData = cipher.doFinal(message.getBytes());
		return Base64.encode(encryptedData);
	}

	/**
	 * 16进制数据转换成字符串
	 * Date: 2017年8月30日<br>
	 * @return String
	 */
	public static byte[] convertHexString(String s) {
		byte digest[] = new byte[s.length() / 2];
		for (int i = 0; i < digest.length; i++) {
			String byteString = s.substring(2 * i, 2 * i + 2);
			int byteValue = Integer.parseInt(byteString, 16);
			digest[i] = (byte) byteValue;
		}
		return digest;
	}

	/**
	 * 字符串转换成16进制数据
	 * Date: 2017年8月30日<br>
	 * @return String
	 */
	public static String toHexString(byte b[]) {
		StringBuffer hexString = new StringBuffer();
		for (int i = 0; i < b.length; i++) {
			String plainText = Integer.toHexString(0xff & b[i]);
			if (plainText.length() < 2)
				plainText = "0" + plainText;
			hexString.append(plainText);
		}
		return hexString.toString();
	}
	
	public static void main(String[] args) {
		try {
			String string="49C67B1C0FC093B6922303791220BCF2B0687E0D333A3E74";
			String str=decrypt(string,"PatrickpanP=","Mycoineagel=");
			System.out.println(str);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}