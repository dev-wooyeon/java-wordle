public class Result {

    private StringBuilder board;
    private StringBuilder[] boards = new StringBuilder[WordCondition.입력_제한_횟수.getValue()];
    private int currentBoardsIndex = 0;

    public Result() {
        board = new StringBuilder();
    }

    public void addTile(String tile) {
        board.append(tile);
    }

    public void addBoard() {
        if (WordCondition.입력_제한_횟수.getValue() <= currentBoardsIndex) {
            throw new RuntimeException("입력 제한 횟수를 넘어 갑니다");
        }
        boards[currentBoardsIndex] = board;
        currentBoardsIndex++;
    }
}
