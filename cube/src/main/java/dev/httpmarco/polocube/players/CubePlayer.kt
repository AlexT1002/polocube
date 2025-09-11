package dev.httpmarco.polocube.players

import org.bukkit.entity.Player

class CubePlayer(player: Player) : CubePlayerPaperWrapper(player) {

    // chat options for a better handling
    val disableChat: Boolean = false
    // players that will not see the chat messages
    // if list is null, all players will see the chat messages
    val listenerOnChat : List<Player>? = null
    // layout for the chat, here you can set a custom layout for the chat
    val chatLayout: ((Player) -> String)? = null

}