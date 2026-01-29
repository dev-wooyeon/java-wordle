package domain.model;

import static org.junit.jupiter.api.Assertions.*;

import application.port.OutputPort;
import domain.port.WordRepository;
import infrastructure.adapter.in.ConsoleOutputAdapter;
import infrastructure.adapter.out.FileWordRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class WordTest {

    @Test
    void compareAnswer() {
        // given
        WordRepository wordRepository = new FileWordRepository();
        Result result = new Result();
        Answer answer = new Answer("AIRPO");
        Input input = new Input("AIRPO");
        Word word = new Word(answer, wordRepository);
        // when
        ResultValues[] results = word.compareAnswer(input);
        result.addRecord(results);
        // then
        Assertions.assertEquals("🟩🟩🟩🟩🟩", result.getLastBoard());
    }

    @Test
    void 기본_판정_로직_완전_일치() {
        // given
        WordRepository wordRepository = new FileWordRepository();
        Result result = new Result();
        Answer answer = new Answer();
        Input input = new Input(answer.getAnswerValue());
        Word word = new Word(answer, wordRepository);
        // when
        ResultValues[] results = word.compareAnswer(input);
        result.addRecord(results);
        // then
        Assertions.assertEquals("🟩🟩🟩🟩🟩", result.getLastBoard());
    }

    @Test
    void 기본_판정_로직_완전_불일치() {
        // given
        WordRepository wordRepository = new FileWordRepository();
        Result result = new Result();
        Answer answer = new Answer("APPLE");
        Input input = new Input("BVSKI");
        Word word = new Word(answer, wordRepository);
        // when
        ResultValues[] results = word.compareAnswer(input);
        result.addRecord(results);
        // then
        Assertions.assertEquals("⬜⬜⬜⬜⬜", result.getLastBoard());
    }

    @Test
    void 중복판정_성공() {
        // given
        WordRepository wordRepository = new FileWordRepository();
        Result result = new Result();
        Answer answer = new Answer("APPLE");
        Input input = new Input("AAABB");
        Word word = new Word(answer, wordRepository);
        // when
        ResultValues[] resultArray = word.compareAnswer(input);
        result.addRecord(resultArray);
        // then
        Assertions.assertEquals("🟩⬜⬜⬜⬜", result.getLastBoard());
    }

    @Test
    void valid_정상_입력() {
        // given
        WordRepository wordRepository = new FileWordRepository();
        Result result = new Result();
        Answer answer = new Answer();
        Input input = new Input("apple");
        Word word = new Word(answer, wordRepository);
        // when & then
        Assertions.assertEquals(ValidationStatus.VALID, word.validate(input));
    }

    @Test
    void valid_null_입력() {
        // given
        WordRepository wordRepository = new FileWordRepository();
        Result result = new Result();
        Answer answer = new Answer();
        Input input = new Input(null);
        Word word = new Word(answer, wordRepository);
        // when & then
        Assertions.assertEquals(ValidationStatus.NULL_INPUT, word.validate(input));
    }

    @Test
    void valid_길이_불일치() {
        // given
        WordRepository wordRepository = new FileWordRepository();
        Result result = new Result();
        Answer answer = new Answer();
        Input input = new Input("a");
        Word word = new Word(answer, wordRepository);
        // when & then
        Assertions.assertEquals(ValidationStatus.INVALID_LENGTH, word.validate(input));
    }

    @Test
    void valid_알파벳_외_문자() {
        // given
        WordRepository wordRepository = new FileWordRepository();
        Result result = new Result();
        Answer answer = new Answer();
        Input input = new Input("appl1");
        Word word = new Word(answer, wordRepository);
        // when & then
        Assertions.assertEquals(ValidationStatus.NOT_ALPHABET, word.validate(input));
    }

    @Test
    void valid_사전_없음() {
        // given
        WordRepository wordRepository = new FileWordRepository();
        Result result = new Result();
        Answer answer = new Answer();
        Input input = new Input("zzzzz");
        Word word = new Word(answer, wordRepository);
        // when & then
        Assertions.assertEquals(ValidationStatus.NOT_IN_DICTIONARY, word.validate(input));
    }

}
