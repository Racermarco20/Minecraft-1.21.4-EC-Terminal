package at.racermarco20.ecTerminal;

import org.bukkit.plugin.java.JavaPlugin;

public final class ECTerminalPlugin extends JavaPlugin {


    @Override
    public void onEnable() {
        // Plugin startup logic
        getLogger().info("ECTerminal has been enabled!");

        getCommand("ec").setExecutor(new ECTerminalCommand());

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info("ECTerminal has been disabled!");
    }
}
