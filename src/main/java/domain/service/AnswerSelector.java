package domain.service;

import domain.model.WordCondition;
import domain.port.WordRepository;
import java.time.LocalDate;

public class AnswerSelector {

    private final WordRepository wordRepository;

    public AnswerSelector(WordRepository wordRepository) {
        this.wordRepository = wordRepository;
    }

    public String selectAnswer() {
        int dayOfYear = LocalDate.now().getDayOfYear();
        int index = calculateIndex(dayOfYear);
        return wordRepository.getWordList().get(index);
    }

    private int calculateIndex(int dayOfYear) {
        int wordLength = WordCondition.WORD_LENGTH.getValue();
        int maxTryCount = WordCondition.MAX_TRY_COUNT.getValue();
        return (dayOfYear - 1) % (wordLength * maxTryCount);
    }
}
