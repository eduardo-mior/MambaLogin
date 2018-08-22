package rush.login.entidades;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import rush.login.utils.DataManager;
import rush.login.utils.Logger;

public class LPlayer {

	private String pass;
	private String nick;
	private boolean isRegistered;

	public static LPlayer get(Player player) {
		return new LPlayer(player.getName().toLowerCase());
	}

	public static LPlayer get(String player) {
		return new LPlayer(player.toLowerCase());
	}

	public LPlayer(String player) {
		FileConfiguration lpConfig = getlpConfig(player);
		this.pass = lpConfig.getString("Senha");
		this.nick = lpConfig.getString("Nick");
		this.isRegistered = lpConfig.getBoolean("Registrado");
	}

	public String getSenha() {
		return pass;
	}
	
	public void setSenha(String pass) {
		saveLpValue("Senha", pass);
		this.pass = pass;
	}
		
	public boolean isRegistered() {
		return isRegistered;
	}
	
	public void setRegistered(boolean registered) {
		saveLpValue("Registrado", registered);
		this.isRegistered = registered;
	}
	
	private void saveLpValue(String key, Object value) {
		String player = nick.toLowerCase();
		File lpFile = DataManager.getFile(player, "playerdata");
		FileConfiguration lpConfig = DataManager.getConfig(lpFile);
		lpConfig.set(key, value);
		try {
			lpConfig.save(lpFile);
		} catch (IOException e) {
			Logger.error("Nao foi possivel salvar o Valor !" + value + " na Key " + key + " no arquivo" + lpFile.getName() + "!");
			e.printStackTrace();
		}
	}

	private FileConfiguration getlpConfig(String player) {
		return DataManager.getConfig(DataManager.getFile(player, "playerdata"));
	}

}
