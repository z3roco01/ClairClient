package unknownuser2.clairclient.module.modules;

import unknownuser2.clairclient.events.TickEvent;
import net.minecraft.network.packet.c2s.play.PlayerMoveC2SPacket;
import unknownuser2.clairclient.ClairClient;
import unknownuser2.clairclient.module.Module;

//if (mc.player.isFallFlying())
//				return;
//			mc.player.networkHandler.sendPacket(new PlayerMoveC2SPacket.OnGroundOnly(true));
public class NoFall extends Module implements TickEvent {
    public NoFall() {
        super("No Fall", "Makes you take no damage when you fall.", "nfall");
        ClairClient.TICK_EVENTS.register(this);
    }

    @Override
    public void onTick() {
        if(ClairClient.mc.player == null)
            return;
        if(ClairClient.MODULE_LIST.getModule(NoFall.class).isEnabled() && !ClairClient.mc.player.isFallFlying())
            ClairClient.mc.player.networkHandler.sendPacket(new PlayerMoveC2SPacket.OnGroundOnly(true));
    }
}
