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
}
