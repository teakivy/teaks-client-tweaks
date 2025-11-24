package me.teakivy.teaksclienttweaks.mixin;

import net.minecraft.client.MinecraftClient;
import net.minecraft.registry.RegistryKey;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ServerPlayerEntity.class)
public class NoHardcoreSpawnpointMessageMixin {

//    @ModifyArg(method = "setSpawnPoint")

//    @ModifyArg(method = "setSpawnPoint", at = @At(value = "INVOKE", target = "Lnet/minecraft/server/network/ServerPlayerEntity;setSpawnPoint(Lnet/minecraft/util/registry/RegistryKey;Lnet/minecraft/util/math/BlockPos;FZZ)V"), index = 4)
//    public boolean setSpawnPoint(boolean sendMessage) {
////        if (!Config.NoHardcoreSpawnpointMessage.isEnabled()) return;
//
//        if (!sendMessage) return sendMessage;
//        if (MinecraftClient.getInstance().player == null) return sendMessage;
//
//        if (MinecraftClient.getInstance().player.getWorld().getLevelProperties().isHardcore()) {
//            return false;
//        }
//
//        return sendMessage;
//    }
}
