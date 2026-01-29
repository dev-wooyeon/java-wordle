package domain.model;

import application.port.OutputPort;
import domain.port.WordRepository;

import static java.util.Objects.isNull;

import java.util.HashMap;
import java.util.Map;

public class Word {

    private Answer answer;
    private WordRepository wordRepository;

    public Word(Answer answer, WordRepository wordRepository) {
        this.answer = answer;
        this.wordRepository = wordRepository;
    }

    public ValidationStatus validate(Input input) {
        if (!isNotNull(input.getInputValue()))
            return ValidationStatus.NULL_INPUT;
        if (!hasValidLength(input.getInputValue()))
            return ValidationStatus.INVALID_LENGTH;
        if (!isAlphabetical(input.getInputValue()))
            return ValidationStatus.NOT_ALPHABET;
        if (!isWithinDictionary(input.getInputValue()))
            return ValidationStatus.NOT_IN_DICTIONARY;

        return ValidationStatus.VALID;
    }

    private boolean isWithinDictionary(String input) {
        return this.wordRepository.hasWord(input);
    }

    private boolean isNotNull(String input) {
        return !isNull(input);
    }

    private boolean hasValidLength(String input) {
        return input.length() == WordCondition.WORD_LENGTH.getValue();
    }

    private boolean isAlphabetical(String input) {
        return input.matches("(?i)[a-z]+");
    }

    // Input: APPLE
    // Answer: AIRPO
    public ResultValues[] compareAnswer(Input input) {
        String answerValue = this.answer.getAnswerValue();
        String inputValue = input.getInputValue();
        int length = answerValue.length();

        ResultValues[] resultArray = new ResultValues[length];

        // Count the number of each character in the answer and store it in a map.
        Map<Character, Integer> remainingCountMap = getAnswerRemainingCountMap(length, answerValue);

        // First pass: Identify GREEN tiles (correct character at the correct position).
        markGreenTiles(length, inputValue, answerValue, resultArray, remainingCountMap);

        // Second pass: Identify YELLOW (correct character, wrong position) and GRAY
        // tiles.
        markYellowAndGrayTiles(length, resultArray, inputValue, remainingCountMap);

        return resultArray;
    }

    private static void markYellowAndGrayTiles(int length, ResultValues[] resultArray, String input,
            Map<Character, Integer> remainingCountMap) {
        for (int i = 0; i < length; i++) {
            if (resultArray[i] != null) {
                continue;
            }

            char inputChar = Character.toLowerCase(input.charAt(i));
            int count = remainingCountMap.getOrDefault(inputChar, 0);

            if (count > 0) {
                resultArray[i] = ResultValues.YELLOW;
                remainingCountMap.put(inputChar, count - 1);
            }

            if (count == 0) {
                resultArray[i] = ResultValues.GRAY;
            }
        }
    }

    private static void markGreenTiles(int length, String input, String answer, ResultValues[] resultArray,
            Map<Character, Integer> remainingCountMap) {
        for (int i = 0; i < length; i++) {
            char inputChar = Character.toLowerCase(input.charAt(i));
            char answerChar = Character.toLowerCase(answer.charAt(i));

            if (inputChar == answerChar) {
                resultArray[i] = ResultValues.GREEN;
                remainingCountMap.put(inputChar, remainingCountMap.get(inputChar) - 1); // consume character count
            }
        }
    }

    public HashMap<Character, Integer> getAnswerRemainingCountMap(int length, String answer) {
        // Count the frequency of each character in the answer word.
        HashMap<Character, Integer> remainingCountMap = new HashMap<>();
        for (int i = 0; i < length; i++) {
            char c = Character.toLowerCase(answer.charAt(i));
            remainingCountMap.put(c, remainingCountMap.getOrDefault(c, 0) + 1);
        }

        return remainingCountMap;
    }
}
