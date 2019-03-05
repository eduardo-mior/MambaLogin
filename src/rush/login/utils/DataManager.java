package rush.login.utils;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import rush.login.Main;

public class DataManager {

	public static void createFolder(String folder) {
		try {
			File pasta = new File(Main.get().getDataFolder() + File.separator + folder);
			if (!pasta.exists()) {
				pasta.mkdirs();
			}
		} catch (Throwable e) {
			Bukkit.getConsoleSender().sendMessage("§c[Login] Nao foi possivel criar a pasta" + folder + "!");
			e.printStackTrace();
		}
	}

	public static void createFile(File file) {
		try {
			file.createNewFile();
		} catch (Throwable e) {
			Bukkit.getConsoleSender().sendMessage("§c[Login] Nao foi possivel criar o arquivo " + file.getName() + "!");
			e.printStackTrace();
		}
	}

	public static File getFolder(String folder) {
		File Arquivo = new File(Main.get().getDataFolder() + File.separator + folder);
		return Arquivo;
	}

	public static File getFile(String file, String folder) {
		File Arquivo = new File(Main.get().getDataFolder() + File.separator + folder, file + ".yml");
		return Arquivo;
	}

	public static File getFile(String file) {
		File Arquivo = new File(Main.get().getDataFolder() + "/" + file + ".yml");
		return Arquivo;
	}

	public static FileConfiguration getConfig(File file) {
		FileConfiguration config = (FileConfiguration) YamlConfiguration.loadConfiguration(file);
		return config;
	}

	public static void deleteFile(File file) {
		file.delete();
	}
}
