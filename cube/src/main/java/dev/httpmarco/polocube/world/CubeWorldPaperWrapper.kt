package dev.httpmarco.polocube.world

import org.bukkit.BlockChangeDelegate
import org.bukkit.Chunk
import org.bukkit.ChunkSnapshot
import org.bukkit.Difficulty
import org.bukkit.Effect
import org.bukkit.FeatureFlag
import org.bukkit.FluidCollisionMode
import org.bukkit.GameRule
import org.bukkit.HeightMap
import org.bukkit.Instrument
import org.bukkit.Location
import org.bukkit.Material
import org.bukkit.NamespacedKey
import org.bukkit.Note
import org.bukkit.Particle
import org.bukkit.Raid
import org.bukkit.Sound
import org.bukkit.SoundCategory
import org.bukkit.StructureType
import org.bukkit.TreeType
import org.bukkit.World
import org.bukkit.WorldBorder
import org.bukkit.WorldType
import org.bukkit.block.Biome
import org.bukkit.block.Block
import org.bukkit.block.BlockState
import org.bukkit.block.data.BlockData
import org.bukkit.boss.DragonBattle
import org.bukkit.entity.AbstractArrow
import org.bukkit.entity.Arrow
import org.bukkit.entity.Entity
import org.bukkit.entity.EntityType
import org.bukkit.entity.FallingBlock
import org.bukkit.entity.Item
import org.bukkit.entity.LightningStrike
import org.bukkit.entity.LivingEntity
import org.bukkit.entity.Player
import org.bukkit.entity.SpawnCategory
import org.bukkit.event.entity.CreatureSpawnEvent
import org.bukkit.generator.BiomeProvider
import org.bukkit.generator.BlockPopulator
import org.bukkit.generator.ChunkGenerator
import org.bukkit.generator.structure.GeneratedStructure
import org.bukkit.generator.structure.Structure
import org.bukkit.inventory.ItemStack
import org.bukkit.material.MaterialData
import org.bukkit.metadata.MetadataValue
import org.bukkit.persistence.PersistentDataContainer
import org.bukkit.plugin.Plugin
import org.bukkit.util.BiomeSearchResult
import org.bukkit.util.BoundingBox
import org.bukkit.util.RayTraceResult
import org.bukkit.util.StructureSearchResult
import org.bukkit.util.Vector
import java.io.File
import java.util.Random
import java.util.UUID
import java.util.function.Consumer
import java.util.function.Predicate

@Suppress("DEPRECATION", "removal")
abstract class CubeWorldPaperWrapper(val wrapperWorld: World) : World {

    override fun getBlockAt(x: Int, y: Int, z: Int): Block { return wrapperWorld.getBlockAt(x, y, z) }
    override fun getBlockAt(location: Location): Block { return wrapperWorld.getBlockAt(location) }
    override fun getHighestBlockAt(x: Int, z: Int): Block { return wrapperWorld.getHighestBlockAt(x, z) }
    override fun getHighestBlockAt(location: Location): Block { return wrapperWorld.getHighestBlockAt(location) }
    override fun getHighestBlockAt(x: Int, z: Int, heightMap: HeightMap): Block { return wrapperWorld.getHighestBlockAt(x, z, heightMap) }
    override fun getHighestBlockAt(location: Location, heightMap: HeightMap): Block { return wrapperWorld.getHighestBlockAt(location, heightMap) }
    override fun getChunkAt(x: Int, z: Int): Chunk { return wrapperWorld.getChunkAt(x, z) }
    override fun getChunkAt(x: Int, z: Int, generate: Boolean): Chunk { return wrapperWorld.getChunkAt(x, z, generate) }
    override fun getChunkAt(location: Location): Chunk { return wrapperWorld.getChunkAt(location) }
    override fun getChunkAt(block: Block): Chunk { return wrapperWorld.getChunkAt(block) }
    override fun isChunkLoaded(chunk: Chunk): Boolean { return wrapperWorld.isChunkLoaded(chunk) }
    override fun isChunkLoaded(x: Int, z: Int): Boolean { return wrapperWorld.isChunkLoaded(x, z) }
    override fun getLoadedChunks(): Array<out Chunk?> { return wrapperWorld.loadedChunks }
    override fun loadChunk(chunk: Chunk) { wrapperWorld.loadChunk(chunk) }
    override fun loadChunk(x: Int, z: Int) { wrapperWorld.loadChunk(x, z) }
    override fun loadChunk(x: Int, z: Int, generate: Boolean): Boolean { return wrapperWorld.loadChunk(x, z, generate) }
    override fun isChunkGenerated(x: Int, z: Int): Boolean { return wrapperWorld.isChunkGenerated(x, z) }
    override fun isChunkInUse(x: Int, z: Int): Boolean { return wrapperWorld.isChunkInUse(x, z) }
    override fun unloadChunk(chunk: Chunk): Boolean { return wrapperWorld.unloadChunk(chunk) }
    override fun unloadChunk(x: Int, z: Int): Boolean { return wrapperWorld.unloadChunk(x, z) }
    override fun unloadChunk(x: Int, z: Int, save: Boolean): Boolean { return wrapperWorld.unloadChunk(x, z, save) }
    override fun unloadChunkRequest(x: Int, z: Int): Boolean { return wrapperWorld.unloadChunkRequest(x, z) }
    override fun regenerateChunk(x: Int, z: Int): Boolean { return wrapperWorld.regenerateChunk(x, z) }
    override fun refreshChunk(x: Int, z: Int): Boolean { return wrapperWorld.refreshChunk(x, z) }
    override fun getPlayersSeeingChunk(chunk: Chunk): Collection<Player?> { return wrapperWorld.getPlayersSeeingChunk(chunk) }
    override fun getPlayersSeeingChunk(x: Int, z: Int): Collection<Player?> { return wrapperWorld.getPlayersSeeingChunk(x, z) }
    override fun isChunkForceLoaded(x: Int, z: Int): Boolean { return wrapperWorld.isChunkForceLoaded(x, z) }
    override fun setChunkForceLoaded(x: Int, z: Int, forced: Boolean) { wrapperWorld.setChunkForceLoaded(x, z, forced) }
    override fun getForceLoadedChunks(): Collection<Chunk?> { return wrapperWorld.forceLoadedChunks }
    override fun addPluginChunkTicket(x: Int, z: Int, plugin: Plugin): Boolean { return wrapperWorld.addPluginChunkTicket(x, z, plugin) }
    override fun removePluginChunkTicket(x: Int, z: Int, plugin: Plugin): Boolean { return wrapperWorld.removePluginChunkTicket(x, z, plugin) }
    override fun removePluginChunkTickets(plugin: Plugin) { wrapperWorld.removePluginChunkTickets(plugin) }
    override fun getPluginChunkTickets(x: Int, z: Int): Collection<Plugin?> { return wrapperWorld.getPluginChunkTickets(x, z) }
    override fun getPluginChunkTickets(): Map<Plugin?, Collection<Chunk?>?> { return wrapperWorld.pluginChunkTickets }
    override fun getIntersectingChunks(box: BoundingBox): Collection<Chunk?> { return wrapperWorld.getIntersectingChunks(box) }
    override fun dropItem(location: Location, item: ItemStack): Item { return wrapperWorld.dropItem(location, item) }
    override fun dropItem(location: Location, item: ItemStack, function: Consumer<in Item>?): Item { return wrapperWorld.dropItem(location, item, function) }
    override fun dropItemNaturally(location: Location, item: ItemStack): Item { return wrapperWorld.dropItemNaturally(location, item) }
    override fun dropItemNaturally(location: Location, item: ItemStack, function: Consumer<in Item>?): Item { return wrapperWorld.dropItemNaturally(location, item, function) }
    override fun spawnArrow(location: Location, direction: Vector, speed: Float, spread: Float): Arrow { return wrapperWorld.spawnArrow(location, direction, speed, spread) }
    override fun <T : AbstractArrow?> spawnArrow(location: Location, direction: Vector, speed: Float, spread: Float, clazz: Class<T?>): T & Any { return wrapperWorld.spawnArrow(location, direction, speed, spread, clazz) }
    override fun generateTree(location: Location, type: TreeType): Boolean { return wrapperWorld.generateTree(location, type) }
    override fun generateTree(loc: Location, type: TreeType, delegate: BlockChangeDelegate): Boolean { return wrapperWorld.generateTree(loc, type, delegate) }
    override fun generateTree(location: Location, random: Random, type: TreeType): Boolean { return wrapperWorld.generateTree(location, random, type) }
    override fun generateTree(location: Location, random: Random, type: TreeType, stateConsumer: Consumer<in BlockState>?): Boolean { return wrapperWorld.generateTree(location, random, type, stateConsumer) }
    override fun generateTree(location: Location, random: Random, type: TreeType, statePredicate: Predicate<in BlockState>?): Boolean { return wrapperWorld.generateTree(location, random, type, statePredicate) }
    override fun strikeLightning(loc: Location): LightningStrike { return wrapperWorld.strikeLightning(loc) }
    override fun strikeLightningEffect(loc: Location): LightningStrike { return wrapperWorld.strikeLightningEffect(loc) }
    override fun getEntities(): List<Entity?> { return wrapperWorld.entities }
    override fun getLivingEntities(): List<LivingEntity?> { return wrapperWorld.livingEntities }
    override fun <T : Entity?> getEntitiesByClass(vararg classes: Class<T?>?): Collection<T?> { return wrapperWorld.getEntitiesByClass(*classes) }
    override fun <T : Entity?> getEntitiesByClass(cls: Class<T?>): Collection<T?> { return wrapperWorld.getEntitiesByClass(cls) }
    override fun getEntitiesByClasses(vararg classes: Class<*>?): Collection<Entity?> { return wrapperWorld.getEntitiesByClasses(*classes) }
    override fun getPlayers(): List<Player?> { return wrapperWorld.players }
    override fun getNearbyEntities(location: Location, x: Double, y: Double, z: Double): Collection<Entity?> { return wrapperWorld.getNearbyEntities(location, x, y, z) }
    override fun getNearbyEntities(location: Location, x: Double, y: Double, z: Double, filter: Predicate<in Entity>?): Collection<Entity?> { return wrapperWorld.getNearbyEntities(location, x, y, z, filter) }
    override fun getNearbyEntities(boundingBox: BoundingBox): Collection<Entity?> { return wrapperWorld.getNearbyEntities(boundingBox) }
    override fun getNearbyEntities(boundingBox: BoundingBox, filter: Predicate<in Entity>?): Collection<Entity?> { return wrapperWorld.getNearbyEntities(boundingBox, filter) }
    override fun rayTraceEntities(start: Location, direction: Vector, maxDistance: Double): RayTraceResult? { return wrapperWorld.rayTraceEntities(start, direction, maxDistance) }
    override fun rayTraceEntities(start: Location, direction: Vector, maxDistance: Double, raySize: Double): RayTraceResult? { return wrapperWorld.rayTraceEntities(start, direction, maxDistance, raySize) }
    override fun rayTraceEntities(start: Location, direction: Vector, maxDistance: Double, filter: Predicate<in Entity>?): RayTraceResult? { return wrapperWorld.rayTraceEntities(start, direction, maxDistance, filter) }
    override fun rayTraceEntities(start: Location, direction: Vector, maxDistance: Double, raySize: Double, filter: Predicate<in Entity>?): RayTraceResult? { return wrapperWorld.rayTraceEntities(start, direction, maxDistance, raySize, filter) }
    override fun rayTraceBlocks(start: Location, direction: Vector, maxDistance: Double): RayTraceResult? { return wrapperWorld.rayTraceBlocks(start, direction, maxDistance) }
    override fun rayTraceBlocks(start: Location, direction: Vector, maxDistance: Double, fluidCollisionMode: FluidCollisionMode): RayTraceResult? { return wrapperWorld.rayTraceBlocks(start, direction, maxDistance, fluidCollisionMode) }
    override fun rayTraceBlocks(start: Location, direction: Vector, maxDistance: Double, fluidCollisionMode: FluidCollisionMode, ignorePassableBlocks: Boolean): RayTraceResult? { return wrapperWorld.rayTraceBlocks(start, direction, maxDistance, fluidCollisionMode, ignorePassableBlocks) }
    override fun rayTrace(start: Location, direction: Vector, maxDistance: Double, fluidCollisionMode: FluidCollisionMode, ignorePassableBlocks: Boolean, raySize: Double, filter: Predicate<in Entity>?): RayTraceResult? { return wrapperWorld.rayTrace(start, direction, maxDistance, fluidCollisionMode, ignorePassableBlocks, raySize, filter) }
    override fun getSpawnLocation(): Location { return wrapperWorld.spawnLocation }
    override fun setSpawnLocation(location: Location): Boolean { return wrapperWorld.setSpawnLocation(location) }
    override fun setSpawnLocation(x: Int, y: Int, z: Int, angle: Float): Boolean { return wrapperWorld.setSpawnLocation(x, y, z, angle) }
    override fun setSpawnLocation(x: Int, y: Int, z: Int): Boolean { return wrapperWorld.setSpawnLocation(x, y, z) }
    override fun getTime(): Long { return wrapperWorld.time }
    override fun setTime(time: Long) { wrapperWorld.time = time }
    override fun getFullTime(): Long { return wrapperWorld.fullTime }
    override fun setFullTime(time: Long) { wrapperWorld.fullTime = time }
    override fun getGameTime(): Long { return wrapperWorld.gameTime }
    override fun hasStorm(): Boolean { return wrapperWorld.hasStorm() }
    override fun setStorm(hasStorm: Boolean) { wrapperWorld.setStorm(hasStorm) }
    override fun getWeatherDuration(): Int { return wrapperWorld.weatherDuration }
    override fun setWeatherDuration(duration: Int) { wrapperWorld.setWeatherDuration(duration) }
    override fun isThundering(): Boolean { return wrapperWorld.isThundering }
    override fun setThundering(thundering: Boolean) { wrapperWorld.setThundering(thundering) }
    override fun getThunderDuration(): Int { return wrapperWorld.thunderDuration }
    override fun setThunderDuration(duration: Int) { wrapperWorld.setThunderDuration(duration) }
    override fun isClearWeather(): Boolean { return wrapperWorld.isClearWeather }
    override fun setClearWeatherDuration(duration: Int) { wrapperWorld.setClearWeatherDuration(duration) }
    override fun getClearWeatherDuration(): Int { return wrapperWorld.clearWeatherDuration }
    override fun createExplosion(x: Double, y: Double, z: Double, power: Float): Boolean { return wrapperWorld.createExplosion(x, y, z, power) }
    override fun createExplosion(x: Double, y: Double, z: Double, power: Float, setFire: Boolean): Boolean { return wrapperWorld.createExplosion(x, y, z, power, setFire) }
    override fun createExplosion(x: Double, y: Double, z: Double, power: Float, setFire: Boolean, breakBlocks: Boolean): Boolean { return wrapperWorld.createExplosion(x, y, z, power, setFire, breakBlocks) }
    override fun createExplosion(x: Double, y: Double, z: Double, power: Float, setFire: Boolean, breakBlocks: Boolean, source: Entity?): Boolean { return wrapperWorld.createExplosion(x, y, z, power, setFire, breakBlocks, source) }
    override fun createExplosion(loc: Location, power: Float): Boolean { return wrapperWorld.createExplosion(loc, power) }
    override fun createExplosion(loc: Location, power: Float, setFire: Boolean): Boolean { return wrapperWorld.createExplosion(loc, power, setFire) }
    override fun createExplosion(loc: Location, power: Float, setFire: Boolean, breakBlocks: Boolean): Boolean { return wrapperWorld.createExplosion(loc, power, setFire, breakBlocks) }
    override fun createExplosion(loc: Location, power: Float, setFire: Boolean, breakBlocks: Boolean, source: Entity?): Boolean { return wrapperWorld.createExplosion(loc, power, setFire, breakBlocks, source) }
    override fun getPVP(): Boolean { return wrapperWorld.pvp }
    override fun setPVP(pvp: Boolean) { wrapperWorld.pvp = pvp }
    override fun getGenerator(): ChunkGenerator? { return wrapperWorld.generator }
    override fun getBiomeProvider(): BiomeProvider? { return wrapperWorld.biomeProvider }
    override fun save() { wrapperWorld.save() }
    override fun getPopulators(): List<BlockPopulator?> { return wrapperWorld.populators }
    override fun <T : LivingEntity?> spawn(location: Location, clazz: Class<T?>, spawnReason: CreatureSpawnEvent.SpawnReason, randomizeData: Boolean, function: Consumer<in T>?): T & Any { return wrapperWorld.spawn(location, clazz, spawnReason, randomizeData, function) }
    override fun <T : Entity?> spawn(location: Location, clazz: Class<T?>): T & Any { return wrapperWorld.spawn(location, clazz) }
    override fun <T : Entity?> spawn(location: Location, clazz: Class<T?>, function: Consumer<in T>?): T & Any { return wrapperWorld.spawn(location, clazz, function) }
    override fun <T : Entity?> spawn(location: Location, clazz: Class<T?>, randomizeData: Boolean, function: Consumer<in T>?): T & Any { return wrapperWorld.spawn(location, clazz, randomizeData, function) }
    override fun spawnFallingBlock(location: Location,data: MaterialData): FallingBlock { return wrapperWorld.spawnFallingBlock(location, data) }
    override fun spawnFallingBlock(location: Location, data: BlockData): FallingBlock { return wrapperWorld.spawnFallingBlock(location, data) }
    override fun spawnFallingBlock(location: Location, material: Material, data: Byte): FallingBlock { return wrapperWorld.spawnFallingBlock(location, material, data) }
    override fun playEffect(location: Location, effect: Effect, data: Int) { wrapperWorld.playEffect(location, effect, data) }
    override fun playEffect(location: Location, effect: Effect, data: Int, radius: Int) { wrapperWorld.playEffect(location, effect, data, radius) }
    override fun <T : Any?> playEffect(location: Location, effect: Effect, data: T?) { wrapperWorld.playEffect(location, effect, data) }
    override fun <T : Any?> playEffect(location: Location, effect: Effect, data: T?, radius: Int) { wrapperWorld.playEffect(location, effect, data, radius) }
    override fun getEmptyChunkSnapshot(x: Int, z: Int, includeBiome: Boolean, includeBiomeTemp: Boolean): ChunkSnapshot { return wrapperWorld.getEmptyChunkSnapshot(x, z, includeBiome, includeBiomeTemp) }
    override fun setSpawnFlags(allowMonsters: Boolean, allowAnimals: Boolean) { wrapperWorld.setSpawnFlags(allowMonsters, allowAnimals) }
    override fun getAllowAnimals(): Boolean { return wrapperWorld.allowAnimals }
    override fun getAllowMonsters(): Boolean { return wrapperWorld.allowMonsters }
    override fun getBiome(x: Int, z: Int): Biome { return wrapperWorld.getBiome(x, z) }
    override fun getBiome(location: Location): Biome { return wrapperWorld.getBiome(location) }
    override fun getBiome(x: Int, y: Int, z: Int): Biome { return wrapperWorld.getBiome(x, y, z) }
    override fun setBiome(x: Int, z: Int, bio: Biome) { wrapperWorld.setBiome(x, z, bio) }
    override fun setBiome(location: Location, biome: Biome) { wrapperWorld.setBiome(location, biome) }
    override fun setBiome(x: Int, y: Int, z: Int, biome: Biome) { wrapperWorld.setBiome(x, y, z, biome) }
    override fun getTemperature(x: Int, z: Int): Double { return wrapperWorld.getTemperature(x, z) }
    override fun getTemperature(x: Int, y: Int, z: Int): Double { return wrapperWorld.getTemperature(x, y, z) }
    override fun getHumidity(x: Int, z: Int): Double { return wrapperWorld.getHumidity(x, z) }
    override fun getHumidity(x: Int, y: Int, z: Int): Double { return wrapperWorld.getHumidity(x, y, z) }
    override fun getLogicalHeight(): Int { return wrapperWorld.logicalHeight }
    override fun isNatural(): Boolean { return wrapperWorld.isNatural }
    override fun isBedWorks(): Boolean { return wrapperWorld.isBedWorks }
    override fun hasSkyLight(): Boolean { return wrapperWorld.hasSkyLight() }
    override fun hasCeiling(): Boolean { return wrapperWorld.hasCeiling() }
    override fun isPiglinSafe(): Boolean { return wrapperWorld.isPiglinSafe }
    override fun isRespawnAnchorWorks(): Boolean { return wrapperWorld.isRespawnAnchorWorks }
    override fun hasRaids(): Boolean { return wrapperWorld.hasRaids() }
    override fun isUltraWarm(): Boolean { return wrapperWorld.isUltraWarm }
    override fun getSeaLevel(): Int { return wrapperWorld.seaLevel }
    override fun getKeepSpawnInMemory(): Boolean { return wrapperWorld.keepSpawnInMemory }
    override fun setKeepSpawnInMemory(keepLoaded: Boolean) { wrapperWorld.keepSpawnInMemory = keepLoaded }
    override fun isAutoSave(): Boolean { return wrapperWorld.isAutoSave() }
    override fun setAutoSave(value: Boolean) { wrapperWorld.setAutoSave(value) }
    override fun setDifficulty(difficulty: Difficulty) { wrapperWorld.difficulty = difficulty }
    override fun getDifficulty(): Difficulty { return wrapperWorld.difficulty }
    override fun getViewDistance(): Int { return wrapperWorld.viewDistance }
    override fun getSimulationDistance(): Int { return wrapperWorld.simulationDistance }
    override fun getWorldFolder(): File { return wrapperWorld.worldFolder }
    override fun getWorldType(): WorldType? { return wrapperWorld.worldType }
    override fun canGenerateStructures(): Boolean { return wrapperWorld.canGenerateStructures() }
    override fun isHardcore(): Boolean { return wrapperWorld.isHardcore }
    override fun setHardcore(hardcore: Boolean) { wrapperWorld.isHardcore = hardcore }
    override fun getTicksPerAnimalSpawns(): Long { return wrapperWorld.ticksPerAnimalSpawns }
    override fun setTicksPerAnimalSpawns(ticksPerAnimalSpawns: Int) { wrapperWorld.setTicksPerAnimalSpawns(ticksPerAnimalSpawns) }
    override fun getTicksPerMonsterSpawns(): Long { return wrapperWorld.ticksPerMonsterSpawns }
    override fun setTicksPerMonsterSpawns(ticksPerMonsterSpawns: Int) { wrapperWorld.setTicksPerMonsterSpawns(ticksPerMonsterSpawns) }
    override fun getTicksPerWaterSpawns(): Long { return wrapperWorld.ticksPerWaterSpawns }
    override fun setTicksPerWaterSpawns(ticksPerWaterSpawns: Int) { wrapperWorld.setTicksPerWaterSpawns(ticksPerWaterSpawns) }
    override fun getTicksPerWaterAmbientSpawns(): Long { return wrapperWorld.ticksPerWaterAmbientSpawns }
    override fun setTicksPerWaterAmbientSpawns(ticksPerAmbientSpawns: Int) { wrapperWorld.setTicksPerWaterAmbientSpawns(ticksPerAmbientSpawns) }
    override fun getTicksPerWaterUndergroundCreatureSpawns(): Long { return wrapperWorld.ticksPerWaterUndergroundCreatureSpawns }
    override fun setTicksPerWaterUndergroundCreatureSpawns(ticksPerWaterUndergroundCreatureSpawns: Int) { wrapperWorld.setTicksPerWaterUndergroundCreatureSpawns(ticksPerWaterUndergroundCreatureSpawns) }
    override fun getTicksPerAmbientSpawns(): Long { return wrapperWorld.ticksPerAmbientSpawns }
    override fun setTicksPerAmbientSpawns(ticksPerAmbientSpawns: Int) { wrapperWorld.setTicksPerAnimalSpawns(ticksPerAmbientSpawns) }
    override fun getTicksPerSpawns(spawnCategory: SpawnCategory): Long { return wrapperWorld.getTicksPerSpawns(spawnCategory) }
    override fun setTicksPerSpawns(spawnCategory: SpawnCategory, ticksPerCategorySpawn: Int) { wrapperWorld.setTicksPerSpawns(spawnCategory, ticksPerCategorySpawn) }
    override fun getMonsterSpawnLimit(): Int { return wrapperWorld.monsterSpawnLimit }
    override fun setMonsterSpawnLimit(limit: Int) { wrapperWorld.monsterSpawnLimit = limit }override fun getAnimalSpawnLimit(): Int { return wrapperWorld.animalSpawnLimit }
    override fun setAnimalSpawnLimit(limit: Int) { wrapperWorld.animalSpawnLimit = limit }
    override fun getWaterAnimalSpawnLimit(): Int { return wrapperWorld.waterAnimalSpawnLimit }
    override fun setWaterAnimalSpawnLimit(limit: Int) { wrapperWorld.waterAnimalSpawnLimit = limit }
    override fun getWaterUndergroundCreatureSpawnLimit(): Int { return wrapperWorld.waterUndergroundCreatureSpawnLimit }
    override fun setWaterUndergroundCreatureSpawnLimit(limit: Int) { wrapperWorld.waterUndergroundCreatureSpawnLimit = limit }
    override fun getWaterAmbientSpawnLimit(): Int { return wrapperWorld.waterAmbientSpawnLimit }
    override fun setWaterAmbientSpawnLimit(limit: Int) { wrapperWorld.waterAmbientSpawnLimit = limit }
    override fun getAmbientSpawnLimit(): Int { return wrapperWorld.ambientSpawnLimit }
    override fun setAmbientSpawnLimit(limit: Int) { wrapperWorld.ambientSpawnLimit = limit }
    override fun getSpawnLimit(spawnCategory: SpawnCategory): Int { return wrapperWorld.getSpawnLimit(spawnCategory) }
    override fun setSpawnLimit(spawnCategory: SpawnCategory, limit: Int) { wrapperWorld.setSpawnLimit(spawnCategory, limit) }
    override fun playNote(loc: Location, instrument: Instrument, note: Note) { wrapperWorld.playNote(loc, instrument, note) }
    override fun playSound(location: Location, sound: Sound, volume: Float, pitch: Float) { wrapperWorld.playSound(location, sound, volume, pitch) }
    override fun playSound(location: Location, sound: String, volume: Float, pitch: Float) { wrapperWorld.playSound(location, sound, volume, pitch) }
    override fun playSound(location: Location, sound: Sound, category: SoundCategory, volume: Float, pitch: Float) { wrapperWorld.playSound(location, sound, category, volume, pitch) }
    override fun playSound(location: Location, sound: String, category: SoundCategory, volume: Float, pitch: Float) { wrapperWorld.playSound(location, sound, category, volume, pitch) }
    override fun playSound(location: Location, sound: Sound, category: SoundCategory, volume: Float, pitch: Float, seed: Long) { wrapperWorld.playSound(location, sound, category, volume, pitch, seed) }
    override fun playSound(location: Location, sound: String, category: SoundCategory, volume: Float, pitch: Float, seed: Long) { wrapperWorld.playSound(location, sound, category, volume, pitch, seed) }
    override fun playSound(entity: Entity, sound: Sound, volume: Float, pitch: Float) { wrapperWorld.playSound(entity, sound, volume, pitch) }
    override fun playSound(entity: Entity, sound: String, volume: Float, pitch: Float) { wrapperWorld.playSound(entity, sound, volume, pitch) }
    override fun playSound(entity: Entity, sound: Sound, category: SoundCategory, volume: Float, pitch: Float) { wrapperWorld.playSound(entity, sound, category, volume, pitch) }
    override fun playSound(entity: Entity, sound: String, category: SoundCategory, volume: Float, pitch: Float) { wrapperWorld.playSound(entity, sound, category, volume, pitch) }
    override fun playSound(entity: Entity, sound: Sound, category: SoundCategory, volume: Float, pitch: Float, seed: Long) { wrapperWorld.playSound(entity, sound, category, volume, pitch, seed) }
    override fun playSound(entity: Entity, sound: String, category: SoundCategory, volume: Float, pitch: Float, seed: Long) { wrapperWorld.playSound(entity, sound, category, volume, pitch, seed) }
    override fun getGameRules(): Array<out String?> { return wrapperWorld.gameRules }
    override fun getGameRuleValue(rule: String?): String? { return wrapperWorld.getGameRuleValue(rule) }
    override fun <T : Any?> getGameRuleValue(rule: GameRule<T?>): T? { return wrapperWorld.getGameRuleValue(rule) }
    override fun setGameRuleValue(rule: String, value: String): Boolean { return wrapperWorld.setGameRuleValue(rule, value) }
    override fun isGameRule(rule: String): Boolean { return wrapperWorld.isGameRule(rule) }
    override fun <T : Any?> getGameRuleDefault(rule: GameRule<T?>): T? { return wrapperWorld.getGameRuleDefault(rule) }
    override fun <T : Any?> setGameRule(rule: GameRule<T?>, newValue: T & Any): Boolean { return wrapperWorld.setGameRule(rule, newValue) }
    override fun getWorldBorder(): WorldBorder { return wrapperWorld.worldBorder }
    override fun spawnParticle(particle: Particle, location: Location, count: Int) { wrapperWorld.spawnParticle(particle, location, count) }
    override fun spawnParticle(particle: Particle, x: Double, y: Double, z: Double, count: Int) { wrapperWorld.spawnParticle(particle, x, y, z, count) }
    override fun <T : Any?> spawnParticle(particle: Particle, location: Location, count: Int, data: T?) { wrapperWorld.spawnParticle(particle, location, count, data) }
    override fun <T : Any?> spawnParticle(particle: Particle, x: Double, y: Double, z: Double, count: Int, data: T?) { wrapperWorld.spawnParticle(particle, x, y, z, count, data) }
    override fun spawnParticle(particle: Particle, location: Location, count: Int, offsetX: Double, offsetY: Double, offsetZ: Double) { wrapperWorld.spawnParticle(particle, location, count, offsetX, offsetY, offsetZ) }
    override fun spawnParticle(particle: Particle, x: Double, y: Double, z: Double, count: Int, offsetX: Double, offsetY: Double, offsetZ: Double) { wrapperWorld.spawnParticle(particle, x, y, z, count, offsetX, offsetY, offsetZ) }
    override fun <T : Any?> spawnParticle(particle: Particle, location: Location, count: Int, offsetX: Double, offsetY: Double, offsetZ: Double, data: T?) { wrapperWorld.spawnParticle(particle, location, count, offsetX, offsetY, offsetZ, data) }
    override fun <T : Any?> spawnParticle(particle: Particle, x: Double, y: Double, z: Double, count: Int, offsetX: Double, offsetY: Double, offsetZ: Double, data: T?) { wrapperWorld.spawnParticle(particle, x, y, z, count, offsetX, offsetY, offsetZ, data) }
    override fun spawnParticle(particle: Particle, location: Location, count: Int, offsetX: Double, offsetY: Double, offsetZ: Double, extra: Double) { wrapperWorld.spawnParticle(particle, location, count, offsetX, offsetY, offsetZ, extra) }
    override fun spawnParticle(particle: Particle, x: Double, y: Double, z: Double, count: Int, offsetX: Double, offsetY: Double, offsetZ: Double, extra: Double) { wrapperWorld.spawnParticle(particle, x, y, z, count, offsetX, offsetY, offsetZ, extra) }
    override fun <T : Any?> spawnParticle(particle: Particle, location: Location, count: Int, offsetX: Double, offsetY: Double, offsetZ: Double, extra: Double, data: T?) { wrapperWorld.spawnParticle(particle, location, count, offsetX, offsetY, offsetZ, extra, data) }
    override fun <T : Any?> spawnParticle(particle: Particle, x: Double, y: Double, z: Double, count: Int, offsetX: Double, offsetY: Double, offsetZ: Double, extra: Double, data: T?) { wrapperWorld.spawnParticle(particle, x, y, z, count, offsetX, offsetY, offsetZ, extra, data) }
    override fun <T : Any?> spawnParticle(particle: Particle, location: Location, count: Int, offsetX: Double, offsetY: Double, offsetZ: Double, extra: Double, data: T?, force: Boolean) { wrapperWorld.spawnParticle(particle, location, count, offsetX, offsetY, offsetZ, extra, data, force) }
    override fun <T : Any?> spawnParticle(particle: Particle, x: Double, y: Double, z: Double, count: Int, offsetX: Double, offsetY: Double, offsetZ: Double, extra: Double, data: T?, force: Boolean) { wrapperWorld.spawnParticle(particle, x, y, z, count, offsetX, offsetY, offsetZ, extra, data, force) }
    override fun locateNearestStructure(origin: Location, structureType: StructureType, radius: Int, findUnexplored: Boolean): Location? { return wrapperWorld.locateNearestStructure(origin, structureType, radius, findUnexplored) }
    override fun locateNearestStructure(origin: Location, structureType: org.bukkit.generator.structure.StructureType, radius: Int, findUnexplored: Boolean): StructureSearchResult? { return wrapperWorld.locateNearestStructure(origin, structureType, radius, findUnexplored) }
    override fun locateNearestStructure(origin: Location, structure: Structure, radius: Int, findUnexplored: Boolean): StructureSearchResult? { return wrapperWorld.locateNearestStructure(origin, structure, radius, findUnexplored) }
    override fun spigot(): World.Spigot { return wrapperWorld.spigot() }
    override fun locateNearestBiome(origin: Location, radius: Int, vararg biomes: Biome?): BiomeSearchResult? { return wrapperWorld.locateNearestBiome(origin, radius, *biomes) }
    override fun locateNearestBiome(origin: Location, radius: Int, horizontalInterval: Int, verticalInterval: Int, vararg biomes: Biome?): BiomeSearchResult? { return wrapperWorld.locateNearestBiome(origin, radius, horizontalInterval, verticalInterval, *biomes) }
    override fun locateNearestRaid(location: Location, radius: Int): Raid? { return wrapperWorld.locateNearestRaid(location, radius) }
    override fun getRaids(): List<Raid?> { return wrapperWorld.raids }
    override fun getEnderDragonBattle(): DragonBattle? { return wrapperWorld.enderDragonBattle }
    override fun getFeatureFlags(): Set<FeatureFlag?> { return wrapperWorld.featureFlags }
    override fun getStructures(x: Int, z: Int): Collection<GeneratedStructure?> { return wrapperWorld.getStructures(x, z) }
    override fun getStructures(x: Int, z: Int, structure: Structure): Collection<GeneratedStructure?> { return wrapperWorld.getStructures(x, z, structure) }
    override fun getBlockState(location: Location): BlockState { return wrapperWorld.getBlockState(location) }
    override fun getBlockState(x: Int, y: Int, z: Int): BlockState { return wrapperWorld.getBlockState(x, y, z) }
    override fun getBlockData(location: Location): BlockData { return wrapperWorld.getBlockData(location) }
    override fun getBlockData(x: Int, y: Int, z: Int): BlockData { return wrapperWorld.getBlockData(x, y, z) }
    override fun getType(location: Location): Material { return wrapperWorld.getType(location) }
    override fun getType(x: Int, y: Int, z: Int): Material { return wrapperWorld.getType(x, y, z) }
    override fun setBlockData(location: Location, blockData: BlockData) { wrapperWorld.setBlockData(location, blockData) }
    override fun setBlockData(x: Int, y: Int, z: Int, blockData: BlockData) { wrapperWorld.setBlockData(x, y, z, blockData) }
    override fun setType(location: Location, material: Material) { wrapperWorld.setType(location, material) }
    override fun setType(x: Int, y: Int, z: Int, material: Material) { wrapperWorld.setType(x, y, z, material) }
    override fun spawnEntity(location: Location, type: EntityType): Entity { return wrapperWorld.spawnEntity(location, type) }
    override fun spawnEntity(loc: Location, type: EntityType, randomizeData: Boolean): Entity { return wrapperWorld.spawnEntity(loc, type, randomizeData) }
    override fun <T : Entity?> createEntity(location: Location, clazz: Class<T?>): T & Any { return wrapperWorld.createEntity(location, clazz) }
    override fun getHighestBlockYAt(x: Int, z: Int): Int { return wrapperWorld.getHighestBlockYAt(x, z) }
    override fun getHighestBlockYAt(location: Location): Int { return wrapperWorld.getHighestBlockYAt(location) }
    override fun getHighestBlockYAt(x: Int, z: Int, heightMap: HeightMap): Int { return wrapperWorld.getHighestBlockYAt(x, z, heightMap) }
    override fun getHighestBlockYAt(location: Location, heightMap: HeightMap): Int { return wrapperWorld.getHighestBlockYAt(location, heightMap) }
    override fun <T : Entity?> addEntity(entity: T & Any): T & Any { return wrapperWorld.addEntity(entity) }
    override fun getName(): String { return wrapperWorld.name }
    override fun getUID(): UUID { return wrapperWorld.uid }
    override fun getEnvironment(): World.Environment { return wrapperWorld.environment }
    override fun getSeed(): Long { return wrapperWorld.seed }
    override fun getMinHeight(): Int { return wrapperWorld.minHeight }
    override fun getMaxHeight(): Int { return wrapperWorld.maxHeight }
    override fun sendPluginMessage(source: Plugin, channel: String, message: ByteArray) { wrapperWorld.sendPluginMessage(source, channel, message) }
    override fun getListeningPluginChannels(): Set<String?> { return wrapperWorld.listeningPluginChannels }
    override fun setMetadata(metadataKey: String, newMetadataValue: MetadataValue) { wrapperWorld.setMetadata(metadataKey, newMetadataValue) }
    override fun getMetadata(metadataKey: String): List<MetadataValue?> { return wrapperWorld.getMetadata(metadataKey) }
    override fun hasMetadata(metadataKey: String): Boolean { return wrapperWorld.hasMetadata(metadataKey) }
    override fun removeMetadata(metadataKey: String, owningPlugin: Plugin) { wrapperWorld.removeMetadata(metadataKey, owningPlugin) }
    override fun getPersistentDataContainer(): PersistentDataContainer { return wrapperWorld.persistentDataContainer }
    override fun getKey(): NamespacedKey { return wrapperWorld.key }
}
