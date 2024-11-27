package baseball.domain;

import java.util.ArrayList;
import java.util.List;

public class User {

    private final List<Integer> numbers;

    private User(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public static User from(String userInput) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < userInput.length(); i++) {
            int userDigit = Character.getNumericValue(userInput.charAt(i));
            numbers.add(userDigit);
        }
        return new User(numbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
