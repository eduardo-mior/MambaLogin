package rush.login.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Encryption {

	public static String encrypt(String senha) {
		return passwordEncrypted(senha);
	}
	
	private static String passwordEncrypted(String senha) {
		try {
			MessageDigest algorithm = MessageDigest.getInstance("MD5");
			byte messageDigest[] = algorithm.digest(senha.getBytes("UTF-8"));
			StringBuilder hexString = new StringBuilder();
			for (byte b : messageDigest) {
			  hexString.append(String.format("%02X", 0xFF & b));
			}
			return hexString.toString();
		} catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
			Logger.error("Erro ao tentar criptografar a senha: " + senha);
			e.printStackTrace();
			return null;
		}
	}
}
