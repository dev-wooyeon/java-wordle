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

    @Test
    void 중복판정_성공() {
        //given
        Result result = new Result();
        Answer answer = new Answer("APPLE");
        Input input = new Input("AAABB", result);
        Word word = new Word(input, answer);
        // when
        word.compareAnswer();
        // then
        Assertions.assertEquals("🟩⬜⬜⬜⬜", result.getBoard());

    }

    @Test
    void 중복판정_실패() {
        //given
        Result result = new Result();
        Answer answer = new Answer("APPLE");
        Input input = new Input("AAABB", result);
        Word word = new Word(input, answer);
        // when
        word.compareAnswer();
        // then
        Assertions.assertNotEquals("🟩🟨⬜⬜⬜", result.getBoard());

    }

    @Test
    void valid_정상_입력() {
        // given
        Result result = new Result();
        Answer answer = new Answer();
        Input input = new Input("apple", result);
        Word word = new Word(input, answer);
        // when & then
        Assertions.assertDoesNotThrow(() -> word.valid());
    }

    @Test
    void valid_null_입력() {
        // given
        Result result = new Result();
        Answer answer = new Answer();
        Input input = new Input(null, result);
        Word word = new Word(input, answer);
        // when & then
        Assertions.assertThrows(IllegalArgumentException.class, () -> word.valid());
    }

    @Test
    void valid_길이_불일치() {
        // given
        Result result = new Result();
        Answer answer = new Answer();
        Input input = new Input("a", result);
        Word word = new Word(input, answer);
        // when & then
        Assertions.assertThrows(IllegalArgumentException.class, () -> word.valid());
    }

    @Test
    void valid_알파벳_외_문자() {
        // given
        Result result = new Result();
        Answer answer = new Answer();
        Input input = new Input("appl1", result);
        Word word = new Word(input, answer);
        // when & then
        Assertions.assertThrows(IllegalArgumentException.class, () -> word.valid());
    }

    @Test
    void valid_사전_없음() {
        // given
        Result result = new Result();
        Answer answer = new Answer();
        Input input = new Input("zzzzz", result);
        Word word = new Word(input, answer);
        // when & then
        Assertions.assertDoesNotThrow(() -> word.valid());
    }


}
