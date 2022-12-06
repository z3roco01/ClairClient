package unknownuser2.clairclient.mixin;

import net.minecraft.client.MinecraftClient;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import unknownuser2.clairclient.ClairClient;

@Mixin(MinecraftClient.class)
public class MinecraftClientMixin {
    @Inject(method = "getWindowTitle", at = @At(value = "RETURN"), cancellable = true)
    private void getWidnowTitle(CallbackInfoReturnable<String> ci) {
        ci.setReturnValue(ClairClient.MODID + " " + ClairClient.VERSION);
    }
}
