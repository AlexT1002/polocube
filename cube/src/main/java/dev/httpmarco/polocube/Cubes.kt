package dev.httpmarco.polocube

import dev.httpmarco.polocube.cube.CubeSnapshot

val cubes = Cubes()

class Cubes {

    /**
     * List of currently loaded CubeSnapshots
     * All cubes that are loaded in the system are stored here, but not necessarily running.
     *
     * @see CubeSnapshot
     */
    private val loadedCubes = mutableListOf<CubeSnapshot>()

    /**
     * List of currently running CubeServers
     *
     * @see CubeServer
     */
    private val runningServers = mutableListOf<CubeServer>()

    fun servers() : List<CubeServer> {
        return ArrayList(runningServers)
    }
}