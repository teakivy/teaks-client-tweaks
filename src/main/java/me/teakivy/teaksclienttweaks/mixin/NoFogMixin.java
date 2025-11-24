package me.teakivy.teaksclienttweaks.mixin;


import com.mojang.blaze3d.systems.RenderSystem;
import me.teakivy.teaksclienttweaks.config.Config;
import net.minecraft.block.enums.CameraSubmersionType;
import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.client.render.BackgroundRenderer;
import net.minecraft.client.render.Camera;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffects;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = BackgroundRenderer.class, priority = 910)
public class NoFogMixin {
    @Inject(method = "applyFog", at = @At("RETURN"))
    private static void applyNoFog(Camera camera, BackgroundRenderer.FogType fogType, float viewDistance, boolean thickFog, float tickDelta, CallbackInfo info) {
        if (!Config.NoFog.isEnabled()) return;

        if (!camera.getSubmersionType().equals(CameraSubmersionType.NONE)) return;

        Entity entity = camera.getFocusedEntity();
        if (!(entity instanceof LivingEntity livingEntity)) return;

        if (livingEntity.isSubmergedInWater()) return;
        if (livingEntity.isInsideWaterOrBubbleColumn()) return;
        if (livingEntity.isInLava()) return;
        if (livingEntity.hasStatusEffect(StatusEffects.BLINDNESS)) return;
        if (livingEntity.hasStatusEffect(StatusEffects.DARKNESS)) return;



        RenderSystem.setShaderFogStart(-8f);
        RenderSystem.setShaderFogEnd(1000000f);
    }
}
