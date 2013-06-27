/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package giftme;

import java.util.List;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
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
    public String message = null;
    Boolean anon = false;

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
                } else if (args.length == 2) {
                    OfflinePlayer target = plugin.getServer().getOfflinePlayer(args[0]);
                    Player player = plugin.getServer().getPlayerExact(sender);
                    ItemStack hand = player.getItemInHand();
                    Material m = hand.getType();
                    int amount = hand.getAmount();
                    int quantity = (Integer.parseInt(args[1]));
                    if (amount < quantity) {
                        player.sendMessage(plugin.prefix + " You don't have " + quantity + " of the item.");
                        player.sendMessage(plugin.prefix + " Please specify a number equal to or less than: " + amount);
                    } else {
                        this.sendGift(player, target, m, quantity);
                    }
                } else if (args.length == 3) {
                    OfflinePlayer target = plugin.getServer().getOfflinePlayer(args[0]);
                    Player player = plugin.getServer().getPlayerExact(sender);
                    ItemStack hand = player.getItemInHand();
                    Material m = hand.getType();
                    int amount = hand.getAmount();
                    int quantity = (Integer.parseInt(args[1]));
                    this.anon=Boolean.parseBoolean(args[2]);
                    if (amount < quantity) {
                        player.sendMessage(plugin.prefix + " You don't have " + quantity + " of the item.");
                        player.sendMessage(plugin.prefix + " Please specify a number equal to or less than: " + amount);
                    } else {
                        this.sendGift(player, target, m, quantity);
                    }
                }else if (args.length==4){ //prob has to change cause of the message :<
                    OfflinePlayer target = plugin.getServer().getOfflinePlayer(args[0]);
                    Player player = plugin.getServer().getPlayerExact(sender);
                    ItemStack hand = player.getItemInHand();
                    Material m = hand.getType();
                    int amount = hand.getAmount();
                    int quantity = (Integer.parseInt(args[1]));
                    this.anon=Boolean.parseBoolean(args[2]);
                    //I have no clue how to set the message now :<
                    if (amount < quantity) {
                        player.sendMessage(plugin.prefix + " You don't have " + quantity + " of the item.");
                        player.sendMessage(plugin.prefix + " Please specify a number equal to or less than: " + amount);
                    } else {
                        this.sendGift(player, target, m, quantity);
                    }
                }
            }

        }
        return false;
    }

    private void sendGift(Player player, OfflinePlayer target, Material m, int quantity) {
        if (target.isOnline()) {
            Player targetOn = target.getPlayer();
            ItemStack iss = new ItemStack(m, quantity);
            targetOn.getInventory().addItem(iss);
            if (anon = false) {//anonymous messaging

                if (message == null) {
                    targetOn.sendMessage(plugin.prefix + " Hey " + targetOn.getName() + ", " + player.getName() + " sent you a gift :D");
                } else {
                    targetOn.sendMessage(plugin.prefix + " Hey " + targetOn.getName() + ", " + player.getName() + " sent you a gift :D");
                    targetOn.sendMessage(plugin.prefix + " " + message);
                }
            } else {
                if (message == null) {
                    targetOn.sendMessage(plugin.prefix + " Hey " + targetOn.getName() + ", you recieved a gift");
                } else {
                    targetOn.sendMessage(plugin.prefix + " Hey " + targetOn.getName() + ", you recieved a gift");
                    targetOn.sendMessage(plugin.prefix + " " + message);
                }
            }
        } else {
            //do da base file stuffs
        }
    }
}
