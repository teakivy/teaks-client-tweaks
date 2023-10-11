package me.teakivy.teaksclienttweaks.mixin;

import me.teakivy.teaksclienttweaks.tweaks.zoom.Zoom;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.GameRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Environment(EnvType.CLIENT)
@Mixin(GameRenderer.class)
public class ZoomMixin {

    private boolean wasSmoothCameraEnabled = Zoom.getSmoothCamera();
    private boolean zooming = false;

    @Inject(method = "getFov(Lnet/minecraft/client/render/Camera;FZ)D", at = @At("RETURN"), cancellable = true)
    public void getZoomLevel(CallbackInfoReturnable<Double> callbackInfo) {
        if(Zoom.isZooming()) {
            if (!zooming) {
                wasSmoothCameraEnabled = Zoom.getSmoothCamera();
            }
            zooming = true;

            double fov = callbackInfo.getReturnValue();
            callbackInfo.setReturnValue(fov * Zoom.getZoom());

            Zoom.setSmoothCamera(true);

        } else {
            if (zooming) {
                zooming = false;
                Zoom.setSmoothCamera(wasSmoothCameraEnabled);
            }
        }
    }
}
