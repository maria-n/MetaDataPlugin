import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

/*
 Created by Maria on 6/28/2015. Meta Data Plugin
 */
public class MetaDataPlugin extends JavaPlugin implements Listener
{
    public static Logger log = Logger.getLogger("Minecraft");

    @Override
    public void onLoad()
    {
        log.info("[MetaDataPlugin] Loading...");
    }

    @Override
    public void onEnable()
    {
        log.info("[MetaDataPlugin] Starting up....");
        getServer().getPluginManager().registerEvents(this, this);
    }

    @Override
    public void onDisable()
    {
        log.info("[MetaDataPlugin] Shutting Down....");
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event)
    {
        Player p = event.getPlayer();

        String serverName = Bukkit.getServerName();
        Plugin[] allPlugins = Bukkit.getPluginManager().getPlugins();


        p.sendMessage("Hello, " + p.getName() + "! How are you doing? This server " + serverName + " is currently used for testing, " +
                "should anything not work, please contact the Owner. Have a pleasant stay!");

        p.sendMessage(serverName + " has " + allPlugins.length + " Plugins installed!");
        for (int i = 0; i < allPlugins.length; i++)
        {
            int j = i + 1;
            List<String> author = allPlugins[i].getDescription().getAuthors();
            Map<String,Map<String,Object>> commands = allPlugins[i].getDescription().getCommands();

            p.sendMessage("      ");
            p.sendMessage("Plugin Number " + j + " is " + allPlugins[i] + " by " + author);
            if(commands == null)
            {
                p.sendMessage(allPlugins[i] + " doesn't use any commands.");
                p.sendMessage("      ");

            } else
            {
                p.sendMessage(allPlugins[i] +  " has following commands: ");
                p.sendMessage(" " + commands);
                p.sendMessage("      ");

            }
        }
    }
}



