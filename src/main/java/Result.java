public class Result {

    private StringBuilder board;
    private StringBuilder[] boards = new StringBuilder[WordCondition.입력_제한_횟수.getValue()];
    private int currentBoardsIndex = 0;

    public Result() {
        this.board = new StringBuilder();
    }

    public void addTile(String tile) {
        this.board.append(tile);
    }

    public void addBoard() {
        this.boards[currentBoardsIndex] = this.board;
        currentBoardsIndex++;
        this.board = new StringBuilder();
    }

    public String getBoard() {
        return this.board.toString();
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

    public StringBuilder[] getBoards() {
        return boards;
    }
}
