package rush.login.events;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class PlayerKickLoginEvent extends Event {
	
    private static final HandlerList handlers = new HandlerList();
    @Override public HandlerList getHandlers() { return handlers; }
    public static HandlerList getHandlerList() { return handlers; }
    
    private Player player;

    public PlayerKickLoginEvent(Player player) {
        this.player = player;
    }

    public Player getPlayer() {
    	return player;
    }
}