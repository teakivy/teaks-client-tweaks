package me.teakivy.teaksclienttweaks.mixin;

import me.teakivy.teaksclienttweaks.config.Config;
import net.minecraft.entity.player.PlayerInventory;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerInventory.class)
public class StopHotbarScrollLoopingMixin {
    @Shadow
    public int selectedSlot;
    @Final
    @Shadow
    private static int HOTBAR_SIZE;

    @Inject(method = "scrollInHotbar", at = @At("HEAD"), cancellable = true)
    public void scrollInHotbar(double scrollAmount, CallbackInfo ci) {
        if (!Config.StopHotbarScrollLooping.isEnabled()) return;

        int slot = selectedSlot - (int) Math.signum(scrollAmount);

        if (slot >= HOTBAR_SIZE && !Config.StopHotbarScrollLooping.isLoopOnRight()) {
            ci.cancel();
            return;
        }

        if (slot < 0 && !Config.StopHotbarScrollLooping.isLoopOnLeft()) {
            ci.cancel();
        }
    }
}
