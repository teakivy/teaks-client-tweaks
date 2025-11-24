package me.teakivy.teaksclienttweaks.tweaks.chat;

import me.teakivy.teaksclienttweaks.config.Config;
import me.teakivy.teaksclienttweaks.accessor.ChatHudAccessor;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.gui.hud.ChatHud;
import net.minecraft.network.message.ChatVisibility;

public class ChatTweaks {

    private static int lastHistoryValue = -1;

    public static void init() {
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if (!Config.ChatTweaks.isEnabled()) {
                client.options.getChatVisibility().setValue(ChatVisibility.FULL);
                return;
            }

            // Chat Visibility
            if (Config.ChatTweaks.isHidden()) {
                client.options.getChatVisibility().setValue(ChatVisibility.HIDDEN);
            } else {
                client.options.getChatVisibility().setValue(ChatVisibility.FULL);
            }

            // Chat History
            int newLimit = Config.ChatTweaks.getHistoryLength();
            if (newLimit != lastHistoryValue) {
                lastHistoryValue = newLimit;

                ChatHud chatHud = client.inGameHud.getChatHud();

                ((ChatHudAccessor) chatHud).teaksclienttweaks$setMaxMessages(newLimit);

                chatHud.reset();
            }
        });
    }
}
