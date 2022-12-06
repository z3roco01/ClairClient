package unknownuser2.clairclient.module.modules;

import unknownuser2.clairclient.events.TickEvent;
import net.minecraft.util.math.Vec3d;
import unknownuser2.clairclient.ClairClient;
import unknownuser2.clairclient.module.Module;

public class Flight extends Module implements TickEvent {
    private double yAccel = 0.5;
    private int tickCount = 0;
    private static final double FALL_SPEED = -0.04;
    private float airStrafeSpeed = 0.075F;
    private double sneakFallSpeed = -0.5;
    public Flight() {
        super("Flight", "Lets you fly.", "fly");
        ClairClient.TICK_EVENTS.register(this);
    }

    public void setyAccel(double yAccel) {
        this.yAccel = yAccel;
    }

    public double getyAccel() {
        return this.yAccel;
    }

    public void setSneakFallSpeed(double sneakFallSpeed) {
        this.sneakFallSpeed = sneakFallSpeed;
    }

    public double getSneakFallSpeed() {
        return this.sneakFallSpeed;
    }

    public void setAirStrafeSpeed(float airStrafeSpeed) {
        this.airStrafeSpeed = airStrafeSpeed;
    }

    public float getAirStrafeSpeed() {
        return this.airStrafeSpeed;
    }

    @Override
    public void onTick() {
        tickCount++;
        if(ClairClient.mc.player != null && ClairClient.MODULE_LIST.getModule(Flight.class).isEnabled()) {
            Vec3d velocity = ClairClient.mc.player.getVelocity();
            ClairClient.mc.player.airStrafingSpeed = airStrafeSpeed;

            if(tickCount == 40)
                ClairClient.mc.player.setVelocity(velocity.x, FALL_SPEED, velocity.z);
            else if(ClairClient.mc.options.sneakKey.isPressed())
                ClairClient.mc.player.setVelocity(velocity.x, sneakFallSpeed, velocity.z);
            else if(ClairClient.mc.options.jumpKey.isPressed())
                ClairClient.mc.player.setVelocity(velocity.x, yAccel, velocity.z);
            else
                ClairClient.mc.player.setVelocity(velocity.x, 0, velocity.z);
        }
        if(tickCount == 40)
            tickCount = 0;
    }
}
