package at.racermarco20.ecTerminal;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ECTerminalCommand implements CommandExecutor {
    private static final Logger log = LoggerFactory.getLogger(ECTerminalCommand.class.getName());

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String @NotNull [] strings) {
        if (!(commandSender instanceof Player player)) {
            log.info("[EC-Terminal] You must be a player to use this command!");
            return true;
        }

        if (strings.length == 0) {
            player.sendMessage("§4❗ Bitte gib eine Zahl an. /ec <Zahl>");
            return false;
        }


        try {
            Integer.parseInt(strings[0]);
        } catch (NumberFormatException e) {
            player.sendMessage("§4❗ Bitte gib eine Zahl an. /ec <Zahl>");
            return false;
        }

        ECTerminalGui.open((Player) commandSender, Integer.parseInt(strings[0]));

        return true;
    }
}
