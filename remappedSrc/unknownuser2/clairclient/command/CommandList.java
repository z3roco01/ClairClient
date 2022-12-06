package unknownuser2.clairclient.command;

import unknownuser2.clairclient.command.commands.Toggle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class CommandList {
    private final ArrayList<Command> commands = new ArrayList<Command>();

    public CommandList() {
        addCommand(new Toggle());
    }

    public void addCommand(Command command) {
        commands.add(command);
    }

    public Command getCommand(Class cmd) {
        return commands.stream().filter(command -> command.getClass().equals(cmd)).findAny().orElse(null);
    }

    public Command getCommand(String _name) {
        for (Command cmd : commands) {
            if (cmd.getCommands().stream().filter(name -> name.equals(_name)).findAny().orElse(null) != null) return cmd;
        }
        return null;
    }
}
