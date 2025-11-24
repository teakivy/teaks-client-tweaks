package me.teakivy.teaksclienttweaks.mixin;

import me.teakivy.teaksclienttweaks.config.Config;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.item.HeldItemRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.*;
import net.minecraft.util.Hand;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(HeldItemRenderer.class)
public class ShieldHiderMixin {

    @Inject(method = "renderFirstPersonItem(Lnet/minecraft/client/network/AbstractClientPlayerEntity;FFLnet/minecraft/util/Hand;FLnet/minecraft/item/ItemStack;FLnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;I)V", at = @At("HEAD"), cancellable = true)
    public void renderItem(AbstractClientPlayerEntity player, float tickDelta, float pitch, Hand hand, float swingProgress, ItemStack item, float equipProgress, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, CallbackInfo ci) {
        if (!Config.ShieldHider.isEnabled()) return;
        if (player == null) return;

        if (Config.ShieldHider.isShownWhileBlocking()) {
            if (player.getActiveItem() == null) return;
            if (player.getActiveItem().getItem() instanceof ShieldItem) return;
        }

        if (Config.ShieldHider.isShownWithWeapon()) {
            Item otherHand = player.getStackInHand(hand == Hand.MAIN_HAND ? Hand.OFF_HAND : Hand.MAIN_HAND).getItem();

            if (otherHand instanceof SwordItem || otherHand instanceof AxeItem) return;
        }

        if (!(item.getItem() instanceof ShieldItem)) return;

        if (hand.equals(Hand.MAIN_HAND) && !Config.ShieldHider.isHiddenInMainHand()) return;
        if (hand.equals(Hand.OFF_HAND) && !Config.ShieldHider.isHiddenInOffHand()) return;

        ci.cancel();
    }
}