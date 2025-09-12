package dev.httpmarco.polocube

import dev.httpmarco.polocube.players.CubePlayerListeners
import org.bukkit.Bukkit
import org.bukkit.plugin.java.JavaPlugin

class CubePlugin : JavaPlugin() {

    override fun onEnable() {
        Bukkit.getPluginManager().registerEvents(CubePlayerListeners(), this)

        cubes
    }

    override fun onDisable() {

    }
}