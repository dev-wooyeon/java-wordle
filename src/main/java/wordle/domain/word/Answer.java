package wordle.domain.word;

import java.util.Objects;

public class Answer {

    private final String value;

    public Answer(String value) {
        this.value = Objects.requireNonNull(value, "Answer value cannot be null");
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Answer answer = (Answer) o;
        return Objects.equals(value, answer.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
