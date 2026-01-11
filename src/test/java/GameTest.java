import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class GameTest {

    @Test
    public void 종료_조건_테스트_6턴_이내() {
        // given
        Result result = new Result();
        result.setCurrentBoardsIndex(5);
        Game game = new Game(result);
        // when
        // then
        assertDoesNotThrow(game::checkedTryCount);
    }


    @Test
    public void 종료_조건_테스트_6턴_초과_불가() {
        // given
        Result result = new Result();
        result.setCurrentBoardsIndex(6);
        Game game = new Game(result);
        // when
        RuntimeException exception = assertThrows(RuntimeException.class,
            game::checkedTryCount);
        // then
        Assertions.assertEquals("입력 제한 횟수를 넘어 갑니다", exception.getMessage());
    }

    @Test
    public void 종료_조건_정답_성공_시_종료() {
        // given
        Result result = new Result();
        StringBuilder board = new StringBuilder(ResultValues.correct());
        result.setBoard(board);
        Game game = new Game(result);
        // when
        game.checkedFinished();
        // then
        Assertions.assertTrue(game.isFinished());
    }

    @Test
    public void 종료_조건_정답_실패_시_종료안됨() {
        // given
        Result result = new Result();
        StringBuilder board = new StringBuilder(ResultValues.inCorrect());
        result.setBoard(board);
        Game game = new Game(result);
        // when
        game.checkedFinished();
        // then
        Assertions.assertFalse(game.isFinished());
    }


}
