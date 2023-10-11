package me.teakivy.teaksclienttweaks.tweaks.chat;

import me.teakivy.teaksclienttweaks.config.Config;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.option.ChatVisibility;

public class ChatTweaks {

    public static void init() {
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if (!Config.ChatTweaks.isEnabled()) {
                client.options.getChatVisibility().setValue(ChatVisibility.FULL);
                return;
            }
            if (Config.ChatTweaks.isHidden()) {
                client.options.getChatVisibility().setValue(ChatVisibility.HIDDEN);
            } else {
                client.options.getChatVisibility().setValue(ChatVisibility.FULL);
            }
        });
    }
}
