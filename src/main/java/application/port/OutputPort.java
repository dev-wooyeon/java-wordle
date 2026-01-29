package application.port;

import java.util.List;

public interface OutputPort {

    String getWelcomeMessage();

    String getInputInfoMessage();

    String getBoardList(List<String> boardList);

    String getHasNotWordRepository();

    String getInvalidInputMessage();

    String getLengthMismatchMessage();

    String getNotAlphabetMessage();

    String getTryCountExceededMessage();
}
