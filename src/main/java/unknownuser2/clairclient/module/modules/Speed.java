package unknownuser2.clairclient.module.modules;

import unknownuser2.clairclient.events.TickEvent;
import net.minecraft.util.math.Vec3d;
import unknownuser2.clairclient.ClairClient;
import unknownuser2.clairclient.module.Module;

public class Speed extends Module implements TickEvent {
    private double speedMul = 2;
    private double maxSpeed = 0.66;
    public Speed() {
        super("Speed", "Makes you go faster.", "speed");
        ClairClient.TICK_EVENTS.register(this);
    }

    public void setSpeedMul(double speedMul) {
        this.speedMul = speedMul;
    }

    public double getSpeedMul() {
        return this.speedMul;
    }

    @Override
    public void onTick() {
        if(ClairClient.mc.player != null && ClairClient.MODULE_LIST.getModule(Speed.class).isEnabled()) {
            if(ClairClient.mc.player.isSneaking() || ClairClient.mc.player.forwardSpeed == 0 && ClairClient.mc.player.sidewaysSpeed == 0)
                return;

            if(!ClairClient.mc.player.isOnGround())
                return;

            Vec3d velocity = ClairClient.mc.player.getVelocity();
            ClairClient.mc.player.setVelocity(velocity.x * speedMul, velocity.y, velocity.z * speedMul);

            velocity = ClairClient.mc.player.getVelocity();

            velocity = ClairClient.mc.player.getVelocity();
            double currentSpeed = Math.sqrt(Math.pow(velocity.x, 2) + Math.pow(velocity.z, 2));
            if(currentSpeed > maxSpeed)
                ClairClient.mc.player.setVelocity(velocity.x / currentSpeed * maxSpeed, velocity.y, velocity.z / currentSpeed * maxSpeed);
        }
    }
}
