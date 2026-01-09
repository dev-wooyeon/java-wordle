
public enum WordCondition {
    입력_제한_길이(5),
    입력_제한_횟수(6),
    ;

    private final int value;

    public int getValue() {
        return value;
    }

    WordCondition(int length) {
        this.value = length;
    }
}
