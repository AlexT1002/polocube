package dev.httpmarco.polocube

import dev.httpmarco.polocube.cube.CubeSnapshot
import dev.httpmarco.polocube.cube.loadCubes
import dev.httpmarco.polocube.players.CubePlayer
import org.bukkit.Bukkit
import org.bukkit.entity.Player

val cubes = Cubes()

class Cubes {

    val logger = Bukkit.getLogger()

    /**
     * List of currently loaded CubeSnapshots
     * All cubes that are loaded in the system are stored here, but not necessarily running.
     *
     * @see CubeSnapshot
     */
    private var loadedCubes = loadCubes("cubes")

    /**
     * List of currently running CubeServers
     *
     * @see CubeServer
     */
    private val runningServers = mutableListOf<CubeServer>()

    /**
     * List of currently connected CubePlayers
     *
     * @see CubePlayer
     */
    private val connectedPlayers = mutableListOf<CubePlayer>()

    init {
        logger.info { "Load ${loadedCubes.size} cubes" }
    }

    fun servers(): List<CubeServer> {
        return ArrayList(runningServers)
    }

    fun findPlayer(player: Player): CubePlayer {
        return connectedPlayers.firstOrNull { it.uniqueId == player.uniqueId } ?: CubePlayer(player).also {
            connectedPlayers.add(it)
        }
    }
}