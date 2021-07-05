package me.ly.encry;


import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

public class TestEncry2 {


    public static void main(String[] args) {
        String str = "a6e7afee8bd546ed28bc435f23579196_6.14.0.0.1_huawei_VENUS_venus_1617186740000";
        String psw = "MTIzNDU2";
        try {
            int total = 1000000;
            int cnt = total;
            long enTime = 0;
            long deTime = 0;
            while (cnt-- > 0) {
                long t1 = System.currentTimeMillis();
                byte[] encrypt = encryptOrdecrypt(true, str.getBytes("UTF-8"), psw, null, AESType.AES_128, "AES/CBC/PKCS5Padding");
                byte[] encode = Base64.getEncoder().encode(encrypt);

                long t2 = System.currentTimeMillis();
                byte[] bytes2 = encryptOrdecrypt(false, Base64.getDecoder().decode(encode), psw, null, AESType.AES_128, "AES/CBC/PKCS5Padding");

                long t3 = System.currentTimeMillis();
                enTime += t2 - t1;
                deTime += t3 - t2;
            }
            System.out.println(enTime + " pre " + enTime / total);
            System.out.println(deTime + " pre " + deTime / total);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (InvalidAlgorithmParameterException e) {
            e.printStackTrace();
        }


    }


    public static byte[] encryptAES(String content, String key)
            throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, BadPaddingException,
            IllegalBlockSizeException, UnsupportedEncodingException {
        KeyGenerator kgen = KeyGenerator.getInstance("AES");
        //此处解决mac，linux报错
        SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
        random.setSeed(key.getBytes());
        kgen.init(128, random);
        SecretKey secretKey = kgen.generateKey();
        byte[] enCodeFormat = secretKey.getEncoded();
        SecretKeySpec keySpec = new SecretKeySpec(enCodeFormat, "AES");
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");// 创建密码器
        cipher.init(Cipher.ENCRYPT_MODE, keySpec);
        byte[] result = cipher.doFinal(content.getBytes("UTF-8"));
        return result;
    }

    public static byte[] toByteArray(String hexString) {
        if (hexString.isEmpty())
            throw new IllegalArgumentException("this hexString must not be empty");

        hexString = hexString.toLowerCase();
        final byte[] byteArray = new byte[hexString.length() / 2];
        int k = 0;
        for (int i = 0; i < byteArray.length; i++) {//因为是16进制，最多只会占用4位，转换成字节需要两个16进制的字符，高位在先
            byte high = (byte) (Character.digit(hexString.charAt(k), 16) & 0xff);
            byte low = (byte) (Character.digit(hexString.charAt(k + 1), 16) & 0xff);
            byteArray[i] = (byte) (high << 4 | low);
            k += 2;
        }
        return byteArray;
    }

    public static byte[] hexStringToBytes(String hexString) {
        if (hexString == null || hexString.equals("")) {
            return null;
        }
        hexString = hexString.toUpperCase();
        int length = hexString.length() / 2;
        char[] hexChars = hexString.toCharArray();
        byte[] d = new byte[length];
        for (int i = 0; i < length; i++) {
            int pos = i * 2;
            d[i] = (byte) (charToByte(hexChars[pos]) << 4 | charToByte(hexChars[pos + 1]));
        }
        return d;
    }

    private static byte charToByte(char c) {
        return (byte) "0123456789ABCDEF".indexOf(c);
    }

    public static byte[] decryptAESS(byte[] content, String key) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, BadPaddingException,
            IllegalBlockSizeException, UnsupportedEncodingException {
        KeyGenerator kgen = KeyGenerator.getInstance("AES");
        SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
        random.setSeed(key.getBytes());
        kgen.init(128, random);
        SecretKey secretKey = kgen.generateKey();
        byte[] enCodeFormat = secretKey.getEncoded();
        SecretKeySpec keySpec = new SecretKeySpec(enCodeFormat, "AES");
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");// 创建密码器
        cipher.init(Cipher.DECRYPT_MODE, keySpec);
//        byte[] result = cipher.doFinal(content.getBytes(Charset.defaultCharset()));
        byte[] result = cipher.doFinal(content);
        return result;
    }

    private static byte[] encryptOrDecrypt(int mode, byte[] byteContent, String key, byte[] iv, AESType type, String modeAndPadding) throws InvalidKeyException, NoSuchAlgorithmException, InvalidAlgorithmParameterException, NoSuchPaddingException, BadPaddingException, IllegalBlockSizeException {
        KeyGenerator kgen = KeyGenerator.getInstance("AES");
        //此处解决mac，linux报错
        SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
        random.setSeed(key.getBytes());
        kgen.init(type.value, random);
        SecretKey secretKey = kgen.generateKey();
        byte[] enCodeFormat = secretKey.getEncoded();
        SecretKeySpec keySpec = new SecretKeySpec(enCodeFormat, "AES");
        Cipher cipher = Cipher.getInstance(modeAndPadding);// 创建密码器
        if (null != iv) {
            //指定一个初始化向量 (Initialization vector，IV)， IV 必须是16位
            cipher.init(mode, keySpec, new IvParameterSpec(iv));
        } else {
            cipher.init(mode, keySpec);
        }
        byte[] result = cipher.doFinal(byteContent);
        return result;
    }


    enum AESType {
        AES_128(128), AES_192(192), AES_256(256);
        public int value;

        private AESType(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }

    public static byte[] encryptOrdecrypt(boolean isEncrypt, byte[] source, String key, byte[] iv, AESType type, String encodeType) throws UnsupportedEncodingException, InvalidAlgorithmParameterException, NoSuchAlgorithmException, NoSuchPaddingException, BadPaddingException, IllegalBlockSizeException, InvalidKeyException {
        if (isEncrypt) {
            byte[] encodeByte = encryptOrDecrypt(Cipher.ENCRYPT_MODE, source, key, iv, type, encodeType);
            return encodeByte;
        } else {
            byte[] decodeByte = encryptOrDecrypt(Cipher.DECRYPT_MODE, source, key, iv, type, encodeType);
            return decodeByte;
        }
    }


}
