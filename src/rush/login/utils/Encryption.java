package rush.login.utils;

import java.security.MessageDigest;

import org.bukkit.Bukkit;

public class Encryption {

	public static String encrypt(String password) {
		return getEncryptedPassowrd(password);
	}
	
	private static String getEncryptedPassowrd(String password) {
		try {
			MessageDigest algorithm = MessageDigest.getInstance("MD5");
			byte messageDigest[] = algorithm.digest(password.getBytes("UTF-8"));
			StringBuilder hexString = new StringBuilder();
			for (byte b : messageDigest) {
			  hexString.append(String.format("%02X", 0xFF & b));
			}
			return hexString.toString();
		} catch (Throwable e) {
			Bukkit.getConsoleSender().sendMessage("§c[Login] Erro ao tentar criptografar a senha: " + password);
			e.printStackTrace();
			return null;
		}
	}
	
}