package unknownuser2.clairclient.module.modules;

import unknownuser2.clairclient.events.TickEvent;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.Vec3d;
import unknownuser2.clairclient.ClairClient;
import unknownuser2.clairclient.module.Module;

public class BoatFlight extends Module implements TickEvent {
    private int tickCount = 0;
    public BoatFlight() {
        super("Boat Flight", "Makes you fly in a boat.", "bfly");
        ClairClient.TICK_EVENTS.register(this);
    }

    @Override
    public void onTick() {
        tickCount++;
        if(ClairClient.MODULE_LIST.getModule(BoatFlight.class).isEnabled()) {
            if(ClairClient.mc.player != null && ClairClient.mc.player.hasVehicle()) {
                Entity vehicle = ClairClient.mc.player.getVehicle();
                Vec3d velocity = vehicle.getVelocity();
                if(tickCount == 70) {
                    vehicle.setVelocity(new Vec3d(velocity.x, 0, velocity.z));
                }else {
                    double yMotion = ClairClient.mc.options.jumpKey.isPressed() ? 0.5 : 0;
                    vehicle.setVelocity(new Vec3d(velocity.x, yMotion, velocity.z));
                }
            }
        }
        if(tickCount == 70)
            tickCount = 0;
    }
}
