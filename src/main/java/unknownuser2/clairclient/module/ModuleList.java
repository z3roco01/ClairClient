package unknownuser2.clairclient.module;

import java.util.ArrayList;
import unknownuser2.clairclient.module.modules.*;

public class ModuleList {
    private final ArrayList<Module> modules = new ArrayList<Module>();

    public ModuleList() {
        addModule(new ImprovedTab());
        addModule(new FullBright());
        addModule(new NoWeather());
        addModule(new Flight());
        addModule(new Antikick());
        addModule(new BoatFlight());
        addModule(new NoFall());
        addModule(new Speed());
        addModule(new Xray());
        addModule(new RobotMovement());
        addModule(new NoFog());
    }

    public ArrayList<Module> getModules() {
        return modules;
    }

    public void addModule(Module module) {
        modules.add(module);
    }

    public Module getModule(Module mod) {
        return modules.stream().filter(module -> module.equals(mod)).findAny().orElse(null);
    }

    public Module getModule(String name) {
        return modules.stream().filter(module -> module.getName().equalsIgnoreCase(name)).findAny().orElse(null);
    }

    public Module getModule(Class mod) {
        return modules.stream().filter(module -> module.getClass().equals(mod)).findAny().orElse(null);
    }

    public Module getModuleShortName(String shortName) {
        return modules.stream().filter(module -> module.getShortName().equals(shortName)).findAny().orElse(null);
    }
}
