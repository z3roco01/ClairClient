package unknownuser2.clairclient.utils;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.text.Text;

import static unknownuser2.clairclient.ClairClient.mc;

public class Utils {
    public static int clamp(int val, int min, int max) {
        if (val < min) return min;
        return Math.min(val, max);
    }

    public static void sendChat(String msg) {
        if(mc == null) {
            mc = MinecraftClient.getInstance();
        }
        mc.player.sendMessage(Text.of(msg));
    }
}
