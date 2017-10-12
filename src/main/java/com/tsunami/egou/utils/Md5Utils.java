package com.tsunami.egou.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Md5Utils {
	/**
	 * 
	 * @param pwd：未加密码的密码
	 * @return 加密之后的密码
	 */
	public static String getMD5Pwd(String pwd){
		/*
		 * md5加密步骤：
		 * 1.获得一个信息摘要
		 * 2.将未加密码的密码转成字节数组
		 * 3.将字节数组中每个字节与8个2进制作与运算
		 * 4.将每个字节与运算之后的结果转成字符串，不足位补0
		 */
		try {
			//获得一个信息摘要
			MessageDigest digest = MessageDigest.getInstance("md5");
			//将未加密码的密码转成字节数组
			byte[] bytes = digest.digest(pwd.getBytes());
			StringBuilder sb = new StringBuilder();
			//将字节数组中每个字节与8个2进制作与运算
			for(byte b:bytes){
				int num = b & 0Xfff;	//加盐
				//将每个字节与运算之后的结果转成字符串，不足位补0
				String numStr = Integer.toHexString(num);
				if(numStr.length()==1){
					sb.append("0"+numStr);
				}else{
					sb.append(numStr);
				}
			}
			return sb.toString();
			
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return null;
	}
	
	public static String encode(String text){
		/*
		 * md5加密步骤：
		 * 1.获得一个信息摘要
		 * 2.将未加密码的密码转成字节数组
		 * 3.将字节数组中每个字节与8个2进制作与运算
		 * 4.将每个字节与运算之后的结果转成字符串，不足位补0
		 */
		try {
			//获得一个信息摘要
			MessageDigest digest = MessageDigest.getInstance("md5");
			//将未加密码的密码转成字节数组
			byte[] bytes = digest.digest(text.getBytes());
			StringBuilder sb = new StringBuilder();
			//将字节数组中每个字节与8个2进制作与运算
			for(byte b:bytes){
				int num = b & 0Xfff; //加盐	
				//将每个字节与运算之后的结果转成字符串，不足位补0
				String numStr = Integer.toHexString(num);
				if(numStr.length()==1){
					sb.append("0"+numStr);
				}else{
					sb.append(numStr);
				}
			}
			return sb.toString();
			
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void main(String[] args) {
		String md5 = encode("123456");
		System.out.println(md5);
		// 原文    第一次加密   第二次加密  第三次加
	}
}
