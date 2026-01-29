package infrastructure;

import application.port.OutputPort;
import application.service.Client;
import domain.model.Answer;
import domain.model.Result;
import domain.model.Word;
import domain.port.WordRepository;
import domain.service.AnswerSelector;
import domain.service.Game;
import infrastructure.adapter.in.ConsoleOutputAdapter;
import infrastructure.adapter.out.FileWordRepository;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        WordRepository wordRepository = new FileWordRepository();
        OutputPort outputPort = new ConsoleOutputAdapter();

        System.out.println(outputPort.getWelcomeMessage());

        Result gameResult = new Result();
        Game wordleGame = new Game(gameResult);
        AnswerSelector answerSelector = new AnswerSelector(wordRepository);
        String selectedAnswer = answerSelector.selectAnswer();
        Answer answer = new Answer(selectedAnswer);

        Word word = new Word(answer, wordRepository);
        Client gameClient = new Client(word, wordleGame, gameResult, outputPort);

        try (Scanner scanner = new Scanner(System.in)) {
            while (!wordleGame.isFinished()) {
                System.out.println(outputPort.getInputInfoMessage());
                String userInput = scanner.next();

                String statusMessage = gameClient.run(userInput);
                if (!statusMessage.isEmpty()) {
                    System.out.println(statusMessage);
                }
            }
        }

    }

}
