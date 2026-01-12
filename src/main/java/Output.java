import java.util.Objects;

public class Output {

    public String getWelcomeMessage() {
        int inputMaxCount = WordCondition.입력_제한_횟수.getValue();
        return String.format("WORDLE을 %d 번 만에 맞춰 보세요.\n"
            + "시도의 결과는 타일의 색 변화로 나타납니다. "
            , inputMaxCount);

    }

   public String getInputInfoMessage() {
       return "정답을 입력해 주세요.";
   }

   public String getBoards(StringBuilder[] boards) {
        StringBuilder result = new StringBuilder();
        for (StringBuilder board : boards) {
            if (Objects.nonNull(board)) {
                result.append(board).append("\n");
            }
        }
        return result.toString();
   }

   public static String getHasNotWordRepository(){
        return "답안은 `words.txt`에 존재하는 단어여야 합니다";
   }

}
