package me.teakivy.teaksclienttweaks.mixin;

import me.teakivy.teaksclienttweaks.config.Config;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(InGameHud.class)
public class NoPumpkinBlurMixin {

    @Inject(method = "renderOverlay", at = @At("HEAD"), cancellable = true)
    public void removePumpkinBlur(DrawContext context, Identifier texture, float opacity, CallbackInfo ci) {
        if (!Config.NoPumpkinBlur.isEnabled()) return;
        if (texture.toString().contains("pumpkin")) ci.cancel();
    }
}
