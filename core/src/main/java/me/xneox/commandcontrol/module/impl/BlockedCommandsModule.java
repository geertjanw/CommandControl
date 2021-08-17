package me.xneox.commandcontrol.module.impl;

import me.xneox.commandcontrol.CommandControl;
import me.xneox.commandcontrol.config.PluginConfiguration;
import me.xneox.commandcontrol.module.Module;
import me.xneox.commandcontrol.util.AdventureUtils;
import net.kyori.adventure.audience.Audience;
import org.checkerframework.checker.nullness.qual.NonNull;

public class BlockedCommandsModule extends Module {
  public BlockedCommandsModule(CommandControl commandControl) {
    super(commandControl);
  }

  @Override
  public boolean handle(@NonNull Audience sender, @NonNull String[] command) {
    PluginConfiguration.BlockedCommands config = this.commandControl.config().blockedCommands();
    if (!config.enabled()) {
      return false;
    }

    if (config.commands().contains(command[0])) {
      if (config.isUseBypassPermission()
          && AdventureUtils.hasPermission(sender, "commandcontrol.bypass.blocked-commands")) {
        return false;
      }

      sender.sendMessage(AdventureUtils.color(config.failMessage()));
      return true;
    }
    return false;
  }
}
