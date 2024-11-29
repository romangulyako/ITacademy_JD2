package itacademy.command;

import itacademy.command.api.Command;
import itacademy.command.commands.LightOffCommand;
import itacademy.command.commands.LightOnCommand;

public class App {
    public static void main(String[] args) {
        Light light = new Light();

        Command commandOn = new LightOnCommand(light);
        Command commandOff = new LightOffCommand(light);

        commandOn.execute();
        commandOff.execute();
    }
}
