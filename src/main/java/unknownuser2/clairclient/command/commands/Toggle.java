package unknownuser2.clairclient.command.commands;

import unknownuser2.clairclient.ClairClient;
import unknownuser2.clairclient.command.Command;
import unknownuser2.clairclient.module.Module;

import java.util.ArrayList;
import java.util.Arrays;

public class Toggle extends Command {
    public Toggle() {
        super(new ArrayList<String>(Arrays.asList("toggle", "t")));
    }

    @Override
    public void doCommand(String[] args) {
        Module mod;
        for (String arg : args) {
            mod = ClairClient.MODULE_LIST.getModuleShortName(arg);
            if (mod != null) mod.toggle();
        }
    }
}
