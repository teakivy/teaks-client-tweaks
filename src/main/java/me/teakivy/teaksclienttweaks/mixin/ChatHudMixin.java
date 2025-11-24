package me.teakivy.teaksclienttweaks.mixin;

import me.teakivy.teaksclienttweaks.accessor.ChatHudAccessor;
import net.minecraft.client.gui.hud.ChatHud;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(ChatHud.class)
public class ChatHudMixin implements ChatHudAccessor {

    @Shadow @Final @Mutable
    private static int MAX_MESSAGES;

    @Override
    public void teaksclienttweaks$setMaxMessages(int value) {
        MAX_MESSAGES = value;
    }
}