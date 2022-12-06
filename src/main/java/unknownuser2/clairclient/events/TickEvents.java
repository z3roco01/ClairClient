package unknownuser2.clairclient.events;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.MinecraftClient;

import java.util.ArrayList;

public class TickEvents implements ClientTickEvents.StartTick {
    private ArrayList<TickEvent> events;

    public TickEvents() {
        this.events = new ArrayList<TickEvent>();
        ClientTickEvents.START_CLIENT_TICK.register(this);
    }

    public void register(TickEvent event) {
        events.add(event);
    }

    public ClientTickEvents.StartTick onTick() {
        return null;
    }

    @Override
    public void onStartTick(MinecraftClient client) {
        for(TickEvent event : this.events) {
            event.onTick();
        }
    }
}
