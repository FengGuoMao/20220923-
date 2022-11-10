package src;//package com.*.*.*.utiles;
/*
 * https://blog.csdn.net/qq_36942720/article/details/125409414
 * */

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;

public class PBKDF2 {
    public static final String PBKDF2_ALGORITHM = "PBKDF2WithHmacSHA1";

    //盐的长度
    public static final int SALT_SIZE = 16;

    //生成密文的长度
    public static final int HASH_SIZE = 16;

    // 迭代次数
    public static final int PBKDF2_ITERATIONS = 1000;

    /**
     * 对输入的密码进行验证
     * password 密码明文
     * dataPassWord 密码加密
     */
    public static boolean verify(String password, String dataPassWord)
            throws NoSuchAlgorithmException, InvalidKeySpecException {
        // 用相同的盐值对用户输入的密码进行加密  
        String result = getPBKDF2(password, dataPassWord.substring(0, 16));
        // 把加密后的密文和原密文进行比较，相同则验证成功，否则失败  
        return result.equals(dataPassWord.substring(16, dataPassWord.length()));
    }

    /**
     * 根据password和salt生成密文
     */
    public static String getPBKDF2(String password, String salt) throws NoSuchAlgorithmException,
            InvalidKeySpecException {
        //将16进制字符串形式的salt转换成byte数组
        byte[] bytes = DatatypeConverter.parseHexBinary(salt);
        KeySpec spec = new PBEKeySpec(password.toCharArray(), bytes, PBKDF2_ITERATIONS, HASH_SIZE * 4);
        SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance(PBKDF2_ALGORITHM);
        byte[] hash = secretKeyFactory.generateSecret(spec).getEncoded();
        //将byte数组转换为16进制的字符串
        return DatatypeConverter.printHexBinary(hash);
    }
public String getMiwen(String password,String salt) {
    String MIWEN = null;
    try {
        MIWEN = getPBKDF2(password, salt);
    } catch (Exception e) {
        e.printStackTrace();
    }
    return MIWEN;
}

    /**
     * 生成随机盐值
     */
    public String getSalt() throws NoSuchAlgorithmException {
        SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
        byte[] bytes = new byte[SALT_SIZE / 2];
        random.nextBytes(bytes);
        //将byte数组转换为16进制的字符串
        String salt = DatatypeConverter.printHexBinary(bytes);
        return salt;
    }
  /*  public String getmiwen2(String miwen){
        return miwen;
    }*/

    public void main() {
        try {
//            String salt= getSalt();
            String salt = "9D6EDFE87496B9E8";
            System.out.println("salt:" + salt);//获取salt
//            String miwen = getPBKDF2("2564", salt); //明文密码加密
            String miwen = "B0F2C8AF8D19EA93"; //明文密码加密
            int i = 1;
            i++;
            System.out.println(i);
            System.out.println("miwen:" + miwen);
            System.out.println(salt + miwen);
            System.out.println(verify("2564", salt + miwen));//解密


        } catch (Exception e) {
            e.printStackTrace();
        }
        Scr scr = new Scr();

    }
}
