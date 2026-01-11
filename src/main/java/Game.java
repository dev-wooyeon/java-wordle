public class Game {

    private final Result result;
    private boolean isFinished;

    public Game(Result result) {
        this.result = result;
    }

    public void updateFinished() {
        if (ResultValues.correct().equals(result.getBoard())) {
            this.isFinished = Boolean.TRUE;
        }
        if (WordCondition.입력_제한_횟수.getValue() == result.getCurrentTryCount()) {
            this.isFinished = Boolean.TRUE;
        }
    }

    public void checkedTryCount() {
        if (WordCondition.입력_제한_횟수.getValue() < result.getCurrentTryCount()) {
            throw new RuntimeException("입력 제한 횟수를 넘어 갑니다");
        }
    }

    public boolean isFinished() {
        return this.isFinished;
    }
}
