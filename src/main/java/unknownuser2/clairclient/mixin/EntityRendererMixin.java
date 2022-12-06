package unknownuser2.clairclient.mixin;

import net.minecraft.client.render.entity.EntityRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import unknownuser2.clairclient.ClairClient;
import unknownuser2.clairclient.module.modules.FullBright;

@Mixin(EntityRenderer.class)
public class EntityRendererMixin {
    @Inject(method = "getSkyLight", at = @At("RETURN"), cancellable = true)
    private void onGetSkyLight(CallbackInfoReturnable<Integer> info) {
        info.setReturnValue(ClairClient.MODULE_LIST.getModule(FullBright.class).isEnabled() ? 15 : info.getReturnValueI());
    }
}
