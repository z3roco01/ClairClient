package unknownuser2.clairclient.mixin;

import net.minecraft.block.BlockState;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.RenderLayers;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import unknownuser2.clairclient.ClairClient;
import unknownuser2.clairclient.module.modules.Xray;

@Mixin(RenderLayers.class)
public class RenderLayersMixin {
    @Inject(method = "getBlockLayer", at = @At("HEAD"), cancellable = true)
    private static void onGetBlockLayer(BlockState state, CallbackInfoReturnable<RenderLayer> ci) {
        if(ClairClient.MODULE_LIST.getModule(Xray.class).isEnabled())
            ci.setReturnValue(RenderLayer.getTranslucent());
    }
}
