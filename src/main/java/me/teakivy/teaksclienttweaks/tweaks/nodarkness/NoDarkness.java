package me.teakivy.teaksclienttweaks.tweaks.nodarkness;

import me.teakivy.teaksclienttweaks.config.Config;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.effect.StatusEffects;

public class NoDarkness {
    public static void init() {
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if (!Config.NoDarkness.isEnabled()) return;
            if (client.player == null) return;

            if (client.player.hasStatusEffect(StatusEffects.DARKNESS)) {
                client.player.removeStatusEffect(StatusEffects.DARKNESS);
            }
        });
    }
}
