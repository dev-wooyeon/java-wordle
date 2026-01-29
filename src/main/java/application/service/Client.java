package application.service;

import application.port.OutputPort;
import domain.model.Result;
import domain.model.ResultValues;
import domain.model.Input;
import domain.model.ValidationStatus;
import domain.model.Word;
import domain.service.Game;

public class Client {

    private final Word wordleWord;
    private final Game wordleGame;
    private final Result gameResult;
    private final OutputPort outputPort;

    public Client(Word wordleWord, Game wordleGame, Result gameResult, OutputPort outputPort) {
        this.wordleWord = wordleWord;
        this.wordleGame = wordleGame;
        this.gameResult = gameResult;
        this.outputPort = outputPort;
    }

    public String run(String userInput) {
        if (!wordleGame.canTry()) {
            return outputPort.getTryCountExceededMessage();
        }

        Input input = new Input(userInput);
        ValidationStatus validationStatus = wordleWord.validate(input);

        if (validationStatus != ValidationStatus.VALID) {
            return handleValidationError(validationStatus);
        }

        ResultValues[] resultArray = wordleWord.compareAnswer(input);
        gameResult.addRecord(resultArray);
        wordleGame.updateFinished();

        return outputPort.getBoardList(gameResult.getBoardList());
    }

    private String handleValidationError(ValidationStatus status) {
        return switch (status) {
            case INVALID_LENGTH -> outputPort.getLengthMismatchMessage();
            case NOT_ALPHABET -> outputPort.getNotAlphabetMessage();
            case NOT_IN_DICTIONARY -> outputPort.getHasNotWordRepository();
            case NULL_INPUT -> outputPort.getInvalidInputMessage();
            default -> "";
        };
    }
}
