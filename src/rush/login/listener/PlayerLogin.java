package rush.login.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import rush.login.entidades.LPlayer;
import rush.login.entidades.Login;
import rush.login.task.JoinTask;

public class PlayerLogin extends Login implements Listener {

	@EventHandler(priority = EventPriority.MONITOR) 
	public void onLogin(PlayerJoinEvent e) {
		Player player = e.getPlayer();
		LPlayer sp = LPlayer.get(player);
		
		if (sp.isRegistered())
			JoinTask.goLogin(player);
		else
			JoinTask.goRegister(player);
	}
	
	@EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true) 
	public void onMove(PlayerMoveEvent e) {
		if (BLOCK.contains(e.getPlayer())) {
			e.getPlayer().teleport(e.getFrom());
		}
	}
	
	@EventHandler(priority = EventPriority.LOWEST)
	public void onCommand(PlayerCommandPreprocessEvent e) {
		if (BLOCK.contains(e.getPlayer())) {
			String cmd = e.getMessage().toLowerCase();
			if (!cmd.startsWith("/login") && !cmd.startsWith("/register")) {
				e.getPlayer().sendMessage("§cVocê precisa estar logado para poder executar comandos.");
				e.setCancelled(true);
			}
		}
	}

	@EventHandler(priority = EventPriority.LOWEST)
	public void onChat(AsyncPlayerChatEvent e) {
		if (BLOCK.contains(e.getPlayer())) {
			e.getPlayer().sendMessage("§cVocê precisa estar logado para poder usar o chat.");
			e.setCancelled(true);
		}
	}

	@EventHandler(priority = EventPriority.LOWEST)
	public void onQuit(PlayerQuitEvent e) {
		LIST.remove(e.getPlayer());
		BLOCK.remove(e.getPlayer());
		if (INVS.containsKey(e.getPlayer())) {
			INVS.get(e.getPlayer()).devolverItens();
		}
	}
	
	@EventHandler (priority = EventPriority.HIGHEST, ignoreCancelled = true) 
	public void onDamage(EntityDamageEvent e) {
		if (e.getEntity() instanceof Player) {
			if (BLOCK.contains(e.getEntity())) {
				e.setCancelled(true);
			}
		}
	}
	
}