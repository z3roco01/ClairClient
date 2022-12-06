package unknownuser2.clairclient.mixin;

import net.minecraft.client.gui.hud.PlayerListHud;
import net.minecraft.client.network.PlayerListEntry;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.Text;
import unknownuser2.clairclient.ClairClient;
import unknownuser2.clairclient.module.modules.ImprovedTab;
import unknownuser2.clairclient.utils.Utils;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PlayerListHud.class)
public class PlayerListHudMixin {
    @Inject(method = "getPlayerName", at = @At("HEAD"), cancellable = true)
    public void getPlayerName(PlayerListEntry entry, CallbackInfoReturnable<Text> info) {
        if(ClairClient.MODULE_LIST.getModule(ImprovedTab.class).isEnabled()){
//            info.setReturnValue(Text.of(entry.getProfile().getName() + " " + entry.getHealth() + "♡"));
            String gm = "UNK";
            switch(entry.getGameMode()){
            case SURVIVAL:
                gm = "SRV";
                break;
            case CREATIVE:
                gm = "CRV";
                break;
            case ADVENTURE:
                gm = "ADV";
                break;
            case SPECTATOR:
                gm = "SPC";
                break;
            }

            info.setReturnValue(Text.of(entry.getProfile().getName() + " [" + gm + "]"));
        }
    }

    @ModifyArg(method = "render", at = @At(value = "INVOKE", target = "Ljava/lang/Math;min(II)I", ordinal = 1), index = 0)
    private int modifyWidth(int width) {
        if(ClairClient.MODULE_LIST.getModule(ImprovedTab.class).isEnabled())
            return width+50;
        else
            return width;
    }

   @Inject(method = "renderLatencyIcon", at = @At("HEAD"), cancellable = true)
    private void renderLatencyIcon(MatrixStack matrices, int width, int x, int y, PlayerListEntry entry, CallbackInfo info) {
       if(ClairClient.MODULE_LIST.getModule(ImprovedTab.class).isEnabled()){
            MinecraftClient mc = MinecraftClient.getInstance();
            TextRenderer tr = mc.textRenderer;

            String text = Utils.clamp(entry.getLatency(), 0, 99999) + "ms";

            tr.drawWithShadow(matrices, text, (float) x + width - tr.getWidth(text), (float) y, 0xFFFFFFFF);

            info.cancel();
       }
   }
}
