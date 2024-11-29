package itacademy.command.commands;

import itacademy.command.Light;
import itacademy.command.api.Command;

public class LightOffCommand  implements Command {
    private final Light light;

    public LightOffCommand(final Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOff();
    }
}
