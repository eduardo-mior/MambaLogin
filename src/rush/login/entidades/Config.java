package rush.login.entidades;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.Plugin;

public class Config {

	public static String TitleRegistrar, SubtitleRegistrar, ExcedeuLimiteRegistrar, 
						 TitleLogar, SubtitleLogar, ExcedeuLimiteLogar,
						 TitleRegistrado, SubtitleRegistrado, TitleLogado, SubtitleLogado, 
						 MensagemRegistrado;
	public static int TentativasParaLogin, TempoParaLogin;

	public static void loadConfig(Plugin plugin) {
		FileConfiguration config = plugin.getConfig();
		TitleRegistrar = config.getString("TitleRegistrar").replace('&', '§');
		SubtitleRegistrar = config.getString("SubtitleRegistrar").replace('&', '§');
		ExcedeuLimiteRegistrar = config.getString("ExcedeuLimiteRegistrar").replace('&', '§');
		TitleLogar = config.getString("TitleLogar").replace('&', '§');
		SubtitleLogar = config.getString("SubtitleLogar").replace('&', '§');
		ExcedeuLimiteLogar = config.getString("ExcedeuLimiteLogar").replace('&', '§');
		TitleRegistrado = config.getString("TitleRegistrado").replace('&', '§');
		SubtitleRegistrado = config.getString("SubtitleRegistrado").replace('&', '§');
		TitleLogado = config.getString("TitleLogado").replace('&', '§');
		SubtitleLogado = config.getString("SubtitleLogado").replace('&', '§');
		MensagemRegistrado = config.getString("MensagemRegistrado").replace('&', '§');
		TempoParaLogin = config.getInt("TempoParaLogin") * 20;
		TentativasParaLogin = config.getInt("TentativasParaLogin") - 1;
	}
	
}
