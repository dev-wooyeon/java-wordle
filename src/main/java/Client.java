public class Client {

    private final Word word;
    private final Game game;
    private final Result result;

    public Client(Word word, Game game, Result result) {
        this.word = word;
        this.game = game;
        this.result = result;
    }

    public String run() {
        game.checkedTryCount();

        word.valid();
        word.compareAnswer();

        game.updateFinished();

        result.addBoard();

        return new Output().getBoards(result.getBoards());
    }
}
