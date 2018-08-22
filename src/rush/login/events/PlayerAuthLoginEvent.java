package rush.login.events;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class PlayerAuthLoginEvent extends Event {
	
    private static final HandlerList handlers = new HandlerList();
    @Override public HandlerList getHandlers() { return handlers; }
    public static HandlerList getHandlerList() { return handlers; }
    
    private Player player;

    public PlayerAuthLoginEvent(Player player) {
        this.player = player;
    }

    public Player getPlayer() {
    	return player;
    }
}