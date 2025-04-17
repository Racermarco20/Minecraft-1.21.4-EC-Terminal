package at.racermarco20.ecTerminal;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ECTerminalGui {

    private static final Logger log = LoggerFactory.getLogger(ECTerminalGui.class);

    public static void open(Player player, int redBitsToPay) {
        log.info("Opening ECTerminalGui for {}", player.getName());

        Inventory ecTerminalGui = Bukkit.createInventory(null, 27, "ECTerminal");

        ItemStack filler = new ItemStack(Material.BLACK_STAINED_GLASS_PANE);
        ItemMeta fillerMeta = filler.getItemMeta();
        fillerMeta.setDisplayName(" ");


        for (int i = 0; i < 27; i++) {
            if (i == 10 || i == 11) continue;
            ecTerminalGui.setItem(i, filler);
        }

        ItemStack paperInfo = new ItemStack(Material.PAPER);
        ItemMeta paperInfoMeta = paperInfo.getItemMeta();
        paperInfoMeta.setDisplayName("§7Red Bits: §c§o" + redBitsToPay);
        paperInfo.setItemMeta(paperInfoMeta);

        ecTerminalGui.setItem(10, paperInfo);

        player.openInventory(ecTerminalGui);
    }
}
