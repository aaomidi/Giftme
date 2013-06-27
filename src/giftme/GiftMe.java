package giftme;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

public class GiftMe extends JavaPlugin {
public String prefix;
    public final static Logger logger = Logger.getLogger("minecraft");
        public void onDesable() {
        PluginDescriptionFile pdf = this.getDescription();
        getCommand("gift").setExecutor(new Comamnd(this)); //Command Executor
        logger.log(Level.INFO, "{0}, version {1} coded by {2} has been Disabled!", new Object[]{pdf.getName(), pdf.getVersion(), pdf.getAuthors()});
    }

    @Override
    public void onEnable() {
        saveDefaultConfig();
        PluginDescriptionFile pdf = this.getDescription();
        logger.log(Level.INFO, "{0}, version {1} coded by {2} has been Enabled!", new Object[]{pdf.getName(), pdf.getVersion(), pdf.getAuthors()});
        prefix=getConfig().getString("Prefix"); //Config Setup
    }
    
}
