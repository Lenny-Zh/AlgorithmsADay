package me.ly;

import javax.crypto.*;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.*;
import java.util.Base64;

/**
 * 加密算法类(精选效率较高的实现算法)
 *
 * @author Jodie
 * @email angviza@gmail.com Create On 2014年11月19日 上午1:54:19
 *
 */
public class EncryptUtil {

	private final static String[] hexDigits = { "0", "1", "2", "3", "4", "5",
			"6", "7", "8", "9", "a", "b", "c", "d", "e", "f" };

	// 电影加密
    public static final String MOVIE_URL_DES_PASSWORD = "$#wemovie@2020.ddkj.me#$";  // 电影加密

    public static String byteArrayToHexString(byte[] b) {
		StringBuffer resultSb = new StringBuffer();
		for (int i = 0; i < b.length; i++) {
			resultSb.append(byteToHexString(b[i]));
		}
		return resultSb.toString();
	}

	private static String byteToHexString(byte b) {
		int n = b;
		if (n < 0)
			n = 256 + n;
		int d1 = n / 16;
		int d2 = n % 16;
		return hexDigits[d1] + hexDigits[d2];
	}

	/**
	 * 将16进制转换为二进制
	 *
	 * @param hexStr
	 * @return
	 */
	public static byte[] parseHexStr2Byte(String hexStr) {
		if (hexStr.length() < 1)
			return null;
		byte[] result = new byte[hexStr.length() / 2];
		for (int i = 0; i < hexStr.length() / 2; i++) {
			int high = Integer.parseInt(hexStr.substring(i * 2, i * 2 + 1), 16);
			int low = Integer.parseInt(hexStr.substring(i * 2 + 1, i * 2 + 2),
					16);
			result[i] = (byte) (high * 16 + low);
		}
		return result;
	}

	public String sha256Hex(String password) {
		try {
			MessageDigest sha256 = MessageDigest.getInstance("SHA-256");
			String salt = "some_random_salt";
			String passWithSalt = password + salt;
			byte[] passBytes = passWithSalt.getBytes();
			byte[] passHash = sha256.digest(passBytes);
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < passHash.length; i++) {
				sb.append(Integer.toString((passHash[i] & 0xff) + 0x100, 16)
						.substring(1));
			}
			String generatedPassword = sb.toString();
			return generatedPassword;
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 对字符串进行MD5进行加密处理
	 *
	 * @return 加密后字符串
	 */

	public static String encryptMD5(String origin) {
		String resultString = null;
		try {
			resultString = new String(origin);
			MessageDigest md = MessageDigest.getInstance("MD5");
			resultString.trim();
			resultString = byteArrayToHexString(md.digest(resultString
					.getBytes("UTF-8")));
		} catch (Exception ex) {
		}
		return resultString;
	}

	/**
	 * 盐值的原理非常简单，就是先把密码和盐值指定的内容合并在一起，再使用md5对合并后的内容进行演算，
	 * 这样一来，就算密码是一个很常见的字符串，再加上用户名，最后算出来的md5值就没那么容易猜出来了。 因为攻击者不知道盐值的值，也很难反算出密码原文。
	 *
	 * @param msg
	 * @return
	 */
	public static String encryptSalt(String msg) {
		String salt = getSalt();
		return encryptMD5(salt);
	}

	/**
	 * SHA（Secure Hash Algorithm，安全散列算法）是消息摘要算法的一种，被广泛认可的MD5算法的继任者。
	 * SHA算法家族目前共有SHA-0、SHA-1、SHA-224、SHA-256、SHA-384和SHA-512五种算法，
	 * 通常将后四种算法并称为SHA-2算法
	 *
	 * @param msg
	 * @return
	 */
	public static String encryptSHA1(String msg) {
		String salt = getSaltSHA1();
		StringBuilder sb = new StringBuilder();
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-1");
			md.update(salt.getBytes());
			byte[] bytes = md.digest(msg.getBytes());
			for (int i = 0; i < bytes.length; i++) {
				sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16)
						.substring(1));
			}
		} catch (Exception e) {

		}

		return sb.toString();
	}

	/**
	 * PBKDF2加密
	 *
	 * @param msg
	 * @return
	 */
	public static String encryptPBKDF2(String msg) {
		try {
			int iterations = 1000;
			char[] chars = msg.toCharArray();
			byte[] salt = getSalt().getBytes();

			PBEKeySpec spec = new PBEKeySpec(chars, salt, iterations, 64 * 8);
			SecretKeyFactory skf = SecretKeyFactory
					.getInstance("PBKDF2WithHmacSHA1");
			byte[] hash = skf.generateSecret(spec).getEncoded();

			return iterations + toHex(salt) + toHex(hash);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	/**
	 * 转化十六进制
	 *
	 * @param array
	 * @return
	 */
	private static String toHex(byte[] array) {
		BigInteger bi = new BigInteger(1, array);
		String hex = bi.toString(16);
		int paddingLength = (array.length * 2) - hex.length();
		if (paddingLength > 0) {
			return String.format("%0" + paddingLength + "d", 0) + hex;
		} else {
			return hex;
		}
	}

	public static String SHA1(String decript) {
		try {
			MessageDigest digest = MessageDigest
					.getInstance("SHA-1");
			digest.update(decript.getBytes());
			byte messageDigest[] = digest.digest();
			StringBuffer hexString = new StringBuffer();
			for (int i = 0; i < messageDigest.length; i++) {
				String shaHex = Integer.toHexString(messageDigest[i] & 0xFF);
				if (shaHex.length() < 2) {
					hexString.append(0);
				}
				hexString.append(shaHex);
			}
			return hexString.toString();

		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return "";
	}

	/**
	 * <ul>
	 * <li>SHA-1 (Simplest one – 160 bits Hash)</li>
	 * <li>SHA-256 (Stronger than SHA-1 – 256 bits Hash)</li>
	 * <li>HA-384 (Stronger than SHA-256 – 384 bits Hash)</li>
	 * <li>SHA-512 (Stronger than SHA-384 – 512 bits Hash)</li>
	 * </ul>
	 *
	 * @return
	 */
	private static String getSaltSHA1() {
		SecureRandom sr;
		byte[] salt = new byte[16];
		try {
			sr = SecureRandom.getInstance("SHA1PRNG");
			sr.nextBytes(salt);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}

		return salt.toString();
	}

	/**
	 * BASE64解密
	 *
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public static byte[] decryptBASE64(String key) throws Exception {
		return Base64.getDecoder().decode(key);
	}

	/**
	 * BASE64加密
	 *
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public static String encryptBASE64(byte[] key) throws Exception {
		return Base64.getEncoder().encodeToString(key);
	}

	/**
	 * 盐值的原理非常简单，就是先把密码和盐值指定的内容合并在一起，再使用md5对合并后的内容进行演算，
	 * 这样一来，就算密码是一个很常见的字符串，再加上用户名，最后算出来的md5值就没那么容易猜出来了。 因为攻击者不知道盐值的值，也很难反算出密码原文。
	 *
	 * @return
	 */
	private static String getSalt() {
		SecureRandom sr;
		byte[] salt = new byte[16];
		try {
			sr = SecureRandom.getInstance("SHA1PRNG", "SUN");
			sr.nextBytes(salt);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return salt.toString();
	}

	/**
	 * 加密
	 *
	 * @param content
	 *            需要加密的内容
	 * @param password
	 *            加密密码
	 * @return
	 */
	public static byte[] encryptAES(String content, String password) {
		try {
			KeyGenerator kgen = KeyGenerator.getInstance("AES");
			kgen.init(128, new SecureRandom(password.getBytes()));
			SecretKey secretKey = kgen.generateKey();
			byte[] enCodeFormat = secretKey.getEncoded();
			SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");
			Cipher cipher = Cipher.getInstance("AES");// 创建密码器
			byte[] byteContent = content.getBytes("utf-8");
			cipher.init(Cipher.ENCRYPT_MODE, key);// 初始化
			byte[] result = cipher.doFinal(byteContent);
			return result; // 加密
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			e.printStackTrace();
		} catch (BadPaddingException e) {
			e.printStackTrace();
		}
		return null;
	}


    public static byte[] encryptAESByECB(String content, String password) {
        try {
            KeyGenerator kgen = KeyGenerator.getInstance("AES");

            kgen.init(128, new SecureRandom(password.getBytes()));
            SecretKey secretKey = kgen.generateKey();
            byte[] enCodeFormat = secretKey.getEncoded();
            SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");// 创建密码器
            byte[] byteContent = content.getBytes("utf-8");
            cipher.init(Cipher.ENCRYPT_MODE, key);// 初始化
            byte[] result = cipher.doFinal(byteContent);
            return result; // 加密
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        }
        return null;
    }

	/**
	 * 解密
	 *
	 * @param content
	 *            待解密内容
	 * @param password
	 *            解密密钥
	 * @return
	 */
	public static byte[] decryptAES(byte[] content, String password) {
		try {
			KeyGenerator kgen = KeyGenerator.getInstance("AES");
			kgen.init(128, new SecureRandom(password.getBytes()));
			SecretKey secretKey = kgen.generateKey();
			byte[] enCodeFormat = secretKey.getEncoded();
			SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");
			Cipher cipher = Cipher.getInstance("AES/ECB/NoPadding");// 创建密码器
			cipher.init(Cipher.DECRYPT_MODE, key);// 初始化
			byte[] result = cipher.doFinal(content);
			return result; // 加密
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			e.printStackTrace();
		} catch (BadPaddingException e) {
			e.printStackTrace();
		}
		return null;
	}

    public static byte[] decryptAESECB(byte[] content, String password) {
        try {
            KeyGenerator kgen = KeyGenerator.getInstance("AES");
            kgen.init(128, new SecureRandom(password.getBytes()));
            SecretKey secretKey = kgen.generateKey();
            byte[] enCodeFormat = secretKey.getEncoded();
            SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");
            Cipher cipher = Cipher.getInstance("AES");// 创建密码器
            cipher.init(Cipher.DECRYPT_MODE, key);// 初始化
            byte[] result = cipher.doFinal(content);
            return result; // 加密
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        }
        return null;
    }

	/**
	 * 解密
	 *
	 * @param content
	 *            待解密内容
	 * @param enCodeFormat
	 *            解密密钥
	 * @return
	 */
	public static byte[] decryptDDkjAES(byte[] content, String enCodeFormat) {
		try {
			SecretKeySpec key = new SecretKeySpec(parseHexStr2Byte(enCodeFormat), "AES");
			Cipher cipher = Cipher.getInstance("AES");// 创建密码器
			cipher.init(Cipher.DECRYPT_MODE, key);// 初始化
			byte[] result = cipher.doFinal(content);
			return result; // 加密
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			e.printStackTrace();
		} catch (BadPaddingException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
     * DES加密
     *
     * @param content
     * @param key
     * @return
     */
    public static String desEncode(String content, String key) {
        try {
            SecureRandom random = new SecureRandom();
            DESKeySpec desKey = new DESKeySpec(key.getBytes());
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
            SecretKey securekey = keyFactory.generateSecret(desKey);
            Cipher cipher = Cipher.getInstance("DES");
            cipher.init(Cipher.ENCRYPT_MODE, securekey, random);
            byte[] result = cipher.doFinal(content.getBytes());
            return byte2hex(result, false);
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * DES解密
     *
     * @param content
     * @param key
     * @return
     */
    public static String desDecode(String content, String key) {
        try {
            byte[] bytes = hex2byte(content);
            SecureRandom random = new SecureRandom();
            DESKeySpec desKey = new DESKeySpec(key.getBytes());
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
            SecretKey securekey = keyFactory.generateSecret(desKey);
            Cipher cipher = Cipher.getInstance("DES");
            cipher.init(Cipher.DECRYPT_MODE, securekey, random);
            byte[] result = cipher.doFinal(bytes);
            return new String(result);
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 二进制转十六进制字符串
     *
     * @param bytes
     * @return
     */
    public static String byte2hex(byte[] bytes, boolean upCase) {
        StringBuilder sign = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            String hex = Integer.toHexString(bytes[i] & 0xFF);
            if (hex.length() == 1) {
                sign.append("0");
            }
            if (upCase) {
                sign.append(hex.toUpperCase());
            } else {
                sign.append(hex);
            }
        }
        return sign.toString();
    }

    public static byte[] hex2byte(String str) {
        int len = str.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(str.charAt(i), 16) << 4) + Character.digit(str.charAt(i + 1), 16));
        }
        return data;
    }

	/**
	 * sha1 算法
	 * @param str
	 * @return
	 * @throws IOException
	 */
	public static String sha1(String str) throws IOException{
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-1");
			byte[] bytes = md.digest(str.getBytes("UTF-8"));
			StringBuilder sign = new StringBuilder();
			for(int i = 0; i < bytes.length; ++i) {
				String hex = Integer.toHexString(bytes[i] & 255);
				if (hex.length() == 1) {
					sign.append("0");
				}
				sign.append(hex.toUpperCase());
			}
			return sign.toString();
		} catch (GeneralSecurityException var3) {
			throw new IOException(var3.getMessage());
		}
	}


}
