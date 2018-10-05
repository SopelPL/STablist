package pl.sopelplyt.stablist;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import objects.Loader;

import org.bukkit.craftbukkit.v1_8_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitTask;

import ru.tehkode.permissions.PermissionUser;
import ru.tehkode.permissions.bukkit.PermissionsEx;
import events.PlayerJoinListener;
import events.PlayerQuitListener;

public class Main extends JavaPlugin{

	private static Main inst;
	
	public static List<String> tablistHeader = new ArrayList<String>();
	public static List<String> tablistFooter = new ArrayList<String>();
	
	public static Map<UUID, BukkitTask> tasks = new HashMap<UUID, BukkitTask>();
	
	@Override
	public void onEnable(){
		inst = this;
		saveDefaultConfig();
		this.getServer().getPluginManager().registerEvents(new PlayerJoinListener(), this);
		this.getServer().getPluginManager().registerEvents(new PlayerQuitListener(), this);
		Loader.loadTablist();
	}
	
	@Override
	public void onDisable(){
		
	}
	
	public static Main getInst(){
		return inst;
	}
	
	public static int getPing(Player player){
		return ((CraftPlayer)player).getHandle().ping;
	}
	
	public static String getPlayerGroup(Player player){
		PermissionUser user = PermissionsEx.getUser(player);
		List<String> groups = user.getParentIdentifiers();
		return groups.get(0);
	}
}
