package fr.xephi.authme.output;

import fr.xephi.authme.util.StringUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Service class for the log filters.
 */
final class LogFilterHelper {

    static final List<String> COMMANDS_TO_SKIP = withAndWithoutAuthMePrefix(
        "/login ", "/register ", "/changepassword ", "/trocarsenha ");

    private static final String ISSUED_COMMAND_TEXT = "issued server command:";

    private LogFilterHelper() {
        // Util class
    }

    /**
     * Validate a message and return whether the message contains a sensitive AuthMe command.
     *
     * @param message The message to verify
     *
     * @return True if it is a sensitive AuthMe command, false otherwise
     */
    static boolean isSensitiveLoginCommand(String message) {
        if (message == null) {
            return false;
        }
        String lowerMessage = message.toLowerCase();
        return lowerMessage.contains(ISSUED_COMMAND_TEXT) && StringUtils.containsAny(lowerMessage, COMMANDS_TO_SKIP);
    }

    private static List<String> withAndWithoutAuthMePrefix(String... commands) {
        List<String> commandList = new ArrayList<>(commands.length * 2);
        for (String command : commands) {
            commandList.add(command);
            commandList.add(command.substring(0, 1) + "login:" + command.substring(1));
        }
        return Collections.unmodifiableList(commandList);
    }
    
}