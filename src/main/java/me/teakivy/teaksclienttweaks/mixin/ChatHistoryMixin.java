package me.teakivy.teaksclienttweaks.mixin;

import me.teakivy.teaksclienttweaks.config.Config;
import net.minecraft.client.gui.hud.ChatHud;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(ChatHud.class)
public class ChatHistoryMixin {
    @ModifyConstant(method = "addMessage(Lnet/minecraft/text/Text;Lnet/minecraft/network/message/MessageSignatureData;ILnet/minecraft/client/gui/hud/MessageIndicator;Z)V", constant = @Constant(intValue = 100))
    public int changeMaxChatHistory(int original) {
        if (!Config.ChatTweaks.isEnabled()) return original;
        return Config.ChatTweaks.getHistoryLength();
    }
}