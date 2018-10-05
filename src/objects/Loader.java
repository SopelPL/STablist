package objects;

import java.text.SimpleDateFormat;
import java.util.Date;

import net.md_5.bungee.api.ChatColor;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.inventivetalent.tabapi.TabAPI;

import pl.sopelplyt.stablist.Main;

public class Loader {
	
	static SimpleDateFormat sdfr = new SimpleDateFormat("hh:mm");

	public static void loadTablist(){
		for(String s : Main.getInst().getConfig().getStringList("tablistHeader")){
			Main.tablistHeader.add(s);
		}
		
		for(String s : Main.getInst().getConfig().getStringList("tablistFooter")){
			Main.tablistFooter.add(s);
		}
	}
	
	public static void setHeaderAndFooter(Player player){
		String[] header = new String[Main.tablistHeader.size()];
		header = Main.tablistHeader.toArray(header);
		
		for(int i = 0; i < header.length; i++){
			header[i] = ChatColor.translateAlternateColorCodes('&', header[i]);
			header[i] = header[i].replaceAll("%ONLINE%", Bukkit.getOnlinePlayers().size() + "/" + Bukkit.getMaxPlayers());
			header[i] = header[i].replaceAll("%HOUR%", sdfr.format(new Date()).toString());
			header[i] = header[i].replaceAll("%GROUP%", Main.getPlayerGroup(player));
			header[i] = header[i].replaceAll("%NAME%", player.getName());
			header[i] = header[i].replaceAll("%PING%", Main.getPing(player) + " MS");
		}
		
		TabAPI.setHeader(player, header);		
		
		String[] footer = new String[Main.tablistFooter.size()];
		footer = Main.tablistFooter.toArray(footer);
		
		for(int i = 0; i < footer.length; i++){
			footer[i] = ChatColor.translateAlternateColorCodes('&', footer[i]);
			footer[i] = footer[i].replaceAll("%ONLINE%", Bukkit.getOnlinePlayers().size() + "/" + Bukkit.getMaxPlayers());
			footer[i] = footer[i].replaceAll("%HOUR%", sdfr.format(new Date()).toString());
			footer[i] = footer[i].replaceAll("%GROUP%", Main.getPlayerGroup(player));
			footer[i] = footer[i].replaceAll("%NAME%", player.getName());
			footer[i] = footer[i].replaceAll("%PING%", Main.getPing(player) + " MS");
		}
		
		TabAPI.setFooter(player, footer);
	}
}
