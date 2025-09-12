package dev.httpmarco.polocube.entities

import org.bukkit.EntityEffect
import org.bukkit.Location
import org.bukkit.Server
import org.bukkit.Sound
import org.bukkit.World
import org.bukkit.block.BlockFace
import org.bukkit.block.PistonMoveReaction
import org.bukkit.entity.Entity
import org.bukkit.entity.EntitySnapshot
import org.bukkit.entity.EntityType
import org.bukkit.entity.Player
import org.bukkit.entity.Pose
import org.bukkit.entity.SpawnCategory
import org.bukkit.event.entity.EntityDamageEvent
import org.bukkit.event.player.PlayerTeleportEvent
import org.bukkit.metadata.MetadataValue
import org.bukkit.permissions.Permission
import org.bukkit.permissions.PermissionAttachment
import org.bukkit.permissions.PermissionAttachmentInfo
import org.bukkit.persistence.PersistentDataContainer
import org.bukkit.plugin.Plugin
import org.bukkit.util.BoundingBox
import org.bukkit.util.Vector
import java.util.UUID

@Suppress("DEPRECATION", "removal")
abstract class CubeEntityPaperWrapper(val wrapperEntity: Entity) : Entity {

    override fun getLocation(): Location = wrapperEntity.location
    override fun getLocation(loc: Location?): Location? = wrapperEntity.getLocation(loc)
    override fun setVelocity(velocity: Vector) = wrapperEntity.setVelocity(velocity)
    override fun getVelocity(): Vector = wrapperEntity.velocity
    override fun getHeight(): Double = wrapperEntity.height
    override fun getWidth(): Double = wrapperEntity.width
    override fun getBoundingBox(): BoundingBox = wrapperEntity.boundingBox
    override fun isOnGround(): Boolean = wrapperEntity.isOnGround
    override fun isInWater(): Boolean = wrapperEntity.isInWater
    override fun getWorld(): World = wrapperEntity.world
    override fun setRotation(yaw: Float, pitch: Float) = wrapperEntity.setRotation(yaw, pitch)
    override fun teleport(location: Location): Boolean = wrapperEntity.teleport(location)
    override fun teleport(location: Location, cause: PlayerTeleportEvent.TeleportCause): Boolean = wrapperEntity.teleport(location, cause)
    override fun teleport(destination: Entity): Boolean = wrapperEntity.teleport(destination)
    override fun teleport(destination: Entity, cause: PlayerTeleportEvent.TeleportCause): Boolean = wrapperEntity.teleport(destination, cause)
    override fun getNearbyEntities(x: Double, y: Double, z: Double): List<Entity?> = wrapperEntity.getNearbyEntities(x, y, z)
    override fun getEntityId(): Int = wrapperEntity.entityId
    override fun getFireTicks(): Int = wrapperEntity.fireTicks
    override fun getMaxFireTicks(): Int = wrapperEntity.maxFireTicks
    override fun setFireTicks(ticks: Int) = wrapperEntity.setFireTicks(ticks)
    override fun setVisualFire(fire: Boolean) = wrapperEntity.setVisualFire(fire)
    override fun isVisualFire(): Boolean = wrapperEntity.isVisualFire
    override fun getFreezeTicks(): Int = wrapperEntity.freezeTicks
    override fun getMaxFreezeTicks(): Int = wrapperEntity.maxFreezeTicks
    override fun setFreezeTicks(ticks: Int) = wrapperEntity.setFreezeTicks(ticks)
    override fun isFrozen(): Boolean = wrapperEntity.isFrozen
    override fun remove() = wrapperEntity.remove()
    override fun isDead(): Boolean = wrapperEntity.isDead
    override fun isValid(): Boolean = wrapperEntity.isValid
    override fun getServer(): Server = wrapperEntity.server
    override fun isPersistent(): Boolean = wrapperEntity.isPersistent
    override fun setPersistent(persistent: Boolean) = wrapperEntity.setPersistent(persistent)
    override fun getPassenger(): Entity? = wrapperEntity.passenger
    override fun setPassenger(passenger: Entity): Boolean = wrapperEntity.setPassenger(passenger)
    override fun getPassengers(): List<Entity?> = wrapperEntity.passengers
    override fun addPassenger(passenger: Entity): Boolean = wrapperEntity.addPassenger(passenger)
    override fun removePassenger(passenger: Entity): Boolean = wrapperEntity.removePassenger(passenger)
    override fun isEmpty(): Boolean = wrapperEntity.isEmpty
    override fun eject(): Boolean = wrapperEntity.eject()
    override fun getFallDistance(): Float = wrapperEntity.fallDistance
    override fun setFallDistance(distance: Float) = wrapperEntity.setFallDistance(distance)
    override fun setLastDamageCause(event: EntityDamageEvent?) = wrapperEntity.setLastDamageCause(event)
    override fun getLastDamageCause(): EntityDamageEvent? = wrapperEntity.lastDamageCause
    override fun getUniqueId(): UUID = wrapperEntity.uniqueId
    override fun getTicksLived(): Int = wrapperEntity.ticksLived
    override fun setTicksLived(value: Int) = wrapperEntity.setTicksLived(value)
    override fun playEffect(type: EntityEffect) = wrapperEntity.playEffect(type)
    override fun getType(): EntityType = wrapperEntity.type
    override fun getSwimSound(): Sound = wrapperEntity.swimSound
    override fun getSwimSplashSound(): Sound = wrapperEntity.swimSplashSound
    override fun getSwimHighSpeedSplashSound(): Sound = wrapperEntity.swimHighSpeedSplashSound
    override fun isInsideVehicle(): Boolean = wrapperEntity.isInsideVehicle
    override fun leaveVehicle(): Boolean = wrapperEntity.leaveVehicle()
    override fun getVehicle(): Entity? = wrapperEntity.vehicle
    override fun setCustomNameVisible(flag: Boolean) = wrapperEntity.setCustomNameVisible(flag)
    override fun isCustomNameVisible(): Boolean = wrapperEntity.isCustomNameVisible
    override fun setVisibleByDefault(visible: Boolean) = wrapperEntity.setVisibleByDefault(visible)
    override fun isVisibleByDefault(): Boolean = wrapperEntity.isVisibleByDefault
    override fun getTrackedBy(): Set<Player?> = wrapperEntity.trackedBy
    override fun setGlowing(flag: Boolean) = wrapperEntity.setGlowing(flag)
    override fun isGlowing(): Boolean = wrapperEntity.isGlowing
    override fun setInvulnerable(flag: Boolean) = wrapperEntity.setInvulnerable(flag)
    override fun isInvulnerable(): Boolean = wrapperEntity.isInvulnerable
    override fun isSilent(): Boolean = wrapperEntity.isSilent
    override fun setSilent(flag: Boolean) = wrapperEntity.setSilent(flag)
    override fun hasGravity(): Boolean = wrapperEntity.hasGravity()
    override fun setGravity(gravity: Boolean) = wrapperEntity.setGravity(gravity)
    override fun getPortalCooldown(): Int = wrapperEntity.portalCooldown
    override fun setPortalCooldown(cooldown: Int) = wrapperEntity.setPortalCooldown(cooldown)
    override fun getScoreboardTags(): Set<String?> = wrapperEntity.scoreboardTags
    override fun addScoreboardTag(tag: String): Boolean = wrapperEntity.addScoreboardTag(tag)
    override fun removeScoreboardTag(tag: String): Boolean = wrapperEntity.removeScoreboardTag(tag)
    override fun getPistonMoveReaction(): PistonMoveReaction = wrapperEntity.pistonMoveReaction
    override fun getFacing(): BlockFace = wrapperEntity.facing
    override fun getPose(): Pose = wrapperEntity.pose
    override fun getSpawnCategory(): SpawnCategory = wrapperEntity.spawnCategory
    override fun isInWorld(): Boolean = wrapperEntity.isInWorld
    override fun getAsString(): String? = wrapperEntity.asString
    override fun createSnapshot(): EntitySnapshot? = wrapperEntity.createSnapshot()
    override fun copy(): Entity = wrapperEntity.copy()
    override fun copy(to: Location): Entity = wrapperEntity.copy(to)
    override fun spigot(): Entity.Spigot = wrapperEntity.spigot()
    override fun setMetadata(metadataKey: String, newMetadataValue: MetadataValue) = wrapperEntity.setMetadata(metadataKey, newMetadataValue)
    override fun getMetadata(metadataKey: String): List<MetadataValue?> = wrapperEntity.getMetadata(metadataKey)
    override fun hasMetadata(metadataKey: String): Boolean = wrapperEntity.hasMetadata(metadataKey)
    override fun removeMetadata(metadataKey: String, owningPlugin: Plugin) = wrapperEntity.removeMetadata(metadataKey, owningPlugin)
    override fun sendMessage(message: String) = wrapperEntity.sendMessage(message)
    override fun sendMessage(vararg messages: String?) = wrapperEntity.sendMessage(*messages)
    override fun sendMessage(sender: UUID?, message: String) = wrapperEntity.sendMessage(sender, message)
    override fun sendMessage(sender: UUID?, vararg messages: String?) = wrapperEntity.sendMessage(sender, *messages)
    override fun getName(): String = wrapperEntity.name
    override fun isPermissionSet(name: String): Boolean = wrapperEntity.isPermissionSet(name)
    override fun isPermissionSet(perm: Permission): Boolean = wrapperEntity.isPermissionSet(perm)
    override fun hasPermission(name: String): Boolean = wrapperEntity.hasPermission(name)
    override fun hasPermission(perm: Permission): Boolean = wrapperEntity.hasPermission(perm)
    override fun addAttachment(plugin: Plugin, name: String, value: Boolean): PermissionAttachment = wrapperEntity.addAttachment(plugin, name, value)
    override fun addAttachment(plugin: Plugin): PermissionAttachment = wrapperEntity.addAttachment(plugin)
    override fun addAttachment(plugin: Plugin, name: String, value: Boolean, ticks: Int): PermissionAttachment? = wrapperEntity.addAttachment(plugin, name, value, ticks)
    override fun addAttachment(plugin: Plugin, ticks: Int): PermissionAttachment? = wrapperEntity.addAttachment(plugin, ticks)
    override fun removeAttachment(attachment: PermissionAttachment) = wrapperEntity.removeAttachment(attachment)
    override fun recalculatePermissions() = wrapperEntity.recalculatePermissions()
    override fun getEffectivePermissions(): Set<PermissionAttachmentInfo?> = wrapperEntity.effectivePermissions
    override fun isOp(): Boolean = wrapperEntity.isOp
    override fun setOp(value: Boolean) = wrapperEntity.setOp(value)
    override fun getCustomName(): String? = wrapperEntity.customName
    override fun setCustomName(name: String?) = wrapperEntity.setCustomName(name)
    override fun getPersistentDataContainer(): PersistentDataContainer = wrapperEntity.persistentDataContainer
}
