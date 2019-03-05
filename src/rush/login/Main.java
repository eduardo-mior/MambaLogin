package rush.login;

import org.bukkit.Bukkit;
import org.bukkit.event.HandlerList;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import fr.xephi.authme.output.OnStartupTasks;
import rush.login.commands.CommandChangePassword;
import rush.login.commands.CommandLogin;
import rush.login.commands.CommandRegister;
import rush.login.commands.CommandUnregister;
import rush.login.entidades.Config;
import rush.login.listener.PlayerData;
import rush.login.listener.PlayerLogin;
import rush.login.listener.PlayerPreLogin;
import rush.login.utils.DataManager;
import rush.login.utils.ReflectionUtils;
import rush.login.utils.TitleAPI;

public class Main extends JavaPlugin {

	private static Main main;

	@Override
	public void onEnable() {
		OnStartupTasks.setupConsoleFilter(getLogger());
		carregarUtilidades();
		registrarComandos();
		registrarEventos();
		gerarConfigs();
	}

	@Override
	public void onDisable() {
		HandlerList.unregisterAll(this);
	}
	
	private void carregarUtilidades() {
		main = this;
		ReflectionUtils.loadUtils();
		TitleAPI.loadAPI();
	}
	
	private void gerarConfigs() {
		DataManager.createFolder("playerdata");
		saveDefaultConfig();
		Config.loadConfig(this);
	}

	private void registrarComandos() {
		getCommand("login").setExecutor(new CommandLogin()); 
		getCommand("register").setExecutor(new CommandRegister()); 
		getCommand("unregister").setExecutor(new CommandUnregister()); 
		getCommand("changepassword").setExecutor(new CommandChangePassword()); 
	}

	private void registrarEventos() {
		PluginManager pm = Bukkit.getServer().getPluginManager();

		pm.registerEvents(new PlayerPreLogin(), this);
		pm.registerEvents(new PlayerLogin(), this);
		pm.registerEvents(new PlayerData(), this);
	}

	public static Main get() {
		return main;
	}

}
