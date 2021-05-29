package me.xneox.commandcontrol.bukkit.listener;

import me.xneox.commandcontrol.CommandControl;
import me.xneox.commandcontrol.bukkit.command.BukkitSender;
import me.xneox.commandcontrol.command.Sender;
import me.xneox.commandcontrol.handler.CommandHandler;
import org.bukkit.command.CommandSender;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class CommandListener extends CommandHandler implements Listener {
    public CommandListener(CommandControl commandControl) {
        super(commandControl);
    }

    @EventHandler
    public void onCommandPreprocess(PlayerCommandPreprocessEvent event) {
        Sender<CommandSender> sender = new BukkitSender(event.getPlayer());

        if (this.handle(sender, event.getMessage())) {
            event.setCancelled(true);
        }
    }

    /* uncomment when someone opens a ticket saying "can you add console command blacklist?????" (yes, it happened before)

    @EventHandler
    public void onConsoleCommand(ServerCommandEvent event) {
        Sender<CommandSender> sender = new BukkitSender(event.getSender());

        if (this.handle(sender, event.getCommand())) {
            event.setCancelled(true);
        }
    }
     */
}