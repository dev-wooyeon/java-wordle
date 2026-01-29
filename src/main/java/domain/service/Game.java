package domain.service;

import application.port.OutputPort;
import domain.model.Result;
import domain.model.ResultValues;
import domain.model.WordCondition;

public class Game {

    private final Result gameResult;
    private boolean isFinished;

    public Game(Result gameResult) {
        this.gameResult = gameResult;
    }

    public void updateFinished() {
        if (ResultValues.getCorrectAnswerLine().equals(gameResult.getLastBoard())) {
            this.isFinished = true;
        }
        if (WordCondition.MAX_TRY_COUNT.getValue() < gameResult.getCurrentTryCount()) {
            this.isFinished = true;
        }
    }

    public boolean canTry() {
        return gameResult.getCurrentTryCount() <= WordCondition.MAX_TRY_COUNT.getValue();
    }

    public boolean isFinished() {
        return this.isFinished;
    }
}
