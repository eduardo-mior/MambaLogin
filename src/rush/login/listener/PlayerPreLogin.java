package rush.login.listener;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerPreLoginEvent;
import org.bukkit.event.player.PlayerPreLoginEvent;
import org.bukkit.event.player.PlayerPreLoginEvent.Result;

@SuppressWarnings("deprecation")
public class PlayerPreLogin implements Listener {
	
	@EventHandler(priority = EventPriority.HIGHEST)
	public void aoTentarEntrar(PlayerPreLoginEvent e) {
		Player p = Bukkit.getPlayer(e.getName());
		if (p != null) {
			e.disallow(Result.KICK_OTHER, "§cJá existe um jogador online utilizando o nick '" + e.getName() +"'");
			e.setResult(org.bukkit.event.player.PlayerPreLoginEvent.Result.KICK_OTHER);
		}
	}

	@EventHandler(priority = EventPriority.HIGHEST)
	public void aoTentarEntrarAsync(AsyncPlayerPreLoginEvent e) {
		Player p = Bukkit.getPlayer(e.getName());
		if (p != null) {
			e.setKickMessage("§cJá existe um jogador online utilizando o nick '" + e.getName() + "'");
			e.setLoginResult(org.bukkit.event.player.AsyncPlayerPreLoginEvent.Result.KICK_OTHER);
		}
	}
}
