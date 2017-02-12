package com.masahirosaito.spigot.anticreeper

import com.masahirosaito.spigot.mscore.utils.register
import org.bukkit.entity.EntityType
import org.bukkit.event.EventHandler
import org.bukkit.event.EventPriority
import org.bukkit.event.Listener
import org.bukkit.event.entity.EntityExplodeEvent
import org.bukkit.plugin.java.JavaPlugin

class AntiCreeper : JavaPlugin(), Listener {

    override fun onEnable() {
        register(this)
    }

    override fun onDisable() {

    }

    @EventHandler(priority = EventPriority.MONITOR)
    fun onEntityExplode(event: EntityExplodeEvent) {
        if (event.isCancelled) return
        if (event.entityType == EntityType.PRIMED_TNT) return
        if (event.entityType == EntityType.MINECART_TNT) return

        event.blockList().clear()
    }
}
