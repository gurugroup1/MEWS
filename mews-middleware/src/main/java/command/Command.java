package command;

import middleware.controllers.ApiResponse;

public interface Command {
    ApiResponse execute(String arg);
}

