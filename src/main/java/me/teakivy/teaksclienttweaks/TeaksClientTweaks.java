package me.teakivy.teaksclienttweaks;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.JanksonConfigSerializer;
import me.teakivy.teaksclienttweaks.config.Config;
import net.fabricmc.api.ModInitializer;

public class TeaksClientTweaks implements ModInitializer {
    /**
     * Runs the mod initializer.
     */
    @Override
    public void onInitialize() {
        AutoConfig.register(Config.class, JanksonConfigSerializer::new);
    }
}
