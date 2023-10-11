package me.teakivy.teaksclienttweaks.config;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.ConfigEntry.*;
import me.shedaniel.autoconfig.annotation.ConfigEntry.Gui.*;

@me.shedaniel.autoconfig.annotation.Config(name = "teaksclienttweaks")
@me.shedaniel.autoconfig.annotation.Config.Gui.Background(value = "minecraft:textures/block/oak_planks.png")
public class Config implements ConfigData {

    // Zoom
    @PrefixText
    @Tooltip
    boolean zoomEnabled = true;
    @Tooltip
    boolean zoomSmoothCamera = true;
    @Tooltip
    @BoundedDiscrete(min = 1, max = 100)
    int zoomPercent = 70;


    // Gamma
    @PrefixText
    @Tooltip
    boolean gammaEnabled = true;
    @Tooltip
    @BoundedDiscrete(min = 1, max = 1200)
    int gammaPercent = 1200;

    @Excluded
    double oldGammaPercent = 0.5;

    @Excluded
    boolean gammaActuallyEnabled = false;


    // Chat
    @PrefixText
    @Tooltip
    boolean chatEnabled = true;

    @Tooltip
    boolean chatHidden = false;

    @Tooltip
    @BoundedDiscrete(min = 1, max = 1000)
    int chatHistoryLength = 100;

    @PrefixText
    @Tooltip
    boolean shieldHiderEnabled = true;

    @Tooltip
    boolean shieldHiderHideInMainHand = false;

    @Tooltip
    boolean shieldHiderHideInOffHand = true;

    @Tooltip
    boolean shieldHiderShowWhileBlocking = true;

    @Tooltip
    boolean shieldHiderShowWithWeapon = true;

    @PrefixText
    @Tooltip
    boolean totemHiderEnabled = true;

    @Tooltip
    boolean totemHiderHideInMainHand = false;

    @Tooltip
    boolean totemHiderHideInOffHand = true;

    @PrefixText
    @Tooltip
    boolean coordsHudEnabled = true;

    @PrefixText
    @Tooltip
    boolean stopHotbarScrollLoopingEnabled = true;

    @Tooltip
    boolean stopHotbarScrollLoopingLoopOnRight = false;

    @Tooltip
    boolean stopHotbarScrollLoopingLoopOnLeft = false;

    @PrefixText
    @Tooltip
    boolean noFogEnabled = true;

    @PrefixText
    @Tooltip
    boolean noDarknessEnabled = true;

    @PrefixText
    @Tooltip
    boolean noPumpkinBlurEnabled = true;


    public static class Zoom {
        public static boolean isEnabled() {
            return AutoConfig.getConfigHolder(Config.class).getConfig().zoomEnabled;
        }

        public static boolean isSmoothCamera() {
            return AutoConfig.getConfigHolder(Config.class).getConfig().zoomSmoothCamera;
        }

        public static int getPercent() {
            int percent = AutoConfig.getConfigHolder(Config.class).getConfig().zoomPercent;
            percent = Math.max(percent, 2);

            return percent;
        }
    }

    public static class Gamma {

        public static boolean isEnabled() {
            return AutoConfig.getConfigHolder(Config.class).getConfig().gammaEnabled;
        }

        public static double getPercent() {
            return AutoConfig.getConfigHolder(Config.class).getConfig().gammaPercent / 100.0;
        }

        public static double getOldPercent() {
            return AutoConfig.getConfigHolder(Config.class).getConfig().oldGammaPercent;
        }

        public static void setOldPercent(double percent) {
            AutoConfig.getConfigHolder(Config.class).getConfig().oldGammaPercent = percent;
        }

        public static boolean isActuallyEnabled() {
            return AutoConfig.getConfigHolder(Config.class).getConfig().gammaActuallyEnabled;
        }

        public static void setActuallyEnabled(boolean enabled) {
            AutoConfig.getConfigHolder(Config.class).getConfig().gammaActuallyEnabled = enabled;
        }
    }

    public static class ChatTweaks {
        public static boolean isEnabled() {
            return AutoConfig.getConfigHolder(Config.class).getConfig().chatEnabled;
        }

        public static int getHistoryLength() {
            return AutoConfig.getConfigHolder(Config.class).getConfig().chatHistoryLength;
        }

        public static boolean isHidden() {
            return AutoConfig.getConfigHolder(Config.class).getConfig().chatHidden;
        }
    }

    public static class ShieldHider {
        public static boolean isEnabled() {
            return AutoConfig.getConfigHolder(Config.class).getConfig().shieldHiderEnabled;
        }

        public static boolean isHiddenInMainHand() {
            return AutoConfig.getConfigHolder(Config.class).getConfig().shieldHiderHideInMainHand;
        }

        public static boolean isHiddenInOffHand() {
            return AutoConfig.getConfigHolder(Config.class).getConfig().shieldHiderHideInOffHand;
        }

        public static boolean isShownWhileBlocking() {
            return AutoConfig.getConfigHolder(Config.class).getConfig().shieldHiderShowWhileBlocking;
        }

        public static boolean isShownWithWeapon() {
            return AutoConfig.getConfigHolder(Config.class).getConfig().shieldHiderShowWithWeapon;
        }
    }

    public static class TotemHider {
        public static boolean isEnabled() {
            return AutoConfig.getConfigHolder(Config.class).getConfig().totemHiderEnabled;
        }

        public static boolean isHiddenInMainHand() {
            return AutoConfig.getConfigHolder(Config.class).getConfig().totemHiderHideInMainHand;
        }

        public static boolean isHiddenInOffHand() {
            return AutoConfig.getConfigHolder(Config.class).getConfig().totemHiderHideInOffHand;
        }
    }

    public static class CoordsHud {
        public static boolean isEnabled() {
            return AutoConfig.getConfigHolder(Config.class).getConfig().coordsHudEnabled;
        }
    }

    public static class StopHotbarScrollLooping {
        public static boolean isEnabled() {
            return AutoConfig.getConfigHolder(Config.class).getConfig().stopHotbarScrollLoopingEnabled;
        }

        public static boolean isLoopOnRight() {
            return AutoConfig.getConfigHolder(Config.class).getConfig().stopHotbarScrollLoopingLoopOnRight;
        }

        public static boolean isLoopOnLeft() {
            return AutoConfig.getConfigHolder(Config.class).getConfig().stopHotbarScrollLoopingLoopOnLeft;
        }
    }

    public static class NoFog {
        public static boolean isEnabled() {
            return AutoConfig.getConfigHolder(Config.class).getConfig().noFogEnabled;
        }
    }

    public static class NoDarkness {
        public static boolean isEnabled() {
            return AutoConfig.getConfigHolder(Config.class).getConfig().noDarknessEnabled;
        }
    }

    public static class NoPumpkinBlur {
        public static boolean isEnabled() {
            return AutoConfig.getConfigHolder(Config.class).getConfig().noPumpkinBlurEnabled;
        }
    }
}