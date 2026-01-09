import static java.util.Objects.isNull;

public class Word {

    private Answer answer;
    private Input input;

    public Word() {
        this.answer = new Answer();
    }

    public Word(Answer answer) {
        this.answer = answer;
    }

    public Word(Input input, Answer answer) {
        this.input = input;
        this.answer = answer;
    }

    public void valid(String input) {
        // TODO. 정책 논의 필요 (횟수 차감 여부)

        validNull(input);

        validLength(input);

        validAlphabet(input);

    }

    public void validNull(String input) {
        if (isNull(input)) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
    }

    public void validLength(String input) throws IllegalArgumentException {
        if (input.length() != WordCondition.입력_제한_길이.ordinal()) {
            throw new IllegalArgumentException("길이가 일치하지 않습니다.");
        }
    }

    public void validAlphabet(String input) {
        if (!input.toLowerCase().matches("[a-z]")) {
            throw new IllegalArgumentException("단어는 알파벳이어야 합니다.");
        }
    }

    // 입력 : APPLE
    // 답 : APPLE
    public void compareAnswer() {




    }
}
