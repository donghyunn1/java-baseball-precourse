package baseball.domain;

import java.util.Objects;

public enum GameCommand {

    RESTART("1"),
    EXIT("2"),
    ;

    private final String commandDigit;

    GameCommand(String commandDigit) {
        this.commandDigit = commandDigit;
    }

    public static boolean isRestarting(String waitingCommand) {
        if (isIncorrectCommand(waitingCommand)) {
            throw new IllegalArgumentException("1,2만 입력하시오.");
        }
        return RESTART.commandDigit.equals(waitingCommand);
    }

    private static boolean isIncorrectCommand(final String waitingCommand) {
        for (GameCommand command : values()) {
            if (command.commandDigit.equals(waitingCommand)) {
                return false;
            }
        }
        return true;
    }
}
