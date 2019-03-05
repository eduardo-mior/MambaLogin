package rush.login.listener;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerPreLoginEvent;
import org.bukkit.event.player.PlayerKickEvent;
import org.bukkit.event.player.PlayerLoginEvent;

public class PlayerPreLogin implements Listener {

	@SuppressWarnings("deprecation")
	@EventHandler(priority = EventPriority.LOWEST)
	public void aoTentarEntrar(AsyncPlayerPreLoginEvent e) {
		Player p = Bukkit.getPlayerExact(e.getName());
		if (p != null) {
			e.setKickMessage("§cJá existe um jogador online utilizando o nick '" + p.getName() + "'");
			e.setLoginResult(org.bukkit.event.player.AsyncPlayerPreLoginEvent.Result.KICK_OTHER);
		}
	}
	
	@SuppressWarnings("deprecation")
	@EventHandler(priority = EventPriority.LOWEST)
	public void aoTentarEntrar(PlayerLoginEvent e) {
		Player p = Bukkit.getPlayerExact(e.getPlayer().getName());
		if (p != null) {
			e.setKickMessage("§cJá existe um jogador online utilizando o nick '" + p.getName() + "'");
			e.setResult(org.bukkit.event.player.PlayerLoginEvent.Result.KICK_OTHER);
		}
	}
	
	@EventHandler(priority = EventPriority.LOW)
	public void aoSerKickado(PlayerKickEvent e) {
		if (e.getReason().contains("You logged in from another location")) {
			e.setCancelled(true);
		}
	}
	
}