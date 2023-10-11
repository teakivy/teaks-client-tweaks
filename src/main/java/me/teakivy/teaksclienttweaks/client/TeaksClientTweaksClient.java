package me.teakivy.teaksclienttweaks.client;

import me.teakivy.teaksclienttweaks.config.ConfigKey;
import me.teakivy.teaksclienttweaks.tweaks.chat.ChatTweaks;
import me.teakivy.teaksclienttweaks.tweaks.coordshud.CoordsHud;
import me.teakivy.teaksclienttweaks.tweaks.gamma.Gamma;
import me.teakivy.teaksclienttweaks.tweaks.nodarkness.NoDarkness;
import me.teakivy.teaksclienttweaks.tweaks.zoom.Zoom;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
public class TeaksClientTweaksClient implements ClientModInitializer {
    public static final String MOD_ID = "teaksclienttweaks";
    public static final String NAME = "Teak's Client Tweaks";
    /**
     * Runs the mod initializer on the client environment.
     */
    @Override
    public void onInitializeClient() {
        Gamma.init();
        Zoom.init();
        ChatTweaks.init();
        NoDarkness.init();
        CoordsHud.init();

        ConfigKey.init();
    }
}
