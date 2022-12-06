package unknownuser2.clairclient.mixin;

import net.minecraft.client.render.LightmapTextureManager;
import net.minecraft.client.render.WorldRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import unknownuser2.clairclient.ClairClient;
import unknownuser2.clairclient.module.modules.FullBright;
import unknownuser2.clairclient.module.modules.NoWeather;

@Mixin(WorldRenderer.class)
public class WorldRendererMixin {
    @ModifyVariable(method = "getLightmapCoordinates(Lnet/minecraft/world/BlockRenderView;Lnet/minecraft/block/BlockState;Lnet/minecraft/util/math/BlockPos;)I", at = @At(value = "STORE"), ordinal = 0)
    private static int getLightmapCoordinatesModifySkyLight(int sky) {
        return ClairClient.MODULE_LIST.getModule(FullBright.class).isEnabled() ? 15 : sky;
    }

    @Inject(method = "renderWeather", at = @At("HEAD"), cancellable = true)
    private void renderWeather(LightmapTextureManager manager, float tickDelta, double cameraX, double cameraY, double cameraZ, CallbackInfo info) {
        if(ClairClient.MODULE_LIST.getModule(NoWeather.class).isEnabled())
            info.cancel();
    }
}
