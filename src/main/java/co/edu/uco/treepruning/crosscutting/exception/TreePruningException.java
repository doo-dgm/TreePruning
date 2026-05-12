package co.edu.uco.treepruning.crosscutting.exception;

public final class TreePruningException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private final String userMessage;

    private TreePruningException(String userMessage, 
            String technicalMessage) {
        super(technicalMessage);
        this.userMessage = userMessage;
    }

    public static TreePruningException create(String userMessage, 
            String technicalMessage) {
        return new TreePruningException(userMessage, technicalMessage);
    }

    public String getUserMessage() {
        return userMessage;
    }
}
