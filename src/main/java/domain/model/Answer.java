package domain.model;

public class Answer {

    private String answerValue;

    // Default constructor creates "apple".
    public Answer() {
        this.answerValue = "apple";
    }

    public Answer(String answerValue) {
        this.answerValue = answerValue;
    }

    public String getAnswerValue() {
        return this.answerValue;
    }
}
