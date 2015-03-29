package me.raydond123.factionfly;

import com.massivecraft.factions.entity.BoardColl;
import com.massivecraft.factions.entity.Faction;
import com.massivecraft.factions.entity.FactionColl;
import com.massivecraft.factions.entity.MPlayer;
import com.massivecraft.massivecore.ps.PS;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public class FactionFly extends JavaPlugin implements Listener {

    Logger logger = Logger.getLogger("Minecraft");

    public void onEnable() {

        Bukkit.getPluginManager().registerEvents(this, this);

        logger.info("[FactionFly] The plugin has been enabled!");

    }

    public void onDisable() {

        logger.info("[FactionFly] The plugin has been disabled!");

    }

    @EventHandler
    public void onMove(PlayerMoveEvent e) {

        Location locTo = e.getTo();
        Location locFrom = e.getFrom();

        Player player = e.getPlayer();
        MPlayer mPlayer = MPlayer.get(player);
        Faction faction = BoardColl.get().getFactionAt(PS.valueOf(locTo));
        Faction faction1 = BoardColl.get().getFactionAt(PS.valueOf(locFrom));

        if(faction != FactionColl.get().getNone()) {

            if(faction1 == FactionColl.get().getNone()) {

                if(faction == mPlayer.getFaction()) {

                    player.setFlying(true);

                }

            }

        } else {

            if(faction1 != FactionColl.get().getNone()) {

                if(faction1 == mPlayer.getFaction()) {

                    player.setFlying(false);

                }

            }

        }

    }

}
