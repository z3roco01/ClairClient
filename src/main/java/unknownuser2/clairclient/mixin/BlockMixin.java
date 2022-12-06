package unknownuser2.clairclient.mixin;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.BlockView;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import unknownuser2.clairclient.ClairClient;
import unknownuser2.clairclient.module.modules.Xray;

@Mixin(Block.class)
public class BlockMixin {
    @Inject(method = "shouldDrawSide", at = @At("HEAD"), cancellable = true)
    private static void onShouldDrawSide(BlockState state, BlockView world, BlockPos pos, Direction side, BlockPos blockPos, CallbackInfoReturnable<Boolean> ci) {
        Xray xray = (Xray)ClairClient.MODULE_LIST.getModule(Xray.class);
        if(xray.isEnabled())
            ci.setReturnValue(xray.getBlocks().contains(state.getBlock()));
    }
}
