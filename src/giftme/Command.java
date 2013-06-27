/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package giftme;

import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 *
 * @author Amir
 */
public class Command implements CommandExecutor {

    private GiftMe plugin; //Just a pointer

    public Command(GiftMe plugin) {
        this.plugin = plugin;
    }
@Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            if (label.equalsIgnoreCase("gift")) {
                if (args.length == 0) {
                    sender.sendMessage(plugin.prefix + " Please define who you would like to send the gift to.");
                    sender.sendMessage(plugin.prefix + " For correct usage of /gift please do /gift help");
                }
                if (args.length == 1) {
                    if (args[0].equalsIgnoreCase("help")){
                        sender.sendMessage(plugin.prefix+ " /gift <player*> <item:amount*> <Yes-No> <Message>");
                        sender.sendMessage(plugin.prefix+ "*=Required. Yes-No=Should this gift be sent anonymously.");
                    }else if () //If args[0] refsers to a player Forgot how to do this.
                }
            }

        }
        return false;
    }
}
