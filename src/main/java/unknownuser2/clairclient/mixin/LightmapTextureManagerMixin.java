package unknownuser2.clairclient.mixin;

import net.minecraft.client.render.LightmapTextureManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArgs;
import org.spongepowered.asm.mixin.injection.invoke.arg.Args;
import unknownuser2.clairclient.ClairClient;
import unknownuser2.clairclient.module.modules.FullBright;
import unknownuser2.clairclient.module.modules.Xray;

@Mixin(LightmapTextureManager.class)
public class LightmapTextureManagerMixin {
    @ModifyArgs(method = "update", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/texture/NativeImage;setColor(III)V"))
    private void onUpdate(Args args) {
        if(ClairClient.MODULE_LIST.getModule(FullBright.class).isEnabled() || ClairClient.MODULE_LIST.getModule(Xray.class).isEnabled())
            args.set(2, 0xFFFFFFFF);
    }
}
