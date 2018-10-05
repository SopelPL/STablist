package events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import pl.sopelplyt.stablist.Main;

public class PlayerQuitListener implements Listener{

	@EventHandler
	public void onQuit(PlayerQuitEvent event){
		Main.tasks.get(event.getPlayer().getUniqueId()).cancel();
		Main.tasks.remove(event.getPlayer().getUniqueId());
	}
}
