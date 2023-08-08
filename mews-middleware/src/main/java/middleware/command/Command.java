package middleware.command;

import middleware.controllers.ApiResponse;
import middleware.models.SalesforceRestControllerResponse;

public interface Command {
    ApiResponse execute(String arg);

    String BookingId = null;
    SalesforceRestControllerResponse restController = null;
}

