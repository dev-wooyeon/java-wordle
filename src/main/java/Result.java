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
        boards[currentBoardsIndex] = board;
        currentBoardsIndex++;
    }

    public String getBoard() {
        return board.toString();
    }

    public int getCurrentTryCount() {
        return currentBoardsIndex + 1;
    }

    public void setCurrentBoardsIndex(int currentBoardsIndex) {
        this.currentBoardsIndex = currentBoardsIndex;
    }

    public void setBoard(StringBuilder board) {
        this.board = board;
    }
}
