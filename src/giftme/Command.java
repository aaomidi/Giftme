/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package giftme;

import java.util.List;
import org.bukkit.Material;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

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
                    if (args[0].equalsIgnoreCase("help")) {
                        sender.sendMessage(plugin.prefix + " /gift <player*> <amount of item in hand*> <Yes-No> <Message>");
                        sender.sendMessage(plugin.prefix + " *=Required. Yes-No=Should this gift be sent anonymously.");
                    } else {
                        
                        sender.sendMessage(plugin.prefix + " For correct usage of /gift please do /gift help");
                    }
                } else if (args.length==2){
                    Player target = plugin.getServer().getPlayerExact(args[0]);
                    Player player=plugin.getServer().getPlayerExact(sender.getName());
                    ItemStack hand=player.getItemInHand();
                    int amount=hand.getAmount(); 
                    int quantity=(Integer.parseInt(args[1]));
                    if (amount<quantity){
                        player.sendMessage(plugin.prefix+ " You don't have "+ quantity+" of the item.");
                        player.sendMessage(plugin.prefix+ " Please specify a number equal to or less than: "+ amount);
                    }
                   ItemStack items=new ItemStack();
                   
                    
                }
            }

        }
        return false;
    }
}
