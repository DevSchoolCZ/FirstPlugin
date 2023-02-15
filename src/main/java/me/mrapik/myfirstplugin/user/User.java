package me.mrapik.myfirstplugin.user;

import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.UUID;

public class User {

    private String name;
    private UUID uuid;

    private Player player;

    private Location homeLocation;

    public User(String name, UUID uuid, Player player, Location homeLocation) {
        this.name = name;
        this.uuid = uuid;
        this.player = player;
        this.homeLocation = homeLocation;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public Location getHomeLocation() {
        return homeLocation;
    }

    public void setHomeLocation(Location homeLocation) {
        this.homeLocation = homeLocation;
    }
}
