package jingcheng.utils.MD5;

import org.apache.commons.codec.digest.DigestUtils;


/**
 * 
 * @ClassName: MD5Util 
 * @Description: MD5加密工具类
 * @author WinZhong
 * @date 2017年5月22日 下午2:31:14
 */
public class MD5Util {
	
	
	public static void main(String[] args){
		System.out.println(MD5Util.hexSALT("000000","CreditCardкредитныекарты"));
	}
	

	/**
	 * MD5加密字符串
	 * @param data
	 * @return
	 */
	public static String hex(String data){
		return DigestUtils.md5Hex(data);
	}

	/**
	 * MD5加密字符串 ，盐值混淆
	 * @param data
	 * @param salt
	 * @return
	 */
	public static String hexSALT(String data,String salt){
		return DigestUtils.md5Hex(data+salt);
	}
	
}
