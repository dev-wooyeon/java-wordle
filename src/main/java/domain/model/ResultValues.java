package domain.model;

public enum ResultValues {

    GREEN("🟩"),
    YELLOW("🟨"),
    GRAY("⬜"),
    ;

    private final String value;

    ResultValues(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static String getCorrectAnswerLine() {
        return String.valueOf(ResultValues.GREEN.getValue())
                .repeat(Math.max(0, WordCondition.WORD_LENGTH.getValue()));
    }
}
