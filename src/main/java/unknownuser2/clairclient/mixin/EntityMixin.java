package unknownuser2.clairclient.mixin;

import net.minecraft.entity.Entity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import unknownuser2.clairclient.ClairClient;
import unknownuser2.clairclient.module.modules.RobotMovement;

@Mixin(Entity.class)
public class EntityMixin {
    @ModifyVariable(method = "setPos(DDD)V", at = @At("HEAD"), ordinal = 0)
    private double fixX(double x) {
        return (ClairClient.MODULE_LIST.getModule(RobotMovement.class).isEnabled()) ? Math.round(x * 100.0) / 100.0 : x;
    }

    @ModifyVariable(method = "setPos(DDD)V", at = @At("HEAD"), ordinal = 2)
    private double fixZ(double z) {
        return (ClairClient.MODULE_LIST.getModule(RobotMovement.class).isEnabled()) ? Math.round(z * 100.0) / 100.0 : z;
    }
}
