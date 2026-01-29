package infrastructure.adapter.in;

import application.port.OutputPort;

import domain.model.WordCondition;
import java.util.List;
import java.util.Objects;

public class ConsoleOutputAdapter implements OutputPort {

    @Override
    public String getWelcomeMessage() {
        int inputMaxTryCount = WordCondition.MAX_TRY_COUNT.getValue();
        return String.format("WORDLE을 %d 번 만에 맞춰 보세요.\n"
                + "시도의 결과는 타일의 색 변화로 나타납니다. ", inputMaxTryCount);

    }

    @Override
    public String getInputInfoMessage() {
        return "정답을 입력해 주세요.";
    }

    @Override
    public String getBoardList(List<String> boardList) {
        StringBuilder boardStringBuilder = new StringBuilder();
        for (String board : boardList) {
            if (Objects.nonNull(board)) {
                boardStringBuilder.append(board).append("\n");
            }
        }
        return boardStringBuilder.toString();
    }

    @Override
    public String getHasNotWordRepository() {
        return "답안은 `words.txt`에 존재하는 단어여야 합니다";
    }

    @Override
    public String getInvalidInputMessage() {
        return "잘못된 입력입니다.";
    }

    @Override
    public String getLengthMismatchMessage() {
        return "길이가 일치하지 않습니다.";
    }

    @Override
    public String getNotAlphabetMessage() {
        return "단어는 알파벳이어야 합니다.";
    }

    @Override
    public String getTryCountExceededMessage() {
        return "입력 제한 횟수를 넘어 갑니다";
    }
}
