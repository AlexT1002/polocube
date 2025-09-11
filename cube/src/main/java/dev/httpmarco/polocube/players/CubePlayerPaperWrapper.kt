package dev.httpmarco.polocube.players

import org.bukkit.BanEntry
import org.bukkit.DyeColor
import org.bukkit.Effect
import org.bukkit.EntityEffect
import org.bukkit.FluidCollisionMode
import org.bukkit.GameMode
import org.bukkit.Input
import org.bukkit.Instrument
import org.bukkit.Location
import org.bukkit.Material
import org.bukkit.NamespacedKey
import org.bukkit.Note
import org.bukkit.Particle
import org.bukkit.Server
import org.bukkit.ServerLinks
import org.bukkit.Sound
import org.bukkit.SoundCategory
import org.bukkit.Statistic
import org.bukkit.WeatherType
import org.bukkit.World
import org.bukkit.WorldBorder
import org.bukkit.advancement.Advancement
import org.bukkit.advancement.AdvancementProgress
import org.bukkit.attribute.Attribute
import org.bukkit.attribute.AttributeInstance
import org.bukkit.block.Block
import org.bukkit.block.BlockFace
import org.bukkit.block.BlockState
import org.bukkit.block.PistonMoveReaction
import org.bukkit.block.Sign
import org.bukkit.block.TileState
import org.bukkit.block.data.BlockData
import org.bukkit.block.sign.Side
import org.bukkit.conversations.Conversation
import org.bukkit.conversations.ConversationAbandonedEvent
import org.bukkit.damage.DamageSource
import org.bukkit.entity.EnderPearl
import org.bukkit.entity.Entity
import org.bukkit.entity.EntityCategory
import org.bukkit.entity.EntitySnapshot
import org.bukkit.entity.EntityType
import org.bukkit.entity.Firework
import org.bukkit.entity.LivingEntity
import org.bukkit.entity.Player
import org.bukkit.entity.Pose
import org.bukkit.entity.Projectile
import org.bukkit.entity.SpawnCategory
import org.bukkit.entity.Villager
import org.bukkit.entity.memory.MemoryKey
import org.bukkit.event.entity.EntityDamageEvent
import org.bukkit.event.player.PlayerTeleportEvent
import org.bukkit.inventory.EntityEquipment
import org.bukkit.inventory.EquipmentSlot
import org.bukkit.inventory.Inventory
import org.bukkit.inventory.InventoryView
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.MainHand
import org.bukkit.inventory.Merchant
import org.bukkit.inventory.PlayerInventory
import org.bukkit.map.MapView
import org.bukkit.metadata.MetadataValue
import org.bukkit.permissions.Permission
import org.bukkit.permissions.PermissionAttachment
import org.bukkit.permissions.PermissionAttachmentInfo
import org.bukkit.persistence.PersistentDataContainer
import org.bukkit.plugin.Plugin
import org.bukkit.potion.PotionEffect
import org.bukkit.potion.PotionEffectType
import org.bukkit.profile.PlayerProfile
import org.bukkit.scoreboard.Scoreboard
import org.bukkit.util.BoundingBox
import org.bukkit.util.RayTraceResult
import org.bukkit.util.Vector
import java.net.InetAddress
import java.net.InetSocketAddress
import java.time.Duration
import java.time.Instant
import java.util.Date
import java.util.UUID
import java.util.concurrent.CompletableFuture

@Suppress("DEPRECATION", "removal")
abstract class CubePlayerPaperWrapper(val wrapperPlayer: Player) : Player {

    override fun getName() = wrapperPlayer.name
    override fun getDisplayName() = wrapperPlayer.displayName
    override fun setDisplayName(name: String?) = wrapperPlayer.setDisplayName(name)
    override fun getPlayerListName() = wrapperPlayer.playerListName
    override fun setPlayerListName(name: String?) = wrapperPlayer.setPlayerListName(name)
    override fun getPlayerListOrder() = wrapperPlayer.playerListOrder
    override fun setPlayerListOrder(order: Int) = wrapperPlayer.setPlayerListOrder(order)
    override fun getPlayerListHeader() = wrapperPlayer.playerListHeader
    override fun getPlayerListFooter(): String? = wrapperPlayer.playerListFooter
    override fun setPlayerListHeader(header: String?) = wrapperPlayer.setPlayerListHeader(header)
    override fun setPlayerListFooter(footer: String?) = wrapperPlayer.setPlayerListFooter(footer)
    override fun setPlayerListHeaderFooter(header: String?, footer: String?) = wrapperPlayer.setPlayerListHeaderFooter(header, footer)
    override fun setCompassTarget(loc: Location) = wrapperPlayer.setCompassTarget(loc)
    override fun getCompassTarget(): Location = wrapperPlayer.compassTarget
    override fun getAddress(): InetSocketAddress? = wrapperPlayer.address
    override fun isTransferred(): Boolean = wrapperPlayer.isTransferred
    override fun retrieveCookie(key: NamespacedKey): CompletableFuture<ByteArray?> = wrapperPlayer.retrieveCookie(key)
    override fun storeCookie(key: NamespacedKey, value: ByteArray) = wrapperPlayer.storeCookie(key, value)
    override fun transfer(host: String, port: Int) = wrapperPlayer.transfer(host, port)
    override fun sendRawMessage(message: String) = wrapperPlayer.sendRawMessage(message)
    override fun kickPlayer(message: String?) = wrapperPlayer.kickPlayer(message)
    override fun ban(reason: String?, expires: Date?, source: String?, kickPlayer: Boolean): BanEntry<PlayerProfile?>? = wrapperPlayer.ban(reason, expires, source, kickPlayer)
    override fun ban(reason: String?, expires: Instant?, source: String?, kickPlayer: Boolean): BanEntry<PlayerProfile?>? = wrapperPlayer.ban(reason, expires, source, kickPlayer)
    override fun ban(reason: String?, duration: Duration?, source: String?, kickPlayer: Boolean): BanEntry<PlayerProfile?>? = wrapperPlayer.ban(reason, duration, source, kickPlayer)
    override fun banIp(reason: String?, expires: Date?, source: String?, kickPlayer: Boolean): BanEntry<InetAddress?>? = wrapperPlayer.banIp(reason, expires, source, kickPlayer)
    override fun banIp(reason: String?, expires: Instant?, source: String?, kickPlayer: Boolean): BanEntry<InetAddress?>? = wrapperPlayer.banIp(reason, expires, source, kickPlayer)
    override fun banIp(reason: String?, duration: Duration?, source: String?, kickPlayer: Boolean): BanEntry<InetAddress?>? = wrapperPlayer.banIp(reason, duration, source, kickPlayer)
    override fun chat(msg: String) = wrapperPlayer.chat(msg)
    override fun performCommand(command: String): Boolean = wrapperPlayer.performCommand(command)
    override fun isOnGround(): Boolean = wrapperPlayer.isOnGround
    override fun isSneaking(): Boolean = wrapperPlayer.isSneaking
    override fun setSneaking(sneak: Boolean) = wrapperPlayer.setSneaking(sneak)
    override fun isSprinting(): Boolean = wrapperPlayer.isSprinting
    override fun setSprinting(sprinting: Boolean) = wrapperPlayer.setSprinting(sprinting)
    override fun saveData() = wrapperPlayer.saveData()
    override fun loadData() = wrapperPlayer.loadData()
    override fun setSleepingIgnored(isSleeping: Boolean) = wrapperPlayer.setSleepingIgnored(isSleeping)
    override fun isSleepingIgnored(): Boolean = wrapperPlayer.isSleepingIgnored
    override fun getBedSpawnLocation(): Location? = wrapperPlayer.bedSpawnLocation
    override fun getRespawnLocation(): Location? = wrapperPlayer.respawnLocation
    override fun setBedSpawnLocation(location: Location?) = wrapperPlayer.setBedSpawnLocation(location)
    override fun setRespawnLocation(location: Location?) = wrapperPlayer.setRespawnLocation(location)
    override fun setBedSpawnLocation(location: Location?, force: Boolean) = wrapperPlayer.setBedSpawnLocation(location, force)
    override fun setRespawnLocation(location: Location?, force: Boolean) = wrapperPlayer.setRespawnLocation(location, force)
    override fun getEnderPearls(): Collection<EnderPearl?> = wrapperPlayer.enderPearls
    override fun getCurrentInput(): Input = wrapperPlayer.currentInput
    override fun playNote(loc: Location, instrument: Byte, note: Byte) = wrapperPlayer.playNote(loc, instrument, note)
    override fun playNote(loc: Location, instrument: Instrument, note: Note) = wrapperPlayer.playNote(loc, instrument, note)
    override fun playSound(location: Location, sound: Sound, volume: Float, pitch: Float) = wrapperPlayer.playSound(location, sound, volume, pitch)
    override fun playSound(location: Location, sound: String, volume: Float, pitch: Float) = wrapperPlayer.playSound(location, sound, volume, pitch)
    override fun playSound(location: Location, sound: Sound, category: SoundCategory, volume: Float, pitch: Float) = wrapperPlayer.playSound(location, sound, category, volume, pitch)
    override fun playSound(location: Location, sound: String, category: SoundCategory, volume: Float, pitch: Float) = wrapperPlayer.playSound(location, sound, category, volume, pitch)
    override fun playSound(location: Location, sound: Sound, category: SoundCategory, volume: Float, pitch: Float, seed: Long) = wrapperPlayer.playSound(location, sound, category, volume, pitch, seed)
    override fun playSound(location: Location, sound: String, category: SoundCategory, volume: Float, pitch: Float, seed: Long) = wrapperPlayer.playSound(location, sound, category, volume, pitch, seed)
    override fun playSound(entity: Entity, sound: Sound, volume: Float, pitch: Float) = wrapperPlayer.playSound(entity, sound, volume, pitch)
    override fun playSound(entity: Entity, sound: String, volume: Float, pitch: Float) = wrapperPlayer.playSound(entity, sound, volume, pitch)
    override fun playSound(entity: Entity, sound: Sound, category: SoundCategory, volume: Float, pitch: Float) = wrapperPlayer.playSound(entity, sound, category, volume, pitch)
    override fun playSound(entity: Entity, sound: String, category: SoundCategory, volume: Float, pitch: Float) = wrapperPlayer.playSound(entity, sound, category, volume, pitch)
    override fun playSound(entity: Entity, sound: Sound, category: SoundCategory, volume: Float, pitch: Float, seed: Long) = wrapperPlayer.playSound(entity, sound, category, volume, pitch, seed)
    override fun playSound(entity: Entity, sound: String, category: SoundCategory, volume: Float, pitch: Float, seed: Long) = wrapperPlayer.playSound(entity, sound, category, volume, pitch, seed)
    override fun stopSound(sound: Sound) = wrapperPlayer.stopSound(sound)
    override fun stopSound(sound: String) = wrapperPlayer.stopSound(sound)
    override fun stopSound(sound: Sound, category: SoundCategory?) = wrapperPlayer.stopSound(sound, category)
    override fun stopSound(sound: String, category: SoundCategory?) = wrapperPlayer.stopSound(sound, category)
    override fun stopSound(category: SoundCategory) = wrapperPlayer.stopSound(category)
    override fun stopAllSounds() = wrapperPlayer.stopAllSounds()
    override fun playEffect(loc: Location, effect: Effect, data: Int) = wrapperPlayer.playEffect(loc, effect, data)
    override fun <T : Any?> playEffect(loc: Location, effect: Effect, data: T?) = wrapperPlayer.playEffect(loc, effect, data)
    override fun breakBlock(block: Block): Boolean = wrapperPlayer.breakBlock(block)
    override fun sendBlockChange(loc: Location, material: Material, data: Byte) = wrapperPlayer.sendBlockChange(loc, material, data)
    override fun sendBlockChange(loc: Location, block: BlockData) = wrapperPlayer.sendBlockChange(loc, block)
    override fun sendBlockChanges(blocks: Collection<BlockState?>) = wrapperPlayer.sendBlockChanges(blocks)
    override fun sendBlockChanges(blocks: Collection<BlockState?>, suppressLightUpdates: Boolean) = wrapperPlayer.sendBlockChanges(blocks, suppressLightUpdates)
    override fun sendBlockDamage(loc: Location, progress: Float) = wrapperPlayer.sendBlockDamage(loc, progress)
    override fun sendBlockDamage(loc: Location, progress: Float, source: Entity) = wrapperPlayer.sendBlockDamage(loc, progress, source)
    override fun sendBlockDamage(loc: Location, progress: Float, sourceId: Int) = wrapperPlayer.sendBlockDamage(loc, progress, sourceId)
    override fun sendEquipmentChange(entity: LivingEntity, slot: EquipmentSlot, item: ItemStack?) = wrapperPlayer.sendEquipmentChange(entity, slot, item)
    override fun sendEquipmentChange(entity: LivingEntity, items: Map<EquipmentSlot?, ItemStack?>) = wrapperPlayer.sendEquipmentChange(entity, items)
    override fun sendSignChange(loc: Location, lines: Array<out String?>?) = wrapperPlayer.sendSignChange(loc, lines)
    override fun sendSignChange(loc: Location, lines: Array<out String?>?, dyeColor: DyeColor) = wrapperPlayer.sendSignChange(loc, lines, dyeColor)
    override fun sendSignChange(loc: Location, lines: Array<out String?>?, dyeColor: DyeColor, hasGlowingText: Boolean) = wrapperPlayer.sendSignChange(loc, lines, dyeColor, hasGlowingText)
    override fun sendBlockUpdate(loc: Location, tileState: TileState) = wrapperPlayer.sendBlockUpdate(loc, tileState)
    override fun sendPotionEffectChange(entity: LivingEntity, effect: PotionEffect) = wrapperPlayer.sendPotionEffectChange(entity, effect)
    override fun sendPotionEffectChangeRemove(entity: LivingEntity, type: PotionEffectType) = wrapperPlayer.sendPotionEffectChangeRemove(entity, type)
    override fun sendMap(map: MapView) = wrapperPlayer.sendMap(map)
    override fun sendHurtAnimation(yaw: Float) = wrapperPlayer.sendHurtAnimation(yaw)
    override fun sendLinks(links: ServerLinks) = wrapperPlayer.sendLinks(links)
    override fun addCustomChatCompletions(completions: Collection<String?>) = wrapperPlayer.addCustomChatCompletions(completions)
    override fun removeCustomChatCompletions(completions: Collection<String?>) = wrapperPlayer.removeCustomChatCompletions(completions)
    override fun setCustomChatCompletions(completions: Collection<String?>) = wrapperPlayer.setCustomChatCompletions(completions)
    override fun updateInventory() = wrapperPlayer.updateInventory()
    override fun getPreviousGameMode(): GameMode? = wrapperPlayer.previousGameMode
    override fun setPlayerTime(time: Long, relative: Boolean) = wrapperPlayer.setPlayerTime(time, relative)
    override fun getPlayerTime(): Long = wrapperPlayer.playerTime
    override fun getPlayerTimeOffset(): Long = wrapperPlayer.playerTimeOffset
    override fun isPlayerTimeRelative(): Boolean = wrapperPlayer.isPlayerTimeRelative
    override fun resetPlayerTime() = wrapperPlayer.resetPlayerTime()
    override fun setPlayerWeather(type: WeatherType) = wrapperPlayer.setPlayerWeather(type)
    override fun getPlayerWeather(): WeatherType? = wrapperPlayer.playerWeather
    override fun resetPlayerWeather() = wrapperPlayer.resetPlayerWeather()
    override fun getExpCooldown(): Int = wrapperPlayer.expCooldown
    override fun setExpCooldown(ticks: Int) = wrapperPlayer.setExpCooldown(ticks)
    override fun giveExp(amount: Int) = wrapperPlayer.giveExp(amount)
    override fun giveExpLevels(amount: Int) = wrapperPlayer.giveExpLevels(amount)
    override fun getExp(): Float = wrapperPlayer.exp
    override fun setExp(exp: Float) = wrapperPlayer.setExp(exp)
    override fun getLevel(): Int = wrapperPlayer.level
    override fun setLevel(level: Int) = wrapperPlayer.setLevel(level)
    override fun getTotalExperience(): Int = wrapperPlayer.totalExperience
    override fun setTotalExperience(exp: Int) = wrapperPlayer.setTotalExperience(exp)
    override fun sendExperienceChange(progress: Float) = wrapperPlayer.sendExperienceChange(progress)
    override fun sendExperienceChange(progress: Float, level: Int) = wrapperPlayer.sendExperienceChange(progress, level)
    override fun getAllowFlight(): Boolean = wrapperPlayer.allowFlight
    override fun setAllowFlight(flight: Boolean) = wrapperPlayer.setAllowFlight(flight)
    override fun hidePlayer(player: Player) = wrapperPlayer.hidePlayer(player)
    override fun hidePlayer(plugin: Plugin, player: Player) = wrapperPlayer.hidePlayer(plugin, player)
    override fun showPlayer(player: Player) = wrapperPlayer.showPlayer(player)
    override fun showPlayer(plugin: Plugin, player: Player) = wrapperPlayer.showPlayer(plugin, player)
    override fun canSee(player: Player): Boolean = wrapperPlayer.canSee(player)
    override fun hideEntity(plugin: Plugin, entity: Entity) = wrapperPlayer.hideEntity(plugin, entity)
    override fun showEntity(plugin: Plugin, entity: Entity) = wrapperPlayer.showEntity(plugin, entity)
    override fun canSee(entity: Entity): Boolean = wrapperPlayer.canSee(entity)
    override fun isFlying(): Boolean = wrapperPlayer.isFlying
    override fun setFlying(value: Boolean) = wrapperPlayer.setFlying(value)
    override fun setFlySpeed(value: Float) = wrapperPlayer.setFlySpeed(value)
    override fun setWalkSpeed(value: Float) = wrapperPlayer.setWalkSpeed(value)
    override fun getFlySpeed(): Float = wrapperPlayer.flySpeed
    override fun getWalkSpeed(): Float = wrapperPlayer.walkSpeed
    override fun setTexturePack(url: String) = wrapperPlayer.setTexturePack(url)
    override fun setResourcePack(url: String) = wrapperPlayer.setResourcePack(url)
    override fun setResourcePack(url: String, hash: ByteArray?) = wrapperPlayer.setResourcePack(url, hash)
    override fun setResourcePack(url: String, hash: ByteArray?, prompt: String?) = wrapperPlayer.setResourcePack(url, hash, prompt)
    override fun setResourcePack(url: String, hash: ByteArray?, force: Boolean) = wrapperPlayer.setResourcePack(url, hash, force)
    override fun setResourcePack(url: String, hash: ByteArray?, prompt: String?, force: Boolean) = wrapperPlayer.setResourcePack(url, hash, prompt, force)
    override fun setResourcePack(id: UUID, url: String, hash: ByteArray?, prompt: String?, force: Boolean) = wrapperPlayer.setResourcePack(id, url, hash, prompt, force)
    override fun addResourcePack(id: UUID, url: String, hash: ByteArray?, prompt: String?, force: Boolean) = wrapperPlayer.addResourcePack(id, url, hash, prompt, force)
    override fun removeResourcePack(id: UUID) = wrapperPlayer.removeResourcePack(id)
    override fun removeResourcePacks() = wrapperPlayer.removeResourcePacks()
    override fun getScoreboard(): Scoreboard = wrapperPlayer.scoreboard
    override fun setScoreboard(scoreboard: Scoreboard) = wrapperPlayer.setScoreboard(scoreboard)
    override fun getWorldBorder(): WorldBorder? = wrapperPlayer.worldBorder
    override fun setWorldBorder(border: WorldBorder?) = wrapperPlayer.setWorldBorder(border)
    override fun sendHealthUpdate(health: Double, foodLevel: Int, saturation: Float) = wrapperPlayer.sendHealthUpdate(health, foodLevel, saturation)
    override fun sendHealthUpdate() = wrapperPlayer.sendHealthUpdate()
    override fun isHealthScaled(): Boolean = wrapperPlayer.isHealthScaled
    override fun setHealthScaled(scale: Boolean) = wrapperPlayer.setHealthScaled(scale)
    override fun setHealthScale(scale: Double) = wrapperPlayer.setHealthScale(scale)
    override fun getHealthScale(): Double = wrapperPlayer.healthScale
    override fun getSpectatorTarget(): Entity? = wrapperPlayer.spectatorTarget
    override fun setSpectatorTarget(entity: Entity?) = wrapperPlayer.setSpectatorTarget(entity)
    override fun sendTitle(title: String?, subtitle: String?) = wrapperPlayer.sendTitle(title, subtitle)
    override fun sendTitle(title: String?, subtitle: String?, fadeIn: Int, stay: Int, fadeOut: Int) = wrapperPlayer.sendTitle(title, subtitle, fadeIn, stay, fadeOut)
    override fun resetTitle() = wrapperPlayer.resetTitle()
    override fun spawnParticle(particle: Particle, location: Location, count: Int) = wrapperPlayer.spawnParticle(particle, location, count)
    override fun spawnParticle(particle: Particle, x: Double, y: Double, z: Double, count: Int) = wrapperPlayer.spawnParticle(particle, x, y, z, count)
    override fun <T : Any?> spawnParticle(particle: Particle, location: Location, count: Int, data: T?) = wrapperPlayer.spawnParticle(particle, location, count, data)
    override fun <T : Any?> spawnParticle(particle: Particle, x: Double, y: Double, z: Double, count: Int, data: T?) = wrapperPlayer.spawnParticle(particle, x, y, z, count, data)
    override fun spawnParticle(particle: Particle, location: Location, count: Int, offsetX: Double, offsetY: Double, offsetZ: Double) = wrapperPlayer.spawnParticle(particle, location, count, offsetX, offsetY, offsetZ)
    override fun spawnParticle(particle: Particle, x: Double, y: Double, z: Double, count: Int, offsetX: Double, offsetY: Double, offsetZ: Double) = wrapperPlayer.spawnParticle(particle, x, y, z, count, offsetX, offsetY, offsetZ)
    override fun <T : Any?> spawnParticle(particle: Particle, location: Location, count: Int, offsetX: Double, offsetY: Double, offsetZ: Double, data: T?) = wrapperPlayer.spawnParticle(particle, location, count, offsetX, offsetY, offsetZ, data)
    override fun <T : Any?> spawnParticle(particle: Particle, x: Double, y: Double, z: Double, count: Int, offsetX: Double, offsetY: Double, offsetZ: Double, data: T?) = wrapperPlayer.spawnParticle(particle, x, y, z, count, offsetX, offsetY, offsetZ, data)
    override fun spawnParticle(particle: Particle, location: Location, count: Int, offsetX: Double, offsetY: Double, offsetZ: Double, extra: Double) = wrapperPlayer.spawnParticle(particle, location, count, offsetX, offsetY, offsetZ, extra)
    override fun spawnParticle(particle: Particle, x: Double, y: Double, z: Double, count: Int, offsetX: Double, offsetY: Double, offsetZ: Double, extra: Double) = wrapperPlayer.spawnParticle(particle, x, y, z, count, offsetX, offsetY, offsetZ, extra)
    override fun <T : Any?> spawnParticle(particle: Particle, location: Location, count: Int, offsetX: Double, offsetY: Double, offsetZ: Double, extra: Double, data: T?) = wrapperPlayer.spawnParticle(particle, location, count, offsetX, offsetY, offsetZ, extra, data)
    override fun <T : Any?> spawnParticle(particle: Particle, x: Double, y: Double, z: Double, count: Int, offsetX: Double, offsetY: Double, offsetZ: Double, extra: Double, data: T?) = wrapperPlayer.spawnParticle(particle, x, y, z, count, offsetX, offsetY, offsetZ, extra, data)
    override fun <T : Any?> spawnParticle(particle: Particle, location: Location, count: Int, offsetX: Double, offsetY: Double, offsetZ: Double, extra: Double, data: T?, force: Boolean) = wrapperPlayer.spawnParticle(particle, location, count, offsetX, offsetY, offsetZ, extra, data, force)
    override fun <T : Any?> spawnParticle(particle: Particle, x: Double, y: Double, z: Double, count: Int, offsetX: Double, offsetY: Double, offsetZ: Double, extra: Double, data: T?, force: Boolean) = wrapperPlayer.spawnParticle(particle, x, y, z, count, offsetX, offsetY, offsetZ, extra, data, force)
    override fun getAdvancementProgress(advancement: Advancement): AdvancementProgress = wrapperPlayer.getAdvancementProgress(advancement)
    override fun getClientViewDistance(): Int = wrapperPlayer.clientViewDistance
    override fun getPing(): Int = wrapperPlayer.ping
    override fun getLocale(): String = wrapperPlayer.locale
    override fun updateCommands() = wrapperPlayer.updateCommands()
    override fun openBook(book: ItemStack) = wrapperPlayer.openBook(book)
    override fun openSign(sign: Sign) = wrapperPlayer.openSign(sign)
    override fun openSign(sign: Sign, side: Side) = wrapperPlayer.openSign(sign, side)
    override fun showDemoScreen() = wrapperPlayer.showDemoScreen()
    override fun isAllowingServerListings(): Boolean = wrapperPlayer.isAllowingServerListings
    override fun spigot(): Player.Spigot = wrapperPlayer.spigot()
    override fun isConversing(): Boolean = wrapperPlayer.isConversing
    override fun acceptConversationInput(input: String) = wrapperPlayer.acceptConversationInput(input)
    override fun beginConversation(conversation: Conversation): Boolean = wrapperPlayer.beginConversation(conversation)
    override fun abandonConversation(conversation: Conversation) = wrapperPlayer.abandonConversation(conversation)
    override fun abandonConversation(conversation: Conversation, details: ConversationAbandonedEvent) = wrapperPlayer.abandonConversation(conversation, details)
    override fun sendRawMessage(sender: UUID?, message: String) = wrapperPlayer.sendRawMessage(sender, message)
    override fun isOnline(): Boolean = wrapperPlayer.isOnline
    override fun getPlayerProfile(): PlayerProfile = wrapperPlayer.playerProfile
    override fun isBanned(): Boolean = wrapperPlayer.isBanned
    override fun ban(reason: String?, expires: Date?, source: String?): BanEntry<PlayerProfile?>? = wrapperPlayer.ban(reason, expires, source)
    override fun ban(reason: String?, expires: Instant?, source: String?): BanEntry<PlayerProfile?>? = wrapperPlayer.ban(reason, expires, source)
    override fun ban(reason: String?, duration: Duration?, source: String?): BanEntry<PlayerProfile?>? = wrapperPlayer.ban(reason, duration, source)
    override fun isWhitelisted(): Boolean = wrapperPlayer.isWhitelisted
    override fun setWhitelisted(value: Boolean) = wrapperPlayer.setWhitelisted(value)
    override fun getPlayer(): Player? = wrapperPlayer.player
    override fun getFirstPlayed(): Long = wrapperPlayer.firstPlayed
    override fun getLastPlayed(): Long = wrapperPlayer.lastPlayed
    override fun hasPlayedBefore(): Boolean = wrapperPlayer.hasPlayedBefore()
    override fun incrementStatistic(statistic: Statistic) = wrapperPlayer.incrementStatistic(statistic)
    override fun decrementStatistic(statistic: Statistic) = wrapperPlayer.decrementStatistic(statistic)
    override fun incrementStatistic(statistic: Statistic, amount: Int) = wrapperPlayer.incrementStatistic(statistic, amount)
    override fun decrementStatistic(statistic: Statistic, amount: Int) = wrapperPlayer.decrementStatistic(statistic, amount)
    override fun setStatistic(statistic: Statistic, newValue: Int) = wrapperPlayer.setStatistic(statistic, newValue)
    override fun getStatistic(statistic: Statistic): Int = wrapperPlayer.getStatistic(statistic)
    override fun incrementStatistic(statistic: Statistic, material: Material) = wrapperPlayer.incrementStatistic(statistic, material)
    override fun decrementStatistic(statistic: Statistic, material: Material) = wrapperPlayer.decrementStatistic(statistic, material)
    override fun getStatistic(statistic: Statistic, material: Material): Int = wrapperPlayer.getStatistic(statistic, material)
    override fun incrementStatistic(statistic: Statistic, material: Material, amount: Int) = wrapperPlayer.incrementStatistic(statistic, material, amount)
    override fun decrementStatistic(statistic: Statistic, material: Material, amount: Int) = wrapperPlayer.decrementStatistic(statistic, material, amount)
    override fun setStatistic(statistic: Statistic, material: Material, newValue: Int) = wrapperPlayer.setStatistic(statistic, material, newValue)
    override fun incrementStatistic(statistic: Statistic, entityType: EntityType) = wrapperPlayer.incrementStatistic(statistic, entityType)
    override fun decrementStatistic(statistic: Statistic, entityType: EntityType) = wrapperPlayer.decrementStatistic(statistic, entityType)
    override fun getStatistic(statistic: Statistic, entityType: EntityType): Int = wrapperPlayer.getStatistic(statistic, entityType)
    override fun incrementStatistic(statistic: Statistic, entityType: EntityType, amount: Int) = wrapperPlayer.incrementStatistic(statistic, entityType, amount)
    override fun decrementStatistic(statistic: Statistic, entityType: EntityType, amount: Int) = wrapperPlayer.decrementStatistic(statistic, entityType, amount)
    override fun setStatistic(statistic: Statistic, entityType: EntityType, newValue: Int) = wrapperPlayer.setStatistic(statistic, entityType, newValue)
    override fun getLocation(): Location = wrapperPlayer.location
    override fun getLocation(loc: Location?): Location? = wrapperPlayer.getLocation(loc)
    override fun setVelocity(velocity: Vector) = wrapperPlayer.setVelocity(velocity)
    override fun getVelocity(): Vector = wrapperPlayer.velocity
    override fun getHeight(): Double = wrapperPlayer.height
    override fun getWidth(): Double = wrapperPlayer.width
    override fun getBoundingBox(): BoundingBox = wrapperPlayer.boundingBox
    override fun isInWater(): Boolean = wrapperPlayer.isInWater
    override fun getWorld(): World = wrapperPlayer.world
    override fun setRotation(yaw: Float, pitch: Float) = wrapperPlayer.setRotation(yaw, pitch)
    override fun teleport(location: Location): Boolean = wrapperPlayer.teleport(location)
    override fun teleport(location: Location, cause: PlayerTeleportEvent.TeleportCause): Boolean = wrapperPlayer.teleport(location, cause)
    override fun teleport(destination: Entity): Boolean = wrapperPlayer.teleport(destination)
    override fun teleport(destination: Entity, cause: PlayerTeleportEvent.TeleportCause): Boolean = wrapperPlayer.teleport(destination, cause)
    override fun getNearbyEntities(x: Double, y: Double, z: Double): List<Entity?> = wrapperPlayer.getNearbyEntities(x, y, z)
    override fun getEntityId(): Int = wrapperPlayer.entityId
    override fun getFireTicks(): Int = wrapperPlayer.fireTicks
    override fun getMaxFireTicks(): Int = wrapperPlayer.maxFireTicks
    override fun setFireTicks(ticks: Int) = wrapperPlayer.setFireTicks(ticks)
    override fun setVisualFire(fire: Boolean) = wrapperPlayer.setVisualFire(fire)
    override fun isVisualFire(): Boolean = wrapperPlayer.isVisualFire
    override fun getFreezeTicks(): Int = wrapperPlayer.freezeTicks
    override fun getMaxFreezeTicks(): Int = wrapperPlayer.maxFreezeTicks
    override fun setFreezeTicks(ticks: Int) = wrapperPlayer.setFreezeTicks(ticks)
    override fun isFrozen(): Boolean = wrapperPlayer.isFrozen
    override fun remove() = wrapperPlayer.remove()
    override fun isDead(): Boolean = wrapperPlayer.isDead
    override fun isValid(): Boolean = wrapperPlayer.isValid
    override fun getServer(): Server = wrapperPlayer.server
    override fun isPersistent(): Boolean = wrapperPlayer.isPersistent
    override fun setPersistent(persistent: Boolean) = wrapperPlayer.setPersistent(persistent)
    override fun getPassenger(): Entity? = wrapperPlayer.passenger
    override fun setPassenger(passenger: Entity): Boolean = wrapperPlayer.setPassenger(passenger)
    override fun getPassengers(): List<Entity?> = wrapperPlayer.passengers
    override fun addPassenger(passenger: Entity): Boolean = wrapperPlayer.addPassenger(passenger)
    override fun removePassenger(passenger: Entity): Boolean = wrapperPlayer.removePassenger(passenger)
    override fun isEmpty(): Boolean = wrapperPlayer.isEmpty
    override fun eject(): Boolean = wrapperPlayer.eject()
    override fun getFallDistance(): Float = wrapperPlayer.fallDistance
    override fun setFallDistance(distance: Float) = wrapperPlayer.setFallDistance(distance)
    override fun setLastDamageCause(event: EntityDamageEvent?) = wrapperPlayer.setLastDamageCause(event)
    override fun getLastDamageCause(): EntityDamageEvent? = wrapperPlayer.lastDamageCause
    override fun getUniqueId(): UUID = wrapperPlayer.uniqueId
    override fun getTicksLived(): Int = wrapperPlayer.ticksLived
    override fun setTicksLived(value: Int) = wrapperPlayer.setTicksLived(value)
    override fun playEffect(type: EntityEffect) = wrapperPlayer.playEffect(type)
    override fun getType(): EntityType = wrapperPlayer.type
    override fun getSwimSound(): Sound = wrapperPlayer.swimSound
    override fun getSwimSplashSound(): Sound = wrapperPlayer.swimSplashSound
    override fun getSwimHighSpeedSplashSound(): Sound = wrapperPlayer.swimHighSpeedSplashSound
    override fun isInsideVehicle(): Boolean = wrapperPlayer.isInsideVehicle
    override fun leaveVehicle(): Boolean = wrapperPlayer.leaveVehicle()
    override fun getVehicle(): Entity? = wrapperPlayer.vehicle
    override fun setCustomNameVisible(flag: Boolean) = wrapperPlayer.setCustomNameVisible(flag)
    override fun isCustomNameVisible(): Boolean = wrapperPlayer.isCustomNameVisible
    override fun setVisibleByDefault(visible: Boolean) = wrapperPlayer.setVisibleByDefault(visible)
    override fun isVisibleByDefault(): Boolean = wrapperPlayer.isVisibleByDefault
    override fun getTrackedBy(): Set<Player?> = wrapperPlayer.trackedBy
    override fun setGlowing(flag: Boolean) = wrapperPlayer.setGlowing(flag)
    override fun isGlowing(): Boolean = wrapperPlayer.isGlowing
    override fun setInvulnerable(flag: Boolean) = wrapperPlayer.setInvulnerable(flag)
    override fun isInvulnerable(): Boolean = wrapperPlayer.isInvulnerable
    override fun isSilent(): Boolean = wrapperPlayer.isSilent
    override fun setSilent(flag: Boolean) = wrapperPlayer.setSilent(flag)
    override fun hasGravity(): Boolean = wrapperPlayer.hasGravity()
    override fun setGravity(gravity: Boolean) = wrapperPlayer.setGravity(gravity)
    override fun getPortalCooldown(): Int = wrapperPlayer.portalCooldown
    override fun setPortalCooldown(cooldown: Int) = wrapperPlayer.setPortalCooldown(cooldown)
    override fun getScoreboardTags(): Set<String?> = wrapperPlayer.scoreboardTags
    override fun addScoreboardTag(tag: String): Boolean = wrapperPlayer.addScoreboardTag(tag)
    override fun removeScoreboardTag(tag: String): Boolean = wrapperPlayer.removeScoreboardTag(tag)
    override fun getPistonMoveReaction(): PistonMoveReaction = wrapperPlayer.pistonMoveReaction
    override fun getFacing(): BlockFace = wrapperPlayer.facing
    override fun getPose(): Pose = wrapperPlayer.pose
    override fun getSpawnCategory(): SpawnCategory = wrapperPlayer.spawnCategory
    override fun isInWorld(): Boolean = wrapperPlayer.isInWorld
    override fun getAsString(): String? = wrapperPlayer.asString
    override fun createSnapshot(): EntitySnapshot? = wrapperPlayer.createSnapshot()
    override fun copy(): Entity = wrapperPlayer.copy()
    override fun copy(to: Location): Entity = wrapperPlayer.copy(to)
    override fun getInventory(): PlayerInventory = wrapperPlayer.inventory
    override fun getEnderChest(): Inventory = wrapperPlayer.enderChest
    override fun getMainHand(): MainHand = wrapperPlayer.mainHand
    @Suppress("DEPRECATION", "removal")
    override fun setWindowProperty(prop: InventoryView.Property, value: Int): Boolean = wrapperPlayer.setWindowProperty(prop, value)
    override fun getEnchantmentSeed(): Int = wrapperPlayer.enchantmentSeed
    override fun setEnchantmentSeed(seed: Int) = wrapperPlayer.setEnchantmentSeed(seed)
    override fun getOpenInventory(): InventoryView = wrapperPlayer.openInventory
    override fun openInventory(inventory: Inventory): InventoryView? = wrapperPlayer.openInventory(inventory)
    override fun openWorkbench(location: Location?, force: Boolean): InventoryView? = wrapperPlayer.openWorkbench(location, force)
    override fun openEnchanting(location: Location?, force: Boolean): InventoryView? = wrapperPlayer.openEnchanting(location, force)
    override fun openInventory(inventory: InventoryView) = wrapperPlayer.openInventory(inventory)
    override fun openMerchant(trader: Villager, force: Boolean): InventoryView? = wrapperPlayer.openMerchant(trader, force)
    override fun openMerchant(merchant: Merchant, force: Boolean): InventoryView? = wrapperPlayer.openMerchant(merchant, force)
    override fun closeInventory() = wrapperPlayer.closeInventory()
    override fun getItemInHand(): ItemStack = wrapperPlayer.itemInHand
    override fun setItemInHand(item: ItemStack?) = wrapperPlayer.setItemInHand(item)
    override fun getItemOnCursor(): ItemStack = wrapperPlayer.itemOnCursor
    override fun setItemOnCursor(item: ItemStack?) = wrapperPlayer.setItemOnCursor(item)
    override fun hasCooldown(material: Material): Boolean = wrapperPlayer.hasCooldown(material)
    override fun getCooldown(material: Material): Int = wrapperPlayer.getCooldown(material)
    override fun setCooldown(material: Material, ticks: Int) = wrapperPlayer.setCooldown(material, ticks)
    override fun hasCooldown(item: ItemStack): Boolean = wrapperPlayer.hasCooldown(item)
    override fun getCooldown(item: ItemStack): Int = wrapperPlayer.getCooldown(item)
    override fun setCooldown(item: ItemStack, ticks: Int) = wrapperPlayer.setCooldown(item, ticks)
    override fun getSleepTicks(): Int = wrapperPlayer.sleepTicks
    override fun sleep(location: Location, force: Boolean): Boolean = wrapperPlayer.sleep(location, force)
    override fun wakeup(setSpawnLocation: Boolean) = wrapperPlayer.wakeup(setSpawnLocation)
    override fun startRiptideAttack(duration: Int, attackStrength: Float, attackItem: ItemStack?) = wrapperPlayer.startRiptideAttack(duration, attackStrength, attackItem)
    override fun getBedLocation(): Location = wrapperPlayer.bedLocation
    override fun getGameMode(): GameMode = wrapperPlayer.gameMode
    override fun setGameMode(mode: GameMode) = wrapperPlayer.setGameMode(mode)
    override fun isBlocking(): Boolean = wrapperPlayer.isBlocking
    override fun isHandRaised(): Boolean = wrapperPlayer.isHandRaised
    override fun getExpToLevel(): Int = wrapperPlayer.expToLevel
    override fun getAttackCooldown(): Float = wrapperPlayer.attackCooldown
    override fun discoverRecipe(recipe: NamespacedKey): Boolean = wrapperPlayer.discoverRecipe(recipe)
    override fun discoverRecipes(recipes: Collection<NamespacedKey?>): Int = wrapperPlayer.discoverRecipes(recipes)
    override fun undiscoverRecipe(recipe: NamespacedKey): Boolean = wrapperPlayer.undiscoverRecipe(recipe)
    override fun undiscoverRecipes(recipes: Collection<NamespacedKey?>): Int = wrapperPlayer.undiscoverRecipes(recipes)
    override fun hasDiscoveredRecipe(recipe: NamespacedKey): Boolean = wrapperPlayer.hasDiscoveredRecipe(recipe)
    override fun getDiscoveredRecipes(): Set<NamespacedKey?> = wrapperPlayer.discoveredRecipes
    override fun getShoulderEntityLeft(): Entity? = wrapperPlayer.shoulderEntityLeft
    override fun setShoulderEntityLeft(entity: Entity?) = wrapperPlayer.setShoulderEntityLeft(entity)
    override fun getShoulderEntityRight(): Entity? = wrapperPlayer.shoulderEntityRight
    override fun setShoulderEntityRight(entity: Entity?) = wrapperPlayer.setShoulderEntityRight(entity)
    override fun dropItem(dropAll: Boolean): Boolean = wrapperPlayer.dropItem(dropAll)
    override fun getExhaustion(): Float = wrapperPlayer.exhaustion
    override fun setExhaustion(value: Float) = wrapperPlayer.setExhaustion(value)
    override fun getSaturation(): Float = wrapperPlayer.saturation
    override fun setSaturation(value: Float) = wrapperPlayer.setSaturation(value)
    override fun getFoodLevel(): Int = wrapperPlayer.foodLevel
    override fun setFoodLevel(value: Int) = wrapperPlayer.setFoodLevel(value)
    override fun getSaturatedRegenRate(): Int = wrapperPlayer.saturatedRegenRate
    override fun setSaturatedRegenRate(ticks: Int) = wrapperPlayer.setSaturatedRegenRate(ticks)
    override fun getUnsaturatedRegenRate(): Int = wrapperPlayer.unsaturatedRegenRate
    override fun setUnsaturatedRegenRate(ticks: Int) = wrapperPlayer.setUnsaturatedRegenRate(ticks)
    override fun getStarvationRate(): Int = wrapperPlayer.starvationRate
    override fun setStarvationRate(ticks: Int) = wrapperPlayer.setStarvationRate(ticks)
    override fun getLastDeathLocation(): Location? = wrapperPlayer.lastDeathLocation
    override fun setLastDeathLocation(location: Location?) = wrapperPlayer.setLastDeathLocation(location)
    override fun fireworkBoost(fireworkItemStack: ItemStack): Firework? = wrapperPlayer.fireworkBoost(fireworkItemStack)
    override fun getEyeHeight(): Double = wrapperPlayer.eyeHeight
    override fun getEyeHeight(ignorePose: Boolean): Double = wrapperPlayer.getEyeHeight(ignorePose)
    override fun getEyeLocation(): Location = wrapperPlayer.eyeLocation
    override fun getLineOfSight(transparent: Set<Material?>?, maxDistance: Int): List<Block?> = wrapperPlayer.getLineOfSight(transparent, maxDistance)
    override fun getTargetBlock(transparent: Set<Material?>?, maxDistance: Int): Block = wrapperPlayer.getTargetBlock(transparent, maxDistance)
    override fun getLastTwoTargetBlocks(transparent: Set<Material?>?, maxDistance: Int): List<Block?> = wrapperPlayer.getLastTwoTargetBlocks(transparent, maxDistance)
    override fun getTargetBlockExact(maxDistance: Int): Block? = wrapperPlayer.getTargetBlockExact(maxDistance)
    override fun getTargetBlockExact(maxDistance: Int, fluidCollisionMode: FluidCollisionMode): Block? = wrapperPlayer.getTargetBlockExact(maxDistance, fluidCollisionMode)
    override fun rayTraceBlocks(maxDistance: Double): RayTraceResult? = wrapperPlayer.rayTraceBlocks(maxDistance)
    override fun rayTraceBlocks(maxDistance: Double, fluidCollisionMode: FluidCollisionMode): RayTraceResult? = wrapperPlayer.rayTraceBlocks(maxDistance, fluidCollisionMode)
    override fun getRemainingAir(): Int = wrapperPlayer.remainingAir
    override fun setRemainingAir(ticks: Int) = wrapperPlayer.setRemainingAir(ticks)
    override fun getMaximumAir(): Int = wrapperPlayer.maximumAir
    override fun setMaximumAir(ticks: Int) = wrapperPlayer.setMaximumAir(ticks)
    override fun getItemInUse(): ItemStack? = wrapperPlayer.itemInUse
    override fun getItemInUseTicks(): Int = wrapperPlayer.itemInUseTicks
    override fun setItemInUseTicks(ticks: Int) = wrapperPlayer.setItemInUseTicks(ticks)
    override fun getArrowCooldown(): Int = wrapperPlayer.arrowCooldown
    override fun setArrowCooldown(ticks: Int) = wrapperPlayer.setArrowCooldown(ticks)
    override fun getArrowsInBody(): Int = wrapperPlayer.arrowsInBody
    override fun setArrowsInBody(count: Int) = wrapperPlayer.setArrowsInBody(count)
    override fun getMaximumNoDamageTicks(): Int = wrapperPlayer.maximumNoDamageTicks
    override fun setMaximumNoDamageTicks(ticks: Int) = wrapperPlayer.setMaximumNoDamageTicks(ticks)
    override fun getLastDamage(): Double = wrapperPlayer.lastDamage
    override fun setLastDamage(damage: Double) = wrapperPlayer.setLastDamage(damage)
    override fun getNoDamageTicks(): Int = wrapperPlayer.noDamageTicks
    override fun setNoDamageTicks(ticks: Int) = wrapperPlayer.setNoDamageTicks(ticks)
    override fun getNoActionTicks(): Int = wrapperPlayer.noActionTicks
    override fun setNoActionTicks(ticks: Int) = wrapperPlayer.setNoActionTicks(ticks)
    override fun getKiller(): Player? = wrapperPlayer.killer
    override fun addPotionEffect(effect: PotionEffect): Boolean = wrapperPlayer.addPotionEffect(effect)
    override fun addPotionEffect(effect: PotionEffect, force: Boolean): Boolean = wrapperPlayer.addPotionEffect(effect, force)
    override fun addPotionEffects(effects: Collection<PotionEffect?>): Boolean = wrapperPlayer.addPotionEffects(effects)
    override fun hasPotionEffect(type: PotionEffectType): Boolean = wrapperPlayer.hasPotionEffect(type)
    override fun getPotionEffect(type: PotionEffectType): PotionEffect? = wrapperPlayer.getPotionEffect(type)
    override fun removePotionEffect(type: PotionEffectType) = wrapperPlayer.removePotionEffect(type)
    override fun getActivePotionEffects(): Collection<PotionEffect?> = wrapperPlayer.activePotionEffects
    override fun hasLineOfSight(other: Entity): Boolean = wrapperPlayer.hasLineOfSight(other)
    override fun getRemoveWhenFarAway(): Boolean = wrapperPlayer.removeWhenFarAway
    override fun setRemoveWhenFarAway(remove: Boolean) = wrapperPlayer.setRemoveWhenFarAway(remove)
    override fun getEquipment(): EntityEquipment? = wrapperPlayer.equipment
    override fun setCanPickupItems(pickup: Boolean) = wrapperPlayer.setCanPickupItems(pickup)
    override fun getCanPickupItems(): Boolean = wrapperPlayer.canPickupItems
    override fun isLeashed(): Boolean = wrapperPlayer.isLeashed
    override fun getLeashHolder(): Entity = wrapperPlayer.leashHolder
    override fun setLeashHolder(holder: Entity?): Boolean = wrapperPlayer.setLeashHolder(holder)
    override fun isGliding(): Boolean = wrapperPlayer.isGliding
    override fun setGliding(gliding: Boolean) = wrapperPlayer.setGliding(gliding)
    override fun isSwimming(): Boolean = wrapperPlayer.isSwimming
    override fun setSwimming(swimming: Boolean) = wrapperPlayer.setSwimming(swimming)
    override fun isRiptiding(): Boolean = wrapperPlayer.isRiptiding
    override fun setRiptiding(riptiding: Boolean) = wrapperPlayer.setRiptiding(riptiding)
    override fun isSleeping(): Boolean = wrapperPlayer.isSleeping
    override fun isClimbing(): Boolean = wrapperPlayer.isClimbing
    override fun setAI(ai: Boolean) = wrapperPlayer.setAI(ai)
    override fun hasAI(): Boolean = wrapperPlayer.hasAI()
    override fun attack(target: Entity) = wrapperPlayer.attack(target)
    override fun swingMainHand() = wrapperPlayer.swingMainHand()
    override fun swingOffHand() = wrapperPlayer.swingOffHand()
    override fun playHurtAnimation(yaw: Float) = wrapperPlayer.playHurtAnimation(yaw)
    override fun setCollidable(collidable: Boolean) = wrapperPlayer.setCollidable(collidable)
    override fun isCollidable(): Boolean = wrapperPlayer.isCollidable
    override fun getCollidableExemptions(): Set<UUID?> = wrapperPlayer.collidableExemptions
    override fun <T : Any?> getMemory(memoryKey: MemoryKey<T?>): T? = wrapperPlayer.getMemory(memoryKey)
    override fun <T : Any?> setMemory(memoryKey: MemoryKey<T?>, memoryValue: T?) = wrapperPlayer.setMemory(memoryKey, memoryValue)
    override fun getHurtSound(): Sound? = wrapperPlayer.hurtSound
    override fun getDeathSound(): Sound? = wrapperPlayer.deathSound
    override fun getFallDamageSound(fallHeight: Int): Sound = wrapperPlayer.getFallDamageSound(fallHeight)
    override fun getFallDamageSoundSmall(): Sound = wrapperPlayer.fallDamageSoundSmall
    override fun getFallDamageSoundBig(): Sound = wrapperPlayer.fallDamageSoundBig
    override fun getDrinkingSound(itemStack: ItemStack): Sound = wrapperPlayer.getDrinkingSound(itemStack)
    override fun getEatingSound(itemStack: ItemStack): Sound = wrapperPlayer.getEatingSound(itemStack)
    override fun canBreatheUnderwater(): Boolean = wrapperPlayer.canBreatheUnderwater()
    override fun getCategory(): EntityCategory = wrapperPlayer.category
    override fun setInvisible(invisible: Boolean) = wrapperPlayer.setInvisible(invisible)
    override fun isInvisible(): Boolean = wrapperPlayer.isInvisible
    override fun getAttribute(attribute: Attribute): AttributeInstance? = wrapperPlayer.getAttribute(attribute)
    override fun damage(amount: Double) = wrapperPlayer.damage(amount)
    override fun damage(amount: Double, source: Entity?) = wrapperPlayer.damage(amount, source)
    override fun damage(amount: Double, damageSource: DamageSource) = wrapperPlayer.damage(amount, damageSource)
    override fun getHealth(): Double = wrapperPlayer.health
    override fun setHealth(health: Double) = wrapperPlayer.setHealth(health)
    override fun getAbsorptionAmount(): Double = wrapperPlayer.absorptionAmount
    override fun setAbsorptionAmount(amount: Double) = wrapperPlayer.setAbsorptionAmount(amount)
    override fun getMaxHealth(): Double = wrapperPlayer.maxHealth
    override fun setMaxHealth(health: Double) = wrapperPlayer.setMaxHealth(health)
    override fun resetMaxHealth() = wrapperPlayer.resetMaxHealth()
    override fun setMetadata(metadataKey: String, newMetadataValue: MetadataValue) = wrapperPlayer.setMetadata(metadataKey, newMetadataValue)
    override fun getMetadata(metadataKey: String): List<MetadataValue?> = wrapperPlayer.getMetadata(metadataKey)
    override fun hasMetadata(metadataKey: String): Boolean = wrapperPlayer.hasMetadata(metadataKey)
    override fun removeMetadata(metadataKey: String, owningPlugin: Plugin) = wrapperPlayer.removeMetadata(metadataKey, owningPlugin)
    override fun sendMessage(message: String) = wrapperPlayer.sendMessage(message)
    override fun sendMessage(vararg messages: String?) = wrapperPlayer.sendMessage(*messages)
    override fun sendMessage(sender: UUID?, message: String) = wrapperPlayer.sendMessage(sender, message)
    override fun sendMessage(sender: UUID?, vararg messages: String?) = wrapperPlayer.sendMessage(sender, *messages)
    override fun isPermissionSet(name: String): Boolean = wrapperPlayer.isPermissionSet(name)
    override fun isPermissionSet(perm: Permission): Boolean = wrapperPlayer.isPermissionSet(perm)
    override fun hasPermission(name: String): Boolean = wrapperPlayer.hasPermission(name)
    override fun hasPermission(perm: Permission): Boolean = wrapperPlayer.hasPermission(perm)
    override fun addAttachment(plugin: Plugin, name: String, value: Boolean): PermissionAttachment = wrapperPlayer.addAttachment(plugin, name, value)
    override fun addAttachment(plugin: Plugin): PermissionAttachment = wrapperPlayer.addAttachment(plugin)
    override fun addAttachment(plugin: Plugin, name: String, value: Boolean, ticks: Int): PermissionAttachment? = wrapperPlayer.addAttachment(plugin, name, value, ticks)
    override fun addAttachment(plugin: Plugin, ticks: Int): PermissionAttachment? = wrapperPlayer.addAttachment(plugin, ticks)
    override fun removeAttachment(attachment: PermissionAttachment) = wrapperPlayer.removeAttachment(attachment)
    override fun recalculatePermissions() = wrapperPlayer.recalculatePermissions()
    override fun getEffectivePermissions(): Set<PermissionAttachmentInfo?> = wrapperPlayer.effectivePermissions
    override fun isOp(): Boolean = wrapperPlayer.isOp
    override fun setOp(value: Boolean) = wrapperPlayer.setOp(value)
    override fun getCustomName(): String? = wrapperPlayer.customName
    override fun setCustomName(name: String?) = wrapperPlayer.setCustomName(name)
    override fun getPersistentDataContainer(): PersistentDataContainer = wrapperPlayer.persistentDataContainer
    override fun <T : Projectile?> launchProjectile(projectile: Class<out T?>): T & Any = wrapperPlayer.launchProjectile(projectile)
    override fun <T : Projectile?> launchProjectile(projectile: Class<out T?>, velocity: Vector?): T & Any = wrapperPlayer.launchProjectile(projectile, velocity)
    override fun serialize(): Map<String?, Any?> = wrapperPlayer.serialize()
    override fun sendPluginMessage(source: Plugin, channel: String, message: ByteArray) = wrapperPlayer.sendPluginMessage(source, channel, message)
    override fun getListeningPluginChannels(): Set<String?> = wrapperPlayer.listeningPluginChannels
}