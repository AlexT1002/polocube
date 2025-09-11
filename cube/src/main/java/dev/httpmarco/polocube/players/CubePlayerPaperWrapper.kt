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

abstract class CubePlayerPaperWrapper(val player: Player) : Player {

    override fun getName() = player.name
    override fun getDisplayName() = player.displayName
    override fun setDisplayName(name: String?) = player.setDisplayName(name)
    override fun getPlayerListName() = player.playerListName
    override fun setPlayerListName(name: String?) = player.setPlayerListName(name)
    override fun getPlayerListOrder() = player.playerListOrder
    override fun setPlayerListOrder(order: Int) = player.setPlayerListOrder(order)
    override fun getPlayerListHeader() = player.playerListHeader

    override fun getPlayerListFooter(): String? = player.playerListFooter

    override fun setPlayerListHeader(header: String?) = player.setPlayerListHeader(header)

    override fun setPlayerListFooter(footer: String?) = player.setPlayerListFooter(footer)

    override fun setPlayerListHeaderFooter(header: String?, footer: String?) = player.setPlayerListHeaderFooter(header, footer)

    override fun setCompassTarget(loc: Location) = player.setCompassTarget(loc)

    override fun getCompassTarget(): Location = player.compassTarget

    override fun getAddress(): InetSocketAddress? = player.address

    override fun isTransferred(): Boolean = player.isTransferred

    override fun retrieveCookie(key: NamespacedKey): CompletableFuture<ByteArray?> = player.retrieveCookie(key)

    override fun storeCookie(key: NamespacedKey, value: ByteArray) = player.storeCookie(key, value)

    override fun transfer(host: String, port: Int) = player.transfer(host, port)

    override fun sendRawMessage(message: String) = player.sendRawMessage(message)

    override fun kickPlayer(message: String?) = player.kickPlayer(message)

    override fun ban(
        reason: String?,
        expires: Date?,
        source: String?,
        kickPlayer: Boolean
    ): BanEntry<PlayerProfile?>? = player.ban(reason, expires, source, kickPlayer)

    override fun ban(
        reason: String?,
        expires: Instant?,
        source: String?,
        kickPlayer: Boolean
    ): BanEntry<PlayerProfile?>? = player.ban(reason, expires, source, kickPlayer)

    override fun ban(
        reason: String?,
        duration: Duration?,
        source: String?,
        kickPlayer: Boolean
    ): BanEntry<PlayerProfile?>? = player.ban(reason, duration, source, kickPlayer)

    override fun banIp(
        reason: String?,
        expires: Date?,
        source: String?,
        kickPlayer: Boolean
    ): BanEntry<InetAddress?>? = player.banIp(reason, expires, source, kickPlayer)

    override fun banIp(
        reason: String?,
        expires: Instant?,
        source: String?,
        kickPlayer: Boolean
    ): BanEntry<InetAddress?>? = player.banIp(reason, expires, source, kickPlayer)

    override fun banIp(
        reason: String?,
        duration: Duration?,
        source: String?,
        kickPlayer: Boolean
    ): BanEntry<InetAddress?>? = player.banIp(reason, duration, source, kickPlayer)

    override fun chat(msg: String) = player.chat(msg)

    override fun performCommand(command: String): Boolean = player.performCommand(command)

    override fun isOnGround(): Boolean = player.isOnGround

    override fun isSneaking(): Boolean = player.isSneaking

    override fun setSneaking(sneak: Boolean) = player.setSneaking(sneak)

    override fun isSprinting(): Boolean = player.isSprinting

    override fun setSprinting(sprinting: Boolean) = player.setSprinting(sprinting)

    override fun saveData() = player.saveData()

    override fun loadData() = player.loadData()

    override fun setSleepingIgnored(isSleeping: Boolean) = player.setSleepingIgnored(isSleeping)

    override fun isSleepingIgnored(): Boolean = player.isSleepingIgnored

    override fun getBedSpawnLocation(): Location? = player.bedSpawnLocation

    override fun getRespawnLocation(): Location? = player.respawnLocation

    override fun setBedSpawnLocation(location: Location?) = player.setBedSpawnLocation(location)

    override fun setRespawnLocation(location: Location?) = player.setRespawnLocation(location)

    override fun setBedSpawnLocation(location: Location?, force: Boolean) = player.setBedSpawnLocation(location, force)

    override fun setRespawnLocation(location: Location?, force: Boolean) = player.setRespawnLocation(location, force)

    override fun getEnderPearls(): Collection<EnderPearl?> = player.enderPearls

    override fun getCurrentInput(): Input = player.currentInput

    override fun playNote(loc: Location, instrument: Byte, note: Byte) = player.playNote(loc, instrument, note)

    override fun playNote(loc: Location, instrument: Instrument, note: Note) = player.playNote(loc, instrument, note)

    override fun playSound(
        location: Location,
        sound: Sound,
        volume: Float,
        pitch: Float
    ) = player.playSound(location, sound, volume, pitch)

    override fun playSound(
        location: Location,
        sound: String,
        volume: Float,
        pitch: Float
    ) = player.playSound(location, sound, volume, pitch)

    override fun playSound(
        location: Location,
        sound: Sound,
        category: SoundCategory,
        volume: Float,
        pitch: Float
    ) = player.playSound(location, sound, category, volume, pitch)

    override fun playSound(
        location: Location,
        sound: String,
        category: SoundCategory,
        volume: Float,
        pitch: Float
    ) = player.playSound(location, sound, category, volume, pitch)

    override fun playSound(
        location: Location,
        sound: Sound,
        category: SoundCategory,
        volume: Float,
        pitch: Float,
        seed: Long
    ) = player.playSound(location, sound, category, volume, pitch, seed)

    override fun playSound(
        location: Location,
        sound: String,
        category: SoundCategory,
        volume: Float,
        pitch: Float,
        seed: Long
    ) = player.playSound(location, sound, category, volume, pitch, seed)

    override fun playSound(
        entity: Entity,
        sound: Sound,
        volume: Float,
        pitch: Float
    ) = player.playSound(entity, sound, volume, pitch)

    override fun playSound(
        entity: Entity,
        sound: String,
        volume: Float,
        pitch: Float
    ) = player.playSound(entity, sound, volume, pitch)

    override fun playSound(
        entity: Entity,
        sound: Sound,
        category: SoundCategory,
        volume: Float,
        pitch: Float
    ) = player.playSound(entity, sound, category, volume, pitch)

    override fun playSound(
        entity: Entity,
        sound: String,
        category: SoundCategory,
        volume: Float,
        pitch: Float
    ) = player.playSound(entity, sound, category, volume, pitch)

    override fun playSound(
        entity: Entity,
        sound: Sound,
        category: SoundCategory,
        volume: Float,
        pitch: Float,
        seed: Long
    ) = player.playSound(entity, sound, category, volume, pitch, seed)

    override fun playSound(
        entity: Entity,
        sound: String,
        category: SoundCategory,
        volume: Float,
        pitch: Float,
        seed: Long
    ) = player.playSound(entity, sound, category, volume, pitch, seed)

    override fun stopSound(sound: Sound) = player.stopSound(sound)

    override fun stopSound(sound: String) = player.stopSound(sound)

    override fun stopSound(sound: Sound, category: SoundCategory?) = player.stopSound(sound, category)

    override fun stopSound(sound: String, category: SoundCategory?) = player.stopSound(sound, category)

    override fun stopSound(category: SoundCategory) = player.stopSound(category)

    override fun stopAllSounds() = player.stopAllSounds()

    override fun playEffect(loc: Location, effect: Effect, data: Int) = player.playEffect(loc, effect, data)

    override fun <T : Any?> playEffect(loc: Location, effect: Effect, data: T?) = player.playEffect(loc, effect, data)

    override fun breakBlock(block: Block): Boolean = player.breakBlock(block)

    override fun sendBlockChange(loc: Location, material: Material, data: Byte) = player.sendBlockChange(loc, material, data)

    override fun sendBlockChange(loc: Location, block: BlockData) = player.sendBlockChange(loc, block)

    override fun sendBlockChanges(blocks: Collection<BlockState?>) = player.sendBlockChanges(blocks)

    override fun sendBlockChanges(
        blocks: Collection<BlockState?>,
        suppressLightUpdates: Boolean
    ) = player.sendBlockChanges(blocks, suppressLightUpdates)

    override fun sendBlockDamage(loc: Location, progress: Float) = player.sendBlockDamage(loc, progress)

    override fun sendBlockDamage(loc: Location, progress: Float, source: Entity) = player.sendBlockDamage(loc, progress, source)

    override fun sendBlockDamage(loc: Location, progress: Float, sourceId: Int) = player.sendBlockDamage(loc, progress, sourceId)

    override fun sendEquipmentChange(
        entity: LivingEntity,
        slot: EquipmentSlot,
        item: ItemStack?
    ) = player.sendEquipmentChange(entity, slot, item)

    override fun sendEquipmentChange(
        entity: LivingEntity,
        items: Map<EquipmentSlot?, ItemStack?>
    ) = player.sendEquipmentChange(entity, items)

    override fun sendSignChange(loc: Location, lines: Array<out String?>?) = player.sendSignChange(loc, lines)

    override fun sendSignChange(
        loc: Location,
        lines: Array<out String?>?,
        dyeColor: DyeColor
    ) = player.sendSignChange(loc, lines, dyeColor)

    override fun sendSignChange(
        loc: Location,
        lines: Array<out String?>?,
        dyeColor: DyeColor,
        hasGlowingText: Boolean
    ) = player.sendSignChange(loc, lines, dyeColor, hasGlowingText)

    override fun sendBlockUpdate(loc: Location, tileState: TileState) = player.sendBlockUpdate(loc, tileState)

    override fun sendPotionEffectChange(
        entity: LivingEntity,
        effect: PotionEffect
    ) = player.sendPotionEffectChange(entity, effect)

    override fun sendPotionEffectChangeRemove(
        entity: LivingEntity,
        type: PotionEffectType
    ) = player.sendPotionEffectChangeRemove(entity, type)

    override fun sendMap(map: MapView) = player.sendMap(map)

    override fun sendHurtAnimation(yaw: Float) = player.sendHurtAnimation(yaw)

    override fun sendLinks(links: ServerLinks) = player.sendLinks(links)

    override fun addCustomChatCompletions(completions: Collection<String?>) = player.addCustomChatCompletions(completions)

    override fun removeCustomChatCompletions(completions: Collection<String?>) = player.removeCustomChatCompletions(completions)

    override fun setCustomChatCompletions(completions: Collection<String?>) = player.setCustomChatCompletions(completions)

    override fun updateInventory() = player.updateInventory()

    override fun getPreviousGameMode(): GameMode? = player.previousGameMode

    override fun setPlayerTime(time: Long, relative: Boolean) = player.setPlayerTime(time, relative)

    override fun getPlayerTime(): Long = player.playerTime

    override fun getPlayerTimeOffset(): Long = player.playerTimeOffset

    override fun isPlayerTimeRelative(): Boolean = player.isPlayerTimeRelative

    override fun resetPlayerTime() = player.resetPlayerTime()

    override fun setPlayerWeather(type: WeatherType) = player.setPlayerWeather(type)

    override fun getPlayerWeather(): WeatherType? = player.playerWeather

    override fun resetPlayerWeather() = player.resetPlayerWeather()

    override fun getExpCooldown(): Int = player.expCooldown

    override fun setExpCooldown(ticks: Int) = player.setExpCooldown(ticks)

    override fun giveExp(amount: Int) = player.giveExp(amount)

    override fun giveExpLevels(amount: Int) = player.giveExpLevels(amount)

    override fun getExp(): Float = player.exp

    override fun setExp(exp: Float) = player.setExp(exp)

    override fun getLevel(): Int = player.level

    override fun setLevel(level: Int) = player.setLevel(level)

    override fun getTotalExperience(): Int = player.totalExperience

    override fun setTotalExperience(exp: Int) = player.setTotalExperience(exp)

    override fun sendExperienceChange(progress: Float) = player.sendExperienceChange(progress)

    override fun sendExperienceChange(progress: Float, level: Int) = player.sendExperienceChange(progress, level)

    override fun getAllowFlight(): Boolean = player.allowFlight

    override fun setAllowFlight(flight: Boolean) = player.setAllowFlight(flight)

    override fun hidePlayer(player: Player) = player.hidePlayer(player)

    override fun hidePlayer(plugin: Plugin, player: Player) = player.hidePlayer(plugin, player)

    override fun showPlayer(player: Player) = player.showPlayer(player)

    override fun showPlayer(plugin: Plugin, player: Player) = player.showPlayer(plugin, player)

    override fun canSee(player: Player): Boolean = player.canSee(player)

    override fun hideEntity(plugin: Plugin, entity: Entity) = player.hideEntity(plugin, entity)

    override fun showEntity(plugin: Plugin, entity: Entity) = player.showEntity(plugin, entity)

    override fun canSee(entity: Entity): Boolean = player.canSee(entity)

    override fun isFlying(): Boolean = player.isFlying

    override fun setFlying(value: Boolean) = player.setFlying(value)

    override fun setFlySpeed(value: Float) = player.setFlySpeed(value)

    override fun setWalkSpeed(value: Float) = player.setWalkSpeed(value)

    override fun getFlySpeed(): Float = player.flySpeed

    override fun getWalkSpeed(): Float = player.walkSpeed

    override fun setTexturePack(url: String) = player.setTexturePack(url)

    override fun setResourcePack(url: String) = player.setResourcePack(url)

    override fun setResourcePack(url: String, hash: ByteArray?) = player.setResourcePack(url, hash)

    override fun setResourcePack(url: String, hash: ByteArray?, prompt: String?) = player.setResourcePack(url, hash, prompt)

    override fun setResourcePack(url: String, hash: ByteArray?, force: Boolean) = player.setResourcePack(url, hash, force)

    override fun setResourcePack(
        url: String,
        hash: ByteArray?,
        prompt: String?,
        force: Boolean
    ) = player.setResourcePack(url, hash, prompt, force)

    override fun setResourcePack(
        id: UUID,
        url: String,
        hash: ByteArray?,
        prompt: String?,
        force: Boolean
    ) = player.setResourcePack(id, url, hash, prompt, force)

    override fun addResourcePack(
        id: UUID,
        url: String,
        hash: ByteArray?,
        prompt: String?,
        force: Boolean
    ) = player.addResourcePack(id, url, hash, prompt, force)

    override fun removeResourcePack(id: UUID) = player.removeResourcePack(id)

    override fun removeResourcePacks() = player.removeResourcePacks()

    override fun getScoreboard(): Scoreboard = player.scoreboard

    override fun setScoreboard(scoreboard: Scoreboard) = player.setScoreboard(scoreboard)

    override fun getWorldBorder(): WorldBorder? = player.worldBorder

    override fun setWorldBorder(border: WorldBorder?) = player.setWorldBorder(border)

    override fun sendHealthUpdate(health: Double, foodLevel: Int, saturation: Float) = player.sendHealthUpdate(health, foodLevel, saturation)

    override fun sendHealthUpdate() = player.sendHealthUpdate()

    override fun isHealthScaled(): Boolean = player.isHealthScaled

    override fun setHealthScaled(scale: Boolean) = player.setHealthScaled(scale)

    override fun setHealthScale(scale: Double) = player.setHealthScale(scale)

    override fun getHealthScale(): Double = player.healthScale

    override fun getSpectatorTarget(): Entity? = player.spectatorTarget

    override fun setSpectatorTarget(entity: Entity?) = player.setSpectatorTarget(entity)

    override fun sendTitle(title: String?, subtitle: String?) = player.sendTitle(title, subtitle)

    override fun sendTitle(
        title: String?,
        subtitle: String?,
        fadeIn: Int,
        stay: Int,
        fadeOut: Int
    ) = player.sendTitle(title, subtitle, fadeIn, stay, fadeOut)

    override fun resetTitle() = player.resetTitle()

    override fun spawnParticle(particle: Particle, location: Location, count: Int) = player.spawnParticle(particle, location, count)

    override fun spawnParticle(
        particle: Particle,
        x: Double,
        y: Double,
        z: Double,
        count: Int
    ) = player.spawnParticle(particle, x, y, z, count)

    override fun <T : Any?> spawnParticle(
        particle: Particle,
        location: Location,
        count: Int,
        data: T?
    ) = player.spawnParticle(particle, location, count, data)

    override fun <T : Any?> spawnParticle(
        particle: Particle,
        x: Double,
        y: Double,
        z: Double,
        count: Int,
        data: T?
    ) = player.spawnParticle(particle, x, y, z, count, data)

    override fun spawnParticle(
        particle: Particle,
        location: Location,
        count: Int,
        offsetX: Double,
        offsetY: Double,
        offsetZ: Double
    ) = player.spawnParticle(particle, location, count, offsetX, offsetY, offsetZ)

    override fun spawnParticle(
        particle: Particle,
        x: Double,
        y: Double,
        z: Double,
        count: Int,
        offsetX: Double,
        offsetY: Double,
        offsetZ: Double
    ) = player.spawnParticle(particle, x, y, z, count, offsetX, offsetY, offsetZ)

    override fun <T : Any?> spawnParticle(
        particle: Particle,
        location: Location,
        count: Int,
        offsetX: Double,
        offsetY: Double,
        offsetZ: Double,
        data: T?
    ) = player.spawnParticle(particle, location, count, offsetX, offsetY, offsetZ, data)

    override fun <T : Any?> spawnParticle(
        particle: Particle,
        x: Double,
        y: Double,
        z: Double,
        count: Int,
        offsetX: Double,
        offsetY: Double,
        offsetZ: Double,
        data: T?
    ) = player.spawnParticle(particle, x, y, z, count, offsetX, offsetY, offsetZ, data)

    override fun spawnParticle(
        particle: Particle,
        location: Location,
        count: Int,
        offsetX: Double,
        offsetY: Double,
        offsetZ: Double,
        extra: Double
    ) = player.spawnParticle(particle, location, count, offsetX, offsetY, offsetZ, extra)

    override fun spawnParticle(
        particle: Particle,
        x: Double,
        y: Double,
        z: Double,
        count: Int,
        offsetX: Double,
        offsetY: Double,
        offsetZ: Double,
        extra: Double
    ) = player.spawnParticle(particle, x, y, z, count, offsetX, offsetY, offsetZ, extra)

    override fun <T : Any?> spawnParticle(
        particle: Particle,
        location: Location,
        count: Int,
        offsetX: Double,
        offsetY: Double,
        offsetZ: Double,
        extra: Double,
        data: T?
    ) = player.spawnParticle(particle, location, count, offsetX, offsetY, offsetZ, extra, data)

    override fun <T : Any?> spawnParticle(
        particle: Particle,
        x: Double,
        y: Double,
        z: Double,
        count: Int,
        offsetX: Double,
        offsetY: Double,
        offsetZ: Double,
        extra: Double,
        data: T?
    ) = player.spawnParticle(particle, x, y, z, count, offsetX, offsetY, offsetZ, extra, data)

    override fun <T : Any?> spawnParticle(
        particle: Particle,
        location: Location,
        count: Int,
        offsetX: Double,
        offsetY: Double,
        offsetZ: Double,
        extra: Double,
        data: T?,
        force: Boolean
    ) = player.spawnParticle(particle, location, count, offsetX, offsetY, offsetZ, extra, data, force)

    override fun <T : Any?> spawnParticle(
        particle: Particle,
        x: Double,
        y: Double,
        z: Double,
        count: Int,
        offsetX: Double,
        offsetY: Double,
        offsetZ: Double,
        extra: Double,
        data: T?,
        force: Boolean
    ) = player.spawnParticle(particle, x, y, z, count, offsetX, offsetY, offsetZ, extra, data, force)

    override fun getAdvancementProgress(advancement: Advancement): AdvancementProgress = player.getAdvancementProgress(advancement)

    override fun getClientViewDistance(): Int = player.clientViewDistance

    override fun getPing(): Int = player.ping

    override fun getLocale(): String = player.locale

    override fun updateCommands() = player.updateCommands()

    override fun openBook(book: ItemStack) = player.openBook(book)

    override fun openSign(sign: Sign) = player.openSign(sign)

    override fun openSign(sign: Sign, side: Side) = player.openSign(sign, side)

    override fun showDemoScreen() = player.showDemoScreen()

    override fun isAllowingServerListings(): Boolean = player.isAllowingServerListings

    override fun spigot(): Player.Spigot = player.spigot()

    override fun isConversing(): Boolean = player.isConversing

    override fun acceptConversationInput(input: String) = player.acceptConversationInput(input)

    override fun beginConversation(conversation: Conversation): Boolean = player.beginConversation(conversation)

    override fun abandonConversation(conversation: Conversation) = player.abandonConversation(conversation)

    override fun abandonConversation(
        conversation: Conversation,
        details: ConversationAbandonedEvent
    ) = player.abandonConversation(conversation, details)

    override fun sendRawMessage(sender: UUID?, message: String) = player.sendRawMessage(sender, message)

    override fun isOnline(): Boolean = player.isOnline

    override fun getPlayerProfile(): PlayerProfile = player.playerProfile

    override fun isBanned(): Boolean = player.isBanned

    override fun ban(
        reason: String?,
        expires: Date?,
        source: String?
    ): BanEntry<PlayerProfile?>? = player.ban(reason, expires, source)

    override fun ban(
        reason: String?,
        expires: Instant?,
        source: String?
    ): BanEntry<PlayerProfile?>? = player.ban(reason, expires, source)

    override fun ban(
        reason: String?,
        duration: Duration?,
        source: String?
    ): BanEntry<PlayerProfile?>? = player.ban(reason, duration, source)

    override fun isWhitelisted(): Boolean = player.isWhitelisted

    override fun setWhitelisted(value: Boolean) = player.setWhitelisted(value)

    override fun getPlayer(): Player? = player.player

    override fun getFirstPlayed(): Long = player.firstPlayed

    override fun getLastPlayed(): Long = player.lastPlayed

    override fun hasPlayedBefore(): Boolean = player.hasPlayedBefore()

    override fun incrementStatistic(statistic: Statistic) = player.incrementStatistic(statistic)

    override fun decrementStatistic(statistic: Statistic) = player.decrementStatistic(statistic)

    override fun incrementStatistic(statistic: Statistic, amount: Int) = player.incrementStatistic(statistic, amount)

    override fun decrementStatistic(statistic: Statistic, amount: Int) = player.decrementStatistic(statistic, amount)

    override fun setStatistic(statistic: Statistic, newValue: Int) = player.setStatistic(statistic, newValue)

    override fun getStatistic(statistic: Statistic): Int = player.getStatistic(statistic)

    override fun incrementStatistic(statistic: Statistic, material: Material) = player.incrementStatistic(statistic, material)

    override fun decrementStatistic(statistic: Statistic, material: Material) = player.decrementStatistic(statistic, material)

    override fun getStatistic(statistic: Statistic, material: Material): Int = player.getStatistic(statistic, material)

    override fun incrementStatistic(
        statistic: Statistic,
        material: Material,
        amount: Int
    ) = player.incrementStatistic(statistic, material, amount)

    override fun decrementStatistic(
        statistic: Statistic,
        material: Material,
        amount: Int
    ) = player.decrementStatistic(statistic, material, amount)

    override fun setStatistic(statistic: Statistic, material: Material, newValue: Int) = player.setStatistic(statistic, material, newValue)

    override fun incrementStatistic(statistic: Statistic, entityType: EntityType) = player.incrementStatistic(statistic, entityType)

    override fun decrementStatistic(statistic: Statistic, entityType: EntityType) = player.decrementStatistic(statistic, entityType)

    override fun getStatistic(statistic: Statistic, entityType: EntityType): Int = player.getStatistic(statistic, entityType)

    override fun incrementStatistic(
        statistic: Statistic,
        entityType: EntityType,
        amount: Int
    ) = player.incrementStatistic(statistic, entityType, amount)

    override fun decrementStatistic(
        statistic: Statistic,
        entityType: EntityType,
        amount: Int
    ) = player.decrementStatistic(statistic, entityType, amount)

    override fun setStatistic(
        statistic: Statistic,
        entityType: EntityType,
        newValue: Int
    ) = player.setStatistic(statistic, entityType, newValue)

    override fun getLocation(): Location = player.location

    override fun getLocation(loc: Location?): Location? = player.getLocation(loc)

    override fun setVelocity(velocity: Vector) = player.setVelocity(velocity)

    override fun getVelocity(): Vector = player.velocity

    override fun getHeight(): Double = player.height

    override fun getWidth(): Double = player.width

    override fun getBoundingBox(): BoundingBox = player.boundingBox

    override fun isInWater(): Boolean = player.isInWater

    override fun getWorld(): World = player.world

    override fun setRotation(yaw: Float, pitch: Float) = player.setRotation(yaw, pitch)

    override fun teleport(location: Location): Boolean = player.teleport(location)

    override fun teleport(
        location: Location,
        cause: PlayerTeleportEvent.TeleportCause
    ): Boolean = player.teleport(location, cause)

    override fun teleport(destination: Entity): Boolean = player.teleport(destination)

    override fun teleport(
        destination: Entity,
        cause: PlayerTeleportEvent.TeleportCause
    ): Boolean = player.teleport(destination, cause)

    override fun getNearbyEntities(
        x: Double,
        y: Double,
        z: Double
    ): List<Entity?> = player.getNearbyEntities(x, y, z)

    override fun getEntityId(): Int = player.entityId

    override fun getFireTicks(): Int = player.fireTicks

    override fun getMaxFireTicks(): Int = player.maxFireTicks

    override fun setFireTicks(ticks: Int) = player.setFireTicks(ticks)

    override fun setVisualFire(fire: Boolean) = player.setVisualFire(fire)

    override fun isVisualFire(): Boolean = player.isVisualFire

    override fun getFreezeTicks(): Int = player.freezeTicks

    override fun getMaxFreezeTicks(): Int = player.maxFreezeTicks

    override fun setFreezeTicks(ticks: Int) = player.setFreezeTicks(ticks)

    override fun isFrozen(): Boolean = player.isFrozen

    override fun remove() = player.remove()

    override fun isDead(): Boolean = player.isDead

    override fun isValid(): Boolean = player.isValid

    override fun getServer(): Server = player.server

    override fun isPersistent(): Boolean = player.isPersistent

    override fun setPersistent(persistent: Boolean) = player.setPersistent(persistent)

    override fun getPassenger(): Entity? = player.passenger

    override fun setPassenger(passenger: Entity): Boolean = player.setPassenger(passenger)

    override fun getPassengers(): List<Entity?> = player.passengers

    override fun addPassenger(passenger: Entity): Boolean = player.addPassenger(passenger)

    override fun removePassenger(passenger: Entity): Boolean = player.removePassenger(passenger)

    override fun isEmpty(): Boolean = player.isEmpty

    override fun eject(): Boolean = player.eject()

    override fun getFallDistance(): Float = player.fallDistance

    override fun setFallDistance(distance: Float) = player.setFallDistance(distance)

    override fun setLastDamageCause(event: EntityDamageEvent?) = player.setLastDamageCause(event)

    override fun getLastDamageCause(): EntityDamageEvent? = player.lastDamageCause

    override fun getUniqueId(): UUID = player.uniqueId

    override fun getTicksLived(): Int = player.ticksLived

    override fun setTicksLived(value: Int) = player.setTicksLived(value)

    override fun playEffect(type: EntityEffect) = player.playEffect(type)

    override fun getType(): EntityType = player.type

    override fun getSwimSound(): Sound = player.swimSound

    override fun getSwimSplashSound(): Sound = player.swimSplashSound

    override fun getSwimHighSpeedSplashSound(): Sound = player.swimHighSpeedSplashSound

    override fun isInsideVehicle(): Boolean = player.isInsideVehicle

    override fun leaveVehicle(): Boolean = player.leaveVehicle()

    override fun getVehicle(): Entity? = player.vehicle

    override fun setCustomNameVisible(flag: Boolean) = player.setCustomNameVisible(flag)

    override fun isCustomNameVisible(): Boolean = player.isCustomNameVisible

    override fun setVisibleByDefault(visible: Boolean) = player.setVisibleByDefault(visible)

    override fun isVisibleByDefault(): Boolean = player.isVisibleByDefault

    override fun getTrackedBy(): Set<Player?> = player.trackedBy

    override fun setGlowing(flag: Boolean) = player.setGlowing(flag)

    override fun isGlowing(): Boolean = player.isGlowing

    override fun setInvulnerable(flag: Boolean) = player.setInvulnerable(flag)

    override fun isInvulnerable(): Boolean = player.isInvulnerable

    override fun isSilent(): Boolean = player.isSilent

    override fun setSilent(flag: Boolean) = player.setSilent(flag)

    override fun hasGravity(): Boolean = player.hasGravity()

    override fun setGravity(gravity: Boolean) = player.setGravity(gravity)

    override fun getPortalCooldown(): Int = player.portalCooldown

    override fun setPortalCooldown(cooldown: Int) = player.setPortalCooldown(cooldown)

    override fun getScoreboardTags(): Set<String?> = player.scoreboardTags

    override fun addScoreboardTag(tag: String): Boolean = player.addScoreboardTag(tag)

    override fun removeScoreboardTag(tag: String): Boolean = player.removeScoreboardTag(tag)

    override fun getPistonMoveReaction(): PistonMoveReaction = player.pistonMoveReaction

    override fun getFacing(): BlockFace = player.facing

    override fun getPose(): Pose = player.pose

    override fun getSpawnCategory(): SpawnCategory = player.spawnCategory

    override fun isInWorld(): Boolean = player.isInWorld

    override fun getAsString(): String? = player.asString

    override fun createSnapshot(): EntitySnapshot? = player.createSnapshot()

    override fun copy(): Entity = player.copy()

    override fun copy(to: Location): Entity = player.copy(to)

    override fun getInventory(): PlayerInventory = player.inventory

    override fun getEnderChest(): Inventory = player.enderChest

    override fun getMainHand(): MainHand = player.mainHand

    override fun setWindowProperty(
        prop: InventoryView.Property,
        value: Int
    ): Boolean = player.setWindowProperty(prop, value)

    override fun getEnchantmentSeed(): Int = player.enchantmentSeed

    override fun setEnchantmentSeed(seed: Int) = player.setEnchantmentSeed(seed)

    override fun getOpenInventory(): InventoryView = player.openInventory

    override fun openInventory(inventory: Inventory): InventoryView? = player.openInventory(inventory)

    override fun openWorkbench(
        location: Location?,
        force: Boolean
    ): InventoryView? = player.openWorkbench(location, force)

    override fun openEnchanting(
        location: Location?,
        force: Boolean
    ): InventoryView? = player.openEnchanting(location, force)

    override fun openInventory(inventory: InventoryView) = player.openInventory(inventory)

    override fun openMerchant(
        trader: Villager,
        force: Boolean
    ): InventoryView? = player.openMerchant(trader, force)

    override fun openMerchant(
        merchant: Merchant,
        force: Boolean
    ): InventoryView? = player.openMerchant(merchant, force)

    override fun closeInventory() = player.closeInventory()

    override fun getItemInHand(): ItemStack = player.itemInHand

    override fun setItemInHand(item: ItemStack?) = player.setItemInHand(item)

    override fun getItemOnCursor(): ItemStack = player.itemOnCursor

    override fun setItemOnCursor(item: ItemStack?) = player.setItemOnCursor(item)

    override fun hasCooldown(material: Material): Boolean = player.hasCooldown(material)

    override fun getCooldown(material: Material): Int = player.getCooldown(material)

    override fun setCooldown(material: Material, ticks: Int) = player.setCooldown(material, ticks)

    override fun hasCooldown(item: ItemStack): Boolean = player.hasCooldown(item)

    override fun getCooldown(item: ItemStack): Int = player.getCooldown(item)

    override fun setCooldown(item: ItemStack, ticks: Int) = player.setCooldown(item, ticks)

    override fun getSleepTicks(): Int = player.sleepTicks

    override fun sleep(location: Location, force: Boolean): Boolean = player.sleep(location, force)

    override fun wakeup(setSpawnLocation: Boolean) = player.wakeup(setSpawnLocation)

    override fun startRiptideAttack(
        duration: Int,
        attackStrength: Float,
        attackItem: ItemStack?
    ) = player.startRiptideAttack(duration, attackStrength, attackItem)

    override fun getBedLocation(): Location = player.bedLocation

    override fun getGameMode(): GameMode = player.gameMode

    override fun setGameMode(mode: GameMode) = player.setGameMode(mode)

    override fun isBlocking(): Boolean = player.isBlocking

    override fun isHandRaised(): Boolean = player.isHandRaised

    override fun getExpToLevel(): Int = player.expToLevel

    override fun getAttackCooldown(): Float = player.attackCooldown

    override fun discoverRecipe(recipe: NamespacedKey): Boolean = player.discoverRecipe(recipe)

    override fun discoverRecipes(recipes: Collection<NamespacedKey?>): Int = player.discoverRecipes(recipes)

    override fun undiscoverRecipe(recipe: NamespacedKey): Boolean = player.undiscoverRecipe(recipe)

    override fun undiscoverRecipes(recipes: Collection<NamespacedKey?>): Int = player.undiscoverRecipes(recipes)

    override fun hasDiscoveredRecipe(recipe: NamespacedKey): Boolean = player.hasDiscoveredRecipe(recipe)

    override fun getDiscoveredRecipes(): Set<NamespacedKey?> = player.discoveredRecipes

    override fun getShoulderEntityLeft(): Entity? = player.shoulderEntityLeft

    override fun setShoulderEntityLeft(entity: Entity?) = player.setShoulderEntityLeft(entity)

    override fun getShoulderEntityRight(): Entity? = player.shoulderEntityRight

    override fun setShoulderEntityRight(entity: Entity?) = player.setShoulderEntityRight(entity)

    override fun dropItem(dropAll: Boolean): Boolean = player.dropItem(dropAll)

    override fun getExhaustion(): Float = player.exhaustion

    override fun setExhaustion(value: Float) = player.setExhaustion(value)

    override fun getSaturation(): Float = player.saturation

    override fun setSaturation(value: Float) = player.setSaturation(value)

    override fun getFoodLevel(): Int = player.foodLevel

    override fun setFoodLevel(value: Int) = player.setFoodLevel(value)

    override fun getSaturatedRegenRate(): Int = player.saturatedRegenRate

    override fun setSaturatedRegenRate(ticks: Int) = player.setSaturatedRegenRate(ticks)

    override fun getUnsaturatedRegenRate(): Int = player.unsaturatedRegenRate

    override fun setUnsaturatedRegenRate(ticks: Int) = player.setUnsaturatedRegenRate(ticks)

    override fun getStarvationRate(): Int = player.starvationRate

    override fun setStarvationRate(ticks: Int) = player.setStarvationRate(ticks)

    override fun getLastDeathLocation(): Location? = player.lastDeathLocation

    override fun setLastDeathLocation(location: Location?) = player.setLastDeathLocation(location)

    override fun fireworkBoost(fireworkItemStack: ItemStack): Firework? = player.fireworkBoost(fireworkItemStack)

    override fun getEyeHeight(): Double = player.eyeHeight

    override fun getEyeHeight(ignorePose: Boolean): Double = player.getEyeHeight(ignorePose)

    override fun getEyeLocation(): Location = player.eyeLocation

    override fun getLineOfSight(
        transparent: Set<Material?>?,
        maxDistance: Int
    ): List<Block?> = player.getLineOfSight(transparent, maxDistance)

    override fun getTargetBlock(
        transparent: Set<Material?>?,
        maxDistance: Int
    ): Block = player.getTargetBlock(transparent, maxDistance)

    override fun getLastTwoTargetBlocks(
        transparent: Set<Material?>?,
        maxDistance: Int
    ): List<Block?> = player.getLastTwoTargetBlocks(transparent, maxDistance)

    override fun getTargetBlockExact(maxDistance: Int): Block? = player.getTargetBlockExact(maxDistance)

    override fun getTargetBlockExact(
        maxDistance: Int,
        fluidCollisionMode: FluidCollisionMode
    ): Block? = player.getTargetBlockExact(maxDistance, fluidCollisionMode)

    override fun rayTraceBlocks(maxDistance: Double): RayTraceResult? = player.rayTraceBlocks(maxDistance)

    override fun rayTraceBlocks(
        maxDistance: Double,
        fluidCollisionMode: FluidCollisionMode
    ): RayTraceResult? = player.rayTraceBlocks(maxDistance, fluidCollisionMode)

    override fun getRemainingAir(): Int = player.remainingAir

    override fun setRemainingAir(ticks: Int) = player.setRemainingAir(ticks)

    override fun getMaximumAir(): Int = player.maximumAir

    override fun setMaximumAir(ticks: Int) = player.setMaximumAir(ticks)

    override fun getItemInUse(): ItemStack? = player.itemInUse

    override fun getItemInUseTicks(): Int = player.itemInUseTicks

    override fun setItemInUseTicks(ticks: Int) = player.setItemInUseTicks(ticks)

    override fun getArrowCooldown(): Int = player.arrowCooldown

    override fun setArrowCooldown(ticks: Int) = player.setArrowCooldown(ticks)

    override fun getArrowsInBody(): Int = player.arrowsInBody

    override fun setArrowsInBody(count: Int) = player.setArrowsInBody(count)

    override fun getMaximumNoDamageTicks(): Int = player.maximumNoDamageTicks

    override fun setMaximumNoDamageTicks(ticks: Int) = player.setMaximumNoDamageTicks(ticks)

    override fun getLastDamage(): Double = player.lastDamage

    override fun setLastDamage(damage: Double) = player.setLastDamage(damage)

    override fun getNoDamageTicks(): Int = player.noDamageTicks

    override fun setNoDamageTicks(ticks: Int) = player.setNoDamageTicks(ticks)

    override fun getNoActionTicks(): Int = player.noActionTicks

    override fun setNoActionTicks(ticks: Int) = player.setNoActionTicks(ticks)

    override fun getKiller(): Player? = player.killer

    override fun addPotionEffect(effect: PotionEffect): Boolean = player.addPotionEffect(effect)

    override fun addPotionEffect(effect: PotionEffect, force: Boolean): Boolean = player.addPotionEffect(effect, force)

    override fun addPotionEffects(effects: Collection<PotionEffect?>): Boolean = player.addPotionEffects(effects)

    override fun hasPotionEffect(type: PotionEffectType): Boolean = player.hasPotionEffect(type)

    override fun getPotionEffect(type: PotionEffectType): PotionEffect? = player.getPotionEffect(type)

    override fun removePotionEffect(type: PotionEffectType) = player.removePotionEffect(type)

    override fun getActivePotionEffects(): Collection<PotionEffect?> = player.activePotionEffects

    override fun hasLineOfSight(other: Entity): Boolean = player.hasLineOfSight(other)

    override fun getRemoveWhenFarAway(): Boolean = player.removeWhenFarAway

    override fun setRemoveWhenFarAway(remove: Boolean) = player.setRemoveWhenFarAway(remove)

    override fun getEquipment(): EntityEquipment? = player.equipment

    override fun setCanPickupItems(pickup: Boolean) = player.setCanPickupItems(pickup)

    override fun getCanPickupItems(): Boolean = player.canPickupItems

    override fun isLeashed(): Boolean = player.isLeashed

    override fun getLeashHolder(): Entity = player.leashHolder

    override fun setLeashHolder(holder: Entity?): Boolean = player.setLeashHolder(holder)

    override fun isGliding(): Boolean = player.isGliding

    override fun setGliding(gliding: Boolean) = player.setGliding(gliding)

    override fun isSwimming(): Boolean = player.isSwimming

    override fun setSwimming(swimming: Boolean) = player.setSwimming(swimming)

    override fun isRiptiding(): Boolean = player.isRiptiding

    override fun setRiptiding(riptiding: Boolean) = player.setRiptiding(riptiding)

    override fun isSleeping(): Boolean = player.isSleeping

    override fun isClimbing(): Boolean = player.isClimbing

    override fun setAI(ai: Boolean) = player.setAI(ai)

    override fun hasAI(): Boolean = player.hasAI()

    override fun attack(target: Entity) = player.attack(target)

    override fun swingMainHand() = player.swingMainHand()

    override fun swingOffHand() = player.swingOffHand()

    override fun playHurtAnimation(yaw: Float) = player.playHurtAnimation(yaw)

    override fun setCollidable(collidable: Boolean) = player.setCollidable(collidable)

    override fun isCollidable(): Boolean = player.isCollidable

    override fun getCollidableExemptions(): Set<UUID?> = player.collidableExemptions

    override fun <T : Any?> getMemory(memoryKey: MemoryKey<T?>): T? = player.getMemory(memoryKey)

    override fun <T : Any?> setMemory(memoryKey: MemoryKey<T?>, memoryValue: T?) = player.setMemory(memoryKey, memoryValue)

    override fun getHurtSound(): Sound? = player.hurtSound

    override fun getDeathSound(): Sound? = player.deathSound

    override fun getFallDamageSound(fallHeight: Int): Sound = player.getFallDamageSound(fallHeight)

    override fun getFallDamageSoundSmall(): Sound = player.fallDamageSoundSmall

    override fun getFallDamageSoundBig(): Sound = player.fallDamageSoundBig

    override fun getDrinkingSound(itemStack: ItemStack): Sound = player.getDrinkingSound(itemStack)

    override fun getEatingSound(itemStack: ItemStack): Sound = player.getEatingSound(itemStack)

    override fun canBreatheUnderwater(): Boolean = player.canBreatheUnderwater()

    override fun getCategory(): EntityCategory = player.category

    override fun setInvisible(invisible: Boolean) = player.setInvisible(invisible)

    override fun isInvisible(): Boolean = player.isInvisible

    override fun getAttribute(attribute: Attribute): AttributeInstance? = player.getAttribute(attribute)

    override fun damage(amount: Double) = player.damage(amount)

    override fun damage(amount: Double, source: Entity?) = player.damage(amount, source)

    override fun damage(amount: Double, damageSource: DamageSource) = player.damage(amount, damageSource)

    override fun getHealth(): Double = player.health

    override fun setHealth(health: Double) = player.setHealth(health)

    override fun getAbsorptionAmount(): Double = player.absorptionAmount

    override fun setAbsorptionAmount(amount: Double) = player.setAbsorptionAmount(amount)

    override fun getMaxHealth(): Double = player.maxHealth

    override fun setMaxHealth(health: Double) = player.setMaxHealth(health)

    override fun resetMaxHealth() = player.resetMaxHealth()

    override fun setMetadata(metadataKey: String, newMetadataValue: MetadataValue) = player.setMetadata(metadataKey, newMetadataValue)

    override fun getMetadata(metadataKey: String): List<MetadataValue?> = player.getMetadata(metadataKey)

    override fun hasMetadata(metadataKey: String): Boolean = player.hasMetadata(metadataKey)

    override fun removeMetadata(metadataKey: String, owningPlugin: Plugin) = player.removeMetadata(metadataKey, owningPlugin)

    override fun sendMessage(message: String) = player.sendMessage(message)

    override fun sendMessage(vararg messages: String?) = player.sendMessage(*messages)

    override fun sendMessage(sender: UUID?, message: String) = player.sendMessage(sender, message)

    override fun sendMessage(sender: UUID?, vararg messages: String?) = player.sendMessage(sender, *messages)

    override fun isPermissionSet(name: String): Boolean = player.isPermissionSet(name)

    override fun isPermissionSet(perm: Permission): Boolean = player.isPermissionSet(perm)

    override fun hasPermission(name: String): Boolean = player.hasPermission(name)

    override fun hasPermission(perm: Permission): Boolean = player.hasPermission(perm)

    override fun addAttachment(
        plugin: Plugin,
        name: String,
        value: Boolean
    ): PermissionAttachment = player.addAttachment(plugin, name, value)

    override fun addAttachment(plugin: Plugin): PermissionAttachment = player.addAttachment(plugin)

    override fun addAttachment(
        plugin: Plugin,
        name: String,
        value: Boolean,
        ticks: Int
    ): PermissionAttachment? = player.addAttachment(plugin, name, value, ticks)

    override fun addAttachment(
        plugin: Plugin,
        ticks: Int
    ): PermissionAttachment? = player.addAttachment(plugin, ticks)

    override fun removeAttachment(attachment: PermissionAttachment) = player.removeAttachment(attachment)

    override fun recalculatePermissions() = player.recalculatePermissions()

    override fun getEffectivePermissions(): Set<PermissionAttachmentInfo?> = player.effectivePermissions

    override fun isOp(): Boolean = player.isOp

    override fun setOp(value: Boolean) = player.setOp(value)

    override fun getCustomName(): String? = player.customName

    override fun setCustomName(name: String?) = player.setCustomName(name)

    override fun getPersistentDataContainer(): PersistentDataContainer = player.persistentDataContainer

    override fun <T : Projectile?> launchProjectile(projectile: Class<out T?>): T & Any = player.launchProjectile(projectile)

    override fun <T : Projectile?> launchProjectile(
        projectile: Class<out T?>,
        velocity: Vector?
    ): T & Any = player.launchProjectile(projectile, velocity)

    override fun serialize(): Map<String?, Any?> = player.serialize()

    override fun sendPluginMessage(
        source: Plugin,
        channel: String,
        message: ByteArray
    ) = player.sendPluginMessage(source, channel, message)

    override fun getListeningPluginChannels(): Set<String?> = player.listeningPluginChannels


}