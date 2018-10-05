package events;

import objects.Loader;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scheduler.BukkitRunnable;

import pl.sopelplyt.stablist.Main;

public class PlayerJoinListener implements Listener{

	@EventHandler
	public void onJoin(PlayerJoinEvent event){
		Main.tasks.put(event.getPlayer().getUniqueId(), new BukkitRunnable(){
			@Override
			public void run(){
				Loader.setHeaderAndFooter(event.getPlayer());
			}
		}.runTaskTimer(Main.getInst(), 10, 10));
	}
}
