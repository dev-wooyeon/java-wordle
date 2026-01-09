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
}
