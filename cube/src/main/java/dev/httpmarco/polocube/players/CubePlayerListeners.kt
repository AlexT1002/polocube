package dev.httpmarco.polocube.players

import dev.httpmarco.polocube.cubes
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.AsyncPlayerPreLoginEvent

class CubePlayerListeners : Listener {

    @EventHandler
    fun handleCubePlayerConnect(event: AsyncPlayerPreLoginEvent) {
        // Handle player connect event

        if (cubes.servers().isEmpty()) {
            event.loginResult = AsyncPlayerPreLoginEvent.Result.KICK_OTHER
            event.kickMessage = "§cNo cube servers are currently available."
        }
    }
}