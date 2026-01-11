import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class WordTest {

    @Test
    void compareAnswer() {

        // given
        Result result = new Result();
        Answer answer = new Answer();
        Input input = new Input("AIRPO", result);
        Word word = new Word(input, answer);
        // when
        word.compareAnswer();
        // then
        Assertions.assertEquals("🟩⬜⬜🟨⬜", result.getBoard());
    }

    @Test
    void 기본_판정_로직_완전_일치() {
        // given
        Result result = new Result();
        Answer answer = new Answer();
        Input input = new Input(answer.getValue(), result);
        Word word = new Word(input, answer);
        // when
        word.compareAnswer();
        // then
        Assertions.assertEquals("🟩🟩🟩🟩🟩", result.getBoard());
    }

    @Test
    void 기본_판정_로직_완전_불일치() {
        // given
        Result result = new Result();
        Answer answer = new Answer();
        Input input = new Input("BVSKI", result);
        Word word = new Word(input, answer);
        // when
        word.compareAnswer();
        // then
        Assertions.assertEquals("⬜⬜⬜⬜⬜", result.getBoard());
    }

}
