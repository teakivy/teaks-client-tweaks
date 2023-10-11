package me.teakivy.teaksclienttweaks.tweaks.zoom;

import me.teakivy.teaksclienttweaks.config.Config;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;

public class Zoom {
    private static KeyBinding keyBinding;
    private static MinecraftClient client = MinecraftClient.getInstance();

    public static void init() {
        keyBinding = KeyBindingHelper.registerKeyBinding(
                new KeyBinding(
                        "key.teaksclienttweaks.zoom",
                        InputUtil.Type.KEYSYM,
                        GLFW.GLFW_KEY_C,
                        "category.teaksclienttweaks.keybinds"
                )
        );
    }

    public static boolean isZooming() {
        if (!Config.Zoom.isEnabled()) return false;
        return keyBinding.isPressed();
    }

    public static boolean getSmoothCamera() {
        return client.options.smoothCameraEnabled;
    }

    public static void setSmoothCamera(boolean enabled) {
        if (!Config.Zoom.isSmoothCamera()) return;
        client.options.smoothCameraEnabled = enabled;
    }

    public static double getZoom() {
        return (double) (101 - Config.Zoom.getPercent()) / 100;
    }
}
