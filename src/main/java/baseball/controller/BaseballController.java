package baseball.controller;

import baseball.domain.*;
import camp.nextstep.edu.missionutils.Console;

public class BaseballController {

    public void start() {
        do {
            Opponent opponent = Opponent.from(new RandomAnswerGenerator());
            startUserProcess(opponent);
        } while (isRestarting());
    }

    private void startUserProcess(Opponent opponent) {
        while (true) {
            User user = initilaizeUser();
            Hint hint = opponent.checkHint(user.getNumbers());
            printHint(hint);

            if (hint.isStrikeOut()) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            }
        }
    }

    private User initilaizeUser() {
        System.out.print("숫자를 입력해주세요 : ");
        String userInput = Console.readLine();
        return User.from(userInput);
    }

    private void printHint(Hint hint) {
        int strike = hint.getStrike();
        int ball = hint.getBall();
        StringBuilder hintMessage = new StringBuilder();

        if (hint.hasBall()) {
            hintMessage.append(ball).append("볼 ");
        }
        if (hint.hasStrike()) {
            hintMessage.append(strike).append("스트라이크");
        }
        if (hint.isNothing()) {
            hintMessage.append("낫싱");
        }
        System.out.println(hintMessage);
    }

    private boolean isRestarting() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String waitingCommand = Console.readLine();
        return GameCommand.isRestarting(waitingCommand);
    }
}
