package domain.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Result {

    private final List<String> boardList = new ArrayList<>();

    public void addRecord(ResultValues[] resultArray) {
        StringBuilder rowStringBuilder = new StringBuilder();
        for (ResultValues resultValue : resultArray) {
            rowStringBuilder.append(resultValue.getValue());
        }
        this.boardList.add(rowStringBuilder.toString());
    }

    public String getLastBoard() {
        if (boardList.isEmpty()) {
            return "";
        }
        return boardList.get(boardList.size() - 1);
    }

    public int getCurrentTryCount() {
        return boardList.size() + 1;
    }

    public List<String> getBoardList() {
        return Collections.unmodifiableList(boardList);
    }
}
