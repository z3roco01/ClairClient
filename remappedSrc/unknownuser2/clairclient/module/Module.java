package unknownuser2.clairclient.module;

import java.util.Objects;

public class Module {
    private final String name;
    private final String desc;
    private final String shortName;

    private boolean enabled;

    public Module(String name, String desc, String shortName) {
        this.name       = Objects.requireNonNull(name);
        this.desc       = Objects.requireNonNull(desc);
        this.shortName  = Objects.requireNonNull(shortName);
    }

    public boolean isEnabled() {
        return enabled;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    public String getShortName() {
        return shortName;
    }

    public void onEnable() {

    }

    public void onDisable() {

    }

    public void onCmd(String[] args) {
        this.toggle();
    }

    public void enable() {
        onEnable();
        enabled = true;
    }

    public void disable() {
        onDisable();
        enabled = false;
    }

    public void toggle() {
        if(enabled) onDisable();
        else onEnable();

        enabled = !enabled;
    }
}
