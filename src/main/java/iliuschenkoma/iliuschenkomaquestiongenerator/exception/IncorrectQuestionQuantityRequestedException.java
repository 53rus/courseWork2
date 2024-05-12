package iliuschenkoma.iliuschenkomaquestiongenerator.exception;

public class IncorrectQuestionQuantityRequestedException extends RuntimeException{
    public IncorrectQuestionQuantityRequestedException() {
    }

    public IncorrectQuestionQuantityRequestedException(String message) {
        super(message);
    }

    public IncorrectQuestionQuantityRequestedException(String message, Throwable cause) {
        super(message, cause);
    }

    public IncorrectQuestionQuantityRequestedException(Throwable cause) {
        super(cause);
    }

    public IncorrectQuestionQuantityRequestedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
