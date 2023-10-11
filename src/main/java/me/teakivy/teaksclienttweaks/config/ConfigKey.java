package me.teakivy.teaksclienttweaks.config;

import me.shedaniel.autoconfig.AutoConfig;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;

public class ConfigKey {
    public static void init() {
        KeyBinding configKeyBind = KeyBindingHelper.registerKeyBinding(
                new KeyBinding(
                        "key.teaksclienttweaks.openConfig",
                        InputUtil.Type.KEYSYM,
                        GLFW.GLFW_KEY_F7,
                        "category.teaksclienttweaks.keybinds"
                )
        );

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            while (configKeyBind.wasPressed()) {
                Screen screen = AutoConfig.getConfigScreen(Config.class, client.currentScreen).get();
                client.setScreen(screen);
            }
        });
    }
}
