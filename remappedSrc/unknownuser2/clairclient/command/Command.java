package unknownuser2.clairclient.command;

import java.util.ArrayList;

public class Command {
    private ArrayList<String> commands;

    public Command(ArrayList<String> commands) {
        this.commands = commands;
    }

    public void doCommand(String[] args) {

    }

    public ArrayList<String> getCommands() {
        return commands;
    }
}
