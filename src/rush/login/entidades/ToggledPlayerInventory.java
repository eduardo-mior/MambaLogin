package rush.login.entidades;

import org.bukkit.entity.Player;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.ItemStack;

public class ToggledPlayerInventory {

	private Player player;
	private ItemStack[] contents;
	private ItemStack helmet;
	private ItemStack chestplate;
	private ItemStack leggings;
	private ItemStack boots;
	
	public ToggledPlayerInventory(Player p) {
		PlayerInventory inv = p.getInventory();
		this.contents = inv.getContents();
		this.helmet = inv.getHelmet();
		this.chestplate = inv.getChestplate();
		this.leggings = inv.getLeggings();
		this.boots = inv.getBoots();
		this.player = p;
		this.clearInventory(inv);
	}

	/**
	 * @return the contents
	 */
	public ItemStack[] getContents() {
		return contents;
	}

	/**
	 * @param contents the contents to set
	 */
	public void setContents(ItemStack[] contents) {
		this.contents = contents;
	}

	/**
	 * @return the helmet
	 */
	public ItemStack getHelmet() {
		return helmet;
	}

	/**
	 * @param helmet the helmet to set
	 */
	public void setHelmet(ItemStack helmet) {
		this.helmet = helmet;
	}

	/**
	 * @return the chestplate
	 */
	public ItemStack getChestplate() {
		return chestplate;
	}

	/**
	 * @param chestplate the chestplate to set
	 */
	public void setChestplate(ItemStack chestplate) {
		this.chestplate = chestplate;
	}

	/**
	 * @return the leggings
	 */
	public ItemStack getLeggings() {
		return leggings;
	}

	/**
	 * @param leggings the leggings to set
	 */
	public void setLeggings(ItemStack leggings) {
		this.leggings = leggings;
	}

	/**
	 * @return the boots
	 */
	public ItemStack getBoots() {
		return boots;
	}

	/**
	 * @param boots the boots to set
	 */
	public void setBoots(ItemStack boots) {
		this.boots = boots;
	}

	/**
	 * @return the player
	 */
	public Player getPlayer() {
		return player;
	}

	/**
	 * @param player the player to set
	 */
	public void setPlayer(Player player) {
		this.player = player;
	}
	
	private void clearInventory(PlayerInventory inv) {
		inv.clear();
		inv.setHelmet(null);
		inv.setChestplate(null);
		inv.setLeggings(null);
		inv.setBoots(null);
	}
	
	public void devolverItens() {
		PlayerInventory inv = player.getInventory();
		inv.setContents(contents);
		inv.setHelmet(helmet);
		inv.setChestplate(chestplate);
		inv.setLeggings(leggings);
		inv.setBoots(boots);
	}
	
}