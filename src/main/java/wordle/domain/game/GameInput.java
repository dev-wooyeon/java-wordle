package wordle.domain.game;

import java.util.Objects;

public class GameInput {

    private final String value;

    public GameInput(String value) {
        this.value = value;
    }

    public String getInputValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        GameInput input = (GameInput) o;
        return Objects.equals(value, input.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
