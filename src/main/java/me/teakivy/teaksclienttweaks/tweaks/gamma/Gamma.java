package me.teakivy.teaksclienttweaks.tweaks.gamma;

import me.teakivy.teaksclienttweaks.config.Config;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.text.Text;
import org.lwjgl.glfw.GLFW;

public class Gamma {
    private static KeyBinding keyBinding;
    private static MinecraftClient client = MinecraftClient.getInstance();

    public static void init() {
        keyBinding = KeyBindingHelper.registerKeyBinding(
                new KeyBinding(
                        "key.teaksclienttweaks.gamma",
                        InputUtil.Type.KEYSYM,
                        GLFW.GLFW_KEY_BACKSLASH,
                        "category.teaksclienttweaks.keybinds"
                )
        );

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            while (keyBinding.wasPressed()) {
                if (!Config.Gamma.isEnabled()) return;

                if (!Config.Gamma.isActuallyEnabled()) {
                    Config.Gamma.setOldPercent(getGamma());
                }

                Config.Gamma.setActuallyEnabled(!Config.Gamma.isActuallyEnabled());
            }

            if (Config.Gamma.getOldPercent() > 1) {
                Config.Gamma.setOldPercent(.5);
                return;
            }

            if (Config.Gamma.isEnabled() && Config.Gamma.isActuallyEnabled()) {
                setGamma(Config.Gamma.getPercent());
                return;
            }

            setGamma(Config.Gamma.getOldPercent());
        });
    }

    public static double getGamma() {
        return client.options.getGamma().getValue();
    }

    public static void setGamma(double gamma) {
        if (gamma > 1) {
            Config.Gamma.setOldPercent(client.options.getGamma().getValue());
        }
        client.options.getGamma().setValue(gamma);
    }

}
