import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        WordRepository wordRepository = new WordRepository();
        Output output = new Output();

        System.out.println(output.getWelcomeMessage());

        Result result = new Result();
        Game game = new Game(result);
        Answer answer = new Answer();

        try (Scanner scanner = new Scanner(System.in)) {
            while (!game.isFinished()) {
                System.out.println(output.getInputInfoMessage());
                String userInput = scanner.next();
                Word word = new Word(new Input(userInput, result), answer);

                Client client = new Client(word, game, result);
                String gameResult = client.run();

                System.out.println(gameResult);
            }
        }

    }

}
