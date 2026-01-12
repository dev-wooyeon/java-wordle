import java.time.LocalDate;

public class AnswerSelector {

    public static String selectAnswer() {
        int dayOfYear = LocalDate.now().getDayOfYear();
        int index = calculateIndex(dayOfYear);
        return WordRepository.getWordList().get(index);
    }

    private static int calculateIndex(int dayOfYear) {
        int length = WordCondition.입력_제한_길이.getValue();
        int count = WordCondition.입력_제한_횟수.getValue();
        return (dayOfYear - 1) % (length * count);
    }
}
