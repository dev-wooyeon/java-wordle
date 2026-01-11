public enum ResultValues {

    그린("🟩"),
    옐로우("🟨"),
    그레이("⬜"),
    ;

    private final String value;

    ResultValues(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static String correct() {
        return String.valueOf(ResultValues.그린.getValue())
            .repeat(Math.max(0, WordCondition.입력_제한_길이.getValue()));
    }

    public static String inCorrect() {
        return String.valueOf(ResultValues.그레이.getValue())
            .repeat(Math.max(0, WordCondition.입력_제한_길이.getValue()));
    }
}
