package rush.login.utils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

/**
 * @author Mior
 * @version 1.0
 * @category utils
 */

public class ReflectionUtils {
	
	private static final String version = Bukkit.getServer().getClass().getPackage().getName().split("\\.")[3];
	private static Method getHandle;
	private static Method sendPacket;
	private static Field playerConnectionField;
	
	public static void loadUtils() {
		try 
		{
			getHandle = getOBClass("entity.CraftPlayer").getMethod("getHandle");
			playerConnectionField = getNMSClass("EntityPlayer").getField("playerConnection");
			sendPacket = getNMSClass("PlayerConnection").getMethod("sendPacket", getNMSClass("Packet"));
		}
		catch (Throwable e) {
			e.printStackTrace();
		}
	}
	
   	public static Class<?> getNMSClass(String name) throws ClassNotFoundException {
   		return Class.forName("net.minecraft.server." + version + "." + name);
   	}
   	
   	public static Class<?> getOBClass(String name) throws ClassNotFoundException {
   		return Class.forName("org.bukkit.craftbukkit." + version + "." + name);
   	}
   	
   	public static void sendPacket(Player player, Object packet) {
   		try {
   			Object entityPlayer = getHandle.invoke(player);
   			Object playerConnection = playerConnectionField.get(entityPlayer);
   			sendPacket.invoke(playerConnection, packet);
   		} catch (Throwable e) {
   			e.printStackTrace();
   		}
   	}
   	
}