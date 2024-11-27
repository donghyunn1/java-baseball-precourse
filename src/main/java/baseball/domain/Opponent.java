package baseball.domain;

import java.util.List;

public class Opponent {

    private final List<Integer> answers;

    private Opponent(List<Integer> answers) {
        this.answers = answers;
    }

    public static Opponent from(RandomAnswerGenerator randomAnswerGenerator) {
        List<Integer> answers = randomAnswerGenerator.generate();
        return new Opponent(answers);
    }

    public Hint checkHint(List<Integer> userNumbers) {
        Hint hint = new Hint();
        for (int i = 0; i < userNumbers.size(); i++) {
            int userDigit = userNumbers.get(i);
            int opponentDigit = answers.get(i);

            if (userDigit == opponentDigit) {
                hint.increaseStrike();
                continue;
            }
            if (answers.contains(userDigit)) {
                hint.increaseBall();
            }
        }
        return hint;
    }
}
