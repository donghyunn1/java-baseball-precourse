package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RandomAnswerGenerator {

    private static final int MAX_LENGTH = 3;

    public List<Integer> generate() {
        List<Integer> answers = new ArrayList<>();
        while (answers.size() < MAX_LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(1,9);
            if(!answers.contains(randomNumber)) {
                answers.add(randomNumber);
            }
        }
        return answers;
    }
}
