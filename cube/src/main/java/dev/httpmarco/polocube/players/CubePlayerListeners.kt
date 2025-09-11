package dev.httpmarco.polocube.players

import dev.httpmarco.polocube.cubes
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.AsyncPlayerChatEvent
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

    @EventHandler
    fun handleCubePlayerChat(event: AsyncPlayerChatEvent) {
        val player = cubes.findPlayer(event.player)

        if (player.disableChat) {
            event.isCancelled = true
            return
        }

        if (player.listenerOnChat != null) {
            event.recipients.retainAll(player.listenerOnChat.toSet())
        }

        if (player.chatLayout != null) {
            event.format = player.chatLayout.invoke(event.player)
        }
    }
}