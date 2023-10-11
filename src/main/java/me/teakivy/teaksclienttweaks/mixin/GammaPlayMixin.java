package me.teakivy.teaksclienttweaks.mixin;

import me.teakivy.teaksclienttweaks.config.Config;
import me.teakivy.teaksclienttweaks.tweaks.gamma.Gamma;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.network.packet.s2c.play.PlayerAbilitiesS2CPacket;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ClientPlayNetworkHandler.class)
public class GammaPlayMixin {

    @Inject(method = "onPlayerAbilities", at = @At("TAIL"))
    private void onPlayerAbilities(PlayerAbilitiesS2CPacket packet, CallbackInfo info) {
        updateGamma();
    }

    @Unique
    private void updateGamma() {
        MinecraftClient client = MinecraftClient.getInstance();
        if (client.player == null) return;
        if (!Config.Gamma.isEnabled()) return;
        if (Gamma.getGamma() > 1) return;

        Config.Gamma.setOldPercent(Gamma.getGamma());
    }
}
