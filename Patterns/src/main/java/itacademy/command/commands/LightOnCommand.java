package itacademy.command.commands;

import itacademy.command.Light;
import itacademy.command.api.Command;

public class LightOnCommand implements Command {
    private final Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOn();
    }
}
