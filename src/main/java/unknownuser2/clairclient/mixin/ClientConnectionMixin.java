package unknownuser2.clairclient.mixin;

import net.minecraft.network.ClientConnection;
import net.minecraft.network.Packet;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import unknownuser2.clairclient.ClairClient;

@Mixin(ClientConnection.class)
public class ClientConnectionMixin {
    @Inject(at = @At("TAIL"), method = "send(Lnet/minecraft/network/Packet;)V", cancellable = true)
    public void send(Packet<?> packet, CallbackInfo ci) {
        //ClairClient.LOGGER.info(packet.getClass().getName());
    }
}