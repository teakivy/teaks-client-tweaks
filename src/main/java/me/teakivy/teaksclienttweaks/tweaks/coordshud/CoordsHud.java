package me.teakivy.teaksclienttweaks.tweaks.coordshud;

import me.teakivy.teaksclienttweaks.config.Config;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import org.lwjgl.glfw.GLFW;

public class CoordsHud {
    public static void init() {

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if (!Config.CoordsHud.isEnabled()) return;
            if (client.player == null) return;
            ClientPlayerEntity player = client.player;
            if (client.inGameHud == null) return;
            String hudDisplay = "§6XYZ: §r" +
                player.getBlockPos().getX() + " " +
                player.getBlockPos().getY() + " " +
                player.getBlockPos().getZ() + "§6   " +
                getDirectionAbbr(player.getYaw()) + "   " +
                getWorldTime(player.getWorld());

            client.inGameHud.setOverlayMessage(Text.of(hudDisplay), false);
        });
    }

    public static String getWorldTime(World world) {
        long ticks = world.getTimeOfDay();
        int hours = (int) (((ticks / 1000) + 6) % 24);
        int minutes = (int) ((ticks % 1000 / 10) * 0.6);
        return String.format("%02d:%02d", hours, minutes);
    }



    public static String get2PointDirectionAbbr(float direction) {
        if (direction <= -157.5 || direction >= 157.5) return "N";
        if (direction >= 112.5 && direction <= 157.5) return "NW";
        if (direction >= 67.5 && direction <= 112.5) return "W";
        if (direction >= 22.5 && direction <= 67.5) return "SW";
        if (direction >= -22.5 && direction <= 22.5) return "S";
        if (direction >= -67.5 && direction <= -22.5) return "SE";
        if (direction >= -112.5 && direction <= -67.5) return "E";
        if (direction >= -157.5 && direction <= -112.5) return "NE";

        return "N/A";
    }



    public static String getDirectionAbbr(float direction) {
        return get2PointDirectionAbbr(direction).substring(0, 1);
    }
}
