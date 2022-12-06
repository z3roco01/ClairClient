package unknownuser2.clairclient.mixin;

import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import unknownuser2.clairclient.ClairClient;
import unknownuser2.clairclient.command.Command;

import javax.annotation.Nullable;
import java.util.Arrays;

@Mixin(ClientPlayerEntity.class)
public class ClientPlayerEntityMixin {
    @Inject(method = "sendChatMessage(Ljava/lang/String;Lnet/minecraft/text/Text;)V", at = @At("HEAD"), cancellable = true)
    private void sendChatMessage(String message, Text preview, CallbackInfo info) {
        if(message.startsWith(".")){
            String[] cmd = message.substring(1).split(" ");

            Command command = ClairClient.COMMAND_LIST.getCommand(cmd[0]);
            if(command != null) {
                command.doCommand(Arrays.copyOfRange(cmd, 1, cmd.length));
            }

            info.cancel();
        }
    }
}
