package command;

import middleware.controllers.ApiResponse;

public class Invoker {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public ApiResponse invoke(String requestBody) {
        return command.execute(requestBody);
    }
}


