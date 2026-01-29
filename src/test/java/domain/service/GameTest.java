package domain.service;

import domain.model.Result;
import domain.model.ResultValues;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class GameTest {

    @Test
    public void 종료_조건_테스트_6턴_이내() {
        // given
        Result result = new Result();
        ResultValues[] resultArray = new ResultValues[] {
                ResultValues.GRAY, ResultValues.GRAY, ResultValues.GRAY,
                ResultValues.GRAY, ResultValues.GRAY
        };
        for (int i = 0; i < 5; i++) {
            result.addRecord(resultArray);
        }
        Game game = new Game(result);
        // when & then
        Assertions.assertTrue(game.canTry());
    }

    @Test
    public void 종료_조건_테스트_6턴_초과_불가() {
        // given
        Result result = new Result();
        ResultValues[] resultArray = new ResultValues[] {
                ResultValues.GRAY, ResultValues.GRAY, ResultValues.GRAY,
                ResultValues.GRAY, ResultValues.GRAY
        };
        for (int i = 0; i < 6; i++) {
            result.addRecord(resultArray);
        }
        Game game = new Game(result);
        // when
        boolean canTry = game.canTry();
        // then (size is 6, so currentTryCount is 7, 7 > 6)
        Assertions.assertFalse(canTry);
    }

    @Test
    public void 종료_조건_정답_성공_시_종료() {
        // given
        Result result = new Result();
        ResultValues[] correctResultValueArray = new ResultValues[] {
                ResultValues.GREEN, ResultValues.GREEN, ResultValues.GREEN, ResultValues.GREEN, ResultValues.GREEN
        };
        result.addRecord(correctResultValueArray);

        Game game = new Game(result);
        // when
        game.updateFinished();
        // then
        Assertions.assertTrue(game.isFinished());
    }

    @Test
    public void 종료_조건_정답_실패_시_종료안됨() {
        // given
        Result result = new Result();
        ResultValues[] incorrectResultValueArray = new ResultValues[] {
                ResultValues.GRAY, ResultValues.GRAY, ResultValues.GRAY, ResultValues.GRAY, ResultValues.GRAY
        };
        result.addRecord(incorrectResultValueArray);

        Game game = new Game(result);
        // when
        game.updateFinished();
        // then
        Assertions.assertFalse(game.isFinished());
    }
}
